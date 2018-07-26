package com.baidu.tts.p225m;

import com.baidu.tts.p218b.p219a.p223b.C5008e.C5006b;
import com.baidu.tts.p218b.p219a.p223b.C5013f.C5010b;
import com.baidu.tts.p218b.p220b.p227b.C5030b.C5029a;
import com.baidu.tts.p224n.C5004a;
import com.baidu.tts.p233f.C5081b;
import com.baidu.tts.p233f.C5085c;
import com.baidu.tts.p233f.C5086d;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5092j;

/* compiled from: TtsParams */
/* renamed from: com.baidu.tts.m.j */
public class C5148j extends C5004a<C5148j> {
    /* renamed from: a */
    private C5141b f21273a = new C5141b();
    /* renamed from: b */
    private C5140a f21274b = new C5140a();

    /* renamed from: a */
    public C5141b m17449a() {
        return this.f21273a;
    }

    /* renamed from: b */
    public C5140a m17450b() {
        return this.f21274b;
    }

    /* renamed from: c */
    public C5010b m17451c() {
        return this.f21273a.m17396a();
    }

    /* renamed from: d */
    public C5006b m17452d() {
        return this.f21273a.m17399b();
    }

    /* renamed from: e */
    public C5029a m17453e() {
        return this.f21274b.m17394a();
    }

    /* renamed from: a */
    public int m17448a(C5089g c5089g, String str) {
        return m17447b(c5089g, str);
    }

    /* renamed from: b */
    private int m17447b(C5089g c5089g, String str) {
        C5006b b = this.f21273a.m17399b();
        C5010b a = this.f21273a.m17396a();
        C5029a a2 = this.f21274b.m17394a();
        switch (c5089g) {
            case SPEED:
                this.f21273a.m17398a(str);
                break;
            case VOLUME:
                this.f21273a.m17400b(str);
                break;
            case PITCH:
                this.f21273a.m17402c(str);
                break;
            case TEXT_DAT_PATH:
                b.m16795d(str);
                break;
            case SPEECH_DAT_PATH:
                b.m16797e(str);
                break;
            case TTS_LICENSE_FILE_PATH:
                b.m16799f(str);
                break;
            case APP_CODE:
                b.m16801g(str);
                break;
            case TEXT_ENCODE:
                a.m16772a(C5086d.m17268a(str));
                break;
            case NOTIFICATION_COUNT_PER_SECOND:
                a2.m16965a(str);
                break;
            case PRODUCT_ID:
                a.m16826c(str);
                break;
            case AUDIO_ENCODE:
                return a.m16816a(C5081b.m17256a(str));
            case BITRATE:
                a.m16819a(C5085c.m17262a(str));
                break;
            case BACKGROUND:
                a.m16832f(str);
                break;
            case CUSTOM_SYNTH:
                return b.m16792c(str);
            case LANGUAGE:
                a.m16773i(str);
                b.m16773i(str);
                break;
            case OPEN_XML:
                return this.f21273a.m17403d(str);
            case PUNCTUATION:
                a.m16836h(str);
                break;
            case SPEAKER:
                a.m16828d(str);
                break;
            case STYLE:
                a.m16830e(str);
                break;
            case TERRITORY:
                a.m16834g(str);
                break;
            case TTS_VOCODER_OPTIMIZATION:
                return b.m16788a(str);
            case API_KEY:
                a.m16820a(str);
                break;
            case SECRET_KEY:
                a.m16823b(str);
                break;
            case STREAM_TYPE:
                this.f21274b.m17395a(Integer.parseInt(str));
                break;
            case MIX_MODE:
                C5092j valueOf;
                try {
                    valueOf = C5092j.valueOf(str);
                } catch (Exception e) {
                    valueOf = C5092j.DEFAULT;
                }
                this.f21273a.m17397a(valueOf);
                break;
            case SAMPLE_RATE:
                b.m16791b(str);
                break;
        }
        return 0;
    }
}
