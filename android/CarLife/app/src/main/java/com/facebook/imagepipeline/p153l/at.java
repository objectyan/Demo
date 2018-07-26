package com.facebook.imagepipeline.p153l;

import android.util.Pair;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: ThrottlingProducer */
/* renamed from: com.facebook.imagepipeline.l.at */
public class at<T> implements ai<T> {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22559a = "ThrottlingProducer";
    /* renamed from: b */
    private final ai<T> f22560b;
    /* renamed from: c */
    private final int f22561c;
    @GuardedBy("this")
    /* renamed from: d */
    private int f22562d = 0;
    @GuardedBy("this")
    /* renamed from: e */
    private final ConcurrentLinkedQueue<Pair<C5517j<T>, aj>> f22563e = new ConcurrentLinkedQueue();
    /* renamed from: f */
    private final Executor f22564f;

    /* compiled from: ThrottlingProducer */
    /* renamed from: com.facebook.imagepipeline.l.at$a */
    private class C5570a extends C5549m<T, T> {
        /* renamed from: a */
        final /* synthetic */ at f22558a;

        private C5570a(at atVar, C5517j<T> consumer) {
            this.f22558a = atVar;
            super(consumer);
        }

        /* renamed from: a */
        protected void mo4091a(T newResult, boolean isLast) {
            m19142d().mo4087b(newResult, isLast);
            if (isLast) {
                m19264c();
            }
        }

        /* renamed from: a */
        protected void mo4092a(Throwable t) {
            m19142d().mo4088b(t);
            m19264c();
        }

        /* renamed from: a */
        protected void mo4089a() {
            m19142d().mo4085b();
            m19264c();
        }

        /* renamed from: c */
        private void m19264c() {
            synchronized (this.f22558a) {
                final Pair<C5517j<T>, aj> nextRequestPair = (Pair) this.f22558a.f22563e.poll();
                if (nextRequestPair == null) {
                    this.f22558a.f22562d = this.f22558a.f22562d - 1;
                }
            }
            if (nextRequestPair != null) {
                this.f22558a.f22564f.execute(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C5570a f22557b;

                    public void run() {
                        this.f22557b.f22558a.m19272b((C5517j) nextRequestPair.first, (aj) nextRequestPair.second);
                    }
                });
            }
        }
    }

    public at(int maxSimultaneousRequests, Executor executor, ai<T> inputProducer) {
        this.f22561c = maxSimultaneousRequests;
        this.f22564f = (Executor) C5350k.m18310a((Object) executor);
        this.f22560b = (ai) C5350k.m18310a((Object) inputProducer);
    }

    /* renamed from: a */
    public void mo4122a(C5517j<T> consumer, aj producerContext) {
        boolean delayRequest;
        producerContext.m19213c().mo4111a(producerContext.m19212b(), f22559a);
        synchronized (this) {
            if (this.f22562d >= this.f22561c) {
                this.f22563e.add(Pair.create(consumer, producerContext));
                delayRequest = true;
            } else {
                this.f22562d++;
                delayRequest = false;
            }
        }
        if (!delayRequest) {
            m19272b(consumer, producerContext);
        }
    }

    /* renamed from: b */
    void m19272b(C5517j<T> consumer, aj producerContext) {
        producerContext.m19213c().mo4114a(producerContext.m19212b(), f22559a, null);
        this.f22560b.mo4122a(new C5570a(consumer), producerContext);
    }
}
