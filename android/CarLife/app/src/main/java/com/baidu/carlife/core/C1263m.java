package com.baidu.carlife.core;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import com.baidu.carlife.core.screen.presentation.C1329i;

/* compiled from: DisplayUtils */
/* renamed from: com.baidu.carlife.core.m */
public class C1263m {
    /* renamed from: a */
    private static final String f3629a = "DisplayUtils";
    /* renamed from: b */
    private static C1263m f3630b = new C1263m();

    /* renamed from: a */
    public static C1263m m4466a() {
        return f3630b;
    }

    private C1263m() {
    }

    /* renamed from: b */
    private VirtualDisplay m4467b(C1329i spec, String displayName) {
        if (spec.m4789e() == 0) {
            spec.m4788d(9);
        }
        return ((DisplayManager) C1157a.m3876a().getSystemService("display")).createVirtualDisplay(displayName, spec.m4780a(), spec.m4783b(), spec.m4785c(), spec.m4787d(), spec.m4789e());
    }

    /* renamed from: a */
    public VirtualDisplay m4468a(C1329i spec, String displayName) {
        return m4467b(spec, displayName);
    }
}
