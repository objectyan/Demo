package com.baidu.navi.track.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.carlife.core.a;

public class TrackConfig
{
  private static final String MAX_TIME = "max_time";
  private static final String TOTAL_DISTANSE = "total_distanse";
  private static final String TRACK_AUTO_NAVIGATE_COLLECT = "track_auto_navigate_collect";
  private static final String TRACK_AUTO_SYNC = "track_auto_sync";
  private static final String TRACK_CONFIG = "track_pref";
  private static final String TRACK_LAST_SYNC_TIME = "track_last_sync_time";
  private static final String WEEK_DISTANSE = "week_distanse";
  private static final String WEEK_END_TIME = "week_end_time";
  private SharedPreferences mPreferences = a.a().getSharedPreferences("track_pref", 0);
  
  public static TrackConfig getInstance()
  {
    return Holder.GLOBAL_CONFIG;
  }
  
  public long getLastSyncTime()
  {
    return this.mPreferences.getLong("track_last_sync_time", 0L);
  }
  
  public int getMaxTime()
  {
    return this.mPreferences.getInt("max_time", 0);
  }
  
  public int getTotalDistanse()
  {
    return this.mPreferences.getInt("total_distanse", 0);
  }
  
  public int getWeekDistanse()
  {
    return this.mPreferences.getInt("week_distanse", 0);
  }
  
  public int getWeekEndTime()
  {
    return this.mPreferences.getInt("week_end_time", 0);
  }
  
  public boolean isOpenAutoSync()
  {
    return this.mPreferences.getBoolean("track_auto_sync", false);
  }
  
  public boolean isOpenNavigateRecord()
  {
    return this.mPreferences.getBoolean("track_auto_navigate_collect", true);
  }
  
  public void setLastSyncTime(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putLong("track_last_sync_time", paramLong);
    localEditor.commit();
  }
  
  public void setMaxTime(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putInt("max_time", paramInt);
    localEditor.commit();
  }
  
  public void setOpenAutoSync(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putBoolean("track_auto_sync", paramBoolean);
    localEditor.commit();
  }
  
  public void setOpenNavigateRecord(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putBoolean("track_auto_navigate_collect", paramBoolean);
    localEditor.commit();
  }
  
  public void setTotalDistanse(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putInt("total_distanse", paramInt);
    localEditor.commit();
  }
  
  public void setWeekDistanse(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putInt("week_distanse", paramInt);
    localEditor.commit();
  }
  
  public void setWeekEndTime(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putInt("week_end_time", paramInt);
    localEditor.commit();
  }
  
  private static class Holder
  {
    static final TrackConfig GLOBAL_CONFIG = new TrackConfig(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/common/TrackConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */