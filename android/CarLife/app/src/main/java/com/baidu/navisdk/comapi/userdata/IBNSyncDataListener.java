package com.baidu.navisdk.comapi.userdata;

public abstract interface IBNSyncDataListener
{
  public static final int FAV_POI_SYNC_RESULT_BDUSS = 1;
  public static final int FAV_POI_SYNC_RESULT_FAILED = 5;
  public static final int FAV_POI_SYNC_RESULT_FULL = 3;
  public static final int FAV_POI_SYNC_RESULT_RELOGIN = 4;
  public static final int FAV_POI_SYNC_RESULT_SUCCESS = 2;
  
  public abstract void onSyncFavPoiResult(int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/userdata/IBNSyncDataListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */