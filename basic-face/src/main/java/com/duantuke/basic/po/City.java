package com.duantuke.basic.po;

import java.math.BigDecimal;

public class City {
    private Long id;

    private Long code;

    private String name;

    private Integer proid;

    private Integer sort;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String simplename;

    private String ishotcity;

    private Double range;

    private String isselect;

    private String querycityname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getSimplename() {
        return simplename;
    }

    public void setSimplename(String simplename) {
        this.simplename = simplename == null ? null : simplename.trim();
    }

    public String getIshotcity() {
        return ishotcity;
    }

    public void setIshotcity(String ishotcity) {
        this.ishotcity = ishotcity == null ? null : ishotcity.trim();
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        this.range = range;
    }

    public String getIsselect() {
        return isselect;
    }

    public void setIsselect(String isselect) {
        this.isselect = isselect == null ? null : isselect.trim();
    }

    public String getQuerycityname() {
        return querycityname;
    }

    public void setQuerycityname(String querycityname) {
        this.querycityname = querycityname == null ? null : querycityname.trim();
    }
}