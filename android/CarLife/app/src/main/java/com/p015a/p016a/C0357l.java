package com.p015a.p016a;

import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor7;

/* compiled from: TypeName */
/* renamed from: com.a.a.l */
public class C0357l {
    /* renamed from: a */
    private static final C0359c f1107a = C0359c.m1374a("java.lang", "Void", new String[0]);
    /* renamed from: b */
    private static final C0359c f1108b = C0359c.m1374a("java.lang", "Boolean", new String[0]);
    /* renamed from: c */
    private static final C0359c f1109c = C0359c.m1374a("java.lang", "Byte", new String[0]);
    /* renamed from: d */
    public static final C0357l f1110d = new C0357l("void");
    /* renamed from: e */
    public static final C0357l f1111e = new C0357l("boolean");
    /* renamed from: f */
    public static final C0357l f1112f = new C0357l("byte");
    /* renamed from: g */
    public static final C0357l f1113g = new C0357l("short");
    /* renamed from: h */
    public static final C0357l f1114h = new C0357l(Regular.TYPE_INT);
    /* renamed from: i */
    public static final C0357l f1115i = new C0357l(Regular.TYPE_LONG);
    /* renamed from: j */
    public static final C0357l f1116j = new C0357l("char");
    /* renamed from: k */
    public static final C0357l f1117k = new C0357l("float");
    /* renamed from: l */
    public static final C0357l f1118l = new C0357l(Regular.TYPE_DOUBLE);
    /* renamed from: m */
    public static final C0359c f1119m = C0359c.m1374a("java.lang", "Object", new String[0]);
    /* renamed from: o */
    private static final C0359c f1120o = C0359c.m1374a("java.lang", "Short", new String[0]);
    /* renamed from: p */
    private static final C0359c f1121p = C0359c.m1374a("java.lang", "Integer", new String[0]);
    /* renamed from: q */
    private static final C0359c f1122q = C0359c.m1374a("java.lang", "Long", new String[0]);
    /* renamed from: r */
    private static final C0359c f1123r = C0359c.m1374a("java.lang", "Character", new String[0]);
    /* renamed from: s */
    private static final C0359c f1124s = C0359c.m1374a("java.lang", "Float", new String[0]);
    /* renamed from: t */
    private static final C0359c f1125t = C0359c.m1374a("java.lang", "Double", new String[0]);
    /* renamed from: n */
    public final List<C0356a> f1126n;
    /* renamed from: u */
    private final String f1127u;
    /* renamed from: v */
    private String f1128v;

