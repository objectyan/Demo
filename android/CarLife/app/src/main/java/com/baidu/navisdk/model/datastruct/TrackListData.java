package com.baidu.navisdk.model.datastruct;

import com.baidu.navisdk.util.statistic.PerformStatItem;

public class TrackListData {
    public String mTrackEnd;
    public String mTrackKey;
    public String mTrackMileage;
    public String mTrackName;
    public String mTrackSpeed;
    public String mTrackStart;
    public String mTrackTime;
    public String mTrackTimeLength;

    public TrackListData() {
        this.mTrackStart = "";
        this.mTrackEnd = "";
        this.mTrackMileage = "";
        this.mTrackTimeLength = "";
        this.mTrackSpeed = "";
        this.mTrackTime = "";
    }

    public TrackListData(String s) {
        this.mTrackStart = "baidu ";
        this.mTrackEnd = "shenzhen ";
        this.mTrackMileage = PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_INDEX;
        this.mTrackTimeLength = "1h30min";
        this.mTrackSpeed = "50";
        this.mTrackTime = "11.23";
        this.mTrackKey = s;
    }

    public String toString() {
        return "mTrackStart=" + this.mTrackStart + ", mTrackEnd=" + this.mTrackEnd + ", mTrackMileage=" + this.mTrackMileage + ", mTrackTimeLength=" + this.mTrackTimeLength + ", mTrackSpeed=" + this.mTrackSpeed + ", mTrackTime=" + this.mTrackTime;
    }
}
