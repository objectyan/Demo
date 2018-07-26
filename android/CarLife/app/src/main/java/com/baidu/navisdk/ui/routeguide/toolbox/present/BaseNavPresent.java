package com.baidu.navisdk.ui.routeguide.toolbox.present;

import android.view.View;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;

public abstract class BaseNavPresent {
    protected abstract void initViewStatus();

    public abstract void onClick(View view, int i);

    public abstract void onTopStatus();

    public abstract void setOnSubViewClickListener(OnRGSubViewListener onRGSubViewListener);

    public void startInit() {
        initViewStatus();
    }
}
