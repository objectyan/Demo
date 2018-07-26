package com.baidu.carlife.p078f;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.view.HomeCardView;
import java.lang.reflect.Method;

/* compiled from: FocusArea */
/* renamed from: com.baidu.carlife.f.a */
public abstract class C1436a implements OnKeyListener {
    /* renamed from: a */
    protected static final String f4174a = "FocusArea";
    /* renamed from: b */
    public static final int f4175b = 0;
    /* renamed from: c */
    public static final int f4176c = 1;
    /* renamed from: d */
    public static final int f4177d = 2;
    /* renamed from: e */
    public static final int f4178e = 3;
    /* renamed from: f */
    public static final int f4179f = 4;
    /* renamed from: g */
    public static final int f4180g = 5;
    /* renamed from: h */
    public static final int f4181h = 6;
    /* renamed from: i */
    public static final int f4182i = 7;
    /* renamed from: j */
    public static final int f4183j = 8;
    /* renamed from: k */
    public static final int f4184k = 9;
    /* renamed from: l */
    public static final int f4185l = 10;
    /* renamed from: m */
    public static final int f4186m = 11;
    /* renamed from: n */
    public static final int f4187n = 12;
    /* renamed from: o */
    public static final int f4188o = 13;
    /* renamed from: p */
    public static final int f4189p = 14;
    /* renamed from: q */
    public static final int f4190q = 15;
    /* renamed from: r */
    protected View f4191r;
    /* renamed from: s */
    protected int f4192s;
    /* renamed from: t */
    protected boolean f4193t = false;
    /* renamed from: u */
    protected boolean f4194u = false;

    protected C1436a(View view, int position) {
        this.f4191r = view;
        this.f4192s = position;
        this.f4193t = false;
    }

    protected C1436a(View view, int position, boolean isCyclic) {
        this.f4191r = view;
        this.f4192s = position;
        this.f4193t = isCyclic;
    }

    /* renamed from: a */
    public boolean mo1554a() {
        C1260i.m4435b("FocusManager", "grantFocus focusArea");
        this.f4191r.setFocusable(true);
        boolean result = this.f4191r.requestFocus();
        if (result) {
            m5243a(this.f4191r);
        }
        return result;
    }

    /* renamed from: a */
    public void m5243a(View view) {
        if (!C1765g.m6424a().m6442c() && view != null) {
            Drawable drawable = view.getBackground();
            if (view instanceof HomeCardView) {
                ((HomeCardView) view).setFocusViewGone();
            } else if (drawable == null || !(drawable instanceof StateListDrawable)) {
                view.clearFocus();
            } else {
                StateListDrawable stateListDrawable = (StateListDrawable) drawable;
                try {
                    Method getStateDrawableIndex = StateListDrawable.class.getMethod("getStateDrawableIndex", new Class[]{int[].class});
                    Object[] objArr = new Object[1];
                    objArr[0] = new int[]{16843161};
                    stateListDrawable.selectDrawable(((Integer) getStateDrawableIndex.invoke(stateListDrawable, objArr)).intValue());
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: b */
    public int m5246b() {
        return this.f4192s;
    }

    /* renamed from: c */
    public boolean m5247c() {
        return this.f4191r.hasFocus();
    }

    /* renamed from: a */
    public void m5244a(boolean isDialog) {
        this.f4194u = isDialog;
    }

    /* renamed from: d */
    public boolean m5248d() {
        return this.f4194u;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event != null && event.getAction() == 0) {
            C1436a focusArea;
            switch (keyCode) {
                case 19:
                    focusArea = C1440d.m5251a().m5262e(this);
                    C1260i.m4435b("FocusManager", "KEYCODE_DPAD_UP focusArea=" + focusArea);
                    if (focusArea == null) {
                        return true;
                    }
                    focusArea.mo1554a();
                    return true;
                case 20:
                    focusArea = C1440d.m5251a().m5260d(this);
                    C1260i.m4435b("FocusManager", "KEYCODE_DPAD_DOWN focusArea=" + focusArea);
                    if (focusArea == null) {
                        return true;
                    }
                    focusArea.mo1554a();
                    return true;
                case 21:
                    focusArea = C1440d.m5251a().m5264f(this);
                    C1260i.m4435b("FocusManager", "KEYCODE_DPAD_LEFT focusArea=" + focusArea);
                    if (focusArea == null) {
                        return true;
                    }
                    focusArea.mo1554a();
                    return true;
                case 22:
                    focusArea = C1440d.m5251a().m5266g(this);
                    C1260i.m4435b("FocusManager", "KEYCODE_DPAD_RIGHT focusArea=" + focusArea);
                    if (focusArea == null) {
                        return true;
                    }
                    focusArea.mo1554a();
                    return true;
            }
        }
        if (v != null && v.isFocused()) {
            m5243a(v);
        }
        return false;
    }
}
