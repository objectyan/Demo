package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.C1251e;

/* compiled from: AudioUtil */
/* renamed from: com.baidu.carlife.core.audio.a */
public class C1163a {
    /* renamed from: a */
    public static final int f2997a = 120;
    /* renamed from: b */
    public static final int f2998b = 10240;
    /* renamed from: c */
    public static final int f2999c = 120;
    /* renamed from: d */
    public static final int f3000d = 10240;
    /* renamed from: e */
    public static final int f3001e = 2;
    /* renamed from: f */
    public static final int f3002f = 102400;
    /* renamed from: g */
    public static final int f3003g = 12;
    /* renamed from: h */
    public static final int f3004h = 12;
    /* renamed from: i */
    public static final int f3005i = 20480;
    /* renamed from: j */
    public static final int f3006j = 2;
    /* renamed from: k */
    public static final int f3007k = 2;
    /* renamed from: l */
    public static final float f3008l = 0.001f;
    /* renamed from: m */
    public static final int f3009m = 100;
    /* renamed from: n */
    public static final String f3010n = "Audio-";
    /* renamed from: o */
    private static C1163a f3011o = null;
    /* renamed from: p */
    private static final int f3012p = 0;
    /* renamed from: q */
    private static final int f3013q = 0;
    /* renamed from: r */
    private static final int f3014r = 1;
    /* renamed from: s */
    private int f3015s = 0;
    /* renamed from: t */
    private int f3016t = 0;

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$a */
    private enum C1158a {
        INDEPENDENT_CHANNEL_MODE(0),
        BLUE_TOOTH_MODE(1);
        
        /* renamed from: c */
        private int f2976c;

        private C1158a(int mode) {
            this.f2976c = mode;
        }

        /* renamed from: a */
        public int m3881a() {
            return this.f2976c;
        }
    }

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$b */
    public enum C1159b {
        TTS_START,
        TTS_END,
        PHONE_START,
        PHONE_END
    }

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$c */
    public enum C1160c {
        MP3_MOUDLE,
        PCM_MODULE,
        INVALID_MODULE
    }

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$d */
    public enum C1161d {
        INIT,
        STOP,
        PAUSE,
        RESUME,
        SEEK,
        NORMAL
    }

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$e */
    public enum C1162e {
        MP3_MUSIC,
        LEBO,
        NULL
    }

    private C1163a() {
    }

    /* renamed from: a */
    public static C1163a m3882a() {
        if (f3011o == null) {
            f3011o = new C1163a();
        }
        return f3011o;
    }

    /* renamed from: a */
    public void m3887a(short[] shortArray, byte[] byteArray) {
        for (int i = 0; i < shortArray.length; i++) {
            short dataL = (short) (shortArray[i] & 255);
            byteArray[i * 2] = (byte) ((((short) (shortArray[i] & 65280)) >> 8) & 255);
            byteArray[(i * 2) + 1] = (byte) (dataL & 255);
        }
    }

    /* renamed from: a */
    public void m3886a(short[] shortArray, int shortArraySize, byte[] byteArray) {
        for (int i = 0; i < shortArraySize; i++) {
            short dataH = (short) (shortArray[i] & 65280);
            byteArray[i * 2] = (byte) (((short) (shortArray[i] & 255)) & 255);
            byteArray[(i * 2) + 1] = (byte) ((dataH >> 8) & 255);
        }
    }

    /* renamed from: a */
    public void m3888a(short[] shortArray, byte[] byteArray, int byteArraySize) {
        for (int i = 0; i < byteArraySize / 2; i++) {
            short dataL = (short) (byteArray[(i * 2) + 1] & 255);
            shortArray[i] = (short) ((((short) (byteArray[i * 2] & 255)) << 8) | dataL);
        }
    }

    /* renamed from: a */
    public void m3885a(byte[] byteArray, int byteArraySize, int byteArrayOffset, short[] shortArray) {
        for (int i = 0; i < byteArraySize / 2; i++) {
            shortArray[i] = (short) ((((short) (byteArray[((i * 2) + byteArrayOffset) + 1] & 255)) << 8) | ((short) (byteArray[(i * 2) + byteArrayOffset] & 255)));
        }
    }

    /* renamed from: b */
    public void m3889b() {
        this.f3016t = 0;
    }

    /* renamed from: a */
    public void m3884a(int sr) {
        this.f3016t = sr;
    }

    /* renamed from: c */
    public int m3891c() {
        return this.f3016t;
    }

    /* renamed from: d */
    public boolean m3892d() {
        if (m3891c() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public void m3893e() {
        this.f3015s = 0;
    }

    /* renamed from: b */
    public void m3890b(int mode) {
        this.f3015s = mode;
    }

    /* renamed from: f */
    public int m3894f() {
        return this.f3015s;
    }

    /* renamed from: g */
    public boolean m3895g() {
        if (m3894f() == C1158a.BLUE_TOOTH_MODE.m3881a()) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m3883h() {
        C1251e.m4358a();
        return C1251e.m4386y();
    }
}
