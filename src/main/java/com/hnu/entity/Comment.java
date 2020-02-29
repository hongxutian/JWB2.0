package com.hnu.entity;

public class Comment {

    private int id;
    private int sdId;
    private int uId;
    private int touId;
    private String content;
    private long time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSdId() {
        return sdId;
    }

    public void setSdId(int sdId) {
        this.sdId = sdId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getTouId() {
        return touId;
    }

    public void setTouId(int touId) {
        this.touId = touId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
