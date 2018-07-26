package com.baidu.platform.comapi.search;

public class SugResult implements ResultBase {
    private String[] cityid;
    private String[] distance;
    public boolean ispinyin;
    public String keyword;
    public int mResultType;
    private String[] poiname;
    private int requestId;
    private String[] subtitle;
    public int type;

    public String[] getPoiname() {
        return this.poiname;
    }

    public String getPoiname(int index) {
        if (this.poiname.length > index) {
            return this.poiname[index];
        }
        return null;
    }

    public void setPoiname(String[] poiname) {
        this.poiname = poiname;
    }

    public String getSubtitle(int index) {
        if (this.subtitle.length > index) {
            return this.subtitle[index];
        }
        return null;
    }

    public String[] getSubtitle(String[] subtitle) {
        return subtitle;
    }

    public void setSubtitle(String[] subtitle) {
        this.subtitle = subtitle;
    }

    public String[] getCityid() {
        return this.cityid;
    }

    public String getCityid(int index) {
        if (this.cityid.length > index) {
            return this.cityid[index];
        }
        return null;
    }

    public void setCityid(String[] cityid) {
        this.cityid = cityid;
    }

    public void setDistance(String[] distance) {
        this.distance = distance;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return this.requestId;
    }
}
