package com.fangbaba.basic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.po.CityModel;
import com.fangbaba.basic.po.DistrictModel;
import com.fangbaba.basic.po.HotelModel;
import com.fangbaba.basic.po.ProvinceModel;
import com.fangbaba.basic.service.CityService;
import com.fangbaba.basic.service.DistrictService;
import com.fangbaba.basic.service.HotelSearchService;
import com.fangbaba.basic.service.HotelService;
import com.fangbaba.basic.service.ProvinceService;
import com.fangbaba.basic.util.HotelElasticsearchUtil;
import com.fangbaba.basic.util.SearchConst;
import com.google.common.base.Strings;

/**
 * @author he
 * 酒店搜索相关接口
 */
@Service
public class HotelSearchServiceImpl implements HotelSearchService {
	
	private static final Logger log = LoggerFactory.getLogger(HotelSearchServiceImpl.class);
	@Autowired
    private HotelElasticsearchUtil esutil;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private DistrictService districtService;

	/**
	 * 初始化所有酒店到es
	 * @return
	 */
	@Override
	public void initHotelsToEs() {
		List<HotelModel> list = hotelService.queryAllHotels();
		List<ProvinceModel> list1 = provinceService.queryAllProvinces();
		List<CityModel> list2 = cityService.queryAllCitys();
		List<DistrictModel> list3 = districtService.queryAllDistricts();
		Map<Integer,ProvinceModel> map1 = new HashMap<Integer,ProvinceModel>();
		Map<Integer,CityModel> map2 = new HashMap<Integer,CityModel>();
		Map<Integer,DistrictModel> map3 = new HashMap<Integer,DistrictModel>();
		for (ProvinceModel provinceModel:list1) {
			map1.put(Integer.parseInt(provinceModel.getCode()), provinceModel==null?new ProvinceModel():provinceModel);
		}
		for (CityModel cityModel:list2) {
			map2.put(Integer.parseInt(cityModel.getCode()), cityModel);
		}
		for (DistrictModel districtModel:list3) {
			map3.put(Integer.parseInt(districtModel.getCode()), districtModel==null?new DistrictModel():districtModel);
		}
		for (HotelModel hotelModel:list) {
			hotelModel.setProvincename(map1.get(hotelModel.getProvcode()).getName());
			hotelModel.setCityname(map2.get(hotelModel.getCitycode()).getName());
			hotelModel.setDistrictname(map3.get(hotelModel.getDiscode()).getName());
			hotelModel.setPin(new GeoPoint(hotelModel.getLatitude().doubleValue(), hotelModel.getLongitude().doubleValue()));
		}
		esutil.deleteAllDocument();
		esutil.batchAddDocument(list);
	}

	@Override
	public boolean updateES(HotelModel hotelModel) {
		boolean result=false;
		SearchHit[] hits=esutil.searchHotelByHotelId(hotelModel.getId().toString());
		if (null==hits || hits.length==0) {
			log.info("could't find any hotel in es. hotel id:{}",hotelModel.getId());
			result=false;
		}else {
			String hotelESid=hits[0].getId();
			if (!Strings.isNullOrEmpty(hotelESid)) {
				UpdateResponse resp=esutil.updateDocument(hotelESid, hotelModel);
				result=resp.isCreated();
				log.info("update hotel es success.hotel id:{}",hotelModel.getId());
			}else {
				log.info("could't find  hotel id in es. hotel id:{}",hotelModel.getId());
			}
		}
		return result;
	}

	@Override
	public boolean insertES(HotelModel hotelModel) {
		IndexResponse indexResponse= esutil.signleAddDocument(hotelModel);
		boolean result=indexResponse.isCreated();
		log.info("insert es result:{},hotel id:{}",result,hotelModel.getId());
		return result;
	}

	@Override
	public boolean delES(HotelModel hotelModel) {
		boolean result=false;
		SearchHit[] hits=esutil.searchHotelByHotelId(hotelModel.getId().toString());

		if (null==hits || hits.length==0) {
			log.info("could't find any hotel in es. hotel id:{}",hotelModel.getId());
			result=false;
		}else {
			for (SearchHit searchHit : hits) {
				String hotelESid=searchHit.getId();
				if (!Strings.isNullOrEmpty(hotelESid)) {
					DeleteResponse resp=esutil.deleteDocument(hotelESid);
					result=resp.isFound();
					log.info("delete hotel es success.hotel id:{},hotel info:",hotelModel.getId(),searchHit.getFields());
				}else {
					log.info("could't find  hotel id in es. hotel id:{},hotel info:",hotelModel.getId(),searchHit.getFields());
				}
			}
			
		}
		return result;
	}

	@Override
	public List<HotelModel> searchHotelFromES(HotelModel hotelModel,int page,int size) {
		Map<String, String > map=new HashMap<String, String>();
		try {
			map.put("hotelname", hotelModel.getHotelname());
			map.put("cityname", hotelModel.getCityname());
			map.put("districtname", hotelModel.getDistrictname());
			map.put("provincename", hotelModel.getProvincename());
			map.put("pin", hotelModel.getLatitude()+","+hotelModel.getLongitude());
			map.put("range", hotelModel.getRange().toString());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		// page参数校验：如果page小于等于0，默认为1.
        if (page <= 0) {
            page = SearchConst.SEARCH_PAGE_DEFAULT;
        }
        // size参数校验：如果size小于等于0，默认为10.
        if (size <= 0) {
        	size = SearchConst.SEARCH_LIMIT_DEFAULT;
        }
		List<HotelModel> result=esutil.searchHotelWithFields(map,page,size);
		log.info("searchHotelFromES result:{}",result);
		return result;
	}
	

}
