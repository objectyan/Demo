package com.baidu.navisdk.ui.cruise.view;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.cruise.control.CruiseMapController;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseMapView
{
  private static final String TAG = "Cruise";
  private static final int[] sVerticalLineViewIds = { 1711865941, 1711865945 };
  private Activity mActivity;
  private ImageView mBatteryIcon = null;
  private TextView mBatteryTv = null;
  private View mBottomBar;
  private boolean mIsPortrait = true;
  boolean mIsVisible = false;
  public CruiseMainInfoPanel mMainInfoPanel;
  private CruiseMapControlPanel mMapControlPanel;
  private ImageView mMenuImageView;
  private View mMenuMaskView;
  private CruiseMenu mMenuView;
  private View.OnTouchListener mOnTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if (CruiseMapView.this.mMenuView.isShowing()) {
        CruiseMapView.this.hideMenu();
      }
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
  private View[] mVerticalLineViews;
  
  public CruiseMapView(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    this.mIsPortrait = paramBoolean;
    int i;
    if (paramBoolean)
    {
      i = 1711472660;
      this.mRootView = ((ViewGroup)JarUtils.inflate(paramActivity, i, null));
      if (this.mRootView != null) {
        break label83;
      }
    }
    label83:
    do
    {
      do
      {
        return;
        i = 1711472661;
        break;
      } while (paramViewGroup == null);
      paramViewGroup.addView(this.mRootView);
      this.mRootView.setOnTouchListener(this.mOnTouchListener);
      this.mMapControlPanel = new CruiseMapControlPanel(paramActivity, paramViewGroup, paramBoolean);
      initMenuView(paramViewGroup);
      this.mMainInfoPanel = new CruiseMainInfoPanel(paramActivity, paramViewGroup);
      this.mQuitBtn = paramViewGroup.findViewById(1711865939);
      this.mQuitBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410022", "410022");
          if (CruiseMapView.this.mQuitCruiseClickListener != null) {
            CruiseMapView.this.mQuitCruiseClickListener.onClickQuitCruise();
          }
        }
      });
      this.mQuitImageView = ((ImageView)paramViewGroup.findViewById(1711865940));
      this.mMenuImageView = ((ImageView)paramViewGroup.findViewById(1711865947));
      this.mBottomBar = paramViewGroup.findViewById(1711865938);
      this.mRoadInfoLayout = paramViewGroup.findViewById(1711865942);
      this.mRoadNameTextView = ((TextView)this.mRoadInfoLayout.findViewById(1711865944));
      this.mRoadTitleTextView = ((TextView)this.mRoadInfoLayout.findViewById(1711865943));
      this.mBatteryTv = ((TextView)paramViewGroup.findViewById(1711865928));
      this.mBatteryIcon = ((ImageView)paramViewGroup.findViewById(1711865929));
      setCurrentRoadName(CruiseUIModel.getInstance().getCurrentRoadName());
      setCurrentRoadVisible(CruiseUIModel.getInstance().isProvinceDataDownloaded());
      setBatteryStatus(BNPowerSaver.getInstance().getmBatteryLevel(), BNPowerSaver.getInstance().ismIsBatteryCharging());
      if (this.mIsPortrait)
      {
        this.mVerticalLineViews = new View[sVerticalLineViewIds.length];
        i = 0;
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
  
  private void hideMenu()
  {
    LogUtil.e("Cruise", "hideMenu.");
    if (this.mMenuView != null) {
      this.mMenuView.hide();
    }
    if (this.mMenuMaskView != null) {
      this.mMenuMaskView.setVisibility(8);
    }
    CruiseUIModel.getInstance().setIsShowingMenu(false);
  }
  
  private void initMenuView(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup;
    if (paramViewGroup != null)
    {
      LogUtil.e("Cruise", "initMenuView");
      this.mMenuView = new CruiseMenu(this.mActivity);
      this.mMenuView.initViews();
      localViewGroup = (ViewGroup)paramViewGroup.findViewById(1711865964);
      if (localViewGroup != null) {
        break label48;
      }
    }
    label48:
    boolean bool;
    do
    {
      return;
      localViewGroup.addView(this.mMenuView.getView(), 0);
      this.mMenuView.hide();
      this.mMenuView.setMenuItemClickListener(new CruiseMenu.IOnMenuItemClickedListener()
      {
        public void onClickClose()
        {
          CruiseMapView.this.hideMenu();
        }
        
        public void onClickHelp() {}
        
        public void onClickOfflineData() {}
      });
      this.mMenuMaskView = paramViewGroup.findViewById(1711865963);
      if (this.mMenuMaskView != null) {
        this.mMenuMaskView.setVisibility(8);
      }
      bool = CruiseUIModel.getInstance().isShowingMenu();
      LogUtil.e("Cruise", "initMenuView: isShowingMenu " + bool);
    } while (!bool);
    showMenu();
  }
  
  private void showMenu()
  {
    LogUtil.e("Cruise", "showMenu...");
    if (this.mMenuView != null) {
      this.mMenuView.show();
    }
    if (this.mMenuMaskView != null) {
      this.mMenuMaskView.setVisibility(0);
    }
    CruiseUIModel.getInstance().setIsShowingMenu(true);
  }
  
  public void changeToCar3DView()
  {
    CruiseMapController.getInstance().changeToCar3DView(true);
    TipTool.onCreateToastDialog(this.mActivity, BNStyleManager.getString(1711669749));
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setLocateIcon(1);
    }
  }
  
  public void changeToNorth2DView()
  {
    CruiseMapController.getInstance().changeToNorth2DView();
    TipTool.onCreateToastDialog(this.mActivity, BNStyleManager.getString(1711669748));
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setLocateIcon(0);
    }
  }
  
  public void exitCruiser()
  {
    BCruiser.getInstance().notifyCruiseFragmentQuitCruise();
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public void handleCruiseVoiceChanged(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mMenuView != null)
    {
      this.mMenuView.handleCruiseVoiceChanged(paramBoolean1, paramBoolean2);
      this.mMapControlPanel.updateItsVoiceBtn();
    }
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
    return false;
  }
  
  public boolean isPortrait()
  {
    return this.mIsPortrait;
  }
  
  public boolean onBackPressed()
  {
    if (CruiseUIModel.getInstance().isShowingMenu())
    {
      hideMenu();
      return false;
    }
    return true;
  }
  
  public void onConfigurationChanged()
  {
    if ((CruiseUIModel.getInstance().isShowingMenu()) && (!this.mMenuView.isShowing())) {
      showMenu();
    }
  }
  
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
    if ((this.mQuitImageView == null) || (this.mMainInfoPanel == null) || (this.mBottomBar == null) || (this.mRoadTitleTextView == null) || (this.mRoadNameTextView == null)) {}
    do
    {
      return;
      this.mQuitImageView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407293));
      this.mMainInfoPanel.onUpdateStyle(paramBoolean);
      this.mBottomBar.setBackgroundDrawable(null);
      this.mRoadTitleTextView.setTextColor(JarUtils.getResources().getColor(1711800458));
      this.mRoadNameTextView.setTextColor(JarUtils.getResources().getColor(1711800457));
    } while (this.mMapControlPanel == null);
    this.mMapControlPanel.onUpdateStyle(paramBoolean);
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
      this.mBatteryIcon.setImageDrawable(JarUtils.getResources().getDrawable(1711407676));
    }
    for (;;)
    {
      return;
      int j = -1;
      int i;
      if (paramInt <= 35) {
        i = 1711407677;
      }
      while ((this.mBatteryIcon != null) && (i != -1))
      {
        this.mBatteryIcon.setImageDrawable(JarUtils.getResources().getDrawable(i));
        return;
        if ((paramInt > 35) && (paramInt <= 65))
        {
          i = 1711407678;
        }
        else if ((paramInt > 65) && (paramInt <= 95))
        {
          i = 1711407679;
        }
        else
        {
          i = j;
          if (paramInt > 95)
          {
            i = j;
            if (paramInt <= 100) {
              i = 1711407680;
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
    this.mRoadNameTextView.setText(JarUtils.getResources().getString(1711669740));
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
        this.mRoadTitleTextView.setVisibility(i);
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
  
  public void setOnControlPanelClickListener(CruiseMapControlPanel.ControlPanelClickListener paramControlPanelClickListener)
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setControlPanelClickLis(paramControlPanelClickListener);
    }
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
    this.mQuitBtn.setVisibility(0);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/view/CruiseMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */