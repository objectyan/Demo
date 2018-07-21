package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.widget.BNBaseView;

public class RGMMNotificationDebugView
  extends BNBaseView
{
  private Button mCommonHideBtn = null;
  private Button mCommonShowBtn = null;
  private View mDebugView = null;
  private Button mOperableHideBtn = null;
  private Button mOperableShowBtn = null;
  
  public RGMMNotificationDebugView(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    initViews();
    initListener();
  }
  
  private void initListener()
  {
    if (this.mCommonShowBtn != null) {
      this.mCommonShowBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RGNotificationController.getInstance().debugCommonNotification(true);
        }
      });
    }
    if (this.mCommonHideBtn != null) {
      this.mCommonHideBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RGNotificationController.getInstance().debugCommonNotification(false);
        }
      });
    }
    if (this.mOperableShowBtn != null) {
      this.mOperableShowBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RGNotificationController.getInstance().debugOperableNotification(true);
        }
      });
    }
    if (this.mOperableHideBtn != null) {
      this.mOperableHideBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RGNotificationController.getInstance().debugOperableNotification(false);
        }
      });
    }
  }
  
  private void initViews()
  {
    if ((this.mRootViewGroup == null) || (this.mContext == null)) {}
    do
    {
      return;
      if (this.mDebugView == null) {
        this.mDebugView = ((ViewStub)this.mRootViewGroup.findViewById(1711866550)).inflate();
      }
    } while (this.mDebugView == null);
    this.mCommonShowBtn = ((Button)this.mDebugView.findViewById(1711866627));
    this.mCommonHideBtn = ((Button)this.mDebugView.findViewById(1711866628));
    this.mOperableShowBtn = ((Button)this.mDebugView.findViewById(1711866629));
    this.mOperableHideBtn = ((Button)this.mDebugView.findViewById(1711866630));
  }
  
  public void hide()
  {
    super.hide();
    if (this.mDebugView != null) {
      this.mDebugView.setVisibility(8);
    }
  }
  
  public void show()
  {
    super.show();
    if (this.mDebugView != null) {
      this.mDebugView.setVisibility(0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMNotificationDebugView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */