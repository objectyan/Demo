package com.baidu.navisdk.ui.routeguide.mapmode;

import android.content.DialogInterface.OnCancelListener;

public interface RGMapModeViewController$RouteGuideDialogManagerInterface {
    void dismissGPSSettingDialog();

    void dismissLoading();

    void dismissQuitDialog();

    void dismissYawingLoading();

    void hideAllDialogs();

    void hideViaComfirmDialog();

    void releaseAllDialogs();

    void showGPSSettingDialog();

    void showLoading(String str, OnCancelListener onCancelListener);

    void showQuitDialog(boolean z);

    void showReCalRouteQuitDialog();

    void showViaComfirmDialog();

    void showYawingLoading(String str);

    void showYawingQuitDialog();
}
