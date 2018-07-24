package com.baidu.carlife.logic.voice;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/* compiled from: RecordInputStream */
/* renamed from: com.baidu.carlife.logic.voice.f */
public class C1892f extends InputStream {
    /* renamed from: a */
    private PipedInputStream f5844a = new PipedInputStream();
    /* renamed from: b */
    private PipedOutputStream f5845b;
    /* renamed from: c */
    private boolean f5846c = false;

    public C1892f() {
        try {
            this.f5845b = new PipedOutputStream(this.f5844a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public int m7241a(byte[] buffer, int offset, int size) {
        if (buffer == null || this.f5845b == null) {
            return -1;
        }
        try {
            this.f5845b.write(buffer, offset, size);
            return size;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int read() throws IOException {
        if (this.f5846c || this.f5844a == null) {
            return -1;
        }
        return this.f5844a.read();
    }

    public void close() {
        this.f5846c = true;
        if (this.f5844a != null) {
            try {
                this.f5844a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.f5845b != null) {
            try {
                this.f5845b.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m7242a() {
        if (this.f5845b != null) {
            try {
                this.f5845b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public boolean m7243b() {
        return this.f5846c;
    }
}
