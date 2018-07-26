package com.facebook.drawee.p143c;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: ForwardingControllerListener */
/* renamed from: com.facebook.drawee.c.e */
public class C5397e<INFO> implements C5396d<INFO> {
    /* renamed from: a */
    private static final String f22042a = "FdingControllerListener";
    /* renamed from: b */
    private final List<C5396d<? super INFO>> f22043b = new ArrayList(2);

    /* renamed from: a */
    public static <INFO> C5397e<INFO> m18463a() {
        return new C5397e();
    }

    /* renamed from: a */
    public static <INFO> C5397e<INFO> m18464a(C5396d<? super INFO> listener) {
        C5397e<INFO> forwarder = C5397e.m18463a();
        forwarder.m18472b(listener);
        return forwarder;
    }

    /* renamed from: b */
    public static <INFO> C5397e<INFO> m18465b(C5396d<? super INFO> listener1, C5396d<? super INFO> listener2) {
        C5397e<INFO> forwarder = C5397e.m18463a();
        forwarder.m18472b(listener1);
        forwarder.m18472b(listener2);
        return forwarder;
    }

    /* renamed from: b */
    public synchronized void m18472b(C5396d<? super INFO> listener) {
        this.f22043b.add(listener);
    }

    /* renamed from: c */
    public synchronized void m18475c(C5396d<? super INFO> listener) {
        this.f22043b.remove(listener);
    }

    /* renamed from: b */
    public synchronized void m18471b() {
        this.f22043b.clear();
    }

    /* renamed from: c */
    private synchronized void m18466c(String message, Throwable t) {
        Log.e(f22042a, message, t);
    }

    /* renamed from: a */
    public synchronized void mo4024a(String id, Object callerContext) {
        int numberOfListeners = this.f22043b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5396d) this.f22043b.get(i)).mo4024a(id, callerContext);
            } catch (Exception exception) {
                m18466c("InternalListener exception in onSubmit", exception);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo4025a(String id, @Nullable INFO imageInfo, @Nullable Animatable animatable) {
        int numberOfListeners = this.f22043b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5396d) this.f22043b.get(i)).mo4025a(id, imageInfo, animatable);
            } catch (Exception exception) {
                m18466c("InternalListener exception in onFinalImageSet", exception);
            }
        }
    }

    /* renamed from: b */
    public void mo4027b(String id, @Nullable INFO imageInfo) {
        int numberOfListeners = this.f22043b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5396d) this.f22043b.get(i)).mo4027b(id, (Object) imageInfo);
            } catch (Exception exception) {
                m18466c("InternalListener exception in onIntermediateImageSet", exception);
            }
        }
    }

    /* renamed from: a */
    public void mo4026a(String id, Throwable throwable) {
        int numberOfListeners = this.f22043b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5396d) this.f22043b.get(i)).mo4026a(id, throwable);
            } catch (Exception exception) {
                m18466c("InternalListener exception in onIntermediateImageFailed", exception);
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo4028b(String id, Throwable throwable) {
        int numberOfListeners = this.f22043b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5396d) this.f22043b.get(i)).mo4028b(id, throwable);
            } catch (Exception exception) {
                m18466c("InternalListener exception in onFailure", exception);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo4023a(String id) {
        int numberOfListeners = this.f22043b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5396d) this.f22043b.get(i)).mo4023a(id);
            } catch (Exception exception) {
                m18466c("InternalListener exception in onRelease", exception);
            }
        }
    }
}
