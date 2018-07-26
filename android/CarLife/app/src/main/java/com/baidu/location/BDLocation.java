package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.location.Address.Builder;
import com.baidu.location.p188h.C3391g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Creator<BDLocation> CREATOR = new C31701();
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = -1;
    private String buildingid;
    private String floor;
    private boolean indoorLocMode;
    private boolean isCellChangeFlag;
    private String locationID;
    private Address mAddr;
    private String mAddrStr;
    private double mAltitude;
    private String mBuildingName;
    private String mCoorType;
    private String mCu;
    private float mDerect;
    private String mDescription;
    private int mGpsAccuracyStatus;
    private int mGpsCheckStatus;
    private boolean mHasAddr;
    private boolean mHasAltitude;
    private boolean mHasRadius;
    private boolean mHasSateNumber;
    private boolean mHasSpeed;
    private int mIndoorLocationSurpport;
    private int mIndoorNetworkState;
    private int mIndoorSource;
    private int mIndoorState;
    private String mIndoorSurpportBuildingID;
    private String mIndoorSurpportBuildingName;
    private String mIndoorSurpportPolygon;
    private double mLatitude;
    private int mLocType;
    private int mLocationWhere;
    private double mLongitude;
    private int mOperators;
    private int mParkState;
    private List<Poi> mPoiList;
    private float mRadius;
    private int mSatelliteNumber;
    private String mSemaAptag;
    private String mSemaPoiRegion;
    private String mSemaRegular;
    private float mSpeed;
    private String mTime;
    private String netWorkLocationType;
    private HashMap<String, String> retFields;

    /* renamed from: com.baidu.location.BDLocation$1 */
    static class C31701 implements Creator<BDLocation> {
        C31701() {
        }

        public BDLocation createFromParcel(Parcel parcel) {
            return new BDLocation(parcel);
        }

        public BDLocation[] newArray(int i) {
            return new BDLocation[i];
        }
    }

    public BDLocation() {
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new Builder().build();
        this.floor = null;
        this.buildingid = null;
        this.mBuildingName = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        this.mIndoorState = -1;
        this.mIndoorLocationSurpport = 0;
        this.mIndoorNetworkState = 2;
        this.mIndoorSource = 0;
        this.mIndoorSurpportBuildingName = null;
        this.mIndoorSurpportBuildingID = null;
        this.mIndoorSurpportPolygon = null;
        this.mPoiList = null;
        this.mDescription = null;
        this.locationID = null;
        this.retFields = new HashMap();
        this.mGpsAccuracyStatus = 0;
        this.mGpsCheckStatus = 0;
    }

    private BDLocation(Parcel parcel) {
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new Builder().build();
        this.floor = null;
        this.buildingid = null;
        this.mBuildingName = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        this.mIndoorState = -1;
        this.mIndoorLocationSurpport = 0;
        this.mIndoorNetworkState = 2;
        this.mIndoorSource = 0;
        this.mIndoorSurpportBuildingName = null;
        this.mIndoorSurpportBuildingID = null;
        this.mIndoorSurpportPolygon = null;
        this.mPoiList = null;
        this.mDescription = null;
        this.locationID = null;
        this.retFields = new HashMap();
        this.mGpsAccuracyStatus = 0;
        this.mGpsCheckStatus = 0;
        this.mLocType = parcel.readInt();
        this.mTime = parcel.readString();
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
        this.mAltitude = parcel.readDouble();
        this.mSpeed = parcel.readFloat();
        this.mRadius = parcel.readFloat();
        this.mSatelliteNumber = parcel.readInt();
        this.mDerect = parcel.readFloat();
        this.floor = parcel.readString();
        this.mParkState = parcel.readInt();
        this.buildingid = parcel.readString();
        this.mBuildingName = parcel.readString();
        this.netWorkLocationType = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        this.mAddr = new Builder().country(readString7).countryCode(parcel.readString()).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).build();
        boolean[] zArr = new boolean[7];
        this.mOperators = parcel.readInt();
        this.mCu = parcel.readString();
        this.mSemaAptag = parcel.readString();
        this.mSemaPoiRegion = parcel.readString();
        this.mSemaRegular = parcel.readString();
        this.mLocationWhere = parcel.readInt();
        this.mDescription = parcel.readString();
        this.mIndoorState = parcel.readInt();
        this.mIndoorLocationSurpport = parcel.readInt();
        this.mIndoorNetworkState = parcel.readInt();
        this.mIndoorSource = parcel.readInt();
        this.mIndoorSurpportBuildingName = parcel.readString();
        this.mIndoorSurpportBuildingID = parcel.readString();
        this.mIndoorSurpportPolygon = parcel.readString();
        this.mGpsAccuracyStatus = parcel.readInt();
        this.locationID = parcel.readString();
        this.mGpsCheckStatus = parcel.readInt();
        try {
            parcel.readBooleanArray(zArr);
            this.mHasAltitude = zArr[0];
            this.mHasSpeed = zArr[1];
            this.mHasRadius = zArr[2];
            this.mHasSateNumber = zArr[3];
            this.mHasAddr = zArr[4];
            this.isCellChangeFlag = zArr[5];
            this.indoorLocMode = zArr[6];
        } catch (Exception e) {
        }
        List arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.mPoiList = null;
        } else {
            this.mPoiList = arrayList;
        }
    }

    public BDLocation(BDLocation bDLocation) {
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new Builder().build();
        this.floor = null;
        this.buildingid = null;
        this.mBuildingName = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        this.mIndoorState = -1;
        this.mIndoorLocationSurpport = 0;
        this.mIndoorNetworkState = 2;
        this.mIndoorSource = 0;
        this.mIndoorSurpportBuildingName = null;
        this.mIndoorSurpportBuildingID = null;
        this.mIndoorSurpportPolygon = null;
        this.mPoiList = null;
        this.mDescription = null;
        this.locationID = null;
        this.retFields = new HashMap();
        this.mGpsAccuracyStatus = 0;
        this.mGpsCheckStatus = 0;
        this.mLocType = bDLocation.mLocType;
        this.mTime = bDLocation.mTime;
        this.mLatitude = bDLocation.mLatitude;
        this.mLongitude = bDLocation.mLongitude;
        this.mHasAltitude = bDLocation.mHasAltitude;
        this.mAltitude = bDLocation.mAltitude;
        this.mHasSpeed = bDLocation.mHasSpeed;
        this.mSpeed = bDLocation.mSpeed;
        this.mHasRadius = bDLocation.mHasRadius;
        this.mRadius = bDLocation.mRadius;
        this.mHasSateNumber = bDLocation.mHasSateNumber;
        this.mSatelliteNumber = bDLocation.mSatelliteNumber;
        this.mDerect = bDLocation.mDerect;
        this.mCoorType = bDLocation.mCoorType;
        this.mHasAddr = bDLocation.mHasAddr;
        this.mAddrStr = bDLocation.mAddrStr;
        this.isCellChangeFlag = bDLocation.isCellChangeFlag;
        this.mAddr = new Builder().country(bDLocation.mAddr.country).countryCode(bDLocation.mAddr.countryCode).province(bDLocation.mAddr.province).city(bDLocation.mAddr.city).cityCode(bDLocation.mAddr.cityCode).district(bDLocation.mAddr.district).street(bDLocation.mAddr.street).streetNumber(bDLocation.mAddr.streetNumber).build();
        this.floor = bDLocation.floor;
        this.buildingid = bDLocation.buildingid;
        this.mBuildingName = bDLocation.mBuildingName;
        this.mLocationWhere = bDLocation.mLocationWhere;
        this.mParkState = bDLocation.mParkState;
        this.indoorLocMode = bDLocation.indoorLocMode;
        this.netWorkLocationType = bDLocation.netWorkLocationType;
        this.mOperators = bDLocation.mOperators;
        this.mCu = bDLocation.mCu;
        this.mSemaAptag = bDLocation.mSemaAptag;
        this.mSemaPoiRegion = bDLocation.mSemaPoiRegion;
        this.mSemaRegular = bDLocation.mSemaRegular;
        this.mIndoorState = bDLocation.mIndoorState;
        this.mIndoorLocationSurpport = bDLocation.mIndoorLocationSurpport;
        this.mIndoorNetworkState = bDLocation.mIndoorLocationSurpport;
        this.mIndoorSource = bDLocation.mIndoorSource;
        this.mIndoorSurpportBuildingName = bDLocation.mIndoorSurpportBuildingName;
        this.mIndoorSurpportBuildingID = bDLocation.mIndoorSurpportBuildingID;
        this.mIndoorSurpportPolygon = bDLocation.mIndoorSurpportPolygon;
        this.mGpsAccuracyStatus = bDLocation.mGpsAccuracyStatus;
        this.locationID = bDLocation.locationID;
        if (bDLocation.mPoiList == null) {
            this.mPoiList = null;
        } else {
            List arrayList = new ArrayList();
            for (int i = 0; i < bDLocation.mPoiList.size(); i++) {
                Poi poi = (Poi) bDLocation.mPoiList.get(i);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
            }
            this.mPoiList = arrayList;
        }
        this.mDescription = bDLocation.mDescription;
        this.retFields = bDLocation.retFields;
        this.mGpsCheckStatus = bDLocation.mGpsCheckStatus;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BDLocation(java.lang.String r13) {
        /*
        r12 = this;
        r12.<init>();
        r0 = 0;
        r12.mLocType = r0;
        r0 = 0;
        r12.mTime = r0;
        r0 = 1;
        r12.mLatitude = r0;
        r0 = 1;
        r12.mLongitude = r0;
        r0 = 0;
        r12.mHasAltitude = r0;
        r0 = 1;
        r12.mAltitude = r0;
        r0 = 0;
        r12.mHasSpeed = r0;
        r0 = 0;
        r12.mSpeed = r0;
        r0 = 0;
        r12.mHasRadius = r0;
        r0 = 0;
        r12.mRadius = r0;
        r0 = 0;
        r12.mHasSateNumber = r0;
        r0 = -1;
        r12.mSatelliteNumber = r0;
        r0 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r12.mDerect = r0;
        r0 = 0;
        r12.mCoorType = r0;
        r0 = 0;
        r12.mHasAddr = r0;
        r0 = 0;
        r12.mAddrStr = r0;
        r0 = 0;
        r12.mSemaAptag = r0;
        r0 = 0;
        r12.mSemaPoiRegion = r0;
        r0 = 0;
        r12.mSemaRegular = r0;
        r0 = 0;
        r12.isCellChangeFlag = r0;
        r0 = new com.baidu.location.Address$Builder;
        r0.<init>();
        r0 = r0.build();
        r12.mAddr = r0;
        r0 = 0;
        r12.floor = r0;
        r0 = 0;
        r12.buildingid = r0;
        r0 = 0;
        r12.mBuildingName = r0;
        r0 = 0;
        r12.indoorLocMode = r0;
        r0 = 0;
        r12.mParkState = r0;
        r0 = 1;
        r12.mLocationWhere = r0;
        r0 = 0;
        r12.netWorkLocationType = r0;
        r0 = "";
        r12.mCu = r0;
        r0 = -1;
        r12.mIndoorState = r0;
        r0 = 0;
        r12.mIndoorLocationSurpport = r0;
        r0 = 2;
        r12.mIndoorNetworkState = r0;
        r0 = 0;
        r12.mIndoorSource = r0;
        r0 = 0;
        r12.mIndoorSurpportBuildingName = r0;
        r0 = 0;
        r12.mIndoorSurpportBuildingID = r0;
        r0 = 0;
        r12.mIndoorSurpportPolygon = r0;
        r0 = 0;
        r12.mPoiList = r0;
        r0 = 0;
        r12.mDescription = r0;
        r0 = 0;
        r12.locationID = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r12.retFields = r0;
        r0 = 0;
        r12.mGpsAccuracyStatus = r0;
        r0 = 0;
        r12.mGpsCheckStatus = r0;
        if (r13 == 0) goto L_0x009e;
    L_0x0095:
        r0 = "";
        r0 = r13.equals(r0);
        if (r0 == 0) goto L_0x009f;
    L_0x009e:
        return;
    L_0x009f:
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0.<init>(r13);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "result";
        r1 = r0.getJSONObject(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = "error";
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setLocType(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r3 = "time";
        r1 = r1.getString(r3);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setTime(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = 61;
        if (r2 != r1) goto L_0x0186;
    L_0x00c7:
        r1 = "content";
        r0 = r0.getJSONObject(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "point";
        r1 = r0.getJSONObject(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = "y";
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = java.lang.Double.parseDouble(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setLatitude(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = "x";
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = java.lang.Double.parseDouble(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setLongitude(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "radius";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = java.lang.Float.parseFloat(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setRadius(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "s";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = java.lang.Float.parseFloat(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setSpeed(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "d";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = java.lang.Float.parseFloat(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setDirection(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "n";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setSatelliteNumber(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "h";
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r1 == 0) goto L_0x013c;
    L_0x0132:
        r1 = "h";
        r2 = r0.getDouble(r1);	 Catch:{ Exception -> 0x05ce, Error -> 0x017a }
        r12.setAltitude(r2);	 Catch:{ Exception -> 0x05ce, Error -> 0x017a }
    L_0x013c:
        r1 = "in_cn";
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x0170, Error -> 0x017a }
        if (r1 == 0) goto L_0x016b;
    L_0x0145:
        r1 = "in_cn";
        r0 = r0.getString(r1);	 Catch:{ Exception -> 0x0170, Error -> 0x017a }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0170, Error -> 0x017a }
        r12.setLocationWhere(r0);	 Catch:{ Exception -> 0x0170, Error -> 0x017a }
    L_0x0153:
        r0 = r12.mLocationWhere;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 != 0) goto L_0x0172;
    L_0x0157:
        r0 = "wgs84";
        r12.setCoorType(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x009e;
    L_0x015f:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = 0;
        r12.mLocType = r0;
        r0 = 0;
        r12.mHasAddr = r0;
        goto L_0x009e;
    L_0x016b:
        r0 = 1;
        r12.setLocationWhere(r0);	 Catch:{ Exception -> 0x0170, Error -> 0x017a }
        goto L_0x0153;
    L_0x0170:
        r0 = move-exception;
        goto L_0x0153;
    L_0x0172:
        r0 = "gcj02";
        r12.setCoorType(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x009e;
    L_0x017a:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = 0;
        r12.mLocType = r0;
        r0 = 0;
        r12.mHasAddr = r0;
        goto L_0x009e;
    L_0x0186:
        r1 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        if (r2 != r1) goto L_0x056a;
    L_0x018a:
        r1 = "content";
        r9 = r0.getJSONObject(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = "point";
        r0 = r9.getJSONObject(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "y";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = java.lang.Double.parseDouble(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setLatitude(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "x";
        r0 = r0.getString(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = java.lang.Double.parseDouble(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setLongitude(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = "radius";
        r0 = r9.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = java.lang.Float.parseFloat(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setRadius(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = "sema";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x0269;
    L_0x01cb:
        r0 = "sema";
        r1 = r9.getJSONObject(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = "aptag";
        r0 = r1.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x01ea;
    L_0x01db:
        r0 = "aptag";
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r2 != 0) goto L_0x0231;
    L_0x01e8:
        r12.mSemaAptag = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x01ea:
        r0 = "aptagd";
        r0 = r1.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x0239;
    L_0x01f3:
        r0 = "aptagd";
        r0 = r1.getJSONObject(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = "pois";
        r2 = r0.getJSONArray(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r3.<init>();	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = 0;
    L_0x0207:
        r4 = r2.length();	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 >= r4) goto L_0x0237;
    L_0x020d:
        r4 = r2.getJSONObject(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r5 = "pname";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r6 = "pid";
        r6 = r4.getString(r6);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r7 = "pr";
        r10 = r4.getDouble(r7);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r4 = new com.baidu.location.Poi;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r4.<init>(r6, r5, r10);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r3.add(r4);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = r0 + 1;
        goto L_0x0207;
    L_0x0231:
        r0 = "";
        r12.mSemaAptag = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x01ea;
    L_0x0237:
        r12.mPoiList = r3;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x0239:
        r0 = "poiregion";
        r0 = r1.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x0251;
    L_0x0242:
        r0 = "poiregion";
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r2 != 0) goto L_0x0251;
    L_0x024f:
        r12.mSemaPoiRegion = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x0251:
        r0 = "regular";
        r0 = r1.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x0269;
    L_0x025a:
        r0 = "regular";
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r1 != 0) goto L_0x0269;
    L_0x0267:
        r12.mSemaRegular = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x0269:
        r0 = "addr";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x04eb;
    L_0x0272:
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r0 = 0;
        r8 = "addr";
        r10 = r9.getString(r8);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r8 = new org.json.JSONObject;	 Catch:{ Exception -> 0x04ae, Error -> 0x017a }
        r8.<init>(r10);	 Catch:{ Exception -> 0x04ae, Error -> 0x017a }
    L_0x0286:
        if (r8 == 0) goto L_0x04b2;
    L_0x0288:
        r7 = "";
        r6 = "";
        r5 = "";
        r4 = "";
        r3 = "";
        r2 = "";
        r1 = "";
        r0 = "";
        r10 = "city";
        r10 = r8.has(r10);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r10 == 0) goto L_0x02b0;
    L_0x02a9:
        r4 = "city";
        r4 = r8.getString(r4);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x02b0:
        r10 = "city_code";
        r10 = r8.has(r10);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r10 == 0) goto L_0x02c0;
    L_0x02b9:
        r3 = "city_code";
        r3 = r8.getString(r3);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x02c0:
        r10 = "country";
        r10 = r8.has(r10);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r10 == 0) goto L_0x02d0;
    L_0x02c9:
        r7 = "country";
        r7 = r8.getString(r7);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x02d0:
        r10 = "country_code";
        r10 = r8.has(r10);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r10 == 0) goto L_0x02e0;
    L_0x02d9:
        r6 = "country_code";
        r6 = r8.getString(r6);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x02e0:
        r10 = "province";
        r10 = r8.has(r10);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r10 == 0) goto L_0x02f0;
    L_0x02e9:
        r5 = "province";
        r5 = r8.getString(r5);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x02f0:
        r10 = "district";
        r10 = r8.has(r10);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r10 == 0) goto L_0x0300;
    L_0x02f9:
        r2 = "district";
        r2 = r8.getString(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x0300:
        r10 = "street";
        r10 = r8.has(r10);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r10 == 0) goto L_0x0310;
    L_0x0309:
        r1 = "street";
        r1 = r8.getString(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x0310:
        r10 = "street_number";
        r10 = r8.has(r10);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r10 == 0) goto L_0x0320;
    L_0x0319:
        r0 = "street_number";
        r0 = r8.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x0320:
        r8 = new com.baidu.location.Address$Builder;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r8.<init>();	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r7 = r8.country(r7);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r6 = r7.countryCode(r6);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r5 = r6.province(r5);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r4 = r5.city(r4);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r3 = r4.cityCode(r3);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = r3.district(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = r2.street(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = r1.streetNumber(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = r0.build();	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.mAddr = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = 1;
        r12.mHasAddr = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x034e:
        r0 = "floor";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x036b;
    L_0x0357:
        r0 = "floor";
        r0 = r9.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.floor = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = r12.floor;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x036b;
    L_0x0368:
        r0 = 0;
        r12.floor = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x036b:
        r0 = "indoor";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x038c;
    L_0x0374:
        r0 = "indoor";
        r0 = r9.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r1 != 0) goto L_0x038c;
    L_0x0381:
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setUserIndoorState(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x038c:
        r0 = "loctp";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x03a9;
    L_0x0395:
        r0 = "loctp";
        r0 = r9.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.netWorkLocationType = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = r12.netWorkLocationType;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x03a9;
    L_0x03a6:
        r0 = 0;
        r12.netWorkLocationType = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x03a9:
        r0 = "bldgid";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x03c6;
    L_0x03b2:
        r0 = "bldgid";
        r0 = r9.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.buildingid = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = r12.buildingid;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x03c6;
    L_0x03c3:
        r0 = 0;
        r12.buildingid = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x03c6:
        r0 = "bldg";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x03e3;
    L_0x03cf:
        r0 = "bldg";
        r0 = r9.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.mBuildingName = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = r12.mBuildingName;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x03e3;
    L_0x03e0:
        r0 = 0;
        r12.mBuildingName = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x03e3:
        r0 = "ibav";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x03fc;
    L_0x03ec:
        r0 = "ibav";
        r0 = r9.getString(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r1 == 0) goto L_0x04f4;
    L_0x03f9:
        r0 = 0;
        r12.mParkState = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x03fc:
        r0 = "indoorflags";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x051b;
    L_0x0405:
        r0 = "indoorflags";
        r0 = r9.getJSONObject(r0);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        r1 = "area";
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        if (r1 == 0) goto L_0x042a;
    L_0x0415:
        r1 = "area";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        if (r1 != 0) goto L_0x050e;
    L_0x0426:
        r1 = 2;
        r12.setIndoorLocationSurpport(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
    L_0x042a:
        r1 = "support";
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        if (r1 == 0) goto L_0x0445;
    L_0x0433:
        r1 = "support";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        r12.setIndoorLocationSource(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
    L_0x0445:
        r1 = "inbldg";
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        if (r1 == 0) goto L_0x0457;
    L_0x044e:
        r1 = "inbldg";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        r12.mIndoorSurpportBuildingName = r1;	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
    L_0x0457:
        r1 = "inbldgid";
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        if (r1 == 0) goto L_0x0469;
    L_0x0460:
        r1 = "inbldgid";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        r12.mIndoorSurpportBuildingID = r1;	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
    L_0x0469:
        r1 = "polygon";
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        if (r1 == 0) goto L_0x047c;
    L_0x0472:
        r1 = "polygon";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        r12.setIndoorSurpportPolygon(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
    L_0x047c:
        r1 = "ret_fields";
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        if (r1 == 0) goto L_0x051b;
    L_0x0485:
        r1 = "ret_fields";
        r0 = r0.getString(r1);	 Catch:{ Exception -> 0x0551, Error -> 0x017a }
        r1 = "\\|";
        r1 = r0.split(r1);	 Catch:{ Exception -> 0x0551, Error -> 0x017a }
        r2 = r1.length;	 Catch:{ Exception -> 0x0551, Error -> 0x017a }
        r0 = 0;
    L_0x0495:
        if (r0 >= r2) goto L_0x051b;
    L_0x0497:
        r3 = r1[r0];	 Catch:{ Exception -> 0x0551, Error -> 0x017a }
        r4 = "=";
        r3 = r3.split(r4);	 Catch:{ Exception -> 0x0551, Error -> 0x017a }
        r4 = 0;
        r4 = r3[r4];	 Catch:{ Exception -> 0x0551, Error -> 0x017a }
        r5 = 1;
        r3 = r3[r5];	 Catch:{ Exception -> 0x0551, Error -> 0x017a }
        r5 = r12.retFields;	 Catch:{ Exception -> 0x0551, Error -> 0x017a }
        r5.put(r4, r3);	 Catch:{ Exception -> 0x0551, Error -> 0x017a }
        r0 = r0 + 1;
        goto L_0x0495;
    L_0x04ae:
        r8 = move-exception;
        r8 = 0;
        goto L_0x0286;
    L_0x04b2:
        r8 = ",";
        r8 = r10.split(r8);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r10 = r8.length;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r10 <= 0) goto L_0x04bf;
    L_0x04bc:
        r5 = 0;
        r5 = r8[r5];	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x04bf:
        r11 = 1;
        if (r10 <= r11) goto L_0x04c5;
    L_0x04c2:
        r4 = 1;
        r4 = r8[r4];	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x04c5:
        r11 = 2;
        if (r10 <= r11) goto L_0x04cb;
    L_0x04c8:
        r2 = 2;
        r2 = r8[r2];	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x04cb:
        r11 = 3;
        if (r10 <= r11) goto L_0x04d1;
    L_0x04ce:
        r1 = 3;
        r1 = r8[r1];	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x04d1:
        r11 = 4;
        if (r10 <= r11) goto L_0x04d7;
    L_0x04d4:
        r0 = 4;
        r0 = r8[r0];	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x04d7:
        r11 = 5;
        if (r10 <= r11) goto L_0x04dd;
    L_0x04da:
        r3 = 5;
        r3 = r8[r3];	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x04dd:
        r11 = 6;
        if (r10 <= r11) goto L_0x04e3;
    L_0x04e0:
        r7 = 6;
        r7 = r8[r7];	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x04e3:
        r11 = 7;
        if (r10 <= r11) goto L_0x0320;
    L_0x04e6:
        r6 = 7;
        r6 = r8[r6];	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x0320;
    L_0x04eb:
        r0 = 0;
        r12.mHasAddr = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = 0;
        r12.setAddrStr(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x034e;
    L_0x04f4:
        r1 = "0";
        r1 = r0.equals(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r1 == 0) goto L_0x0502;
    L_0x04fd:
        r0 = 0;
        r12.mParkState = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x03fc;
    L_0x0502:
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.mParkState = r0;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x03fc;
    L_0x050e:
        r2 = 1;
        if (r1 != r2) goto L_0x042a;
    L_0x0511:
        r1 = 1;
        r12.setIndoorLocationSurpport(r1);	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        goto L_0x042a;
    L_0x0517:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x051b:
        r0 = "gpscs";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 == 0) goto L_0x0556;
    L_0x0524:
        r0 = "gpscs";
        r0 = r9.getInt(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setGpsCheckStatus(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
    L_0x052e:
        r0 = "in_cn";
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x0560, Error -> 0x017a }
        if (r0 == 0) goto L_0x055b;
    L_0x0537:
        r0 = "in_cn";
        r0 = r9.getString(r0);	 Catch:{ Exception -> 0x0560, Error -> 0x017a }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0560, Error -> 0x017a }
        r12.setLocationWhere(r0);	 Catch:{ Exception -> 0x0560, Error -> 0x017a }
    L_0x0545:
        r0 = r12.mLocationWhere;	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        if (r0 != 0) goto L_0x0562;
    L_0x0549:
        r0 = "wgs84";
        r12.setCoorType(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x009e;
    L_0x0551:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0517, Error -> 0x017a }
        goto L_0x051b;
    L_0x0556:
        r0 = 0;
        r12.setGpsCheckStatus(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x052e;
    L_0x055b:
        r0 = 1;
        r12.setLocationWhere(r0);	 Catch:{ Exception -> 0x0560, Error -> 0x017a }
        goto L_0x0545;
    L_0x0560:
        r0 = move-exception;
        goto L_0x0545;
    L_0x0562:
        r0 = "gcj02";
        r12.setCoorType(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x009e;
    L_0x056a:
        r1 = 66;
        if (r2 == r1) goto L_0x0572;
    L_0x056e:
        r1 = 68;
        if (r2 != r1) goto L_0x05c4;
    L_0x0572:
        r1 = "content";
        r0 = r0.getJSONObject(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "point";
        r1 = r0.getJSONObject(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = "y";
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = java.lang.Double.parseDouble(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setLatitude(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = "x";
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r2 = java.lang.Double.parseDouble(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setLongitude(r2);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "radius";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = java.lang.Float.parseFloat(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setRadius(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r1 = "isCellChanged";
        r0 = r0.getString(r1);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = java.lang.Boolean.parseBoolean(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r12.setCellChangeFlag(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        r0 = "gcj02";
        r12.setCoorType(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x009e;
    L_0x05c4:
        r0 = 167; // 0xa7 float:2.34E-43 double:8.25E-322;
        if (r2 != r0) goto L_0x009e;
    L_0x05c8:
        r0 = 2;
        r12.setLocationWhere(r0);	 Catch:{ Exception -> 0x015f, Error -> 0x017a }
        goto L_0x009e;
    L_0x05ce:
        r1 = move-exception;
        goto L_0x013c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.BDLocation.<init>(java.lang.String):void");
    }

    private void setCellChangeFlag(Boolean bool) {
        this.isCellChangeFlag = bool.booleanValue();
    }

    public int describeContents() {
        return 0;
    }

    public String getAddrStr() {
        return this.mAddr.address;
    }

    public Address getAddress() {
        return this.mAddr;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public String getBuildingID() {
        return this.buildingid;
    }

    public String getBuildingName() {
        return this.mBuildingName;
    }

    public String getCity() {
        return this.mAddr.city;
    }

    public String getCityCode() {
        return this.mAddr.cityCode;
    }

    public String getCoorType() {
        return this.mCoorType;
    }

    public String getCountry() {
        return this.mAddr.country;
    }

    public String getCountryCode() {
        return this.mAddr.countryCode;
    }

    public float getDerect() {
        return this.mDerect;
    }

    public float getDirection() {
        return this.mDerect;
    }

    public String getDistrict() {
        return this.mAddr.district;
    }

    public String getFloor() {
        return this.floor;
    }

    public int getGpsAccuracyStatus() {
        return this.mGpsAccuracyStatus;
    }

    public int getGpsCheckStatus() {
        return this.mGpsCheckStatus;
    }

    public int getIndoorLocationSource() {
        return this.mIndoorSource;
    }

    public int getIndoorLocationSurpport() {
        return this.mIndoorLocationSurpport;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        return this.mIndoorSurpportBuildingID;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        return this.mIndoorSurpportBuildingName;
    }

    public int getIndoorNetworkState() {
        return this.mIndoorNetworkState;
    }

    public String getIndoorSurpportPolygon() {
        return this.mIndoorSurpportPolygon;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public int getLocType() {
        return this.mLocType;
    }

    public String getLocTypeDescription() {
        return this.mDescription;
    }

    public String getLocationDescribe() {
        return this.mSemaAptag;
    }

    public String getLocationID() {
        return this.locationID;
    }

    public int getLocationWhere() {
        return this.mLocationWhere;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getNetworkLocationType() {
        return this.netWorkLocationType;
    }

    public int getOperators() {
        return this.mOperators;
    }

    public List<Poi> getPoiList() {
        return this.mPoiList;
    }

    public String getProvince() {
        return this.mAddr.province;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public String getRetFields(String str) {
        return (String) this.retFields.get(str);
    }

    public int getSatelliteNumber() {
        this.mHasSateNumber = true;
        return this.mSatelliteNumber;
    }

    public String getSemaAptag() {
        return this.mSemaAptag;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public String getStreet() {
        return this.mAddr.street;
    }

    public String getStreetNumber() {
        return this.mAddr.streetNumber;
    }

    public String getTime() {
        return this.mTime;
    }

    public int getUserIndoorState() {
        return this.mIndoorState;
    }

    public boolean hasAddr() {
        return this.mHasAddr;
    }

    public boolean hasAltitude() {
        return this.mHasAltitude;
    }

    public boolean hasRadius() {
        return this.mHasRadius;
    }

    public boolean hasSateNumber() {
        return this.mHasSateNumber;
    }

    public boolean hasSpeed() {
        return this.mHasSpeed;
    }

    public boolean isCellChangeFlag() {
        return this.isCellChangeFlag;
    }

    public boolean isIndoorLocMode() {
        return this.indoorLocMode;
    }

    public int isParkAvailable() {
        return this.mParkState;
    }

    public void setAddr(Address address) {
        if (address != null) {
            this.mAddr = address;
            this.mHasAddr = true;
        }
    }

    public void setAddrStr(String str) {
        this.mAddrStr = str;
        if (str == null) {
            this.mHasAddr = false;
        } else {
            this.mHasAddr = true;
        }
    }

    public void setAltitude(double d) {
        this.mAltitude = d;
        this.mHasAltitude = true;
    }

    public void setBuildingID(String str) {
        this.buildingid = str;
    }

    public void setBuildingName(String str) {
        this.mBuildingName = str;
    }

    public void setCoorType(String str) {
        this.mCoorType = str;
    }

    public void setDirection(float f) {
        this.mDerect = f;
    }

    public void setFloor(String str) {
        this.floor = str;
    }

    public void setGpsAccuracyStatus(int i) {
        this.mGpsAccuracyStatus = i;
    }

    public void setGpsCheckStatus(int i) {
        this.mGpsCheckStatus = i;
    }

    public void setIndoorLocMode(boolean z) {
        this.indoorLocMode = z;
    }

    public void setIndoorLocationSource(int i) {
        this.mIndoorSource = i;
    }

    public void setIndoorLocationSurpport(int i) {
        this.mIndoorLocationSurpport = i;
    }

    public void setIndoorNetworkState(int i) {
        this.mIndoorNetworkState = i;
    }

    public void setIndoorSurpportPolygon(String str) {
        this.mIndoorSurpportPolygon = str;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public void setLocType(int i) {
        this.mLocType = i;
        switch (i) {
            case 61:
                setLocTypeDescription("GPS location successful!");
                setUserIndoorState(0);
                return;
            case 62:
                setLocTypeDescription("Location failed beacuse we can not get any loc information!");
                return;
            case 63:
            case 67:
                setLocTypeDescription("Offline location failed, please check the net (wifi/cell)!");
                return;
            case 66:
                setLocTypeDescription("Offline location successful!");
                return;
            case 161:
                setLocTypeDescription("NetWork location successful!");
                return;
            case 162:
                setLocTypeDescription("NetWork location failed because baidu location service can not decrypt the request query, please check the so file !");
                return;
            case 167:
                setLocTypeDescription("NetWork location failed because baidu location service can not caculate the location!");
                return;
            case 505:
                setLocTypeDescription("NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !");
                return;
            default:
                setLocTypeDescription("UnKnown!");
                return;
        }
    }

    public void setLocTypeDescription(String str) {
        this.mDescription = str;
    }

    public void setLocationDescribe(String str) {
        this.mSemaAptag = str;
    }

    public void setLocationID(String str) {
        this.locationID = str;
    }

    public void setLocationWhere(int i) {
        this.mLocationWhere = i;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public void setNetworkLocationType(String str) {
        this.netWorkLocationType = str;
    }

    public void setOperators(int i) {
        this.mOperators = i;
    }

    public void setParkAvailable(int i) {
        this.mParkState = i;
    }

    public void setPoiList(List<Poi> list) {
        this.mPoiList = list;
    }

    public void setRadius(float f) {
        this.mRadius = f;
        this.mHasRadius = true;
    }

    public void setSatelliteNumber(int i) {
        this.mSatelliteNumber = i;
    }

    public void setSpeed(float f) {
        this.mSpeed = f;
        this.mHasSpeed = true;
    }

    public void setTime(String str) {
        this.mTime = str;
        setLocationID(C3391g.m14436a(str));
    }

    public void setUserIndoorState(int i) {
        this.mIndoorState = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mLocType);
        parcel.writeString(this.mTime);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
        parcel.writeDouble(this.mAltitude);
        parcel.writeFloat(this.mSpeed);
        parcel.writeFloat(this.mRadius);
        parcel.writeInt(this.mSatelliteNumber);
        parcel.writeFloat(this.mDerect);
        parcel.writeString(this.floor);
        parcel.writeInt(this.mParkState);
        parcel.writeString(this.buildingid);
        parcel.writeString(this.mBuildingName);
        parcel.writeString(this.netWorkLocationType);
        parcel.writeString(this.mAddr.province);
        parcel.writeString(this.mAddr.city);
        parcel.writeString(this.mAddr.district);
        parcel.writeString(this.mAddr.street);
        parcel.writeString(this.mAddr.streetNumber);
        parcel.writeString(this.mAddr.cityCode);
        parcel.writeString(this.mAddr.address);
        parcel.writeString(this.mAddr.country);
        parcel.writeString(this.mAddr.countryCode);
        parcel.writeInt(this.mOperators);
        parcel.writeString(this.mCu);
        parcel.writeString(this.mSemaAptag);
        parcel.writeString(this.mSemaPoiRegion);
        parcel.writeString(this.mSemaRegular);
        parcel.writeInt(this.mLocationWhere);
        parcel.writeString(this.mDescription);
        parcel.writeInt(this.mIndoorState);
        parcel.writeInt(this.mIndoorLocationSurpport);
        parcel.writeInt(this.mIndoorNetworkState);
        parcel.writeInt(this.mIndoorSource);
        parcel.writeString(this.mIndoorSurpportBuildingName);
        parcel.writeString(this.mIndoorSurpportBuildingID);
        parcel.writeString(this.mIndoorSurpportPolygon);
        parcel.writeInt(this.mGpsAccuracyStatus);
        parcel.writeString(this.locationID);
        parcel.writeInt(this.mGpsCheckStatus);
        parcel.writeBooleanArray(new boolean[]{this.mHasAltitude, this.mHasSpeed, this.mHasRadius, this.mHasSateNumber, this.mHasAddr, this.isCellChangeFlag, this.indoorLocMode});
        parcel.writeList(this.mPoiList);
    }
}
