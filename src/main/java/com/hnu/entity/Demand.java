package com.hnu.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;
import java.util.Date;

public class Demand {

    @JsonAlias(value = "u_id")
    private int uId;
    @JsonAlias(value = "s_lon")
    private BigDecimal sLon;
    @JsonAlias(value = "s_lat")
    private BigDecimal sLat;
    @JsonAlias(value = "s_nation")
    private String sNation;
    @JsonAlias(value = "s_city")
    private String sCity;
    @JsonAlias(value = "s_province")
    private String sProvince;
    @JsonAlias(value = "s_district")
    private String sDistrict;
    @JsonAlias(value = "s_street")
    private String sStreet;
    @JsonAlias(value = "s_street_number")
    private String sStreetNumber;
    @JsonAlias(value = "s_content")
    private String sContent;
    @JsonAlias(value = "s_type")
    private int sType;
    @JsonAlias(value = "s_range")
    private int sRange;
    @JsonAlias(value = "s_aging")
    private int sAging;
    @JsonAlias(value = "s_subtime")
    private Date sSubtime;
    @JsonAlias(value = "store_name")
    private String storeName;
    @JsonAlias(value = "u_id_id")
    private int uIdId; //外键链接的对象

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public BigDecimal getsLon() {
        return sLon;
    }

    public void setsLon(BigDecimal sLon) {
        this.sLon = sLon;
    }

    public BigDecimal getsLat() {
        return sLat;
    }

    public void setsLat(BigDecimal sLat) {
        this.sLat = sLat;
    }

    public String getsNation() {
        return sNation;
    }

    public void setsNation(String sNation) {
        this.sNation = sNation;
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public String getsProvince() {
        return sProvince;
    }

    public void setsProvince(String sProvince) {
        this.sProvince = sProvince;
    }

    public String getsDistrict() {
        return sDistrict;
    }

    public void setsDistrict(String sDistrict) {
        this.sDistrict = sDistrict;
    }

    public String getsStreet() {
        return sStreet;
    }

    public void setsStreet(String sStreet) {
        this.sStreet = sStreet;
    }

    public String getsStreetNumber() {
        return sStreetNumber;
    }

    public void setsStreetNumber(String sStreetNumber) {
        this.sStreetNumber = sStreetNumber;
    }

    public String getsContent() {
        return sContent;
    }

    public void setsContent(String sContent) {
        this.sContent = sContent;
    }

    public int getsType() {
        return sType;
    }

    public void setsType(int sType) {
        this.sType = sType;
    }

    public int getsRange() {
        return sRange;
    }

    public void setsRange(int sRange) {
        this.sRange = sRange;
    }

    public int getsAging() {
        return sAging;
    }

    public void setsAging(int sAging) {
        this.sAging = sAging;
    }

    public Date getsSubtime() {
        return sSubtime;
    }

    public void setsSubtime(Date sSubtime) {
        this.sSubtime = sSubtime;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getuIdId() {
        return uIdId;
    }

    public void setuIdId(int uIdId) {
        this.uIdId = uIdId;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "u_id=" + uId +
                ", s_lon=" + sLon +
                ", s_lat=" + sLat +
                ", s_nation='" + sNation + '\'' +
                ", s_city='" + sCity + '\'' +
                ", s_province='" + sProvince + '\'' +
                ", s_district='" + sDistrict + '\'' +
                ", s_street='" + sStreet + '\'' +
                ", s_street_number='" + sStreetNumber + '\'' +
                ", s_content='" + sContent + '\'' +
                ", s_type=" + sType +
                ", s_range=" + sRange +
                ", s_aging=" + sAging +
                ", s_subtime=" + sSubtime +
                ", store_name='" + storeName + '\'' +
                ", u_id_id=" + uIdId +
                '}';
    }
}