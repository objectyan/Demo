package com.baidu.carlife.core.screen;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

/* compiled from: OnWindowManagerViewListener */
/* renamed from: com.baidu.carlife.core.screen.m */
public interface OnWindowManagerViewListener {
    void hideWindowView();

    boolean isWindowViewShown();

    void showWindowView(View view, LayoutParams layoutParams);
}
