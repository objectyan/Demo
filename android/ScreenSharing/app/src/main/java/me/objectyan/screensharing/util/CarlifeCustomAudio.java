package me.objectyan.screensharing.util;

import android.content.Context;

import me.objectyan.screensharing.core.AppContext;
import me.objectyan.screensharing.core.audio.AudioUtil;
import me.objectyan.screensharing.core.audio.CustomAudioDecoder;


public class CarlifeCustomAudio {

    private static final String f5156a = (AudioUtil.AUDIO + me.objectyan.screensharing.util.CarlifeCustomAudio.class.getSimpleName());

    private static me.objectyan.screensharing.util.CarlifeCustomAudio f5157b;

    private CustomAudioDecoder f5158c = new CustomAudioDecoder();

    private Context f5159d = AppContext.getAppContext().getApplicationContext();

    private CarlifeCustomAudio() {
    }


    public static me.objectyan.screensharing.util.CarlifeCustomAudio m6122a() {
        if (f5157b == null) {
            f5157b = new me.objectyan.screensharing.util.CarlifeCustomAudio();
        }
        return f5157b;
    }


    public boolean m6124a(String filePath) {
        return this.f5158c.init(filePath);
    }


    public byte[] m6125b() {
        return this.f5158c.getDecoderOut();
    }


    public void m6126c() {
        this.f5158c.initAudioTrack();
    }


    public void m6123a(byte[] pData) {
        this.f5158c.writeAudioData(pData);
    }
}
