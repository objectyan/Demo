package com.baidu.navisdk.debug;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

public class BNEyeSpyPaperFloatButton
{
  private static final String TAG = BNEyeSpyPaperFloatButton.class.getSimpleName();
  private boolean isMoved = false;
  private boolean isShowing = false;
  private float mDownX = 0.0F;
  private float mDownY = 0.0F;
  private LinearLayout mFloatLayout;
  private int mTouchSlop;
  private WindowManager mWindowManager;
  private float mXInFloatView;
  private float mXInScreen;
  private float mYInFloatView;
  private float mYInScreen;
  private WindowManager.LayoutParams wmParams;
  
  public BNEyeSpyPaperFloatButton()
  {
    initWindowsManger();
    initViews();
    this.mTouchSlop = ViewConfiguration.get(BNaviModuleManager.getActivity()).getScaledTouchSlop();
  }
  
  private boolean handleMotionEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        this.mXInFloatView = paramMotionEvent.getX();
        this.mYInFloatView = paramMotionEvent.getY();
        this.mDownX = paramMotionEvent.getRawX();
        this.mDownY = paramMotionEvent.getRawY();
        this.isMoved = false;
        return false;
        this.mXInScreen = paramMotionEvent.getRawX();
        this.mYInScreen = (paramMotionEvent.getRawY() - ScreenUtil.getInstance().getStatusBarHeight());
        if ((Math.abs(this.mDownX - paramMotionEvent.getRawX()) > this.mTouchSlop) || (Math.abs(this.mDownY - paramMotionEvent.getRawY()) > this.mTouchSlop)) {
          this.isMoved = true;
        }
      } while (!this.isMoved);
      updateViewPosition();
      return false;
    }
    updateViewPosition();
    return this.isMoved;
  }
  
  private void initViews()
  {
    this.mFloatLayout = new LinearLayout(BNaviModuleManager.getActivity());
    TextView localTextView = new TextView(BNaviModuleManager.getActivity());
    localTextView.setTextSize(1, 20.0F);
    localTextView.setText("报bug");
    this.mFloatLayout.addView(localTextView);
    this.mFloatLayout.setOrientation(0);
    this.mFloatLayout.setGravity(17);
    this.mFloatLayout.setBackgroundColor(-65536);
    this.mFloatLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {
          return;
        }
        BNEyeSpyPaperController.getInstance().showUserKeyLogDialog();
      }
    });
  }
  
  private void initWindowsManger()
  {
    this.wmParams = new WindowManager.LayoutParams();
    this.mWindowManager = ((WindowManager)BNaviModuleManager.getActivity().getSystemService("window"));
    this.wmParams.type = 2;
    this.wmParams.format = 1;
    this.wmParams.flags = 8;
    this.wmParams.gravity = 51;
    this.wmParams.width = ScreenUtil.getInstance().dip2px(69);
    this.wmParams.height = ScreenUtil.getInstance().dip2px(30);
  }
  
  private void updateViewPosition()
  {
    this.wmParams.x = ((int)(this.mXInScreen - this.mXInFloatView));
    this.wmParams.y = ((int)(this.mYInScreen - this.mYInFloatView));
    try
    {
      this.mWindowManager.updateViewLayout(this.mFloatLayout, this.wmParams);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dispose()
  {
    this.isShowing = false;
    if (this.mFloatLayout != null) {
      this.mWindowManager.removeView(this.mFloatLayout);
    }
  }
  
  public void hide()
  {
    LogUtil.e(TAG, "hide");
    try
    {
      if ((this.mFloatLayout != null) && (this.mFloatLayout.getParent() != null)) {
        this.mWindowManager.removeView(this.mFloatLayout);
      }
      this.isShowing = false;
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "hide float excetion e:" + localException.getMessage());
    }
  }
  
  public boolean isShow()
  {
    return this.isShowing;
  }
  
  public boolean show()
  {
    LogUtil.e(TAG, "show :" + isShow());
    if (isShow()) {
      return true;
    }
    try
    {
      this.mFloatLayout.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return BNEyeSpyPaperFloatButton.this.handleMotionEvent(paramAnonymousMotionEvent);
        }
      });
      this.mWindowManager.addView(this.mFloatLayout, this.wmParams);
      this.isShowing = true;
      return true;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "float excetion e:" + localException.getMessage());
      this.isShowing = false;
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/debug/BNEyeSpyPaperFloatButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */