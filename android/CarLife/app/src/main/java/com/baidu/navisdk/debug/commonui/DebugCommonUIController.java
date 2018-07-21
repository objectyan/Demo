package com.baidu.navisdk.debug.commonui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DebugCommonUIController
{
  public static final String DEBUG_MODULE_LOCATION = "debug_module_location";
  private static final int MSG_TIMER = 1;
  private static DebugCommonUIController sInstance = null;
  private DebugCommonUIView mCurCommonUIView = null;
  private ConcurrentMap<String, DebugCommonUIView> mDebugModuleViews = new ConcurrentHashMap();
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1)
      {
        if (DebugCommonUIController.this.mCurCommonUIView != null) {
          DebugCommonUIController.this.mCurCommonUIView.refresh();
        }
        DebugCommonUIController.this.mHandler.removeMessages(1);
        DebugCommonUIController.this.mHandler.sendEmptyMessageDelayed(1, 1000L);
      }
    }
  };
  private boolean mTimerInited = false;
  
  public static DebugCommonUIController getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new DebugCommonUIController();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void initTimer()
  {
    if (!this.mTimerInited) {
      try
      {
        if (!this.mTimerInited)
        {
          this.mTimerInited = true;
          this.mHandler.removeMessages(1);
          this.mHandler.sendEmptyMessageDelayed(1, 1000L);
        }
        return;
      }
      finally {}
    }
  }
  
  public ViewGroup getContainer()
  {
    return (ViewGroup)RGViewController.getInstance().getView();
  }
  
  public void hideUI(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.mDebugModuleViews.containsKey(paramString))
        {
          paramString = (DebugCommonUIView)this.mDebugModuleViews.get(paramString);
          paramString.hide();
          ViewGroup localViewGroup = getContainer();
          if (localViewGroup != null) {
            localViewGroup.removeView(paramString.getView());
          }
          if (this.mCurCommonUIView == paramString)
          {
            this.mCurCommonUIView = null;
            return;
          }
        }
      }
      catch (Exception paramString) {}
    }
  }
  
  public void showUI(String paramString, DebugCommonUICallback paramDebugCommonUICallback)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    try
    {
      ViewGroup localViewGroup = getContainer();
      if (this.mDebugModuleViews.containsKey(paramString)) {
        paramString = (DebugCommonUIView)this.mDebugModuleViews.get(paramString);
      }
      for (;;)
      {
        if (paramString != null)
        {
          if (this.mCurCommonUIView != null)
          {
            this.mCurCommonUIView.hide();
            if (localViewGroup != null) {
              localViewGroup.removeView(this.mCurCommonUIView.getView());
            }
          }
          this.mCurCommonUIView = paramString;
          if (paramString.getView().getParent() != null) {
            ((ViewGroup)paramString.getView().getParent()).removeView(paramString.getView());
          }
          paramString.show();
          if (localViewGroup != null)
          {
            localViewGroup.addView(paramString.getView(), new LinearLayout.LayoutParams(ScreenUtil.getInstance().dip2px(400), ScreenUtil.getInstance().dip2px(700)));
            localViewGroup.setVisibility(0);
          }
        }
        initTimer();
        return;
        paramDebugCommonUICallback = new DebugCommonUIView(paramDebugCommonUICallback);
        try
        {
          this.mDebugModuleViews.put(paramString, paramDebugCommonUICallback);
          paramString = paramDebugCommonUICallback;
        }
        catch (Exception paramString) {}
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void updateUIInfo(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    while (!this.mDebugModuleViews.containsKey(paramString1)) {
      return;
    }
    ((DebugCommonUIView)this.mDebugModuleViews.get(paramString1)).updateInfo(paramString2, false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/debug/commonui/DebugCommonUIController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */