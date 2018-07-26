package com.baidu.navisdk.lightnavi.listener;

import android.os.Message;

public interface LightGuideRGListener {
    void avoidTrafficJam(Message message);

    void calcOtherRoute();

    void hideAvoidTrafficJamView();

    void isYellowBarHide(Message message);

    void onArriveDest(Message message);

    void onAutoRefresh(int i);

    void onGpsStatusChange(boolean z);

    void onIPOAddressScreen(Message message);

    void onIPOLockScreen(Message message);

    void onIPORoadConditionHide(Message message);

    void onIPORoadConditionUpdate(Message message);

    void onOtherRoute(Message message);

    void onQuitNavi();

    void onRemainInfoUpdate(Message message);

    void onSwithSLightToNavi(Message message);

    void onUpdateSimpleGuide(Message message);

    void onUpdateSpeed(boolean z, Message message);

    void onYawingRPFail();

    void onYawingRerouteSuccess(Message message);

    void onYawingRerouting(Message message);

    void refreshScreenShot();

    void showSafetyGuide(boolean z);

    void switchScrennType();

    void zoomToFullView();
}
