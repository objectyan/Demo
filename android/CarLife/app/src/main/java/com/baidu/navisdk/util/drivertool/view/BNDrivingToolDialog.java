package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.drivertool.BNDrivingToolUtils;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import com.baidu.navisdk.util.drivertool.BNTakePhotoManager;
import com.baidu.navisdk.util.drivertool.BNVideoRecordManager;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class BNDrivingToolDialog
  extends Dialog
{
  public static final int UPDATE_ROUTE_MSG = 100;
  private String[] mDrivingTestNames = null;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage.what == 100) && (BNDrivingToolDialog.this.mRouteSp != null))
      {
        if (BNDrivingToolManager.getInstance().isSinglePerson) {
          BNDrivingToolDialog.this.mRouteSp.setText(BNStyleManager.getString(1711670295));
        }
      }
      else {
        return;
      }
      BNDrivingToolDialog.this.mRouteSp.setVisibility(0);
      paramAnonymousMessage = BNDrivingToolManager.getInstance().mRouteName;
      BNDrivingToolDialog.this.mRouteSp.setText(paramAnonymousMessage);
    }
  };
  private Button mIssueListBtn;
  private Button mNewIssueBtn;
  private TextView mRouteSp;
  private Button mScreenShotBtn;
  private Button mSettingBtn;
  private Button mShortVideoBtn;
  private Button mTakePhotoBtn;
  
  public BNDrivingToolDialog(Context paramContext)
  {
    super(paramContext);
    Object localObject = JarUtils.getResources().newTheme();
    ((Resources.Theme)localObject).applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    paramContext = JarUtils.inflate((Activity)paramContext, 1711472672, null);
    setContentView(paramContext);
    this.mRouteSp = ((TextView)paramContext.findViewById(1711866083));
    this.mTakePhotoBtn = ((Button)paramContext.findViewById(1711866085));
    this.mScreenShotBtn = ((Button)paramContext.findViewById(1711866086));
    this.mShortVideoBtn = ((Button)paramContext.findViewById(1711866088));
    this.mSettingBtn = ((Button)paramContext.findViewById(1711866089));
    this.mNewIssueBtn = ((Button)paramContext.findViewById(1711866090));
    this.mIssueListBtn = ((Button)paramContext.findViewById(1711866091));
    if (this.mIssueListBtn != null)
    {
      paramContext = this.mIssueListBtn;
      if (!BNaviModuleManager.isGooglePlayChannel()) {
        break label234;
      }
    }
    label234:
    for (int i = 8;; i = 0)
    {
      paramContext.setVisibility(i);
      paramContext = getWindow();
      localObject = paramContext.getAttributes();
      ((WindowManager.LayoutParams)localObject).width = (ScreenUtil.getInstance().getWidthPixels() / 8 * 5);
      ((WindowManager.LayoutParams)localObject).height = (ScreenUtil.getInstance().getHeightPixels() / 9 * 4);
      paramContext.setAttributes((WindowManager.LayoutParams)localObject);
      paramContext.setGravity(17);
      initData();
      initListener();
      return;
    }
  }
  
  private void initData()
  {
    pullDrivingTestNames();
    this.mHandler.sendEmptyMessage(100);
  }
  
  private void initListener()
  {
    if (this.mTakePhotoBtn != null) {
      this.mTakePhotoBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!SystemAuth.checkAuth("android.permission.CAMERA", true, "没有照相机权限，请打开后重试"))
          {
            TipTool.onCreateToastDialog(BNaviModuleManager.getNaviActivity(), "没有照相机权限，请打开后重试");
            return;
          }
          BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
          BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
          long l = System.currentTimeMillis();
          BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime = String.valueOf(l);
          BNDrivingToolManager.getInstance().getIssueInfo().mBduss = BNaviModuleManager.getBduss();
          BNDrivingToolManager.getInstance().getIssueInfo().mStoreType = String.valueOf(2);
          BNDrivingToolManager.getInstance().getIssueInfo().mIssueLocation = BNDrivingToolUtils.getCarPointString();
          BNDrivingToolManager.getInstance().getIssueInfo().mSessionID = BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", "");
          BNTakePhotoManager.getInstance().takePhoto();
        }
      });
    }
    if (this.mScreenShotBtn != null) {
      this.mScreenShotBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(final View paramAnonymousView)
        {
          if (BNScreentShotManager.sIsInThread) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getNaviActivity(), "截图正在处理中...请稍候再试");
          }
          for (;;)
          {
            return;
            BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
            BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
            long l = System.currentTimeMillis();
            BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime = String.valueOf(l);
            BNDrivingToolManager.getInstance().getIssueInfo().mStoreType = String.valueOf(3);
            BNDrivingToolManager.getInstance().getIssueInfo().mBduss = BNaviModuleManager.getBduss();
            BNDrivingToolManager.getInstance().getIssueInfo().mIssueLocation = BNDrivingToolUtils.getCarPointString();
            BNDrivingToolManager.getInstance().getIssueInfo().mSessionID = BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", "");
            paramAnonymousView = BNScreentShotManager.getInstance();
            if ((BNDrivingToolUtils.isMobileRoot()) && (BNSettingManager.isRootScreenshotPermitted()))
            {
              BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("notifyDayNightObservers-" + getClass().getSimpleName(), null)new BNWorkerConfig
              {
                protected String execute()
                {
                  paramAnonymousView.rootScreenShot();
                  return null;
                }
              }, new BNWorkerConfig(2, 0));
              return;
            }
            paramAnonymousView.initParams();
            try
            {
              if ((BNDrivingToolUtils.sCanShow) && (BNDrivingToolUtils.sMapRenderShow))
              {
                BNScreentShotManager.getInstance().captureSurfaceView(0, 0, 1);
                return;
              }
            }
            catch (Exception paramAnonymousView)
            {
              BNDrivingToolUtils.setSurfaceViewState(false);
              paramAnonymousView.printStackTrace();
            }
          }
        }
      });
    }
    if (this.mShortVideoBtn != null) {
      this.mShortVideoBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!BNVideoRecordManager.getInstance().hasRecordAuth())
          {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNVideoRecordManager.NO_RECORD_AUTH_MSG);
            return;
          }
          BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
          BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
          long l = System.currentTimeMillis();
          BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime = String.valueOf(l);
          BNDrivingToolManager.getInstance().getIssueInfo().mBduss = BNaviModuleManager.getBduss();
          BNDrivingToolManager.getInstance().getIssueInfo().mIssueLocation = BNDrivingToolUtils.getCarPointString();
          BNDrivingToolManager.getInstance().getIssueInfo().mSessionID = BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", "");
          BNVideoRecordManager.getInstance().recordVideo();
        }
      });
    }
    if (this.mSettingBtn != null) {
      this.mSettingBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
          BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
          paramAnonymousView = BNaviModuleManager.getNaviActivity();
          if (paramAnonymousView != null)
          {
            paramAnonymousView = new BNDrivingToolSettingDialog(paramAnonymousView);
            paramAnonymousView.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
              }
            });
            paramAnonymousView.show();
          }
        }
      });
    }
    if (this.mNewIssueBtn != null) {
      this.mNewIssueBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
          BNDrivingToolManager.getInstance().getIssueInfo().mBduss = BNaviModuleManager.getBduss();
          BNDrivingToolManager.getInstance().getIssueInfo().mSessionID = BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", "");
          paramAnonymousView = BNDrivingToolManager.getInstance().getIssueStoreDialog(4);
          paramAnonymousView.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
            }
          });
          paramAnonymousView.show();
        }
      });
    }
    if (this.mIssueListBtn != null) {
      this.mIssueListBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(final View paramAnonymousView)
        {
          if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
          {
            paramAnonymousView = new BNIssueViewDialog(BNaviModuleManager.getNaviActivity(), 16973833);
            paramAnonymousView.show();
            paramAnonymousView.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                paramAnonymousView.releaseResource();
              }
            });
            return;
          }
          TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(1711669729));
        }
      });
    }
  }
  
  private void pullDrivingTestNames()
  {
    this.mDrivingTestNames = new String[] { "hello, 我是一个路测" };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/view/BNDrivingToolDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */