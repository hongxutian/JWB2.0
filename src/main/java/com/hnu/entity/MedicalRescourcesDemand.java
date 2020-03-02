package com.hnu.entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 资源发布和请求实体类
 */
public class MedicalRescourcesDemand {

    private long id ;
    /**  */
    private BigDecimal sLon ;
    /**  */
    private BigDecimal sLat ;
    /**  */
    private String sNation ;
    /**  */
    private String sCity ;
    /**  */
    private String sProvince ;
    /**  */
    private String sDistrict ;
    /**  */
    private String sStreet ;
    /**  */
    private String sStreetNumber ;
    /**  */
    private String sContent ;
    /**  */
    private long sType ;
    /**  */
    private long sRange ;
    /**  */
    private long sAging ;
    /**  */
    private Date sSubtime ;
    /**  */
    private String storeName ;
    /**  */
    private long uIdId ;

    /**  */
    public long getId(){
        return this.id;
    }
    /**  */
    public void setId(long id){
        this.id = id;
    }
    /**  */
    public BigDecimal getSLon(){
        return this.sLon;
    }
    /**  */
    public void setSLon(BigDecimal sLon){
        this.sLon = sLon;
    }
    /**  */
    public BigDecimal getSLat(){
        return this.sLat;
    }
    /**  */
    public void setSLat(BigDecimal sLat){
        this.sLat = sLat;
    }
    /**  */
    public String getSNation(){
        return this.sNation;
    }
    /**  */
    public void setSNation(String sNation){
        this.sNation = sNation;
    }
    /**  */
    public String getSCity(){
        return this.sCity;
    }
    /**  */
    public void setSCity(String sCity){
        this.sCity = sCity;
    }
    /**  */
    public String getSProvince(){
        return this.sProvince;
    }
    /**  */
    public void setSProvince(String sProvince){
        this.sProvince = sProvince;
    }
    /**  */
    public String getSDistrict(){
        return this.sDistrict;
    }
    /**  */
    public void setSDistrict(String sDistrict){
        this.sDistrict = sDistrict;
    }
    /**  */
    public String getSStreet(){
        return this.sStreet;
    }
    /**  */
    public void setSStreet(String sStreet){
        this.sStreet = sStreet;
    }
    /**  */
    public String getSStreetNumber(){
        return this.sStreetNumber;
    }
    /**  */
    public void setSStreetNumber(String sStreetNumber){
        this.sStreetNumber = sStreetNumber;
    }
    /**  */
    public String getSContent(){
        return this.sContent;
    }
    /**  */
    public void setSContent(String sContent){
        this.sContent = sContent;
    }
    /**  */
    public long getSType(){
        return this.sType;
    }
    /**  */
    public void setSType(long sType){
        this.sType = sType;
    }
    /**  */
    public long getSRange(){
        return this.sRange;
    }
    /**  */
    public void setSRange(long sRange){
        this.sRange = sRange;
    }
    /**  */
    public long getSAging(){
        return this.sAging;
    }
    /**  */
    public void setSAging(long sAging){
        this.sAging = sAging;
    }
    /**  */
    public Date getSSubtime(){
        return this.sSubtime;
    }
    /**  */
    public void setSSubtime(Date sSubtime){
        this.sSubtime = sSubtime;
    }
    /**  */
    public String getStoreName(){
        return this.storeName;
    }
    /**  */
    public void setStoreName(String storeName){
        this.storeName = storeName;
    }
    /**  */
    public long getUIdId(){
        return this.uIdId;
    }
    /**  */
    public void setUIdId(long uIdId){
        this.uIdId = uIdId;
    }

}
