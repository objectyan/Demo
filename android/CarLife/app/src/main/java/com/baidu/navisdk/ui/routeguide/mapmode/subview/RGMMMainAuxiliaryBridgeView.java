package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGMMMainAuxiliaryBridgeView
  extends BNBaseView
{
  public static final int MAB_VIEW_TYPE_ALL_DISMISS = 0;
  public static final int MAB_VIEW_TYPE_AUXILIARY_ROAD = 2;
  public static final int MAB_VIEW_TYPE_MAIN_ROAD = 1;
  public static final int MAB_VIEW_TYPE_ON_BRIDGE = 4;
  public static final int MAB_VIEW_TYPE_ON_BRIDGE_AUXILIARY_ROAD = 6;
  public static final int MAB_VIEW_TYPE_ON_BRIDGE_MAIN_ROAD = 5;
  public static final int MAB_VIEW_TYPE_UNDER_BRIDGE = 8;
  public static final int MAB_VIEW_TYPE_UNDER_BRIDGE_AUXILIARY_ROAD = 10;
  private static final String TAG = "RGMMMainAuxiliaryBridgeView";
  private boolean isBothShow = false;
  private boolean isBtnClicked = false;
  private View mBridgeRoadLinear = null;
  private int mCurrentType = -1;
  private ImageView mIVBridgeSwitch = null;
  private ImageView mIVMASwitch = null;
  private View mMainRoadViewLinear = null;
  private RelativeLayout mRLBridgeSwitch = null;
  private RelativeLayout mRLMASwitch = null;
  private TextView mTVBridgeSwitch = null;
  private TextView mTVMASwitch = null;
  
  public RGMMMainAuxiliaryBridgeView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initView();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
  }
  
  private int getClickedTypeByShowType(int paramInt1, int paramInt2)
  {
    int j = -1;
    int i = j;
    if (paramInt2 == this.mRLMASwitch.getId())
    {
      i = j;
      switch (paramInt1)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if (paramInt2 == this.mRLBridgeSwitch.getId()) {}
      switch (paramInt1)
      {
      case 7: 
      case 8: 
      case 9: 
      default: 
        return i;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 2;
      }
    }
    return 4;
    return 4;
    return 8;
  }
  
  private void initListener()
  {
    if ((this.mRLMASwitch == null) || (this.mRLBridgeSwitch == null))
    {
      LogUtil.e("RGMMMainAuxiliaryBridgeView", "initListener mRLMASwitch mRLBridgeSwitch is null");
      return;
    }
    this.mRLMASwitch.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (RGMMMainAuxiliaryBridgeView.this.mSubViewListener == null)
        {
          LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLMASwitch mSubViewListener == null");
          return;
        }
        if (ForbidDaulClickUtils.isFastDoubleClick())
        {
          LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLMASwitch isFastDoubleClick");
          return;
        }
        int i;
        if (RGMMMainAuxiliaryBridgeView.this.isBothShow)
        {
          i = RGMMMainAuxiliaryBridgeView.this.getClickedTypeByShowType(RGMMMainAuxiliaryBridgeView.this.mCurrentType, RGMMMainAuxiliaryBridgeView.this.mRLMASwitch.getId());
          LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLMASwitch isBothShow clickedType = " + i + ", mCurrentType = " + RGMMMainAuxiliaryBridgeView.this.mCurrentType);
          if (i == 1)
          {
            UserOPController.getInstance().add("3.v.1", "2", null, null);
            if ((RGMMMainAuxiliaryBridgeView.this.mSubViewListener != null) && (i != -1)) {
              RGMMMainAuxiliaryBridgeView.this.mSubViewListener.onOnlineMainAuxiliarySwitch(i);
            }
          }
        }
        label297:
        for (;;)
        {
          RGMMMainAuxiliaryBridgeView.access$902(RGMMMainAuxiliaryBridgeView.this, true);
          RGMMMainAuxiliaryBridgeView.this.hide();
          return;
          if (i != 2) {
            break;
          }
          UserOPController.getInstance().add("3.v.2", "2", null, null);
          break;
          LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLMASwitch NotBothShow mCurrentType = " + RGMMMainAuxiliaryBridgeView.this.mCurrentType);
          if (RGMMMainAuxiliaryBridgeView.this.mCurrentType == 1) {
            UserOPController.getInstance().add("3.v.1", "2", null, null);
          }
          for (;;)
          {
            if (RGMMMainAuxiliaryBridgeView.this.mSubViewListener == null) {
              break label297;
            }
            RGMMMainAuxiliaryBridgeView.this.mSubViewListener.onOnlineMainAuxiliarySwitch(RGMMMainAuxiliaryBridgeView.this.mCurrentType);
            break;
            if (RGMMMainAuxiliaryBridgeView.this.mCurrentType == 2) {
              UserOPController.getInstance().add("3.v.2", "2", null, null);
            }
          }
        }
      }
    });
    this.mRLBridgeSwitch.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (RGMMMainAuxiliaryBridgeView.this.mSubViewListener == null)
        {
          LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLBridgeSwitch mSubViewListener == null");
          return;
        }
        if (ForbidDaulClickUtils.isFastDoubleClick())
        {
          LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLBridgeSwitch isFastDoubleClick");
          return;
        }
        int i;
        if (RGMMMainAuxiliaryBridgeView.this.isBothShow)
        {
          i = RGMMMainAuxiliaryBridgeView.this.getClickedTypeByShowType(RGMMMainAuxiliaryBridgeView.this.mCurrentType, RGMMMainAuxiliaryBridgeView.this.mRLBridgeSwitch.getId());
          LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLBridgeSwitch isBothShow clickedType = " + i + ", mCurrentType = " + RGMMMainAuxiliaryBridgeView.this.mCurrentType);
          if (i == 4)
          {
            UserOPController.getInstance().add("3.v.3", "2", null, null);
            if ((RGMMMainAuxiliaryBridgeView.this.mSubViewListener != null) && (i != -1)) {
              RGMMMainAuxiliaryBridgeView.this.mSubViewListener.onOnlineMainAuxiliarySwitch(i);
            }
          }
        }
        label299:
        for (;;)
        {
          RGMMMainAuxiliaryBridgeView.access$902(RGMMMainAuxiliaryBridgeView.this, true);
          RGMMMainAuxiliaryBridgeView.this.hide();
          return;
          if (i != 8) {
            break;
          }
          UserOPController.getInstance().add("3.v.4", "2", null, null);
          break;
          LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLBridgeSwitch NotBothShow mCurrentType = " + RGMMMainAuxiliaryBridgeView.this.mCurrentType);
          if (RGMMMainAuxiliaryBridgeView.this.mCurrentType == 4) {
            UserOPController.getInstance().add("3.v.3", "2", null, null);
          }
          for (;;)
          {
            if (RGMMMainAuxiliaryBridgeView.this.mSubViewListener == null) {
              break label299;
            }
            RGMMMainAuxiliaryBridgeView.this.mSubViewListener.onOnlineMainAuxiliarySwitch(RGMMMainAuxiliaryBridgeView.this.mCurrentType);
            break;
            if (RGMMMainAuxiliaryBridgeView.this.mCurrentType == 8) {
              UserOPController.getInstance().add("3.v.4", "2", null, null);
            }
          }
        }
      }
    });
  }
  
  private void initView()
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    if (1 == RGViewController.getInstance().getOrientation()) {}
    for (this.mCurOrientation = 1;; this.mCurOrientation = 2)
    {
      this.mRLMASwitch = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866573));
      this.mIVMASwitch = ((ImageView)this.mRootViewGroup.findViewById(1711866575));
      this.mTVMASwitch = ((TextView)this.mRootViewGroup.findViewById(1711866576));
      this.mRLBridgeSwitch = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866577));
      this.mIVBridgeSwitch = ((ImageView)this.mRootViewGroup.findViewById(1711866579));
      this.mTVBridgeSwitch = ((TextView)this.mRootViewGroup.findViewById(1711866580));
      this.mMainRoadViewLinear = this.mRootViewGroup.findViewById(1711866574);
      this.mBridgeRoadLinear = this.mRootViewGroup.findViewById(1711866578);
      return;
    }
  }
  
  private void showAuxiliaryRoad()
  {
    UserOPController.getInstance().add("3.v.2", "1", null, null);
    if (this.mTVMASwitch != null) {
      this.mTVMASwitch.setText(BNStyleManager.getString(1711670060));
    }
    if (this.mIVMASwitch != null) {
      this.mIVMASwitch.setImageDrawable(BNStyleManager.getDrawable(1711407865));
    }
    showMASwitch(true);
  }
  
  private void showBridgeSwitch(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.mRLBridgeSwitch != null)
    {
      localRelativeLayout = this.mRLBridgeSwitch;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  private void showMASwitch(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.mRLMASwitch != null)
    {
      localRelativeLayout = this.mRLMASwitch;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  private void showMainRoad()
  {
    UserOPController.getInstance().add("3.v.1", "1", null, null);
    if (this.mTVMASwitch != null) {
      this.mTVMASwitch.setText(BNStyleManager.getString(1711670059));
    }
    if (this.mIVMASwitch != null) {
      this.mIVMASwitch.setImageDrawable(BNStyleManager.getDrawable(1711407867));
    }
    showMASwitch(true);
  }
  
  private void showOnBridge()
  {
    UserOPController.getInstance().add("3.v.3", "1", null, null);
    if (this.mTVBridgeSwitch != null) {
      this.mTVBridgeSwitch.setText(BNStyleManager.getString(1711670061));
    }
    if (this.mIVBridgeSwitch != null) {
      this.mIVBridgeSwitch.setImageDrawable(BNStyleManager.getDrawable(1711407869));
    }
    showBridgeSwitch(true);
  }
  
  private void showUnderBridge()
  {
    UserOPController.getInstance().add("3.v.4", "1", null, null);
    if (this.mTVBridgeSwitch != null) {
      this.mTVBridgeSwitch.setText(BNStyleManager.getString(1711670062));
    }
    if (this.mIVBridgeSwitch != null) {
      this.mIVBridgeSwitch.setImageDrawable(BNStyleManager.getDrawable(1711407871));
    }
    showBridgeSwitch(true);
  }
  
  public void dispose()
  {
    super.dispose();
    hide();
    this.isBothShow = false;
    this.mCurrentType = -1;
    resetBtnClicked();
  }
  
  public void hide()
  {
    super.hide();
    showMASwitch(false);
    showBridgeSwitch(false);
  }
  
  public boolean isBtnClicked()
  {
    return this.isBtnClicked;
  }
  
  public void onOrientationChange(int paramInt)
  {
    hide();
    updateMainAuxiliaryBridgeView(paramInt);
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    initView();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
    updateMainAuxiliaryBridgeView(this.mCurrentType);
  }
  
  public void resetBtnClicked()
  {
    this.isBtnClicked = false;
  }
  
  public void show()
  {
    hide();
    super.show();
    showMASwitch(true);
    showBridgeSwitch(true);
  }
  
  public void updateMainAuxiliaryBridgeView(int paramInt)
  {
    LogUtil.e("RGMMMainAuxiliaryBridgeView", "peng updateMABView type = " + paramInt);
    this.mCurrentType = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 7: 
    case 9: 
    default: 
      hide();
      this.isBothShow = false;
      LogUtil.e("RGMMMainAuxiliaryBridgeView", "peng enter default hide");
      return;
    case 0: 
      hide();
      this.isBothShow = false;
      return;
    case 1: 
      hide();
      showMainRoad();
      this.isBothShow = false;
      return;
    case 2: 
      hide();
      showAuxiliaryRoad();
      this.isBothShow = false;
      return;
    case 4: 
      hide();
      showOnBridge();
      this.isBothShow = false;
      return;
    case 8: 
      hide();
      showUnderBridge();
      this.isBothShow = false;
      return;
    case 5: 
      hide();
      showOnBridge();
      showMainRoad();
      this.isBothShow = true;
      return;
    case 6: 
      hide();
      showOnBridge();
      showAuxiliaryRoad();
      this.isBothShow = true;
      return;
    }
    hide();
    showUnderBridge();
    showAuxiliaryRoad();
    this.isBothShow = true;
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (this.mBridgeRoadLinear != null) {
      this.mBridgeRoadLinear.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407295));
    }
    if (this.mMainRoadViewLinear != null) {
      this.mMainRoadViewLinear.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407295));
    }
    if (this.mTVBridgeSwitch != null) {
      this.mTVBridgeSwitch.setTextColor(BNStyleManager.getColor(1711800686));
    }
    if (this.mTVMASwitch != null) {
      this.mTVMASwitch.setTextColor(BNStyleManager.getColor(1711800686));
    }
    updateMainAuxiliaryBridgeView(this.mCurrentType);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMMainAuxiliaryBridgeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */