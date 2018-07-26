package com.baidu.location.p188h;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.baidu.location.h.c */
public class C3382c {
    /* renamed from: c */
    static C3382c f18320c;
    /* renamed from: a */
    String f18321a = "firll.dat";
    /* renamed from: b */
    int f18322b = 3164;
    /* renamed from: d */
    int f18323d = 0;
    /* renamed from: e */
    int f18324e = 20;
    /* renamed from: f */
    int f18325f = 40;
    /* renamed from: g */
    int f18326g = 60;
    /* renamed from: h */
    int f18327h = 80;
    /* renamed from: i */
    int f18328i = 100;

    /* renamed from: a */
    private long m14409a(int i) {
        Throwable th;
        String l = C3391g.m14456l();
        if (l == null) {
            return -1;
        }
        String str = l + File.separator + this.f18321a;
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile randomAccessFile2;
        try {
            randomAccessFile2 = new RandomAccessFile(str, "rw");
            try {
                randomAccessFile2.seek((long) i);
                int readInt = randomAccessFile2.readInt();
                long readLong = randomAccessFile2.readLong();
                if (readInt == randomAccessFile2.readInt()) {
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e) {
                        }
                    }
                    return readLong;
                } else if (randomAccessFile2 == null) {
                    return -1;
                } else {
                    try {
                        randomAccessFile2.close();
                        return -1;
                    } catch (IOException e2) {
                        return -1;
                    }
                }
            } catch (Exception e3) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    return -1;
                }
                try {
                    randomAccessFile.close();
                    return -1;
                } catch (IOException e4) {
                    return -1;
                }
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            if (randomAccessFile != null) {
                return -1;
            }
            randomAccessFile.close();
            return -1;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile2 = null;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static C3382c m14410a() {
        if (f18320c == null) {
            f18320c = new C3382c();
        }
        return f18320c;
    }

    /* renamed from: a */
    private void m14411a(int i, long j) {
        String l = C3391g.m14456l();
        if (l != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(l + File.separator + this.f18321a, "rw");
                randomAccessFile.seek((long) i);
                randomAccessFile.writeInt(this.f18322b);
                randomAccessFile.writeLong(j);
                randomAccessFile.writeInt(this.f18322b);
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public void m14412a(long j) {
        m14411a(this.f18323d, j);
    }

    /* renamed from: b */
    public long m14413b() {
        return m14409a(this.f18323d);
    }

    /* renamed from: b */
    public void m14414b(long j) {
        m14411a(this.f18324e, j);
    }

    /* renamed from: c */
    public long m14415c() {
        return m14409a(this.f18324e);
    }

    /* renamed from: c */
    public void m14416c(long j) {
        m14411a(this.f18325f, j);
    }

    /* renamed from: d */
    public long m14417d() {
        return m14409a(this.f18326g);
    }

    /* renamed from: d */
    public void m14418d(long j) {
        m14411a(this.f18326g, j);
    }

    /* renamed from: e */
    public long m14419e() {
        return m14409a(this.f18327h);
    }

    /* renamed from: e */
    public void m14420e(long j) {
        m14411a(this.f18327h, j);
    }

    /* renamed from: f */
    public long m14421f() {
        return m14409a(this.f18328i);
    }

    /* renamed from: f */
    public void m14422f(long j) {
        m14411a(this.f18328i, j);
    }
}
