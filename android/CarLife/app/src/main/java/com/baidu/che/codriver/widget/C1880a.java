package com.baidu.che.codriver.widget;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

/* compiled from: DuerOSAnimationDrawable */
/* renamed from: com.baidu.che.codriver.widget.a */
public abstract class C1880a extends AnimationDrawable {
    /* renamed from: a */
    private Handler f5817a;
    /* renamed from: b */
    private int f5818b;

    /* compiled from: DuerOSAnimationDrawable */
    /* renamed from: com.baidu.che.codriver.widget.a$1 */
    class C28811 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1880a f9504a;

        C28811(C1880a this$0) {
            this.f9504a = this$0;
        }

        public void run() {
            if (this.f9504a.isOneShot()) {
                this.f9504a.mo1702a();
            } else {
                this.f9504a.f5817a.postDelayed(this, (long) this.f9504a.f5818b);
            }
        }
    }

    /* renamed from: a */
    public abstract void mo1702a();

    public C1880a(AnimationDrawable aniDrawable) {
        for (int i = 0; i < aniDrawable.getNumberOfFrames(); i++) {
            addFrame(aniDrawable.getFrame(i), aniDrawable.getDuration(i));
        }
        this.f5818b = m7180b();
    }

    public void start() {
        super.start();
        this.f5817a = new Handler();
        this.f5817a.postDelayed(new C28811(this), (long) this.f5818b);
    }

    /* renamed from: b */
    public int m7180b() {
        int iDuration = 0;
        for (int i = 0; i < getNumberOfFrames(); i++) {
            iDuration += getDuration(i);
        }
        return iDuration;
    }
}
