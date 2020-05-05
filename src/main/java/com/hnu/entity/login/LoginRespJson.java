package com.hnu.entity.login;

public class LoginRespJson {


    /**
     * u_type : 0
     * open_id :
     * nick_name :
     * avatar_utl :
     * gender : 女
     */

    private int u_type;
    private String open_id;
    private String nick_name;
    private String avatar_utl;
    private String gender;
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

    public String getAvatar_utl() {
        return avatar_utl;
    }

    public void setAvatar_utl(String avatar_utl) {
        this.avatar_utl = avatar_utl;
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
