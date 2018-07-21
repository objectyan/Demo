package com.baidu.navisdk.comapi.geolocate;

import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import com.baidu.navi.location.BDLocation;
import com.baidu.navi.location.BDLocationListener;
import com.baidu.navi.location.LocationClient;
import com.baidu.navi.location.LocationClientOption;
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

public class BNGeoLocateManager
  extends BNLocationManager
{
  private static final int LOCATION_SCAN_SPAN = 3000;
  private static final String TAG = "Location";
  private static BNGeoLocateManager mInstance = null;
  private Context mContext;
  private BNLocationListener mLocListener = new BNLocationListener(null);
  private int mLocType = 0;
  private LocationClient mLocationClient = null;
  private LocationClientOption mOption = null;
  private TelephonyManager mTelephonyManager;
  private boolean mUgcInfoSet = false;
  private WifiManager mWifiManager;
  
  private BNGeoLocateManager()
  {
    this.mOption.setOpenGps(true);
    this.mOption.setCoorType("gcj02");
    this.mOption.setAddrType("detail");
    this.mOption.setScanSpan(3000);
    this.mOption.setLocationNotify(true);
    this.mOption.setProdName("Baidu_navi_" + PackageUtil.strSoftWareVer);
  }
  
  public static void destory()
  {
    try
    {
      if (mInstance != null) {
        mInstance.unInit();
      }
      mInstance = null;
      return;
    }
    finally {}
  }
  
  public static BNGeoLocateManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new BNGeoLocateManager();
      }
      BNGeoLocateManager localBNGeoLocateManager = mInstance;
      return localBNGeoLocateManager;
    }
    finally {}
  }
  
  private String locationTypeToStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UnkownType";
    case 65: 
      return "CacheLocation";
    case 62: 
      return "CriteriaException";
    case 61: 
      return "GpsLocation";
    case 63: 
      return "NetWorkException";
    case 161: 
      return "NetWorkLocation";
    case 0: 
      return "None";
    case 66: 
      return "OffLineLocation";
    case 67: 
      return "OffLineLocationFail";
    case 68: 
      return "OffLineLocationNetworkFail";
    }
    return "ServerError";
  }
  
  private void setNavigationState(boolean paramBoolean)
  {
    try
    {
      this.mUgcInfoSet = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void setOptionForMap()
  {
    if ((this.mLocationClient != null) && (this.mOption != null))
    {
      this.mOption.setOpenGps(true);
      this.mOption.setScanSpan(3000);
      this.mLocationClient.setLocOption(this.mOption);
    }
  }
  
  private void setOptionForNavi()
  {
    if ((this.mLocationClient != null) && (this.mOption != null))
    {
      this.mOption.setOpenGps(true);
      this.mOption.setScanSpan(86400000);
      this.mLocationClient.setLocOption(this.mOption);
    }
  }
  
  /* Error */
  private boolean startLocate()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   8: ifnull +73 -> 81
    //   11: aload_0
    //   12: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   15: invokevirtual 187	com/baidu/navi/location/LocationClient:isStarted	()Z
    //   18: ifne +63 -> 81
    //   21: aload_0
    //   22: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   25: aload_0
    //   26: getfield 48	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocListener	Lcom/baidu/navisdk/comapi/geolocate/BNGeoLocateManager$BNLocationListener;
    //   29: invokevirtual 191	com/baidu/navi/location/LocationClient:registerLocationListener	(Lcom/baidu/navi/location/BDLocationListener;)V
    //   32: aload_0
    //   33: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   36: iconst_1
    //   37: invokevirtual 194	com/baidu/navi/location/LocationClient:setForBaiduMap	(Z)V
    //   40: aload_0
    //   41: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   44: aload_0
    //   45: getfield 50	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mOption	Lcom/baidu/navi/location/LocationClientOption;
    //   48: invokevirtual 180	com/baidu/navi/location/LocationClient:setLocOption	(Lcom/baidu/navi/location/LocationClientOption;)V
    //   51: aload_0
    //   52: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   55: invokevirtual 197	com/baidu/navi/location/LocationClient:start	()V
    //   58: iload_2
    //   59: istore_1
    //   60: getstatic 202	com/baidu/navisdk/debug/NavSDKDebug:sShowDebugToast	Z
    //   63: ifeq +14 -> 77
    //   66: aload_0
    //   67: getfield 110	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mContext	Landroid/content/Context;
    //   70: ldc -52
    //   72: invokestatic 210	com/baidu/navisdk/ui/util/TipTool:onCreateDebugToast	(Landroid/content/Context;Ljava/lang/String;)V
    //   75: iload_2
    //   76: istore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: iload_1
    //   80: ireturn
    //   81: iconst_0
    //   82: istore_1
    //   83: goto -6 -> 77
    //   86: astore_3
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_3
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	BNGeoLocateManager
    //   59	24	1	bool1	boolean
    //   1	75	2	bool2	boolean
    //   86	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	58	86	finally
    //   60	75	86	finally
  }
  
  /* Error */
  private boolean stopLocate()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   6: ifnull +52 -> 58
    //   9: aload_0
    //   10: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   13: invokevirtual 187	com/baidu/navi/location/LocationClient:isStarted	()Z
    //   16: ifeq +42 -> 58
    //   19: aload_0
    //   20: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   23: aload_0
    //   24: getfield 48	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocListener	Lcom/baidu/navisdk/comapi/geolocate/BNGeoLocateManager$BNLocationListener;
    //   27: invokevirtual 214	com/baidu/navi/location/LocationClient:unRegisterLocationListener	(Lcom/baidu/navi/location/BDLocationListener;)V
    //   30: aload_0
    //   31: getfield 43	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mLocationClient	Lcom/baidu/navi/location/LocationClient;
    //   34: invokevirtual 217	com/baidu/navi/location/LocationClient:stop	()V
    //   37: getstatic 202	com/baidu/navisdk/debug/NavSDKDebug:sShowDebugToast	Z
    //   40: ifeq +12 -> 52
    //   43: aload_0
    //   44: getfield 110	com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager:mContext	Landroid/content/Context;
    //   47: ldc -37
    //   49: invokestatic 210	com/baidu/navisdk/ui/util/TipTool:onCreateDebugToast	(Landroid/content/Context;Ljava/lang/String;)V
    //   52: iconst_1
    //   53: istore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: iload_1
    //   57: ireturn
    //   58: iconst_0
    //   59: istore_1
    //   60: goto -6 -> 54
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	BNGeoLocateManager
    //   53	7	1	bool	boolean
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	63	finally
  }
  
  public LocData getCurLocation()
  {
    if (BNSysLocationManager.getInstance().isSysLocationValid()) {
      return BNSysLocationManager.getInstance().getCurLocation();
    }
    return super.getCurLocation();
  }
  
  public RoutePlanNode getCurLocationNode()
  {
    if (BNSysLocationManager.getInstance().isSysLocationValid()) {
      return BNSysLocationManager.getInstance().getCurLocationNode();
    }
    return super.getCurLocationNode();
  }
  
  public int getCurLocationType()
  {
    return this.mLocType;
  }
  
  public GeoPoint getLastValidLocation()
  {
    if (BNSysLocationManager.getInstance().isSysLocationValid()) {
      return BNSysLocationManager.getInstance().getLastValidLocation();
    }
    return super.getLastValidLocation();
  }
  
  public void init(Context paramContext)
  {
    try
    {
      LogUtil.e("Location", "[LocationClient] init");
      this.mContext = paramContext;
      if ((this.mLocationClient == null) && (paramContext != null)) {
        this.mLocationClient = new LocationClient(paramContext);
      }
      try
      {
        if (SystemAuth.checkAuth("android.permission.READ_PHONE_STATE")) {
          this.mTelephonyManager = ((TelephonyManager)paramContext.getSystemService("phone"));
        }
        this.mWifiManager = ((WifiManager)paramContext.getSystemService("wifi"));
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      startLocate();
      return;
    }
    finally {}
  }
  
  public boolean isGPSLocationValid()
  {
    return (getCurLocation() != null) && (this.mLocType == 61);
  }
  
  public boolean isGpsEnabled()
  {
    if (this.mContext != null)
    {
      LocationManager localLocationManager = (LocationManager)this.mContext.getSystemService("location");
      try
      {
        boolean bool = localLocationManager.isProviderEnabled("gps");
        return bool;
      }
      catch (Exception localException)
      {
        LogUtil.e("Location", localException.toString());
      }
    }
    return false;
  }
  
  public boolean isLocationValid()
  {
    return (getCurLocation() != null) && ((this.mLocType == 61) || (this.mLocType == 161) || (this.mLocType == 66) || (this.mLocType == 68));
  }
  
  public boolean startNaviLocate(Context paramContext)
  {
    try
    {
      LogUtil.e("Location", "[navi] startLocate");
      super.startNaviLocate(paramContext);
      setOptionForNavi();
      setNavigationState(true);
      return true;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void stopNaviLocate()
  {
    try
    {
      LogUtil.e("Location", "[navi] stopLocate");
      super.stopNaviLocate();
      setOptionForMap();
      setNavigationState(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void unInit()
  {
    try
    {
      LogUtil.e("Location", "[LocationClient] unInit");
      stopLocate();
      this.mLocationClient = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void updateLocation(LocData paramLocData)
  {
    if (paramLocData != null) {
      notifyLocationChanged(paramLocData);
    }
  }
  
  private class BNLocationListener
    implements BDLocationListener
  {
    private BNLocationListener() {}
    
    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      if (paramBDLocation == null) {}
      label226:
      label651:
      label659:
      label705:
      for (;;)
      {
        return;
        int i;
        String str1;
        LocData localLocData;
        if ((BNGeoLocateManager.this.mLocationClient != null) && (BNGeoLocateManager.this.mUgcInfoSet))
        {
          if (BNGeoLocateManager.this.mIsNaviStarted)
          {
            BNGeoLocateManager.this.mLocationClient.setUgcInfo("1");
            BNGeoLocateManager.access$202(BNGeoLocateManager.this, false);
          }
        }
        else
        {
          i = paramBDLocation.getLocType();
          str1 = BNGeoLocateManager.this.locationTypeToStr(i);
          if ((BNGeoLocateManager.this.mIsNaviStarted) && (i != 61)) {
            continue;
          }
          localLocData = new LocData();
          localLocData.type = i;
          if ((i != 61) && (i != 161) && (i != 66) && (i != 68)) {
            break label659;
          }
          if ((i == 68) && (!paramBDLocation.isCellChangeFlag())) {
            continue;
          }
          localLocData.latitude = paramBDLocation.getLatitude();
          localLocData.longitude = paramBDLocation.getLongitude();
          localLocData.speed = ((float)(paramBDLocation.getSpeed() / 3.6D));
          localLocData.accuracy = Math.min(2000.0F, paramBDLocation.getRadius());
          localLocData.direction = paramBDLocation.getDerect();
          localLocData.satellitesNum = paramBDLocation.getSatelliteNumber();
          localLocData.altitude = paramBDLocation.getAltitude();
          BNGeoLocateManager.access$602(BNGeoLocateManager.this, i);
          if (i != 61) {
            break label651;
          }
          localLocData.locType = 0;
          BNGeoLocateManager.this.notifyLocationChanged(localLocData);
          RespTimeStatItem.getInstance().setAppLocatedTime();
        }
        for (;;)
        {
          if (!NavSDKDebug.sShowDebugToast) {
            break label705;
          }
          Object localObject5 = null;
          Object localObject6 = null;
          CellLocation localCellLocation2 = null;
          Object localObject7 = null;
          String str2 = null;
          paramBDLocation = null;
          Object localObject2 = str2;
          CellLocation localCellLocation1 = localCellLocation2;
          Object localObject3 = localObject7;
          Object localObject4 = localObject5;
          Object localObject1 = localObject6;
          if (BNGeoLocateManager.this.mTelephonyManager != null)
          {
            localObject2 = str2;
            localCellLocation1 = localCellLocation2;
            localObject3 = localObject7;
            localObject4 = localObject5;
            localObject1 = localObject6;
            if (SystemAuth.checkAuth("android.permission.READ_PHONE_STATE"))
            {
              str2 = BNGeoLocateManager.this.mTelephonyManager.getNetworkOperator();
              localCellLocation2 = BNGeoLocateManager.this.mTelephonyManager.getCellLocation();
              localObject7 = BNGeoLocateManager.this.mTelephonyManager.getNeighboringCellInfo();
              if (((List)localObject7).size() > 0) {
                paramBDLocation = (NeighboringCellInfo)((List)localObject7).get(0);
              }
              localObject2 = paramBDLocation;
              localCellLocation1 = localCellLocation2;
              localObject3 = localObject7;
              localObject4 = localObject5;
              localObject1 = localObject6;
              if (str2 != null)
              {
                localObject2 = paramBDLocation;
                localCellLocation1 = localCellLocation2;
                localObject3 = localObject7;
                localObject4 = localObject5;
                localObject1 = localObject6;
                if (str2.length() >= 5)
                {
                  localObject4 = str2.substring(0, 3);
                  localObject1 = str2.substring(3, 5);
                  localObject3 = localObject7;
                  localCellLocation1 = localCellLocation2;
                  localObject2 = paramBDLocation;
                }
              }
            }
          }
          localObject6 = null;
          localCellLocation2 = null;
          localObject5 = localObject6;
          paramBDLocation = localCellLocation2;
          if (BNGeoLocateManager.this.mWifiManager != null)
          {
            localObject7 = BNGeoLocateManager.this.mWifiManager.getConnectionInfo();
            localObject5 = localObject6;
            paramBDLocation = localCellLocation2;
            if (localObject7 != null)
            {
              localObject5 = ((WifiInfo)localObject7).getBSSID();
              paramBDLocation = ((WifiInfo)localObject7).getSSID();
            }
          }
          TipTool.onCreateDebugToast(BNGeoLocateManager.this.mContext, "LocSDK recv type " + str1 + ", " + localLocData + "\nmcc=" + (String)localObject4 + " mnc=" + (String)localObject1 + " cellloc=" + localCellLocation1 + " neighbor=" + ((List)localObject3).size() + " first=" + localObject2 + "\nbssid=" + (String)localObject5 + " ssid=" + paramBDLocation);
          return;
          BNGeoLocateManager.this.mLocationClient.setUgcInfo("0");
          break;
          localLocData.locType = 1;
          break label226;
          if ((i == 167) || (i == 67))
          {
            localLocData = BNGeoLocateManager.this.getCurLocation();
            str1 = BNGeoLocateManager.this.locationTypeToStr(BNGeoLocateManager.this.mLocType);
            BNGeoLocateManager.this.notifyLocationNotChanged(localLocData);
          }
        }
      }
    }
    
    public void onReceivePoi(BDLocation paramBDLocation)
    {
      LogUtil.e("Location", "BNLocationListener onReceivePoi: LocType " + BNGeoLocateManager.this.locationTypeToStr(paramBDLocation.getLocType()));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/geolocate/BNGeoLocateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */