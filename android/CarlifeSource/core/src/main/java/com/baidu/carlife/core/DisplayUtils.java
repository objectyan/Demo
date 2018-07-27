package com.baidu.carlife.core;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import com.baidu.carlife.core.screen.presentation.DisplaySpec;

/* compiled from: DisplayUtils */
/* renamed from: com.baidu.carlife.core.m */
public class DisplayUtils {
    /* renamed from: a */
    private static final String f3629a = "DisplayUtils";
    /* renamed from: b */
    private static DisplayUtils f3630b = new DisplayUtils();

    /* renamed from: a */
    public static DisplayUtils m4466a() {
        return f3630b;
    }

    private DisplayUtils() {
    }

    /* renamed from: b */
    private VirtualDisplay m4467b(DisplaySpec spec, String displayName) {
        if (spec.getFlag() == 0) {
            spec.setFlag(9);
        }
        return ((DisplayManager) AppContext.getAppContext().getSystemService("display")).createVirtualDisplay(displayName, spec.getWidth(), spec.getHeight(), spec.getDensityDpi(), spec.getSurface(), spec.getFlag());
    }

    /* renamed from: a */
    public VirtualDisplay m4468a(DisplaySpec spec, String displayName) {
        return m4467b(spec, displayName);
    }
}
