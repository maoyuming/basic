package com.duantuke.basic.po;

import java.util.Date;

public class UserToken {
    private Long tokenId;

    private Long mid;

    private Date expireTime;

    private String token;

    private Integer tokenSort;

    private Short type;

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getTokenSort() {
        return tokenSort;
    }

    public void setTokenSort(Integer tokenSort) {
        this.tokenSort = tokenSort;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }
}