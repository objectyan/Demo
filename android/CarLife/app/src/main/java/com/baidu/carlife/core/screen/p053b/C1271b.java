package com.baidu.carlife.core.screen.p053b;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.carlife.core.C1260i;

/* compiled from: NormalKnobKeyListener */
/* renamed from: com.baidu.carlife.core.screen.b.b */
public class C1271b extends C1270a {
    public C1271b(Activity activity) {
        this.c = activity;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        C1260i.m4435b("ouyang", "-------keyCode:" + keyCode);
        if (keyCode != C1270a.f3665b && keyCode != C1270a.f3664a) {
            return false;
        }
        if (event.getAction() == 0) {
            C1260i.m4435b("ouyang", "-------ACTION_DOWN----");
            return false;
        }
        if (event.getAction() == 1) {
            if (keyCode == C1270a.f3664a) {
                this.c.dispatchKeyEvent(new KeyEvent(0, 22));
            } else {
                this.c.dispatchKeyEvent(new KeyEvent(0, 21));
            }
            C1260i.m4435b("ouyang", "-------ACTION_UP----");
        }
        return true;
    }
}