    /* compiled from: TypeName */
    /* renamed from: com.a.a.l$2 */
    static /* synthetic */ class C03802 {
        /* renamed from: a */
        static final /* synthetic */ int[] f1217a = new int[TypeKind.values().length];

        static {
            try {
                f1217a[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1217a[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1217a[TypeKind.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1217a[TypeKind.INT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1217a[TypeKind.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1217a[TypeKind.CHAR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1217a[TypeKind.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f1217a[TypeKind.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private C0357l(String keyword) {
        this(keyword, new ArrayList());
    }

    private C0357l(String keyword, List<C0356a> annotations) {
        this.f1127u = keyword;
        this.f1126n = C0386o.m1665a((Collection) annotations);
    }

    C0357l(List<C0356a> annotations) {
        this(null, annotations);
    }

    /* renamed from: a */
    public final C0357l m1354a(C0356a... annotations) {
        return mo1155b(Arrays.asList(annotations));
    }

    /* renamed from: b */
    public C0357l mo1155b(List<C0356a> annotations) {
        C0386o.m1661a((Object) annotations, "annotations == null", new Object[0]);
        return new C0357l(this.f1127u, m1357c(annotations));
    }

    /* renamed from: a */
    public C0357l mo1154a() {
        return new C0357l(this.f1127u);
    }

    /* renamed from: c */
    protected final List<C0356a> m1357c(List<C0356a> annotations) {
        List<C0356a> allAnnotations = new ArrayList(this.f1126n);
        allAnnotations.addAll(annotations);
        return allAnnotations;
    }

    /* renamed from: g */
    public boolean m1358g() {
        return !this.f1126n.isEmpty();
    }

    /* renamed from: h */
    public boolean m1359h() {
        return (this.f1127u == null || this == f1110d) ? false : true;
    }

    /* renamed from: i */
    public boolean m1360i() {
        return equals(f1108b) || equals(f1109c) || equals(f1120o) || equals(f1121p) || equals(f1122q) || equals(f1123r) || equals(f1124s) || equals(f1125t);
    }

    /* renamed from: j */
    public C0357l m1361j() {
        if (this.f1127u == null) {
            return this;
        }
        if (this == f1110d) {
            return f1107a;
        }
        if (this == f1111e) {
            return f1108b;
        }
        if (this == f1112f) {
            return f1109c;
        }
        if (this == f1113g) {
            return f1120o;
        }
        if (this == f1114h) {
            return f1121p;
        }
        if (this == f1115i) {
            return f1122q;
        }
        if (this == f1116j) {
            return f1123r;
        }
        if (this == f1117k) {
            return f1124s;
        }
        if (this == f1118l) {
            return f1125t;
        }
        throw new AssertionError(this.f1127u);
    }

    /* renamed from: k */
    public C0357l m1362k() {
        if (this.f1127u != null) {
            return this;
        }
        if (equals(f1107a)) {
            return f1110d;
        }
        if (equals(f1108b)) {
            return f1111e;
        }
        if (equals(f1109c)) {
            return f1112f;
        }
        if (equals(f1120o)) {
            return f1113g;
        }
        if (equals(f1121p)) {
            return f1114h;
        }
        if (equals(f1122q)) {
            return f1115i;
        }
        if (equals(f1123r)) {
            return f1116j;
        }
        if (equals(f1124s)) {
            return f1117k;
        }
        if (equals(f1125t)) {
            return f1118l;
        }
        throw new UnsupportedOperationException("cannot unbox " + this);
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return toString().equals(o.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        String result = this.f1128v;
        if (result != null) {
            return result;
        }
        try {
            StringBuilder resultBuilder = new StringBuilder();
            C0363e codeWriter = new C0363e(resultBuilder);
            m1355b(codeWriter);
            mo1153a(codeWriter);
            result = resultBuilder.toString();
            this.f1128v = result;
            return result;
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    C0363e mo1153a(C0363e out) throws IOException {
        if (this.f1127u != null) {
            return out.m1433c(this.f1127u);
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    C0363e m1355b(C0363e out) throws IOException {
        for (C0356a annotation : this.f1126n) {
            annotation.m1344a(out, true);
            out.m1429b(" ");
        }
        return out;
    }

    /* renamed from: a */
    public static C0357l m1346a(TypeMirror mirror) {
        return C0357l.m1347a(mirror, new LinkedHashMap());
    }

    /* renamed from: a */
    static C0357l m1347a(TypeMirror mirror, final Map<TypeParameterElement, C0385n> typeVariables) {
        return (C0357l) mirror.accept(new SimpleTypeVisitor7<C0357l, Void>() {
            /* renamed from: a */
            public C0357l m1573a(PrimitiveType t, Void p) {
                switch (C03802.f1217a[t.getKind().ordinal()]) {
                    case 1:
                        return C0357l.f1111e;
                    case 2:
                        return C0357l.f1112f;
                    case 3:
                        return C0357l.f1113g;
                    case 4:
                        return C0357l.f1114h;
                    case 5:
                        return C0357l.f1115i;
                    case 6:
                        return C0357l.f1116j;
                    case 7:
                        return C0357l.f1117k;
                    case 8:
                        return C0357l.f1118l;
                    default:
                        throw new AssertionError();
                }
            }

            /* renamed from: a */
            public C0357l m1570a(DeclaredType t, Void p) {
                C0357l enclosing;
                C0359c rawType = C0359c.m1375a((TypeElement) t.asElement());
                TypeMirror enclosingType = t.getEnclosingType();
                if (enclosingType.getKind() == TypeKind.NONE || t.asElement().getModifiers().contains(Modifier.STATIC)) {
                    enclosing = null;
                } else {
                    enclosing = (C0357l) enclosingType.accept(this, null);
                }
                if (t.getTypeArguments().isEmpty() && !(enclosing instanceof C0378k)) {
                    return rawType;
                }
                List typeArgumentNames = new ArrayList();
                for (TypeMirror mirror : t.getTypeArguments()) {
                    typeArgumentNames.add(C0357l.m1347a(mirror, typeVariables));
                }
                return enclosing instanceof C0378k ? ((C0378k) enclosing).m1565a(rawType.m1390f(), typeArgumentNames) : new C0378k(null, rawType, typeArgumentNames);
            }

            /* renamed from: a */
            public C0357l m1571a(ErrorType t, Void p) {
                return m1570a((DeclaredType) t, p);
            }

            /* renamed from: a */
            public C0358b m1569a(ArrayType t, Void p) {
                return C0358b.m1368a(t, typeVariables);
            }

            /* renamed from: a */
            public C0357l m1575a(TypeVariable t, Void p) {
                return C0385n.m1653a(t, typeVariables);
            }

            /* renamed from: a */
            public C0357l m1576a(WildcardType t, Void p) {
                return C0387p.m1677a(t, typeVariables);
            }

            /* renamed from: a */
            public C0357l m1572a(NoType t, Void p) {
                if (t.getKind() == TypeKind.VOID) {
                    return C0357l.f1110d;
                }
                return (C0357l) super.visitUnknown(t, p);
            }

            /* renamed from: a */
            protected C0357l m1574a(TypeMirror e, Void p) {
                throw new IllegalArgumentException("Unexpected type mirror: " + e);
            }
        }, null);
    }

    /* renamed from: b */
    public static C0357l m1351b(Type type) {
        return C0357l.m1345a(type, new LinkedHashMap());
    }

    /* renamed from: a */
    static C0357l m1345a(Type type, Map<Type, C0385n> map) {
        if (type instanceof Class) {
            Class classType = (Class) type;
            if (type == Void.TYPE) {
                return f1110d;
            }
            if (type == Boolean.TYPE) {
                return f1111e;
            }
            if (type == Byte.TYPE) {
                return f1112f;
            }
            if (type == Short.TYPE) {
                return f1113g;
            }
            if (type == Integer.TYPE) {
                return f1114h;
            }
            if (type == Long.TYPE) {
                return f1115i;
            }
            if (type == Character.TYPE) {
                return f1116j;
            }
            if (type == Float.TYPE) {
                return f1117k;
            }
            if (type == Double.TYPE) {
                return f1118l;
            }
            if (classType.isArray()) {
                return C0358b.m1363a(C0357l.m1345a(classType.getComponentType(), (Map) map));
            }
            return C0359c.m1373a(classType);
        } else if (type instanceof ParameterizedType) {
            return C0378k.m1562a((ParameterizedType) type, (Map) map);
        } else {
            if (type instanceof java.lang.reflect.WildcardType) {
                return C0387p.m1675a((java.lang.reflect.WildcardType) type, (Map) map);
            }
            if (type instanceof java.lang.reflect.TypeVariable) {
                return C0385n.m1650a((java.lang.reflect.TypeVariable) type, (Map) map);
            }
            if (type instanceof GenericArrayType) {
                return C0358b.m1365a((GenericArrayType) type, (Map) map);
            }
            throw new IllegalArgumentException("unexpected type: " + type);
        }
    }

    /* renamed from: a */
    static List<C0357l> m1348a(Type[] types) {
        return C0357l.m1349a(types, new LinkedHashMap());
    }

    /* renamed from: a */
    static List<C0357l> m1349a(Type[] types, Map<Type, C0385n> map) {
        List<C0357l> result = new ArrayList(types.length);
        for (Type type : types) {
            result.add(C0357l.m1345a(type, (Map) map));
        }
        return result;
    }

    /* renamed from: b */
    static C0357l m1350b(C0357l type) {
        return type instanceof C0358b ? ((C0358b) type).f1129a : null;
    }
}
