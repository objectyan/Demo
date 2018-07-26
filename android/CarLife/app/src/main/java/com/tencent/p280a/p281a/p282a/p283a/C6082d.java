package com.tencent.p280a.p281a.p282a.p283a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

/* renamed from: com.tencent.a.a.a.a.d */
final class C6082d extends C6079f {
    public C6082d(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected final void mo4973a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to sharedPreferences");
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
            edit.putString(C6085h.m21669c("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            edit.commit();
        }
    }

    /* renamed from: a */
    protected final boolean mo4974a() {
        return true;
    }

    /* renamed from: b */
    protected final String mo4975b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.a).getString(C6085h.m21669c("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
        }
        return string;
    }
}
