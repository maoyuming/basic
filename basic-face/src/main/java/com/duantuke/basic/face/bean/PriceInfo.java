package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class PriceInfo implements Serializable{
    private String date;
    private BigDecimal price;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    
    
}
