package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.util.common.LogUtil;

public class GuideStatItem
{
  private static final String TAG = GuideStatItem.class.getName();
  private static GuideStatItem instance = null;
  private long mBaseTime = 0L;
  private Bundle mDataBundle = null;
  private StringBuffer mGuideSer = new StringBuffer();
  
  private GuideStatItem()
  {
    init();
  }
  
  public static GuideStatItem getInstance()
  {
    if (instance == null) {
      instance = new GuideStatItem();
    }
    return instance;
  }
  
  private void init()
  {
    this.mBaseTime = 0L;
    this.mDataBundle = null;
  }
  
  public void add(String paramString1, String paramString2)
  {
    if (this.mBaseTime <= 0L) {
      this.mBaseTime = SystemClock.elapsedRealtime();
    }
    for (long l = 0L;; l = (SystemClock.elapsedRealtime() - this.mBaseTime) / 1000L + 1L)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString1);
      localStringBuffer.append("-");
      localStringBuffer.append(String.valueOf(l));
      if (paramString2 != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(paramString2);
      }
      if (this.mGuideSer.length() >= 1) {
        this.mGuideSer.append(":");
      }
      this.mGuideSer.append(localStringBuffer.toString());
      LogUtil.e(TAG, "add:" + localStringBuffer.toString());
      return;
    }
  }
  
  public void end()
  {
    if ((this.mGuideSer == null) || (this.mGuideSer.length() <= 0)) {
      return;
    }
    this.mDataBundle = new Bundle();
    LogUtil.e(TAG, "end():" + this.mGuideSer.toString());
    JNIStatisticsControl.sInstance.getStatisticsResult(this.mGuideSer.toString(), this.mDataBundle);
    this.mBaseTime = 0L;
  }
  
  public String getGuideStatString()
  {
    if ((this.mGuideSer == null) || (this.mGuideSer.length() <= 0)) {}
    while ((this.mDataBundle == null) || (!this.mDataBundle.containsKey("part_statics"))) {
      return null;
    }
    LogUtil.e(TAG, "getGuideStatString() PART_STATICS_KEY:" + this.mDataBundle.getString("part_statics"));
    LogUtil.e(TAG, "getGuideStatString() ALL_STATICS_KEY:" + this.mDataBundle.getString("all_statics"));
    return this.mDataBundle.getString("all_statics");
  }
  
  public void initMBaseTime()
  {
    if (this.mBaseTime <= 0L) {
      this.mBaseTime = SystemClock.elapsedRealtime();
    }
  }
  
  public static abstract interface GuideStatContants
  {
    public static final String HIGH_WAY_REMAIN_DIST_SERIALNUM = "3.4";
    public static final String RASTER_EXPAND_MAP_SERIALNUM = "3.3";
  }
  
  private static abstract interface StatResultKey
  {
    public static final String ALL_STATICS_KEY = "all_statics";
    public static final String PART_STATICS_KEY = "part_statics";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/GuideStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */