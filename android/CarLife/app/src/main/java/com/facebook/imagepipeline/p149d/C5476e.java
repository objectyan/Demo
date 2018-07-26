package com.facebook.imagepipeline.p149d;

import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p257e.C5320a;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.memory.ac;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.p135b.p136a.C5247d;
import com.facebook.p135b.p136a.C5252j;
import com.facebook.p135b.p137b.C5281j;
import com.facebook.p252a.C5240a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.C0027j;

/* compiled from: BufferedDiskCache */
/* renamed from: com.facebook.imagepipeline.d.e */
public class C5476e {
    /* renamed from: a */
    private static final Class<?> f22288a = C5476e.class;
    /* renamed from: b */
    private final C5281j f22289b;
    /* renamed from: c */
    private final C5642z f22290c;
    /* renamed from: d */
    private final ac f22291d;
    /* renamed from: e */
    private final Executor f22292e;
    /* renamed from: f */
    private final Executor f22293f;
    /* renamed from: g */
    private final C5491u f22294g = C5491u.m18838a();
    /* renamed from: h */
    private final C5485n f22295h;

    /* compiled from: BufferedDiskCache */
    /* renamed from: com.facebook.imagepipeline.d.e$5 */
    class C54745 implements Callable<Void> {
        /* renamed from: a */
        final /* synthetic */ C5476e f22285a;

        C54745(C5476e this$0) {
            this.f22285a = this$0;
        }

        public /* synthetic */ Object call() throws Exception {
            return m18758a();
        }

        /* renamed from: a */
        public Void m18758a() throws Exception {
            this.f22285a.f22294g.m18843b();
            this.f22285a.f22289b.mo3979e();
            return null;
        }
    }

    public C5476e(C5281j fileCache, C5642z pooledByteBufferFactory, ac pooledByteStreams, Executor readExecutor, Executor writeExecutor, C5485n imageCacheStatsTracker) {
        this.f22289b = fileCache;
        this.f22290c = pooledByteBufferFactory;
        this.f22291d = pooledByteStreams;
        this.f22292e = readExecutor;
        this.f22293f = writeExecutor;
        this.f22295h = imageCacheStatsTracker;
    }

    /* renamed from: a */
    public boolean m18777a(C5247d key) {
        return this.f22294g.m18845c(key) || this.f22289b.mo3978d(key);
    }

    /* renamed from: b */
    public C0027j<Boolean> m18778b(C5247d key) {
        if (m18777a(key)) {
            return C0027j.a(Boolean.valueOf(true));
        }
        return m18771e(key);
    }

    /* renamed from: e */
    private C0027j<Boolean> m18771e(final C5247d key) {
        try {
            return C0027j.a(new Callable<Boolean>(this) {
                /* renamed from: b */
                final /* synthetic */ C5476e f22276b;

                public /* synthetic */ Object call() throws Exception {
                    return m18755a();
                }

                /* renamed from: a */
                public Boolean m18755a() throws Exception {
                    return Boolean.valueOf(this.f22276b.m18772f(key));
                }
            }, this.f22292e);
        } catch (Throwable exception) {
            C5320a.m18175d(f22288a, exception, "Failed to schedule disk-cache read for %s", key.toString());
            return C0027j.a(exception);
        }
    }

    /* renamed from: c */
    public boolean m18779c(C5247d key) {
        if (m18777a(key)) {
            return true;
        }
        return m18772f(key);
    }

    /* renamed from: a */
    public C0027j<C2952d> m18775a(C5247d key, AtomicBoolean isCancelled) {
        C2952d pinnedImage = this.f22294g.m18842b(key);
        if (pinnedImage != null) {
            return m18763b(key, pinnedImage);
        }
        return m18764b(key, isCancelled);
    }

    /* renamed from: f */
    private boolean m18772f(C5247d key) {
        C2952d result = this.f22294g.m18842b(key);
        if (result != null) {
            result.close();
            C5320a.m18123a(f22288a, "Found image for %s in staging area", key.toString());
            this.f22295h.mo4073g();
            return true;
        }
        C5320a.m18123a(f22288a, "Did not find image for %s in staging area", key.toString());
        this.f22295h.mo4074h();
        try {
            return this.f22289b.mo3980e(key);
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    private C0027j<C2952d> m18764b(final C5247d key, final AtomicBoolean isCancelled) {
        try {
            return C0027j.a(new Callable<C2952d>(this) {
                /* renamed from: c */
                final /* synthetic */ C5476e f22279c;

                public /* synthetic */ Object call() throws Exception {
                    return m18756a();
                }

                /* renamed from: a */
                public C2952d m18756a() throws Exception {
                    if (isCancelled.get()) {
                        throw new CancellationException();
                    }
                    C2952d result = this.f22279c.f22294g.m18842b(key);
                    if (result != null) {
                        C5320a.m18123a(C5476e.f22288a, "Found image for %s in staging area", key.toString());
                        this.f22279c.f22295h.mo4073g();
                    } else {
                        C5320a.m18123a(C5476e.f22288a, "Did not find image for %s in staging area", key.toString());
                        this.f22279c.f22295h.mo4074h();
                        C2921a<C5640y> ref;
                        try {
                            ref = C2921a.a(this.f22279c.m18773g(key));
                            C2952d result2 = new C2952d(ref);
                            try {
                                C2921a.c(ref);
                                result = result2;
                            } catch (Exception e) {
                                result = result2;
                                return null;
                            }
                        } catch (Exception e2) {
                            return null;
                        } catch (Throwable th) {
                            C2921a.c(ref);
                        }
                    }
                    if (!Thread.interrupted()) {
                        return result;
                    }
                    C5320a.m18122a(C5476e.f22288a, "Host thread was interrupted, decreasing reference count");
                    if (result != null) {
                        result.close();
                    }
                    throw new InterruptedException();
                }
            }, this.f22292e);
        } catch (Throwable exception) {
            C5320a.m18175d(f22288a, exception, "Failed to schedule disk-cache read for %s", key.toString());
            return C0027j.a(exception);
        }
    }

    /* renamed from: a */
    public void m18776a(final C5247d key, C2952d encodedImage) {
        C5350k.m18310a((Object) key);
        C5350k.m18315a(C2952d.e(encodedImage));
        this.f22294g.m18840a(key, encodedImage);
        final C2952d finalEncodedImage = C2952d.a(encodedImage);
        try {
            this.f22293f.execute(new Runnable(this) {
                /* renamed from: c */
                final /* synthetic */ C5476e f22282c;

                public void run() {
                    try {
                        this.f22282c.m18769c(key, finalEncodedImage);
                    } finally {
                        this.f22282c.f22294g.m18844b(key, finalEncodedImage);
                        C2952d.d(finalEncodedImage);
                    }
                }
            });
        } catch (Throwable exception) {
            C5320a.m18175d(f22288a, exception, "Failed to schedule disk-cache write for %s", key.toString());
            this.f22294g.m18844b(key, encodedImage);
            C2952d.d(finalEncodedImage);
        }
    }

    /* renamed from: d */
    public C0027j<Void> m18780d(final C5247d key) {
        C5350k.m18310a((Object) key);
        this.f22294g.m18841a(key);
        try {
            return C0027j.a(new Callable<Void>(this) {
                /* renamed from: b */
                final /* synthetic */ C5476e f22284b;

                public /* synthetic */ Object call() throws Exception {
                    return m18757a();
                }

                /* renamed from: a */
                public Void m18757a() throws Exception {
                    this.f22284b.f22294g.m18841a(key);
                    this.f22284b.f22289b.mo3976c(key);
                    return null;
                }
            }, this.f22293f);
        } catch (Throwable exception) {
            C5320a.m18175d(f22288a, exception, "Failed to schedule disk-cache remove for %s", key.toString());
            return C0027j.a(exception);
        }
    }

    /* renamed from: a */
    public C0027j<Void> m18774a() {
        this.f22294g.m18843b();
        try {
            return C0027j.a(new C54745(this), this.f22293f);
        } catch (Throwable exception) {
            C5320a.m18175d(f22288a, exception, "Failed to schedule disk-cache clear", new Object[0]);
            return C0027j.a(exception);
        }
    }

    /* renamed from: b */
    private C0027j<C2952d> m18763b(C5247d key, C2952d pinnedImage) {
        C5320a.m18123a(f22288a, "Found image for %s in staging area", key.toString());
        this.f22295h.mo4073g();
        return C0027j.a(pinnedImage);
    }

    /* renamed from: g */
    private C5640y m18773g(C5247d key) throws IOException {
        InputStream is;
        try {
            C5320a.m18123a(f22288a, "Disk cache read for %s", key.toString());
            C5240a diskCacheResource = this.f22289b.mo3971a(key);
            if (diskCacheResource == null) {
                C5320a.m18123a(f22288a, "Disk cache miss for %s", key.toString());
                this.f22295h.mo4076j();
                return null;
            }
            C5320a.m18123a(f22288a, "Found entry in disk cache for %s", key.toString());
            this.f22295h.mo4075i();
            is = diskCacheResource.mo3930a();
            C5640y byteBuffer = this.f22290c.mo4162b(is, (int) diskCacheResource.mo3932c());
            is.close();
            C5320a.m18123a(f22288a, "Successful read from disk cache for %s", key.toString());
            return byteBuffer;
        } catch (Throwable ioe) {
            C5320a.m18175d(f22288a, ioe, "Exception reading from cache for %s", key.toString());
            this.f22295h.mo4077k();
            throw ioe;
        } catch (Throwable th) {
            is.close();
        }
    }

    /* renamed from: c */
    private void m18769c(C5247d key, final C2952d encodedImage) {
        C5320a.m18123a(f22288a, "About to write to disk-cache for key %s", key.toString());
        try {
            this.f22289b.mo3972a(key, new C5252j(this) {
                /* renamed from: b */
                final /* synthetic */ C5476e f22287b;

                /* renamed from: a */
                public void mo3945a(OutputStream os) throws IOException {
                    this.f22287b.f22291d.m19482a(encodedImage.d(), os);
                }
            });
            C5320a.m18123a(f22288a, "Successful disk-cache write for key %s", key.toString());
        } catch (Throwable ioe) {
            C5320a.m18175d(f22288a, ioe, "Failed to write to disk-cache for key %s", key.toString());
        }
    }
}
