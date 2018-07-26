package com.p015a.p016a;

import com.p015a.p016a.C0362d.C0361a;
import com.p015a.p016a.C0377j.C0376a;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Types;

/* compiled from: MethodSpec */
/* renamed from: com.a.a.h */
public final class C0373h {
    /* renamed from: a */
    static final String f1190a = "<init>";
    /* renamed from: b */
    static final C0359c f1191b = C0359c.m1373a(Override.class);
    /* renamed from: c */
    public final String f1192c;
    /* renamed from: d */
    public final C0362d f1193d;
    /* renamed from: e */
    public final List<C0356a> f1194e;
    /* renamed from: f */
    public final Set<Modifier> f1195f;
    /* renamed from: g */
    public final List<C0385n> f1196g;
    /* renamed from: h */
    public final C0357l f1197h;
    /* renamed from: i */
    public final List<C0377j> f1198i;
    /* renamed from: j */
    public final boolean f1199j;
    /* renamed from: k */
    public final List<C0357l> f1200k;
    /* renamed from: l */
    public final C0362d f1201l;
    /* renamed from: m */
    public final C0362d f1202m;

    /* compiled from: MethodSpec */
    /* renamed from: com.a.a.h$a */
    public static final class C0372a {
        /* renamed from: a */
        private final String f1179a;
        /* renamed from: b */
        private final C0361a f1180b;
        /* renamed from: c */
        private final List<C0356a> f1181c;
        /* renamed from: d */
        private final List<Modifier> f1182d;
        /* renamed from: e */
        private List<C0385n> f1183e;
        /* renamed from: f */
        private C0357l f1184f;
        /* renamed from: g */
        private final List<C0377j> f1185g;
        /* renamed from: h */
        private final Set<C0357l> f1186h;
        /* renamed from: i */
        private final C0361a f1187i;
        /* renamed from: j */
        private boolean f1188j;
        /* renamed from: k */
        private C0362d f1189k;

        private C0372a(String name) {
            boolean z;
            this.f1180b = C0362d.m1406b();
            this.f1181c = new ArrayList();
            this.f1182d = new ArrayList();
            this.f1183e = new ArrayList();
            this.f1185g = new ArrayList();
            this.f1186h = new LinkedHashSet();
            this.f1187i = C0362d.m1406b();
            if (name.equals(C0373h.f1190a) || SourceVersion.isName(name)) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "not a valid name: %s", name);
            this.f1179a = name;
            this.f1184f = name.equals(C0373h.f1190a) ? null : C0357l.f1110d;
        }

        /* renamed from: a */
        public C0372a m1509a(String format, Object... args) {
            this.f1180b.m1397a(format, args);
            return this;
        }

        /* renamed from: a */
        public C0372a m1508a(Iterable<C0356a> annotationSpecs) {
            boolean z;
            if (annotationSpecs != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "annotationSpecs == null", new Object[0]);
            for (C0356a annotationSpec : annotationSpecs) {
                this.f1181c.add(annotationSpec);
            }
            return this;
        }

        /* renamed from: a */
        public C0372a m1500a(C0356a annotationSpec) {
            this.f1181c.add(annotationSpec);
            return this;
        }

        /* renamed from: a */
        public C0372a m1501a(C0359c annotation) {
            this.f1181c.add(C0356a.m1337a(annotation).m1326a());
            return this;
        }

        /* renamed from: a */
        public C0372a m1507a(Class<?> annotation) {
            return m1501a(C0359c.m1373a((Class) annotation));
        }

        /* renamed from: a */
        public C0372a m1513a(Modifier... modifiers) {
            Collections.addAll(this.f1182d, modifiers);
            return this;
        }

        /* renamed from: b */
        public C0372a m1517b(Iterable<Modifier> modifiers) {
            C0386o.m1661a((Object) modifiers, "modifiers == null", new Object[0]);
            for (Modifier modifier : modifiers) {
                this.f1182d.add(modifier);
            }
            return this;
        }

