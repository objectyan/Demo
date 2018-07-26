package com.baidu.carlife.core.screen.p053b;

import android.view.KeyEvent;
import android.view.View;
import com.baidu.carlife.core.C1260i;

/* compiled from: SpecifyKnobKeyListener */
/* renamed from: com.baidu.carlife.core.screen.b.d */
public class C1272d extends C1270a {
    /* renamed from: d */
    private View f3667d;
    /* renamed from: e */
    private View f3668e;

    public C1272d(View next, View previous) {
        this.f3667d = next;
        this.f3668e = previous;
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
            View targetView;
            if (keyCode == C1270a.f3664a) {
                targetView = this.f3667d;
            } else {
                targetView = this.f3668e;
            }
            if (targetView != null) {
                targetView.requestFocus();
            }
            C1260i.m4435b("ouyang", "-------ACTION_UP----");
        }
        return true;
    }
}
