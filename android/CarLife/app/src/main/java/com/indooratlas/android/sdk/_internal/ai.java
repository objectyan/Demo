package com.indooratlas.android.sdk._internal;

import android.text.TextUtils;
import java.io.IOException;
import org.json.JSONObject;

public class ai extends C6015z<JSONObject> {
    /* renamed from: b */
    private static final String f22946b = ee.m20406a(ai.class);
    /* renamed from: c */
    private static final JSONObject f22947c = new JSONObject();

    /* renamed from: a */
    public final /* synthetic */ Object m19806a(C6013x c6013x) throws IOException {
        return m19805c(c6013x);
    }

    /* renamed from: c */
    private static JSONObject m19805c(C6013x c6013x) throws IOException {
        Object d = c6013x.d();
        new Object[1][0] = d;
        try {
            if (TextUtils.isEmpty(d)) {
                return f22947c;
            }
            return new JSONObject(d);
        } catch (Throwable e) {
            throw new IOException("error parsing response body to JSON", e);
        }
    }
}
