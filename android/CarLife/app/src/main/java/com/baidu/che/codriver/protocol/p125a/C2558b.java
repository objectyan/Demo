package com.baidu.che.codriver.protocol.p125a;

import com.baidu.che.codriver.protocol.C2556b;
import com.baidu.che.codriver.protocol.C2560a;
import com.baidu.che.codriver.protocol.C2566d;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;

/* compiled from: NLPTask */
/* renamed from: com.baidu.che.codriver.protocol.a.b */
public class C2558b extends C2556b<NLPResponseData> {
    /* renamed from: a */
    private String f8477a;

    public C2558b(C2566d<NLPResponseData> listener, Class<NLPResponseData> clazz, String query) {
        super(listener, clazz);
        this.f8477a = query;
    }

    public C2558b(C2566d<NLPResponseData> listener, Class<NLPResponseData> clazz, String query, boolean route) {
        super(listener, clazz);
        this.f8477a = query;
    }

    /* renamed from: b */
    protected String mo1882b() {
        return C2560a.m9678a(this.f8477a);
    }
}
