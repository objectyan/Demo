package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGMMMessageFloatView
{
  private static final String TAG = RGMMMessageFloatView.class.getSimpleName();
  private volatile boolean isShowing = false;
  private TextView mContentText;
  private ViewGroup mFloatLayout;
  private TextView mHideButton;
  private WindowManager mWindowManager;
  private WindowManager.LayoutParams wmParams;
  
  public RGMMMessageFloatView()
  {
    initWindowsManger();
    initViews();
  }
  
  private void initViews()
  {
    this.mFloatLayout = ((ViewGroup)JarUtils.inflate(BNaviModuleManager.getActivity(), 1711472690, null));
    this.mContentText = ((TextView)this.mFloatLayout.findViewById(1711866331));
    this.mContentText.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407509));
    this.mHideButton = ((TextView)this.mFloatLayout.findViewById(1711866332));
    this.mHideButton.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407371));
    this.mHideButton.setText(JarUtils.getResources().getString(1711669685));
    this.mHideButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RGMMMessageFloatView.this.hide();
      }
    });
  }
  
  private void initWindowsManger()
  {
    this.wmParams = new WindowManager.LayoutParams();
    this.mWindowManager = ((WindowManager)BNaviModuleManager.getActivity().getApplicationContext().getSystemService("window"));
    if (Build.VERSION.SDK_INT >= 19) {}
    for (this.wmParams.type = 2005;; this.wmParams.type = 2002)
    {
      this.wmParams.format = -3;
      this.wmParams.flags = 268435456;
      this.wmParams.gravity = 17;
      this.wmParams.x = 0;
      this.wmParams.y = 0;
      this.wmParams.width = -1;
      this.wmParams.height = -1;
      return;
    }
  }
  
  public void dispose()
  {
    hide();
  }
  
  public void hide()
  {
    this.isShowing = false;
    if ((this.mFloatLayout != null) && (this.mFloatLayout.getParent() != null)) {
      this.mWindowManager.removeView(this.mFloatLayout);
    }
  }
  
  public boolean isShow()
  {
    return this.isShowing;
  }
  
  public void setText(String paramString)
  {
    if (this.mContentText != null) {
      this.mContentText.setText(paramString);
    }
  }
  
  public boolean show()
  {
    if (isShow()) {
      return true;
    }
    try
    {
      UserOPController.getInstance().add("3.x.5");
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMMessageFloatView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */