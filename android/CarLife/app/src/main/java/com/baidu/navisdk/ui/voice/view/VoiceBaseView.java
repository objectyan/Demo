package com.baidu.navisdk.ui.voice.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoice.OnVoicePageJumpListener;

public abstract class VoiceBaseView
{
  public static final String ACTION_PARAM = "actionParam";
  public static final String URL_CHECK = "bdnavi://check";
  public static final String URL_NET_LOSS = "bdnavi://getdataerr";
  public static final String URL_PASS_TOPIC_INFO = "bdnavi://passTopicInfo";
  public static final String URL_PAUSE = "bdnavi://pause";
  public static final String URL_PREFIX = "bdnavi://";
  public static final String URL_START = "bdnavi://start";
  public static final String YPID = "ypid";
  public boolean hasPaused = false;
  protected Activity mActivity = null;
  protected Handler mHandler = null;
  protected BNVoice.OnVoicePageJumpListener mJumpListener;
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public abstract void initValues(Bundle paramBundle);
  
  public View initView(Activity paramActivity, BNVoice.OnVoicePageJumpListener paramOnVoicePageJumpListener, Bundle paramBundle)
  {
    this.mActivity = paramActivity;
    this.mJumpListener = paramOnVoicePageJumpListener;
    this.mHandler = new Handler(paramActivity.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        BNVoice.getInstance().handleVoiceMessage(paramAnonymousMessage.what, paramAnonymousMessage.arg1, paramAnonymousMessage.obj);
      }
    };
    if (paramOnVoicePageJumpListener != null) {
      paramOnVoicePageJumpListener.onVoiceUserBehaviour("voice_access");
    }
    paramActivity = onInitView(paramBundle);
    initValues(paramBundle);
    return paramActivity;
  }
  
  public boolean onBackPressed()
  {
    return true;
  }
  
  public void onDestory() {}
  
  protected abstract View onInitView(Bundle paramBundle);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public void onUpdateOrientation(int paramInt) {}
  
  public abstract void onUpdateStyle(boolean paramBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/view/VoiceBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */