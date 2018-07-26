package com.samsung.android.sdk.motion;

import android.hardware.motion.MREvent;
import android.hardware.motion.MRListener;
import com.samsung.android.sdk.motion.SmotionCall.ChangeListener;
import com.samsung.android.sdk.motion.SmotionCall.Info;

/* renamed from: com.samsung.android.sdk.motion.c */
final class C6076c implements MRListener {
    /* renamed from: a */
    private final /* synthetic */ ChangeListener f24733a;

    C6076c(SmotionCall smotionCall, ChangeListener changeListener) {
        this.f24733a = changeListener;
    }

    public final void onMotionListener(MREvent mREvent) {
        long nanoTime;
        Info info = new Info();
        switch (mREvent.getMotion()) {
            case 101:
                nanoTime = System.nanoTime();
                info.m21622a(0);
                break;
            case 102:
                nanoTime = System.nanoTime();
                info.m21622a(1);
                break;
            default:
                return;
        }
        info.f24694b = nanoTime;
        this.f24733a.onChanged(info);
    }
}
