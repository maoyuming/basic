package com.fangbaba.basic.face.base;

import java.io.Serializable;
import java.util.List;


/**
 * 公共返回值
 */
public class RetInfo<T> implements Serializable {
	private static final long serialVersionUID = -4737817121454976870L;
	public boolean result = true;//true成功，false失败
    public String code;//错误编码
    public String msg;//错误信息
    private T obj;
    private List<T> list;
    
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	/**
	 * 成功
	 */
	public void success(){
		this.setResult(true);
		this.setMsg("success");
	}
	/**
	 * 失败
	 * @param code
	 * @param msg
	 */
	public void fail(String code,String msg){
		this.setResult(false);
		this.setCode(code);
		this.setMsg(msg);
	}
    
}
