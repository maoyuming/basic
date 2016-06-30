package com.duantuke.basic.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PersonalTailor implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long personalTailorId;

    private Long customerId;

    private Integer type;

    private String departureCity;

    private String destination;

    private Integer howlong;

    private Date fromdate;

    private String trip;

    private Integer number;

    private Long budget;

    private BigDecimal totalPrice;

    private String contact;

    private String contactPhone;

    private String email;

    private String memo;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Long getPersonalTailorId() {
        return personalTailorId;
    }

    public void setPersonalTailorId(Long personalTailorId) {
        this.personalTailorId = personalTailorId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity == null ? null : departureCity.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public Integer getHowlong() {
        return howlong;
    }

    public void setHowlong(Integer howlong) {
        this.howlong = howlong;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip == null ? null : trip.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}