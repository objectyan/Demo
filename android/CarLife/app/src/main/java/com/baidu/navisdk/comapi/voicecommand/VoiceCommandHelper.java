package com.baidu.navisdk.comapi.voicecommand;

import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class VoiceCommandHelper
{
  private static boolean MapMove(int paramInt1, int paramInt2)
  {
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    if (localMapStatus != null)
    {
      Object localObject = CoordinateTransformUtil.MC2LLE6(localMapStatus._CenterPtX, localMapStatus._CenterPtY);
      localObject = new GeoPoint(((Bundle)localObject).getInt("LLx"), ((Bundle)localObject).getInt("LLy"));
      localObject = BNMapController.getInstance().getScreenPosByGeoPos((GeoPoint)localObject);
      ((Point)localObject).x += paramInt1;
      ((Point)localObject).y += paramInt2;
      localObject = BNMapController.getInstance().getGeoPosByScreenPos(((Point)localObject).x, ((Point)localObject).y);
      localObject = CoordinateTransformUtil.LL2MC(((GeoPoint)localObject).getLongitudeE6() / 100000.0D, ((GeoPoint)localObject).getLatitudeE6() / 100000.0D);
      localMapStatus._CenterPtX = ((Bundle)localObject).getInt("MCx");
      localMapStatus._CenterPtY = ((Bundle)localObject).getInt("MCy");
      NMapControlProxy.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationPos);
      return true;
    }
    return false;
  }
  
  public static boolean MapMoveDown()
  {
    return MapMove(0, -BNMapController.getInstance().getScreenHeight() / 3);
  }
  
  public static boolean MapMoveLeft()
  {
    return MapMove(-BNMapController.getInstance().getScreenWidth() / 3, 0);
  }
  
  public static boolean MapMoveRight()
  {
    return MapMove(BNMapController.getInstance().getScreenWidth() / 3, 0);
  }
  
  public static boolean MapMoveUp()
  {
    return MapMove(0, BNMapController.getInstance().getScreenHeight() / 3);
  }
  
  public static boolean help()
  {
    return true;
  }
  
  public static boolean lockPhone()
  {
    return true;
  }
  
  public static boolean onITSChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (!BNSettingManager.isRoadCondOnOrOff())) {
      if (BNSettingManager.isNaviRealHistoryITS())
      {
        if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
          break label49;
        }
        BNMapController.getInstance().showTrafficMap(true);
        BNSettingManager.setRoadCondOnOff(true);
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(1711669388));
      }
    }
    label49:
    while ((paramBoolean) || (!PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getBoolean("NAVI_ROADCOND_ON_OFF", false)))
    {
      return true;
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(1711669387));
      return true;
    }
    BNMapController.getInstance().showTrafficMap(false);
    BNSettingManager.setRoadCondOnOff(false);
    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(1711669390));
    return true;
  }
  
  public static boolean switchAR()
  {
    String str = RouteGuideFSM.getInstance().getCurrentState();
    int i = 0;
    while ((i < 5) && (!"HUD".equals(str)) && (!RouteGuideFSM.getInstance().isBaseState()))
    {
      RouteGuideFSM.getInstance().run("[返回]按钮点击");
      str = RouteGuideFSM.getInstance().getCurrentState();
      i += 1;
    }
    if ("HUD".equals(str)) {
      RouteGuideFSM.getInstance().run("[AR]按钮点击");
    }
    for (;;)
    {
      return true;
      if (RouteGuideFSM.getInstance().isBaseState()) {
        RouteGuideFSM.getInstance().run("[AR]按钮点击");
      }
    }
  }
  
  public static boolean switchHUD()
  {
    String str = RouteGuideFSM.getInstance().getCurrentState();
    int i = 0;
    while ((i < 5) && (!"HUD".equals(str)) && (!RouteGuideFSM.getInstance().isBaseState()))
    {
      RouteGuideFSM.getInstance().run("[返回]按钮点击");
      str = RouteGuideFSM.getInstance().getCurrentState();
      i += 1;
    }
    if (RouteGuideFSM.getInstance().isBaseState()) {
      RouteGuideFSM.getInstance().run("[HUD]按钮点击");
    }
    return true;
  }
  
  public static boolean switchHUDMirror()
  {
    String str = RouteGuideFSM.getInstance().getCurrentState();
    int i = 0;
    while ((i < 5) && (!"HUDMirror".equals(str)) && (!"HUD".equals(str)) && (!RouteGuideFSM.getInstance().isBaseState()))
    {
      RouteGuideFSM.getInstance().run("[返回]按钮点击");
      str = RouteGuideFSM.getInstance().getCurrentState();
      i += 1;
    }
    if ("HUD".equals(str)) {
      RouteGuideFSM.getInstance().run("从HUD去HUD镜像页");
    }
    for (;;)
    {
      return true;
      if (RouteGuideFSM.getInstance().isBaseState()) {
        RouteGuideFSM.getInstance().run("从HUD去HUD镜像页");
      }
    }
  }
  
  public static boolean switchNaviMode()
  {
    if (RouteGuideFSM.getInstance().isBaseState()) {
      RouteGuideFSM.getInstance().run("[回车位]按钮点击");
    }
    for (;;)
    {
      return true;
      int i = 0;
      while ((i < 5) && (!RouteGuideFSM.getInstance().isBaseState()))
      {
        RouteGuideFSM.getInstance().run("[返回]按钮点击");
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/voicecommand/VoiceCommandHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */