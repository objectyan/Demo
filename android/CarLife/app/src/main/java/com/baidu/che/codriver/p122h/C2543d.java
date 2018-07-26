package com.baidu.che.codriver.p122h;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.baidunavis.tts.IBNTTSVoiceHintListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2725h;
import java.util.Random;

/* compiled from: TTSPlayerManager */
/* renamed from: com.baidu.che.codriver.h.d */
public class C2543d {
    /* renamed from: a */
    public static C2543d f8393a = null;
    /* renamed from: c */
    private static final String f8394c = C2543d.class.getSimpleName();
    /* renamed from: g */
    private static final int f8395g = 3;
    /* renamed from: b */
    protected IBNTTSVoiceHintListener f8396b = new C25412(this);
    /* renamed from: d */
    private Context f8397d;
    /* renamed from: e */
    private C2538b f8398e;
    /* renamed from: f */
    private String[] f8399f;
    /* renamed from: h */
    private int f8400h = 0;

    /* compiled from: TTSPlayerManager */
    /* renamed from: com.baidu.che.codriver.h.d$2 */
    class C25412 implements IBNTTSVoiceHintListener {
        /* renamed from: a */
        final /* synthetic */ C2543d f8387a;

        C25412(C2543d this$0) {
            this.f8387a = this$0;
        }

        @Deprecated
        public void notifyTTSStart() {
            C2725h.m10207b(C2543d.f8394c, "---TTS--onSpeechStart-----");
            if (this.f8387a.f8398e != null) {
                this.f8387a.f8398e.onSpeechStart(null);
            }
        }

        public void notifyTTSEnd() {
            C2725h.m10207b(C2543d.f8394c, "---TTS--onSpeechEnd-----");
            if (this.f8387a.f8398e != null) {
                this.f8387a.f8398e.onSpeechFinish(null);
            }
        }
    }

    /* compiled from: TTSPlayerManager */
    /* renamed from: com.baidu.che.codriver.h.d$a */
    public enum C2542a {
        NORMAL_FEMALE,
        EMOTION_FEMALE,
        NORMAL_MALE,
        EMOTION_MALE
    }

    private C2543d() {
        C1915a.m7321a().m7325a(this.f8396b);
    }

    /* renamed from: a */
    public static C2543d m9631a() {
        if (f8393a == null) {
            synchronized (C2543d.class) {
                if (f8393a == null) {
                    f8393a = new C2543d();
                }
            }
        }
        return f8393a;
    }

    /* renamed from: a */
    public void m9635a(Context context) {
        this.f8397d = context;
        this.f8399f = this.f8397d.getResources().getStringArray(C0965R.array.tts_record_start_hint_array);
    }

    /* renamed from: b */
    public void m9638b() {
    }

    /* renamed from: a */
    public void m9636a(C2542a type) {
    }

    /* renamed from: a */
    public void m9637a(C2549b model, C2538b speechListener) {
        m9634a(model.f8465g, speechListener);
    }

    /* renamed from: a */
    public int m9634a(final String text, C2538b listener) {
        boolean isOk = true;
        this.f8398e = listener;
        if (TextUtils.isEmpty(text)) {
            if (this.f8398e != null) {
                this.f8398e.onSpeechFinish(text);
            }
            return -1;
        }
        int result = C1915a.m7321a().m7328b(text, 1);
        if (result != 0) {
            isOk = false;
        }
        if (!isOk) {
            int i = this.f8400h;
            this.f8400h = i + 1;
            if (i < 3) {
                new Handler().postDelayed(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2543d f8386b;

                    public void run() {
                        this.f8386b.m9633a(text);
                    }
                }, 1000);
                return result;
            }
        }
        this.f8400h = 0;
        return result;
    }

    /* renamed from: a */
    public int m9633a(String text) {
        return m9634a(text, null);
    }

    /* renamed from: c */
    public void m9639c() {
        C1915a.m7321a().m7334d();
    }

    /* renamed from: d */
    public void m9640d() {
        m9633a(this.f8397d.getString(C0965R.string.tts_record_end_hint_1));
    }

    /* renamed from: e */
    public void m9641e() {
        if (this.f8399f != null) {
            int radomIndex = new Random().nextInt(this.f8399f.length);
            C2549b modelHello = new C2549b();
            modelHello.f8465g = this.f8399f[radomIndex];
            modelHello.f8468j = 1;
            C2674b.m9985b().m10019b(modelHello);
        }
    }
}
