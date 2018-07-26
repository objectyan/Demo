package com.baidu.platform.comapi.search;

import com.baidu.platform.comapi.basestruct.Point;

public class SuggestionHistoryInfo {
    private String addword = "";
    private String bid = "";
    private String fbid = "";
    public String l1c1Tag;
    public String l1c2;
    public String l1c3;
    private Point point;
    public String searchQuery;
    private int subNodeType = -1;
    private String subtitle = "";
    private String title = "";
    private int type = Integer.MIN_VALUE;
    private String uid = "";

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAddword() {
        return this.addword;
    }

    public void setAddword(String addword) {
        this.addword = addword;
    }

    public String getBid() {
        return this.bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getFbid() {
        return this.fbid;
    }

    public void setFbid(String fbid) {
        this.fbid = fbid;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Point getPoint() {
        return this.point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getSubNodeType() {
        return this.subNodeType;
    }

    public void setSubNodeType(int nodeType) {
        this.subNodeType = nodeType;
    }

    public void copy(SuggestionHistoryInfo o) {
        this.title = o.getTitle();
        this.subtitle = o.getSubtitle();
        this.addword = o.getAddword();
        this.bid = o.getBid();
        this.fbid = o.getFbid();
        this.type = o.getType();
        this.l1c1Tag = o.l1c1Tag;
        this.l1c2 = o.l1c2;
        this.l1c3 = o.l1c3;
        this.searchQuery = o.searchQuery;
        this.uid = o.getUid();
        this.point = o.point;
        this.subNodeType = o.subNodeType;
    }
}
