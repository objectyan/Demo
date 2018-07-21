package com.baidu.navisdk.ui.routeguide.mapmode.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.iview.IMoreSettingView;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.BlueToothListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreSettingPresenter
{
  private static String TAG = "RouteGuide";
  private IMoreSettingView mMoreSettingView;
  
  public MoreSettingPresenter(IMoreSettingView paramIMoreSettingView)
  {
    this.mMoreSettingView = paramIMoreSettingView;
  }
  
  public void addUserOP(String paramString)
  {
    UserOPController.getInstance().add(paramString);
  }
  
  public void addUserOP(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    UserOPController.getInstance().add(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean checkPlate(String paramString)
  {
    return Pattern.compile("^[\\u4e00-\\u9fa5]{1}[A-Z_0-9]{6,7}$").matcher(paramString).matches();
  }
  
  public void getPlateFromLocal(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = BNSettingManager.getPlateFromLocal(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        this.mMoreSettingView.showCarPlate(paramContext);
      }
    }
    else
    {
      return;
    }
    paramContext = BNSettingManager.getOwnerCarPlate();
    this.mMoreSettingView.showCarPlate(paramContext);
  }
  
  public void getVoiceName()
  {
    Object localObject = VoiceHelper.getInstance().getCurrentUsedTTSId();
    if ((localObject == null) || ("2-201526".equals(localObject))) {}
    for (localObject = JarUtils.getResources().getString(1711670105);; localObject = ((VoiceInfo)localObject).name)
    {
      this.mMoreSettingView.updateVoiceName((String)localObject);
      do
      {
        return;
        localObject = VoiceHelper.getInstance().getVoiceInfo((String)localObject);
      } while (localObject == null);
    }
  }
  
  public void handleCheckPlateSuccess(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    BNSettingManager.setCarPlateToLocal(paramContext, paramString);
    BNRoutePlaner.getInstance().setCalcPrefCarNo(paramString);
  }
  
  public void initActionSwitchSetting()
  {
    int i = BNSettingManager.getVoiceMode();
    if (i == 0)
    {
      this.mMoreSettingView.getVoiceMode(0);
      if (BNSettingManager.getMapMode() != 1) {
        break label119;
      }
      this.mMoreSettingView.getMapMode(0);
      label35:
      i = BNSettingManager.getNaviDayAndNightMode();
      if (i != 1) {
        break label132;
      }
      this.mMoreSettingView.getNaviDayAndNightMode(0);
      label54:
      if (BNSettingManager.getIsShowMapSwitch() != 1) {
        break label163;
      }
      this.mMoreSettingView.getIsShowMapSwitch(1);
    }
    for (;;)
    {
      if (BNSettingManager.getPlayTTsVoiceMode() != 0) {
        break label176;
      }
      this.mMoreSettingView.getPlayTTsVoiceMode(0);
      return;
      if (i == 1)
      {
        this.mMoreSettingView.getVoiceMode(1);
        break;
      }
      this.mMoreSettingView.getVoiceMode(2);
      break;
      label119:
      this.mMoreSettingView.getMapMode(1);
      break label35;
      label132:
      if (i == 2)
      {
        this.mMoreSettingView.getNaviDayAndNightMode(1);
        break label54;
      }
      this.mMoreSettingView.getNaviDayAndNightMode(2);
      break label54;
      label163:
      this.mMoreSettingView.getIsShowMapSwitch(0);
    }
    label176:
    this.mMoreSettingView.getPlayTTsVoiceMode(1);
  }
  
  public void initPlateFromLocal(Context paramContext)
  {
    if (paramContext != null)
    {
      str = BNSettingManager.getPlateFromLocal(paramContext);
      if (!TextUtils.isEmpty(str)) {
        this.mMoreSettingView.showCarPlate(str);
      }
    }
    else
    {
      return;
    }
    String str = BNSettingManager.getOwnerCarPlate();
    if (!StringUtils.isEmpty(str))
    {
      this.mMoreSettingView.showCarPlate(str);
      return;
    }
    BNaviModuleManager.fetchCarOwnerData(paramContext);
  }
  
  public void initRedGuide()
  {
    if (!BNSettingManager.getFristBlueToothChannelGuide()) {
      this.mMoreSettingView.onBlueToothRedGuide(true);
    }
    if (!BNSettingManager.getFirsCarLogoGuide()) {
      this.mMoreSettingView.onCarLogoRedGuide(true);
    }
    if (!BNSettingManager.getFirstVoiceGuide()) {
      this.mMoreSettingView.onVoiceRedGuide(true);
    }
  }
  
  public boolean[] initUserConfig()
  {
    boolean[] arrayOfBoolean = new boolean[8];
    try
    {
      arrayOfBoolean[3] = BNSettingManager.getPrefRealEnlargementNavi();
      arrayOfBoolean[4] = BNSettingManager.getColladaStatus();
      arrayOfBoolean[2] = BNSettingManager.isAutoLevelMode();
      arrayOfBoolean[6] = BNSettingManager.getPrefParkSearch();
      arrayOfBoolean[7] = BNSettingManager.getPrefFloatSwitch();
      arrayOfBoolean[1] = BlueToothListener.sIsOpenBTChannel;
      arrayOfBoolean[5] = BNSettingManager.getShowCarLogoToEnd();
      arrayOfBoolean[0] = RGCarPreferSettingController.getInstance().isCarLimitOpen();
      return arrayOfBoolean;
    }
    catch (Exception localException) {}
    return arrayOfBoolean;
  }
  
  public void onChangeAngleFollowModeSetting()
  {
    UserOPController.getInstance().add("3.5.1", "", null, "2");
    RouteGuideFSM.getInstance().cacheBackMapState("Car3D");
    BNavigator.getInstance().enterNavState();
    BNSettingManager.setMapMode(1);
  }
  
  public void onChangeAngleHUDModeSetting()
  {
    UserOPController.getInstance().add("3.5.4");
    RouteGuideFSM.getInstance().run("[HUD]按钮点击");
  }
  
  public void onChangeAngleTrueNorthModeSetting()
  {
    UserOPController.getInstance().add("3.5.1", null, "", "2");
    RouteGuideFSM.getInstance().cacheBackMapState("North2D");
    BNavigator.getInstance().enterNavState();
    BNSettingManager.setMapMode(2);
  }
  
  public void onChangeConciseVoiceModeSetting()
  {
    BNSettingManager.resetVoiceModeParams(1);
    this.mMoreSettingView.setVoiceSpeakSetting(0, 1);
    BNSettingManager.setLastVoiceMode(1);
  }
  
  public void onChangeDetailVoiceModeSetting()
  {
    BNSettingManager.resetVoiceModeParams(0);
    this.mMoreSettingView.setVoiceSpeakSetting(0, 0);
    BNSettingManager.setLastVoiceMode(0);
  }
  
  public void onChangeQuiteVoiceModeSetting()
  {
    BNSettingManager.resetVoiceModeParams(2);
    this.mMoreSettingView.setVoiceSpeakSetting(0, 2);
  }
  
  public void onSettingsChange(boolean[] paramArrayOfBoolean, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
    case 3: 
    case 4: 
    case 2: 
    case 6: 
    case 7: 
      for (;;)
      {
        try
        {
          this.mMoreSettingView.updateCheckDrawable(paramInt);
          return;
        }
        catch (Throwable paramArrayOfBoolean)
        {
          LogUtil.e(TAG, "onSettingsChange exception ->" + paramArrayOfBoolean.getMessage());
          return;
        }
        BNSettingManager.setPrefRealEnlargementNavi(paramArrayOfBoolean[paramInt]);
        continue;
        BNSettingManager.setColladaStatus(paramArrayOfBoolean[paramInt]);
        continue;
        BNSettingManager.setAutoLevelMode(paramArrayOfBoolean[paramInt]);
        continue;
        BNSettingManager.setPrefParkSearch(paramArrayOfBoolean[paramInt]);
        continue;
        BNSettingManager.setPrefFloatSwitch(paramArrayOfBoolean[paramInt]);
      }
    }
    for (;;)
    {
      int i;
      this.mMoreSettingView.onCarPlateInputLayoutVisible(i);
      RGCarPreferSettingController.getInstance().setCarLimitOpen(paramArrayOfBoolean[paramInt]);
      break;
      int j = paramArrayOfBoolean[paramInt];
      BNSettingManager.setShowCarLogoToEnd(j);
      BNMapController.getInstance().setRedLineRender(j);
      break;
      if (paramArrayOfBoolean[paramInt] != 0) {
        i = 0;
      } else {
        i = 8;
      }
    }
  }
  
  public void setBlueToothChannelGuide(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    if (!paramBoolean)
    {
      BNSettingManager.setFristBlueToothChannelGuide(true);
      this.mMoreSettingView.showBlueToothChannelGuide(BlueToothListener.isBTConnect);
      return;
    }
    BNSettingManager.setBlueToothPhoneChannel(false);
    RGMapModeViewController.getInstance().closeSCO(11);
  }
  
  public void setCarLogo()
  {
    UserOPController.getInstance().add("3.5.b");
    BNSettingManager.setFirstCarLogoGuide(true);
    this.mMoreSettingView.onCarLogoRedGuide(false);
    this.mMoreSettingView.jumpCarLogoPage();
  }
  
  public void setNaviDayAndNightMode(int paramInt)
  {
    BNSettingManager.setNaviDayAndNightMode(paramInt);
  }
  
  public void setPlayTTSMusicMode(int paramInt)
  {
    BNSettingManager.setPlayTTsVoiceMode(paramInt);
  }
  
  public void setRouteConditionOverView(int paramInt)
  {
    BNSettingManager.setIsShowMapSwitch(paramInt);
    RGViewController.getInstance().showAssistMapSwitch();
  }
  
  public void updatePreferValue(int paramInt, boolean paramBoolean)
  {
    RGCarPreferSettingController.getInstance().updatePreferValue(paramInt, paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/presenter/MoreSettingPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */