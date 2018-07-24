package com.baidu.carlife.logic.voice;

public class ReceiveDataThread extends Thread {
    private static final int AUDIO_PACKET_MAX_LENGTH = 5000;
    private static final int FILTER_PAKCAGE_NUM = 20;
    public static final int RECORD_STATUS_IDLE = 1;
    public static final int RECORD_STATUS_RECOG = 3;
    public static final int RECORD_STATUS_WAKEUP = 2;
    public static final int SAMPLE_RATE_16K = 16000;
    private static final String TAG = "CarLifeVoice";
    public static boolean isPlayMicAudio = false;
    private static C1892f mRecordInputStream;
    int dataLength = 0;
    int flag = -1;
    byte[] inputData = new byte[5000];
    private int mFilterIndex = 0;
    private int mRecordStatus = 1;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r13 = this;
        r2 = 4;
        r12 = 1;
        r11 = 3;
        r10 = 2;
        r9 = 0;
        r1 = 16000; // 0x3e80 float:2.2421E-41 double:7.905E-320;
        r5 = android.media.AudioTrack.getMinBufferSize(r1, r2, r10);
        r8 = 0;
        r0 = new android.media.AudioTrack;	 Catch:{ IllegalArgumentException -> 0x0040 }
        r1 = 3;
        r2 = 16000; // 0x3e80 float:2.2421E-41 double:7.905E-320;
        r3 = 4;
        r4 = 2;
        r6 = 1;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ IllegalArgumentException -> 0x0040 }
    L_0x0017:
        r1 = com.baidu.carlife.p087l.C1663a.m5979a();
        r2 = r13.inputData;
        r3 = 12;
        r1 = r1.m6033e(r2, r3);
        r13.flag = r1;
        r1 = r13.flag;
        r2 = -1;
        if (r1 == r2) goto L_0x0030;
    L_0x002a:
        r1 = r13.flag;
        r2 = 12;
        if (r1 == r2) goto L_0x0043;
    L_0x0030:
        r1 = "CarLifeVoice";
        r2 = "-- get data length failed";
        com.baidu.carlife.core.LogUtil.m4445e(r1, r2);
    L_0x0039:
        r1 = 0;
        r13.inputData = r1;
        r0.stop();	 Catch:{ IllegalStateException -> 0x013d }
    L_0x003f:
        return;
    L_0x0040:
        r7 = move-exception;
        r0 = r8;
        goto L_0x003f;
    L_0x0043:
        r1 = r13.inputData;
        r1 = r1[r9];
        r1 = r1 << 24;
        r2 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r1 = r1 & r2;
        r2 = r13.inputData;
        r2 = r2[r12];
        r2 = r2 << 16;
        r3 = 16711680; // 0xff0000 float:2.3418052E-38 double:8.256667E-317;
        r2 = r2 & r3;
        r1 = r1 + r2;
        r2 = r13.inputData;
        r2 = r2[r10];
        r2 = r2 << 8;
        r3 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r2 = r2 & r3;
        r1 = r1 + r2;
        r2 = r13.inputData;
        r2 = r2[r11];
        r2 = r2 << 0;
        r2 = r2 & 255;
        r1 = r1 + r2;
        r13.dataLength = r1;
        r1 = r13.dataLength;
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        if (r1 <= r2) goto L_0x008f;
    L_0x0072:
        r1 = "CarLifeVoice";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "---- get data too long!!!-len:";
        r2 = r2.append(r3);
        r3 = r13.dataLength;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.baidu.carlife.core.LogUtil.m4445e(r1, r2);
        goto L_0x0039;
    L_0x008f:
        r1 = com.baidu.carlife.p087l.C1663a.m5979a();
        r2 = r13.inputData;
        r3 = r13.dataLength;
        r1 = r1.m6033e(r2, r3);
        r13.flag = r1;
        r1 = r13.flag;
        if (r1 >= 0) goto L_0x00ab;
    L_0x00a1:
        r1 = "CarLifeVoice";
        r2 = "-- get data failed---";
        com.baidu.carlife.core.LogUtil.m4445e(r1, r2);
        goto L_0x0039;
    L_0x00ab:
        r1 = "CarLifeVoice";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "- get data OK!!-dataLength:";
        r2 = r2.append(r3);
        r3 = r13.dataLength;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.baidu.carlife.core.LogUtil.d(r1, r2);
        r1 = com.baidu.carlife.p087l.C1663a.m5979a();
        r1 = r1.m6001V();
        if (r1 == 0) goto L_0x00f7;
    L_0x00d1:
        r1 = r13.dataLength;
        if (r1 <= 0) goto L_0x00f7;
    L_0x00d5:
        r1 = com.baidu.carlife.p087l.C1663a.m5979a();
        r2 = r13.inputData;
        r3 = r13.dataLength;
        r1 = r1.m6040g(r2, r3);
        r13.inputData = r1;
        r1 = r13.inputData;
        if (r1 != 0) goto L_0x00f2;
    L_0x00e7:
        r1 = "CarLifeVoice";
        r2 = "decrypt failed!";
        com.baidu.carlife.core.LogUtil.m4445e(r1, r2);
        goto L_0x003f;
    L_0x00f2:
        r1 = r13.inputData;
        r1 = r1.length;
        r13.dataLength = r1;
    L_0x00f7:
        r1 = r13.mFilterIndex;
        r2 = r1 + 1;
        r13.mFilterIndex = r2;
        r2 = 20;
        if (r1 <= r2) goto L_0x0017;
    L_0x0101:
        r1 = isPlayMicAudio;
        if (r1 == 0) goto L_0x0117;
    L_0x0105:
        r1 = r13.inputData;
        r2 = r13.dataLength;
        r0.write(r1, r9, r2);
        r1 = r0.getPlayState();
        if (r1 == r11) goto L_0x0017;
    L_0x0112:
        r0.play();
        goto L_0x0017;
    L_0x0117:
        r1 = r13.mRecordStatus;
        if (r1 != r11) goto L_0x012a;
    L_0x011b:
        r1 = mRecordInputStream;
        if (r1 == 0) goto L_0x0017;
    L_0x011f:
        r1 = mRecordInputStream;
        r2 = r13.inputData;
        r3 = r13.dataLength;
        r1.m7241a(r2, r9, r3);
        goto L_0x0017;
    L_0x012a:
        r1 = r13.mRecordStatus;
        if (r1 != r10) goto L_0x0017;
    L_0x012e:
        r1 = mRecordInputStream;
        if (r1 == 0) goto L_0x0017;
    L_0x0132:
        r1 = mRecordInputStream;
        r2 = r13.inputData;
        r3 = r13.dataLength;
        r1.m7241a(r2, r9, r3);
        goto L_0x0017;
    L_0x013d:
        r7 = move-exception;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.logic.voice.ReceiveDataThread.run():void");
    }

    public void setRecordStatus(int status) {
        this.mRecordStatus = status;
        this.mFilterIndex = 0;
        if (mRecordInputStream != null) {
            mRecordInputStream.close();
        }
        mRecordInputStream = new C1892f();
    }

    public static C1892f getExtSource() {
        return mRecordInputStream;
    }
}
