package com.duantuke.basic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.SkuTypeEnum;
import com.duantuke.basic.face.bean.RoomTypeInfo;
import com.duantuke.basic.face.bean.SkuInfo;
import com.duantuke.basic.face.bean.SkuQueryIn;
import com.duantuke.basic.face.service.PriceService;
import com.duantuke.basic.face.service.RoomTypeService;
import com.duantuke.basic.face.service.SkuService;
import com.duantuke.basic.po.RoomType;

@Service
public class SkuServiceImpl implements SkuService {

	@Autowired
	private RoomTypeService roomTypeService;
	@Autowired
	private PriceService priceService;

    @Autowired
    private Mapper dozerMapper;
	@Override
	public SkuInfo querySku(SkuQueryIn skuQueryIn) {
		if(skuQueryIn!=null){
			if(MapUtils.isNotEmpty(skuQueryIn.getSkuMap())){
				for (Entry<Integer, List<Long>> entry : skuQueryIn.getSkuMap().entrySet()) {
					SkuTypeEnum skuTypeEnum = SkuTypeEnum.getSkuTypeEnumByCode(entry.getKey());
					
					switch (skuTypeEnum) {
					case roomtype:
						break;
					case meal:
						
						break;
						
					default:
						break;
					}
				}
			}
		}
		
		return null;
	}
	
	
	public void queryRoomtype(SkuQueryIn skuQueryIn,List<Long> roomtypeIds){
		List<RoomType> roomtypes =  null;
		List<RoomTypeInfo> roomTypeInfos =  new ArrayList<RoomTypeInfo>();
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
				
				//query price
				priceService.queryHotelPrices(skuQueryIn.getHotelId(), skuQueryIn.getBeginTime(), skuQueryIn.getEndTime(), roomType.getRoomtypeId());
				roomTypeInfos.add(roomTypeInfo);
			}
		
		}
	}

}
