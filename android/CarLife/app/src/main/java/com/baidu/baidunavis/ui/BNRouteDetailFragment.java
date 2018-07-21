package com.baidu.baidunavis.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.wrapper.BNRouteDetailActivityWrapper;
import com.baidu.carlife.custom.b;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.routedetails.proxy.BNRouteDetail;

public class BNRouteDetailFragment
  extends ContentFragment
{
  public static final String BACK_FROM_ANOLOG_NAVI = "BACK_FROM_ANOLOG_NAVI";
  private BNRouteDetailActivityWrapper mBnRouteDetailActivityWrapper;
  
  public void driving()
  {
    if (b.a().b()) {
      return;
    }
    backTo(17, null);
    com.baidu.carlife.custom.a.a().d();
  }
  
  public boolean isMapPage()
  {
    return true;
  }
  
  public boolean onBackPressed()
  {
    if ((NavMapAdapter.getInstance().isNaviInjectSuccess()) && (this.mBnRouteDetailActivityWrapper != null)) {
      if (!this.mBnRouteDetailActivityWrapper.onBackPressed()) {
        super.onBackPressed();
      }
    }
    for (;;)
    {
      return true;
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((NavMapAdapter.getInstance().isNaviInjectSuccess()) && (this.mBnRouteDetailActivityWrapper != null)) {
      this.mBnRouteDetailActivityWrapper.onConfigurationChanged(paramConfiguration);
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.baidu.navi.fragment.BaseFragment.mResumeMapView = true;
    if (NavMapAdapter.getInstance().isNaviInjectSuccess())
    {
      if (this.mBnRouteDetailActivityWrapper == null) {
        this.mBnRouteDetailActivityWrapper = new BNRouteDetailActivityWrapper(this);
      }
      return;
    }
    NavMapAdapter.getInstance().navigateTo(com.baidu.carlife.core.a.a(), NavMapAdapter.getInstance().getMapFramePageClassName());
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    if ((NavMapAdapter.getInstance().isNaviInjectSuccess()) && (this.mBnRouteDetailActivityWrapper != null)) {
      return this.mBnRouteDetailActivityWrapper.onCreateContentView(this);
    }
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (NavMapManager.getInstance().getNaviMapMode() == 5) {
      NavMapManager.getInstance().showCarResultLayer(true);
    }
    for (;;)
    {
      NavMapManager.getInstance().set3DGestureEnable(false);
      return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      com.baidu.baidumaps.f.a.a.a.a().d();
      com.baidu.baidumaps.f.a.a.a.a().a(false, null);
    }
  }
  
  public void onDestroy()
  {
    if ((NavMapAdapter.getInstance().isNaviInjectSuccess()) && (this.mBnRouteDetailActivityWrapper != null)) {
      this.mBnRouteDetailActivityWrapper.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    BNRouteDetail.getInstance().cancleCountDownTask();
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onInitFocusAreas()
  {
    if ((NavMapAdapter.getInstance().isNaviInjectSuccess()) && (this.mBnRouteDetailActivityWrapper != null)) {
      this.mBnRouteDetailActivityWrapper.onInitFocus();
    }
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    if ((NavMapAdapter.getInstance().isNaviInjectSuccess()) && (this.mBnRouteDetailActivityWrapper != null)) {
      this.mBnRouteDetailActivityWrapper.onPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    if ((NavMapAdapter.getInstance().isNaviInjectSuccess()) && (this.mBnRouteDetailActivityWrapper != null)) {
      this.mBnRouteDetailActivityWrapper.onResume();
    }
    if (com.baidu.carlife.l.a.a().N()) {
      com.baidu.carlife.m.a.a().a(true);
    }
    for (;;)
    {
      super.onResume();
      return;
      com.baidu.carlife.m.a.a().a(false);
    }
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    if ((paramInt1 == 2) && (paramInt2 == 38))
    {
      back();
      return true;
    }
    if (this.mBnRouteDetailActivityWrapper != null) {
      return this.mBnRouteDetailActivityWrapper.onVoiceCommand(paramInt1, paramInt2, paramInt3, paramObject, paramBoolean);
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/BNRouteDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */