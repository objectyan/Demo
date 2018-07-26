package com.baidu.carlife.radio.p080b;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ListParser */
/* renamed from: com.baidu.carlife.radio.b.j */
public abstract class C2120j<T> implements C2113m<String, List<T>> {
    /* renamed from: a */
    private C2113m<JSONObject, T> f6721a;

    /* renamed from: a */
    protected abstract List<T> mo1779a(JSONObject jSONObject);

    public C2120j(C2113m<JSONObject, T> objectParser) {
        this.f6721a = objectParser;
    }

    /* renamed from: a */
    C2113m<JSONObject, T> m7989a() {
        return this.f6721a;
    }

    /* renamed from: a */
    public List<T> m7991a(String input) {
        try {
            return mo1779a(new JSONObject(input));
        } catch (JSONException e) {
            return null;
        }
    }
}
