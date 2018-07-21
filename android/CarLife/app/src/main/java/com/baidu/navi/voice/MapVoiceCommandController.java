package com.baidu.navi.voice;

import android.os.Bundle;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.a.d;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.util.w;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class MapVoiceCommandController
{
  private static final String TAG = MapVoiceCommandController.class.getSimpleName();
  private static MapVoiceCommandController mInstance;
  private d mCarlifePresenter;
  
  public static MapVoiceCommandController getInstance()
  {
    if (mInstance == null) {
      mInstance = new MapVoiceCommandController();
    }
    return mInstance;
  }
  
  private void handleError()
  {
    com.baidu.carlife.m.a.a().b("当前页面不支持", 0);
    w.a("当前页面不支持");
  }
  
  private void handleVoiceCommandMsg(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    BNVoiceCommandController.getInstance().handleVoiceCommandMsg(paramInt1, paramInt2, paramInt3, paramBundle);
  }
  
  private static boolean mapMove(int paramInt1, int paramInt2)
  {
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    if (localMapStatus != null)
    {
      localObject = CoordinateTransformUtil.MC2LLE6(localMapStatus._CenterPtX, localMapStatus._CenterPtY);
      localObject = new GeoPoint(((Bundle)localObject).getInt("LLx"), ((Bundle)localObject).getInt("LLy"));
      localObject = BNMapController.getInstance().getScreenPosByGeoPos((GeoPoint)localObject);
      if (localObject != null) {}
    }
    else
    {
      return false;
    }
    ((Point)localObject).x += paramInt1;
    ((Point)localObject).y += paramInt2;
    Object localObject = BNMapController.getInstance().getGeoPosByScreenPos(((Point)localObject).x, ((Point)localObject).y);
    localObject = CoordinateTransformUtil.LL2MC(((GeoPoint)localObject).getLongitudeE6() / 100000.0D, ((GeoPoint)localObject).getLatitudeE6() / 100000.0D);
    localMapStatus._CenterPtX = ((Bundle)localObject).getInt("MCx");
    localMapStatus._CenterPtY = ((Bundle)localObject).getInt("MCy");
    NMapControlProxy.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationPos);
    return true;
  }
  
  public void cancelNavi()
  {
    i.b(TAG, "cancelNavi");
    handleVoiceCommandMsg(2, 38, 0, null);
  }
  
  public void enterCruise()
  {
    i.b(TAG, "enterCruise");
    com.baidu.carlife.m.a.a().a(com.baidu.carlife.l.a.a().N());
    h.a().showFragment(114, null);
  }
  
  public void exitCruise()
  {
    i.b(TAG, "exitCruise");
    if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
      BaiduNaviSDKManager.getInstance().quitCruise();
    }
  }
  
  public void exitCruiseFollow()
  {
    i.b(TAG, "exitCruiseFollow");
    if (BCruiser.getInstance().isCruiseBegin()) {
      EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
    }
  }
  
  public void exitNavi()
  {
    i.b(TAG, "exitNavi");
    if (BaiduNaviSDKManager.getInstance().isNaviBegin())
    {
      BaiduNaviSDKManager.getInstance().quitNavi();
      return;
    }
    handleError();
  }
  
  public void goHome()
  {
    i.b(TAG, "goHome");
    handleVoiceCommandMsg(5, 5, 0, null);
  }
  
  public void goOffice()
  {
    i.b(TAG, "goOffice");
    handleVoiceCommandMsg(5, 6, 0, null);
  }
  
  public boolean isMapContentFragment()
  {
    int i = this.mCarlifePresenter.h();
    return (i == 17) || (i == 52) || (i == 113) || (i == 116) || (i == 114) || (i == 33);
  }
  
  public boolean isMapModule()
  {
    return this.mCarlifePresenter.i() == 4003;
  }
  
  public boolean isRouteDetailFragment()
  {
    return this.mCarlifePresenter.h() == 52;
  }
  
  public void mapCarForward()
  {
    i.b(TAG, "mapCarForward");
    if (!isMapContentFragment()) {
      return;
    }
    if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
      if (RGControlPanelModel.getInstance().getLocateStatus() == 1) {
        com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
      }
    }
    for (;;)
    {
      handleVoiceCommandMsg(2, 30, 0, null);
      return;
      com.baidu.carlife.m.a.a().b("已为您切换", 0);
      continue;
      if ((BaiduNaviSDKManager.getInstance().isCruiseBegin()) || (BCruiser.getInstance().isCruiseBegin()))
      {
        if (!PreferenceHelper.getInstance(com.baidu.carlife.core.a.a()).getBoolean("SP_Last_Cruise_Map_Status", true)) {
          com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
        } else {
          com.baidu.carlife.m.a.a().b("已为您切换", 0);
        }
      }
      else if (2 == MainMapModel.getInstance().getCurLocMode()) {
        com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
      } else {
        com.baidu.carlife.m.a.a().b("已为您切换", 0);
      }
    }
  }
  
  public boolean mapMoveDown()
  {
    return mapMove(0, -BNMapController.getInstance().getScreenHeight() / 3);
  }
  
  public boolean mapMoveLeft()
  {
    return mapMove(BNMapController.getInstance().getScreenWidth() / 3, 0);
  }
  
  public boolean mapMoveLeftDown()
  {
    int i = BNMapController.getInstance().getScreenHeight();
    return mapMove(BNMapController.getInstance().getScreenWidth() / 3, -i / 3);
  }
  
  public boolean mapMoveLeftUp()
  {
    int i = BNMapController.getInstance().getScreenHeight();
    return mapMove(BNMapController.getInstance().getScreenWidth() / 3, i / 3);
  }
  
  public boolean mapMoveRight()
  {
    return mapMove(-BNMapController.getInstance().getScreenWidth() / 3, 0);
  }
  
  public boolean mapMoveRightDown()
  {
    int i = BNMapController.getInstance().getScreenHeight();
    return mapMove(-BNMapController.getInstance().getScreenWidth() / 3, -i / 3);
  }
  
  public boolean mapMoveRightUp()
  {
    int i = BNMapController.getInstance().getScreenHeight();
    return mapMove(-BNMapController.getInstance().getScreenWidth() / 3, i / 3);
  }
  
  public boolean mapMoveUp()
  {
    return mapMove(0, BNMapController.getInstance().getScreenHeight() / 3);
  }
  
  public void mapNorthForward()
  {
    i.b(TAG, "mapNorthForward");
    if (!isMapContentFragment()) {
      return;
    }
    if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
      if (RGControlPanelModel.getInstance().getLocateStatus() == 2) {
        com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
      }
    }
    for (;;)
    {
      handleVoiceCommandMsg(2, 29, 0, null);
      return;
      com.baidu.carlife.m.a.a().b("已为您切换", 0);
      continue;
      if ((BaiduNaviSDKManager.getInstance().isCruiseBegin()) || (BCruiser.getInstance().isCruiseBegin()))
      {
        if (PreferenceHelper.getInstance(com.baidu.carlife.core.a.a()).getBoolean("SP_Last_Cruise_Map_Status", true)) {
          com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
        } else {
          com.baidu.carlife.m.a.a().b("已为您切换", 0);
        }
      }
      else if (1 == MainMapModel.getInstance().getCurLocMode()) {
        com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
      } else {
        com.baidu.carlife.m.a.a().b("已为您切换", 0);
      }
    }
  }
  
  public void mapZoomIn()
  {
    i.b(TAG, "mapZoomIn");
    if (!isMapContentFragment()) {
      return;
    }
    if (BNMapController.getInstance().getZoomLevel() >= 20) {
      com.baidu.carlife.m.a.a().b("已为最大模式", 0);
    }
    for (;;)
    {
      handleVoiceCommandMsg(2, 3, 0, null);
      return;
      com.baidu.carlife.m.a.a().b("地图已放大", 0);
    }
  }
  
  public void mapZoomOut()
  {
    i.b(TAG, "mapZoomOut");
    if (!isMapContentFragment()) {
      return;
    }
    if (BNMapController.getInstance().getZoomLevel() <= 3) {
      com.baidu.carlife.m.a.a().b("已为最小模式", 0);
    }
    for (;;)
    {
      handleVoiceCommandMsg(2, 2, 0, null);
      return;
      com.baidu.carlife.m.a.a().b("地图已缩小", 0);
    }
  }
  
  public void nameSearch(String paramString)
  {
    i.b(TAG, "nameSearch key: " + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("poiname", paramString);
    handleVoiceCommandMsg(5, 3, 0, localBundle);
  }
  
  public void naviContinue()
  {
    i.b(TAG, "naviContinue");
    if (BaiduNaviSDKManager.getInstance().isNaviBegin())
    {
      if (RGControlPanelModel.getInstance().getFullviewState())
      {
        com.baidu.carlife.m.a.a().b("已为您切换", 0);
        BNavigator.getInstance().enterNavState();
        return;
      }
      com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
      return;
    }
    handleError();
  }
  
  public void naviFullView()
  {
    i.b(TAG, "naviFullView");
    if (BaiduNaviSDKManager.getInstance().isNaviBegin())
    {
      if (!RGControlPanelModel.getInstance().getFullviewState())
      {
        com.baidu.carlife.m.a.a().b("已为您切换", 0);
        BNavigator.getInstance().onVoiceCommand(2, 16, 0, null, true);
        return;
      }
      com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
      return;
    }
    handleError();
  }
  
  public void openNavi()
  {
    this.mCarlifePresenter.e();
  }
  
  public void selectRoute(int paramInt)
  {
    i.b(TAG, "selectRoute index: " + paramInt);
    handleVoiceCommandMsg(2, 67, paramInt, null);
  }
  
  public void selectRouteAndStartNavi(int paramInt)
  {
    i.b(TAG, "selectRouteAndStartNavi index: " + paramInt);
    handleVoiceCommandMsg(2, 66, paramInt, null);
  }
  
  public void setCarlifePresenter(d paramd)
  {
    this.mCarlifePresenter = paramd;
  }
  
  public void setCompanyAddress(RoutePlanNode paramRoutePlanNode)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("select_point_action", 5);
    UIModel.settingAddress(paramRoutePlanNode, com.baidu.carlife.core.a.a(), localBundle);
  }
  
  public void setHomeAddress(RoutePlanNode paramRoutePlanNode)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("select_point_action", 4);
    UIModel.settingAddress(paramRoutePlanNode, com.baidu.carlife.core.a.a(), localBundle);
  }
  
  public void spaceSearch(String paramString)
  {
    i.b(TAG, "spaceSearch key: " + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("poiname", paramString);
    handleVoiceCommandMsg(5, 4, 0, localBundle);
  }
  
  public void startCalcRoute(double paramDouble1, double paramDouble2)
  {
    Object localObject = CoordinateTransformUtil.transferGCJ02ToBD09(paramDouble1, paramDouble2);
    if (!((GeoPoint)localObject).isValid()) {}
    do
    {
      return;
      localObject = new com.baidu.carlife.core.screen.a(((GeoPoint)localObject).getLongitudeE6() / 100000.0D, ((GeoPoint)localObject).getLatitudeE6() / 100000.0D);
    } while (this.mCarlifePresenter == null);
    this.mCarlifePresenter.a((com.baidu.carlife.core.screen.a)localObject);
  }
  
  public void startNavi()
  {
    i.b(TAG, "startNavi");
    if (isRouteDetailFragment())
    {
      handleVoiceCommandMsg(2, 65, 0, null);
      return;
    }
    handleError();
  }
  
  public void switchDayNightMode(boolean paramBoolean)
  {
    i.b(TAG, "switchDayNightMode isDay: " + paramBoolean);
    if (!isMapContentFragment()) {
      return;
    }
    if (paramBoolean)
    {
      if (StyleManager.getDayStyle()) {
        com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
      }
      for (;;)
      {
        handleVoiceCommandMsg(2, 32, 0, null);
        return;
        com.baidu.carlife.m.a.a().b("已为您切换", 0);
      }
    }
    if (!StyleManager.getDayStyle()) {
      com.baidu.carlife.m.a.a().b("当前已为该模式", 0);
    }
    for (;;)
    {
      handleVoiceCommandMsg(2, 31, 0, null);
      return;
      com.baidu.carlife.m.a.a().b("已为您切换", 0);
    }
  }
  
  public void switchNaviVoiceMode(boolean paramBoolean)
  {
    i.b(TAG, "switchNaviVoiceMode isNewerMode: " + paramBoolean);
    if (paramBoolean)
    {
      handleVoiceCommandMsg(2, 33, 0, null);
      return;
    }
    handleVoiceCommandMsg(2, 34, 0, null);
  }
  
  public void switchRoadCondition(boolean paramBoolean)
  {
    i.b(TAG, "switchRoadCondition isEnable: " + paramBoolean);
    if (paramBoolean)
    {
      if (BNSettingManager.isRoadCondOnOrOff()) {
        com.baidu.carlife.m.a.a().b("当前路况已开启", 0);
      }
      for (;;)
      {
        handleVoiceCommandMsg(2, 7, 0, null);
        return;
        com.baidu.carlife.m.a.a().b("路况已开启", 0);
      }
    }
    if (!BNSettingManager.isRoadCondOnOrOff()) {
      com.baidu.carlife.m.a.a().b("当前路况已关闭", 0);
    }
    for (;;)
    {
      handleVoiceCommandMsg(2, 8, 0, null);
      return;
      com.baidu.carlife.m.a.a().b("路况已关闭", 0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/voice/MapVoiceCommandController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */