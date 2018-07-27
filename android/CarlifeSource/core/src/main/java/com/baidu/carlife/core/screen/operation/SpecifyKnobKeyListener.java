package com.baidu.carlife.core.screen.operation;

import android.view.KeyEvent;
import android.view.View;

import com.baidu.carlife.core.LogUtil;

/* compiled from: SpecifyKnobKeyListener */
/* renamed from: com.baidu.carlife.core.screen.b.d */
public class SpecifyKnobKeyListener extends KnobKeyListener {
    /* renamed from: d */
    private View mNextView;
    /* renamed from: e */
    private View mPreviousView;

    public SpecifyKnobKeyListener(View next, View previous) {
        this.mNextView = next;
        this.mPreviousView = previous;
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
                targetView = this.mNextView;
            } else {
                targetView = this.mPreviousView;
            }
            if (targetView != null) {
                targetView.requestFocus();
            }
            LogUtil.d("ouyang", "-------ACTION_UP----");
        }
        return true;
    }
}
