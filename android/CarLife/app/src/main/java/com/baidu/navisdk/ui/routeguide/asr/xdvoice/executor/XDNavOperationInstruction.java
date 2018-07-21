package com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionResponse;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionResponse.RetState;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceTTSListener;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class XDNavOperationInstruction
  extends InstructionExecutorAbs
{
  private String TAG = "XDVoice";
  private XDVoiceTTSListener mXdListener;
  
  private void avoidCongestion()
  {
    if ((BNavigator.getInstance().getContext() != null) && (NetworkUtils.isNetworkAvailable(BNavigator.getInstance().getContext())) && (BNRouteGuider.getInstance().isCurDriveRouteOnline()))
    {
      LogUtil.e(this.TAG, "excute - avoidCongestion()");
      refreshRoute(25);
    }
    do
    {
      return;
      LogUtil.e(this.TAG, "avoidCongestion() -- offlineMode -- retuen");
    } while (this.mXdListener == null);
    this.mXdListener.onResponse(new XDVoiceInstructionResponse(XDVoiceInstructionResponse.RetState.SUCCESS, BNStyleManager.getString(1711670044)));
  }
  
  private void changeFasterRoute()
  {
    if ((BNavigator.getInstance().getContext() != null) && (NetworkUtils.isNetworkAvailable(BNavigator.getInstance().getContext())) && (BNRouteGuider.getInstance().isCurDriveRouteOnline()))
    {
      LogUtil.e(this.TAG, "excute - changeFasterRoute()");
      refreshRoute(26);
      return;
    }
    if (this.mXdListener != null) {
      this.mXdListener.onResponse(new XDVoiceInstructionResponse(XDVoiceInstructionResponse.RetState.SUCCESS, BNStyleManager.getString(1711670044)));
    }
    LogUtil.e(this.TAG, "changeFasterRoute() -- offlineMode -- retuen");
  }
  
  private void exitNav()
  {
    if (this.mXdListener != null) {
      this.mXdListener.onResponse(new XDVoiceInstructionResponse(XDVoiceInstructionResponse.RetState.SUCCESS, "正在为您退出导航"));
    }
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("exitNav-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        BNavigator.getInstance().asrQuitNavi();
        return null;
      }
    }, new BNWorkerConfig(2, 0), 1500L);
  }
  
  private void refreshRoute(int paramInt)
  {
    Context localContext = BNavigator.getInstance().getContext();
    if (localContext != null)
    {
      if (!NetworkUtils.isNetworkAvailable(localContext))
      {
        LogUtil.e(this.TAG, "excute refreshRoute() - not Network!  retuen");
        TipTool.onCreateToastDialog(localContext, JarUtils.getResources().getString(1711670047));
        return;
      }
      RGMapModeViewController.getInstance().showRefreshRoadProgess();
      BNRouteGuider.getInstance().calcOtherRoute("", 1, paramInt);
      return;
    }
    LogUtil.e(this.TAG, "refreshRoute --> BNavigator.getInstance().getContext() == null!!");
  }
  
  public void execute(String paramString, XDVoiceTTSListener paramXDVoiceTTSListener)
  {
    this.mXdListener = paramXDVoiceTTSListener;
    if ("exit_navigation".equals(paramString))
    {
      exitNav();
      UserOPController.getInstance().add("3.c.6");
    }
    do
    {
      return;
      if ("more_fast".equals(paramString))
      {
        changeFasterRoute();
        UserOPController.getInstance().add("3.c.g");
        return;
      }
    } while (!"avoid_congestion".equals(paramString));
    avoidCongestion();
    UserOPController.getInstance().add("3.c.5");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/asr/xdvoice/executor/XDNavOperationInstruction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */