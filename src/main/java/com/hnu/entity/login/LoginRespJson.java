package com.hnu.entity.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "登录返回结果内容")
public class LoginRespJson {


    /**
     * u_type : 0
     * open_id :
     * nick_name :
     * avatar_url :
     * gender : 女
     */

    @ApiModelProperty(value = "用户类型")
    private int u_type;
    @ApiModelProperty(value = "openid")
    private String open_id;
    @ApiModelProperty(value = "用户名")
    private String nick_name;
    @ApiModelProperty(value = "用户头像的地址")
    private String avatar_url;
    @ApiModelProperty(value = "用户性别")
    private String gender;
    @ApiModelProperty(value = "登陆后访问其他接口需要的token,访问时添加在请求头参数token中")
    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
