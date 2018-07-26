package com.baidu.navi.track.database;

import android.provider.BaseColumns;

public class DataBaseConstants implements BaseColumns {
    public static final String ACTION_STATE = "action_state";
    public static final int ACTION_STATE_ADD = 3;
    public static final int ACTION_STATE_DELETE = 2;
    public static final int ACTION_STATE_GET = 4;
    public static final int ACTION_STATE_NOT_EXIST = -1;
    public static final int ACTION_STATE_SYNC = 1;
    public static final int ACTION_STATE_UNSYNC = 0;
    public static final int ACTION_STATE_UPDATE = 5;
    public static final String AVG_SPEED = "avg_speed";
    public static final String CAR_CHANNEL = "car_channel";
    public static final String CAR_CUID = "car_cuid";
    public static final String CAR_VERSION = "car_version";
    public static final String CREATE_TRACK_CAR_TABLE = "CREATE TABLE IF NOT EXISTS Track_Car( guid TEXT PRIMARY KEY UNIQUE ,type TEXT ,car_cuid TEXT ,car_channel TEXT ,car_version TEXT ,isconnect INTEGER DEFAULT 0,ctime INTEGER DEFAULT 0,modifyTime INTEGER DEFAULT 0,sid TEXT ,action_state INTEGER DEFAULT 0,useid TEXT ,sign TEXT ,start_lng REAL ,start_lat REAL ,start_addr TEXT ,end_lng REAL ,end_lat REAL ,end_addr TEXT ,distance INTEGER DEFAULT 0,duration INTEGER DEFAULT 0,avg_speed REAL DEFAULT 0,maxSpeed REAL DEFAULT 0,sdcard_path TEXT )";
    public static final String CTIME = "ctime";
    public static final String DATABASE_NAME = "tracks.db";
    public static final int DATABASE_V1 = 1;
    public static final int DATABASE_V2 = 2;
    public static final int DATABASE_VERSION = 1;
    public static final String DELETE_TRACK_CAR_TABLE = "DROP TABLE IF EXISTS Track_Car";
    public static final String DISTANCE = "distance";
    public static final String DURATION = "duration";
    public static final String END_ADDR = "end_addr";
    public static final String END_LAT = "end_lat";
    public static final String END_LNG = "end_lng";
    public static final String GUID = "guid";
    private static final String INTEGER_TYPE = "INTEGER";
    public static final String ISCONNECT = "isconnect";
    public static final String MAX_SPEED = "maxSpeed";
    public static final String MODIFY_TIME = "modifyTime";
    private static final String NUMERIC_TYPE = "NUMERIC";
    private static final String PRIMARY_TEXT_KEY = "TEXT PRIMARY KEY";
    private static final String REAL_TYPE = "REAL";
    public static final String SDCARD_PATH = "sdcard_path";
    public static final String SID = "sid";
    public static final String SIGN = "sign";
    public static final String START_ADDR = "start_addr";
    public static final String START_LAT = "start_lat";
    public static final String START_LNG = "start_lng";
    public static final int SYNCING_STATE_DELETE = 12;
    public static final int SYNCING_STATE_SYNC = 11;
    public static final int SYNCING_STATE_UNSYNC = 10;
    private static final String TEXT_TYPE = "TEXT";
    public static final String TRACK_CAR_TABLE = "Track_Car";
    public static final String TYPE = "type";
    public static final String TYPE_AUTO_CRUISE = "auto_cruise";
    public static final String TYPE_CAR = "car_navi";
    public static final String TYPE_CRUISE = "cruise";
    public static final String TYPE_LOC = "loc";
    private static final String UNIQUE = "UNIQUE";
    public static final String USEID = "useid";

    public enum TRACK_TYPE {
        loc,
        car_navi,
        cruise,
        auto_cruise
    }

    public enum TrackQueryType {
        ALL,
        LOCATION,
        LINE,
        CAR,
        WALK,
        RIDE,
        RECORD
    }
}
