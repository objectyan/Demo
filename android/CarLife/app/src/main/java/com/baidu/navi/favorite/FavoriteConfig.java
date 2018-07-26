package com.baidu.navi.favorite;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.carlife.core.C1157a;

public class FavoriteConfig {
    public static final boolean DEBUG = false;
    public static final String FAMILY_HAS_SYNCED_AFTER_LOGIN = "family_has_synced_after_login";
    private static final String FAVORITE_CONFIG = "favorite_pref";
    private static final String FAVORITE_HAS_SYNCED_AFTER_LOGIN = "favorite_has_synced_after_login";
    private static final String FAVORITE_LAST_SYNC_TIME = "favorite_last_sync_time";
    private SharedPreferences mPreferences;

    private static class Holder {
        static final FavoriteConfig GLOBAL_CONFIG = new FavoriteConfig();

        private Holder() {
        }
    }

    public boolean isSynced() {
        return this.mPreferences.getBoolean(FAVORITE_HAS_SYNCED_AFTER_LOGIN, false);
    }

    public void setIsSynced(boolean isSynced) {
        Editor editor = this.mPreferences.edit();
        editor.putBoolean(FAVORITE_HAS_SYNCED_AFTER_LOGIN, isSynced);
        editor.commit();
    }

    public long getLastSyncTime() {
        return this.mPreferences.getLong(FAVORITE_LAST_SYNC_TIME, 0);
    }

    public void setLastSyncTime(long time) {
        Editor editor = this.mPreferences.edit();
        editor.putLong(FAVORITE_LAST_SYNC_TIME, time);
        editor.commit();
    }

    public static FavoriteConfig getInstance() {
        return Holder.GLOBAL_CONFIG;
    }

    private FavoriteConfig() {
        this.mPreferences = C1157a.a().getSharedPreferences(FAVORITE_CONFIG, 0);
    }
}
