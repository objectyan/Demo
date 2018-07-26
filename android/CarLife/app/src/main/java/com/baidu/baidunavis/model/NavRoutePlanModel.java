package com.baidu.baidunavis.model;

import android.os.Bundle;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviEnter;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviNet;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NavRoutePlanModel {
    private static NavRoutePlanModel sInstance = null;
    public String mCarPANumber = null;
    public String mCurMrsl = "";
    private int mDriveRefTimeDuration = -1;
    private int mDriveRefTimeInterval = -1;
    private RouteNode mEndRouteNode = null;
    public int mEntry = 3;
    public Bundle mExtBundle = null;
    public boolean mIsContainsAllNodeOfflineData = false;
    public boolean mIsGPSNav = true;
    public boolean mIsRedirector = true;
    public String mLastMrsl = "";
    private long mLastestTimeSetSensor = -1;
    public long mLastestTimeToSelectRoute = -1;
    private int mMapSensorAngle = -1;
    private String mNavEnter = NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV;
    public boolean mNotBuildReady = false;
    private int mPreference = -1;
    private int mRouteInfoStatus = -1;
    public int mRoutePlanResultFailedType = -1;
    public boolean mRoutePlanResultOK = false;
    private ArrayList<ISensorChangeListener> mSensorObservers = new ArrayList();
    public boolean mStartDriv = false;
    private RouteNode mStartRouteNode = null;
    private int mStrategy = -1;
    private List<RouteNode> mViaNodes = null;
    public byte[] pbData;
    public int pbDataLen;
    public String routePlanStatistcsUrl = "";

    public float getmSensorAngle() {
        long ctime = System.currentTimeMillis();
        NavLogUtils.m3003e("", "mSensorChangeListener getmSensorAngle ctime " + ctime + ", mLastestTimeSetSensor=" + this.mLastestTimeSetSensor + ", mMapSensorAngle=" + this.mMapSensorAngle);
        if (ctime - this.mLastestTimeSetSensor <= Config.BPLUS_DELAY_TIME) {
            return (float) this.mMapSensorAngle;
        }
        return -1.0f;
    }

    public void setmMapSensorAngle(int mSensorAngle) {
        if (mSensorAngle >= 0) {
            this.mLastestTimeSetSensor = System.currentTimeMillis();
            this.mMapSensorAngle = mSensorAngle;
        }
        try {
            BNRoutePlaner.getInstance().triggerSensorAngle((double) mSensorAngle, 1.0d);
            Iterator it = this.mSensorObservers.iterator();
            while (it.hasNext()) {
                ((ISensorChangeListener) it.next()).onSensorChange(mSensorAngle);
            }
        } catch (Exception e) {
        }
    }

    public void addSensorChangeListener(ISensorChangeListener listener) {
        synchronized (this.mSensorObservers) {
            if (!this.mSensorObservers.contains(listener)) {
                this.mSensorObservers.add(listener);
            }
        }
    }

    public void removeSensorChangeListener(ISensorChangeListener listener) {
        synchronized (this.mSensorObservers) {
            this.mSensorObservers.remove(listener);
        }
    }

    private NavRoutePlanModel() {
    }

    public static NavRoutePlanModel getInstance() {
        if (sInstance == null) {
            sInstance = new NavRoutePlanModel();
        }
        return sInstance;
    }

    public int getRPNodeCount() {
        if (this.mViaNodes == null) {
            return 2;
        }
        return this.mViaNodes.size() + 2;
    }

    public String getmNavEnter() {
        return this.mNavEnter;
    }

    public void setmNavEnter(String mNavEnter) {
        this.mNavEnter = mNavEnter;
    }

    public void setStartRouteNode(RouteNode rn) {
        this.mStartRouteNode = rn;
    }

    public RouteNode getStartRouteNode() {
        return this.mStartRouteNode;
    }

    public void setExtBundle(Bundle extBundle) {
        this.mExtBundle = extBundle;
    }

    public Bundle getExtBundle() {
        return this.mExtBundle;
    }

    public void setEndRouteNode(RouteNode rn) {
        this.mEndRouteNode = rn;
    }

    public RouteNode getEndRouteNode() {
        return this.mEndRouteNode;
    }

    public void setViaNodes(List<RouteNode> viaNodes) {
        this.mViaNodes = viaNodes;
    }

    public List<RouteNode> getViaNodes() {
        return this.mViaNodes;
    }

    public void setPreference(int p) {
        this.mPreference = p;
    }

    public int getPreference() {
        return this.mPreference;
    }

    public void setRouteInfoStatus(int status) {
        this.mRouteInfoStatus = status;
    }

    public int getRouteInfoStatus() {
        return this.mRouteInfoStatus;
    }

    public void setDriveRefTime(int interval, int duration) {
        this.mDriveRefTimeInterval = interval;
        this.mDriveRefTimeDuration = duration;
    }

    public int getDriveRefTimeInterval() {
        return this.mDriveRefTimeInterval;
    }

    public int getDriveRefTimeDuration() {
        return this.mDriveRefTimeDuration;
    }

    public void setStrategy(int s) {
        this.mStrategy = s;
    }

    public String getStrategyForUserBeh() {
        if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            return NavUserBehaviourNaviNet.BEHAVIOUR_NAVI_NET_OFFLINE;
        }
        if (BNSettingManager.getPrefRoutPlanMode() == 3) {
            return NavUserBehaviourNaviNet.BEHAVIOUR_NAVI_NET_ONLINE;
        }
        if (BNSettingManager.getPrefRoutPlanMode() == 2) {
            return NavUserBehaviourNaviNet.BEHAVIOUR_NAVI_NET_OFFLINE;
        }
        return null;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public int getEntry() {
        return this.mEntry;
    }

    public void setEntry(int entry) {
        this.mEntry = entry;
    }

    public void triggerStartSensorData(float x, float y, float z) {
        try {
            BNRoutePlaner.getInstance().triggerStartSensorData(x, y, z);
        } catch (Exception e) {
        }
    }

    public boolean isEntryToCarResultScene() {
        switch (getEntry()) {
            case 4:
            case 6:
            case 7:
            case 12:
            case 20:
            case 21:
            case 23:
            case 24:
            case 25:
            case 27:
            case 29:
            case 30:
            case 33:
            case 34:
                return true;
            default:
                return false;
        }
    }
}
