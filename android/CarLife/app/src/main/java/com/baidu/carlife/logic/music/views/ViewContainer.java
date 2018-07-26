package com.baidu.carlife.logic.music.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.carlife.p059c.p061f.C1139a.C1095b;
import com.baidu.carlife.p059c.p061f.C1139a.C1132a;

public class ViewContainer extends FrameLayout implements C1095b {
    /* renamed from: a */
    private C1132a f5727a;

    public ViewContainer(@NonNull Context context) {
        super(context);
    }

    public ViewContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewContainer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* renamed from: a */
    public void m7041a(C1132a basePresenter) {
        this.f5727a = basePresenter;
    }

    /* renamed from: a */
    public void m7039a() {
        removeAllViews();
        addView(this.f5727a.mo1429b().m3702a());
        this.f5727a.mo1424a();
    }
}
