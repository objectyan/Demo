package com.baidu.che.codriver.vr.record.outside;

import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.record.C1749d;
import com.baidu.che.codriver.vr.record.C2852a;
import com.baidu.che.codriver.vr.record.C2863c;
import java.io.InputStream;

public class OutsideRecordHelper {
    public static final String ASR_INPUT_STREAM = "#com.baidu.che.codriver.vr.record.outside.OutsideRecordHelper.getAsrInputStream()";
    private static final String TAG = "OutsideRecordHelper";
    public static final String WAKEUP_INPUT_STREAM = "#com.baidu.che.codriver.vr.record.outside.OutsideRecordHelper.getWakeupInputStream()";
    private static C2863c mRecordInputStream;
    private static C2863c mRecordInputStreamWakeup;
    private C2865a mOutsideDataReceiver;
    private C2852a mPcmWritor = new C28641(this);

    /* renamed from: com.baidu.che.codriver.vr.record.outside.OutsideRecordHelper$1 */
    class C28641 implements C2852a {
        /* renamed from: a */
        final /* synthetic */ OutsideRecordHelper f9380a;

        C28641(OutsideRecordHelper this$0) {
            this.f9380a = this$0;
        }

        /* renamed from: a */
        public void mo1979a(byte[] src, int offset, int length) {
            if (length == -1) {
                if (!(OutsideRecordHelper.mRecordInputStreamWakeup == null || OutsideRecordHelper.mRecordInputStreamWakeup.m10840a())) {
                    OutsideRecordHelper.mRecordInputStreamWakeup.close();
                }
                if (OutsideRecordHelper.mRecordInputStream != null && !OutsideRecordHelper.mRecordInputStream.m10840a()) {
                    OutsideRecordHelper.mRecordInputStream.close();
                    return;
                }
                return;
            }
            if (!(OutsideRecordHelper.mRecordInputStream == null || OutsideRecordHelper.mRecordInputStream.m10840a())) {
                OutsideRecordHelper.mRecordInputStream.m10838a(src, offset, length);
            }
            if (OutsideRecordHelper.mRecordInputStreamWakeup != null && !OutsideRecordHelper.mRecordInputStreamWakeup.m10840a()) {
                OutsideRecordHelper.mRecordInputStreamWakeup.m10838a(src, offset, length);
            }
        }
    }

    public static InputStream getAsrInputStream() {
        return mRecordInputStream;
    }

    public static InputStream getWakeupInputStream() {
        return mRecordInputStreamWakeup;
    }

    public void reset() {
        C2725h.m10207b(TAG, "-----reset()----");
        if (mRecordInputStream == null || mRecordInputStream.m10840a()) {
            C2725h.m10207b(TAG, "-----reset()--build RecordInputStream--");
            mRecordInputStream = new C2863c();
        }
    }

    public void startRecordForAsr(C1749d tool) {
        if (this.mOutsideDataReceiver == null || !this.mOutsideDataReceiver.isAlive()) {
            this.mOutsideDataReceiver = new C2865a(this.mPcmWritor, tool);
            this.mOutsideDataReceiver.start();
        }
        if (mRecordInputStream == null || mRecordInputStream.m10840a()) {
            mRecordInputStream = new C2863c();
        }
    }

    public void startRecordForWakeup(C1749d tool) {
        if (this.mOutsideDataReceiver == null || !this.mOutsideDataReceiver.isAlive()) {
            this.mOutsideDataReceiver = new C2865a(this.mPcmWritor, tool);
            this.mOutsideDataReceiver.start();
        }
        if (mRecordInputStreamWakeup == null || mRecordInputStreamWakeup.m10840a()) {
            mRecordInputStreamWakeup = new C2863c();
        }
    }

    public void closeRecordForAsr() {
        if (mRecordInputStream != null && !mRecordInputStream.m10840a()) {
            mRecordInputStream.close();
        }
    }

    public void closeRecordForWakeup() {
        if (mRecordInputStreamWakeup != null && !mRecordInputStreamWakeup.m10840a()) {
            mRecordInputStreamWakeup.close();
        }
    }

    public void release() {
        this.mOutsideDataReceiver = null;
        mRecordInputStream = null;
        mRecordInputStreamWakeup = null;
    }
}
