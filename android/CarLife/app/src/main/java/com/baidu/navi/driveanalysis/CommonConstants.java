package com.baidu.navi.driveanalysis;

public class CommonConstants {
    public static final String COORD_TYPE = "coordType";
    public static final String CREATE_TRACK_DATA_TABLE = "CREATE TABLE IF NOT EXISTS TrackDataTable(guid TEXT PRIMARY KEY,latitude REAL,longitude REAL,coordType INTEGER,speed REAL,direction INTEGER,height REAL,radius REAL,localTime INTEGER)";
    public static final String DATABASE_NAME = "driveAnalysis.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DIRECTION = "direction";
    public static final String GUID = "guid";
    public static final String HEIGHT = "height";
    private static final String INTEGER_TYPE = "INTEGER";
    public static final String LATITUDE = "latitude";
    public static final String LOCAL_TIME = "localTime";
    public static final String LONGITUDE = "longitude";
    public static final int MAX_UPLOAD_DATA_NUM = 200;
    public static final int MAX_UPLOAD_NUM_EACH_MINUTE = 4;
    private static final String NUMERIC_TYPE = "NUMERIC";
    private static final String PRIMARY_TEXT_KEY = "TEXT PRIMARY KEY";
    public static final String RADIUS = "radius";
    private static final String REAL_TYPE = "REAL";
    public static final String SPEED = "speed";
    private static final String TEXT_TYPE = "TEXT";
    public static final String TRACK_TABLE_NAME = "TrackDataTable";
    private static final String UNIQUE = "UNIQUE";
}
