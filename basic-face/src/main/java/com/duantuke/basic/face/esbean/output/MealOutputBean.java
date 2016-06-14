package com.duantuke.basic.face.esbean.output;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author he
 * 餐饮搜索结果输出bean
 */
public class MealOutputBean implements Serializable{

	private static final long serialVersionUID = 1L;

	//from meal
	private Long skuId;

    private String meatVegetable;

    private BigDecimal cost;

    private BigDecimal price;

    private BigDecimal suggestPrice;

    private Integer peopleNumber;
    
    //from sku
    private String name;//名称
    private String pics;//图片
    private String descrition;//描述
    private String supplierId;//提供者
    private String supplierName;//提供者
    private String memo;//备注

    //from meal_rank
    private Long mealRankId;//餐饮评级id
    private Integer rank;//评级
    private Integer consume;//消费次数
    private Integer comment;//评论数
    private Integer travel;//游记数
    private String createtime;
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public String getMeatVegetable() {
		return meatVegetable;
	}
	public void setMeatVegetable(String meatVegetable) {
		this.meatVegetable = meatVegetable;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSuggestPrice() {
		return suggestPrice;
	}
	public void setSuggestPrice(BigDecimal suggestPrice) {
		this.suggestPrice = suggestPrice;
	}
	public Integer getPeopleNumber() {
		return peopleNumber;
	}
	public void setPeopleNumber(Integer peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Long getMealRankId() {
		return mealRankId;
	}
	public void setMealRankId(Long mealRankId) {
		this.mealRankId = mealRankId;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getConsume() {
		return consume;
	}
	public void setConsume(Integer consume) {
		this.consume = consume;
	}
	public Integer getComment() {
		return comment;
	}
	public void setComment(Integer comment) {
		this.comment = comment;
	}
	public Integer getTravel() {
		return travel;
	}
	public void setTravel(Integer travel) {
		this.travel = travel;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}
