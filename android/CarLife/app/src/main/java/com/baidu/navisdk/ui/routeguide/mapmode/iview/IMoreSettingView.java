package com.baidu.navisdk.ui.routeguide.mapmode.iview;

public interface IMoreSettingView {
    void getIsShowMapSwitch(int i);

    void getMapMode(int i);

    void getNaviDayAndNightMode(int i);

    void getPlayTTsVoiceMode(int i);

    void getVoiceMode(int i);

    void jumpCarLogoPage();

    void onBlueToothRedGuide(boolean z);

    void onCarLogoRedGuide(boolean z);

    void onCarPlateInputLayoutVisible(int i);

    void onVoiceRedGuide(boolean z);

    void setVoiceSpeakSetting(int i, int i2);

    void showBlueToothChannelGuide(boolean z);

    void showCarPlate(String str);

    void updateCheckDrawable(int i);

    void updateVoiceName(String str);
}
