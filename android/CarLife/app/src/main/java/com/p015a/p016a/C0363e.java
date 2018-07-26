package com.p015a.p016a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: CodeWriter */
/* renamed from: com.a.a.e */
final class C0363e {
    /* renamed from: b */
    private static final String f1137b = new String();
    /* renamed from: a */
    int f1138a;
    /* renamed from: c */
    private final String f1139c;
    /* renamed from: d */
    private final Appendable f1140d;
    /* renamed from: e */
    private int f1141e;
    /* renamed from: f */
    private boolean f1142f;
    /* renamed from: g */
    private boolean f1143g;
    /* renamed from: h */
    private String f1144h;
    /* renamed from: i */
    private final List<C0384m> f1145i;
    /* renamed from: j */
    private final Set<String> f1146j;
    /* renamed from: k */
    private final Set<String> f1147k;
    /* renamed from: l */
    private final Map<String, C0359c> f1148l;
    /* renamed from: m */
    private final Map<String, C0359c> f1149m;
    /* renamed from: n */
    private final Set<String> f1150n;
    /* renamed from: o */
    private boolean f1151o;

    C0363e(Appendable out) {
        this(out, "  ", Collections.emptySet());
    }

    C0363e(Appendable out, String indent, Set<String> staticImports) {
        this(out, indent, Collections.emptyMap(), staticImports);
    }

    C0363e(Appendable out, String indent, Map<String, C0359c> importedTypes, Set<String> staticImports) {
        this.f1142f = false;
        this.f1143g = false;
        this.f1144h = f1137b;
        this.f1145i = new ArrayList();
        this.f1149m = new LinkedHashMap();
        this.f1150n = new LinkedHashSet();
        this.f1138a = -1;
        this.f1140d = (Appendable) C0386o.m1661a((Object) out, "out == null", new Object[0]);
        this.f1139c = (String) C0386o.m1661a((Object) indent, "indent == null", new Object[0]);
        this.f1148l = (Map) C0386o.m1661a((Object) importedTypes, "importedTypes == null", new Object[0]);
        this.f1147k = (Set) C0386o.m1661a((Object) staticImports, "staticImports == null", new Object[0]);
        this.f1146j = new LinkedHashSet();
        for (String signature : staticImports) {
            this.f1146j.add(signature.substring(0, signature.lastIndexOf(46)));
        }
    }

    /* renamed from: a */
    public Map<String, C0359c> m1421a() {
        return this.f1148l;
    }

    /* renamed from: b */
    public C0363e m1427b() {
        return m1416a(1);
    }

    /* renamed from: a */
    public C0363e m1416a(int levels) {
        this.f1141e += levels;
        return this;
    }

    /* renamed from: c */
    public C0363e m1431c() {
        return m1428b(1);
    }

    /* renamed from: b */
    public C0363e m1428b(int levels) {
        boolean z;
        if (this.f1141e - levels >= 0) {
            z = true;
        } else {
            z = false;
        }
        C0386o.m1669a(z, "cannot unindent %s from %s", Integer.valueOf(levels), Integer.valueOf(this.f1141e));
        this.f1141e -= levels;
        return this;
    }

    /* renamed from: a */
    public C0363e m1418a(String packageName) {
        boolean z;
        if (this.f1144h == f1137b) {
            z = true;
        } else {
            z = false;
        }
        C0386o.m1672b(z, "package already set: %s", this.f1144h);
        this.f1144h = (String) C0386o.m1661a((Object) packageName, "packageName == null", new Object[0]);
        return this;
    }

    /* renamed from: d */
    public C0363e m1434d() {
        boolean z;
        if (this.f1144h != f1137b) {
            z = true;
        } else {
            z = false;
        }
        C0386o.m1672b(z, "package already set: %s", this.f1144h);
        this.f1144h = f1137b;
        return this;
    }

    /* renamed from: a */
    public C0363e m1417a(C0384m type) {
        this.f1145i.add(type);
        return this;
    }

    /* renamed from: e */
    public C0363e m1435e() {
        this.f1145i.remove(this.f1145i.size() - 1);
        return this;
    }

    /* renamed from: a */
    public void m1422a(C0362d codeBlock) throws IOException {
        this.f1151o = true;
        this.f1143g = true;
        try {
            m1432c(codeBlock);
            m1429b("\n");
        } finally {
            this.f1143g = false;
        }
    }

    /* renamed from: b */
    public void m1430b(C0362d javadocCodeBlock) throws IOException {
        if (!javadocCodeBlock.m1407a()) {
            m1429b("/**\n");
            this.f1142f = true;
            try {
                m1432c(javadocCodeBlock);
                m1429b(" */\n");
            } finally {
                this.f1142f = false;
            }
        }
    }

    /* renamed from: a */
    public void m1424a(List<C0356a> annotations, boolean inline) throws IOException {
        for (C0356a annotationSpec : annotations) {
            annotationSpec.m1344a(this, inline);
            m1429b(inline ? " " : "\n");
        }
    }

    /* renamed from: a */
    public void m1426a(Set<Modifier> modifiers, Set<Modifier> implicitModifiers) throws IOException {
        if (!modifiers.isEmpty()) {
            Iterator it = EnumSet.copyOf(modifiers).iterator();
            while (it.hasNext()) {
                Modifier modifier = (Modifier) it.next();
                if (!implicitModifiers.contains(modifier)) {
                    m1433c(modifier.name().toLowerCase(Locale.US));
                    m1433c(" ");
                }
            }
        }
    }

    /* renamed from: a */
    public void m1425a(Set<Modifier> modifiers) throws IOException {
        m1426a((Set) modifiers, Collections.emptySet());
    }

    /* renamed from: a */
    public void m1423a(List<C0385n> typeVariables) throws IOException {
        if (!typeVariables.isEmpty()) {
            m1429b("<");
            boolean firstTypeVariable = true;
            for (C0385n typeVariable : typeVariables) {
                if (!firstTypeVariable) {
                    m1429b(", ");
                }
                m1419a("$L", typeVariable.f1259a);
                boolean firstBound = true;
                for (C0357l bound : typeVariable.f1260b) {
                    m1419a(firstBound ? " extends $T" : " & $T", bound);
                    firstBound = false;
                }
                firstTypeVariable = false;
            }
            m1429b(">");
        }
    }

    /* renamed from: b */
    public C0363e m1429b(String s) throws IOException {
        return m1433c(s);
    }

    /* renamed from: a */
    public C0363e m1419a(String format, Object... args) throws IOException {
        return m1432c(C0362d.m1405a(format, args));
    }

    /* renamed from: c */
    public C0363e m1432c(C0362d codeBlock) throws IOException {
        int a = 0;
        C0359c deferredTypeName = null;
        ListIterator<String> partIterator = codeBlock.f1135a.listIterator();
        while (partIterator.hasNext()) {
            String part = (String) partIterator.next();
            Object obj = -1;
            switch (part.hashCode()) {
                case 1152:
                    if (part.equals("$$")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1176:
                    if (part.equals("$<")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 1178:
                    if (part.equals("$>")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 1192:
                    if (part.equals("$L")) {
                        obj = null;
                        break;
                    }
                    break;
                case 1194:
                    if (part.equals("$N")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1199:
                    if (part.equals("$S")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1200:
                    if (part.equals("$T")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1207:
                    if (part.equals("$[")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 1209:
                    if (part.equals("$]")) {
                        obj = 8;
                        break;
                    }
                    break;
            }
            int a2;
            switch (obj) {
                case null:
                    a2 = a + 1;
                    m1410a(codeBlock.f1136b.get(a));
                    a = a2;
                    break;
                case 1:
                    a2 = a + 1;
                    m1433c((String) codeBlock.f1136b.get(a));
                    a = a2;
                    break;
                case 2:
                    a2 = a + 1;
                    String string = (String) codeBlock.f1136b.get(a);
                    m1433c(string != null ? C0386o.m1663a(string, this.f1139c) : "null");
                    a = a2;
                    break;
                case 3:
                    a2 = a + 1;
                    C0357l typeName = (C0357l) codeBlock.f1136b.get(a);
                    if (typeName.m1358g()) {
                        typeName.m1355b(this);
                        typeName = typeName.mo1154a();
                    }
                    if ((typeName instanceof C0359c) && partIterator.hasNext() && !((String) codeBlock.f1135a.get(partIterator.nextIndex())).startsWith("$")) {
                        C0359c candidate = (C0359c) typeName;
                        if (this.f1146j.contains(candidate.f1132c)) {
                            C0386o.m1672b(deferredTypeName == null, "pending type for static import?!", new Object[0]);
                            deferredTypeName = candidate;
                            a = a2;
                            break;
                        }
                    }
                    typeName.mo1153a(this);
                    a = a2;
                    break;
                case 4:
                    m1433c("$");
                    break;
                case 5:
                    m1427b();
                    break;
                case 6:
                    m1431c();
                    break;
                case 7:
                    C0386o.m1672b(this.f1138a == -1, "statement enter $[ followed by statement enter $[", new Object[0]);
                    this.f1138a = 0;
                    break;
                case 8:
                    C0386o.m1672b(this.f1138a != -1, "statement exit $] has no matching statement enter $[", new Object[0]);
                    if (this.f1138a > 0) {
                        m1428b(2);
                    }
                    this.f1138a = -1;
                    break;
                default:
                    if (deferredTypeName != null) {
                        if (part.startsWith(".") && m1411a(deferredTypeName.f1132c, part)) {
                            deferredTypeName = null;
                            break;
                        }
                        deferredTypeName.mo1153a(this);
                        deferredTypeName = null;
                    }
                    m1433c(part);
                    break;
            }
        }
        return this;
    }

    /* renamed from: d */
    private static String m1413d(String part) {
        C0386o.m1669a(Character.isJavaIdentifierStart(part.charAt(0)), "not an identifier: %s", part);
        for (int i = 1; i <= part.length(); i++) {
            if (!SourceVersion.isIdentifier(part.substring(0, i))) {
                return part.substring(0, i - 1);
            }
        }
        return part;
    }

    /* renamed from: a */
    private boolean m1411a(String canonical, String part) throws IOException {
        String partWithoutLeadingDot = part.substring(1);
        if (partWithoutLeadingDot.isEmpty() || !Character.isJavaIdentifierStart(partWithoutLeadingDot.charAt(0))) {
            return false;
        }
        String explicit = canonical + "." + C0363e.m1413d(partWithoutLeadingDot);
        String wildcard = canonical + ".*";
        if (!this.f1147k.contains(explicit) && !this.f1147k.contains(wildcard)) {
            return false;
        }
        m1433c(partWithoutLeadingDot);
        return true;
    }

    /* renamed from: a */
    private void m1410a(Object o) throws IOException {
        if (o instanceof C0384m) {
            ((C0384m) o).m1643a(this, null, Collections.emptySet());
        } else if (o instanceof C0356a) {
            ((C0356a) o).m1344a(this, true);
        } else if (o instanceof C0362d) {
            m1432c((C0362d) o);
        } else {
            m1433c(String.valueOf(o));
        }
    }

    /* renamed from: a */
    String m1420a(C0359c className) {
        boolean nameResolved = false;
        for (C0359c c = className; c != null; c = c.m1387c()) {
            C0359c resolved = m1414e(c.m1390f());
            nameResolved = resolved != null;
            if (Objects.equals(resolved, c)) {
                return C0386o.m1664a(".", className.m1389e().subList(c.m1389e().size() - 1, className.m1389e().size()));
            }
        }
        if (nameResolved) {
            return className.f1132c;
        }
        if (Objects.equals(this.f1144h, className.m1386b())) {
            this.f1150n.add(className.m1388d().m1390f());
            return C0386o.m1664a(".", className.m1389e());
        }
        if (!this.f1142f) {
            m1412b(className);
        }
        return className.f1132c;
    }

    /* renamed from: b */
    private void m1412b(C0359c className) {
        if (!className.m1386b().isEmpty()) {
            C0359c topLevelClassName = className.m1388d();
            String simpleName = topLevelClassName.m1390f();
            C0359c replaced = (C0359c) this.f1149m.put(simpleName, topLevelClassName);
            if (replaced != null) {
                this.f1149m.put(simpleName, replaced);
            }
        }
    }

    /* renamed from: e */
    private C0359c m1414e(String simpleName) {
        for (int i = this.f1145i.size() - 1; i >= 0; i--) {
            for (C0384m visibleChild : ((C0384m) this.f1145i.get(i)).f1257o) {
                if (Objects.equals(visibleChild.f1244b, simpleName)) {
                    return m1409a(i, simpleName);
                }
            }
        }
        if (this.f1145i.size() > 0 && Objects.equals(((C0384m) this.f1145i.get(0)).f1244b, simpleName)) {
            return C0359c.m1374a(this.f1144h, simpleName, new String[0]);
        }
        C0359c importedType = (C0359c) this.f1148l.get(simpleName);
        return importedType == null ? null : importedType;
    }

    /* renamed from: a */
    private C0359c m1409a(int stackDepth, String simpleName) {
        C0359c className = C0359c.m1374a(this.f1144h, ((C0384m) this.f1145i.get(0)).f1244b, new String[0]);
        for (int i = 1; i <= stackDepth; i++) {
            className = className.m1380a(((C0384m) this.f1145i.get(i)).f1244b);
        }
        return className.m1380a(simpleName);
    }

    /* renamed from: c */
    com.p015a.p016a.C0363e m1433c(java.lang.String r10) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.IndexOutOfBoundsException: bitIndex < 0: -1
	at java.util.BitSet.get(BitSet.java:623)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.usedArgAssign(CodeShrinker.java:138)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.access$300(CodeShrinker.java:43)
	at jadx.core.dex.visitors.CodeShrinker.canMoveBetweenBlocks(CodeShrinker.java:282)
	at jadx.core.dex.visitors.CodeShrinker.shrinkBlock(CodeShrinker.java:232)
	at jadx.core.dex.visitors.CodeShrinker.shrinkMethod(CodeShrinker.java:38)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkArrayForEach(LoopRegionVisitor.java:196)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkForIndexedLoop(LoopRegionVisitor.java:119)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:65)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r9 = this;
        r4 = 0;
        r8 = -1;
        r0 = 1;
        r2 = "\n";
        r5 = r10.split(r2, r8);
        r6 = r5.length;
        r3 = r4;
    L_0x000c:
        if (r3 >= r6) goto L_0x0080;
    L_0x000e:
        r1 = r5[r3];
        if (r0 != 0) goto L_0x0049;
    L_0x0012:
        r2 = r9.f1142f;
        if (r2 != 0) goto L_0x001a;
    L_0x0016:
        r2 = r9.f1143g;
        if (r2 == 0) goto L_0x002d;
    L_0x001a:
        r2 = r9.f1151o;
        if (r2 == 0) goto L_0x002d;
    L_0x001e:
        r9.m1415g();
        r7 = r9.f1140d;
        r2 = r9.f1142f;
        if (r2 == 0) goto L_0x0054;
    L_0x0027:
        r2 = " *";
    L_0x002a:
        r7.append(r2);
    L_0x002d:
        r2 = r9.f1140d;
        r7 = 10;
        r2.append(r7);
        r2 = 1;
        r9.f1151o = r2;
        r2 = r9.f1138a;
        if (r2 == r8) goto L_0x0049;
    L_0x003b:
        r2 = r9.f1138a;
        if (r2 != 0) goto L_0x0043;
    L_0x003f:
        r2 = 2;
        r9.m1416a(r2);
    L_0x0043:
        r2 = r9.f1138a;
        r2 = r2 + 1;
        r9.f1138a = r2;
    L_0x0049:
        r0 = 0;
        r2 = r1.isEmpty();
        if (r2 == 0) goto L_0x0058;
    L_0x0050:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x000c;
    L_0x0054:
        r2 = "//";
        goto L_0x002a;
    L_0x0058:
        r2 = r9.f1151o;
        if (r2 == 0) goto L_0x006b;
    L_0x005c:
        r9.m1415g();
        r2 = r9.f1142f;
        if (r2 == 0) goto L_0x0073;
    L_0x0063:
        r2 = r9.f1140d;
        r7 = " * ";
        r2.append(r7);
    L_0x006b:
        r2 = r9.f1140d;
        r2.append(r1);
        r9.f1151o = r4;
        goto L_0x0050;
    L_0x0073:
        r2 = r9.f1143g;
        if (r2 == 0) goto L_0x006b;
    L_0x0077:
        r2 = r9.f1140d;
        r7 = "// ";
        r2.append(r7);
        goto L_0x006b;
    L_0x0080:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.e.c(java.lang.String):com.a.a.e");
    }

    /* renamed from: g */
    private void m1415g() throws IOException {
        for (int j = 0; j < this.f1141e; j++) {
            this.f1140d.append(this.f1139c);
        }
    }

    /* renamed from: f */
    Map<String, C0359c> m1436f() {
        Map<String, C0359c> result = new LinkedHashMap(this.f1149m);
        result.keySet().removeAll(this.f1150n);
        return result;
    }
}
