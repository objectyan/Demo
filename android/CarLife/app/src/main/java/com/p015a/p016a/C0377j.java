package com.p015a.p016a;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: ParameterSpec */
/* renamed from: com.a.a.j */
public final class C0377j {
    /* renamed from: a */
    public final String f1209a;
    /* renamed from: b */
    public final List<C0356a> f1210b;
    /* renamed from: c */
    public final Set<Modifier> f1211c;
    /* renamed from: d */
    public final C0357l f1212d;

    /* compiled from: ParameterSpec */
    /* renamed from: com.a.a.j$a */
    public static final class C0376a {
        /* renamed from: a */
        private final C0357l f1205a;
        /* renamed from: b */
        private final String f1206b;
        /* renamed from: c */
        private final List<C0356a> f1207c;
        /* renamed from: d */
        private final List<Modifier> f1208d;

        private C0376a(C0357l type, String name) {
            this.f1207c = new ArrayList();
            this.f1208d = new ArrayList();
            this.f1205a = type;
            this.f1206b = name;
        }

        /* renamed from: a */
        public C0376a m1550a(Iterable<C0356a> annotationSpecs) {
            boolean z;
            if (annotationSpecs != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "annotationSpecs == null", new Object[0]);
            for (C0356a annotationSpec : annotationSpecs) {
                this.f1207c.add(annotationSpec);
            }
            return this;
        }

        /* renamed from: a */
        public C0376a m1547a(C0356a annotationSpec) {
            this.f1207c.add(annotationSpec);
            return this;
        }

        /* renamed from: a */
        public C0376a m1548a(C0359c annotation) {
            this.f1207c.add(C0356a.m1337a(annotation).m1326a());
            return this;
        }

        /* renamed from: a */
        public C0376a m1549a(Class<?> annotation) {
            return m1548a(C0359c.m1373a((Class) annotation));
        }

        /* renamed from: a */
        public C0376a m1551a(Modifier... modifiers) {
            Collections.addAll(this.f1208d, modifiers);
            return this;
        }

        /* renamed from: a */
        public C0377j m1552a() {
            return new C0377j();
        }
    }

    private C0377j(C0376a builder) {
        this.f1209a = (String) C0386o.m1661a(builder.f1206b, "name == null", new Object[0]);
        this.f1210b = C0386o.m1665a(builder.f1207c);
        this.f1211c = C0386o.m1671b(builder.f1208d);
        this.f1212d = (C0357l) C0386o.m1661a(builder.f1205a, "type == null", new Object[0]);
    }

    /* renamed from: a */
    public boolean m1558a(Modifier modifier) {
        return this.f1211c.contains(modifier);
    }

    /* renamed from: a */
    void m1557a(C0363e codeWriter, boolean varargs) throws IOException {
        codeWriter.m1424a(this.f1210b, true);
        codeWriter.m1425a(this.f1211c);
        if (varargs) {
            codeWriter.m1419a("$T... $L", C0357l.m1350b(this.f1212d), this.f1209a);
            return;
        }
        codeWriter.m1419a("$T $L", this.f1212d, this.f1209a);
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
            m1557a(new C0363e(out), false);
            return out.toString();
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static C0376a m1553a(C0357l type, String name, Modifier... modifiers) {
        C0386o.m1661a((Object) type, "type == null", new Object[0]);
        C0386o.m1669a(SourceVersion.isName(name), "not a valid name: %s", name);
        return new C0376a(type, name).m1551a(modifiers);
    }

    /* renamed from: a */
    public static C0376a m1554a(Type type, String name, Modifier... modifiers) {
        return C0377j.m1553a(C0357l.m1351b(type), name, modifiers);
    }

    /* renamed from: a */
    public C0376a m1555a() {
        return m1556a(this.f1212d, this.f1209a);
    }

    /* renamed from: a */
    C0376a m1556a(C0357l type, String name) {
        C0376a builder = new C0376a(type, name);
        builder.f1207c.addAll(this.f1210b);
        builder.f1208d.addAll(this.f1211c);
        return builder;
    }
}
