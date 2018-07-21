package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

import android.content.res.Resources;
import android.util.SparseArray;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.Utils;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor.InstructionExecutor;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class XDVoiceInstructManager
{
  private static XDVoiceInstructManager INSTANCE;
  private static String TAG = "XDVoice";
  public static boolean XD_ROUSED = false;
  private SparseArray<InstructionExecutor> mInstructionExecutors = new SparseArray();
  public XDVoiceInstructionResponse mLastResponse;
  private XDVoiceTTSListener mXDTTSListener = null;
  private XDVoiceCallback mXDVoiceCallback;
  
  public static XDVoiceInstructManager getInstance()
  {
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new XDVoiceInstructManager();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  public void askNaviToPark(String paramString, GeoPoint paramGeoPoint)
  {
    paramString = new XDVoiceInstructionResponse(XDVoiceInstructionResponse.RetState.SUCCESS, Utils.getPushCommandSpeech("ask_dest_park", paramString));
    paramString.setHasRound2(true);
    paramString.setRoundValue("ask_dest_park");
    paramString.setExtra(paramGeoPoint);
    this.mLastResponse = paramString;
    if (this.mXDTTSListener != null) {
      this.mXDTTSListener.onResponse(paramString);
    }
  }
  
  public void askRouteRecommend(String paramString)
  {
    LogUtil.e(TAG, "askRouteRecommend() - tips: " + paramString);
    if (!StringUtils.isEmpty(paramString))
    {
      UserOPController.getInstance().add("3.c.b");
      UserOPController.getInstance().add("aj");
      paramString = new XDVoiceInstructionResponse(XDVoiceInstructionResponse.RetState.SUCCESS, Utils.getPushCommandSpeech("ask_route_recommend", paramString));
      paramString.setHasRound2(true);
      paramString.setErrorContent(JarUtils.getResources().getString(1711670271));
      paramString.setRoundValue("ask_route_recommend");
      this.mLastResponse = paramString;
      if (this.mXDTTSListener != null) {
        this.mXDTTSListener.onResponse(paramString);
      }
    }
  }
  
  public void cancelAsr()
  {
    if (this.mXDVoiceCallback != null) {
      this.mXDVoiceCallback.cancelAsr();
    }
  }
  
  public void closePanel()
  {
    if (this.mXDVoiceCallback != null) {
      this.mXDVoiceCallback.closePanel();
    }
  }
  
  public void executInstruction(String paramString)
  {
    XDVoiceInstructionRequest localXDVoiceInstructionRequest = new XDVoiceInstructionRequest(paramString);
    InstructionExecutor localInstructionExecutor = (InstructionExecutor)this.mInstructionExecutors.get(localXDVoiceInstructionRequest.topType);
    paramString = localInstructionExecutor;
    if (localInstructionExecutor == null)
    {
      paramString = XDVoiceInstructionFactory.createInstructExecutor(localXDVoiceInstructionRequest.topType);
      this.mInstructionExecutors.append(localXDVoiceInstructionRequest.topType, paramString);
    }
    if ((this.mXDTTSListener != null) && (paramString != null)) {
      paramString.execute(localXDVoiceInstructionRequest.subAction, this.mXDTTSListener);
    }
  }
  
  public boolean onStart()
  {
    if (!Utils.checkAuthrity("android.permission.RECORD_AUDIO"))
    {
      LogUtil.e(TAG, "onStart() -- not RECORD_AUDIO_AUTH permission");
      return false;
    }
    if ((!XD_ROUSED) && (this.mXDTTSListener != null))
    {
      LogUtil.e(TAG, "onStart()");
      TTSPlayerControl.stopVoiceTTSOutput();
      BNavigator.getInstance().onXDVoiceStart();
      BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
      XD_ROUSED = true;
    }
    return XD_ROUSED;
  }
  
  public void onStop()
  {
    if (XD_ROUSED)
    {
      LogUtil.e(TAG, "onStop()");
      XD_ROUSED = false;
      this.mInstructionExecutors.clear();
    }
  }
  
  public void registXDVoicePanelCallback(XDVoiceCallback paramXDVoiceCallback)
  {
    LogUtil.e(TAG, "registXDVoicePanelCallback() - callback > " + paramXDVoiceCallback);
    this.mXDVoiceCallback = paramXDVoiceCallback;
  }
  
  public void release()
  {
    this.mXDTTSListener = null;
    this.mXDVoiceCallback = null;
    onStop();
  }
  
  public void resetLastInstrut()
  {
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask(getClass().getSimpleName() + " - resetLastInstrut", null)new BNWorkerConfig
    {
      protected String execute()
      {
        LogUtil.e(XDVoiceInstructManager.TAG, "resetLastInstrut!");
        if (XDVoiceInstructManager.getInstance().mLastResponse != null)
        {
          XDVoiceInstructManager.getInstance().mLastResponse = null;
          XDVoiceInstructManager.this.cancelAsr();
        }
        return null;
      }
    }, new BNWorkerConfig(8, 0), 300L);
  }
  
  public void setPhoneIn(boolean paramBoolean)
  {
    if (this.mXDVoiceCallback != null)
    {
      LogUtil.e(TAG, "setPhoneIn > " + paramBoolean);
      if (paramBoolean)
      {
        this.mXDVoiceCallback.closePanel();
        this.mXDVoiceCallback.xdWakeEnable(false);
      }
    }
    else
    {
      return;
    }
    this.mXDVoiceCallback.xdWakeEnable(true);
  }
  
  public void setWakeupEnable(boolean paramBoolean)
  {
    if (this.mXDVoiceCallback != null) {
      this.mXDVoiceCallback.xdWakeEnable(paramBoolean);
    }
  }
  
  public void setXDPlan(int paramInt1, int paramInt2)
  {
    if (this.mXDVoiceCallback != null) {
      this.mXDVoiceCallback.voiceEnable(paramInt1, paramInt2);
    }
  }
  
  public void setXDVoiceListener(XDVoiceTTSListener paramXDVoiceTTSListener)
  {
    this.mXDTTSListener = paramXDVoiceTTSListener;
  }
  
  public void startAsr()
  {
    if (this.mXDVoiceCallback != null) {
      this.mXDVoiceCallback.startAsr();
    }
  }
  
  public boolean xdIsWakeUpOn()
  {
    if (this.mXDVoiceCallback != null) {
      return this.mXDVoiceCallback.xdIsWakeUpOn();
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/asr/xdvoice/XDVoiceInstructManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */