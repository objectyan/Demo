package com.baidu.android.pushservice.richmedia;

import android.content.Context;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p025d.C0463a.C0459g;
import com.baidu.android.pushservice.p027f.C0520a;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.richmedia.C0641c.C0640a;
import com.baidu.carlife.core.audio.C1163a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.baidu.android.pushservice.richmedia.a */
public class C0638a extends Thread implements Comparable<C0638a> {
    /* renamed from: e */
    public static int f2020e = 1;
    /* renamed from: f */
    public static int f2021f = 2;
    /* renamed from: g */
    private static HashSet<C0641c> f2022g = new HashSet();
    /* renamed from: a */
    protected C0424f f2023a;
    /* renamed from: b */
    public WeakReference<Context> f2024b;
    /* renamed from: c */
    protected long f2025c;
    /* renamed from: d */
    public C0641c f2026d;
    /* renamed from: h */
    private boolean f2027h = false;

    public C0638a(Context context, C0424f c0424f, C0641c c0641c) {
        this.f2023a = c0424f;
        this.f2024b = new WeakReference(context);
        this.f2025c = System.currentTimeMillis();
        this.f2026d = c0641c;
    }

    /* renamed from: a */
    private int m2793a(String str) {
        try {
            return ((HttpURLConnection) new URL(str).openConnection()).getContentLength();
        } catch (MalformedURLException e) {
            return 0;
        } catch (IOException e2) {
            return 0;
        }
    }

    /* renamed from: a */
    private C0459g m2794a(Context context, String str) {
        List b = C0463a.m2005b(context);
        if (b != null) {
            for (int i = 0; i < b.size(); i++) {
                if (((C0459g) b.get(i)).f1483b.equalsIgnoreCase(str)) {
                    return (C0459g) b.get(i);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m2795a(C0644e c0644e) {
        try {
            if (this.f2023a == null || c0644e == null) {
                C0638a.m2799b(this.f2026d);
                return;
            }
            if (c0644e.f2048c == 0) {
                String str = c0644e.f2050e;
                if (c0644e.f2046a == C0640a.REQ_TYPE_GET_ZIP && str != null) {
                    String substring = str.substring(0, str.lastIndexOf("."));
                    File file = new File(str);
                    C0638a.m2796a(file, substring);
                    file.delete();
                    c0644e.f2050e = substring;
                }
                this.f2023a.mo1275a(this, c0644e);
            } else if (c0644e.f2048c == 1) {
                this.f2023a.mo1276a(this, new Throwable("error: response http error errorCode=" + c0644e.f2047b));
            } else if (c0644e.f2048c == 3) {
                this.f2023a.mo1276a(this, new Throwable("error: request error,request is null or fileName is null."));
            } else if (c0644e.f2048c == 2) {
                this.f2023a.mo1277b(this);
            } else if (c0644e.f2048c == -1) {
                this.f2023a.mo1276a(this, new Throwable("IOException"));
            }
            C0638a.m2799b(this.f2026d);
        } catch (Throwable th) {
            C0638a.m2799b(this.f2026d);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m2796a(java.io.File r13, java.lang.String r14) {
        /*
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r3 = 0;
        r5 = 0;
        r2 = 0;
        r1 = 0;
        r0 = 0;
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00ac, all -> 0x00c5 }
        r6.<init>(r13);	 Catch:{ Exception -> 0x00ac, all -> 0x00c5 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x00f6, all -> 0x00e0 }
        r3.<init>(r6);	 Catch:{ Exception -> 0x00f6, all -> 0x00e0 }
        r4 = new java.util.zip.ZipInputStream;	 Catch:{ Exception -> 0x00fa, all -> 0x00e6 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x00fa, all -> 0x00e6 }
        r0 = r1;
        r1 = r2;
    L_0x0018:
        r5 = r4.getNextEntry();	 Catch:{ Exception -> 0x00ff, all -> 0x00eb }
        if (r5 == 0) goto L_0x0096;
    L_0x001e:
        r8 = new byte[r7];	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r9 = r5.getName();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r2 = 0;
        r10 = r9.length();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        if (r10 <= 0) goto L_0x0032;
    L_0x002b:
        r2 = "/";
        r2 = r9.split(r2);	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
    L_0x0032:
        r9 = new java.io.File;	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r10.<init>();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r10 = r10.append(r14);	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r11 = "/";
        r10 = r10.append(r11);	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r11 = r2.length;	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r11 = r11 + -1;
        r2 = r2[r11];	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r2 = r10.append(r2);	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r9.<init>(r2);	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r2 = r5.isDirectory();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        if (r2 != 0) goto L_0x0018;
    L_0x005a:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r5 = r9.getParent();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r5 = r2.exists();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        if (r5 != 0) goto L_0x006c;
    L_0x0069:
        r2.mkdirs();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
    L_0x006c:
        r2 = r9.exists();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        if (r2 != 0) goto L_0x0075;
    L_0x0072:
        r9.createNewFile();	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
    L_0x0075:
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r2.<init>(r9);	 Catch:{ Exception -> 0x0106, all -> 0x00eb }
        r1 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x0109, all -> 0x00f1 }
        r1.<init>(r2, r7);	 Catch:{ Exception -> 0x0109, all -> 0x00f1 }
    L_0x007f:
        r0 = 0;
        r0 = r4.read(r8, r0, r7);	 Catch:{ Exception -> 0x008c, all -> 0x00e9 }
        r5 = -1;
        if (r0 == r5) goto L_0x0090;
    L_0x0087:
        r5 = 0;
        r1.write(r8, r5, r0);	 Catch:{ Exception -> 0x008c, all -> 0x00e9 }
        goto L_0x007f;
    L_0x008c:
        r0 = move-exception;
        r0 = r1;
        r1 = r2;
        goto L_0x0018;
    L_0x0090:
        r1.flush();	 Catch:{ Exception -> 0x008c, all -> 0x00e9 }
        r0 = r1;
        r1 = r2;
        goto L_0x0018;
    L_0x0096:
        r2 = 5;
        r2 = new java.io.Closeable[r2];
        r5 = 0;
        r2[r5] = r6;
        r5 = 1;
        r2[r5] = r4;
        r4 = 2;
        r2[r4] = r1;
        r1 = 3;
        r2[r1] = r0;
        r0 = 4;
        r2[r0] = r3;
        com.baidu.android.pushservice.p027f.C0521b.m2169a(r2);
    L_0x00ab:
        return;
    L_0x00ac:
        r4 = move-exception;
        r4 = r3;
        r3 = r5;
    L_0x00af:
        r5 = 5;
        r5 = new java.io.Closeable[r5];
        r6 = 0;
        r5[r6] = r4;
        r4 = 1;
        r5[r4] = r3;
        r3 = 2;
        r5[r3] = r2;
        r2 = 3;
        r5[r2] = r1;
        r1 = 4;
        r5[r1] = r0;
        com.baidu.android.pushservice.p027f.C0521b.m2169a(r5);
        goto L_0x00ab;
    L_0x00c5:
        r4 = move-exception;
        r6 = r3;
        r3 = r0;
        r0 = r4;
        r4 = r5;
    L_0x00ca:
        r5 = 5;
        r5 = new java.io.Closeable[r5];
        r7 = 0;
        r5[r7] = r6;
        r6 = 1;
        r5[r6] = r4;
        r4 = 2;
        r5[r4] = r2;
        r2 = 3;
        r5[r2] = r1;
        r1 = 4;
        r5[r1] = r3;
        com.baidu.android.pushservice.p027f.C0521b.m2169a(r5);
        throw r0;
    L_0x00e0:
        r3 = move-exception;
        r4 = r5;
        r12 = r0;
        r0 = r3;
        r3 = r12;
        goto L_0x00ca;
    L_0x00e6:
        r0 = move-exception;
        r4 = r5;
        goto L_0x00ca;
    L_0x00e9:
        r0 = move-exception;
        goto L_0x00ca;
    L_0x00eb:
        r2 = move-exception;
        r12 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x00ca;
    L_0x00f1:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x00ca;
    L_0x00f6:
        r3 = move-exception;
        r3 = r5;
        r4 = r6;
        goto L_0x00af;
    L_0x00fa:
        r0 = move-exception;
        r0 = r3;
        r4 = r6;
        r3 = r5;
        goto L_0x00af;
    L_0x00ff:
        r2 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        r3 = r4;
        r4 = r6;
        goto L_0x00af;
    L_0x0106:
        r2 = move-exception;
        goto L_0x0018;
    L_0x0109:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.richmedia.a.a(java.io.File, java.lang.String):void");
    }

    /* renamed from: a */
    private static synchronized boolean m2797a(C0641c c0641c) {
        boolean add;
        synchronized (C0638a.class) {
            add = f2022g.add(c0641c);
        }
        return add;
    }

    /* renamed from: b */
    private C0644e m2798b() {
        InputStream a;
        RandomAccessFile randomAccessFile;
        C0644e c0644e = new C0644e();
        c0644e.f2049d = this.f2026d;
        if (this.f2026d != null) {
            c0644e.f2046a = this.f2026d.m2803a();
            if (this.f2026d.f2033b == null) {
                c0644e.f2048c = 3;
            } else if (C0638a.m2797a(this.f2026d)) {
                C0459g c0459g;
                C0459g a2 = m2794a((Context) this.f2024b.get(), this.f2026d.m2808c());
                if (a2 == null) {
                    c0459g = new C0459g();
                    c0459g.f1483b = this.f2026d.m2808c();
                    c0459g.f1482a = this.f2026d.f2032a;
                    c0459g.f1484c = this.f2026d.f2034c;
                    c0459g.f1485d = this.f2026d.f2035d;
                    c0459g.f1488g = 0;
                    c0459g.f1489h = m2793a(c0459g.f1483b);
                    c0459g.f1490i = f2020e;
                    c0459g.f1487f = c0459g.f1483b.substring(c0459g.f1483b.lastIndexOf(47) + 1);
                    c0459g.f1486e = this.f2026d.f2033b;
                    try {
                        C0463a.m1988a((Context) this.f2024b.get(), c0459g);
                    } catch (Exception e) {
                    }
                } else {
                    a2.f1489h = m2793a(a2.f1483b);
                    c0459g = a2;
                }
                if (c0459g.f1490i == f2021f) {
                    c0644e.f2048c = 0;
                    c0644e.f2049d = this.f2026d;
                    c0644e.f2050e = c0459g.f1486e + "/" + c0459g.f1487f;
                    return c0644e;
                }
                if (this.f2023a != null) {
                    this.f2023a.mo1273a(this);
                }
                try {
                    C0520a a3 = C0521b.m2163a(this.f2026d.m2808c(), this.f2026d.m2806b(), this.f2026d.f2037f);
                    if (a3.m2162b() == 200) {
                        a = a3.m2159a();
                        File file = new File(c0459g.f1486e);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(c0459g.f1486e + "/" + c0459g.f1487f);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        randomAccessFile = new RandomAccessFile(file2, "rw");
                        randomAccessFile.seek((long) c0459g.f1488g);
                        byte[] bArr = new byte[C1163a.f3002f];
                        int i = c0459g.f1488g;
                        C0639b c0639b = new C0639b();
                        c0639b.f2029b = (long) c0459g.f1489h;
                        c0639b.f2028a = (long) i;
                        m2802a(c0639b);
                        do {
                            if (this.f2027h) {
                                break;
                            }
                            int read = a.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            randomAccessFile.write(bArr, 0, read);
                            i += read;
                            c0639b = new C0639b();
                            c0639b.f2029b = (long) c0459g.f1489h;
                            c0639b.f2028a = (long) i;
                            m2802a(c0639b);
                        } while (i != c0459g.f1489h);
                        C0521b.m2169a(a, randomAccessFile);
                        if (this.f2027h) {
                            C0463a.m2002b((Context) this.f2024b.get(), c0459g.f1483b);
                            c0644e.f2048c = 2;
                            file2.delete();
                        } else {
                            c0459g.f1488g = i;
                            c0459g.f1490i = f2021f;
                            C0463a.m1986a((Context) this.f2024b.get(), c0459g.f1483b, c0459g);
                            c0644e.f2048c = 0;
                            c0644e.f2050e = file2.getAbsolutePath();
                        }
                    } else {
                        c0644e.f2048c = 1;
                        c0644e.f2047b = a3.m2162b();
                    }
                } catch (IOException e2) {
                    C0521b.m2169a(a, randomAccessFile);
                } catch (Exception e3) {
                    c0644e.f2048c = -1;
                } catch (Throwable th) {
                    C0521b.m2169a(a, randomAccessFile);
                }
            } else {
                this.f2023a = null;
                this.f2026d = null;
                return null;
            }
        }
        return c0644e;
    }

    /* renamed from: b */
    private static synchronized boolean m2799b(C0641c c0641c) {
        boolean remove;
        synchronized (C0638a.class) {
            remove = f2022g.remove(c0641c);
        }
        return remove;
    }

    /* renamed from: a */
    public int m2800a(C0638a c0638a) {
        if (c0638a == null) {
            return -1;
        }
        long a = c0638a.m2801a();
        return this.f2025c <= a ? this.f2025c < a ? 1 : 0 : -1;
    }

    /* renamed from: a */
    public long m2801a() {
        return this.f2025c;
    }

    /* renamed from: a */
    protected void m2802a(C0639b c0639b) {
        if (this.f2023a != null) {
            this.f2023a.mo1274a(this, c0639b);
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m2800a((C0638a) obj);
    }

    public void run() {
        m2795a(m2798b());
    }
}
