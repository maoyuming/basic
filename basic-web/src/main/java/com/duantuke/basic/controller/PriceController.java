package com.duantuke.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.duantuke.basic.face.bean.PriceInfo;
import com.duantuke.basic.face.bean.SkuRequest;
import com.duantuke.basic.face.bean.SkuSubRequest;
import com.duantuke.basic.face.service.PriceService;
import com.google.gson.Gson;


@Controller
@RequestMapping(value = "/price")
public class PriceController {
	private static Logger logger = LoggerFactory.getLogger(PriceController.class);
	@Autowired
	private PriceService priceService;
	
	
	/**
     * 查询价格
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value = "/query")
    public ResponseEntity<Map<Long,List<PriceInfo>>> query(HttpServletRequest request, HttpServletResponse response,
    		Long hotelId, String begintime, String endtime,@RequestParam ArrayList<Long> roomtypeIds) {
		Map<Long,List<PriceInfo>> map = null;
		try {
			map = priceService.queryHotelPriceInfos(hotelId, begintime, endtime, roomtypeIds);
		} catch (Exception e) {
			logger.error("查询价格异常",e);
		}
		return new ResponseEntity<Map<Long,List<PriceInfo>>>(map, HttpStatus.OK);
	}
	
	/**
	 * 校验参数
	 * @param token
	 */
	private void checkParam(SkuRequest skuRequest,HttpServletRequest request){
		
		logger.info("查询sku入参：{}",new Gson().toJson(skuRequest));
		

//		duantukeComment.setCustomerId(TokenUtil.getUserIdByRequest(request));
		
		
	}
	
	
	public static void main(String[] args) {
		SkuRequest skuRequest= new SkuRequest();
		Map<Integer, List<SkuSubRequest>> skuMap = new HashMap<Integer, List<SkuSubRequest>>();
		List<SkuSubRequest> list = new ArrayList<SkuSubRequest>();
		SkuSubRequest request = new SkuSubRequest();
		request.setSkuId(12321L);
		request.setNum(11);
		list.add(request);
		
		skuMap.put(1, list);
		
		skuRequest.setHotelId(123L);
		skuRequest.setSkuMap(skuMap);
		skuRequest.setBeginDate("2016-06-05");
		skuRequest.setEndDate("2016-06-06");
	
		System.out.println(new Gson().toJson(skuRequest));
		
//		String json = "{\"skuMap\":{\"1\":[123123,123123,123523,123823,123023]},\"hotelId\":123}";
//		SkuRequest skuRequest2= new Gson().fromJson(json, SkuRequest.class);
//		System.out.println(new Gson().toJson(skuRequest2));
	}
}
