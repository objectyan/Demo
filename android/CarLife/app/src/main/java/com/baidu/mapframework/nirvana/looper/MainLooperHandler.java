package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapframework.nirvana.C3534b;
import com.baidu.mapframework.nirvana.C3541e;
import com.baidu.mapframework.nirvana.C3560n;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.p205b.C3533c;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import org.jetbrains.annotations.NotNull;

public abstract class MainLooperHandler extends Handler {
    private final ScheduleConfig config;
    private C3534b exceptionCallback;
    private final Module module;

    public abstract void onMessage(Message message);

    public MainLooperHandler(@NotNull Module module, @NotNull ScheduleConfig config) {
        super(Looper.getMainLooper());
        this.module = module;
        this.config = config;
    }

    public C3534b getExceptionCallback() {
        return this.exceptionCallback;
    }

    public void setExceptionCallback(C3534b exceptionCallback) {
        this.exceptionCallback = exceptionCallback;
    }

    public final boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        C3541e.m15174b().m15142a(C3533c.LOOPER, msg, this.module, this.config);
        return super.sendMessageAtTime(msg, uptimeMillis);
    }

    public final void handleMessage(Message msg) {
        if (msg != null) {
            final Message copyMsg = Message.obtain();
            copyMsg.copyFrom(msg);
            C3541e.m15175c().run(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ MainLooperHandler f19213b;

                public void run() {
                    C3541e.m15174b().m15143a(copyMsg);
                    try {
                        this.f19213b.onMessage(copyMsg);
                    } catch (Throwable e) {
                        C3560n.m15211a("MainLooperHandler handleMessage exception", e);
                        if (this.f19213b.exceptionCallback != null) {
                            this.f19213b.exceptionCallback.m15158a(e);
                        }
                    }
                    C3541e.m15174b().m15146b(copyMsg);
                    copyMsg.recycle();
                }
            });
        }
    }

    public final void dispatchMessage(Message msg) {
        super.dispatchMessage(msg);
    }
}
