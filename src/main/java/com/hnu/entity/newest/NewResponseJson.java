package com.hnu.entity.newest;

import java.math.BigDecimal;
import java.util.List;

public class NewResponseJson {

    /**
     * avatar_url : 1
     * store_name : 口罩
     * s_lon : 12.1
     * s_lat : 22.3
     * s_nation : 111
     * s_city : 12321
     * s_province : 23213
     * s_street : 123213
     * s_street_number : 19号
     * s_content : 阿三大苏打2321
     * s_type : 0
     * s_range : 2
     * s_aging : 2
     * s_subtime : 11111111111
     * details_info : [{"type":0,"count":100,"goods_name":"口罩"},{"type":1,"count":100,"goods_name":"口罩"}]
     */

    private String avatar_url;
    private String store_name;
    private BigDecimal s_lon;
    private BigDecimal s_lat;
    private String s_nation;
    private String s_city;
    private String s_province;
    private String s_street;
    private String s_street_number;
    private String s_content;
    private int s_type;
    private int s_range;
    private int s_aging;
    private String s_subtime;
    private List<DetailsInfoBean> details_info;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
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

    public String getS_subtime() {
        return s_subtime;
    }

    public void setS_subtime(String s_subtime) {
        this.s_subtime = s_subtime;
    }

    public List<DetailsInfoBean> getDetails_info() {
        return details_info;
    }

    public void setDetails_info(List<DetailsInfoBean> details_info) {
        this.details_info = details_info;
    }

    public static class DetailsInfoBean {
        /**
         * type : 0
         * count : 100
         * goods_name : 口罩
         */

        private int type;
        private int count;
        private String goods_name;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }
    }
}
