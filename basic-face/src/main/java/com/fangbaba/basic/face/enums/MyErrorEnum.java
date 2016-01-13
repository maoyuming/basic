/**
 * 2015年12月23日下午3:11:07
 * zhaochuanbin
 */
package com.fangbaba.basic.face.enums;

import com.fangbaba.basic.face.bean.MyException;

public enum MyErrorEnum {
	errorParm("-1","参数错误。"),
	errorHotelId("-2","酒店id为空"),
	errorRoomTypeId("-3","房型id为空"),
	errorBeginDate("-4","开始时间为空"),
	errorEndDate("-5","结束时间为空"),
	errorRoomTypeEmpty("-6","酒店房型的房间为空"),
	errorRoomId("-7","房间id为空"),
	errorOtaTypeEmpty("-8","otatype参数为空"),
	errorNotOtaType("-9","没有该酒店下房型otatype的记录"),
	errorNotOtaRoom("-10","没有该酒店下房型otatype的房间数为负数"),
	customError("0000","");
	;
	
	private final String errorCode;
	private final String errorMsg;
	
	private MyErrorEnum(String errorCode,String errorMsg){
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
	}
	
	public MyException getMyException(){
		return getMyException(errorMsg);
	}
	
	public MyException getMyException(String msg){
		return new MyException(errorCode, "", msg);//  返回输入的错误信息
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	 
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public static MyErrorEnum findByCode(String code){
		for (MyErrorEnum value : MyErrorEnum.values()) {
			if(value.errorCode.equalsIgnoreCase(code)){
				return value;
			}
		}
		return null;
	}
}
