package com.baidu.navi.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.ImageView;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;

public class ZoomButtonView
{
  private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
  private AutoHandler mAutoHandler = new AutoHandler(this, null);
  private Context mContext;
  private boolean mDayStyle;
  private OnZoomBtnClickListener mListener;
  private View.OnClickListener mZoomBtnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ZoomButtonView.this.mAutoHandler.removeMessages(8);
      if (paramAnonymousView == ZoomButtonView.this.mZoomInBtnView) {
        ZoomButtonView.this.handleZoomIn();
      }
      while (paramAnonymousView != ZoomButtonView.this.mZoomOutBtnView) {
        return;
      }
      ZoomButtonView.this.handleZoomOut();
    }
  };
  private View.OnTouchListener mZoomBtnTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if ((paramAnonymousView == ZoomButtonView.this.mZoomInBtnView) || (paramAnonymousView == ZoomButtonView.this.mZoomOutBtnView)) {
        ZoomButtonView.this.mAutoHandler.removeMessages(8);
      }
      return false;
    }
  };
  private View mZoomDirver = null;
  private ImageView mZoomInBtnView = null;
  private boolean mZoomInEnabled;
  private ImageView mZoomOutBtnView = null;
  private boolean mZoomOutEnabled;
  private View mZoomPanelView = null;
  
  private void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    hide();
  }
  
  private void updateStyle()
  {
    if ((this.mZoomInBtnView == null) || (this.mZoomOutBtnView == null) || ((this.mZoomPanelView == null) && (this.mZoomDirver == null))) {
      return;
    }
    View localView = this.mZoomDirver;
    int i;
    if (this.mDayStyle)
    {
      i = 14277081;
      localView.setBackgroundColor(i);
      this.mZoomPanelView.setBackground(StyleManager.getDrawable(2130838848, this.mDayStyle));
      this.mZoomInBtnView.setBackground(StyleManager.getDrawable(2130838413, this.mDayStyle));
      this.mZoomOutBtnView.setBackground(StyleManager.getDrawable(2130838415, this.mDayStyle));
      if (!this.mZoomInEnabled) {
        break label183;
      }
      this.mZoomInBtnView.setImageResource(2130838882);
      label113:
      if (!this.mZoomOutEnabled) {
        break label195;
      }
      this.mZoomOutBtnView.setImageResource(2130838887);
      label129:
      if ((this.mZoomInEnabled) || (!this.mZoomInBtnView.isFocused())) {
        break label207;
      }
      this.mZoomOutBtnView.requestFocus();
    }
    for (;;)
    {
      this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
      this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
      return;
      i = -13814976;
      break;
      label183:
      this.mZoomInBtnView.setImageResource(2130838883);
      break label113;
      label195:
      this.mZoomOutBtnView.setImageResource(2130838888);
      break label129;
      label207:
      if ((!this.mZoomOutEnabled) && (this.mZoomOutBtnView.isFocused())) {
        this.mZoomInBtnView.requestFocus();
      }
    }
  }
  
  public View getZoomInBtnView()
  {
    return this.mZoomInBtnView;
  }
  
  public View getZoomOutBtnView()
  {
    return this.mZoomOutBtnView;
  }
  
  public void handleZoomIn()
  {
    int i = BNMapController.getInstance().getZoomLevel();
    MapViewFactory.getInstance().getMapView().setZoomLevel(i + 1);
    if (this.mListener != null) {
      this.mListener.onZoomInBtnClick();
    }
  }
  
  public void handleZoomOut()
  {
    int i = BNMapController.getInstance().getZoomLevel();
    MapViewFactory.getInstance().getMapView().setZoomLevel(i - 1);
    if (this.mListener != null) {
      this.mListener.onZoomOutBtnClick();
    }
  }
  
  public void hide()
  {
    this.mZoomPanelView.setVisibility(8);
  }
  
  public void initView(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.mZoomDirver = paramView.findViewById(2131624958);
    this.mZoomPanelView = paramView.findViewById(2131624957);
    this.mZoomInBtnView = ((ImageView)paramView.findViewById(2131624950));
    this.mZoomOutBtnView = ((ImageView)paramView.findViewById(2131624959));
    this.mZoomInBtnView.setOnClickListener(this.mZoomBtnClickListener);
    this.mZoomOutBtnView.setOnClickListener(this.mZoomBtnClickListener);
    this.mZoomInBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    this.mZoomOutBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    this.mDayStyle = true;
    this.mZoomInEnabled = true;
    this.mZoomOutEnabled = true;
  }
  
  public void initView(Context paramContext, View paramView, boolean paramBoolean)
  {
    initView(paramContext, paramView);
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    this.mDayStyle = paramBoolean;
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
  
  public void updateZoomBtn(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mZoomInEnabled = paramBoolean1;
    this.mZoomOutEnabled = paramBoolean2;
    updateStyle();
  }
  
  private static class AutoHandler
    extends Handler
  {
    private ZoomButtonView mView;
    
    private AutoHandler(ZoomButtonView paramZoomButtonView)
    {
      this.mView = paramZoomButtonView;
    }
    
    public void handleMessage(Message paramMessage)
    {
      this.mView.handleMessage(paramMessage);
    }
  }
  
  public static abstract interface OnZoomBtnClickListener
  {
    public abstract void onZoomInBtnClick();
    
    public abstract void onZoomOutBtnClick();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/ZoomButtonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */