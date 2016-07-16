package com.duantuke.basic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.duantuke.basic.face.service.PushLogService;
import com.duantuke.basic.po.LPushLog;

@Controller
@RequestMapping(value = "/message")
public class MessageController {
	private static Logger logger = LoggerFactory.getLogger(MessageController.class);
	

	@Autowired
	private PushLogService pushLogService;
	
	
	@RequestMapping("/list")
	public ResponseEntity<List<LPushLog>> list(HttpServletRequest request,LPushLog lPushLog) throws Exception {
        logger.info("用户{}查询消息列表",JSONObject.toJSON(lPushLog));
		lPushLog.setBegin(lPushLog.getBegin());
		lPushLog.setEnd(lPushLog.getPageSize());
		List<LPushLog> list=pushLogService.queryPushLogByMid(lPushLog);
		
		return new ResponseEntity<List<LPushLog>>(list, HttpStatus.OK);
	}
	
	
}
