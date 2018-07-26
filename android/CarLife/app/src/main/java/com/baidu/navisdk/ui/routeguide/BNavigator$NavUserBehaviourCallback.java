package com.baidu.navisdk.ui.routeguide;

import android.os.Bundle;

public interface BNavigator$NavUserBehaviourCallback {
    boolean isShouldShowNaviResult();

    void onCarLogoPageShow();

    boolean onFellowCloseLCS();

    boolean onFellowCreateLCS();

    int onFellowGetReqId();

    boolean onFellowRegisterLCS();

    Bundle onFellowSendData(int i, byte[] bArr, String str, String str2);

    boolean onFellowUnregisterLCS();

    void onRoutePlan();

    void onShowMenu();

    void onUgcPageShow(int i, String str);

    void onYawing();

    void registerLoadingProxy();

    void unRegisterLoadingProxy();
}
