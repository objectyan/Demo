package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGCurRoadNameView
  extends BNBaseView
{
  private static String TAG = "RouteGuide";
  private boolean isMove = false;
  private ViewGroup mCurRoadContainer;
  private RelativeLayout mCurRoadContanerBg;
  private TextView mCurRoadNameTv;
  
  public RGCurRoadNameView(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    initView();
  }
  
  private void autoAdaptTextSize(int paramInt, String paramString)
  {
    if (this.mCurRoadNameTv != null)
    {
      this.mCurRoadNameTv.setTextSize(1, paramInt);
      if (!UIUtils.isTextFullDisplay(this.mCurRoadNameTv, JarUtils.getResources().getDimensionPixelSize(1711734806), paramString)) {
        autoAdaptTextSize(paramInt - 2, paramString);
      }
    }
  }
  
  private void initView()
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    try
    {
      this.mCurRoadContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866530));
      if (this.mCurRoadContainer != null)
      {
        if (this.mCurRoadContainer.getChildCount() > 0) {
          this.mCurRoadContainer.removeAllViews();
        }
        this.mCurRoadContanerBg = ((RelativeLayout)JarUtils.inflate((Activity)this.mContext, 1711472709, null));
        if (this.mCurRoadContanerBg != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, ScreenUtil.getInstance().dip2px(32));
          localLayoutParams.addRule(12);
          localLayoutParams.addRule(14);
          localLayoutParams.bottomMargin = ScreenUtil.getInstance().dip2px(67);
          this.mCurRoadContainer.addView(this.mCurRoadContanerBg, localLayoutParams);
          this.mCurRoadNameTv = ((TextView)this.mCurRoadContanerBg.findViewById(1711866472));
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    updateStyle(BNStyleManager.getDayStyle());
    updateRoadName(RGSimpleGuideModel.getInstance().getCurRoadName());
  }
  
  private void setDayMode()
  {
    if ((this.mCurRoadContanerBg != null) && (this.mCurRoadNameTv != null))
    {
      this.mCurRoadContanerBg.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407165));
      this.mCurRoadNameTv.setTextColor(Color.parseColor("#333333"));
    }
  }
  
  private void setNightMode()
  {
    if ((this.mCurRoadContanerBg != null) && (this.mCurRoadNameTv != null))
    {
      this.mCurRoadContanerBg.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407166));
      this.mCurRoadNameTv.setTextColor(-1);
    }
  }
  
  public void hide()
  {
    super.hide();
    if (this.mCurRoadContanerBg != null) {
      this.mCurRoadContanerBg.setVisibility(8);
    }
  }
  
  public void moveRightView()
  {
    if ((RGMapModeViewController.getInstance().getOrientation() == 2) && (this.mCurRoadContainer != null))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCurRoadContainer.getLayoutParams();
      localLayoutParams.width = (ScreenUtil.getInstance().getHeightPixels() / 2);
      localLayoutParams.gravity = 5;
      this.mCurRoadContainer.setLayoutParams(localLayoutParams);
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    initView();
  }
  
  public void resetViewPosition()
  {
    if ((RGMapModeViewController.getInstance().getOrientation() == 2) && (this.mCurRoadContainer != null))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCurRoadContainer.getLayoutParams();
      localLayoutParams.width = (ScreenUtil.getInstance().getGuidePanelWidth() * 3);
      localLayoutParams.gravity = 5;
      this.mCurRoadContainer.setLayoutParams(localLayoutParams);
    }
  }
  
  public void show()
  {
    super.show();
    if (this.mCurRoadContanerBg != null)
    {
      this.mCurRoadContanerBg.setVisibility(0);
      updateRoadName(RGSimpleGuideModel.getInstance().getCurRoadName());
    }
  }
  
  public void updateRoadName(String paramString)
  {
    LogUtil.e("RouteGuide", "updateRoadName --> " + paramString);
    if ((this.mCurRoadContanerBg == null) || (this.mCurRoadNameTv == null) || (paramString == null) || (paramString.equals(this.mCurRoadNameTv.getText().toString()))) {
      return;
    }
    if ((StringUtils.isEmpty(paramString)) || ("无名路".equals(paramString)) || ("当前道路".equals(paramString)) || ("无数据道路".equals(paramString)))
    {
      this.mCurRoadNameTv.setText("");
      this.mCurRoadContanerBg.setVisibility(8);
      return;
    }
    autoAdaptTextSize(16, paramString);
    this.mCurRoadNameTv.setText(paramString);
    this.mCurRoadContanerBg.setVisibility(0);
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (paramBoolean)
    {
      setDayMode();
      return;
    }
    setNightMode();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGCurRoadNameView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */