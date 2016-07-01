package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.duantuke.basic.po.RoomType;

public class RoomTypeInfo extends RoomType implements Serializable{
	private static final long serialVersionUID = 1L;
    
    private Map<String, BigDecimal> prices;

    private List<PriceInfo> priceInfos;

	public Map<String, BigDecimal> getPrices() {
		return prices;
	}

	public void setPrices(Map<String, BigDecimal> prices) {
		this.prices = prices;
	}

	public List<PriceInfo> getPriceInfos() {
		return priceInfos;
	}

	public void setPriceInfos(List<PriceInfo> priceInfos) {
		this.priceInfos = priceInfos;
	}
    
    
    
}