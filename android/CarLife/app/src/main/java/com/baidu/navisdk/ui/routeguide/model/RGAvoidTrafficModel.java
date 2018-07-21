package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;

public class RGAvoidTrafficModel
{
  private static final int MSG_TYPE_COUNT_DOWN = 100;
  private static RGAvoidTrafficModel sInstance = null;
  private boolean mCanAvoidTrafficShow = false;
  private int mCountDown = 30;
  private OnCountDownListener mCountDownListener = null;
  private int mCurRouteId = -1;
  private Handler mHandler = null;
  private boolean mIsClickToSwitch = false;
  private boolean mIsShowCountDown = false;
  private String mRouteTips = null;
  private OptimalRouteType mRouteType = OptimalRouteType.AVOID_TRAFFIC;
  private String mRouteVoiceTips = null;
  
  public static RGAvoidTrafficModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new RGAvoidTrafficModel();
    }
    return sInstance;
  }
  
  public String getRouteTips()
  {
    return this.mRouteTips;
  }
  
  public OptimalRouteType getRouteType()
  {
    return this.mRouteType;
  }
  
  public String getVoiceTips()
  {
    return this.mRouteVoiceTips;
  }
  
  public boolean getmCanAvoidTrafficShow()
  {
    return this.mCanAvoidTrafficShow;
  }
  
  public int getmCountDown()
  {
    return this.mCountDown;
  }
  
  public int getmCurRouteId()
  {
    return this.mCurRouteId;
  }
  
  public boolean getmIsClickToSwitch()
  {
    return this.mIsClickToSwitch;
  }
  
  public boolean isCLoudRecommend()
  {
    return this.mRouteType == OptimalRouteType.CLOUD_RECOMMEND;
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
    if (!paramBoolean) {
      this.mCountDownListener = null;
    }
  }
  
  public void setOnCountDownListener(OnCountDownListener paramOnCountDownListener)
  {
    this.mCountDownListener = paramOnCountDownListener;
  }
  
  public void setOptimalRouteInfo(Bundle paramBundle)
  {
    int i;
    if (paramBundle != null)
    {
      this.mRouteTips = paramBundle.getString("OptimalRouteTips");
      this.mRouteVoiceTips = paramBundle.getString("OptimalVoiceTips");
      LogUtil.e("dingbinAvoic", this.mRouteVoiceTips);
      i = paramBundle.getInt("OptimalRouteType", 0);
      LogUtil.e("OptimalRoute", "OptimalRoute type " + i + ", " + this.mRouteTips);
      if (1 != i) {
        break label90;
      }
      this.mRouteType = OptimalRouteType.AVOID_TRAFFIC;
    }
    label90:
    while (2 != i) {
      return;
    }
    this.mRouteType = OptimalRouteType.CLOUD_RECOMMEND;
  }
  
  public void setmCanAvoidTrafficShow(boolean paramBoolean)
  {
    this.mCanAvoidTrafficShow = paramBoolean;
  }
  
  public void setmCountDown(int paramInt)
  {
    this.mCountDown = paramInt;
  }
  
  public void setmCurRouteId(int paramInt)
  {
    this.mCurRouteId = paramInt;
  }
  
  public void setmIsClickToSwitch(boolean paramBoolean)
  {
    this.mIsClickToSwitch = paramBoolean;
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
              LogUtil.e("", "AssistantIconUpdate showAvoidTrafficView:onCountDown  mCountDown " + RGAvoidTrafficModel.this.mCountDown + "   mCountDownListener " + RGAvoidTrafficModel.this.mCountDownListener);
              RGAvoidTrafficModel.access$010(RGAvoidTrafficModel.this);
              if (RGAvoidTrafficModel.this.mCountDown <= 0) {
                break label118;
              }
              RGAvoidTrafficModel.this.mHandler.sendEmptyMessageDelayed(100, 1000L);
            }
            for (;;)
            {
              if (RGAvoidTrafficModel.this.mCountDownListener != null) {
                RGAvoidTrafficModel.this.mCountDownListener.onCountDown(RGAvoidTrafficModel.this.mCountDown);
              }
              return;
              label118:
              RGAvoidTrafficModel.access$002(RGAvoidTrafficModel.this, 0);
              RGAvoidTrafficModel.access$302(RGAvoidTrafficModel.this, false);
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
  
  public static enum OptimalRouteType
  {
    AVOID_TRAFFIC,  CLOUD_RECOMMEND;
    
    private OptimalRouteType() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGAvoidTrafficModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */