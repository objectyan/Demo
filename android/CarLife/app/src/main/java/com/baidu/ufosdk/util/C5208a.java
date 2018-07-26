package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressLint({"HandlerLeak"})
/* compiled from: AsyncLoaderImage */
/* renamed from: com.baidu.ufosdk.util.a */
public final class C5208a {
    /* renamed from: a */
    public static C5208a f21687a;
    /* renamed from: b */
    private static HashMap f21688b;
    /* renamed from: c */
    private static ExecutorService f21689c;

    /* renamed from: a */
    public static synchronized C5208a m17729a() {
        C5208a c5208a;
        synchronized (C5208a.class) {
            if (f21687a == null) {
                f21687a = new C5208a();
                if (f21689c == null) {
                    f21689c = Executors.newFixedThreadPool(1);
                }
            }
            c5208a = f21687a;
        }
        return c5208a;
    }

    private C5208a() {
        if (f21688b == null) {
            f21688b = new HashMap();
        }
    }

    /* renamed from: a */
    public final Bitmap m17731a(C5224q c5224q, String str) {
        Bitmap bitmap;
        String c = C5220m.m17774c(str);
        if (f21688b.containsKey(c)) {
            bitmap = (Bitmap) ((SoftReference) f21688b.get(c)).get();
            if (bitmap != null) {
                return bitmap;
            }
        }
        try {
            bitmap = C5213f.m17748a(c);
        } catch (OutOfMemoryError e) {
            System.gc();
            bitmap = null;
        }
        if (bitmap != null) {
            f21688b.put(c, new SoftReference(bitmap));
            return bitmap;
        }
        f21689c.execute(new C5209b(this, str, c, c5224q));
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static android.graphics.Bitmap m17728a(java.lang.String r6) {
        /*
        r2 = 0;
        r0 = new java.net.URL;	 Catch:{ OutOfMemoryError -> 0x0035, Exception -> 0x004d }
        r0.<init>(r6);	 Catch:{ OutOfMemoryError -> 0x0035, Exception -> 0x004d }
        r0 = r0.openConnection();	 Catch:{ OutOfMemoryError -> 0x0035, Exception -> 0x004d }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ OutOfMemoryError -> 0x0035, Exception -> 0x004d }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ OutOfMemoryError -> 0x0035, Exception -> 0x004d }
        r1 = 1;
        r0.setDoInput(r1);	 Catch:{ OutOfMemoryError -> 0x0035, Exception -> 0x004d }
        r0.connect();	 Catch:{ OutOfMemoryError -> 0x0035, Exception -> 0x004d }
        r1 = r0.getInputStream();	 Catch:{ OutOfMemoryError -> 0x0035, Exception -> 0x004d }
        r2 = android.graphics.BitmapFactory.decodeStream(r1);	 Catch:{ OutOfMemoryError -> 0x0082, Exception -> 0x0076, all -> 0x0073 }
        if (r2 == 0) goto L_0x008e;
    L_0x0022:
        r0 = r2.getWidth();	 Catch:{ OutOfMemoryError -> 0x0088, Exception -> 0x007c, all -> 0x0073 }
        r3 = r2.getHeight();	 Catch:{ OutOfMemoryError -> 0x0088, Exception -> 0x007c, all -> 0x0073 }
        r4 = 1;
        r0 = android.graphics.Bitmap.createScaledBitmap(r2, r0, r3, r4);	 Catch:{ OutOfMemoryError -> 0x0088, Exception -> 0x007c, all -> 0x0073 }
    L_0x002f:
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.close();	 Catch:{ IOException -> 0x006e }
    L_0x0034:
        return r0;
    L_0x0035:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0038:
        java.lang.System.gc();	 Catch:{ all -> 0x0062 }
        r1 = r1.toString();	 Catch:{ all -> 0x0062 }
        com.baidu.ufosdk.util.C5210c.m17736d(r1);	 Catch:{ all -> 0x0062 }
        if (r2 == 0) goto L_0x0034;
    L_0x0044:
        r2.close();	 Catch:{ IOException -> 0x0048 }
        goto L_0x0034;
    L_0x0048:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0034;
    L_0x004d:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0050:
        r1 = r1.toString();	 Catch:{ all -> 0x0062 }
        com.baidu.ufosdk.util.C5210c.m17736d(r1);	 Catch:{ all -> 0x0062 }
        if (r2 == 0) goto L_0x0034;
    L_0x0059:
        r2.close();	 Catch:{ IOException -> 0x005d }
        goto L_0x0034;
    L_0x005d:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
    L_0x0063:
        if (r2 == 0) goto L_0x0068;
    L_0x0065:
        r2.close();	 Catch:{ IOException -> 0x0069 }
    L_0x0068:
        throw r0;
    L_0x0069:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0068;
    L_0x006e:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0034;
    L_0x0073:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0063;
    L_0x0076:
        r0 = move-exception;
        r5 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r5;
        goto L_0x0050;
    L_0x007c:
        r0 = move-exception;
        r5 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r5;
        goto L_0x0050;
    L_0x0082:
        r0 = move-exception;
        r5 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r5;
        goto L_0x0038;
    L_0x0088:
        r0 = move-exception;
        r5 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r5;
        goto L_0x0038;
    L_0x008e:
        r0 = r2;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ufosdk.util.a.a(java.lang.String):android.graphics.Bitmap");
    }
}
