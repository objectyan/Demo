package com.baidu.mapframework.location;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapframework.location.LocationChangeListener.CoordType;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navi.driveanalysis.CommonConstants;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.location.LocationMgr;
import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.baidu.platform.comapi.map.MapUtils;
import com.baidu.platform.comapi.p207a.C4755b;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationManager {
    private static final boolean DEBUG = false;
    static final String TAG = LocationManager.class.getSimpleName();
    static boolean isResumed = false;
    private static String locDataIndoorFormat = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":170,\"iconarrowfocid\":171,\"areaid\":141,\"lineid\":142}]}";
    private static String locDataIndoorFormatWithWheel = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":170,\"iconarrowfocid\":171,\"areaid\":141,\"lineid\":142},{\"ptx\":%d,\"pty\":%d,\"radius\":0,\"direction\":0,\"iconarrownor\":\"direction_wheel\",\"iconarrownorid\":54,\"iconarrowfoc\":\"direction_wheel\",\"iconarrowfocid\":54}]}";
    private static String locDataNormalFormat = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":28,\"iconarrowfocid\":29,\"areaid\":69,\"lineid\":71}]}";
    private static String locDataNormalFormatWithWalkWheel = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":347,\"iconarrowfocid\":347,\"areaid\":69,\"lineid\":71},{\"ptx\":%d,\"pty\":%d,\"radius\":0,\"direction\":0,\"iconarrownor\":\"direction_wheel\",\"iconarrownorid\":339,\"iconarrowfoc\":\"direction_wheel\",\"iconarrowfocid\":339}]}";
    private static String locDataNormalFormatWithWheel = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":28,\"iconarrowfocid\":29,\"areaid\":69,\"lineid\":71},{\"ptx\":%d,\"pty\":%d,\"radius\":0,\"direction\":0,\"iconarrownor\":\"direction_wheel\",\"iconarrownorid\":54,\"iconarrowfoc\":\"direction_wheel\",\"iconarrowfocid\":54}]}";
    private static LocData mCurLocation = new LocData();
    private static final CoordType mDefaultCoordType = CoordType.CoordType_GCJ02;
    private static LocationManager mInstance = null;
    static Set<LocationChangeListener> mLocObservers = new HashSet();
    private static LocationClientOption mOption = null;
    private static style mStyle = style.normal;
    private static LocData mTmpLocation = new LocData();
    private volatile boolean isFirstOffLocation = true;
    private volatile boolean isFirstOnLineLocation = true;
    private boolean locationStartLogRecorded = false;
    Context mContext = null;
    BMLocationListener mLocListener = null;
    private int mLocType = 0;
    volatile LocationClient mLocationClient = null;
    private volatile Thread mLocationThread;
    private LongLinkClient mLongLinkClient;
    private LongLinkDataCallback mLongLinkDataCallback;

    /* renamed from: com.baidu.mapframework.location.LocationManager$2 */
    class C35112 extends ConcurrentTask {
        C35112() {
        }

        public void run() {
            if (LocationManager.this.mLocationClient != null) {
                LocationManager.this.mLocationClient.requestHotSpotState();
            }
        }
    }

    class BMLocationListener extends BDLocationListener {

        /* renamed from: com.baidu.mapframework.location.LocationManager$BMLocationListener$2 */
        class C35132 implements LongLinkDataCallback {
            C35132() {
            }

            public boolean onReceiveData(ELongLinkStatus status, int reqId, byte[] dataBuffer, boolean isPush) {
                C2911f.b("GPSLongLinkPush", "onReceiveData:reqId:" + reqId + " status:" + status + " data: " + new String(dataBuffer));
                return true;
            }
        }

        BMLocationListener() {
        }

        public void onReceiveLocation(final BDLocation location) {
            LocationManager.this.recordLocationLog(location);
            LocationManager.this.logLocation(location);
            LooperManager.executeTask(Module.LOCATION_MODULE, new LooperTask() {
                public void run() {
                    LocationManager.this.notifiyLocation(location);
                }
            }, ScheduleConfig.forData());
        }

        public void onGPSLongLinkPushData(byte[] data, int moduleId) {
            if (data != null && data.length > 0) {
                try {
                    C2911f.b("GPSLongLinkPush", "onGPSLongLinkPushData " + moduleId + " data:" + new String(data));
                    if (LocationManager.this.mLongLinkClient == null) {
                        LocationManager.this.mLongLinkClient = LongLinkClient.create(moduleId);
                        if (LocationManager.this.mLongLinkDataCallback == null) {
                            LocationManager.this.mLongLinkDataCallback = new C35132();
                        }
                        LocationManager.this.mLongLinkClient.register(LocationManager.this.mLongLinkDataCallback);
                    }
                    ArrayList<LongLinkFileData> dataList = new ArrayList();
                    LongLinkFileData fileData = new LongLinkFileData();
                    fileData.fileName = "location.dat";
                    String fileParams = "filename=" + fileData.fileName;
                    fileData.binData = Arrays.copyOf(data, data.length);
                    dataList.add(fileData);
                    LocationManager.this.mLongLinkClient.sendFileData(fileParams, dataList);
                } catch (Exception e) {
                }
            }
        }

        public void onReceiveLocationTag(String string) {
            if (TextUtils.isEmpty(string)) {
                BMEventBus.getInstance().post(new MyLocationEvent(""));
            } else {
                BMEventBus.getInstance().post(new MyLocationEvent(string));
            }
        }

        public void onReceiveNaviModeWifiLocation(final BDLocation location) {
            HashSet<LocationChangeListener> list;
            String navName = "com.baidu.baidunavis.NavLocationManager$1";
            synchronized (LocationManager.mLocObservers) {
                list = new HashSet(LocationManager.mLocObservers);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final LocationChangeListener listener = (LocationChangeListener) it.next();
                if (navName.equals(listener.getClass().getName())) {
                    LooperManager.executeTask(Module.LOCATION_MODULE, new LooperTask() {
                        public void run() {
                            LocationManager.this.notifiyNavLocation(location, listener);
                        }
                    }, ScheduleConfig.forData());
                }
            }
        }

        public void onConnectHotSpotMessage(String var1, int var2) {
            BMEventBus.getInstance().post(new HotSpotUpdateEvent(var1, var2));
        }

        public void onLocDiagnosticMessage(int locType, int diagnosticType, String diagnosticMessage) {
            BMEventBus.getInstance().postSticky(new FailLocationEvent(locType, diagnosticType, diagnosticMessage));
        }
    }

    public static class LocData implements Cloneable {
        public float accuracy;
        public String addr;
        public double altitude;
        public String buildingId;
        public String city;
        public String cityCode;
        public CoordType coordType = CoordType.CoordType_GCJ02;
        public float direction;
        public String district;
        public String floorId;
        public int indoorState;
        public int isIbeacon;
        public boolean isIndoorMode;
        public double latitude = -1.0d;
        public double longitude = -1.0d;
        public String networkLocType;
        public String province;
        public int satellitesNum;
        public float speed;
        public int type;

        public LocData clone() {
            LocData newLoc = new LocData();
            synchronized (this) {
                newLoc.accuracy = this.accuracy;
                newLoc.direction = this.direction;
                newLoc.latitude = this.latitude;
                newLoc.longitude = this.longitude;
                newLoc.satellitesNum = this.satellitesNum;
                newLoc.speed = this.speed;
                newLoc.type = this.type;
                newLoc.coordType = this.coordType;
                newLoc.buildingId = this.buildingId;
                newLoc.floorId = this.floorId;
                newLoc.networkLocType = this.networkLocType;
                newLoc.isIbeacon = this.isIbeacon;
                newLoc.isIndoorMode = this.isIndoorMode;
                newLoc.indoorState = this.indoorState;
                newLoc.altitude = this.altitude;
                newLoc.province = this.province;
                newLoc.city = this.city;
                newLoc.cityCode = this.cityCode;
                newLoc.district = this.district;
                newLoc.addr = this.addr;
            }
            return newLoc;
        }

        public String toLocationOverlayJsonString(boolean bShowWheel) {
            Point p = null;
            if (this.coordType == CoordType.CoordType_BD09LL) {
                p = LocationMgr.getInstance().Coordinate_encryptEx((float) this.longitude, (float) this.latitude, "bd09ll");
            }
            if (this.coordType == CoordType.CoordType_GCJ02) {
                p = LocationMgr.getInstance().Coordinate_encryptEx((float) this.longitude, (float) this.latitude, "gcj02");
            }
            int x = p != null ? p.getIntX() : (int) this.longitude;
            int y = p != null ? p.getIntY() : (int) this.latitude;
            if (LocationManager.mStyle == style.normal) {
                if (bShowWheel) {
                    return String.format(LocationManager.locDataNormalFormatWithWheel, new Object[]{Integer.valueOf(x), Integer.valueOf(y), Float.valueOf(this.accuracy), Float.valueOf(this.direction), Integer.valueOf(x), Integer.valueOf(y)});
                }
                return String.format(LocationManager.locDataNormalFormat, new Object[]{Integer.valueOf(x), Integer.valueOf(y), Float.valueOf(this.accuracy), Float.valueOf(this.direction)});
            } else if (LocationManager.mStyle == style.indoor) {
                if (bShowWheel) {
                    return String.format(LocationManager.locDataIndoorFormatWithWheel, new Object[]{Integer.valueOf(x), Integer.valueOf(y), Float.valueOf(this.accuracy), Float.valueOf(this.direction), Integer.valueOf(x), Integer.valueOf(y)});
                }
                return String.format(LocationManager.locDataIndoorFormat, new Object[]{Integer.valueOf(x), Integer.valueOf(y), Float.valueOf(this.accuracy), Float.valueOf(this.direction)});
            } else if (LocationManager.mStyle != style.walk) {
                return "";
            } else {
                return String.format(LocationManager.locDataNormalFormatWithWalkWheel, new Object[]{Integer.valueOf(x), Integer.valueOf(y), Float.valueOf(this.accuracy), Float.valueOf(this.direction), Integer.valueOf(x), Integer.valueOf(y)});
            }
        }

        public String toLocationOverlayJsonStringNoDir() {
            JSONObject dataset = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            JSONObject elem = new JSONObject();
            Point p = null;
            if (this.coordType == CoordType.CoordType_BD09LL) {
                p = LocationMgr.getInstance().Coordinate_encryptEx((float) this.longitude, (float) this.latitude, "bd09ll");
            }
            try {
                dataset.put("type", 0);
                if (p != null) {
                    elem.put(MapObjKey.OBJ_SL_PTX, p.getIntX());
                    elem.put(MapObjKey.OBJ_SL_PTY, p.getIntY());
                } else {
                    elem.put(MapObjKey.OBJ_SL_PTX, (int) this.longitude);
                    elem.put(MapObjKey.OBJ_SL_PTY, (int) this.latitude);
                }
                elem.put(CommonConstants.RADIUS, (double) this.accuracy);
                elem.put("direction", 0);
                elem.put("iconarrownor", "NormalLocArrow");
                elem.put("iconarrowfoc", "FocusLocArrow");
                if (LocationManager.mStyle == style.normal) {
                    elem.put("iconarrownorid", 26);
                    elem.put("iconarrowfocid", 27);
                    elem.put("areaid", 69);
                    elem.put("lineid", 71);
                } else {
                    elem.put("iconarrownorid", 170);
                    elem.put("iconarrowfocid", 171);
                    elem.put("areaid", 141);
                    elem.put("lineid", 142);
                }
                jsonArray.put(elem);
                dataset.put("data", jsonArray);
            } catch (JSONException e) {
            }
            return dataset.toString();
        }
    }

    public enum style {
        normal,
        indoor,
        walk
    }

    public void setNormalStyle(style style) {
        mStyle = style;
    }

    public style getStyle() {
        return mStyle;
    }

    public final LocData getCurLocation(CoordType type) {
        GeoPoint output = null;
        if (!(type == null || type.equals(mDefaultCoordType))) {
            GeoPoint input = new GeoPoint(mTmpLocation.latitude, mTmpLocation.longitude);
            if (mDefaultCoordType == CoordType.CoordType_BD09 && type == CoordType.CoordType_BD09LL) {
                output = MapUtils.mc2ll(input);
            } else if (mDefaultCoordType == CoordType.CoordType_BD09LL && type == CoordType.CoordType_BD09) {
                output = MapUtils.ll2mc(input);
            } else if (mDefaultCoordType == CoordType.CoordType_GCJ02 && type == CoordType.CoordType_BD09LL) {
                Point point = CoordinateUtil.gcj02Tobd09ll(input.getLongitude(), input.getLatitude());
                if (point != null) {
                    output = new GeoPoint(point.getDoubleY(), point.getDoubleX());
                }
            } else if (mDefaultCoordType == CoordType.CoordType_GCJ02 && type == CoordType.CoordType_BD09) {
                Bundle b = CoordinateTransformUtil.LL2MC(input.getLongitude(), input.getLatitude());
                if (b != null) {
                    output = new GeoPoint(b.getInt("MCy"), b.getInt("MCx"));
                }
            } else {
                throw new UnsupportedOperationException("CoordType is not support!");
            }
        }
        mCurLocation = mTmpLocation.clone();
        if (output != null) {
            mCurLocation.longitude = output.getLongitude();
            mCurLocation.latitude = output.getLatitude();
            mCurLocation.coordType = type;
        } else {
            mCurLocation.longitude = mTmpLocation.longitude;
            mCurLocation.latitude = mTmpLocation.latitude;
            mCurLocation.coordType = mDefaultCoordType;
        }
        return mCurLocation;
    }

    private LocationManager() {
        if (this.mLocListener == null) {
            this.mLocListener = new BMLocationListener();
        }
        mOption = new LocationClientOption();
        if (mDefaultCoordType.equals(CoordType.CoordType_BD09)) {
            mOption.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09);
        } else if (mDefaultCoordType.equals(CoordType.CoordType_BD09LL)) {
            mOption.setCoorType("bd09ll");
        } else if (mDefaultCoordType.equals(CoordType.CoordType_GCJ02)) {
            mOption.setCoorType("gcj02");
        }
        mOption.setScanSpan(3000);
        mOption.setEnableSimulateGps(true);
        mOption.setAddrType("all");
        mOption.setIsNeedAddress(true);
        mOption.setServiceName("com.baidu.BaiduMap.service");
        mOption.setLocationNotify(true);
        mOption.setProdName("Baidu_baidumap_" + SysOSAPIv2.getInstance().getVersionName());
    }

    public static LocationManager getInstance() {
        if (mInstance == null) {
            synchronized (LocationManager.class) {
                if (mInstance == null) {
                    mInstance = new LocationManager();
                }
            }
        }
        return mInstance;
    }

    public void addLocationChangeLister(LocationChangeListener listener) {
        if (listener != null) {
            synchronized (mLocObservers) {
                mLocObservers.add(listener);
                LocData curLocation = getCurLocation(listener.onGetCoordType());
                if (!(curLocation == null || curLocation.latitude == -1.0d || curLocation.longitude == -1.0d)) {
                    listener.onLocationChange(curLocation);
                }
            }
        }
    }

    public void removeLocationChangeLister(LocationChangeListener listener) {
        synchronized (mLocObservers) {
            mLocObservers.remove(listener);
        }
    }

    public void init(Context ctx) {
        C2911f.e(TAG, "init");
        if (this.mLocationThread == null || this.mContext == null || this.mLocationClient == null) {
            final CountDownLatch latch = new CountDownLatch(1);
            this.mContext = ctx;
            this.mLocationThread = new Thread(LocationManager.class.getSimpleName() + "-init") {
                public void run() {
                    C2911f.e(LocationManager.TAG, "Location Thread start");
                    Looper.prepare();
                    LocationManager.this.mLocationClient = new LocationClient(LocationManager.this.mContext);
                    LocationManager.this.mLocationClient.registerLocationListener(LocationManager.this.mLocListener);
                    LocationManager.this.mLocationClient.setForBaiduMap(true);
                    LocationManager.this.enableGPS(LocationManager.isResumed);
                    latch.countDown();
                    Looper.loop();
                }
            };
            this.mLocationThread.start();
            try {
                latch.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public void onResume() {
        isResumed = true;
        if (mOption != null && this.mLocationClient != null) {
            if (!this.mLocationClient.isStarted()) {
                C2911f.e(TAG, "Location client start");
                this.mLocationClient.start();
            }
            mOption.setOpenGps(true);
            mOption.setScanSpan(3000);
            mOption.setIsNeedAltitude(true);
            this.mLocationClient.setLocOption(mOption);
            this.mLocationClient.requestLocation();
        }
    }

    public void startLoc() {
        if (mOption != null && this.mLocationClient != null) {
            if (!this.mLocationClient.isStarted()) {
                recordLocationStartLog();
                this.mLocationClient.start();
            }
            mOption.setOpenGps(false);
            mOption.setIsNeedAltitude(true);
            this.mLocationClient.setLocOption(mOption);
            this.mLocationClient.requestLocation();
        }
    }

    public void startLocNoSpan() {
        if (mOption != null && this.mLocationClient != null) {
            if (!this.mLocationClient.isStarted()) {
                this.mLocationClient.start();
            }
            mOption.setOpenGps(false);
            mOption.setIsNeedAltitude(true);
            mOption.setScanSpan(0);
            this.mLocationClient.setLocOption(mOption);
            this.mLocationClient.requestLocation();
        }
    }

    public void stopLoc() {
        if (this.mLocationThread != null && this.mLocationClient != null && this.mLocationClient.isStarted()) {
            this.mLocationClient.stop();
        }
    }

    public void onPause() {
        isResumed = false;
        if (this.mLocationClient != null && this.mLocationClient.isStarted()) {
            mOption.setOpenGps(false);
            mOption.setScanSpan(100);
            mOption.setIsNeedAltitude(false);
            this.mLocationClient.setLocOption(mOption);
            stopIndoorMode();
        }
    }

    public void unInit() {
        isResumed = false;
        if (!(this.mLocationThread == null || this.mLocationClient == null || !this.mLocationClient.isStarted())) {
            this.mLocationClient.unRegisterLocationListener(this.mLocListener);
            this.mLocationClient.stop();
        }
        if (this.mLongLinkClient != null) {
            try {
                this.mLongLinkClient.unRegister(this.mLongLinkDataCallback);
                this.mLongLinkClient.release();
            } catch (C4755b e) {
            }
        }
    }

    public void setNavModeStatus(int source, int state) {
        if (this.mLocationClient != null) {
            this.mLocationClient.setNaviModeStatus(source, state);
        }
    }

    public void enableGPS(boolean useGPS) {
        if (this.mLocationClient != null) {
            mOption.setOpenGps(useGPS);
            this.mLocationClient.setLocOption(mOption);
        }
    }

    public boolean setUgcInfo(String info) {
        if (this.mLocationClient == null) {
            return false;
        }
        return this.mLocationClient.setUgcInfo(info);
    }

    public boolean isLocationValid() {
        return mTmpLocation != null && (mTmpLocation.type == 61 || mTmpLocation.type == 161 || mTmpLocation.type == 66);
    }

    public boolean isLocationOffline() {
        return mTmpLocation != null && mTmpLocation.type == 66;
    }

    public int getCurLocationType() {
        return this.mLocType;
    }

    private void logLocation(BDLocation location) {
        StringBuffer sb = new StringBuffer(256);
        sb.append(">>>TM:");
        sb.append(location.getTime());
        sb.append("\tLT:");
        sb.append(location.getLocType());
        sb.append("\tNT: ");
        sb.append(location.getNetworkLocationType());
        sb.append("\tBID: ");
        sb.append(location.getBuildingID());
        sb.append("\tFL:").append(location.getFloor());
        sb.append("\tIBA:").append(location.isParkAvailable());
        sb.append("\tIIM:").append(location.isIndoorLocMode());
        sb.append("\tLAT : ");
        sb.append(location.getLatitude());
        sb.append("\tLONG : ");
        sb.append(location.getLongitude());
        sb.append("\tRAD : ");
        sb.append(location.getRadius());
        if (location.getLocType() == 61) {
            sb.append("\tSPD : ");
            sb.append(location.getSpeed());
            sb.append("\tSAT : ");
            sb.append(location.getSatelliteNumber());
        } else if (location.getLocType() == 161) {
            sb.append("\tADDR : ");
            sb.append(location.getAddrStr());
        }
        sb.append("\tcity: ").append(location.getCity());
        sb.append("\tcityCode: ").append(location.getCityCode());
        sb.append("\tprovince: ").append(location.getProvince());
        sb.append("\tcountry: ").append(location.getCountry());
        sb.append("\tcountrycode: ").append(location.getCountryCode());
        sb.append("\tstreet: ").append(location.getStreet());
        sb.append("\tstreetNo: ").append(location.getStreetNumber());
        sb.append("\n");
        C2911f.e(TAG, sb.toString());
    }

    private boolean isLocationInIndoor(BDLocation location) {
        return (location == null || location.getBuildingID() == null || location.getFloor() == null) ? false : true;
    }

    private void notifiyLocation(BDLocation location) {
        int locType = location.getLocType();
        this.mLocType = locType;
        if (locType == 61 || locType == 161 || locType == 66) {
            String str;
            HashSet<LocationChangeListener> list;
            mTmpLocation.type = locType;
            mTmpLocation.latitude = location.getLatitude();
            mTmpLocation.longitude = location.getLongitude();
            mTmpLocation.speed = location.getSpeed();
            mTmpLocation.accuracy = Math.min(2000.0f, location.getRadius());
            mTmpLocation.direction = location.getDirection();
            mTmpLocation.satellitesNum = location.getSatelliteNumber();
            mTmpLocation.coordType = mDefaultCoordType;
            mTmpLocation.buildingId = location.getBuildingID();
            LocData locData = mTmpLocation;
            if (location.getFloor() == null) {
                str = null;
            } else {
                str = location.getFloor().toUpperCase();
            }
            locData.floorId = str;
            mTmpLocation.isIbeacon = location.isParkAvailable();
            mTmpLocation.isIndoorMode = location.isIndoorLocMode();
            mTmpLocation.indoorState = location.getUserIndoorState();
            mTmpLocation.networkLocType = location.getNetworkLocationType();
            mTmpLocation.altitude = location.getAltitude();
            mTmpLocation.province = location.getProvince();
            mTmpLocation.city = location.getCity();
            mTmpLocation.cityCode = location.getCityCode();
            mTmpLocation.district = location.getDistrict();
            mTmpLocation.addr = location.getAddrStr();
            if (!this.mLocationClient.isIndoorMode() && isLocationInIndoor(location)) {
                tryStartIndoorMode();
            } else if (!isLocationInIndoor(location)) {
                stopIndoorMode();
            }
            synchronized (mLocObservers) {
                list = new HashSet(mLocObservers);
            }
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    LocationChangeListener listener = (LocationChangeListener) it.next();
                    GeoPoint output = null;
                    if (listener != null) {
                        CoordType type = listener.onGetCoordType();
                        if (type == null) {
                            continue;
                        } else {
                            if (!mDefaultCoordType.equals(type)) {
                                GeoPoint input = new GeoPoint(location.getLatitude(), location.getLongitude());
                                if (mDefaultCoordType == CoordType.CoordType_BD09 && type == CoordType.CoordType_BD09LL) {
                                    output = MapUtils.mc2ll(input);
                                } else if (mDefaultCoordType == CoordType.CoordType_BD09LL && type == CoordType.CoordType_BD09) {
                                    output = MapUtils.ll2mc(input);
                                } else if (mDefaultCoordType == CoordType.CoordType_GCJ02 && type == CoordType.CoordType_BD09LL) {
                                    Point point = CoordinateUtil.gcj02Tobd09ll(input.getLongitude(), input.getLatitude());
                                    if (point != null) {
                                        output = new GeoPoint(point.getDoubleY(), point.getDoubleX());
                                    }
                                } else if (mDefaultCoordType == CoordType.CoordType_GCJ02 && type == CoordType.CoordType_BD09) {
                                    Bundle b = CoordinateTransformUtil.LL2MC(input.getLongitude(), input.getLatitude());
                                    if (b != null) {
                                        output = new GeoPoint(b.getInt("MCy"), b.getInt("MCx"));
                                    }
                                } else {
                                    throw new UnsupportedOperationException("CoordType is not support!");
                                }
                            }
                            LocData tmpLoc = mTmpLocation.clone();
                            if (output != null) {
                                tmpLoc.longitude = output.getLongitude();
                                tmpLoc.latitude = output.getLatitude();
                                tmpLoc.coordType = type;
                            } else {
                                tmpLoc.longitude = mTmpLocation.longitude;
                                tmpLoc.latitude = mTmpLocation.latitude;
                                tmpLoc.coordType = mDefaultCoordType;
                            }
                            listener.onLocationChange(tmpLoc);
                        }
                    }
                }
                SysOSAPIv2.getInstance().updateSinan(SysOSAPIv2.getInstance().enCrypt(((int) mTmpLocation.longitude) + "," + ((int) mTmpLocation.latitude), "sinan"));
            }
        }
    }

    public void notifiyNavLocation(BDLocation location, LocationChangeListener listener) {
        int locType = location.getLocType();
        this.mLocType = locType;
        LocData tmpLoc = mTmpLocation.clone();
        if (locType == 61 || locType == 161 || locType == 66) {
            String str;
            tmpLoc.type = locType;
            tmpLoc.latitude = location.getLatitude();
            tmpLoc.longitude = location.getLongitude();
            tmpLoc.speed = location.getSpeed();
            tmpLoc.accuracy = Math.min(2000.0f, location.getRadius());
            tmpLoc.direction = location.getDerect();
            tmpLoc.satellitesNum = location.getSatelliteNumber();
            tmpLoc.coordType = mDefaultCoordType;
            tmpLoc.buildingId = location.getBuildingID();
            if (location.getFloor() == null) {
                str = null;
            } else {
                str = location.getFloor().toUpperCase();
            }
            tmpLoc.floorId = str;
            tmpLoc.isIbeacon = location.isParkAvailable();
            tmpLoc.isIndoorMode = location.isIndoorLocMode();
            tmpLoc.indoorState = location.getUserIndoorState();
            tmpLoc.networkLocType = location.getNetworkLocationType();
            tmpLoc.altitude = location.getAltitude();
            tmpLoc.province = location.getProvince();
            tmpLoc.city = location.getCity();
            tmpLoc.cityCode = location.getCityCode();
            tmpLoc.district = location.getDistrict();
            tmpLoc.addr = location.getAddrStr();
        }
        GeoPoint output = null;
        CoordType type = listener.onGetCoordType();
        if (!mDefaultCoordType.equals(type)) {
            GeoPoint input = new GeoPoint(location.getLatitude(), location.getLongitude());
            if (mDefaultCoordType == CoordType.CoordType_BD09 && type == CoordType.CoordType_BD09LL) {
                output = MapUtils.mc2ll(input);
            } else if (mDefaultCoordType == CoordType.CoordType_BD09LL && type == CoordType.CoordType_BD09) {
                output = MapUtils.ll2mc(input);
            } else if (mDefaultCoordType == CoordType.CoordType_GCJ02 && type == CoordType.CoordType_BD09LL) {
                Point point = CoordinateUtil.gcj02Tobd09ll(input.getLongitude(), input.getLatitude());
                if (point != null) {
                    output = new GeoPoint(point.getDoubleY(), point.getDoubleX());
                }
            } else if (mDefaultCoordType == CoordType.CoordType_GCJ02 && type == CoordType.CoordType_BD09) {
                Bundle b = CoordinateTransformUtil.LL2MC(input.getLongitude(), input.getLatitude());
                if (b != null) {
                    output = new GeoPoint(b.getInt("MCy"), b.getInt("MCx"));
                }
            } else {
                throw new UnsupportedOperationException("CoordType is not support!");
            }
        }
        if (output != null) {
            tmpLoc.longitude = output.getLongitude();
            tmpLoc.latitude = output.getLatitude();
            tmpLoc.coordType = type;
        } else {
            tmpLoc.longitude = mTmpLocation.longitude;
            tmpLoc.latitude = mTmpLocation.latitude;
            tmpLoc.coordType = mDefaultCoordType;
        }
        listener.onLocationChange(tmpLoc);
    }

    private void recordLocationLog(BDLocation location) {
    }

    private void recordLocationStartLog() {
    }

    public boolean triggerErrorReport(String errorID) {
        return this.mLocationClient != null && this.mLocationClient.triggerErrorReport(errorID);
    }

    public boolean tryStartIndoorMode() {
        return this.mLocationClient != null && this.mLocationClient.baiduMapStartIndoorMode();
    }

    public boolean stopIndoorMode() {
        return this.mLocationClient != null && this.mLocationClient.baiduMapStopIndoorMode();
    }

    public boolean isIndoorMode() {
        return this.mLocationClient != null && this.mLocationClient.isIndoorMode();
    }

    public boolean tryStartBLEIndoorMode() {
        return this.mLocationClient != null && this.mLocationClient.baiduMapStartIndoorBleMode();
    }

    public boolean stopBLEIndoorMode() {
        return this.mLocationClient != null && this.mLocationClient.baiduMapStopIndoorBleMode();
    }

    public void requestLocationTag() {
        if (this.mLocationClient != null) {
            this.mLocationClient.requestLocationTag();
        }
    }

    public void requestLocation() {
        if (this.mLocationClient != null) {
            this.mLocationClient.requestLocation();
        }
    }

    public void requestHotSpotState() {
        ConcurrentManager.executeTask(Module.LOCAL_MAP_MODULE, new C35112(), ScheduleConfig.forData());
    }

    public String getLocInfo() {
        if (this.mLocationClient != null) {
            return this.mLocationClient.getLocInfo();
        }
        return "";
    }

    public void reStartService() {
        if (this.mLocationClient != null) {
            this.mLocationClient.restartService();
        }
    }

    public void setHotSpotUserCallbackInfo(boolean info) {
        if (this.mLocationClient != null) {
            this.mLocationClient.setHotSpotUserCallbackInfo(info);
        }
    }
}
