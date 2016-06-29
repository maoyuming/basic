package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import com.duantuke.basic.po.TeamSku;

public class TeamSkuInfo extends TeamSku implements Serializable{
	private static final long serialVersionUID = 1L;
    
    private Map<String, BigDecimal> prices;


	public Map<String, BigDecimal> getPrices() {
		return prices;
	}

	public void setPrices(Map<String, BigDecimal> prices) {
		this.prices = prices;
	}
    
    
    
}