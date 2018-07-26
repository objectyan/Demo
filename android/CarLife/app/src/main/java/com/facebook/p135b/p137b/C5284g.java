package com.facebook.p135b.p137b;

import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p253d.C5314a;
import com.facebook.common.p253d.C5319c;
import com.facebook.common.p253d.C5319c.C5315a;
import com.facebook.common.p257e.C5320a;
import com.facebook.p135b.p136a.C5244a;
import com.facebook.p135b.p136a.C5244a.C5243a;
import com.facebook.p135b.p137b.C5266d.C5259c;
import com.facebook.p135b.p137b.C5266d.C5263d;
import com.facebook.p135b.p137b.C5266d.C5275a;
import com.facebook.p252a.C5240a;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/* compiled from: DynamicDefaultDiskStorage */
/* renamed from: com.facebook.b.b.g */
public class C5284g implements C5266d {
    /* renamed from: b */
    private static final Class<?> f21845b = C5284g.class;
    @VisibleForTesting
    /* renamed from: a */
    volatile g$a f21846a = new g$a(null, null);
    /* renamed from: c */
    private final int f21847c;
    /* renamed from: d */
    private final C5273m<File> f21848d;
    /* renamed from: e */
    private final String f21849e;
    /* renamed from: f */
    private final C5244a f21850f;

    public C5284g(int version, C5273m<File> baseDirectoryPathSupplier, String baseDirectoryName, C5244a cacheErrorLogger) {
        this.f21847c = version;
        this.f21850f = cacheErrorLogger;
        this.f21848d = baseDirectoryPathSupplier;
        this.f21849e = baseDirectoryName;
    }

    /* renamed from: a */
    public boolean mo3958a() {
        try {
            return m18017f().mo3958a();
        } catch (IOException e) {
            return false;
        }
    }

    /* renamed from: b */
    public String mo3961b() {
        try {
            return m18017f().mo3961b();
        } catch (IOException e) {
            return "";
        }
    }

    /* renamed from: b */
    public C5240a mo3960b(String resourceId, Object debugInfo) throws IOException {
        return m18017f().mo3960b(resourceId, debugInfo);
    }

    /* renamed from: c */
    public boolean mo3963c(String resourceId, Object debugInfo) throws IOException {
        return m18017f().mo3963c(resourceId, debugInfo);
    }

    /* renamed from: d */
    public boolean mo3965d(String resourceId, Object debugInfo) throws IOException {
        return m18017f().mo3965d(resourceId, debugInfo);
    }

    /* renamed from: c */
    public void mo3962c() {
        try {
            m18017f().mo3962c();
        } catch (Throwable ioe) {
            C5320a.m18181e(f21845b, "purgeUnexpectedResources", ioe);
        }
    }

    /* renamed from: a */
    public C5263d mo3957a(String resourceId, Object debugInfo) throws IOException {
        return m18017f().mo3957a(resourceId, debugInfo);
    }

    /* renamed from: g */
    public Collection<C5259c> mo3967g() throws IOException {
        return m18017f().mo3967g();
    }

    /* renamed from: a */
    public long mo3956a(C5259c entry) throws IOException {
        return m18017f().mo3956a(entry);
    }

    /* renamed from: b */
    public long mo3959b(String resourceId) throws IOException {
        return m18017f().mo3959b(resourceId);
    }

    /* renamed from: d */
    public void mo3964d() throws IOException {
        m18017f().mo3964d();
    }

    /* renamed from: e */
    public C5275a mo3966e() throws IOException {
        return m18017f().mo3966e();
    }

    @VisibleForTesting
    /* renamed from: f */
    synchronized C5266d m18017f() throws IOException {
        if (m18003i()) {
            m18019h();
            m18004j();
        }
        return (C5266d) C5350k.m18310a(this.f21846a.f12857a);
    }

    /* renamed from: i */
    private boolean m18003i() {
        g$a currentState = this.f21846a;
        return currentState.f12857a == null || currentState.f12858b == null || !currentState.f12858b.exists();
    }

    @VisibleForTesting
    /* renamed from: h */
    void m18019h() {
        if (this.f21846a.f12857a != null && this.f21846a.f12858b != null) {
            C5314a.m18115b(this.f21846a.f12858b);
        }
    }

    /* renamed from: j */
    private void m18004j() throws IOException {
        File rootDirectory = new File((File) this.f21848d.mo3969b(), this.f21849e);
        m18007a(rootDirectory);
        this.f21846a = new g$a(rootDirectory, new C5267a(rootDirectory, this.f21847c, this.f21850f));
    }

    @VisibleForTesting
    /* renamed from: a */
    void m18007a(File rootDirectory) throws IOException {
        try {
            C5319c.m18116a(rootDirectory);
            C5320a.m18141b(f21845b, "Created cache directory %s", rootDirectory.getAbsolutePath());
        } catch (C5315a cde) {
            this.f21850f.mo3937a(C5243a.WRITE_CREATE_DIR, f21845b, "createRootDirectoryIfNecessary", cde);
            throw cde;
        }
    }
}
