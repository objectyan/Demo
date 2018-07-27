package com.baidu.carlife.p078f;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import com.baidu.carlife.core.LogUtil;

/* compiled from: FocusWebView */
/* renamed from: com.baidu.carlife.f.i */
public class C1445i extends C1436a {
    public C1445i(WebView view, int position) {
        super(view, position);
        view.setOnKeyListener(this);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        LogUtil.e("FocusArea", "keycode = " + keyCode + ", event = " + event.toString());
        if (event != null && event.getAction() == 0) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    return true;
                case 300:
                    LogUtil.d("FocusArea", "WebView: KEYCODE_KONB_CLOCKWISE ");
                    this.r.onKeyDown(20, event);
                    return true;
                case 301:
                    LogUtil.d("FocusArea", "WebView: KEYCODE_KONB_ANTI_CLOCKWISE ");
                    this.r.onKeyDown(19, event);
                    return true;
            }
        }
        return super.onKey(v, keyCode, event);
    }
}
