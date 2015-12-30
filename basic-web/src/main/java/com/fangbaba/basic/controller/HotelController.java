package com.fangbaba.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fangbaba.basic.service.HotelService;

@Controller
@RequestMapping(value = "/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	/*@Autowired
	private HotelSearchService hotelSearchService;

	@RequestMapping(value = "/inites", method = RequestMethod.GET)
	public ResponseEntity<RetInfo> inites() {
		RetInfo retInfo = new RetInfo();
		try {
			hotelSearchService.initHotelsToEs();
			retInfo.success();
		} catch (Exception e) {
			retInfo.fail("-1", e.getMessage());
		} 
		return new ResponseEntity<RetInfo>(retInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/insertes", method = RequestMethod.POST)
	public ResponseEntity<RetInfo> insertES(HotelModel hotelModel) {
		HotelModel hotelModel=new HotelModel();
		hotelModel.setId(111L);
		hotelModel.setHotelname("123456");
		hotelModel.setHotelpms("qwedfgy");
		RetInfo retInfo=new RetInfo();
		try {
			boolean result=hotelSearchService.insertES(hotelModel);
			retInfo.result=result;
		} catch (Exception e) {
			retInfo.fail("-1", e.getMessage());
		}
		return new ResponseEntity<RetInfo>(retInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updatees", method = RequestMethod.POST)
	public ResponseEntity<RetInfo> updateES(HotelModel hotelModel) {
		HotelModel hotelModel=new HotelModel();
		hotelModel.setId(111L);
		hotelModel.setHotelname("12345");
		hotelModel.setProvincename("S 上海市");
		hotelModel.setCityname("S 上海市");
		hotelModel.setDistrictname("Z 闵行区");
		RetInfo retInfo=new RetInfo();
		try {
			boolean result=hotelSearchService.updateES(hotelModel);
			retInfo.result=result;
		} catch (Exception e) {
			retInfo.fail("-1", e.getMessage());
		}
		return new ResponseEntity<RetInfo>(retInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deles", method = RequestMethod.POST)
	public ResponseEntity<RetInfo> delES(HotelModel hotelModel) {
		HotelModel hotelModel=new HotelModel();
		hotelModel.setId(111L);
		hotelModel.setHotelname("123456");
		hotelModel.setProvincename("S 上海市");
		hotelModel.setCityname("S 上海市");
		hotelModel.setDistrictname("Z 闵行区");
		
		RetInfo retInfo=new RetInfo();
		try {
			boolean result=hotelSearchService.delES(hotelModel);
			retInfo.result=result;
		} catch (Exception e) {
			retInfo.fail("-1", e.getMessage());
		}
		return new ResponseEntity<RetInfo>(retInfo, HttpStatus.OK);
	}
	*/
	@RequestMapping(value = "/synchotel", method = RequestMethod.POST)
	public ResponseEntity<String> searchES(String json) {
		hotelService.syncHotelInfo(json);
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
}
