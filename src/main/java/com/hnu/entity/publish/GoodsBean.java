package com.hnu.entity.publish;

public class GoodsBean {
    /**
     * goods_name : 口罩
     * num_or_price : 100
     */

    private String goods_name;
    private float num_or_price;

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public float getNum_or_price() {
        return num_or_price;
    }

    public void setNum_or_price(float num_or_price) {
        this.num_or_price = num_or_price;
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "goods_name='" + goods_name + '\'' +
                ", num_or_price=" + num_or_price +
                '}';
    }
}
