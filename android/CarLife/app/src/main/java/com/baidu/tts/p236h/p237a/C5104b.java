package com.baidu.tts.p236h.p237a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p233f.C5097n;

/* compiled from: TtsErrorFlyweight */
/* renamed from: com.baidu.tts.h.a.b */
public class C5104b extends C5103a {
    public C5104b(C5097n c5097n) {
        super(c5097n);
    }

    /* renamed from: a */
    public int m17293a(TtsError ttsError) {
        return this.a.m17284b();
    }

    /* renamed from: b */
    public String m17294b(TtsError ttsError) {
        int code = ttsError.getCode();
        String message = ttsError.getMessage();
        Throwable throwable = ttsError.getThrowable();
        int b = this.a.m17284b();
        String str = "(" + b + ")" + this.a.m17285c();
        if (message != null) {
            str = str + "[(" + code + ")" + message + "]";
        } else if (code != 0) {
            str = str + "[(" + code + ")]";
        }
        if (throwable == null) {
            return str;
        }
        return str + "[(cause)" + throwable.toString() + "]";
    }
}
