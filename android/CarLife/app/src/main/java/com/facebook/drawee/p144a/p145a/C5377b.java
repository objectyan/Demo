package com.facebook.drawee.p144a.p145a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.p150f.C2947h;
import com.facebook.imagepipeline.p150f.C2948j;
import com.facebook.imagepipeline.p150f.C5509g;

/* compiled from: Fresco */
/* renamed from: com.facebook.drawee.a.a.b */
public class C5377b {
    /* renamed from: a */
    private static C5379e f21980a;

    private C5377b() {
    }

    /* renamed from: a */
    public static void m18413a(Context context) {
        C2948j.a(context);
        C5377b.m18416b(context);
    }

    /* renamed from: a */
    public static void m18414a(Context context, C2947h imagePipelineConfig) {
        C2948j.a(imagePipelineConfig);
        C5377b.m18416b(context);
    }

    /* renamed from: b */
    private static void m18416b(Context context) {
        f21980a = new C5379e(context);
        SimpleDraweeView.m18650a(f21980a);
    }

    /* renamed from: a */
    public static C5379e m18412a() {
        return f21980a;
    }

    /* renamed from: b */
    public static C5378d m18415b() {
        return f21980a.m18433a();
    }

    /* renamed from: c */
    public static C2948j m18417c() {
        return C2948j.a();
    }

    /* renamed from: d */
    public static C5509g m18418d() {
        return C5377b.m18417c().j();
    }

    /* renamed from: e */
    public static void m18419e() {
        f21980a = null;
        SimpleDraweeView.m18652g();
        C2948j.b();
    }
}
