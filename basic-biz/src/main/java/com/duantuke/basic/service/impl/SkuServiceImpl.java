package com.duantuke.basic.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.duantuke.basic.enums.SkuTypeEnum;
import com.duantuke.basic.exception.OpenException;
import com.duantuke.basic.face.bean.MealInfo;
import com.duantuke.basic.face.bean.PriceInfo;
import com.duantuke.basic.face.bean.RoomTypeInfo;
import com.duantuke.basic.face.bean.SkuInfo;
import com.duantuke.basic.face.bean.SkuRequest;
import com.duantuke.basic.face.bean.SkuResponse;
import com.duantuke.basic.face.bean.SkuResultInfo;
import com.duantuke.basic.face.bean.SkuSubRequest;
import com.duantuke.basic.face.bean.TeamSkuInfo;
import com.duantuke.basic.face.service.MealService;
import com.duantuke.basic.face.service.PriceService;
import com.duantuke.basic.face.service.RoomTypeService;
import com.duantuke.basic.face.service.SkuService;
import com.duantuke.basic.face.service.TeamSkuService;
import com.duantuke.basic.po.Meal;
import com.duantuke.basic.po.RoomType;
import com.duantuke.basic.po.TeamSku;
import com.duantuke.basic.util.DateUtil;
import com.duantuke.promotion.domain.PromotionQueryIn;
import com.duantuke.promotion.domain.PromotionResult;
import com.duantuke.promotion.face.base.RetInfo;
import com.duantuke.promotion.face.service.PromotionService;
import com.google.gson.Gson;

@Service
public class SkuServiceImpl implements SkuService {
	private static Logger logger = LoggerFactory.getLogger(SkuServiceImpl.class);
	@Autowired
	private RoomTypeService roomTypeService;
	@Autowired
	private TeamSkuService teamSkuService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private MealService mealService;
	@Autowired
	private PromotionService promotionService;

    @Autowired
    private Mapper dozerMapper;
    
    
    /**
     * 查询sku列表
     */
	@Override
	public SkuResponse querySku(SkuRequest skuQueryIn) {
		logger.info("查询sku开始，{}",new Gson().toJson(skuQueryIn));
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		SkuResponse skuResponse = new SkuResponse();
		try {
			skuResponse.setTotalPrice(totalPrice);
			
//			skuResponse.setSupplierId(skuQueryIn.getHotelId());
			
			

			List<SkuInfo> listAll = new ArrayList<SkuInfo>();
			if(skuQueryIn!=null){
				if(MapUtils.isNotEmpty(skuQueryIn.getSkuMap())){
					for (Entry<Integer, List<SkuSubRequest>> entry : skuQueryIn.getSkuMap().entrySet()) {
						SkuTypeEnum skuTypeEnum = SkuTypeEnum.getSkuTypeEnumByCode(entry.getKey());
						
						switch (skuTypeEnum) {
						case roomtype:
							BigDecimal roomPrice  = doQueryRoomtype(skuQueryIn, listAll, entry.getValue());
							
							totalPrice = totalPrice.add(roomPrice);
//						skuInfo.setRoomTypeInfos(roomTypeInfos);
							break;
						case teamsku:
							BigDecimal teamPrice  = doQueryTeamSku(skuQueryIn, listAll, entry.getValue());
							
							totalPrice = totalPrice.add(teamPrice);
//						skuInfo.setRoomTypeInfos(roomTypeInfos);
							break;
						case meal:
							BigDecimal mealPrice  = doQueryMeal(skuQueryIn, listAll, entry.getValue());
							totalPrice = totalPrice.add(mealPrice);
//						skuInfo.setMealInfos(mealInfos);
							break;
							
						default:
							break;
						}
						
						skuResponse.setOriginalPrice(totalPrice);
						if(skuQueryIn.getCustomerId()!=null){
							PromotionQueryIn promotionQueryIn = new PromotionQueryIn();
							promotionQueryIn.setCustomerId(skuQueryIn.getCustomerId());
							promotionQueryIn.setHotelId(skuQueryIn.getHotelId());
							promotionQueryIn.setOrderPrice(totalPrice);
							promotionQueryIn.setPromotionIds(skuQueryIn.getPromotionIds());
							promotionQueryIn.setSkuType(entry.getKey());
							
							RetInfo<PromotionResult> retInfo = promotionService.queryPromotionPrice(promotionQueryIn);
							if(retInfo.isResult()){
								PromotionResult promotionResult = 	retInfo.getObj();
								if(promotionResult!=null){
									totalPrice  = promotionResult.getPrice();
									logger.info("促销后价格：{}", new JSONObject().toJSON(promotionResult));
								}
							}
						}
					}
				}else{
					throw new OpenException("sku列表为空");
				}
			}else{
				throw new OpenException("sku列表为空");
			}
			
			if(CollectionUtils.isEmpty(listAll)){
				throw new OpenException("没有查询到sku信息");
			}else{
				logger.info("sku返回集合大小：{}",listAll.size());
			}
			skuResponse.setTotalPrice(totalPrice);
			skuResponse.setList(listAll);
		} catch (Exception e) {
			logger.error("查询sku异常",e);
			throw new OpenException(e);
		}finally{
			try {
				logger.info("查询sku结束，{}",JSON.json(skuResponse));
			} catch (IOException e) {
				
			}
		}
		if(skuResponse.getTotalPrice()!=null&&skuResponse.getOriginalPrice()!=null){
			skuResponse.setPromotionPrice(skuResponse.getOriginalPrice().subtract(skuResponse.getTotalPrice()));
		}else{
			skuResponse.setPromotionPrice(BigDecimal.ZERO);
		}
		return skuResponse;
	}
	

	/**
	 * 执行查询餐饮信息，包括价格
	 * @param skuQueryIn
	 * @param totalPrice
	 * @param listAll
	 * @param roomtypeIds
	 * @throws IOException 
	 */
	public BigDecimal  doQueryMeal(SkuRequest skuQueryIn,List<SkuInfo> listAll,List<SkuSubRequest> mealIds) throws IOException{
		BigDecimal mealPrice = BigDecimal.ZERO;

		List<Meal> meals = new ArrayList<Meal>();
		for (SkuSubRequest skuId : mealIds) {
			//根据房型id查询酒店id
			Meal meal = mealService.queryMealById(skuId.getSkuId());
			if(meal!=null){
				meal.setOrderNum(skuId.getNum());
				meals.add(meal);
			}
		}
		
		if(CollectionUtils.isEmpty(meals)){
			logger.info("餐饮id没有对应酒店，{}",new Gson().toJson(mealIds));
			return mealPrice;
		}
		
		Map<Long, List<SkuSubRequest>> mealMap = new HashMap<Long, List<SkuSubRequest>>();
		for (Meal meal : meals) {
			if(mealMap.containsKey(meal.getSupplierId())){

				SkuSubRequest request = new SkuSubRequest();
				request.setSkuId(meal.getSkuId());
				request.setNum(meal.getOrderNum());
				mealMap.get(meal.getSupplierId()).add(request);
			}else{
				List<SkuSubRequest> skuIds = new ArrayList<SkuSubRequest>();
				SkuSubRequest request = new SkuSubRequest();
				request.setSkuId(meal.getSkuId());
				request.setNum(meal.getOrderNum());
				skuIds.add(request);
				mealMap.put(meal.getSupplierId(),skuIds);
			}
		}
		
		
		for (Entry<Long, List<SkuSubRequest>> mealEntry : mealMap.entrySet()) {
			skuQueryIn.setHotelId(mealEntry.getKey());
			
			SkuResultInfo<List<MealInfo>> info = queryMeal(skuQueryIn, mealEntry.getValue());
			List<MealInfo> mealInfos = info.getInfo();
			mealPrice = mealPrice.add(info.getTotalPrice());
			
			List<SkuInfo<MealInfo>> list2 = new ArrayList<SkuInfo<MealInfo>>();
			if(CollectionUtils.isNotEmpty(mealInfos)){
				for (MealInfo mealInfo : mealInfos) {
					SkuInfo<MealInfo> skuInfo = dozerMapper.map(mealInfo, SkuInfo.class);
					
//					SkuInfo<MealInfo> skuInfo = new SkuInfo<MealInfo>();
					skuInfo.setInfo(mealInfo);
					skuInfo.setType(SkuTypeEnum.meal.getCode());
					skuInfo.setSkuName(mealInfo.getName());
					skuInfo.setSkuId(mealInfo.getSkuId());
					list2.add(skuInfo);
				}
				listAll.addAll(list2);
			}
		}
		return mealPrice;
		
	}
	
