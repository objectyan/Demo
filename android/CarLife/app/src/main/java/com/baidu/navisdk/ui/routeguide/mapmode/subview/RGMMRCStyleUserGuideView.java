package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseOrientationView;
import com.baidu.navisdk.util.common.ScreenUtil;

public class RGMMRCStyleUserGuideView
  extends BNBaseOrientationView
  implements View.OnClickListener
{
  private boolean isMiniMapSelected = true;
  private View mConfirmTv = null;
  private TextView mMiniMapTv = null;
  private TextView mRoadBarTv = null;
  
  public RGMMRCStyleUserGuideView(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  public RGMMRCStyleUserGuideView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
  }
  
  public ViewGroup.LayoutParams generalLayoutParams()
  {
    int i;
    if (this.mCurOrientation == 1)
    {
      i = ScreenUtil.getInstance().dip2px(130);
      int j = ScreenUtil.getInstance().dip2px(80);
      this.mRootView.setPadding(0, i, 0, j);
    }
    for (;;)
    {
      return new RelativeLayout.LayoutParams(-1, -1);
      i = ScreenUtil.getInstance().dip2px(20);
      this.mRootView.setPadding(0, 0, 0, i);
    }
  }
  
  public int getContainerViewId()
  {
    return 1711866554;
  }
  
  public int getLandscapeLayoutId()
  {
    return 1711472734;
  }
  
  public int getPortraitLayoutId()
  {
    return 1711472734;
  }
  
  public void hide()
  {
    if (isVisibility()) {
      RGViewController.getInstance().updateToolBoxItem(6);
    }
    super.hide();
    if (this.isMiniMapSelected) {
      BNSettingManager.setIsShowMapSwitch(0);
    }
    for (;;)
    {
      RGViewController.getInstance().showAssistMapSwitch();
      return;
      BNSettingManager.setIsShowMapSwitch(1);
    }
  }
  
  public void initListener()
  {
    this.mMiniMapTv.setOnClickListener(this);
    this.mRoadBarTv.setOnClickListener(this);
    this.mConfirmTv.setOnClickListener(this);
    this.mRootView.setOnClickListener(this);
  }
  
  public void initViewById()
  {
    this.mMiniMapTv = ((TextView)this.mRootView.findViewById(1711866911));
    this.mRoadBarTv = ((TextView)this.mRootView.findViewById(1711866912));
    this.mConfirmTv = this.mRootView.findViewById(1711866913);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 1711866911: 
      this.isMiniMapSelected = true;
      this.mMiniMapTv.setCompoundDrawablesWithIntrinsicBounds(BNStyleManager.getDrawable(1711407776), null, null, null);
      this.mRoadBarTv.setCompoundDrawablesWithIntrinsicBounds(BNStyleManager.getDrawable(1711407775), null, null, null);
      BNSettingManager.setIsShowMapSwitch(0);
      return;
    case 1711866912: 
      this.isMiniMapSelected = false;
      this.mMiniMapTv.setCompoundDrawablesWithIntrinsicBounds(BNStyleManager.getDrawable(1711407775), null, null, null);
      this.mRoadBarTv.setCompoundDrawablesWithIntrinsicBounds(BNStyleManager.getDrawable(1711407776), null, null, null);
      BNSettingManager.setIsShowMapSwitch(1);
      return;
    }
    hide();
  }
  
  public void updateDataByLast() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMRCStyleUserGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */