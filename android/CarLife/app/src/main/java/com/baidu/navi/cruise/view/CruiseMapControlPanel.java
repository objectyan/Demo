package com.baidu.navi.cruise.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.CruiseMapController;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class CruiseMapControlPanel
{
  private static final int AUTO_HIDE_TIME_DEFAULT = 15000;
  private static final String FIRST_ITS_ON = "FIRST_ITS_ON";
  private static final String TAG = "Cruise";
  private final int CAR_3D_BTN = 1;
  private final int LOC_CAR_BTN = 2;
  private final int NORTH_2D_BTN = 0;
  private Activity mActivity;
  private int mBtnId = 1;
  private Context mContext;
  private CruiseScaleLevelView mCruiseScaleLevelView;
  private CruiseZoomButtonView mCruiseZoomButtonView;
  private Handler mHandler = new Handler();
  private Runnable mHideRunnable = new Runnable()
  {
    public void run()
    {
      CruiseMapControlPanel.this.hide();
    }
  };
  private boolean mIsItsOpen = false;
  private boolean mIsItsVoiceOpen = true;
  private View mItsButton;
  private ImageView mItsImageView;
  private View mItsVoiceButton;
  private ImageView mItsVoiceImageView;
  private Runnable mLocCarRunnable = new Runnable()
  {
    public void run()
    {
      CruiseMapControlPanel.this.locateToCarPt();
    }
  };
  private ProgressBar mLocProgressBar;
  private ImageButton mLocationBtn;
  private View mLocationView;
  
  public CruiseMapControlPanel(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.mContext = paramActivity;
    this.mActivity = paramActivity;
    this.mCruiseScaleLevelView = new CruiseScaleLevelView(this.mActivity, paramViewGroup);
    this.mCruiseScaleLevelView.hide();
    this.mCruiseZoomButtonView = new CruiseZoomButtonView(this.mActivity, paramViewGroup);
    this.mCruiseZoomButtonView.setZoomBtnClickListener(new CruiseZoomButtonView.OnZoomBtnClickListener()
    {
      public void onZoomInBtnClick()
      {
        CruiseMapControlPanel.this.autoHide();
        CruiseMapControlPanel.this.mCruiseScaleLevelView.showScale();
      }
      
      public void onZoomOutBtnClick()
      {
        CruiseMapControlPanel.this.autoHide();
        CruiseMapControlPanel.this.mCruiseScaleLevelView.showScale();
      }
    });
    this.mLocationBtn = ((ImageButton)paramViewGroup.findViewById(2131625905));
    this.mLocationView = paramViewGroup.findViewById(2131625904);
    if (PreferenceHelper.getInstance(this.mContext).getBoolean("SP_Last_Cruise_Map_Status", true)) {}
    for (int i = 0;; i = 1)
    {
      this.mBtnId = i;
      setLocateIcon(this.mBtnId);
      this.mLocProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131625906));
      if (this.mLocationView != null) {
        this.mLocationView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (ForbidDaulClickUtils.isFastDoubleClick()) {
              return;
            }
            if (CruiseMapControlPanel.this.mBtnId == 0)
            {
              CruiseMapControlPanel.access$102(CruiseMapControlPanel.this, (CruiseMapControlPanel.this.mBtnId + 1) % 2);
              CruiseMapController.getInstance().changeToCar3DView(true);
              CruiseMapControlPanel.this.showToast(2131297787);
            }
            for (;;)
            {
              CruiseMapControlPanel.this.setLocateIcon(CruiseMapControlPanel.this.mBtnId);
              CruiseMapControlPanel.this.autoHide();
              return;
              if (CruiseMapControlPanel.this.mBtnId == 1)
              {
                CruiseMapControlPanel.access$102(CruiseMapControlPanel.this, (CruiseMapControlPanel.this.mBtnId + 1) % 2);
                CruiseMapController.getInstance().changeToNorth2DView();
                CruiseMapControlPanel.this.showToast(2131297810);
              }
              else if (CruiseMapControlPanel.this.mBtnId == 2)
              {
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410019", "410019");
                CruiseMapControlPanel.this.locateToCarPt();
                CruiseMapControlPanel.this.showToast(2131297798);
              }
            }
          }
        });
      }
      this.mLocationBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick()) {
            return;
          }
          if (CruiseMapControlPanel.this.mBtnId == 0)
          {
            CruiseMapControlPanel.access$102(CruiseMapControlPanel.this, (CruiseMapControlPanel.this.mBtnId + 1) % 2);
            CruiseMapController.getInstance().changeToCar3DView(true);
            CruiseMapControlPanel.this.showToast(2131297787);
          }
          for (;;)
          {
            CruiseMapControlPanel.this.setLocateIcon(CruiseMapControlPanel.this.mBtnId);
            CruiseMapControlPanel.this.autoHide();
            return;
            if (CruiseMapControlPanel.this.mBtnId == 1)
            {
              CruiseMapControlPanel.access$102(CruiseMapControlPanel.this, (CruiseMapControlPanel.this.mBtnId + 1) % 2);
              CruiseMapController.getInstance().changeToNorth2DView();
              CruiseMapControlPanel.this.showToast(2131297810);
            }
            else if (CruiseMapControlPanel.this.mBtnId == 2)
            {
              BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410019", "410019");
              CruiseMapControlPanel.this.locateToCarPt();
              CruiseMapControlPanel.this.showToast(2131297798);
            }
          }
        }
      });
      this.mItsButton = paramViewGroup.findViewById(2131625913);
      this.mItsImageView = ((ImageView)paramViewGroup.findViewById(2131624961));
      this.mItsVoiceButton = paramViewGroup.findViewById(2131625922);
      this.mItsVoiceImageView = ((ImageView)paramViewGroup.findViewById(2131625923));
      this.mIsItsOpen = BNSettingManager.isRoadCondOnOrOff();
      updateItsBtn();
      updateItsVoiceBtn();
      CruiseMapController.getInstance().showTrafficMap(this.mIsItsOpen);
      this.mItsButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CruiseMapControlPanel.this.handleItsClick();
        }
      });
      if (this.mItsVoiceButton != null) {
        this.mItsVoiceButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            CruiseMapControlPanel.this.handleItsVoiceClick();
          }
        });
      }
      return;
    }
  }
  
  private void handleItsClick()
  {
    autoHide();
    StatisticManager.onEvent("NAVI_0005", "NAVI_0005");
    if ((!this.mIsItsOpen) && (!BNSettingManager.isRoadCondOnOrOff()))
    {
      StatisticManager.onEvent("NAVI_0006", "NAVI_0006");
      if (PreferenceHelper.getInstance(this.mContext).getBoolean("NAVI_REAL_HISTORY_ITS", true))
      {
        if ((!PreferenceHelper.getInstance(this.mContext).getBoolean("FIRST_ITS_ON", true)) || (!BCruiser.getInstance().isOfflineDataDownloaded())) {
          break label115;
        }
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
          break label101;
        }
        PreferenceHelper.getInstance(this.mContext).putBoolean("FIRST_ITS_ON", false);
        showTrafficMap();
      }
    }
    label101:
    label115:
    while ((!this.mIsItsOpen) || (!BNSettingManager.isRoadCondOnOrOff()))
    {
      return;
      TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(2131296778));
      return;
      showTrafficMap();
      return;
    }
    CruiseMapController.getInstance().showTrafficMap(false);
    BNSettingManager.setRoadCondOnOff(false);
    this.mIsItsOpen = false;
    updateItsBtn();
    TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(2131296776));
  }
  
  private void handleItsVoiceClick()
  {
    boolean bool = true;
    autoHide();
    CruiseMapController.getInstance().handleCruiseVoiceChanged(true, true);
    if (!BaiduNaviSDKManager.getInstance().isNaviMuteState()) {}
    for (;;)
    {
      this.mIsItsVoiceOpen = bool;
      if (this.mIsItsVoiceOpen) {
        StatisticManager.onEvent("NAVI_0008");
      }
      updateItsVoiceBtn();
      return;
      bool = false;
    }
  }
  
  private boolean isSupportTrafficMap()
  {
    Object localObject = BNMapController.getInstance().getGeoPosByScreenPos(this.mActivity.getWindowManager().getDefaultDisplay().getWidth() / 2, this.mActivity.getWindowManager().getDefaultDisplay().getHeight() / 2);
    if ((localObject != null) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)))
    {
      localObject = BNPoiSearcher.getInstance().getDistrictByPoint((GeoPoint)localObject, 0);
      if ((localObject != null) && (!BNMapController.getInstance().checkRoadConditionSupport(((DistrictInfo)localObject).mId))) {
        return false;
      }
    }
    return true;
  }
  
  private void locateToCarPt()
  {
    int i = 1;
    LogUtil.e("Cruise", "locateToCarPt");
    CruiseMapController.getInstance().locateToCarPoint(true);
    if (PreferenceHelper.getInstance(this.mContext).getBoolean("SP_Last_Cruise_Map_Status", true)) {
      i = 0;
    }
    this.mBtnId = i;
    setLocateIcon(this.mBtnId);
  }
  
  private void showFirstItsDialog()
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {
      return;
    }
    try
    {
      new BNDialog(this.mActivity).setTitleText(StyleManager.getString(2131296783)).setContentMessage(StyleManager.getString(2131297794)).setFirstBtnText(StyleManager.getString(2131296735)).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          PreferenceHelper.getInstance(CruiseMapControlPanel.this.mContext).putBoolean("FIRST_ITS_ON", false);
          CruiseMapControlPanel.this.showTrafficMap();
        }
      }).setSecondBtnText(StyleManager.getString(2131296732)).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick() {}
      }).show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void showToast(int paramInt)
  {
    TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(paramInt));
  }
  
  private void showTrafficMap()
  {
    if (NetworkUtils.isNetworkAvailable(this.mContext))
    {
      if (!isSupportTrafficMap())
      {
        TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(2131296750));
        return;
      }
      CruiseMapController.getInstance().showTrafficMap(true);
      BNSettingManager.setRoadCondOnOff(true);
      this.mIsItsOpen = true;
      TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(2131296777));
    }
    for (;;)
    {
      updateItsBtn();
      return;
      TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(2131296778));
      this.mIsItsOpen = false;
    }
  }
  
  private void updateScale()
  {
    if (this.mCruiseScaleLevelView != null) {
      this.mCruiseScaleLevelView.update();
    }
  }
  
  private void updateZoomButton()
  {
    if (this.mCruiseZoomButtonView != null) {
      this.mCruiseZoomButtonView.updateZoomButton();
    }
  }
  
  public void autoHide() {}
  
  public void autoHide(long paramLong)
  {
    this.mHandler.removeCallbacks(this.mHideRunnable);
    this.mHandler.postDelayed(this.mHideRunnable, paramLong);
  }
  
  public void hide()
  {
    if ((this.mLocationBtn == null) || (this.mItsButton == null) || (this.mCruiseZoomButtonView == null) || (this.mCruiseScaleLevelView == null) || (this.mLocProgressBar == null) || (this.mItsVoiceButton == null) || (this.mLocationView == null)) {
      return;
    }
    this.mLocationBtn.setVisibility(4);
    this.mLocationView.setVisibility(4);
    this.mLocProgressBar.setVisibility(4);
    this.mItsButton.setVisibility(4);
    this.mItsVoiceButton.setVisibility(4);
    this.mCruiseScaleLevelView.hide();
    this.mCruiseZoomButtonView.hide();
  }
  
  public void onConfigurationChanged() {}
  
  public void onResume()
  {
    this.mIsItsOpen = BNSettingManager.isRoadCondOnOrOff();
    updateItsBtn();
    updateItsVoiceBtn();
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    this.mLocationBtn.setBackgroundDrawable(StyleManager.getDrawable(2130838852));
    setLocateIcon(this.mBtnId);
    this.mItsButton.setBackgroundDrawable(StyleManager.getDrawable(2130838100));
    this.mItsImageView.setBackgroundDrawable(StyleManager.getDrawable(2130838852));
    this.mItsVoiceImageView.setBackgroundDrawable(StyleManager.getDrawable(2130838852));
    updateItsBtn();
    updateItsVoiceBtn();
    this.mCruiseZoomButtonView.onUpdateStyle(paramBoolean);
    this.mCruiseScaleLevelView.onUpdateStyle(paramBoolean);
  }
  
  public void removeLocModeRunnable()
  {
    if ((this.mHandler != null) && (this.mLocCarRunnable != null)) {
      this.mHandler.removeCallbacks(this.mLocCarRunnable);
    }
  }
  
  public void resetLocMode()
  {
    this.mBtnId = 2;
    setLocateIcon(this.mBtnId);
    BNRouteGuider.getInstance().setBrowseStatus(true);
    if ((this.mHandler != null) && (this.mLocCarRunnable != null))
    {
      this.mHandler.removeCallbacks(this.mLocCarRunnable);
      this.mHandler.postDelayed(this.mLocCarRunnable, 5000L);
    }
  }
  
  public void setLocateIcon(int paramInt)
  {
    LogUtil.e("Cruise", "set locate button icon, btn mode " + paramInt);
    if (paramInt == 1) {
      this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(2130838892));
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(2130838891));
        return;
      }
    } while (paramInt != 2);
    this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(2130838880));
  }
  
  public void show()
  {
    if ((this.mLocationBtn == null) || (this.mItsButton == null) || (this.mCruiseZoomButtonView == null) || (this.mCruiseScaleLevelView == null) || (this.mItsVoiceButton == null) || (this.mLocationView == null)) {
      return;
    }
    this.mLocationBtn.setVisibility(0);
    this.mLocationView.setVisibility(0);
    this.mItsButton.setVisibility(0);
    this.mItsVoiceButton.setVisibility(0);
    this.mCruiseScaleLevelView.show();
    this.mCruiseZoomButtonView.show();
  }
  
  public void updateItsBtn()
  {
    this.mIsItsOpen = BNSettingManager.isRoadCondOnOrOff();
    if (this.mIsItsOpen)
    {
      this.mItsImageView.setImageDrawable(StyleManager.getDrawable(2130838874));
      return;
    }
    this.mItsImageView.setImageDrawable(StyleManager.getDrawable(2130838873));
  }
  
  public void updateItsVoiceBtn()
  {
    if (this.mItsVoiceImageView == null) {
      return;
    }
    if (!BaiduNaviSDKManager.getInstance().isNaviMuteState()) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsItsVoiceOpen = bool;
      if (!this.mIsItsVoiceOpen) {
        break;
      }
      this.mItsVoiceImageView.setImageDrawable(StyleManager.getDrawable(2130838871));
      return;
    }
    this.mItsVoiceImageView.setImageDrawable(StyleManager.getDrawable(2130838870));
  }
  
  public void updateView()
  {
    updateScale();
    updateZoomButton();
    BNMapController.getInstance().updateLayer(10);
    BNMapController.getInstance().UpdataBaseLayers();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/cruise/view/CruiseMapControlPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */