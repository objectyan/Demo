package com.baidu.carlife.core.screen.operation;

import android.view.KeyEvent;
import android.view.View;
import com.baidu.carlife.core.LogUtil;

/* compiled from: SpecifyKnobKeyListener */
/* renamed from: com.baidu.carlife.core.screen.b.d */
public class SpecifyKnobKeyListener extends KnobKeyListener {
    /* renamed from: d */
    private View f3667d;
    /* renamed from: e */
    private View f3668e;

    public SpecifyKnobKeyListener(View next, View previous) {
        this.f3667d = next;
        this.f3668e = previous;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        LogUtil.d("ouyang", "-------keyCode:" + keyCode);
        if (keyCode != KnobKeyListener.f3665b && keyCode != KnobKeyListener.f3664a) {
            return false;
        }
        if (event.getAction() == 0) {
            LogUtil.d("ouyang", "-------ACTION_DOWN----");
            return false;
        }
        if (event.getAction() == 1) {
            View targetView;
            if (keyCode == KnobKeyListener.f3664a) {
                targetView = this.f3667d;
            } else {
                targetView = this.f3668e;
            }
            if (targetView != null) {
                targetView.requestFocus();
            }
            LogUtil.d("ouyang", "-------ACTION_UP----");
        }
        return true;
    }
}
