package com.fangbaba.basic.face.bean;

import java.io.Serializable;

import com.fangbaba.basic.face.enums.MyErrorEnum;


public class MyException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String errorCode;
	private  final String errorKey;
	
	public MyException(String errorCode, String errorKey, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorKey = errorKey;
	}

	public MyException(String errorCode,String errorKey){
		super("errorcode:"+errorCode);
		this.errorCode=errorCode;
		this.errorKey=errorKey;
	}
	
	
	public MyException(MyErrorEnum errorEnum){
		this(errorEnum.getErrorCode(),errorEnum.getErrorMsg());
	}
	
	public MyErrorEnum getMyErrorEnum(){
		return MyErrorEnum.findByCode(errorCode);
	}

	public final String getErrorKey() {
		return errorKey;
	}

}
