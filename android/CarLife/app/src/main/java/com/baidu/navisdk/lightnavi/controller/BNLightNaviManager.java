package com.baidu.navisdk.lightnavi.controller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.lightnavi.listener.LightGuideRGListener;
import com.baidu.navisdk.lightnavi.utils.LightNaviPageJumpHelper;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.vi.VMsgDispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BNLightNaviManager
  extends BNLogicController
{
  public static final int BRIGHT_TYPE = 2;
  public static final int LOCK_TYPE = 1;
  private static final String TAG = BNLightNaviManager.class.getSimpleName();
  private static volatile BNLightNaviManager mInstance;
  public static int pRGViewMode = 1;
  private boolean isSwitching = false;
  private int mAutoRefresh = -1;
  public Activity mDetailActivity = null;
  private MsgHandler mHandler = new MsgHandler(Looper.getMainLooper())
  {
    public void careAbout()
    {
      observe(4612);
      observe(4613);
      observe(4211);
      observe(4212);
      observe(4107);
      observe(4098);
      observe(4172);
      observe(4216);
      observe(4100);
      observe(4113);
      observe(4104);
      observe(4105);
      observe(4106);
      observe(4404);
      observe(4152);
      observe(4153);
      observe(4116);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool2 = true;
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      int i;
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              return;
                                            } while (BNLightNaviManager.this.mRGListener == null);
                                            BNLightNaviManager.this.mRGListener.onIPOLockScreen(paramAnonymousMessage);
                                            return;
                                          } while (BNLightNaviManager.this.mRGListener == null);
                                          BNLightNaviManager.this.mRGListener.onIPOAddressScreen(paramAnonymousMessage);
                                          return;
                                        } while (BNLightNaviManager.this.mRGListener == null);
                                        BNLightNaviManager.this.mRGListener.onIPORoadConditionHide(paramAnonymousMessage);
                                        return;
                                      } while (BNLightNaviManager.this.mRGListener == null);
                                      BNLightNaviManager.this.mRGListener.onIPORoadConditionUpdate(paramAnonymousMessage);
                                      return;
                                      paramAnonymousMessage = BNaviModuleManager.getContext();
                                      LogUtil.e("wangyang", "BN_RoutePlan_MSG.RP_IPO_SUCCESS_NORMAL=" + paramAnonymousMessage);
                                      LightNaviPageJumpHelper.getInstance().onPageJump(2, null);
                                      return;
                                      if (BNLightNaviManager.this.isNaving())
                                      {
                                        BNLightNaviManager.this.quitLightNavi();
                                        return;
                                      }
                                      paramAnonymousMessage = BNaviModuleManager.getContext();
                                      BNRouteGuider.getInstance().setNaviMode(1);
                                      BNMapController.getInstance().updateLayer(13);
                                      TipTool.onCreateToastDialog(paramAnonymousMessage, "路线规划失败");
                                      return;
                                      LogUtil.e("wangyang", "RP_PROCCESS_CANCLE");
                                      if (BNLightNaviManager.this.isNaving()) {
                                        BNaviModuleManager.removeIPO();
                                      }
                                      BNRouteGuider.getInstance().setNaviMode(1);
                                      return;
                                    } while (BNLightNaviManager.this.mRGListener == null);
                                    BNLightNaviManager.this.mRGListener.onRemainInfoUpdate(paramAnonymousMessage);
                                    return;
                                  } while (BNLightNaviManager.this.mRGListener == null);
                                  BNLightNaviManager.this.mRGListener.avoidTrafficJam(paramAnonymousMessage);
                                  return;
                                } while (BNLightNaviManager.this.mRGListener == null);
                                BNLightNaviManager.this.mRGListener.onOtherRoute(paramAnonymousMessage);
                                return;
                                BNLightNaviManager.access$102(BNLightNaviManager.this, paramAnonymousMessage.arg1);
                                LogUtil.e("wangyang", "onAutoRefresh type =" + BNLightNaviManager.this.mAutoRefresh);
                                return;
                                switch (paramAnonymousMessage.arg1)
                                {
                                case 4: 
                                case 5: 
                                default: 
                                  return;
                                }
                              } while (BNLightNaviManager.this.mRGListener == null);
                              BNLightNaviManager.this.mRGListener.zoomToFullView();
                              return;
                            } while (BNLightNaviManager.this.mRGListener == null);
                            BNLightNaviManager.this.mRGListener.onYawingRerouteSuccess(paramAnonymousMessage);
                            return;
                          } while (BNLightNaviManager.this.mRGListener == null);
                          BNLightNaviManager.this.mRGListener.onYawingRerouting(paramAnonymousMessage);
                          return;
                        } while (BNLightNaviManager.this.mRGListener == null);
                        BNLightNaviManager.this.mRGListener.onArriveDest(paramAnonymousMessage);
                        return;
                        if ((BNLightNaviManager.this.mRGListener != null) && (BNLightNaviManager.this.mSwitchType == 1)) {
                          BNLightNaviManager.this.mRGListener.onSwithSLightToNavi(paramAnonymousMessage);
                        }
                        if (BNLightNaviManager.this.mSwitchType == 2) {
                          BNLightNaviSwitchManager.getInstance().onSwitchNormalNaviToSLight(paramAnonymousMessage);
                        }
                        i = paramAnonymousMessage.arg1;
                        LogUtil.e("wangyang", "onSwithSLightToNavi type = " + i + " mSwitchType=" + BNLightNaviManager.this.mSwitchType);
                      } while (i == 2);
                      BNLightNaviSwitchManager.getInstance().setIsSwitching(false);
                      BNLightNaviSwitchManager.getInstance().setIsRefreashRoute(false);
                      return;
                      LogUtil.e("wangyang", "MSG_NAVI_SHOW_SIMPLE_GUIDE_INFO " + paramAnonymousMessage.arg1);
                    } while (BNLightNaviManager.this.mRGListener == null);
                    BNLightNaviManager.this.mRGListener.onUpdateSimpleGuide(paramAnonymousMessage);
                    return;
                  } while (BNLightNaviManager.this.mRGListener == null);
                  BNLightNaviManager.this.mRGListener.onUpdateSpeed(true, paramAnonymousMessage);
                  return;
                } while (BNLightNaviManager.this.mRGListener == null);
                BNLightNaviManager.this.mRGListener.onUpdateSpeed(true, paramAnonymousMessage);
                return;
              } while (BNLightNaviManager.this.mRGListener == null);
              BNLightNaviManager.this.mRGListener.onUpdateSpeed(false, paramAnonymousMessage);
              return;
            } while (BNLightNaviManager.this.mRGListener == null);
            BNLightNaviManager.this.mRGListener.isYellowBarHide(paramAnonymousMessage);
            return;
            LogUtil.e("BNLightNaviManager", "handleMessage: --> MSG_NAVI_Satellite_Fixing_Update");
          } while (BNLightNaviManager.this.mRGListener == null);
          BNLightNaviManager.this.mRGListener.onGpsStatusChange(false);
          return;
          LogUtil.e("BNLightNaviManager", "handleMessage: --> MSG_NAVI_Satellite_Fix_Success_Update");
        } while (BNLightNaviManager.this.mRGListener == null);
        BNLightNaviManager.this.mRGListener.onGpsStatusChange(true);
        return;
        localObject = new StringBuilder().append("handleMessage: --> MSG_NAVI_GPS_STATUS_CHANGE, fixed = ");
        if (paramAnonymousMessage.arg1 != 1) {
          break;
        }
        bool1 = true;
        LogUtil.e("BNLightNaviManager", bool1);
      } while (BNLightNaviManager.this.mRGListener == null);
      Object localObject = BNLightNaviManager.this.mRGListener;
      if (paramAnonymousMessage.arg1 == 1) {}
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((LightGuideRGListener)localObject).onGpsStatusChange(bool1);
        return;
        bool1 = false;
        break;
      }
    }
  };
  private boolean mIsLightNaviView = false;
  private boolean mIsNaving = false;
  private JNIGuidanceControl mJniGuideControl;
  private Activity mLightNaviBrightActivity = null;
  private String mPackageName = "com.baidu.BaiduMap";
  private LightGuideRGListener mRGListener;
  private int mSwitchType = 0;
  private volatile int mType = 2;
  
  private BNLightNaviManager()
  {
    VMsgDispatcher.registerMsgHandler(this.mHandler);
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mHandler);
    this.mJniGuideControl = JNIGuidanceControl.getInstance();
  }
  
  private List<String> getHomes()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.mLightNaviBrightActivity.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    localObject = ((PackageManager)localObject).queryIntentActivities(localIntent, 65536).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName);
    }
    return localArrayList;
  }
  
  public static BNLightNaviManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BNLightNaviManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void openApp()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = this.mLightNaviBrightActivity.getPackageManager().getPackageInfo(this.mPackageName, 0);
      localObject1 = localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject2;
        Intent localIntent;
        localNameNotFoundException.printStackTrace();
      }
    }
    localObject2 = new Intent("android.intent.action.MAIN", null);
    ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
    ((Intent)localObject2).setPackage(((PackageInfo)localObject1).packageName);
    localObject1 = this.mLightNaviBrightActivity.getPackageManager().queryIntentActivities((Intent)localObject2, 0);
    if (((List)localObject1).iterator().hasNext())
    {
      localObject2 = (ResolveInfo)((List)localObject1).iterator().next();
      if (localObject2 != null)
      {
        localObject1 = ((ResolveInfo)localObject2).activityInfo.packageName;
        localObject2 = ((ResolveInfo)localObject2).activityInfo.name;
        localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.LAUNCHER");
        localIntent.setComponent(new ComponentName((String)localObject1, (String)localObject2));
        this.mLightNaviBrightActivity.startActivity(localIntent);
      }
    }
  }
  
  public void cancelNaviModeSwitch() {}
  
  public int getAutoRefresh()
  {
    return this.mAutoRefresh;
  }
  
  public Activity getDetailActivity()
  {
    return this.mDetailActivity;
  }
  
  public MsgHandler getHandler()
  {
    return this.mHandler;
  }
  
  public boolean getIsLightNaviView()
  {
    return this.mIsLightNaviView;
  }
  
  public Activity getLightNaviBrightActivity()
  {
    return this.mLightNaviBrightActivity;
  }
  
  public void getRemianDisAndTime(Bundle paramBundle)
  {
    if (this.mJniGuideControl != null) {
      this.mJniGuideControl.getRemainRouteInfo(paramBundle);
    }
  }
  
  public int getType()
  {
    try
    {
      int i = this.mType;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void hideAvoidTrafficJamView()
  {
    if (this.mRGListener != null) {
      this.mRGListener.hideAvoidTrafficJamView();
    }
  }
  
  public void init(LightGuideRGListener paramLightGuideRGListener, Activity paramActivity)
  {
    setListener(paramLightGuideRGListener);
    setLightNaviBrightActivity(paramActivity);
    setIsNaving(true);
  }
  
  public boolean isHome()
  {
    List localList = getHomes();
    if ((localList != null) && (localList.size() > 0)) {
      return localList.contains(this.mPackageName);
    }
    return false;
  }
  
  public boolean isNaving()
  {
    try
    {
      boolean bool = this.mIsNaving;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isSwitching()
  {
    return this.isSwitching;
  }
  
  public void naviSwitchingCalcRoute(int paramInt)
  {
    this.mSwitchType = paramInt;
    BNLightNaviSwitchManager.getInstance().naviSwitchingCalcRoute(paramInt);
  }
  
  public void quitLightNavi()
  {
    if (this.mRGListener != null) {
      this.mRGListener.onQuitNavi();
    }
  }
  
  public void refreshScrennShot()
  {
    if (this.mRGListener != null) {
      this.mRGListener.refreshScreenShot();
    }
  }
  
  public void setAutoRefresh(int paramInt)
  {
    this.mAutoRefresh = paramInt;
  }
  
  public void setDetailActivity(Activity paramActivity)
  {
    this.mDetailActivity = paramActivity;
  }
  
  public void setIsLightNaviView(boolean paramBoolean)
  {
    this.mIsLightNaviView = paramBoolean;
  }
  
  public void setIsNaving(boolean paramBoolean)
  {
    try
    {
      this.mIsNaving = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setLightNaviBrightActivity(Activity paramActivity)
  {
    this.mLightNaviBrightActivity = paramActivity;
  }
  
  public void setListener(LightGuideRGListener paramLightGuideRGListener)
  {
    this.mRGListener = paramLightGuideRGListener;
  }
  
  public void setPackageName(String paramString)
  {
    this.mPackageName = paramString;
  }
  
  public void setSwitching(boolean paramBoolean)
  {
    this.isSwitching = paramBoolean;
    LogUtil.e(TAG, "setSwitching: switching --> " + paramBoolean);
  }
  
  public void setType(int paramInt)
  {
    for (int i = 1;; i = 0) {
      try
      {
        if (this.mType != paramInt)
        {
          this.mType = paramInt;
          if (this.mRGListener != null) {
            this.mRGListener.switchScrennType();
          }
        }
        else
        {
          if ((i != 0) && (paramInt == 1) && (this.mRGListener != null))
          {
            this.mRGListener.calcOtherRoute();
            this.mRGListener.refreshScreenShot();
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void showSafetyGuide(boolean paramBoolean)
  {
    if (this.mRGListener != null) {
      this.mRGListener.showSafetyGuide(paramBoolean);
    }
  }
  
  public void startUnLockScreen()
  {
    UserOPController.getInstance().add("4.6.1");
    if (!getInstance().isNaving()) {
      quitLightNavi();
    }
    getInstance().setType(2);
  }
  
  public void switch2AlternativeRoute(int paramInt)
  {
    BNLightNaviSwitchManager.getInstance().switch2AlternativeRoute(paramInt);
  }
  
  public void uninit()
  {
    this.mType = 2;
    this.mLightNaviBrightActivity = null;
    this.mIsNaving = false;
    this.mRGListener = null;
    BNRoutePlaner.getInstance().removeRouteResultHandler(this.mHandler);
    VMsgDispatcher.unregisterMsgHandler(this.mHandler);
    mInstance = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/controller/BNLightNaviManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */