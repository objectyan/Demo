package com.facebook.imagepipeline.p271a.p272a;

import com.facebook.imagepipeline.p150f.C5497e;
import com.facebook.imagepipeline.p275c.C5456e;

/* compiled from: AnimatedFactoryProvider */
/* renamed from: com.facebook.imagepipeline.a.a.c */
public class C5444c {
    /* renamed from: a */
    private static boolean f22232a;
    /* renamed from: b */
    private static C5443b f22233b = null;

    /* renamed from: a */
    public static C5443b m18700a(C5456e platformBitmapFactory, C5497e executorSupplier) {
        if (!f22232a) {
            try {
                f22233b = (C5443b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(new Class[]{C5456e.class, C5497e.class}).newInstance(new Object[]{platformBitmapFactory, executorSupplier});
            } catch (Throwable th) {
            }
            if (f22233b != null) {
                f22232a = true;
                return f22233b;
            }
            try {
                f22233b = (C5443b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(new Class[]{C5456e.class, C5497e.class}).newInstance(new Object[]{platformBitmapFactory, executorSupplier});
            } catch (Throwable th2) {
            }
            f22232a = true;
        }
        return f22233b;
    }
}
