package com.baidu.navi.routedetails.proxy;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.f.g;

public class RGRouteDetailsViewController
{
  private static RGRouteDetailsViewController sInstance;
  private Activity mActivity;
  private Context mContext;
  private boolean mIsRouteDetail;
  private ViewGroup mParentView;
  private RouteDetailMapView mRouteDetailMapView;
  
  public static RGRouteDetailsViewController getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new RGRouteDetailsViewController();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void cancleCountDownTask()
  {
    if (this.mRouteDetailMapView != null) {
      this.mRouteDetailMapView.cancleCountDownTask();
    }
  }
  
  public void initFocus(g paramg1, g paramg2, boolean paramBoolean)
  {
    if (this.mRouteDetailMapView == null) {
      return;
    }
    this.mRouteDetailMapView.initFocus(paramg1, paramg2, paramBoolean);
  }
  
  public void initView(Activity paramActivity, ViewGroup paramViewGroup, e parame)
  {
    this.mActivity = paramActivity;
    this.mContext = paramActivity.getApplicationContext();
    this.mParentView = paramViewGroup;
    setIsRouteDetail(true);
    this.mRouteDetailMapView = new RouteDetailMapView(this.mActivity, this.mParentView, parame);
  }
  
  public boolean isRouteDetail()
  {
    return this.mIsRouteDetail;
  }
  
  public boolean onBackPressed()
  {
    if (this.mRouteDetailMapView != null) {
      return this.mRouteDetailMapView.onBackPressed();
    }
    return false;
  }
  
  public void onDestory()
  {
    if (this.mRouteDetailMapView != null) {
      this.mRouteDetailMapView.onDestory();
    }
    setIsRouteDetail(false);
    this.mActivity = null;
  }
  
  public void onPause()
  {
    if (this.mRouteDetailMapView != null) {
      this.mRouteDetailMapView.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.mRouteDetailMapView != null) {
      this.mRouteDetailMapView.onResume();
    }
  }
  
  public void onUpdateOrientation(int paramInt)
  {
    if (this.mRouteDetailMapView != null) {
      this.mRouteDetailMapView.onUpdateOrientation(paramInt);
    }
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    if (this.mRouteDetailMapView != null) {
      this.mRouteDetailMapView.onUpdateStyle(paramBoolean);
    }
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    if (this.mRouteDetailMapView != null) {
      this.mRouteDetailMapView.onVoiceCommand(paramInt1, paramInt2, paramInt3, paramObject, paramBoolean);
    }
    return false;
  }
  
  public void setIsRouteDetail(boolean paramBoolean)
  {
    this.mIsRouteDetail = paramBoolean;
  }
  
  public void setNaviListener(BNRouteDetail.BNRouteDetailNavListener paramBNRouteDetailNavListener)
  {
    if (this.mRouteDetailMapView != null) {
      this.mRouteDetailMapView.setNaviListener(paramBNRouteDetailNavListener);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/routedetails/proxy/RGRouteDetailsViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */