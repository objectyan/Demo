package com.baidu.che.codriver.vr.record;

import android.os.SystemClock;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2840n;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/* compiled from: RecordInputStream */
/* renamed from: com.baidu.che.codriver.vr.record.c */
public class C2863c extends InputStream {
    /* renamed from: a */
    private static final String f9374a = "RecordData";
    /* renamed from: b */
    private PipedInputStream f9375b = new PipedInputStream();
    /* renamed from: c */
    private PipedOutputStream f9376c;
    /* renamed from: d */
    private volatile boolean f9377d = false;
    /* renamed from: e */
    private C2857a f9378e;
    /* renamed from: f */
    private long f9379f = 0;

    /* compiled from: RecordInputStream */
    /* renamed from: com.baidu.che.codriver.vr.record.c$a */
    public interface C2857a {
        void onClose();
    }

    /* renamed from: a */
    public void m10839a(C2857a closeListener) {
        this.f9378e = closeListener;
    }

    public C2863c() {
        try {
            this.f9376c = new PipedOutputStream(this.f9375b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public int m10838a(byte[] buffer, int offset, int size) {
        if (buffer == null || this.f9376c == null) {
            C2725h.m10214e(f9374a, "mPipedOutputStream == null");
            return -1;
        }
        try {
            this.f9376c.write(buffer, offset, size);
            return size;
        } catch (IOException e) {
            return -1;
        }
    }

    @Deprecated
    public int read() throws IOException {
        if (this.f9377d || this.f9375b == null) {
            return -1;
        }
        return this.f9375b.read();
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        if (this.f9377d || this.f9375b == null) {
            C2725h.m10214e(f9374a, "----read mClosed || mPipedInputStream == null------");
            return -1;
        }
        if (C2840n.m10672a()) {
            this.f9379f = SystemClock.elapsedRealtime();
        }
        return this.f9375b.read(buffer, byteOffset, byteCount);
    }

    public void close() {
        C2725h.m10207b(f9374a, "----RecordInputStream----close()-----mClosed:" + this.f9377d);
        if (this.f9378e != null) {
            this.f9378e.onClose();
        }
        if (!this.f9377d) {
            this.f9377d = true;
            if (this.f9375b != null) {
                try {
                    this.f9375b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (this.f9376c != null) {
                try {
                    this.f9376c.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m10840a() {
        return this.f9377d;
    }
}
