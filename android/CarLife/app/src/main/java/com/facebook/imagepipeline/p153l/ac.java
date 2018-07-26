package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.VisibleForTesting;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: MultiplexProducer */
/* renamed from: com.facebook.imagepipeline.l.ac */
public abstract class ac<K, T extends Closeable> implements ai<T> {
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: a */
    final Map<K, ac$a> f22496a = new HashMap();
    /* renamed from: b */
    private final ai<T> f22497b;

    /* renamed from: a */
    protected abstract T mo4137a(T t);

    /* renamed from: b */
    protected abstract K mo4138b(aj ajVar);

    protected ac(ai<T> inputProducer) {
        this.f22497b = inputProducer;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<T> consumer, aj context) {
        Object key = mo4138b(context);
        ac$a multiplexer;
        do {
            boolean createdNewMultiplexer = false;
            synchronized (this) {
                multiplexer = m19184a(key);
                if (multiplexer == null) {
                    multiplexer = m19188b(key);
                    createdNewMultiplexer = true;
                }
            }
        } while (!multiplexer.a(consumer, context));
        if (createdNewMultiplexer) {
            ac$a.a(multiplexer);
        }
    }

    /* renamed from: a */
    private synchronized ac$a m19184a(K key) {
        return (ac$a) this.f22496a.get(key);
    }

    /* renamed from: b */
    private synchronized ac$a m19188b(K key) {
        ac$a multiplexer;
        multiplexer = new ac$a(this, key);
        this.f22496a.put(key, multiplexer);
        return multiplexer;
    }

    /* renamed from: a */
    private synchronized void m19187a(K key, ac$a multiplexer) {
        if (this.f22496a.get(key) == multiplexer) {
            this.f22496a.remove(key);
        }
    }
}
