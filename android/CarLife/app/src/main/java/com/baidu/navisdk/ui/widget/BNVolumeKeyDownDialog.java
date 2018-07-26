package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public abstract class BNVolumeKeyDownDialog extends Dialog {
    Activity mActivity;

    public BNVolumeKeyDownDialog(Context context) {
        super(context);
        this.mActivity = (Activity) context;
    }

    public BNVolumeKeyDownDialog(Context context, int theme) {
        super(context, theme);
        this.mActivity = (Activity) context;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AudioManager audio = (AudioManager) this.mActivity.getSystemService("audio");
        int current = audio.getStreamVolume(3);
        int maxVolume = audio.getStreamMaxVolume(3);
        switch (keyCode) {
            case 4:
                super.onKeyDown(keyCode, event);
                return true;
            case 24:
                if (RGMapModeViewController.getInstance().getVolumeChangeListener() != null) {
                    current = RGMapModeViewController.getInstance().getVolumeChangeListener().onVolumeUpKeyDown(audio, maxVolume);
                }
                UserOPController.getInstance().appendContinuousOP(UserOPParams.GUIDE_3_ka);
                if (current <= 0) {
                    return true;
                }
                RGMapModeViewController.getInstance().updateLowVolumeView(false);
                return true;
            case 25:
                if (RGMapModeViewController.getInstance().getVolumeChangeListener() != null) {
                    current = RGMapModeViewController.getInstance().getVolumeChangeListener().onVolumeDownKeyDown(audio, maxVolume);
                }
                UserOPController.getInstance().appendContinuousOP(UserOPParams.GUIDE_3_kb);
                if (current != 0) {
                    return true;
                }
                RGMapModeViewController.getInstance().updateLowVolumeView(true);
                return true;
            default:
                return false;
        }
    }
}
