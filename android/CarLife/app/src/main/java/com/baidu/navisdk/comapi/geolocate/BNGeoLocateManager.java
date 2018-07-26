package com.baidu.navisdk.comapi.geolocate;

import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navi.location.BDLocation;
import com.baidu.navi.location.BDLocationListener;
import com.baidu.navi.location.LocationClient;
import com.baidu.navi.location.LocationClientOption;
import com.baidu.navi.protocol.model.GetPluginInfoDataStruct;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.RespTimeStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.List;

public class BNGeoLocateManager extends BNLocationManager {
    private static final int LOCATION_SCAN_SPAN = 3000;
    private static final String TAG = "Location";
    private static BNGeoLocateManager mInstance = null;
    private Context mContext;
    private BNLocationListener mLocListener;
    private int mLocType;
    private LocationClient mLocationClient;
    private LocationClientOption mOption;
    private TelephonyManager mTelephonyManager;
    private boolean mUgcInfoSet;
    private WifiManager mWifiManager;

    private class BNLocationListener implements BDLocationListener {
        private BNLocationListener() {
        }

        public void onReceiveLocation(BDLocation location) {
            if (location != null) {
                if (BNGeoLocateManager.this.mLocationClient != null && BNGeoLocateManager.this.mUgcInfoSet) {
                    if (BNGeoLocateManager.this.mIsNaviStarted) {
                        BNGeoLocateManager.this.mLocationClient.setUgcInfo("1");
                    } else {
                        BNGeoLocateManager.this.mLocationClient.setUgcInfo("0");
                    }
                    BNGeoLocateManager.this.mUgcInfoSet = false;
                }
                int locType = location.getLocType();
                String locTypeStr = BNGeoLocateManager.this.locationTypeToStr(locType);
                if (!BNGeoLocateManager.this.mIsNaviStarted || locType == 61) {
                    LocData locData = new LocData();
                    locData.type = locType;
                    if (locType == 61 || locType == 161 || locType == 66 || locType == 68) {
                        if (locType != 68 || location.isCellChangeFlag()) {
                            locData.latitude = location.getLatitude();
                            locData.longitude = location.getLongitude();
                            locData.speed = (float) (((double) location.getSpeed()) / 3.6d);
                            locData.accuracy = Math.min(2000.0f, location.getRadius());
                            locData.direction = location.getDerect();
                            locData.satellitesNum = location.getSatelliteNumber();
                            locData.altitude = location.getAltitude();
                            BNGeoLocateManager.this.mLocType = locType;
                            if (locType == 61) {
                                locData.locType = 0;
                            } else {
                                locData.locType = 1;
                            }
                            BNGeoLocateManager.this.notifyLocationChanged(locData);
                            RespTimeStatItem.getInstance().setAppLocatedTime();
                        } else {
                            return;
                        }
                    } else if (locType == 167 || locType == 67) {
                        locData = BNGeoLocateManager.this.getCurLocation();
                        locTypeStr = BNGeoLocateManager.this.locationTypeToStr(BNGeoLocateManager.this.mLocType);
                        BNGeoLocateManager.this.notifyLocationNotChanged(locData);
                    }
                    if (NavSDKDebug.sShowDebugToast) {
                        String mcc = null;
                        String mnc = null;
                        CellLocation cellloc = null;
                        List<NeighboringCellInfo> list = null;
                        NeighboringCellInfo cellinfo = null;
                        if (BNGeoLocateManager.this.mTelephonyManager != null && SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
                            String mccMnc = BNGeoLocateManager.this.mTelephonyManager.getNetworkOperator();
                            cellloc = BNGeoLocateManager.this.mTelephonyManager.getCellLocation();
                            list = BNGeoLocateManager.this.mTelephonyManager.getNeighboringCellInfo();
                            if (list.size() > 0) {
                                cellinfo = (NeighboringCellInfo) list.get(0);
                            }
                            if (mccMnc != null && mccMnc.length() >= 5) {
                                mcc = mccMnc.substring(0, 3);
                                mnc = mccMnc.substring(3, 5);
                            }
                        }
                        String bssid = null;
                        String ssid = null;
                        if (BNGeoLocateManager.this.mWifiManager != null) {
                            WifiInfo wifiInfo = BNGeoLocateManager.this.mWifiManager.getConnectionInfo();
                            if (wifiInfo != null) {
                                bssid = wifiInfo.getBSSID();
                                ssid = wifiInfo.getSSID();
                            }
                        }
                        TipTool.onCreateDebugToast(BNGeoLocateManager.this.mContext, "LocSDK recv type " + locTypeStr + ", " + locData + "\nmcc=" + mcc + " mnc=" + mnc + " cellloc=" + cellloc + " neighbor=" + list.size() + " first=" + cellinfo + "\nbssid=" + bssid + " ssid=" + ssid);
                    }
                }
            }
        }

        public void onReceivePoi(BDLocation location) {
            LogUtil.m15791e("Location", "BNLocationListener onReceivePoi: LocType " + BNGeoLocateManager.this.locationTypeToStr(location.getLocType()));
        }
    }

    private BNGeoLocateManager() {
        this.mLocationClient = null;
        this.mLocListener = new BNLocationListener();
        this.mOption = null;
        this.mLocType = 0;
        this.mUgcInfoSet = false;
        this.mOption = new LocationClientOption();
        this.mOption.setOpenGps(true);
        this.mOption.setCoorType("gcj02");
        this.mOption.setAddrType(GetPluginInfoDataStruct.KEY_DETAIL);
        this.mOption.setScanSpan(3000);
        this.mOption.setLocationNotify(true);
        this.mOption.setProdName("Baidu_navi_" + PackageUtil.strSoftWareVer);
    }

