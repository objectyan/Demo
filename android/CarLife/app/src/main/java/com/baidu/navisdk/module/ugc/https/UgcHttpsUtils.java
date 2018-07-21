package com.baidu.navisdk.module.ugc.https;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.utils.PhotoProcessUtils;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

public class UgcHttpsUtils
{
  private ScreenShotCallBack callBack = null;
  private JNIBaseMap mJniBaseMap = null;
  private MsgHandler mMsgHandler = new MsgHandler(Looper.getMainLooper())
  {
    public void careAbout()
    {
      observe(4616);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 4616) {}
      try
      {
        if (UgcHttpsUtils.this.mJniBaseMap != null)
        {
          paramAnonymousMessage = new Bundle();
          UgcHttpsUtils.this.mJniBaseMap.getScreenShotImage(paramAnonymousMessage);
          int i = paramAnonymousMessage.getInt("unImageWidth");
          int j = paramAnonymousMessage.getInt("unImageHeight");
          Bitmap localBitmap = Bitmap.createBitmap(paramAnonymousMessage.getIntArray("pbtImageData"), i, j, Bitmap.Config.ARGB_8888);
          paramAnonymousMessage = new PhotoProcessUtils();
          if (localBitmap != null)
          {
            localBitmap = paramAnonymousMessage.compress(localBitmap, 600, 800);
            if (localBitmap != null)
            {
              paramAnonymousMessage = paramAnonymousMessage.setBitmapToFile(localBitmap);
              if ((UgcHttpsUtils.this.callBack != null) && (UgcHttpsUtils.this.mJniBaseMap != null))
              {
                VMsgDispatcher.unregisterMsgHandler(UgcHttpsUtils.this.mMsgHandler);
                UgcHttpsUtils.access$002(UgcHttpsUtils.this, null);
                UgcHttpsUtils.this.callBack.onScreenShotCompleted(paramAnonymousMessage);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramAnonymousMessage)
      {
        do
        {
          paramAnonymousMessage.printStackTrace();
        } while ((UgcHttpsUtils.this.callBack == null) || (UgcHttpsUtils.this.mJniBaseMap == null));
        VMsgDispatcher.unregisterMsgHandler(UgcHttpsUtils.this.mMsgHandler);
        UgcHttpsUtils.access$002(UgcHttpsUtils.this, null);
        UgcHttpsUtils.this.callBack.onScreenShotCompleted(null);
      }
    }
  };
  
  private void addCommonInfoToPackage(UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage)
  {
    paramUgcReportInfoUploadPackage.cuid = PackageUtil.getCuid();
    paramUgcReportInfoUploadPackage.os = 0;
    paramUgcReportInfoUploadPackage.osv = PackageUtil.strOSVersion;
    paramUgcReportInfoUploadPackage.sv = PackageUtil.strSoftWareVer;
    paramUgcReportInfoUploadPackage.cityId = getCurrentCityId();
    paramUgcReportInfoUploadPackage.cityName = GeoLocateModel.getInstance().getCurCityName();
  }
  
  static CookieStore getCookieStore()
  {
    if (BNaviModuleManager.getBduss() == null) {
      return null;
    }
    BasicClientCookie localBasicClientCookie = new BasicClientCookie("BDUSS", BNaviModuleManager.getBduss());
    BasicCookieStore localBasicCookieStore = new BasicCookieStore();
    localBasicClientCookie.setDomain(".baidu.com");
    localBasicClientCookie.setPath("/");
    localBasicClientCookie.setVersion(0);
    localBasicCookieStore.addCookie(localBasicClientCookie);
    return localBasicCookieStore;
  }
  
  static int getCurrentCityId()
  {
    int i = -1;
    DistrictInfo localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
    if (localDistrictInfo != null) {
      i = localDistrictInfo.mId;
    }
    return i;
  }
  
  static String transferUploadIntToString(int paramInt)
  {
    if (paramInt == -1) {
      return "";
    }
    return paramInt + "";
  }
  
  public void addMapInfoTopackage(UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage)
  {
    addCommonInfoToPackage(paramUgcReportInfoUploadPackage);
    paramUgcReportInfoUploadPackage.businessTrigger = 8;
  }
  
  public void addNaviInfoToPackage(UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage, boolean paramBoolean)
  {
    if (paramUgcReportInfoUploadPackage == null) {}
    RoutePlanModel localRoutePlanModel;
    do
    {
      return;
      addCommonInfoToPackage(paramUgcReportInfoUploadPackage);
      localObject = new Bundle();
      BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl((Bundle)localObject);
      paramUgcReportInfoUploadPackage.sessionId = ((Bundle)localObject).getString("session");
      paramUgcReportInfoUploadPackage.mrsl = ((Bundle)localObject).getString("mrsl");
      paramUgcReportInfoUploadPackage.guid = JNITrajectoryControl.sInstance.getCurrentUUID();
      paramUgcReportInfoUploadPackage.businessTrigger = 1;
      localRoutePlanModel = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    } while (localRoutePlanModel == null);
    Object localObject = localRoutePlanModel.getStartNode().getGeoPoint();
    if (localObject != null)
    {
      localObject = CoordinateTransformUtil.LLE62MC(((GeoPoint)localObject).getLongitudeE6(), ((GeoPoint)localObject).getLatitudeE6());
      paramUgcReportInfoUploadPackage.fromPoint = (((Bundle)localObject).getInt("MCx") + "," + ((Bundle)localObject).getInt("MCy"));
    }
    paramUgcReportInfoUploadPackage.fromUid = (localRoutePlanModel.getStartNode().getUID() + "");
    String str = localRoutePlanModel.getStartNode().getDescription();
    if (str != null)
    {
      localObject = str;
      if (!str.trim().equals("")) {}
    }
    else
    {
      localObject = localRoutePlanModel.getStartNode().getName() + "";
    }
    paramUgcReportInfoUploadPackage.fromName = ((String)localObject);
    localObject = localRoutePlanModel.getEndNode().getGeoPoint();
    if (localObject != null)
    {
      localObject = CoordinateTransformUtil.LLE62MC(((GeoPoint)localObject).getLongitudeE6(), ((GeoPoint)localObject).getLatitudeE6());
      paramUgcReportInfoUploadPackage.toPoint = (((Bundle)localObject).getInt("MCx") + "," + ((Bundle)localObject).getInt("MCy"));
    }
    str = localRoutePlanModel.getEndNode().getUID();
    if (str != null)
    {
      localObject = str;
      if (!str.trim().equals("null")) {}
    }
    else
    {
      localObject = "";
    }
    paramUgcReportInfoUploadPackage.toUid = ((String)localObject);
    str = localRoutePlanModel.getEndNode().getDescription();
    if (str != null)
    {
      localObject = str;
      if (!str.trim().equals("")) {}
    }
    else
    {
      localObject = localRoutePlanModel.getEndNode().getName() + "";
    }
    paramUgcReportInfoUploadPackage.toName = ((String)localObject);
  }
  
  public void addNaviResultInfoToPackge(UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage)
  {
    addCommonInfoToPackage(paramUgcReportInfoUploadPackage);
    paramUgcReportInfoUploadPackage.businessTrigger = 11;
    paramUgcReportInfoUploadPackage.supply = 1;
  }
  
  public String getCurrentLocationPoint()
  {
    Object localObject = BNSysLocationManager.getInstance().getCurLocation();
    String str2 = "";
    String str1 = str2;
    if (localObject != null)
    {
      ((LocData)localObject).toGeoPoint();
      localObject = CoordinateTransformUtil.LL2MC(((LocData)localObject).longitude, ((LocData)localObject).latitude);
      str1 = str2;
      if (localObject != null) {
        str1 = ((Bundle)localObject).getInt("MCx") + "," + ((Bundle)localObject).getInt("MCy");
      }
    }
    return str1;
  }
  
  public void setScreenShotParam(int paramInt, final ScreenShotCallBack paramScreenShotCallBack)
  {
    if (this.mJniBaseMap == null) {
      this.mJniBaseMap = new JNIBaseMap();
    }
    VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
    this.callBack = paramScreenShotCallBack;
    ScreenUtil localScreenUtil = ScreenUtil.getInstance();
    if (paramInt == 1) {
      paramInt = localScreenUtil.getWidthPixels();
    }
    for (int i = localScreenUtil.getHeightPixels() - ScreenUtil.getInstance().dip2px(120); (!new JNIBaseMap().setScreenShotParam(4, paramInt, i, 0L, 0L, 0)) && (paramScreenShotCallBack != null); i = localScreenUtil.getHeightPixels())
    {
      paramScreenShotCallBack.onScreenShotCompleted(null);
      return;
      paramInt = localScreenUtil.getWidthPixels() * 2 / 3;
    }
    new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if ((paramScreenShotCallBack != null) && (UgcHttpsUtils.this.mJniBaseMap != null))
        {
          UgcHttpsUtils.access$002(UgcHttpsUtils.this, null);
          paramScreenShotCallBack.onScreenShotCompleted(null);
          VMsgDispatcher.unregisterMsgHandler(UgcHttpsUtils.this.mMsgHandler);
        }
      }
    }.sendEmptyMessageDelayed(16, 1500L);
  }
  
  public static abstract interface ScreenShotCallBack
  {
    public abstract void onScreenShotCompleted(String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/https/UgcHttpsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */