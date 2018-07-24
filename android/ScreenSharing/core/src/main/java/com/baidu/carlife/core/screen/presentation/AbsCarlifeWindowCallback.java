package com.baidu.carlife.core.screen.presentation;

import android.support.annotation.Nullable;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.baidu.carlife.core.KeepClass;

/* compiled from: AbsCarlifeWindowCallback */
/* renamed from: com.baidu.carlife.core.screen.presentation.c */
public abstract class AbsCarlifeWindowCallback implements Callback, KeepClass {
    /* renamed from: a */
    private static final String f3711a = "CarlifeTouchManager#CarlifeWindowCallback";
    /* renamed from: b */
    private Window f3712b;

    /* renamed from: a */
    public abstract void mo1450a();

    public AbsCarlifeWindowCallback(Window window) {
        this.f3712b = window;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return this.f3712b.superDispatchKeyEvent(keyEvent);
        }
        mo1450a();
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f3712b.superDispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f3712b.superDispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f3712b.superDispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f3712b.superDispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Nullable
    public View onCreatePanelView(int i) {
        return null;
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return false;
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return false;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return false;
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
    }

    public void onContentChanged() {
    }

    public void onWindowFocusChanged(boolean b) {
    }

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
    }

    public void onPanelClosed(int i, Menu menu) {
    }

    public boolean onSearchRequested() {
        return false;
    }

    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void onActionModeStarted(ActionMode actionMode) {
    }

    public void onActionModeFinished(ActionMode actionMode) {
    }
}
