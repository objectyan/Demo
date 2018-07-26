package com.baidu.carlife.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: CarLifeSettings */
/* renamed from: com.baidu.carlife.core.c */
public class C1192c implements C0689h {
    /* renamed from: a */
    private static final String f3165a;
    /* renamed from: b */
    private static final String f3166b;
    /* renamed from: c */
    private static final String f3167c = "isFristHelpInVoice";
    /* renamed from: n */
    private static C1192c f3168n = new C1192c();
    /* renamed from: d */
    private boolean f3169d;
    /* renamed from: e */
    private boolean f3170e;
    /* renamed from: f */
    private boolean f3171f;
    /* renamed from: g */
    private int f3172g;
    /* renamed from: h */
    private boolean f3173h;
    /* renamed from: i */
    private boolean f3174i;
    /* renamed from: j */
    private boolean f3175j;
    /* renamed from: k */
    private boolean f3176k;
    /* renamed from: l */
    private boolean f3177l;
    /* renamed from: m */
    private SharedPreferences f3178m;

    static {
        StringBuilder append = new StringBuilder().append("hadGuide_v");
        C1251e.m4358a();
        f3165a = append.append(C1251e.m4375h()).toString();
        append = new StringBuilder().append("hadAgreeDisclaimer");
        C1251e.m4358a();
        f3166b = append.append(C1251e.m4375h()).toString();
    }

    /* renamed from: a */
    public static C1192c m4069a() {
        return f3168n;
    }

    private C1192c() {
        this.f3169d = false;
        this.f3170e = false;
        this.f3171f = true;
        this.f3173h = false;
        this.f3174i = false;
        this.f3175j = false;
        this.f3176k = false;
        this.f3177l = false;
        this.f3178m = null;
        this.f3178m = C1157a.m3876a().getSharedPreferences(C1253f.ia, 0);
        m4072n();
    }

    /* renamed from: n */
    private void m4072n() {
    }

    /* renamed from: a */
    private void m4070a(Editor editor) {
        m4071a(editor, false);
    }

    /* renamed from: a */
    private void m4071a(Editor editor, boolean sync) {
        if (sync) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    /* renamed from: b */
    public boolean m4076b() {
        return this.f3178m.getBoolean(f3165a, true);
    }

    /* renamed from: a */
    public void m4074a(boolean status) {
        Editor editor = this.f3178m.edit();
        editor.putBoolean(f3165a, status);
        m4070a(editor);
    }

    /* renamed from: c */
    public boolean m4078c() {
        return this.f3178m.getBoolean(f3166b, false);
    }

    /* renamed from: b */
    public void m4075b(boolean status) {
        Editor editor = this.f3178m.edit();
        editor.putBoolean(f3166b, status);
        m4070a(editor);
    }

    /* renamed from: d */
    public boolean m4080d() {
        return this.f3169d;
    }

    /* renamed from: c */
    public void m4077c(boolean engineInitFinish) {
        this.f3169d = engineInitFinish;
    }

    /* renamed from: e */
    public boolean m4082e() {
        return this.f3170e;
    }

    /* renamed from: d */
    public void m4079d(boolean mLaunchInit) {
        this.f3170e = mLaunchInit;
    }

    /* renamed from: f */
    public boolean m4084f() {
        return this.f3171f;
    }

    /* renamed from: g */
    public int m4085g() {
        return this.f3172g;
    }

    /* renamed from: a */
    public void m4073a(int mOrientation) {
        this.f3172g = mOrientation;
    }

    /* renamed from: h */
    public boolean m4088h() {
        return this.f3174i;
    }

    /* renamed from: e */
    public void m4081e(boolean isCoverSupport) {
        this.f3174i = isCoverSupport;
    }

    /* renamed from: i */
    public boolean m4090i() {
        return this.f3175j;
    }

    /* renamed from: f */
    public void m4083f(boolean lastCoverState) {
        this.f3175j = lastCoverState;
    }

    /* renamed from: j */
    public boolean m4092j() {
        return this.f3178m.getBoolean("isFristHelpInVoice", true);
    }

    /* renamed from: g */
    public void m4086g(boolean status) {
        Editor editor = this.f3178m.edit();
        editor.putBoolean("isFristHelpInVoice", status);
        m4070a(editor);
    }

    /* renamed from: k */
    public boolean m4093k() {
        return this.f3173h;
    }

    /* renamed from: h */
    public void m4087h(boolean flag) {
        this.f3173h = flag;
    }

    /* renamed from: l */
    public boolean m4094l() {
        return this.f3176k;
    }

    /* renamed from: i */
    public void m4089i(boolean surfaceCreatedDone) {
        this.f3176k = surfaceCreatedDone;
    }

    /* renamed from: m */
    public boolean m4095m() {
        return this.f3177l;
    }

    /* renamed from: j */
    public void m4091j(boolean isForeground) {
        this.f3177l = isForeground;
    }
}
