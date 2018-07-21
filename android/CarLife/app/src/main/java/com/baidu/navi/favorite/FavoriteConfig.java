package com.baidu.navi.favorite;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.carlife.core.a;

public class FavoriteConfig
{
  public static final boolean DEBUG = false;
  public static final String FAMILY_HAS_SYNCED_AFTER_LOGIN = "family_has_synced_after_login";
  private static final String FAVORITE_CONFIG = "favorite_pref";
  private static final String FAVORITE_HAS_SYNCED_AFTER_LOGIN = "favorite_has_synced_after_login";
  private static final String FAVORITE_LAST_SYNC_TIME = "favorite_last_sync_time";
  private SharedPreferences mPreferences = a.a().getSharedPreferences("favorite_pref", 0);
  
  public static FavoriteConfig getInstance()
  {
    return Holder.GLOBAL_CONFIG;
  }
  
  public long getLastSyncTime()
  {
    return this.mPreferences.getLong("favorite_last_sync_time", 0L);
  }
  
  public boolean isSynced()
  {
    return this.mPreferences.getBoolean("favorite_has_synced_after_login", false);
  }
  
  public void setIsSynced(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putBoolean("favorite_has_synced_after_login", paramBoolean);
    localEditor.commit();
  }
  
  public void setLastSyncTime(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putLong("favorite_last_sync_time", paramLong);
    localEditor.commit();
  }
  
  private static class Holder
  {
    static final FavoriteConfig GLOBAL_CONFIG = new FavoriteConfig(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/FavoriteConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */