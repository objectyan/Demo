package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.audio.AudioUtil.EnumAudioState;
import com.baidu.carlife.core.connect.ConnectManager;

/* compiled from: MediaChannelSend */
/* renamed from: com.baidu.carlife.core.audio.k */
public class MediaChannelSend {
    /* renamed from: a */
    private static MediaChannelSend sMediaChannelSend;
    /* renamed from: b */
    private boolean mStatus = false;

    private MediaChannelSend() {
    }

    /* renamed from: a */
    public static MediaChannelSend newInstance() {
        if (sMediaChannelSend == null) {
            sMediaChannelSend = new MediaChannelSend();
        }
        return sMediaChannelSend;
    }

    /* renamed from: a */
    public synchronized int send(byte[] data, int len, EnumAudioState type) {
        int i = -1;
        synchronized (this) {
            if (!AudioUtil.newInstance().isBlueToothMode()) {
                if (type == EnumAudioState.INIT || type == EnumAudioState.RESUME) {
                    setStatus(true);
                } else if (type == EnumAudioState.PAUSE || type == EnumAudioState.STOP) {
                    setStatus(false);
                }
                if ((type != EnumAudioState.NORMAL || getStatus()) && AudioUtil.getIs() && len >= 0) {
                    i = ConnectManager.newInstance().writeAudio(data, len);
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private void setStatus(boolean status) {
        this.mStatus = status;
    }

    /* renamed from: b */
    private boolean getStatus() {
        return this.mStatus;
    }
}
