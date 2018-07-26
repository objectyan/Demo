package com.baidu.ufosdk.p248b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.ufosdk.util.C5219l;

@SuppressLint({"NewApi"})
/* compiled from: ScreenCollector */
/* renamed from: com.baidu.ufosdk.b.e */
public final class C5172e {
    /* renamed from: a */
    private static Display f21388a;
    /* renamed from: b */
    private static int f21389b;
    /* renamed from: c */
    private static int f21390c;

    /* renamed from: a */
    public static int[] m17562a(Context context) {
        if (f21389b == 0) {
            if (f21388a == null) {
                f21388a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (C5219l.m17768a() < 13) {
                point.set(f21388a.getWidth(), f21388a.getHeight());
            } else {
                f21388a.getSize(point);
            }
            f21389b = point.x;
            f21390c = point.y;
        }
        return new int[]{f21389b, f21390c};
    }

    /* renamed from: b */
    public static String m17563b(Context context) {
        int[] a = C5172e.m17562a(context);
        return a[0] + "x" + a[1];
    }
}
