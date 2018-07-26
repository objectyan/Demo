package com.baidu.android.pushservice.p031j;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.baidu.android.pushservice.j.h */
public class C0569h {
    /* renamed from: a */
    byte[] f1860a = new byte[8];
    /* renamed from: b */
    private DataInputStream f1861b;

    public C0569h(InputStream inputStream) {
        this.f1861b = new DataInputStream(inputStream);
    }

    /* renamed from: a */
    private int m2445a(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int read = this.f1861b.read(this.f1860a, i2, i - i2);
            if (read == -1) {
                return read;
            }
            i2 += read;
        }
        return i2;
    }

    /* renamed from: a */
    public void m2446a() throws IOException {
        this.f1861b.close();
    }

    /* renamed from: a */
    public final void m2447a(byte[] bArr) throws IOException {
        this.f1861b.readFully(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public final int m2448b() throws IOException {
        if (m2445a(4) >= 0) {
            return ((((this.f1860a[3] & 255) << 24) | ((this.f1860a[2] & 255) << 16)) | ((this.f1860a[1] & 255) << 8)) | (this.f1860a[0] & 255);
        }
        throw new EOFException();
    }

    /* renamed from: c */
    public final short m2449c() throws IOException {
        if (m2445a(2) >= 0) {
            return (short) (((this.f1860a[1] & 255) << 8) | (this.f1860a[0] & 255));
        }
        throw new EOFException();
    }

    /* renamed from: d */
    public final long m2450d() throws IOException {
        if (m2445a(8) < 0) {
            throw new EOFException();
        }
        return (((long) (((((this.f1860a[3] & 255) << 24) | ((this.f1860a[2] & 255) << 16)) | ((this.f1860a[1] & 255) << 8)) | (this.f1860a[0] & 255))) & 4294967295L) | ((((long) (((((this.f1860a[7] & 255) << 24) | ((this.f1860a[6] & 255) << 16)) | ((this.f1860a[5] & 255) << 8)) | (this.f1860a[4] & 255))) & 4294967295L) << 32);
    }
}
