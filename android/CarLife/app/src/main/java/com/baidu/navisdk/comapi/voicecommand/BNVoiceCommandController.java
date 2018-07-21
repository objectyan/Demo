package com.baidu.navisdk.comapi.voicecommand;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.geolocate.BNGeoLocateManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.AppStateUtils;
import com.baidu.navisdk.util.common.AppStateUtils.AppStateListener;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.PhoneStatusReceiver;
import com.baidu.navisdk.vi.VMsgDispatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;

public class BNVoiceCommandController
  extends BNLogicController
{
  private static final boolean Open_Stat = true;
  public static final String TAG = BNVoiceCommandController.class.getSimpleName();
  private static byte[] appID = new String("navinavinavinavinavinavinavinavi").getBytes();
  private static String cuid;
  private static int len;
  private static byte[] license;
  private static BNVoiceCommandController sInstance;
  private static Object sObj = new Object();
  private APPVoiceFuncCallback mAPPVoiceFuncCallback = null;
  private AppStateUtils.AppStateListener mAppStateListener = null;
  private boolean mHadResponseActionFinish = true;
  private Handler mHandler = null;
  private boolean mIsASRStarted = false;
  private boolean mIsJustStart = false;
  private boolean mIsRequestDelayResponse = false;
  private boolean mIsSettingHome = false;
  private boolean mIsSettingOffice = false;
  private int mLastestVCSubType = -1;
  private int mLastestVCTarget = -1;
  private int mLastestVCTopType = -1;
  private int mLastestVoiceStatus = 0;
  private OnVoiceCommandListener mOnVoiceCommandListener = null;
  private Set<OnVoiceStatusListener> mOnVoiceStatusListeners = new HashSet();
  private Object mSyncObj = new Object();
  
  static
  {
    sInstance = null;
    cuid = "baidu";
    license = new String("bdccd9288c0e962011eae8bf12369e61a0fcb254d48f340b5755ac0ef46dd3dd9bdd09100f2c681cc78b634824e9ff2d2babbdcea918214c0459d34755455407d8f0def5b5c6f09a40b60915c204cef2159a6c89b0a658aef707393d02081a0df0421cdb3fee0b33dd32d449ef330175fa8309d8992abb92044de98ea320a482").getBytes();
    len = license.length;
  }
  
  private void arrangeResponseTimeoutMsg()
  {
    if (this.mHandler == null) {
      return;
    }
    cancelResponseTimeoutMsg();
    this.mHandler.sendEmptyMessageDelayed(100, 90000L);
  }
  
  private Bundle asrGetVoiceASRRegResult()
  {
    return new Bundle();
  }
  
  private int asrTriggerRegActionFinish(BNVoiceCommandParams.VoiceRegActionFinishResult paramVoiceRegActionFinishResult)
  {
    LogUtil.e(TAG, "asrTriggerRegActionFinish() response, mode=" + paramVoiceRegActionFinishResult.regStatus + ", result=" + paramVoiceRegActionFinishResult.actionStatus);
    cancelResponseTimeoutMsg();
    requestDelayResponse(false);
    this.mHadResponseActionFinish = true;
    statVoiceCommand(paramVoiceRegActionFinishResult.actionStatus);
    return 0;
  }
  
  private void cancelResponseTimeoutMsg()
  {
    if (this.mHandler == null) {}
    while (!this.mHandler.hasMessages(100)) {
      return;
    }
    this.mHandler.removeMessages(100);
  }
  
  private boolean defaultHandleVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    boolean bool = true;
    if (2 == paramInt1) {
      switch (paramInt2)
      {
      default: 
        bool = false;
      }
    }
    label662:
    label794:
    label879:
    do
    {
      Object localObject1;
      do
      {
        do
        {
          return bool;
          NMapControlProxy.getInstance().zoomOut();
          commonVoiceCommandResponse(paramInt1, 1);
          return true;
          NMapControlProxy.getInstance().zoomIn();
          commonVoiceCommandResponse(paramInt1, 1);
          return true;
          if ((this.mAPPVoiceFuncCallback != null) && (this.mAPPVoiceFuncCallback.onFullview()))
          {
            getInstance().commonVoiceCommandResponse(paramInt1, 1);
            return true;
          }
          getInstance().commonVoiceCommandResponse(paramInt1, 2);
          return true;
          VoiceCommandHelper.onITSChanged(true);
          getInstance().commonVoiceCommandResponse(paramInt1, 1);
          return true;
          VoiceCommandHelper.onITSChanged(false);
          getInstance().commonVoiceCommandResponse(paramInt1, 1);
          return true;
          VoiceCommandHelper.MapMoveLeft();
          commonVoiceCommandResponse(paramInt1, 1);
          return true;
          VoiceCommandHelper.MapMoveRight();
          commonVoiceCommandResponse(paramInt1, 1);
          return true;
          VoiceCommandHelper.MapMoveUp();
          commonVoiceCommandResponse(paramInt1, 1);
          return true;
          VoiceCommandHelper.MapMoveDown();
          commonVoiceCommandResponse(paramInt1, 1);
          return true;
          if (this.mAPPVoiceFuncCallback != null)
          {
            if (this.mAPPVoiceFuncCallback.changeLocationMode(1))
            {
              commonVoiceCommandResponse(paramInt1, 1);
              return true;
            }
            commonVoiceCommandResponse(paramInt1, 2);
            return true;
          }
          commonVoiceCommandResponse(paramInt1, 3);
          return true;
          if (this.mAPPVoiceFuncCallback != null)
          {
            if (this.mAPPVoiceFuncCallback.changeLocationMode(2))
            {
              commonVoiceCommandResponse(paramInt1, 1);
              return true;
            }
            commonVoiceCommandResponse(paramInt1, 2);
            return true;
          }
          commonVoiceCommandResponse(paramInt1, 3);
          return true;
          if (this.mAPPVoiceFuncCallback != null)
          {
            this.mAPPVoiceFuncCallback.exitAPP();
            commonVoiceCommandResponse(paramInt1, 1);
            return true;
          }
          commonVoiceCommandResponse(paramInt1, 3);
          return true;
          BNSettingManager.setAlwaysBright(true);
          getInstance().commonVoiceCommandResponse(paramInt1, 1);
          return true;
          BNSettingManager.setAlwaysBright(false);
          getInstance().commonVoiceCommandResponse(paramInt1, 1);
          return true;
          if (3 == paramInt1)
          {
            switch (paramInt2)
            {
            }
            break;
          }
          if (5 != paramInt1) {
            break label879;
          }
          switch (paramInt2)
          {
          default: 
            break;
          case 3: 
            localObject2 = null;
            localObject1 = localObject2;
            if (paramObject != null)
            {
              localObject1 = localObject2;
              if ((paramObject instanceof Bundle)) {
                localObject1 = (Bundle)paramObject;
              }
            }
            localObject2 = null;
            paramObject = localObject2;
            if (localObject1 != null)
            {
              paramObject = localObject2;
              if (((Bundle)localObject1).containsKey("poiname"))
              {
                paramObject = ((Bundle)localObject1).getString("poiname");
                LogUtil.e(TAG, "Searchname2  poi=" + (String)paramObject);
              }
            }
            if (paramObject == null) {
              break label662;
            }
          }
        } while (this.mAPPVoiceFuncCallback.nameSearch((String)paramObject));
        commonVoiceCommandResponse(paramInt1, 2);
        return true;
        commonVoiceCommandResponse(paramInt1, 0);
        return true;
        Object localObject2 = null;
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = localObject2;
          if ((paramObject instanceof Bundle)) {
            localObject1 = (Bundle)paramObject;
          }
        }
        localObject2 = null;
        paramObject = localObject2;
        if (localObject1 != null)
        {
          paramObject = localObject2;
          if (((Bundle)localObject1).containsKey("poiname"))
          {
            paramObject = ((Bundle)localObject1).getString("poiname");
            LogUtil.e(TAG, "SearchAround  poi=" + (String)paramObject);
          }
        }
        if (paramObject == null) {
          break label794;
        }
      } while (this.mAPPVoiceFuncCallback.spaceSearch((String)paramObject));
      commonVoiceCommandResponse(paramInt1, 2);
      return true;
      commonVoiceCommandResponse(paramInt1, 0);
      return true;
      if (this.mAPPVoiceFuncCallback != null)
      {
        setIsSettingHome(true);
        setIsSettingOffice(false);
        this.mAPPVoiceFuncCallback.goHome();
        return true;
      }
      commonVoiceCommandResponse(paramInt1, 2);
      return true;
      if (this.mAPPVoiceFuncCallback != null)
      {
        setIsSettingHome(false);
        setIsSettingOffice(true);
        this.mAPPVoiceFuncCallback.goOffice();
        return true;
      }
      commonVoiceCommandResponse(paramInt1, 2);
      return true;
      if (4 != paramInt1) {
        break;
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        localObject1 = BNStyleManager.getString(1711669383);
        paramObject = localObject1;
        if (BNGeoLocateManager.getInstance().isGPSLocationValid())
        {
          paramObject = localObject1;
          if (BNGeoLocateManager.getInstance().getCurLocation() != null) {
            paramObject = StringUtils.getDirection(BNGeoLocateManager.getInstance().getCurLocation().direction, (String)localObject1);
          }
        }
        paramObject = (String)paramObject + BNStyleManager.getString(1711669871);
        getInstance().commonVoiceCommandResponse(paramInt1, 1, (String)paramObject);
        return true;
      }
    } while (this.mAPPVoiceFuncCallback == null);
    paramObject = this.mAPPVoiceFuncCallback.myLoc();
    if ((paramObject != null) && (((String)paramObject).length() > 0))
    {
      commonVoiceCommandResponse(paramInt1, 1, (String)paramObject);
      return true;
    }
    commonVoiceCommandResponse(paramInt1, 2);
    return true;
  }
  
  public static BNVoiceCommandController getInstance()
  {
    if (sInstance == null) {}
    synchronized (sObj)
    {
      if (sInstance == null) {
        sInstance = new BNVoiceCommandController();
      }
      return sInstance;
    }
  }
  
  private void handleAppStateChanged(int paramInt, boolean paramBoolean)
  {
    if ((3 == paramInt) || (1 == paramInt))
    {
      asrTriggerAppStatus(2);
      return;
    }
    if (!paramBoolean)
    {
      asrTriggerAppStatus(3);
      return;
    }
    asrTriggerAppStatus(1);
  }
  
  private void handleNetworkChanged(boolean paramBoolean1, boolean paramBoolean2) {}
  
  private void handlePhoneStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    }
    handleAppStateChanged(paramInt, AppStateUtils.getInstance().isForeground());
  }
  
  private void handleVoiceCommandMsg(int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (this.mSyncObj)
    {
      this.mHadResponseActionFinish = false;
      arrangeResponseTimeoutMsg();
      this.mLastestVCTopType = paramInt1;
      this.mLastestVCSubType = paramInt2;
      this.mLastestVCTarget = paramInt3;
      ??? = null;
      if (5 == paramInt1) {
        ??? = asrGetVoiceASRRegResult();
      }
      if (!preHandleVoiceCommand(paramInt1, paramInt2, paramInt3, ???)) {
        if (this.mOnVoiceCommandListener != null) {
          if ((!this.mOnVoiceCommandListener.onVoiceCommand(paramInt1, paramInt2, paramInt3, ???, true)) && (defaultHandleVoiceCommand(paramInt1, paramInt2, paramInt3, ???))) {
            this.mOnVoiceCommandListener.onVoiceCommand(paramInt1, paramInt2, paramInt3, null, false);
          }
        }
      }
    }
    synchronized (this.mSyncObj)
    {
      do
      {
        for (;;)
        {
          if ((!isRequestDelayResponse()) && (!this.mHadResponseActionFinish) && (5 != paramInt1))
          {
            this.mHadResponseActionFinish = true;
            BNVoiceCommandParams.VoiceRegActionFinishResult localVoiceRegActionFinishResult = new BNVoiceCommandParams.VoiceRegActionFinishResult();
            localVoiceRegActionFinishResult.regStatus = paramInt1;
            localVoiceRegActionFinishResult.actionStatus = 3;
            localVoiceRegActionFinishResult.extras = new Bundle();
            LogUtil.e(TAG, "BNVoiceCommandController.handleVoiceCommandMsg() default response");
            asrTriggerRegActionFinish(localVoiceRegActionFinishResult);
          }
          return;
          localObject2 = finally;
          throw ((Throwable)localObject2);
          defaultHandleVoiceCommand(paramInt1, paramInt2, paramInt3, ???);
        }
      } while (this.mOnVoiceCommandListener == null);
      this.mOnVoiceCommandListener.onVoiceCommand(paramInt1, paramInt2, paramInt3, null, false);
    }
  }
  
  private void initHandler()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(4154));
    localArrayList.add(Integer.valueOf(4155));
    localArrayList.add(Integer.valueOf(4156));
    localArrayList.add(Integer.valueOf(4157));
    localArrayList.add(Integer.valueOf(4158));
    localArrayList.add(Integer.valueOf(4159));
    localArrayList.add(Integer.valueOf(4161));
    this.mHandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool2 = true;
        int j = -1;
        int i = j;
        switch (paramAnonymousMessage.what)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          if (i >= 0) {
            BNVoiceCommandController.this.handleVoiceCommandMsg(i, paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
          }
          return;
          BNVoiceCommandController.this.onResponseTimeout();
          i = j;
          continue;
          i = 2;
          LogUtil.e(BNVoiceCommandController.TAG, "ui, arg1=" + paramAnonymousMessage.arg1 + ", arg2=" + paramAnonymousMessage.arg2);
          continue;
          i = 3;
          LogUtil.e(BNVoiceCommandController.TAG, "PAGE, arg1=" + paramAnonymousMessage.arg1 + ", arg2=" + paramAnonymousMessage.arg2);
          continue;
          i = 4;
          LogUtil.e(BNVoiceCommandController.TAG, "GUIDANCE, arg1=" + paramAnonymousMessage.arg1 + ", arg2=" + paramAnonymousMessage.arg2);
          continue;
          i = 5;
          LogUtil.e(BNVoiceCommandController.TAG, "SEARCH, arg1=" + paramAnonymousMessage.arg1 + ", arg2=" + paramAnonymousMessage.arg2);
          continue;
          if ((BNVoiceCommandController.this.mIsJustStart) && (paramAnonymousMessage.arg1 == 0))
          {
            BNVoiceCommandController.access$102(BNVoiceCommandController.this, false);
            i = j;
          }
          else
          {
            LogUtil.e(BNVoiceCommandController.TAG, "BNVoiceCommandController.status=" + paramAnonymousMessage.arg1);
            if ((paramAnonymousMessage.arg1 >= 0) && (paramAnonymousMessage.arg1 <= 3)) {
              BNVoiceCommandController.access$202(BNVoiceCommandController.this, paramAnonymousMessage.arg1);
            }
            Object localObject;
            if ((paramAnonymousMessage.arg1 >= 0) && (paramAnonymousMessage.arg1 <= 3) && (BNVoiceCommandController.this.mOnVoiceStatusListeners.size() > 0))
            {
              localObject = BNVoiceCommandController.this.mOnVoiceStatusListeners.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((OnVoiceStatusListener)((Iterator)localObject).next()).onVoiceStatusChanged(paramAnonymousMessage.arg1);
              }
            }
            i = j;
            if (paramAnonymousMessage.arg1 == 3)
            {
              BNVoiceCommandController.this.statVoiceCommandNotUnderstand();
              i = j;
              continue;
              i = j;
              if (BNVoiceCommandController.this.mAPPVoiceFuncCallback != null)
              {
                BNVoiceCommandController.this.mAPPVoiceFuncCallback.poiDataNotNew();
                i = j;
                continue;
                localObject = BNVoiceCommandController.this;
                boolean bool1;
                if (paramAnonymousMessage.arg2 == 1)
                {
                  bool1 = true;
                  label545:
                  if (paramAnonymousMessage.arg1 != 1) {
                    break label573;
                  }
                }
                for (;;)
                {
                  ((BNVoiceCommandController)localObject).handleNetworkChanged(bool1, bool2);
                  i = j;
                  break;
                  bool1 = false;
                  break label545;
                  label573:
                  bool2 = false;
                }
                BNVoiceCommandController.this.handlePhoneStateChanged(paramAnonymousMessage.arg1);
                i = j;
              }
            }
          }
        }
      }
    };
    VMsgDispatcher.registerMsgHandler(this.mHandler, localArrayList);
  }
  
  private void initListener()
  {
    if (this.mAppStateListener == null) {
      this.mAppStateListener = new AppStateUtils.AppStateListener()
      {
        public void onAppStateChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
        {
          if (1 == paramAnonymousInt1) {
            BNVoiceCommandController.this.handleAppStateChanged(AppStateUtils.getInstance().getPhoneStatus(), AppStateUtils.getInstance().isForeground());
          }
        }
      };
    }
    AppStateUtils.getInstance().addAppStateListener(this.mAppStateListener);
  }
  
  private void onResponseTimeout()
  {
    synchronized (this.mSyncObj)
    {
      if (!this.mHadResponseActionFinish)
      {
        this.mHadResponseActionFinish = true;
        BNVoiceCommandParams.VoiceRegActionFinishResult localVoiceRegActionFinishResult = new BNVoiceCommandParams.VoiceRegActionFinishResult();
        localVoiceRegActionFinishResult.regStatus = getLastestVCTopType();
        localVoiceRegActionFinishResult.actionStatus = 2;
        localVoiceRegActionFinishResult.extras = new Bundle();
        LogUtil.e(TAG, "BNVoiceCommandController.onResponseTimeout() timeout response.");
        asrTriggerRegActionFinish(localVoiceRegActionFinishResult);
      }
      return;
    }
  }
  
  private boolean preHandleVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (2 == paramInt1) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      return false;
      paramObject = new Intent("android.intent.action.CALL");
      if (BNaviModuleManager.getContext() != null) {
        BNaviModuleManager.getContext().startActivity((Intent)paramObject);
      }
      commonVoiceCommandResponse(paramInt1, 1);
      return true;
      AudioUtils.volumeUp(BNaviModuleManager.getContext());
      commonVoiceCommandResponse(paramInt1, 1);
      return true;
      AudioUtils.volumeDown(BNaviModuleManager.getContext());
      commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setVoiceMode(2);
      BNRouteGuider.getInstance().setVoiceMode(2);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setVoiceMode(0);
      BNRouteGuider.getInstance().setVoiceMode(0);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setVoiceMode(1);
      BNRouteGuider.getInstance().setVoiceMode(1);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setStraightDirectSpeakEnable(true);
      BNRouteGuider.getInstance().setStraightDirectSpeak(true);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setStraightDirectSpeakEnable(false);
      BNRouteGuider.getInstance().setStraightDirectSpeak(false);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setSpeedCameraSpeakEnable(true);
      BNRouteGuider.getInstance().setSpeedCameraSpeak(true);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setSpeedCameraSpeakEnable(false);
      BNRouteGuider.getInstance().setSpeedCameraSpeak(false);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      if (this.mAPPVoiceFuncCallback != null)
      {
        this.mAPPVoiceFuncCallback.switchDayNightMode(3);
        getInstance().commonVoiceCommandResponse(paramInt1, 1);
        return true;
      }
      return false;
      if (this.mAPPVoiceFuncCallback != null)
      {
        this.mAPPVoiceFuncCallback.switchDayNightMode(2);
        getInstance().commonVoiceCommandResponse(paramInt1, 1);
        return true;
      }
      return false;
      if (this.mAPPVoiceFuncCallback != null) {
        return this.mAPPVoiceFuncCallback.washCar();
      }
      getInstance().commonVoiceCommandResponse(paramInt1, 2);
      return true;
      if (this.mAPPVoiceFuncCallback != null) {
        return this.mAPPVoiceFuncCallback.weather();
      }
      getInstance().commonVoiceCommandResponse(paramInt1, 2);
      return true;
      if (this.mAPPVoiceFuncCallback != null) {
        return this.mAPPVoiceFuncCallback.limitLine();
      }
      getInstance().commonVoiceCommandResponse(paramInt1, 2);
      return true;
      VoiceCommandHelper.help();
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setElecCameraSpeakEnable(true);
      BNRouteGuider.getInstance().setElecCameraSpeak(true);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setElecCameraSpeakEnable(false);
      BNRouteGuider.getInstance().setElecCameraSpeak(false);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setSaftyDriveSpeakEnable(true);
      BNRouteGuider.getInstance().setSaftyDriveSpeak(true);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setSaftyDriveSpeakEnable(false);
      BNRouteGuider.getInstance().setSaftyDriveSpeak(false);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setPrefSearchMode(3);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setPrefSearchMode(2);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setPrefRoutePlanMode(3);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setPrefRoutePlanMode(2);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setRoadConditionpeakEnable(true);
      BNRouteGuider.getInstance().setRoadConditionSpeak(true);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setRoadConditionpeakEnable(false);
      BNRouteGuider.getInstance().setRoadConditionSpeak(false);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setSpeedCameraSpeakEnable(true);
      BNRouteGuider.getInstance().setSpeedCameraSpeak(true);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      BNSettingManager.setSpeedCameraSpeakEnable(false);
      BNRouteGuider.getInstance().setSpeedCameraSpeak(false);
      getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
      if (this.mAPPVoiceFuncCallback != null)
      {
        this.mAPPVoiceFuncCallback.showVoiceHelp();
        getInstance().commonVoiceCommandResponse(paramInt1, 1);
        return true;
      }
      return false;
      if ((3 != paramInt1) && (5 != paramInt1) && (4 == paramInt1)) {
        switch (paramInt2)
        {
        }
      }
    }
  }
  
  private void statVoiceCommand(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((str != null) && (str.length() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        paramInt = 0;
        if (this.mAPPVoiceFuncCallback != null) {
          paramInt = this.mAPPVoiceFuncCallback.getPageType();
        }
        BasicNameValuePair localBasicNameValuePair1 = new BasicNameValuePair("pg_type", Integer.toString(paramInt));
        BasicNameValuePair localBasicNameValuePair2 = new BasicNameValuePair("top_vc", Integer.toString(getLastestVCTopType()));
        BasicNameValuePair localBasicNameValuePair3 = new BasicNameValuePair("sub_vc", Integer.toString(getLastestVCSubType()));
        BasicNameValuePair localBasicNameValuePair4 = new BasicNameValuePair("target", Integer.toString(getLastestVCTarget()));
        localArrayList.add(localBasicNameValuePair1);
        localArrayList.add(localBasicNameValuePair2);
        localArrayList.add(localBasicNameValuePair3);
        localArrayList.add(localBasicNameValuePair4);
        BNStatisticsManager.getInstance().onEventWithParam(50008, str, localArrayList);
      }
      return;
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
    }
  }
  
  private void statVoiceCommandNotUnderstand()
  {
    int i = 0;
    if (this.mAPPVoiceFuncCallback != null) {
      i = this.mAPPVoiceFuncCallback.getPageType();
    }
    BasicNameValuePair localBasicNameValuePair = new BasicNameValuePair("pg_type", Integer.toString(i));
    BNStatisticsManager.getInstance().onEventWithParam(50008, "4", localBasicNameValuePair);
  }
  
  private void uninit()
  {
    uninitListener();
    NetworkListener.unRegisterMessageHandler(this.mHandler);
    PhoneStatusReceiver.unRegisterMessageHandler(this.mHandler);
  }
  
  private void uninitListener()
  {
    AppStateUtils.getInstance().removeAppStateListener(this.mAppStateListener);
  }
  
  private int voiceASRVerifyLicense()
  {
    return -1;
  }
  
  public void addOnVoiceStatusListener(OnVoiceStatusListener paramOnVoiceStatusListener)
  {
    if (paramOnVoiceStatusListener != null) {
      this.mOnVoiceStatusListeners.add(paramOnVoiceStatusListener);
    }
  }
  
  public int asrTriggerAppStatus(int paramInt)
  {
    return 0;
  }
  
  public int asrTriggerRecorderStatus(int paramInt)
  {
    return 0;
  }
  
  public int commonVoiceCommandResponse(int paramInt1, int paramInt2)
  {
    return commonVoiceCommandResponse(paramInt1, paramInt2, new Bundle());
  }
  
  public int commonVoiceCommandResponse(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    synchronized (this.mSyncObj)
    {
      if (!this.mHadResponseActionFinish)
      {
        this.mHadResponseActionFinish = true;
        ??? = new BNVoiceCommandParams.VoiceRegActionFinishResult();
        ((BNVoiceCommandParams.VoiceRegActionFinishResult)???).regStatus = paramInt1;
        ((BNVoiceCommandParams.VoiceRegActionFinishResult)???).actionStatus = paramInt2;
        ((BNVoiceCommandParams.VoiceRegActionFinishResult)???).extras = paramBundle;
        return asrTriggerRegActionFinish((BNVoiceCommandParams.VoiceRegActionFinishResult)???);
      }
      return 0;
    }
  }
  
  public int commonVoiceCommandResponse(int paramInt1, int paramInt2, String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      return commonVoiceCommandResponse(paramInt1, paramInt2, localBundle);
      localBundle.putString("weatherinfo", paramString);
      continue;
      localBundle.putString("weatherinfo", paramString);
      continue;
      localBundle.putString("curpoiinfo", paramString);
      continue;
      localBundle.putString("guidanceinfo", paramString);
    }
  }
  
  public int getLastestVCSubType()
  {
    return this.mLastestVCSubType;
  }
  
  public int getLastestVCTarget()
  {
    return this.mLastestVCTarget;
  }
  
  public int getLastestVCTopType()
  {
    return this.mLastestVCTopType;
  }
  
  public int getLastestVoiceStatus()
  {
    return this.mLastestVoiceStatus;
  }
  
  public void handleVoiceCommandMsg(int paramInt1, int paramInt2, int paramInt3, Bundle arg4)
  {
    synchronized (this.mSyncObj)
    {
      this.mHadResponseActionFinish = false;
      arrangeResponseTimeoutMsg();
      this.mLastestVCTopType = paramInt1;
      this.mLastestVCSubType = paramInt2;
      this.mLastestVCTarget = paramInt3;
      if (!preHandleVoiceCommand(paramInt1, paramInt2, paramInt3, ???)) {
        if (this.mOnVoiceCommandListener != null) {
          if ((!this.mOnVoiceCommandListener.onVoiceCommand(paramInt1, paramInt2, paramInt3, ???, true)) && (defaultHandleVoiceCommand(paramInt1, paramInt2, paramInt3, ???))) {
            this.mOnVoiceCommandListener.onVoiceCommand(paramInt1, paramInt2, paramInt3, null, false);
          }
        }
      }
    }
    synchronized (this.mSyncObj)
    {
      do
      {
        for (;;)
        {
          if ((!isRequestDelayResponse()) && (!this.mHadResponseActionFinish) && (5 != paramInt1))
          {
            this.mHadResponseActionFinish = true;
            ??? = new BNVoiceCommandParams.VoiceRegActionFinishResult();
            ((BNVoiceCommandParams.VoiceRegActionFinishResult)???).regStatus = paramInt1;
            ((BNVoiceCommandParams.VoiceRegActionFinishResult)???).actionStatus = 3;
            ((BNVoiceCommandParams.VoiceRegActionFinishResult)???).extras = new Bundle();
            LogUtil.e(TAG, "BNVoiceCommandController.handleVoiceCommandMsg() default respone");
            asrTriggerRegActionFinish((BNVoiceCommandParams.VoiceRegActionFinishResult)???);
          }
          return;
          ??? = finally;
          throw ???;
          defaultHandleVoiceCommand(paramInt1, paramInt2, paramInt3, ???);
        }
      } while (this.mOnVoiceCommandListener == null);
      this.mOnVoiceCommandListener.onVoiceCommand(paramInt1, paramInt2, paramInt3, null, false);
    }
  }
  
  public void init()
  {
    initHandler();
    initListener();
    NetworkListener.registerMessageHandler(this.mHandler);
    PhoneStatusReceiver.registerMessageHandler(this.mHandler);
  }
  
  public boolean isRequestDelayResponse()
  {
    return this.mIsRequestDelayResponse;
  }
  
  public boolean isSettingHome()
  {
    return this.mIsSettingHome;
  }
  
  public boolean isSettingOffice()
  {
    return this.mIsSettingOffice;
  }
  
  public boolean isStarted()
  {
    return this.mIsASRStarted;
  }
  
  public int pauseASR()
  {
    return 0;
  }
  
  public void removeOnVoiceStatusListener(OnVoiceStatusListener paramOnVoiceStatusListener)
  {
    if (paramOnVoiceStatusListener != null) {
      this.mOnVoiceStatusListeners.remove(paramOnVoiceStatusListener);
    }
  }
  
  public void requestDelayResponse(boolean paramBoolean)
  {
    this.mIsRequestDelayResponse = paramBoolean;
  }
  
  public int resumeASR()
  {
    return 0;
  }
  
  public void setAPPVoiceFuncCallback(APPVoiceFuncCallback paramAPPVoiceFuncCallback)
  {
    this.mAPPVoiceFuncCallback = paramAPPVoiceFuncCallback;
  }
  
  public void setIsSettingHome(boolean paramBoolean)
  {
    this.mIsSettingHome = paramBoolean;
  }
  
  public void setIsSettingOffice(boolean paramBoolean)
  {
    this.mIsSettingOffice = paramBoolean;
  }
  
  public void setOnVoiceCommandListener(OnVoiceCommandListener paramOnVoiceCommandListener)
  {
    this.mOnVoiceCommandListener = paramOnVoiceCommandListener;
  }
  
  public boolean startASR()
  {
    if (!this.mIsASRStarted) {}
    synchronized (sObj)
    {
      if (!this.mIsASRStarted)
      {
        if (voiceASRVerifyLicense() == 0)
        {
          LogUtil.e(TAG, "startASR() success");
          handleAppStateChanged(AppStateUtils.getInstance().getPhoneStatus(), AppStateUtils.getInstance().isForeground());
          DistrictInfo localDistrictInfo = GeoLocateModel.getInstance().getProvinceDistrict();
          if (localDistrictInfo != null) {
            int i = localDistrictInfo.mId;
          }
          this.mIsASRStarted = false;
        }
      }
      else {
        return this.mIsASRStarted;
      }
      this.mIsASRStarted = false;
      LogUtil.e(TAG, "startASR() failed");
    }
  }
  
  public int startVoiceRegDecode()
  {
    return 0;
  }
  
  public boolean stopASR()
  {
    if (this.mIsASRStarted) {}
    synchronized (sObj)
    {
      if ((!this.mIsASRStarted) || (!this.mIsASRStarted)) {
        return true;
      }
    }
    return false;
  }
  
  public int stopVoiceRegDecode()
  {
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/voicecommand/BNVoiceCommandController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */