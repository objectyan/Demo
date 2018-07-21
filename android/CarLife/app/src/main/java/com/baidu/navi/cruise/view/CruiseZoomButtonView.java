package com.baidu.navi.cruise.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.ImageView;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;

public class CruiseZoomButtonView
{
  private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
  private Activity mActivity;
  private Handler mAutoHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
        CruiseZoomButtonView.this.mZoomInBtnView.setVisibility(8);
        CruiseZoomButtonView.this.mZoomOutBtnView.setVisibility(8);
      }
    }
  };
  private boolean mDayStyle = true;
  private OnZoomBtnClickListener mListener;
  private View.OnClickListener mZoomBtnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      CruiseZoomButtonView.this.mAutoHandler.removeMessages(8);
      if (paramAnonymousView == CruiseZoomButtonView.this.mZoomInBtnView)
      {
        BNMapController.getInstance().zoomIn();
        if (CruiseZoomButtonView.this.mListener != null) {
          CruiseZoomButtonView.this.mListener.onZoomInBtnClick();
        }
      }
      do
      {
        do
        {
          return;
        } while (paramAnonymousView != CruiseZoomButtonView.this.mZoomOutBtnView);
        BNMapController.getInstance().zoomOut();
      } while (CruiseZoomButtonView.this.mListener == null);
      CruiseZoomButtonView.this.mListener.onZoomOutBtnClick();
    }
  };
  private View.OnTouchListener mZoomBtnTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if ((paramAnonymousView == CruiseZoomButtonView.this.mZoomInBtnView) || (paramAnonymousView == CruiseZoomButtonView.this.mZoomOutBtnView)) {
        CruiseZoomButtonView.this.mAutoHandler.removeMessages(8);
      }
      return false;
    }
  };
  private View mZoomDirver = null;
  private ImageView mZoomInBtnView = null;
  private boolean mZoomInButtonEnable = true;
  private ImageView mZoomOutBtnView = null;
  private boolean mZoomOutButtonEnable = true;
  private View mZoomPanelView = null;
  
  public CruiseZoomButtonView(Activity paramActivity, View paramView)
  {
    this.mActivity = paramActivity;
    this.mZoomPanelView = paramView.findViewById(2131625910);
    this.mZoomInBtnView = ((ImageView)paramView.findViewById(2131625911));
    this.mZoomDirver = paramView.findViewById(2131624958);
    this.mZoomOutBtnView = ((ImageView)paramView.findViewById(2131625912));
    this.mZoomInBtnView.setOnClickListener(this.mZoomBtnClickListener);
    this.mZoomOutBtnView.setOnClickListener(this.mZoomBtnClickListener);
    this.mZoomInBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    this.mZoomOutBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
  }
  
  private void zoomInEnabled(boolean paramBoolean)
  {
    this.mZoomInButtonEnable = paramBoolean;
    if (paramBoolean)
    {
      this.mZoomInBtnView.setImageDrawable(StyleManager.getDrawable(2130838882));
      return;
    }
    this.mZoomInBtnView.setImageDrawable(StyleManager.getDrawable(2130838883));
  }
  
  private void zoomOutEnabled(boolean paramBoolean)
  {
    this.mZoomOutButtonEnable = paramBoolean;
    if (paramBoolean)
    {
      this.mZoomOutBtnView.setImageDrawable(StyleManager.getDrawable(2130838887));
      return;
    }
    this.mZoomOutBtnView.setImageDrawable(StyleManager.getDrawable(2130838888));
  }
  
  public void autoHide(long paramLong)
  {
    this.mAutoHandler.removeMessages(8);
    this.mAutoHandler.sendEmptyMessageDelayed(8, paramLong);
  }
  
  public void hide()
  {
    this.mZoomPanelView.setVisibility(8);
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    this.mDayStyle = paramBoolean;
    if ((this.mZoomInBtnView == null) || (this.mZoomOutBtnView == null) || (this.mZoomDirver == null)) {
      return;
    }
    View localView = this.mZoomDirver;
    if (this.mDayStyle) {}
    for (int i = 14277081;; i = -13814976)
    {
      localView.setBackgroundColor(i);
      this.mZoomPanelView.setBackgroundDrawable(StyleManager.getDrawable(2130838848));
      this.mZoomInBtnView.setBackgroundDrawable(StyleManager.getDrawable(2130838413));
      this.mZoomOutBtnView.setBackgroundDrawable(StyleManager.getDrawable(2130838415));
      zoomOutEnabled(this.mZoomOutButtonEnable);
      zoomInEnabled(this.mZoomInButtonEnable);
      return;
    }
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
  
  public void updateZoomButton()
  {
    int i = BNMapController.getInstance().getZoomLevel();
    LogUtil.e("CruiseMapDebug", "updateZoomButton. level = " + i);
    if (i <= 3)
    {
      zoomInEnabled(true);
      zoomOutEnabled(false);
      return;
    }
    if (i >= 20)
    {
      zoomInEnabled(false);
      zoomOutEnabled(true);
      return;
    }
    zoomInEnabled(true);
    zoomOutEnabled(true);
  }
  
  public static abstract interface OnZoomBtnClickListener
  {
    public abstract void onZoomInBtnClick();
    
    public abstract void onZoomOutBtnClick();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/cruise/view/CruiseZoomButtonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */