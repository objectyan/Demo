package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.CarlifeUtil;

/* compiled from: AudioUtil */
/* renamed from: com.baidu.carlife.core.audio.a */
public class AudioUtil {
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
    public static final int M_CHUNK_LENGTH = 20480;
    /* renamed from: j */
    public static final int f3006j = 2;
    /* renamed from: k */
    public static final int f3007k = 2;
    /* renamed from: l */
    public static final float f3008l = 0.001f;
    /* renamed from: m */
    public static final int f3009m = 100;
    /* renamed from: n */
    public static final String AUDIO = "Audio-";
    /* renamed from: o */
    private static AudioUtil sAudioUtil = null;
    /* renamed from: p */
    private static final int f3012p = 0;
    /* renamed from: q */
    private static final int f3013q = 0;
    /* renamed from: r */
    private static final int f3014r = 1;
    /* renamed from: s */
    private int mMode = 0;
    /* renamed from: t */
    private int mSR = 0;

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$a */
    private enum EnumAudioMode {
        INDEPENDENT_CHANNEL_MODE(0),
        BLUE_TOOTH_MODE(1);

        /* renamed from: c */
        private int mMode;

        private EnumAudioMode(int mode) {
            this.mMode = mode;
        }

        /* renamed from: a */
        public int getMode() {
            return this.mMode;
        }
    }

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$b */
    public enum EnumAudioStatus {
        TTS_START,
        TTS_END,
        PHONE_START,
        PHONE_END
    }

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$c */
    public enum EnumAudioModule {
        MP3_MOUDLE,
        PCM_MODULE,
        INVALID_MODULE
    }

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$d */
    public enum EnumAudioState {
        INIT,
        STOP,
        PAUSE,
        RESUME,
        SEEK,
        NORMAL
    }

    /* compiled from: AudioUtil */
    /* renamed from: com.baidu.carlife.core.audio.a$e */
    public enum EnumAudioType {
        MP3_MUSIC,
        LEBO,
        NULL
    }

    private AudioUtil() {
    }

    /* renamed from: a */
    public static AudioUtil newInstance() {
        if (sAudioUtil == null) {
            sAudioUtil = new AudioUtil();
        }
        return sAudioUtil;
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
    public void initSR() {
        this.mSR = 0;
    }

    /* renamed from: a */
    public void setSR(int sr) {
        this.mSR = sr;
    }

    /* renamed from: c */
    public int getSR() {
        return this.mSR;
    }

    /* renamed from: d */
    public boolean isSR() {
        if (getSR() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public void setMode() {
        this.mMode = 0;
    }

    /* renamed from: b */
    public void setMode(int mode) {
        this.mMode = mode;
    }

    /* renamed from: f */
    public int getMode() {
        return this.mMode;
    }

    /* renamed from: g */
    public boolean isBlueToothMode() {
        if (getMode() == EnumAudioMode.BLUE_TOOTH_MODE.getMode()) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public static boolean getIs() {
        CarlifeUtil.newInstance();
        return CarlifeUtil.getIs();
    }
}
