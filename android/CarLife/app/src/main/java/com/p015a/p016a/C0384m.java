package com.p015a.p016a;

import com.p015a.p016a.C0362d.C0361a;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

/* compiled from: TypeSpec */
/* renamed from: com.a.a.m */
public final class C0384m {
    /* renamed from: a */
    public final C0383b f1243a;
    /* renamed from: b */
    public final String f1244b;
    /* renamed from: c */
    public final C0362d f1245c;
    /* renamed from: d */
    public final C0362d f1246d;
    /* renamed from: e */
    public final List<C0356a> f1247e;
    /* renamed from: f */
    public final Set<Modifier> f1248f;
    /* renamed from: g */
    public final List<C0385n> f1249g;
    /* renamed from: h */
    public final C0357l f1250h;
    /* renamed from: i */
    public final List<C0357l> f1251i;
    /* renamed from: j */
    public final Map<String, C0384m> f1252j;
    /* renamed from: k */
    public final List<C0366f> f1253k;
    /* renamed from: l */
    public final C0362d f1254l;
    /* renamed from: m */
    public final C0362d f1255m;
    /* renamed from: n */
    public final List<C0373h> f1256n;
    /* renamed from: o */
    public final List<C0384m> f1257o;
    /* renamed from: p */
    public final List<Element> f1258p;

    /* compiled from: TypeSpec */
    /* renamed from: com.a.a.m$a */
    public static final class C0382a {
        /* renamed from: a */
        private final C0383b f1218a;
        /* renamed from: b */
        private final String f1219b;
        /* renamed from: c */
        private final C0362d f1220c;
        /* renamed from: d */
        private final C0361a f1221d;
        /* renamed from: e */
        private final List<C0356a> f1222e;
        /* renamed from: f */
        private final List<Modifier> f1223f;
        /* renamed from: g */
        private final List<C0385n> f1224g;
        /* renamed from: h */
        private C0357l f1225h;
        /* renamed from: i */
        private final List<C0357l> f1226i;
        /* renamed from: j */
        private final Map<String, C0384m> f1227j;
        /* renamed from: k */
        private final List<C0366f> f1228k;
        /* renamed from: l */
        private final C0361a f1229l;
        /* renamed from: m */
        private final C0361a f1230m;
        /* renamed from: n */
        private final List<C0373h> f1231n;
        /* renamed from: o */
        private final List<C0384m> f1232o;
        /* renamed from: p */
        private final List<Element> f1233p;

        private C0382a(C0383b kind, String name, C0362d anonymousTypeArguments) {
            boolean z;
            this.f1221d = C0362d.m1406b();
            this.f1222e = new ArrayList();
            this.f1223f = new ArrayList();
            this.f1224g = new ArrayList();
            this.f1225h = C0359c.f1130a;
            this.f1226i = new ArrayList();
            this.f1227j = new LinkedHashMap();
            this.f1228k = new ArrayList();
            this.f1229l = C0362d.m1406b();
            this.f1230m = C0362d.m1406b();
            this.f1231n = new ArrayList();
            this.f1232o = new ArrayList();
            this.f1233p = new ArrayList();
            if (name == null || SourceVersion.isName(name)) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "not a valid name: %s", name);
            this.f1218a = kind;
            this.f1219b = name;
            this.f1220c = anonymousTypeArguments;
        }

        /* renamed from: a */
        public C0382a m1615a(String format, Object... args) {
            this.f1221d.m1397a(format, args);
            return this;
        }

        /* renamed from: a */
        public C0382a m1612a(Iterable<C0356a> annotationSpecs) {
            boolean z;
            if (annotationSpecs != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "annotationSpecs == null", new Object[0]);
            for (C0356a annotationSpec : annotationSpecs) {
                this.f1222e.add(annotationSpec);
            }
            return this;
        }

        /* renamed from: a */
        public C0382a m1602a(C0356a annotationSpec) {
            this.f1222e.add(annotationSpec);
            return this;
        }

        /* renamed from: a */
        public C0382a m1603a(C0359c annotation) {
            return m1602a(C0356a.m1337a(annotation).m1326a());
        }

        /* renamed from: a */
        public C0382a m1611a(Class<?> annotation) {
            return m1603a(C0359c.m1373a((Class) annotation));
        }

        /* renamed from: a */
        public C0382a m1619a(Modifier... modifiers) {
            boolean z;
            if (this.f1220c == null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1672b(z, "forbidden on anonymous types.", new Object[0]);
            Collections.addAll(this.f1223f, modifiers);
            return this;
        }

        /* renamed from: b */
        public C0382a m1623b(Iterable<C0385n> typeVariables) {
            boolean z;
            boolean z2 = true;
            if (this.f1220c == null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1672b(z, "forbidden on anonymous types.", new Object[0]);
            if (typeVariables == null) {
                z2 = false;
            }
            C0386o.m1669a(z2, "typeVariables == null", new Object[0]);
            for (C0385n typeVariable : typeVariables) {
                this.f1224g.add(typeVariable);
            }
            return this;
        }

        /* renamed from: a */
        public C0382a m1610a(C0385n typeVariable) {
            boolean z;
            if (this.f1220c == null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1672b(z, "forbidden on anonymous types.", new Object[0]);
            this.f1224g.add(typeVariable);
            return this;
        }

        /* renamed from: a */
        public C0382a m1607a(C0357l superclass) {
            boolean z;
            boolean z2 = true;
            if (this.f1225h == C0359c.f1130a) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1672b(z, "superclass already set to " + this.f1225h, new Object[0]);
            if (superclass.m1359h()) {
                z2 = false;
            }
            C0386o.m1669a(z2, "superclass may not be a primitive", new Object[0]);
            this.f1225h = superclass;
            return this;
        }

        /* renamed from: a */
        public C0382a m1616a(Type superclass) {
            return m1607a(C0357l.m1351b(superclass));
        }

        /* renamed from: c */
        public C0382a m1625c(Iterable<? extends C0357l> superinterfaces) {
            boolean z;
            if (superinterfaces != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "superinterfaces == null", new Object[0]);
            for (C0357l superinterface : superinterfaces) {
                this.f1226i.add(superinterface);
            }
            return this;
        }

        /* renamed from: b */
        public C0382a m1622b(C0357l superinterface) {
            this.f1226i.add(superinterface);
            return this;
        }

        /* renamed from: b */
        public C0382a m1624b(Type superinterface) {
            return m1622b(C0357l.m1351b(superinterface));
        }

        /* renamed from: a */
        public C0382a m1613a(String name) {
            return m1614a(name, C0384m.m1635a("", new Object[0]).m1620a());
        }

        /* renamed from: a */
        public C0382a m1614a(String name, C0384m typeSpec) {
            boolean z;
            C0386o.m1672b(this.f1218a == C0383b.ENUM, "%s is not enum", this.f1219b);
            if (typeSpec.f1245c != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "enum constants must have anonymous type arguments", new Object[0]);
            C0386o.m1669a(SourceVersion.isName(name), "not a valid enum constant: %s", name);
            this.f1227j.put(name, typeSpec);
            return this;
        }

        /* renamed from: d */
        public C0382a m1626d(Iterable<C0366f> fieldSpecs) {
            boolean z;
            if (fieldSpecs != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "fieldSpecs == null", new Object[0]);
            for (C0366f fieldSpec : fieldSpecs) {
                m1605a(fieldSpec);
            }
            return this;
        }

        /* renamed from: a */
        public C0382a m1605a(C0366f fieldSpec) {
            C0386o.m1672b(this.f1218a != C0383b.ANNOTATION, "%s %s cannot have fields", this.f1218a, this.f1219b);
            if (this.f1218a == C0383b.INTERFACE) {
                C0386o.m1668a(fieldSpec.f1162e, Modifier.PUBLIC, Modifier.PRIVATE);
                C0386o.m1672b(fieldSpec.f1162e.containsAll(EnumSet.of(Modifier.STATIC, Modifier.FINAL)), "%s %s.%s requires modifiers %s", this.f1218a, this.f1219b, fieldSpec.f1159b, EnumSet.of(Modifier.STATIC, Modifier.FINAL));
            }
            this.f1228k.add(fieldSpec);
            return this;
        }

        /* renamed from: a */
        public C0382a m1608a(C0357l type, String name, Modifier... modifiers) {
            return m1605a(C0366f.m1453a(type, name, modifiers).m1451a());
        }

        /* renamed from: a */
        public C0382a m1617a(Type type, String name, Modifier... modifiers) {
            return m1608a(C0357l.m1351b(type), name, modifiers);
        }

        /* renamed from: a */
        public C0382a m1604a(C0362d block) {
            this.f1229l.m1399b("static", new Object[0]).m1396a(block).m1395a();
            return this;
        }

        /* renamed from: b */
        public C0382a m1621b(C0362d block) {
            if (this.f1218a == C0383b.CLASS || this.f1218a == C0383b.ENUM) {
                this.f1230m.m1397a("{\n", new Object[0]).m1398b().m1396a(block).m1400c().m1397a("}\n", new Object[0]);
                return this;
            }
            throw new UnsupportedOperationException(this.f1218a + " can't have initializer blocks");
        }

        /* renamed from: e */
        public C0382a m1627e(Iterable<C0373h> methodSpecs) {
            boolean z;
            if (methodSpecs != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "methodSpecs == null", new Object[0]);
            for (C0373h methodSpec : methodSpecs) {
                m1606a(methodSpec);
            }
            return this;
        }

        /* renamed from: a */
        public C0382a m1606a(C0373h methodSpec) {
            boolean z;
            if (this.f1218a == C0383b.INTERFACE) {
                C0386o.m1668a(methodSpec.f1195f, Modifier.ABSTRACT, Modifier.STATIC, C0386o.f1261a);
                C0386o.m1668a(methodSpec.f1195f, Modifier.PUBLIC, Modifier.PRIVATE);
            } else if (this.f1218a == C0383b.ANNOTATION) {
                C0386o.m1672b(methodSpec.f1195f.equals(this.f1218a.f1240f), "%s %s.%s requires modifiers %s", this.f1218a, this.f1219b, methodSpec.f1192c, this.f1218a.f1240f);
            }
            if (this.f1218a != C0383b.ANNOTATION) {
                if (methodSpec.f1202m == null) {
                    z = true;
                } else {
                    z = false;
                }
                C0386o.m1672b(z, "%s %s.%s cannot have a default value", this.f1218a, this.f1219b, methodSpec.f1192c);
            }
            if (this.f1218a != C0383b.INTERFACE) {
                if (C0386o.m1673c(methodSpec.f1195f)) {
                    z = false;
                } else {
                    z = true;
                }
                C0386o.m1672b(z, "%s %s.%s cannot be default", this.f1218a, this.f1219b, methodSpec.f1192c);
            }
            this.f1231n.add(methodSpec);
            return this;
        }

        /* renamed from: f */
        public C0382a m1628f(Iterable<C0384m> typeSpecs) {
            boolean z;
            if (typeSpecs != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "typeSpecs == null", new Object[0]);
            for (C0384m typeSpec : typeSpecs) {
                m1609a(typeSpec);
            }
            return this;
        }

        /* renamed from: a */
        public C0382a m1609a(C0384m typeSpec) {
            C0386o.m1669a(typeSpec.f1248f.containsAll(this.f1218a.f1241g), "%s %s.%s requires modifiers %s", this.f1218a, this.f1219b, typeSpec.f1244b, this.f1218a.f1241g);
            this.f1232o.add(typeSpec);
            return this;
        }

        /* renamed from: a */
        public C0382a m1618a(Element originatingElement) {
            this.f1233p.add(originatingElement);
            return this;
        }

        /* renamed from: a */
        public C0384m m1620a() {
            boolean z;
            boolean isAbstract;
            int i;
            boolean z2 = true;
            if (this.f1218a == C0383b.ENUM && this.f1227j.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            C0386o.m1669a(z, "at least one enum constant is required for %s", this.f1219b);
            if (this.f1223f.contains(Modifier.ABSTRACT) || this.f1218a != C0383b.CLASS) {
                isAbstract = true;
            } else {
                isAbstract = false;
            }
            for (C0373h methodSpec : this.f1231n) {
                if (isAbstract || !methodSpec.m1536a(Modifier.ABSTRACT)) {
                    z = true;
                } else {
                    z = false;
                }
                C0386o.m1669a(z, "non-abstract type %s cannot declare abstract method %s", this.f1219b, methodSpec.f1192c);
            }
            if (this.f1225h.equals(C0359c.f1130a)) {
                i = 0;
            } else {
                i = 1;
            }
            int interestingSupertypeCount = i + this.f1226i.size();
            if (this.f1220c != null && interestingSupertypeCount > 1) {
                z2 = false;
            }
            C0386o.m1669a(z2, "anonymous type has too many supertypes", new Object[0]);
            return new C0384m();
        }
    }

    /* compiled from: TypeSpec */
    /* renamed from: com.a.a.m$b */
    public enum C0383b {
        CLASS(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.emptySet()),
        INTERFACE(C0386o.m1671b(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL})), C0386o.m1671b(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.ABSTRACT})), C0386o.m1671b(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC})), C0386o.m1671b(Arrays.asList(new Modifier[]{Modifier.STATIC}))),
        ENUM(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.singleton(Modifier.STATIC)),
        ANNOTATION(C0386o.m1671b(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL})), C0386o.m1671b(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.ABSTRACT})), C0386o.m1671b(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC})), C0386o.m1671b(Arrays.asList(new Modifier[]{Modifier.STATIC})));
        
        /* renamed from: e */
        private final Set<Modifier> f1239e;
        /* renamed from: f */
        private final Set<Modifier> f1240f;
        /* renamed from: g */
        private final Set<Modifier> f1241g;
        /* renamed from: h */
        private final Set<Modifier> f1242h;

        private C0383b(Set<Modifier> implicitFieldModifiers, Set<Modifier> implicitMethodModifiers, Set<Modifier> implicitTypeModifiers, Set<Modifier> asMemberModifiers) {
            this.f1239e = implicitFieldModifiers;
            this.f1240f = implicitMethodModifiers;
            this.f1241g = implicitTypeModifiers;
            this.f1242h = asMemberModifiers;
        }
    }

    private C0384m(C0382a builder) {
        this.f1243a = builder.f1218a;
        this.f1244b = builder.f1219b;
        this.f1245c = builder.f1220c;
        this.f1246d = builder.f1221d.m1403d();
        this.f1247e = C0386o.m1665a(builder.f1222e);
        this.f1248f = C0386o.m1671b(builder.f1223f);
        this.f1249g = C0386o.m1665a(builder.f1224g);
        this.f1250h = builder.f1225h;
        this.f1251i = C0386o.m1665a(builder.f1226i);
        this.f1252j = C0386o.m1670b(builder.f1227j);
        this.f1253k = C0386o.m1665a(builder.f1228k);
        this.f1254l = builder.f1229l.m1403d();
        this.f1255m = builder.f1230m.m1403d();
        this.f1256n = C0386o.m1665a(builder.f1231n);
        this.f1257o = C0386o.m1665a(builder.f1232o);
        Collection originatingElementsMutable = new ArrayList();
        originatingElementsMutable.addAll(builder.f1233p);
        for (C0384m typeSpec : builder.f1232o) {
            originatingElementsMutable.addAll(typeSpec.f1258p);
        }
        this.f1258p = C0386o.m1665a(originatingElementsMutable);
    }

    /* renamed from: a */
    public boolean m1644a(Modifier modifier) {
        return this.f1248f.contains(modifier);
    }

    /* renamed from: a */
    public static C0382a m1634a(String name) {
        return new C0382a(C0383b.CLASS, (String) C0386o.m1661a((Object) name, "name == null", new Object[0]), null);
    }

    /* renamed from: a */
    public static C0382a m1633a(C0359c className) {
        return C0384m.m1634a(((C0359c) C0386o.m1661a((Object) className, "className == null", new Object[0])).m1390f());
    }

    /* renamed from: b */
    public static C0382a m1637b(String name) {
        return new C0382a(C0383b.INTERFACE, (String) C0386o.m1661a((Object) name, "name == null", new Object[0]), null);
    }

    /* renamed from: b */
    public static C0382a m1636b(C0359c className) {
        return C0384m.m1637b(((C0359c) C0386o.m1661a((Object) className, "className == null", new Object[0])).m1390f());
    }

    /* renamed from: c */
    public static C0382a m1639c(String name) {
        return new C0382a(C0383b.ENUM, (String) C0386o.m1661a((Object) name, "name == null", new Object[0]), null);
    }

    /* renamed from: c */
    public static C0382a m1638c(C0359c className) {
        return C0384m.m1639c(((C0359c) C0386o.m1661a((Object) className, "className == null", new Object[0])).m1390f());
    }

    /* renamed from: a */
    public static C0382a m1635a(String typeArgumentsFormat, Object... args) {
        return new C0382a(C0383b.CLASS, null, C0362d.m1406b().m1397a(typeArgumentsFormat, args).m1403d());
    }

    /* renamed from: d */
    public static C0382a m1641d(String name) {
        return new C0382a(C0383b.ANNOTATION, (String) C0386o.m1661a((Object) name, "name == null", new Object[0]), null);
    }

    /* renamed from: d */
    public static C0382a m1640d(C0359c className) {
        return C0384m.m1641d(((C0359c) C0386o.m1661a((Object) className, "className == null", new Object[0])).m1390f());
    }

    /* renamed from: a */
    public C0382a m1642a() {
        C0382a builder = new C0382a(this.f1243a, this.f1244b, this.f1245c);
        builder.f1221d.m1396a(this.f1246d);
        builder.f1222e.addAll(this.f1247e);
        builder.f1223f.addAll(this.f1248f);
        builder.f1224g.addAll(this.f1249g);
        builder.f1225h = this.f1250h;
        builder.f1226i.addAll(this.f1251i);
        builder.f1227j.putAll(this.f1252j);
        builder.f1228k.addAll(this.f1253k);
        builder.f1231n.addAll(this.f1256n);
        builder.f1232o.addAll(this.f1257o);
        builder.f1230m.m1396a(this.f1255m);
        builder.f1229l.m1396a(this.f1254l);
        return builder;
    }

    /* renamed from: a */
    void m1643a(C0363e codeWriter, String enumName, Set<Modifier> implicitModifiers) throws IOException {
        int previousStatementLine = codeWriter.f1138a;
        codeWriter.f1138a = -1;
        if (enumName != null) {
            try {
                codeWriter.m1430b(this.f1246d);
                codeWriter.m1424a(this.f1247e, false);
                codeWriter.m1419a("$L", enumName);
                if (!this.f1245c.f1135a.isEmpty()) {
                    codeWriter.m1429b("(");
                    codeWriter.m1432c(this.f1245c);
                    codeWriter.m1429b(")");
                }
                if (!this.f1253k.isEmpty() || !this.f1256n.isEmpty() || !this.f1257o.isEmpty()) {
                    codeWriter.m1429b(" {\n");
                } else {
                    return;
                }
            } finally {
                codeWriter.f1138a = previousStatementLine;
            }
        } else if (this.f1245c != null) {
            C0357l supertype = !this.f1251i.isEmpty() ? (C0357l) this.f1251i.get(0) : this.f1250h;
            codeWriter.m1419a("new $T(", supertype);
            codeWriter.m1432c(this.f1245c);
            codeWriter.m1429b(") {\n");
        } else {
            List<C0357l> extendsTypes;
            List<C0357l> implementsTypes;
            boolean firstType;
            codeWriter.m1430b(this.f1246d);
            codeWriter.m1424a(this.f1247e, false);
            codeWriter.m1426a(this.f1248f, C0386o.m1667a((Set) implicitModifiers, this.f1243a.f1242h));
            if (this.f1243a == C0383b.ANNOTATION) {
                codeWriter.m1419a("$L $L", "@interface", this.f1244b);
            } else {
                codeWriter.m1419a("$L $L", this.f1243a.name().toLowerCase(Locale.US), this.f1244b);
            }
            codeWriter.m1423a(this.f1249g);
            if (this.f1243a == C0383b.INTERFACE) {
                extendsTypes = this.f1251i;
                implementsTypes = Collections.emptyList();
            } else {
                if (this.f1250h.equals(C0359c.f1130a)) {
                    extendsTypes = Collections.emptyList();
                } else {
                    extendsTypes = Collections.singletonList(this.f1250h);
                }
                implementsTypes = this.f1251i;
            }
            if (!extendsTypes.isEmpty()) {
                codeWriter.m1429b(" extends");
                firstType = true;
                for (C0357l type : extendsTypes) {
                    if (!firstType) {
                        codeWriter.m1429b(",");
                    }
                    codeWriter.m1419a(" $T", (Object[]) new Object[]{type});
                    firstType = false;
                }
            }
            if (!implementsTypes.isEmpty()) {
                codeWriter.m1429b(" implements");
                firstType = true;
                for (C0357l type2 : implementsTypes) {
                    if (!firstType) {
                        codeWriter.m1429b(",");
                    }
                    codeWriter.m1419a(" $T", (Object[]) new Object[]{type2});
                    firstType = false;
                }
            }
            codeWriter.m1429b(" {\n");
        }
        codeWriter.m1417a(this);
        codeWriter.m1427b();
        boolean firstMember = true;
        Iterator<Entry<String, C0384m>> i = this.f1252j.entrySet().iterator();
        while (i.hasNext()) {
            Entry<String, C0384m> enumConstant = (Entry) i.next();
            if (!firstMember) {
                codeWriter.m1429b("\n");
            }
            ((C0384m) enumConstant.getValue()).m1643a(codeWriter, (String) enumConstant.getKey(), Collections.emptySet());
            firstMember = false;
            if (i.hasNext()) {
                codeWriter.m1429b(",\n");
            } else if (this.f1253k.isEmpty() && this.f1256n.isEmpty() && this.f1257o.isEmpty()) {
                codeWriter.m1429b("\n");
            } else {
                codeWriter.m1429b(";\n");
            }
        }
        for (C0366f fieldSpec : this.f1253k) {
            if (fieldSpec.m1457a(Modifier.STATIC)) {
                if (!firstMember) {
                    codeWriter.m1429b("\n");
                }
                fieldSpec.m1456a(codeWriter, this.f1243a.f1239e);
                firstMember = false;
            }
        }
        if (!this.f1254l.m1407a()) {
            if (!firstMember) {
                codeWriter.m1429b("\n");
            }
            codeWriter.m1432c(this.f1254l);
            firstMember = false;
        }
        for (C0366f fieldSpec2 : this.f1253k) {
            if (!fieldSpec2.m1457a(Modifier.STATIC)) {
                if (!firstMember) {
                    codeWriter.m1429b("\n");
                }
                fieldSpec2.m1456a(codeWriter, this.f1243a.f1239e);
                firstMember = false;
            }
        }
        if (!this.f1255m.m1407a()) {
            if (!firstMember) {
                codeWriter.m1429b("\n");
            }
            codeWriter.m1432c(this.f1255m);
            firstMember = false;
        }
        for (C0373h methodSpec : this.f1256n) {
            if (methodSpec.m1535a()) {
                if (!firstMember) {
                    codeWriter.m1429b("\n");
                }
                methodSpec.m1534a(codeWriter, this.f1244b, this.f1243a.f1240f);
                firstMember = false;
            }
        }
        for (C0373h methodSpec2 : this.f1256n) {
            if (!methodSpec2.m1535a()) {
                if (!firstMember) {
                    codeWriter.m1429b("\n");
                }
                methodSpec2.m1534a(codeWriter, this.f1244b, this.f1243a.f1240f);
                firstMember = false;
            }
        }
        for (C0384m typeSpec : this.f1257o) {
            if (!firstMember) {
                codeWriter.m1429b("\n");
            }
            typeSpec.m1643a(codeWriter, null, this.f1243a.f1241g);
            firstMember = false;
        }
        codeWriter.m1431c();
        codeWriter.m1435e();
        codeWriter.m1429b("}");
        if (enumName == null && this.f1245c == null) {
            codeWriter.m1429b("\n");
        }
        codeWriter.f1138a = previousStatementLine;
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
            m1643a(new C0363e(out), null, Collections.emptySet());
            return out.toString();
        } catch (IOException e) {
            throw new AssertionError();
        }
    }
}
