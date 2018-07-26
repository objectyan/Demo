package com.p015a.p016a;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

/* compiled from: AnnotationSpec */
/* renamed from: com.a.a.a */
public final class C0356a {
    /* renamed from: a */
    public final C0357l f1105a;
    /* renamed from: b */
    public final Map<String, List<C0362d>> f1106b;

    /* compiled from: AnnotationSpec */
    /* renamed from: com.a.a.a$1 */
    static class C03531 implements Comparator<Method> {
        C03531() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1320a((Method) obj, (Method) obj2);
        }

        /* renamed from: a */
        public int m1320a(Method m1, Method m2) {
            return m1.getName().compareTo(m2.getName());
        }
    }

    /* compiled from: AnnotationSpec */
    /* renamed from: com.a.a.a$a */
    public static final class C0354a {
        /* renamed from: a */
        private final C0357l f1102a;
        /* renamed from: b */
        private final Map<String, List<C0362d>> f1103b;

        private C0354a(C0357l type) {
            this.f1103b = new LinkedHashMap();
            this.f1102a = type;
        }

        /* renamed from: a */
        public C0354a m1325a(String name, String format, Object... args) {
            return m1323a(name, C0362d.m1405a(format, args));
        }

        /* renamed from: a */
        public C0354a m1323a(String name, C0362d codeBlock) {
            List<C0362d> values = (List) this.f1103b.get(name);
            if (values == null) {
                values = new ArrayList();
                this.f1103b.put(name, values);
            }
            values.add(codeBlock);
            return this;
        }

        /* renamed from: a */
        C0354a m1324a(String memberName, Object value) {
            C0386o.m1661a((Object) memberName, "memberName == null", new Object[0]);
            C0386o.m1661a(value, "value == null, constant non-null value expected for %s", memberName);
            if (value instanceof Class) {
                return m1325a(memberName, "$T.class", value);
            } else if (value instanceof Enum) {
                return m1325a(memberName, "$T.$L", value.getClass(), ((Enum) value).name());
            } else if (value instanceof String) {
                return m1325a(memberName, "$S", value);
            } else if (value instanceof Float) {
                return m1325a(memberName, "$Lf", value);
            } else if (value instanceof Character) {
                return m1325a(memberName, "'$L'", C0386o.m1662a(((Character) value).charValue()));
            } else {
                return m1325a(memberName, "$L", value);
            }
        }

        /* renamed from: a */
        public C0356a m1326a() {
            return new C0356a();
        }
    }

    /* compiled from: AnnotationSpec */
    /* renamed from: com.a.a.a$b */
    private static class C0355b extends SimpleAnnotationValueVisitor7<C0354a, String> {
        /* renamed from: a */
        final C0354a f1104a;

        C0355b(C0354a builder) {
            super(builder);
            this.f1104a = builder;
        }

        /* renamed from: a */
        protected C0354a m1327a(Object o, String name) {
            return this.f1104a.m1324a(name, o);
        }

        /* renamed from: a */
        public C0354a m1329a(AnnotationMirror a, String name) {
            return this.f1104a.m1325a(name, "$L", C0356a.m1341a(a));
        }

        /* renamed from: a */
        public C0354a m1330a(VariableElement c, String name) {
            return this.f1104a.m1325a(name, "$T.$L", c.asType(), c.getSimpleName());
        }

        /* renamed from: a */
        public C0354a m1331a(TypeMirror t, String name) {
            return this.f1104a.m1325a(name, "$T.class", t);
        }

        /* renamed from: a */
        public C0354a m1328a(List<? extends AnnotationValue> values, String name) {
            for (AnnotationValue value : values) {
                value.accept(this, name);
            }
            return this.f1104a;
        }
    }

    private C0356a(C0354a builder) {
        this.f1105a = builder.f1102a;
        this.f1106b = C0386o.m1666a(builder.f1103b);
    }

    /* renamed from: a */
    void m1344a(C0363e codeWriter, boolean inline) throws IOException {
        String whitespace = inline ? "" : "\n";
        String memberSeparator = inline ? ", " : ",\n";
        if (this.f1106b.isEmpty()) {
            codeWriter.m1419a("@$T", this.f1105a);
        } else if (this.f1106b.size() == 1 && this.f1106b.containsKey("value")) {
            codeWriter.m1419a("@$T(", this.f1105a);
            m1342a(codeWriter, whitespace, memberSeparator, (List) this.f1106b.get("value"));
            codeWriter.m1429b(")");
        } else {
            codeWriter.m1419a("@$T(" + whitespace, this.f1105a);
            codeWriter.m1416a(2);
            Iterator<Entry<String, List<C0362d>>> i = this.f1106b.entrySet().iterator();
            while (i.hasNext()) {
                codeWriter.m1419a("$L = ", ((Entry) i.next()).getKey());
                m1342a(codeWriter, whitespace, memberSeparator, (List) entry.getValue());
                if (i.hasNext()) {
                    codeWriter.m1429b(memberSeparator);
                }
            }
            codeWriter.m1428b(2);
            codeWriter.m1429b(whitespace + ")");
        }
    }

    /* renamed from: a */
    private void m1342a(C0363e codeWriter, String whitespace, String memberSeparator, List<C0362d> values) throws IOException {
        if (values.size() == 1) {
            codeWriter.m1416a(2);
            codeWriter.m1432c((C0362d) values.get(0));
            codeWriter.m1428b(2);
            return;
        }
        codeWriter.m1429b("{" + whitespace);
        codeWriter.m1416a(2);
        boolean first = true;
        for (C0362d codeBlock : values) {
            if (!first) {
                codeWriter.m1429b(memberSeparator);
            }
            codeWriter.m1432c(codeBlock);
            first = false;
        }
        codeWriter.m1428b(2);
        codeWriter.m1429b(whitespace + "}");
    }

    /* renamed from: a */
    public static C0356a m1339a(Annotation annotation) {
        return C0356a.m1340a(annotation, false);
    }

    /* renamed from: a */
    public static C0356a m1340a(Annotation annotation, boolean includeDefaultValues) {
        C0354a builder = C0356a.m1338a(annotation.annotationType());
        try {
            Method[] methods = annotation.annotationType().getDeclaredMethods();
            Arrays.sort(methods, new C03531());
            for (Method method : methods) {
                Object value = method.invoke(annotation, new Object[0]);
                if (includeDefaultValues || !Objects.deepEquals(value, method.getDefaultValue())) {
                    if (value.getClass().isArray()) {
                        for (int i = 0; i < Array.getLength(value); i++) {
                            builder.m1324a(method.getName(), Array.get(value, i));
                        }
                    } else if (value instanceof Annotation) {
                        builder.m1325a(method.getName(), "$L", C0356a.m1339a((Annotation) value));
                    } else {
                        builder.m1324a(method.getName(), value);
                    }
                }
            }
            return builder.m1326a();
        } catch (Exception e) {
            throw new RuntimeException("Reflecting " + annotation + " failed!", e);
        }
    }

    /* renamed from: a */
    public static C0356a m1341a(AnnotationMirror annotation) {
        C0354a builder = C0356a.m1337a(C0359c.m1375a((TypeElement) annotation.getAnnotationType().asElement()));
        C0355b visitor = new C0355b(builder);
        for (ExecutableElement executableElement : annotation.getElementValues().keySet()) {
            ((AnnotationValue) annotation.getElementValues().get(executableElement)).accept(visitor, executableElement.getSimpleName().toString());
        }
        return builder.m1326a();
    }

    /* renamed from: a */
    public static C0354a m1337a(C0359c type) {
        C0386o.m1661a((Object) type, "type == null", new Object[0]);
        return new C0354a(type);
    }

    /* renamed from: a */
    public static C0354a m1338a(Class<?> type) {
        return C0356a.m1337a(C0359c.m1373a((Class) type));
    }

    /* renamed from: a */
    public C0354a m1343a() {
        C0354a builder = new C0354a(this.f1105a);
        for (Entry<String, List<C0362d>> entry : this.f1106b.entrySet()) {
            builder.f1103b.put(entry.getKey(), new ArrayList((Collection) entry.getValue()));
        }
        return builder;
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
            new C0363e(out).m1419a("$L", this);
            return out.toString();
        } catch (IOException e) {
            throw new AssertionError();
        }
    }
}
