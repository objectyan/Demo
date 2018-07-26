package com.baidu.navisdk.ui.routeguide.mapmode;

public interface IRGPreferSettingListener {
    boolean isSupportAvoidJam();

    boolean[] onGetLastPreferenceCheck();

    int onGetLastPreferenceValue();

    boolean[] onGetPreferenceCheck();

    void onSetLastPreferenceValue(int i);

    void onSetPreferenceCheck(boolean z, int i);

    void onSetPreferenceCheck(boolean[] zArr);
}
