package com.facebook.imagepipeline.p278j;

import com.facebook.common.p257e.C5320a;
import com.facebook.imagepipeline.p154m.C2959c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: ForwardingRequestListener */
/* renamed from: com.facebook.imagepipeline.j.b */
public class C5541b implements C5539c {
    /* renamed from: a */
    private static final String f22461a = "ForwardingRequestListener";
    /* renamed from: b */
    private final List<C5539c> f22462b;

    public C5541b(Set<C5539c> requestListeners) {
        this.f22462b = new ArrayList(requestListeners.size());
        for (C5539c requestListener : requestListeners) {
            this.f22462b.add(requestListener);
        }
    }

    /* renamed from: a */
    public void mo4107a(C2959c request, Object callerContext, String requestId, boolean isPrefetch) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5539c) this.f22462b.get(i)).mo4107a(request, callerContext, requestId, isPrefetch);
            } catch (Throwable exception) {
                m19088a("InternalListener exception in onRequestStart", exception);
            }
        }
    }

    /* renamed from: a */
    public void mo4111a(String requestId, String producerName) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5539c) this.f22462b.get(i)).mo4111a(requestId, producerName);
            } catch (Throwable exception) {
                m19088a("InternalListener exception in onProducerStart", exception);
            }
        }
    }

    /* renamed from: a */
    public void mo4114a(String requestId, String producerName, @Nullable Map<String, String> extraMap) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5539c) this.f22462b.get(i)).mo4114a(requestId, producerName, (Map) extraMap);
            } catch (Throwable exception) {
                m19088a("InternalListener exception in onProducerFinishWithSuccess", exception);
            }
        }
    }

    /* renamed from: a */
    public void mo4113a(String requestId, String producerName, Throwable t, @Nullable Map<String, String> extraMap) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5539c) this.f22462b.get(i)).mo4113a(requestId, producerName, t, extraMap);
            } catch (Throwable exception) {
                m19088a("InternalListener exception in onProducerFinishWithFailure", exception);
            }
        }
    }

    /* renamed from: b */
    public void mo4115b(String requestId, String producerName, @Nullable Map<String, String> extraMap) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5539c) this.f22462b.get(i)).mo4115b(requestId, producerName, extraMap);
            } catch (Throwable exception) {
                m19088a("InternalListener exception in onProducerFinishWithCancellation", exception);
            }
        }
    }

    /* renamed from: a */
    public void mo4112a(String requestId, String producerName, String producerEventName) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5539c) this.f22462b.get(i)).mo4112a(requestId, producerName, producerEventName);
            } catch (Throwable exception) {
                m19088a("InternalListener exception in onIntermediateChunkStart", exception);
            }
        }
    }

    /* renamed from: a */
    public void mo4109a(C2959c request, String requestId, boolean isPrefetch) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5539c) this.f22462b.get(i)).mo4109a(request, requestId, isPrefetch);
            } catch (Throwable exception) {
                m19088a("InternalListener exception in onRequestSuccess", exception);
            }
        }
    }

    /* renamed from: a */
    public void mo4108a(C2959c request, String requestId, Throwable throwable, boolean isPrefetch) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5539c) this.f22462b.get(i)).mo4108a(request, requestId, throwable, isPrefetch);
            } catch (Throwable exception) {
                m19088a("InternalListener exception in onRequestFailure", exception);
            }
        }
    }

    /* renamed from: a */
    public void mo4110a(String requestId) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            try {
                ((C5539c) this.f22462b.get(i)).mo4110a(requestId);
            } catch (Throwable exception) {
                m19088a("InternalListener exception in onRequestCancellation", exception);
            }
        }
    }

    /* renamed from: b */
    public boolean mo4116b(String id) {
        int numberOfListeners = this.f22462b.size();
        for (int i = 0; i < numberOfListeners; i++) {
            if (((C5539c) this.f22462b.get(i)).mo4116b(id)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m19088a(String message, Throwable t) {
        C5320a.m18185e(f22461a, message, t);
    }
}
