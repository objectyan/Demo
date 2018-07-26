package com.baidu.navisdk.util.common;

import android.content.Context;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class AudioUtils$2 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ Context val$context;

    AudioUtils$2(String taskName, String pInData, Context context) {
        this.val$context = context;
        super(taskName, pInData);
    }

    protected String execute() {
        LogUtil.m15791e(TAG, "resumeTTS() sIsPaused=" + AudioUtils.sIsPaused + ", sVolumeBeforePause=" + AudioUtils.sVolumeBeforePause);
        AudioUtils.setVolume(this.val$context, AudioUtils.sVolumeBeforePause);
        if (BNavigator.getInstance().isNaviBegin() && AudioUtils.sVolumeBeforePause > 0) {
            RGMapModeViewController.getInstance().updateLowVolumeView(false);
        }
        return null;
    }
}
