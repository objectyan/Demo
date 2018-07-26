package com.baidu.navisdk.ui.routeguide.mapmode;

import android.media.AudioManager;

public interface RGMapModeViewController$VolumeChangeListener {
    int onVolumeDownKeyDown(AudioManager audioManager, int i);

    int onVolumeUpKeyDown(AudioManager audioManager, int i);
}
