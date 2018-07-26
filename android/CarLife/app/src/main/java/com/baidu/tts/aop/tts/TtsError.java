package com.baidu.tts.aop.tts;

import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5104b;

public class TtsError {
    /* renamed from: a */
    private Throwable f20653a;
    /* renamed from: b */
    private int f20654b;
    /* renamed from: c */
    private String f20655c;
    /* renamed from: d */
    private C5104b f20656d;

    public C5104b getTtsErrorFlyweight() {
        return this.f20656d;
    }

    public void setTtsErrorFlyweight(C5104b ttsErrorFlyweight) {
        this.f20656d = ttsErrorFlyweight;
    }

    public C5097n getErrorEnum() {
        return this.f20656d == null ? null : this.f20656d.m17292a();
    }

    public Throwable getThrowable() {
        return this.f20653a;
    }

    public void setThrowable(Throwable throwable) {
        this.f20653a = throwable;
    }

    public int getCode() {
        return this.f20654b;
    }

    public void setCode(int code) {
        this.f20654b = code;
    }

    public String getMessage() {
        return this.f20655c;
    }

    public void setMessage(String message) {
        this.f20655c = message;
    }

    public int getDetailCode() {
        return this.f20656d != null ? this.f20656d.m17293a(this) : this.f20654b;
    }

    public String getDetailMessage() {
        if (this.f20656d != null) {
            return this.f20656d.m17294b(this);
        }
        return this.f20655c != null ? this.f20655c : "TtsErrorFlyweight is null";
    }
}
