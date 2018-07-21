package com.baidu.navisdk.comapi.offlinedata;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.jni.nativeif.JNIOfflineDataControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.commandparser.CmdGeneralFunc.Callback;
import com.baidu.navisdk.model.datastruct.ApkInfo;
import com.baidu.navisdk.model.datastruct.CheckNewInfo;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.model.datastruct.OfflineUpdateInfo;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.OfflineDataMergeMsgModel;
import com.baidu.navisdk.model.modelfactory.OfflineDataMergeMsgModel.MergeMessage;
import com.baidu.navisdk.model.modelfactory.OfflineDataModel;
import com.baidu.navisdk.module.car.BNYellowBannerTipsController;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.PhoneStatusReceiver;
import com.baidu.navisdk.util.listener.SDCardListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.navisdk.vi.VMsgDispatcher;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BNOfflineDataManager
  extends BNLogicController
{
  private static long DOWNLOADING_UPDATE_UI_INTERVAL = 1000L;
  public static final int SDCARD_ERROR = 2;
  private static final String TAG = "OffineData";
  private static boolean bHaveGetDownload = false;
  private static ArrayList<OfflineDataInfo> mDownloadProvince = new ArrayList();
  private static volatile BNOfflineDataManager mInstance;
  private static long mLastUpdateNotificationTime;
  private static long mLastUpdateUITime;
  private int curMd5ErrorProvince = -1;
  private Boolean isClickDownloadOnMobile = Boolean.valueOf(false);
  private int lastProvinceId = -1;
  private Activity mActivity = null;
  private int mCurDownloadID = -1;
  private OfflineDataInfo mCurDownloadingProvince = null;
  private MsgHandler mHandler = new MsgHandler(Looper.getMainLooper())
  {
    public void careAbout()
    {
      observe(4118);
      observe(4119);
      observe(4120);
      observe(4121);
      observe(4122);
      observe(4124);
      observe(4125);
      observe(4126);
      observe(4135);
      observe(4136);
      observe(4137);
      observe(4127);
      observe(4128);
      observe(4129);
      observe(4130);
      observe(4131);
      observe(4168);
      observe(4184);
      observe(4186);
      observe(4187);
      observe(4185);
      observe(4218);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.arg1;
      int j = paramAnonymousMessage.arg2;
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
        LogUtil.e("OffineData", "**download province id:" + i);
        if (BNOfflineDataManager.this.handleDownloadStart(i, j / 10, j))
        {
          BNOfflineDataManager.this.statistics(i, 0);
          BNOfflineDataManager.access$202(BNOfflineDataManager.this, -1);
          BNOfflineDataManager.access$302(BNOfflineDataManager.this, i);
          OfflineDataInfo localOfflineDataInfo = BNOfflineDataManager.this.mOfflineDataModel.getUndowloadInfo(i);
          if (localOfflineDataInfo != null) {
            localOfflineDataInfo.mTaskStatus = 2;
          }
          BNOfflineDataManager.this.updateUI();
          continue;
          LogUtil.e("Handler", "**download province id:" + i + " download mProgress:" + j);
          if (BNOfflineDataManager.this.HandleDownloadOnMobile().booleanValue()) {
            if ((BNOfflineDataManager.this.lastProvinceId != i) && (BNOfflineDataManager.this.checkSdcardError(i).booleanValue()))
            {
              BNOfflineDataManager.this.suspendBatchDownload();
            }
            else
            {
              BNOfflineDataManager.access$702(BNOfflineDataManager.this, i);
              BNOfflineDataManager.access$302(BNOfflineDataManager.this, i);
              BNOfflineDataManager.this.handleDownloadProgress(i, j / 10, j);
              continue;
              LogUtil.e("Handler", " in case  DOWNLOAD FINISH");
              BNOfflineDataManager.this.statistics(i, 1);
              BNOfflineDataManager.access$302(BNOfflineDataManager.this, -1);
              if (BNOfflineDataManager.this.updateDownloadFinish(i))
              {
                BNOfflineDataManager.access$1102(BNOfflineDataManager.this, true);
                BNOfflineDataManager.access$202(BNOfflineDataManager.this, -1);
                BNOfflineDataManager.this.updateUI();
              }
              if (BNOfflineDataManager.this.mActivity != null)
              {
                continue;
                LogUtil.e("Handler", " in case MSG_NAVI_DOWNLOAD_ERROR");
                if (paramAnonymousMessage.arg2 == 2)
                {
                  BNOfflineDataManager.this.handleSdcardError();
                  if (BNOfflineDataManager.this.mActivity == null) {}
                }
                for (;;)
                {
                  BNOfflineDataManager.this.updateUI();
                  break;
                  BNOfflineDataManager.this.handleNetWorkError();
                }
                LogUtil.e("Handler", " in case  MSG_NAVI_DOWNLOAD_MD5_ERROR mCurDownloadID " + BNOfflineDataManager.this.mCurDownloadID);
                BNOfflineDataManager.access$302(BNOfflineDataManager.this, i);
                BNOfflineDataManager.this.handleMd5Error(i);
                continue;
                LogUtil.e("Handler", "**update province id:" + i + " update mProgress:" + j);
                if (BNOfflineDataManager.this.HandleDownloadOnMobile().booleanValue())
                {
                  BNOfflineDataManager.access$302(BNOfflineDataManager.this, i);
                  BNOfflineDataManager.this.handleUpdateProgress(i, j / 10, j);
                  continue;
                  BNOfflineDataManager.this.statistics(i, 3);
                  BNOfflineDataManager.access$302(BNOfflineDataManager.this, -1);
                  if (BNOfflineDataManager.this.updateUpdateFinish(i, paramAnonymousMessage.arg2))
                  {
                    BNOfflineDataManager.access$202(BNOfflineDataManager.this, -1);
                    BNOfflineDataManager.access$1102(BNOfflineDataManager.this, true);
                    BNOfflineDataManager.this.updateUI();
                  }
                  if (BNOfflineDataManager.this.mActivity != null)
                  {
                    continue;
                    LogUtil.e("Handler", "==== in case update province id " + i);
                    if (BNOfflineDataManager.this.handleUpdateStart(i, j / 10, j))
                    {
                      BNOfflineDataManager.this.statistics(i, 2);
                      BNOfflineDataManager.access$202(BNOfflineDataManager.this, -1);
                      BNOfflineDataManager.access$302(BNOfflineDataManager.this, i);
                      BNOfflineDataManager.this.updateUI();
                      continue;
                      BNOfflineDataManager.this.handleDownloadRequest(i, paramAnonymousMessage.what);
                      BNOfflineDataManager.this.updateUI();
                      continue;
                      LogUtil.e("Handler", " in case PhoneStatusReceiver.MSG_TYPE_PHONE_CHANGE");
                      i = paramAnonymousMessage.arg1;
                      BNOfflineDataManager.this.handleTelphoneChange(i);
                      BNOfflineDataManager.this.updateUI();
                      continue;
                      LogUtil.e("Handler", " in case NetworkListener.MSG_TYPE_NET_WORK_CHANGE");
                      i = paramAnonymousMessage.arg1;
                      j = paramAnonymousMessage.arg2;
                      BNOfflineDataManager.this.handleNetWorkChange(i, j);
                      BNOfflineDataManager.this.updateUI();
                      continue;
                      LogUtil.e("Handler", " in case SDCardListener.MSG_TYPE_SDCARD_CHANGE");
                      i = paramAnonymousMessage.arg1;
                      BNOfflineDataManager.this.handleSDCardChange(i);
                      BNOfflineDataManager.this.updateUI();
                      continue;
                      BNOfflineDataManager.this.downloadApkProgress(j);
                      continue;
                      LogUtil.e("OffineData", "~recved DOWNLOAD_APK_SUCCESS");
                      BNOfflineDataManager.this.downloadApkSuccess();
                      continue;
                      LogUtil.e("OffineData", "~recved DOWNLOAD_APK_START");
                      BNOfflineDataManager.this.downloadApkStart(j);
                      continue;
                      LogUtil.e("OffineData", "~recved DOWNLOAD_APK_FAIL");
                      BNOfflineDataManager.this.downloadApkFail();
                      continue;
                      LogUtil.e("OffineData", "~recved DOWNLOAD_APK_NET_ERROR");
                      BNOfflineDataManager.this.downloadApkNetError();
                      continue;
                      LogUtil.e("Handler", "==== MSG_NAVI_Check_Data_Ver_Fail ");
                      BNOfflineDataManager.access$2702(BNOfflineDataManager.this, true);
                      continue;
                      if (BNOfflineDataManager.this.mergeStart(i))
                      {
                        BNOfflineDataManager.this.updateUI();
                        continue;
                        BNOfflineDataManager.access$302(BNOfflineDataManager.this, -1);
                        if (BNOfflineDataManager.this.updateUpdateFinish(i, paramAnonymousMessage.arg2))
                        {
                          BNOfflineDataManager.access$202(BNOfflineDataManager.this, -1);
                          BNOfflineDataManager.access$1102(BNOfflineDataManager.this, true);
                          BNOfflineDataManager.this.mIsUpdateFinishNotProgress = true;
                          BNOfflineDataManager.this.updateUI();
                          continue;
                          if (BNOfflineDataManager.this.mergeFail(i))
                          {
                            BNOfflineDataManager.this.updateUI();
                            continue;
                            if (BNOfflineDataManager.this.mergeWait(i))
                            {
                              BNOfflineDataManager.this.updateUI();
                              continue;
                              LogUtil.e("BNOfflineDataManager", "MSG_NAVI_DOWNLOAD_XIJIANG_SWITCH====");
                              BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("NaviDownLoadSwitch-" + getClass().getSimpleName(), null)new BNWorkerConfig
                              {
                                protected String execute()
                                {
                                  try
                                  {
                                    BNOfflineDataManager.access$3102(BNOfflineDataManager.this, true);
                                    LogUtil.e(TAG, "NaviDownLoadSwitch " + BNOfflineDataManager.this.mNeedReload);
                                    BNOfflineDataManager.this.initDownloadInfo(true);
                                    BNOfflineDataManager.this.updateUI();
                                    BNaviModuleManager.naviDownloadXiJiangSwitch();
                                    return null;
                                  }
                                  catch (Exception localException)
                                  {
                                    for (;;) {}
                                  }
                                }
                              }, new BNWorkerConfig(101, 0));
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  private boolean mHaveInitDownloadInfo = false;
  private boolean mHaveValidData = false;
  private ImportNaviMapDataListener mImportListener = null;
  private boolean mIsDataVerNotMatch = false;
  public boolean mIsUpdateFinishNotProgress = false;
  private int mLastProgress = -1;
  private Object mLock = new Object();
  private boolean mNeedReload = false;
  private boolean mNeedReloadCfgFile = true;
  private boolean mNewProvinceDownload = false;
  private JNIOfflineDataControl mOfflineDataControl;
  private OfflineDataModel mOfflineDataModel = null;
  private SDCardListener mSdcardListener;
  private BNMessageDialog mXiJiangDeleteAlertDlg = null;
  private boolean mhasInit = false;
  private LinkedList<Integer> userOperStartList = new LinkedList();
  private LinkedList<Integer> userOperUpdateList = new LinkedList();
  
  private BNOfflineDataManager()
  {
    LogUtil.e("OffineData", "~~~~~~~~~~~~~~~~~~~~~~~~~ BNOfflineDataManager constructor ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    this.mOfflineDataControl = JNIOfflineDataControl.getInstance();
    this.mOfflineDataModel = ((OfflineDataModel)NaviDataEngine.getInstance().getModel("OfflineDataModel"));
    VMsgDispatcher.registerMsgHandler(this.mHandler);
    NetworkListener.registerMessageHandler(this.mHandler);
    PhoneStatusReceiver.registerMessageHandler(this.mHandler);
    SDCardListener.registerMessageHandler(this.mHandler);
  }
  
  private Boolean HandleDownloadOnMobile()
  {
    if ((!getIsClickDownloadOnMobile().booleanValue()) && (!NetworkUtils.isTypeNetworkAvailable(BNaviModuleManager.getContext(), 1)))
    {
      setIsClickDownloadOnMobile(Boolean.valueOf(false));
      suspendBatchDownload();
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  private Boolean checkSdcardError(int paramInt)
  {
    OfflineDataInfo localOfflineDataInfo = null;
    if (this.mOfflineDataModel != null) {
      localOfflineDataInfo = this.mOfflineDataModel.getUndowloadInfo(paramInt);
    }
    if (localOfflineDataInfo != null)
    {
      double d = localOfflineDataInfo.mProgress / 100.0D;
      paramInt = (int)(localOfflineDataInfo.mSize * d);
      if (SDCardUtils.handleOfflinePathError(localOfflineDataInfo.mSize - paramInt, true) == 1) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
  
  private void deleteFinish(final String paramString)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DeleteFinish-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          BNOfflineDataManager.this.notifyObservers(2, 269, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadApkFail()
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadApkFail-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(3, 275, null);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadApkNetError()
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadApkNetError-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(3, 276, null);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadApkProgress(final int paramInt)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadApkProgress-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mProgress = paramInt;
          BNOfflineDataManager.this.notifyObservers(2, 273, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadApkStart(final int paramInt)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadApkStart-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mProgress = paramInt;
          BNOfflineDataManager.this.notifyObservers(2, 272, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadApkSuccess()
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadApkSuccess-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(2, 274, null);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadFinshed(final String paramString)
  {
    LogUtil.e("OffineData", "downloadFinshed name is " + paramString);
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadFinshed-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          LogUtil.e(TAG, "DownloadFinshed execute");
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          localDownloadArg.mProgress = 100;
          BNOfflineDataManager.this.notifyObservers(2, 262, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadProgress(final String paramString, final int paramInt)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadProgress-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          localDownloadArg.mProgress = paramInt;
          BNOfflineDataManager.this.notifyObservers(2, 261, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadRequestFail()
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadRequestFail-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(2, 258, null);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadRequestNetError()
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadRequestNetError-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(2, 259, null);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadRequestSuccess(final int paramInt)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadRequestSuccess-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mProgress = paramInt;
          BNOfflineDataManager.this.notifyObservers(2, 257, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadStart(final String paramString, final int paramInt)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadStart-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          localDownloadArg.mProgress = paramInt;
          BNOfflineDataManager.this.notifyObservers(2, 260, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void downloadSuspend(final String paramString, final int paramInt)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("DownloadSuspend-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          localDownloadArg.mProgress = paramInt;
          BNOfflineDataManager.this.notifyObservers(2, 263, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  public static BNOfflineDataManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNOfflineDataManager();
    }
    return mInstance;
  }
  
  private boolean handleDownloadProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt3 <= 1000)
    {
      bool1 = bool2;
      if (paramInt2 >= 0)
      {
        bool1 = bool2;
        if (paramInt2 > 100) {}
      }
    }
    for (;;)
    {
      long l1;
      long l3;
      try
      {
        OfflineDataInfo localOfflineDataInfo = this.mCurDownloadingProvince;
        if (localOfflineDataInfo == null)
        {
          bool1 = bool2;
          return bool1;
        }
        bool1 = bool2;
        if (this.mCurDownloadingProvince.mTaskStatus != 2) {
          continue;
        }
        bool2 = false;
        l1 = System.currentTimeMillis();
        long l2 = Math.abs(l1 - mLastUpdateNotificationTime);
        l3 = Math.abs(l1 - mLastUpdateUITime);
        if ((paramInt2 - this.mCurDownloadingProvince.mProgress >= 1) && (l2 >= DOWNLOADING_UPDATE_UI_INTERVAL))
        {
          downloadProgress(this.mCurDownloadingProvince.mName, paramInt2);
          mLastUpdateNotificationTime = l1;
          bool1 = true;
          this.mCurDownloadingProvince.mProgress = paramInt2;
          this.mCurDownloadingProvince.mProgressBy10 = paramInt3;
          this.mCurDownloadingProvince.formatStatusTips();
          continue;
        }
        bool1 = bool2;
      }
      finally {}
      if (l3 >= DOWNLOADING_UPDATE_UI_INTERVAL)
      {
        mLastUpdateUITime = l1;
        updateUI();
        bool1 = bool2;
      }
    }
  }
  
  private boolean handleDownloadRequest(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getUndowloadInfo(paramInt1);
        if (localOfflineDataInfo != null)
        {
          int i = localOfflineDataInfo.mTaskStatus;
          if (i == 1) {}
        }
        else
        {
          bool = false;
          return bool;
        }
        localOfflineDataInfo.mIsRequest = false;
        switch (paramInt2)
        {
        case 4135: 
          downloadProvinceData(paramInt1);
          downloadRequestSuccess(paramInt1);
          break;
        case 4136: 
          downloadRequestFail();
        }
      }
      finally {}
      continue;
      downloadRequestNetError();
    }
  }
  
  private boolean handleDownloadStart(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt2 > 100) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getUndowloadInfo(paramInt1);
        bool1 = bool2;
        if (localOfflineDataInfo == null) {
          continue;
        }
        if (localOfflineDataInfo.mTaskStatus != 2)
        {
          bool1 = bool2;
          if (localOfflineDataInfo.mTaskStatus != 3) {
            continue;
          }
        }
        localOfflineDataInfo.mProgress = paramInt2;
        localOfflineDataInfo.mProgressBy10 = paramInt3;
        localOfflineDataInfo.mTaskStatus = 2;
        downloadStart(localOfflineDataInfo.mName, paramInt2);
        this.mCurDownloadingProvince = localOfflineDataInfo;
        bool1 = true;
      }
      finally {}
    }
  }
  
  private void handleMd5Error(int paramInt)
  {
    this.curMd5ErrorProvince = paramInt;
    OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getUndowloadInfo(paramInt);
    if ((localOfflineDataInfo != null) && ((localOfflineDataInfo.mTaskStatus == 2) || (localOfflineDataInfo.mTaskStatus == 3))) {
      suspendDownloadProvinceData(paramInt);
    }
    localOfflineDataInfo = this.mOfflineDataModel.getDowloadedInfo(paramInt);
    if ((localOfflineDataInfo != null) && ((localOfflineDataInfo.mTaskStatus == 12) || (localOfflineDataInfo.mTaskStatus == 11))) {
      suspendUpdateProvinceData(paramInt);
    }
    notifiMD5Error();
  }
  
  private void handleNetWorkChange(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) || (paramInt1 == 0)) {}
    for (;;)
    {
      label114:
      try
      {
        handleNetWorkError();
        return;
      }
      finally {}
      if (paramInt1 == 1)
      {
        i = 0;
        paramInt2 = 0;
        if ((this.mCurDownloadingProvince != null) && (this.mCurDownloadingProvince.mTaskStatus == 6))
        {
          this.mOfflineDataControl.downloadData(this.mCurDownloadID);
          this.mCurDownloadingProvince.mIsSuspendByNetChange = false;
          if (!this.mCurDownloadingProvince.mIsNewVer) {
            continue;
          }
        }
        for (this.mCurDownloadingProvince.mTaskStatus = 11;; this.mCurDownloadingProvince.mTaskStatus = 3)
        {
          this.mCurDownloadingProvince.formatStatusTips();
          paramInt1 = i;
          if (this.mOfflineDataModel == null) {
            break;
          }
          paramInt1 = i;
          if (this.mOfflineDataModel.getUndowloadInfo() == null) {
            break;
          }
          i = 0;
          paramInt1 = paramInt2;
          if (i >= this.mOfflineDataModel.getUndowloadInfo().size()) {
            break;
          }
          OfflineDataInfo localOfflineDataInfo1 = (OfflineDataInfo)this.mOfflineDataModel.getUndowloadInfo().get(i);
          paramInt1 = paramInt2;
          if (localOfflineDataInfo1.mIsSuspendByNetChange != true) {
            break label375;
          }
          paramInt1 = paramInt2;
          if (localOfflineDataInfo1.mProvinceId == this.mCurDownloadID) {
            break label375;
          }
          paramInt1 = paramInt2;
          if (localOfflineDataInfo1.mTaskStatus != 6) {
            break label375;
          }
          this.mOfflineDataControl.downloadData(localOfflineDataInfo1.mProvinceId);
          localOfflineDataInfo1.mIsSuspendByNetChange = false;
          localOfflineDataInfo1.mTaskStatus = 3;
          localOfflineDataInfo1.formatStatusTips();
          paramInt1 = 1;
          break label375;
        }
      }
    }
    int i = paramInt1;
    if (this.mOfflineDataModel != null)
    {
      i = paramInt1;
      if (this.mOfflineDataModel.getDowloadedInfo() != null) {
        paramInt2 = 0;
      }
    }
    for (;;)
    {
      i = paramInt1;
      if (paramInt2 < this.mOfflineDataModel.getDowloadedInfo().size())
      {
        OfflineDataInfo localOfflineDataInfo2 = (OfflineDataInfo)this.mOfflineDataModel.getDowloadedInfo().get(paramInt2);
        i = paramInt1;
        if (localOfflineDataInfo2.mIsSuspendByNetChange == true)
        {
          i = paramInt1;
          if (localOfflineDataInfo2.mProvinceId != this.mCurDownloadID)
          {
            i = paramInt1;
            if (localOfflineDataInfo2.mTaskStatus == 6)
            {
              this.mOfflineDataControl.updateData(localOfflineDataInfo2.mProvinceId);
              localOfflineDataInfo2.mIsSuspendByNetChange = false;
              localOfflineDataInfo2.mTaskStatus = 11;
              localOfflineDataInfo2.formatStatusTips();
              i = 1;
            }
          }
        }
      }
      else
      {
        if (i == 0) {
          break;
        }
        updateUI();
        break;
        label375:
        i += 1;
        paramInt2 = paramInt1;
        break label114;
      }
      paramInt2 += 1;
      paramInt1 = i;
    }
  }
  
  private void handleNetWorkError()
  {
    for (;;)
    {
      int k;
      int j;
      try
      {
        this.mOfflineDataControl.suspendDownloadData(-1);
        k = 0;
        j = 0;
        int i = k;
        OfflineDataInfo localOfflineDataInfo;
        if (this.mOfflineDataModel != null)
        {
          i = k;
          if (this.mOfflineDataModel.getUndowloadInfo() != null)
          {
            k = 0;
            i = j;
            if (k < this.mOfflineDataModel.getUndowloadInfo().size())
            {
              localOfflineDataInfo = (OfflineDataInfo)this.mOfflineDataModel.getUndowloadInfo().get(k);
              if ((localOfflineDataInfo.mTaskStatus != 2) && (localOfflineDataInfo.mTaskStatus != 3)) {
                break label227;
              }
              localOfflineDataInfo.mIsSuspendByNetChange = true;
              localOfflineDataInfo.mTaskStatus = 6;
              localOfflineDataInfo.formatStatusTips();
              j = 1;
              break label227;
            }
          }
        }
        k = i;
        if (this.mOfflineDataModel != null)
        {
          k = i;
          if (this.mOfflineDataModel.getDowloadedInfo() != null)
          {
            j = 0;
            k = i;
            if (j < this.mOfflineDataModel.getDowloadedInfo().size())
            {
              localOfflineDataInfo = (OfflineDataInfo)this.mOfflineDataModel.getDowloadedInfo().get(j);
              if ((localOfflineDataInfo.mTaskStatus != 12) && (localOfflineDataInfo.mTaskStatus != 11)) {
                break label234;
              }
              localOfflineDataInfo.mIsSuspendByNetChange = true;
              localOfflineDataInfo.mTaskStatus = 6;
              localOfflineDataInfo.formatStatusTips();
              i = 1;
              break label234;
            }
          }
        }
        if (k != 0) {
          suspendAll();
        }
        return;
      }
      finally {}
      label227:
      k += 1;
      continue;
      label234:
      j += 1;
    }
  }
  
  private void handleSDCardChange(int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 3) || (paramInt == 4)) {}
    for (;;)
    {
      int j;
      int i;
      try
      {
        this.mOfflineDataControl.suspendDownloadData(-1);
        j = 0;
        i = 0;
        paramInt = j;
        OfflineDataInfo localOfflineDataInfo;
        if (this.mOfflineDataModel != null)
        {
          paramInt = j;
          if (this.mOfflineDataModel.getUndowloadInfo() != null)
          {
            j = 0;
            paramInt = i;
            if (j < this.mOfflineDataModel.getUndowloadInfo().size())
            {
              localOfflineDataInfo = (OfflineDataInfo)this.mOfflineDataModel.getUndowloadInfo().get(j);
              if ((localOfflineDataInfo.mTaskStatus != 2) && (localOfflineDataInfo.mTaskStatus != 3)) {
                break label236;
              }
              localOfflineDataInfo.mTaskStatus = 6;
              localOfflineDataInfo.formatStatusTips();
              i = 1;
              break label236;
            }
          }
        }
        j = paramInt;
        if (this.mOfflineDataModel != null)
        {
          j = paramInt;
          if (this.mOfflineDataModel.getDowloadedInfo() != null)
          {
            i = 0;
            j = paramInt;
            if (i < this.mOfflineDataModel.getDowloadedInfo().size())
            {
              localOfflineDataInfo = (OfflineDataInfo)this.mOfflineDataModel.getDowloadedInfo().get(i);
              if ((localOfflineDataInfo.mTaskStatus != 12) && (localOfflineDataInfo.mTaskStatus != 11)) {
                break label243;
              }
              localOfflineDataInfo.mIsSuspendByNetChange = true;
              localOfflineDataInfo.mTaskStatus = 6;
              localOfflineDataInfo.formatStatusTips();
              paramInt = 1;
              break label243;
            }
          }
        }
        if (j != 0) {
          suspendAll();
        }
        return;
      }
      finally {}
      label236:
      j += 1;
      continue;
      label243:
      i += 1;
    }
  }
  
  private void handleSdcardError()
  {
    int i;
    int k;
    int j;
    try
    {
      this.mOfflineDataControl.suspendDownloadData(-1);
      i = SDCardUtils.handleOfflinePathError(1048576L, true);
      if (i == 1) {
        sdcardFull();
      }
      for (;;)
      {
        k = 0;
        j = 0;
        i = k;
        if (this.mOfflineDataModel == null) {
          break;
        }
        i = k;
        if (this.mOfflineDataModel.getUndowloadInfo() == null) {
          break;
        }
        k = 0;
        i = j;
        if (k >= this.mOfflineDataModel.getUndowloadInfo().size()) {
          break;
        }
        OfflineDataInfo localOfflineDataInfo1 = (OfflineDataInfo)this.mOfflineDataModel.getUndowloadInfo().get(k);
        if ((localOfflineDataInfo1.mTaskStatus != 2) && (localOfflineDataInfo1.mTaskStatus != 3)) {
          break label243;
        }
        localOfflineDataInfo1.mTaskStatus = 9;
        localOfflineDataInfo1.formatStatusTips();
        j = 1;
        break label243;
        if (i != 0) {
          sdcardError();
        }
      }
      k = i;
    }
    finally {}
    if (this.mOfflineDataModel != null)
    {
      k = i;
      if (this.mOfflineDataModel.getDowloadedInfo() != null) {
        j = 0;
      }
    }
    for (;;)
    {
      k = i;
      if (j < this.mOfflineDataModel.getDowloadedInfo().size())
      {
        OfflineDataInfo localOfflineDataInfo2 = (OfflineDataInfo)this.mOfflineDataModel.getDowloadedInfo().get(j);
        if ((localOfflineDataInfo2.mTaskStatus == 12) || (localOfflineDataInfo2.mTaskStatus == 11))
        {
          localOfflineDataInfo2.mTaskStatus = 9;
          localOfflineDataInfo2.formatStatusTips();
          i = 1;
        }
      }
      else
      {
        if (k != 0) {
          suspendAll();
        }
        return;
        label243:
        k += 1;
        break;
      }
      j += 1;
    }
  }
  
  private void handleTelphoneChange(int paramInt)
  {
    int i;
    int k;
    int m;
    try
    {
      i = NetworkUtils.mWifiState;
      if (i == 1) {}
      for (;;)
      {
        return;
        j = 0;
        k = 0;
        m = 0;
        i = 0;
        switch (paramInt)
        {
        case 2: 
        default: 
          break;
        case 1: 
        case 3: 
          LogUtil.e("OffineData", "=======handle suspend download by telephone ");
          this.mOfflineDataControl.suspendDownloadData(-1);
          paramInt = j;
          label99:
          OfflineDataInfo localOfflineDataInfo1;
          if (this.mOfflineDataModel != null)
          {
            paramInt = j;
            if (this.mOfflineDataModel.getUndowloadInfo() != null)
            {
              j = 0;
              paramInt = i;
              if (j < this.mOfflineDataModel.getUndowloadInfo().size())
              {
                localOfflineDataInfo1 = (OfflineDataInfo)this.mOfflineDataModel.getUndowloadInfo().get(j);
                if ((localOfflineDataInfo1.mTaskStatus != 2) && (localOfflineDataInfo1.mTaskStatus != 3)) {
                  break label612;
                }
                localOfflineDataInfo1.mIsSuspendByPhoneChange = true;
                localOfflineDataInfo1.mTaskStatus = 4;
                localOfflineDataInfo1.formatStatusTips();
                i = 1;
                break label612;
              }
            }
          }
          j = paramInt;
          if (this.mOfflineDataModel != null)
          {
            j = paramInt;
            if (this.mOfflineDataModel.getDowloadedInfo() != null)
            {
              i = 0;
              label194:
              j = paramInt;
              if (i < this.mOfflineDataModel.getDowloadedInfo().size())
              {
                localOfflineDataInfo1 = (OfflineDataInfo)this.mOfflineDataModel.getDowloadedInfo().get(i);
                if ((localOfflineDataInfo1.mTaskStatus != 12) && (localOfflineDataInfo1.mTaskStatus != 11)) {
                  break label619;
                }
                localOfflineDataInfo1.mIsSuspendByPhoneChange = true;
                localOfflineDataInfo1.mTaskStatus = 13;
                localOfflineDataInfo1.formatStatusTips();
                paramInt = 1;
                break label619;
              }
            }
          }
          if (j != 0) {
            suspendAll();
          }
          break;
        }
      }
      LogUtil.e("OffineData", "=======handle resume download by telephone ");
    }
    finally {}
    if ((this.mCurDownloadingProvince != null) && (this.mCurDownloadingProvince.mIsSuspendByPhoneChange == true))
    {
      this.mOfflineDataControl.downloadData(this.mCurDownloadID);
      this.mCurDownloadingProvince.mIsSuspendByPhoneChange = false;
      if (!this.mCurDownloadingProvince.mIsNewVer) {
        break label476;
      }
    }
    label387:
    OfflineDataInfo localOfflineDataInfo2;
    label476:
    for (this.mCurDownloadingProvince.mTaskStatus = 11;; this.mCurDownloadingProvince.mTaskStatus = 3)
    {
      this.mCurDownloadingProvince.formatStatusTips();
      paramInt = m;
      if (this.mOfflineDataModel == null) {
        break;
      }
      paramInt = m;
      if (this.mOfflineDataModel.getUndowloadInfo() == null) {
        break;
      }
      j = 0;
      i = k;
      paramInt = i;
      if (j >= this.mOfflineDataModel.getUndowloadInfo().size()) {
        break;
      }
      localOfflineDataInfo2 = (OfflineDataInfo)this.mOfflineDataModel.getUndowloadInfo().get(j);
      paramInt = i;
      if (localOfflineDataInfo2.mIsSuspendByPhoneChange != true) {
        break label626;
      }
      paramInt = i;
      if (localOfflineDataInfo2.mTaskStatus != 4) {
        break label626;
      }
      this.mOfflineDataControl.downloadData(localOfflineDataInfo2.mProvinceId);
      localOfflineDataInfo2.mIsSuspendByPhoneChange = false;
      localOfflineDataInfo2.mTaskStatus = 3;
      localOfflineDataInfo2.formatStatusTips();
      paramInt = 1;
      break label626;
    }
    int j = paramInt;
    if (this.mOfflineDataModel != null)
    {
      j = paramInt;
      if (this.mOfflineDataModel.getDowloadedInfo() != null) {
        i = 0;
      }
    }
    for (;;)
    {
      j = paramInt;
      if (i < this.mOfflineDataModel.getDowloadedInfo().size())
      {
        localOfflineDataInfo2 = (OfflineDataInfo)this.mOfflineDataModel.getDowloadedInfo().get(i);
        j = paramInt;
        if (localOfflineDataInfo2.mIsSuspendByPhoneChange == true)
        {
          j = paramInt;
          if (localOfflineDataInfo2.mTaskStatus == 13)
          {
            this.mOfflineDataControl.updateData(localOfflineDataInfo2.mProvinceId);
            localOfflineDataInfo2.mIsSuspendByPhoneChange = false;
            localOfflineDataInfo2.mTaskStatus = 11;
            localOfflineDataInfo2.formatStatusTips();
            j = 1;
          }
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        updateUI();
        break;
        label612:
        j += 1;
        break label99;
        label619:
        i += 1;
        break label194;
        label626:
        j += 1;
        i = paramInt;
        break label387;
      }
      i += 1;
      paramInt = j;
    }
  }
  
  private boolean handleUpdateProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt3 <= 1000)
    {
      bool1 = bool2;
      if (paramInt2 <= 100)
      {
        if (paramInt2 >= 0) {
          break label39;
        }
        bool1 = bool2;
      }
    }
    label39:
    do
    {
      for (;;)
      {
        return bool1;
        try
        {
          if (this.mCurDownloadingProvince == null)
          {
            this.mCurDownloadingProvince = this.mOfflineDataModel.getDowloadedInfo(paramInt1);
            if (this.mCurDownloadingProvince == null)
            {
              LogUtil.e("OffineData", "handleUpdateProgress: !! no downloaded province was found by id " + paramInt1);
              bool1 = bool2;
              continue;
            }
          }
        }
        finally {}
      }
      if (this.mCurDownloadingProvince.mTaskStatus == 12) {
        break;
      }
      bool1 = bool2;
    } while (this.mCurDownloadingProvince.mTaskStatus != 11);
    bool2 = false;
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - mLastUpdateNotificationTime);
    long l3 = Math.abs(l1 - mLastUpdateUITime);
    if ((paramInt2 - this.mCurDownloadingProvince.mUpProgress >= 1) && (l2 >= DOWNLOADING_UPDATE_UI_INTERVAL))
    {
      updateProgress(this.mCurDownloadingProvince.mName, paramInt2);
      mLastUpdateNotificationTime = l1;
      bool1 = true;
    }
    for (;;)
    {
      this.mCurDownloadingProvince.mUpProgress = paramInt2;
      this.mCurDownloadingProvince.mUpProgressBy10 = paramInt3;
      this.mCurDownloadingProvince.mTaskStatus = 12;
      this.mCurDownloadingProvince.formatStatusTips();
      this.mCurDownloadingProvince.mIsNewVer = true;
      break;
      bool1 = bool2;
      if (l3 >= DOWNLOADING_UPDATE_UI_INTERVAL)
      {
        mLastUpdateUITime = l1;
        updateUI();
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  private boolean handleUpdateStart(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   9: iload_1
    //   10: invokevirtual 586	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	(I)Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   13: astore 6
    //   15: iload 5
    //   17: istore 4
    //   19: aload 6
    //   21: ifnull +13 -> 34
    //   24: iload_2
    //   25: bipush 100
    //   27: if_icmple +12 -> 39
    //   30: iload 5
    //   32: istore 4
    //   34: aload_0
    //   35: monitorexit
    //   36: iload 4
    //   38: ireturn
    //   39: aload 6
    //   41: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   44: bipush 12
    //   46: if_icmpeq +57 -> 103
    //   49: aload 6
    //   51: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   54: bipush 11
    //   56: if_icmpeq +47 -> 103
    //   59: aload 6
    //   61: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   64: bipush 13
    //   66: if_icmpeq +37 -> 103
    //   69: aload 6
    //   71: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   74: bipush 8
    //   76: if_icmpeq +27 -> 103
    //   79: aload 6
    //   81: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   84: bipush 9
    //   86: if_icmpeq +17 -> 103
    //   89: iload 5
    //   91: istore 4
    //   93: aload 6
    //   95: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   98: bipush 6
    //   100: if_icmpne -66 -> 34
    //   103: aload 6
    //   105: iload_2
    //   106: putfield 653	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgress	I
    //   109: aload 6
    //   111: iload_3
    //   112: putfield 659	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgressBy10	I
    //   115: aload 6
    //   117: bipush 12
    //   119: putfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   122: aload 6
    //   124: iconst_1
    //   125: putfield 602	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mIsNewVer	Z
    //   128: aload_0
    //   129: aload 6
    //   131: getfield 558	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mName	Ljava/lang/String;
    //   134: iload_2
    //   135: invokespecial 662	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:updateStart	(Ljava/lang/String;I)V
    //   138: aload_0
    //   139: aload 6
    //   141: putfield 165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadingProvince	Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   144: iconst_1
    //   145: istore 4
    //   147: goto -113 -> 34
    //   150: astore 6
    //   152: aload_0
    //   153: monitorexit
    //   154: aload 6
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	BNOfflineDataManager
    //   0	157	1	paramInt1	int
    //   0	157	2	paramInt2	int
    //   0	157	3	paramInt3	int
    //   17	129	4	bool1	boolean
    //   1	89	5	bool2	boolean
    //   13	127	6	localOfflineDataInfo	OfflineDataInfo
    //   150	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	15	150	finally
    //   39	89	150	finally
    //   93	103	150	finally
    //   103	144	150	finally
  }
  
  public static void initMergeMessageCache(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4184) {}
    for (;;)
    {
      try
      {
        OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.add(new OfflineDataMergeMsgModel.MergeMessage(paramInt2, 16));
        return;
      }
      finally {}
      if (paramInt1 == 4185) {
        OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.add(new OfflineDataMergeMsgModel.MergeMessage(paramInt2, 17));
      } else if (paramInt1 == 4187) {
        OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.add(new OfflineDataMergeMsgModel.MergeMessage(paramInt2, 19));
      } else if (paramInt1 == 4186) {
        OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.add(new OfflineDataMergeMsgModel.MergeMessage(paramInt2, 18));
      }
    }
  }
  
  private boolean isProvinceDownload(int paramInt)
  {
    int i = 0;
    int m = 0;
    if (!bHaveGetDownload)
    {
      getItemTable(2, mDownloadProvince);
      bHaveGetDownload = true;
    }
    int j = 0;
    while (j < mDownloadProvince.size())
    {
      int k = m;
      if (((OfflineDataInfo)mDownloadProvince.get(j)).mProvinceId == 0)
      {
        k = m;
        if (((OfflineDataInfo)mDownloadProvince.get(j)).mStatus == 2) {
          k = 1;
        }
      }
      int n = i;
      if (((OfflineDataInfo)mDownloadProvince.get(j)).mProvinceId == paramInt)
      {
        n = i;
        if (((OfflineDataInfo)mDownloadProvince.get(j)).mStatus == 2) {
          n = 1;
        }
      }
      j += 1;
      m = k;
      i = n;
    }
    return (m != 0) && (i != 0);
  }
  
  private boolean mergeFail(int paramInt)
  {
    OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getDowloadedInfo(paramInt);
    if (localOfflineDataInfo != null)
    {
      localOfflineDataInfo.mTaskStatus = 19;
      notifyMergeFail(localOfflineDataInfo.mName);
      return true;
    }
    return false;
  }
  
  private void mergeMessageCheck(OfflineDataInfo paramOfflineDataInfo)
  {
    int j = OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.size();
    int k = 0;
    int i = k;
    if (OfflineDataMergeMsgModel.getInstance().mMergerMessageCache != null)
    {
      i = k;
      if (j > 0) {
        j -= 1;
      }
    }
    for (;;)
    {
      i = k;
      if (j >= 0)
      {
        OfflineDataMergeMsgModel.MergeMessage localMergeMessage = (OfflineDataMergeMsgModel.MergeMessage)OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.get(j);
        if (localMergeMessage.mProviceId != paramOfflineDataInfo.mProvinceId) {
          break label287;
        }
        paramOfflineDataInfo.mTaskStatus = localMergeMessage.mMessageType;
        if (paramOfflineDataInfo.mTaskStatus != 16) {
          break label179;
        }
        if (mergeStart(paramOfflineDataInfo.mProvinceId)) {
          updateUI();
        }
        OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.remove(j);
        i = j - 1;
      }
      for (;;)
      {
        if ((OfflineDataMergeMsgModel.getInstance().mMergerMessageCache == null) || (i <= 0)) {
          return;
        }
        j = 0;
        while (j <= i)
        {
          if (((OfflineDataMergeMsgModel.MergeMessage)OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.get(j)).mProviceId == paramOfflineDataInfo.mProvinceId) {
            OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.remove(j);
          }
          j += 1;
        }
        label179:
        if (paramOfflineDataInfo.mTaskStatus == 17)
        {
          if (!mergeWait(paramOfflineDataInfo.mProvinceId)) {
            break;
          }
          updateUI();
          break;
        }
        if (paramOfflineDataInfo.mTaskStatus == 18)
        {
          this.mCurDownloadID = -1;
          if (!updateUpdateFinish(paramOfflineDataInfo.mProvinceId, 0)) {
            break;
          }
          this.mLastProgress = -1;
          this.mNewProvinceDownload = true;
          this.mIsUpdateFinishNotProgress = true;
          updateUI();
          break;
        }
        if (paramOfflineDataInfo.mTaskStatus != 19) {
          break;
        }
        i = k;
        if (mergeFail(paramOfflineDataInfo.mProvinceId))
        {
          updateUI();
          i = k;
        }
      }
      label287:
      j -= 1;
    }
  }
  
  private boolean mergeStart(int paramInt)
  {
    int i = this.mOfflineDataModel.getMergeStartID();
    if ((i > 0) && (i != paramInt)) {}
    OfflineDataInfo localOfflineDataInfo;
    do
    {
      return false;
      localOfflineDataInfo = this.mOfflineDataModel.getDowloadedInfo(paramInt);
    } while (localOfflineDataInfo == null);
    localOfflineDataInfo.mTaskStatus = 16;
    notifyMergeStart(localOfflineDataInfo.mName);
    return true;
  }
  
  private boolean mergeWait(int paramInt)
  {
    OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getDowloadedInfo(paramInt);
    if (localOfflineDataInfo != null)
    {
      localOfflineDataInfo.mTaskStatus = 17;
      notifyMergeWait(localOfflineDataInfo.mName);
      return true;
    }
    return false;
  }
  
  private void notifiMD5Error()
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("NotifiMD5Error-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(3, 278, null);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void notifyMergeFail(final String paramString)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("NotifyMergeFail-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          BNOfflineDataManager.this.notifyObservers(2, 291, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void notifyMergeStart(final String paramString)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("NotifyMergeStart-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          BNOfflineDataManager.this.notifyObservers(2, 288, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void notifyMergeSuccess(final String paramString)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("NotifyMergeSuccess-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          BNOfflineDataManager.this.notifyObservers(2, 290, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void notifyMergeWait(final String paramString)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("NotifyMergeWait-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          BNOfflineDataManager.this.notifyObservers(2, 289, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private static boolean removeDownloadProvince(int paramInt)
  {
    if (mDownloadProvince == null) {
      return false;
    }
    int i = 0;
    while (i < mDownloadProvince.size())
    {
      if ((((OfflineDataInfo)mDownloadProvince.get(i)).mProvinceId == paramInt) && (((OfflineDataInfo)mDownloadProvince.get(i)).mStatus == 2)) {
        mDownloadProvince.remove(i);
      }
      i += 1;
    }
    return true;
  }
  
  private void sdcardError()
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("SdcardError-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(3, 270, null);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  private void suspendAll()
  {
    int i = 0;
    final String str;
    if (this.mCurDownloadingProvince != null) {
      str = this.mCurDownloadingProvince.mName;
    }
    for (;;)
    {
      if (this.mCurDownloadingProvince != null) {
        i = this.mCurDownloadingProvince.mProgress;
      }
      final int j = i;
      if (this.mCurDownloadingProvince != null)
      {
        j = i;
        if (this.mCurDownloadingProvince.mIsNewVer) {
          j = this.mCurDownloadingProvince.mUpProgress;
        }
      }
      synchronized (this.mLock)
      {
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("SuspendAll-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
            localDownloadArg.mName = str;
            localDownloadArg.mProgress = j;
            BNOfflineDataManager.this.notifyObservers(2, 264, localDownloadArg);
            return null;
          }
        }, new BNWorkerConfig(101, 0), 0L);
        return;
        str = " ";
      }
    }
  }
  
  /* Error */
  private boolean updateDownloadFinish(final int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 92
    //   6: ldc_w 739
    //   9: invokestatic 227	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   16: iload_1
    //   17: invokevirtual 422	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	(I)Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   20: astore 4
    //   22: iload_3
    //   23: istore_2
    //   24: aload 4
    //   26: ifnull +52 -> 78
    //   29: aload 4
    //   31: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   34: iconst_2
    //   35: if_icmpeq +47 -> 82
    //   38: aload 4
    //   40: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   43: iconst_3
    //   44: if_icmpeq +38 -> 82
    //   47: ldc 92
    //   49: new 447	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 741
    //   59: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   67: invokevirtual 650	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 467	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 227	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: iload_3
    //   77: istore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: iload_2
    //   81: ireturn
    //   82: aload 4
    //   84: iconst_5
    //   85: putfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   88: aload 4
    //   90: bipush 100
    //   92: putfield 427	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProgress	I
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadingProvince	Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   100: aload_0
    //   101: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   104: iload_1
    //   105: invokevirtual 744	com/baidu/navisdk/model/modelfactory/OfflineDataModel:removeDataInUndownload	(I)V
    //   108: aload_0
    //   109: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   112: aload 4
    //   114: invokevirtual 747	com/baidu/navisdk/model/modelfactory/OfflineDataModel:addDataInDownloaded	(Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;)V
    //   117: new 749	com/baidu/navisdk/logic/ReqData
    //   120: dup
    //   121: ldc_w 751
    //   124: bipush 7
    //   126: new 753	android/os/Handler
    //   129: dup
    //   130: invokespecial 754	android/os/Handler:<init>	()V
    //   133: sipush 1401
    //   136: sipush 10000
    //   139: invokespecial 757	com/baidu/navisdk/logic/ReqData:<init>	(Ljava/lang/String;ILandroid/os/Handler;II)V
    //   142: astore 5
    //   144: aload 5
    //   146: new 64	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$5
    //   149: dup
    //   150: aload_0
    //   151: iload_1
    //   152: invokespecial 759	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$5:<init>	(Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;I)V
    //   155: invokestatic 765	com/baidu/navisdk/logic/commandparser/CmdGeneralFunc:addFunc	(Lcom/baidu/navisdk/logic/ReqData;Lcom/baidu/navisdk/logic/commandparser/CmdGeneralFunc$Callback;)V
    //   158: invokestatic 770	com/baidu/navisdk/logic/CommandCenter:getInstance	()Lcom/baidu/navisdk/logic/CommandCenter;
    //   161: aload 5
    //   163: invokevirtual 774	com/baidu/navisdk/logic/CommandCenter:sendRequest	(Lcom/baidu/navisdk/logic/ReqData;)I
    //   166: pop
    //   167: invokestatic 445	com/baidu/navisdk/util/worker/BNWorkerCenter:getInstance	()Lcom/baidu/navisdk/util/worker/IBNWorkerCenter;
    //   170: new 66	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$6
    //   173: dup
    //   174: aload_0
    //   175: new 447	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 776
    //   185: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_0
    //   189: invokevirtual 458	java/lang/Object:getClass	()Ljava/lang/Class;
    //   192: invokevirtual 464	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   195: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 467	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aconst_null
    //   202: invokespecial 777	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$6:<init>	(Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;Ljava/lang/String;Ljava/lang/String;)V
    //   205: new 472	com/baidu/navisdk/util/worker/BNWorkerConfig
    //   208: dup
    //   209: bipush 101
    //   211: iconst_0
    //   212: invokespecial 474	com/baidu/navisdk/util/worker/BNWorkerConfig:<init>	(II)V
    //   215: invokeinterface 781 3 0
    //   220: aload_0
    //   221: aload 4
    //   223: getfield 558	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mName	Ljava/lang/String;
    //   226: invokespecial 783	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:downloadFinshed	(Ljava/lang/String;)V
    //   229: iconst_1
    //   230: istore_2
    //   231: goto -153 -> 78
    //   234: astore 4
    //   236: aload_0
    //   237: monitorexit
    //   238: aload 4
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	BNOfflineDataManager
    //   0	241	1	paramInt	int
    //   23	208	2	bool1	boolean
    //   1	76	3	bool2	boolean
    //   20	202	4	localOfflineDataInfo	OfflineDataInfo
    //   234	5	4	localObject	Object
    //   142	20	5	localReqData	com.baidu.navisdk.logic.ReqData
    // Exception table:
    //   from	to	target	type
    //   4	22	234	finally
    //   29	76	234	finally
    //   82	229	234	finally
  }
  
  private void updateFinshed(final String paramString, final OfflineUpdateInfo paramOfflineUpdateInfo)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("UpdateFinshed-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          localDownloadArg.mUpdatePoiCount = paramOfflineUpdateInfo.mPOIUpCount;
          localDownloadArg.mUpdateRouteCount = paramOfflineUpdateInfo.mRouteUpCount;
          localDownloadArg.mUpdateDate = paramOfflineUpdateInfo.mUpdateDate;
          BNOfflineDataManager.this.notifyObservers(2, 267, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(100, 0), 0L);
      return;
    }
  }
  
  private void updateProgress(final String paramString, final int paramInt)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("UpdateProgress-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          localDownloadArg.mProgress = paramInt;
          BNOfflineDataManager.this.notifyObservers(2, 266, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(100, 0), 0L);
      return;
    }
  }
  
  private void updateStart(final String paramString, final int paramInt)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("UpdateStart-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          localDownloadArg.mProgress = paramInt;
          BNOfflineDataManager.this.notifyObservers(2, 265, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(100, 0), 0L);
      return;
    }
  }
  
  private void updateSuspend(final String paramString, final int paramInt)
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("UpdateSuspend-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataObserver.DownloadArg localDownloadArg = new BNOfflineDataObserver.DownloadArg();
          localDownloadArg.mName = paramString;
          localDownloadArg.mProgress = paramInt;
          BNOfflineDataManager.this.notifyObservers(2, 268, localDownloadArg);
          return null;
        }
      }, new BNWorkerConfig(100, 0), 0L);
      return;
    }
  }
  
  private void updateUI()
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("UpdateUI-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(1, 0, null);
          return null;
        }
      }, new BNWorkerConfig(7, 0), 0L);
      return;
    }
  }
  
  public boolean GetUpdatedInfo(int paramInt, OfflineUpdateInfo paramOfflineUpdateInfo)
  {
    Bundle localBundle = new Bundle();
    boolean bool = this.mOfflineDataControl.GetUpdatedInfo(paramInt, localBundle);
    paramOfflineUpdateInfo.mPOIUpCount = localBundle.getInt("unUpdatePoiCount");
    paramOfflineUpdateInfo.mRouteUpCount = localBundle.getInt("unUpdateRpCount");
    LogUtil.e("OffineData", "GetUpdatedInfo: POIUpCount " + paramOfflineUpdateInfo.mPOIUpCount + ", RouteUpCount " + paramOfflineUpdateInfo.mRouteUpCount);
    return bool;
  }
  
  public void UnInitSDCardListener(Activity paramActivity)
  {
    if ((paramActivity != null) && (this.mSdcardListener != null)) {}
    try
    {
      paramActivity.unregisterReceiver(this.mSdcardListener);
      this.mSdcardListener = null;
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public void cancelUpdateData(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   6: iload_1
    //   7: invokevirtual 586	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	(I)Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +68 -> 80
    //   15: aload_3
    //   16: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   19: bipush 13
    //   21: if_icmpeq +62 -> 83
    //   24: aload_3
    //   25: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   28: bipush 11
    //   30: if_icmpeq +53 -> 83
    //   33: aload_3
    //   34: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   37: bipush 12
    //   39: if_icmpeq +44 -> 83
    //   42: aload_3
    //   43: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   46: bipush 6
    //   48: if_icmpeq +35 -> 83
    //   51: aload_3
    //   52: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   55: bipush 12
    //   57: if_icmpeq +26 -> 83
    //   60: aload_3
    //   61: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   64: bipush 8
    //   66: if_icmpeq +17 -> 83
    //   69: aload_3
    //   70: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   73: istore_2
    //   74: iload_2
    //   75: bipush 9
    //   77: if_icmpeq +6 -> 83
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_3
    //   84: bipush 10
    //   86: putfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   89: aload_3
    //   90: iconst_1
    //   91: putfield 602	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mIsNewVer	Z
    //   94: aload_3
    //   95: iconst_0
    //   96: putfield 653	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgress	I
    //   99: aload_3
    //   100: iconst_0
    //   101: putfield 659	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgressBy10	I
    //   104: aload_0
    //   105: getfield 165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadingProvince	Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   108: ifnull +47 -> 155
    //   111: aload_0
    //   112: getfield 165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadingProvince	Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   115: getfield 616	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
    //   118: iload_1
    //   119: if_icmpne +36 -> 155
    //   122: aload_0
    //   123: getfield 165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadingProvince	Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   126: bipush 10
    //   128: putfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   131: aload_0
    //   132: getfield 165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadingProvince	Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   135: iconst_1
    //   136: putfield 602	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mIsNewVer	Z
    //   139: aload_0
    //   140: getfield 165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadingProvince	Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   143: iconst_0
    //   144: putfield 653	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgress	I
    //   147: aload_0
    //   148: getfield 165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadingProvince	Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   151: iconst_0
    //   152: putfield 659	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgressBy10	I
    //   155: aload_0
    //   156: getfield 235	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataControl	Lcom/baidu/navisdk/jni/nativeif/JNIOfflineDataControl;
    //   159: iload_1
    //   160: invokevirtual 624	com/baidu/navisdk/jni/nativeif/JNIOfflineDataControl:suspendDownloadData	(I)I
    //   163: pop
    //   164: aload_0
    //   165: getfield 235	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataControl	Lcom/baidu/navisdk/jni/nativeif/JNIOfflineDataControl;
    //   168: iload_1
    //   169: invokevirtual 846	com/baidu/navisdk/jni/nativeif/JNIOfflineDataControl:cancelUpdateData	(I)I
    //   172: pop
    //   173: iload_1
    //   174: aload_0
    //   175: getfield 167	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadID	I
    //   178: if_icmpne +16 -> 194
    //   181: aload_0
    //   182: iconst_m1
    //   183: putfield 167	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadID	I
    //   186: aload_0
    //   187: aload_3
    //   188: getfield 558	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mName	Ljava/lang/String;
    //   191: invokespecial 848	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:deleteFinish	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: invokespecial 402	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:updateUI	()V
    //   198: goto -118 -> 80
    //   201: astore_3
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_3
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	BNOfflineDataManager
    //   0	206	1	paramInt	int
    //   73	5	2	i	int
    //   10	178	3	localOfflineDataInfo	OfflineDataInfo
    //   201	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	201	finally
    //   15	74	201	finally
    //   83	155	201	finally
    //   155	194	201	finally
    //   194	198	201	finally
  }
  
  public boolean checkBaseMapDataExit(int paramInt)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      boolean bool = BNaviModuleManager.checkBaseMapDataExit(paramInt);
      long l2 = System.currentTimeMillis();
      LogUtil.e("testDelay:", "coast:" + (l2 - l1));
      LogUtil.e("DataOffLine:", "return :" + paramInt + "__" + bool);
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void checkDataVerNotMatch()
  {
    if (BNaviModuleManager.getActivity() == null) {
      return;
    }
    LogUtil.e("", "BNDownloadUIManager: isFirstShow checkDataVerNotMatch");
    PreferenceHelper.getInstance(BNaviModuleManager.getActivity()).putBoolean("SP_KEY_SHOW_TOAST_FOR_LINKID", true);
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("CheckDataVerNotMatch-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(3, 277, null);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  public boolean checkNewVer(CheckNewInfo paramCheckNewInfo, ApkInfo paramApkInfo, int[] paramArrayOfInt, boolean paramBoolean)
  {
    boolean bool3 = true;
    Bundle localBundle = new Bundle();
    try
    {
      bool1 = this.mOfflineDataControl.checkNewVer(localBundle, paramArrayOfInt);
      if (paramCheckNewInfo != null)
      {
        if (localBundle.getInt("newApp", 0) == 1)
        {
          bool2 = true;
          paramCheckNewInfo.mNewApp = bool2;
          if (localBundle.getInt("newData", 0) != 1) {
            break label278;
          }
          bool2 = bool3;
          paramCheckNewInfo.mNewData = bool2;
          paramCheckNewInfo.mCount = localBundle.getInt("count", 0);
          LogUtil.e("OffineData", "checkModel: newApp " + paramCheckNewInfo.mNewApp + ", newData " + paramCheckNewInfo.mNewData);
        }
      }
      else
      {
        if (paramApkInfo != null)
        {
          paramApkInfo.mUptime = StringUtils.charArrayToString(localBundle.getCharArray("cUptime"));
          paramApkInfo.mApkVer = StringUtils.charArrayToString(localBundle.getCharArray("cApkVer"));
          paramApkInfo.mInfo = StringUtils.shortArrayToString(localBundle.getShortArray("usApkInfo"));
          paramApkInfo.mApkSize = localBundle.getInt("unApkSize", 0);
          LogUtil.e("OffineData", "apkModel: upTime " + paramApkInfo.mUptime + ", ver " + paramApkInfo.mApkVer + ", info " + paramApkInfo.mInfo + ", size " + paramApkInfo.mApkSize);
        }
        initDownloadInfo(paramBoolean);
        return bool1;
      }
    }
    catch (Throwable paramArrayOfInt)
    {
      for (;;)
      {
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        label278:
        bool2 = false;
      }
    }
  }
  
  public int checkVer(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    try
    {
      int i = this.mOfflineDataControl.checkVer(paramArrayOfInt1, paramArrayOfInt2);
      return i;
    }
    finally
    {
      paramArrayOfInt1 = finally;
      throw paramArrayOfInt1;
    }
  }
  
  public void clearNewProvinceDownload()
  {
    this.mNewProvinceDownload = false;
  }
  
  public int downLoadAppData()
  {
    try
    {
      int i = this.mOfflineDataControl.downLoadAppData();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int downLoadCityMapData(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 281	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   5: iconst_1
    //   6: invokestatic 287	com/baidu/navisdk/util/common/NetworkUtils:isTypeNetworkAvailable	(Landroid/content/Context;I)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +16 -> 27
    //   14: invokestatic 233	com/baidu/navisdk/jni/nativeif/JNIOfflineDataControl:getInstance	()Lcom/baidu/navisdk/jni/nativeif/JNIOfflineDataControl;
    //   17: iload_1
    //   18: invokevirtual 988	com/baidu/navisdk/jni/nativeif/JNIOfflineDataControl:DownLoadCityMapData	(I)I
    //   21: istore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: astore_3
    //   27: iconst_m1
    //   28: istore_1
    //   29: goto -7 -> 22
    //   32: astore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_3
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	BNOfflineDataManager
    //   0	37	1	paramInt	int
    //   9	2	2	bool	boolean
    //   26	1	3	localThrowable	Throwable
    //   32	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	22	26	java/lang/Throwable
    //   2	10	32	finally
    //   14	22	32	finally
  }
  
  public void downloadProvinceData(int paramInt)
  {
    try
    {
      OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getUndowloadInfo(paramInt);
      if (localOfflineDataInfo != null)
      {
        this.mOfflineDataControl.downloadData(paramInt);
        localOfflineDataInfo.mTaskStatus = 3;
        updateUI();
      }
      return;
    }
    finally {}
  }
  
  public OfflineDataInfo getDataInfoByProvinceId(int paramInt)
  {
    try
    {
      OfflineDataInfo localOfflineDataInfo2 = this.mOfflineDataModel.getUndowloadInfo(paramInt);
      OfflineDataInfo localOfflineDataInfo1 = localOfflineDataInfo2;
      if (localOfflineDataInfo2 == null) {
        localOfflineDataInfo1 = this.mOfflineDataModel.getDowloadedInfo(paramInt);
      }
      return localOfflineDataInfo1;
    }
    finally {}
  }
  
  public ArrayList<OfflineDataInfo> getDownloadedList()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mOfflineDataModel != null) && (this.mOfflineDataModel.getDowloadedInfo() != null)) {
      localArrayList.addAll(this.mOfflineDataModel.getDowloadedInfo());
    }
    return localArrayList;
  }
  
  public Boolean getIsClickDownloadOnMobile()
  {
    return this.isClickDownloadOnMobile;
  }
  
  /* Error */
  public boolean getItemTable(int paramInt, ArrayList<OfflineDataInfo> paramArrayList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: bipush 36
    //   7: anewarray 807	android/os/Bundle
    //   10: astore 7
    //   12: aload_0
    //   13: getfield 235	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataControl	Lcom/baidu/navisdk/jni/nativeif/JNIOfflineDataControl;
    //   16: iload_1
    //   17: aload 7
    //   19: invokevirtual 999	com/baidu/navisdk/jni/nativeif/JNIOfflineDataControl:getItemTable	(I[Landroid/os/Bundle;)I
    //   22: istore 4
    //   24: aload 7
    //   26: arraylength
    //   27: istore 5
    //   29: iconst_0
    //   30: istore_3
    //   31: iload_3
    //   32: iload 5
    //   34: if_icmpge +274 -> 308
    //   37: aload 7
    //   39: iload_3
    //   40: aaload
    //   41: astore 8
    //   43: aload 8
    //   45: ifnull +247 -> 292
    //   48: new 424	com/baidu/navisdk/model/datastruct/OfflineDataInfo
    //   51: dup
    //   52: invokespecial 1000	com/baidu/navisdk/model/datastruct/OfflineDataInfo:<init>	()V
    //   55: astore 9
    //   57: aload 9
    //   59: aload 8
    //   61: ldc_w 1002
    //   64: invokevirtual 1006	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: putfield 558	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mName	Ljava/lang/String;
    //   70: aload 9
    //   72: aload 8
    //   74: ldc_w 1008
    //   77: invokevirtual 817	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   80: putfield 616	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
    //   83: aload 9
    //   85: aload 8
    //   87: ldc_w 1010
    //   90: invokevirtual 817	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   93: putfield 432	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mSize	I
    //   96: aload 9
    //   98: aload 8
    //   100: ldc_w 1012
    //   103: invokevirtual 817	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   106: putfield 1015	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpSize	I
    //   109: aload 9
    //   111: aload 8
    //   113: ldc_w 1017
    //   116: invokevirtual 817	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   119: putfield 1020	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mDownloadSize	I
    //   122: aload 9
    //   124: aload 8
    //   126: ldc_w 1022
    //   129: invokevirtual 817	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   132: putfield 1025	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mDownloadUpSize	I
    //   135: aload 9
    //   137: aload 8
    //   139: ldc_w 1027
    //   142: invokevirtual 817	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   145: putfield 686	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mStatus	I
    //   148: aload 9
    //   150: aload 8
    //   152: ldc_w 1029
    //   155: invokevirtual 817	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   158: putfield 563	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProgressBy10	I
    //   161: aload 9
    //   163: aload 8
    //   165: ldc_w 1031
    //   168: invokevirtual 817	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   171: putfield 659	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgressBy10	I
    //   174: aload 9
    //   176: aload 9
    //   178: getfield 563	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProgressBy10	I
    //   181: bipush 10
    //   183: idiv
    //   184: putfield 427	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProgress	I
    //   187: aload 9
    //   189: aload 9
    //   191: getfield 659	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgressBy10	I
    //   194: bipush 10
    //   196: idiv
    //   197: putfield 653	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgress	I
    //   200: aload_2
    //   201: aload 9
    //   203: invokevirtual 678	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   206: pop
    //   207: ldc 92
    //   209: new 447	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 1033
    //   219: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 9
    //   224: getfield 558	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mName	Ljava/lang/String;
    //   227: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc_w 1035
    //   233: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 9
    //   238: getfield 616	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
    //   241: invokevirtual 650	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 972
    //   247: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 9
    //   252: getfield 432	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mSize	I
    //   255: invokevirtual 650	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc_w 1037
    //   261: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 9
    //   266: getfield 1020	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mDownloadSize	I
    //   269: invokevirtual 650	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: ldc_w 1039
    //   275: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 9
    //   280: getfield 427	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProgress	I
    //   283: invokevirtual 650	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: invokevirtual 467	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 227	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: iload_3
    //   293: iconst_1
    //   294: iadd
    //   295: istore_3
    //   296: goto -265 -> 31
    //   299: astore_2
    //   300: iconst_0
    //   301: istore 6
    //   303: aload_0
    //   304: monitorexit
    //   305: iload 6
    //   307: ireturn
    //   308: getstatic 145	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:bHaveGetDownload	Z
    //   311: ifne +31 -> 342
    //   314: iload_1
    //   315: iconst_2
    //   316: if_icmpne +26 -> 342
    //   319: aload_2
    //   320: ifnull +22 -> 342
    //   323: aload_2
    //   324: invokevirtual 609	java/util/ArrayList:size	()I
    //   327: ifle +15 -> 342
    //   330: getstatic 152	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mDownloadProvince	Ljava/util/ArrayList;
    //   333: aload_2
    //   334: invokevirtual 994	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   337: pop
    //   338: iconst_1
    //   339: putstatic 145	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:bHaveGetDownload	Z
    //   342: iload 4
    //   344: iconst_m1
    //   345: if_icmpne -42 -> 303
    //   348: iconst_0
    //   349: istore 6
    //   351: goto -48 -> 303
    //   354: astore_2
    //   355: aload_0
    //   356: monitorexit
    //   357: aload_2
    //   358: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	BNOfflineDataManager
    //   0	359	1	paramInt	int
    //   0	359	2	paramArrayList	ArrayList<OfflineDataInfo>
    //   30	266	3	i	int
    //   22	324	4	j	int
    //   27	8	5	k	int
    //   1	349	6	bool	boolean
    //   10	28	7	arrayOfBundle	Bundle[]
    //   41	123	8	localBundle	Bundle
    //   55	224	9	localOfflineDataInfo	OfflineDataInfo
    // Exception table:
    //   from	to	target	type
    //   12	24	299	java/lang/Throwable
    //   5	12	354	finally
    //   12	24	354	finally
    //   24	29	354	finally
    //   48	292	354	finally
    //   308	314	354	finally
    //   323	342	354	finally
  }
  
  public boolean getNeedReload()
  {
    return this.mNeedReload;
  }
  
  public boolean getNeedUpdateInfo(ArrayList<OfflineDataInfo> paramArrayList)
  {
    try
    {
      boolean bool = getItemTable(3, paramArrayList);
      return bool;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public List<Integer> getSuspendDownloadDataInfo()
  {
    Object localObject = this.mOfflineDataModel.getUndowloadInfo();
    ArrayList localArrayList = new ArrayList();
    BitSet localBitSet = BNSettingManager.getDownloadProvinceIdSet();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)((Iterator)localObject).next();
      if ((localOfflineDataInfo.mTaskStatus == 4) && (!localBitSet.get(localOfflineDataInfo.mProvinceId))) {
        localArrayList.add(Integer.valueOf(localOfflineDataInfo.mProvinceId));
      }
    }
    int i = 0;
    while (i < localBitSet.size())
    {
      if (localBitSet.get(i)) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<OfflineDataInfo> getUndowloadList()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mOfflineDataModel != null) && (this.mOfflineDataModel.getUndowloadInfo() != null)) {
      localArrayList.addAll(this.mOfflineDataModel.getUndowloadInfo());
    }
    return localArrayList;
  }
  
  public void handleMd5ToRedownload()
  {
    int i = this.curMd5ErrorProvince;
    OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getUndowloadInfo(i);
    if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 4)) {
      removeProvinceData(i);
    }
    localOfflineDataInfo = this.mOfflineDataModel.getDowloadedInfo(i);
    if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 13))
    {
      cancelUpdateData(i);
      removeProvinceData(i);
    }
    startDownloadRequest(i);
  }
  
  public boolean hasContainOfflineData()
  {
    if (OfflineDataParams.PROVINCE_NAME != null)
    {
      int i = 0;
      while (i < OfflineDataParams.PROVINCE_NAME.length)
      {
        if (isProvinceDataDownload(i)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean hasSuspendDownloadDataInfo()
  {
    Iterator localIterator = this.mOfflineDataModel.getUndowloadInfo().iterator();
    while (localIterator.hasNext()) {
      if (((OfflineDataInfo)localIterator.next()).mTaskStatus == 4) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public boolean haveValidData()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 147	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 150	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aload_0
    //   11: iconst_2
    //   12: aload_3
    //   13: invokevirtual 683	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:getItemTable	(ILjava/util/ArrayList;)Z
    //   16: pop
    //   17: iconst_0
    //   18: istore_1
    //   19: aload_3
    //   20: ifnull +61 -> 81
    //   23: iload_1
    //   24: aload_3
    //   25: invokevirtual 609	java/util/ArrayList:size	()I
    //   28: if_icmpge +53 -> 81
    //   31: aload_3
    //   32: iload_1
    //   33: invokevirtual 613	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   36: checkcast 424	com/baidu/navisdk/model/datastruct/OfflineDataInfo
    //   39: astore 4
    //   41: aload 4
    //   43: iconst_5
    //   44: putfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   47: aload 4
    //   49: aload 4
    //   51: getfield 432	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mSize	I
    //   54: invokestatic 1105	com/baidu/navisdk/util/common/StringUtils:ByteSizeToString	(I)Ljava/lang/String;
    //   57: putfield 1108	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mStrSize	Ljava/lang/String;
    //   60: aload 4
    //   62: getfield 616	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
    //   65: ifne +25 -> 90
    //   68: aload_3
    //   69: invokevirtual 609	java/util/ArrayList:size	()I
    //   72: iconst_2
    //   73: if_icmplt +17 -> 90
    //   76: aload_0
    //   77: iconst_1
    //   78: putfield 175	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mHaveValidData	Z
    //   81: aload_0
    //   82: getfield 175	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mHaveValidData	Z
    //   85: istore_2
    //   86: aload_0
    //   87: monitorexit
    //   88: iload_2
    //   89: ireturn
    //   90: iload_1
    //   91: iconst_1
    //   92: iadd
    //   93: istore_1
    //   94: goto -75 -> 19
    //   97: astore_3
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_3
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	BNOfflineDataManager
    //   18	76	1	i	int
    //   85	4	2	bool	boolean
    //   9	60	3	localArrayList	ArrayList
    //   97	4	3	localObject	Object
    //   39	22	4	localOfflineDataInfo	OfflineDataInfo
    // Exception table:
    //   from	to	target	type
    //   2	17	97	finally
    //   23	81	97	finally
    //   81	86	97	finally
  }
  
  public void initDownloadInfo(boolean paramBoolean)
  {
    Object localObject3;
    Object localObject2;
    ArrayList localArrayList1;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    ArrayList localArrayList5;
    ArrayList localArrayList6;
    int i;
    OfflineDataInfo localOfflineDataInfo;
    for (;;)
    {
      try
      {
        if (!this.mhasInit) {
          break label572;
        }
        localObject3 = new ArrayList();
        localObject2 = new ArrayList();
        localArrayList1 = new ArrayList();
        localArrayList3 = new ArrayList();
        localArrayList4 = new ArrayList();
        getItemTable(0, (ArrayList)localObject3);
        getItemTable(1, (ArrayList)localObject2);
        getItemTable(2, localArrayList1);
        getItemTable(3, localArrayList3);
        getItemTable(4, localArrayList4);
        localArrayList5 = new ArrayList();
        localArrayList6 = new ArrayList();
        i = 0;
        if ((localObject3 != null) && (i < ((ArrayList)localObject3).size()))
        {
          localOfflineDataInfo = (OfflineDataInfo)((ArrayList)localObject3).get(i);
          localOfflineDataInfo.mTaskStatus = 1;
          localOfflineDataInfo.mStrSize = StringUtils.ByteSizeToString(localOfflineDataInfo.mSize);
          i += 1;
          continue;
        }
        if (localObject3 == null) {
          break label1101;
        }
        localArrayList5.addAll((Collection)localObject3);
      }
      finally {}
      if ((localObject2 == null) || (i >= ((ArrayList)localObject2).size())) {
        continue;
      }
      localObject3 = (OfflineDataInfo)((ArrayList)localObject2).get(i);
      ((OfflineDataInfo)localObject3).mTaskStatus = 4;
      ((OfflineDataInfo)localObject3).mStrSize = StringUtils.ByteSizeToString(((OfflineDataInfo)localObject3).mSize);
      i += 1;
    }
    if (localObject2 != null) {
      localArrayList5.addAll((Collection)localObject2);
    }
    this.mHaveValidData = false;
    int j = 0;
    label252:
    label316:
    int m;
    int k;
    if (j < localArrayList1.size())
    {
      localObject2 = (OfflineDataInfo)localArrayList1.get(j);
      ((OfflineDataInfo)localObject2).mTaskStatus = 5;
      ((OfflineDataInfo)localObject2).mStrSize = StringUtils.ByteSizeToString(((OfflineDataInfo)localObject2).mSize);
      if ((((OfflineDataInfo)localObject2).mProvinceId == 0) && (localArrayList1.size() >= 2))
      {
        this.mHaveValidData = true;
        break label1106;
        i = m;
        if (k >= localArrayList3.size()) {
          break label1119;
        }
        if (((OfflineDataInfo)localObject2).mProvinceId != ((OfflineDataInfo)localArrayList3.get(k)).mProvinceId) {
          break label1132;
        }
        ((OfflineDataInfo)localObject2).mTaskStatus = 10;
        ((OfflineDataInfo)localObject2).mStrSize = StringUtils.ByteSizeToString(((OfflineDataInfo)localObject2).mSize);
        ((OfflineDataInfo)localObject2).mIsNewVer = true;
        localArrayList6.add(localObject2);
        i = 1;
        break label1119;
        label389:
        m = i;
        if (k < localArrayList4.size())
        {
          if (((OfflineDataInfo)localObject2).mProvinceId != ((OfflineDataInfo)localArrayList4.get(k)).mProvinceId) {
            break label1141;
          }
          ((OfflineDataInfo)localObject2).mTaskStatus = 13;
          ((OfflineDataInfo)localObject2).mStrSize = StringUtils.ByteSizeToString(((OfflineDataInfo)localObject2).mSize);
          ((OfflineDataInfo)localObject2).mIsNewVer = true;
          localArrayList6.add(localObject2);
          m = 1;
        }
        if (OfflineDataMergeMsgModel.getInstance().getIsMergeNeedCache()) {
          mergeMessageCheck((OfflineDataInfo)localObject2);
        }
        if (m != 0) {
          break label1125;
        }
        localArrayList6.add(localObject2);
        break label1125;
        label491:
        if (OfflineDataMergeMsgModel.getInstance().getIsMergeNeedCache()) {
          mergeMessageCheck((OfflineDataInfo)localObject2);
        }
        localArrayList6.add(localObject2);
        break label1125;
      }
    }
    else
    {
      Collections.sort(localArrayList5, new ComparatorUtil());
      if (this.mOfflineDataModel != null)
      {
        this.mOfflineDataModel.initUnDownloadInfo(localArrayList5);
        this.mOfflineDataModel.initDownloadedInfo(localArrayList6);
      }
      OfflineDataMergeMsgModel.getInstance().setIsMergeNeedCache(false);
      label569:
      return;
      label572:
      this.mhasInit = true;
      localObject3 = new ArrayList();
      localObject2 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localArrayList4 = new ArrayList();
      getItemTable(0, (ArrayList)localObject3);
      getItemTable(1, (ArrayList)localObject2);
      getItemTable(2, localArrayList2);
      getItemTable(3, localArrayList3);
      getItemTable(4, localArrayList4);
      localArrayList5 = new ArrayList();
      localArrayList6 = new ArrayList();
      i = 0;
      while ((localObject3 != null) && (i < ((ArrayList)localObject3).size()))
      {
        localOfflineDataInfo = (OfflineDataInfo)((ArrayList)localObject3).get(i);
        localOfflineDataInfo.mTaskStatus = 1;
        localOfflineDataInfo.mStrSize = StringUtils.ByteSizeToString(localOfflineDataInfo.mSize);
        i += 1;
      }
      if (localObject3 == null) {
        break label1150;
      }
      localArrayList5.addAll((Collection)localObject3);
      break label1150;
      label749:
      while ((localObject2 != null) && (i < ((ArrayList)localObject2).size()))
      {
        localObject3 = (OfflineDataInfo)((ArrayList)localObject2).get(i);
        ((OfflineDataInfo)localObject3).mTaskStatus = 4;
        ((OfflineDataInfo)localObject3).mStrSize = StringUtils.ByteSizeToString(((OfflineDataInfo)localObject3).mSize);
        i += 1;
      }
      if (localObject2 != null) {
        localArrayList5.addAll((Collection)localObject2);
      }
      this.mHaveValidData = false;
      j = 0;
      label820:
      if (j < localArrayList2.size())
      {
        localObject2 = (OfflineDataInfo)localArrayList2.get(j);
        ((OfflineDataInfo)localObject2).mTaskStatus = 5;
        ((OfflineDataInfo)localObject2).mStrSize = StringUtils.ByteSizeToString(((OfflineDataInfo)localObject2).mSize);
        if ((((OfflineDataInfo)localObject2).mProvinceId != 0) || (localArrayList2.size() < 2)) {
          break label1155;
        }
        this.mHaveValidData = true;
        break label1155;
        label884:
        i = m;
        if (k >= localArrayList3.size()) {
          break label1168;
        }
        if (((OfflineDataInfo)localObject2).mProvinceId != ((OfflineDataInfo)localArrayList3.get(k)).mProvinceId) {
          break label1181;
        }
        ((OfflineDataInfo)localObject2).mTaskStatus = 10;
        ((OfflineDataInfo)localObject2).mStrSize = StringUtils.ByteSizeToString(((OfflineDataInfo)localObject2).mSize);
        ((OfflineDataInfo)localObject2).mIsNewVer = true;
        localArrayList6.add(localObject2);
        i = 1;
        break label1168;
      }
    }
    for (;;)
    {
      m = i;
      if (k < localArrayList4.size())
      {
        if (((OfflineDataInfo)localObject2).mProvinceId == ((OfflineDataInfo)localArrayList4.get(k)).mProvinceId)
        {
          ((OfflineDataInfo)localObject2).mTaskStatus = 13;
          ((OfflineDataInfo)localObject2).mStrSize = StringUtils.ByteSizeToString(((OfflineDataInfo)localObject2).mSize);
          ((OfflineDataInfo)localObject2).mIsNewVer = true;
          localArrayList6.add(localObject2);
          m = 1;
        }
      }
      else
      {
        if (m == 0)
        {
          localArrayList6.add(localObject2);
          break label1174;
          label1101:
          label1106:
          label1119:
          label1125:
          label1132:
          label1141:
          label1150:
          label1155:
          do
          {
            localArrayList6.add(localObject2);
            break label1174;
            Collections.sort(localArrayList5, new ComparatorUtil());
            if (this.mOfflineDataModel != null)
            {
              this.mOfflineDataModel.initUnDownloadInfo(localArrayList5);
              this.mOfflineDataModel.initDownloadedInfo(localArrayList6);
            }
            this.mHaveInitDownloadInfo = true;
            break label569;
            i = 0;
            break;
            if (!paramBoolean) {
              break label491;
            }
            m = 0;
            k = 0;
            break label316;
            k = 0;
            break label389;
            j += 1;
            break label252;
            k += 1;
            break label316;
            k += 1;
            break label389;
            i = 0;
            break label749;
          } while (!paramBoolean);
          m = 0;
          k = 0;
          break label884;
          label1168:
          k = 0;
          continue;
        }
        label1174:
        j += 1;
        break label820;
        label1181:
        k += 1;
        break label884;
      }
      k += 1;
    }
  }
  
  public void initDownloadInfoForfirst()
  {
    for (;;)
    {
      Object localObject2;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      int i;
      try
      {
        localObject2 = new ArrayList();
        localArrayList1 = new ArrayList();
        getItemTable(0, (ArrayList)localObject2);
        getItemTable(1, localArrayList1);
        localArrayList2 = new ArrayList();
        i = 0;
        if ((localObject2 != null) && (i < ((ArrayList)localObject2).size()))
        {
          OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)((ArrayList)localObject2).get(i);
          localOfflineDataInfo.mTaskStatus = 1;
          localOfflineDataInfo.mStrSize = StringUtils.ByteSizeToString(localOfflineDataInfo.mSize);
          i += 1;
          continue;
        }
        if (localObject2 == null) {
          break label196;
        }
        localArrayList2.addAll((Collection)localObject2);
      }
      finally {}
      if ((localArrayList1 != null) && (i < localArrayList1.size()))
      {
        localObject2 = (OfflineDataInfo)localArrayList1.get(i);
        ((OfflineDataInfo)localObject2).mTaskStatus = 4;
        ((OfflineDataInfo)localObject2).mStrSize = StringUtils.ByteSizeToString(((OfflineDataInfo)localObject2).mSize);
        i += 1;
      }
      else
      {
        if (localArrayList1 != null) {
          localArrayList2.addAll(localArrayList1);
        }
        Collections.sort(localArrayList2, new ComparatorUtil());
        this.mOfflineDataModel.initUnDownloadInfo(localArrayList2);
        return;
        label196:
        i = 0;
      }
    }
  }
  
  public void initSDCardListener(Activity paramActivity)
  {
    IntentFilter localIntentFilter;
    if ((this.mSdcardListener == null) && (paramActivity != null))
    {
      this.mSdcardListener = new SDCardListener();
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
      localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
      localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
      localIntentFilter.addDataScheme("file");
    }
    try
    {
      paramActivity.registerReceiver(this.mSdcardListener, localIntentFilter);
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  /* Error */
  public boolean isCommonDataDownload()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   9: ifnull +65 -> 74
    //   12: aload_0
    //   13: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   16: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   19: ifnull +55 -> 74
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: aload_0
    //   26: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   29: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   32: invokevirtual 609	java/util/ArrayList:size	()I
    //   35: if_icmpge +39 -> 74
    //   38: aload_0
    //   39: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   42: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   45: iload_1
    //   46: invokevirtual 613	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   49: checkcast 424	com/baidu/navisdk/model/datastruct/OfflineDataInfo
    //   52: getfield 616	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
    //   55: istore_2
    //   56: iload_2
    //   57: ifne +10 -> 67
    //   60: iload 4
    //   62: istore_3
    //   63: aload_0
    //   64: monitorexit
    //   65: iload_3
    //   66: ireturn
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: istore_1
    //   71: goto -47 -> 24
    //   74: aload_0
    //   75: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   78: ifnull +86 -> 164
    //   81: aload_0
    //   82: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   85: invokevirtual 605	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	()Ljava/util/ArrayList;
    //   88: ifnull +76 -> 164
    //   91: iconst_0
    //   92: istore_1
    //   93: iload_1
    //   94: aload_0
    //   95: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   98: invokevirtual 605	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	()Ljava/util/ArrayList;
    //   101: invokevirtual 609	java/util/ArrayList:size	()I
    //   104: if_icmpge +60 -> 164
    //   107: aload_0
    //   108: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   111: invokevirtual 605	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	()Ljava/util/ArrayList;
    //   114: iload_1
    //   115: invokevirtual 613	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   118: checkcast 424	com/baidu/navisdk/model/datastruct/OfflineDataInfo
    //   121: astore 5
    //   123: aload 5
    //   125: getfield 616	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
    //   128: ifne +29 -> 157
    //   131: iload 4
    //   133: istore_3
    //   134: aload 5
    //   136: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   139: iconst_2
    //   140: if_icmpeq -77 -> 63
    //   143: aload 5
    //   145: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   148: istore_2
    //   149: iload 4
    //   151: istore_3
    //   152: iload_2
    //   153: iconst_3
    //   154: if_icmpeq -91 -> 63
    //   157: iload_1
    //   158: iconst_1
    //   159: iadd
    //   160: istore_1
    //   161: goto -68 -> 93
    //   164: iconst_0
    //   165: istore_3
    //   166: goto -103 -> 63
    //   169: astore 5
    //   171: aload_0
    //   172: monitorexit
    //   173: aload 5
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	BNOfflineDataManager
    //   23	138	1	i	int
    //   55	100	2	j	int
    //   62	104	3	bool1	boolean
    //   1	149	4	bool2	boolean
    //   121	23	5	localOfflineDataInfo	OfflineDataInfo
    //   169	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	22	169	finally
    //   24	56	169	finally
    //   74	91	169	finally
    //   93	131	169	finally
    //   134	149	169	finally
  }
  
  /* Error */
  public boolean isDeleteCommonDataVailid()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: istore 4
    //   5: iload 4
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   12: ifnull +57 -> 69
    //   15: iload 4
    //   17: istore_3
    //   18: aload_0
    //   19: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   22: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   25: ifnull +44 -> 69
    //   28: iconst_0
    //   29: istore_1
    //   30: iload 4
    //   32: istore_3
    //   33: iload_1
    //   34: aload_0
    //   35: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   38: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   41: invokevirtual 609	java/util/ArrayList:size	()I
    //   44: if_icmpge +25 -> 69
    //   47: aload_0
    //   48: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   51: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   54: iload_1
    //   55: invokevirtual 613	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   58: checkcast 424	com/baidu/navisdk/model/datastruct/OfflineDataInfo
    //   61: getfield 616	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
    //   64: ifeq +90 -> 154
    //   67: iconst_0
    //   68: istore_3
    //   69: iload_3
    //   70: istore 4
    //   72: aload_0
    //   73: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   76: ifnull +73 -> 149
    //   79: iload_3
    //   80: istore 4
    //   82: aload_0
    //   83: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   86: invokevirtual 605	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	()Ljava/util/ArrayList;
    //   89: ifnull +60 -> 149
    //   92: iconst_0
    //   93: istore_1
    //   94: iload_3
    //   95: istore 4
    //   97: iload_1
    //   98: aload_0
    //   99: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   102: invokevirtual 605	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	()Ljava/util/ArrayList;
    //   105: invokevirtual 609	java/util/ArrayList:size	()I
    //   108: if_icmpge +41 -> 149
    //   111: aload_0
    //   112: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   115: invokevirtual 605	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	()Ljava/util/ArrayList;
    //   118: iload_1
    //   119: invokevirtual 613	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   122: checkcast 424	com/baidu/navisdk/model/datastruct/OfflineDataInfo
    //   125: astore 5
    //   127: aload 5
    //   129: getfield 616	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
    //   132: ifeq +29 -> 161
    //   135: aload 5
    //   137: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   140: istore_2
    //   141: iload_2
    //   142: iconst_1
    //   143: if_icmpeq +18 -> 161
    //   146: iconst_0
    //   147: istore 4
    //   149: aload_0
    //   150: monitorexit
    //   151: iload 4
    //   153: ireturn
    //   154: iload_1
    //   155: iconst_1
    //   156: iadd
    //   157: istore_1
    //   158: goto -128 -> 30
    //   161: iload_1
    //   162: iconst_1
    //   163: iadd
    //   164: istore_1
    //   165: goto -71 -> 94
    //   168: astore 5
    //   170: aload_0
    //   171: monitorexit
    //   172: aload 5
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	BNOfflineDataManager
    //   29	136	1	i	int
    //   140	4	2	j	int
    //   7	88	3	bool1	boolean
    //   3	149	4	bool2	boolean
    //   125	11	5	localOfflineDataInfo	OfflineDataInfo
    //   168	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	15	168	finally
    //   18	28	168	finally
    //   33	67	168	finally
    //   72	79	168	finally
    //   82	92	168	finally
    //   97	141	168	finally
  }
  
  public boolean isNeedReloadCfgFile()
  {
    return this.mNeedReloadCfgFile;
  }
  
  public boolean isNewDataUpdating()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mOfflineDataModel != null) && (this.mOfflineDataModel.getDowloadedInfo() != null))
    {
      localArrayList.addAll(this.mOfflineDataModel.getDowloadedInfo());
      int i = 0;
      while (i < localArrayList.size())
      {
        OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)localArrayList.get(i);
        if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mIsNewVer == true) && ((localOfflineDataInfo.mTaskStatus == 12) || (localOfflineDataInfo.mTaskStatus == 11))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean isNewProvinceDownload()
  {
    return this.mNewProvinceDownload;
  }
  
  public boolean isNewUpdateData()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mOfflineDataModel != null) && (this.mOfflineDataModel.getDowloadedInfo() != null))
    {
      localArrayList.addAll(this.mOfflineDataModel.getDowloadedInfo());
      int i = 0;
      while (i < localArrayList.size())
      {
        OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)localArrayList.get(i);
        if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mIsNewVer == true)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean isProvinceDataDownload(int paramInt)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    if ((this.mOfflineDataModel != null) && (this.mOfflineDataModel.getDowloadedInfo() != null) && (this.mOfflineDataModel.getDowloadedInfo().size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.mOfflineDataModel.getDowloadedInfo());
      i = 0;
      bool1 = bool2;
      if (i < localArrayList.size())
      {
        OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)localArrayList.get(i);
        if ((localOfflineDataInfo == null) || (localOfflineDataInfo.mProvinceId != paramInt)) {
          break label98;
        }
        bool1 = true;
      }
    }
    label98:
    do
    {
      return bool1;
      i += 1;
      break;
      if (!this.mhasInit) {
        break label122;
      }
      bool1 = bool2;
    } while (this.mHaveInitDownloadInfo);
    label122:
    return isProvinceDownload(paramInt);
  }
  
  /* Error */
  public boolean isProvinceDownloadCommonNotDownload()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_3
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   13: ifnull +64 -> 77
    //   16: iload_3
    //   17: istore_2
    //   18: aload_0
    //   19: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   22: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   25: ifnull +52 -> 77
    //   28: iconst_0
    //   29: istore_1
    //   30: iload_3
    //   31: istore_2
    //   32: iload_1
    //   33: aload_0
    //   34: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   37: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   40: invokevirtual 609	java/util/ArrayList:size	()I
    //   43: if_icmpge +34 -> 77
    //   46: aload_0
    //   47: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   50: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   53: iload_1
    //   54: invokevirtual 613	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   57: checkcast 424	com/baidu/navisdk/model/datastruct/OfflineDataInfo
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +74 -> 138
    //   67: aload 6
    //   69: getfield 616	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
    //   72: ifne +66 -> 138
    //   75: iconst_1
    //   76: istore_2
    //   77: iload 5
    //   79: istore 4
    //   81: aload_0
    //   82: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   85: ifnull +48 -> 133
    //   88: iload 5
    //   90: istore 4
    //   92: aload_0
    //   93: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   96: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   99: ifnull +34 -> 133
    //   102: iload 5
    //   104: istore 4
    //   106: iload_2
    //   107: ifne +26 -> 133
    //   110: aload_0
    //   111: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   114: invokevirtual 618	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	()Ljava/util/ArrayList;
    //   117: invokevirtual 609	java/util/ArrayList:size	()I
    //   120: istore_1
    //   121: iload 5
    //   123: istore 4
    //   125: iload_1
    //   126: iconst_2
    //   127: if_icmplt +6 -> 133
    //   130: iconst_1
    //   131: istore 4
    //   133: aload_0
    //   134: monitorexit
    //   135: iload 4
    //   137: ireturn
    //   138: iload_1
    //   139: iconst_1
    //   140: iadd
    //   141: istore_1
    //   142: goto -112 -> 30
    //   145: astore 6
    //   147: aload_0
    //   148: monitorexit
    //   149: aload 6
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	BNOfflineDataManager
    //   29	113	1	i	int
    //   8	99	2	j	int
    //   6	25	3	k	int
    //   79	57	4	bool1	boolean
    //   1	121	5	bool2	boolean
    //   60	8	6	localOfflineDataInfo	OfflineDataInfo
    //   145	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	16	145	finally
    //   18	28	145	finally
    //   32	62	145	finally
    //   67	75	145	finally
    //   81	88	145	finally
    //   92	102	145	finally
    //   110	121	145	finally
  }
  
  public void memoryUserOper(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.userOperStartList == null) {
      this.userOperStartList = new LinkedList();
    }
    if (this.userOperUpdateList == null) {
      this.userOperUpdateList = new LinkedList();
    }
    new LinkedList();
    LinkedList localLinkedList;
    if (paramInt2 == 0)
    {
      localLinkedList = this.userOperStartList;
      if (!paramBoolean) {
        break label141;
      }
      if (!localLinkedList.contains(Integer.valueOf(paramInt1))) {
        localLinkedList.add(Integer.valueOf(paramInt1));
      }
    }
    for (;;)
    {
      LogUtil.e("BNOfflineDataManager", "memoryUserOper type:" + paramInt2 + ",provinceID:" + paramInt1 + ",isByClick:" + paramBoolean);
      do
      {
        return;
      } while (paramInt2 != 1);
      localLinkedList = this.userOperUpdateList;
      break;
      label141:
      if (localLinkedList.contains(Integer.valueOf(paramInt1))) {
        localLinkedList.remove(Integer.valueOf(paramInt1));
      }
    }
  }
  
  public int pauseAppDataDownLoad()
  {
    try
    {
      int i = this.mOfflineDataControl.pauseAppDataDownLoad();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int removeAppData()
  {
    try
    {
      int i = this.mOfflineDataControl.removeAppData();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void removeProvinceData(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: bipush 64
    //   4: newarray <illegal type>
    //   6: astore_3
    //   7: iconst_1
    //   8: newarray <illegal type>
    //   10: astore 4
    //   12: aload_0
    //   13: iload_1
    //   14: invokespecial 1165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:isProvinceDownload	(I)Z
    //   17: istore_2
    //   18: aload_0
    //   19: getfield 235	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataControl	Lcom/baidu/navisdk/jni/nativeif/JNIOfflineDataControl;
    //   22: iload_1
    //   23: invokevirtual 624	com/baidu/navisdk/jni/nativeif/JNIOfflineDataControl:suspendDownloadData	(I)I
    //   26: pop
    //   27: aload_0
    //   28: getfield 235	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataControl	Lcom/baidu/navisdk/jni/nativeif/JNIOfflineDataControl;
    //   31: iload_1
    //   32: invokevirtual 1191	com/baidu/navisdk/jni/nativeif/JNIOfflineDataControl:removeDownloadData	(I)I
    //   35: pop
    //   36: aload_0
    //   37: getfield 235	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataControl	Lcom/baidu/navisdk/jni/nativeif/JNIOfflineDataControl;
    //   40: iload_1
    //   41: aload_3
    //   42: aload 4
    //   44: invokevirtual 1195	com/baidu/navisdk/jni/nativeif/JNIOfflineDataControl:getProvinceMapFileId	(I[I[I)I
    //   47: pop
    //   48: invokestatic 445	com/baidu/navisdk/util/worker/BNWorkerCenter:getInstance	()Lcom/baidu/navisdk/util/worker/IBNWorkerCenter;
    //   51: new 28	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$2
    //   54: dup
    //   55: aload_0
    //   56: new 447	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 1197
    //   66: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 458	java/lang/Object:getClass	()Ljava/lang/Class;
    //   73: invokevirtual 464	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   76: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 1199
    //   82: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 467	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: aconst_null
    //   89: aload 4
    //   91: aload_3
    //   92: invokespecial 1202	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$2:<init>	(Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;Ljava/lang/String;Ljava/lang/String;[I[I)V
    //   95: new 472	com/baidu/navisdk/util/worker/BNWorkerConfig
    //   98: dup
    //   99: bipush 101
    //   101: iconst_0
    //   102: invokespecial 474	com/baidu/navisdk/util/worker/BNWorkerConfig:<init>	(II)V
    //   105: invokeinterface 1205 3 0
    //   110: aload_0
    //   111: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   114: iload_1
    //   115: invokevirtual 422	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	(I)Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   118: astore_3
    //   119: aload_3
    //   120: ifnull +122 -> 242
    //   123: aload_3
    //   124: iconst_1
    //   125: putfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   128: aload_3
    //   129: iconst_0
    //   130: putfield 602	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mIsNewVer	Z
    //   133: aload_3
    //   134: iconst_0
    //   135: putfield 653	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgress	I
    //   138: aload_3
    //   139: iconst_0
    //   140: putfield 427	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProgress	I
    //   143: aload_3
    //   144: iconst_0
    //   145: putfield 659	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgressBy10	I
    //   148: aload_3
    //   149: iconst_0
    //   150: putfield 563	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProgressBy10	I
    //   153: iload_1
    //   154: aload_0
    //   155: getfield 167	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadID	I
    //   158: if_icmpne +20 -> 178
    //   161: aload_0
    //   162: iconst_m1
    //   163: putfield 167	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadID	I
    //   166: aload_3
    //   167: ifnull +11 -> 178
    //   170: aload_0
    //   171: aload_3
    //   172: getfield 558	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mName	Ljava/lang/String;
    //   175: invokespecial 848	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:deleteFinish	(Ljava/lang/String;)V
    //   178: iload_2
    //   179: ifeq +56 -> 235
    //   182: invokestatic 445	com/baidu/navisdk/util/worker/BNWorkerCenter:getInstance	()Lcom/baidu/navisdk/util/worker/IBNWorkerCenter;
    //   185: new 50	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$3
    //   188: dup
    //   189: aload_0
    //   190: new 447	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   197: ldc_w 1207
    //   200: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: invokevirtual 458	java/lang/Object:getClass	()Ljava/lang/Class;
    //   207: invokevirtual 464	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   210: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 467	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: aconst_null
    //   217: invokespecial 1208	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$3:<init>	(Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;Ljava/lang/String;Ljava/lang/String;)V
    //   220: new 472	com/baidu/navisdk/util/worker/BNWorkerConfig
    //   223: dup
    //   224: bipush 101
    //   226: iconst_0
    //   227: invokespecial 474	com/baidu/navisdk/util/worker/BNWorkerConfig:<init>	(II)V
    //   230: invokeinterface 781 3 0
    //   235: aload_0
    //   236: invokespecial 402	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:updateUI	()V
    //   239: aload_0
    //   240: monitorexit
    //   241: return
    //   242: aload_0
    //   243: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   246: iload_1
    //   247: invokevirtual 586	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	(I)Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   250: astore 4
    //   252: aload 4
    //   254: astore_3
    //   255: aload 4
    //   257: ifnull -104 -> 153
    //   260: aload 4
    //   262: iconst_1
    //   263: putfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   266: aload 4
    //   268: iconst_0
    //   269: putfield 602	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mIsNewVer	Z
    //   272: aload 4
    //   274: iconst_0
    //   275: putfield 653	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgress	I
    //   278: aload 4
    //   280: iconst_0
    //   281: putfield 427	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProgress	I
    //   284: aload 4
    //   286: iconst_0
    //   287: putfield 659	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mUpProgressBy10	I
    //   290: aload 4
    //   292: iconst_0
    //   293: putfield 563	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProgressBy10	I
    //   296: aload 4
    //   298: astore_3
    //   299: aload_0
    //   300: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   303: ifnull -150 -> 153
    //   306: aload 4
    //   308: astore_3
    //   309: aload_0
    //   310: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   313: invokevirtual 605	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	()Ljava/util/ArrayList;
    //   316: ifnull -163 -> 153
    //   319: aload_0
    //   320: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   323: iload_1
    //   324: invokevirtual 1211	com/baidu/navisdk/model/modelfactory/OfflineDataModel:removeDataInDownloaded	(I)V
    //   327: aload_0
    //   328: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   331: aload 4
    //   333: invokevirtual 1214	com/baidu/navisdk/model/modelfactory/OfflineDataModel:addDataInUnDownload	(Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;)V
    //   336: aload_0
    //   337: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   340: invokevirtual 605	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getUndowloadInfo	()Ljava/util/ArrayList;
    //   343: new 74	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$ComparatorUtil
    //   346: dup
    //   347: aload_0
    //   348: invokespecial 1115	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager$ComparatorUtil:<init>	(Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;)V
    //   351: invokestatic 1121	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   354: aload 4
    //   356: astore_3
    //   357: goto -204 -> 153
    //   360: astore_3
    //   361: aload_0
    //   362: monitorexit
    //   363: aload_3
    //   364: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	BNOfflineDataManager
    //   0	365	1	paramInt	int
    //   17	162	2	bool	boolean
    //   6	351	3	localObject1	Object
    //   360	4	3	localObject2	Object
    //   10	345	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	119	360	finally
    //   123	153	360	finally
    //   153	166	360	finally
    //   170	178	360	finally
    //   182	235	360	finally
    //   235	239	360	finally
    //   242	252	360	finally
    //   260	296	360	finally
    //   299	306	360	finally
    //   309	354	360	finally
  }
  
  public void resetNeedReload()
  {
    this.mNeedReload = false;
    LogUtil.e("OffineData", "resetNeedReload ");
  }
  
  public void sdcardFull()
  {
    synchronized (this.mLock)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("SdcardFull-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNOfflineDataManager.this.notifyObservers(3, 271, null);
          return null;
        }
      }, new BNWorkerConfig(101, 0), 0L);
      return;
    }
  }
  
  public void sendUpdateSucessMsg(int paramInt)
  {
    if (this.mHandler != null)
    {
      Message localMessage = this.mHandler.obtainMessage(4125);
      localMessage.arg1 = paramInt;
      localMessage.arg2 = 100;
      this.mHandler.sendMessage(localMessage);
    }
  }
  
  public void setImportNaviMapDataListener(ImportNaviMapDataListener paramImportNaviMapDataListener)
  {
    this.mImportListener = paramImportNaviMapDataListener;
  }
  
  public void setIsClickDownloadOnMobile(Boolean paramBoolean)
  {
    this.isClickDownloadOnMobile = paramBoolean;
  }
  
  public void setNeedReload(boolean paramBoolean)
  {
    this.mNeedReload = paramBoolean;
  }
  
  public void setNeedReloadCfgFile(boolean paramBoolean)
  {
    this.mNeedReloadCfgFile = paramBoolean;
  }
  
  public void startDownBaseMapData(int paramInt)
  {
    BNYellowBannerTipsController.getInstance().setOfflineDataTipsFlag(BNaviModuleManager.getContext(), false);
    if (this.mImportListener != null) {
      this.mImportListener.startDownLoadDataByProvinceId(paramInt);
    }
  }
  
  public void startDownloadRequest(final int paramInt)
  {
    try
    {
      OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getUndowloadInfo(paramInt);
      if (localOfflineDataInfo != null)
      {
        localOfflineDataInfo.mIsRequest = true;
        localOfflineDataInfo.formatStatusTips();
        updateUI();
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            BNOfflineDataManager.this.mOfflineDataControl.downloadDataRequest(paramInt);
            return null;
          }
        }, new BNWorkerConfig(101, 0));
      }
      return;
    }
    finally {}
  }
  
  public void statistics(int paramInt1, int paramInt2)
  {
    String str1 = "0";
    String str3 = "1";
    if (BNaviModuleManager.getContext() == null) {
      str1 = "1";
    }
    if (NetworkUtils.isTypeNetworkAvailable(BNaviModuleManager.getContext(), 1)) {
      str1 = "1";
    }
    if ((paramInt2 == 0) || (1 == paramInt2)) {}
    String str2;
    for (LinkedList localLinkedList = this.userOperStartList;; localLinkedList = this.userOperUpdateList)
    {
      if (paramInt2 != 0)
      {
        str2 = str3;
        if (2 != paramInt2) {}
      }
      else
      {
        str2 = str3;
        if (localLinkedList != null)
        {
          str2 = str3;
          if (localLinkedList.contains(Integer.valueOf(paramInt1)))
          {
            str2 = "0";
            localLinkedList.remove(Integer.valueOf(paramInt1));
          }
        }
      }
      LogUtil.e("BNOfflineDataManager", "download type:" + paramInt2 + ",iswifi:" + str1 + ",isByClick:" + str2 + "provinceID:" + paramInt1);
      switch (paramInt2)
      {
      default: 
        return;
      }
    }
    UserOPController.getInstance().add("a.1", paramInt1 + "", str1, str2);
    return;
    UserOPController.getInstance().add("a.2", paramInt1 + "", str1, null);
    return;
    UserOPController.getInstance().add("a.3", paramInt1 + "", str1, str2);
    return;
    UserOPController.getInstance().add("a.4", paramInt1 + "", str1, null);
  }
  
  public void suspendBatchDownload()
  {
    for (;;)
    {
      int k;
      int j;
      try
      {
        this.mOfflineDataControl.suspendDownloadData(-1);
        k = 0;
        j = 0;
        int i = k;
        OfflineDataInfo localOfflineDataInfo;
        if (this.mOfflineDataModel != null)
        {
          i = k;
          if (this.mOfflineDataModel.getUndowloadInfo() != null)
          {
            k = 0;
            i = j;
            if (k < this.mOfflineDataModel.getUndowloadInfo().size())
            {
              localOfflineDataInfo = (OfflineDataInfo)this.mOfflineDataModel.getUndowloadInfo().get(k);
              if ((localOfflineDataInfo.mTaskStatus != 2) && (localOfflineDataInfo.mTaskStatus != 3)) {
                break label208;
              }
              localOfflineDataInfo.mTaskStatus = 4;
              j = 1;
              break label208;
            }
          }
        }
        k = i;
        if (this.mOfflineDataModel != null)
        {
          k = i;
          if (this.mOfflineDataModel.getDowloadedInfo() != null)
          {
            j = 0;
            k = i;
            if (j < this.mOfflineDataModel.getDowloadedInfo().size())
            {
              localOfflineDataInfo = (OfflineDataInfo)this.mOfflineDataModel.getDowloadedInfo().get(j);
              if ((localOfflineDataInfo.mTaskStatus != 12) && (localOfflineDataInfo.mTaskStatus != 11)) {
                break label215;
              }
              localOfflineDataInfo.mTaskStatus = 13;
              i = 1;
              break label215;
            }
          }
        }
        updateUI();
        if (k != 0) {
          suspendAll();
        }
        return;
      }
      finally {}
      label208:
      k += 1;
      continue;
      label215:
      j += 1;
    }
  }
  
  public void suspendDownloadProvinceData(int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      suspendBatchDownload();
      return;
    }
    finally {}
    this.mOfflineDataControl.suspendDownloadData(paramInt);
    OfflineDataInfo localOfflineDataInfo1 = this.mOfflineDataModel.getUndowloadInfo(paramInt);
    if (localOfflineDataInfo1 != null) {}
    OfflineDataInfo localOfflineDataInfo2;
    for (localOfflineDataInfo1.mTaskStatus = 4;; localOfflineDataInfo2.mTaskStatus = 4)
    {
      updateUI();
      downloadSuspend(localOfflineDataInfo1.mName, localOfflineDataInfo1.mProgress);
      break;
      localOfflineDataInfo2 = this.mOfflineDataModel.getDowloadedInfo(paramInt);
    }
  }
  
  public void suspendUpdateProvinceData(int paramInt)
  {
    try
    {
      this.mOfflineDataControl.suspendDownloadData(paramInt);
      OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getDowloadedInfo(paramInt);
      if (localOfflineDataInfo != null)
      {
        localOfflineDataInfo.mTaskStatus = 13;
        updateSuspend(localOfflineDataInfo.mName, localOfflineDataInfo.mUpProgress);
      }
      updateUI();
      return;
    }
    finally {}
  }
  
  public void unregisterAllReceivers(Activity paramActivity)
  {
    if (this.mHandler != null) {
      VMsgDispatcher.unregisterMsgHandler(this.mHandler);
    }
    if ((paramActivity != null) && (this.mSdcardListener != null)) {}
    try
    {
      paramActivity.unregisterReceiver(this.mSdcardListener);
      this.mSdcardListener = null;
      PhoneStatusReceiver.unRegisterMessageHandler(this.mHandler);
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;) {}
    }
  }
  
  public boolean updateCountryInfoFromCfg()
  {
    return this.mOfflineDataControl.UpdateCountryInfoFromCfg();
  }
  
  public void updateMapDataStutas() {}
  
  public void updateProvinceData(int paramInt)
  {
    try
    {
      this.mOfflineDataControl.updateData(paramInt);
      OfflineDataInfo localOfflineDataInfo = this.mOfflineDataModel.getDowloadedInfo(paramInt);
      if (localOfflineDataInfo != null) {
        localOfflineDataInfo.mTaskStatus = 11;
      }
      updateUI();
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean updateUpdateFinish(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 92
    //   6: ldc_w 1305
    //   9: invokestatic 227	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 163	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mOfflineDataModel	Lcom/baidu/navisdk/model/modelfactory/OfflineDataModel;
    //   16: iload_1
    //   17: invokevirtual 586	com/baidu/navisdk/model/modelfactory/OfflineDataModel:getDowloadedInfo	(I)Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   20: astore 4
    //   22: aload 4
    //   24: ifnull +33 -> 57
    //   27: aload 4
    //   29: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   32: bipush 12
    //   34: if_icmpeq +63 -> 97
    //   37: aload 4
    //   39: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   42: bipush 11
    //   44: if_icmpeq +53 -> 97
    //   47: aload 4
    //   49: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   52: bipush 16
    //   54: if_icmpeq +43 -> 97
    //   57: aload 4
    //   59: ifnull +32 -> 91
    //   62: ldc 92
    //   64: new 447	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 1307
    //   74: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 4
    //   79: getfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   82: invokevirtual 650	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 467	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 227	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: iconst_0
    //   92: istore_3
    //   93: aload_0
    //   94: monitorexit
    //   95: iload_3
    //   96: ireturn
    //   97: aload 4
    //   99: iconst_5
    //   100: putfield 539	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mTaskStatus	I
    //   103: aload 4
    //   105: iconst_0
    //   106: putfield 602	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mIsNewVer	Z
    //   109: new 819	com/baidu/navisdk/model/datastruct/OfflineUpdateInfo
    //   112: dup
    //   113: invokespecial 1308	com/baidu/navisdk/model/datastruct/OfflineUpdateInfo:<init>	()V
    //   116: astore 5
    //   118: aload_0
    //   119: iload_1
    //   120: aload 5
    //   122: invokevirtual 1310	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:GetUpdatedInfo	(ILcom/baidu/navisdk/model/datastruct/OfflineUpdateInfo;)Z
    //   125: pop
    //   126: new 1312	java/text/SimpleDateFormat
    //   129: dup
    //   130: ldc_w 1314
    //   133: invokespecial 1316	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   136: new 1318	java/util/Date
    //   139: dup
    //   140: invokespecial 1319	java/util/Date:<init>	()V
    //   143: invokevirtual 1323	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   146: astore 6
    //   148: new 447	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   155: aload 6
    //   157: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 1325
    //   163: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 4
    //   168: getfield 558	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mName	Ljava/lang/String;
    //   171: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 1325
    //   177: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: getfield 827	com/baidu/navisdk/model/datastruct/OfflineUpdateInfo:mRouteUpCount	I
    //   185: invokestatic 1329	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   188: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 1325
    //   194: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 5
    //   199: getfield 822	com/baidu/navisdk/model/datastruct/OfflineUpdateInfo:mPOIUpCount	I
    //   202: invokestatic 1329	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   205: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 467	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 1334	com/baidu/navisdk/util/common/FileUtils:writeDataUpdateLogToFile	(Ljava/lang/String;)V
    //   214: aload 5
    //   216: aload 6
    //   218: putfield 1337	com/baidu/navisdk/model/datastruct/OfflineUpdateInfo:mUpdateDate	Ljava/lang/String;
    //   221: aload_0
    //   222: aload 4
    //   224: getfield 558	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mName	Ljava/lang/String;
    //   227: aload 5
    //   229: invokespecial 1339	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:updateFinshed	(Ljava/lang/String;Lcom/baidu/navisdk/model/datastruct/OfflineUpdateInfo;)V
    //   232: aload_0
    //   233: aconst_null
    //   234: putfield 165	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mCurDownloadingProvince	Lcom/baidu/navisdk/model/datastruct/OfflineDataInfo;
    //   237: aload_0
    //   238: iconst_1
    //   239: putfield 169	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:mNeedReload	Z
    //   242: ldc 92
    //   244: ldc_w 1341
    //   247: invokestatic 227	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: goto -157 -> 93
    //   253: astore 4
    //   255: aload_0
    //   256: monitorexit
    //   257: aload 4
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	BNOfflineDataManager
    //   0	260	1	paramInt1	int
    //   0	260	2	paramInt2	int
    //   1	95	3	bool	boolean
    //   20	203	4	localOfflineDataInfo	OfflineDataInfo
    //   253	5	4	localObject	Object
    //   116	112	5	localOfflineUpdateInfo	OfflineUpdateInfo
    //   146	71	6	str	String
    // Exception table:
    //   from	to	target	type
    //   4	22	253	finally
    //   27	57	253	finally
    //   62	91	253	finally
    //   97	250	253	finally
  }
  
  public class ComparatorUtil
    implements Comparator<OfflineDataInfo>
  {
    public ComparatorUtil() {}
    
    public int compare(OfflineDataInfo paramOfflineDataInfo1, OfflineDataInfo paramOfflineDataInfo2)
    {
      if (paramOfflineDataInfo1.mProvinceId >= paramOfflineDataInfo2.mProvinceId) {
        return 1;
      }
      return -1;
    }
  }
  
  public static abstract interface DOWNLOAD_STATISTICS_PARAMS
  {
    public static final int TYPE_DOWNLOAD_FINISH = 1;
    public static final int TYPE_UPDATE_FINISH = 3;
    public static final int TYPE_UPDATE_START = 2;
    public static final int YTPE_DOWNLOAD_START = 0;
  }
  
  public static abstract interface ImportNaviMapDataListener
  {
    public abstract boolean checkDataExitByProvinceId(int paramInt);
    
    public abstract void onImportNaviMapData();
    
    public abstract void startDownLoadDataByProvinceId(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */