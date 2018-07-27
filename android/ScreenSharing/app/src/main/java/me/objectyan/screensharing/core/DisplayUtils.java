package me.objectyan.screensharing.core;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;

import me.objectyan.screensharing.core.screen.presentation.DisplaySpec;


public class DisplayUtils {

    private static final String f3629a = "DisplayUtils";

    private static DisplayUtils f3630b = new DisplayUtils();


    public static DisplayUtils m4466a() {
        return f3630b;
    }

    private DisplayUtils() {
    }


    private VirtualDisplay m4467b(DisplaySpec spec, String displayName) {
        if (spec.getFlag() == 0) {
            spec.setFlag(9);
        }
        return ((DisplayManager) AppContext.getAppContext().getSystemService("display")).createVirtualDisplay(displayName, spec.getWidth(), spec.getHeight(), spec.getDensityDpi(), spec.getSurface(), spec.getFlag());
    }


    public VirtualDisplay m4468a(DisplaySpec spec, String displayName) {
        return m4467b(spec, displayName);
    }
}
