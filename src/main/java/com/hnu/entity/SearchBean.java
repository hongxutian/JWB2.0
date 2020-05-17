package com.hnu.entity;

import java.math.BigDecimal;

public class SearchBean {
    /**
     * s_lon : 112.995674000000000000000000000000
     * s_lat : 28.109192000000000000000000000000
     * s_nation : 中国
     * s_city : 长沙市
     * s_province : 湖南省
     * s_street : 五凌路
     * s_street_number : 五凌路328号
     * s_content :
     * s_type : 1
     * s_range : -1
     * s_aging : -1
     * s_subtime : 2020-02-14T13:37:10.121549
     * store_name : 口罩
     * u_id : {"id":2852,"u_type":0,"open_id":"oo9r74qc-NiEAELHJIqX4rtDeEWg","nick_name":"%E7%A7%8B%E9%A3%8E%E4%BE%9D%E6%97%A7","avatar_url":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL6RU7VccKlnp9Fkicibd3hibMVjZQibEFwx2N29FPwOSoqQmeLbzGFgiaVwm0bXxFe7X7XGNGHCozERTA/132","gender":"男","store_name":"口罩","m_longitude":"28.109173999999999438159647979774","m_latitude":"112.995670000000004051798896398395","nation":"中国","city":"长沙市","province":"湖南省","district":"天心区","street":"五凌路","street_number":"五凌路328号"}
     */

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
    private String store_name;
    private UIdBean u_id;

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

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public UIdBean getU_id() {
        return u_id;
    }

    public void setU_id(UIdBean u_id) {
        this.u_id = u_id;
    }

    public static class UIdBean {
        /**
         * id : 2852
         * u_type : 0
         * open_id : oo9r74qc-NiEAELHJIqX4rtDeEWg
         * nick_name : %E7%A7%8B%E9%A3%8E%E4%BE%9D%E6%97%A7
         * avatar_url : https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL6RU7VccKlnp9Fkicibd3hibMVjZQibEFwx2N29FPwOSoqQmeLbzGFgiaVwm0bXxFe7X7XGNGHCozERTA/132
         * gender : 男
         * store_name : 口罩
         * m_longitude : 28.109173999999999438159647979774
         * m_latitude : 112.995670000000004051798896398395
         * nation : 中国
         * city : 长沙市
         * province : 湖南省
         * district : 天心区
         * street : 五凌路
         * street_number : 五凌路328号
         */

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
}
