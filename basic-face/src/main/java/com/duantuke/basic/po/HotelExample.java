package com.duantuke.basic.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public HotelExample() {
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
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Long value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Long value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Long value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Long value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Long value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Long> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Long> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Long value1, Long value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Long value1, Long value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNull() {
            addCriterion("hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("hotel_name =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("hotel_name <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("hotel_name >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_name >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("hotel_name <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_name <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("hotel_name like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("hotel_name not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("hotel_name in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("hotel_name not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("hotel_name between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("hotel_name not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameIsNull() {
            addCriterion("hotel_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameIsNotNull() {
            addCriterion("hotel_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameEqualTo(String value) {
            addCriterion("hotel_contact_name =", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameNotEqualTo(String value) {
            addCriterion("hotel_contact_name <>", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameGreaterThan(String value) {
            addCriterion("hotel_contact_name >", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_contact_name >=", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameLessThan(String value) {
            addCriterion("hotel_contact_name <", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_contact_name <=", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameLike(String value) {
            addCriterion("hotel_contact_name like", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameNotLike(String value) {
            addCriterion("hotel_contact_name not like", value, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameIn(List<String> values) {
            addCriterion("hotel_contact_name in", values, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameNotIn(List<String> values) {
            addCriterion("hotel_contact_name not in", values, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameBetween(String value1, String value2) {
            addCriterion("hotel_contact_name between", value1, value2, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andHotelContactNameNotBetween(String value1, String value2) {
            addCriterion("hotel_contact_name not between", value1, value2, "hotelContactName");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNull() {
            addCriterion("reg_time is null");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNotNull() {
            addCriterion("reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegTimeEqualTo(Date value) {
            addCriterion("reg_time =", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotEqualTo(Date value) {
            addCriterion("reg_time <>", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThan(Date value) {
            addCriterion("reg_time >", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reg_time >=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThan(Date value) {
            addCriterion("reg_time <", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("reg_time <=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeIn(List<Date> values) {
            addCriterion("reg_time in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotIn(List<Date> values) {
            addCriterion("reg_time not in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeBetween(Date value1, Date value2) {
            addCriterion("reg_time between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("reg_time not between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andDetailAddrIsNull() {
            addCriterion("detail_addr is null");
            return (Criteria) this;
        }

        public Criteria andDetailAddrIsNotNull() {
            addCriterion("detail_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAddrEqualTo(String value) {
            addCriterion("detail_addr =", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrNotEqualTo(String value) {
            addCriterion("detail_addr <>", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrGreaterThan(String value) {
            addCriterion("detail_addr >", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrGreaterThanOrEqualTo(String value) {
            addCriterion("detail_addr >=", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrLessThan(String value) {
            addCriterion("detail_addr <", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrLessThanOrEqualTo(String value) {
            addCriterion("detail_addr <=", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrLike(String value) {
            addCriterion("detail_addr like", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrNotLike(String value) {
            addCriterion("detail_addr not like", value, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrIn(List<String> values) {
            addCriterion("detail_addr in", values, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrNotIn(List<String> values) {
            addCriterion("detail_addr not in", values, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrBetween(String value1, String value2) {
            addCriterion("detail_addr between", value1, value2, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andDetailAddrNotBetween(String value1, String value2) {
            addCriterion("detail_addr not between", value1, value2, "detailAddr");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            addCriterion("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            addCriterion("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            addCriterion("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Date value) {
            addCriterion("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<Date> values) {
            addCriterion("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<Date> values) {
            addCriterion("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            addCriterion("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNull() {
            addCriterion("repair_time is null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNotNull() {
            addCriterion("repair_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeEqualTo(Date value) {
            addCriterion("repair_time =", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotEqualTo(Date value) {
            addCriterion("repair_time <>", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThan(Date value) {
            addCriterion("repair_time >", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repair_time >=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThan(Date value) {
            addCriterion("repair_time <", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThanOrEqualTo(Date value) {
            addCriterion("repair_time <=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIn(List<Date> values) {
            addCriterion("repair_time in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotIn(List<Date> values) {
            addCriterion("repair_time not in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeBetween(Date value1, Date value2) {
            addCriterion("repair_time between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotBetween(Date value1, Date value2) {
            addCriterion("repair_time not between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontIsNull() {
            addCriterion("business_license_front is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontIsNotNull() {
            addCriterion("business_license_front is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontEqualTo(String value) {
            addCriterion("business_license_front =", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontNotEqualTo(String value) {
            addCriterion("business_license_front <>", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontGreaterThan(String value) {
            addCriterion("business_license_front >", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_front >=", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontLessThan(String value) {
            addCriterion("business_license_front <", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontLessThanOrEqualTo(String value) {
            addCriterion("business_license_front <=", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontLike(String value) {
            addCriterion("business_license_front like", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontNotLike(String value) {
            addCriterion("business_license_front not like", value, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontIn(List<String> values) {
            addCriterion("business_license_front in", values, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontNotIn(List<String> values) {
            addCriterion("business_license_front not in", values, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontBetween(String value1, String value2) {
            addCriterion("business_license_front between", value1, value2, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseFrontNotBetween(String value1, String value2) {
            addCriterion("business_license_front not between", value1, value2, "businessLicenseFront");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackIsNull() {
            addCriterion("business_license_back is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackIsNotNull() {
            addCriterion("business_license_back is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackEqualTo(String value) {
            addCriterion("business_license_back =", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackNotEqualTo(String value) {
            addCriterion("business_license_back <>", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackGreaterThan(String value) {
            addCriterion("business_license_back >", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_back >=", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackLessThan(String value) {
            addCriterion("business_license_back <", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackLessThanOrEqualTo(String value) {
            addCriterion("business_license_back <=", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackLike(String value) {
            addCriterion("business_license_back like", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackNotLike(String value) {
            addCriterion("business_license_back not like", value, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackIn(List<String> values) {
            addCriterion("business_license_back in", values, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackNotIn(List<String> values) {
            addCriterion("business_license_back not in", values, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackBetween(String value1, String value2) {
            addCriterion("business_license_back between", value1, value2, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBackNotBetween(String value1, String value2) {
            addCriterion("business_license_back not between", value1, value2, "businessLicenseBack");
            return (Criteria) this;
        }

        public Criteria andIsvisibleIsNull() {
            addCriterion("isvisible is null");
            return (Criteria) this;
        }

        public Criteria andIsvisibleIsNotNull() {
            addCriterion("isvisible is not null");
            return (Criteria) this;
        }

        public Criteria andIsvisibleEqualTo(String value) {
            addCriterion("isvisible =", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotEqualTo(String value) {
            addCriterion("isvisible <>", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleGreaterThan(String value) {
            addCriterion("isvisible >", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleGreaterThanOrEqualTo(String value) {
            addCriterion("isvisible >=", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleLessThan(String value) {
            addCriterion("isvisible <", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleLessThanOrEqualTo(String value) {
            addCriterion("isvisible <=", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleLike(String value) {
            addCriterion("isvisible like", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotLike(String value) {
            addCriterion("isvisible not like", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleIn(List<String> values) {
            addCriterion("isvisible in", values, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotIn(List<String> values) {
            addCriterion("isvisible not in", values, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleBetween(String value1, String value2) {
            addCriterion("isvisible between", value1, value2, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotBetween(String value1, String value2) {
            addCriterion("isvisible not between", value1, value2, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontIsNull() {
            addCriterion("idcardfront is null");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontIsNotNull() {
            addCriterion("idcardfront is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontEqualTo(String value) {
            addCriterion("idcardfront =", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontNotEqualTo(String value) {
            addCriterion("idcardfront <>", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontGreaterThan(String value) {
            addCriterion("idcardfront >", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontGreaterThanOrEqualTo(String value) {
            addCriterion("idcardfront >=", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontLessThan(String value) {
            addCriterion("idcardfront <", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontLessThanOrEqualTo(String value) {
            addCriterion("idcardfront <=", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontLike(String value) {
            addCriterion("idcardfront like", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontNotLike(String value) {
            addCriterion("idcardfront not like", value, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontIn(List<String> values) {
            addCriterion("idcardfront in", values, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontNotIn(List<String> values) {
            addCriterion("idcardfront not in", values, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontBetween(String value1, String value2) {
            addCriterion("idcardfront between", value1, value2, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardfrontNotBetween(String value1, String value2) {
            addCriterion("idcardfront not between", value1, value2, "idcardfront");
            return (Criteria) this;
        }

        public Criteria andIdcardbackIsNull() {
            addCriterion("idcardback is null");
            return (Criteria) this;
        }

        public Criteria andIdcardbackIsNotNull() {
            addCriterion("idcardback is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardbackEqualTo(String value) {
            addCriterion("idcardback =", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackNotEqualTo(String value) {
            addCriterion("idcardback <>", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackGreaterThan(String value) {
            addCriterion("idcardback >", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackGreaterThanOrEqualTo(String value) {
            addCriterion("idcardback >=", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackLessThan(String value) {
            addCriterion("idcardback <", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackLessThanOrEqualTo(String value) {
            addCriterion("idcardback <=", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackLike(String value) {
            addCriterion("idcardback like", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackNotLike(String value) {
            addCriterion("idcardback not like", value, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackIn(List<String> values) {
            addCriterion("idcardback in", values, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackNotIn(List<String> values) {
            addCriterion("idcardback not in", values, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackBetween(String value1, String value2) {
            addCriterion("idcardback between", value1, value2, "idcardback");
            return (Criteria) this;
        }

        public Criteria andIdcardbackNotBetween(String value1, String value2) {
            addCriterion("idcardback not between", value1, value2, "idcardback");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeIsNull() {
            addCriterion("retention_time is null");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeIsNotNull() {
            addCriterion("retention_time is not null");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeEqualTo(String value) {
            addCriterion("retention_time =", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeNotEqualTo(String value) {
            addCriterion("retention_time <>", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeGreaterThan(String value) {
            addCriterion("retention_time >", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("retention_time >=", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeLessThan(String value) {
            addCriterion("retention_time <", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeLessThanOrEqualTo(String value) {
            addCriterion("retention_time <=", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeLike(String value) {
            addCriterion("retention_time like", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeNotLike(String value) {
            addCriterion("retention_time not like", value, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeIn(List<String> values) {
            addCriterion("retention_time in", values, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeNotIn(List<String> values) {
            addCriterion("retention_time not in", values, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeBetween(String value1, String value2) {
            addCriterion("retention_time between", value1, value2, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andRetentionTimeNotBetween(String value1, String value2) {
            addCriterion("retention_time not between", value1, value2, "retentionTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeIsNull() {
            addCriterion("default_leave_time is null");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeIsNotNull() {
            addCriterion("default_leave_time is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeEqualTo(String value) {
            addCriterion("default_leave_time =", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeNotEqualTo(String value) {
            addCriterion("default_leave_time <>", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeGreaterThan(String value) {
            addCriterion("default_leave_time >", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("default_leave_time >=", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeLessThan(String value) {
            addCriterion("default_leave_time <", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeLessThanOrEqualTo(String value) {
            addCriterion("default_leave_time <=", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeLike(String value) {
            addCriterion("default_leave_time like", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeNotLike(String value) {
            addCriterion("default_leave_time not like", value, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeIn(List<String> values) {
            addCriterion("default_leave_time in", values, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeNotIn(List<String> values) {
            addCriterion("default_leave_time not in", values, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeBetween(String value1, String value2) {
            addCriterion("default_leave_time between", value1, value2, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLeaveTimeNotBetween(String value1, String value2) {
            addCriterion("default_leave_time not between", value1, value2, "defaultLeaveTime");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneIsNull() {
            addCriterion("hotel_phone is null");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneIsNotNull() {
            addCriterion("hotel_phone is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneEqualTo(String value) {
            addCriterion("hotel_phone =", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotEqualTo(String value) {
            addCriterion("hotel_phone <>", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneGreaterThan(String value) {
            addCriterion("hotel_phone >", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_phone >=", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneLessThan(String value) {
            addCriterion("hotel_phone <", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneLessThanOrEqualTo(String value) {
            addCriterion("hotel_phone <=", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneLike(String value) {
            addCriterion("hotel_phone like", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotLike(String value) {
            addCriterion("hotel_phone not like", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneIn(List<String> values) {
            addCriterion("hotel_phone in", values, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotIn(List<String> values) {
            addCriterion("hotel_phone not in", values, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneBetween(String value1, String value2) {
            addCriterion("hotel_phone between", value1, value2, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotBetween(String value1, String value2) {
            addCriterion("hotel_phone not between", value1, value2, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneIsNull() {
            addCriterion("qt_phone is null");
            return (Criteria) this;
        }

        public Criteria andQtPhoneIsNotNull() {
            addCriterion("qt_phone is not null");
            return (Criteria) this;
        }

        public Criteria andQtPhoneEqualTo(String value) {
            addCriterion("qt_phone =", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneNotEqualTo(String value) {
            addCriterion("qt_phone <>", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneGreaterThan(String value) {
            addCriterion("qt_phone >", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("qt_phone >=", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneLessThan(String value) {
            addCriterion("qt_phone <", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneLessThanOrEqualTo(String value) {
            addCriterion("qt_phone <=", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneLike(String value) {
            addCriterion("qt_phone like", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneNotLike(String value) {
            addCriterion("qt_phone not like", value, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneIn(List<String> values) {
            addCriterion("qt_phone in", values, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneNotIn(List<String> values) {
            addCriterion("qt_phone not in", values, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneBetween(String value1, String value2) {
            addCriterion("qt_phone between", value1, value2, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andQtPhoneNotBetween(String value1, String value2) {
            addCriterion("qt_phone not between", value1, value2, "qtPhone");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(Integer value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(Integer value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(Integer value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(Integer value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(Integer value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<Integer> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<Integer> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(Integer value1, Integer value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(Integer value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(Integer value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(Integer value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(Integer value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(Integer value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<Integer> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<Integer> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(Integer value1, Integer value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNull() {
            addCriterion("district_code is null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNotNull() {
            addCriterion("district_code is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeEqualTo(Integer value) {
            addCriterion("district_code =", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotEqualTo(Integer value) {
            addCriterion("district_code <>", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThan(Integer value) {
            addCriterion("district_code >", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("district_code >=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThan(Integer value) {
            addCriterion("district_code <", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThanOrEqualTo(Integer value) {
            addCriterion("district_code <=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIn(List<Integer> values) {
            addCriterion("district_code in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotIn(List<Integer> values) {
            addCriterion("district_code not in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeBetween(Integer value1, Integer value2) {
            addCriterion("district_code between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("district_code not between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andHotelFaxIsNull() {
            addCriterion("hotel_fax is null");
            return (Criteria) this;
        }

        public Criteria andHotelFaxIsNotNull() {
            addCriterion("hotel_fax is not null");
            return (Criteria) this;
        }

        public Criteria andHotelFaxEqualTo(String value) {
            addCriterion("hotel_fax =", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxNotEqualTo(String value) {
            addCriterion("hotel_fax <>", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxGreaterThan(String value) {
            addCriterion("hotel_fax >", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_fax >=", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxLessThan(String value) {
            addCriterion("hotel_fax <", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxLessThanOrEqualTo(String value) {
            addCriterion("hotel_fax <=", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxLike(String value) {
            addCriterion("hotel_fax like", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxNotLike(String value) {
            addCriterion("hotel_fax not like", value, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxIn(List<String> values) {
            addCriterion("hotel_fax in", values, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxNotIn(List<String> values) {
            addCriterion("hotel_fax not in", values, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxBetween(String value1, String value2) {
            addCriterion("hotel_fax between", value1, value2, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andHotelFaxNotBetween(String value1, String value2) {
            addCriterion("hotel_fax not between", value1, value2, "hotelFax");
            return (Criteria) this;
        }

        public Criteria andReadonlyIsNull() {
            addCriterion("readonly is null");
            return (Criteria) this;
        }

        public Criteria andReadonlyIsNotNull() {
            addCriterion("readonly is not null");
            return (Criteria) this;
        }

        public Criteria andReadonlyEqualTo(String value) {
            addCriterion("readonly =", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotEqualTo(String value) {
            addCriterion("readonly <>", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyGreaterThan(String value) {
            addCriterion("readonly >", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyGreaterThanOrEqualTo(String value) {
            addCriterion("readonly >=", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyLessThan(String value) {
            addCriterion("readonly <", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyLessThanOrEqualTo(String value) {
            addCriterion("readonly <=", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyLike(String value) {
            addCriterion("readonly like", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotLike(String value) {
            addCriterion("readonly not like", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyIn(List<String> values) {
            addCriterion("readonly in", values, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotIn(List<String> values) {
            addCriterion("readonly not in", values, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyBetween(String value1, String value2) {
            addCriterion("readonly between", value1, value2, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotBetween(String value1, String value2) {
            addCriterion("readonly not between", value1, value2, "readonly");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPicsIsNull() {
            addCriterion("pics is null");
            return (Criteria) this;
        }

        public Criteria andPicsIsNotNull() {
            addCriterion("pics is not null");
            return (Criteria) this;
        }

        public Criteria andPicsEqualTo(String value) {
            addCriterion("pics =", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotEqualTo(String value) {
            addCriterion("pics <>", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThan(String value) {
            addCriterion("pics >", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThanOrEqualTo(String value) {
            addCriterion("pics >=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThan(String value) {
            addCriterion("pics <", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThanOrEqualTo(String value) {
            addCriterion("pics <=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLike(String value) {
            addCriterion("pics like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotLike(String value) {
            addCriterion("pics not like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsIn(List<String> values) {
            addCriterion("pics in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotIn(List<String> values) {
            addCriterion("pics not in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsBetween(String value1, String value2) {
            addCriterion("pics between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotBetween(String value1, String value2) {
            addCriterion("pics not between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberIsNull() {
            addCriterion("people_number is null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberIsNotNull() {
            addCriterion("people_number is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberEqualTo(Integer value) {
            addCriterion("people_number =", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberNotEqualTo(Integer value) {
            addCriterion("people_number <>", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberGreaterThan(Integer value) {
            addCriterion("people_number >", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("people_number >=", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberLessThan(Integer value) {
            addCriterion("people_number <", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberLessThanOrEqualTo(Integer value) {
            addCriterion("people_number <=", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberIn(List<Integer> values) {
            addCriterion("people_number in", values, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberNotIn(List<Integer> values) {
            addCriterion("people_number not in", values, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberBetween(Integer value1, Integer value2) {
            addCriterion("people_number between", value1, value2, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("people_number not between", value1, value2, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("createuser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("createuser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("createuser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("createuser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("createuser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("createuser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("createuser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("createuser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("createuser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("createuser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("createuser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("createuser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("createuser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("createuser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNull() {
            addCriterion("updateuser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNotNull() {
            addCriterion("updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserEqualTo(String value) {
            addCriterion("updateuser =", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotEqualTo(String value) {
            addCriterion("updateuser <>", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThan(String value) {
            addCriterion("updateuser >", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("updateuser >=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThan(String value) {
            addCriterion("updateuser <", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("updateuser <=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLike(String value) {
            addCriterion("updateuser like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotLike(String value) {
            addCriterion("updateuser not like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIn(List<String> values) {
            addCriterion("updateuser in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotIn(List<String> values) {
            addCriterion("updateuser not in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserBetween(String value1, String value2) {
            addCriterion("updateuser between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotBetween(String value1, String value2) {
            addCriterion("updateuser not between", value1, value2, "updateuser");
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