package me.objectyan.screensharing.core.screen.operation;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import me.objectyan.screensharing.core.LogUtil;


public class SpecifyKnobKeyListener extends KnobKeyListener {

    private View mNextView;

    private View mPreviousView;

    public SpecifyKnobKeyListener(View next, View previous) {
        this.mNextView = next;
        this.mPreviousView = previous;
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
            View targetView;
            if (keyCode == KnobKeyListener.f3664a) {
                targetView = this.mNextView;
            } else {
                targetView = this.mPreviousView;
            }
            if (targetView != null) {
                targetView.requestFocus();
            }
            Log.d("ouyang", "-------ACTION_UP----");
        }
        return true;
    }
}
