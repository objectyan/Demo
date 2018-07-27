package me.objectyan.screensharing.core.screen;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;


public interface OnWindowManagerViewListener {
    void hideWindowView();

    boolean isWindowViewShown();

    void showWindowView(View view, LayoutParams layoutParams);
}
