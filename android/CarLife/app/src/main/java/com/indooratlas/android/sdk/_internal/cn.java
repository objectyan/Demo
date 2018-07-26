package com.indooratlas.android.sdk._internal;

import org.json.JSONArray;
import org.json.JSONException;

public final class cn {
    /* renamed from: a */
    public static double[] m20233a(JSONArray jSONArray) throws JSONException {
        int length = jSONArray.length();
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = jSONArray.getDouble(i);
        }
        return dArr;
    }
}
