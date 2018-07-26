package com.p015a.p016a;

import com.baidu.baidunavis.model.NavCarInfo;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* compiled from: CodeBlock */
/* renamed from: com.a.a.d */
public final class C0362d {
    /* renamed from: a */
    final List<String> f1135a;
    /* renamed from: b */
    final List<Object> f1136b;

    /* compiled from: CodeBlock */
    /* renamed from: com.a.a.d$a */
    public static final class C0361a {
        /* renamed from: a */
        final List<String> f1133a;
        /* renamed from: b */
        final List<Object> f1134b;

        private C0361a() {
            this.f1133a = new ArrayList();
            this.f1134b = new ArrayList();
        }

        /* renamed from: a */
        public C0361a m1397a(String format, Object... args) {
            boolean hasRelative = false;
            boolean hasIndexed = false;
            int relativeParameterCount = 0;
            int[] indexedParameterCount = new int[args.length];
            int p = 0;
            while (p < format.length()) {
                if (format.charAt(p) != '$') {
                    int nextP = format.indexOf(36, p + 1);
                    if (nextP == -1) {
                        nextP = format.length();
                    }
                    this.f1133a.add(format.substring(p, nextP));
                    p = nextP;
                } else {
                    p++;
                    int indexStart = p;
                    while (true) {
                        C0386o.m1669a(p < format.length(), "dangling format characters in '%s'", format);
                        int p2 = p + 1;
                        char c = format.charAt(p);
                        if (c < '0' || c > '9') {
                            int indexEnd = p2 - 1;
                            if (c == '$' || c == '>' || c == '<' || c == '[' || c == ']') {
                                C0386o.m1669a(indexStart == indexEnd, "$$, $>, $<, $[ and $] may not have an index", new Object[0]);
                                this.f1133a.add("$" + c);
                                p = p2;
                            } else {
                                int index;
                                if (indexStart < indexEnd) {
                                    index = Integer.parseInt(format.substring(indexStart, indexEnd)) - 1;
                                    hasIndexed = true;
                                    int length = index % args.length;
                                    indexedParameterCount[length] = indexedParameterCount[length] + 1;
                                } else {
                                    index = relativeParameterCount;
                                    hasRelative = true;
                                    relativeParameterCount++;
                                }
                                boolean z = index >= 0 && index < args.length;
                                C0386o.m1669a(z, "index %d for '%s' not in range (received %s arguments)", Integer.valueOf(index + 1), format.substring(indexStart - 1, indexEnd + 1), Integer.valueOf(args.length));
                                z = (hasIndexed && hasRelative) ? false : true;
                                C0386o.m1669a(z, "cannot mix indexed and positional parameters", new Object[0]);
                                switch (c) {
                                    case NavCarInfo.CarType_62L /*76*/:
                                        this.f1134b.add(m1392b(args[index]));
                                        break;
                                    case 'N':
                                        this.f1134b.add(m1391a(args[index]));
                                        break;
                                    case 'S':
                                        this.f1134b.add(m1393c(args[index]));
                                        break;
                                    case 'T':
                                        this.f1134b.add(m1394d(args[index]));
                                        break;
                                    default:
                                        throw new IllegalArgumentException(String.format("invalid format string: '%s'", new Object[]{format}));
                                }
                                this.f1133a.add("$" + c);
                                p = p2;
                            }
                        } else {
                            p = p2;
                        }
                    }
                }
            }
            if (hasRelative) {
                C0386o.m1669a(relativeParameterCount >= args.length, "unused arguments: expected %s, received %s", Integer.valueOf(relativeParameterCount), Integer.valueOf(args.length));
            }
            if (hasIndexed) {
                List<String> unused = new ArrayList();
                for (int i = 0; i < args.length; i++) {
                    if (indexedParameterCount[i] == 0) {
                        unused.add("$" + (i + 1));
                    }
                }
                String s = unused.size() == 1 ? "" : "s";
                C0386o.m1669a(unused.isEmpty(), "unused argument%s: %s", s, C0386o.m1664a(", ", (List) unused));
            }
            return this;
        }

        /* renamed from: a */
        private String m1391a(Object o) {
            if (o instanceof CharSequence) {
                return o.toString();
            }
            if (o instanceof C0377j) {
                return ((C0377j) o).f1209a;
            }
            if (o instanceof C0366f) {
                return ((C0366f) o).f1159b;
            }
            if (o instanceof C0373h) {
                return ((C0373h) o).f1192c;
            }
            if (o instanceof C0384m) {
                return ((C0384m) o).f1244b;
            }
            throw new IllegalArgumentException("expected name but was " + o);
        }

        /* renamed from: b */
        private Object m1392b(Object o) {
            return o;
        }

        /* renamed from: c */
        private String m1393c(Object o) {
            return o != null ? String.valueOf(o) : null;
        }

        /* renamed from: d */
        private C0357l m1394d(Object o) {
            if (o instanceof C0357l) {
                return (C0357l) o;
            }
            if (o instanceof TypeMirror) {
                return C0357l.m1346a((TypeMirror) o);
            }
            if (o instanceof Element) {
                return C0357l.m1346a(((Element) o).asType());
            }
            if (o instanceof Type) {
                return C0357l.m1351b((Type) o);
            }
            throw new IllegalArgumentException("expected type but was " + o);
        }

        /* renamed from: b */
        public C0361a m1399b(String controlFlow, Object... args) {
            m1397a(controlFlow + " {\n", args);
            m1398b();
            return this;
        }

        /* renamed from: c */
        public C0361a m1401c(String controlFlow, Object... args) {
            m1400c();
            m1397a("} " + controlFlow + " {\n", args);
            m1398b();
            return this;
        }

        /* renamed from: a */
        public C0361a m1395a() {
            m1400c();
            m1397a("}\n", new Object[0]);
            return this;
        }

        /* renamed from: d */
        public C0361a m1402d(String controlFlow, Object... args) {
            m1400c();
            m1397a("} " + controlFlow + ";\n", args);
            return this;
        }

        /* renamed from: e */
        public C0361a m1404e(String format, Object... args) {
            m1397a("$[", new Object[0]);
            m1397a(format, args);
            m1397a(";\n$]", new Object[0]);
            return this;
        }

        /* renamed from: a */
        public C0361a m1396a(C0362d codeBlock) {
            this.f1133a.addAll(codeBlock.f1135a);
            this.f1134b.addAll(codeBlock.f1136b);
            return this;
        }

        /* renamed from: b */
        public C0361a m1398b() {
            this.f1133a.add("$>");
            return this;
        }

        /* renamed from: c */
        public C0361a m1400c() {
            this.f1133a.add("$<");
            return this;
        }

        /* renamed from: d */
        public C0362d m1403d() {
            return new C0362d();
        }
    }

    private C0362d(C0361a builder) {
        this.f1135a = C0386o.m1665a(builder.f1133a);
        this.f1136b = C0386o.m1665a(builder.f1134b);
    }

    /* renamed from: a */
    public boolean m1407a() {
        return this.f1135a.isEmpty();
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
            new C0363e(out).m1432c(this);
            return out.toString();
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static C0362d m1405a(String format, Object... args) {
        return new C0361a().m1397a(format, args).m1403d();
    }

    /* renamed from: b */
    public static C0361a m1406b() {
        return new C0361a();
    }

    /* renamed from: c */
    public C0361a m1408c() {
        C0361a builder = new C0361a();
        builder.f1133a.addAll(this.f1135a);
        builder.f1134b.addAll(this.f1136b);
        return builder;
    }
}
