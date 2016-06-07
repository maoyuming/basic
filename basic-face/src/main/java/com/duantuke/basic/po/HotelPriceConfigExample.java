package com.duantuke.basic.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelPriceConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public HotelPriceConfigExample() {
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

        public Criteria andHotelPriceConfigIdIsNull() {
            addCriterion("hotel_price_config_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdIsNotNull() {
            addCriterion("hotel_price_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdEqualTo(Long value) {
            addCriterion("hotel_price_config_id =", value, "hotelPriceConfigId");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdNotEqualTo(Long value) {
            addCriterion("hotel_price_config_id <>", value, "hotelPriceConfigId");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdGreaterThan(Long value) {
            addCriterion("hotel_price_config_id >", value, "hotelPriceConfigId");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hotel_price_config_id >=", value, "hotelPriceConfigId");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdLessThan(Long value) {
            addCriterion("hotel_price_config_id <", value, "hotelPriceConfigId");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdLessThanOrEqualTo(Long value) {
            addCriterion("hotel_price_config_id <=", value, "hotelPriceConfigId");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdIn(List<Long> values) {
            addCriterion("hotel_price_config_id in", values, "hotelPriceConfigId");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdNotIn(List<Long> values) {
            addCriterion("hotel_price_config_id not in", values, "hotelPriceConfigId");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdBetween(Long value1, Long value2) {
            addCriterion("hotel_price_config_id between", value1, value2, "hotelPriceConfigId");
            return (Criteria) this;
        }

        public Criteria andHotelPriceConfigIdNotBetween(Long value1, Long value2) {
            addCriterion("hotel_price_config_id not between", value1, value2, "hotelPriceConfigId");
            return (Criteria) this;
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

        public Criteria andRackIsNull() {
            addCriterion("rack is null");
            return (Criteria) this;
        }

        public Criteria andRackIsNotNull() {
            addCriterion("rack is not null");
            return (Criteria) this;
        }

        public Criteria andRackEqualTo(Double value) {
            addCriterion("rack =", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackNotEqualTo(Double value) {
            addCriterion("rack <>", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackGreaterThan(Double value) {
            addCriterion("rack >", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackGreaterThanOrEqualTo(Double value) {
            addCriterion("rack >=", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackLessThan(Double value) {
            addCriterion("rack <", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackLessThanOrEqualTo(Double value) {
            addCriterion("rack <=", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackIn(List<Double> values) {
            addCriterion("rack in", values, "rack");
            return (Criteria) this;
        }

        public Criteria andRackNotIn(List<Double> values) {
            addCriterion("rack not in", values, "rack");
            return (Criteria) this;
        }

        public Criteria andRackBetween(Double value1, Double value2) {
            addCriterion("rack between", value1, value2, "rack");
            return (Criteria) this;
        }

        public Criteria andRackNotBetween(Double value1, Double value2) {
            addCriterion("rack not between", value1, value2, "rack");
            return (Criteria) this;
        }

        public Criteria andDailyIsNull() {
            addCriterion("daily is null");
            return (Criteria) this;
        }

        public Criteria andDailyIsNotNull() {
            addCriterion("daily is not null");
            return (Criteria) this;
        }

        public Criteria andDailyEqualTo(Double value) {
            addCriterion("daily =", value, "daily");
            return (Criteria) this;
        }

        public Criteria andDailyNotEqualTo(Double value) {
            addCriterion("daily <>", value, "daily");
            return (Criteria) this;
        }

        public Criteria andDailyGreaterThan(Double value) {
            addCriterion("daily >", value, "daily");
            return (Criteria) this;
        }

        public Criteria andDailyGreaterThanOrEqualTo(Double value) {
            addCriterion("daily >=", value, "daily");
            return (Criteria) this;
        }

        public Criteria andDailyLessThan(Double value) {
            addCriterion("daily <", value, "daily");
            return (Criteria) this;
        }

        public Criteria andDailyLessThanOrEqualTo(Double value) {
            addCriterion("daily <=", value, "daily");
            return (Criteria) this;
        }

        public Criteria andDailyIn(List<Double> values) {
            addCriterion("daily in", values, "daily");
            return (Criteria) this;
        }

        public Criteria andDailyNotIn(List<Double> values) {
            addCriterion("daily not in", values, "daily");
            return (Criteria) this;
        }

        public Criteria andDailyBetween(Double value1, Double value2) {
            addCriterion("daily between", value1, value2, "daily");
            return (Criteria) this;
        }

        public Criteria andDailyNotBetween(Double value1, Double value2) {
            addCriterion("daily not between", value1, value2, "daily");
            return (Criteria) this;
        }

        public Criteria andWeekendIsNull() {
            addCriterion("weekend is null");
            return (Criteria) this;
        }

        public Criteria andWeekendIsNotNull() {
            addCriterion("weekend is not null");
            return (Criteria) this;
        }

        public Criteria andWeekendEqualTo(Double value) {
            addCriterion("weekend =", value, "weekend");
            return (Criteria) this;
        }

        public Criteria andWeekendNotEqualTo(Double value) {
            addCriterion("weekend <>", value, "weekend");
            return (Criteria) this;
        }

        public Criteria andWeekendGreaterThan(Double value) {
            addCriterion("weekend >", value, "weekend");
            return (Criteria) this;
        }

        public Criteria andWeekendGreaterThanOrEqualTo(Double value) {
            addCriterion("weekend >=", value, "weekend");
            return (Criteria) this;
        }

        public Criteria andWeekendLessThan(Double value) {
            addCriterion("weekend <", value, "weekend");
            return (Criteria) this;
        }

        public Criteria andWeekendLessThanOrEqualTo(Double value) {
            addCriterion("weekend <=", value, "weekend");
            return (Criteria) this;
        }

        public Criteria andWeekendIn(List<Double> values) {
            addCriterion("weekend in", values, "weekend");
            return (Criteria) this;
        }

        public Criteria andWeekendNotIn(List<Double> values) {
            addCriterion("weekend not in", values, "weekend");
            return (Criteria) this;
        }

        public Criteria andWeekendBetween(Double value1, Double value2) {
            addCriterion("weekend between", value1, value2, "weekend");
            return (Criteria) this;
        }

        public Criteria andWeekendNotBetween(Double value1, Double value2) {
            addCriterion("weekend not between", value1, value2, "weekend");
            return (Criteria) this;
        }

        public Criteria andRackTypeIsNull() {
            addCriterion("rack_type is null");
            return (Criteria) this;
        }

        public Criteria andRackTypeIsNotNull() {
            addCriterion("rack_type is not null");
            return (Criteria) this;
        }

        public Criteria andRackTypeEqualTo(Short value) {
            addCriterion("rack_type =", value, "rackType");
            return (Criteria) this;
        }

        public Criteria andRackTypeNotEqualTo(Short value) {
            addCriterion("rack_type <>", value, "rackType");
            return (Criteria) this;
        }

        public Criteria andRackTypeGreaterThan(Short value) {
            addCriterion("rack_type >", value, "rackType");
            return (Criteria) this;
        }

        public Criteria andRackTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("rack_type >=", value, "rackType");
            return (Criteria) this;
        }

        public Criteria andRackTypeLessThan(Short value) {
            addCriterion("rack_type <", value, "rackType");
            return (Criteria) this;
        }

        public Criteria andRackTypeLessThanOrEqualTo(Short value) {
            addCriterion("rack_type <=", value, "rackType");
            return (Criteria) this;
        }

        public Criteria andRackTypeIn(List<Short> values) {
            addCriterion("rack_type in", values, "rackType");
            return (Criteria) this;
        }

        public Criteria andRackTypeNotIn(List<Short> values) {
            addCriterion("rack_type not in", values, "rackType");
            return (Criteria) this;
        }

        public Criteria andRackTypeBetween(Short value1, Short value2) {
            addCriterion("rack_type between", value1, value2, "rackType");
            return (Criteria) this;
        }

        public Criteria andRackTypeNotBetween(Short value1, Short value2) {
            addCriterion("rack_type not between", value1, value2, "rackType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeIsNull() {
            addCriterion("daily_type is null");
            return (Criteria) this;
        }

        public Criteria andDailyTypeIsNotNull() {
            addCriterion("daily_type is not null");
            return (Criteria) this;
        }

        public Criteria andDailyTypeEqualTo(Short value) {
            addCriterion("daily_type =", value, "dailyType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeNotEqualTo(Short value) {
            addCriterion("daily_type <>", value, "dailyType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeGreaterThan(Short value) {
            addCriterion("daily_type >", value, "dailyType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("daily_type >=", value, "dailyType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeLessThan(Short value) {
            addCriterion("daily_type <", value, "dailyType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeLessThanOrEqualTo(Short value) {
            addCriterion("daily_type <=", value, "dailyType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeIn(List<Short> values) {
            addCriterion("daily_type in", values, "dailyType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeNotIn(List<Short> values) {
            addCriterion("daily_type not in", values, "dailyType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeBetween(Short value1, Short value2) {
            addCriterion("daily_type between", value1, value2, "dailyType");
            return (Criteria) this;
        }

        public Criteria andDailyTypeNotBetween(Short value1, Short value2) {
            addCriterion("daily_type not between", value1, value2, "dailyType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeIsNull() {
            addCriterion("weekend_type is null");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeIsNotNull() {
            addCriterion("weekend_type is not null");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeEqualTo(Short value) {
            addCriterion("weekend_type =", value, "weekendType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeNotEqualTo(Short value) {
            addCriterion("weekend_type <>", value, "weekendType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeGreaterThan(Short value) {
            addCriterion("weekend_type >", value, "weekendType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("weekend_type >=", value, "weekendType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeLessThan(Short value) {
            addCriterion("weekend_type <", value, "weekendType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeLessThanOrEqualTo(Short value) {
            addCriterion("weekend_type <=", value, "weekendType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeIn(List<Short> values) {
            addCriterion("weekend_type in", values, "weekendType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeNotIn(List<Short> values) {
            addCriterion("weekend_type not in", values, "weekendType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeBetween(Short value1, Short value2) {
            addCriterion("weekend_type between", value1, value2, "weekendType");
            return (Criteria) this;
        }

        public Criteria andWeekendTypeNotBetween(Short value1, Short value2) {
            addCriterion("weekend_type not between", value1, value2, "weekendType");
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