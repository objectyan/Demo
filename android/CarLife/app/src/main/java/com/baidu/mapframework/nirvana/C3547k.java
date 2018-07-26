package com.baidu.mapframework.nirvana;

import java.util.LinkedList;

/* compiled from: QueueRunner */
/* renamed from: com.baidu.mapframework.nirvana.k */
public class C3547k {
    /* renamed from: a */
    private final C3538a f19180a;
    /* renamed from: b */
    private final LinkedList<Runnable> f19181b = new LinkedList();
    /* renamed from: c */
    private Runnable f19182c;

    /* compiled from: QueueRunner */
    /* renamed from: com.baidu.mapframework.nirvana.k$a */
    public interface C3538a {
        void execute(Runnable runnable);
    }

    public C3547k(C3538a executor) {
        this.f19180a = executor;
    }

    /* renamed from: a */
    public void m15189a(Runnable runnable) {
        synchronized (this) {
            if (this.f19182c == null) {
                this.f19182c = runnable;
                this.f19180a.execute(m15186b(runnable));
            } else {
                this.f19181b.addLast(runnable);
            }
        }
    }

    /* renamed from: a */
    public void m15188a() {
        synchronized (this) {
            this.f19182c = null;
            this.f19181b.clear();
        }
    }

    /* renamed from: b */
    private Runnable m15186b(final Runnable runnable) {
        return new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C3547k f19179b;

            public void run() {
                runnable.run();
                synchronized (this.f19179b) {
                    if (this.f19179b.f19181b.isEmpty()) {
                        this.f19179b.f19182c = null;
                    } else {
                        this.f19179b.f19182c = (Runnable) this.f19179b.f19181b.removeFirst();
                        this.f19179b.f19180a.execute(this.f19179b.m15186b(this.f19179b.f19182c));
                    }
                }
            }
        };
    }
}
