package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.BNavigator.NavUserBehaviourCallback;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView.UgcRCEventCallback;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class BNRCEventDetailsMenuView
  extends BNBaseView
{
  public static boolean isViewShow = false;
  private ViewGroup mMenuViewContainer = null;
  private View mMenuViewPanel = null;
  private View mRCEventDetailsView = null;
  private BNRCEventDetailsView.UgcRCEventCallback mUgcRCEventCallback = new BNRCEventDetailsView.UgcRCEventCallback()
  {
    public void onFinish()
    {
      RGMapModeViewController.getInstance().onBNRCEventClear();
      BNRCEventDetailsMenuView.this.hide();
    }
    
    public void onShowUserINfo(String paramAnonymousString) {}
  };
  
  public BNRCEventDetailsMenuView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener, String paramString)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews(paramContext, paramString);
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  private void initViews(Context paramContext, String paramString)
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    this.mMenuViewPanel = this.mRootViewGroup.findViewById(1711866536);
    this.mMenuViewContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866537));
    if (this.mMenuViewContainer != null) {
      this.mMenuViewContainer.removeAllViews();
    }
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
    }
    for (;;)
    {
      if (BNavigator.getInstance().getmNavUserBehaviourCallback() != null) {
        BNavigator.getInstance().getmNavUserBehaviourCallback().registerLoadingProxy();
      }
      this.mRCEventDetailsView = BNRCEventDetailsViewController.getInstance().getView(paramContext, paramString, BNaviModuleManager.getBduss(), this.mUgcRCEventCallback, RGViewController.getInstance().getOrientation());
      UserOPController.getInstance().add("3.u.2", "2", null, null);
      if ((this.mMenuViewContainer == null) || (this.mRCEventDetailsView == null)) {
        break;
      }
      this.mMenuViewContainer.removeAllViews();
      paramContext = new FrameLayout.LayoutParams(-1, -1);
      this.mMenuViewContainer.addView(this.mRCEventDetailsView, paramContext);
      return;
      if (this.mMenuViewContainer != null) {
        this.mMenuViewContainer.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        });
      }
    }
  }
  
  public void hide()
  {
    super.hide();
    isViewShow = false;
    if (this.mMenuViewContainer != null) {
      this.mMenuViewContainer.setVisibility(8);
    }
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setVisibility(8);
    }
  }
  
  public boolean onBackPress()
  {
    return BNRCEventDetailsViewController.getInstance().onBackPressed();
  }
  
  public void onDestroy()
  {
    BNRCEventDetailsViewController.getInstance().onDestroy();
    if (BNavigator.getInstance().getmNavUserBehaviourCallback() != null) {
      BNavigator.getInstance().getmNavUserBehaviourCallback().unRegisterLoadingProxy();
    }
  }
  
  public void show()
  {
    super.show();
    isViewShow = true;
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setVisibility(0);
    }
    if (this.mMenuViewContainer != null) {
      this.mMenuViewContainer.setVisibility(0);
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/BNRCEventDetailsMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */