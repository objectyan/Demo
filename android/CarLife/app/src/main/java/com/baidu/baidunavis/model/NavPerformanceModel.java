package com.baidu.baidunavis.model;

import android.os.SystemClock;
import android.util.Log;

public class NavPerformanceModel
{
  private static boolean OPEN = false;
  private static String TAG = "Navi_Performance";
  private static NavPerformanceModel sInstance = null;
  private long mSearchByCircleForMapPoiResultPBStartTime = -1L;
  private long mSearchByNameForMapPoiResultPBStartTime = -1L;
  
  public static NavPerformanceModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavPerformanceModel();
    }
    return sInstance;
  }
  
  private void log(String paramString)
  {
    if (OPEN) {
      Log.e(TAG, paramString);
    }
  }
  
  public void endSearchByCircleForMapPoiResultPB()
  {
    long l = SystemClock.elapsedRealtime();
    log("spaceSearch() totalTime=" + (l - this.mSearchByCircleForMapPoiResultPBStartTime) + "ms, endTime=" + l);
  }
  
  public void endSearchByNameForMapPoiResultPB()
  {
    long l = SystemClock.elapsedRealtime();
    log("oneSearch() totalTime=" + (l - this.mSearchByNameForMapPoiResultPBStartTime) + "ms, endTime=" + l);
  }
  
  public void startSearchByCircleForMapPoiResultPB()
  {
    this.mSearchByCircleForMapPoiResultPBStartTime = SystemClock.elapsedRealtime();
    log("spaceSearch() startTime=" + this.mSearchByCircleForMapPoiResultPBStartTime);
  }
  
  public void startSearchByNameForMapPoiResultPB()
  {
    this.mSearchByNameForMapPoiResultPBStartTime = SystemClock.elapsedRealtime();
    log("oneSearch() startTime=" + this.mSearchByNameForMapPoiResultPBStartTime);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/NavPerformanceModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */