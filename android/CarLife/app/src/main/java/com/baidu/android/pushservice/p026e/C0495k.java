package com.baidu.android.pushservice.p026e;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONArray;

/* renamed from: com.baidu.android.pushservice.e.k */
public class C0495k extends C0487c {
    /* renamed from: d */
    private String[] f1602d;

    public C0495k(C0496l c0496l, Context context, String[] strArr) {
        super(c0496l, context);
        this.f1602d = strArr;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        if (r1 == 0) {
            m2068a(30602);
            return;
        }
        hashMap.put("method", "delete");
        JSONArray jSONArray = new JSONArray();
        for (Object put : this.f1602d) {
            jSONArray.put(put);
        }
        hashMap.put("msg_ids", jSONArray.toString());
    }
}
