package com.baidu.navi;

import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;

public class BaiduNaviSDKManager
{
  public static final String TAG = BaiduNaviSDKManager.class.getSimpleName();
  private static volatile BaiduNaviSDKManager mInstance = null;
  
  public static BaiduNaviSDKManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BaiduNaviSDKManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  public void closeNaviInstant()
  {
    JNIGuidanceControl.getInstance().setFuncConfigParams(true, RGMultiRouteModel.DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS, 1);
  }
  
  public void enterNavState()
  {
    BNavigator.getInstance().enterNavState();
  }
  
  public boolean isCruiseBegin()
  {
    return BCruiser.getInstance().isCruiseBegin();
  }
  
  public boolean isNaviBegin()
  {
    return BNavigator.getInstance().isNaviBegin();
  }
  
  public boolean isNaviMuteState()
  {
    return TTSPlayerControl.isNaviMuteState();
  }
  
  public void quitCruise()
  {
    BCruiser.getInstance().notifyCruiseFragmentQuitCruise();
  }
  
  public void quitNavi()
  {
    BNavigator.getInstance().quitNavi();
  }
  
  public void reInitCruiseLocationService()
  {
    BCruiser.getInstance().reInitLocationService();
  }
  
  public void reInitNaviLocationService(int paramInt)
  {
    BNavigator.getInstance().reInitLocationService(paramInt);
  }
  
  public void reInitTrackLocationService()
  {
    NavTrajectoryController.getInstance().reInitLocationService();
  }
  
  public void setNaviMuteState(boolean paramBoolean)
  {
    TTSPlayerControl.setNaviMuteState(paramBoolean);
  }
  
  public void updateNaviInstant()
  {
    BNRoutePlaner.getInstance().updateFuncConfigParams();
  }
  
  public void updateRGEngineSpeekStatus()
  {
    BNavigator.getInstance().updateRGEngineSpeekStatus();
  }
  
  public void updateWGS84Location(LocData paramLocData1, LocData paramLocData2)
  {
    BNExtGPSLocationManager.getInstance().updateWGS84Location(paramLocData1, paramLocData2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/BaiduNaviSDKManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */