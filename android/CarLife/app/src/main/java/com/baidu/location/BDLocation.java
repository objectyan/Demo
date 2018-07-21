package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.location.h.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class BDLocation
  implements Parcelable
{
  public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
  public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
  public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
  public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
  public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
  public static final Parcelable.Creator<BDLocation> CREATOR = new Parcelable.Creator()
  {
    public BDLocation createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BDLocation(paramAnonymousParcel, null);
    }
    
    public BDLocation[] newArray(int paramAnonymousInt)
    {
      return new BDLocation[paramAnonymousInt];
    }
  };
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
  private String buildingid = null;
  private String floor = null;
  private boolean indoorLocMode = false;
  private boolean isCellChangeFlag = false;
  private String locationID = null;
  private Address mAddr = new Address.Builder().build();
  private String mAddrStr = null;
  private double mAltitude = Double.MIN_VALUE;
  private String mBuildingName = null;
  private String mCoorType = null;
  private String mCu = "";
  private float mDerect = -1.0F;
  private String mDescription = null;
  private int mGpsAccuracyStatus = 0;
  private int mGpsCheckStatus = 0;
  private boolean mHasAddr = false;
  private boolean mHasAltitude = false;
  private boolean mHasRadius = false;
  private boolean mHasSateNumber = false;
  private boolean mHasSpeed = false;
  private int mIndoorLocationSurpport = 0;
  private int mIndoorNetworkState = 2;
  private int mIndoorSource = 0;
  private int mIndoorState = -1;
  private String mIndoorSurpportBuildingID = null;
  private String mIndoorSurpportBuildingName = null;
  private String mIndoorSurpportPolygon = null;
  private double mLatitude = Double.MIN_VALUE;
  private int mLocType = 0;
  private int mLocationWhere = 1;
  private double mLongitude = Double.MIN_VALUE;
  private int mOperators;
  private int mParkState = 0;
  private List<Poi> mPoiList = null;
  private float mRadius = 0.0F;
  private int mSatelliteNumber = -1;
  private String mSemaAptag = null;
  private String mSemaPoiRegion = null;
  private String mSemaRegular = null;
  private float mSpeed = 0.0F;
  private String mTime = null;
  private String netWorkLocationType = null;
  private HashMap<String, String> retFields = new HashMap();
  
  public BDLocation() {}
  
  private BDLocation(Parcel paramParcel)
  {
    this.mLocType = paramParcel.readInt();
    this.mTime = paramParcel.readString();
    this.mLatitude = paramParcel.readDouble();
    this.mLongitude = paramParcel.readDouble();
    this.mAltitude = paramParcel.readDouble();
    this.mSpeed = paramParcel.readFloat();
    this.mRadius = paramParcel.readFloat();
    this.mSatelliteNumber = paramParcel.readInt();
    this.mDerect = paramParcel.readFloat();
    this.floor = paramParcel.readString();
    this.mParkState = paramParcel.readInt();
    this.buildingid = paramParcel.readString();
    this.mBuildingName = paramParcel.readString();
    this.netWorkLocationType = paramParcel.readString();
    Object localObject = paramParcel.readString();
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    paramParcel.readString();
    String str6 = paramParcel.readString();
    String str7 = paramParcel.readString();
    this.mAddr = new Address.Builder().country(str6).countryCode(str7).province((String)localObject).city(str1).cityCode(str5).district(str2).street(str3).streetNumber(str4).build();
    localObject = new boolean[7];
    this.mOperators = paramParcel.readInt();
    this.mCu = paramParcel.readString();
    this.mSemaAptag = paramParcel.readString();
    this.mSemaPoiRegion = paramParcel.readString();
    this.mSemaRegular = paramParcel.readString();
    this.mLocationWhere = paramParcel.readInt();
    this.mDescription = paramParcel.readString();
    this.mIndoorState = paramParcel.readInt();
    this.mIndoorLocationSurpport = paramParcel.readInt();
    this.mIndoorNetworkState = paramParcel.readInt();
    this.mIndoorSource = paramParcel.readInt();
    this.mIndoorSurpportBuildingName = paramParcel.readString();
    this.mIndoorSurpportBuildingID = paramParcel.readString();
    this.mIndoorSurpportPolygon = paramParcel.readString();
    this.mGpsAccuracyStatus = paramParcel.readInt();
    this.locationID = paramParcel.readString();
    this.mGpsCheckStatus = paramParcel.readInt();
    try
    {
      paramParcel.readBooleanArray((boolean[])localObject);
      this.mHasAltitude = localObject[0];
      this.mHasSpeed = localObject[1];
      this.mHasRadius = localObject[2];
      this.mHasSateNumber = localObject[3];
      this.mHasAddr = localObject[4];
      this.isCellChangeFlag = localObject[5];
      this.indoorLocMode = localObject[6];
      localObject = new ArrayList();
      paramParcel.readList((List)localObject, Poi.class.getClassLoader());
      if (((List)localObject).size() == 0)
      {
        this.mPoiList = null;
        return;
      }
      this.mPoiList = ((List)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public BDLocation(BDLocation paramBDLocation)
  {
    this.mLocType = paramBDLocation.mLocType;
    this.mTime = paramBDLocation.mTime;
    this.mLatitude = paramBDLocation.mLatitude;
    this.mLongitude = paramBDLocation.mLongitude;
    this.mHasAltitude = paramBDLocation.mHasAltitude;
    this.mAltitude = paramBDLocation.mAltitude;
    this.mHasSpeed = paramBDLocation.mHasSpeed;
    this.mSpeed = paramBDLocation.mSpeed;
    this.mHasRadius = paramBDLocation.mHasRadius;
    this.mRadius = paramBDLocation.mRadius;
    this.mHasSateNumber = paramBDLocation.mHasSateNumber;
    this.mSatelliteNumber = paramBDLocation.mSatelliteNumber;
    this.mDerect = paramBDLocation.mDerect;
    this.mCoorType = paramBDLocation.mCoorType;
    this.mHasAddr = paramBDLocation.mHasAddr;
    this.mAddrStr = paramBDLocation.mAddrStr;
    this.isCellChangeFlag = paramBDLocation.isCellChangeFlag;
    this.mAddr = new Address.Builder().country(paramBDLocation.mAddr.country).countryCode(paramBDLocation.mAddr.countryCode).province(paramBDLocation.mAddr.province).city(paramBDLocation.mAddr.city).cityCode(paramBDLocation.mAddr.cityCode).district(paramBDLocation.mAddr.district).street(paramBDLocation.mAddr.street).streetNumber(paramBDLocation.mAddr.streetNumber).build();
    this.floor = paramBDLocation.floor;
    this.buildingid = paramBDLocation.buildingid;
    this.mBuildingName = paramBDLocation.mBuildingName;
    this.mLocationWhere = paramBDLocation.mLocationWhere;
    this.mParkState = paramBDLocation.mParkState;
    this.indoorLocMode = paramBDLocation.indoorLocMode;
    this.netWorkLocationType = paramBDLocation.netWorkLocationType;
    this.mOperators = paramBDLocation.mOperators;
    this.mCu = paramBDLocation.mCu;
    this.mSemaAptag = paramBDLocation.mSemaAptag;
    this.mSemaPoiRegion = paramBDLocation.mSemaPoiRegion;
    this.mSemaRegular = paramBDLocation.mSemaRegular;
    this.mIndoorState = paramBDLocation.mIndoorState;
    this.mIndoorLocationSurpport = paramBDLocation.mIndoorLocationSurpport;
    this.mIndoorNetworkState = paramBDLocation.mIndoorLocationSurpport;
    this.mIndoorSource = paramBDLocation.mIndoorSource;
    this.mIndoorSurpportBuildingName = paramBDLocation.mIndoorSurpportBuildingName;
    this.mIndoorSurpportBuildingID = paramBDLocation.mIndoorSurpportBuildingID;
    this.mIndoorSurpportPolygon = paramBDLocation.mIndoorSurpportPolygon;
    this.mGpsAccuracyStatus = paramBDLocation.mGpsAccuracyStatus;
    this.locationID = paramBDLocation.locationID;
    if (paramBDLocation.mPoiList == null) {}
    ArrayList localArrayList;
    for (this.mPoiList = null;; this.mPoiList = localArrayList)
    {
      this.mDescription = paramBDLocation.mDescription;
      this.retFields = paramBDLocation.retFields;
      this.mGpsCheckStatus = paramBDLocation.mGpsCheckStatus;
      return;
      localArrayList = new ArrayList();
      int i = 0;
      while (i < paramBDLocation.mPoiList.size())
      {
        Poi localPoi = (Poi)paramBDLocation.mPoiList.get(i);
        localArrayList.add(new Poi(localPoi.getId(), localPoi.getName(), localPoi.getRank()));
        i += 1;
      }
    }
  }
  
  /* Error */
  public BDLocation(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 146	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 148	com/baidu/location/BDLocation:mLocType	I
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 150	com/baidu/location/BDLocation:mTime	Ljava/lang/String;
    //   14: aload_0
    //   15: ldc2_w 151
    //   18: putfield 154	com/baidu/location/BDLocation:mLatitude	D
    //   21: aload_0
    //   22: ldc2_w 151
    //   25: putfield 156	com/baidu/location/BDLocation:mLongitude	D
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 158	com/baidu/location/BDLocation:mHasAltitude	Z
    //   33: aload_0
    //   34: ldc2_w 151
    //   37: putfield 160	com/baidu/location/BDLocation:mAltitude	D
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 162	com/baidu/location/BDLocation:mHasSpeed	Z
    //   45: aload_0
    //   46: fconst_0
    //   47: putfield 164	com/baidu/location/BDLocation:mSpeed	F
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 166	com/baidu/location/BDLocation:mHasRadius	Z
    //   55: aload_0
    //   56: fconst_0
    //   57: putfield 168	com/baidu/location/BDLocation:mRadius	F
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 170	com/baidu/location/BDLocation:mHasSateNumber	Z
    //   65: aload_0
    //   66: iconst_m1
    //   67: putfield 172	com/baidu/location/BDLocation:mSatelliteNumber	I
    //   70: aload_0
    //   71: ldc -83
    //   73: putfield 175	com/baidu/location/BDLocation:mDerect	F
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 177	com/baidu/location/BDLocation:mCoorType	Ljava/lang/String;
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 179	com/baidu/location/BDLocation:mHasAddr	Z
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 181	com/baidu/location/BDLocation:mAddrStr	Ljava/lang/String;
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 183	com/baidu/location/BDLocation:mSemaAptag	Ljava/lang/String;
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 185	com/baidu/location/BDLocation:mSemaPoiRegion	Ljava/lang/String;
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 187	com/baidu/location/BDLocation:mSemaRegular	Ljava/lang/String;
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 189	com/baidu/location/BDLocation:isCellChangeFlag	Z
    //   111: aload_0
    //   112: new 191	com/baidu/location/Address$Builder
    //   115: dup
    //   116: invokespecial 192	com/baidu/location/Address$Builder:<init>	()V
    //   119: invokevirtual 196	com/baidu/location/Address$Builder:build	()Lcom/baidu/location/Address;
    //   122: putfield 198	com/baidu/location/BDLocation:mAddr	Lcom/baidu/location/Address;
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 200	com/baidu/location/BDLocation:floor	Ljava/lang/String;
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 202	com/baidu/location/BDLocation:buildingid	Ljava/lang/String;
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 204	com/baidu/location/BDLocation:mBuildingName	Ljava/lang/String;
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 206	com/baidu/location/BDLocation:indoorLocMode	Z
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 208	com/baidu/location/BDLocation:mParkState	I
    //   150: aload_0
    //   151: iconst_1
    //   152: putfield 210	com/baidu/location/BDLocation:mLocationWhere	I
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 212	com/baidu/location/BDLocation:netWorkLocationType	Ljava/lang/String;
    //   160: aload_0
    //   161: ldc -42
    //   163: putfield 216	com/baidu/location/BDLocation:mCu	Ljava/lang/String;
    //   166: aload_0
    //   167: iconst_m1
    //   168: putfield 218	com/baidu/location/BDLocation:mIndoorState	I
    //   171: aload_0
    //   172: iconst_0
    //   173: putfield 220	com/baidu/location/BDLocation:mIndoorLocationSurpport	I
    //   176: aload_0
    //   177: iconst_2
    //   178: putfield 222	com/baidu/location/BDLocation:mIndoorNetworkState	I
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 224	com/baidu/location/BDLocation:mIndoorSource	I
    //   186: aload_0
    //   187: aconst_null
    //   188: putfield 226	com/baidu/location/BDLocation:mIndoorSurpportBuildingName	Ljava/lang/String;
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 228	com/baidu/location/BDLocation:mIndoorSurpportBuildingID	Ljava/lang/String;
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 230	com/baidu/location/BDLocation:mIndoorSurpportPolygon	Ljava/lang/String;
    //   201: aload_0
    //   202: aconst_null
    //   203: putfield 232	com/baidu/location/BDLocation:mPoiList	Ljava/util/List;
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 234	com/baidu/location/BDLocation:mDescription	Ljava/lang/String;
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 236	com/baidu/location/BDLocation:locationID	Ljava/lang/String;
    //   216: aload_0
    //   217: new 238	java/util/HashMap
    //   220: dup
    //   221: invokespecial 239	java/util/HashMap:<init>	()V
    //   224: putfield 241	com/baidu/location/BDLocation:retFields	Ljava/util/HashMap;
    //   227: aload_0
    //   228: iconst_0
    //   229: putfield 243	com/baidu/location/BDLocation:mGpsAccuracyStatus	I
    //   232: aload_0
    //   233: iconst_0
    //   234: putfield 245	com/baidu/location/BDLocation:mGpsCheckStatus	I
    //   237: aload_1
    //   238: ifnull +12 -> 250
    //   241: aload_1
    //   242: ldc -42
    //   244: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +4 -> 251
    //   250: return
    //   251: new 369	org/json/JSONObject
    //   254: dup
    //   255: aload_1
    //   256: invokespecial 371	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   259: astore_1
    //   260: aload_1
    //   261: ldc_w 373
    //   264: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   267: astore 5
    //   269: aload 5
    //   271: ldc_w 379
    //   274: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   277: invokestatic 389	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   280: istore_2
    //   281: aload_0
    //   282: iload_2
    //   283: invokevirtual 393	com/baidu/location/BDLocation:setLocType	(I)V
    //   286: aload_0
    //   287: aload 5
    //   289: ldc_w 395
    //   292: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   295: invokevirtual 398	com/baidu/location/BDLocation:setTime	(Ljava/lang/String;)V
    //   298: iload_2
    //   299: bipush 61
    //   301: if_icmpne +222 -> 523
    //   304: aload_1
    //   305: ldc_w 400
    //   308: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   311: astore_1
    //   312: aload_1
    //   313: ldc_w 402
    //   316: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   319: astore 5
    //   321: aload_0
    //   322: aload 5
    //   324: ldc_w 404
    //   327: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   330: invokestatic 410	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   333: invokevirtual 414	com/baidu/location/BDLocation:setLatitude	(D)V
    //   336: aload_0
    //   337: aload 5
    //   339: ldc_w 416
    //   342: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   345: invokestatic 410	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   348: invokevirtual 419	com/baidu/location/BDLocation:setLongitude	(D)V
    //   351: aload_0
    //   352: aload_1
    //   353: ldc_w 421
    //   356: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   359: invokestatic 427	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   362: invokevirtual 431	com/baidu/location/BDLocation:setRadius	(F)V
    //   365: aload_0
    //   366: aload_1
    //   367: ldc_w 433
    //   370: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   373: invokestatic 427	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   376: invokevirtual 436	com/baidu/location/BDLocation:setSpeed	(F)V
    //   379: aload_0
    //   380: aload_1
    //   381: ldc_w 438
    //   384: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   387: invokestatic 427	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   390: invokevirtual 441	com/baidu/location/BDLocation:setDirection	(F)V
    //   393: aload_0
    //   394: aload_1
    //   395: ldc_w 443
    //   398: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: invokestatic 389	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   404: invokevirtual 446	com/baidu/location/BDLocation:setSatelliteNumber	(I)V
    //   407: aload_1
    //   408: ldc_w 448
    //   411: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   414: istore 4
    //   416: iload 4
    //   418: ifeq +14 -> 432
    //   421: aload_0
    //   422: aload_1
    //   423: ldc_w 448
    //   426: invokevirtual 455	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   429: invokevirtual 458	com/baidu/location/BDLocation:setAltitude	(D)V
    //   432: aload_1
    //   433: ldc_w 460
    //   436: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   439: ifeq +48 -> 487
    //   442: aload_0
    //   443: aload_1
    //   444: ldc_w 460
    //   447: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   450: invokestatic 389	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   453: invokevirtual 463	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   456: aload_0
    //   457: getfield 210	com/baidu/location/BDLocation:mLocationWhere	I
    //   460: ifne +39 -> 499
    //   463: aload_0
    //   464: ldc_w 465
    //   467: invokevirtual 468	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   470: return
    //   471: astore_1
    //   472: aload_1
    //   473: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   476: aload_0
    //   477: iconst_0
    //   478: putfield 148	com/baidu/location/BDLocation:mLocType	I
    //   481: aload_0
    //   482: iconst_0
    //   483: putfield 179	com/baidu/location/BDLocation:mHasAddr	Z
    //   486: return
    //   487: aload_0
    //   488: iconst_1
    //   489: invokevirtual 463	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   492: goto -36 -> 456
    //   495: astore_1
    //   496: goto -40 -> 456
    //   499: aload_0
    //   500: ldc_w 473
    //   503: invokevirtual 468	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   506: return
    //   507: astore_1
    //   508: aload_1
    //   509: invokevirtual 474	java/lang/Error:printStackTrace	()V
    //   512: aload_0
    //   513: iconst_0
    //   514: putfield 148	com/baidu/location/BDLocation:mLocType	I
    //   517: aload_0
    //   518: iconst_0
    //   519: putfield 179	com/baidu/location/BDLocation:mHasAddr	Z
    //   522: return
    //   523: iload_2
    //   524: sipush 161
    //   527: if_icmpne +1557 -> 2084
    //   530: aload_1
    //   531: ldc_w 400
    //   534: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   537: astore 20
    //   539: aload 20
    //   541: ldc_w 402
    //   544: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   547: astore_1
    //   548: aload_0
    //   549: aload_1
    //   550: ldc_w 404
    //   553: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   556: invokestatic 410	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   559: invokevirtual 414	com/baidu/location/BDLocation:setLatitude	(D)V
    //   562: aload_0
    //   563: aload_1
    //   564: ldc_w 416
    //   567: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   570: invokestatic 410	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   573: invokevirtual 419	com/baidu/location/BDLocation:setLongitude	(D)V
    //   576: aload_0
    //   577: aload 20
    //   579: ldc_w 421
    //   582: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   585: invokestatic 427	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   588: invokevirtual 431	com/baidu/location/BDLocation:setRadius	(F)V
    //   591: aload 20
    //   593: ldc_w 476
    //   596: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   599: ifeq +226 -> 825
    //   602: aload 20
    //   604: ldc_w 476
    //   607: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   610: astore_1
    //   611: aload_1
    //   612: ldc_w 478
    //   615: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   618: ifeq +26 -> 644
    //   621: aload_1
    //   622: ldc_w 478
    //   625: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   628: astore 5
    //   630: aload 5
    //   632: invokestatic 484	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   635: ifne +112 -> 747
    //   638: aload_0
    //   639: aload 5
    //   641: putfield 183	com/baidu/location/BDLocation:mSemaAptag	Ljava/lang/String;
    //   644: aload_1
    //   645: ldc_w 486
    //   648: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   651: ifeq +111 -> 762
    //   654: aload_1
    //   655: ldc_w 486
    //   658: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   661: ldc_w 488
    //   664: invokevirtual 492	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   667: astore 5
    //   669: new 299	java/util/ArrayList
    //   672: dup
    //   673: invokespecial 300	java/util/ArrayList:<init>	()V
    //   676: astore 6
    //   678: iconst_0
    //   679: istore_2
    //   680: iload_2
    //   681: aload 5
    //   683: invokevirtual 497	org/json/JSONArray:length	()I
    //   686: if_icmpge +70 -> 756
    //   689: aload 5
    //   691: iload_2
    //   692: invokevirtual 500	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   695: astore 7
    //   697: aload 7
    //   699: ldc_w 502
    //   702: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   705: astore 8
    //   707: aload 6
    //   709: new 302	com/baidu/location/Poi
    //   712: dup
    //   713: aload 7
    //   715: ldc_w 504
    //   718: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   721: aload 8
    //   723: aload 7
    //   725: ldc_w 506
    //   728: invokevirtual 455	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   731: invokespecial 355	com/baidu/location/Poi:<init>	(Ljava/lang/String;Ljava/lang/String;D)V
    //   734: invokeinterface 359 2 0
    //   739: pop
    //   740: iload_2
    //   741: iconst_1
    //   742: iadd
    //   743: istore_2
    //   744: goto -64 -> 680
    //   747: aload_0
    //   748: ldc -42
    //   750: putfield 183	com/baidu/location/BDLocation:mSemaAptag	Ljava/lang/String;
    //   753: goto -109 -> 644
    //   756: aload_0
    //   757: aload 6
    //   759: putfield 232	com/baidu/location/BDLocation:mPoiList	Ljava/util/List;
    //   762: aload_1
    //   763: ldc_w 508
    //   766: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   769: ifeq +26 -> 795
    //   772: aload_1
    //   773: ldc_w 508
    //   776: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   779: astore 5
    //   781: aload 5
    //   783: invokestatic 484	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   786: ifne +9 -> 795
    //   789: aload_0
    //   790: aload 5
    //   792: putfield 185	com/baidu/location/BDLocation:mSemaPoiRegion	Ljava/lang/String;
    //   795: aload_1
    //   796: ldc_w 510
    //   799: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   802: ifeq +23 -> 825
    //   805: aload_1
    //   806: ldc_w 510
    //   809: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   812: astore_1
    //   813: aload_1
    //   814: invokestatic 484	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   817: ifne +8 -> 825
    //   820: aload_0
    //   821: aload_1
    //   822: putfield 187	com/baidu/location/BDLocation:mSemaRegular	Ljava/lang/String;
    //   825: aload 20
    //   827: ldc_w 512
    //   830: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   833: ifeq +846 -> 1679
    //   836: aconst_null
    //   837: astore 12
    //   839: aconst_null
    //   840: astore 8
    //   842: aconst_null
    //   843: astore_1
    //   844: aconst_null
    //   845: astore 5
    //   847: aconst_null
    //   848: astore 11
    //   850: aconst_null
    //   851: astore 6
    //   853: aconst_null
    //   854: astore 9
    //   856: aconst_null
    //   857: astore 10
    //   859: aload 20
    //   861: ldc_w 512
    //   864: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   867: astore 7
    //   869: new 369	org/json/JSONObject
    //   872: dup
    //   873: aload 7
    //   875: invokespecial 371	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   878: astore 13
    //   880: aload 13
    //   882: ifnull +771 -> 1653
    //   885: ldc -42
    //   887: astore 6
    //   889: ldc -42
    //   891: astore 9
    //   893: ldc -42
    //   895: astore 10
    //   897: ldc -42
    //   899: astore_1
    //   900: ldc -42
    //   902: astore 5
    //   904: ldc -42
    //   906: astore 11
    //   908: ldc -42
    //   910: astore 12
    //   912: ldc -42
    //   914: astore 7
    //   916: aload 13
    //   918: ldc_w 513
    //   921: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   924: ifeq +12 -> 936
    //   927: aload 13
    //   929: ldc_w 513
    //   932: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   935: astore_1
    //   936: aload 13
    //   938: ldc_w 515
    //   941: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   944: ifeq +13 -> 957
    //   947: aload 13
    //   949: ldc_w 515
    //   952: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   955: astore 5
    //   957: aload 13
    //   959: ldc_w 516
    //   962: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   965: ifeq +13 -> 978
    //   968: aload 13
    //   970: ldc_w 516
    //   973: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   976: astore 6
    //   978: aload 13
    //   980: ldc_w 518
    //   983: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   986: ifeq +13 -> 999
    //   989: aload 13
    //   991: ldc_w 518
    //   994: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   997: astore 9
    //   999: aload 13
    //   1001: ldc_w 519
    //   1004: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1007: ifeq +13 -> 1020
    //   1010: aload 13
    //   1012: ldc_w 519
    //   1015: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1018: astore 10
    //   1020: aload 13
    //   1022: ldc_w 520
    //   1025: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1028: ifeq +13 -> 1041
    //   1031: aload 13
    //   1033: ldc_w 520
    //   1036: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1039: astore 11
    //   1041: aload 13
    //   1043: ldc_w 521
    //   1046: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1049: ifeq +13 -> 1062
    //   1052: aload 13
    //   1054: ldc_w 521
    //   1057: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1060: astore 12
    //   1062: aload 12
    //   1064: astore 14
    //   1066: aload 11
    //   1068: astore 15
    //   1070: aload 5
    //   1072: astore 16
    //   1074: aload_1
    //   1075: astore 17
    //   1077: aload 10
    //   1079: astore 18
    //   1081: aload 9
    //   1083: astore 8
    //   1085: aload 6
    //   1087: astore 19
    //   1089: aload 13
    //   1091: ldc_w 523
    //   1094: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1097: ifeq +40 -> 1137
    //   1100: aload 13
    //   1102: ldc_w 523
    //   1105: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1108: astore 7
    //   1110: aload 6
    //   1112: astore 19
    //   1114: aload 9
    //   1116: astore 8
    //   1118: aload 10
    //   1120: astore 18
    //   1122: aload_1
    //   1123: astore 17
    //   1125: aload 5
    //   1127: astore 16
    //   1129: aload 11
    //   1131: astore 15
    //   1133: aload 12
    //   1135: astore 14
    //   1137: aload_0
    //   1138: new 191	com/baidu/location/Address$Builder
    //   1141: dup
    //   1142: invokespecial 192	com/baidu/location/Address$Builder:<init>	()V
    //   1145: aload 19
    //   1147: invokevirtual 270	com/baidu/location/Address$Builder:country	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   1150: aload 8
    //   1152: invokevirtual 273	com/baidu/location/Address$Builder:countryCode	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   1155: aload 18
    //   1157: invokevirtual 276	com/baidu/location/Address$Builder:province	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   1160: aload 17
    //   1162: invokevirtual 279	com/baidu/location/Address$Builder:city	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   1165: aload 16
    //   1167: invokevirtual 282	com/baidu/location/Address$Builder:cityCode	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   1170: aload 15
    //   1172: invokevirtual 285	com/baidu/location/Address$Builder:district	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   1175: aload 14
    //   1177: invokevirtual 288	com/baidu/location/Address$Builder:street	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   1180: aload 7
    //   1182: invokevirtual 291	com/baidu/location/Address$Builder:streetNumber	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   1185: invokevirtual 196	com/baidu/location/Address$Builder:build	()Lcom/baidu/location/Address;
    //   1188: putfield 198	com/baidu/location/BDLocation:mAddr	Lcom/baidu/location/Address;
    //   1191: aload_0
    //   1192: iconst_1
    //   1193: putfield 179	com/baidu/location/BDLocation:mHasAddr	Z
    //   1196: aload 20
    //   1198: ldc_w 524
    //   1201: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1204: ifeq +30 -> 1234
    //   1207: aload_0
    //   1208: aload 20
    //   1210: ldc_w 524
    //   1213: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1216: putfield 200	com/baidu/location/BDLocation:floor	Ljava/lang/String;
    //   1219: aload_0
    //   1220: getfield 200	com/baidu/location/BDLocation:floor	Ljava/lang/String;
    //   1223: invokestatic 484	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1226: ifeq +8 -> 1234
    //   1229: aload_0
    //   1230: aconst_null
    //   1231: putfield 200	com/baidu/location/BDLocation:floor	Ljava/lang/String;
    //   1234: aload 20
    //   1236: ldc_w 526
    //   1239: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1242: ifeq +30 -> 1272
    //   1245: aload 20
    //   1247: ldc_w 526
    //   1250: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1253: astore_1
    //   1254: aload_1
    //   1255: invokestatic 484	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1258: ifne +14 -> 1272
    //   1261: aload_0
    //   1262: aload_1
    //   1263: invokestatic 530	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1266: invokevirtual 533	java/lang/Integer:intValue	()I
    //   1269: invokevirtual 536	com/baidu/location/BDLocation:setUserIndoorState	(I)V
    //   1272: aload 20
    //   1274: ldc_w 538
    //   1277: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1280: ifeq +30 -> 1310
    //   1283: aload_0
    //   1284: aload 20
    //   1286: ldc_w 538
    //   1289: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1292: putfield 212	com/baidu/location/BDLocation:netWorkLocationType	Ljava/lang/String;
    //   1295: aload_0
    //   1296: getfield 212	com/baidu/location/BDLocation:netWorkLocationType	Ljava/lang/String;
    //   1299: invokestatic 484	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1302: ifeq +8 -> 1310
    //   1305: aload_0
    //   1306: aconst_null
    //   1307: putfield 212	com/baidu/location/BDLocation:netWorkLocationType	Ljava/lang/String;
    //   1310: aload 20
    //   1312: ldc_w 540
    //   1315: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1318: ifeq +30 -> 1348
    //   1321: aload_0
    //   1322: aload 20
    //   1324: ldc_w 540
    //   1327: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1330: putfield 202	com/baidu/location/BDLocation:buildingid	Ljava/lang/String;
    //   1333: aload_0
    //   1334: getfield 202	com/baidu/location/BDLocation:buildingid	Ljava/lang/String;
    //   1337: invokestatic 484	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1340: ifeq +8 -> 1348
    //   1343: aload_0
    //   1344: aconst_null
    //   1345: putfield 202	com/baidu/location/BDLocation:buildingid	Ljava/lang/String;
    //   1348: aload 20
    //   1350: ldc_w 542
    //   1353: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1356: ifeq +30 -> 1386
    //   1359: aload_0
    //   1360: aload 20
    //   1362: ldc_w 542
    //   1365: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1368: putfield 204	com/baidu/location/BDLocation:mBuildingName	Ljava/lang/String;
    //   1371: aload_0
    //   1372: getfield 204	com/baidu/location/BDLocation:mBuildingName	Ljava/lang/String;
    //   1375: invokestatic 484	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1378: ifeq +8 -> 1386
    //   1381: aload_0
    //   1382: aconst_null
    //   1383: putfield 204	com/baidu/location/BDLocation:mBuildingName	Ljava/lang/String;
    //   1386: aload 20
    //   1388: ldc_w 544
    //   1391: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1394: ifeq +24 -> 1418
    //   1397: aload 20
    //   1399: ldc_w 544
    //   1402: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1405: astore_1
    //   1406: aload_1
    //   1407: invokestatic 484	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1410: ifeq +282 -> 1692
    //   1413: aload_0
    //   1414: iconst_0
    //   1415: putfield 208	com/baidu/location/BDLocation:mParkState	I
    //   1418: aload 20
    //   1420: ldc_w 546
    //   1423: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1426: istore 4
    //   1428: iload 4
    //   1430: ifeq +312 -> 1742
    //   1433: aload 20
    //   1435: ldc_w 546
    //   1438: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1441: astore_1
    //   1442: aload_1
    //   1443: ldc_w 548
    //   1446: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1449: ifeq +26 -> 1475
    //   1452: aload_1
    //   1453: ldc_w 548
    //   1456: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1459: invokestatic 530	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1462: invokevirtual 533	java/lang/Integer:intValue	()I
    //   1465: istore_2
    //   1466: iload_2
    //   1467: ifne +257 -> 1724
    //   1470: aload_0
    //   1471: iconst_2
    //   1472: invokevirtual 551	com/baidu/location/BDLocation:setIndoorLocationSurpport	(I)V
    //   1475: aload_1
    //   1476: ldc_w 553
    //   1479: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1482: ifeq +20 -> 1502
    //   1485: aload_0
    //   1486: aload_1
    //   1487: ldc_w 553
    //   1490: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1493: invokestatic 530	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1496: invokevirtual 533	java/lang/Integer:intValue	()I
    //   1499: invokevirtual 556	com/baidu/location/BDLocation:setIndoorLocationSource	(I)V
    //   1502: aload_1
    //   1503: ldc_w 558
    //   1506: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1509: ifeq +14 -> 1523
    //   1512: aload_0
    //   1513: aload_1
    //   1514: ldc_w 558
    //   1517: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1520: putfield 226	com/baidu/location/BDLocation:mIndoorSurpportBuildingName	Ljava/lang/String;
    //   1523: aload_1
    //   1524: ldc_w 560
    //   1527: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1530: ifeq +14 -> 1544
    //   1533: aload_0
    //   1534: aload_1
    //   1535: ldc_w 560
    //   1538: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1541: putfield 228	com/baidu/location/BDLocation:mIndoorSurpportBuildingID	Ljava/lang/String;
    //   1544: aload_1
    //   1545: ldc_w 562
    //   1548: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1551: ifeq +14 -> 1565
    //   1554: aload_0
    //   1555: aload_1
    //   1556: ldc_w 562
    //   1559: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1562: invokevirtual 565	com/baidu/location/BDLocation:setIndoorSurpportPolygon	(Ljava/lang/String;)V
    //   1565: aload_1
    //   1566: ldc_w 567
    //   1569: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1572: istore 4
    //   1574: iload 4
    //   1576: ifeq +166 -> 1742
    //   1579: aload_1
    //   1580: ldc_w 567
    //   1583: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1586: ldc_w 569
    //   1589: invokevirtual 573	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1592: astore_1
    //   1593: aload_1
    //   1594: arraylength
    //   1595: istore_3
    //   1596: iconst_0
    //   1597: istore_2
    //   1598: iload_2
    //   1599: iload_3
    //   1600: if_icmpge +142 -> 1742
    //   1603: aload_1
    //   1604: iload_2
    //   1605: aaload
    //   1606: ldc_w 575
    //   1609: invokevirtual 573	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1612: astore 6
    //   1614: aload 6
    //   1616: iconst_0
    //   1617: aaload
    //   1618: astore 5
    //   1620: aload 6
    //   1622: iconst_1
    //   1623: aaload
    //   1624: astore 6
    //   1626: aload_0
    //   1627: getfield 241	com/baidu/location/BDLocation:retFields	Ljava/util/HashMap;
    //   1630: aload 5
    //   1632: aload 6
    //   1634: invokevirtual 579	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1637: pop
    //   1638: iload_2
    //   1639: iconst_1
    //   1640: iadd
    //   1641: istore_2
    //   1642: goto -44 -> 1598
    //   1645: astore 13
    //   1647: aconst_null
    //   1648: astore 13
    //   1650: goto -770 -> 880
    //   1653: aload 7
    //   1655: ldc_w 581
    //   1658: invokevirtual 573	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1661: astore 13
    //   1663: aload 13
    //   1665: arraylength
    //   1666: istore_2
    //   1667: iload_2
    //   1668: ifle +278 -> 1946
    //   1671: aload 13
    //   1673: iconst_0
    //   1674: aaload
    //   1675: astore_1
    //   1676: goto +270 -> 1946
    //   1679: aload_0
    //   1680: iconst_0
    //   1681: putfield 179	com/baidu/location/BDLocation:mHasAddr	Z
    //   1684: aload_0
    //   1685: aconst_null
    //   1686: invokevirtual 584	com/baidu/location/BDLocation:setAddrStr	(Ljava/lang/String;)V
    //   1689: goto -493 -> 1196
    //   1692: aload_1
    //   1693: ldc_w 586
    //   1696: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1699: ifeq +11 -> 1710
    //   1702: aload_0
    //   1703: iconst_0
    //   1704: putfield 208	com/baidu/location/BDLocation:mParkState	I
    //   1707: goto -289 -> 1418
    //   1710: aload_0
    //   1711: aload_1
    //   1712: invokestatic 530	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1715: invokevirtual 533	java/lang/Integer:intValue	()I
    //   1718: putfield 208	com/baidu/location/BDLocation:mParkState	I
    //   1721: goto -303 -> 1418
    //   1724: iload_2
    //   1725: iconst_1
    //   1726: if_icmpne -251 -> 1475
    //   1729: aload_0
    //   1730: iconst_1
    //   1731: invokevirtual 551	com/baidu/location/BDLocation:setIndoorLocationSurpport	(I)V
    //   1734: goto -259 -> 1475
    //   1737: astore_1
    //   1738: aload_1
    //   1739: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   1742: aload 20
    //   1744: ldc_w 588
    //   1747: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1750: ifeq +64 -> 1814
    //   1753: aload_0
    //   1754: aload 20
    //   1756: ldc_w 588
    //   1759: invokevirtual 591	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1762: invokevirtual 594	com/baidu/location/BDLocation:setGpsCheckStatus	(I)V
    //   1765: aload 20
    //   1767: ldc_w 460
    //   1770: invokevirtual 452	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1773: ifeq +49 -> 1822
    //   1776: aload_0
    //   1777: aload 20
    //   1779: ldc_w 460
    //   1782: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1785: invokestatic 389	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1788: invokevirtual 463	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   1791: aload_0
    //   1792: getfield 210	com/baidu/location/BDLocation:mLocationWhere	I
    //   1795: ifne +39 -> 1834
    //   1798: aload_0
    //   1799: ldc_w 465
    //   1802: invokevirtual 468	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   1805: return
    //   1806: astore_1
    //   1807: aload_1
    //   1808: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   1811: goto -69 -> 1742
    //   1814: aload_0
    //   1815: iconst_0
    //   1816: invokevirtual 594	com/baidu/location/BDLocation:setGpsCheckStatus	(I)V
    //   1819: goto -54 -> 1765
    //   1822: aload_0
    //   1823: iconst_1
    //   1824: invokevirtual 463	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   1827: goto -36 -> 1791
    //   1830: astore_1
    //   1831: goto -40 -> 1791
    //   1834: aload_0
    //   1835: ldc_w 473
    //   1838: invokevirtual 468	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   1841: return
    //   1842: aload_1
    //   1843: ldc_w 400
    //   1846: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1849: astore_1
    //   1850: aload_1
    //   1851: ldc_w 402
    //   1854: invokevirtual 377	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1857: astore 5
    //   1859: aload_0
    //   1860: aload 5
    //   1862: ldc_w 404
    //   1865: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1868: invokestatic 410	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1871: invokevirtual 414	com/baidu/location/BDLocation:setLatitude	(D)V
    //   1874: aload_0
    //   1875: aload 5
    //   1877: ldc_w 416
    //   1880: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1883: invokestatic 410	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1886: invokevirtual 419	com/baidu/location/BDLocation:setLongitude	(D)V
    //   1889: aload_0
    //   1890: aload_1
    //   1891: ldc_w 421
    //   1894: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1897: invokestatic 427	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1900: invokevirtual 431	com/baidu/location/BDLocation:setRadius	(F)V
    //   1903: aload_0
    //   1904: aload_1
    //   1905: ldc_w 596
    //   1908: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1911: invokestatic 601	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   1914: invokestatic 604	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1917: invokespecial 608	com/baidu/location/BDLocation:setCellChangeFlag	(Ljava/lang/Boolean;)V
    //   1920: aload_0
    //   1921: ldc_w 473
    //   1924: invokevirtual 468	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   1927: return
    //   1928: iload_2
    //   1929: sipush 167
    //   1932: if_icmpne -1682 -> 250
    //   1935: aload_0
    //   1936: iconst_2
    //   1937: invokevirtual 463	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   1940: return
    //   1941: astore 5
    //   1943: goto -1511 -> 432
    //   1946: iload_2
    //   1947: iconst_1
    //   1948: if_icmple +9 -> 1957
    //   1951: aload 13
    //   1953: iconst_1
    //   1954: aaload
    //   1955: astore 5
    //   1957: iload_2
    //   1958: iconst_2
    //   1959: if_icmple +9 -> 1968
    //   1962: aload 13
    //   1964: iconst_2
    //   1965: aaload
    //   1966: astore 6
    //   1968: iload_2
    //   1969: iconst_3
    //   1970: if_icmple +9 -> 1979
    //   1973: aload 13
    //   1975: iconst_3
    //   1976: aaload
    //   1977: astore 9
    //   1979: iload_2
    //   1980: iconst_4
    //   1981: if_icmple +9 -> 1990
    //   1984: aload 13
    //   1986: iconst_4
    //   1987: aaload
    //   1988: astore 10
    //   1990: iload_2
    //   1991: iconst_5
    //   1992: if_icmple +9 -> 2001
    //   1995: aload 13
    //   1997: iconst_5
    //   1998: aaload
    //   1999: astore 11
    //   2001: iload_2
    //   2002: bipush 6
    //   2004: if_icmple +10 -> 2014
    //   2007: aload 13
    //   2009: bipush 6
    //   2011: aaload
    //   2012: astore 12
    //   2014: aload 10
    //   2016: astore 7
    //   2018: aload 9
    //   2020: astore 14
    //   2022: aload 6
    //   2024: astore 15
    //   2026: aload 11
    //   2028: astore 16
    //   2030: aload 5
    //   2032: astore 17
    //   2034: aload_1
    //   2035: astore 18
    //   2037: aload 12
    //   2039: astore 19
    //   2041: iload_2
    //   2042: bipush 7
    //   2044: if_icmple -907 -> 1137
    //   2047: aload 13
    //   2049: bipush 7
    //   2051: aaload
    //   2052: astore 8
    //   2054: aload 10
    //   2056: astore 7
    //   2058: aload 9
    //   2060: astore 14
    //   2062: aload 6
    //   2064: astore 15
    //   2066: aload 11
    //   2068: astore 16
    //   2070: aload 5
    //   2072: astore 17
    //   2074: aload_1
    //   2075: astore 18
    //   2077: aload 12
    //   2079: astore 19
    //   2081: goto -944 -> 1137
    //   2084: iload_2
    //   2085: bipush 66
    //   2087: if_icmpeq -245 -> 1842
    //   2090: iload_2
    //   2091: bipush 68
    //   2093: if_icmpne -165 -> 1928
    //   2096: goto -254 -> 1842
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2099	0	this	BDLocation
    //   0	2099	1	paramString	String
    //   280	1814	2	i	int
    //   1595	6	3	j	int
    //   414	1161	4	bool	boolean
    //   267	1609	5	localObject1	Object
    //   1941	1	5	localException1	Exception
    //   1955	116	5	localObject2	Object
    //   676	1387	6	localObject3	Object
    //   695	1362	7	localObject4	Object
    //   705	1348	8	localObject5	Object
    //   854	1205	9	str1	String
    //   857	1198	10	str2	String
    //   848	1219	11	str3	String
    //   837	1241	12	str4	String
    //   878	223	13	localJSONObject1	org.json.JSONObject
    //   1645	1	13	localException2	Exception
    //   1648	400	13	arrayOfString	String[]
    //   1064	997	14	str5	String
    //   1068	997	15	localObject6	Object
    //   1072	997	16	localObject7	Object
    //   1075	998	17	localObject8	Object
    //   1079	997	18	str6	String
    //   1087	993	19	localObject9	Object
    //   537	1241	20	localJSONObject2	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   251	298	471	java/lang/Exception
    //   304	416	471	java/lang/Exception
    //   456	470	471	java/lang/Exception
    //   499	506	471	java/lang/Exception
    //   530	644	471	java/lang/Exception
    //   644	678	471	java/lang/Exception
    //   680	740	471	java/lang/Exception
    //   747	753	471	java/lang/Exception
    //   756	762	471	java/lang/Exception
    //   762	795	471	java/lang/Exception
    //   795	825	471	java/lang/Exception
    //   825	836	471	java/lang/Exception
    //   859	869	471	java/lang/Exception
    //   916	936	471	java/lang/Exception
    //   936	957	471	java/lang/Exception
    //   957	978	471	java/lang/Exception
    //   978	999	471	java/lang/Exception
    //   999	1020	471	java/lang/Exception
    //   1020	1041	471	java/lang/Exception
    //   1041	1062	471	java/lang/Exception
    //   1089	1110	471	java/lang/Exception
    //   1137	1196	471	java/lang/Exception
    //   1196	1234	471	java/lang/Exception
    //   1234	1272	471	java/lang/Exception
    //   1272	1310	471	java/lang/Exception
    //   1310	1348	471	java/lang/Exception
    //   1348	1386	471	java/lang/Exception
    //   1386	1418	471	java/lang/Exception
    //   1418	1428	471	java/lang/Exception
    //   1653	1667	471	java/lang/Exception
    //   1679	1689	471	java/lang/Exception
    //   1692	1707	471	java/lang/Exception
    //   1710	1721	471	java/lang/Exception
    //   1738	1742	471	java/lang/Exception
    //   1742	1765	471	java/lang/Exception
    //   1791	1805	471	java/lang/Exception
    //   1814	1819	471	java/lang/Exception
    //   1834	1841	471	java/lang/Exception
    //   1842	1927	471	java/lang/Exception
    //   1935	1940	471	java/lang/Exception
    //   432	456	495	java/lang/Exception
    //   487	492	495	java/lang/Exception
    //   251	298	507	java/lang/Error
    //   304	416	507	java/lang/Error
    //   421	432	507	java/lang/Error
    //   432	456	507	java/lang/Error
    //   456	470	507	java/lang/Error
    //   487	492	507	java/lang/Error
    //   499	506	507	java/lang/Error
    //   530	644	507	java/lang/Error
    //   644	678	507	java/lang/Error
    //   680	740	507	java/lang/Error
    //   747	753	507	java/lang/Error
    //   756	762	507	java/lang/Error
    //   762	795	507	java/lang/Error
    //   795	825	507	java/lang/Error
    //   825	836	507	java/lang/Error
    //   859	869	507	java/lang/Error
    //   869	880	507	java/lang/Error
    //   916	936	507	java/lang/Error
    //   936	957	507	java/lang/Error
    //   957	978	507	java/lang/Error
    //   978	999	507	java/lang/Error
    //   999	1020	507	java/lang/Error
    //   1020	1041	507	java/lang/Error
    //   1041	1062	507	java/lang/Error
    //   1089	1110	507	java/lang/Error
    //   1137	1196	507	java/lang/Error
    //   1196	1234	507	java/lang/Error
    //   1234	1272	507	java/lang/Error
    //   1272	1310	507	java/lang/Error
    //   1310	1348	507	java/lang/Error
    //   1348	1386	507	java/lang/Error
    //   1386	1418	507	java/lang/Error
    //   1418	1428	507	java/lang/Error
    //   1433	1466	507	java/lang/Error
    //   1470	1475	507	java/lang/Error
    //   1475	1502	507	java/lang/Error
    //   1502	1523	507	java/lang/Error
    //   1523	1544	507	java/lang/Error
    //   1544	1565	507	java/lang/Error
    //   1565	1574	507	java/lang/Error
    //   1579	1596	507	java/lang/Error
    //   1603	1614	507	java/lang/Error
    //   1626	1638	507	java/lang/Error
    //   1653	1667	507	java/lang/Error
    //   1679	1689	507	java/lang/Error
    //   1692	1707	507	java/lang/Error
    //   1710	1721	507	java/lang/Error
    //   1729	1734	507	java/lang/Error
    //   1738	1742	507	java/lang/Error
    //   1742	1765	507	java/lang/Error
    //   1765	1791	507	java/lang/Error
    //   1791	1805	507	java/lang/Error
    //   1807	1811	507	java/lang/Error
    //   1814	1819	507	java/lang/Error
    //   1822	1827	507	java/lang/Error
    //   1834	1841	507	java/lang/Error
    //   1842	1927	507	java/lang/Error
    //   1935	1940	507	java/lang/Error
    //   869	880	1645	java/lang/Exception
    //   1433	1466	1737	java/lang/Exception
    //   1470	1475	1737	java/lang/Exception
    //   1475	1502	1737	java/lang/Exception
    //   1502	1523	1737	java/lang/Exception
    //   1523	1544	1737	java/lang/Exception
    //   1544	1565	1737	java/lang/Exception
    //   1565	1574	1737	java/lang/Exception
    //   1729	1734	1737	java/lang/Exception
    //   1807	1811	1737	java/lang/Exception
    //   1579	1596	1806	java/lang/Exception
    //   1603	1614	1806	java/lang/Exception
    //   1626	1638	1806	java/lang/Exception
    //   1765	1791	1830	java/lang/Exception
    //   1822	1827	1830	java/lang/Exception
    //   421	432	1941	java/lang/Exception
  }
  
  private void setCellChangeFlag(Boolean paramBoolean)
  {
    this.isCellChangeFlag = paramBoolean.booleanValue();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddrStr()
  {
    return this.mAddr.address;
  }
  
  public Address getAddress()
  {
    return this.mAddr;
  }
  
  public double getAltitude()
  {
    return this.mAltitude;
  }
  
  public String getBuildingID()
  {
    return this.buildingid;
  }
  
  public String getBuildingName()
  {
    return this.mBuildingName;
  }
  
  public String getCity()
  {
    return this.mAddr.city;
  }
  
  public String getCityCode()
  {
    return this.mAddr.cityCode;
  }
  
  public String getCoorType()
  {
    return this.mCoorType;
  }
  
  public String getCountry()
  {
    return this.mAddr.country;
  }
  
  public String getCountryCode()
  {
    return this.mAddr.countryCode;
  }
  
  public float getDerect()
  {
    return this.mDerect;
  }
  
  public float getDirection()
  {
    return this.mDerect;
  }
  
  public String getDistrict()
  {
    return this.mAddr.district;
  }
  
  public String getFloor()
  {
    return this.floor;
  }
  
  public int getGpsAccuracyStatus()
  {
    return this.mGpsAccuracyStatus;
  }
  
  public int getGpsCheckStatus()
  {
    return this.mGpsCheckStatus;
  }
  
  public int getIndoorLocationSource()
  {
    return this.mIndoorSource;
  }
  
  public int getIndoorLocationSurpport()
  {
    return this.mIndoorLocationSurpport;
  }
  
  public String getIndoorLocationSurpportBuidlingID()
  {
    return this.mIndoorSurpportBuildingID;
  }
  
  public String getIndoorLocationSurpportBuidlingName()
  {
    return this.mIndoorSurpportBuildingName;
  }
  
  public int getIndoorNetworkState()
  {
    return this.mIndoorNetworkState;
  }
  
  public String getIndoorSurpportPolygon()
  {
    return this.mIndoorSurpportPolygon;
  }
  
  public double getLatitude()
  {
    return this.mLatitude;
  }
  
  public int getLocType()
  {
    return this.mLocType;
  }
  
  public String getLocTypeDescription()
  {
    return this.mDescription;
  }
  
  public String getLocationDescribe()
  {
    return this.mSemaAptag;
  }
  
  public String getLocationID()
  {
    return this.locationID;
  }
  
  public int getLocationWhere()
  {
    return this.mLocationWhere;
  }
  
  public double getLongitude()
  {
    return this.mLongitude;
  }
  
  public String getNetworkLocationType()
  {
    return this.netWorkLocationType;
  }
  
  public int getOperators()
  {
    return this.mOperators;
  }
  
  public List<Poi> getPoiList()
  {
    return this.mPoiList;
  }
  
  public String getProvince()
  {
    return this.mAddr.province;
  }
  
  public float getRadius()
  {
    return this.mRadius;
  }
  
  public String getRetFields(String paramString)
  {
    return (String)this.retFields.get(paramString);
  }
  
  public int getSatelliteNumber()
  {
    this.mHasSateNumber = true;
    return this.mSatelliteNumber;
  }
  
  public String getSemaAptag()
  {
    return this.mSemaAptag;
  }
  
  public float getSpeed()
  {
    return this.mSpeed;
  }
  
  public String getStreet()
  {
    return this.mAddr.street;
  }
  
  public String getStreetNumber()
  {
    return this.mAddr.streetNumber;
  }
  
  public String getTime()
  {
    return this.mTime;
  }
  
  public int getUserIndoorState()
  {
    return this.mIndoorState;
  }
  
  public boolean hasAddr()
  {
    return this.mHasAddr;
  }
  
  public boolean hasAltitude()
  {
    return this.mHasAltitude;
  }
  
  public boolean hasRadius()
  {
    return this.mHasRadius;
  }
  
  public boolean hasSateNumber()
  {
    return this.mHasSateNumber;
  }
  
  public boolean hasSpeed()
  {
    return this.mHasSpeed;
  }
  
  public boolean isCellChangeFlag()
  {
    return this.isCellChangeFlag;
  }
  
  public boolean isIndoorLocMode()
  {
    return this.indoorLocMode;
  }
  
  public int isParkAvailable()
  {
    return this.mParkState;
  }
  
  public void setAddr(Address paramAddress)
  {
    if (paramAddress != null)
    {
      this.mAddr = paramAddress;
      this.mHasAddr = true;
    }
  }
  
  public void setAddrStr(String paramString)
  {
    this.mAddrStr = paramString;
    if (paramString == null)
    {
      this.mHasAddr = false;
      return;
    }
    this.mHasAddr = true;
  }
  
  public void setAltitude(double paramDouble)
  {
    this.mAltitude = paramDouble;
    this.mHasAltitude = true;
  }
  
  public void setBuildingID(String paramString)
  {
    this.buildingid = paramString;
  }
  
  public void setBuildingName(String paramString)
  {
    this.mBuildingName = paramString;
  }
  
  public void setCoorType(String paramString)
  {
    this.mCoorType = paramString;
  }
  
  public void setDirection(float paramFloat)
  {
    this.mDerect = paramFloat;
  }
  
  public void setFloor(String paramString)
  {
    this.floor = paramString;
  }
  
  public void setGpsAccuracyStatus(int paramInt)
  {
    this.mGpsAccuracyStatus = paramInt;
  }
  
  public void setGpsCheckStatus(int paramInt)
  {
    this.mGpsCheckStatus = paramInt;
  }
  
  public void setIndoorLocMode(boolean paramBoolean)
  {
    this.indoorLocMode = paramBoolean;
  }
  
  public void setIndoorLocationSource(int paramInt)
  {
    this.mIndoorSource = paramInt;
  }
  
  public void setIndoorLocationSurpport(int paramInt)
  {
    this.mIndoorLocationSurpport = paramInt;
  }
  
  public void setIndoorNetworkState(int paramInt)
  {
    this.mIndoorNetworkState = paramInt;
  }
  
  public void setIndoorSurpportPolygon(String paramString)
  {
    this.mIndoorSurpportPolygon = paramString;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.mLatitude = paramDouble;
  }
  
  public void setLocType(int paramInt)
  {
    this.mLocType = paramInt;
    switch (paramInt)
    {
    default: 
      setLocTypeDescription("UnKnown!");
      return;
    case 62: 
      setLocTypeDescription("Location failed beacuse we can not get any loc information!");
      return;
    case 61: 
      setLocTypeDescription("GPS location successful!");
      setUserIndoorState(0);
      return;
    case 161: 
      setLocTypeDescription("NetWork location successful!");
      return;
    case 63: 
    case 67: 
      setLocTypeDescription("Offline location failed, please check the net (wifi/cell)!");
      return;
    case 66: 
      setLocTypeDescription("Offline location successful!");
      return;
    case 167: 
      setLocTypeDescription("NetWork location failed because baidu location service can not caculate the location!");
      return;
    case 162: 
      setLocTypeDescription("NetWork location failed because baidu location service can not decrypt the request query, please check the so file !");
      return;
    }
    setLocTypeDescription("NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !");
  }
  
  public void setLocTypeDescription(String paramString)
  {
    this.mDescription = paramString;
  }
  
  public void setLocationDescribe(String paramString)
  {
    this.mSemaAptag = paramString;
  }
  
  public void setLocationID(String paramString)
  {
    this.locationID = paramString;
  }
  
  public void setLocationWhere(int paramInt)
  {
    this.mLocationWhere = paramInt;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.mLongitude = paramDouble;
  }
  
  public void setNetworkLocationType(String paramString)
  {
    this.netWorkLocationType = paramString;
  }
  
  public void setOperators(int paramInt)
  {
    this.mOperators = paramInt;
  }
  
  public void setParkAvailable(int paramInt)
  {
    this.mParkState = paramInt;
  }
  
  public void setPoiList(List<Poi> paramList)
  {
    this.mPoiList = paramList;
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
    this.mHasRadius = true;
  }
  
  public void setSatelliteNumber(int paramInt)
  {
    this.mSatelliteNumber = paramInt;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.mSpeed = paramFloat;
    this.mHasSpeed = true;
  }
  
  public void setTime(String paramString)
  {
    this.mTime = paramString;
    setLocationID(g.a(paramString));
  }
  
  public void setUserIndoorState(int paramInt)
  {
    this.mIndoorState = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mLocType);
    paramParcel.writeString(this.mTime);
    paramParcel.writeDouble(this.mLatitude);
    paramParcel.writeDouble(this.mLongitude);
    paramParcel.writeDouble(this.mAltitude);
    paramParcel.writeFloat(this.mSpeed);
    paramParcel.writeFloat(this.mRadius);
    paramParcel.writeInt(this.mSatelliteNumber);
    paramParcel.writeFloat(this.mDerect);
    paramParcel.writeString(this.floor);
    paramParcel.writeInt(this.mParkState);
    paramParcel.writeString(this.buildingid);
    paramParcel.writeString(this.mBuildingName);
    paramParcel.writeString(this.netWorkLocationType);
    paramParcel.writeString(this.mAddr.province);
    paramParcel.writeString(this.mAddr.city);
    paramParcel.writeString(this.mAddr.district);
    paramParcel.writeString(this.mAddr.street);
    paramParcel.writeString(this.mAddr.streetNumber);
    paramParcel.writeString(this.mAddr.cityCode);
    paramParcel.writeString(this.mAddr.address);
    paramParcel.writeString(this.mAddr.country);
    paramParcel.writeString(this.mAddr.countryCode);
    paramParcel.writeInt(this.mOperators);
    paramParcel.writeString(this.mCu);
    paramParcel.writeString(this.mSemaAptag);
    paramParcel.writeString(this.mSemaPoiRegion);
    paramParcel.writeString(this.mSemaRegular);
    paramParcel.writeInt(this.mLocationWhere);
    paramParcel.writeString(this.mDescription);
    paramParcel.writeInt(this.mIndoorState);
    paramParcel.writeInt(this.mIndoorLocationSurpport);
    paramParcel.writeInt(this.mIndoorNetworkState);
    paramParcel.writeInt(this.mIndoorSource);
    paramParcel.writeString(this.mIndoorSurpportBuildingName);
    paramParcel.writeString(this.mIndoorSurpportBuildingID);
    paramParcel.writeString(this.mIndoorSurpportPolygon);
    paramParcel.writeInt(this.mGpsAccuracyStatus);
    paramParcel.writeString(this.locationID);
    paramParcel.writeInt(this.mGpsCheckStatus);
    paramParcel.writeBooleanArray(new boolean[] { this.mHasAltitude, this.mHasSpeed, this.mHasRadius, this.mHasSateNumber, this.mHasAddr, this.isCellChangeFlag, this.indoorLocMode });
    paramParcel.writeList(this.mPoiList);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/BDLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */