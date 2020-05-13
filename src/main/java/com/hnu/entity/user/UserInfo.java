package com.hnu.entity.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "提交的用户基本信息")
public class UserInfo {


    /**
     * u_type : 0
     * open_id : 111
     * nick_name : 用户1
     * avatar_url : im1
     * gender : 男
     * store_name : 口罩
     * m_longitude : 112
     * m_latitude : 66
     * nation : 汉
     * city : 长沙
     * province : 湖南
     * district : 岳麓区
     * street : 曲子周街道
     * street_number : 2号
     */

    @ApiModelProperty(value = "不需要填写")
    private int id;
    @ApiModelProperty(value = "用户类型")
    private int u_type;
    @ApiModelProperty(value = "openid")
    private String open_id;
    @ApiModelProperty(value = "用户名")
    private String nick_name;
    @ApiModelProperty(value = "用户的头像的地址")
    private String avatar_url;
    @ApiModelProperty(value = "用户性别")
    private String gender;
    @ApiModelProperty(value = "商店名字")
    private String store_name;
    @ApiModelProperty(value = "经度")
    private float m_longitude;
    @ApiModelProperty(value = "纬度")
    private float m_latitude;
    @ApiModelProperty(value = "国家")
    private String nation;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "区")
    private String district;
    @ApiModelProperty(value = "街道")
    private String street;
    @ApiModelProperty(value = "街道号")
    private String street_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getU_type() {
        return u_type;
    }

    public void setU_type(int u_type) {
        this.u_type = u_type;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public float getM_longitude() {
        return m_longitude;
    }

    public void setM_longitude(float m_longitude) {
        this.m_longitude = m_longitude;
    }

    public float getM_latitude() {
        return m_latitude;
    }

    public void setM_latitude(float m_latitude) {
        this.m_latitude = m_latitude;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "u_type=" + u_type +
                ", open_id=" + open_id +
                ", nick_name='" + nick_name + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", gender='" + gender + '\'' +
                ", store_name='" + store_name + '\'' +
                ", m_longitude=" + m_longitude +
                ", m_latitude=" + m_latitude +
                ", nation='" + nation + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", street_number='" + street_number + '\'' +
                '}';
    }
}
