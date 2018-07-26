package com.baidu.navi.location;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.carlife.p085i.C1609a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.location.Poi;
import com.baidu.navi.driveanalysis.CommonConstants;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.location.LocationMgr;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.baidu.platform.comapi.map.MapUtils;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationManager {
    private static final boolean DEBUG = false;
    private static final int LOCATION_SCAN_SPAN = 3000;
    static final String TAG = LocationManager.class.getSimpleName();
    private static boolean isNormalStyle = true;
    static boolean isResumed = false;
    private static String locDataIndoorFormat = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":170,\"iconarrowfocid\":171,\"areaid\":141,\"lineid\":142}]}";
    private static String locDataIndoorFormatWithWheel = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":170,\"iconarrowfocid\":171,\"areaid\":141,\"lineid\":142},{\"ptx\":%d,\"pty\":%d,\"radius\":0,\"direction\":0,\"iconarrownor\":\"direction_wheel\",\"iconarrownorid\":54,\"iconarrowfoc\":\"direction_wheel\",\"iconarrowfocid\":54}]}";
    private static String locDataNormalFormat = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":28,\"iconarrowfocid\":29,\"areaid\":69,\"lineid\":71}]}";
    private static String locDataNormalFormatWithWalkWheel = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":347,\"iconarrowfocid\":347,\"areaid\":69,\"lineid\":71},{\"ptx\":%d,\"pty\":%d,\"radius\":0,\"direction\":0,\"iconarrownor\":\"direction_wheel\",\"iconarrownorid\":339,\"iconarrowfoc\":\"direction_wheel\",\"iconarrowfocid\":339}]}";
    private static String locDataNormalFormatWithWheel = "{\"type\":0,\"data\":[{\"ptx\":%d,\"pty\":%d,\"radius\":%2f,\"direction\":%2f,\"iconarrownor\":\"NormalLocArrow\",\"iconarrowfoc\":\"FocusLocArrow\",\"iconarrownorid\":28,\"iconarrowfocid\":29,\"areaid\":69,\"lineid\":71},{\"ptx\":%d,\"pty\":%d,\"radius\":0,\"direction\":0,\"iconarrownor\":\"direction_wheel\",\"iconarrownorid\":54,\"iconarrowfoc\":\"direction_wheel\",\"iconarrowfocid\":54}]}";
    private static LocData mCurLocation = new LocData();
    private static final CoordType mDefaultCoordType = CoordType.CoordType_GCJ02;
    private static LocationManager mInstance = null;
    static List<LocationChangeListener> mLocObservers = new ArrayList();
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

    class BMLocationListener extends BDLocationListener {
        private Handler handler = new Handler(Looper.getMainLooper());

        BMLocationListener() {
        }

        public void onReceiveLocation(final BDLocation location) {
            if (!C1663a.a().N() || !C1609a.a().b() || !C1609a.a().c()) {
                this.handler.post(new Runnable() {
                    public void run() {
                        LocationManager.this.notifiyLocation(location);
                    }
                });
            }
        }

        public void onConnectHotSpotMessage(String s, int i) {
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
                if (LocationManager.isNormalStyle) {
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

    public void setNormalStyle(boolean normalStyle) {
        isNormalStyle = normalStyle;
    }

    public LocationClientOption getDefaultLocationClientOption() {
        if (mOption == null) {
            mOption = new LocationClientOption();
            mOption.setLocationMode(LocationMode.Hight_Accuracy);
            mOption.setCoorType("gcj02");
            mOption.setScanSpan(3000);
            mOption.setIsNeedAddress(false);
            mOption.setIsNeedLocationDescribe(false);
            mOption.setNeedDeviceDirect(true);
            mOption.setLocationNotify(false);
            mOption.setIgnoreKillProcess(true);
            mOption.setIsNeedLocationDescribe(false);
            mOption.setIsNeedLocationPoiList(false);
            mOption.SetIgnoreCacheException(false);
        }
        return mOption;
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
        mOption = getDefaultLocationClientOption();
        mOption.setEnableSimulateGps(true);
        mOption.setServiceName("com.baidu.BaiduCarLife.service");
        mOption.setLocationNotify(true);
        mOption.setProdName("Baidu_baiducarlife_" + SysOSAPIv2.getInstance().getVersionName());
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
        if (this.mLocationThread == null || this.mContext == null || this.mLocationClient == null) {
            final CountDownLatch latch = new CountDownLatch(1);
            this.mContext = ctx;
            this.mLocationThread = new Thread(LocationManager.class.getSimpleName() + "-init") {
                public void run() {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                    LocationManager.this.mLocationClient = new LocationClient(LocationManager.this.mContext);
                    LocationManager.this.mLocationClient.registerLocationListener(LocationManager.this.mLocListener);
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
                this.mLocationClient.start();
            }
            mOption.setOpenGps(true);
            mOption.setScanSpan(3000);
            mOption.setIsNeedAltitude(true);
            this.mLocationClient.setLocOption(mOption);
            this.mLocationClient.requestLocation();
        }
    }

    public void onPause() {
        isResumed = false;
        if (this.mLocationClient != null && this.mLocationClient.isStarted()) {
            mOption.setOpenGps(false);
            mOption.setScanSpan(100);
            mOption.setIsNeedAltitude(false);
            this.mLocationClient.setLocOption(mOption);
        }
    }

    public void unInit() {
        isResumed = false;
        if (this.mLocationThread != null && this.mLocationClient != null && this.mLocationClient.isStarted()) {
            this.mLocationClient.unRegisterLocationListener(this.mLocListener);
            this.mLocationClient.stop();
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
        return true;
    }

    public boolean isLocationValid() {
        return mTmpLocation != null && (mTmpLocation.type == 61 || mTmpLocation.type == 161 || mTmpLocation.type == 66 || mTmpLocation.type == 68);
    }

    public boolean isLocationOffline() {
        if (mTmpLocation == null) {
            return false;
        }
        if (mTmpLocation.type == 66 || mTmpLocation.type == 68) {
            return true;
        }
        return false;
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
        sb.append("\nDescribe: ");
        sb.append(location.getLocationDescribe());
        sb.append("\nDirection(not all devices have value): ");
        sb.append(location.getDirection());
        sb.append("\nPoi: ");
        if (!(location.getPoiList() == null || location.getPoiList().isEmpty())) {
            for (int i = 0; i < location.getPoiList().size(); i++) {
                sb.append(((Poi) location.getPoiList().get(i)).getName() + ";");
            }
        }
        sb.append("\n");
        if (location.getLocType() == 61) {
            sb.append("\nspeed : ");
            sb.append(location.getSpeed());
            sb.append("\nsatellite : ");
            sb.append(location.getSatelliteNumber());
            sb.append("\nheight : ");
            sb.append(location.getAltitude());
            sb.append("\ndescribe : ");
            sb.append("gps定位成功");
        } else if (location.getLocType() == 161) {
            sb.append("\noperationers : ");
            sb.append(location.getOperators());
            sb.append("\ndescribe : ");
            sb.append("网络定位成功");
        } else if (location.getLocType() == 66) {
            sb.append("\ndescribe : ");
            sb.append("离线定位成功，离线定位结果也是有效的");
        } else if (location.getLocType() == 167) {
            sb.append("\ndescribe : ");
            sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
        } else if (location.getLocType() == 63) {
            sb.append("\ndescribe : ");
            sb.append("网络不同导致定位失败，请检查网络是否通畅");
        } else if (location.getLocType() == 62) {
            sb.append("\ndescribe : ");
            sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
        }
        Log.e(TAG, sb.toString());
    }

    private boolean isLocationInIndoor(BDLocation location) {
        return (location == null || location.getBuildingID() == null || location.getFloor() == null) ? false : true;
    }

    private void notifiyLocation(BDLocation location) {
        int locType = location.getLocType();
        this.mLocType = locType;
        if (locType == 61 || locType == 161 || locType == 66 || locType == 68) {
            String str;
            ArrayList<LocationChangeListener> list;
            mTmpLocation.type = locType;
            mTmpLocation.latitude = location.getLatitude();
            mTmpLocation.longitude = location.getLongitude();
            mTmpLocation.speed = location.getSpeed();
            mTmpLocation.accuracy = Math.min(2000.0f, location.getRadius());
            mTmpLocation.direction = location.getDerect();
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
            synchronized (mLocObservers) {
                list = new ArrayList(mLocObservers);
            }
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    LocationChangeListener listener = (LocationChangeListener) it.next();
                    GeoPoint output = null;
                    if (listener != null) {
                        CoordType type = listener.onGetCoordType();
                        if (type != null) {
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
            }
        }
    }

    public void notifiyLocation(LocData location) {
        int locType = location.type;
        this.mLocType = locType;
        mTmpLocation.type = locType;
        mTmpLocation.latitude = location.latitude;
        mTmpLocation.longitude = location.longitude;
        mTmpLocation.speed = location.speed;
        mTmpLocation.accuracy = location.accuracy;
        mTmpLocation.direction = location.direction;
        mTmpLocation.satellitesNum = location.satellitesNum;
        mTmpLocation.coordType = mDefaultCoordType;
        synchronized (mLocObservers) {
            ArrayList<LocationChangeListener> list = new ArrayList(mLocObservers);
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                LocationChangeListener listener = (LocationChangeListener) it.next();
                GeoPoint output = null;
                if (listener != null) {
                    CoordType type = listener.onGetCoordType();
                    if (type != null) {
                        if (!mDefaultCoordType.equals(type)) {
                            GeoPoint input = new GeoPoint(location.latitude, location.longitude);
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
        }
    }

    public void requestLocation() {
        if (this.mLocationClient != null) {
            this.mLocationClient.requestLocation();
        }
    }

    public synchronized void startNaviLocate() {
        onPause();
    }

    public synchronized void stopNaviLocate() {
        onResume();
    }

    private void setOptionForNavi() {
        if (this.mLocationClient != null && mOption != null) {
            mOption.setOpenGps(true);
            mOption.setScanSpan(86400000);
            this.mLocationClient.setLocOption(mOption);
        }
    }

    private void setOptionForMap() {
        if (this.mLocationClient != null && mOption != null) {
            mOption.setOpenGps(true);
            mOption.setScanSpan(3000);
            this.mLocationClient.setLocOption(mOption);
        }
    }
}
