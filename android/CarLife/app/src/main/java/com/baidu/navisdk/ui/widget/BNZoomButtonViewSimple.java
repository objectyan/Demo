package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class BNZoomButtonViewSimple
{
  private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
  private AutoHandler mAutoHandler = new AutoHandler(this, null);
  private Context mContext;
  private boolean mDayStyle;
  private boolean mIsFullView = true;
  private View mLineLeftView = null;
  private OnZoomBtnClickListener mListener;
  private boolean mShowTwoBtn;
  private View.OnClickListener mZoomBtnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      BNZoomButtonViewSimple.this.mAutoHandler.removeMessages(8);
      if (paramAnonymousView == BNZoomButtonViewSimple.this.mZoomInBtnView)
      {
        UserOPController.getInstance().add("1.9");
        BNMapController.getInstance().setDragMapStatus(true);
        BNZoomButtonViewSimple.this.handleZoomIn();
      }
      do
      {
        return;
        if (paramAnonymousView == BNZoomButtonViewSimple.this.mZoomOutBtnView)
        {
          BNMapController.getInstance().setDragMapStatus(true);
          UserOPController.getInstance().add("1.a");
          BNZoomButtonViewSimple.this.handleZoomOut();
          return;
        }
      } while ((paramAnonymousView != BNZoomButtonViewSimple.this.mZoomFullViewBtnView) || (BNZoomButtonViewSimple.this.mListener == null));
      BNZoomButtonViewSimple.this.mListener.onZoomFullViewBtnClick();
    }
  };
  private View.OnTouchListener mZoomBtnTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if ((paramAnonymousView == BNZoomButtonViewSimple.this.mZoomInBtnView) || (paramAnonymousView == BNZoomButtonViewSimple.this.mZoomOutBtnView) || (paramAnonymousView == BNZoomButtonViewSimple.this.mZoomFullViewBtnView)) {
        BNZoomButtonViewSimple.this.mAutoHandler.removeMessages(8);
      }
      return false;
    }
  };
  private View mZoomDivider = null;
  private ImageView mZoomFullViewBtnView = null;
  private RelativeLayout mZoomInBtnView = null;
  private boolean mZoomInEnabled;
  private ImageView mZoomInImageView = null;
  private RelativeLayout mZoomOutBtnView = null;
  private boolean mZoomOutEnabled;
  private ImageView mZoomOutImageView = null;
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
    float f2 = 1.0F;
    RelativeLayout localRelativeLayout;
    if ((this.mZoomInBtnView != null) && (this.mZoomOutBtnView != null))
    {
      if (RouteGuideParams.getRouteGuideMode() != 2)
      {
        this.mZoomInBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407130));
        this.mZoomOutBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407132));
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        localRelativeLayout = this.mZoomInBtnView;
        if (!this.mZoomInEnabled) {
          break label144;
        }
        f1 = 1.0F;
        localRelativeLayout.setAlpha(f1);
        localRelativeLayout = this.mZoomOutBtnView;
        if (!this.mZoomOutEnabled) {
          break label150;
        }
      }
    }
    label144:
    label150:
    for (float f1 = f2;; f1 = 0.2F)
    {
      localRelativeLayout.setAlpha(f1);
      this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
      this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
      if (this.mZoomDivider != null) {
        this.mZoomDivider.setBackgroundColor(JarUtils.getResources().getColor(1711800688));
      }
      return;
      f1 = 0.2F;
      break;
    }
  }
  
  private void updateStyle()
  {
    float f2 = 1.0F;
    Object localObject;
    float f1;
    if ((this.mZoomInBtnView != null) && (this.mZoomOutBtnView != null) && (this.mZoomInImageView != null) && (this.mZoomOutImageView != null))
    {
      if (RouteGuideParams.getRouteGuideMode() != 2)
      {
        this.mZoomInBtnView.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407130));
        this.mZoomOutBtnView.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407132));
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.mZoomInImageView;
        if (this.mZoomInEnabled)
        {
          f1 = 1.0F;
          ((ImageView)localObject).setAlpha(f1);
          localObject = this.mZoomOutImageView;
          if (!this.mZoomOutEnabled) {
            break label171;
          }
          f1 = f2;
          label105:
          ((ImageView)localObject).setAlpha(f1);
        }
      }
      else
      {
        this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
        this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
      }
    }
    else if (this.mZoomDivider != null)
    {
      localObject = this.mZoomDivider;
      if (!BNStyleManager.getDayStyle()) {
        break label177;
      }
    }
    label171:
    label177:
    for (int i = 1711800688;; i = 1711800691)
    {
      ((View)localObject).setBackgroundColor(BNStyleManager.getColor(i));
      return;
      f1 = 0.2F;
      break;
      f1 = 0.2F;
      break label105;
    }
  }
  
  private void updateZoomBtnVisibility()
  {
    if (this.mZoomFullViewBtnView != null)
    {
      if (this.mShowTwoBtn) {
        this.mZoomFullViewBtnView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.mZoomFullViewBtnView.setVisibility(0);
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
    if (this.mZoomPanelView != null) {
      this.mZoomPanelView.setVisibility(8);
    }
  }
  
  public void initView(Context paramContext, View paramView, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mZoomPanelView = paramView.findViewById(1711866169);
    this.mZoomInBtnView = ((RelativeLayout)paramView.findViewById(1711866170));
    this.mZoomInImageView = ((ImageView)paramView.findViewById(1711866171));
    this.mZoomOutBtnView = ((RelativeLayout)paramView.findViewById(1711866172));
    this.mZoomOutImageView = ((ImageView)paramView.findViewById(1711866173));
    this.mZoomFullViewBtnView = ((ImageView)paramView.findViewById(1711866174));
    this.mZoomDivider = paramView.findViewById(1711866593);
    if (this.mZoomInBtnView != null)
    {
      this.mZoomInBtnView.setOnClickListener(this.mZoomBtnClickListener);
      this.mZoomInBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    }
    if (this.mZoomOutBtnView != null)
    {
      this.mZoomOutBtnView.setOnClickListener(this.mZoomBtnClickListener);
      this.mZoomOutBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    }
    if (this.mZoomFullViewBtnView != null)
    {
      this.mZoomFullViewBtnView.setOnClickListener(this.mZoomBtnClickListener);
      this.mZoomFullViewBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    }
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
    if (this.mZoomPanelView != null) {
      this.mZoomPanelView.setVisibility(0);
    }
    if (this.mZoomInBtnView != null) {
      this.mZoomInBtnView.getParent().requestTransparentRegion(this.mZoomInBtnView);
    }
  }
  
  public void updateFullViewState(boolean paramBoolean)
  {
    LogUtil.e("jzc", "onZoomFullViewBtnClick FullView=" + paramBoolean);
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
    private BNZoomButtonViewSimple mView;
    
    private AutoHandler(BNZoomButtonViewSimple paramBNZoomButtonViewSimple)
    {
      this.mView = paramBNZoomButtonViewSimple;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNZoomButtonViewSimple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */