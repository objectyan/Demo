package com.p015a.p016a;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;

/* compiled from: TypeVariableName */
/* renamed from: com.a.a.n */
public final class C0385n extends C0357l {
    /* renamed from: a */
    public final String f1259a;
    /* renamed from: b */
    public final List<C0357l> f1260b;

    /* renamed from: b */
    public /* synthetic */ C0357l mo1155b(List list) {
        return m1656a(list);
    }

    private C0385n(String name, List<C0357l> bounds) {
        this(name, bounds, new ArrayList());
    }

    private C0385n(String name, List<C0357l> bounds, List<C0356a> annotations) {
        super((List) annotations);
        this.f1259a = (String) C0386o.m1661a((Object) name, "name == null", new Object[0]);
        this.f1260b = bounds;
        for (C0357l bound : this.f1260b) {
            boolean z = (bound.m1359h() || bound == d) ? false : true;
            C0386o.m1669a(z, "invalid bound: %s", bound);
        }
    }

    /* renamed from: a */
    public C0385n m1656a(List<C0356a> annotations) {
        return new C0385n(this.f1259a, this.f1260b, annotations);
    }

    /* renamed from: a */
    public C0357l mo1154a() {
        return new C0385n(this.f1259a, this.f1260b);
    }

    /* renamed from: b */
    public C0385n m1659b(Type... bounds) {
        return m1660d(C0357l.m1348a(bounds));
    }

    /* renamed from: a */
    public C0385n m1657a(C0357l... bounds) {
        return m1660d(Arrays.asList(bounds));
    }

    /* renamed from: d */
    public C0385n m1660d(List<C0357l> bounds) {
        ArrayList<C0357l> newBounds = new ArrayList();
        newBounds.addAll(this.f1260b);
        newBounds.addAll(bounds);
        return new C0385n(this.f1259a, newBounds, this.n);
    }

    /* renamed from: a */
    private static C0385n m1646a(String name, List<C0357l> bounds) {
        List<C0357l> boundsNoObject = new ArrayList(bounds);
        boundsNoObject.remove(m);
        return new C0385n(name, Collections.unmodifiableList(boundsNoObject));
    }

    /* renamed from: a */
    C0363e mo1153a(C0363e out) throws IOException {
        return out.m1433c(this.f1259a);
    }

    /* renamed from: a */
    public static C0385n m1645a(String name) {
        return C0385n.m1646a(name, Collections.emptyList());
    }

    /* renamed from: a */
    public static C0385n m1647a(String name, C0357l... bounds) {
        return C0385n.m1646a(name, Arrays.asList(bounds));
    }

    /* renamed from: a */
    public static C0385n m1648a(String name, Type... bounds) {
        return C0385n.m1646a(name, C0357l.m1348a(bounds));
    }

    /* renamed from: a */
    public static C0385n m1652a(TypeVariable mirror) {
        return C0385n.m1651a((TypeParameterElement) mirror.asElement());
    }

    /* renamed from: a */
    static C0385n m1653a(TypeVariable mirror, Map<TypeParameterElement, C0385n> typeVariables) {
        TypeParameterElement element = (TypeParameterElement) mirror.asElement();
        C0385n typeVariableName = (C0385n) typeVariables.get(element);
        if (typeVariableName == null) {
            List<C0357l> bounds = new ArrayList();
            typeVariableName = new C0385n(element.getSimpleName().toString(), Collections.unmodifiableList(bounds));
            typeVariables.put(element, typeVariableName);
            for (TypeMirror typeMirror : element.getBounds()) {
                bounds.add(C0357l.m1347a(typeMirror, (Map) typeVariables));
            }
            bounds.remove(m);
        }
        return typeVariableName;
    }

    /* renamed from: a */
    public static C0385n m1651a(TypeParameterElement element) {
        String name = element.getSimpleName().toString();
        List<? extends TypeMirror> boundsMirrors = element.getBounds();
        List boundsTypeNames = new ArrayList();
        for (TypeMirror typeMirror : boundsMirrors) {
            boundsTypeNames.add(C0357l.m1346a(typeMirror));
        }
        return C0385n.m1646a(name, boundsTypeNames);
    }

    /* renamed from: a */
    public static C0385n m1649a(java.lang.reflect.TypeVariable<?> type) {
        return C0385n.m1650a((java.lang.reflect.TypeVariable) type, new LinkedHashMap());
    }

    /* renamed from: a */
    static C0385n m1650a(java.lang.reflect.TypeVariable<?> type, Map<Type, C0385n> map) {
        C0385n result = (C0385n) map.get(type);
        if (result == null) {
            List<C0357l> bounds = new ArrayList();
            result = new C0385n(type.getName(), Collections.unmodifiableList(bounds));
            map.put(type, result);
            for (Type bound : type.getBounds()) {
                bounds.add(C0357l.m1345a(bound, (Map) map));
            }
            bounds.remove(m);
        }
        return result;
    }
}
