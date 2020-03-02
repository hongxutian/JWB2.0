package com.hnu.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NewJson {

    private String longitude;
    private String latitude;
    @JsonAlias(value = "search_range")
    private String searchRange;
    @JsonAlias(value = "page_items_count")
    private String pageItemsCount;
    @JsonAlias(value = "start_time")
    private String startTime;
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
