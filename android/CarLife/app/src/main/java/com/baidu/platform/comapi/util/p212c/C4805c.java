package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.platform.comapi.C2907c;

/* compiled from: CuidInfo */
/* renamed from: com.baidu.platform.comapi.util.c.c */
public class C4805c implements C4800g {
    /* renamed from: a */
    private String f19913a;
    /* renamed from: b */
    private SharedPreferences f19914b;

    /* renamed from: a */
    public void mo3723a(Context context) {
        this.f19914b = context.getSharedPreferences("cuid", 0);
        try {
            if (this.f19914b != null && this.f19914b.contains("cuid")) {
                this.f19913a = this.f19914b.getString("cuid", "");
            }
            if (TextUtils.isEmpty(this.f19913a)) {
                this.f19913a = CommonParam.getCUID(context);
                this.f19914b.edit().putString("cuid", this.f19913a).commit();
            }
        } catch (Exception e) {
            this.f19913a = CommonParam.getCUID(context);
        }
    }

    /* renamed from: a */
    public String m15953a() {
        if (TextUtils.isEmpty(this.f19913a)) {
            mo3723a(C2907c.f());
        }
        return this.f19913a;
    }

    /* renamed from: b */
    public void m15955b() {
        this.f19913a = CommonParam.getCUID(C2907c.f());
        if (this.f19914b != null) {
            this.f19914b.edit().putString("cuid", this.f19913a).commit();
        }
    }
}
