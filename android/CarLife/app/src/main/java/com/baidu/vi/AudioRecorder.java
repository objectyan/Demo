package com.baidu.vi;

import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.os.Process;

public class AudioRecorder {
    private static final int CHANNEL_DOUBLE = 2;
    private static final int CHANNEL_SINGLE = 1;
    private static final int ERR_CODE_PARAMS_ILLEGAL = 1;
    private static final int ERR_CODE_SUCCESS = 0;
    private static final int MSG_READ_DATA = 1;
    private static final int MSG_READ_ERROR = 2;
    private static final int WAY_ASYNC = 1;
    private static final int WAY_SYNC = 0;
    private static Handler mHandler = new C52321();
    private boolean isAsync = true;
    private volatile boolean isRecording = false;
    private int mBufferSize;
    private int mCallBackBufferSize;
    private int mChannel;
    private int mFormat;
    private int mJniData;
    private Object mMutex = new Object();
    private int mRate;
    private Thread mRecordThread = new Thread(this, AudioRecorder.class.getSimpleName() + "-Record") {
        /* renamed from: a */
        final /* synthetic */ AudioRecorder f21727a;

        public void run() {
            Process.setThreadPriority(-19);
            this.f21727a.mRecorder.startRecording();
            int result = 0;
            while (this.f21727a.isRecording) {
                byte[] buffer = new byte[this.f21727a.mCallBackBufferSize];
                if (this.f21727a.mRecorder != null) {
                    result = this.f21727a.mRecorder.read(buffer, 0, this.f21727a.mCallBackBufferSize);
                }
                if (result == -3 || result == -2 || result == -1 || result == 0) {
                    this.f21727a.handleReadError();
                } else {
                    this.f21727a.handleReadData(buffer, result);
                }
            }
        }
    };
    private volatile AudioRecord mRecorder;

    /* renamed from: com.baidu.vi.AudioRecorder$1 */
    static class C52321 extends Handler {
        C52321() {
        }

        public void handleMessage(Message msg) {
            AudioRecorder recorder = ((ReadData) msg.obj).f21728a;
            switch (msg.what) {
                case 1:
                    if (recorder.isRecording) {
                        recorder.onReadData(((ReadData) msg.obj).f21729b, ((ReadData) msg.obj).f21730c);
                        return;
                    }
                    return;
                case 2:
                    if (recorder.isRecording) {
                        recorder.onReadError();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private class ReadData {
        /* renamed from: a */
        AudioRecorder f21728a;
        /* renamed from: b */
        byte[] f21729b;
        /* renamed from: c */
        int f21730c;
        /* renamed from: d */
        final /* synthetic */ AudioRecorder f21731d;

        public ReadData(AudioRecorder audioRecorder, AudioRecorder parent, byte[] data, int len) {
            this.f21731d = audioRecorder;
            this.f21728a = parent;
            this.f21729b = data;
            this.f21730c = len;
        }
    }

    native void onReadData(byte[] bArr, int i);

    native void onReadError();

    private void handleReadError() {
        if (this.isAsync) {
            mHandler.sendMessage(mHandler.obtainMessage(2, new ReadData(this, this, null, 0)));
        } else if (this.isRecording) {
            onReadError();
        }
    }

    private void handleReadData(byte[] data, int len) {
        if (this.isAsync) {
            mHandler.sendMessage(mHandler.obtainMessage(1, new ReadData(this, this, data, len)));
        } else if (this.isRecording) {
            onReadData(data, len);
        }
    }

    public AudioRecorder(int format, int sampleRate, int bits, int channel, int bufferSize, int callBackBufferSize, int way) {
        boolean z = true;
        if (bits == 8) {
            this.mFormat = 3;
        } else {
            this.mFormat = 2;
        }
        if (channel == 2) {
            this.mChannel = 3;
        } else {
            this.mChannel = 2;
        }
        if (way != 1) {
            z = false;
        }
        this.isAsync = z;
        this.mRate = sampleRate;
        this.mBufferSize = bufferSize;
        this.mCallBackBufferSize = callBackBufferSize;
    }

    private static int getMinBufferSize(int format, int sampleRate, int bits, int channel) {
        if (bits == 8) {
            format = 3;
        } else {
            format = 2;
        }
        if (channel == 2) {
            channel = 3;
        } else {
            channel = 2;
        }
        int size = 0;
        try {
            size = AudioRecord.getMinBufferSize(sampleRate, channel, format);
            return size > 0 ? size : 0;
        } catch (Exception e) {
            return size;
        }
    }

    private void setWay(int way) {
        boolean z = true;
        if (way != 1) {
            z = false;
        }
        this.isAsync = z;
    }

    private int start() {
        if (this.mRecorder != null) {
            this.mRecorder.stop();
            this.mRecorder.release();
            this.mRecorder = null;
        }
        try {
            int version = Integer.parseInt(VERSION.SDK);
            if (version >= 7) {
                this.mRecorder = new AudioRecord(1, this.mRate, this.mChannel, this.mFormat, this.mBufferSize);
            }
            if (version < 7 || this.mRecorder.getState() == 0) {
                this.mRecorder = new AudioRecord(1, this.mRate, this.mChannel, this.mFormat, this.mBufferSize);
            }
        } catch (NumberFormatException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.mRecorder.getState() == 0 || this.mRecorder == null) {
            return 1;
        }
        this.isRecording = true;
        this.mRecordThread.start();
        return 0;
    }

    private void stop() {
        this.isRecording = false;
        if (this.mRecorder != null) {
            this.mRecorder.stop();
        }
    }

    private void release() {
        if (this.mRecorder != null) {
            this.mRecorder.release();
        }
        this.mRecorder = null;
    }
}
