package com.hnu.entity;

import java.math.BigDecimal;

public class SearUserInforBean {

    private long id;
    private int u_type;
    private String open_id;
    private String nick_name;
    private String avatar_url;
    private String gender;
    private String store_name;
    private BigDecimal m_longitude;
    private BigDecimal m_latitude;
    private String nation;
    private String city;
    private String province;
    private String district;
    private String street;
    private String street_number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public BigDecimal getM_longitude() {
        return m_longitude;
    }

    public void setM_longitude(BigDecimal m_longitude) {
        this.m_longitude = m_longitude;
    }

    public BigDecimal getM_latitude() {
        return m_latitude;
    }

    public void setM_latitude(BigDecimal m_latitude) {
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
}
