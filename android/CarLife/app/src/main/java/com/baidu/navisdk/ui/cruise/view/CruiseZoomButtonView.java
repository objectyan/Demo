package com.baidu.navisdk.ui.cruise.view;

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

public class CruiseZoomButtonView
{
  private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
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
  private Context mContext;
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
  
  public CruiseZoomButtonView(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.mZoomDirver = paramView.findViewById(1711865968);
    this.mZoomPanelView = paramView.findViewById(1711865956);
    this.mZoomInBtnView = ((ImageView)paramView.findViewById(1711865957));
    this.mZoomOutBtnView = ((ImageView)paramView.findViewById(1711865959));
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
      this.mZoomInBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407303));
      return;
    }
    this.mZoomInBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407304));
  }
  
  private void zoomOutEnabled(boolean paramBoolean)
  {
    this.mZoomOutButtonEnable = paramBoolean;
    if (paramBoolean)
    {
      this.mZoomOutBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407307));
      return;
    }
    this.mZoomOutBtnView.setImageDrawable(JarUtils.getResources().getDrawable(1711407308));
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
    if ((this.mZoomInBtnView == null) || (this.mZoomOutBtnView == null) || ((this.mZoomPanelView == null) && (this.mZoomDirver == null))) {
      return;
    }
    View localView = this.mZoomDirver;
    if (this.mDayStyle) {}
    for (int i = 14277081;; i = -13814976)
    {
      localView.setBackgroundColor(i);
      this.mZoomPanelView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407289));
      this.mZoomInBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407202));
      this.mZoomOutBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407204));
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/view/CruiseZoomButtonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */