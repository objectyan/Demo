package com.baidu.navisdk.util.common;

import java.util.ArrayList;
import java.util.List;

public class AppStateUtils {
    private static AppStateUtils sInstance = null;
    private List<AppStateListener> mAppStateListener = new ArrayList();
    private boolean mIsForeground = true;
    private int mPhoneStatus = 0;

    public interface AppStateListener {
        public static final int State_Type_Fore_Back_Changed = 1;

        void onAppStateChanged(int i, int i2, int i3, Object obj);
    }

    private AppStateUtils() {
    }

    public static AppStateUtils getInstance() {
        if (sInstance == null) {
            sInstance = new AppStateUtils();
        }
        return sInstance;
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    public void setForeground(boolean isFore) {
        this.mIsForeground = isFore;
        for (int i = 0; i < this.mAppStateListener.size(); i++) {
            int i2;
            AppStateListener appStateListener = (AppStateListener) this.mAppStateListener.get(i);
            if (this.mIsForeground) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            appStateListener.onAppStateChanged(1, i2, 0, null);
        }
    }

    public void addAppStateListener(AppStateListener lis) {
        if (lis != null && !this.mAppStateListener.contains(lis)) {
            this.mAppStateListener.add(lis);
        }
    }

    public void removeAppStateListener(AppStateListener lis) {
        if (lis != null && this.mAppStateListener.contains(lis)) {
            this.mAppStateListener.remove(lis);
        }
    }

    public void setPhoneStatus(int phoneStatus) {
        this.mPhoneStatus = phoneStatus;
    }

    public int getPhoneStatus() {
        return this.mPhoneStatus;
    }
}
