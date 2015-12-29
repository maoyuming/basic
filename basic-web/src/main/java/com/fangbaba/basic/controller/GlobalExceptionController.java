package com.fangbaba.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 系统例外处理
 *
 * @author nolan.
 *
 */
@ControllerAdvice
public class GlobalExceptionController {
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);


	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllException(Exception ex) {
		logger.error("异常",ex);
		return new ResponseEntity<String>(ex.getLocalizedMessage(), HttpStatus.OK);
	}

}