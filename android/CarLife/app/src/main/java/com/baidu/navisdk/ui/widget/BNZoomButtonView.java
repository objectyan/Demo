package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.ImageView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class BNZoomButtonView
{
  private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
  private AutoHandler mAutoHandler = new AutoHandler(this, null);
  private Context mContext;
  private boolean mDayStyle;
  private boolean mIsFullView = true;
  private View mLineLeftView = null;
  private View mLineRightView = null;
  private OnZoomBtnClickListener mListener;
  private boolean mShowTwoBtn;
  private View.OnClickListener mZoomBtnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      BNZoomButtonView.this.mAutoHandler.removeMessages(8);
      if (paramAnonymousView == BNZoomButtonView.this.mZoomInBtnView)
      {
        UserOPController.getInstance().add("1.9");
        BNZoomButtonView.this.handleZoomIn();
      }
      do
      {
        return;
        if (paramAnonymousView == BNZoomButtonView.this.mZoomOutBtnView)
        {
          UserOPController.getInstance().add("1.a");
          BNZoomButtonView.this.handleZoomOut();
          return;
        }
      } while ((paramAnonymousView != BNZoomButtonView.this.mZoomFullViewBtnView) || (BNZoomButtonView.this.mListener == null));
      BNZoomButtonView.this.mListener.onZoomFullViewBtnClick();
    }
  };
  private View.OnTouchListener mZoomBtnTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if ((paramAnonymousView == BNZoomButtonView.this.mZoomInBtnView) || (paramAnonymousView == BNZoomButtonView.this.mZoomOutBtnView) || (paramAnonymousView == BNZoomButtonView.this.mZoomFullViewBtnView)) {
        BNZoomButtonView.this.mAutoHandler.removeMessages(8);
      }
      return false;
    }
  };
  private ImageView mZoomFullViewBtnView = null;
  private ImageView mZoomInBtnView = null;
  private boolean mZoomInEnabled;
  private ImageView mZoomOutBtnView = null;
  private boolean mZoomOutEnabled;
  private View mZoomPanelView = null;
  private boolean noNightStyle = false;
  
  private void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    hide();
  }
  
  private void initStyle()
  {
    this.mZoomInBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407470));
    this.mLineLeftView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407398));
    this.mLineLeftView.setBackgroundColor(JarUtils.getResources().getColor(1711800690));
    if (!this.mShowTwoBtn)
    {
      this.mZoomOutBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407452));
      this.mLineRightView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407398));
      this.mZoomFullViewBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407462));
      if (this.mIsFullView)
      {
        this.mZoomFullViewBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407379));
        if (!this.mZoomInEnabled) {
          break label222;
        }
        this.mZoomInBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407391));
        label141:
        if (!this.mZoomOutEnabled) {
          break label240;
        }
        this.mZoomOutBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407395));
      }
    }
    for (;;)
    {
      this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
      this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
      return;
      this.mZoomFullViewBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407377));
      break;
      this.mZoomOutBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407452));
      break;
      label222:
      this.mZoomInBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407389));
      break label141;
      label240:
      this.mZoomOutBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407393));
    }
  }
  
  private void updateStyle()
  {
    this.mZoomInBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407470));
    this.mLineLeftView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407398));
    this.mLineLeftView.setBackgroundColor(BNStyleManager.getColor(1711800690));
    if (!this.mShowTwoBtn)
    {
      this.mZoomOutBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407452));
      this.mLineRightView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407398));
      this.mZoomFullViewBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407462));
      if (this.mIsFullView)
      {
        this.mZoomFullViewBtnView.setImageDrawable(BNStyleManager.getDrawable(1711407379));
        if (!this.mZoomInEnabled) {
          break label189;
        }
        this.mZoomInBtnView.setImageDrawable(BNStyleManager.getDrawable(1711407391));
        label117:
        if (!this.mZoomOutEnabled) {
          break label204;
        }
        this.mZoomOutBtnView.setImageDrawable(BNStyleManager.getDrawable(1711407395));
      }
    }
    for (;;)
    {
      this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
      this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
      return;
      this.mZoomFullViewBtnView.setImageDrawable(BNStyleManager.getDrawable(1711407377));
      break;
      this.mZoomOutBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407452));
      break;
      label189:
      this.mZoomInBtnView.setImageDrawable(BNStyleManager.getDrawable(1711407389));
      break label117;
      label204:
      this.mZoomOutBtnView.setImageDrawable(BNStyleManager.getDrawable(1711407393));
    }
  }
  
  private void updateZoomBtnVisibility()
  {
    if (this.mShowTwoBtn)
    {
      this.mZoomFullViewBtnView.setVisibility(8);
      this.mLineRightView.setVisibility(8);
      return;
    }
    this.mZoomFullViewBtnView.setVisibility(0);
    this.mLineRightView.setVisibility(0);
  }
  
  public void handleZoomIn()
  {
    BNMapController.getInstance().zoomIn();
    if (this.mListener != null) {
      this.mListener.onZoomInBtnClick();
    }
    updateFullViewState(false);
  }
  
  public void handleZoomOut()
  {
    BNMapController.getInstance().zoomOut();
    if (this.mListener != null) {
      this.mListener.onZoomOutBtnClick();
    }
    updateFullViewState(false);
  }
  
  public void hide()
  {
    this.mZoomPanelView.setVisibility(8);
  }
  
  public void initView(Context paramContext, View paramView, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mZoomPanelView = paramView.findViewById(1711866169);
    this.mZoomInBtnView = ((ImageView)paramView.findViewById(1711866170));
    this.mZoomOutBtnView = ((ImageView)paramView.findViewById(1711866172));
    this.mZoomFullViewBtnView = ((ImageView)paramView.findViewById(1711866174));
    this.mLineLeftView = paramView.findViewById(1711865958);
    this.mLineRightView = paramView.findViewById(1711867037);
    this.mZoomInBtnView.setOnClickListener(this.mZoomBtnClickListener);
    this.mZoomOutBtnView.setOnClickListener(this.mZoomBtnClickListener);
    this.mZoomFullViewBtnView.setOnClickListener(this.mZoomBtnClickListener);
    this.mZoomInBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    this.mZoomOutBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    this.mZoomFullViewBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    this.mDayStyle = true;
    this.mZoomInEnabled = true;
    this.mZoomOutEnabled = true;
    setTwoBtnMode(paramBoolean);
  }
  
  public boolean isFullView()
  {
    return this.mIsFullView;
  }
  
  public boolean isNoNightStyle()
  {
    return this.noNightStyle;
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    this.mDayStyle = paramBoolean;
    if (this.noNightStyle)
    {
      initStyle();
      return;
    }
    updateStyle();
  }
  
  public void setNoNightStyle(boolean paramBoolean)
  {
    this.noNightStyle = paramBoolean;
  }
  
  public void setTwoBtnMode(boolean paramBoolean)
  {
    this.mShowTwoBtn = paramBoolean;
    updateZoomBtnVisibility();
    if (this.noNightStyle)
    {
      initStyle();
      return;
    }
    updateStyle();
  }
  
  public void setZoomBtnClickListener(OnZoomBtnClickListener paramOnZoomBtnClickListener)
  {
    this.mListener = paramOnZoomBtnClickListener;
  }
  
  public void show()
  {
    this.mZoomPanelView.setVisibility(0);
    this.mZoomInBtnView.getParent().requestTransparentRegion(this.mZoomInBtnView);
  }
  
  public void updateFullViewState(boolean paramBoolean)
  {
    LogUtil.e("jzc", "onZoomFullViewBtnClick FullView=" + paramBoolean);
    this.mIsFullView = paramBoolean;
    this.mIsFullView = paramBoolean;
    if (paramBoolean)
    {
      this.mZoomFullViewBtnView.setImageDrawable(BNStyleManager.getDrawable(1711407379));
      return;
    }
    this.mZoomFullViewBtnView.setImageDrawable(BNStyleManager.getDrawable(1711407377));
  }
  
  public void updateZoomBtn(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mZoomInEnabled = paramBoolean1;
    this.mZoomOutEnabled = paramBoolean2;
    if (this.noNightStyle)
    {
      initStyle();
      return;
    }
    updateStyle();
  }
  
  private static class AutoHandler
    extends Handler
  {
    private BNZoomButtonView mView;
    
    private AutoHandler(BNZoomButtonView paramBNZoomButtonView)
    {
      this.mView = paramBNZoomButtonView;
    }
    
    public void handleMessage(Message paramMessage)
    {
      this.mView.handleMessage(paramMessage);
    }
  }
  
  public static abstract interface OnZoomBtnClickListener
  {
    public abstract void onZoomFullViewBtnClick();
    
    public abstract void onZoomInBtnClick();
    
    public abstract void onZoomOutBtnClick();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNZoomButtonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */