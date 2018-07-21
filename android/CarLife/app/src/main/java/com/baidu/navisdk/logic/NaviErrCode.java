package com.baidu.navisdk.logic;

public class NaviErrCode
{
  public static final int MSG_ANTI_GEO_POI_FAIL = 36;
  public static final int MSG_ANTI_GEO_POI_SUCC = 35;
  public static final int MSG_NAME_SEARCH_FAIL = 2;
  public static final int MSG_NAME_SEARCH_SUCC = 1;
  public static final int MSG_SEARCH_POI_LIST_NULL = 7;
  public static final int MSG_SPACE_CATALOG_SEARCH_FAIL = 6;
  public static final int MSG_SPACE_CATALOG_SEARCH_SUCC = 5;
  public static final int MSG_SPACE_KEY_SEARCH_FAIL = 4;
  public static final int MSG_SPACE_KEY_SEARCH_SUCC = 3;
  public static final int MSG_SUG_FAIL = 18;
  public static final int MSG_SUG_SUCC = 17;
  public static final int RET_BUG = -9999;
  public static final int RET_CANCELLED = -3;
  public static final int RET_ERR_APP_BASE = 6000;
  public static final int RET_ERR_ENGINE_INIT_FAILED = 31;
  public static final int RET_ERR_ENGINE_RELATED = 30;
  public static final int RET_ERR_IO_FILEIO_ERR = 22;
  public static final int RET_ERR_IO_RELATED = 20;
  public static final int RET_ERR_IO_SDCARD_ERR = 21;
  public static final int RET_ERR_LOCATION_ANTGEO_FAILED = 13;
  public static final int RET_ERR_LOCATION_GPS_CLOSED = 11;
  public static final int RET_ERR_LOCATION_LOCATE_FAILED = 12;
  public static final int RET_ERR_LOCATION_RELATED = 10;
  public static final int RET_ERR_NETWORK_CLOSED = 1;
  public static final int RET_ERR_NETWORK_JSONEXCEPTION = 3;
  public static final int RET_ERR_NETWORK_NODATA = 6;
  public static final int RET_ERR_NETWORK_RELATED = 0;
  public static final int RET_ERR_NETWORK_RETURNERR = 5;
  public static final int RET_ERR_NETWORK_RETURNNULL = 4;
  public static final int RET_ERR_NETWORK_TIMEOUT = 2;
  public static final int RET_ERR_SDK_BASE = 5000;
  public static final int RET_INIT = -10000;
  public static final int RET_OK = 0;
  public static final int RET_PAUSE = -4;
  public static final int RET_RESULT_IS_NULL = -9998;
  public static final int RET_TIMEOUT = -2;
  
  public static int getAppError(int paramInt)
  {
    return paramInt + 6000;
  }
  
  public static int getSDKError(int paramInt)
  {
    return paramInt + 5000;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/NaviErrCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */