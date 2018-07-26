package com.baidu.carlife.p078f;

import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.baidu.carlife.core.C1260i;

/* compiled from: FocusViewPager */
/* renamed from: com.baidu.carlife.f.h */
public class C1444h extends C1436a {
    /* renamed from: v */
    private static final String f4230v = "FocusViewPager";
    /* renamed from: w */
    private OnKeyListener f4231w;

    public C1444h(ViewPager view, int position) {
        super(view, position);
        view.setOnKeyListener(this);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (this.f4231w != null && this.f4231w.onKey(v, keyCode, event)) {
            return true;
        }
        if (event != null && event.getAction() == 0) {
            C1260i.m4440c(f4230v, "action=" + event.getAction() + "keyCode=" + keyCode);
            switch (keyCode) {
                case 23:
                    if (this.f4231w != null) {
                        return this.f4231w.onKey(v, keyCode, event);
                    }
                    break;
                case 300:
                    ((ViewPager) this.r).arrowScroll(66);
                    return true;
                case 301:
                    ((ViewPager) this.r).arrowScroll(17);
                    return true;
            }
        }
        return super.onKey(v, keyCode, event);
    }

    /* renamed from: a */
    public void m5307a(OnKeyListener onKeyListener) {
        this.f4231w = onKeyListener;
    }
}
