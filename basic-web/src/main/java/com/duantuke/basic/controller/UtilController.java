package com.duantuke.basic.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.face.esbean.output.SightOutputBean;
import com.duantuke.basic.face.esbean.query.SightQueryBean;
import com.duantuke.basic.face.service.SightSearchService;
import com.google.gson.Gson;
import com.mk.jdbc.utils.MD5Util;

@Controller
@RequestMapping(value = "/util")
public class UtilController extends BaseController {

	@Autowired
	private SightSearchService sightSearchService;
	
	String AUTH = "5416d7cd6ef195a0f7622a9c56b55e84";
	
	/**
	 * @return 初始化es
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
	 * @return 清空es
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

	@RequestMapping(value = "/searchSightsFromEs", method = RequestMethod.POST)
	public ResponseEntity<String> searchSightsFromEs(SightQueryBean sightQueryBean, String auth) {
		if (StringUtils.isEmpty(auth) || !AUTH.equals(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		List<SightOutputBean> list = sightSearchService.searchSightsFromEs(sightQueryBean);
		String result = new Gson().toJson(list);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

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
