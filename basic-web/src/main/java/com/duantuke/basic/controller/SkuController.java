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

import com.duantuke.basic.face.bean.SkuRequest;
import com.duantuke.basic.face.bean.SkuResponse;
import com.duantuke.basic.face.service.SkuService;
import com.google.gson.Gson;


@Controller
@RequestMapping(value = "/customer/sku")
public class SkuController {
	private static Logger logger = LoggerFactory.getLogger(SkuController.class);
	@Autowired
	private SkuService skuService;
	
	
	/**
     * 查询价格
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value = "/query")
    public ResponseEntity<SkuResponse> query(HttpServletRequest request, HttpServletResponse response,
    		String json) {
        SkuRequest skuRequest= new Gson().fromJson(json, SkuRequest.class);
		//校验参数
		checkParam(skuRequest,request);
		SkuResponse skuResponse = null;
		try {
			skuResponse = skuService.querySku(skuRequest);
		} catch (Exception e) {
			logger.error("查询sku异常",e);
		}
		return new ResponseEntity<SkuResponse>(skuResponse, HttpStatus.OK);
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
		Map<Integer, List<Long>> skuMap = new HashMap<Integer, List<Long>>();
		List<Long> list = new ArrayList<Long>();
		list.add(123123L);
		list.add(123123L);
		list.add(123523L);
		list.add(123823L);
		list.add(123023L);
		
		skuMap.put(1, list);
		
		skuRequest.setHotelId(123L);
		skuRequest.setSkuMap(skuMap);
		skuRequest.setBeginTime("2016-06-05");
		skuRequest.setEndTime("2016-06-06");
	
		System.out.println(new Gson().toJson(skuRequest));
		
		String json = "{\"skuMap\":{\"1\":[123123,123123,123523,123823,123023]},\"hotelId\":123}";
		SkuRequest skuRequest2= new Gson().fromJson(json, SkuRequest.class);
		System.out.println(new Gson().toJson(skuRequest2));
	}
}
