package com.p015a.p016a;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;

/* compiled from: ArrayTypeName */
/* renamed from: com.a.a.b */
public final class C0358b extends C0357l {
    /* renamed from: a */
    public final C0357l f1129a;

    /* renamed from: b */
    public /* synthetic */ C0357l mo1155b(List list) {
        return m1369a(list);
    }

    private C0358b(C0357l componentType) {
        this(componentType, new ArrayList());
    }

    private C0358b(C0357l componentType, List<C0356a> annotations) {
        super((List) annotations);
        this.f1129a = (C0357l) C0386o.m1661a((Object) componentType, "rawType == null", new Object[0]);
    }

    /* renamed from: a */
    public C0358b m1369a(List<C0356a> annotations) {
        return new C0358b(this.f1129a, m1357c(annotations));
    }

    /* renamed from: a */
    public C0357l mo1154a() {
        return new C0358b(this.f1129a);
    }

    /* renamed from: a */
    C0363e mo1153a(C0363e out) throws IOException {
        return out.m1419a("$T[]", this.f1129a);
    }

    /* renamed from: a */
    public static C0358b m1363a(C0357l componentType) {
        return new C0358b(componentType);
    }

    /* renamed from: a */
    public static C0358b m1366a(Type componentType) {
        return C0358b.m1363a(C0357l.m1351b(componentType));
    }

    /* renamed from: a */
    public static C0358b m1367a(ArrayType mirror) {
        return C0358b.m1368a(mirror, new LinkedHashMap());
    }

    /* renamed from: a */
    static C0358b m1368a(ArrayType mirror, Map<TypeParameterElement, C0385n> typeVariables) {
        return new C0358b(C0357l.m1347a(mirror.getComponentType(), (Map) typeVariables));
    }

    /* renamed from: a */
    public static C0358b m1364a(GenericArrayType type) {
        return C0358b.m1365a(type, new LinkedHashMap());
    }

    /* renamed from: a */
    static C0358b m1365a(GenericArrayType type, Map<Type, C0385n> map) {
        return C0358b.m1363a(C0357l.m1345a(type.getGenericComponentType(), (Map) map));
    }
}
