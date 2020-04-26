package com.hnu.entity.publish;

import java.math.BigDecimal;
import java.util.List;

public class PublishJson {


    /**
     * u_id : 1232434233
     * lon : 22.333333332
     * lat : 23.233233333
     * nation : 中国
     * province : 广东
     * city : 广州
     * district : 白云区
     * street : ggg
     * street_number : rweeg
     * content : hello world
     * type : 0
     * goods : [{"goods_name":"口罩","num_or_price":100},{"goods_name":"口罩","num_or_price":100}]
     * range : 12
     * aging : 12
     * subtime : 2020-03-04 12:12:12
     * store_name : 默默药店
     */

    private int u_id;
    private BigDecimal lon;
    private BigDecimal lat;
    private String nation;
    private String province;
    private String city;
    private String district;
    private String street;
    private String street_number;
    private String content;
    private int type;
    private int range;
    private int aging;
    private String subtime;
    private String store_name;
    private List<GoodsBean> goods;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
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

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getAging() {
        return aging;
    }

    public void setAging(int aging) {
        this.aging = aging;
    }

    public String getSubtime() {
        return subtime;
    }

    public void setSubtime(String subtime) {
        this.subtime = subtime;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * goods_name : 口罩
         * num_or_price : 100
         */

        private String goods_name;
        private int num_or_price;

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public int getNum_or_price() {
            return num_or_price;
        }

        public void setNum_or_price(int num_or_price) {
            this.num_or_price = num_or_price;
        }
    }
}
