package com.baidu.navi.track.model;

public class BaseTrackModel {
    public int ctime;
    public String guid;
    public int modifyTime;
    public String sid;
    public int syncState;
    public String type;
    public String useId;

    public String toString() {
        return "BaseTrackModel [sid =" + this.sid + ", guid=" + this.guid + ", type=" + this.type + ", ctime=" + this.ctime + ", modifyTime=" + this.modifyTime + ", syncState=" + this.syncState + ", useId=" + this.useId + "]";
    }
}
