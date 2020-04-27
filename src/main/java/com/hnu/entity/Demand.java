package com.hnu.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;
import java.util.Date;

public class Demand {

    private int id;
    private String avatar_url;
    private String nick_name;
    private String demand_id;
    @JsonAlias(value = "u_id")
    private int u_id;
    @JsonAlias(value = "lon")
    private BigDecimal s_lon;
    @JsonAlias(value = "lat")
    private BigDecimal s_lat;
    @JsonAlias(value = "nation")
    private String s_nation;
    @JsonAlias(value = "city")
    private String s_city;
    @JsonAlias(value = "province")
    private String s_province;
    @JsonAlias(value = "district")
    private String s_district;
    @JsonAlias(value = "street")
    private String s_street;
    @JsonAlias(value = "street_number")
    private String s_street_number;
    @JsonAlias(value = "content")
    private String s_content;
    @JsonAlias(value = "type")
    private int s_type;
    @JsonAlias(value = "range")
    private int s_range;
    @JsonAlias(value = "aging")
    private int s_aging;
    @JsonAlias(value = "subtime")
    private Date s_subtime;
    @JsonAlias(value = "store_name")
    private String store_name;
    @JsonAlias(value = "u_id_id")
    private int u_id_id; //外键链接的对象

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDemand_id() {
        return demand_id;
    }

    public void setDemand_id(String demand_id) {
        this.demand_id = demand_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public BigDecimal getS_lon() {
        return s_lon;
    }

    public void setS_lon(BigDecimal s_lon) {
        this.s_lon = s_lon;
    }

    public BigDecimal getS_lat() {
        return s_lat;
    }

    public void setS_lat(BigDecimal s_lat) {
        this.s_lat = s_lat;
    }

    public String getS_nation() {
        return s_nation;
    }

    public void setS_nation(String s_nation) {
        this.s_nation = s_nation;
    }

    public String getS_city() {
        return s_city;
    }

    public void setS_city(String s_city) {
        this.s_city = s_city;
    }

    public String getS_province() {
        return s_province;
    }

    public void setS_province(String s_province) {
        this.s_province = s_province;
    }

    public String getS_district() {
        return s_district;
    }

    public void setS_district(String s_district) {
        this.s_district = s_district;
    }

    public String getS_street() {
        return s_street;
    }

    public void setS_street(String s_street) {
        this.s_street = s_street;
    }

    public String getS_street_number() {
        return s_street_number;
    }

    public void setS_street_number(String s_street_number) {
        this.s_street_number = s_street_number;
    }

    public String getS_content() {
        return s_content;
    }

    public void setS_content(String s_content) {
        this.s_content = s_content;
    }

    public int getS_type() {
        return s_type;
    }

    public void setS_type(int s_type) {
        this.s_type = s_type;
    }

    public int getS_range() {
        return s_range;
    }

    public void setS_range(int s_range) {
        this.s_range = s_range;
    }

    public int getS_aging() {
        return s_aging;
    }

    public void setS_aging(int s_aging) {
        this.s_aging = s_aging;
    }

    public Date getS_subtime() {
        return s_subtime;
    }

    public void setS_subtime(Date s_subtime) {
        this.s_subtime = s_subtime;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public int getU_id_id() {
        return u_id_id;
    }

    public void setU_id_id(int u_id_id) {
        this.u_id_id = u_id_id;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "id=" + id +
                ", nick_name='" + nick_name + '\'' +
                ", u_id=" + u_id +
                ", s_lon=" + s_lon +
                ", s_lat=" + s_lat +
                ", s_nation='" + s_nation + '\'' +
                ", s_city='" + s_city + '\'' +
                ", s_province='" + s_province + '\'' +
                ", s_district='" + s_district + '\'' +
                ", s_street='" + s_street + '\'' +
                ", s_street_number='" + s_street_number + '\'' +
                ", s_content='" + s_content + '\'' +
                ", s_type=" + s_type +
                ", s_range=" + s_range +
                ", s_aging=" + s_aging +
                ", s_subtime=" + s_subtime +
                ", store_name='" + store_name + '\'' +
                ", u_id_id=" + u_id_id +
                '}';
    }
}