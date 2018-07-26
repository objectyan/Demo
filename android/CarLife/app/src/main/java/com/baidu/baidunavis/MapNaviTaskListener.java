package com.baidu.baidunavis;

import com.baidu.navisdk.ui.voice.controller.VoiceDownloadStatus.NaviTaskListener;

public class MapNaviTaskListener implements NaviTaskListener {
    public boolean onCheckNaviTask() {
        return isNaviTask();
    }

    private boolean isNaviTask() {
        return false;
    }
}
