package com.baidu.navisdk;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class BNEventManager {
    private static BNEventManager mInstance = null;
    private String TAG;
    private NaviMsgListener mNaviMsgListener;
    private ArrayList<NaviMsgListener> mNaviMsgListeners;
    private NaviPhoneStateListener mPhoneStateListener;

    public interface NaviMsgListener {
        public static final int EVENT_AVOID_TRAFFIC_EJECT = 13;
        public static final int EVENT_AVOID_TRAFFIC_SWITCH = 12;
        public static final int EVENT_AVOID_TRAFFIC_SWITCH_FAILED = 15;
        public static final int EVENT_AVOID_TRAFFIC_SWITCH_SUCCESS = 14;
        public static final int EVENT_AVOID_TRAFFIC_TIPS = 11;
        public static final int EVENT_GPS_DISMISS = 6;
        public static final int EVENT_GPS_LOCATED = 5;
        public static final int EVENT_NAVIGATING_STATE_BEGIN = 3;
        public static final int EVENT_NAVIGATING_STATE_END = 4;
        public static final int EVENT_ROUTEPLAN_BEGIN = 7;
        public static final int EVENT_ROUTEPLAN_END = 8;
        public static final int EVENT_ROUTEPLAN_FAILED = 10;
        public static final int EVENT_ROUTEPLAN_SUCCESS = 9;
        public static final int RASTERMAPTYPE_DERECTBOARD = 1;
        public static final int RASTERMAPTYPE_GRID = 2;

        void onOtherAction(int i, int i2, int i3, Object obj);

        void onRasterMapHide();

        void onRasterMapShow(int i, Bitmap bitmap, Bitmap bitmap2);

        void onRasterMapUpdate(String str, int i, String str2);

        void onRemainDistanceUpdate(CharSequence charSequence, Drawable drawable);

        void onRemainTimeUpdate(CharSequence charSequence, Drawable drawable);

        void onRoadNameUpdate(String str);

        void onRoadTurnInfoDistanceUpdate(CharSequence charSequence);

        void onRoadTurnInfoIconUpdate(Drawable drawable);

        void onSatelliteNumUpdate(int i, Drawable drawable);
    }

    public interface NaviPhoneStateListener {
        void onIdle();

        void onOffHook();

        void onRinging();
    }

    private BNEventManager() {
        this.TAG = BNEventManager.class.getSimpleName();
        this.mNaviMsgListener = null;
        this.mNaviMsgListeners = null;
        this.mPhoneStateListener = null;
        this.mNaviMsgListeners = new ArrayList();
    }

    public static BNEventManager getInstance() {
        if (mInstance == null) {
            synchronized (BNEventManager.class) {
                if (mInstance == null) {
                    mInstance = new BNEventManager();
                }
            }
        }
        return mInstance;
    }

    public void setNaviMsgListener(NaviMsgListener listener) {
        this.mNaviMsgListener = listener;
    }

    public void removeNaviMsgListener() {
        this.mNaviMsgListener = null;
    }

    public void registerNaviMsgListener(NaviMsgListener listener) {
        if (this.mNaviMsgListeners != null && listener != null) {
            synchronized (this.mNaviMsgListeners) {
                if (!this.mNaviMsgListeners.contains(listener)) {
                    this.mNaviMsgListeners.add(listener);
                }
            }
        }
    }

    public void unregisterNaviMsgListener(NaviMsgListener listener) {
        if (this.mNaviMsgListeners != null && listener != null) {
            synchronized (this.mNaviMsgListeners) {
                if (this.mNaviMsgListeners.contains(listener)) {
                    this.mNaviMsgListeners.remove(listener);
                }
            }
        }
    }

    public void onRoadTurnInfoIconUpdate(Drawable icon) {
        if (this.mNaviMsgListener != null) {
            this.mNaviMsgListener.onRoadTurnInfoIconUpdate(icon);
            LogUtil.m15791e(this.TAG, "RoadTurnInfoIcon:");
        }
        synchronized (this.mNaviMsgListeners) {
            if (this.mNaviMsgListeners != null) {
                Iterator it = this.mNaviMsgListeners.iterator();
                while (it.hasNext()) {
                    ((NaviMsgListener) it.next()).onRoadTurnInfoIconUpdate(icon);
                }
            }
        }
    }

    public void onRoadTurnInfoDistanceUpdate(CharSequence curDistance) {
        if (this.mNaviMsgListener != null) {
            this.mNaviMsgListener.onRoadTurnInfoDistanceUpdate(curDistance);
            LogUtil.m15791e(this.TAG, "RoadTurnInfoDistance: " + curDistance);
        }
        synchronized (this.mNaviMsgListeners) {
            if (this.mNaviMsgListeners != null) {
                Iterator it = this.mNaviMsgListeners.iterator();
                while (it.hasNext()) {
                    ((NaviMsgListener) it.next()).onRoadTurnInfoDistanceUpdate(curDistance);
                }
            }
        }
    }

    public void onRoadNameUpdate(String name) {
        if (this.mNaviMsgListener != null) {
            this.mNaviMsgListener.onRoadNameUpdate(name);
            LogUtil.m15791e(this.TAG, "RoadName: " + name);
        }
        synchronized (this.mNaviMsgListeners) {
            if (this.mNaviMsgListeners != null) {
                Iterator it = this.mNaviMsgListeners.iterator();
                while (it.hasNext()) {
                    ((NaviMsgListener) it.next()).onRoadNameUpdate(name);
                }
            }
        }
    }

    public void onRemainDistanceUpdate(CharSequence remainDistance, Drawable icon) {
        if (this.mNaviMsgListener != null) {
            this.mNaviMsgListener.onRemainDistanceUpdate(remainDistance, icon);
            LogUtil.m15791e(this.TAG, "RemainDistance: " + remainDistance);
        }
        synchronized (this.mNaviMsgListeners) {
            if (this.mNaviMsgListeners != null) {
                Iterator it = this.mNaviMsgListeners.iterator();
                while (it.hasNext()) {
                    ((NaviMsgListener) it.next()).onRemainDistanceUpdate(remainDistance, icon);
                }
            }
        }
    }

    public void onRemainTimeUpdate(CharSequence remainTime, Drawable icon) {
        if (this.mNaviMsgListener != null) {
            this.mNaviMsgListener.onRemainTimeUpdate(remainTime, icon);
            LogUtil.m15791e(this.TAG, "RemainTime: " + remainTime);
        }
        synchronized (this.mNaviMsgListeners) {
            if (this.mNaviMsgListeners != null) {
                Iterator it = this.mNaviMsgListeners.iterator();
                while (it.hasNext()) {
                    ((NaviMsgListener) it.next()).onRemainTimeUpdate(remainTime, icon);
                }
            }
        }
    }

    public void onSatelliteNumUpdate(int satelliteNum, Drawable icon) {
        if (this.mNaviMsgListener != null) {
            this.mNaviMsgListener.onSatelliteNumUpdate(satelliteNum, icon);
            LogUtil.m15791e(this.TAG, "SatelliteNum: " + satelliteNum);
        }
        synchronized (this.mNaviMsgListeners) {
            if (this.mNaviMsgListeners != null) {
                Iterator it = this.mNaviMsgListeners.iterator();
                while (it.hasNext()) {
                    ((NaviMsgListener) it.next()).onSatelliteNumUpdate(satelliteNum, icon);
                }
            }
        }
    }

    public void onRasterMapShow(int type, Bitmap arrowBmp, Bitmap bgBmp) {
        try {
            if (!(this.mNaviMsgListener == null || arrowBmp == null || arrowBmp.isRecycled() || bgBmp == null || bgBmp.isRecycled())) {
                this.mNaviMsgListener.onRasterMapShow(type, arrowBmp.copy(Config.ARGB_8888, true), bgBmp.copy(Config.ARGB_8888, true));
                LogUtil.m15791e(this.TAG, "RasterMapShow,type=" + type);
            }
            synchronized (this.mNaviMsgListeners) {
                if (!(this.mNaviMsgListeners == null || arrowBmp == null || arrowBmp.isRecycled() || bgBmp == null || bgBmp.isRecycled())) {
                    Bitmap arrowCopy = arrowBmp.copy(Config.ARGB_8888, true);
                    Bitmap bgCopy = bgBmp.copy(Config.ARGB_8888, true);
                    Iterator it = this.mNaviMsgListeners.iterator();
                    while (it.hasNext()) {
                        ((NaviMsgListener) it.next()).onRasterMapShow(type, arrowCopy, bgCopy);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public void onRasterMapUpdate(String remainDistance, int progress, String roadName) {
        if (this.mNaviMsgListener != null) {
            this.mNaviMsgListener.onRasterMapUpdate(remainDistance, progress, roadName);
            LogUtil.m15791e(this.TAG, "RasterMapUpdate: " + remainDistance + "-" + progress + "-" + roadName);
        }
        synchronized (this.mNaviMsgListeners) {
            if (this.mNaviMsgListeners != null) {
                Iterator it = this.mNaviMsgListeners.iterator();
                while (it.hasNext()) {
                    ((NaviMsgListener) it.next()).onRasterMapUpdate(remainDistance, progress, roadName);
                }
            }
        }
    }

    public void onRasterMapHide() {
        if (this.mNaviMsgListener != null) {
            this.mNaviMsgListener.onRasterMapHide();
            LogUtil.m15791e(this.TAG, "onRasterMapHide: ");
        }
        synchronized (this.mNaviMsgListeners) {
            if (this.mNaviMsgListeners != null) {
                Iterator it = this.mNaviMsgListeners.iterator();
                while (it.hasNext()) {
                    ((NaviMsgListener) it.next()).onRasterMapHide();
                }
            }
        }
    }

    public void onOtherAction(int type, int arg1, int arg2, Object data) {
        if (this.mNaviMsgListener != null) {
            this.mNaviMsgListener.onOtherAction(type, arg1, arg2, data);
            LogUtil.m15791e(this.TAG, "onOtherAction: type=" + type);
        }
        synchronized (this.mNaviMsgListeners) {
            if (this.mNaviMsgListeners != null) {
                Iterator it = this.mNaviMsgListeners.iterator();
                while (it.hasNext()) {
                    ((NaviMsgListener) it.next()).onOtherAction(type, arg1, arg2, data);
                }
            }
        }
    }

    public void setNaviPhoneStateListener(NaviPhoneStateListener listener) {
        this.mPhoneStateListener = listener;
    }

    public void removeNaviPhoneStateListener() {
        this.mPhoneStateListener = null;
    }

    public void onOffHook() {
        if (this.mPhoneStateListener != null) {
            this.mPhoneStateListener.onOffHook();
            LogUtil.m15791e(this.TAG, "onOffHook");
        }
    }

    public void onRinging() {
        if (this.mPhoneStateListener != null) {
            this.mPhoneStateListener.onRinging();
            LogUtil.m15791e(this.TAG, "onRinging");
        }
    }

    public void onIdle() {
        if (this.mPhoneStateListener != null) {
            this.mPhoneStateListener.onIdle();
            LogUtil.m15791e(this.TAG, "onIdle");
        }
    }
}
