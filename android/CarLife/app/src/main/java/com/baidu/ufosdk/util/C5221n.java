package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import java.io.ByteArrayOutputStream;

/* compiled from: GlobalScreenShot */
/* renamed from: com.baidu.ufosdk.util.n */
public final class C5221n {
    /* renamed from: a */
    public static C5221n f21711a;
    /* renamed from: b */
    private Context f21712b;
    /* renamed from: c */
    private Bitmap f21713c;
    /* renamed from: d */
    private ByteArrayOutputStream f21714d;

    /* renamed from: a */
    public static synchronized C5221n m17776a(Context context) {
        C5221n c5221n;
        synchronized (C5221n.class) {
            if (f21711a == null) {
                f21711a = new C5221n(context);
            }
            c5221n = f21711a;
        }
        return c5221n;
    }

    private C5221n(Context context) {
        this.f21712b = context;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public final void m17778a(Activity activity, int i) {
        int i2 = 40;
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        this.f21714d = new ByteArrayOutputStream();
        this.f21713c = decorView.getDrawingCache();
        if (this.f21713c != null) {
            this.f21713c.compress(CompressFormat.JPEG, 40, this.f21714d);
        }
        C5210c.m17735c("stream.toByteArray() length is " + this.f21714d.toByteArray().length);
        C5210c.m17735c("stream.toByteArray() length is " + C5216i.m17767c((long) this.f21714d.toByteArray().length));
        int length = this.f21714d.toByteArray().length;
        while (length > 300000 && i2 >= 0) {
            C5210c.m17735c("quality is " + i2);
            this.f21714d = new ByteArrayOutputStream();
            this.f21713c.compress(CompressFormat.JPEG, i2, this.f21714d);
            i2 -= 10;
            length = this.f21714d.toByteArray().length;
            C5210c.m17735c("streamLength is " + length);
        }
        C5210c.m17735c("stream.toByteArray() length is " + this.f21714d.toByteArray().length);
        C5210c.m17735c("stream.toByteArray() length is " + C5216i.m17767c((long) this.f21714d.toByteArray().length));
        Runnable c5222o = new C5222o(this, activity, i);
        if (this.f21713c == null) {
            C5210c.m17736d("screen shot is null");
            c5222o.run();
            return;
        }
        try {
            this.f21713c.setHasAlpha(false);
        } catch (Exception e) {
        }
        this.f21713c.prepareToDraw();
        c5222o.run();
    }
}
