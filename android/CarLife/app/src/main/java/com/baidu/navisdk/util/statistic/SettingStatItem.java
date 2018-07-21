package com.baidu.navisdk.util.statistic;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.ui.cruise.view.CruiseMenu;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import java.util.ArrayList;
import java.util.BitSet;
import org.apache.http.message.BasicNameValuePair;

public class SettingStatItem
{
  private static final String TAG = "SettingStat";
  private static SettingStatItem instance = null;
  
  public static int bitSetToInt(BitSet paramBitSet)
  {
    int j = 0;
    int i = 0;
    while (i < 32)
    {
      int k = j;
      if (paramBitSet.get(i)) {
        k = j | 1 << i;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private static int getCruiseSpeekContentIntBits()
  {
    BitSet localBitSet = new BitSet(CruiseMenu.sSettingPrefKeys.length);
    int i = 0;
    if (i < CruiseMenu.sSettingPrefKeys.length)
    {
      if (BNSettingManager.getInt(CruiseMenu.sSettingPrefKeys[i], 0) == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localBitSet.set(i, bool);
        i += 1;
        break;
      }
    }
    i = bitSetToInt(localBitSet);
    LogUtil.e("SettingStat", "cruise speek content bits: " + Integer.toBinaryString(i));
    return i;
  }
  
  public static SettingStatItem getInstance()
  {
    if (instance == null) {
      instance = new SettingStatItem();
    }
    return instance;
  }
  
  private static int getSpeekContentIntBits()
  {
    BitSet localBitSet = new BitSet(5);
    localBitSet.set(0, BNSettingManager.isElecCameraSpeakEnable());
    localBitSet.set(1, BNSettingManager.isStraightDirectSpeakEnable());
    localBitSet.set(2, BNSettingManager.isSaftyDriveSpeakEnable());
    localBitSet.set(3, BNSettingManager.isRoadConditionSpeakEnable());
    localBitSet.set(4, BNSettingManager.isSpeedCameraSpeakEnable());
    int i = bitSetToInt(localBitSet);
    LogUtil.e("SettingStat", "navi speek content bits: " + Integer.toBinaryString(i));
    return i;
  }
  
  public void onEvent()
  {
    ArrayList localArrayList = new ArrayList();
    if (PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getBoolean("NAVI_ROADCOND_ON_OFF", false))
    {
      i = 1;
      localArrayList.add(new BasicNameValuePair("lk", Integer.toString(i)));
      i = -1;
      switch (BNSettingManager.getVoiceMode())
      {
      default: 
        label76:
        localArrayList.add(new BasicNameValuePair("bb", Integer.toString(i)));
        switch (BNSettingManager.getIsShowMapSwitch())
        {
        case 1: 
        default: 
          label124:
          i = -1;
          switch (BNSettingManager.getMapMode())
          {
          default: 
            label152:
            localArrayList.add(new BasicNameValuePair("sj", Integer.toString(i)));
            i = -1;
            switch (BNSettingManager.getNaviDayAndNightMode())
            {
            default: 
              label200:
              localArrayList.add(new BasicNameValuePair("ry", Integer.toString(i)));
              i = -1;
              switch (BNSettingManager.getPowerSaveMode())
              {
              default: 
                label248:
                localArrayList.add(new BasicNameValuePair("sd", Integer.toString(i)));
                if (BNSettingManager.isAutoUpdateNewData())
                {
                  i = 1;
                  label274:
                  localArrayList.add(new BasicNameValuePair("zd", Integer.toString(i)));
                  if (!BNSettingManager.getPrefParkSearch()) {
                    break label830;
                  }
                  i = 1;
                  label300:
                  localArrayList.add(new BasicNameValuePair("tc", Integer.toString(i)));
                  if (!BNSettingManager.getPrefRealEnlargementNavi()) {
                    break label835;
                  }
                  i = 1;
                  label326:
                  localArrayList.add(new BasicNameValuePair("sjt", Integer.toString(i)));
                  if (!BNSettingManager.getColladaStatus()) {
                    break label840;
                  }
                  i = 1;
                  label352:
                  localArrayList.add(new BasicNameValuePair("cl", Integer.toString(i)));
                  if (!BNSettingManager.isAutoLevelMode()) {
                    break label845;
                  }
                  i = 1;
                  label378:
                  localArrayList.add(new BasicNameValuePair("al", Integer.toString(i)));
                  localArrayList.add(new BasicNameValuePair("sort", Integer.toString(RGRouteSortController.getInstance().getPreferValue())));
                  localArrayList.add(new BasicNameValuePair("pre", Integer.toString(BNRoutePlaner.getInstance().getCalcPreference())));
                  if (!BNaviModuleManager.isSettingCarPlate()) {
                    break label850;
                  }
                  i = 1;
                  label450:
                  localArrayList.add(new BasicNameValuePair("cn", Integer.toString(i)));
                  if (!BNaviModuleManager.isCarPlateNumComplete()) {
                    break label855;
                  }
                  i = 1;
                  label476:
                  localArrayList.add(new BasicNameValuePair("wcn", Integer.toString(i)));
                  if (BNSettingManager.getPrefRoutPlanMode() != 3) {
                    break label860;
                  }
                  i = 1;
                  label503:
                  localArrayList.add(new BasicNameValuePair("ol", Integer.toString(i)));
                  if (!BNSettingManager.getAutoEnterLightNavi()) {
                    break label865;
                  }
                  i = 1;
                  label529:
                  localArrayList.add(new BasicNameValuePair("rd", Integer.toString(i)));
                  if (BNSettingManager.getIsShowMapSwitch() != 0) {
                    break label870;
                  }
                  i = 1;
                  label555:
                  localArrayList.add(new BasicNameValuePair("slk", Integer.toString(i)));
                  if (!BNSettingManager.isBlueToothPhoneChannel()) {
                    break label875;
                  }
                  i = 1;
                  label581:
                  localArrayList.add(new BasicNameValuePair("bl", Integer.toString(i)));
                  if (!BNSettingManager.getPrefFloatSwitch()) {
                    break label880;
                  }
                  i = 1;
                  label607:
                  localArrayList.add(new BasicNameValuePair("bn", Integer.toString(i)));
                  if (BNSettingManager.getIsShowMapSwitch() != 0) {
                    break label885;
                  }
                  i = 1;
                  label633:
                  if (i == 0) {
                    break label890;
                  }
                  i = 0;
                  label639:
                  localArrayList.add(new BasicNameValuePair("light_win", Integer.toString(i)));
                  if (!BNSettingManager.getShowCarLogoToEnd()) {
                    break label895;
                  }
                  i = 1;
                  label665:
                  localArrayList.add(new BasicNameValuePair("red_line", Integer.toString(i)));
                  if (BNSettingManager.getPlayTTsVoiceMode() != 0) {
                    break label900;
                  }
                  i = 1;
                  label691:
                  if (i == 0) {
                    break label905;
                  }
                  i = 1;
                  label697:
                  localArrayList.add(new BasicNameValuePair("music_mode", Integer.toString(i)));
                  if (BNSettingManager.getVoiceMode() != 2) {
                    break label910;
                  }
                  i = 1;
                  label724:
                  if (i == 0) {
                    break label915;
                  }
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    label830:
    label835:
    label840:
    label845:
    label850:
    label855:
    label860:
    label865:
    label870:
    label875:
    label880:
    label885:
    label890:
    label895:
    label900:
    label905:
    label910:
    label915:
    for (int i = 0;; i = 1)
    {
      localArrayList.add(new BasicNameValuePair("voice_mode", Integer.toString(i)));
      BNStatisticsManager.getInstance().onEventWithParam(50006, null, localArrayList);
      return;
      i = 0;
      break;
      i = 2;
      break label76;
      i = 0;
      break label76;
      i = 1;
      break label76;
      break label124;
      break label124;
      i = 1;
      break label152;
      i = 0;
      break label152;
      i = 2;
      break label200;
      i = 1;
      break label200;
      i = 0;
      break label200;
      i = 1;
      break label248;
      i = 0;
      break label248;
      i = 2;
      break label248;
      i = 0;
      break label274;
      i = 0;
      break label300;
      i = 0;
      break label326;
      i = 0;
      break label352;
      i = 0;
      break label378;
      i = 0;
      break label450;
      i = 0;
      break label476;
      i = 0;
      break label503;
      i = 0;
      break label529;
      i = 0;
      break label555;
      i = 0;
      break label581;
      i = 0;
      break label607;
      i = 0;
      break label633;
      i = 1;
      break label639;
      i = 0;
      break label665;
      i = 0;
      break label691;
      i = 0;
      break label697;
      i = 0;
      break label724;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/SettingStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */