package com.facebook.p252a;

import com.facebook.common.internal.C5344e;
import com.facebook.common.internal.C5350k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileBinaryResource */
/* renamed from: com.facebook.a.c */
public class C5242c implements C5240a {
    /* renamed from: a */
    private final File f21737a;

    private C5242c(File file) {
        this.f21737a = (File) C5350k.m18310a((Object) file);
    }

    /* renamed from: d */
    public File m17829d() {
        return this.f21737a;
    }

    /* renamed from: a */
    public InputStream mo3930a() throws IOException {
        return new FileInputStream(this.f21737a);
    }

    /* renamed from: c */
    public long mo3932c() {
        return this.f21737a.length();
    }

    /* renamed from: b */
    public byte[] mo3931b() throws IOException {
        return C5344e.m18277a(this.f21737a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C5242c)) {
            return false;
        }
        return this.f21737a.equals(((C5242c) obj).f21737a);
    }

    public int hashCode() {
        return this.f21737a.hashCode();
    }

    /* renamed from: a */
    public static C5242c m17825a(File file) {
        return file != null ? new C5242c(file) : null;
    }
}
