package com.baidu.che.codriver.vr.record.aec;

import com.baidu.che.codriver.util.C2725h;
import com.baidu.speech.easr.easrNativeJni;

/* compiled from: AecUtils */
/* renamed from: com.baidu.che.codriver.vr.record.aec.a */
public class C2858a {
    /* renamed from: a */
    public static final int f9357a = 2560;
    /* renamed from: b */
    private static final String f9358b = "AecUtils";
    /* renamed from: c */
    private static short[] f9359c;
    /* renamed from: d */
    private static short[] f9360d;
    /* renamed from: e */
    private static short[] f9361e;

    /* renamed from: a */
    public static void m10812a() {
        if (easrNativeJni.AECInit() != 0) {
            throw new UnsupportedOperationException("AEC init failed!");
        }
        f9359c = new short[1280];
        f9360d = new short[1280];
        f9361e = new short[1280];
    }

    /* renamed from: b */
    public static void m10817b() {
        easrNativeJni.AECExit();
    }

    /* renamed from: c */
    public static int m10818c() {
        return easrNativeJni.AECGetVolume();
    }

    /* renamed from: a */
    public static void m10813a(byte[] rawMicData, byte[] rawSpkData, byte[] resultBuffer) {
        if (!C2858a.m10815a(rawMicData, f9360d)) {
            C2725h.m10214e(f9358b, "MicData.length != AEC_ENGINE_REQUIRE_SIZE");
        } else if (C2858a.m10815a(rawSpkData, f9359c)) {
            if (easrNativeJni.AECProcess(f9360d, f9359c, f9361e, f9361e.length) < 0) {
                C2725h.m10214e(f9358b, "---AEC error!!!--");
            }
            C2858a.m10814a(f9361e, resultBuffer);
        } else {
            C2725h.m10214e(f9358b, "SpkData.length != AEC_ENGINE_REQUIRE_SIZE");
        }
    }

    /* renamed from: a */
    private static void m10814a(short[] shortArray, byte[] byteArray) {
        if (byteArray.length < shortArray.length * 2) {
            C2725h.m10214e(f9358b, "---shortArrayToByteArraySmallEnd error!!!--");
            return;
        }
        int shortArraySize = shortArray.length;
        for (int i = 0; i < shortArraySize; i++) {
            short dataH = (short) (shortArray[i] & 65280);
            byteArray[i * 2] = (byte) (((short) (shortArray[i] & 255)) & 255);
            byteArray[(i * 2) + 1] = (byte) ((dataH >> 8) & 255);
        }
    }

    /* renamed from: a */
    private static byte[] m10816a(short[] shortArray) {
        int shortArraySize = shortArray.length;
        byte[] byteArray = new byte[(shortArraySize * 2)];
        for (int i = 0; i < shortArraySize; i++) {
            short dataH = (short) (shortArray[i] & 65280);
            byteArray[i * 2] = (byte) (((short) (shortArray[i] & 255)) & 255);
            byteArray[(i * 2) + 1] = (byte) ((dataH >> 8) & 255);
        }
        return byteArray;
    }

    /* renamed from: a */
    private static boolean m10815a(byte[] byteArray, short[] shortArray) {
        int shortArraySize = byteArray.length / 2;
        if (shortArray.length != shortArraySize) {
            return false;
        }
        for (int i = 0; i < shortArraySize; i++) {
            shortArray[i] = (short) ((((short) (byteArray[(i * 2) + 1] & 255)) << 8) | ((short) (byteArray[i * 2] & 255)));
        }
        return true;
    }
}
