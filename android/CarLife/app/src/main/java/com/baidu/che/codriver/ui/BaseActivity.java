package com.baidu.che.codriver.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.che.codriver.C2510a;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.mobstat.StatService;
import java.util.Iterator;
import java.util.Stack;

public abstract class BaseActivity extends Activity {
    /* renamed from: b */
    private static Stack<BaseActivity> f8687b = new Stack();
    /* renamed from: a */
    private boolean f8688a;

    protected void onCreate(Bundle savedInstanceState) {
        C2725h.m10207b(getClass().getSimpleName(), "onCreate()");
        this.f8688a = true;
        super.onCreate(savedInstanceState);
        m9908b(this);
    }

    protected void onStart() {
        C2725h.m10207b(getClass().getSimpleName(), "onStart()");
        super.onStart();
    }

    protected void onResume() {
        C2725h.m10207b(getClass().getSimpleName(), "onResume()");
        StatService.onResume((Context) this);
        super.onResume();
    }

    protected void onPause() {
        C2725h.m10207b(getClass().getSimpleName(), "onPause()");
        StatService.onPause((Context) this);
        this.f8688a = false;
        super.onPause();
    }

    protected void onStop() {
        C2725h.m10207b(getClass().getSimpleName(), "onStop()");
        super.onStop();
    }

    protected void onDestroy() {
        C2725h.m10207b(getClass().getSimpleName(), "onDestroy()");
        super.onDestroy();
        m9909c(this);
    }

    public void onBackPressed() {
        if (C2510a.f8201r.equals(getIntent().getStringExtra(C2510a.f8200q))) {
            C2674b.m9985b().m10043t();
        }
        super.onBackPressed();
    }

    /* renamed from: b */
    private static void m9908b(BaseActivity activity) {
        if (activity != null) {
            f8687b.push(activity);
        }
    }

    /* renamed from: c */
    private static void m9909c(BaseActivity activity) {
        if (activity != null && f8687b.contains(activity)) {
            f8687b.remove(activity);
        }
    }

    /* renamed from: a */
    public static void m9905a() {
        if (!f8687b.empty()) {
            Iterator it = f8687b.iterator();
            while (it.hasNext()) {
                BaseActivity activity = (BaseActivity) it.next();
                if (!(activity == null || activity.isFinishing())) {
                    activity.finish();
                }
            }
            f8687b.clear();
        }
    }

    /* renamed from: a */
    public static void m9906a(BaseActivity activity) {
        if (!(activity == null || activity.isFinishing())) {
            activity.finish();
        }
        m9909c(activity);
    }

    /* renamed from: b */
    public static BaseActivity m9907b() {
        if (!f8687b.empty()) {
            Iterator it = f8687b.iterator();
            while (it.hasNext()) {
                BaseActivity activity = (BaseActivity) it.next();
                if (activity != null && (activity instanceof MainActivity)) {
                    return activity;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    protected void m9910a(String titleText) {
    }
}
