package com.baidu.navisdk.ui.voice.controller;

import android.os.Bundle;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.model.OrgVoiceItem;
import com.baidu.navisdk.ui.voice.model.OrgVoiceSet;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.vi.VJavaAudioRecorder;
import com.baidu.navisdk.vi.VJavaAudioRecorder.AudioRecorderListener;
import java.util.ArrayList;

public class VoiceRecordController {
    private static final int MAX_ITEM_VOICE_DATA_SIZE = 1638400;
    private static final long MAX_ITEM_VOICE_LEN = 10000;
    private static final long MIN_ITEM_VOICE_LEN = 1000;
    private static final int POSITION_DELAY_MILLIS = 1000;
    public static final int RECORD_RESULT_ERROR = 3;
    public static final int RECORD_RESULT_SUCCESS = 0;
    public static final int RECORD_RESULT_TOO_SHORT = 2;
    public static final int RECORD_RESULT_UNKNOWN = 1;
    private boolean bRecord;
    private boolean hasError;
    private VJavaAudioRecorder mAudioRecorder;
    private AudioRecorderListener mAudioRecorderListener;
    private Object mMutex;
    private boolean mNeedSave;
    private String mOrgWord;
    private long mStartRecordTime;
    private String mTaskId;
    private short[] mVoiceBuffer;
    private int mVoiceBufferLength;
    private final BNWorkerNormalTask<String, String> recordRefreshTask;

    /* renamed from: com.baidu.navisdk.ui.voice.controller.VoiceRecordController$1 */
    class C45311 implements AudioRecorderListener {
        C45311() {
        }

        public void onReadData(short[] buffer, int len) {
            synchronized (VoiceRecordController.this.mMutex) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "record===111   mVoiceBufferLength " + VoiceRecordController.this.mVoiceBufferLength + "len = " + len + " mVoiceBuffer " + VoiceRecordController.this.mVoiceBuffer.length);
                if (len > 0) {
                    if (VoiceRecordController.this.mVoiceBufferLength + len <= VoiceRecordController.this.mVoiceBuffer.length) {
                        System.arraycopy(buffer, 0, VoiceRecordController.this.mVoiceBuffer, VoiceRecordController.this.mVoiceBufferLength, len);
                        VoiceRecordController.this.mVoiceBufferLength = VoiceRecordController.this.mVoiceBufferLength + len;
                    } else {
                        VoiceRecordController.this.hasError = true;
                    }
                }
            }
        }

        public void onReadError() {
        }
    }

    private static class LazyHolder {
        public static final VoiceRecordController sInstance = new VoiceRecordController();

        private LazyHolder() {
        }
    }

    public void resetSaveState() {
        this.mNeedSave = false;
    }

    public boolean shouldSaveRecord() {
        return this.mNeedSave;
    }

    private VoiceRecordController() {
        this.mStartRecordTime = 0;
        this.mVoiceBuffer = null;
        this.mVoiceBufferLength = 0;
        this.mTaskId = null;
        this.mOrgWord = null;
        this.bRecord = false;
        this.hasError = false;
        this.mMutex = new Object();
        this.mNeedSave = false;
        this.mAudioRecorderListener = new C45311();
        this.recordRefreshTask = new BNWorkerNormalTask<String, String>("recordRefreshTask-" + getClass().getSimpleName(), null) {
            protected String execute() {
                BNVoice.getInstance().notifyObservers(2, 33, Long.valueOf(VoiceRecordController.this.getRecordTime()));
                if (VoiceRecordController.this.getRecordTime() > 10000) {
                    BNVoice.getInstance().notifyObservers(2, 32, Integer.valueOf(VoiceRecordController.this.stopRecord()));
                } else {
                    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(VoiceRecordController.this.recordRefreshTask, new BNWorkerConfig(100, 0), VoiceRecordController.MIN_ITEM_VOICE_LEN);
                }
                return null;
            }
        };
        this.mAudioRecorder = new VJavaAudioRecorder();
    }

    public static VoiceRecordController getInstance() {
        return LazyHolder.sInstance;
    }

    public boolean startRecord(String taskId, String orgWord) {
        if (this.mAudioRecorder == null || this.bRecord || !this.mAudioRecorder.isCanRecord()) {
            return false;
        }
        this.mVoiceBufferLength = 0;
        this.mOrgWord = orgWord;
        this.mTaskId = taskId;
        this.hasError = false;
        if (!this.mAudioRecorder.start()) {
            return false;
        }
        this.bRecord = true;
        startRefreshTimer();
        return true;
    }

    public boolean isRecord() {
        return this.bRecord;
    }

    public int stopRecord() {
        int ret = 1;
        cancelRefreshTimer();
        if (this.mAudioRecorder != null && this.bRecord && this.mAudioRecorder.isCanRecord()) {
            this.mAudioRecorder.stop();
            if (this.hasError) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "record error");
                ret = 3;
            } else {
                synchronized (this.mMutex) {
                    if (getRecordTime() < MIN_ITEM_VOICE_LEN) {
                        ret = 2;
                    } else if (this.mVoiceBufferLength > 0) {
                        ArrayList<OrgVoiceItem> voiceItems = new ArrayList();
                        OrgVoiceItem item = new OrgVoiceItem();
                        item.orgWrod = this.mOrgWord;
                        item.orgLen = this.mVoiceBufferLength;
                        item.orgData = new short[this.mVoiceBufferLength];
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "record len = " + this.mVoiceBufferLength + " orgword:" + this.mOrgWord);
                        System.arraycopy(this.mVoiceBuffer, 0, item.orgData, 0, this.mVoiceBufferLength);
                        voiceItems.add(item);
                        if (JNIVoicePersonalityControl.sInstance.recordVoiceData(voiceItems, voiceItems.size(), this.mTaskId)) {
                            ret = 0;
                            this.mNeedSave = true;
                        } else {
                            ret = 3;
                            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "stop Record save error");
                        }
                    }
                }
            }
        }
        this.mVoiceBufferLength = 0;
        this.bRecord = false;
        this.hasError = false;
        return ret;
    }

    public void initRecord() {
        LogUtil.m15791e("VoiceRecordView", "  MyClickListener isLongClick mAudioRecorder " + this.mAudioRecorder);
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.setRecorderListener(this.mAudioRecorderListener);
            if (this.mAudioRecorder.init()) {
                LogUtil.m15791e("VoiceRecordView", "  MyClickListener isLongClick mAudioRecorder.init() suceess ");
                this.mVoiceBuffer = new short[MAX_ITEM_VOICE_DATA_SIZE];
            }
            this.mVoiceBufferLength = 0;
            this.mTaskId = null;
        }
    }

    public void releaseRecord() {
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.stop();
            this.mAudioRecorder.release();
            this.mAudioRecorder.setRecorderListener(null);
            this.mVoiceBuffer = null;
            this.mVoiceBufferLength = 0;
            this.bRecord = false;
            this.mTaskId = null;
        }
    }

    public boolean saveRecordVoice(String taskId, String name, String tag, String bduss) {
        OrgVoiceSet set = new OrgVoiceSet();
        set.taskId = taskId;
        set.name = name;
        set.tag = tag;
        return getInstance().saveRecordVoiceData(true, set, bduss);
    }

    public boolean cleanRecordVoice(String taskId) {
        OrgVoiceSet set = new OrgVoiceSet();
        set.taskId = taskId;
        return getInstance().saveRecordVoiceData(false, set, null);
    }

    private boolean saveRecordVoiceData(boolean save, OrgVoiceSet set, String bduss) {
        Bundle bundle = new Bundle();
        bundle.putString("taskId", set.taskId);
        bundle.putString("name", set.name);
        bundle.putString("tag", set.tag);
        bundle.putString("bduss", bduss);
        return JNIVoicePersonalityControl.sInstance.saveRecordVoiceData(save, bundle);
    }

    private void startRefreshTimer() {
        cancelRefreshTimer();
        this.mStartRecordTime = System.currentTimeMillis();
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.recordRefreshTask, new BNWorkerConfig(100, 0), MIN_ITEM_VOICE_LEN);
    }

    private void cancelRefreshTimer() {
        BNWorkerCenter.getInstance().cancelTask(this.recordRefreshTask, false);
    }

    private long getRecordTime() {
        return System.currentTimeMillis() - this.mStartRecordTime;
    }
}
