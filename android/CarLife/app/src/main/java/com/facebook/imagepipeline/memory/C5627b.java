package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5354o;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p140h.C5329c;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imagepipeline.p276e.C5496e;
import com.facebook.p148h.C2940a;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: BitmapCounter */
/* renamed from: com.facebook.imagepipeline.memory.b */
public class C5627b {
    @GuardedBy("this")
    /* renamed from: a */
    private int f22750a;
    @GuardedBy("this")
    /* renamed from: b */
    private long f22751b;
    /* renamed from: c */
    private final int f22752c;
    /* renamed from: d */
    private final int f22753d;
    /* renamed from: e */
    private final C5329c<Bitmap> f22754e;

    /* compiled from: BitmapCounter */
    /* renamed from: com.facebook.imagepipeline.memory.b$1 */
    class C56261 implements C5329c<Bitmap> {
        /* renamed from: a */
        final /* synthetic */ C5627b f22749a;

        C56261(C5627b this$0) {
            this.f22749a = this$0;
        }

        /* renamed from: a */
        public void m19491a(Bitmap value) {
            try {
                this.f22749a.m19497b(value);
            } finally {
                value.recycle();
            }
        }
    }

    public C5627b(int maxCount, int maxSize) {
        boolean z = true;
        C5350k.m18315a(maxCount > 0);
        if (maxSize <= 0) {
            z = false;
        }
        C5350k.m18315a(z);
        this.f22752c = maxCount;
        this.f22753d = maxSize;
        this.f22754e = new C56261(this);
    }

    /* renamed from: a */
    public synchronized boolean m19495a(Bitmap bitmap) {
        boolean z;
        int bitmapSize = C2940a.a(bitmap);
        if (this.f22750a >= this.f22752c || this.f22751b + ((long) bitmapSize) > ((long) this.f22753d)) {
            z = false;
        } else {
            this.f22750a++;
            this.f22751b += (long) bitmapSize;
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized void m19497b(Bitmap bitmap) {
        boolean z = true;
        synchronized (this) {
            int bitmapSize = C2940a.a(bitmap);
            C5350k.m18316a(this.f22750a > 0, (Object) "No bitmaps registered.");
            if (((long) bitmapSize) > this.f22751b) {
                z = false;
            }
            C5350k.m18317a(z, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(bitmapSize), Long.valueOf(this.f22751b));
            this.f22751b -= (long) bitmapSize;
            this.f22750a--;
        }
    }

    /* renamed from: a */
    public synchronized int m19493a() {
        return this.f22750a;
    }

    /* renamed from: b */
    public synchronized long m19496b() {
        return this.f22751b;
    }

    /* renamed from: c */
    public C5329c<Bitmap> m19498c() {
        return this.f22754e;
    }

    /* renamed from: a */
    public List<C2921a<Bitmap>> m19494a(List<Bitmap> bitmaps) {
        Bitmap bitmap;
        int countedBitmaps = 0;
        while (countedBitmaps < bitmaps.size()) {
            try {
                bitmap = (Bitmap) bitmaps.get(countedBitmaps);
                if (VERSION.SDK_INT < 21) {
                    Bitmaps.m19635a(bitmap);
                }
                if (m19495a(bitmap)) {
                    countedBitmaps++;
                } else {
                    throw new C5496e();
                }
            } catch (Exception exception) {
                if (bitmaps != null) {
                    for (Bitmap bitmap2 : bitmaps) {
                        int countedBitmaps2 = countedBitmaps - 1;
                        if (countedBitmaps > 0) {
                            m19497b(bitmap2);
                        }
                        bitmap2.recycle();
                        countedBitmaps = countedBitmaps2;
                    }
                }
                throw C5354o.m18340b(exception);
            }
        }
        List<C2921a<Bitmap>> ret = new ArrayList();
        for (Bitmap bitmap22 : bitmaps) {
            ret.add(C2921a.a(bitmap22, this.f22754e));
        }
        return ret;
    }
}
