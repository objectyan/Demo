package com.baidu.navisdk.util.logic;

import android.content.Context;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public abstract class BNLocationManager {
    public static final int GPS_STATUS_CLOSE = 5;
    public static final int GPS_STATUS_OPEN = 4;
    private static final String TAG = BNLocationManager.class.getSimpleName();
    private LocData mCurLocation = null;
    protected boolean mIsNaviStarted = false;
    private List<ILocationListener> mLocationListenerList = new ArrayList();
    private long mLocationUpdatedTime = 0;

    public abstract void init(Context context);

    public abstract boolean isGpsEnabled();

    public abstract void unInit();

    protected BNLocationManager() {
        NavSDKDebug.sShowDebugToast = BNSettingManager.isShowLocationEnable();
    }

    public void addLocationListener(ILocationListener listener) {
        if (listener != null) {
            synchronized (this.mLocationListenerList) {
                if (!this.mLocationListenerList.contains(listener)) {
                    this.mLocationListenerList.add(listener);
                    listener.onGpsStatusChange(isGpsEnabled(), isGpsAvailable());
                }
            }
        }
    }

    public void removeLocationListener(ILocationListener listener) {
        synchronized (this.mLocationListenerList) {
            this.mLocationListenerList.remove(listener);
        }
    }

    public void clearLocationListeners() {
        synchronized (this.mLocationListenerList) {
            this.mLocationListenerList.clear();
        }
    }

    public int getLocationListenerNum() {
        int size;
        synchronized (this.mLocationListenerList) {
            size = this.mLocationListenerList.size();
        }
        return size;
    }

    public LocData getCurLocation() {
        return this.mCurLocation;
    }

    public GeoPoint getLastValidLocation() {
        if (this.mCurLocation == null) {
            return null;
        }
        GeoPoint lastPoint = new GeoPoint();
        lastPoint.setLongitudeE6((int) (this.mCurLocation.longitude * 100000.0d));
        lastPoint.setLatitudeE6((int) (this.mCurLocation.latitude * 100000.0d));
        return lastPoint;
    }

    public RoutePlanNode getCurLocationNode() {
        GeoPoint point = getLastValidLocation();
        if (point != null) {
            return new RoutePlanNode(point, 3, null, null);
        }
        return null;
    }

    public boolean isGpsAvailable() {
        return true;
    }

    public synchronized boolean startNaviLocate(Context context) {
        LogUtil.e(TAG, "startNaviLocate");
        this.mIsNaviStarted = true;
        return true;
    }

    public synchronized void stopNaviLocate() {
        LogUtil.e(TAG, "stopNaviLocate");
        this.mIsNaviStarted = false;
    }

    private synchronized boolean startLocate() {
        return false;
    }

    private synchronized boolean stopLocate() {
        return false;
    }

    protected void notifyGpsStatusChanged(boolean gpsEnabled, boolean available) {
        synchronized (this.mLocationListenerList) {
            for (ILocationListener listener : this.mLocationListenerList) {
                if (listener != null) {
                    listener.onGpsStatusChange(gpsEnabled, available);
                }
            }
        }
    }

    protected void notifyLocationChanged(LocData locData) {
        if (locData != null) {
            this.mCurLocation = locData;
            this.mLocationUpdatedTime = System.currentTimeMillis();
            updateGeoLocateModel();
            synchronized (this.mLocationListenerList) {
                for (ILocationListener listener : this.mLocationListenerList) {
                    if (listener != null) {
                        listener.onLocationChange(this.mCurLocation);
                    }
                }
            }
        }
    }

    protected void notifyWGS84LocationChanged(LocData locData, LocData gcj02LocData) {
        if (locData != null) {
            synchronized (this.mLocationListenerList) {
                for (ILocationListener listener : this.mLocationListenerList) {
                    if (listener != null) {
                        listener.onWGS84LocationChange(locData, gcj02LocData);
                    }
                }
            }
        }
    }

    protected void notifyLocationNotChanged(LocData locData) {
        if (locData != null) {
            LogUtil.e(TAG, "notify " + locData.toString());
            synchronized (this.mLocationListenerList) {
                for (ILocationListener listener : this.mLocationListenerList) {
                    if (listener != null) {
                        listener.onLocationChange(this.mCurLocation);
                    }
                }
            }
        }
    }

    private void updateGeoLocateModel() {
        GeoLocateModel.getInstance().updateLocation(this.mCurLocation);
    }

    public long getLocationUpdatedTime() {
        return this.mLocationUpdatedTime;
    }
}
