package com.duantuke.basic.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public CityExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Long value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Long value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Long value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Long value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Long value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Long> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Long> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Long value1, Long value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Long value1, Long value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andQueryNameIsNull() {
            addCriterion("query_name is null");
            return (Criteria) this;
        }

        public Criteria andQueryNameIsNotNull() {
            addCriterion("query_name is not null");
            return (Criteria) this;
        }

        public Criteria andQueryNameEqualTo(String value) {
            addCriterion("query_name =", value, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameNotEqualTo(String value) {
            addCriterion("query_name <>", value, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameGreaterThan(String value) {
            addCriterion("query_name >", value, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameGreaterThanOrEqualTo(String value) {
            addCriterion("query_name >=", value, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameLessThan(String value) {
            addCriterion("query_name <", value, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameLessThanOrEqualTo(String value) {
            addCriterion("query_name <=", value, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameLike(String value) {
            addCriterion("query_name like", value, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameNotLike(String value) {
            addCriterion("query_name not like", value, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameIn(List<String> values) {
            addCriterion("query_name in", values, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameNotIn(List<String> values) {
            addCriterion("query_name not in", values, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameBetween(String value1, String value2) {
            addCriterion("query_name between", value1, value2, "queryName");
            return (Criteria) this;
        }

        public Criteria andQueryNameNotBetween(String value1, String value2) {
            addCriterion("query_name not between", value1, value2, "queryName");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andProidIsNull() {
            addCriterion("proid is null");
            return (Criteria) this;
        }

        public Criteria andProidIsNotNull() {
            addCriterion("proid is not null");
            return (Criteria) this;
        }

        public Criteria andProidEqualTo(Integer value) {
            addCriterion("proid =", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotEqualTo(Integer value) {
            addCriterion("proid <>", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThan(Integer value) {
            addCriterion("proid >", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proid >=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThan(Integer value) {
            addCriterion("proid <", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThanOrEqualTo(Integer value) {
            addCriterion("proid <=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidIn(List<Integer> values) {
            addCriterion("proid in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotIn(List<Integer> values) {
            addCriterion("proid not in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidBetween(Integer value1, Integer value2) {
            addCriterion("proid between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotBetween(Integer value1, Integer value2) {
            addCriterion("proid not between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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

        public Criteria andSimplenameIsNull() {
            addCriterion("simplename is null");
            return (Criteria) this;
        }

        public Criteria andSimplenameIsNotNull() {
            addCriterion("simplename is not null");
            return (Criteria) this;
        }

        public Criteria andSimplenameEqualTo(String value) {
            addCriterion("simplename =", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameNotEqualTo(String value) {
            addCriterion("simplename <>", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameGreaterThan(String value) {
            addCriterion("simplename >", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameGreaterThanOrEqualTo(String value) {
            addCriterion("simplename >=", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameLessThan(String value) {
            addCriterion("simplename <", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameLessThanOrEqualTo(String value) {
            addCriterion("simplename <=", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameLike(String value) {
            addCriterion("simplename like", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameNotLike(String value) {
            addCriterion("simplename not like", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameIn(List<String> values) {
            addCriterion("simplename in", values, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameNotIn(List<String> values) {
            addCriterion("simplename not in", values, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameBetween(String value1, String value2) {
            addCriterion("simplename between", value1, value2, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameNotBetween(String value1, String value2) {
            addCriterion("simplename not between", value1, value2, "simplename");
            return (Criteria) this;
        }

        public Criteria andIshotcityIsNull() {
            addCriterion("ishotcity is null");
            return (Criteria) this;
        }

        public Criteria andIshotcityIsNotNull() {
            addCriterion("ishotcity is not null");
            return (Criteria) this;
        }

        public Criteria andIshotcityEqualTo(String value) {
            addCriterion("ishotcity =", value, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityNotEqualTo(String value) {
            addCriterion("ishotcity <>", value, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityGreaterThan(String value) {
            addCriterion("ishotcity >", value, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityGreaterThanOrEqualTo(String value) {
            addCriterion("ishotcity >=", value, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityLessThan(String value) {
            addCriterion("ishotcity <", value, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityLessThanOrEqualTo(String value) {
            addCriterion("ishotcity <=", value, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityLike(String value) {
            addCriterion("ishotcity like", value, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityNotLike(String value) {
            addCriterion("ishotcity not like", value, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityIn(List<String> values) {
            addCriterion("ishotcity in", values, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityNotIn(List<String> values) {
            addCriterion("ishotcity not in", values, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityBetween(String value1, String value2) {
            addCriterion("ishotcity between", value1, value2, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andIshotcityNotBetween(String value1, String value2) {
            addCriterion("ishotcity not between", value1, value2, "ishotcity");
            return (Criteria) this;
        }

        public Criteria andRangeIsNull() {
            addCriterion("range is null");
            return (Criteria) this;
        }

        public Criteria andRangeIsNotNull() {
            addCriterion("range is not null");
            return (Criteria) this;
        }

        public Criteria andRangeEqualTo(Double value) {
            addCriterion("range =", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotEqualTo(Double value) {
            addCriterion("range <>", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeGreaterThan(Double value) {
            addCriterion("range >", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeGreaterThanOrEqualTo(Double value) {
            addCriterion("range >=", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeLessThan(Double value) {
            addCriterion("range <", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeLessThanOrEqualTo(Double value) {
            addCriterion("range <=", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeIn(List<Double> values) {
            addCriterion("range in", values, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotIn(List<Double> values) {
            addCriterion("range not in", values, "range");
            return (Criteria) this;
        }

        public Criteria andRangeBetween(Double value1, Double value2) {
            addCriterion("range between", value1, value2, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotBetween(Double value1, Double value2) {
            addCriterion("range not between", value1, value2, "range");
            return (Criteria) this;
        }

        public Criteria andIsselectIsNull() {
            addCriterion("isselect is null");
            return (Criteria) this;
        }

        public Criteria andIsselectIsNotNull() {
            addCriterion("isselect is not null");
            return (Criteria) this;
        }

        public Criteria andIsselectEqualTo(String value) {
            addCriterion("isselect =", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectNotEqualTo(String value) {
            addCriterion("isselect <>", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectGreaterThan(String value) {
            addCriterion("isselect >", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectGreaterThanOrEqualTo(String value) {
            addCriterion("isselect >=", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectLessThan(String value) {
            addCriterion("isselect <", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectLessThanOrEqualTo(String value) {
            addCriterion("isselect <=", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectLike(String value) {
            addCriterion("isselect like", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectNotLike(String value) {
            addCriterion("isselect not like", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectIn(List<String> values) {
            addCriterion("isselect in", values, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectNotIn(List<String> values) {
            addCriterion("isselect not in", values, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectBetween(String value1, String value2) {
            addCriterion("isselect between", value1, value2, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectNotBetween(String value1, String value2) {
            addCriterion("isselect not between", value1, value2, "isselect");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameIsNull() {
            addCriterion("querycityname is null");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameIsNotNull() {
            addCriterion("querycityname is not null");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameEqualTo(String value) {
            addCriterion("querycityname =", value, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameNotEqualTo(String value) {
            addCriterion("querycityname <>", value, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameGreaterThan(String value) {
            addCriterion("querycityname >", value, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameGreaterThanOrEqualTo(String value) {
            addCriterion("querycityname >=", value, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameLessThan(String value) {
            addCriterion("querycityname <", value, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameLessThanOrEqualTo(String value) {
            addCriterion("querycityname <=", value, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameLike(String value) {
            addCriterion("querycityname like", value, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameNotLike(String value) {
            addCriterion("querycityname not like", value, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameIn(List<String> values) {
            addCriterion("querycityname in", values, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameNotIn(List<String> values) {
            addCriterion("querycityname not in", values, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameBetween(String value1, String value2) {
            addCriterion("querycityname between", value1, value2, "querycityname");
            return (Criteria) this;
        }

        public Criteria andQuerycitynameNotBetween(String value1, String value2) {
            addCriterion("querycityname not between", value1, value2, "querycityname");
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