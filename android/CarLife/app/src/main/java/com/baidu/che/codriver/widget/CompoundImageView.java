package com.baidu.che.codriver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CompoundImageView extends ImageView {
    /* renamed from: a */
    private boolean f9412a;

    public CompoundImageView(Context context) {
        super(context);
    }

    public CompoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public int[] onCreateDrawableState(int extraSpace) {
        int[] states = super.onCreateDrawableState(extraSpace + 1);
        if (m10853a()) {
            mergeDrawableStates(states, new int[]{16842912});
        }
        return states;
    }

    /* renamed from: a */
    public boolean m10853a() {
        return this.f9412a;
    }

    public void setChecked(boolean checked) {
        if (m10853a() != checked) {
            this.f9412a = checked;
            refreshDrawableState();
        }
    }
}
