package com.facebook.imagepipeline.p278j;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.p257e.C5320a;
import com.facebook.imagepipeline.p154m.C2959c;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: RequestLoggingListener */
/* renamed from: com.facebook.imagepipeline.j.d */
public class C5542d implements C5539c {
    /* renamed from: a */
    private static final String f22463a = "RequestLoggingListener";
    @GuardedBy("this")
    /* renamed from: b */
    private final Map<Pair<String, String>, Long> f22464b = new HashMap();
    @GuardedBy("this")
    /* renamed from: c */
    private final Map<String, Long> f22465c = new HashMap();

    /* renamed from: a */
    public synchronized void mo4107a(C2959c request, Object callerContextObject, String requestId, boolean isPrefetch) {
        if (C5320a.m18138a(2)) {
            C5320a.m18134a(f22463a, "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(C5542d.m19099a()), (Object) requestId, callerContextObject, Boolean.valueOf(isPrefetch));
            this.f22465c.put(requestId, Long.valueOf(C5542d.m19099a()));
        }
    }

    /* renamed from: a */
    public synchronized void mo4111a(String requestId, String producerName) {
        if (C5320a.m18138a(2)) {
            Pair<String, String> mapKey = Pair.create(requestId, producerName);
            long startTime = C5542d.m19099a();
            this.f22464b.put(mapKey, Long.valueOf(startTime));
            C5320a.m18133a(f22463a, "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(startTime), (Object) requestId, (Object) producerName);
        }
    }

    /* renamed from: a */
    public synchronized void mo4114a(String requestId, String producerName, @Nullable Map<String, String> extraMap) {
        if (C5320a.m18138a(2)) {
            Long startTime = (Long) this.f22464b.remove(Pair.create(requestId, producerName));
            long currentTime = C5542d.m19099a();
            C5320a.m18136a(f22463a, "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(currentTime), requestId, producerName, Long.valueOf(C5542d.m19100a(startTime, currentTime)), extraMap);
        }
    }

    /* renamed from: a */
    public synchronized void mo4113a(String requestId, String producerName, Throwable throwable, @Nullable Map<String, String> extraMap) {
        if (C5320a.m18138a(5)) {
            Long startTime = (Long) this.f22464b.remove(Pair.create(requestId, producerName));
            long currentTime = C5542d.m19099a();
            C5320a.m18178d(f22463a, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", Long.valueOf(currentTime), requestId, producerName, Long.valueOf(C5542d.m19100a(startTime, currentTime)), extraMap, throwable.toString());
        }
    }

    /* renamed from: b */
    public synchronized void mo4115b(String requestId, String producerName, @Nullable Map<String, String> extraMap) {
        if (C5320a.m18138a(2)) {
            Long startTime = (Long) this.f22464b.remove(Pair.create(requestId, producerName));
            long currentTime = C5542d.m19099a();
            C5320a.m18136a(f22463a, "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(currentTime), requestId, producerName, Long.valueOf(C5542d.m19100a(startTime, currentTime)), extraMap);
        }
    }

    /* renamed from: a */
    public synchronized void mo4112a(String requestId, String producerName, String producerEventName) {
        if (C5320a.m18138a(2)) {
            Long startTime = (Long) this.f22464b.get(Pair.create(requestId, producerName));
            long currentTime = C5542d.m19099a();
            C5320a.m18136a(f22463a, "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", Long.valueOf(C5542d.m19099a()), requestId, producerName, producerEventName, Long.valueOf(C5542d.m19100a(startTime, currentTime)));
        }
    }

    /* renamed from: a */
    public synchronized void mo4109a(C2959c request, String requestId, boolean isPrefetch) {
        if (C5320a.m18138a(2)) {
            Long startTime = (Long) this.f22465c.remove(requestId);
            long currentTime = C5542d.m19099a();
            C5320a.m18133a(f22463a, "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(currentTime), (Object) requestId, Long.valueOf(C5542d.m19100a(startTime, currentTime)));
        }
    }

    /* renamed from: a */
    public synchronized void mo4108a(C2959c request, String requestId, Throwable throwable, boolean isPrefetch) {
        if (C5320a.m18138a(5)) {
            Long startTime = (Long) this.f22465c.remove(requestId);
            long currentTime = C5542d.m19099a();
            C5320a.m18178d(f22463a, "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", Long.valueOf(currentTime), requestId, Long.valueOf(C5542d.m19100a(startTime, currentTime)), throwable.toString());
        }
    }

    /* renamed from: a */
    public synchronized void mo4110a(String requestId) {
        if (C5320a.m18138a(2)) {
            Long startTime = (Long) this.f22465c.remove(requestId);
            long currentTime = C5542d.m19099a();
            C5320a.m18133a(f22463a, "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(currentTime), (Object) requestId, Long.valueOf(C5542d.m19100a(startTime, currentTime)));
        }
    }

    /* renamed from: b */
    public boolean mo4116b(String id) {
        return C5320a.m18138a(2);
    }

    /* renamed from: a */
    private static long m19100a(@Nullable Long startTime, long endTime) {
        if (startTime != null) {
            return endTime - startTime.longValue();
        }
        return -1;
    }

    /* renamed from: a */
    private static long m19099a() {
        return SystemClock.uptimeMillis();
    }
}
