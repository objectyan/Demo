package com.baidu.android.pushservice.p026e;

import android.content.Context;
import com.baidu.speech.asr.SpeechConstant;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.v */
public class C0506v extends C0489e {
    /* renamed from: d */
    protected String f1626d = null;
    /* renamed from: e */
    protected String f1627e = null;
    /* renamed from: f */
    protected String f1628f = null;
    /* renamed from: g */
    protected String f1629g = null;

    public C0506v(C0496l c0496l, Context context, String str, String str2, String str3, String str4) {
        super(c0496l, context);
        this.f1626d = str;
        this.f1627e = str2;
        this.f1628f = str3;
        this.f1629g = str4;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "sendmsgtouser");
        hashMap.put(SpeechConstant.APP_ID, this.f1626d);
        hashMap.put("user_id", this.f1627e);
        if (this.f1629g != null && this.f1628f != null) {
            StringBuilder stringBuilder = new StringBuilder("[\"");
            stringBuilder.append(this.f1628f).append("\"]");
            StringBuilder stringBuilder2 = new StringBuilder("[\"");
            stringBuilder2.append(this.f1629g).append("\"]");
            hashMap.put("msg_keys", stringBuilder.toString());
            hashMap.put("messages", stringBuilder2.toString());
        }
    }
}
