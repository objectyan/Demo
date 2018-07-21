package com.baidu.navi.track.datashop;

import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.model.TrackAcmp;
import java.util.List;

public class TrackShopEvent
{
  public static final int EVENT_TRACK_ADD = 1;
  public static final int EVENT_TRACK_BY_TIME = 2;
  public static final int EVENT_TRACK_CALENDAR_EXPLORE = 13;
  public static final int EVENT_TRACK_CALENDAR_GET_LOCATIONS = 14;
  public static final int EVENT_TRACK_CLEAR_BY_BDUID = 12;
  public static final int EVENT_TRACK_DELETE_BY_GUID = 6;
  public static final int EVENT_TRACK_MAINLIST = 3;
  public static final int EVENT_TRACK_MAPAREA = 9;
  public static final int EVENT_TRACK_MAP_FRAGMENT = 10;
  public static final int EVENT_TRACK_MODIFY = 11;
  public static final int EVENT_TRACK_STATISTIC = 5;
  public static final int EVENT_TRACK_SYNCRECORDS = 7;
  public static final int EVENT_UNSYNC_COUNT = 8;
  public Object item;
  public List<Object> list;
  public int number;
  public TrackAcmp statistic;
  public int status = 0;
  public int token;
  public DataBaseConstants.TrackQueryType trackQueryType;
  public int type;
  
  public String toString()
  {
    return "TrackShopEvent{type=" + this.type + ", status=" + this.status + ", list=" + this.list + ", item=" + this.item + ", number=" + this.number + '}';
  }
  
  public static class TrackShopStatus
  {
    public static final int STATUS_ACCOUNT_TIMEOUT = -4;
    public static final int STATUS_DATA_NOT_EXIST = -6;
    public static final int STATUS_DB_FAIL = -2;
    public static final int STATUS_NET_FAIL = -1;
    public static final int STATUS_PARAMETER_ERROR = -5;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_UN_LOGIN = -3;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/datashop/TrackShopEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */