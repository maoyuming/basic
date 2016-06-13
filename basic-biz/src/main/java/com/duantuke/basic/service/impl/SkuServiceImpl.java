package com.duantuke.basic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.SkuTypeEnum;
import com.duantuke.basic.exception.OpenException;
import com.duantuke.basic.face.bean.MealInfo;
import com.duantuke.basic.face.bean.RoomTypeInfo;
import com.duantuke.basic.face.bean.SkuInfo;
import com.duantuke.basic.face.bean.SkuQueryIn;
import com.duantuke.basic.face.service.MealService;
import com.duantuke.basic.face.service.PriceService;
import com.duantuke.basic.face.service.RoomTypeService;
import com.duantuke.basic.face.service.SkuService;
import com.duantuke.basic.po.Meal;
import com.duantuke.basic.po.RoomType;

@Service
public class SkuServiceImpl implements SkuService {

	@Autowired
	private RoomTypeService roomTypeService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private MealService mealService;

    @Autowired
    private Mapper dozerMapper;
    
    
    /**
     * 查询sku列表
     */
	@Override
	public SkuInfo querySku(SkuQueryIn skuQueryIn) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		SkuInfo skuInfo = new SkuInfo();
		skuInfo.setTotalPrice(totalPrice);
		skuInfo.setSupplier(skuQueryIn.getHotelId()+"");
		
		if(skuQueryIn!=null){
			if(MapUtils.isNotEmpty(skuQueryIn.getSkuMap())){
				for (Entry<Integer, List<Long>> entry : skuQueryIn.getSkuMap().entrySet()) {
					SkuTypeEnum skuTypeEnum = SkuTypeEnum.getSkuTypeEnumByCode(entry.getKey());
					
					switch (skuTypeEnum) {
					case roomtype:
						BigDecimal roomtypePrice = BigDecimal.ZERO;
						List<RoomTypeInfo> roomTypeInfos = queryRoomtype(skuQueryIn, entry.getValue(),roomtypePrice);
						totalPrice = totalPrice.add(roomtypePrice);
						
						skuInfo.setRoomTypeInfos(roomTypeInfos);
						break;
					case meal:
						BigDecimal mealPrice = BigDecimal.ZERO;
						List<MealInfo> mealInfos = queryMeal(skuQueryIn, entry.getValue(), totalPrice);
						totalPrice = totalPrice.add(mealPrice);
						skuInfo.setMealInfos(mealInfos);
						break;
						
					default:
						break;
					}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 查询房型信息
	 * @param skuQueryIn
	 * @param roomtypeIds
	 * @return
	 */
	public List<RoomTypeInfo> queryRoomtype(SkuQueryIn skuQueryIn,List<Long> roomtypeIds,BigDecimal totalPrice){
		List<RoomType> roomtypes =  null;
		List<RoomTypeInfo> roomTypeInfos =  new ArrayList<RoomTypeInfo>();
		

		//query price
		Map<Long,Map<String,BigDecimal>> priceMap = priceService.queryHotelPrices(skuQueryIn.getHotelId(), skuQueryIn.getBeginTime(), skuQueryIn.getEndTime(), null);
		
		//如果sku集合为空，则查询所有房型
		if(CollectionUtils.isEmpty(roomtypeIds)){
			roomtypes = roomTypeService.queryRoomtypeByHotleId(skuQueryIn.getHotelId());
		}else{
			roomtypes = roomTypeService.queryRoomtypeByRoomtypeIds(roomtypeIds);
		}
		if(CollectionUtils.isNotEmpty(roomtypes)){

			for (RoomType roomType : roomtypes) {
				
				//类型转换，同时查询价格
				RoomTypeInfo roomTypeInfo = dozerMapper.map(roomType, RoomTypeInfo.class);
				
				
				if(MapUtils.isNotEmpty(priceMap)){
					roomTypeInfo.setPrices(priceMap.get(roomType.getRoomtypeId()));
					if(MapUtils.isNotEmpty(roomTypeInfo.getPrices())){
						for (Entry<String, BigDecimal> entry : roomTypeInfo.getPrices().entrySet()) {
							if(entry.getValue()!=null){
								totalPrice = totalPrice.add(entry.getValue());
							}else{
								throw new OpenException("有房型价格为空");
							}
						}
					}
				}
				roomTypeInfos.add(roomTypeInfo);
			}
		
		}
		return roomTypeInfos;
	}
	
	/**
	 * 查询餐饮信息
	 * @param skuQueryIn
	 * @param roomtypeIds
	 * @return
	 */
	public List<MealInfo> queryMeal(SkuQueryIn skuQueryIn,List<Long> mealIds,BigDecimal totalPrice){
		List<Meal> meals =  null;
		List<MealInfo> mealInfos =  new ArrayList<MealInfo>();
		
		//如果sku集合为空，则查询所有房型
		if(CollectionUtils.isEmpty(mealIds)){
			meals = mealService.queryMealByHotleId(skuQueryIn.getHotelId());
		}else{
			meals = mealService.queryMealByMealIds(mealIds);
		}

		if(CollectionUtils.isNotEmpty(meals)){

			for (Meal meal : meals) {

				//类型转换，同时查询价格
				MealInfo mealInfo = dozerMapper.map(meal, MealInfo.class);
				if(mealInfo.getPrice()!=null){
					totalPrice = totalPrice.add(mealInfo.getPrice());
				}else{
					throw new OpenException("有餐饮价格为空");
				}
				mealInfos.add(mealInfo);
			}
		}
		
		return mealInfos;
	}

}
