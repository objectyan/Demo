package com.baidu.navi.cruise.view;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.view.TopBarView;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.control.CruiseMapController;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.ui.cruise.view.CruiseMenu;
import com.baidu.navisdk.ui.util.TipTool;

public class CruiseMapView
{
  private static final String TAG = "Cruise";
  private static final int[] sVerticalLineViewIds = { 2131625897, 2131625901 };
  private Activity mActivity;
  private ImageView mBatteryIcon = null;
  private TextView mBatteryTv = null;
  private View mBottomBar;
  private boolean mIsPortrait = true;
  boolean mIsVisible = false;
  public CruiseMainInfoPanel mMainInfoPanel;
  private CruiseMapControlPanel mMapControlPanel;
  private CruiseMenu mMenuView;
  private View.OnTouchListener mOnTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if (CruiseMapView.this.mMapControlPanel != null) {
        CruiseMapView.this.mMapControlPanel.autoHide();
      }
      return false;
    }
  };
  private View mQuitBtn;
  private IQuitCruiseClickListener mQuitCruiseClickListener;
  private ImageView mQuitImageView;
  private View mRoadInfoLayout;
  private TextView mRoadNameTextView;
  private TextView mRoadTitleTextView;
  private ViewGroup mRootView;
  private TopBarView mTopBarView;
  private View[] mVerticalLineViews;
  
  public CruiseMapView(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    this.mIsPortrait = paramBoolean;
    this.mRootView = ((ViewGroup)StyleManager.inflate(2130968968, null));
    if (this.mRootView == null) {}
    do
    {
      do
      {
        return;
      } while (paramViewGroup == null);
      paramViewGroup.addView(this.mRootView);
      this.mRootView.setOnTouchListener(this.mOnTouchListener);
      this.mMapControlPanel = new CruiseMapControlPanel(paramActivity, paramViewGroup, paramBoolean);
      this.mMainInfoPanel = new CruiseMainInfoPanel(paramActivity, paramViewGroup);
      this.mQuitBtn = paramViewGroup.findViewById(2131625895);
      this.mQuitBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410022", "410022");
          EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        }
      });
      this.mQuitImageView = ((ImageView)paramViewGroup.findViewById(2131625896));
      this.mBottomBar = paramViewGroup.findViewById(2131625894);
      this.mRoadInfoLayout = paramViewGroup.findViewById(2131625898);
      this.mRoadInfoLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
      this.mRoadNameTextView = ((TextView)this.mRoadInfoLayout.findViewById(2131625900));
      this.mRoadTitleTextView = ((TextView)this.mRoadInfoLayout.findViewById(2131625899));
      this.mBatteryTv = ((TextView)paramViewGroup.findViewById(2131625884));
      this.mBatteryIcon = ((ImageView)paramViewGroup.findViewById(2131625885));
      this.mTopBarView = ((TopBarView)paramViewGroup.findViewById(2131625917));
      this.mTopBarView.setAlpha(1.0F);
      setCurrentRoadName(CruiseUIModel.getInstance().getCurrentRoadName());
      setCurrentRoadVisible(CruiseUIModel.getInstance().isProvinceDataDownloaded());
      setBatteryStatus(BNPowerSaver.getInstance().getmBatteryLevel(), BNPowerSaver.getInstance().ismIsBatteryCharging());
      if (this.mIsPortrait)
      {
        this.mVerticalLineViews = new View[sVerticalLineViewIds.length];
        int i = 0;
        while (i < sVerticalLineViewIds.length)
        {
          this.mVerticalLineViews[i] = this.mBottomBar.findViewById(sVerticalLineViewIds[i]);
          i += 1;
        }
      }
      show();
      updateControlPanel();
    } while (this.mMapControlPanel == null);
    this.mMapControlPanel.autoHide();
  }
  
  public void changeToCar3DView()
  {
    CruiseMapController.getInstance().changeToCar3DView(true);
    TipTool.onCreateToastDialog(this.mActivity, StyleManager.getString(2131297787));
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setLocateIcon(1);
    }
  }
  
  public void changeToNorth2DView()
  {
    CruiseMapController.getInstance().changeToNorth2DView();
    TipTool.onCreateToastDialog(this.mActivity, StyleManager.getString(2131297810));
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setLocateIcon(0);
    }
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public void handleCruiseVoiceChanged(boolean paramBoolean1, boolean paramBoolean2)
  {
    BaiduNaviSDKManager.getInstance().setNaviMuteState(paramBoolean2);
    if (paramBoolean1)
    {
      if (!BaiduNaviSDKManager.getInstance().isNaviMuteState()) {
        TipTool.onCreateToastDialog(this.mActivity, StyleManager.getString(2131296404));
      }
    }
    else {
      return;
    }
    TipTool.onCreateToastDialog(this.mActivity, StyleManager.getString(2131296403));
  }
  
  public void hide()
  {
    if (this.mMainInfoPanel == null) {
      return;
    }
    this.mIsVisible = false;
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.hide();
    }
    this.mQuitBtn.setVisibility(4);
    this.mMainInfoPanel.hide();
  }
  
  public boolean isOrientationPortrait()
  {
    return (this.mActivity == null) || (this.mActivity.getResources().getConfiguration().orientation == 1);
  }
  
  public boolean isPortrait()
  {
    return this.mIsPortrait;
  }
  
  public boolean onBackPressed()
  {
    return !CruiseUIModel.getInstance().isShowingMenu();
  }
  
  public void onConfigurationChanged() {}
  
  public void onResume()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.onResume();
    }
    if (this.mMainInfoPanel != null) {
      this.mMainInfoPanel.onResume();
    }
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    if ((this.mQuitImageView == null) || (this.mMainInfoPanel == null) || (this.mRoadNameTextView == null)) {
      return;
    }
    this.mQuitImageView.setBackground(StyleManager.getDrawable(2130838852));
    this.mQuitImageView.setImageDrawable(StyleManager.getDrawable(2130839087));
    this.mRoadNameTextView.setBackground(StyleManager.getDrawable(2130838848));
    this.mRoadNameTextView.setTextColor(StyleManager.getColor(2131558856));
    this.mMainInfoPanel.onUpdateStyle(paramBoolean);
    if (this.mIsPortrait)
    {
      this.mBottomBar.setBackgroundColor(StyleManager.getColor(2131558930));
      this.mRoadTitleTextView.setTextColor(StyleManager.getColor(2131558938));
      int i = 0;
      while (i < this.mVerticalLineViews.length)
      {
        if (this.mVerticalLineViews[i] != null) {
          this.mVerticalLineViews[i].setBackgroundDrawable(StyleManager.getDrawable(2130839110));
        }
        i += 1;
      }
    }
    this.mBottomBar.setBackgroundDrawable(null);
    this.mRoadTitleTextView.setTextColor(StyleManager.getColor(2131558934));
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.onUpdateStyle(paramBoolean);
    }
    this.mTopBarView.a(paramBoolean);
  }
  
  public void removeLocModeRunnable()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.removeLocModeRunnable();
    }
  }
  
  public void resetLocMode()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.resetLocMode();
    }
  }
  
  public void setBCruiserQuitCruiseClickListener(IQuitCruiseClickListener paramIQuitCruiseClickListener)
  {
    this.mQuitCruiseClickListener = paramIQuitCruiseClickListener;
  }
  
  public void setBatteryStatus(int paramInt, boolean paramBoolean)
  {
    if (this.mBatteryTv != null) {
      this.mBatteryTv.setText(paramInt + "%");
    }
    if ((paramBoolean) && (this.mBatteryIcon != null)) {
      this.mBatteryIcon.setImageDrawable(StyleManager.getDrawable(2130839186));
    }
    for (;;)
    {
      return;
      int j = -1;
      int i;
      if (paramInt <= 35) {
        i = 2130839187;
      }
      while ((this.mBatteryIcon != null) && (i != -1))
      {
        this.mBatteryIcon.setImageDrawable(StyleManager.getDrawable(i));
        return;
        if ((paramInt > 35) && (paramInt <= 65))
        {
          i = 2130839188;
        }
        else if ((paramInt > 65) && (paramInt <= 95))
        {
          i = 2130839189;
        }
        else
        {
          i = j;
          if (paramInt > 95)
          {
            i = j;
            if (paramInt <= 100) {
              i = 2130839190;
            }
          }
        }
      }
    }
  }
  
  public void setCurrentRoadName(String paramString)
  {
    CruiseUIModel.getInstance().setCurrentRoadName(paramString);
    if (this.mRoadNameTextView != null)
    {
      if (paramString != null) {
        this.mRoadNameTextView.setText(paramString);
      }
    }
    else {
      return;
    }
    this.mRoadNameTextView.setText(StyleManager.getString(2131297818));
  }
  
  public void setCurrentRoadVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      if (this.mRoadNameTextView != null) {
        this.mRoadNameTextView.setVisibility(i);
      }
      if (this.mRoadTitleTextView != null) {
        this.mRoadTitleTextView.setVisibility(8);
      }
      return;
    }
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.mIsVisible) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while (this.mMainInfoPanel == null);
      this.mMainInfoPanel.setToConnected();
      return;
    } while (this.mMainInfoPanel == null);
    this.mMainInfoPanel.setToDisconnected();
  }
  
  public void setViewWhenGPSRecover()
  {
    if (this.mMainInfoPanel != null) {
      this.mMainInfoPanel.setViewWhenGPSRecover();
    }
  }
  
  public void setViewWhenNoGPS()
  {
    if (this.mMainInfoPanel != null) {
      this.mMainInfoPanel.setViewWhenNoGPS();
    }
    updateCurrentSpeed(0);
    updateSatelliteViews(0);
  }
  
  public void setViewWhenNotLocated()
  {
    if (this.mMainInfoPanel != null) {
      this.mMainInfoPanel.setViewWhenNotLocated();
    }
    updateCurrentSpeed(0);
    updateSatelliteViews(0);
  }
  
  public void show()
  {
    if (this.mMainInfoPanel == null) {
      return;
    }
    this.mIsVisible = true;
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.show();
    }
    setNetworkAvailable(CruiseUIModel.getInstance().isConnected());
  }
  
  public void showMapButtons()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.show();
    }
  }
  
  public void updateControlPanel()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.updateView();
    }
  }
  
  public void updateCurrentSpeed(int paramInt)
  {
    if (this.mMainInfoPanel != null) {
      this.mMainInfoPanel.updateCurrentSpeed(paramInt);
    }
  }
  
  public void updateData(Bundle paramBundle)
  {
    if (this.mMainInfoPanel != null) {
      this.mMainInfoPanel.updateData(paramBundle);
    }
  }
  
  public void updateItsBtn()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.updateItsBtn();
    }
  }
  
  public void updateItsVoiceBtn()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.updateItsVoiceBtn();
    }
  }
  
  public void updateSatelliteViews(int paramInt)
  {
    if (this.mMainInfoPanel != null) {
      this.mMainInfoPanel.updateSatelliteViews(paramInt);
    }
  }
  
  public static abstract interface IQuitCruiseClickListener
  {
    public abstract void onClickQuitCruise();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/cruise/view/CruiseMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */