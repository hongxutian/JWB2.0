package com.hnu.entity.user;

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

    private int id;
    private int u_type;
    private String open_id;
    private String nick_name;
    private String avatar_url;
    private String gender;
    private String store_name;
    private float m_longitude;
    private float m_latitude;
    private String nation;
    private String city;
    private String province;
    private String district;
    private String street;
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
