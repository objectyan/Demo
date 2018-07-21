package com.baidu.navisdk.ui.routeguide.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class RGUpdateRCFailModel
{
  public static final int MAX_WAIT_TIME = 30;
  public static final int MSG_CANCEL_COUNT = 3;
  public static final int MSG_STOP_COUNT = 2;
  public static final int MSG_TIME_COUNT = 1;
  public static int currentMsgType = -1;
  private static RGUpdateRCFailModel mInstance = null;
  public int currentCount = 30;
  private boolean mCanCounterRestart = false;
  private OnCountDownListener mCountDownListener;
  private Handler mHandler;
  private boolean mRCUpdateFialCanShow = false;
  
  private void cancelCountDown()
  {
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1);
    }
    this.currentCount = 0;
  }
  
  public static RGUpdateRCFailModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGUpdateRCFailModel();
    }
    return mInstance;
  }
  
  public String getCountStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(BNStyleManager.getString(1711670069));
    return this.currentCount;
  }
  
  public boolean isRCUpdateFialCanShow()
  {
    return this.mRCUpdateFialCanShow;
  }
  
  public boolean ismCanCounterRestart()
  {
    return this.mCanCounterRestart;
  }
  
  public void setOnCountDownListener(OnCountDownListener paramOnCountDownListener)
  {
    this.mCountDownListener = paramOnCountDownListener;
  }
  
  public void setmCanCounterRestart(boolean paramBoolean)
  {
    this.mCanCounterRestart = paramBoolean;
  }
  
  public void setmCanRCUpdateFialShow(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.currentCount = 30;
    }
    for (;;)
    {
      this.mRCUpdateFialCanShow = paramBoolean;
      return;
      cancelCountDown();
    }
  }
  
  public void startCountDown()
  {
    if (this.mHandler == null)
    {
      this.mHandler = new Handler(Looper.getMainLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (1 == paramAnonymousMessage.what)
          {
            paramAnonymousMessage = RGUpdateRCFailModel.this;
            paramAnonymousMessage.currentCount -= 1;
            if (RGUpdateRCFailModel.this.currentCount <= 0) {
              break label78;
            }
            RGUpdateRCFailModel.this.mHandler.sendEmptyMessageDelayed(1, 1000L);
          }
          for (;;)
          {
            if (RGUpdateRCFailModel.this.mCountDownListener != null) {
              RGUpdateRCFailModel.this.mCountDownListener.onCountDown(RGUpdateRCFailModel.this.currentCount);
            }
            return;
            label78:
            RGUpdateRCFailModel.this.currentCount = 0;
          }
        }
      };
      return;
    }
    this.mHandler.removeMessages(1);
    this.mHandler.sendEmptyMessageDelayed(1, 1000L);
  }
  
  public static abstract interface OnCountDownListener
  {
    public abstract void onCountDown(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGUpdateRCFailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */