package com.baidu.ufosdk.util;

import android.graphics.Bitmap;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import java.lang.ref.SoftReference;

/* compiled from: AsyncLoaderImage */
/* renamed from: com.baidu.ufosdk.util.b */
final class C5209b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C5208a f21690a;
    /* renamed from: b */
    private final /* synthetic */ String f21691b;
    /* renamed from: c */
    private final /* synthetic */ String f21692c;
    /* renamed from: d */
    private final /* synthetic */ C5224q f21693d;

    C5209b(C5208a c5208a, String str, String str2, C5224q c5224q) {
        this.f21690a = c5208a;
        this.f21691b = str;
        this.f21692c = str2;
        this.f21693d = c5224q;
    }

    public final void run() {
        try {
            Bitmap a = C5208a.m17728a(this.f21691b);
            if (a != null) {
                C5208a.f21688b.put(this.f21692c, new SoftReference(a));
                C5213f.m17749a().m17754a(a, this.f21692c);
                FeedbackInputActivity.f21455a.add(a);
                this.f21693d.obtainMessage(0, a).sendToTarget();
                return;
            }
            this.f21693d.obtainMessage(0, null).sendToTarget();
        } catch (OutOfMemoryError e) {
            C5210c.m17736d(e.toString());
            System.gc();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
