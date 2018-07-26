package com.baidu.navi.track.model;

public class TrackDBEventType {
    public static final int TYPE_LAST_TRACK_DATA = 16;
    public static final int TYPE_LOCATION_DAYS_LIST = 19;
    public static final int TYPE_LOCATION_TRACK_BETWEEN_TIME = 20;
    public static final int TYPE_TRACK_ADD = 1;
    public static final int TYPE_TRACK_AFTER_TIME = 3;
    public static final int TYPE_TRACK_BY_STATE = 4;
    @Deprecated
    public static final int TYPE_TRACK_BY_TIME = 2;
    public static final int TYPE_TRACK_CLEAR_BY_BDUID = 12;
    public static final int TYPE_TRACK_DATA_BY_GUID = 17;
    public static final int TYPE_TRACK_DELETE_BY_GUID = 6;
    public static final int TYPE_TRACK_DELETE_BY_GUIDLIST = 11;
    @Deprecated
    public static final int TYPE_TRACK_DELETE_BY_TIME_WITH_BDUID = 13;
    @Deprecated
    public static final int TYPE_TRACK_GUID_AFTER_TIME = 9;
    public static final int TYPE_TRACK_GUID_LIST_BY_BDUID = 14;
    public static final int TYPE_TRACK_MAP_FRAGMENT = 10;
    public static final int TYPE_TRACK_MODIFY = 7;
    public static final int TYPE_TRACK_STATISTIC = 5;
    public static final int TYPE_TRACK_SYNC_STATE_BY_GUID_LIST = 18;
    public static final int TYPE_UNSYNC_TRACK_NUMBER = 8;
    public static final int TYPE_UPDATE_LOCATION_LAST_TIME = 15;
}
