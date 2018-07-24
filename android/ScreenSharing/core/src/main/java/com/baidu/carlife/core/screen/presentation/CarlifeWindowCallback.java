package com.baidu.carlife.core.screen.presentation;

import android.view.Window;
import com.baidu.navi.ActivityStack;

/* compiled from: CarlifeWindowCallback */
/* renamed from: com.baidu.carlife.core.screen.presentation.g */
public class CarlifeWindowCallback extends AbsCarlifeWindowCallback {
    public CarlifeWindowCallback(Window window) {
        super(window);
    }

    /* renamed from: a */
    public void mo1450a() {
        ActivityStack.handleAppBackPressed();
    }
}
