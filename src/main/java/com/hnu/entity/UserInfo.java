package com.hnu.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;

public class UserInfo {

    private int id;
    @JsonAlias(value = "u_type")
    private int uType;
    @JsonAlias(value = "open_id")
    private String openId;
    @JsonAlias(value = "nick_name")
    private String nickName;
    @JsonAlias(value = "avatar_url")
    private String avatarUrl;
    private String gender;
    private String nation;
    private String province;
    private String city;
    private String district;
    private String street;
    @JsonAlias(value = "street_number")
    private String streetNumber;
    @JsonAlias(value = "store_name")
    private String storeName;
    @JsonAlias(value = "m_longitude")
    private BigDecimal mLongitude;
    @JsonAlias(value = "m_latitude")
    private BigDecimal mLatitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuType() {
        return uType;
    }

    public void setuType(int uType) {
        this.uType = uType;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGenvdr(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(BigDecimal mLongitude) {
        this.mLongitude = mLongitude;
    }

    public BigDecimal getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(BigDecimal mLatitude) {
        this.mLatitude = mLatitude;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uType=" + uType +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", nation='" + nation + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", storeName='" + storeName + '\'' +
                ", mLongitude=" + mLongitude +
                ", mLatitude=" + mLatitude +
                '}';
    }
}
