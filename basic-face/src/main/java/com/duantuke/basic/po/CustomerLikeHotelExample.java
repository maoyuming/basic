package com.duantuke.basic.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerLikeHotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public CustomerLikeHotelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("h.hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("h.hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Long value) {
            addCriterion("h.hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Long value) {
            addCriterion("h.hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Long value) {
            addCriterion("h.hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("h.hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Long value) {
            addCriterion("h.hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Long value) {
            addCriterion("h.hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Long> values) {
            addCriterion("h.hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Long> values) {
            addCriterion("h.hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Long value1, Long value2) {
            addCriterion("h.hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Long value1, Long value2) {
            addCriterion("h.hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNull() {
            addCriterion("h.hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("h.hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("h.hotel_name =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("h.hotel_name <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("h.hotel_name >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("h.hotel_name >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("h.hotel_name <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("h.hotel_name <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("h.hotel_name like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("h.hotel_name not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("h.hotel_name in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("h.hotel_name not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("h.hotel_name between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("h.hotel_name not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameIsNull() {
            addCriterion("h.hotel_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameIsNotNull() {
            addCriterion("h.hotel_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameEqualTo(String value) {
            addCriterion("h.hotel_contact_name =", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameNotEqualTo(String value) {
            addCriterion("h.hotel_contact_name <>", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameGreaterThan(String value) {
            addCriterion("h.hotel_contact_name >", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("h.hotel_contact_name >=", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameLessThan(String value) {
            addCriterion("h.hotel_contact_name <", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameLessThanOrEqualTo(String value) {
            addCriterion("h.hotel_contact_name <=", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameLike(String value) {
            addCriterion("h.hotel_contact_name like", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameNotLike(String value) {
            addCriterion("h.hotel_contact_name not like", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameIn(List<String> values) {
            addCriterion("h.hotel_contact_name in", values, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameNotIn(List<String> values) {
            addCriterion("h.hotel_contact_name not in", values, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameBetween(String value1, String value2) {
            addCriterion("h.hotel_contact_name between", value1, value2, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameNotBetween(String value1, String value2) {
            addCriterion("h.hotel_contact_name not between", value1, value2, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNull() {
            addCriterion("h.reg_time is null");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNotNull() {
            addCriterion("h.reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegTimeEqualTo(Date value) {
            addCriterion("h.reg_time =", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotEqualTo(Date value) {
            addCriterion("h.reg_time <>", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThan(Date value) {
            addCriterion("h.reg_time >", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("h.reg_time >=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThan(Date value) {
            addCriterion("h.reg_time <", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("h.reg_time <=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeIn(List<Date> values) {
            addCriterion("h.reg_time in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotIn(List<Date> values) {
            addCriterion("h.reg_time not in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeBetween(Date value1, Date value2) {
            addCriterion("h.reg_time between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("h.reg_time not between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andDetailAddrIsNull() {
            addCriterion("h.detail_addr is null");
            return (Criteria) this;
        }

        public Criteria andDetailAddrIsNotNull() {
            addCriterion("h.detail_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAddrEqualTo(String value) {
            addCriterion("h.detail_addr =", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrNotEqualTo(String value) {
            addCriterion("h.detail_addr <>", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrGreaterThan(String value) {
            addCriterion("h.detail_addr >", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrGreaterThanOrEqualTo(String value) {
            addCriterion("h.detail_addr >=", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrLessThan(String value) {
            addCriterion("h.detail_addr <", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrLessThanOrEqualTo(String value) {
            addCriterion("h.detail_addr <=", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrLike(String value) {
            addCriterion("h.detail_addr like", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrNotLike(String value) {
            addCriterion("h.detail_addr not like", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrIn(List<String> values) {
            addCriterion("h.detail_addr in", values, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrNotIn(List<String> values) {
            addCriterion("h.detail_addr not in", values, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrBetween(String value1, String value2) {
            addCriterion("h.detail_addr between", value1, value2, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrNotBetween(String value1, String value2) {
            addCriterion("h.detail_addr not between", value1, value2, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("h.longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("h.longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("h.longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("h.longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("h.longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("h.longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("h.longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("h.longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("h.longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("h.longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("h.longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("h.longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("h.latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("h.latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("h.latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("h.latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("h.latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("h.latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("h.latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("h.latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("h.latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("h.latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("h.latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("h.latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("h.open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("h.open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            addCriterion("h.open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            addCriterion("h.open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            addCriterion("h.open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("h.open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Date value) {
            addCriterion("h.open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("h.open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<Date> values) {
            addCriterion("h.open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<Date> values) {
            addCriterion("h.open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            addCriterion("h.open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("h.open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNull() {
            addCriterion("h.repair_time is null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNotNull() {
            addCriterion("h.repair_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeEqualTo(Date value) {
            addCriterion("h.repair_time =", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotEqualTo(Date value) {
            addCriterion("h.repair_time <>", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThan(Date value) {
            addCriterion("h.repair_time >", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("h.repair_time >=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThan(Date value) {
            addCriterion("h.repair_time <", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThanOrEqualTo(Date value) {
            addCriterion("h.repair_time <=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIn(List<Date> values) {
            addCriterion("h.repair_time in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotIn(List<Date> values) {
            addCriterion("h.repair_time not in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeBetween(Date value1, Date value2) {
            addCriterion("h.repair_time between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotBetween(Date value1, Date value2) {
            addCriterion("h.repair_time not between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontIsNull() {
            addCriterion("h.business_license_front is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontIsNotNull() {
            addCriterion("h.business_license_front is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontEqualTo(String value) {
            addCriterion("h.business_license_front =", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontNotEqualTo(String value) {
            addCriterion("h.business_license_front <>", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontGreaterThan(String value) {
            addCriterion("h.business_license_front >", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontGreaterThanOrEqualTo(String value) {
            addCriterion("h.business_license_front >=", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontLessThan(String value) {
            addCriterion("h.business_license_front <", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontLessThanOrEqualTo(String value) {
            addCriterion("h.business_license_front <=", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontLike(String value) {
            addCriterion("h.business_license_front like", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontNotLike(String value) {
            addCriterion("h.business_license_front not like", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontIn(List<String> values) {
            addCriterion("h.business_license_front in", values, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontNotIn(List<String> values) {
            addCriterion("h.business_license_front not in", values, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontBetween(String value1, String value2) {
            addCriterion("h.business_license_front between", value1, value2, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontNotBetween(String value1, String value2) {
            addCriterion("h.business_license_front not between", value1, value2, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackIsNull() {
            addCriterion("h.business_license_back is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackIsNotNull() {
            addCriterion("h.business_license_back is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackEqualTo(String value) {
            addCriterion("h.business_license_back =", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackNotEqualTo(String value) {
            addCriterion("h.business_license_back <>", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackGreaterThan(String value) {
            addCriterion("h.business_license_back >", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackGreaterThanOrEqualTo(String value) {
            addCriterion("h.business_license_back >=", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackLessThan(String value) {
            addCriterion("h.business_license_back <", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackLessThanOrEqualTo(String value) {
            addCriterion("h.business_license_back <=", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackLike(String value) {
            addCriterion("h.business_license_back like", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackNotLike(String value) {
            addCriterion("h.business_license_back not like", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackIn(List<String> values) {
            addCriterion("h.business_license_back in", values, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackNotIn(List<String> values) {
            addCriterion("h.business_license_back not in", values, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackBetween(String value1, String value2) {
            addCriterion("h.business_license_back between", value1, value2, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackNotBetween(String value1, String value2) {
            addCriterion("h.business_license_back not between", value1, value2, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andIsvisibleIsNull() {
            addCriterion("h.isvisible is null");
            return (Criteria) this;
        }

        public Criteria andIsvisibleIsNotNull() {
            addCriterion("h.isvisible is not null");
            return (Criteria) this;
        }

        public Criteria andIsvisibleEqualTo(String value) {
            addCriterion("h.isvisible =", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotEqualTo(String value) {
            addCriterion("h.isvisible <>", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleGreaterThan(String value) {
            addCriterion("h.isvisible >", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleGreaterThanOrEqualTo(String value) {
            addCriterion("h.isvisible >=", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleLessThan(String value) {
            addCriterion("h.isvisible <", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleLessThanOrEqualTo(String value) {
            addCriterion("h.isvisible <=", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleLike(String value) {
            addCriterion("h.isvisible like", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotLike(String value) {
            addCriterion("h.isvisible not like", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleIn(List<String> values) {
            addCriterion("h.isvisible in", values, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotIn(List<String> values) {
            addCriterion("h.isvisible not in", values, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleBetween(String value1, String value2) {
            addCriterion("h.isvisible between", value1, value2, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotBetween(String value1, String value2) {
            addCriterion("h.isvisible not between", value1, value2, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontIsNull() {
            addCriterion("h.idcardfront is null");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontIsNotNull() {
            addCriterion("h.idcardfront is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontEqualTo(String value) {
            addCriterion("h.idcardfront =", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontNotEqualTo(String value) {
            addCriterion("h.idcardfront <>", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontGreaterThan(String value) {
            addCriterion("h.idcardfront >", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontGreaterThanOrEqualTo(String value) {
            addCriterion("h.idcardfront >=", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontLessThan(String value) {
            addCriterion("h.idcardfront <", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontLessThanOrEqualTo(String value) {
            addCriterion("h.idcardfront <=", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontLike(String value) {
            addCriterion("h.idcardfront like", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontNotLike(String value) {
            addCriterion("h.idcardfront not like", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontIn(List<String> values) {
            addCriterion("h.idcardfront in", values, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontNotIn(List<String> values) {
            addCriterion("h.idcardfront not in", values, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontBetween(String value1, String value2) {
            addCriterion("h.idcardfront between", value1, value2, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontNotBetween(String value1, String value2) {
            addCriterion("h.idcardfront not between", value1, value2, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardbackIsNull() {
            addCriterion("h.idcardback is null");
            return (Criteria) this;
        }

        public Criteria andIdcardbackIsNotNull() {
            addCriterion("h.idcardback is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardbackEqualTo(String value) {
            addCriterion("h.idcardback =", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackNotEqualTo(String value) {
            addCriterion("h.idcardback <>", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackGreaterThan(String value) {
            addCriterion("h.idcardback >", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackGreaterThanOrEqualTo(String value) {
            addCriterion("h.idcardback >=", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackLessThan(String value) {
            addCriterion("h.idcardback <", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackLessThanOrEqualTo(String value) {
            addCriterion("h.idcardback <=", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackLike(String value) {
            addCriterion("h.idcardback like", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackNotLike(String value) {
            addCriterion("h.idcardback not like", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackIn(List<String> values) {
            addCriterion("h.idcardback in", values, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackNotIn(List<String> values) {
            addCriterion("h.idcardback not in", values, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackBetween(String value1, String value2) {
            addCriterion("h.idcardback between", value1, value2, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackNotBetween(String value1, String value2) {
            addCriterion("h.idcardback not between", value1, value2, "idcardback");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeIsNull() {
            addCriterion("h.retention_time is null");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeIsNotNull() {
            addCriterion("h.retention_time is not null");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeEqualTo(String value) {
            addCriterion("h.retention_time =", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeNotEqualTo(String value) {
            addCriterion("h.retention_time <>", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeGreaterThan(String value) {
            addCriterion("h.retention_time >", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("h.retention_time >=", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeLessThan(String value) {
            addCriterion("h.retention_time <", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeLessThanOrEqualTo(String value) {
            addCriterion("h.retention_time <=", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeLike(String value) {
            addCriterion("h.retention_time like", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeNotLike(String value) {
            addCriterion("h.retention_time not like", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeIn(List<String> values) {
            addCriterion("h.retention_time in", values, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeNotIn(List<String> values) {
            addCriterion("h.retention_time not in", values, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeBetween(String value1, String value2) {
            addCriterion("h.retention_time between", value1, value2, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeNotBetween(String value1, String value2) {
            addCriterion("h.retention_time not between", value1, value2, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeIsNull() {
            addCriterion("h.default_leave_time is null");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeIsNotNull() {
            addCriterion("h.default_leave_time is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeEqualTo(String value) {
            addCriterion("h.default_leave_time =", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeNotEqualTo(String value) {
            addCriterion("h.default_leave_time <>", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeGreaterThan(String value) {
            addCriterion("h.default_leave_time >", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("h.default_leave_time >=", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeLessThan(String value) {
            addCriterion("h.default_leave_time <", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeLessThanOrEqualTo(String value) {
            addCriterion("h.default_leave_time <=", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeLike(String value) {
            addCriterion("h.default_leave_time like", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeNotLike(String value) {
            addCriterion("h.default_leave_time not like", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeIn(List<String> values) {
            addCriterion("h.default_leave_time in", values, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeNotIn(List<String> values) {
            addCriterion("h.default_leave_time not in", values, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeBetween(String value1, String value2) {
            addCriterion("h.default_leave_time between", value1, value2, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeNotBetween(String value1, String value2) {
            addCriterion("h.default_leave_time not between", value1, value2, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneIsNull() {
            addCriterion("h.hotel_phone is null");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneIsNotNull() {
            addCriterion("h.hotel_phone is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneEqualTo(String value) {
            addCriterion("h.hotel_phone =", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotEqualTo(String value) {
            addCriterion("h.hotel_phone <>", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneGreaterThan(String value) {
            addCriterion("h.hotel_phone >", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("h.hotel_phone >=", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneLessThan(String value) {
            addCriterion("h.hotel_phone <", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneLessThanOrEqualTo(String value) {
            addCriterion("h.hotel_phone <=", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneLike(String value) {
            addCriterion("h.hotel_phone like", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotLike(String value) {
            addCriterion("h.hotel_phone not like", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneIn(List<String> values) {
            addCriterion("h.hotel_phone in", values, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotIn(List<String> values) {
            addCriterion("h.hotel_phone not in", values, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneBetween(String value1, String value2) {
            addCriterion("h.hotel_phone between", value1, value2, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotBetween(String value1, String value2) {
            addCriterion("h.hotel_phone not between", value1, value2, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneIsNull() {
            addCriterion("h.qt_phone is null");
            return (Criteria) this;
        }

        public Criteria andQtPhoneIsNotNull() {
            addCriterion("h.qt_phone is not null");
            return (Criteria) this;
        }

        public Criteria andQtPhoneEqualTo(String value) {
            addCriterion("h.qt_phone =", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneNotEqualTo(String value) {
            addCriterion("h.qt_phone <>", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneGreaterThan(String value) {
            addCriterion("h.qt_phone >", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("h.qt_phone >=", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneLessThan(String value) {
            addCriterion("h.qt_phone <", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneLessThanOrEqualTo(String value) {
            addCriterion("h.qt_phone <=", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneLike(String value) {
            addCriterion("h.qt_phone like", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneNotLike(String value) {
            addCriterion("h.qt_phone not like", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneIn(List<String> values) {
            addCriterion("h.qt_phone in", values, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneNotIn(List<String> values) {
            addCriterion("h.qt_phone not in", values, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneBetween(String value1, String value2) {
            addCriterion("h.qt_phone between", value1, value2, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneNotBetween(String value1, String value2) {
            addCriterion("h.qt_phone not between", value1, value2, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("h.province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("h.province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(Integer value) {
            addCriterion("h.province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(Integer value) {
            addCriterion("h.province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(Integer value) {
            addCriterion("h.province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("h.province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(Integer value) {
            addCriterion("h.province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(Integer value) {
            addCriterion("h.province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<Integer> values) {
            addCriterion("h.province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<Integer> values) {
            addCriterion("h.province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(Integer value1, Integer value2) {
            addCriterion("h.province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("h.province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("h.city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("h.city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(Integer value) {
            addCriterion("h.city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(Integer value) {
            addCriterion("h.city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(Integer value) {
            addCriterion("h.city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("h.city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(Integer value) {
            addCriterion("h.city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(Integer value) {
            addCriterion("h.city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<Integer> values) {
            addCriterion("h.city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<Integer> values) {
            addCriterion("h.city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(Integer value1, Integer value2) {
            addCriterion("h.city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("h.city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNull() {
            addCriterion("h.district_code is null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNotNull() {
            addCriterion("h.district_code is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeEqualTo(Integer value) {
            addCriterion("h.district_code =", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotEqualTo(Integer value) {
            addCriterion("h.district_code <>", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThan(Integer value) {
            addCriterion("h.district_code >", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("h.district_code >=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThan(Integer value) {
            addCriterion("h.district_code <", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThanOrEqualTo(Integer value) {
            addCriterion("h.district_code <=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIn(List<Integer> values) {
            addCriterion("h.district_code in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotIn(List<Integer> values) {
            addCriterion("h.district_code not in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeBetween(Integer value1, Integer value2) {
            addCriterion("h.district_code between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("h.district_code not between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andHotelFaxIsNull() {
            addCriterion("h.hotel_fax is null");
            return (Criteria) this;
        }

        public Criteria andHotelFaxIsNotNull() {
            addCriterion("h.hotel_fax is not null");
            return (Criteria) this;
        }

        public Criteria andHotelFaxEqualTo(String value) {
            addCriterion("h.hotel_fax =", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxNotEqualTo(String value) {
            addCriterion("h.hotel_fax <>", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxGreaterThan(String value) {
            addCriterion("h.hotel_fax >", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxGreaterThanOrEqualTo(String value) {
            addCriterion("h.hotel_fax >=", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxLessThan(String value) {
            addCriterion("h.hotel_fax <", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxLessThanOrEqualTo(String value) {
            addCriterion("h.hotel_fax <=", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxLike(String value) {
            addCriterion("h.hotel_fax like", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxNotLike(String value) {
            addCriterion("h.hotel_fax not like", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxIn(List<String> values) {
            addCriterion("h.hotel_fax in", values, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxNotIn(List<String> values) {
            addCriterion("h.hotel_fax not in", values, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxBetween(String value1, String value2) {
            addCriterion("h.hotel_fax between", value1, value2, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxNotBetween(String value1, String value2) {
            addCriterion("h.hotel_fax not between", value1, value2, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("h.state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("h.state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("h.state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("h.state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("h.state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("h.state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("h.state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("h.state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("h.state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("h.state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("h.state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("h.state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPicsIsNull() {
            addCriterion("h.pics is null");
            return (Criteria) this;
        }

        public Criteria andPicsIsNotNull() {
            addCriterion("h.pics is not null");
            return (Criteria) this;
        }

        public Criteria andPicsEqualTo(String value) {
            addCriterion("h.pics =", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotEqualTo(String value) {
            addCriterion("h.pics <>", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThan(String value) {
            addCriterion("h.pics >", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThanOrEqualTo(String value) {
            addCriterion("h.pics >=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThan(String value) {
            addCriterion("h.pics <", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThanOrEqualTo(String value) {
            addCriterion("h.pics <=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLike(String value) {
            addCriterion("h.pics like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotLike(String value) {
            addCriterion("h.pics not like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsIn(List<String> values) {
            addCriterion("h.pics in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotIn(List<String> values) {
            addCriterion("h.pics not in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsBetween(String value1, String value2) {
            addCriterion("h.pics between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotBetween(String value1, String value2) {
            addCriterion("h.pics not between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("h.createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("h.createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("h.createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("h.createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("h.createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("h.createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("h.createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("h.createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("h.createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("h.createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("h.createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("h.createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("h.createuser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("h.createuser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("h.createuser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("h.createuser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("h.createuser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("h.createuser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("h.createuser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("h.createuser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("h.createuser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("h.createuser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("h.createuser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("h.createuser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("h.createuser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("h.createuser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("h.updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("h.updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("h.updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("h.updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("h.updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("h.updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("h.updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("h.updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("h.updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("h.updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("h.updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("h.updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNull() {
            addCriterion("h.updateuser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNotNull() {
            addCriterion("h.updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserEqualTo(String value) {
            addCriterion("h.updateuser =", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotEqualTo(String value) {
            addCriterion("h.updateuser <>", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThan(String value) {
            addCriterion("h.updateuser >", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("h.updateuser >=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThan(String value) {
            addCriterion("h.updateuser <", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("h.updateuser <=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLike(String value) {
            addCriterion("h.updateuser like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotLike(String value) {
            addCriterion("h.updateuser not like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIn(List<String> values) {
            addCriterion("h.updateuser in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotIn(List<String> values) {
            addCriterion("h.updateuser not in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserBetween(String value1, String value2) {
            addCriterion("h.updateuser between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotBetween(String value1, String value2) {
            addCriterion("h.updateuser not between", value1, value2, "updateuser");
            return (Criteria) this;
        }
        
        
        public Criteria andCustomerIdIsNull() {
            addCriterion("d.customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("d.customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("d.customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("d.customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("d.customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("d.customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("d.customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("d.customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("d.customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("d.customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("d.customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("d.customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }
        
        public Criteria andBusinessTypeIsNull() {
            addCriterion("d.business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("d.business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(Short value) {
            addCriterion("d.business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(Short value) {
            addCriterion("d.business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(Short value) {
            addCriterion("d.business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("d.business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(Short value) {
            addCriterion("d.business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(Short value) {
            addCriterion("d.business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<Short> values) {
            addCriterion("d.business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<Short> values) {
            addCriterion("d.business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(Short value1, Short value2) {
            addCriterion("d.business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(Short value1, Short value2) {
            addCriterion("d.business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }
        
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}