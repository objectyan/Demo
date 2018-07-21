package com.baidu.navisdk.ui.cruise.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.cruise.control.CruiseMapController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class CruiseMapControlPanel
{
  private static final int AUTO_HIDE_TIME_DEFAULT = 3000;
  private static final String FIRST_ITS_ON = "FIRST_ITS_ON";
  private static final String TAG = "Cruise";
  private final int CAR_3D_BTN = 1;
  private final int LOC_CAR_BTN = 2;
  private final int NORTH_2D_BTN = 0;
  private Activity mActivity;
  private int mBtnId = 1;
  private Context mContext;
  private ControlPanelClickListener mControlPanelClickLis = null;
  private CruiseScaleLevelView mCruiseScaleLevelView;
  private CruiseZoomButtonView mCruiseZoomButtonView;
  private Handler mHandler = new Handler();
  private BNWorkerNormalTask<String, String> mHideTask = new BNWorkerNormalTask("mHideTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      CruiseMapControlPanel.this.hide();
      return null;
    }
  };
  private boolean mIsItsOpen = false;
  private boolean mIsItsVoiceOpen = true;
  private View mItsButton;
  private ImageView mItsImageView;
  private View mItsVoiceButton;
  private ImageView mItsVoiceImageView;
  private BNWorkerNormalTask<String, String> mLocCarTask = new BNWorkerNormalTask("mLocCarTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      CruiseMapControlPanel.this.locateToCarPt();
      return null;
    }
  };
  private ProgressBar mLocProgressBar;
  private ImageButton mLocationBtn;
  private View mLocationView;
  
  public CruiseMapControlPanel(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.mContext = paramActivity;
    this.mActivity = paramActivity;
    this.mCruiseScaleLevelView = new CruiseScaleLevelView(this.mContext, paramViewGroup);
    this.mCruiseScaleLevelView.hide();
    this.mCruiseZoomButtonView = new CruiseZoomButtonView(this.mContext, paramViewGroup);
    this.mCruiseZoomButtonView.setZoomBtnClickListener(new CruiseZoomButtonView.OnZoomBtnClickListener()
    {
      public void onZoomInBtnClick()
      {
        CruiseMapControlPanel.this.autoHide();
      }
      
      public void onZoomOutBtnClick()
      {
        CruiseMapControlPanel.this.autoHide();
      }
    });
    this.mLocationBtn = ((ImageButton)paramViewGroup.findViewById(1711865949));
    this.mLocationView = paramViewGroup.findViewById(1711865948);
    if (PreferenceHelper.getInstance(this.mContext).getBoolean("SP_Last_Cruise_Map_Status", true)) {}
    for (int i = 0;; i = 1)
    {
      this.mBtnId = i;
      setLocateIcon(this.mBtnId);
      this.mLocProgressBar = ((ProgressBar)paramViewGroup.findViewById(1711865950));
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
              CruiseMapControlPanel.access$002(CruiseMapControlPanel.this, (CruiseMapControlPanel.this.mBtnId + 1) % 2);
              CruiseMapController.getInstance().changeToCar3DView(true);
              CruiseMapControlPanel.this.showToast(1711669749);
            }
            for (;;)
            {
              CruiseMapControlPanel.this.setLocateIcon(CruiseMapControlPanel.this.mBtnId);
              CruiseMapControlPanel.this.autoHide();
              return;
              if (CruiseMapControlPanel.this.mBtnId == 1)
              {
                CruiseMapControlPanel.access$002(CruiseMapControlPanel.this, (CruiseMapControlPanel.this.mBtnId + 1) % 2);
                CruiseMapController.getInstance().changeToNorth2DView();
                CruiseMapControlPanel.this.showToast(1711669748);
              }
              else if (CruiseMapControlPanel.this.mBtnId == 2)
              {
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410019", "410019");
                CruiseMapControlPanel.this.locateToCarPt();
                CruiseMapControlPanel.this.showToast(1711669750);
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
            CruiseMapControlPanel.access$002(CruiseMapControlPanel.this, (CruiseMapControlPanel.this.mBtnId + 1) % 2);
            CruiseMapController.getInstance().changeToCar3DView(true);
            CruiseMapControlPanel.this.showToast(1711669749);
          }
          for (;;)
          {
            CruiseMapControlPanel.this.setLocateIcon(CruiseMapControlPanel.this.mBtnId);
            CruiseMapControlPanel.this.autoHide();
            return;
            if (CruiseMapControlPanel.this.mBtnId == 1)
            {
              CruiseMapControlPanel.access$002(CruiseMapControlPanel.this, (CruiseMapControlPanel.this.mBtnId + 1) % 2);
              CruiseMapController.getInstance().changeToNorth2DView();
              CruiseMapControlPanel.this.showToast(1711669748);
            }
            else if (CruiseMapControlPanel.this.mBtnId == 2)
            {
              BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410019", "410019");
              CruiseMapControlPanel.this.locateToCarPt();
              CruiseMapControlPanel.this.showToast(1711669750);
            }
          }
        }
      });
      this.mItsButton = paramViewGroup.findViewById(1711865960);
      this.mItsImageView = ((ImageView)paramViewGroup.findViewById(1711865961));
      this.mItsVoiceButton = paramViewGroup.findViewById(1711865966);
      this.mItsVoiceImageView = ((ImageView)paramViewGroup.findViewById(1711865967));
      this.mIsItsOpen = BNSettingManager.isRoadCondOnOrOff();
      updateItsBtn();
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
    BNStatisticsManager.getInstance().onEvent("NAVI_0005", "NAVI_0005");
    if ((!this.mIsItsOpen) && (!BNSettingManager.isRoadCondOnOrOff()))
    {
      BNStatisticsManager.getInstance().onEvent("NAVI_0006", "NAVI_0006");
      if (PreferenceHelper.getInstance(this.mContext).getBoolean("NAVI_REAL_HISTORY_ITS", true))
      {
        if ((!PreferenceHelper.getInstance(this.mContext).getBoolean("FIRST_ITS_ON", true)) || (!BCruiser.getInstance().isOfflineDataDownloaded())) {
          break label129;
        }
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
          break label112;
        }
        PreferenceHelper.getInstance(this.mContext).putBoolean("FIRST_ITS_ON", false);
        showTrafficMap();
      }
    }
    label112:
    label129:
    while ((!this.mIsItsOpen) || (!BNSettingManager.isRoadCondOnOrOff()))
    {
      return;
      TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669387));
      return;
      showTrafficMap();
      return;
    }
    CruiseMapController.getInstance().showTrafficMap(false);
    BNSettingManager.setRoadCondOnOff(false);
    this.mIsItsOpen = false;
    updateItsBtn();
    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669390));
  }
  
  private void handleItsVoiceClick()
  {
    boolean bool = true;
    autoHide();
    CruiseMapController.getInstance().handleCruiseVoiceChanged(true, true);
    if (!TTSPlayerControl.isNaviMuteState()) {}
    for (;;)
    {
      this.mIsItsVoiceOpen = bool;
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
      new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(1711669372)).setContentMessage(JarUtils.getResources().getString(1711669736)).setFirstBtnText(JarUtils.getResources().getString(1711669757)).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          PreferenceHelper.getInstance(CruiseMapControlPanel.this.mContext).putBoolean("FIRST_ITS_ON", false);
          CruiseMapControlPanel.this.showTrafficMap();
        }
      }).setSecondBtnText(JarUtils.getResources().getString(1711669755)).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick() {}
      }).show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void showToast(int paramInt)
  {
    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(paramInt));
  }
  
  private void showTrafficMap()
  {
    if (NetworkUtils.isNetworkAvailable(this.mContext))
    {
      if (!isSupportTrafficMap())
      {
        TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669394));
        return;
      }
      CruiseMapController.getInstance().showTrafficMap(true);
      BNSettingManager.setRoadCondOnOff(true);
      this.mIsItsOpen = true;
      TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669388));
    }
    for (;;)
    {
      updateItsBtn();
      return;
      TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669387));
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
    BNWorkerCenter.getInstance().cancelTask(this.mHideTask, false);
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mHideTask, new BNWorkerConfig(2, 0), paramLong);
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
    if ((this.mLocationBtn == null) || (this.mItsButton == null) || (this.mCruiseZoomButtonView == null) || (this.mCruiseScaleLevelView == null) || (this.mItsVoiceButton == null) || (this.mItsImageView == null) || (this.mItsVoiceImageView == null)) {
      return;
    }
    this.mLocationBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407293));
    this.mItsImageView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407293));
    this.mItsVoiceImageView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407293));
    setLocateIcon(this.mBtnId);
    updateItsBtn();
    updateItsVoiceBtn();
    this.mCruiseZoomButtonView.onUpdateStyle(paramBoolean);
    this.mCruiseScaleLevelView.onUpdateStyle(paramBoolean);
  }
  
  public void removeLocModeRunnable()
  {
    BNWorkerCenter.getInstance().cancelTask(this.mLocCarTask, false);
  }
  
  public void resetLocMode()
  {
    this.mBtnId = 2;
    setLocateIcon(this.mBtnId);
    BNRouteGuider.getInstance().setBrowseStatus(true);
    BNWorkerCenter.getInstance().cancelTask(this.mLocCarTask, false);
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mLocCarTask, new BNWorkerConfig(2, 0), 5000L);
  }
  
  public void setControlPanelClickLis(ControlPanelClickListener paramControlPanelClickListener)
  {
    this.mControlPanelClickLis = paramControlPanelClickListener;
  }
  
  public void setLocateIcon(int paramInt)
  {
    LogUtil.e("Cruise", "set locate button icon, btn mode " + paramInt);
    if (paramInt == 1) {
      this.mLocationBtn.setImageDrawable(BNStyleManager.getDrawable(1711407312));
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        this.mLocationBtn.setImageDrawable(BNStyleManager.getDrawable(1711407311));
        return;
      }
    } while (paramInt != 2);
    this.mLocationBtn.setImageDrawable(BNStyleManager.getDrawable(1711407302));
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
    if (this.mItsImageView == null) {
      return;
    }
    this.mIsItsOpen = BNSettingManager.isRoadCondOnOrOff();
    if (this.mIsItsOpen)
    {
      this.mItsImageView.setImageDrawable(BNStyleManager.getDrawable(1711407301));
      return;
    }
    this.mItsImageView.setImageDrawable(BNStyleManager.getDrawable(1711407300));
  }
  
  public void updateItsVoiceBtn()
  {
    if (this.mItsVoiceImageView == null) {
      return;
    }
    if (!TTSPlayerControl.isNaviMuteState()) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsItsVoiceOpen = bool;
      if (!this.mIsItsVoiceOpen) {
        break;
      }
      this.mItsVoiceImageView.setImageDrawable(BNStyleManager.getRealDrawable(1711407298));
      return;
    }
    this.mItsVoiceImageView.setImageDrawable(BNStyleManager.getRealDrawable(1711407297));
  }
  
  public void updateView()
  {
    updateScale();
    updateZoomButton();
    BNMapController.getInstance().updateLayer(10);
    BNMapController.getInstance().UpdataBaseLayers();
  }
  
  public static abstract interface ControlPanelClickListener
  {
    public abstract void roadConditionClick();
    
    public abstract void viewSwitchClick();
    
    public abstract void voiceClick();
    
    public abstract void zoomInClick();
    
    public abstract void zoomOutClick();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/view/CruiseMapControlPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */