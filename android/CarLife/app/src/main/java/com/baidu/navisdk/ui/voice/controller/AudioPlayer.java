package com.baidu.navisdk.ui.voice.controller;

import android.media.AudioTrack;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioPlayer {
    private static final int AUDIO_TRACK_FREQUENCY = 16000;
    private static final int MIN_BUFFER_SIZE = AudioTrack.getMinBufferSize(16000, 2, 2);
    private AudioTrack mAudioTrack = null;
    private byte[] mDataBuffer = null;
    private Object mDataMutex = new Object();
    private boolean mDataReady = false;
    private boolean mIsInit = false;
    private boolean mIsStart = false;
    private boolean mIsStop = false;
    private OnVoicePlayCompletedListener mListener = null;
    private int mOffset = 0;
    private PlayThread mPlayThread = null;
    private Object mStateMutext = new Object();

    public interface OnVoicePlayCompletedListener {
        void onPlaycompleted();
    }

    private class PlayThread extends Thread {
        private PlayThread() {
        }

        public void run() {
            while (AudioPlayer.this.mIsInit && AudioPlayer.this.mAudioTrack != null) {
                try {
                    if (AudioPlayer.this.mIsStop) {
                        synchronized (AudioPlayer.this.mStateMutext) {
                            try {
                                AudioPlayer.this.mStateMutext.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (AudioPlayer.this.mIsInit && AudioPlayer.this.mAudioTrack != null) {
                        if (AudioPlayer.this.mIsStop && AudioPlayer.this.mAudioTrack.getPlayState() != 1) {
                            AudioPlayer.this.mAudioTrack.stop();
                        } else if (AudioPlayer.this.mDataReady && AudioPlayer.this.mAudioTrack.getState() == 1) {
                            synchronized (AudioPlayer.this.mDataMutex) {
                                if (AudioPlayer.this.mOffset + AudioPlayer.MIN_BUFFER_SIZE > AudioPlayer.this.mDataBuffer.length) {
                                    AudioPlayer.this.mDataReady = false;
                                    AudioPlayer.this.mIsStart = false;
                                    AudioPlayer.this.mIsStop = true;
                                    LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "audio player end");
                                    if (AudioPlayer.this.mListener != null) {
                                        AudioPlayer.this.mListener.onPlaycompleted();
                                    }
                                } else {
                                    int ret = AudioPlayer.this.mAudioTrack.write(AudioPlayer.this.mDataBuffer, AudioPlayer.this.mOffset, AudioPlayer.MIN_BUFFER_SIZE);
                                    if (ret == -3 || ret == -2) {
                                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "audio player write buffer ret = " + ret);
                                        AudioPlayer.this.mDataReady = false;
                                    } else {
                                        AudioPlayer.this.mAudioTrack.flush();
                                        AudioPlayer.this.mOffset = AudioPlayer.this.mOffset + ret;
                                    }
                                }
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    return;
                }
            }
        }
    }

    public void setPlayCompletedListener(OnVoicePlayCompletedListener listener) {
        this.mListener = listener;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean init() {
        /*
        r11 = this;
        r10 = 1;
        r0 = r11.mIsInit;
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        r0 = r10;
    L_0x0006:
        return r0;
    L_0x0007:
        r8 = 5;
        r9 = r8;
    L_0x0009:
        r8 = r9 + -1;
        if (r9 <= 0) goto L_0x0034;
    L_0x000d:
        r0 = new android.media.AudioTrack;	 Catch:{ IllegalArgumentException -> 0x0040 }
        r1 = 3;
        r2 = 16000; // 0x3e80 float:2.2421E-41 double:7.905E-320;
        r3 = 2;
        r4 = 2;
        r5 = MIN_BUFFER_SIZE;	 Catch:{ IllegalArgumentException -> 0x0040 }
        r6 = 1;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ IllegalArgumentException -> 0x0040 }
        r11.mAudioTrack = r0;	 Catch:{ IllegalArgumentException -> 0x0040 }
        r0 = r11.mAudioTrack;	 Catch:{ IllegalArgumentException -> 0x0040 }
        r0 = r0.getState();	 Catch:{ IllegalArgumentException -> 0x0040 }
        if (r0 != r10) goto L_0x0045;
    L_0x0024:
        r0 = new com.baidu.navisdk.ui.voice.controller.AudioPlayer$PlayThread;	 Catch:{ IllegalArgumentException -> 0x0040 }
        r1 = 0;
        r0.<init>();	 Catch:{ IllegalArgumentException -> 0x0040 }
        r11.mPlayThread = r0;	 Catch:{ IllegalArgumentException -> 0x0040 }
        r0 = r11.mPlayThread;	 Catch:{ IllegalArgumentException -> 0x0040 }
        r0.start();	 Catch:{ IllegalArgumentException -> 0x0040 }
        r0 = 1;
        r11.mIsInit = r0;	 Catch:{ IllegalArgumentException -> 0x0040 }
    L_0x0034:
        r0 = "BNVoice";
        r1 = " player init";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r0, r1);
        r0 = r11.mIsInit;
        goto L_0x0006;
    L_0x0040:
        r7 = move-exception;
        r0 = 0;
        r11.mIsInit = r0;
        goto L_0x0034;
    L_0x0045:
        r9 = r8;
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.voice.controller.AudioPlayer.init():boolean");
    }

    public void release() {
        if (this.mIsInit && this.mAudioTrack != null) {
            synchronized (this.mDataMutex) {
                this.mIsInit = false;
                this.mDataReady = false;
                this.mDataBuffer = null;
                this.mAudioTrack.release();
                this.mAudioTrack = null;
                this.mPlayThread = null;
            }
            synchronized (this.mStateMutext) {
                this.mStateMutext.notify();
            }
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, " player release");
        }
    }

    public boolean start(String filePath) {
        if (filePath == null || !this.mIsInit || this.mAudioTrack == null) {
            return false;
        }
        if (this.mIsStart) {
            return true;
        }
        try {
            File file = new File(filePath);
            if (file.exists()) {
                setDataSource(file);
                this.mIsStart = true;
                this.mIsStop = false;
                this.mOffset = 0;
                this.mAudioTrack.play();
                synchronized (this.mStateMutext) {
                    this.mStateMutext.notify();
                }
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, " player start");
                return true;
            }
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "start play file not exists " + filePath);
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setDataSource(File file) throws IOException {
        Throwable th;
        FileInputStream fstream = null;
        try {
            FileInputStream fstream2 = new FileInputStream(file);
            try {
                long size = file.length();
                synchronized (this.mDataMutex) {
                    this.mDataBuffer = new byte[((int) size)];
                    fstream2.read(this.mDataBuffer);
                    LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "play setDataSource size :" + size);
                }
                this.mDataReady = true;
                try {
                    fstream2.close();
                } catch (IOException e) {
                }
            } catch (Throwable th2) {
                th = th2;
                fstream = fstream2;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                fstream.close();
            } catch (IOException e2) {
            }
            throw th;
        }
    }

    public boolean stop() {
        if (!this.mIsInit || this.mAudioTrack == null) {
            return false;
        }
        if (this.mIsStop) {
            return true;
        }
        this.mDataReady = false;
        this.mIsStart = false;
        this.mIsStop = true;
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, " player stop");
        return true;
    }

    public boolean canPlay() {
        return this.mIsInit && this.mDataReady;
    }
}
