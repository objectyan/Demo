package com.baidu.platform.comapi.map;

public interface MapListenerInterface {
    void setCaptureMapListener(CaptureMapListener captureMapListener);

    void setEngineMsgListener(EngineMsgListener engineMsgListener);

    void setHideIndoorPopupListener(HideIndoorPopupListener hideIndoorPopupListener);

    void setMapRenderModeChangeListener(MapRenderModeChangeListener mapRenderModeChangeListener);

    void setMapViewInterface(MapViewInterface mapViewInterface);

    void setMapViewListener(MapViewListener mapViewListener);

    void setStreetArrowClickListener(StreetArrowClickListener streetArrowClickListener);
}
