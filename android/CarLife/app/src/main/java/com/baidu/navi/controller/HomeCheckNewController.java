package com.baidu.navi.controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.view.dialog.m;
import com.baidu.carlife.view.dialog.m.a;
import com.baidu.carlife.view.dialog.o;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.utils.Tools;
import com.baidu.navi.view.DownNotifManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver.DownloadArg;
import com.baidu.navisdk.model.datastruct.ApkInfo;
import com.baidu.navisdk.model.datastruct.CheckNewInfo;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.util.ArrayList;
import java.util.HashMap;

public class HomeCheckNewController
{
  public static final int MSG_CHECK_DATA_INCONSIST = -6;
  public static final int MSG_CHECK_NAVI_DATA = -4;
  public static final int MSG_CHECK_NEW_APK_VER = -5;
  public static final int MSG_CHECK_NEW_DATA_VER = -7;
  private ApkInfo mApkInfoModel;
  private String mApkSizeString;
  private boolean mAutoUpdate;
  private CheckNewAppThread mCheckNewAppThread = null;
  private boolean mCheckNewData;
  private Handler mCheckNewHandler = null;
  private CheckNewListener mCheckNewListener = null;
  private Context mContext = null;
  private boolean mDoUpdating = false;
  private m mDownloadDialog;
  private TextView mDownloadText;
  private boolean mIsNewApkVer = false;
  private boolean mIsNewData = false;
  private ArrayList<OfflineDataInfo> mNeedUpdateList = new ArrayList();
  private BNOfflineDataObserver mOfflineDataObserver = new BNOfflineDataObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      switch (paramAnonymousInt1)
      {
      }
      for (;;)
      {
        label24:
        return;
        paramAnonymousBNSubject = (BNOfflineDataObserver.DownloadArg)paramAnonymousObject;
        if (paramAnonymousBNSubject == null) {}
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousBNSubject.mProgress) {
          switch (paramAnonymousInt2)
          {
          case 268: 
          case 269: 
          case 270: 
          case 271: 
          default: 
            return;
          case 267: 
            paramAnonymousBNSubject = (BNOfflineDataObserver.DownloadArg)paramAnonymousObject;
            paramAnonymousObject = paramAnonymousBNSubject.mName;
            paramAnonymousInt1 = paramAnonymousBNSubject.mUpdatePoiCount;
            paramAnonymousInt2 = paramAnonymousBNSubject.mUpdateRouteCount;
            if ((paramAnonymousInt1 <= 0) || (paramAnonymousInt2 <= 0)) {
              break label480;
            }
            paramAnonymousBNSubject = HomeCheckNewController.this.mContext.getString(2131297185, new Object[] { paramAnonymousObject, Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
            label151:
            DownNotifManager.getInstance(HomeCheckNewController.this.mContext).clearAllNotifs();
            DownNotifManager.getInstance(HomeCheckNewController.this.mContext).showUpdateFinshedNotif(HomeCheckNewController.this.mContext, paramAnonymousBNSubject);
            LogUtil.e("Update", "update finished name:" + (String)paramAnonymousObject + "!!!!!!!!!!!");
            if (HomeCheckNewController.this.mNeedUpdateList == null) {
              break label24;
            }
            paramAnonymousInt1 = 0;
            while (paramAnonymousInt1 < HomeCheckNewController.this.mNeedUpdateList.size())
            {
              if (((OfflineDataInfo)HomeCheckNewController.this.mNeedUpdateList.get(paramAnonymousInt1)).mName.endsWith((String)paramAnonymousObject)) {
                HomeCheckNewController.this.mNeedUpdateList.remove(paramAnonymousInt1);
              }
              paramAnonymousInt1 += 1;
            }
          }
        }
        if (HomeCheckNewController.this.mProgressBar != null) {
          HomeCheckNewController.this.mProgressBar.setProgress(paramAnonymousInt1);
        }
        if (HomeCheckNewController.this.mPersentText != null) {
          HomeCheckNewController.this.mPersentText.setText("" + paramAnonymousInt1 + "%");
        }
        if ((HomeCheckNewController.this.mDownloadText == null) || (HomeCheckNewController.this.mApkInfoModel == null)) {
          continue;
        }
        paramAnonymousInt2 = paramAnonymousInt1;
        if (paramAnonymousInt1 > 100) {
          paramAnonymousInt2 = 100;
        }
        paramAnonymousBNSubject = StringUtils.ByteSizeToString(HomeCheckNewController.this.mApkInfoModel.mApkSize * paramAnonymousInt2 / 100);
        paramAnonymousBNSubject = paramAnonymousBNSubject + "/" + HomeCheckNewController.this.mApkSizeString;
        HomeCheckNewController.this.mDownloadText.setText(paramAnonymousBNSubject);
        return;
        try
        {
          if (HomeCheckNewController.this.mOnDialogListener != null) {
            HomeCheckNewController.this.mOnDialogListener.dismissDialog();
          }
          HomeCheckNewController.this.installApk();
          return;
          label480:
          if ((paramAnonymousInt1 <= 0) && (paramAnonymousInt2 > 0))
          {
            paramAnonymousBNSubject = HomeCheckNewController.this.mContext.getString(2131297188, new Object[] { paramAnonymousObject, Integer.valueOf(paramAnonymousInt2) });
            break label151;
          }
          if ((paramAnonymousInt1 > 0) && (paramAnonymousInt2 <= 0))
          {
            paramAnonymousBNSubject = HomeCheckNewController.this.mContext.getString(2131297187, new Object[] { paramAnonymousObject, Integer.valueOf(paramAnonymousInt1) });
            break label151;
          }
          paramAnonymousBNSubject = HomeCheckNewController.this.mContext.getString(2131297186, new Object[] { paramAnonymousObject });
          break label151;
          if (HomeCheckNewController.this.mNeedUpdateList.size() != 0) {
            continue;
          }
          LogUtil.e("Update", "update finished in check new home!!!!!!!!!!!");
          HomeCheckNewController.access$1702(HomeCheckNewController.this, false);
          HomeCheckNewController.access$402(HomeCheckNewController.this, false);
          UIModel.getInstance().setIsAutoUpdateDataStatus(false);
          UIModel.getInstance().setNewData(false);
          if (HomeCheckNewController.this.mCheckNewListener == null) {
            continue;
          }
          LogUtil.e("Update", "update finished listner called!!!!!!!!!!!");
          HomeCheckNewController.this.mCheckNewListener.finishUpdateNewData();
          return;
          switch (paramAnonymousInt2)
          {
          default: 
            return;
          }
          if (HomeCheckNewController.this.mPersentText != null) {
            HomeCheckNewController.this.mPersentText.setText("");
          }
          if (HomeCheckNewController.this.mDownloadText == null) {
            continue;
          }
          HomeCheckNewController.this.mDownloadText.setText(HomeCheckNewController.this.mContext.getString(2131296448));
          return;
        }
        catch (Exception paramAnonymousBNSubject)
        {
          for (;;) {}
        }
      }
    }
  };
  private e mOnDialogListener;
  private TextView mPersentText;
  private ProgressBar mProgressBar;
  protected HashMap<String, String> mResponseMap = new HashMap();
  private int mUpdateCount;
  private int[] mUpdateDistrictID = new int[36];
  
  public HomeCheckNewController(Context paramContext, e parame)
  {
    this.mContext = paramContext;
    this.mOnDialogListener = parame;
  }
  
  private Handler getMainUiHandler()
  {
    new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        case -6: 
        case -5: 
        default: 
          return;
        }
        HomeCheckNewController.access$202(HomeCheckNewController.this, false);
      }
    };
  }
  
  private void installApk()
  {
    String str = SysOSAPI.getInstance().GetSDCardPath() + "/BaiduNavi.apk";
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + str), "application/vnd.android.package-archive");
    this.mContext.startActivity(localIntent);
  }
  
  private void showApkUpdateInfoDialog()
  {
    boolean bool = PreferenceHelper.getInstance(this.mContext).getBoolean("NAVI_UPDATE_APK_NOT_ALERT", false);
    Object localObject = PreferenceHelper.getInstance(this.mContext).getString("NAVI_UPDATE_APK_VERSION", "0.0.0");
    if ((this.mApkInfoModel == null) || ((bool) && (this.mApkInfoModel.mApkVer.equals(localObject)))) {
      return;
    }
    this.mApkSizeString = StringUtils.ByteSizeToString(this.mApkInfoModel.mApkSize);
    String str = this.mContext.getString(2131297146) + this.mApkSizeString + ".\r\n" + this.mContext.getString(2131297147) + this.mApkInfoModel.mApkVer + ".\r\n" + this.mApkInfoModel.mInfo;
    if (NaviFragmentManager.isUsingMapMode()) {}
    for (localObject = View.inflate(this.mContext, 2130968943, null);; localObject = View.inflate(this.mContext, 2130968677, null))
    {
      CheckBox localCheckBox = (CheckBox)((View)localObject).findViewById(2131624557);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131624556);
      localCheckBox.setChecked(bool);
      localTextView.setText(str);
      localTextView.setTextSize(18.0F);
      localTextView.setMovementMethod(new ScrollingMovementMethod());
      localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).putBoolean("NAVI_UPDATE_APK_NOT_ALERT", true);
            PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).putString("NAVI_UPDATE_APK_VERSION", HomeCheckNewController.this.mApkInfoModel.mApkVer);
            return;
          }
          PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).putBoolean("NAVI_UPDATE_APK_NOT_ALERT", false);
        }
      });
      localObject = new o(this.mContext).i(2131296295).c((View)localObject).j(2131296259).k(2131296294).m().c(new m.a()
      {
        public void onClick() {}
      }).d(new m.a()
      {
        public void onClick()
        {
          if (NetworkUtils.isNetworkAvailable(HomeCheckNewController.this.mContext))
          {
            if (PackageUtil.isChannelGooglePlay())
            {
              Tools.goMarket();
              return;
            }
            HomeCheckNewController.this.showDownloadAppDialog();
            return;
          }
          TipTool.onCreateToastDialog(HomeCheckNewController.this.mContext, 2131296293);
        }
      });
      this.mOnDialogListener.showDialog((BaseDialog)localObject, BaseDialog.a.a);
      return;
    }
  }
  
  private void showDownloadAppDialog()
  {
    if (this.mDownloadDialog == null)
    {
      View localView = LayoutInflater.from(this.mContext).inflate(2130969020, null);
      this.mProgressBar = ((ProgressBar)localView.findViewById(2131626083));
      this.mDownloadText = ((TextView)localView.findViewById(2131626081));
      this.mPersentText = ((TextView)localView.findViewById(2131626082));
      localView.setBackgroundColor(StyleManager.getColor(2131558509));
      this.mDownloadText.setTextColor(StyleManager.getColor(2131558511));
      this.mPersentText.setTextColor(StyleManager.getColor(2131558511));
      this.mDownloadDialog = new m(this.mContext).a(2131296273).a(localView).b(2131296259).a(new m.a()
      {
        public void onClick()
        {
          BNOfflineDataManager.getInstance().pauseAppDataDownLoad();
          BNOfflineDataManager.getInstance().removeAppData();
        }
      });
    }
    this.mOnDialogListener.showDialog(this.mDownloadDialog, BaseDialog.a.a);
    BNOfflineDataManager.getInstance().pauseAppDataDownLoad();
    BNOfflineDataManager.getInstance().removeAppData();
    BNOfflineDataManager.getInstance().downLoadAppData();
  }
  
  public void setCheckNewListener(CheckNewListener paramCheckNewListener)
  {
    this.mCheckNewListener = paramCheckNewListener;
  }
  
  public void startCheckNewThread()
  {
    if (this.mCheckNewAppThread == null)
    {
      this.mCheckNewHandler = getMainUiHandler();
      this.mCheckNewAppThread = new CheckNewAppThread(this.mCheckNewHandler);
    }
    if ((this.mCheckNewAppThread != null) && (!this.mCheckNewAppThread.isAlive())) {
      this.mCheckNewAppThread.start();
    }
  }
  
  class CheckNewAppThread
    extends Thread
  {
    Handler mThreadHandler;
    
    CheckNewAppThread(Handler paramHandler)
    {
      this.mThreadHandler = paramHandler;
    }
    
    public void run()
    {
      HomeCheckNewController.access$002(HomeCheckNewController.this, PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).getBoolean("NAVI_AUTO_CHECK_NEW_DATA", true));
      HomeCheckNewController.access$202(HomeCheckNewController.this, PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).getBoolean("NAVI_AUTO_UPDATE_NEW_DATA", false));
      HomeCheckNewController.access$302(HomeCheckNewController.this, false);
      HomeCheckNewController.access$402(HomeCheckNewController.this, false);
      HomeCheckNewController.access$502(HomeCheckNewController.this, new ApkInfo());
      Object localObject = new CheckNewInfo();
      if (NetworkUtils.isNetworkAvailable(HomeCheckNewController.this.mContext)) {}
      for (;;)
      {
        boolean bool;
        try
        {
          BNOfflineDataManager.getInstance().checkNewVer((CheckNewInfo)localObject, HomeCheckNewController.this.mApkInfoModel, HomeCheckNewController.this.mUpdateDistrictID, HomeCheckNewController.this.mCheckNewData);
          HomeCheckNewController.access$302(HomeCheckNewController.this, ((CheckNewInfo)localObject).mNewApp);
          HomeCheckNewController.access$402(HomeCheckNewController.this, ((CheckNewInfo)localObject).mNewData);
          HomeCheckNewController.access$702(HomeCheckNewController.this, ((CheckNewInfo)localObject).mCount);
          if ((HomeCheckNewController.this.mIsNewApkVer) || (HomeCheckNewController.this.mIsNewData)) {
            BNOfflineDataManager.getInstance().addObserver(HomeCheckNewController.this.mOfflineDataObserver);
          }
          if (HomeCheckNewController.this.mIsNewApkVer) {
            Message.obtain(this.mThreadHandler, -5, 0, 0, null).sendToTarget();
          }
          localObject = new ArrayList();
          BNOfflineDataManager.getInstance().getNeedUpdateInfo((ArrayList)localObject);
          if (((ArrayList)localObject).size() > 0) {
            HomeCheckNewController.access$402(HomeCheckNewController.this, true);
          }
          localObject = HomeCheckNewController.this;
          if (HomeCheckNewController.this.mCheckNewData != true) {
            break label413;
          }
          bool = HomeCheckNewController.this.mIsNewData;
          HomeCheckNewController.access$402((HomeCheckNewController)localObject, bool);
          if (HomeCheckNewController.this.mIsNewData)
          {
            UIModel.getInstance().setNewData(true);
            if (HomeCheckNewController.this.mCheckNewListener != null) {
              HomeCheckNewController.this.mCheckNewListener.newData();
            }
            Message.obtain(this.mThreadHandler, -7, 0, 0, null).sendToTarget();
          }
          return;
        }
        catch (Exception localException)
        {
          return;
        }
        ArrayList localArrayList = new ArrayList();
        BNOfflineDataManager.getInstance().getItemTable(3, localArrayList);
        if (localArrayList.size() > 0) {
          HomeCheckNewController.access$402(HomeCheckNewController.this, true);
        }
        if ((HomeCheckNewController.this.mIsNewApkVer) || (HomeCheckNewController.this.mIsNewData))
        {
          BNOfflineDataManager.getInstance().addObserver(HomeCheckNewController.this.mOfflineDataObserver);
          continue;
          label413:
          bool = false;
        }
      }
    }
  }
  
  public static abstract interface CheckNewListener
  {
    public abstract void beginUpdateNewData();
    
    public abstract void finishUpdateNewData();
    
    public abstract void newData();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/HomeCheckNewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */