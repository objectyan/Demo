package me.objectyan.screensharing.core.audio;

import me.objectyan.screensharing.core.CarlifeUtil;


public class AudioUtil {

    public static final int f2997a = 120;

    public static final int f2998b = 10240;

    public static final int f2999c = 120;

    public static final int f3000d = 10240;

    public static final int f3001e = 2;

    public static final int f3002f = 102400;

    public static final int f3003g = 12;

    public static final int f3004h = 12;

    public static final int M_CHUNK_LENGTH = 20480;

    public static final int f3006j = 2;

    public static final int f3007k = 2;

    public static final float f3008l = 0.001f;

    public static final int f3009m = 100;

    public static final String AUDIO = "Audio-";

    private static AudioUtil sAudioUtil = null;

    private static final int f3012p = 0;

    private static final int f3013q = 0;

    private static final int f3014r = 1;

    private int mMode = 0;

    private int mSR = 0;


    private enum EnumAudioMode {
        INDEPENDENT_CHANNEL_MODE(0),
        BLUE_TOOTH_MODE(1);


        private int mMode;

        private EnumAudioMode(int mode) {
            this.mMode = mode;
        }


        public int getMode() {
            return this.mMode;
        }
    }


    public enum EnumAudioStatus {
        TTS_START,
        TTS_END,
        PHONE_START,
        PHONE_END
    }


    public enum EnumAudioModule {
        MP3_MOUDLE,
        PCM_MODULE,
        INVALID_MODULE
    }


    public enum EnumAudioState {
        INIT,
        STOP,
        PAUSE,
        RESUME,
        SEEK,
        NORMAL
    }


    public enum EnumAudioType {
        MP3_MUSIC,
        LEBO,
        NULL
    }

    private AudioUtil() {
    }


    public static AudioUtil newInstance() {
        if (sAudioUtil == null) {
            sAudioUtil = new AudioUtil();
        }
        return sAudioUtil;
    }


    public void m3887a(short[] shortArray, byte[] byteArray) {
        for (int i = 0; i < shortArray.length; i++) {
            short dataL = (short) (shortArray[i] & 255);
            byteArray[i * 2] = (byte) ((((short) (shortArray[i] & 65280)) >> 8) & 255);
            byteArray[(i * 2) + 1] = (byte) (dataL & 255);
        }
    }


    public void m3886a(short[] shortArray, int shortArraySize, byte[] byteArray) {
        for (int i = 0; i < shortArraySize; i++) {
            short dataH = (short) (shortArray[i] & 65280);
            byteArray[i * 2] = (byte) (((short) (shortArray[i] & 255)) & 255);
            byteArray[(i * 2) + 1] = (byte) ((dataH >> 8) & 255);
        }
    }


    public void m3888a(short[] shortArray, byte[] byteArray, int byteArraySize) {
        for (int i = 0; i < byteArraySize / 2; i++) {
            short dataL = (short) (byteArray[(i * 2) + 1] & 255);
            shortArray[i] = (short) ((((short) (byteArray[i * 2] & 255)) << 8) | dataL);
        }
    }


    public void m3885a(byte[] byteArray, int byteArraySize, int byteArrayOffset, short[] shortArray) {
        for (int i = 0; i < byteArraySize / 2; i++) {
            shortArray[i] = (short) ((((short) (byteArray[((i * 2) + byteArrayOffset) + 1] & 255)) << 8) | ((short) (byteArray[(i * 2) + byteArrayOffset] & 255)));
        }
    }


    public void initSR() {
        this.mSR = 0;
    }


    public void setSR(int sr) {
        this.mSR = sr;
    }


    public int getSR() {
        return this.mSR;
    }


    public boolean isSR() {
        if (getSR() == 1) {
            return true;
        }
        return false;
    }


    public void setMode() {
        this.mMode = 0;
    }


    public void setMode(int mode) {
        this.mMode = mode;
    }


    public int getMode() {
        return this.mMode;
    }


    public boolean isBlueToothMode() {
        if (getMode() == EnumAudioMode.BLUE_TOOTH_MODE.getMode()) {
            return true;
        }
        return false;
    }


    public static boolean getIs() {
        CarlifeUtil.newInstance();
        return CarlifeUtil.getIs();
    }
}
