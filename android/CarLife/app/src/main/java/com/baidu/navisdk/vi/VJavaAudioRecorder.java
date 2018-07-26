package com.baidu.navisdk.vi;

import android.media.AudioRecord;
import com.baidu.navisdk.util.common.LogUtil;

public class VJavaAudioRecorder {
    private static final int AUDIO_FORMAT = 2;
    private static final int AUDIO_SOURCE = 1;
    protected static final int BUFFER_SIZE_IN_BYTES = Math.max(AudioRecord.getMinBufferSize(16000, 2, 2), 2048);
    private static final int CHANNEL_CONFIG = 2;
    private static final int SAMPLE_RATE = 16000;
    private static final String TAG = "VJavaAudioRecorder";
    private boolean isInit = false;
    private boolean isStart = false;
    private boolean isStop = true;
    private boolean isThreadStart = false;
    private short[] mBuffer = new short[2048];
    private int mJniData;
    private Object mMutex = new Object();
    AudioRecord mRecord;
    private RecordThread mRecordThread;
    private AudioRecorderListener mRecorderListener;

    public interface AudioRecorderListener {
        void onReadData(short[] sArr, int i);

        void onReadError();
    }

    class RecordThread extends Thread {
        RecordThread() {
        }

        public void run() {
            while (VJavaAudioRecorder.this.isInit && VJavaAudioRecorder.this.mRecord != null) {
                if (VJavaAudioRecorder.this.isStop) {
                    synchronized (VJavaAudioRecorder.this.mMutex) {
                        try {
                            LogUtil.m15791e(VJavaAudioRecorder.TAG, "java record thread read stop");
                            VJavaAudioRecorder.this.mMutex.wait();
                            LogUtil.m15791e(VJavaAudioRecorder.TAG, "java record thread read start");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (!VJavaAudioRecorder.this.isInit || VJavaAudioRecorder.this.mRecord == null) {
                    break;
                } else if (VJavaAudioRecorder.this.isStop) {
                    VJavaAudioRecorder.this.mRecord.stop();
                } else {
                    int len = VJavaAudioRecorder.this.mRecord.read(VJavaAudioRecorder.this.mBuffer, 0, VJavaAudioRecorder.this.mBuffer.length);
                    if (!VJavaAudioRecorder.this.isStop) {
                        if (len > 0) {
                            LogUtil.m15791e(VJavaAudioRecorder.TAG, "java record thread read len:" + len);
                            VJavaAudioRecorder.this.onRecordReadData(VJavaAudioRecorder.this.mBuffer, len);
                        } else {
                            LogUtil.m15791e(VJavaAudioRecorder.TAG, "java record thread read error len = " + len);
                            VJavaAudioRecorder.this.onRecordReadError();
                        }
                    }
                }
            }
            LogUtil.m15791e(VJavaAudioRecorder.TAG, "java record thread end");
        }
    }

    native void onReadData(short[] sArr, int i);

    native void onReadError();

    public void setRecorderListener(AudioRecorderListener listener) {
        this.mRecorderListener = listener;
    }

    public boolean init() {
        try {
            LogUtil.m15791e("VoiceRecordView", "  MyClickListener isLongClick isInit " + this.isInit);
            if (this.isInit) {
                return true;
            }
            int retry = 6;
            while (true) {
                int retry2 = retry - 1;
                if (retry >= 0) {
                    this.mRecord = new AudioRecord(1, 16000, 2, 2, BUFFER_SIZE_IN_BYTES);
                    if (this.mRecord.getState() == 1) {
                        LogUtil.m15791e(TAG, "success to init audio record!");
                        this.isInit = true;
                        this.mRecordThread = new RecordThread();
                        this.mRecordThread.start();
                        return true;
                    }
                    retry = retry2;
                } else {
                    LogUtil.m15791e(TAG, "fail to init audio record!");
                    return false;
                }
            }
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "fail to init audio record for exception!");
            return false;
        }
    }

    public boolean start() {
        if (!this.isInit || this.mRecord == null) {
            return false;
        }
        if (this.isStart) {
            return true;
        }
        LogUtil.m15791e(TAG, "start recod");
        this.isStart = true;
        this.isStop = false;
        try {
            this.mRecord.startRecording();
        } catch (Exception e) {
        }
        synchronized (this.mMutex) {
            this.mMutex.notify();
        }
        return true;
    }

    public int getAudioSessionId() {
        if (this.mRecord == null || this.mRecord.getRecordingState() != 3) {
            return 0;
        }
        return this.mRecord.getAudioSessionId();
    }

    public boolean stop() {
        if (!this.isInit || this.mRecord == null) {
            return false;
        }
        if (this.isStop) {
            return true;
        }
        LogUtil.m15791e(TAG, "stop recod");
        this.isStart = false;
        this.isStop = true;
        return true;
    }

    public void release() {
        if (this.isInit && this.mRecord != null) {
            this.isInit = false;
            this.mRecordThread = null;
            LogUtil.m15791e(TAG, "release recod");
            this.mRecord.release();
            this.mRecord = null;
            synchronized (this.mMutex) {
                this.mMutex.notify();
            }
        }
    }

    public boolean isCanRecord() {
        return this.isInit;
    }

    private void onRecordReadData(short[] buffer, int len) {
        if (this.isStop) {
            LogUtil.m15791e(TAG, "onRecordReadData, has stopped");
        } else if (this.mRecorderListener != null) {
            this.mRecorderListener.onReadData(buffer, len);
        } else {
            onReadData(buffer, len);
        }
    }

    private void onRecordReadError() {
        try {
            if (this.mRecorderListener != null) {
                this.mRecorderListener.onReadError();
            } else {
                onReadError();
            }
        } catch (Throwable th) {
        }
    }
}
