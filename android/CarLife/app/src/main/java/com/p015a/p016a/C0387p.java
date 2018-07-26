package com.p015a.p016a;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.WildcardType;

/* compiled from: WildcardTypeName */
/* renamed from: com.a.a.p */
public final class C0387p extends C0357l {
    /* renamed from: a */
    public final List<C0357l> f1262a;
    /* renamed from: b */
    public final List<C0357l> f1263b;

    /* renamed from: b */
    public /* synthetic */ C0357l mo1155b(List list) {
        return m1684a(list);
    }

    private C0387p(List<C0357l> upperBounds, List<C0357l> lowerBounds) {
        this(upperBounds, lowerBounds, new ArrayList());
    }

    private C0387p(List<C0357l> upperBounds, List<C0357l> lowerBounds, List<C0356a> annotations) {
        boolean z;
        super((List) annotations);
        this.f1262a = C0386o.m1665a((Collection) upperBounds);
        this.f1263b = C0386o.m1665a((Collection) lowerBounds);
        if (this.f1262a.size() == 1) {
            z = true;
        } else {
            z = false;
        }
        C0386o.m1669a(z, "unexpected extends bounds: %s", upperBounds);
        for (C0357l upperBound : this.f1262a) {
            if (upperBound.m1359h() || upperBound == d) {
                z = false;
            } else {
                z = true;
            }
            C0386o.m1669a(z, "invalid upper bound: %s", upperBound);
        }
        for (C0357l lowerBound : this.f1263b) {
            z = (lowerBound.m1359h() || lowerBound == d) ? false : true;
            C0386o.m1669a(z, "invalid lower bound: %s", lowerBound);
        }
    }

    /* renamed from: a */
    public C0387p m1684a(List<C0356a> annotations) {
        return new C0387p(this.f1262a, this.f1263b, m1357c(annotations));
    }

    /* renamed from: a */
    public C0357l mo1154a() {
        return new C0387p(this.f1262a, this.f1263b);
    }

    /* renamed from: a */
    C0363e mo1153a(C0363e out) throws IOException {
        if (this.f1263b.size() == 1) {
            return out.m1419a("? super $T", this.f1263b.get(0));
        } else if (((C0357l) this.f1262a.get(0)).equals(C0357l.f1119m)) {
            return out.m1429b("?");
        } else {
            return out.m1419a("? extends $T", this.f1262a.get(0));
        }
    }

    /* renamed from: a */
    public static C0387p m1678a(C0357l upperBound) {
        return new C0387p(Arrays.asList(new C0357l[]{upperBound}), Collections.emptyList());
    }

    /* renamed from: a */
    public static C0387p m1679a(Type upperBound) {
        return C0387p.m1678a(C0357l.m1351b(upperBound));
    }

    /* renamed from: c */
    public static C0387p m1680c(C0357l lowerBound) {
        return new C0387p(Arrays.asList(new C0357l[]{m}), Arrays.asList(new C0357l[]{lowerBound}));
    }

    /* renamed from: c */
    public static C0387p m1681c(Type lowerBound) {
        return C0387p.m1680c(C0357l.m1351b(lowerBound));
    }

    /* renamed from: a */
    public static C0357l m1676a(WildcardType mirror) {
        return C0387p.m1677a(mirror, new LinkedHashMap());
    }

    /* renamed from: a */
    static C0357l m1677a(WildcardType mirror, Map<TypeParameterElement, C0385n> typeVariables) {
        TypeMirror extendsBound = mirror.getExtendsBound();
        if (extendsBound != null) {
            return C0387p.m1678a(C0357l.m1347a(extendsBound, (Map) typeVariables));
        }
        TypeMirror superBound = mirror.getSuperBound();
        if (superBound == null) {
            return C0387p.m1679a((Type) Object.class);
        }
        return C0387p.m1680c(C0357l.m1347a(superBound, (Map) typeVariables));
    }

    /* renamed from: a */
    public static C0357l m1674a(java.lang.reflect.WildcardType wildcardName) {
        return C0387p.m1675a(wildcardName, new LinkedHashMap());
    }

    /* renamed from: a */
    static C0357l m1675a(java.lang.reflect.WildcardType wildcardName, Map<Type, C0385n> map) {
        return new C0387p(C0357l.m1349a(wildcardName.getUpperBounds(), (Map) map), C0357l.m1349a(wildcardName.getLowerBounds(), (Map) map));
    }
}