    public static synchronized BNGeoLocateManager getInstance() {
        BNGeoLocateManager bNGeoLocateManager;
        synchronized (BNGeoLocateManager.class) {
            if (mInstance == null) {
                mInstance = new BNGeoLocateManager();
            }
            bNGeoLocateManager = mInstance;
        }
        return bNGeoLocateManager;
    }

    public static synchronized void destory() {
        synchronized (BNGeoLocateManager.class) {
            if (mInstance != null) {
                mInstance.unInit();
            }
            mInstance = null;
        }
    }

    public synchronized void init(Context context) {
        LogUtil.m15791e("Location", "[LocationClient] init");
        this.mContext = context;
        if (this.mLocationClient == null && context != null) {
            this.mLocationClient = new LocationClient(context);
        }
        try {
            if (SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
                this.mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
            }
            this.mWifiManager = (WifiManager) context.getSystemService(C1981b.f6365e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        startLocate();
    }

    public synchronized void unInit() {
        LogUtil.m15791e("Location", "[LocationClient] unInit");
        stopLocate();
        this.mLocationClient = null;
    }

    private synchronized boolean startLocate() {
        boolean z = true;
        synchronized (this) {
            if (this.mLocationClient == null || this.mLocationClient.isStarted()) {
                z = false;
            } else {
                this.mLocationClient.registerLocationListener(this.mLocListener);
                this.mLocationClient.setForBaiduMap(true);
                this.mLocationClient.setLocOption(this.mOption);
                this.mLocationClient.start();
                if (NavSDKDebug.sShowDebugToast) {
                    TipTool.onCreateDebugToast(this.mContext, "LocSDK: startLocate");
                }
            }
        }
        return z;
    }

    private synchronized boolean stopLocate() {
        boolean z;
        if (this.mLocationClient == null || !this.mLocationClient.isStarted()) {
            z = false;
        } else {
            this.mLocationClient.unRegisterLocationListener(this.mLocListener);
            this.mLocationClient.stop();
            if (NavSDKDebug.sShowDebugToast) {
                TipTool.onCreateDebugToast(this.mContext, "LocSDK: stopLocate");
            }
            z = true;
        }
        return z;
    }

    public GeoPoint getLastValidLocation() {
        if (BNSysLocationManager.getInstance().isSysLocationValid()) {
            return BNSysLocationManager.getInstance().getLastValidLocation();
        }
        return super.getLastValidLocation();
    }

    public boolean isLocationValid() {
        return getCurLocation() != null && (this.mLocType == 61 || this.mLocType == 161 || this.mLocType == 66 || this.mLocType == 68);
    }

    public boolean isGPSLocationValid() {
        return getCurLocation() != null && this.mLocType == 61;
    }

    public LocData getCurLocation() {
        if (BNSysLocationManager.getInstance().isSysLocationValid()) {
            return BNSysLocationManager.getInstance().getCurLocation();
        }
        return super.getCurLocation();
    }

    public int getCurLocationType() {
        return this.mLocType;
    }

    public RoutePlanNode getCurLocationNode() {
        if (BNSysLocationManager.getInstance().isSysLocationValid()) {
            return BNSysLocationManager.getInstance().getCurLocationNode();
        }
        return super.getCurLocationNode();
    }

    private void setOptionForNavi() {
        if (this.mLocationClient != null && this.mOption != null) {
            this.mOption.setOpenGps(true);
            this.mOption.setScanSpan(86400000);
            this.mLocationClient.setLocOption(this.mOption);
        }
    }

    private void setOptionForMap() {
        if (this.mLocationClient != null && this.mOption != null) {
            this.mOption.setOpenGps(true);
            this.mOption.setScanSpan(3000);
            this.mLocationClient.setLocOption(this.mOption);
        }
    }

    public boolean isGpsEnabled() {
        if (this.mContext != null) {
            try {
                return ((LocationManager) this.mContext.getSystemService("location")).isProviderEnabled("gps");
            } catch (Exception e) {
                LogUtil.m15791e("Location", e.toString());
            }
        }
        return false;
    }

    public synchronized boolean startNaviLocate(Context context) {
        LogUtil.m15791e("Location", "[navi] startLocate");
        super.startNaviLocate(context);
        setOptionForNavi();
        setNavigationState(true);
        return true;
    }

    private synchronized void setNavigationState(boolean isNavigating) {
        this.mUgcInfoSet = true;
    }

    public synchronized void stopNaviLocate() {
        LogUtil.m15791e("Location", "[navi] stopLocate");
        super.stopNaviLocate();
        setOptionForMap();
        setNavigationState(false);
    }

    private String locationTypeToStr(int type) {
        switch (type) {
            case 0:
                return "None";
            case 61:
                return "GpsLocation";
            case 62:
                return "CriteriaException";
            case 63:
                return "NetWorkException";
            case 65:
                return "CacheLocation";
            case 66:
                return "OffLineLocation";
            case 67:
                return "OffLineLocationFail";
            case 68:
                return "OffLineLocationNetworkFail";
            case 161:
                return "NetWorkLocation";
            case 167:
                return "ServerError";
            default:
                return "UnkownType";
        }
    }

    public void updateLocation(LocData locData) {
        if (locData != null) {
            notifyLocationChanged(locData);
        }
    }
}
