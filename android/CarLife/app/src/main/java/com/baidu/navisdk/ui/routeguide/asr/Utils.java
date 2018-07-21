package com.baidu.navisdk.ui.routeguide.asr;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl.OnTTSPlayStateListener;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.Iterator;
import java.util.List;

public class Utils
{
  private static final long ADDRESS_UPDATE_INTERVAL = 432000000L;
  public static final int CONTACTS_NO_UPLOAD_TAG = 2;
  public static final int CONTACTS_UPLOAD_TAG = 1;
  public static final String OP_TAG = "dingbbinOP";
  private static final String TAG = "BNASRUtils";
  private static String mCurrentTips;
  private static TTSPlayerControl.OnTTSPlayStateListener mTTSPlayStateListener = new TTSPlayerControl.OnTTSPlayStateListener()
  {
    public void onPlayEnd()
    {
      TTSPlayerControl.removeTTSPlayStateListener(Utils.mTTSPlayStateListener);
      TTSPlayerControl.playTTS(Utils.mCurrentTips, 0);
    }
    
    public void onPlayStart() {}
  };
  
  public static void asrAvoidJam()
  {
    BNRoutePlaner.getInstance().selectRoute(RGMultiRouteModel.getInstance().mSelectedRouteIndex);
    BNMapController.getInstance().updateLayer(10);
    BNEventManager.getInstance().onOtherAction(12, 0, 0, null);
  }
  
  public static void avoidRoadClose() {}
  
  private static void awaitSpeakMessage(String paramString)
  {
    if (mTTSPlayStateListener == null) {
      return;
    }
    mCurrentTips = paramString;
    TTSPlayerControl.addTTSPlayStateListener(mTTSPlayStateListener);
  }
  
  private static boolean canSpeakInstant()
  {
    return !TTSPlayerControl.getMapTTSPlayStatus();
  }
  
  public static boolean checkAuthrity(String paramString)
  {
    Activity localActivity = BNaviModuleManager.getActivity();
    boolean bool2;
    if (localActivity == null)
    {
      bool2 = false;
      return bool2;
    }
    boolean bool3 = false;
    for (;;)
    {
      try
      {
        if (localActivity.getPackageManager().checkPermission(paramString, PackageUtil.getPackageName()) == 0)
        {
          bool1 = true;
          bool2 = bool1;
          if (bool1) {
            break;
          }
          bool3 = bool1;
          if (paramString.equals("android.permission.CALL_PHONE"))
          {
            bool3 = bool1;
            BNavigator.getInstance().requestAuth("android.permission.CALL_PHONE");
            bool3 = bool1;
            TipTool.onCreateToastDialog(localActivity, "没有打电话权限，请打开后重试");
            return bool1;
          }
          bool3 = bool1;
          if (paramString.equals("android.permission.READ_CONTACTS"))
          {
            bool3 = bool1;
            LogUtil.e("BNASRUtils", "no auth in read contacts");
            return bool1;
          }
          bool2 = bool1;
          bool3 = bool1;
          if (!paramString.equals("android.permission.RECORD_AUDIO")) {
            break;
          }
          bool3 = bool1;
          TipTool.onCreateToastDialog(localActivity, "没有麦克风权限，请打开后重试");
          return bool1;
        }
      }
      catch (Throwable paramString)
      {
        return bool3;
      }
      boolean bool1 = false;
    }
  }
  
  public static void ensureTTSStop()
  {
    boolean bool = TTSPlayerControl.getMapTTSPlayStatus();
    if (bool)
    {
      TTSPlayerControl.stopVoiceTTSOutput();
      TTSPlayerControl.pauseVoiceTTSOutput();
      BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
      LogUtil.e("BNASRUtils", "dingbbinasr need to stop tts,current status is " + bool);
    }
  }
  
  private static String gatherName(String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{\"name\":\"");
    localStringBuffer.append(paramString);
    if (paramBoolean) {
      localStringBuffer.append("\",\"frequency\":1000}");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("\",\"frequency\":1000},");
    }
  }
  
  public static String getAddressListString()
  {
    if (BNaviModuleManager.getActivity() == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Cursor localCursor = BNaviModuleManager.getActivity().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    if (localCursor != null)
    {
      localStringBuffer.append("[");
      while (localCursor.moveToNext())
      {
        boolean bool = localCursor.isLast();
        localStringBuffer.append(gatherName(localCursor.getString(localCursor.getColumnIndex("display_name")), bool));
      }
      localCursor.close();
    }
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
  
  public static String getLastTTSSpeech()
  {
    return "左转";
  }
  
  public static SearchPoi getNearestPoi(List<SearchPoi> paramList)
  {
    SearchPoi localSearchPoi = new SearchPoi();
    int i = 0;
    int j = 0;
    double d1 = Double.MAX_VALUE;
    Object localObject3 = BNExtGPSLocationManager.getInstance().getCurLocation();
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = BNSysLocationManager.getInstance().getCurLocation();
      if (localObject1 == null)
      {
        localSearchPoi.copy((SearchPoi)paramList.get(0));
        return localSearchPoi;
      }
      double d4 = ((LocData)localObject1).longitude;
      double d5 = ((LocData)localObject1).latitude;
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (SearchPoi)((Iterator)localObject1).next();
        double d3 = StringUtils.geoSphereDistance(d4 * 100000.0D, d5 * 100000.0D, ((SearchPoi)localObject3).mViewPoint.getLongitudeE6(), ((SearchPoi)localObject3).mViewPoint.getLatitudeE6());
        double d2 = d1;
        if (d3 < d1)
        {
          j = i;
          d2 = d3;
        }
        i += 1;
        d1 = d2;
      }
      localSearchPoi.copy((SearchPoi)paramList.get(j));
      return localSearchPoi;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public static String getNextManeuverPoint()
  {
    return "前方100左转";
  }
  
  public static String getPanDemandType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return "gs";
    case 1: 
      return "wc";
    case 2: 
      return "bk";
    case 3: 
      return "ss";
    case 4: 
      return "fd";
    case 5: 
      return "ht";
    case 6: 
      return "sa";
    }
    return "pl";
  }
  
  public static String getPhoneNumber(String paramString)
  {
    if (BNaviModuleManager.getActivity() == null) {}
    Cursor localCursor;
    for (;;)
    {
      return null;
      localObject1 = null;
      localObject2 = null;
      try
      {
        localCursor = BNaviModuleManager.getActivity().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, "display_name = '" + paramString + "'", null, null);
        if (localCursor != null)
        {
          LogUtil.e("BNASRUtils", "asr cursor size : " + localCursor.getCount());
          if (!localCursor.moveToFirst()) {
            break label320;
          }
          paramString = (String)localObject2;
          localObject1 = localCursor.getString(localCursor.getColumnIndex("_id"));
          LogUtil.e("BNASRUtils", "asr contactId : " + (String)localObject1);
          localObject2 = paramString;
          if (localObject1 == null) {
            break label328;
          }
          localObject2 = BNaviModuleManager.getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = '" + (String)localObject1 + "'", null, null);
          localObject1 = paramString;
          if (localObject2 == null) {
            break label314;
          }
          LogUtil.e("BNASRUtils", "asr phone size : " + ((Cursor)localObject2).getCount());
          while (((Cursor)localObject2).moveToNext())
          {
            localObject1 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("data1"));
            LogUtil.e("BNASRUtils", "asr number : " + (String)localObject1);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = ((String)localObject1).replaceAll("\\s*", "");
              if (PhoneNumberUtils.isGlobalPhoneNumber((String)localObject1)) {
                paramString = (String)localObject1;
              }
            }
          }
          ((Cursor)localObject2).close();
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
    Object localObject1 = paramString;
    label314:
    Object localObject2 = localObject1;
    if (localObject1 != null) {}
    for (;;)
    {
      label320:
      localCursor.close();
      return (String)localObject1;
      label328:
      paramString = (String)localObject2;
      if (localCursor.moveToNext()) {
        break;
      }
      localObject1 = localObject2;
    }
  }
  
  public static String getPushCommandSpeech(String paramString1, String paramString2)
  {
    String str = null;
    if (BNavigator.getInstance().isBackgroundNavi()) {
      str = paramString2;
    }
    do
    {
      return str;
      if (paramString1.equals("ask_dest_park")) {
        return paramString2 + "," + "是否直接导航到停车场，滴声后回答确定可导航到停车场";
      }
    } while (!paramString1.equals("ask_route_recommend"));
    return paramString2 + "," + "滴声后回答确定可切换路线";
  }
  
  public static boolean isAddressNeedUpload()
  {
    if (BNSettingManager.getAsrUploadAddress() == 1)
    {
      BNSettingManager.setHasAsrUploadAddress(2);
      LogUtil.e("BNASRUtils", "dingbin upload contacts ----> true");
      return true;
    }
    LogUtil.e("BNASRUtils", "dingbin upload contacts ----> false");
    return false;
  }
  
  public static boolean isAsrCanShow()
  {
    return BNSettingManager.isShowNaviAsr();
  }
  
  public static boolean isAsrCanWork()
  {
    try
    {
      boolean bool = BNSettingManager.isShowNaviAsr();
      if (BNavigator.getInstance().getContext() != null)
      {
        int i = BNavigator.getInstance().getContext().getPackageManager().checkPermission("android.permission.RECORD_AUDIO", PackageUtil.getPackageName());
        if (i == 0) {}
        for (i = 1; (bool) && (i != 0); i = 0) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public static boolean isInOnLineMode()
  {
    return (BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() == 1) || (BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() == 3);
  }
  
  public static void mainAuxiliarySwitch(boolean paramBoolean) {}
  
  public static void makeAvoidJamSpeak(String paramString)
  {
    if (canSpeakInstant())
    {
      TTSPlayerControl.playTTS(paramString, 0);
      return;
    }
    awaitSpeakMessage(paramString);
  }
  
  public static void makeMainAuxiliarySpeak(String paramString) {}
  
  public static void makeParkingSpeak(String paramString)
  {
    if (BNavigator.getInstance().isNaviBegin()) {
      TTSPlayerControl.playTTS(paramString, 0);
    }
  }
  
  public static void naviToDestPark(GeoPoint paramGeoPoint)
  {
    BNRoutePlaner.getInstance().setGuideSceneType(4);
    RGSimpleGuideModel.getInstance();
    RGSimpleGuideModel.mCalcRouteType = 4;
    RGEngineControl.getInstance().setEndPtToCalcRoute(paramGeoPoint);
  }
  
  public static void naviToSearchPoint(SearchPoi paramSearchPoi)
  {
    RGEngineControl.getInstance().addViaPtToCalcRoute(paramSearchPoi.mGuidePoint, paramSearchPoi.mName);
    if (RGRouteSearchModel.getInstance().isRouteSearchMode())
    {
      RGRouteSearchModel.getInstance().setRouteSearchMode(false);
      BNPoiSearcher.getInstance().clearBkgCache();
      BNMapController.getInstance().updateLayer(4);
      BNMapController.getInstance().showLayer(4, false);
      BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410310", "410310");
    }
  }
  
  public static void updateAddressUploadState()
  {
    if (BNSettingManager.getAsrUploadAddress() == 0) {
      BNSettingManager.setHasAsrUploadAddress(1);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/asr/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */