package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.p122h.C2538b;
import com.baidu.che.codriver.p122h.C2543d;
import com.baidu.che.codriver.p122h.C2543d.C2542a;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.tts.client.SpeechError;

/* compiled from: TTSPlayerHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.j */
public class C2639j implements C2603a {

    /* compiled from: TTSPlayerHandler */
    /* renamed from: com.baidu.che.codriver.sdk.handler.j$1 */
    class C26381 extends C2538b {
        /* renamed from: a */
        final /* synthetic */ C2639j f8686a;

        C26381(C2639j this$0) {
            this.f8686a = this$0;
        }

        public void onSynthesizeDataArrived(String s, byte[] bytes, int i) {
        }

        public void onSynthesizeFinish(String s) {
        }

        public void onSpeechStart(String s) {
            this.f8686a.m9903a("onSpeechStart", s);
        }

        public void onSpeechProgressChanged(String s, int i) {
        }

        public void onSpeechFinish(String s) {
            this.f8686a.m9903a("onSpeechFinish", s);
        }

        public void onError(String s, SpeechError speechError) {
            this.f8686a.m9903a("onError", s);
        }

        public void onSynthesizeStart(String s) {
        }
    }

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        C2725h.m10214e(C2639j.class.getName(), "onReceiveCommand-cmdType:" + cmdType + ";param:" + param + ";data:" + data);
        if (C2848p.af.equals(param)) {
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("stop".equals(param)) {
            C2543d.m9631a().m9639c();
        } else if ("switch".equals(param)) {
            int i = -1;
            switch (data.hashCode()) {
                case -1823637272:
                    if (data.equals("emotionmale")) {
                        i = 1;
                        break;
                    }
                    break;
                case -365442201:
                    if (data.equals("emotionfemale")) {
                        i = 0;
                        break;
                    }
                    break;
                case -239311228:
                    if (data.equals("nomalmale")) {
                        i = 3;
                        break;
                    }
                    break;
                case 1753463299:
                    if (data.equals("nomalfemale")) {
                        i = 2;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    C2543d.m9631a().m9636a(C2542a.EMOTION_FEMALE);
                    break;
                case 1:
                    C2543d.m9631a().m9636a(C2542a.EMOTION_MALE);
                    break;
                case 2:
                    C2543d.m9631a().m9636a(C2542a.NORMAL_FEMALE);
                    break;
                case 3:
                    C2543d.m9631a().m9636a(C2542a.NORMAL_MALE);
                    break;
                default:
                    break;
            }
        } else if ("play".equals(param)) {
            C2543d.m9631a().m9634a(data, new C26381(this));
        } else if ("play_and_show".equals(param)) {
            C2549b model = new C2549b();
            model.f8465g = data;
            model.f8468j = 2;
            C2674b.m9985b().m10019b(model);
        } else if ("set_stream_type".equals(param)) {
        }
        return null;
    }

    /* renamed from: a */
    private void m9903a(String param, String data) {
        C2606l.m9828a().m9829a(C2606l.f8618d, param, data);
    }
}
