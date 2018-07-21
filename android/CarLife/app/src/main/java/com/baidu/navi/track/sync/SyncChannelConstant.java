package com.baidu.navi.track.sync;

public class SyncChannelConstant
{
  public static final int MSG_SYNC_DATA = 524;
  
  public static class Action
  {
    public static final String ADD = "1";
    public static final String DEL = "3";
    public static final String GET = "4";
    public static final String MODIFY = "2";
  }
  
  public static class ErrorMsg
  {
    public static final int CLEAN_DATA_ERROR = 2002;
    public static final int CLEAN_DATA_OK = 2001;
    public static final int ERROR = 2000;
    public static final int ERROR_DATABASE = 5;
    public static final int ERROR_INTERFACE_NOT_EXIST = 4;
    public static final int ERROR_INTERNAL_SERVER1 = 1;
    public static final int ERROR_INTERNAL_SERVER2 = 2;
    public static final int ERROR_INTERNAL_SERVER3 = 3;
    public static final int ERROR_PARAMETER = 6;
    public static final int ERROR_PASSPORT = 16;
    public static final int ERROR_SIGN = 7;
    public static final int ERROR_USER_NOT_EXIST = 15;
    public static final int OK = 0;
    public static final int SYNC_DATA_FILE_ERROR = 101;
    public static final int SYNC_DATA_FINISH = 100;
  }
  
  public static class ErrorNo
  {
    public static final int ERROR_CONFLICT = 101;
    public static final int ERROR_PARAMETER = 102;
    public static final int ERROR_SERVER = 103;
    public static final int OK = 100;
  }
  
  public static class Key
  {
    public static final String AUTO_SYNC = "autosync";
    public static final String BUSINESS = "business";
    public static final String IMAGE = "image";
    public static final String INTERVAL = "interval";
    public static final String PATH = "path";
    public static final String SYNC_NOW = "syncnow";
    public static final String TRACK = "track";
    public static final String UPLOAD_URL = "uploadurl";
  }
  
  public static class SyncModel
  {
    public static final int AUTO_SYNC_CLOSE = 0;
    public static final int AUTO_SYNC_OPEN = 1;
  }
  
  public static class Value
  {
    public static final int AUTO_SYNC_INTERVAL = 1;
    public static final int SYNC_NOW = 1;
    public static final int TRACK_BUSINESS = 1;
    public static final String TRACK_UPLOAD_URL = "https://vehicle.baidu.com/carlife/orbitsync";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/sync/SyncChannelConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */