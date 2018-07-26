package com.baidu.navisdk.ui.routeguide.mapmode.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.iview.IMoreSettingView;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.BlueToothListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.util.regex.Pattern;

public class MoreSettingPresenter {
    private static String TAG = ModuleName.ROUTEGUIDE;
    private IMoreSettingView mMoreSettingView;

    public MoreSettingPresenter(IMoreSettingView mMoreSettingView) {
        this.mMoreSettingView = mMoreSettingView;
    }

    public boolean[] initUserConfig() {
        boolean[] isChecked = new boolean[8];
        try {
            isChecked[3] = BNSettingManager.getPrefRealEnlargementNavi();
            isChecked[4] = BNSettingManager.getColladaStatus();
            isChecked[2] = BNSettingManager.isAutoLevelMode();
            isChecked[6] = BNSettingManager.getPrefParkSearch();
            isChecked[7] = BNSettingManager.getPrefFloatSwitch();
            isChecked[1] = BlueToothListener.sIsOpenBTChannel;
            isChecked[5] = BNSettingManager.getShowCarLogoToEnd();
            isChecked[0] = RGCarPreferSettingController.getInstance().isCarLimitOpen();
        } catch (Exception e) {
        }
        return isChecked;
    }

    public void initRedGuide() {
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

    public void initActionSwitchSetting() {
        int voiceMode = BNSettingManager.getVoiceMode();
        if (voiceMode == 0) {
            this.mMoreSettingView.getVoiceMode(0);
        } else if (voiceMode == 1) {
            this.mMoreSettingView.getVoiceMode(1);
        } else {
            this.mMoreSettingView.getVoiceMode(2);
        }
        if (BNSettingManager.getMapMode() == 1) {
            this.mMoreSettingView.getMapMode(0);
        } else {
            this.mMoreSettingView.getMapMode(1);
        }
        int dayMode = BNSettingManager.getNaviDayAndNightMode();
        if (dayMode == 1) {
            this.mMoreSettingView.getNaviDayAndNightMode(0);
        } else if (dayMode == 2) {
            this.mMoreSettingView.getNaviDayAndNightMode(1);
        } else {
            this.mMoreSettingView.getNaviDayAndNightMode(2);
        }
        if (BNSettingManager.getIsShowMapSwitch() == 1) {
            this.mMoreSettingView.getIsShowMapSwitch(1);
        } else {
            this.mMoreSettingView.getIsShowMapSwitch(0);
        }
        if (BNSettingManager.getPlayTTsVoiceMode() == 0) {
            this.mMoreSettingView.getPlayTTsVoiceMode(0);
        } else {
            this.mMoreSettingView.getPlayTTsVoiceMode(1);
        }
    }

    public void addUserOP(String op) {
        UserOPController.getInstance().add(op);
    }

    public void addUserOP(String op, String paramA, String paramB, String paramC) {
        UserOPController.getInstance().add(op, paramA, paramB, paramC);
    }

    public void updatePreferValue(int changePrefer, boolean isPreferOpen) {
        RGCarPreferSettingController.getInstance().updatePreferValue(changePrefer, isPreferOpen);
    }

    public void handleCheckPlateSuccess(Context context, String carNum) {
        if (context != null) {
            BNSettingManager.setCarPlateToLocal(context, carNum);
            BNRoutePlaner.getInstance().setCalcPrefCarNo(carNum);
        }
    }

    public boolean checkPlate(String carNum) {
        return Pattern.compile("^[\\u4e00-\\u9fa5]{1}[A-Z_0-9]{6,7}$").matcher(carNum).matches();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSettingsChange(boolean[] r7, int r8) {
        /*
        r6 = this;
        switch(r8) {
            case 0: goto L_0x0046;
            case 1: goto L_0x0003;
            case 2: goto L_0x0034;
            case 3: goto L_0x0009;
            case 4: goto L_0x002e;
            case 5: goto L_0x005d;
            case 6: goto L_0x003a;
            case 7: goto L_0x0040;
            default: goto L_0x0003;
        };
    L_0x0003:
        r3 = r6.mMoreSettingView;	 Catch:{ Throwable -> 0x000f }
        r3.updateCheckDrawable(r8);	 Catch:{ Throwable -> 0x000f }
    L_0x0008:
        return;
    L_0x0009:
        r1 = r7[r8];	 Catch:{ Throwable -> 0x000f }
        com.baidu.navisdk.comapi.setting.BNSettingManager.setPrefRealEnlargementNavi(r1);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0003;
    L_0x000f:
        r2 = move-exception;
        r3 = TAG;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "onSettingsChange exception ->";
        r4 = r4.append(r5);
        r5 = r2.getMessage();
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.baidu.navisdk.util.common.LogUtil.m15791e(r3, r4);
        goto L_0x0008;
    L_0x002e:
        r1 = r7[r8];	 Catch:{ Throwable -> 0x000f }
        com.baidu.navisdk.comapi.setting.BNSettingManager.setColladaStatus(r1);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0003;
    L_0x0034:
        r1 = r7[r8];	 Catch:{ Throwable -> 0x000f }
        com.baidu.navisdk.comapi.setting.BNSettingManager.setAutoLevelMode(r1);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0003;
    L_0x003a:
        r1 = r7[r8];	 Catch:{ Throwable -> 0x000f }
        com.baidu.navisdk.comapi.setting.BNSettingManager.setPrefParkSearch(r1);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0003;
    L_0x0040:
        r1 = r7[r8];	 Catch:{ Throwable -> 0x000f }
        com.baidu.navisdk.comapi.setting.BNSettingManager.setPrefFloatSwitch(r1);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0003;
    L_0x0046:
        r3 = r7[r8];	 Catch:{ Throwable -> 0x000f }
        if (r3 == 0) goto L_0x005a;
    L_0x004a:
        r0 = 0;
    L_0x004b:
        r3 = r6.mMoreSettingView;	 Catch:{ Throwable -> 0x000f }
        r3.onCarPlateInputLayoutVisible(r0);	 Catch:{ Throwable -> 0x000f }
        r3 = com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController.getInstance();	 Catch:{ Throwable -> 0x000f }
        r4 = r7[r8];	 Catch:{ Throwable -> 0x000f }
        r3.setCarLimitOpen(r4);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0003;
    L_0x005a:
        r0 = 8;
        goto L_0x004b;
    L_0x005d:
        r1 = r7[r8];	 Catch:{ Throwable -> 0x000f }
        com.baidu.navisdk.comapi.setting.BNSettingManager.setShowCarLogoToEnd(r1);	 Catch:{ Throwable -> 0x000f }
        r3 = com.baidu.navisdk.comapi.mapcontrol.BNMapController.getInstance();	 Catch:{ Throwable -> 0x000f }
        r3.setRedLineRender(r1);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.presenter.MoreSettingPresenter.onSettingsChange(boolean[], int):void");
    }

    public void getVoiceName() {
        String name;
        String ttsId = VoiceHelper.getInstance().getCurrentUsedTTSId();
        if (ttsId == null || BNVoiceParams.GLOBAL.equals(ttsId)) {
            name = JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_normal);
        } else {
            VoiceInfo info = VoiceHelper.getInstance().getVoiceInfo(ttsId);
            if (info != null) {
                name = info.name;
            } else {
                return;
            }
        }
        this.mMoreSettingView.updateVoiceName(name);
    }

    public void setRouteConditionOverView(int type) {
        BNSettingManager.setIsShowMapSwitch(type);
        RGViewController.getInstance().showAssistMapSwitch();
    }

    public void setPlayTTSMusicMode(int mode) {
        BNSettingManager.setPlayTTsVoiceMode(mode);
    }

    public void setNaviDayAndNightMode(int mode) {
        BNSettingManager.setNaviDayAndNightMode(mode);
    }

    public void onChangeAngleTrueNorthModeSetting() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_1, null, "", "2");
        RouteGuideFSM.getInstance().cacheBackMapState(FsmState.North2D);
        BNavigator.getInstance().enterNavState();
        BNSettingManager.setMapMode(2);
    }

    public void onChangeAngleFollowModeSetting() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_1, "", null, "2");
        RouteGuideFSM.getInstance().cacheBackMapState(FsmState.Car3D);
        BNavigator.getInstance().enterNavState();
        BNSettingManager.setMapMode(1);
    }

    public void onChangeAngleHUDModeSetting() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_4);
        RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_HUD_ENTER);
    }

    public void onChangeQuiteVoiceModeSetting() {
        BNSettingManager.resetVoiceModeParams(2);
        this.mMoreSettingView.setVoiceSpeakSetting(0, 2);
    }

    public void onChangeConciseVoiceModeSetting() {
        BNSettingManager.resetVoiceModeParams(1);
        this.mMoreSettingView.setVoiceSpeakSetting(0, 1);
        BNSettingManager.setLastVoiceMode(1);
    }

    public void onChangeDetailVoiceModeSetting() {
        BNSettingManager.resetVoiceModeParams(0);
        this.mMoreSettingView.setVoiceSpeakSetting(0, 0);
        BNSettingManager.setLastVoiceMode(0);
    }

    public void getPlateFromLocal(Context context) {
        if (context != null) {
            String carNum = BNSettingManager.getPlateFromLocal(context);
            if (TextUtils.isEmpty(carNum)) {
                this.mMoreSettingView.showCarPlate(BNSettingManager.getOwnerCarPlate());
                return;
            }
            this.mMoreSettingView.showCarPlate(carNum);
        }
    }

    public void initPlateFromLocal(Context context) {
        if (context != null) {
            String carNum = BNSettingManager.getPlateFromLocal(context);
            if (TextUtils.isEmpty(carNum)) {
                String ownerCarPlate = BNSettingManager.getOwnerCarPlate();
                if (StringUtils.isEmpty(ownerCarPlate)) {
                    BNaviModuleManager.fetchCarOwnerData(context);
                    return;
                } else {
                    this.mMoreSettingView.showCarPlate(ownerCarPlate);
                    return;
                }
            }
            this.mMoreSettingView.showCarPlate(carNum);
        }
    }

    public void setBlueToothChannelGuide(Context context, boolean isOpen) {
        if (context != null) {
            if (isOpen) {
                BNSettingManager.setBlueToothPhoneChannel(false);
                RGMapModeViewController.getInstance().closeSCO(11);
                return;
            }
            BNSettingManager.setFristBlueToothChannelGuide(true);
            this.mMoreSettingView.showBlueToothChannelGuide(BlueToothListener.isBTConnect);
        }
    }

    public void setCarLogo() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_b);
        BNSettingManager.setFirstCarLogoGuide(true);
        this.mMoreSettingView.onCarLogoRedGuide(false);
        this.mMoreSettingView.jumpCarLogoPage();
    }
}
