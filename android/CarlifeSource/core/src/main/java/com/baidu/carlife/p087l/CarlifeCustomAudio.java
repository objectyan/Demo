package com.baidu.carlife.p087l;

import android.content.Context;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.audio.AudioUtil;
import com.baidu.carlife.core.audio.CustomAudioDecoder;

/* compiled from: CarlifeCustomAudio */
/* renamed from: com.baidu.carlife.l.e */
public class CarlifeCustomAudio {
    /* renamed from: a */
    private static final String f5156a = (AudioUtil.AUDIO + com.baidu.carlife.p087l.CarlifeCustomAudio.class.getSimpleName());
    /* renamed from: b */
    private static com.baidu.carlife.p087l.CarlifeCustomAudio f5157b;
    /* renamed from: c */
    private CustomAudioDecoder f5158c = new CustomAudioDecoder();
    /* renamed from: d */
    private Context f5159d = AppContext.getAppContext().getApplicationContext();

    private CarlifeCustomAudio() {
    }

    /* renamed from: a */
    public static com.baidu.carlife.p087l.CarlifeCustomAudio m6122a() {
        if (f5157b == null) {
            f5157b = new com.baidu.carlife.p087l.CarlifeCustomAudio();
        }
        return f5157b;
    }

    /* renamed from: a */
    public boolean m6124a(String filePath) {
        return this.f5158c.init(filePath);
    }

    /* renamed from: b */
    public byte[] m6125b() {
        return this.f5158c.getDecoderOut();
    }

    /* renamed from: c */
    public void m6126c() {
        this.f5158c.initAudioTrack();
    }

    /* renamed from: a */
    public void m6123a(byte[] pData) {
        this.f5158c.writeAudioData(pData);
    }
}
