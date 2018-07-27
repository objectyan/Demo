package me.objectyan.screensharing.core.audio;

import me.objectyan.screensharing.core.audio.AudioUtil.EnumAudioState;
import me.objectyan.screensharing.core.connect.ConnectManager;


public class MediaChannelSend {

    private static MediaChannelSend sMediaChannelSend;

    private boolean mStatus = false;

    private MediaChannelSend() {
    }


    public static MediaChannelSend newInstance() {
        if (sMediaChannelSend == null) {
            sMediaChannelSend = new MediaChannelSend();
        }
        return sMediaChannelSend;
    }


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


    private void setStatus(boolean status) {
        this.mStatus = status;
    }


    private boolean getStatus() {
        return this.mStatus;
    }
}
