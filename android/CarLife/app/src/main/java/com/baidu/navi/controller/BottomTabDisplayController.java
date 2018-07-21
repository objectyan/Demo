package com.baidu.navi.controller;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.presentation.a.f;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.util.w;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.ISDKNaviStatusListener;

public class BottomTabDisplayController
{
  private static final int DELAY_HIDE_TIME = 10000;
  private static final int MSG_HIDE_BOTTOM_TAB = 100;
  private static final int MSG_SHOW_BOTTOM_TAB = 200;
  private static BottomTabDisplayController mInstance;
  private static boolean mIsFunctionOn = true;
  private BottomTabHandler mBottomTabHandler = new BottomTabHandler(null);
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while (!BottomTabDisplayController.this.isHideViable());
        BottomTabDisplayController.this.hideTab();
        return;
      } while (!BottomTabDisplayController.this.isShowViable());
      BottomTabDisplayController.this.showTab();
    }
  };
  private ISDKNaviStatusListener mISDKNaviStatusListener = new MySDKNaviStatusListener();
  private boolean mIsDebugLogOn = false;
  private int mPanelShowNum = 0;
  private Object mPanelShowNumLock = new Object();
  
  public static BottomTabDisplayController getInstance()
  {
    if (mInstance == null) {
      mInstance = new BottomTabDisplayController();
    }
    return mInstance;
  }
  
  private void hideTab()
  {
    if (!mIsFunctionOn) {
      return;
    }
    g.a().b().setBottomBarStatus(false);
  }
  
  private boolean isHideViable()
  {
    if (h.a().getCurrentFragmentType() != 113) {}
    while (isPanelShowing().booleanValue()) {
      return false;
    }
    return true;
  }
  
  private Boolean isPanelShowing()
  {
    return Boolean.valueOf(false);
  }
  
  private boolean isShowViable()
  {
    return true;
  }
  
  private void removeSDKNaviStatusListener()
  {
    BNavigator.getInstance().removeSDKNaviStatusListener();
  }
  
  private void setPanelStatus(Boolean paramBoolean)
  {
    synchronized (this.mPanelShowNumLock)
    {
      if (paramBoolean.booleanValue())
      {
        this.mPanelShowNum += 1;
        if (this.mPanelShowNum < 0) {
          this.mPanelShowNum = 0;
        }
        return;
      }
      this.mPanelShowNum -= 1;
    }
  }
  
  private void setSDKNaviStatusListener()
  {
    BNavigator.getInstance().addSDKNaviStatusListener(this.mISDKNaviStatusListener);
  }
  
  private void showTab()
  {
    if (!mIsFunctionOn) {
      return;
    }
    g.a().b().setBottomBarStatus(true);
  }
  
  public void delayHide()
  {
    if (!isHideViable()) {
      return;
    }
    this.mHandler.removeMessages(100);
    this.mHandler.sendEmptyMessageDelayed(100, 10000L);
  }
  
  public void onNaviRGFragmentInvisiable()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      k.b(this.mBottomTabHandler);
    }
    int i = h.a().getNextFragmentType();
    if (h.a().g(i)) {
      return;
    }
    show();
  }
  
  public void onNaviRGFragmentVisiable()
  {
    delayHide();
    setSDKNaviStatusListener();
    if (Build.VERSION.SDK_INT >= 21) {
      k.a(this.mBottomTabHandler);
    }
  }
  
  public void panelHide()
  {
    setPanelStatus(Boolean.valueOf(false));
    delayHide();
  }
  
  public void panelShow()
  {
    setPanelStatus(Boolean.valueOf(true));
  }
  
  public void show()
  {
    if (!isShowViable()) {
      return;
    }
    this.mHandler.removeMessages(100);
    this.mHandler.sendEmptyMessage(200);
  }
  
  public void showThenDelayDismiss()
  {
    show();
    delayHide();
  }
  
  private class BottomTabHandler
    extends j
  {
    private BottomTabHandler() {}
    
    public void careAbout()
    {
      addMsg(1004);
      addMsg(1002);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1004) {
        BottomTabDisplayController.this.delayHide();
      }
      if (paramMessage.what == 1002) {
        BottomTabDisplayController.this.delayHide();
      }
    }
  }
  
  class MySDKNaviStatusListener
    implements ISDKNaviStatusListener
  {
    MySDKNaviStatusListener() {}
    
    public void onBridgeSwitchClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onBridgeSwitchGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onEmptyPoiClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onEmptyPoiGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onEnlargeRoadMapViewHide()
    {
      if (BottomTabDisplayController.this.mIsDebugLogOn) {
        w.a("onEnlargeRoadMapViewHide", 0);
      }
      BottomTabDisplayController.this.panelHide();
    }
    
    public void onEnlargeRoadMapViewShow()
    {
      if (BottomTabDisplayController.this.mIsDebugLogOn) {
        w.a("onEnlargeRoadMapViewShow", 0);
      }
      BottomTabDisplayController.this.panelShow();
    }
    
    public void onFocusMoreMenu()
    {
      BottomTabDisplayController.this.showThenDelayDismiss();
    }
    
    public void onFocusMoreMenuGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onFullOrResumeGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onFullViewBtnClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onLocationBtnClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onLocationGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onMASwitchClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onMASwitchGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onMainAuxiliaryHide()
    {
      if (BottomTabDisplayController.this.mIsDebugLogOn) {
        w.a("onMainAuxiliaryHide");
      }
      BottomTabDisplayController.this.panelHide();
    }
    
    public void onMainAuxiliaryShow()
    {
      if (BottomTabDisplayController.this.mIsDebugLogOn) {
        w.a("onMainAuxiliaryShow");
      }
      BottomTabDisplayController.this.panelShow();
    }
    
    public void onMoreMenuClick()
    {
      if (BottomTabDisplayController.this.mIsDebugLogOn) {
        w.a("onMoreMenuClick", 0);
      }
    }
    
    public void onNaviLeftPanelTouch()
    {
      BottomTabDisplayController.this.showThenDelayDismiss();
    }
    
    public void onQuitGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onReRouteComplete()
    {
      if (BottomTabDisplayController.this.mIsDebugLogOn) {
        w.a("onReRouteComplete");
      }
      BottomTabDisplayController.this.panelHide();
    }
    
    public void onResumeBtnClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onResumeNavigatorClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onResumeNavigatorGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onRoutePlanYawing()
    {
      if (BottomTabDisplayController.this.mIsDebugLogOn) {
        w.a("onRoutePlanYawing");
      }
      BottomTabDisplayController.this.panelShow();
    }
    
    public void onRouteSwitchClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onRouteSwitchGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onSetingBtnClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onSetingGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onViaPointBtnClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onViaPointGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onZoomInBtnClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onZoomInGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onZoomOutBtnClick()
    {
      BottomTabDisplayController.this.delayHide();
    }
    
    public void onZoomOutGetFocus()
    {
      BottomTabDisplayController.this.delayHide();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/BottomTabDisplayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */