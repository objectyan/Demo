package com.baidu.navi.track.model;

import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import java.util.List;
import java.util.Map;

public class TrackDBEvent {
    public static final int STATUS_FAIL = 0;
    public static final int STATUS_SUCCESS = 1;
    public BaseTrackModel item;
    public List<Object> list;
    public Map<String, Integer> map;
    public int number;
    public TrackQueryType queryType;
    public TrackAcmp statistic;
    public int status;
    public int token;
    public int type;

    public String toString() {
        return "TrackDBEvent [type=" + this.type + ", status=" + this.status + ", list=" + this.list + ", number=" + this.number + ", item=" + this.item + "]";
    }
}
