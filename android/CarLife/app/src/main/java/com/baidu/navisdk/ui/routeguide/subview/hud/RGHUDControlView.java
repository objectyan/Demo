package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.RGBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGHUDControlView
  extends RGBaseView
{
  private static final String TAG = "HUD";
  private RGHUDDialog mHudDialog = null;
  private boolean mIsStraight = false;
  private ImageView trigger;
  
  public RGHUDControlView(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || (this.mHudDialog == null))
    {
      this.mHudDialog = new RGHUDDialog(paramActivity, 16973833, paramBoolean);
      updateLatestData();
      this.mHudDialog.setOnDismissListener(new RGHUDControlView.1(this));
    }
  }
  
  @Deprecated
  public void destory()
  {
    this.mHudDialog = null;
    if (this.trigger != null)
    {
      this.trigger.setImageDrawable(null);
      this.trigger.setBackgroundDrawable(null);
      this.trigger = null;
    }
  }
  
  public void dismiss()
  {
    if ((this.mHudDialog != null) && (this.mHudDialog.isShowing())) {}
    try
    {
      this.mHudDialog.dismiss();
      BNMapController.getInstance().onResume();
      return;
    }
    catch (Exception localException) {}
  }
  
  public RGHUDDialog getHudWidget()
  {
    return this.mHudDialog;
  }
  
  public void hide()
  {
    if ((this.mHudDialog != null) && (this.mHudDialog.isShowing())) {}
    try
    {
      this.mHudDialog.hide();
      BNMapController.getInstance().onResume();
      XDVoiceInstructManager.getInstance().setWakeupEnable(true);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean isVisibility()
  {
    return this.mHudDialog.isShowing();
  }
  
  public void onOrientationChanged()
  {
    if (this.mHudDialog != null)
    {
      this.mHudDialog.onOrientationChanged();
      if (RGHUDDataModel.getInstance().isYaw()) {
        showSuitableView();
      }
    }
    else
    {
      return;
    }
    updateLatestData();
  }
  
  public void restoreData(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("hud_updatetype", -1) == 2)
    {
      restoreHighWayData(paramBundle);
      return;
    }
    int i = paramBundle.getInt("hud_resid", -1);
    if (-1 != i)
    {
      LogUtil.e("HUD", "setTurnIcon ===> " + i);
      this.mHudDialog.setTurnIcon(i);
    }
    i = paramBundle.getInt("hud_remaindist", -1);
    Object localObject2 = RGSimpleGuideModel.getInstance().getFormatAfterMeters(i);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = new Bundle();
      BNRouteGuider.getInstance().getSimpleMapInfo((Bundle)localObject3);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (((Bundle)localObject3).containsKey("remain_dist"))
        {
          i = ((Bundle)localObject3).getInt("remain_dist");
          localObject3 = new StringBuffer();
          StringUtils.formatDistance(i, StringUtils.UnitLangEnum.ZH, (StringBuffer)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((StringBuffer)localObject3).toString();
          }
        }
      }
    }
    if (localObject1 != null)
    {
      LogUtil.e("HUD", "setRemainDistance ===> " + (String)localObject1);
      this.mHudDialog.setNormalGoMeters((String)localObject1);
    }
    Object localObject3 = paramBundle.getString("hud_nextroad");
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (((String)localObject3).length() != 0) {}
    }
    else
    {
      localObject2 = JarUtils.getResources().getString(1711669540);
    }
    LogUtil.e("HUD", "setDirectRoadName ===> " + (String)localObject2);
    this.mHudDialog.setRoadName((String)localObject2);
    localObject2 = paramBundle.getString("hud_head_angle");
    if (localObject2 != null)
    {
      LogUtil.e("HUD", "setDirection ===> " + (String)localObject2);
      this.mHudDialog.setDirection((String)localObject2);
    }
    boolean bool = paramBundle.getBoolean("hud_straight");
    RGHUDDataModel.getInstance().setSimpleGuideAlong(bool);
    if (bool)
    {
      if (localObject1 != null) {
        this.mHudDialog.setDirectRemainDistance((String)localObject1);
      }
      paramBundle = paramBundle.getString("hud_currentroad");
      if (paramBundle != null) {
        this.mHudDialog.setDirectRoadName(paramBundle);
      }
    }
    showSuitableView();
  }
  
  public void restoreHighWayData(Bundle paramBundle)
  {
    int i = paramBundle.getInt("hud_highway_exitdirection");
    if (RGHighwayModel.getInstance().isTurnIconTypeValid(i)) {
      this.mHudDialog.setHighWayTurnIcon(i);
    }
    i = paramBundle.getInt("hud_exitremaindistance");
    if (i >= 0) {
      this.mHudDialog.setHighWayRemainDistance(RGSimpleGuideModel.getInstance().getFormatAfterMeters(i));
    }
    Object localObject = paramBundle.getString("hud_highway_exiticcode");
    if (!StringUtils.isEmpty((String)localObject))
    {
      RGHUDDataModel.getInstance().setHasExitCode(true);
      this.mHudDialog.setHighWayExitCode((String)localObject);
    }
    for (;;)
    {
      localObject = paramBundle.getString("hud_highway_directionname");
      if (StringUtils.isEmpty((String)localObject)) {
        break label165;
      }
      paramBundle = ((String)localObject).split(",");
      localObject = new StringBuffer();
      i = 0;
      while (i < paramBundle.length)
      {
        ((StringBuffer)localObject).append(" ");
        ((StringBuffer)localObject).append(paramBundle[i]);
        i += 1;
      }
      RGHUDDataModel.getInstance().setHasExitCode(false);
    }
    this.mHudDialog.setHighWayExitRoad(((StringBuffer)localObject).toString());
    label165:
    do
    {
      return;
      paramBundle = paramBundle.getString("hud_exitnextroad");
    } while (StringUtils.isEmpty(paramBundle));
    this.mHudDialog.setHighWayExitRoad(paramBundle);
  }
  
  public void setMirrorFlagBeforeShow(boolean paramBoolean)
  {
    this.mHudDialog.setMirrorFlagBeforeShow(paramBoolean);
  }
  
  public void show()
  {
    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410283", "410283");
    this.mHudDialog.show();
    updateLatestData();
    LogUtil.e("HUD", "mHudDialog isShowing: " + this.mHudDialog.isShowing());
    BNMapController.getInstance().onPause();
    XDVoiceInstructManager.getInstance().closePanel();
    XDVoiceInstructManager.getInstance().setWakeupEnable(false);
  }
  
  public void showDirectRoadInfoView(boolean paramBoolean)
  {
    this.mHudDialog.justSetDirectRoadInfoVisibility(paramBoolean);
  }
  
  public void showNormalRoadInfoView(boolean paramBoolean)
  {
    this.mHudDialog.justSetNormalRoadInfoVisibility(paramBoolean);
  }
  
  public void showSuitableView()
  {
    try
    {
      if ((BNavConfig.pRGLocateMode == 1) || (BNavConfig.pRGLocateMode == 5)) {
        this.mHudDialog.updateHudLocate(false);
      }
      if (RGHUDDataModel.getInstance().isYaw())
      {
        this.mHudDialog.updateHudYaw(true);
        return;
      }
      this.mHudDialog.updateHudYaw(false);
      if (RGHUDDataModel.isHighWayModel())
      {
        if (RGHUDDataModel.getInstance().isHasExitCode())
        {
          showDirectRoadInfoView(false);
          showNormalRoadInfoView(false);
          this.mHudDialog.justSetHighWayVisibility(true);
          this.mHudDialog.updateHighWayAlongVisibility(true);
          return;
        }
        showDirectRoadInfoView(false);
        showNormalRoadInfoView(false);
        this.mHudDialog.justSetHighWayVisibility(true);
        this.mHudDialog.updateHighWayAlongVisibility(false);
        return;
      }
      if (RGHUDDataModel.getInstance().isSimpleGuideAlong())
      {
        showDirectRoadInfoView(true);
        showNormalRoadInfoView(false);
        this.mHudDialog.justSetHighWayVisibility(false);
        return;
      }
      showDirectRoadInfoView(false);
      showNormalRoadInfoView(true);
      this.mHudDialog.justSetHighWayVisibility(false);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void updateCurrentCarSpeed()
  {
    this.mHudDialog.updateCurrentCarSpeed();
  }
  
  public void updateData(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    restoreData(paramBundle);
  }
  
  public void updateHudYaw(boolean paramBoolean)
  {
    this.mHudDialog.updateHudYaw(paramBoolean);
  }
  
  public void updateLatestData()
  {
    int i = RGHUDDataModel.latestUpdateType;
    if (i == -1) {
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      updateCurrentCarSpeed();
      updateTotalRemainInfo();
      showSuitableView();
      return;
      Bundle localBundle = RGSimpleGuideModel.getInstance().getNextGuideInfo();
      updateData(RGHUDDataModel.getInstance().simpleGuideToHUD(localBundle));
      continue;
      localBundle = RGHighwayModel.getInstance().getNewHighWayData();
      updateData(RGHUDDataModel.getInstance().highWayDataToHUD(localBundle));
    }
  }
  
  public void updateTotalRemainInfo()
  {
    this.mHudDialog.updateTotalRemainInfo();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/hud/RGHUDControlView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */