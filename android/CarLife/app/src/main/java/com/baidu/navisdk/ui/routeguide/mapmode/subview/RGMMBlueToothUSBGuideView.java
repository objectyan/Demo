package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMBlueToothUSBGuideView
  extends BNBaseView
  implements View.OnClickListener
{
  public static final int PANEL_CONTENT_TYPE_BLUETOOTH = 1;
  public static final int PANEL_CONTENT_TYPE_USB = 2;
  private static final String TAG = RGMMBlueToothUSBGuideView.class.getSimpleName();
  public static int sPanelContentType = 0;
  private TextView mFixDiscriptionTV;
  private ViewGroup mGuideContainer;
  private ViewGroup mGuideInnerPanel;
  private ViewGroup mGuidePanel;
  private ViewGroup mGuideView;
  private TextView mProblemDiscriptionTV;
  private TextView mStillNoVolumDiscriptionTV;
  private LinearLayout mStillNoVolumLL;
  private BNCommonTitleBar mTitleBar = null;
  
  public RGMMBlueToothUSBGuideView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    initListener();
  }
  
  private void initListener()
  {
    if (this.mGuideInnerPanel == null) {
      return;
    }
    this.mGuideInnerPanel.findViewById(1711865878).setOnClickListener(this);
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {}
    for (;;)
    {
      return;
      try
      {
        this.mGuidePanel = ((ViewGroup)this.mRootViewGroup.findViewById(1711866548));
        this.mGuideContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866549));
        if (this.mGuideContainer != null) {
          this.mGuideContainer.removeAllViews();
        }
        this.mGuideView = ((ViewGroup)JarUtils.inflate((Activity)this.mContext, 1711472705, null));
        if ((this.mGuideContainer != null) && (this.mGuideView != null))
        {
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          this.mGuideContainer.addView(this.mGuideView, localLayoutParams);
          this.mTitleBar = ((BNCommonTitleBar)this.mGuideView.findViewById(1711865893));
          if (this.mTitleBar != null)
          {
            this.mTitleBar.setMiddleTextVisible(true);
            this.mTitleBar.setMiddleTextSize(18.0F);
            this.mTitleBar.setRightTextVisible(false);
          }
          this.mGuideInnerPanel = ((ViewGroup)this.mGuideView.findViewById(1711866448));
          this.mProblemDiscriptionTV = ((TextView)this.mRootViewGroup.findViewById(1711866450));
          this.mFixDiscriptionTV = ((TextView)this.mRootViewGroup.findViewById(1711866451));
          this.mStillNoVolumDiscriptionTV = ((TextView)this.mRootViewGroup.findViewById(1711866453));
          this.mStillNoVolumLL = ((LinearLayout)this.mRootViewGroup.findViewById(1711866452));
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  private void updateContent()
  {
    if ((this.mTitleBar == null) || (this.mProblemDiscriptionTV == null) || (this.mFixDiscriptionTV == null) || (this.mStillNoVolumDiscriptionTV == null)) {}
    do
    {
      return;
      if (sPanelContentType == 1)
      {
        this.mStillNoVolumLL.setVisibility(0);
        this.mStillNoVolumDiscriptionTV.setVisibility(0);
        this.mTitleBar.setMiddleText(JarUtils.getResources().getString(1711669405));
        this.mProblemDiscriptionTV.setText(JarUtils.getResources().getString(1711669408));
        this.mFixDiscriptionTV.setText(JarUtils.getResources().getString(1711669411));
        this.mStillNoVolumDiscriptionTV.setText(JarUtils.getResources().getString(1711669414));
        return;
      }
    } while (sPanelContentType != 2);
    this.mStillNoVolumLL.setVisibility(8);
    this.mStillNoVolumDiscriptionTV.setVisibility(8);
    this.mTitleBar.setMiddleText(JarUtils.getResources().getString(1711669406));
    this.mProblemDiscriptionTV.setText(JarUtils.getResources().getString(1711669409));
    this.mFixDiscriptionTV.setText(JarUtils.getResources().getString(1711669412));
  }
  
  public void hide()
  {
    super.hide();
    if (this.mGuideContainer != null) {
      this.mGuideContainer.setVisibility(8);
    }
    if (this.mGuidePanel != null) {
      this.mGuidePanel.setVisibility(8);
    }
    if (this.mGuideInnerPanel != null) {
      this.mGuideInnerPanel.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    try
    {
      switch (paramView.getId())
      {
      case 1711865878: 
        RGViewController.getInstance().hideBlueToothUSBGuide();
        return;
      }
    }
    catch (Exception paramView) {}
  }
  
  public void show()
  {
    super.show();
    updateContent();
    if (this.mGuideContainer != null) {
      this.mGuideContainer.setVisibility(0);
    }
    if (this.mGuidePanel != null) {
      this.mGuidePanel.setVisibility(0);
    }
    if (this.mGuideInnerPanel != null) {
      this.mGuideInnerPanel.setVisibility(0);
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMBlueToothUSBGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */