package com.baidu.che.codriver.vr.record.aec;

import android.media.AudioRecord;
import android.os.Process;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2847o;

/* compiled from: NewPcmRecorder */
/* renamed from: com.baidu.che.codriver.vr.record.aec.d */
public class C2861d extends Thread {
    /* renamed from: a */
    private static final String f9363a = "NewPcmRecorder";
    /* renamed from: b */
    private static final int f9364b = 16000;
    /* renamed from: c */
    private static final int f9365c = 5120;
    /* renamed from: f */
    private static final int f9366f = 65536;
    /* renamed from: d */
    private volatile boolean f9367d = false;
    /* renamed from: e */
    private final Object f9368e = new Object();
    /* renamed from: g */
    private AudioRecord f9369g;

    public C2861d() {
        super(f9363a);
        start();
        C2725h.m10207b(f9363a, "----onCreate()------");
    }

    public void run() {
        C2725h.m10207b(f9363a, "----run------");
        Process.setThreadPriority(-19);
        byte[] tempBufferBytes = new byte[5120];
        while (true) {
            if (!this.f9367d) {
                synchronized (this.f9368e) {
                    if (!this.f9367d) {
                        try {
                            C2725h.m10214e(f9363a, "----run--wait()----");
                            this.f9368e.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            try {
                this.f9369g = new AudioRecord(1, 16000, 12, 2, 65536);
                this.f9369g.startRecording();
                C2725h.m10207b(f9363a, "----run-----isRecording:" + this.f9367d);
                while (this.f9367d) {
                    int bufferRead = this.f9369g.read(tempBufferBytes, 0, tempBufferBytes.length);
                    if (bufferRead == -3) {
                        C2725h.m10214e(f9363a, "read() returned AudioRecord.ERROR_INVALID_OPERATION");
                        break;
                    } else if (bufferRead == -2) {
                        C2725h.m10214e(f9363a, "read() returned AudioRecord.ERROR_BAD_VALUE");
                        break;
                    } else {
                        if (bufferRead != tempBufferBytes.length) {
                            C2725h.m10214e(f9363a, "------bufferRead != micBufferBytes.length-------bufferRead:" + bufferRead);
                        }
                        if (bufferRead > 0 && this.f9367d) {
                            C2847o.m10687a().m10738a(tempBufferBytes);
                        }
                    }
                }
                C2725h.m10207b(f9363a, "----mMicRecordInstance------stop() isRecording:" + this.f9367d);
                if (this.f9369g != null) {
                    this.f9369g.release();
                    this.f9369g = null;
                }
            } catch (Exception e2) {
                C2725h.m10207b(f9363a, "----mMicRecordInstance------stop() isRecording:" + this.f9367d);
                if (this.f9369g != null) {
                    this.f9369g.release();
                    this.f9369g = null;
                }
            } catch (Throwable th) {
                C2725h.m10207b(f9363a, "----mMicRecordInstance------stop() isRecording:" + this.f9367d);
                if (this.f9369g != null) {
                    this.f9369g.release();
                    this.f9369g = null;
                }
            }
        }
    }

    /* renamed from: a */
    public void m10827a() {
        C2725h.m10214e(f9363a, "---startRecord------");
        if (!this.f9367d) {
            this.f9367d = true;
            if (this.f9367d) {
                synchronized (this.f9368e) {
                    if (this.f9367d) {
                        this.f9368e.notify();
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void m10828b() {
        C2725h.m10214e(f9363a, "---pauseRecord start------");
        this.f9367d = false;
    }
}