	/**
	 * 执行查询房型信息，包括价格
	 * @param skuQueryIn
	 * @param totalPrice
	 * @param listAll
	 * @param roomtypeIds
	 * @throws IOException 
	 */
	public BigDecimal  doQueryRoomtype(SkuRequest skuQueryIn,List<SkuInfo> listAll,List<SkuSubRequest> roomtypeIds) throws IOException{
		if(skuQueryIn.getBeginDate()!=null){
			skuQueryIn.setBeginTime(DateUtil.strToDate(skuQueryIn.getBeginDate(), "yyyy-MM-dd"));
		}
		if(skuQueryIn.getEndDate()!=null){
			skuQueryIn.setEndTime(DateUtil.strToDate(skuQueryIn.getEndDate(), "yyyy-MM-dd"));
		}
		
//		List<Long> roomtypeIds = entry.getValue();
		
		BigDecimal totalPrice = BigDecimal.ZERO;
		List<RoomType> roomTypes = new ArrayList<RoomType>();
		for (SkuSubRequest skuId : roomtypeIds) {
			//根据房型id查询酒店id
			RoomType roomType = roomTypeService.queryRoomtypeByRoomtypeId(skuId.getSkuId());
			if(roomType!=null){
				roomType.setOrderNum(skuId.getNum());
				roomTypes.add(roomType);
			}
		}
		if(CollectionUtils.isEmpty(roomTypes)){
			logger.info("房型id没有对应酒店，{}",new Gson().toJson(roomtypeIds));
			return totalPrice;
		}
		Map<Long, List<SkuSubRequest>> roomMap = new HashMap<Long, List<SkuSubRequest>>();
		for (RoomType roomType : roomTypes) {
			if(roomMap.containsKey(roomType.getSupplierId())){

				SkuSubRequest request = new SkuSubRequest();
				request.setSkuId(roomType.getSkuId());
				request.setNum(roomType.getOrderNum());
				roomMap.get(roomType.getSupplierId()).add(request);
			}else{
				List<SkuSubRequest> skuIds = new ArrayList<SkuSubRequest>();
				SkuSubRequest request = new SkuSubRequest();
				request.setSkuId(roomType.getSkuId());
				request.setNum(roomType.getOrderNum());
				skuIds.add(request);
				roomMap.put(roomType.getSupplierId(),skuIds);
			}
		}
		logger.info("存在的房型，{}",JSON.json(roomMap));
		
		for (Entry<Long, List<SkuSubRequest>> roomEntry : roomMap.entrySet()) {
			skuQueryIn.setHotelId(roomEntry.getKey());
			SkuResultInfo<List<RoomTypeInfo>>  info   = queryRoomtype(skuQueryIn, roomEntry.getValue());
			List<RoomTypeInfo> roomTypeInfos = info.getInfo();
			totalPrice = totalPrice.add(info.getTotalPrice());
			
			List<SkuInfo<RoomTypeInfo>> list = new ArrayList<SkuInfo<RoomTypeInfo>>();
			if(CollectionUtils.isNotEmpty(roomTypeInfos)){
				for (RoomTypeInfo roomTypeInfo : roomTypeInfos) {
//					SkuInfo<RoomTypeInfo> skuInfo = new SkuInfo<RoomTypeInfo>();
					SkuInfo<RoomTypeInfo> skuInfo = dozerMapper.map(roomTypeInfo, SkuInfo.class);
					skuInfo.setInfo(roomTypeInfo);
					skuInfo.setType(SkuTypeEnum.roomtype.getCode());
					skuInfo.setSkuName(roomTypeInfo.getName());
					skuInfo.setSkuId(roomTypeInfo.getSkuId());
					list.add(skuInfo);
				}
				listAll.addAll(list);
			}
		}
		return totalPrice;
	}
	/**
	 * 执行查询房型信息，包括价格
	 * @param skuQueryIn
	 * @param totalPrice
	 * @param listAll
	 * @param roomtypeIds
	 * @throws IOException 
	 */
	public BigDecimal  doQueryTeamSku(SkuRequest skuQueryIn,List<SkuInfo> listAll,List<SkuSubRequest> skuSubRequests) throws IOException{
		if(skuQueryIn.getBeginDate()!=null){
			skuQueryIn.setBeginTime(DateUtil.strToDate(skuQueryIn.getBeginDate(), "yyyy-MM-dd"));
		}
		if(skuQueryIn.getEndDate()!=null){
			skuQueryIn.setEndTime(DateUtil.strToDate(skuQueryIn.getEndDate(), "yyyy-MM-dd"));
		}
		
		List<Long> skuIds = new ArrayList<Long>();
		
		BigDecimal totalPrice = BigDecimal.ZERO;
		List<TeamSku> roomTypes = new ArrayList<TeamSku>();
		

		Map<Long, Integer> skuNumMap = new HashMap<Long, Integer>();
		//如果sku集合为空，则查询所有房型
		if(CollectionUtils.isEmpty(skuSubRequests)){
			for (SkuSubRequest skuSubRequest : skuSubRequests) {
				skuIds.add(skuSubRequest.getSkuId());
				skuNumMap.put(skuSubRequest.getSkuId(), skuSubRequest.getNum());
			}
		}
		roomTypes = teamSkuService.queryTeamSkuBySkuIds(skuIds);
		
		
		if(CollectionUtils.isEmpty(roomTypes)){
			logger.info("房型id没有对应酒店，{}",new Gson().toJson(skuSubRequests));
			return totalPrice;
		}
		Map<Long, List<SkuSubRequest>> roomMap = new HashMap<Long, List<SkuSubRequest>>();
		for (TeamSku roomType : roomTypes) {
			if(roomMap.containsKey(roomType.getSupplierId())){

				SkuSubRequest request = new SkuSubRequest();
				request.setSkuId(roomType.getSkuId());
				request.setNum(roomType.getOrderNum());
				roomMap.get(roomType.getSupplierId()).add(request);
			}else{
				List<SkuSubRequest> skuSubRequestList = new ArrayList<SkuSubRequest>();
				SkuSubRequest request = new SkuSubRequest();
				request.setSkuId(roomType.getSkuId());
				request.setNum(roomType.getOrderNum());
				skuSubRequestList.add(request);
				roomMap.put(roomType.getSupplierId(),skuSubRequestList);
			}
		}
		logger.info("存在的房型，{}",JSON.json(roomMap));
		
		for (Entry<Long, List<SkuSubRequest>> roomEntry : roomMap.entrySet()) {
			skuQueryIn.setHotelId(roomEntry.getKey());
			SkuResultInfo<List<TeamSkuInfo>>  info   = queryTeamSku(skuQueryIn, roomEntry.getValue());
			List<TeamSkuInfo> roomTypeInfos = info.getInfo();
			totalPrice = totalPrice.add(info.getTotalPrice());
			
			List<SkuInfo<TeamSkuInfo>> list = new ArrayList<SkuInfo<TeamSkuInfo>>();
			if(CollectionUtils.isNotEmpty(roomTypeInfos)){
				for (TeamSkuInfo roomTypeInfo : roomTypeInfos) {
//					SkuInfo<RoomTypeInfo> skuInfo = new SkuInfo<RoomTypeInfo>();
					SkuInfo<TeamSkuInfo> skuInfo = dozerMapper.map(roomTypeInfo, SkuInfo.class);
					skuInfo.setInfo(roomTypeInfo);
					skuInfo.setType(SkuTypeEnum.teamsku.getCode());
					skuInfo.setSkuName(roomTypeInfo.getName());
					skuInfo.setSkuId(roomTypeInfo.getSkuId());
					list.add(skuInfo);
				}
				listAll.addAll(list);
			}
		}
		return totalPrice;
	}
	
