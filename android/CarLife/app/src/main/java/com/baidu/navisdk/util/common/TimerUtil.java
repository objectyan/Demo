package com.baidu.navisdk.util.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class TimerUtil
{
  private static final String TAG = "TimerUtil";
  private TimerCallBack mCallBack;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((TimerUtil.access$010(TimerUtil.this) > 0) && (TimerUtil.this.mCallBack != null)) {
        TimerUtil.this.mCallBack.onTick(TimerUtil.this.mTimeCount);
      }
      if (TimerUtil.this.mTimeCount == 0) {}
      while (TimerUtil.this.mHandler.hasMessages(0)) {
        return;
      }
      TimerUtil.this.mHandler.sendEmptyMessageDelayed(0, 1000L);
    }
  };
  private int mTimeCount;
  private int mTimeOut;
  
  public void addCallback(TimerCallBack paramTimerCallBack)
  {
    this.mCallBack = paramTimerCallBack;
  }
  
  public void cancle()
  {
    this.mHandler.removeMessages(0);
    this.mHandler.removeCallbacks(null);
  }
  
  public void removeCallback()
  {
    this.mCallBack = null;
  }
  
  public void reset()
  {
    this.mTimeCount = this.mTimeOut;
  }
  
  public void start(int paramInt)
  {
    cancle();
    this.mTimeOut = paramInt;
    this.mTimeCount = paramInt;
    if (this.mHandler == null) {
      LogUtil.e("TimerUtil", "handler is null");
    }
    while (this.mHandler.hasMessages(0)) {
      return;
    }
    this.mHandler.sendEmptyMessageDelayed(0, 1000L);
  }
  
  public static abstract interface TimerCallBack
  {
    public abstract void onTick(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/TimerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */