package com.facebook.imagepipeline.p150f;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: DefaultExecutorSupplier */
/* renamed from: com.facebook.imagepipeline.f.a */
public class C5498a implements C5497e {
    /* renamed from: a */
    private static final int f22342a = 2;
    /* renamed from: b */
    private static final int f22343b = 1;
    /* renamed from: c */
    private final Executor f22344c = Executors.newFixedThreadPool(2);
    /* renamed from: d */
    private final Executor f22345d;
    /* renamed from: e */
    private final Executor f22346e;
    /* renamed from: f */
    private final Executor f22347f;

    public C5498a(int numCpuBoundThreads) {
        ThreadFactory backgroundPriorityThreadFactory = new C5514k(10);
        this.f22345d = Executors.newFixedThreadPool(numCpuBoundThreads, backgroundPriorityThreadFactory);
        this.f22346e = Executors.newFixedThreadPool(numCpuBoundThreads, backgroundPriorityThreadFactory);
        this.f22347f = Executors.newFixedThreadPool(1, backgroundPriorityThreadFactory);
    }

    /* renamed from: a */
    public Executor mo4078a() {
        return this.f22344c;
    }

    /* renamed from: b */
    public Executor mo4079b() {
        return this.f22344c;
    }

    /* renamed from: c */
    public Executor mo4080c() {
        return this.f22345d;
    }

    /* renamed from: d */
    public Executor mo4081d() {
        return this.f22346e;
    }

    /* renamed from: e */
    public Executor mo4082e() {
        return this.f22347f;
    }
}