	/**
	 * 查询房型信息
	 * @param skuQueryIn
	 * @param roomtypeIds
	 * @return
	 */
	public SkuResultInfo<List<RoomTypeInfo>> queryRoomtype(SkuRequest skuQueryIn,List<SkuSubRequest> skuSubRequests){
		

		BigDecimal totalPrice = BigDecimal.ZERO;
		SkuResultInfo<List<RoomTypeInfo>> info  =new SkuResultInfo<List<RoomTypeInfo>>();
		
		List<RoomType> roomtypes =  null;
		List<RoomTypeInfo> roomTypeInfos =  new ArrayList<RoomTypeInfo>();
		
		List<Long> skuIds  =new ArrayList<Long>();
		
		Map<Long, Integer> skuNumMap = new HashMap<Long, Integer>();
		//如果sku集合为空，则查询所有房型
		if(CollectionUtils.isNotEmpty(skuSubRequests)){
			for (SkuSubRequest skuSubRequest : skuSubRequests) {
				skuIds.add(skuSubRequest.getSkuId());
				skuNumMap.put(skuSubRequest.getSkuId(), skuSubRequest.getNum());
			}
		}
		roomtypes = roomTypeService.queryRoomtypeByRoomtypeIds(skuIds);
		
		
		
		//query price
		Map<Long,Map<String,BigDecimal>> priceMap = priceService.queryHotelPrices(skuQueryIn.getHotelId(), skuQueryIn.getBeginTime(), skuQueryIn.getEndTime(), skuIds);
		
		if(CollectionUtils.isNotEmpty(roomtypes)){

			for (RoomType roomType : roomtypes) {
				
				//类型转换，同时查询价格
				RoomTypeInfo roomTypeInfo = dozerMapper.map(roomType, RoomTypeInfo.class);
				
				
				if(MapUtils.isNotEmpty(priceMap)){
					roomTypeInfo.setPriceInfos(priceService.fillPriceInfo(priceMap.get(roomType.getSkuId()),skuQueryIn.getHotelId(),SkuTypeEnum.roomtype.getCode()));
					roomTypeInfo.setPrices(priceMap.get(roomType.getSkuId()));
					if(MapUtils.isNotEmpty(roomTypeInfo.getPrices())){
//						int index=0;
						for (Entry<String, BigDecimal> entry : roomTypeInfo.getPrices().entrySet()) {
							if(entry.getValue()!=null){
//								if(index!=roomTypeInfo.getPrices().entrySet().size()-1){//忽略最后一天的价格

								BigDecimal price = entry.getValue().multiply(BigDecimal.valueOf(skuNumMap.get(roomType.getSkuId())));
								totalPrice = totalPrice.add(price);
									
//								}
							}else{
								throw new OpenException("有房型价格为空");
							}
//							index++;
						}
					}else{
						throw new OpenException("没有查询到房型价格");
					}
				}else{
					throw new OpenException("没有查询到房型价格");
				}
				roomTypeInfos.add(roomTypeInfo);
			}
		
		}
		
		//间页数
		int diff = DateUtil.diffDay(skuQueryIn.getBeginTime(), skuQueryIn.getEndTime());
		if(diff<=0){
			throw new OpenException("时间区间错误");
		}
//		totalPrice = totalPrice.multiply(BigDecimal.valueOf(diff));
		logger.info("总价："+totalPrice);
		try {
			logger.info("查询返回值：{}",JSON.json(roomTypeInfos));
		} catch (IOException e) {
			
		}
		info.setTotalPrice(totalPrice);
		info.setInfo(roomTypeInfos);
		return info;
	}
	/**
	 * 查询团体信息
	 * @param skuQueryIn
	 * @param roomtypeIds
	 * @return
	 */
	public SkuResultInfo<List<TeamSkuInfo>> queryTeamSku(SkuRequest skuQueryIn,List<SkuSubRequest> skuSubRequests){
		
		
		BigDecimal totalPrice = BigDecimal.ZERO;
		SkuResultInfo<List<TeamSkuInfo>> info  =new SkuResultInfo<List<TeamSkuInfo>>();
		
		List<TeamSku> roomtypes =  null;
		List<TeamSkuInfo> roomTypeInfos =  new ArrayList<TeamSkuInfo>();

		Map<Long, Integer> skuNumMap = new HashMap<Long, Integer>();
		List<Long> roomtypeIds = new ArrayList<Long>();
		//如果sku集合为空，则查询所有房型
		if(CollectionUtils.isNotEmpty(roomtypeIds)){
			
			for (SkuSubRequest skuSubRequest : skuSubRequests) {
				roomtypeIds.add(skuSubRequest.getSkuId());

				skuNumMap.put(skuSubRequest.getSkuId(), skuSubRequest.getNum());
			}
			roomtypes = teamSkuService.queryTeamSkuBySkuIds(roomtypeIds);
		}
		
		
		
		//query price
		Map<Long,Map<String,BigDecimal>> priceMap = priceService.queryHotelPrices(skuQueryIn.getHotelId(), skuQueryIn.getBeginTime(), skuQueryIn.getEndTime(), roomtypeIds);
		
		if(CollectionUtils.isNotEmpty(roomtypes)){
			
			for (TeamSku roomType : roomtypes) {
				
				//类型转换，同时查询价格
				TeamSkuInfo roomTypeInfo = dozerMapper.map(roomType, TeamSkuInfo.class);
				
				
				if(MapUtils.isNotEmpty(priceMap)){
					roomTypeInfo.setPriceInfos(priceService.fillPriceInfo(priceMap.get(roomType.getSkuId()),skuQueryIn.getHotelId(),SkuTypeEnum.teamsku.getCode()));
					roomTypeInfo.setPrices(priceMap.get(roomType.getSkuId()));
					if(MapUtils.isNotEmpty(roomTypeInfo.getPrices())){
//						int index=0;
						for (Entry<String, BigDecimal> entry : roomTypeInfo.getPrices().entrySet()) {
							if(entry.getValue()!=null){
//								if(index!=roomTypeInfo.getPrices().entrySet().size()-1){//忽略最后一天的价格

								BigDecimal price = entry.getValue().multiply(BigDecimal.valueOf(skuNumMap.get(roomType.getSkuId())));
								totalPrice = totalPrice.add(price);
//								}
							}else{
								throw new OpenException("有房型价格为空");
							}
//							index++;
						}
					}else{
						throw new OpenException("没有查询到房型价格");
					}
				}else{
					throw new OpenException("没有查询到房型价格");
				}
				roomTypeInfos.add(roomTypeInfo);
			}
			
		}
		
		//间页数
		int diff = DateUtil.diffDay(skuQueryIn.getBeginTime(), skuQueryIn.getEndTime());
		if(diff<=0){
			throw new OpenException("时间区间错误");
		}
//		totalPrice = totalPrice.multiply(BigDecimal.valueOf(diff));
		logger.info("总价："+totalPrice);
		try {
			logger.info("查询返回值：{}",JSON.json(roomTypeInfos));
		} catch (IOException e) {
			
		}
		info.setTotalPrice(totalPrice);
		info.setInfo(roomTypeInfos);
		return info;
	}
	
