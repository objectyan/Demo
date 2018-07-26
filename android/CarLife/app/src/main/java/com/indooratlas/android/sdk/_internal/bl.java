package com.indooratlas.android.sdk._internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class bl {
    /* renamed from: a */
    SharedPreferences f23201a;
    /* renamed from: b */
    Editor f23202b = this.f23201a.edit();

    @SuppressLint({"CommitPrefEdits"})
    bl(Context context) {
        this.f23201a = context.getSharedPreferences("com.indooratlas.sdk.runtime", 0);
    }

    /* renamed from: a */
    public final String m20110a() {
        String string = this.f23201a.getString("idauuid", null);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("called getIdaUUID before api key is stored");
    }

    /* renamed from: b */
    public final void m20111b() {
        this.f23202b.apply();
    }

    /* renamed from: a */
    static String m20109a(JSONObject jSONObject) {
        try {
            return ct.m20258a(ct.m20267a(jSONObject.toString()));
        } catch (Exception e) {
            return "";
        }
    }
}
