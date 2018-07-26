package com.baidu.carlife.core.screen.presentation;

import android.view.Display;
import android.view.Window;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;

/* compiled from: CarlifePresentation */
/* renamed from: com.baidu.carlife.core.screen.presentation.e */
public class C1324e extends C1291b {
    public C1324e(AbsCarlifeActivityService outerContext, Display display) {
        super(outerContext, display);
    }

    public void show() {
        super.show();
        if (C1309g.m4699a().m4701b() != null) {
            C1309g.m4699a().m4701b().mo1484h();
        }
    }

    /* renamed from: a */
    public C1289c mo1452a(Window window) {
        return new C1327g(window);
    }
}
