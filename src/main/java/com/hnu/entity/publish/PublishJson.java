package com.hnu.entity.publish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;
@ApiModel
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

    @ApiModelProperty(value = "用户的openid")
    private String u_id;
    @ApiModelProperty(value = "经度")
    private BigDecimal lon;
    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;
    @ApiModelProperty(value = "国家")
    private String nation;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区/县")
    private String district;
    @ApiModelProperty(value = "街道")
    private String street;
    @ApiModelProperty(value = "街道号")
    private String street_number;
    @ApiModelProperty(value = "发布内容的描述")
    private String content;
    private String demand_id;
    @ApiModelProperty(value = "发布的类型，0发布医疗资源需求信息，1发布医疗资源信息，2发布服务资源需求信息，3发布服务资源信息")
    private int type;
    @ApiModelProperty(value = "有效范围")
    private int range;
    @ApiModelProperty(value = "有效时间")
    private int aging;
    @ApiModelProperty(value = "提交时间",example = "2020-03-23 15:23:23")
    private String subtime;
    @ApiModelProperty(value = "商店或社区名，发布需求时不需要，发布医疗资源时是商店名，发布服务资源时是社区名")
    private String store_name;
    @ApiModelProperty(value = "发布的资源内容")
    private List<GoodsBean> goods;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
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

    public String getDemand_id() {
        return demand_id;
    }

    public void setDemand_id(String demand_id) {
        this.demand_id = demand_id;
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

    @Override
    public String toString() {
        return "PublishJson{" +
                "u_id='" + u_id + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", nation='" + nation + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", street_number='" + street_number + '\'' +
                ", content='" + content + '\'' +
                ", demand_id='" + demand_id + '\'' +
                ", type=" + type +
                ", range=" + range +
                ", aging=" + aging +
                ", subtime='" + subtime + '\'' +
                ", store_name='" + store_name + '\'' +
                ", goods=" + goods +
                '}';
    }
}
