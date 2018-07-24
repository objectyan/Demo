package com.baidu.carlife.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.core.LogUtil;
import java.util.Calendar;

/* compiled from: OnPreventFastClickListener */
/* renamed from: com.baidu.carlife.view.d */
public abstract class C2246d implements OnClickListener {
    /* renamed from: a */
    private static final String f7324a = "CarlifeTouchManager#ClickListener";
    /* renamed from: b */
    public static final int f7325b = 300;
    /* renamed from: c */
    private long f7326c = 0;

    /* renamed from: a */
    public abstract void mo1799a(View view);

    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - this.f7326c > 300) {
            this.f7326c = currentTime;
            mo1799a(v);
            return;
        }
        LogUtil.m4445e(f7324a, "you click too fast, need to throw away");
    }
}