        /* renamed from: c */
        public C0372a m1520c(Iterable<C0385n> typeVariables) {
            boolean z;
            if (typeVariables != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "typeVariables == null", new Object[0]);
            for (C0385n typeVariable : typeVariables) {
                this.f1183e.add(typeVariable);
            }
            return this;
        }

        /* renamed from: a */
        public C0372a m1506a(C0385n typeVariable) {
            this.f1183e.add(typeVariable);
            return this;
        }

        /* renamed from: a */
        public C0372a m1504a(C0357l returnType) {
            boolean z;
            if (this.f1179a.equals(C0373h.f1190a)) {
                z = false;
            } else {
                z = true;
            }
            C0386o.m1672b(z, "constructor cannot have return type.", new Object[0]);
            this.f1184f = returnType;
            return this;
        }

        /* renamed from: a */
        public C0372a m1510a(Type returnType) {
            return m1504a(C0357l.m1351b(returnType));
        }

        /* renamed from: d */
        public C0372a m1523d(Iterable<C0377j> parameterSpecs) {
            boolean z;
            if (parameterSpecs != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "parameterSpecs == null", new Object[0]);
            for (C0377j parameterSpec : parameterSpecs) {
                this.f1185g.add(parameterSpec);
            }
            return this;
        }

        /* renamed from: a */
        public C0372a m1503a(C0377j parameterSpec) {
            this.f1185g.add(parameterSpec);
            return this;
        }

        /* renamed from: a */
        public C0372a m1505a(C0357l type, String name, Modifier... modifiers) {
            return m1503a(C0377j.m1553a(type, name, modifiers).m1552a());
        }

        /* renamed from: a */
        public C0372a m1511a(Type type, String name, Modifier... modifiers) {
            return m1505a(C0357l.m1351b(type), name, modifiers);
        }

        /* renamed from: a */
        public C0372a m1499a() {
            return m1512a(true);
        }

        /* renamed from: a */
        public C0372a m1512a(boolean varargs) {
            this.f1188j = varargs;
            return this;
        }

        /* renamed from: e */
        public C0372a m1525e(Iterable<? extends C0357l> exceptions) {
            boolean z;
            if (exceptions != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "exceptions == null", new Object[0]);
            for (C0357l exception : exceptions) {
                this.f1186h.add(exception);
            }
            return this;
        }

        /* renamed from: b */
        public C0372a m1516b(C0357l exception) {
            this.f1186h.add(exception);
            return this;
        }

        /* renamed from: b */
        public C0372a m1519b(Type exception) {
            return m1516b(C0357l.m1351b(exception));
        }

        /* renamed from: b */
        public C0372a m1518b(String format, Object... args) {
            this.f1187i.m1397a(format, args);
            return this;
        }

        /* renamed from: a */
        public C0372a m1502a(C0362d codeBlock) {
            this.f1187i.m1396a(codeBlock);
            return this;
        }

        /* renamed from: c */
        public C0372a m1521c(String format, Object... args) {
            return m1515b(C0362d.m1405a(format, args));
        }

        /* renamed from: b */
        public C0372a m1515b(C0362d codeBlock) {
            boolean z;
            if (this.f1189k == null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1672b(z, "defaultValue was already set", new Object[0]);
            this.f1189k = (C0362d) C0386o.m1661a((Object) codeBlock, "codeBlock == null", new Object[0]);
            return this;
        }

        /* renamed from: d */
        public C0372a m1524d(String controlFlow, Object... args) {
            this.f1187i.m1399b(controlFlow, args);
            return this;
        }

        /* renamed from: e */
        public C0372a m1526e(String controlFlow, Object... args) {
            this.f1187i.m1401c(controlFlow, args);
            return this;
        }

        /* renamed from: b */
        public C0372a m1514b() {
            this.f1187i.m1395a();
            return this;
        }

        /* renamed from: f */
        public C0372a m1527f(String controlFlow, Object... args) {
            this.f1187i.m1402d(controlFlow, args);
            return this;
        }

        /* renamed from: g */
        public C0372a m1528g(String format, Object... args) {
            this.f1187i.m1404e(format, args);
            return this;
        }

        /* renamed from: c */
        public C0373h m1522c() {
            return new C0373h();
        }
    }

    private C0373h(C0372a builder) {
        C0362d code = builder.f1187i.m1403d();
        boolean z = code.m1407a() || !builder.f1182d.contains(Modifier.ABSTRACT);
        C0386o.m1669a(z, "abstract method %s cannot have code", builder.f1179a);
        if (!builder.f1188j || m1532a(builder.f1185g)) {
            z = true;
        } else {
            z = false;
        }
        C0386o.m1669a(z, "last parameter of varargs method %s must be an array", builder.f1179a);
        this.f1192c = (String) C0386o.m1661a(builder.f1179a, "name == null", new Object[0]);
        this.f1193d = builder.f1180b.m1403d();
        this.f1194e = C0386o.m1665a(builder.f1181c);
        this.f1195f = C0386o.m1671b(builder.f1182d);
        this.f1196g = C0386o.m1665a(builder.f1183e);
        this.f1197h = builder.f1184f;
        this.f1198i = C0386o.m1665a(builder.f1185g);
        this.f1199j = builder.f1188j;
        this.f1200k = C0386o.m1665a(builder.f1186h);
        this.f1202m = builder.f1189k;
        this.f1201l = code;
    }

    /* renamed from: a */
    private boolean m1532a(List<C0377j> parameters) {
        return (parameters.isEmpty() || C0357l.m1350b(((C0377j) parameters.get(parameters.size() - 1)).f1212d) == null) ? false : true;
    }

    /* renamed from: a */
    void m1534a(C0363e codeWriter, String enclosingName, Set<Modifier> implicitModifiers) throws IOException {
        codeWriter.m1430b(this.f1193d);
        codeWriter.m1424a(this.f1194e, false);
        codeWriter.m1426a(this.f1195f, (Set) implicitModifiers);
        if (!this.f1196g.isEmpty()) {
            codeWriter.m1423a(this.f1196g);
            codeWriter.m1429b(" ");
        }
        if (m1535a()) {
            codeWriter.m1419a("$L(", enclosingName);
        } else {
            codeWriter.m1419a("$T $L(", this.f1197h, this.f1192c);
        }
        boolean firstParameter = true;
        Iterator<C0377j> i = this.f1198i.iterator();
        while (i.hasNext()) {
            boolean z;
            C0377j parameter = (C0377j) i.next();
            if (!firstParameter) {
                codeWriter.m1429b(", ");
            }
            if (i.hasNext() || !this.f1199j) {
                z = false;
            } else {
                z = true;
            }
            parameter.m1557a(codeWriter, z);
            firstParameter = false;
        }
        codeWriter.m1429b(")");
        if (!(this.f1202m == null || this.f1202m.m1407a())) {
            codeWriter.m1429b(" default ");
            codeWriter.m1432c(this.f1202m);
        }
        if (!this.f1200k.isEmpty()) {
            codeWriter.m1429b(" throws");
            boolean firstException = true;
            for (C0357l exception : this.f1200k) {
                if (!firstException) {
                    codeWriter.m1429b(",");
                }
                codeWriter.m1419a(" $T", exception);
                firstException = false;
            }
        }
        if (m1536a(Modifier.ABSTRACT)) {
            codeWriter.m1429b(";\n");
        } else if (m1536a(Modifier.NATIVE)) {
            codeWriter.m1432c(this.f1201l);
            codeWriter.m1429b(";\n");
        } else {
            codeWriter.m1429b(" {\n");
            codeWriter.m1427b();
            codeWriter.m1432c(this.f1201l);
            codeWriter.m1431c();
            codeWriter.m1429b("}\n");
        }
    }

    /* renamed from: a */
    public boolean m1536a(Modifier modifier) {
        return this.f1195f.contains(modifier);
    }

    /* renamed from: a */
    public boolean m1535a() {
        return this.f1192c.equals(f1190a);
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
            m1534a(new C0363e(out), "Constructor", Collections.emptySet());
            return out.toString();
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static C0372a m1529a(String name) {
        return new C0372a(name);
    }

    /* renamed from: b */
    public static C0372a m1533b() {
        return new C0372a(f1190a);
    }

    /* renamed from: a */
    public static C0372a m1530a(ExecutableElement method) {
        C0386o.m1661a((Object) method, "method == null", new Object[0]);
        Set<Modifier> modifiers = method.getModifiers();
        if (modifiers.contains(Modifier.PRIVATE) || modifiers.contains(Modifier.FINAL) || modifiers.contains(Modifier.STATIC)) {
            throw new IllegalArgumentException("cannot override method with modifiers: " + modifiers);
        }
        C0372a methodBuilder = C0373h.m1529a(method.getSimpleName().toString());
        methodBuilder.m1501a(f1191b);
        for (AnnotationMirror mirror : method.getAnnotationMirrors()) {
            C0356a annotationSpec = C0356a.m1341a(mirror);
            if (!annotationSpec.f1105a.equals(f1191b)) {
                methodBuilder.m1500a(annotationSpec);
            }
        }
        Iterable modifiers2 = new LinkedHashSet(modifiers);
        modifiers2.remove(Modifier.ABSTRACT);
        methodBuilder.m1517b(modifiers2);
        for (TypeParameterElement typeParameterElement : method.getTypeParameters()) {
            methodBuilder.m1506a(C0385n.m1652a((TypeVariable) typeParameterElement.asType()));
        }
        methodBuilder.m1504a(C0357l.m1346a(method.getReturnType()));
        for (VariableElement parameter : method.getParameters()) {
            C0357l type = C0357l.m1346a(parameter.asType());
            String name = parameter.getSimpleName().toString();
            Set<Modifier> parameterModifiers = parameter.getModifiers();
            C0376a parameterBuilder = C0377j.m1553a(type, name, new Modifier[0]).m1551a((Modifier[]) parameterModifiers.toArray(new Modifier[parameterModifiers.size()]));
            for (AnnotationMirror mirror2 : parameter.getAnnotationMirrors()) {
                parameterBuilder.m1547a(C0356a.m1341a(mirror2));
            }
            methodBuilder.m1503a(parameterBuilder.m1552a());
        }
        methodBuilder.m1512a(method.isVarArgs());
        for (TypeMirror thrownType : method.getThrownTypes()) {
            methodBuilder.m1516b(C0357l.m1346a(thrownType));
        }
        return methodBuilder;
    }

    /* renamed from: a */
    public static C0372a m1531a(ExecutableElement method, DeclaredType enclosing, Types types) {
        ExecutableType executableType = (ExecutableType) types.asMemberOf(enclosing, method);
        List<? extends TypeMirror> resolvedParameterTypes = executableType.getParameterTypes();
        TypeMirror resolvedReturnType = executableType.getReturnType();
        C0372a builder = C0373h.m1530a(method);
        builder.m1504a(C0357l.m1346a(resolvedReturnType));
        int size = builder.f1185g.size();
        for (int i = 0; i < size; i++) {
            C0377j parameter = (C0377j) builder.f1185g.get(i);
            builder.f1185g.set(i, parameter.m1556a(C0357l.m1346a((TypeMirror) resolvedParameterTypes.get(i)), parameter.f1209a).m1552a());
        }
        return builder;
    }

    /* renamed from: c */
    public C0372a m1537c() {
        C0372a builder = new C0372a(this.f1192c);
        builder.f1180b.m1396a(this.f1193d);
        builder.f1181c.addAll(this.f1194e);
        builder.f1182d.addAll(this.f1195f);
        builder.f1183e.addAll(this.f1196g);
        builder.f1184f = this.f1197h;
        builder.f1185g.addAll(this.f1198i);
        builder.f1186h.addAll(this.f1200k);
        builder.f1187i.m1396a(this.f1201l);
        builder.f1188j = this.f1199j;
        builder.f1189k = this.f1202m;
        return builder;
    }
}
