package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * sku查询返回结果
 * @author tankai
 *
 */
public class SkuResultInfo<T>  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal totalPrice;
	private T info;
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
