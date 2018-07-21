package com.baidu.navi.routedetails.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.f.g;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class BNRouteDetail
{
  private static volatile BNRouteDetail me = null;
  private Activity mActivity;
  private Context mContext;
  private FrameLayout mParentView = null;
  
  public static void destory()
  {
    if (me != null) {}
    try
    {
      if (me != null) {
        me.dispose();
      }
      me = null;
      return;
    }
    finally {}
  }
  
  private void dispose() {}
  
  public static BNRouteDetail getInstance()
  {
    if (me == null) {}
    try
    {
      if (me == null) {
        me = new BNRouteDetail();
      }
      return me;
    }
    finally {}
  }
  
  private void setupUI(e parame)
  {
    if (this.mParentView == null) {
      return;
    }
    this.mParentView.removeAllViews();
    RGRouteDetailsViewController.getInstance().initView(this.mActivity, this.mParentView, parame);
  }
  
  public void cancleCountDownTask()
  {
    RGRouteDetailsViewController.getInstance().cancleCountDownTask();
  }
  
  public View init(Activity paramActivity, e parame)
  {
    this.mActivity = paramActivity;
    this.mContext = paramActivity.getApplicationContext();
    try
    {
      this.mParentView = ((FrameLayout)this.mActivity.getLayoutInflater().inflate(2130968881, null));
      setupUI(parame);
      boolean bool = PreferenceHelper.getInstance(this.mActivity).getBoolean("SP_KEY_SHOW_TOAST_FOR_LINKID", false);
      LogUtil.e("", "BNDownloadUIManager: isFirstShow " + bool);
      int i = BNSettingManager.getPrefRoutPlanMode();
      if ((bool) && ((i == 2) || (i == 0))) {
        PreferenceHelper.getInstance(this.mActivity).putBoolean("SP_KEY_SHOW_TOAST_FOR_LINKID", false);
      }
      return this.mParentView;
    }
    catch (Exception paramActivity) {}
    return null;
  }
  
  public void initFocus(g paramg1, g paramg2, boolean paramBoolean)
  {
    RGRouteDetailsViewController.getInstance().initFocus(paramg1, paramg2, paramBoolean);
  }
  
  public boolean onBackPressed()
  {
    return RGRouteDetailsViewController.getInstance().onBackPressed();
  }
  
  public void onDestory()
  {
    if (this.mParentView != null) {
      this.mParentView.removeAllViews();
    }
    RGRouteDetailsViewController.getInstance().onDestory();
    this.mActivity = null;
  }
  
  public void onPause()
  {
    RGRouteDetailsViewController.getInstance().onPause();
  }
  
  public void onResume()
  {
    RGRouteDetailsViewController.getInstance().onResume();
  }
  
  public void onUpdateOrientation(int paramInt)
  {
    RGRouteDetailsViewController.getInstance().onUpdateOrientation(paramInt);
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    RGRouteDetailsViewController.getInstance().onUpdateStyle(paramBoolean);
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    return RGRouteDetailsViewController.getInstance().onVoiceCommand(paramInt1, paramInt2, paramInt3, paramObject, paramBoolean);
  }
  
  public void setNaviListener(BNRouteDetailNavListener paramBNRouteDetailNavListener)
  {
    RGRouteDetailsViewController.getInstance().setNaviListener(paramBNRouteDetailNavListener);
  }
  
  public static abstract interface BNRouteDetailNavListener
  {
    public abstract void onJumpBack();
    
    public abstract void onJumpHome();
    
    public abstract void onStartNavi(Bundle paramBundle, boolean paramBoolean);
    
    public abstract void onUpdate();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/routedetails/proxy/BNRouteDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */