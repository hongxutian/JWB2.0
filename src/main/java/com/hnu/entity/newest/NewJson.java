package com.hnu.entity.newest;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "新的页面请求的内容")
public class NewJson {

    @ApiModelProperty(value = "经度")
    private String longitude;
    @ApiModelProperty(value = "纬度")
    private String latitude;
    @JsonAlias(value = "search_range")
    @ApiModelProperty(value = "查询范围")
    private String searchRange;
    @JsonAlias(value = "page_items_count")
    @ApiModelProperty(value = "查询时每页的数量")
    private String pageItemsCount;
    @JsonAlias(value = "start_time")
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    @JsonAlias(value = "end_time")
    private String endTime;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getSearchRange() {
        return searchRange;
    }

    public void setSearchRange(String searchRange) {
        this.searchRange = searchRange;
    }

    public String getPageItemsCount() {
        return pageItemsCount;
    }

    public void setPageItemsCount(String pageItemsCount) {
        this.pageItemsCount = pageItemsCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "NewJson{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", searchRange='" + searchRange + '\'' +
                ", pageItemsCount='" + pageItemsCount + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
