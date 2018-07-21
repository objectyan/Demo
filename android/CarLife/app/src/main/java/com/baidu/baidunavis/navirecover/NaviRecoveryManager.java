package com.baidu.baidunavis.navirecover;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.widget.BMAlertDialog;
import com.baidu.mapframework.widget.BMAlertDialog.Builder;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.platform.comapi.c;
import java.io.File;
import java.io.FilenameFilter;

public class NaviRecoveryManager
{
  private static final int CRASH_STANDARD_TIME = 300;
  public static final String DUMP_FILE_SUFFIX = ".dmp";
  public static final String NAVI_RECO_DIALOG = "navi_reco_dialog";
  public static final String NAVI_RECO_NEG_CLICK = "navi_reco_neg_click";
  public static final String NAVI_RECO_POS_CLICK = "navi_reco_pos_click";
  public static final String NAVI_RECO_SUCCESS = "navi_reco_success";
  public static final String NAVI_RECO_TAG = "naviRecovery";
  private static final int RECOVER_STANDARD_TIME = 900;
  private static final int SLEEP_TIME = 500;
  private static NaviRecoveryManager sInstance = null;
  private BMAlertDialog naviRecoverDialog;
  
  private void clearLastNaviRoutelnfo(Handler paramHandler)
  {
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-clearLastNaviRoutelnfo", null)new BNWorkerConfig
    {
      protected String execute()
      {
        while ((!BaiduNaviManager.sIsEngineInitialFailed) && (!BaiduNaviManager.sIsBaseEngineInitialized)) {
          try
          {
            Thread.sleep(500L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("CarNavi-clearLastNaviRoutelnfo2", null)new BNWorkerConfig
        {
          protected String execute()
          {
            BaiduNaviManager.getInstance().clearLastNaviRoutelnfo();
            return null;
          }
        }, new BNWorkerConfig(100, 0));
        return null;
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  public static NaviRecoveryManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new NaviRecoveryManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static File getLastModifiedFile(String paramString1, String paramString2)
  {
    File[] arrayOfFile = new File(paramString1).listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.endsWith(this.val$suffix);
      }
    });
    if ((arrayOfFile == null) || (arrayOfFile.length <= 0))
    {
      paramString2 = null;
      return paramString2;
    }
    paramString1 = arrayOfFile[0];
    int i = 1;
    for (;;)
    {
      paramString2 = paramString1;
      if (i >= arrayOfFile.length) {
        break;
      }
      paramString2 = paramString1;
      if (arrayOfFile[i].lastModified() > paramString1.lastModified()) {
        paramString2 = arrayOfFile[i];
      }
      i += 1;
      paramString1 = paramString2;
    }
  }
  
  private boolean hasCrashed()
  {
    if (System.currentTimeMillis() / 1000L - NaviRecoveryModel.getInstance().getCrashTime() < 300L)
    {
      NaviRecoveryModel.getInstance().markCrashTime(0L);
      return true;
    }
    return hasNaCrashed();
  }
  
  private boolean hasKilled(Context paramContext)
  {
    if ((System.currentTimeMillis() / 1000L - BaiduNaviManager.getInstance().getKilledTime(paramContext) < 300L) && (BaiduNaviManager.getInstance().isLastNaviUnfinished(paramContext)))
    {
      BaiduNaviManager.getInstance().setKilledTime(paramContext, 0L);
      return true;
    }
    return false;
  }
  
  private boolean hasNaCrashed()
  {
    File localFile = new File(c.f().getCacheDir(), "dump");
    if (!localFile.exists()) {}
    long l;
    do
    {
      do
      {
        return false;
        localFile = getLastModifiedFile(localFile.getAbsolutePath(), ".dmp");
      } while (localFile == null);
      l = localFile.lastModified();
    } while ((l == NaviRecoveryModel.getInstance().getNaCrashTime()) || (System.currentTimeMillis() / 1000L - l / 1000L >= 300L));
    NaviRecoveryModel.getInstance().markNaCrashTime(l);
    return true;
  }
  
  private boolean hasRecovered()
  {
    return System.currentTimeMillis() / 1000L - NaviRecoveryModel.getInstance().getRecoverTime() < 900L;
  }
  
  private void recoverNaviData(final Handler paramHandler)
  {
    NaviRecoveryModel.getInstance().markRecoverTime(System.currentTimeMillis() / 1000L);
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-recoverNaviData", null)new BNWorkerConfig
    {
      protected String execute()
      {
        while ((!BaiduNaviManager.sIsEngineInitialFailed) && (!BaiduNaviManager.sIsBaseEngineInitialized)) {
          try
          {
            Thread.sleep(500L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("CarNavi-recoverNaviData2", null)new BNWorkerConfig
        {
          protected String execute()
          {
            BaiduNaviManager.getInstance().checkLastNaviStatus(NaviRecoveryManager.6.this.val$handler);
            return null;
          }
        }, new BNWorkerConfig(100, 0));
        return null;
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  private void showNaviRecoverDialog(final Activity paramActivity, final Handler paramHandler)
  {
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
    {
      protected String execute()
      {
        if (paramActivity == null) {
          return null;
        }
        NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_dialog");
        try
        {
          NaviRecoveryManager.access$102(NaviRecoveryManager.this, new BMAlertDialog.Builder(paramActivity).setTitle(Html.fromHtml("是否恢复上次的<font color='#3385ff'>导航</font><br>?")).setPositiveButton("恢复", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_pos_click");
              NaviRecoveryManager.this.recoverNaviData(NaviRecoveryManager.5.this.val$handler);
            }
          }).setNegativeButton("放弃", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_neg_click");
              NaviRecoveryManager.this.clearLastNaviRoutelnfo(NaviRecoveryManager.5.this.val$handler);
            }
          }).create());
          NaviRecoveryManager.this.naviRecoverDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_neg_click");
              NaviRecoveryManager.this.clearLastNaviRoutelnfo(NaviRecoveryManager.5.this.val$handler);
            }
          });
          NaviRecoveryManager.this.naviRecoverDialog.show();
          return null;
        }
        catch (Exception localException) {}
        return null;
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  public void cancelDialog()
  {
    if ((this.naviRecoverDialog != null) && (this.naviRecoverDialog.isShowing())) {}
    try
    {
      this.naviRecoverDialog.cancel();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void markCrashTime()
  {
    NaviRecoveryModel.getInstance().markCrashTime(System.currentTimeMillis() / 1000L);
  }
  
  public void recoverNavi(final Activity paramActivity)
  {
    if (paramActivity == null) {}
    final MainLooperHandler local3;
    boolean bool2;
    do
    {
      boolean bool1;
      do
      {
        return;
        local3 = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData())
        {
          public void onMessage(Message paramAnonymousMessage)
          {
            NavMapAdapter.getInstance().dismissMProgressDialog();
            switch (paramAnonymousMessage.arg1)
            {
            default: 
              return;
            case 0: 
              NavTipTool.onCreateToastDialog(paramActivity, "导航恢复失败，请重新发起！");
              return;
            }
            BaiduNaviManager.getInstance().continueLastNavi();
            NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_success");
          }
        };
        bool1 = hasCrashed();
        bool2 = hasKilled(paramActivity);
        if ((!bool1) && (!bool2))
        {
          clearLastNaviRoutelnfo(local3);
          return;
        }
      } while (!BaiduNaviManager.getInstance().isLastNaviUnfinished(paramActivity));
      if (hasRecovered())
      {
        showNaviRecoverDialog(paramActivity, local3);
        return;
      }
      if (bool1)
      {
        NavTipTool.onCreateToastDialog(paramActivity, "正在恢复上次导航...");
        NavMapAdapter.getInstance().showMProgressDialog((FragmentActivity)paramActivity, "正在恢复上次导航...", "", new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            NaviRecoveryManager.this.clearLastNaviRoutelnfo(local3);
          }
        });
        recoverNaviData(local3);
        return;
      }
    } while (!bool2);
    showNaviRecoverDialog(paramActivity, local3);
  }
  
  public void resetCrashAndKillTime(Context paramContext)
  {
    hasCrashed();
    hasKilled(paramContext);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/navirecover/NaviRecoveryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */