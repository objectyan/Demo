package com.baidu.carlife.core.screen.presentation;

import android.support.annotation.Nullable;
import android.view.ActionMode;
import android.view.SearchEvent;
import android.view.Window;


/* compiled from: CarlifeWindowCallback */
/* renamed from: com.baidu.carlife.core.screen.presentation.g */
public class CarlifeWindowCallback extends AbsCarlifeWindowCallback {
    public CarlifeWindowCallback(Window window) {
        super(null
                , window);
    }

    /* renamed from: a */
    public void mo1450a() {
//        ActivityStack.handleAppBackPressed();
    }

    @Override
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return false;
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return null;
    }
}
