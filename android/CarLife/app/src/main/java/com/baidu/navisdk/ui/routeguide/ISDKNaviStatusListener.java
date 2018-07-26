package com.baidu.navisdk.ui.routeguide;

public interface ISDKNaviStatusListener {
    void onBridgeSwitchClick();

    void onBridgeSwitchGetFocus();

    void onEmptyPoiClick();

    void onEmptyPoiGetFocus();

    void onEnlargeRoadMapViewHide();

    void onEnlargeRoadMapViewShow();

    void onFocusMoreMenu();

    void onFocusMoreMenuGetFocus();

    void onFullOrResumeGetFocus();

    void onFullViewBtnClick();

    void onLocationBtnClick();

    void onLocationGetFocus();

    void onMASwitchClick();

    void onMASwitchGetFocus();

    void onMainAuxiliaryHide();

    void onMainAuxiliaryShow();

    void onMoreMenuClick();

    void onNaviLeftPanelTouch();

    void onQuitGetFocus();

    void onReRouteComplete();

    void onResumeBtnClick();

    void onResumeNavigatorClick();

    void onResumeNavigatorGetFocus();

    void onRoutePlanYawing();

    void onRouteSwitchClick();

    void onRouteSwitchGetFocus();

    void onSetingBtnClick();

    void onSetingGetFocus();

    void onViaPointBtnClick();

    void onViaPointGetFocus();

    void onZoomInBtnClick();

    void onZoomInGetFocus();

    void onZoomOutBtnClick();

    void onZoomOutGetFocus();
}