	/**
	 * 查询餐饮信息
	 * @param skuQueryIn
	 * @param roomtypeIds
	 * @return
	 */
	public  SkuResultInfo<List<MealInfo>> queryMeal(SkuRequest skuQueryIn,List<SkuSubRequest> skuSubRequests){

		BigDecimal totalPrice = BigDecimal.ZERO;
		SkuResultInfo<List<MealInfo>> info  =new SkuResultInfo<List<MealInfo>>();
		
		List<Long> mealIds =  new ArrayList<Long>();
		List<Meal> meals =  null;
		List<MealInfo> mealInfos =  new ArrayList<MealInfo>();
		
		Map<Long, Integer> mealNumMap = new HashMap<Long, Integer>();
		
		//如果sku集合为空，则查询所有房型
		if(CollectionUtils.isNotEmpty(skuSubRequests)){
			for (SkuSubRequest mealInfo : skuSubRequests) {
				mealIds.add(mealInfo.getSkuId());
				mealNumMap.put(mealInfo.getSkuId(),mealInfo.getNum());
			}
			meals = mealService.queryMealByMealIds(mealIds);
		}

		if(CollectionUtils.isNotEmpty(meals)){

			for (Meal meal : meals) {

				//类型转换，同时查询价格
				MealInfo mealInfo = dozerMapper.map(meal, MealInfo.class);
				if(mealInfo.getPrice()!=null){
					BigDecimal price = mealInfo.getPrice().multiply(BigDecimal.valueOf(mealNumMap.get(meal.getSkuId())));
					totalPrice = totalPrice.add(price);
				}else{
					throw new OpenException("有餐饮价格为空");
				}
				mealInfos.add(mealInfo);
			}
		}
		
		info.setInfo(mealInfos);
		info.setTotalPrice(totalPrice);
		return info;
	}
	
	

}
