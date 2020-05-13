package com.hnu.entity.me;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "请求内容")
public class MeJson {


    /**
     * u_id : oo9r74szRh78aYdPi7e6trlEE8tA
     * page_items_count : 2
     * start_time : 2020-2-9 3:19:28
     * end_time : 2020-2-13 5:19:28
     */

    @ApiModelProperty(value = "用户的openid")
    private String u_id;
    @ApiModelProperty(value = "查询每页的数量")
    private String page_items_count;
    @ApiModelProperty(value = "开始时间")
    private String start_time;
    @ApiModelProperty(value = "结束时间")
    private String end_time;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getPage_items_count() {
        return page_items_count;
    }

    public void setPage_items_count(String page_items_count) {
        this.page_items_count = page_items_count;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
