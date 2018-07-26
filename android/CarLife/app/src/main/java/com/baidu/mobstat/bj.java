package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;

class bj extends bk {
    /* renamed from: a */
    static bj f19452a = new bj();

    private bj() {
    }

    /* renamed from: a */
    public static bj m15464a() {
        return f19452a;
    }

    /* renamed from: a */
    public SharedPreferences mo2732a(Context context) {
        return context.getSharedPreferences("__Baidu_Stat_SDK_SendRem", 0);
    }

    /* renamed from: a */
    protected void m15466a(Context context, int i) {
        m15459b(context, "sendLogtype", i);
    }

    /* renamed from: b */
    protected int m15469b(Context context) {
        return m15454a(context, "sendLogtype", 0);
    }

    /* renamed from: b */
    protected void m15470b(Context context, int i) {
        m15459b(context, "timeinterval", i);
    }

    /* renamed from: c */
    protected int m15473c(Context context) {
        return m15454a(context, "timeinterval", 1);
    }

    /* renamed from: a */
    protected void m15468a(Context context, boolean z) {
        m15462b(context, "onlywifi", z);
    }

    /* renamed from: d */
    protected boolean m15478d(Context context) {
        return m15458a(context, "onlywifi", false);
    }

    /* renamed from: a */
    protected void m15467a(Context context, String str) {
        m15461b(context, "device_id_1", str);
    }

    /* renamed from: e */
    protected String m15479e(Context context) {
        return m15457a(context, "device_id_1", null);
    }

    /* renamed from: b */
    protected void m15471b(Context context, String str) {
        if (m15457a(context, "cuid", null) != null) {
            m15463g(context, "cuid");
        }
        m15461b(context, "cuidsec_1", str);
    }

    /* renamed from: f */
    protected String m15481f(Context context) {
        return m15457a(context, "cuidsec_1", null);
    }

    /* renamed from: c */
    protected void m15474c(Context context, String str) {
        m15461b(context, "setchannelwithcodevalue", str);
    }

    /* renamed from: g */
    protected String m15483g(Context context) {
        return m15457a(context, "setchannelwithcodevalue", null);
    }

    /* renamed from: b */
    protected void m15472b(Context context, boolean z) {
        m15462b(context, "setchannelwithcode", z);
    }

    /* renamed from: h */
    protected boolean m15484h(Context context) {
        return m15458a(context, "setchannelwithcode", false);
    }

    /* renamed from: d */
    protected void m15476d(Context context, String str) {
        m15461b(context, "mtjsdkmacss2_1", str);
    }

    /* renamed from: i */
    protected String m15485i(Context context) {
        return m15457a(context, "mtjsdkmacss2_1", null);
    }

    /* renamed from: c */
    protected void m15475c(Context context, boolean z) {
        m15462b(context, "mtjtv", z);
    }

    /* renamed from: j */
    protected boolean m15486j(Context context) {
        return m15458a(context, "mtjtv", false);
    }

    /* renamed from: e */
    protected void m15480e(Context context, String str) {
        m15461b(context, "mtjsdkmacsstv_1", str);
    }

    /* renamed from: k */
    protected String m15487k(Context context) {
        return m15457a(context, "mtjsdkmacsstv_1", null);
    }

    /* renamed from: f */
    protected void m15482f(Context context, String str) {
        m15461b(context, "he.ext", str);
    }

    /* renamed from: l */
    protected String m15488l(Context context) {
        return m15457a(context, "he.ext", null);
    }

    /* renamed from: d */
    protected void m15477d(Context context, boolean z) {
        m15462b(context, "mtjsdkmactrick", z);
    }

    /* renamed from: m */
    protected boolean m15489m(Context context) {
        return m15458a(context, "mtjsdkmactrick", true);
    }
}
