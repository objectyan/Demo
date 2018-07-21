package com.baidu.navisdk.lightnavi.viewhelp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.IItsClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.ILocationBtnClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanelSimple;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapController;

public class LightNaviMapHelper
{
  private static volatile LightNaviMapHelper mInstance;
  private boolean isRoadCondNeedOpen = false;
  private boolean mAddMapCtrlPanel = true;
  private Context mContext;
  private DistrictInfo mDistrict;
  private boolean mFirstItsOn = false;
  public BNMapControlPanel.IItsClickListener mItsClickListener = new BNMapControlPanel.IItsClickListener()
  {
    public void onClickIts()
    {
      UserOPController.getInstance().add("4.2");
      LightNaviMapHelper.access$002(LightNaviMapHelper.this, BNSettingManager.isFirstItsOn());
      GeoPoint localGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getWidthPixels() / 2, ScreenUtil.getInstance().getHeightPixels() / 2);
      if ((localGeoPoint != null) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))) {
        LightNaviMapHelper.access$102(LightNaviMapHelper.this, BNPoiSearcher.getInstance().getDistrictByPoint(localGeoPoint, 0));
      }
      if (!BNSettingManager.isIpoRoadCondOnOrOff())
      {
        if (PreferenceHelper.getInstance(LightNaviMapHelper.this.mContext).getBoolean("NAVI_REAL_HISTORY_ITS", true))
        {
          if (LightNaviMapHelper.this.mFirstItsOn) {
            BNSettingManager.setFirstItsOn(false);
          }
          if (NetworkUtils.isNetworkAvailable(LightNaviMapHelper.this.mContext))
          {
            BNMapController.getInstance().switchITSMode(true);
            BNMapController.getInstance().showTrafficMap(true);
            BNSettingManager.setIpoRoadCondOnOff(true);
            BNaviModuleManager.setIPORCToMap(true);
            if ((LightNaviMapHelper.this.mDistrict == null) || (BNMapController.getInstance().checkRoadConditionSupport(LightNaviMapHelper.this.mDistrict.mId))) {
              break label194;
            }
            TipTool.onCreateToastDialog(LightNaviMapHelper.this.mContext, JarUtils.getResources().getString(1711669394));
          }
        }
        return;
        label194:
        TipTool.onCreateToastDialog(LightNaviMapHelper.this.mContext, JarUtils.getResources().getString(1711670038));
        return;
      }
      BNMapController.getInstance().showTrafficMap(false);
      BNSettingManager.setIpoRoadCondOnOff(false);
      BNaviModuleManager.setIPORCToMap(false);
    }
  };
  private BNMessageDialog mItsSettingAlertDialog;
  private BNMapControlPanelSimple mMapControlPanel;
  private boolean mShowTwoBtn = true;
  
  private LightNaviMapHelper(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static LightNaviMapHelper getInstance(Context paramContext)
  {
    if (mInstance == null) {
      mInstance = new LightNaviMapHelper(paramContext);
    }
    return mInstance;
  }
  
  private void showItsSettingDialog()
  {
    if (this.mItsSettingAlertDialog == null)
    {
      this.mItsSettingAlertDialog = new BNMessageDialog((Activity)this.mContext);
      this.mItsSettingAlertDialog.setTitleText(BNStyleManager.getString(1711669681));
      this.mItsSettingAlertDialog.setMessage(BNStyleManager.getString(1711670189));
      this.mItsSettingAlertDialog.setFirstBtnText(BNStyleManager.getString(1711669686));
      this.mItsSettingAlertDialog.setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          if (LightNaviMapHelper.this.mContext == null) {}
          while (LightNaviMapHelper.this.mItsSettingAlertDialog == null) {
            return;
          }
          LightNaviMapHelper.this.mItsSettingAlertDialog.dismiss();
          LightNaviMapHelper.access$302(LightNaviMapHelper.this, null);
        }
      });
    }
    this.mItsSettingAlertDialog.show();
  }
  
  public void checkITSRoad()
  {
    if ((BNLightNaviManager.getInstance().getType() == 2) && (BNSettingManager.isIpoRoadCondOnOrOff()) && (PreferenceHelper.getInstance(this.mContext).getBoolean("NAVI_REAL_HISTORY_ITS", true)))
    {
      BNMapController.getInstance().switchITSMode(true);
      BNMapController.getInstance().showTrafficMap(true);
    }
  }
  
  public void colsedRoadCond()
  {
    if (BNSettingManager.isIpoRoadCondOnOrOff())
    {
      this.isRoadCondNeedOpen = true;
      BNMapController.getInstance().showTrafficMap(false);
      BNSettingManager.setIpoRoadCondOnOff(false);
    }
  }
  
  public void handleScrollGesture()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.handleScrollGesture();
    }
  }
  
  public void handleSingleTouchGesture()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.handleSingleTouchGesture();
    }
  }
  
  public void loadMapCtrlPanel(View paramView, boolean paramBoolean1, boolean paramBoolean2, BNMapControlPanel.ILocationBtnClickListener paramILocationBtnClickListener)
  {
    this.mShowTwoBtn = paramBoolean1;
    this.mAddMapCtrlPanel = paramBoolean2;
    reloadMapControlPanel(paramView, paramILocationBtnClickListener);
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setVisible(true);
    }
  }
  
  public void mapSetting()
  {
    MapController localMapController = BNMapController.getInstance().getMapController();
    if ((localMapController != null) && (localMapController.get3DGestureEnable() == true)) {
      BNMapController.getInstance().getMapController().set3DGestureEnable(false);
    }
    if (BNLightNaviManager.getInstance().getType() == 2) {
      BNMapController.getInstance().setSlightScreenStatus(2);
    }
    for (;;)
    {
      BNRoutePlaner.getInstance().SetRouteSpec(false);
      BNRouteGuider.getInstance().setBrowseStatus(true);
      if (BNLightNaviManager.getInstance().getType() != 2) {
        break;
      }
      BNMapController.getInstance().setNightMode(false);
      return;
      BNMapController.getInstance().setSlightScreenStatus(1);
    }
    BNMapController.getInstance().setNightMode(true);
  }
  
  public void onPause()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.onResume();
    }
  }
  
  public void openRoadCond()
  {
    if (this.isRoadCondNeedOpen)
    {
      this.isRoadCondNeedOpen = false;
      BNMapController.getInstance().showTrafficMap(true);
      BNSettingManager.setIpoRoadCondOnOff(true);
    }
  }
  
  public void reloadMapControlPanel(View paramView, BNMapControlPanel.ILocationBtnClickListener paramILocationBtnClickListener)
  {
    if ((paramView == null) || (this.mContext == null)) {}
    while (!this.mAddMapCtrlPanel) {
      return;
    }
    this.mMapControlPanel = new BNMapControlPanelSimple(this.mContext, paramView, this.mShowTwoBtn);
    this.mMapControlPanel.onUpdateStyle(true);
    this.mMapControlPanel.updateView();
    this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
    this.mMapControlPanel.setLocationBtnClickListener(paramILocationBtnClickListener);
  }
  
  public void unInit()
  {
    mInstance = null;
  }
  
  public void updateView()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.updateView();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/viewhelp/LightNaviMapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */