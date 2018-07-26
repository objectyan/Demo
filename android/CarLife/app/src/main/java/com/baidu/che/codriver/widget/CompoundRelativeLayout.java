package com.baidu.che.codriver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class CompoundRelativeLayout extends RelativeLayout {
    /* renamed from: a */
    private boolean f9413a;

    public CompoundRelativeLayout(Context context) {
        super(context);
    }

    public CompoundRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected int[] onCreateDrawableState(int extraSpace) {
        int[] drwableStates = super.onCreateDrawableState(extraSpace + 1);
        if (m10854a()) {
            mergeDrawableStates(drwableStates, new int[]{16842912});
        }
        return drwableStates;
    }

    /* renamed from: a */
    public boolean m10854a() {
        return this.f9413a;
    }

    public void setChecked(boolean checked) {
        if (this.f9413a != checked) {
            this.f9413a = checked;
            refreshDrawableState();
        }
    }

    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
    }

    public boolean performClick() {
        return super.performClick();
    }
}
