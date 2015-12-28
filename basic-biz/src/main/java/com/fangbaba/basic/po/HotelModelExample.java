package com.fangbaba.basic.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelModelExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHotelnameIsNull() {
            addCriterion("hotelname is null");
            return (Criteria) this;
        }

        public Criteria andHotelnameIsNotNull() {
            addCriterion("hotelname is not null");
            return (Criteria) this;
        }

        public Criteria andHotelnameEqualTo(String value) {
            addCriterion("hotelname =", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotEqualTo(String value) {
            addCriterion("hotelname <>", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThan(String value) {
            addCriterion("hotelname >", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThanOrEqualTo(String value) {
            addCriterion("hotelname >=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThan(String value) {
            addCriterion("hotelname <", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThanOrEqualTo(String value) {
            addCriterion("hotelname <=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLike(String value) {
            addCriterion("hotelname like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotLike(String value) {
            addCriterion("hotelname not like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameIn(List<String> values) {
            addCriterion("hotelname in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotIn(List<String> values) {
            addCriterion("hotelname not in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameBetween(String value1, String value2) {
            addCriterion("hotelname between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotBetween(String value1, String value2) {
            addCriterion("hotelname not between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameIsNull() {
            addCriterion("hotelcontactname is null");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameIsNotNull() {
            addCriterion("hotelcontactname is not null");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameEqualTo(String value) {
            addCriterion("hotelcontactname =", value, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameNotEqualTo(String value) {
            addCriterion("hotelcontactname <>", value, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameGreaterThan(String value) {
            addCriterion("hotelcontactname >", value, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameGreaterThanOrEqualTo(String value) {
            addCriterion("hotelcontactname >=", value, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameLessThan(String value) {
            addCriterion("hotelcontactname <", value, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameLessThanOrEqualTo(String value) {
            addCriterion("hotelcontactname <=", value, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameLike(String value) {
            addCriterion("hotelcontactname like", value, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameNotLike(String value) {
            addCriterion("hotelcontactname not like", value, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameIn(List<String> values) {
            addCriterion("hotelcontactname in", values, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameNotIn(List<String> values) {
            addCriterion("hotelcontactname not in", values, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameBetween(String value1, String value2) {
            addCriterion("hotelcontactname between", value1, value2, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andHotelcontactnameNotBetween(String value1, String value2) {
            addCriterion("hotelcontactname not between", value1, value2, "hotelcontactname");
            return (Criteria) this;
        }

        public Criteria andRegtimeIsNull() {
            addCriterion("regtime is null");
            return (Criteria) this;
        }

        public Criteria andRegtimeIsNotNull() {
            addCriterion("regtime is not null");
            return (Criteria) this;
        }

        public Criteria andRegtimeEqualTo(Date value) {
            addCriterion("regtime =", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotEqualTo(Date value) {
            addCriterion("regtime <>", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeGreaterThan(Date value) {
            addCriterion("regtime >", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("regtime >=", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeLessThan(Date value) {
            addCriterion("regtime <", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeLessThanOrEqualTo(Date value) {
            addCriterion("regtime <=", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeIn(List<Date> values) {
            addCriterion("regtime in", values, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotIn(List<Date> values) {
            addCriterion("regtime not in", values, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeBetween(Date value1, Date value2) {
            addCriterion("regtime between", value1, value2, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotBetween(Date value1, Date value2) {
            addCriterion("regtime not between", value1, value2, "regtime");
            return (Criteria) this;
        }

        public Criteria andDetailaddrIsNull() {
            addCriterion("detailaddr is null");
            return (Criteria) this;
        }

        public Criteria andDetailaddrIsNotNull() {
            addCriterion("detailaddr is not null");
            return (Criteria) this;
        }

        public Criteria andDetailaddrEqualTo(String value) {
            addCriterion("detailaddr =", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrNotEqualTo(String value) {
            addCriterion("detailaddr <>", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrGreaterThan(String value) {
            addCriterion("detailaddr >", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrGreaterThanOrEqualTo(String value) {
            addCriterion("detailaddr >=", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrLessThan(String value) {
            addCriterion("detailaddr <", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrLessThanOrEqualTo(String value) {
            addCriterion("detailaddr <=", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrLike(String value) {
            addCriterion("detailaddr like", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrNotLike(String value) {
            addCriterion("detailaddr not like", value, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrIn(List<String> values) {
            addCriterion("detailaddr in", values, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrNotIn(List<String> values) {
            addCriterion("detailaddr not in", values, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrBetween(String value1, String value2) {
            addCriterion("detailaddr between", value1, value2, "detailaddr");
            return (Criteria) this;
        }

        public Criteria andDetailaddrNotBetween(String value1, String value2) {
            addCriterion("detailaddr not between", value1, value2, "detailaddr");
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

        public Criteria andOpentimeIsNull() {
            addCriterion("opentime is null");
            return (Criteria) this;
        }

        public Criteria andOpentimeIsNotNull() {
            addCriterion("opentime is not null");
            return (Criteria) this;
        }

        public Criteria andOpentimeEqualTo(Date value) {
            addCriterion("opentime =", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeNotEqualTo(Date value) {
            addCriterion("opentime <>", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeGreaterThan(Date value) {
            addCriterion("opentime >", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeGreaterThanOrEqualTo(Date value) {
            addCriterion("opentime >=", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeLessThan(Date value) {
            addCriterion("opentime <", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeLessThanOrEqualTo(Date value) {
            addCriterion("opentime <=", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeIn(List<Date> values) {
            addCriterion("opentime in", values, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeNotIn(List<Date> values) {
            addCriterion("opentime not in", values, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeBetween(Date value1, Date value2) {
            addCriterion("opentime between", value1, value2, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeNotBetween(Date value1, Date value2) {
            addCriterion("opentime not between", value1, value2, "opentime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeIsNull() {
            addCriterion("repairtime is null");
            return (Criteria) this;
        }

        public Criteria andRepairtimeIsNotNull() {
            addCriterion("repairtime is not null");
            return (Criteria) this;
        }

        public Criteria andRepairtimeEqualTo(Date value) {
            addCriterion("repairtime =", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeNotEqualTo(Date value) {
            addCriterion("repairtime <>", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeGreaterThan(Date value) {
            addCriterion("repairtime >", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repairtime >=", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeLessThan(Date value) {
            addCriterion("repairtime <", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeLessThanOrEqualTo(Date value) {
            addCriterion("repairtime <=", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeIn(List<Date> values) {
            addCriterion("repairtime in", values, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeNotIn(List<Date> values) {
            addCriterion("repairtime not in", values, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeBetween(Date value1, Date value2) {
            addCriterion("repairtime between", value1, value2, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeNotBetween(Date value1, Date value2) {
            addCriterion("repairtime not between", value1, value2, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRoomnumIsNull() {
            addCriterion("roomnum is null");
            return (Criteria) this;
        }

        public Criteria andRoomnumIsNotNull() {
            addCriterion("roomnum is not null");
            return (Criteria) this;
        }

        public Criteria andRoomnumEqualTo(Integer value) {
            addCriterion("roomnum =", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotEqualTo(Integer value) {
            addCriterion("roomnum <>", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumGreaterThan(Integer value) {
            addCriterion("roomnum >", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomnum >=", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumLessThan(Integer value) {
            addCriterion("roomnum <", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumLessThanOrEqualTo(Integer value) {
            addCriterion("roomnum <=", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumIn(List<Integer> values) {
            addCriterion("roomnum in", values, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotIn(List<Integer> values) {
            addCriterion("roomnum not in", values, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumBetween(Integer value1, Integer value2) {
            addCriterion("roomnum between", value1, value2, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotBetween(Integer value1, Integer value2) {
            addCriterion("roomnum not between", value1, value2, "roomnum");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontIsNull() {
            addCriterion("businesslicensefront is null");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontIsNotNull() {
            addCriterion("businesslicensefront is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontEqualTo(String value) {
            addCriterion("businesslicensefront =", value, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontNotEqualTo(String value) {
            addCriterion("businesslicensefront <>", value, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontGreaterThan(String value) {
            addCriterion("businesslicensefront >", value, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontGreaterThanOrEqualTo(String value) {
            addCriterion("businesslicensefront >=", value, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontLessThan(String value) {
            addCriterion("businesslicensefront <", value, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontLessThanOrEqualTo(String value) {
            addCriterion("businesslicensefront <=", value, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontLike(String value) {
            addCriterion("businesslicensefront like", value, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontNotLike(String value) {
            addCriterion("businesslicensefront not like", value, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontIn(List<String> values) {
            addCriterion("businesslicensefront in", values, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontNotIn(List<String> values) {
            addCriterion("businesslicensefront not in", values, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontBetween(String value1, String value2) {
            addCriterion("businesslicensefront between", value1, value2, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensefrontNotBetween(String value1, String value2) {
            addCriterion("businesslicensefront not between", value1, value2, "businesslicensefront");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackIsNull() {
            addCriterion("businesslicenseback is null");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackIsNotNull() {
            addCriterion("businesslicenseback is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackEqualTo(String value) {
            addCriterion("businesslicenseback =", value, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackNotEqualTo(String value) {
            addCriterion("businesslicenseback <>", value, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackGreaterThan(String value) {
            addCriterion("businesslicenseback >", value, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackGreaterThanOrEqualTo(String value) {
            addCriterion("businesslicenseback >=", value, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackLessThan(String value) {
            addCriterion("businesslicenseback <", value, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackLessThanOrEqualTo(String value) {
            addCriterion("businesslicenseback <=", value, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackLike(String value) {
            addCriterion("businesslicenseback like", value, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackNotLike(String value) {
            addCriterion("businesslicenseback not like", value, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackIn(List<String> values) {
            addCriterion("businesslicenseback in", values, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackNotIn(List<String> values) {
            addCriterion("businesslicenseback not in", values, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackBetween(String value1, String value2) {
            addCriterion("businesslicenseback between", value1, value2, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andBusinesslicensebackNotBetween(String value1, String value2) {
            addCriterion("businesslicenseback not between", value1, value2, "businesslicenseback");
            return (Criteria) this;
        }

        public Criteria andHotelpmsIsNull() {
            addCriterion("hotelpms is null");
            return (Criteria) this;
        }

        public Criteria andHotelpmsIsNotNull() {
            addCriterion("hotelpms is not null");
            return (Criteria) this;
        }

        public Criteria andHotelpmsEqualTo(String value) {
            addCriterion("hotelpms =", value, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsNotEqualTo(String value) {
            addCriterion("hotelpms <>", value, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsGreaterThan(String value) {
            addCriterion("hotelpms >", value, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsGreaterThanOrEqualTo(String value) {
            addCriterion("hotelpms >=", value, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsLessThan(String value) {
            addCriterion("hotelpms <", value, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsLessThanOrEqualTo(String value) {
            addCriterion("hotelpms <=", value, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsLike(String value) {
            addCriterion("hotelpms like", value, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsNotLike(String value) {
            addCriterion("hotelpms not like", value, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsIn(List<String> values) {
            addCriterion("hotelpms in", values, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsNotIn(List<String> values) {
            addCriterion("hotelpms not in", values, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsBetween(String value1, String value2) {
            addCriterion("hotelpms between", value1, value2, "hotelpms");
            return (Criteria) this;
        }

        public Criteria andHotelpmsNotBetween(String value1, String value2) {
            addCriterion("hotelpms not between", value1, value2, "hotelpms");
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

        public Criteria andIsonlineIsNull() {
            addCriterion("isonline is null");
            return (Criteria) this;
        }

        public Criteria andIsonlineIsNotNull() {
            addCriterion("isonline is not null");
            return (Criteria) this;
        }

        public Criteria andIsonlineEqualTo(String value) {
            addCriterion("isonline =", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineNotEqualTo(String value) {
            addCriterion("isonline <>", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineGreaterThan(String value) {
            addCriterion("isonline >", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineGreaterThanOrEqualTo(String value) {
            addCriterion("isonline >=", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineLessThan(String value) {
            addCriterion("isonline <", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineLessThanOrEqualTo(String value) {
            addCriterion("isonline <=", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineLike(String value) {
            addCriterion("isonline like", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineNotLike(String value) {
            addCriterion("isonline not like", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineIn(List<String> values) {
            addCriterion("isonline in", values, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineNotIn(List<String> values) {
            addCriterion("isonline not in", values, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineBetween(String value1, String value2) {
            addCriterion("isonline between", value1, value2, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineNotBetween(String value1, String value2) {
            addCriterion("isonline not between", value1, value2, "isonline");
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

        public Criteria andRetentiontimeIsNull() {
            addCriterion("retentiontime is null");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeIsNotNull() {
            addCriterion("retentiontime is not null");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeEqualTo(String value) {
            addCriterion("retentiontime =", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeNotEqualTo(String value) {
            addCriterion("retentiontime <>", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeGreaterThan(String value) {
            addCriterion("retentiontime >", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeGreaterThanOrEqualTo(String value) {
            addCriterion("retentiontime >=", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeLessThan(String value) {
            addCriterion("retentiontime <", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeLessThanOrEqualTo(String value) {
            addCriterion("retentiontime <=", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeLike(String value) {
            addCriterion("retentiontime like", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeNotLike(String value) {
            addCriterion("retentiontime not like", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeIn(List<String> values) {
            addCriterion("retentiontime in", values, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeNotIn(List<String> values) {
            addCriterion("retentiontime not in", values, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeBetween(String value1, String value2) {
            addCriterion("retentiontime between", value1, value2, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeNotBetween(String value1, String value2) {
            addCriterion("retentiontime not between", value1, value2, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeIsNull() {
            addCriterion("defaultleavetime is null");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeIsNotNull() {
            addCriterion("defaultleavetime is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeEqualTo(String value) {
            addCriterion("defaultleavetime =", value, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeNotEqualTo(String value) {
            addCriterion("defaultleavetime <>", value, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeGreaterThan(String value) {
            addCriterion("defaultleavetime >", value, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeGreaterThanOrEqualTo(String value) {
            addCriterion("defaultleavetime >=", value, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeLessThan(String value) {
            addCriterion("defaultleavetime <", value, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeLessThanOrEqualTo(String value) {
            addCriterion("defaultleavetime <=", value, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeLike(String value) {
            addCriterion("defaultleavetime like", value, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeNotLike(String value) {
            addCriterion("defaultleavetime not like", value, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeIn(List<String> values) {
            addCriterion("defaultleavetime in", values, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeNotIn(List<String> values) {
            addCriterion("defaultleavetime not in", values, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeBetween(String value1, String value2) {
            addCriterion("defaultleavetime between", value1, value2, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andDefaultleavetimeNotBetween(String value1, String value2) {
            addCriterion("defaultleavetime not between", value1, value2, "defaultleavetime");
            return (Criteria) this;
        }

        public Criteria andHotelphoneIsNull() {
            addCriterion("hotelphone is null");
            return (Criteria) this;
        }

        public Criteria andHotelphoneIsNotNull() {
            addCriterion("hotelphone is not null");
            return (Criteria) this;
        }

        public Criteria andHotelphoneEqualTo(String value) {
            addCriterion("hotelphone =", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneNotEqualTo(String value) {
            addCriterion("hotelphone <>", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneGreaterThan(String value) {
            addCriterion("hotelphone >", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("hotelphone >=", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneLessThan(String value) {
            addCriterion("hotelphone <", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneLessThanOrEqualTo(String value) {
            addCriterion("hotelphone <=", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneLike(String value) {
            addCriterion("hotelphone like", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneNotLike(String value) {
            addCriterion("hotelphone not like", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneIn(List<String> values) {
            addCriterion("hotelphone in", values, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneNotIn(List<String> values) {
            addCriterion("hotelphone not in", values, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneBetween(String value1, String value2) {
            addCriterion("hotelphone between", value1, value2, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneNotBetween(String value1, String value2) {
            addCriterion("hotelphone not between", value1, value2, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHoteltypeIsNull() {
            addCriterion("hoteltype is null");
            return (Criteria) this;
        }

        public Criteria andHoteltypeIsNotNull() {
            addCriterion("hoteltype is not null");
            return (Criteria) this;
        }

        public Criteria andHoteltypeEqualTo(Integer value) {
            addCriterion("hoteltype =", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotEqualTo(Integer value) {
            addCriterion("hoteltype <>", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeGreaterThan(Integer value) {
            addCriterion("hoteltype >", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("hoteltype >=", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeLessThan(Integer value) {
            addCriterion("hoteltype <", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeLessThanOrEqualTo(Integer value) {
            addCriterion("hoteltype <=", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeIn(List<Integer> values) {
            addCriterion("hoteltype in", values, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotIn(List<Integer> values) {
            addCriterion("hoteltype not in", values, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeBetween(Integer value1, Integer value2) {
            addCriterion("hoteltype between", value1, value2, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotBetween(Integer value1, Integer value2) {
            addCriterion("hoteltype not between", value1, value2, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andDiscodeIsNull() {
            addCriterion("discode is null");
            return (Criteria) this;
        }

        public Criteria andDiscodeIsNotNull() {
            addCriterion("discode is not null");
            return (Criteria) this;
        }

        public Criteria andDiscodeEqualTo(Integer value) {
            addCriterion("discode =", value, "discode");
            return (Criteria) this;
        }

        public Criteria andDiscodeNotEqualTo(Integer value) {
            addCriterion("discode <>", value, "discode");
            return (Criteria) this;
        }

        public Criteria andDiscodeGreaterThan(Integer value) {
            addCriterion("discode >", value, "discode");
            return (Criteria) this;
        }

        public Criteria andDiscodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("discode >=", value, "discode");
            return (Criteria) this;
        }

        public Criteria andDiscodeLessThan(Integer value) {
            addCriterion("discode <", value, "discode");
            return (Criteria) this;
        }

        public Criteria andDiscodeLessThanOrEqualTo(Integer value) {
            addCriterion("discode <=", value, "discode");
            return (Criteria) this;
        }

        public Criteria andDiscodeIn(List<Integer> values) {
            addCriterion("discode in", values, "discode");
            return (Criteria) this;
        }

        public Criteria andDiscodeNotIn(List<Integer> values) {
            addCriterion("discode not in", values, "discode");
            return (Criteria) this;
        }

        public Criteria andDiscodeBetween(Integer value1, Integer value2) {
            addCriterion("discode between", value1, value2, "discode");
            return (Criteria) this;
        }

        public Criteria andDiscodeNotBetween(Integer value1, Integer value2) {
            addCriterion("discode not between", value1, value2, "discode");
            return (Criteria) this;
        }

        public Criteria andQtphoneIsNull() {
            addCriterion("qtphone is null");
            return (Criteria) this;
        }

        public Criteria andQtphoneIsNotNull() {
            addCriterion("qtphone is not null");
            return (Criteria) this;
        }

        public Criteria andQtphoneEqualTo(String value) {
            addCriterion("qtphone =", value, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneNotEqualTo(String value) {
            addCriterion("qtphone <>", value, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneGreaterThan(String value) {
            addCriterion("qtphone >", value, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneGreaterThanOrEqualTo(String value) {
            addCriterion("qtphone >=", value, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneLessThan(String value) {
            addCriterion("qtphone <", value, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneLessThanOrEqualTo(String value) {
            addCriterion("qtphone <=", value, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneLike(String value) {
            addCriterion("qtphone like", value, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneNotLike(String value) {
            addCriterion("qtphone not like", value, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneIn(List<String> values) {
            addCriterion("qtphone in", values, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneNotIn(List<String> values) {
            addCriterion("qtphone not in", values, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneBetween(String value1, String value2) {
            addCriterion("qtphone between", value1, value2, "qtphone");
            return (Criteria) this;
        }

        public Criteria andQtphoneNotBetween(String value1, String value2) {
            addCriterion("qtphone not between", value1, value2, "qtphone");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNull() {
            addCriterion("citycode is null");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNotNull() {
            addCriterion("citycode is not null");
            return (Criteria) this;
        }

        public Criteria andCitycodeEqualTo(Integer value) {
            addCriterion("citycode =", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotEqualTo(Integer value) {
            addCriterion("citycode <>", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThan(Integer value) {
            addCriterion("citycode >", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("citycode >=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThan(Integer value) {
            addCriterion("citycode <", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThanOrEqualTo(Integer value) {
            addCriterion("citycode <=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeIn(List<Integer> values) {
            addCriterion("citycode in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotIn(List<Integer> values) {
            addCriterion("citycode not in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeBetween(Integer value1, Integer value2) {
            addCriterion("citycode between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotBetween(Integer value1, Integer value2) {
            addCriterion("citycode not between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andProvcodeIsNull() {
            addCriterion("provcode is null");
            return (Criteria) this;
        }

        public Criteria andProvcodeIsNotNull() {
            addCriterion("provcode is not null");
            return (Criteria) this;
        }

        public Criteria andProvcodeEqualTo(Integer value) {
            addCriterion("provcode =", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeNotEqualTo(Integer value) {
            addCriterion("provcode <>", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeGreaterThan(Integer value) {
            addCriterion("provcode >", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("provcode >=", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeLessThan(Integer value) {
            addCriterion("provcode <", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeLessThanOrEqualTo(Integer value) {
            addCriterion("provcode <=", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeIn(List<Integer> values) {
            addCriterion("provcode in", values, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeNotIn(List<Integer> values) {
            addCriterion("provcode not in", values, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeBetween(Integer value1, Integer value2) {
            addCriterion("provcode between", value1, value2, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("provcode not between", value1, value2, "provcode");
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