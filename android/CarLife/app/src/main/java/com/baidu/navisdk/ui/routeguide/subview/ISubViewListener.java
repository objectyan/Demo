package com.baidu.navisdk.ui.routeguide.subview;

public interface ISubViewListener {
    void onEnlargeRoadMapHideEnd();

    void onEnlargeRoadMapHideStart();

    void onEnlargeRoadMapImgTouch();

    void onEnlargeRoadMapShowEnd();

    void onEnlargeRoadMapShowStart();

    void onExitDialogConfirm();

    void onExitDialogTimeOut();

    void onMenuSelectedRouteDetail();

    void onMenuSelectedRoutePlan();

    void onRouteDescWindowHide();

    void onRouteDescWindowShow();

    void onZoomBtnClick();
}
