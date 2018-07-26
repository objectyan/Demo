package com.baidu.carlife.radio.p080b;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BundleParser */
/* renamed from: com.baidu.carlife.radio.b.b */
public class C2111b {
    /* renamed from: a */
    public static Map<String, String> m7954a(Bundle input) {
        Map<String, String> params = new HashMap();
        for (String key : input.keySet()) {
            params.put(key, input.getString(key));
        }
        return params;
    }
}
