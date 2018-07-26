package com.p015a.p016a;

import com.p015a.p016a.C0362d.C0361a;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: FieldSpec */
/* renamed from: com.a.a.f */
public final class C0366f {
    /* renamed from: a */
    public final C0357l f1158a;
    /* renamed from: b */
    public final String f1159b;
    /* renamed from: c */
    public final C0362d f1160c;
    /* renamed from: d */
    public final List<C0356a> f1161d;
    /* renamed from: e */
    public final Set<Modifier> f1162e;
    /* renamed from: f */
    public final C0362d f1163f;

    /* compiled from: FieldSpec */
    /* renamed from: com.a.a.f$a */
    public static final class C0365a {
        /* renamed from: a */
        private final C0357l f1152a;
        /* renamed from: b */
        private final String f1153b;
        /* renamed from: c */
        private final C0361a f1154c;
        /* renamed from: d */
        private final List<C0356a> f1155d;
        /* renamed from: e */
        private final List<Modifier> f1156e;
        /* renamed from: f */
        private C0362d f1157f;

        private C0365a(C0357l type, String name) {
            this.f1154c = C0362d.m1406b();
            this.f1155d = new ArrayList();
            this.f1156e = new ArrayList();
            this.f1157f = null;
            this.f1152a = type;
            this.f1153b = name;
        }

        /* renamed from: a */
        public C0365a m1449a(String format, Object... args) {
            this.f1154c.m1397a(format, args);
            return this;
        }

        /* renamed from: a */
        public C0365a m1448a(Iterable<C0356a> annotationSpecs) {
            boolean z;
            if (annotationSpecs != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "annotationSpecs == null", new Object[0]);
            for (C0356a annotationSpec : annotationSpecs) {
                this.f1155d.add(annotationSpec);
            }
            return this;
        }

        /* renamed from: a */
        public C0365a m1444a(C0356a annotationSpec) {
            this.f1155d.add(annotationSpec);
            return this;
        }

        /* renamed from: a */
        public C0365a m1445a(C0359c annotation) {
            this.f1155d.add(C0356a.m1337a(annotation).m1326a());
            return this;
        }

        /* renamed from: a */
        public C0365a m1447a(Class<?> annotation) {
            return m1445a(C0359c.m1373a((Class) annotation));
        }

        /* renamed from: a */
        public C0365a m1450a(Modifier... modifiers) {
            Collections.addAll(this.f1156e, modifiers);
            return this;
        }

        /* renamed from: b */
        public C0365a m1452b(String format, Object... args) {
            return m1446a(C0362d.m1405a(format, args));
        }

        /* renamed from: a */
        public C0365a m1446a(C0362d codeBlock) {
            boolean z;
            if (this.f1157f == null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1672b(z, "initializer was already set", new Object[0]);
            this.f1157f = (C0362d) C0386o.m1661a((Object) codeBlock, "codeBlock == null", new Object[0]);
            return this;
        }

        /* renamed from: a */
        public C0366f m1451a() {
            return new C0366f();
        }
    }

    private C0366f(C0365a builder) {
        C0362d d;
        this.f1158a = (C0357l) C0386o.m1661a(builder.f1152a, "type == null", new Object[0]);
        this.f1159b = (String) C0386o.m1661a(builder.f1153b, "name == null", new Object[0]);
        this.f1160c = builder.f1154c.m1403d();
        this.f1161d = C0386o.m1665a(builder.f1155d);
        this.f1162e = C0386o.m1671b(builder.f1156e);
        if (builder.f1157f == null) {
            d = C0362d.m1406b().m1403d();
        } else {
            d = builder.f1157f;
        }
        this.f1163f = d;
    }

    /* renamed from: a */
    public boolean m1457a(Modifier modifier) {
        return this.f1162e.contains(modifier);
    }

    /* renamed from: a */
    void m1456a(C0363e codeWriter, Set<Modifier> implicitModifiers) throws IOException {
        codeWriter.m1430b(this.f1160c);
        codeWriter.m1424a(this.f1161d, false);
        codeWriter.m1426a(this.f1162e, (Set) implicitModifiers);
        codeWriter.m1419a("$T $L", this.f1158a, this.f1159b);
        if (!this.f1163f.m1407a()) {
            codeWriter.m1429b(" = ");
            codeWriter.m1432c(this.f1163f);
        }
        codeWriter.m1429b(";\n");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return toString().equals(o.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter out = new StringWriter();
        try {
            m1456a(new C0363e(out), Collections.emptySet());
            return out.toString();
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static C0365a m1453a(C0357l type, String name, Modifier... modifiers) {
        C0386o.m1661a((Object) type, "type == null", new Object[0]);
        C0386o.m1669a(SourceVersion.isName(name), "not a valid name: %s", name);
        return new C0365a(type, name).m1450a(modifiers);
    }

    /* renamed from: a */
    public static C0365a m1454a(Type type, String name, Modifier... modifiers) {
        return C0366f.m1453a(C0357l.m1351b(type), name, modifiers);
    }

    /* renamed from: a */
    public C0365a m1455a() {
        C0362d c0362d = null;
        C0365a builder = new C0365a(this.f1158a, this.f1159b);
        builder.f1154c.m1396a(this.f1160c);
        builder.f1155d.addAll(this.f1161d);
        builder.f1156e.addAll(this.f1162e);
        if (!this.f1163f.m1407a()) {
            c0362d = this.f1163f;
        }
        builder.f1157f = c0362d;
        return builder;
    }
}
