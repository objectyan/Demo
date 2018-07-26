package com.facebook.p135b.p137b;

import com.facebook.p135b.p136a.C5252j;
import com.facebook.p252a.C5240a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DiskStorage */
/* renamed from: com.facebook.b.b.d */
public interface C5266d {

    /* compiled from: DiskStorage */
    /* renamed from: com.facebook.b.b.d$c */
    public interface C5259c {
        /* renamed from: a */
        String mo3949a();

        /* renamed from: b */
        long mo3950b();

        /* renamed from: d */
        long mo3951d();

        /* renamed from: e */
        C5240a mo3952e();
    }

    /* compiled from: DiskStorage */
    /* renamed from: com.facebook.b.b.d$d */
    public interface C5263d {
        /* renamed from: a */
        C5240a mo3953a(Object obj) throws IOException;

        /* renamed from: a */
        void mo3954a(C5252j c5252j, Object obj) throws IOException;

        /* renamed from: a */
        boolean mo3955a();
    }

    /* compiled from: DiskStorage */
    /* renamed from: com.facebook.b.b.d$a */
    public static class C5275a {
        /* renamed from: a */
        public List<C5276b> f21807a = new ArrayList();
        /* renamed from: b */
        public Map<String, Integer> f21808b = new HashMap();
    }

    /* compiled from: DiskStorage */
    /* renamed from: com.facebook.b.b.d$b */
    public static class C5276b {
        /* renamed from: a */
        public final String f21809a;
        /* renamed from: b */
        public final String f21810b;
        /* renamed from: c */
        public final float f21811c;
        /* renamed from: d */
        public final String f21812d;

        protected C5276b(String path, String type, float size, String firstBits) {
            this.f21809a = path;
            this.f21810b = type;
            this.f21811c = size;
            this.f21812d = firstBits;
        }
    }

    /* renamed from: a */
    long mo3956a(C5259c c5259c) throws IOException;

    /* renamed from: a */
    C5263d mo3957a(String str, Object obj) throws IOException;

    /* renamed from: a */
    boolean mo3958a();

    /* renamed from: b */
    long mo3959b(String str) throws IOException;

    /* renamed from: b */
    C5240a mo3960b(String str, Object obj) throws IOException;

    /* renamed from: b */
    String mo3961b();

    /* renamed from: c */
    void mo3962c();

    /* renamed from: c */
    boolean mo3963c(String str, Object obj) throws IOException;

    /* renamed from: d */
    void mo3964d() throws IOException;

    /* renamed from: d */
    boolean mo3965d(String str, Object obj) throws IOException;

    /* renamed from: e */
    C5275a mo3966e() throws IOException;

    /* renamed from: g */
    Collection<C5259c> mo3967g() throws IOException;
}
