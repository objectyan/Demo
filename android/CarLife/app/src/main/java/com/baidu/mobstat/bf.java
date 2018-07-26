package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class bf {
    /* renamed from: b */
    private static final bf f19442b = new bf();
    /* renamed from: a */
    private HashMap<String, Set<String>> f19443a = new HashMap();
    /* renamed from: c */
    private boolean f19444c;
    /* renamed from: d */
    private boolean f19445d;

    bf() {
    }

    /* renamed from: a */
    public static bf m15438a() {
        return f19442b;
    }

    /* renamed from: a */
    public void m15453a(Context context) {
        m15445a(context, false);
    }

    @TargetApi(14)
    /* renamed from: a */
    private void m15445a(Context context, boolean z) {
        if (!this.f19445d) {
            if (VERSION.SDK_INT >= 14) {
                m15452b(context);
                this.f19445d = true;
            } else if (z) {
                db.m15657a("module autotrace only support android os version bigger than 4.0");
            }
        }
    }

    /* renamed from: a */
    private void m15444a(Activity activity, boolean z) {
        if (!(activity instanceof IIgnoreAutoTrace)) {
            if (z) {
                bv.m15511a().m15515a((Context) activity);
            }
            if (z) {
                ch.m15571a().m15591a((Context) activity, System.currentTimeMillis(), true);
                return;
            }
            ch.m15571a().m15592a(activity, System.currentTimeMillis(), true, null);
        }
    }

    /* renamed from: b */
    private void m15452b(Context context) {
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new bg(this));
        } catch (Exception e) {
            db.m15657a("registerActivityLifecycleCallbacks encounter exception");
        }
    }

    /* renamed from: a */
    private void m15440a(Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            if (decorView != null) {
                ViewGroup viewGroup;
                try {
                    viewGroup = (ViewGroup) ((ViewGroup) decorView.findViewById(16908290)).getChildAt(0);
                } catch (Exception e) {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    m15443a(activity, viewGroup);
                }
            }
        }
    }

    /* renamed from: a */
    private void m15443a(Activity activity, ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                m15443a(activity, (ViewGroup) childAt);
            }
            m15441a(activity, childAt);
        }
    }

    /* renamed from: a */
    private void m15441a(Activity activity, View view) {
        if (view instanceof Button) {
            String charSequence = ((Button) view).getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                m15442a(activity, view, charSequence);
            }
        }
    }

    /* renamed from: a */
    private void m15442a(Activity activity, View view, String str) {
        AccessibilityDelegate a = m15437a(view);
        if (!(a instanceof bh)) {
            view.setAccessibilityDelegate(new bh(this, activity, view, str, a));
        }
    }

    /* renamed from: a */
    private AccessibilityDelegate m15437a(View view) {
        try {
            return (AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
        } catch (Exception e) {
            db.m15661b("getAccessibilityDelegate threw an exception when called");
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m15451b(android.app.Activity r13, android.view.View r14, java.lang.String r15) {
        /*
        r12 = this;
        r5 = 1;
        r0 = com.baidu.mobstat.bv.m15511a();
        r0.m15515a(r13);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r14.hashCode();
        r0 = r0.append(r1);
        r1 = "_";
        r0 = r0.append(r1);
        r1 = r14.getId();
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = r13.getClass();
        r9 = r0.getName();
        r2 = r12.f19443a;
        monitor-enter(r2);
        r0 = r12.f19443a;	 Catch:{ all -> 0x0065 }
        r0 = r0.get(r9);	 Catch:{ all -> 0x0065 }
        r0 = (java.util.Set) r0;	 Catch:{ all -> 0x0065 }
        if (r0 == 0) goto L_0x0045;
    L_0x003d:
        r0 = r0.contains(r1);	 Catch:{ all -> 0x0065 }
        if (r0 == 0) goto L_0x0045;
    L_0x0043:
        monitor-exit(r2);	 Catch:{ all -> 0x0065 }
    L_0x0044:
        return;
    L_0x0045:
        monitor-exit(r2);	 Catch:{ all -> 0x0065 }
        r8 = r12.m15439a(r14, r13);
        r0 = com.baidu.mobstat.Config.EventViewType.BUTTON;
        r10 = r0.getValue();
        r1 = com.baidu.mobstat.bm.m15495a();
        r2 = r13.getApplicationContext();
        r4 = "";
        r6 = java.lang.System.currentTimeMillis();
        r3 = r15;
        r11 = r5;
        r1.m15500a(r2, r3, r4, r5, r6, r8, r9, r10, r11);
        goto L_0x0044;
    L_0x0065:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0065 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bf.b(android.app.Activity, android.view.View, java.lang.String):void");
    }

    /* renamed from: a */
    private String m15439a(View view, Activity activity) {
        String str = "";
        if (view == null) {
            return str;
        }
        View view2 = null;
        try {
            view2 = (ViewGroup) ((ViewGroup) activity.getWindow().getDecorView().findViewById(16908290)).getChildAt(0);
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(view.getClass().getName());
        while (view != null && view != r1) {
            View view3 = (View) view.getParent();
            arrayList.add(view3.getClass().getName());
            view = view3;
        }
        int size = arrayList.size() - 1;
        String str2 = str;
        while (size >= 0) {
            str = str2 + ((String) arrayList.get(size)) + "/";
            size--;
            str2 = str;
        }
        if (str2.endsWith("/")) {
            return str2.substring(0, str2.length() - 1);
        }
        return str2;
    }
}
