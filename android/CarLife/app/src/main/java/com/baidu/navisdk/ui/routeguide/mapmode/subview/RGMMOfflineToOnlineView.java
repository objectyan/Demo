package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGMMOfflineToOnlineView
  extends BNBaseView
{
  private static String TAG = RGMMOfflineToOnlineView.class.getName();
  private ViewGroup mOfflineToOnlineContainer = null;
  private View mOfflineToOnlineView = null;
  private TextView mReCalBtn;
  private Handler mhander = new Handler();
  
  public RGMMOfflineToOnlineView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
  }
  
  private void initListener()
  {
    if (this.mOfflineToOnlineContainer != null) {
      this.mOfflineToOnlineContainer.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
    }
    if (this.mReCalBtn != null) {
      this.mReCalBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick()) {
            return;
          }
          UserOPController.getInstance().add("3.w.1", "1", null, null);
          if (NetworkUtils.isNetworkAvailable(RGMMOfflineToOnlineView.this.mContext))
          {
            RGViewController.getInstance().showAvoidTrafficLoading("在线重算中...");
            BNRouteGuider.getInstance().calcOtherRoute(2, 2);
            return;
          }
          TipTool.onCreateToastDialog(RGMMOfflineToOnlineView.this.mContext, JarUtils.getResources().getString(1711669518));
        }
      });
    }
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {}
    do
    {
      do
      {
        return;
        LogUtil.e(TAG, "initViews() in");
        this.mOfflineToOnlineContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866430));
      } while (this.mOfflineToOnlineContainer == null);
      LogUtil.e(TAG, "initViews() create");
      this.mOfflineToOnlineContainer.removeAllViews();
      this.mOfflineToOnlineView = JarUtils.inflate((Activity)this.mContext, 1711472731, null);
    } while ((this.mOfflineToOnlineContainer == null) || (this.mOfflineToOnlineView == null));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    this.mOfflineToOnlineContainer.addView(this.mOfflineToOnlineView, localLayoutParams);
    this.mReCalBtn = ((TextView)this.mOfflineToOnlineView.findViewById(1711866891));
  }
  
  public void hide()
  {
    super.hide();
    LogUtil.e(TAG, "onHide()");
    if (this.mOfflineToOnlineContainer != null) {
      this.mOfflineToOnlineContainer.setVisibility(8);
    }
  }
  
  public void show()
  {
    super.show();
    LogUtil.e(TAG, "onShow()");
    if (this.mOfflineToOnlineContainer != null) {
      this.mOfflineToOnlineContainer.setVisibility(0);
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (this.mReCalBtn != null) {
      this.mReCalBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407799));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMOfflineToOnlineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */