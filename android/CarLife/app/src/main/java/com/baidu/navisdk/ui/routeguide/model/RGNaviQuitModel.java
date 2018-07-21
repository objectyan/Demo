package com.baidu.navisdk.ui.routeguide.model;

import android.os.Handler;
import android.os.Message;

public class RGNaviQuitModel
{
  private static final int MSG_TYPE_COUNT_DOWN = 100;
  private static RGNaviQuitModel sInstance = null;
  private int mCountDown = 10;
  private OnCountDownListener mCountDownListener = null;
  private Handler mHandler = null;
  private boolean mIsShowCountDown = false;
  
  public static RGNaviQuitModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new RGNaviQuitModel();
    }
    return sInstance;
  }
  
  public boolean isShowCountDown()
  {
    return this.mIsShowCountDown;
  }
  
  public void setAndStartCountDown(boolean paramBoolean)
  {
    setCountDown(paramBoolean);
    startCountDown();
  }
  
  public void setCountDown(boolean paramBoolean)
  {
    this.mIsShowCountDown = paramBoolean;
    if (paramBoolean)
    {
      this.mCountDown = 10;
      return;
    }
    this.mCountDownListener = null;
  }
  
  public void setOnCountDownListener(OnCountDownListener paramOnCountDownListener)
  {
    this.mCountDownListener = paramOnCountDownListener;
  }
  
  public void startCountDown()
  {
    if (!this.mIsShowCountDown) {}
    do
    {
      return;
      if (this.mHandler == null) {
        this.mHandler = new Handler()
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            if (100 == paramAnonymousMessage.what)
            {
              RGNaviQuitModel.access$010(RGNaviQuitModel.this);
              if (RGNaviQuitModel.this.mCountDown <= 0) {
                break label73;
              }
              RGNaviQuitModel.this.mHandler.sendEmptyMessageDelayed(100, 1000L);
            }
            for (;;)
            {
              if (RGNaviQuitModel.this.mCountDownListener != null) {
                RGNaviQuitModel.this.mCountDownListener.onCountDown(RGNaviQuitModel.this.mCountDown);
              }
              return;
              label73:
              RGNaviQuitModel.access$002(RGNaviQuitModel.this, 0);
              RGNaviQuitModel.access$202(RGNaviQuitModel.this, false);
            }
          }
        };
      }
    } while (this.mHandler == null);
    if (this.mHandler.hasMessages(100)) {
      this.mHandler.removeMessages(100);
    }
    this.mHandler.sendEmptyMessageDelayed(100, 1000L);
  }
  
  public static abstract interface OnCountDownListener
  {
    public abstract void onCountDown(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGNaviQuitModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */