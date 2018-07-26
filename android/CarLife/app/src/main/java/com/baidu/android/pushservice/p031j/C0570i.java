package com.baidu.android.pushservice.p031j;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.baidu.android.pushservice.j.i */
public class C0570i {
    /* renamed from: a */
    byte[] f1862a = new byte[8];
    /* renamed from: b */
    private DataOutputStream f1863b;

    public C0570i(OutputStream outputStream) {
        this.f1863b = new DataOutputStream(outputStream);
    }

    /* renamed from: a */
    public void m2451a() throws IOException {
        this.f1863b.close();
    }

    /* renamed from: a */
    public final void m2452a(int i) throws Exception {
        this.f1862a[1] = (byte) (i >> 8);
        this.f1862a[0] = (byte) i;
        this.f1863b.write(this.f1862a, 0, 2);
    }

    /* renamed from: a */
    public final void m2453a(long j) throws Exception {
        this.f1862a[7] = (byte) ((int) (j >> 56));
        this.f1862a[6] = (byte) ((int) (j >> 48));
        this.f1862a[5] = (byte) ((int) (j >> 40));
        this.f1862a[4] = (byte) ((int) (j >> 32));
        this.f1862a[3] = (byte) ((int) (j >> 24));
        this.f1862a[2] = (byte) ((int) (j >> 16));
        this.f1862a[1] = (byte) ((int) (j >> 8));
        this.f1862a[0] = (byte) ((int) j);
        this.f1863b.write(this.f1862a, 0, 8);
    }

    /* renamed from: a */
    public void m2454a(byte[] bArr) throws Exception {
        this.f1863b.write(bArr);
    }

    /* renamed from: b */
    public final void m2455b(int i) throws Exception {
        this.f1862a[3] = (byte) (i >> 24);
        this.f1862a[2] = (byte) (i >> 16);
        this.f1862a[1] = (byte) (i >> 8);
        this.f1862a[0] = (byte) i;
        this.f1863b.write(this.f1862a, 0, 4);
    }
}
