package com.baidu.navisdk.ui.download;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.datastruct.CheckNewInfo;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.download.view.BNDownloadTabView;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.util.ArrayList;

public class BNDownloadUIManager
  extends BNSubject
{
  private static final String PREF_SHOW_NEWER_GUIDE = "download.showNewerGuide";
  private static final String TAG = "!#BNDownloadUIManager";
  public static final int TYPE_GET_CURR_PROVINCE_SUCC = 1;
  private static ArrayList<OfflineDataInfo> mNeedUpdateList = new ArrayList();
  private static CheckNewInfo sCheckNewInfo;
  private static BNDownloadUIManager sInstance;
  private static boolean sIsCheckedNewVersion = false;
  private static int[] sNewVerDistrictIds;
  private Activity mActivity;
  private boolean mIsRecverRegistered = false;
  private AlertDialog mNewerGuideDialog;
  private View mNewerGuideDlgImage;
  private BNDownloadTabView mTabView;
  
  static
  {
    sCheckNewInfo = new CheckNewInfo();
    sNewVerDistrictIds = new int[35];
  }
  
  private BNDownloadUIManager(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    boolean bool = PreferenceHelper.getInstance(this.mActivity).getBoolean("download.showNewerGuide", true);
    LogUtil.e("!#BNDownloadUIManager", "PREF_SHOW_NEWER_GUIDE = " + bool);
    if (bool)
    {
      PreferenceHelper.getInstance(this.mActivity).putBoolean("download.showNewerGuide", false);
      showNewerGuideDialog(null);
    }
    bool = PreferenceHelper.getInstance(this.mActivity).getBoolean("SP_KEY_SHOW_TOAST_FOR_LINKID", false);
    LogUtil.e("!#BNDownloadUIManager", "BNDownloadUIManager: isFirstShow " + bool);
    if (bool)
    {
      PreferenceHelper.getInstance(this.mActivity).putBoolean("SP_KEY_SHOW_TOAST_FOR_LINKID", false);
      TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(1711669843));
    }
  }
  
  private void buildNewerGuideDialog()
  {
    AlertDialog.Builder localBuilder;
    if (this.mNewerGuideDialog == null) {
      localBuilder = new AlertDialog.Builder(this.mActivity);
    }
    try
    {
      View localView1 = JarUtils.inflate(this.mActivity, 1711472671, null);
      if (localView1 == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      View localView2;
      do
      {
        for (;;)
        {
          localView2 = null;
        }
        this.mNewerGuideDlgImage = localView2.findViewById(1711866081);
        View localView3 = localView2.findViewById(1711866082);
        if (localView3 != null) {
          localView3.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              if (BNDownloadUIManager.this.mNewerGuideDialog != null)
              {
                BNDownloadUIManager.this.mNewerGuideDialog.dismiss();
                BNDownloadUIManager.access$402(BNDownloadUIManager.this, null);
                BNDownloadUIManager.access$502(BNDownloadUIManager.this, null);
              }
            }
          });
        }
        this.mNewerGuideDialog = localBuilder.create();
      } while (this.mNewerGuideDialog == null);
      this.mNewerGuideDialog.setView(localView2, 0, 0, 0, 0);
      this.mNewerGuideDialog.setCancelable(false);
    }
  }
  
  public static void checkNewVersion(Activity paramActivity, boolean paramBoolean, final OnNewVersionListener paramOnNewVersionListener)
  {
    if (paramActivity == null)
    {
      LogUtil.e("!#BNDownloadUIManager", "checkNewVersion: null activity!");
      return;
    }
    if (!NetworkUtils.isTypeNetworkAvailable(paramActivity, 1))
    {
      LogUtil.e("!#BNDownloadUIManager", "checkNewVersion: wifi is unavailable");
      return;
    }
    int i = SDCardUtils.getSdcardState();
    if (i != 0)
    {
      LogUtil.e("!#BNDownloadUIManager", "checkNewVersion: storage is unavailable, " + i);
      return;
    }
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-checkNewVersion", null)new BNWorkerConfig
    {
      /* Error */
      protected String execute()
      {
        // Byte code:
        //   0: ldc 7
        //   2: monitorenter
        //   3: invokestatic 31	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$000	()Z
        //   6: ifeq +16 -> 22
        //   9: getstatic 35	com/baidu/navisdk/ui/download/BNDownloadUIManager$1:TAG	Ljava/lang/String;
        //   12: ldc 37
        //   14: invokestatic 43	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   17: ldc 7
        //   19: monitorexit
        //   20: aconst_null
        //   21: areturn
        //   22: iconst_1
        //   23: invokestatic 47	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$002	(Z)Z
        //   26: pop
        //   27: ldc 7
        //   29: monitorexit
        //   30: new 49	com/baidu/navisdk/model/datastruct/ApkInfo
        //   33: dup
        //   34: invokespecial 52	com/baidu/navisdk/model/datastruct/ApkInfo:<init>	()V
        //   37: astore_2
        //   38: invokestatic 58	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:getInstance	()Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;
        //   41: invokestatic 62	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$100	()Lcom/baidu/navisdk/model/datastruct/CheckNewInfo;
        //   44: aload_2
        //   45: invokestatic 66	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$200	()[I
        //   48: iconst_1
        //   49: invokevirtual 70	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:checkNewVer	(Lcom/baidu/navisdk/model/datastruct/CheckNewInfo;Lcom/baidu/navisdk/model/datastruct/ApkInfo;[IZ)Z
        //   52: pop
        //   53: getstatic 35	com/baidu/navisdk/ui/download/BNDownloadUIManager$1:TAG	Ljava/lang/String;
        //   56: new 72	java/lang/StringBuilder
        //   59: dup
        //   60: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   63: ldc 75
        //   65: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   68: invokestatic 62	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$100	()Lcom/baidu/navisdk/model/datastruct/CheckNewInfo;
        //   71: getfield 85	com/baidu/navisdk/model/datastruct/CheckNewInfo:mNewData	Z
        //   74: invokevirtual 88	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
        //   77: ldc 90
        //   79: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   82: invokestatic 62	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$100	()Lcom/baidu/navisdk/model/datastruct/CheckNewInfo;
        //   85: getfield 93	com/baidu/navisdk/model/datastruct/CheckNewInfo:mNewApp	Z
        //   88: invokevirtual 88	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
        //   91: ldc 95
        //   93: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   96: invokestatic 62	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$100	()Lcom/baidu/navisdk/model/datastruct/CheckNewInfo;
        //   99: getfield 99	com/baidu/navisdk/model/datastruct/CheckNewInfo:mCount	I
        //   102: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   105: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   108: invokestatic 43	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   111: invokestatic 62	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$100	()Lcom/baidu/navisdk/model/datastruct/CheckNewInfo;
        //   114: getfield 85	com/baidu/navisdk/model/datastruct/CheckNewInfo:mNewData	Z
        //   117: ifeq +180 -> 297
        //   120: invokestatic 58	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:getInstance	()Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;
        //   123: iconst_0
        //   124: invokevirtual 109	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:isProvinceDataDownload	(I)Z
        //   127: ifeq +170 -> 297
        //   130: invokestatic 114	com/baidu/navisdk/comapi/setting/BNSettingManager:isAutoUpdateNewData	()Z
        //   133: ifeq +164 -> 297
        //   136: new 116	java/util/ArrayList
        //   139: dup
        //   140: invokespecial 117	java/util/ArrayList:<init>	()V
        //   143: astore_2
        //   144: new 116	java/util/ArrayList
        //   147: dup
        //   148: invokespecial 117	java/util/ArrayList:<init>	()V
        //   151: astore_3
        //   152: invokestatic 58	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:getInstance	()Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;
        //   155: iconst_3
        //   156: aload_2
        //   157: invokevirtual 121	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:getItemTable	(ILjava/util/ArrayList;)Z
        //   160: pop
        //   161: invokestatic 58	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:getInstance	()Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;
        //   164: iconst_4
        //   165: aload_3
        //   166: invokevirtual 121	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:getItemTable	(ILjava/util/ArrayList;)Z
        //   169: pop
        //   170: invokestatic 125	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$300	()Ljava/util/ArrayList;
        //   173: aload_2
        //   174: invokevirtual 129	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
        //   177: pop
        //   178: invokestatic 125	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$300	()Ljava/util/ArrayList;
        //   181: aload_3
        //   182: invokevirtual 129	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
        //   185: pop
        //   186: iconst_0
        //   187: istore_1
        //   188: iload_1
        //   189: invokestatic 125	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$300	()Ljava/util/ArrayList;
        //   192: invokevirtual 133	java/util/ArrayList:size	()I
        //   195: if_icmpge +83 -> 278
        //   198: invokestatic 125	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$300	()Ljava/util/ArrayList;
        //   201: iload_1
        //   202: invokevirtual 137	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   205: checkcast 139	com/baidu/navisdk/model/datastruct/OfflineDataInfo
        //   208: astore_2
        //   209: invokestatic 58	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:getInstance	()Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;
        //   212: aload_2
        //   213: getfield 142	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
        //   216: invokevirtual 146	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:updateProvinceData	(I)V
        //   219: ldc -108
        //   221: new 72	java/lang/StringBuilder
        //   224: dup
        //   225: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   228: ldc -106
        //   230: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   233: aload_2
        //   234: getfield 142	com/baidu/navisdk/model/datastruct/OfflineDataInfo:mProvinceId	I
        //   237: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   240: ldc -104
        //   242: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   245: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   248: invokestatic 43	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   251: ldc2_w 153
        //   254: invokestatic 160	java/lang/Thread:sleep	(J)V
        //   257: iload_1
        //   258: iconst_1
        //   259: iadd
        //   260: istore_1
        //   261: goto -73 -> 188
        //   264: astore_2
        //   265: ldc 7
        //   267: monitorexit
        //   268: aload_2
        //   269: athrow
        //   270: astore_2
        //   271: aload_2
        //   272: invokevirtual 163	java/lang/Exception:printStackTrace	()V
        //   275: goto -18 -> 257
        //   278: aload_0
        //   279: getfield 16	com/baidu/navisdk/ui/download/BNDownloadUIManager$1:val$listener	Lcom/baidu/navisdk/ui/download/BNDownloadUIManager$OnNewVersionListener;
        //   282: ifnull +15 -> 297
        //   285: aload_0
        //   286: getfield 16	com/baidu/navisdk/ui/download/BNDownloadUIManager$1:val$listener	Lcom/baidu/navisdk/ui/download/BNDownloadUIManager$OnNewVersionListener;
        //   289: invokestatic 66	com/baidu/navisdk/ui/download/BNDownloadUIManager:access$200	()[I
        //   292: invokeinterface 169 2 0
        //   297: aconst_null
        //   298: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	299	0	this	1
        //   187	74	1	i	int
        //   37	197	2	localObject1	Object
        //   264	5	2	localObject2	Object
        //   270	2	2	localException	Exception
        //   151	31	3	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   3	20	264	finally
        //   22	30	264	finally
        //   265	268	264	finally
        //   251	257	270	java/lang/Exception
      }
    }, new BNWorkerConfig(101, 0));
  }
  
  public static BNDownloadUIManager getInstance(Activity paramActivity)
  {
    try
    {
      if ((sInstance == null) && (paramActivity != null)) {
        sInstance = new BNDownloadUIManager(paramActivity);
      }
      paramActivity = sInstance;
      return paramActivity;
    }
    finally {}
  }
  
  public static void onActivityDestroy()
  {
    try
    {
      LogUtil.e("!#BNDownloadUIManager", "~~~~~~~~~~ onActivityDestroy ~~~~~~~~~");
      if (sInstance != null) {
        sInstance = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void pauseAllDownload()
  {
    try
    {
      if (sInstance != null) {
        BNOfflineDataManager.getInstance().suspendBatchDownload();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void registerOfflineDataManagerReceiver()
  {
    LogUtil.e("!#BNDownloadUIManager", "registerOfflineDataManagerReceiver: " + this.mIsRecverRegistered);
    if (!this.mIsRecverRegistered)
    {
      this.mIsRecverRegistered = true;
      BNOfflineDataManager.getInstance().initSDCardListener(this.mActivity);
    }
  }
  
  private void showNewerGuideDialog(Configuration paramConfiguration)
  {
    buildNewerGuideDialog();
    int i;
    if (paramConfiguration != null)
    {
      i = paramConfiguration.orientation;
      if (this.mNewerGuideDlgImage != null)
      {
        if (i != 1) {
          break label79;
        }
        this.mNewerGuideDlgImage.setVisibility(0);
      }
    }
    for (;;)
    {
      if ((paramConfiguration == null) && (this.mNewerGuideDialog != null) && (!this.mActivity.isFinishing())) {}
      try
      {
        this.mNewerGuideDialog.show();
        return;
      }
      catch (Throwable paramConfiguration) {}
      i = this.mActivity.getResources().getConfiguration().orientation;
      break;
      label79:
      this.mNewerGuideDlgImage.setVisibility(8);
    }
  }
  
  private void unregisterOfflineDataManagerReceiver()
  {
    LogUtil.e("!#BNDownloadUIManager", "unregisterOfflineDataManagerReceiver: " + this.mIsRecverRegistered);
    if (this.mIsRecverRegistered)
    {
      this.mIsRecverRegistered = false;
      BNOfflineDataManager.getInstance().UnInitSDCardListener(this.mActivity);
    }
  }
  
  public View createView(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      this.mActivity = paramActivity;
      if (this.mTabView == null)
      {
        this.mTabView = new BNDownloadTabView(this.mActivity);
        registerOfflineDataManagerReceiver();
      }
      return this.mTabView.getRootView();
    }
    return null;
  }
  
  public void destroyView()
  {
    if (this.mTabView != null)
    {
      this.mTabView.destroy();
      View localView = this.mTabView.getRootView();
      if (localView != null)
      {
        ViewParent localViewParent = localView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)localViewParent).removeView(localView);
        }
      }
      unregisterOfflineDataManagerReceiver();
      this.mTabView = null;
    }
    this.mActivity = null;
  }
  
  public View getView()
  {
    if (this.mTabView != null) {
      return this.mTabView.getRootView();
    }
    return null;
  }
  
  public boolean isViewCreated()
  {
    return this.mTabView != null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    LogUtil.e("!#BNDownloadUIManager", "onConfigurationChanged: orientation" + paramConfiguration.orientation);
    if ((this.mNewerGuideDialog != null) && (this.mNewerGuideDialog.isShowing())) {
      showNewerGuideDialog(paramConfiguration);
    }
  }
  
  public void remmoveParentView()
  {
    if (this.mTabView != null)
    {
      View localView = this.mTabView.getRootView();
      if (localView != null)
      {
        ViewParent localViewParent = localView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)localViewParent).removeView(localView);
        }
      }
    }
  }
  
  public void setBackBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mTabView != null) {
      this.mTabView.setBackBtnOnClickListener(paramOnClickListener);
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    if (this.mTabView != null) {
      this.mTabView.updateStyle(paramBoolean);
    }
  }
  
  public static abstract interface OnNewVersionListener
  {
    public abstract void onNewVersion(int[] paramArrayOfInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/download/BNDownloadUIManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */