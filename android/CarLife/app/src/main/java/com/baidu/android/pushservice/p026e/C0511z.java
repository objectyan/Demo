package com.baidu.android.pushservice.p026e;

import android.content.Context;
import com.baidu.speech.asr.SpeechConstant;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.z */
public class C0511z extends C0488d {
    public C0511z(C0496l c0496l, Context context) {
        super(c0496l, context);
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        C0486b.m2078a((HashMap) hashMap);
        hashMap.put("method", "unbindapp");
        hashMap.put(SpeechConstant.APP_ID, this.b.f1608f);
    }
}
