package com.baidu.carlife.core.screen;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

/* compiled from: OnUIListener */
/* renamed from: com.baidu.carlife.core.screen.l */
public interface C1283l {
    void hideMapFragment();

    void innerNameSearch(String str);

    void openNavi();

    void openNavi(Bundle bundle);

    void openNaviFromOutSide(int i, Bundle bundle);

    void performOpenHome();

    void setBottomBarBackgroud(Drawable drawable);

    void setBottomBarStatus(boolean z);

    boolean showConnectForbidDialog();

    void showMapFragment();

    void startCalcRoute(C1269a c1269a);

    void updateGaussianBlurBackground();

    void updateMainDisplayStatus(int i);
}
