package com.fangbaba.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hotel")
public class HotelController {

	/*@Autowired
	private HotelSearchService hotelSearchService;
	@Autowired
	private HotelService hotelService;

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
	
	@RequestMapping(value = "/searches", method = RequestMethod.POST)
	public ResponseEntity<RetInfo> searchES(HotelModel hotelModel,int page,int size) {
		HotelModel hotelModel=new HotelModel();
		hotelModel.setHotelname("万鑫全时尚宾馆");
		hotelModel.setProvincename("S 上海市");
		hotelModel.setCityname("S 上海市");
		hotelModel.setDistrictname("P 浦东新区");
		List<HotelModel> list=hotelSearchService.searchHotelFromES(hotelModel,page,size);
		RetInfo retInfo=new RetInfo();
		retInfo.setList(list);
		retInfo.setResult(list!=null &&list.size()>0);
		
		return new ResponseEntity<RetInfo>(retInfo, HttpStatus.OK);
	}*/
	
}
