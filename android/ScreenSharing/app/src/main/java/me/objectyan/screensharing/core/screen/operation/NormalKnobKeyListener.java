package me.objectyan.screensharing.core.screen.operation;

import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import me.objectyan.screensharing.core.LogUtil;


public class NormalKnobKeyListener extends KnobKeyListener {
    public NormalKnobKeyListener(Activity activity) {
        this.mActivity = activity;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        Log.d("ouyang", "-------keyCode:" + keyCode);
        if (keyCode != KnobKeyListener.f3665b && keyCode != KnobKeyListener.f3664a) {
            return false;
        }
        if (event.getAction() == 0) {
            Log.d("ouyang", "-------ACTION_DOWN----");
            return false;
        }
        if (event.getAction() == 1) {
            if (keyCode == KnobKeyListener.f3664a) {
                this.mActivity.dispatchKeyEvent(new KeyEvent(0, 22));
            } else {
                this.mActivity.dispatchKeyEvent(new KeyEvent(0, 21));
            }
            Log.d("ouyang", "-------ACTION_UP----");
        }
        return true;
    }
}
