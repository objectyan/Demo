package com.baidu.che.codriver.vr.record.aec;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.INoProguard;
import com.baidu.che.codriver.vr.C2840n;
import com.baidu.che.codriver.vr.record.C1749d;
import com.baidu.che.codriver.vr.record.C2862b;
import com.baidu.che.codriver.vr.record.C2863c;
import com.baidu.che.codriver.vr.record.C2863c.C2857a;
import com.baidu.che.codriver.vr.record.outside.OutsideRecordHelper;
import java.io.InputStream;

public class RecordHelper implements INoProguard, C2857a {
    private static final String INPUT_STREAM = "#com.baidu.che.codriver.vr.record.aec.RecordHelper.getInputStream()";
    private static final int MSG_SOFTWARE_AEC_GET_ECHO = 1;
    private static boolean SAVE_FLAG = false;
    private static final String TAG = "RecordHelper";
    private static RecordHelper mInstance;
    private static C2863c mRecordInputStream;
    private byte[] inputData = new byte[C2858a.f9357a];
    private long lastDataPackageTime = 0;
    private C2862b mAecResultData;
    private C2862b mBeforeAecMicData;
    private C2862b mBeforeAecSpkData;
    private Context mContext;
    private Handler mHandler;
    private byte[] mMicBuffer = new byte[C2858a.f9357a];
    private C1749d mRecordTool;
    private C2855a mRecordType = C2855a.INSIDE_RAW;
    private byte[] mSpeakerBuffer = new byte[C2858a.f9357a];
    private C2856b mState;
    private C2740c mVolumeChangeListener;

    /* renamed from: com.baidu.che.codriver.vr.record.aec.RecordHelper$c */
    public interface C2740c {
        /* renamed from: a */
        void mo1951a(int i);
    }

    /* renamed from: com.baidu.che.codriver.vr.record.aec.RecordHelper$1 */
    class C28531 implements Callback {
        /* renamed from: a */
        final /* synthetic */ RecordHelper f9342a;

        C28531(RecordHelper this$0) {
            this.f9342a = this$0;
        }

        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Message newMsg = Message.obtain(msg);
                    int volume = C2858a.m10818c();
                    C2725h.m10207b(RecordHelper.TAG, "--MSG_SOFTWARE_AEC_GET_ECHO----volume:" + volume);
                    if (volume != newMsg.arg1) {
                        newMsg.arg1 = volume;
                        if (this.f9342a.mVolumeChangeListener != null) {
                            this.f9342a.mVolumeChangeListener.mo1951a(volume);
                        }
                    }
                    this.f9342a.mHandler.sendMessageDelayed(newMsg, 1000);
                    break;
            }
            return true;
        }
    }

    /* renamed from: com.baidu.che.codriver.vr.record.aec.RecordHelper$a */
    public enum C2855a {
        INSIDE_RAW,
        INSIDE_DSP_RAW,
        INSIDE_AEC_MIC_LEFT,
        INSIDE_AEC_MIC_RIGHT,
        OUTSIDE_RAW,
        OUTSIDE_AEC_MIC_LEFT,
        OUTSIDE_AEC_MIC_RIGHT,
        OUTSIDE_AEC_DUAL_CHANNEL
    }

    /* renamed from: com.baidu.che.codriver.vr.record.aec.RecordHelper$b */
    public enum C2856b {
        STATE_BUSY_WAKEUP,
        STATE_BUSY_SCENE_CMD,
        STATE_BUSY_NORMAL
    }

    public String getInfile() {
        if (this.mRecordType == C2855a.INSIDE_RAW || this.mRecordType == C2855a.INSIDE_DSP_RAW) {
            return null;
        }
        if (this.mRecordType == C2855a.OUTSIDE_RAW || this.mRecordType == C2855a.OUTSIDE_AEC_MIC_LEFT || this.mRecordType == C2855a.OUTSIDE_AEC_MIC_RIGHT) {
            return OutsideRecordHelper.ASR_INPUT_STREAM;
        }
        return INPUT_STREAM;
    }

    public static InputStream getInputStream() {
        if (mRecordInputStream == null || mRecordInputStream.m10840a()) {
            C2725h.m10207b(TAG, "-----getInputStream()--build RecordInputStream--");
            mRecordInputStream = new C2863c();
            if (mInstance != null) {
                mInstance.startRecord();
            }
        }
        return mRecordInputStream;
    }

    public void onClose() {
        endRecord();
    }

    public void setState(C2856b state) {
        this.mState = state;
    }

    public void init(Context context, C2740c listener) {
        C2862b c2862b;
        C2862b c2862b2 = null;
        mInstance = this;
        this.mContext = context;
        C2858a.m10812a();
        this.mRecordTool = new C2859b();
        if (SAVE_FLAG) {
            c2862b = new C2862b(this.mContext);
        } else {
            c2862b = null;
        }
        this.mAecResultData = c2862b;
        if (SAVE_FLAG) {
            c2862b = new C2862b(this.mContext);
        } else {
            c2862b = null;
        }
        this.mBeforeAecMicData = c2862b;
        if (SAVE_FLAG) {
            c2862b2 = new C2862b(this.mContext);
        }
        this.mBeforeAecSpkData = c2862b2;
        this.mVolumeChangeListener = listener;
        HandlerThread handlerThread = new HandlerThread("AecVolumeChangeListener");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), new C28531(this));
    }

    public void setRecordType(C2855a type, C1749d tool) {
        C2725h.m10207b(TAG, "setRecordType() " + type.name());
        if (type != this.mRecordType || this.mRecordType == C2855a.INSIDE_RAW) {
            this.mRecordType = type;
            switch (this.mRecordType) {
                case INSIDE_DSP_RAW:
                    return;
                case INSIDE_AEC_MIC_LEFT:
                case INSIDE_AEC_MIC_RIGHT:
                    this.mRecordTool = new C2860c();
                    this.mHandler.sendEmptyMessageDelayed(1, 1000);
                    return;
                case OUTSIDE_AEC_MIC_LEFT:
                case OUTSIDE_AEC_MIC_RIGHT:
                case OUTSIDE_AEC_DUAL_CHANNEL:
                case OUTSIDE_RAW:
                    this.mRecordTool = tool;
                    return;
                default:
                    this.mRecordTool = new C2859b();
                    return;
            }
        }
        C2725h.m10207b(TAG, "lastRecordType is " + this.mRecordType + " , setRecordType do nothing.");
    }

    public void reset() {
        C2725h.m10207b(TAG, "-----reset()----");
        if (mRecordInputStream == null || mRecordInputStream.m10840a()) {
            C2725h.m10207b(TAG, "-----reset()--build RecordInputStream--");
            mRecordInputStream = new C2863c();
        }
        if (this.mAecResultData != null) {
            this.mAecResultData.m10830a("_resultAfterAec");
        }
        if (this.mBeforeAecMicData != null) {
            this.mBeforeAecMicData.m10830a("_MicDataBeforeAec");
        }
        if (this.mBeforeAecSpkData != null) {
            this.mBeforeAecSpkData.m10830a("_SpkDataBeforeAec");
        }
        this.mRecordTool.mo1635c();
        mRecordInputStream.m10839a(this);
    }

    public void startRecord() {
        C2725h.m10207b(TAG, "-----startRecord()----");
        this.mRecordTool.mo1632a();
    }

    public void endRecord() {
        C2725h.m10207b(TAG, "-----endRecord()----");
        this.mRecordTool.mo1634b();
        if (this.mAecResultData != null) {
            this.mAecResultData.m10837d();
        }
        if (this.mBeforeAecMicData != null) {
            this.mBeforeAecMicData.m10837d();
        }
        if (this.mBeforeAecSpkData != null) {
            this.mBeforeAecSpkData.m10837d();
        }
    }

    public void release() {
        mRecordInputStream = null;
        C2858a.m10817b();
        this.mRecordTool.mo1634b();
    }

    public void feedAudioBuffer(byte[] micData, byte[] spkData) {
        if (micData == null || micData.length == 0 || spkData == null || spkData.length == 0) {
            C2725h.m10214e(TAG, "-----feedAudioBuffer-----NULL Data!!!");
            C2858a.m10817b();
            return;
        }
        if (this.mBeforeAecMicData != null) {
            this.mBeforeAecMicData.m10834b(micData);
        }
        if (this.mBeforeAecSpkData != null) {
            this.mBeforeAecSpkData.m10834b(spkData);
        }
        C2858a.m10813a(micData, spkData, this.inputData);
        byte[] finalData = this.inputData;
        if (C2840n.m10672a()) {
            this.lastDataPackageTime = SystemClock.elapsedRealtime();
        }
        if (this.mAecResultData != null) {
            this.mAecResultData.m10834b(finalData);
        } else if (mRecordInputStream != null && !mRecordInputStream.m10840a() && mRecordInputStream.m10838a(finalData, 0, C2858a.f9357a) == -1) {
            C2725h.m10214e(TAG, "--------feedAudioBuffer--ret == -1");
        }
    }

    public void feedAudioBuffer(byte[] rawData) {
        for (int i = 0; i < rawData.length / 4; i++) {
            if (isMicLeft()) {
                this.mMicBuffer[i * 2] = rawData[i * 4];
                this.mMicBuffer[(i * 2) + 1] = rawData[(i * 4) + 1];
                this.mSpeakerBuffer[i * 2] = rawData[(i * 4) + 2];
                this.mSpeakerBuffer[(i * 2) + 1] = rawData[(i * 4) + 3];
            } else {
                this.mSpeakerBuffer[i * 2] = rawData[i * 4];
                this.mSpeakerBuffer[(i * 2) + 1] = rawData[(i * 4) + 1];
                this.mMicBuffer[i * 2] = rawData[(i * 4) + 2];
                this.mMicBuffer[(i * 2) + 1] = rawData[(i * 4) + 3];
            }
        }
        feedAudioBuffer(this.mMicBuffer, this.mSpeakerBuffer);
    }

    private boolean isMicLeft() {
        return this.mRecordType == C2855a.INSIDE_AEC_MIC_LEFT || this.mRecordType == C2855a.OUTSIDE_AEC_MIC_LEFT;
    }

    public void setDspEchoEnergy(int echoEnergy) {
        int lvl = 1;
        if (echoEnergy == 0) {
            echoEnergy = 1;
        }
        double echoEnergydB = 20.0d * Math.log10(((double) echoEnergy) / 11584.0d);
        if (echoEnergydB < -9.0d) {
            lvl = 1;
        } else if (echoEnergydB < -4.5d) {
            lvl = 2;
        } else if (echoEnergydB < 0.0d) {
            lvl = 3;
        }
        C2725h.m10207b(TAG, "--MSG_HARDWARE_AEC_GET_ECHO---- echoEnergy:" + echoEnergy + "(" + echoEnergydB + "dB) level:" + lvl);
        if (this.mVolumeChangeListener != null) {
            this.mVolumeChangeListener.mo1951a(lvl);
        }
    }
}
