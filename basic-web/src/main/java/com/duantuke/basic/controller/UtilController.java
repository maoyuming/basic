package com.duantuke.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duantuke.basic.face.esbean.output.HotelOutputBean;
import com.duantuke.basic.face.esbean.output.JourneyOutputBean;
import com.duantuke.basic.face.esbean.output.MealOutputBean;
import com.duantuke.basic.face.esbean.output.SightOutputBean;
import com.duantuke.basic.face.esbean.query.HotelQueryBean;
import com.duantuke.basic.face.esbean.query.JourneyQueryBean;
import com.duantuke.basic.face.esbean.query.MealQueryBean;
import com.duantuke.basic.face.esbean.query.SightQueryBean;
import com.duantuke.basic.face.service.HotelSearchService;
import com.duantuke.basic.face.service.JourneySearchService;
import com.duantuke.basic.face.service.MealSearchService;
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
	@Autowired
	private JourneySearchService journeySearchService;
	@Autowired
	private MealSearchService mealSearchService;
	
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
	 * @return 刷新价格到es
	 */
	@RequestMapping(value = "/refreshesprice", method = RequestMethod.POST)
	public ResponseEntity<String> refreshesprice(Long hotelId, String auth) {
		String result = "";
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		try {
			hotelSearchService.refreshesprice(hotelId);
			result = "refreshesprice完成";
		} catch (Exception e) {
			result = e.getMessage();
			logger.error("refreshesprice error", e);
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
		List<HotelOutputBean> list = hotelSearchService.searchHotelsFromEs(hotelQueryBean);
		String result = new Gson().toJson(list);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	/**-------------------------------------------------------------农家院相关end---------------------------------------------------------------*/
	
	
	/**-------------------------------------------------------------游记相关begin---------------------------------------------------------------*/
	
	/**
	 * @return 初始化游记es
	 */
	@RequestMapping(value = "/initjourneyes", method = RequestMethod.POST)
	public ResponseEntity<String> initjourneyes(Long journeyId, String auth) {
		String result = "";
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		try {
			journeySearchService.initEs(journeyId);
			result = "initjourneyes完成";
		} catch (Exception e) {
			result = e.getMessage();
			logger.error("initjourneyes error", e);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	

	/**
	 * @return 清空游记es
	 */
	@RequestMapping(value = "/deljourneyes", method = RequestMethod.POST)
	public ResponseEntity<String> deljourneyes(Long journeyId,String auth) {
		
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}

		try {
			if(journeyId!=null){
				journeySearchService.delEsByJourneyId(journeyId);
			}else{
				journeySearchService.delEs();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("deljourneyes error", e);
		}
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	/**
	 * @param journeyQueryBean
	 * @param auth
	 * 搜索游记es
	 */
	@RequestMapping(value = "/searchJourneysFromEs", method = RequestMethod.POST)
	public ResponseEntity<String> searchJourneysFromEs(JourneyQueryBean journeyQueryBean, String auth) {
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		Map<String,List<String>> tagmap = new HashMap<String,List<String>>();
		List<String> paramlist = new ArrayList<String>();
		paramlist.add("1");
		paramlist.add("2");
		tagmap.put("hotelIds", paramlist);
		List<JourneyOutputBean> list = journeySearchService.searchJourneysFromEs(journeyQueryBean,tagmap,null);
		String result = new Gson().toJson(list);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	/**-------------------------------------------------------------游记相关end---------------------------------------------------------------*/

	/**-------------------------------------------------------------餐饮相关begin---------------------------------------------------------------*/
	
	/**
	 * @return 初始化餐饮es
	 */
	@RequestMapping(value = "/initmeales", method = RequestMethod.POST)
	public ResponseEntity<String> initmeales(Long mealId, String auth) {
		String result = "";
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		try {
			mealSearchService.initEs(mealId);
			result = "initmeales完成";
		} catch (Exception e) {
			result = e.getMessage();
			logger.error("initmeales error", e);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	

	/**
	 * @return 清空游记es
	 */
	@RequestMapping(value = "/delmeales", method = RequestMethod.POST)
	public ResponseEntity<String> delmeales(Long mealId,String auth) {
		
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}

		try {
			if(mealId!=null){
				mealSearchService.delEsByMealId(mealId);
			}else{
				mealSearchService.delEs();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("delmeales error", e);
		}
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	/**
	 * @param mealQueryBean
	 * @param auth
	 * 搜索餐饮es
	 */
	@RequestMapping(value = "/searchMealsFromEs", method = RequestMethod.POST)
	public ResponseEntity<String> searchMealsFromEs(MealQueryBean mealQueryBean, String auth) {
		if (!validateAuth(auth)) {
			return new ResponseEntity<String>("auth参数错误", HttpStatus.OK);
		}
		List<MealOutputBean> list = mealSearchService.searchMealsFromEs(mealQueryBean);
		String result = new Gson().toJson(list);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	/**-------------------------------------------------------------餐饮相关end---------------------------------------------------------------*/
	
	
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
