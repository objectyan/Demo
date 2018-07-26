package com.baidu.platform.comapi.map;

public interface EngineMsgListener {
    void onEnterIndoorMapMode(IndoorMapInfo indoorMapInfo);

    void onExitIndoorMapMode();

    void onLongLinkConnect();

    void onLongLinkDisConnect();
}
