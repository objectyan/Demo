package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import java.lang.ref.WeakReference;

class co implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ch f19599a;
    /* renamed from: b */
    private long f19600b;
    /* renamed from: c */
    private WeakReference<Context> f19601c;
    /* renamed from: d */
    private WeakReference<Fragment> f19602d;
    /* renamed from: e */
    private WeakReference<Object> f19603e;
    /* renamed from: f */
    private long f19604f;
    /* renamed from: g */
    private WeakReference<Context> f19605g;
    /* renamed from: h */
    private WeakReference<Fragment> f19606h;
    /* renamed from: i */
    private WeakReference<Object> f19607i;
    /* renamed from: j */
    private int f19608j;
    /* renamed from: k */
    private String f19609k;
    /* renamed from: l */
    private String f19610l;
    /* renamed from: m */
    private boolean f19611m;
    /* renamed from: n */
    private ExtraInfo f19612n;
    /* renamed from: o */
    private cm f19613o;

    public co(ch chVar, long j, Context context, Fragment fragment, long j2, Context context2, Fragment fragment2, int i, String str, Object obj, Object obj2, String str2, boolean z, ExtraInfo extraInfo, cm cmVar) {
        this.f19599a = chVar;
        this.f19600b = j;
        this.f19604f = j2;
        this.f19601c = new WeakReference(context);
        this.f19605g = new WeakReference(context2);
        this.f19602d = new WeakReference(fragment);
        this.f19606h = new WeakReference(fragment2);
        this.f19607i = new WeakReference(obj);
        this.f19603e = new WeakReference(obj2);
        this.f19608j = i;
        this.f19609k = str;
        this.f19610l = str2;
        this.f19611m = z;
        this.f19612n = extraInfo;
        this.f19613o = cmVar;
    }

    public void run() {
        Context context;
        String str;
        long j;
        String stringBuilder;
        if (this.f19608j == 1) {
            context = (Context) this.f19601c.get();
            Context context2 = (Context) this.f19605g.get();
            if (context == null || context2 == null) {
                db.m15663c("onPause, WeakReference is already been released");
            } else if (context == context2) {
                str = "";
                j = this.f19600b - this.f19604f;
                StringBuilder stringBuilder2 = new StringBuilder();
                if (this.f19609k != null) {
                    stringBuilder2.append(this.f19609k);
                    if (this.f19613o != null) {
                        j = this.f19613o.f19595d - this.f19613o.f19594c;
                        db.m15663c("page time = " + this.f19613o.f19592a + "; time = " + j);
                        if (j < 20) {
                            db.m15663c("page time little than 20 mills.");
                            return;
                        }
                    }
                } else if (context instanceof Activity) {
                    stringBuilder2.append(((Activity) context).getComponentName().getShortClassName());
                    if (stringBuilder2.charAt(0) == '.') {
                        stringBuilder2.deleteCharAt(0);
                    }
                } else {
                    db.m15663c("onPause, pause is not a Activity");
                    return;
                }
                if (context instanceof Activity) {
                    CharSequence title = ((Activity) context).getTitle();
                    if (title != null) {
                        str = title.toString();
                    }
                }
                db.m15657a("new page view, page name = " + stringBuilder2.toString() + ", stay time = " + j + "(ms)");
                stringBuilder = stringBuilder2.toString();
                if (this.f19609k == null) {
                    this.f19610l = stringBuilder;
                }
                this.f19599a.f19578i.m15553a(new cg(stringBuilder, str, this.f19610l, j, this.f19604f, this.f19611m, this.f19612n));
                if (this.f19609k == null) {
                    this.f19599a.f19578i.m15559d(this.f19600b);
                    this.f19599a.m15579c(context);
                } else if (this.f19613o != null) {
                    this.f19599a.f19578i.m15559d(this.f19613o.f19595d);
                    this.f19599a.m15579c(context);
                }
            } else if (this.f19609k != null) {
                db.m15661b("onPageStart() or onPageEnd() install error.");
            } else {
                db.m15661b("onPause() or onResume() install error.");
            }
        } else if (this.f19608j == 2) {
            Fragment fragment = (Fragment) this.f19602d.get();
            Fragment fragment2 = (Fragment) this.f19606h.get();
            if (fragment == null || fragment2 == null) {
                db.m15663c("onPause, WeakReference is already been released");
            } else if (fragment != fragment2) {
                db.m15663c("onPause() or onResume() install error.");
            } else {
                str = "";
                Activity activity = fragment.getActivity();
                if (activity != null) {
                    str = activity.getTitle().toString();
                }
                j = this.f19600b - this.f19604f;
                r0 = fragment.getClass().getName();
                stringBuilder = r0.substring(r0.lastIndexOf(".") + 1);
                db.m15657a("Fragment new page view, page name = " + r0.toString() + ", stay time = " + j + "(ms)");
                this.f19599a.f19578i.m15553a(new cg(stringBuilder, str, stringBuilder, j, this.f19604f, this.f19611m, this.f19612n));
                this.f19599a.f19578i.m15559d(this.f19600b);
                this.f19599a.m15579c(fragment.getActivity());
            }
        } else if (this.f19608j == 3) {
            Object obj = (android.app.Fragment) this.f19603e.get();
            android.app.Fragment fragment3 = (android.app.Fragment) this.f19607i.get();
            if (obj == null || fragment3 == null) {
                db.m15663c("onPause, WeakReference is already been released");
            } else if (obj != fragment3) {
                db.m15663c("onPause() or onResume() install error.");
            } else {
                str = "";
                Activity activity2 = obj.getActivity();
                if (activity2 != null) {
                    str = activity2.getTitle().toString();
                }
                j = this.f19600b - this.f19604f;
                context = ch.m15569a(obj);
                if (context == null) {
                    db.m15663c("getContxtFromReverse faild.");
                    return;
                }
                r0 = obj.getClass().getName();
                stringBuilder = r0.substring(r0.lastIndexOf(".") + 1);
                db.m15657a("android.app.Fragment new page view, page name = " + r0.toString() + "; stay time = " + j + "(ms)");
                this.f19599a.f19578i.m15553a(new cg(stringBuilder, str, stringBuilder, j, this.f19604f, this.f19611m, this.f19612n));
                this.f19599a.f19578i.m15559d(this.f19600b);
                this.f19599a.m15579c(context);
            }
        }
    }
}
