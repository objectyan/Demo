package com.baidu.baidunavis.wrapper;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavLocationManager;
import com.baidu.baidunavis.control.NavDayNightController;
import com.baidu.baidunavis.control.NavDayNightController.OnDayNightChangedListener;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.baidunavis.control.NavRoutePlanController;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.ui.BNRouteDetailFragment;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.f.g;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.routedetails.proxy.BNRouteDetail;
import com.baidu.navi.routedetails.proxy.BNRouteDetail.BNRouteDetailNavListener;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNRouteDetailActivityWrapper
{
  private boolean mBackFromAnologNavi = false;
  private BNRouteDetailFragment mFragment = null;
  private boolean mIsAnologNavi = false;
  private g mLeftArea;
  private NavDayNightController.OnDayNightChangedListener mOnDayNightChangedListener = new NavDayNightController.OnDayNightChangedListener()
  {
    public void onDayNightChanged(boolean paramAnonymousBoolean)
    {
      BNRouteDetail.getInstance().onUpdateStyle(paramAnonymousBoolean);
    }
  };
  private g mRightArea;
  private BNRouteDetail.BNRouteDetailNavListener mRouteDetailNavListener = new BNRouteDetail.BNRouteDetailNavListener()
  {
    public void onJumpBack()
    {
      if (BNRouteDetailActivityWrapper.this.mFragment.getNaviFragmentManager() != null) {
        BNRouteDetailActivityWrapper.this.mFragment.getNaviFragmentManager().back(null);
      }
    }
    
    public void onJumpHome()
    {
      if (BNRouteDetailActivityWrapper.this.mFragment.getNaviFragmentManager() != null) {
        BNRouteDetailActivityWrapper.this.mFragment.getNaviFragmentManager().back(null);
      }
    }
    
    public void onStartNavi(Bundle paramAnonymousBundle, boolean paramAnonymousBoolean)
    {
      BNRouteDetailActivityWrapper.access$002(BNRouteDetailActivityWrapper.this, paramAnonymousBoolean);
      paramAnonymousBundle = NavRouteGuideController.getInstance();
      if (!paramAnonymousBoolean) {}
      for (int i = 1;; i = 2)
      {
        paramAnonymousBundle.setLocateMode(i);
        NavRoutePlanModel.getInstance().setmNavEnter("nav_nav");
        BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", "nav_nav");
        NavRouteGuideController.getInstance().startRouteGuideView(false, NavRoutePlanController.getInstance().createNaviParam(NavRouteGuideController.getInstance().getLocateMode(), false));
        return;
      }
    }
    
    public void onUpdate()
    {
      BNRouteDetailActivityWrapper.this.reInitFocus();
    }
  };
  private RoutePlanObserver mRoutePlanObserver = null;
  private boolean needUpdate = true;
  
  public BNRouteDetailActivityWrapper(BNRouteDetailFragment paramBNRouteDetailFragment)
  {
    this.mFragment = paramBNRouteDetailFragment;
  }
  
  public boolean onBackPressed()
  {
    return BNRouteDetail.getInstance().onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public View onCreateContentView(e parame)
  {
    boolean bool = true;
    if (!JarUtils.getAsJar())
    {
      this.mFragment.back();
      return null;
    }
    Object localObject = this.mFragment.getArguments();
    if ((localObject != null) && (((Bundle)localObject).containsKey("BACK_FROM_ANOLOG_NAVI"))) {
      this.mBackFromAnologNavi = ((Bundle)localObject).getBoolean("BACK_FROM_ANOLOG_NAVI", false);
    }
    this.mRoutePlanObserver = new RoutePlanObserver(null);
    com.baidu.navisdk.ui.routedetails.proxy.BNRouteDetailConfig.pRGViewMode = 1;
    localObject = BNRouteDetail.getInstance();
    BNRouteDetailFragment localBNRouteDetailFragment = this.mFragment;
    parame = ((BNRouteDetail)localObject).init(BNRouteDetailFragment.mActivity, parame);
    if (parame == null) {
      return null;
    }
    localObject = BNMapController.getInstance();
    if (!BNStyleManager.getRealDayStyle()) {}
    for (;;)
    {
      ((BNMapController)localObject).setNightMode(bool);
      if (this.mBackFromAnologNavi) {
        BNRouteDetail.getInstance().cancleCountDownTask();
      }
      BNRouteDetail.getInstance().setNaviListener(this.mRouteDetailNavListener);
      NavDayNightController.getInstance().registerDayNightListener(this.mOnDayNightChangedListener);
      try
      {
        BNRoutePlaner.getInstance().setComeFrom(3);
        StatisticManager.onEvent("NAVI_0001", "NAVI_0001");
        return parame;
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          LogUtil.e("BNRoutePlaner", "BNRoutePlaner.getInstance().setComeFrom MethodError");
        }
      }
    }
  }
  
  public void onDestroy()
  {
    NavDayNightController.getInstance().unregisterDayNightListener(this.mOnDayNightChangedListener);
    BNRouteDetail.getInstance().onDestory();
    try
    {
      BNMapController localBNMapController = BNMapController.getInstance();
      if (!BNStyleManager.getRealDayStyle()) {}
      for (boolean bool = true;; bool = false)
      {
        localBNMapController.setNightMode(bool);
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onInitFocus()
  {
    BNRouteDetail.getInstance().initFocus(this.mLeftArea, this.mRightArea, false);
  }
  
  public void onPause()
  {
    BNRoutePlaner.getInstance().setObserver(null);
    BNRouteDetail.getInstance().onPause();
    NavLocationManager.getInstance().exitRouteDetailPage();
  }
  
  public void onResume()
  {
    BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
    BNRouteDetail.getInstance().onResume();
    BNMapController localBNMapController = BNMapController.getInstance();
    if (!BNStyleManager.getRealDayStyle()) {}
    for (boolean bool = true;; bool = false)
    {
      localBNMapController.setNightMode(bool);
      NavLocationManager.getInstance().enterRouteDetailPage();
      return;
    }
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    return BNRouteDetail.getInstance().onVoiceCommand(paramInt1, paramInt2, paramInt3, paramObject, paramBoolean);
  }
  
  public void reInitFocus()
  {
    BNRouteDetail.getInstance().initFocus(this.mLeftArea, this.mRightArea, true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/wrapper/BNRouteDetailActivityWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */