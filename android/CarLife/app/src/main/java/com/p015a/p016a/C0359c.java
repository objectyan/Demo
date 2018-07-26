package com.p015a.p016a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/* compiled from: ClassName */
/* renamed from: com.a.a.c */
public final class C0359c extends C0357l implements Comparable<C0359c> {
    /* renamed from: a */
    public static final C0359c f1130a = C0359c.m1373a(Object.class);
    /* renamed from: b */
    final List<String> f1131b;
    /* renamed from: c */
    final String f1132c;

    /* renamed from: b */
    public /* synthetic */ C0357l mo1155b(List list) {
        return m1381a(list);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m1379a((C0359c) obj);
    }

    private C0359c(List<String> names) {
        this(names, new ArrayList());
    }

    private C0359c(List<String> names, List<C0356a> annotations) {
        String a;
        super((List) annotations);
        for (int i = 1; i < names.size(); i++) {
            C0386o.m1669a(SourceVersion.isName((CharSequence) names.get(i)), "part '%s' is keyword", names.get(i));
        }
        this.f1131b = C0386o.m1665a((Collection) names);
        if (((String) names.get(0)).isEmpty()) {
            a = C0386o.m1664a(".", names.subList(1, names.size()));
        } else {
            a = C0386o.m1664a(".", (List) names);
        }
        this.f1132c = a;
    }

    /* renamed from: a */
    public C0359c m1381a(List<C0356a> annotations) {
        return new C0359c(this.f1131b, m1357c(annotations));
    }

    /* renamed from: a */
    public C0357l mo1154a() {
        return new C0359c(this.f1131b);
    }

    /* renamed from: b */
    public String m1386b() {
        return (String) this.f1131b.get(0);
    }

    /* renamed from: c */
    public C0359c m1387c() {
        if (this.f1131b.size() == 2) {
            return null;
        }
        return new C0359c(this.f1131b.subList(0, this.f1131b.size() - 1));
    }

    /* renamed from: d */
    public C0359c m1388d() {
        return new C0359c(this.f1131b.subList(0, 2));
    }

    /* renamed from: a */
    public C0359c m1380a(String name) {
        C0386o.m1661a((Object) name, "name == null", new Object[0]);
        List<String> result = new ArrayList(this.f1131b.size() + 1);
        result.addAll(this.f1131b);
        result.add(name);
        return new C0359c(result);
    }

    /* renamed from: e */
    public List<String> m1389e() {
        return this.f1131b.subList(1, this.f1131b.size());
    }

    /* renamed from: b */
    public C0359c m1384b(String name) {
        List<String> result = new ArrayList(this.f1131b);
        result.set(result.size() - 1, name);
        return new C0359c(result);
    }

    /* renamed from: f */
    public String m1390f() {
        return (String) this.f1131b.get(this.f1131b.size() - 1);
    }

    /* renamed from: a */
    public static C0359c m1373a(Class<?> clazz) {
        boolean z;
        boolean z2 = true;
        C0386o.m1661a((Object) clazz, "clazz == null", new Object[0]);
        if (clazz.isPrimitive()) {
            z = false;
        } else {
            z = true;
        }
        C0386o.m1669a(z, "primitive types cannot be represented as a ClassName", new Object[0]);
        if (Void.TYPE.equals(clazz)) {
            z = false;
        } else {
            z = true;
        }
        C0386o.m1669a(z, "'void' type cannot be represented as a ClassName", new Object[0]);
        if (clazz.isArray()) {
            z2 = false;
        }
        C0386o.m1669a(z2, "array types cannot be represented as a ClassName", new Object[0]);
        List<String> names = new ArrayList();
        while (true) {
            names.add(clazz.getSimpleName());
            Class<?> enclosing = clazz.getEnclosingClass();
            if (enclosing == null) {
                break;
            }
            clazz = enclosing;
        }
        int lastDot = clazz.getName().lastIndexOf(46);
        if (lastDot != -1) {
            names.add(clazz.getName().substring(0, lastDot));
        }
        Collections.reverse(names);
        return new C0359c(names);
    }

    /* renamed from: c */
    public static C0359c m1378c(String classNameString) {
        boolean z;
        List<String> names = new ArrayList();
        int p = 0;
        while (p < classNameString.length() && Character.isLowerCase(classNameString.codePointAt(p))) {
            p = classNameString.indexOf(46, p) + 1;
            C0386o.m1669a(p != 0, "couldn't make a guess for %s", classNameString);
        }
        names.add(p != 0 ? classNameString.substring(0, p - 1) : "");
        for (String part : classNameString.substring(p).split("\\.", -1)) {
            if (part.isEmpty() || !Character.isUpperCase(part.codePointAt(0))) {
                z = false;
            } else {
                z = true;
            }
            C0386o.m1669a(z, "couldn't make a guess for %s", classNameString);
            names.add(part);
        }
        if (names.size() >= 2) {
            z = true;
        } else {
            z = false;
        }
        C0386o.m1669a(z, "couldn't make a guess for %s", classNameString);
        return new C0359c(names);
    }

    /* renamed from: a */
    public static C0359c m1374a(String packageName, String simpleName, String... simpleNames) {
        List<String> result = new ArrayList();
        result.add(packageName);
        result.add(simpleName);
        Collections.addAll(result, simpleNames);
        return new C0359c(result);
    }

    /* renamed from: a */
    public static C0359c m1375a(TypeElement element) {
        C0386o.m1661a((Object) element, "element == null", new Object[0]);
        List<String> names = new ArrayList();
        for (Element e = element; C0359c.m1376a(e); e = e.getEnclosingElement()) {
            boolean z;
            if (element.getNestingKind() == NestingKind.TOP_LEVEL || element.getNestingKind() == NestingKind.MEMBER) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "unexpected type testing", new Object[0]);
            names.add(e.getSimpleName().toString());
        }
        names.add(C0359c.m1377b((Element) element).getQualifiedName().toString());
        Collections.reverse(names);
        return new C0359c(names);
    }

    /* renamed from: a */
    private static boolean m1376a(Element e) {
        return e.getKind().isClass() || e.getKind().isInterface();
    }

    /* renamed from: b */
    private static PackageElement m1377b(Element type) {
        while (type.getKind() != ElementKind.PACKAGE) {
            type = type.getEnclosingElement();
        }
        return (PackageElement) type;
    }

    /* renamed from: a */
    public int m1379a(C0359c o) {
        return this.f1132c.compareTo(o.f1132c);
    }

    /* renamed from: a */
    C0363e mo1153a(C0363e out) throws IOException {
        return out.m1433c(out.m1420a(this));
    }
}
