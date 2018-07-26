package com.baidu.navisdk.ui.routeguide;

public interface BNavigator$VoiceSearchCallback {
    void comfirmSuccess(String str);

    void searchFail(String str);

    void searchOne(String str, String str2);

    void searchSuccess(String str, int i);

    void selectSuccess(String str);
}
