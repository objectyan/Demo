package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGOffScreenModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMOffScreenView
  extends BNBaseView
{
  private View bgView;
  private View dividerView;
  private Handler mHandler = null;
  private TextView mOffScreenCancelView = null;
  private ViewGroup mOffScreenContainer = null;
  private TextView mOffScreenGuideTipView = null;
  private TextView mOffScreenTipView = null;
  private View mOffScreenView = null;
  
  public RGMMOffScreenView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initView();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
    createHandler();
  }
  
  private void cancelCountDown()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
    }
  }
  
  private void clearMessage()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(1);
    }
  }
  
  private void createHandler()
  {
    this.mHandler = null;
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
        case 1: 
          do
          {
            do
            {
              return;
              if (RGOffScreenModel.getInstance().mOffScreenCount > 0) {
                break;
              }
            } while (RGMMOffScreenView.this.mHandler == null);
            RGMMOffScreenView.this.mHandler.sendEmptyMessage(2);
            return;
          } while (RGMMOffScreenView.this.mHandler == null);
          RGMMOffScreenView.this.mHandler.sendEmptyMessageDelayed(1, 1000L);
          paramAnonymousMessage = RGOffScreenModel.getInstance();
          paramAnonymousMessage.mOffScreenCount -= 1;
          return;
        case 2: 
          if (BNOffScreenManager.sIsInOffScreenMode)
          {
            BNOffScreenManager.testPrint("offScreen", "MSG_STOP_COUNT, return not legal");
            return;
          }
          BNOffScreenManager.sIsBrightOffEffect = false;
          BNOffScreenManager.testPrint("offScreen", "MSG_STOP_COUNT");
          RGOffScreenModel.getInstance().isInCounting = false;
          RGViewController.getInstance().requestShowExpendView(1, false);
          return;
        }
        RGOffScreenModel.getInstance().isInCounting = false;
      }
    };
  }
  
  private void initListener()
  {
    if (this.mOffScreenGuideTipView != null) {
      this.mOffScreenGuideTipView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RGMMOffScreenView.this.clearMessage();
          RGMMOffScreenView.access$102(RGMMOffScreenView.this, null);
          RGOffScreenModel.getInstance().isInCounting = false;
          BNOffScreenManager.getInstance().offScreenAction();
          RGViewController.getInstance().requestShowExpendView(1, false);
          BNOffScreenManager.getInstance().isEnterOffScreen = true;
        }
      });
    }
    if (this.mOffScreenCancelView != null) {
      this.mOffScreenCancelView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RGMMOffScreenView.this.clearMessage();
          RGMMOffScreenView.access$102(RGMMOffScreenView.this, null);
          BNOffScreenManager.sIsBrightOffEffect = false;
          BNOffScreenManager.testPrint("offScreen", "click canele");
          BNOffScreenManager.test();
          RGOffScreenModel.getInstance().isInCounting = false;
          RGViewController.getInstance().requestShowExpendView(1, false);
        }
      });
    }
  }
  
  private void initView()
  {
    if (this.mRootViewGroup == null) {}
    do
    {
      do
      {
        return;
        this.mOffScreenContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866625));
      } while (this.mOffScreenContainer == null);
      this.mOffScreenContainer.removeAllViews();
      this.mOffScreenView = JarUtils.inflate((Activity)this.mContext, 1711472739, null);
    } while ((this.mOffScreenContainer == null) || (this.mOffScreenView == null));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.mOffScreenContainer.addView(this.mOffScreenView, localLayoutParams);
    this.bgView = this.mRootViewGroup.findViewById(1711866952);
    this.dividerView = this.mRootViewGroup.findViewById(1711866953);
    this.mOffScreenTipView = ((TextView)this.mRootViewGroup.findViewById(1711866954));
    this.mOffScreenGuideTipView = ((TextView)this.mRootViewGroup.findViewById(1711866955));
    this.mOffScreenCancelView = ((TextView)this.mRootViewGroup.findViewById(1711866956));
  }
  
  private void startCountDown()
  {
    if (RGOffScreenModel.getInstance().isCurrentLocationActive)
    {
      RGOffScreenModel.getInstance().isCurrentLocationActive = false;
      if (!RGOffScreenModel.getInstance().isInCounting) {}
    }
    else
    {
      return;
    }
    cancelCountDown();
    RGOffScreenModel.getInstance().mOffScreenCount = 5;
    createHandler();
    BNOffScreenManager.testPrint("offScreen", "start count down");
    RGOffScreenModel.getInstance().isInCounting = true;
    this.mHandler.sendEmptyMessage(1);
  }
  
  public void cleanHandler()
  {
    cancelCountDown();
    this.mHandler = null;
  }
  
  public void forceShow()
  {
    BNOffScreenManager.testPrint("offScreen", "force show");
    if (this.mOffScreenContainer != null) {
      this.mOffScreenContainer.setVisibility(0);
    }
    if (this.mOffScreenView != null) {
      this.mOffScreenView.setVisibility(0);
    }
  }
  
  public void hide()
  {
    super.hide();
    if (this.mOffScreenView != null)
    {
      this.mOffScreenContainer.setVisibility(8);
      this.mOffScreenView.setVisibility(8);
    }
  }
  
  public boolean isVisible()
  {
    return (this.mOffScreenContainer != null) && (this.mOffScreenContainer.getVisibility() == 0);
  }
  
  public void show()
  {
    if (!RGOffScreenModel.getInstance().isCurrentLocationActive) {
      return;
    }
    BNOffScreenManager.testPrint("offScreen", " rgmmoffscreen view show");
    super.show();
    if (this.mOffScreenContainer != null) {
      this.mOffScreenContainer.setVisibility(0);
    }
    if (this.mOffScreenView != null) {
      this.mOffScreenView.setVisibility(0);
    }
    startCountDown();
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (this.bgView != null) {
      this.bgView.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.dividerView != null) {
      this.dividerView.setBackgroundColor(BNStyleManager.getColor(1711800690));
    }
    if (this.mOffScreenTipView != null) {
      this.mOffScreenTipView.setTextColor(BNStyleManager.getColor(1711800674));
    }
    if (this.mOffScreenGuideTipView != null)
    {
      this.mOffScreenGuideTipView.setTextColor(BNStyleManager.getColor(1711800682));
      this.mOffScreenGuideTipView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407113));
    }
    if (this.mOffScreenCancelView != null)
    {
      this.mOffScreenCancelView.setTextColor(BNStyleManager.getColor(1711800674));
      this.mOffScreenCancelView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407148));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMOffScreenView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */