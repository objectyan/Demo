package com.baidu.platform.comapi.util.p211b;

import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.map.config.Preferences;

/* compiled from: SkinSaveUtil */
/* renamed from: com.baidu.platform.comapi.util.b.b */
public class C4798b {
    /* renamed from: a */
    private Preferences f19904a;
    /* renamed from: b */
    private Preferences f19905b;
    /* renamed from: c */
    private Preferences f19906c;

    /* compiled from: SkinSaveUtil */
    /* renamed from: com.baidu.platform.comapi.util.b.b$a */
    private static class C4797a {
        /* renamed from: a */
        static final C4798b f19903a = new C4798b();

        private C4797a() {
        }
    }

    private C4798b() {
        this.f19904a = Preferences.build(C2907c.f(), "skin_save_config");
        this.f19905b = Preferences.build(C2907c.f(), "skin_use_config");
        this.f19906c = Preferences.build(C2907c.f(), "skin_force_change_config");
    }

    /* renamed from: a */
    public static C4798b m15889a() {
        return C4797a.f19903a;
    }

    /* renamed from: b */
    public String m15896b() {
        return this.f19905b.getString(C4795a.f19880a, "");
    }

    /* renamed from: c */
    public void m15901c() {
        this.f19905b.clear();
    }

    /* renamed from: a */
    public void m15893a(String path) {
        this.f19905b.putString(C4795a.f19880a, path);
    }

    /* renamed from: b */
    public void m15900b(String pkgName) {
        this.f19905b.putString(C4795a.f19881b, pkgName);
    }

    /* renamed from: a */
    public void m15890a(int themeId) {
        this.f19905b.putInt(C4795a.f19883d, themeId);
    }

    /* renamed from: a */
    public void m15894a(String path, String pkgName, int themeId) {
        m15893a(path);
        m15900b(pkgName);
        m15890a(themeId);
    }

    /* renamed from: d */
    public int m15904d() {
        return this.f19905b.getInt(C4795a.f19883d, 0);
    }

    /* renamed from: e */
    public int m15907e() {
        return this.f19905b.getInt(C4795a.f19889j, 0);
    }

    /* renamed from: b */
    public void m15897b(int version) {
        this.f19905b.putInt(C4795a.f19889j, version);
    }

    /* renamed from: c */
    public void m15902c(int modeId) {
        this.f19905b.putInt(C4795a.f19882c, modeId);
    }

    /* renamed from: f */
    public int m15910f() {
        return this.f19905b.getInt(C4795a.f19882c, 1);
    }

    /* renamed from: c */
    public void m15903c(String engineUrl) {
        this.f19905b.putString(C4795a.f19884e, engineUrl);
    }

    /* renamed from: g */
    public String m15913g() {
        return this.f19905b.getString(C4795a.f19884e, "");
    }

    /* renamed from: h */
    public String m15916h() {
        return this.f19905b.getString(C4795a.f19881b, "");
    }

    /* renamed from: d */
    public void m15906d(String skinId) {
        this.f19904a.putBoolean(skinId, true);
    }

    /* renamed from: e */
    public boolean m15909e(String skinId) {
        return this.f19904a.getBoolean(skinId, false);
    }

    /* renamed from: d */
    public void m15905d(int themeId) {
        this.f19905b.putInt(C4795a.f19885f, themeId);
    }

    /* renamed from: i */
    public int m15918i() {
        return this.f19905b.getInt(C4795a.f19885f, -1);
    }

    /* renamed from: e */
    public void m15908e(int themeId) {
        this.f19904a.putInt(C4795a.f19886g, themeId);
    }

    /* renamed from: j */
    public int m15920j() {
        return this.f19904a.getInt(C4795a.f19886g, -1);
    }

    /* renamed from: a */
    public void m15891a(int themeId, boolean isClick) {
        this.f19904a.putBoolean(C4795a.f19901v + themeId, isClick);
    }

    /* renamed from: f */
    public boolean m15912f(int themeId) {
        return this.f19904a.getBoolean(C4795a.f19901v + themeId, true);
    }

    /* renamed from: a */
    public void m15895a(boolean status) {
        this.f19905b.putBoolean(C4795a.f19887h, status);
    }

    /* renamed from: k */
    public boolean m15923k() {
        return this.f19905b.getBoolean(C4795a.f19887h, false);
    }

    /* renamed from: b */
    public void m15898b(int materId, boolean isShow) {
        this.f19904a.putBoolean(String.valueOf(materId), isShow);
    }

    /* renamed from: g */
    public boolean m15915g(int materId) {
        return this.f19904a.getBoolean(String.valueOf(materId), true);
    }

    /* renamed from: h */
    public void m15917h(int level) {
        this.f19904a.putInt(C4795a.f19888i, level);
    }

    /* renamed from: l */
    public int m15924l() {
        return this.f19904a.getInt(C4795a.f19888i, 0);
    }

    /* renamed from: i */
    public void m15919i(int themeid) {
        this.f19906c.putInt(C4795a.f19891l, themeid);
    }

    /* renamed from: m */
    public int m15926m() {
        return this.f19906c.getInt(C4795a.f19891l, 0);
    }

    /* renamed from: f */
    public void m15911f(String url) {
        this.f19906c.putString(C4795a.f19892m, url);
    }

    /* renamed from: n */
    public String m15928n() {
        return this.f19906c.getString(C4795a.f19892m, "");
    }

    /* renamed from: j */
    public void m15921j(int modeid) {
        this.f19906c.putInt(C4795a.f19893n, modeid);
    }

    /* renamed from: o */
    public int m15929o() {
        return this.f19906c.getInt(C4795a.f19893n, 1);
    }

    /* renamed from: a */
    public void m15892a(long startDate) {
        this.f19906c.putLong(C4795a.f19894o, startDate);
    }

    /* renamed from: p */
    public long m15930p() {
        return this.f19906c.getLong(C4795a.f19894o, 0).longValue();
    }

    /* renamed from: b */
    public void m15899b(long endDate) {
        this.f19906c.putLong(C4795a.f19895p, endDate);
    }

    /* renamed from: q */
    public long m15931q() {
        return this.f19906c.getLong(C4795a.f19895p, 0).longValue();
    }

    /* renamed from: k */
    public void m15922k(int themeId) {
        this.f19906c.putInt(C4795a.f19897r, themeId);
    }

    /* renamed from: r */
    public int m15932r() {
        return this.f19906c.getInt(C4795a.f19897r, 0);
    }

    /* renamed from: l */
    public void m15925l(int themeId) {
        this.f19906c.putInt(C4795a.f19898s, themeId);
    }

    /* renamed from: s */
    public int m15933s() {
        return this.f19906c.getInt(C4795a.f19898s, -1);
    }

    /* renamed from: g */
    public void m15914g(String skinPath) {
        this.f19906c.putString(C4795a.f19896q, skinPath);
    }

    /* renamed from: t */
    public String m15934t() {
        return this.f19906c.getString(C4795a.f19896q, "");
    }

    /* renamed from: u */
    public void m15935u() {
        this.f19906c.clear();
    }

    /* renamed from: m */
    public void m15927m(int effectType) {
        this.f19905b.putInt(C4795a.f19890k, effectType);
    }

    /* renamed from: v */
    public int m15936v() {
        return this.f19905b.getInt(C4795a.f19890k, -1);
    }
}
