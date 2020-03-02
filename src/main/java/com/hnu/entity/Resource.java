package com.hnu.entity;

public class Resource {

    private long id ;
    /**  */
    private long type ;
    /**  */
    private float count ;
    /**  */
    private String goodsName ;
    /**  */
    private long mIdId ;

    /**  */
    public long getId(){
        return this.id;
    }
    /**  */
    public void setId(long id){
        this.id = id;
    }
    /**  */
    public long getType(){
        return this.type;
    }
    /**  */
    public void setType(long type){
        this.type = type;
    }
    /**  */
    public float getCount(){
        return this.count;
    }
    /**  */
    public void setCount(float count){
        this.count = count;
    }
    /**  */
    public String getGoodsName(){
        return this.goodsName;
    }
    /**  */
    public void setGoodsName(String goodsName){
        this.goodsName = goodsName;
    }
    /**  */
    public long getMIdId(){
        return this.mIdId;
    }
    /**  */
    public void setMIdId(long mIdId){
        this.mIdId = mIdId;
    }
}
