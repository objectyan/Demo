package com.baidu.carlife.core.screen.operation;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;

import com.baidu.carlife.core.LogUtil;

/* compiled from: NormalKnobKeyListener */
/* renamed from: com.baidu.carlife.core.screen.b.b */
public class NormalKnobKeyListener extends KnobKeyListener {
    public NormalKnobKeyListener(Activity activity) {
        this.mActivity = activity;
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
            if (keyCode == KnobKeyListener.f3664a) {
                this.mActivity.dispatchKeyEvent(new KeyEvent(0, 22));
            } else {
                this.mActivity.dispatchKeyEvent(new KeyEvent(0, 21));
            }
            LogUtil.d("ouyang", "-------ACTION_UP----");
        }
        return true;
    }
}
