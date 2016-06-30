package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * sku查询入参
 * @author tankai
 *
 */
public class SkuSubRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long skuId;//skuid
	private Integer num;//数量
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	
	
	
}
