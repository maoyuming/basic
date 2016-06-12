package com.duantuke.basic.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duantuke.basic.face.esbean.output.HotelOutputBean;
import com.duantuke.basic.face.esbean.output.SightOutputBean;
import com.duantuke.basic.face.esbean.query.HotelQueryBean;
import com.duantuke.basic.face.esbean.query.SightQueryBean;
import com.duantuke.basic.face.service.HotelSearchService;
import com.duantuke.basic.face.service.SightSearchService;
import com.google.gson.Gson;
import com.mk.jdbc.utils.MD5Util;

@Controller
@RequestMapping(value = "/util")
public class UtilController extends BaseController {

	@Autowired
	private SightSearchService sightSearchService;
	@Autowired
	private HotelSearchService hotelSearchService;
	
	String AUTH = "5416d7cd6ef195a0f7622a9c56b55e84";
	
	
	/**-------------------------------------------------------------景点相关begin---------------------------------------------------------------*/
	
	/**
	 * @return 初始化景点es
	 */
	@RequestMapping(value = "/initsightes", method = RequestMethod.POST)
	public ResponseEntity<String> initsightes(Long sightId, String auth) {
		String result = "";
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		try {
			sightSearchService.initEs(sightId);
			result = "initsightes完成";
		} catch (Exception e) {
			result = e.getMessage();
			logger.error("initsightes error", e);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	

	/**
	 * @return 清空景点es
	 */
	@RequestMapping(value = "/delsightes", method = RequestMethod.POST)
	public ResponseEntity<String> delsightes(Long sightId,String auth) {
		
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}

		try {
			if(sightId!=null){
				sightSearchService.delEsBySightId(sightId);
			}else{
				sightSearchService.delEs();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("delsightes error", e);
		}
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	/**
	 * @param sightQueryBean
	 * @param auth
	 * 搜索景点es
	 */
	@RequestMapping(value = "/searchSightsFromEs", method = RequestMethod.POST)
	public ResponseEntity<String> searchSightsFromEs(SightQueryBean sightQueryBean, String auth) {
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		List<SightOutputBean> list = sightSearchService.searchSightsFromEs(sightQueryBean);
		String result = new Gson().toJson(list);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	/**-------------------------------------------------------------景点相关end---------------------------------------------------------------*/
	
	
	/**-------------------------------------------------------------农家院相关begin---------------------------------------------------------------*/
	
	/**
	 * @return 初始化农家院es
	 */
	@RequestMapping(value = "/inithoteles", method = RequestMethod.POST)
	public ResponseEntity<String> inithoteles(Long hotelId, String auth) {
		String result = "";
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		try {
			hotelSearchService.initEs(hotelId);
			result = "inithoteles完成";
		} catch (Exception e) {
			result = e.getMessage();
			logger.error("inithoteles error", e);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	

	/**
	 * @return 清空农家院es
	 */
	@RequestMapping(value = "/delhoteles", method = RequestMethod.POST)
	public ResponseEntity<String> delhoteles(Long hotelId,String auth) {
		
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}

		try {
			if(hotelId!=null){
				hotelSearchService.delEsByHotelId(hotelId);
			}else{
				hotelSearchService.delEs();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("delhoteles error", e);
		}
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	/**
	 * @param hotelQueryBean
	 * @param auth
	 * 搜索农家院es
	 */
	@RequestMapping(value = "/searchHotelsFromEs", method = RequestMethod.POST)
	public ResponseEntity<String> searchHotelsFromEs(HotelQueryBean hotelQueryBean, String auth) {
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		List<HotelOutputBean> list = hotelSearchService.searchHotelsFromEs(hotelQueryBean,null);
		String result = new Gson().toJson(list);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	/**-------------------------------------------------------------农家院相关end---------------------------------------------------------------*/

	/**
	 * @param auth
	 * 校验auth
	 */
	private boolean validateAuth(String auth){
		if (StringUtils.isNotBlank(auth) && AUTH.equals(MD5Util.md5Hex(auth))) {
			return true;
		}else{
			return false;
		}
	}
}
