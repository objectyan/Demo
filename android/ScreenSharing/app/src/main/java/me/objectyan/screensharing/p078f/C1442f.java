package com.baidu.carlife.p078f;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ScrollView;

/* compiled from: FocusScrollView */
/* renamed from: com.baidu.carlife.f.f */
public class C1442f extends C1436a {
    public C1442f(ScrollView view, int position) {
        super(view, position);
        view.setOnKeyListener(this);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event != null && event.getAction() == 0) {
            switch (keyCode) {
                case 300:
                    ((ScrollView) this.r).arrowScroll(130);
                    return true;
                case 301:
                    ((ScrollView) this.r).arrowScroll(33);
                    return true;
            }
        }
        return super.onKey(v, keyCode, event);
    }
}
