package com.baidu.navi.favorite.model;

public class FamilyAndCompanyRequestModel {
    private String authId;
    private String bduss;
    private String ctime;
    private String data;
    private String ofmt;
    private String rt;
    private String sign;

    public String getRt() {
        return this.rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getCtime() {
        return this.ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getAuthId() {
        return this.authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBduss() {
        return this.bduss;
    }

    public void setBduss(String bduss) {
        this.bduss = bduss;
    }

    public String getOfmt() {
        return this.ofmt;
    }

    public void setOfmt(String ofmt) {
        this.ofmt = ofmt;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
