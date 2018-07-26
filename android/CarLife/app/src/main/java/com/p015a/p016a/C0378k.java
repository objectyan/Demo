package com.p015a.p016a;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ParameterizedTypeName */
/* renamed from: com.a.a.k */
public final class C0378k extends C0357l {
    /* renamed from: a */
    public final C0359c f1213a;
    /* renamed from: b */
    public final List<C0357l> f1214b;
    /* renamed from: c */
    private final C0378k f1215c;

    /* renamed from: b */
    public /* synthetic */ C0357l mo1155b(List list) {
        return m1566a(list);
    }

    C0378k(C0378k enclosingType, C0359c rawType, List<C0357l> typeArguments) {
        this(enclosingType, rawType, typeArguments, new ArrayList());
    }

    private C0378k(C0378k enclosingType, C0359c rawType, List<C0357l> typeArguments, List<C0356a> annotations) {
        boolean z;
        super((List) annotations);
        this.f1213a = (C0359c) C0386o.m1661a((Object) rawType, "rawType == null", new Object[0]);
        this.f1215c = enclosingType;
        this.f1214b = C0386o.m1665a((Collection) typeArguments);
        if (this.f1214b.isEmpty() && enclosingType == null) {
            z = false;
        } else {
            z = true;
        }
        C0386o.m1669a(z, "no type arguments: %s", rawType);
        for (C0357l typeArgument : this.f1214b) {
            if (typeArgument.m1359h() || typeArgument == d) {
                z = false;
            } else {
                z = true;
            }
            C0386o.m1669a(z, "invalid type parameter: %s", typeArgument);
        }
    }

    /* renamed from: a */
    public C0378k m1566a(List<C0356a> annotations) {
        return new C0378k(this.f1215c, this.f1213a, this.f1214b, m1357c(annotations));
    }

    /* renamed from: a */
    public C0357l mo1154a() {
        return new C0378k(this.f1215c, this.f1213a, this.f1214b, new ArrayList());
    }

    /* renamed from: a */
    C0363e mo1153a(C0363e out) throws IOException {
        if (this.f1215c != null) {
            this.f1215c.m1355b(out);
            this.f1215c.mo1153a(out);
            out.m1429b("." + this.f1213a.m1390f());
        } else {
            this.f1213a.m1355b(out);
            this.f1213a.mo1153a(out);
        }
        if (!this.f1214b.isEmpty()) {
            out.m1433c("<");
            boolean firstParameter = true;
            for (C0357l parameter : this.f1214b) {
                if (!firstParameter) {
                    out.m1433c(", ");
                }
                parameter.m1355b(out);
                parameter.mo1153a(out);
                firstParameter = false;
            }
            out.m1433c(">");
        }
        return out;
    }

    /* renamed from: a */
    public C0378k m1564a(String name) {
        C0386o.m1661a((Object) name, "name == null", new Object[0]);
        return new C0378k(this, this.f1213a.m1380a(name), new ArrayList(), new ArrayList());
    }

    /* renamed from: a */
    public C0378k m1565a(String name, List<C0357l> typeArguments) {
        C0386o.m1661a((Object) name, "name == null", new Object[0]);
        return new C0378k(this, this.f1213a.m1380a(name), typeArguments, new ArrayList());
    }

    /* renamed from: a */
    public static C0378k m1559a(C0359c rawType, C0357l... typeArguments) {
        return new C0378k(null, rawType, Arrays.asList(typeArguments));
    }

    /* renamed from: a */
    public static C0378k m1560a(Class<?> rawType, Type... typeArguments) {
        return new C0378k(null, C0359c.m1373a((Class) rawType), C0357l.m1348a(typeArguments));
    }

    /* renamed from: a */
    public static C0378k m1561a(ParameterizedType type) {
        return C0378k.m1562a(type, new LinkedHashMap());
    }

    /* renamed from: a */
    static C0378k m1562a(ParameterizedType type, Map<Type, C0385n> map) {
        ParameterizedType ownerType;
        C0359c rawType = C0359c.m1373a((Class) type.getRawType());
        if (!(type.getOwnerType() instanceof ParameterizedType) || Modifier.isStatic(((Class) type.getRawType()).getModifiers())) {
            ownerType = null;
        } else {
            ownerType = (ParameterizedType) type.getOwnerType();
        }
        List typeArguments = C0357l.m1349a(type.getActualTypeArguments(), (Map) map);
        return ownerType != null ? C0378k.m1562a(ownerType, (Map) map).m1565a(rawType.m1390f(), typeArguments) : new C0378k(null, rawType, typeArguments);
    }
}
