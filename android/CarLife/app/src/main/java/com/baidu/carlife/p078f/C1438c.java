package com.baidu.carlife.p078f;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ListView;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;

/* compiled from: FocusListView */
/* renamed from: com.baidu.carlife.f.c */
public class C1438c extends C1436a {
    /* renamed from: v */
    private OnKeyListener f4196v;

    public C1438c(ListView view, int position) {
        super(view, position);
        view.setOnKeyListener(this);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (this.f4196v != null && this.f4196v.onKey(v, keyCode, event)) {
            return true;
        }
        if (event != null && event.getAction() == 0) {
            switch (keyCode) {
                case 300:
                    if (!m5248d() && C1309g.m4699a().isDialogShown() && !C1440d.m5251a().m5270i()) {
                        return true;
                    }
                    this.r.onKeyDown(20, event);
                    return true;
                case 301:
                    if (!m5248d() && C1309g.m4699a().isDialogShown() && !C1440d.m5251a().m5270i()) {
                        return true;
                    }
                    this.r.onKeyDown(19, event);
                    return true;
            }
        }
        return super.onKey(v, keyCode, event);
    }

    /* renamed from: a */
    public void m5249a(OnKeyListener onKeyListener) {
        this.f4196v = onKeyListener;
    }

    /* renamed from: e */
    public void m5250e() {
        ((ListView) this.r).setSelection(0);
    }
}
