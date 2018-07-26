package com.baidu.location.indoor.mapversion;

import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;

public class IndoorJni {
    /* renamed from: a */
    public static boolean f18699a;

    static {
        f18699a = false;
        try {
            System.loadLibrary(OVERLAY_KEY.INDOOR);
            initPf();
            f18699a = true;
        } catch (Exception e) {
            System.err.println("Cannot load indoor lib");
            e.printStackTrace();
        }
    }

    public static native double[] getPfFr(double d, double d2);

    public static native void initPf();

    public static native void resetPf();

    public static native double[] setPfWf(double d, double d2);

    public static native void setRdnt(String str, short[][] sArr, double d, double d2, int i, int i2);
}
