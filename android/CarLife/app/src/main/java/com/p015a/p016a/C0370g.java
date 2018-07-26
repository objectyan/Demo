package com.p015a.p016a;

import com.p015a.p016a.C0362d.C0361a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;

/* compiled from: JavaFile */
/* renamed from: com.a.a.g */
public final class C0370g {
    /* renamed from: e */
    private static final Appendable f1172e = new C03671();
    /* renamed from: a */
    public final C0362d f1173a;
    /* renamed from: b */
    public final String f1174b;
    /* renamed from: c */
    public final C0384m f1175c;
    /* renamed from: d */
    public final boolean f1176d;
    /* renamed from: f */
    private final Set<String> f1177f;
    /* renamed from: g */
    private final String f1178g;

    /* compiled from: JavaFile */
    /* renamed from: com.a.a.g$1 */
    static class C03671 implements Appendable {
        C03671() {
        }

        public Appendable append(CharSequence charSequence) {
            return this;
        }

        public Appendable append(CharSequence charSequence, int start, int end) {
            return this;
        }

        public Appendable append(char c) {
            return this;
        }
    }

    /* compiled from: JavaFile */
    /* renamed from: com.a.a.g$a */
    public static final class C0369a {
        /* renamed from: a */
        private final String f1166a;
        /* renamed from: b */
        private final C0384m f1167b;
        /* renamed from: c */
        private final C0361a f1168c;
        /* renamed from: d */
        private final Set<String> f1169d;
        /* renamed from: e */
        private boolean f1170e;
        /* renamed from: f */
        private String f1171f;

        private C0369a(String packageName, C0384m typeSpec) {
            this.f1168c = C0362d.m1406b();
            this.f1169d = new TreeSet();
            this.f1171f = "  ";
            this.f1166a = packageName;
            this.f1167b = typeSpec;
        }

        /* renamed from: a */
        public C0369a m1474a(String format, Object... args) {
            this.f1168c.m1397a(format, args);
            return this;
        }

        /* renamed from: a */
        public C0369a m1472a(Enum<?> constant) {
            return m1470a(C0359c.m1373a(constant.getDeclaringClass()), constant.name());
        }

        /* renamed from: a */
        public C0369a m1471a(Class<?> clazz, String... names) {
            return m1470a(C0359c.m1373a((Class) clazz), names);
        }

        /* renamed from: a */
        public C0369a m1470a(C0359c className, String... names) {
            boolean z;
            if (className != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "className == null", new Object[0]);
            if (names != null) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "names == null", new Object[0]);
            if (names.length > 0) {
                z = true;
            } else {
                z = false;
            }
            C0386o.m1669a(z, "names array is empty", new Object[0]);
            for (String name : names) {
                if (name != null) {
                    z = true;
                } else {
                    z = false;
                }
                C0386o.m1669a(z, "null entry in names array: %s", Arrays.toString(names));
                this.f1169d.add(className.f1132c + "." + name);
            }
            return this;
        }

        /* renamed from: a */
        public C0369a m1475a(boolean skipJavaLangImports) {
            this.f1170e = skipJavaLangImports;
            return this;
        }

        /* renamed from: a */
        public C0369a m1473a(String indent) {
            this.f1171f = indent;
            return this;
        }

        /* renamed from: a */
        public C0370g m1476a() {
            return new C0370g();
        }
    }

    private C0370g(C0369a builder) {
        this.f1173a = builder.f1168c.m1403d();
        this.f1174b = builder.f1166a;
        this.f1175c = builder.f1167b;
        this.f1176d = builder.f1170e;
        this.f1177f = C0386o.m1671b(builder.f1169d);
        this.f1178g = builder.f1171f;
    }

    /* renamed from: a */
    public void m1481a(Appendable out) throws IOException {
        C0363e importsCollector = new C0363e(f1172e, this.f1178g, this.f1177f);
        m1478a(importsCollector);
        m1478a(new C0363e(out, this.f1178g, importsCollector.m1436f(), this.f1177f));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m1482a(java.nio.file.Path r9) throws java.io.IOException {
        /*
        r8 = this;
        r6 = 1;
        r5 = 0;
        r4 = new java.nio.file.LinkOption[r5];
        r4 = java.nio.file.Files.notExists(r9, r4);
        if (r4 != 0) goto L_0x0012;
    L_0x000a:
        r4 = new java.nio.file.LinkOption[r5];
        r4 = java.nio.file.Files.isDirectory(r9, r4);
        if (r4 == 0) goto L_0x003c;
    L_0x0012:
        r4 = r6;
    L_0x0013:
        r7 = "path %s exists but is not a directory.";
        r6 = new java.lang.Object[r6];
        r6[r5] = r9;
        com.p015a.p016a.C0386o.m1669a(r4, r7, r6);
        r0 = r9;
        r4 = r8.f1174b;
        r4 = r4.isEmpty();
        if (r4 != 0) goto L_0x0043;
    L_0x0026:
        r4 = r8.f1174b;
        r6 = "\\.";
        r6 = r4.split(r6);
        r7 = r6.length;
        r4 = r5;
    L_0x0031:
        if (r4 >= r7) goto L_0x003e;
    L_0x0033:
        r2 = r6[r4];
        r0 = r0.resolve(r2);
        r4 = r4 + 1;
        goto L_0x0031;
    L_0x003c:
        r4 = r5;
        goto L_0x0013;
    L_0x003e:
        r4 = new java.nio.file.attribute.FileAttribute[r5];
        java.nio.file.Files.createDirectories(r0, r4);
    L_0x0043:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = r8.f1175c;
        r6 = r6.f1244b;
        r4 = r4.append(r6);
        r6 = ".java";
        r4 = r4.append(r6);
        r4 = r4.toString();
        r1 = r0.resolve(r4);
        r3 = new java.io.OutputStreamWriter;
        r4 = new java.nio.file.OpenOption[r5];
        r4 = java.nio.file.Files.newOutputStream(r1, r4);
        r3.<init>(r4);
        r5 = 0;
        r8.m1481a(r3);	 Catch:{ Throwable -> 0x007f }
        if (r3 == 0) goto L_0x0075;
    L_0x0070:
        if (r5 == 0) goto L_0x007b;
    L_0x0072:
        r3.close();	 Catch:{ Throwable -> 0x0076 }
    L_0x0075:
        return;
    L_0x0076:
        r4 = move-exception;
        r5.addSuppressed(r4);
        goto L_0x0075;
    L_0x007b:
        r3.close();
        goto L_0x0075;
    L_0x007f:
        r5 = move-exception;
        throw r5;	 Catch:{ all -> 0x0081 }
    L_0x0081:
        r4 = move-exception;
        if (r3 == 0) goto L_0x0089;
    L_0x0084:
        if (r5 == 0) goto L_0x008f;
    L_0x0086:
        r3.close();	 Catch:{ Throwable -> 0x008a }
    L_0x0089:
        throw r4;
    L_0x008a:
        r6 = move-exception;
        r5.addSuppressed(r6);
        goto L_0x0089;
    L_0x008f:
        r3.close();
        goto L_0x0089;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.g.a(java.nio.file.Path):void");
    }

    /* renamed from: a */
    public void m1480a(File directory) throws IOException {
        m1482a(directory.toPath());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m1483a(javax.annotation.processing.Filer r9) throws java.io.IOException {
        /*
        r8 = this;
        r5 = r8.f1174b;
        r5 = r5.isEmpty();
        if (r5 == 0) goto L_0x0030;
    L_0x0008:
        r5 = r8.f1175c;
        r1 = r5.f1244b;
    L_0x000c:
        r5 = r8.f1175c;
        r3 = r5.f1258p;
        r5 = r3.size();
        r5 = new javax.lang.model.element.Element[r5];
        r5 = r3.toArray(r5);
        r5 = (javax.lang.model.element.Element[]) r5;
        r2 = r9.createSourceFile(r1, r5);
        r4 = r2.openWriter();	 Catch:{ Exception -> 0x0054 }
        r6 = 0;
        r8.m1481a(r4);	 Catch:{ Throwable -> 0x005d }
        if (r4 == 0) goto L_0x002f;
    L_0x002a:
        if (r6 == 0) goto L_0x0059;
    L_0x002c:
        r4.close();	 Catch:{ Throwable -> 0x004f }
    L_0x002f:
        return;
    L_0x0030:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r8.f1174b;
        r5 = r5.append(r6);
        r6 = ".";
        r5 = r5.append(r6);
        r6 = r8.f1175c;
        r6 = r6.f1244b;
        r5 = r5.append(r6);
        r1 = r5.toString();
        goto L_0x000c;
    L_0x004f:
        r5 = move-exception;
        r6.addSuppressed(r5);	 Catch:{ Exception -> 0x0054 }
        goto L_0x002f;
    L_0x0054:
        r0 = move-exception;
        r2.delete();	 Catch:{ Exception -> 0x0071 }
    L_0x0058:
        throw r0;
    L_0x0059:
        r4.close();	 Catch:{ Exception -> 0x0054 }
        goto L_0x002f;
    L_0x005d:
        r6 = move-exception;
        throw r6;	 Catch:{ all -> 0x005f }
    L_0x005f:
        r5 = move-exception;
        if (r4 == 0) goto L_0x0067;
    L_0x0062:
        if (r6 == 0) goto L_0x006d;
    L_0x0064:
        r4.close();	 Catch:{ Throwable -> 0x0068 }
    L_0x0067:
        throw r5;	 Catch:{ Exception -> 0x0054 }
    L_0x0068:
        r7 = move-exception;
        r6.addSuppressed(r7);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0067;
    L_0x006d:
        r4.close();	 Catch:{ Exception -> 0x0054 }
        goto L_0x0067;
    L_0x0071:
        r5 = move-exception;
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.g.a(javax.annotation.processing.Filer):void");
    }

    /* renamed from: a */
    private void m1478a(C0363e codeWriter) throws IOException {
        Iterator it;
        codeWriter.m1418a(this.f1174b);
        if (!this.f1173a.m1407a()) {
            codeWriter.m1422a(this.f1173a);
        }
        if (!this.f1174b.isEmpty()) {
            codeWriter.m1419a("package $L;\n", this.f1174b);
            codeWriter.m1429b("\n");
        }
        if (!this.f1177f.isEmpty()) {
            it = this.f1177f.iterator();
            while (it.hasNext()) {
                codeWriter.m1419a("import static $L;\n", (String) it.next());
            }
            codeWriter.m1429b("\n");
        }
        int importedTypesCount = 0;
        it = new TreeSet(codeWriter.m1421a().values()).iterator();
        while (it.hasNext()) {
            C0359c className = (C0359c) it.next();
            if (!this.f1176d || !className.m1386b().equals("java.lang")) {
                codeWriter.m1419a("import $L;\n", className);
                importedTypesCount++;
            }
        }
        if (importedTypesCount > 0) {
            codeWriter.m1429b("\n");
        }
        this.f1175c.m1643a(codeWriter, null, Collections.emptySet());
        codeWriter.m1434d();
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
        try {
            Appendable result = new StringBuilder();
            m1481a(result);
            return result.toString();
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public JavaFileObject m1479a() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f1174b.isEmpty()) {
            str = this.f1175c.f1244b;
        } else {
            str = this.f1174b.replace('.', '/') + '/' + this.f1175c.f1244b;
        }
        return new SimpleJavaFileObject(this, URI.create(stringBuilder.append(str).append(Kind.SOURCE.extension).toString()), Kind.SOURCE) {
            /* renamed from: a */
            final /* synthetic */ C0370g f1164a;
            /* renamed from: b */
            private final long f1165b = System.currentTimeMillis();

            /* renamed from: b */
            public /* synthetic */ CharSequence m1461b(boolean z) throws IOException {
                return m1459a(z);
            }

            /* renamed from: a */
            public String m1459a(boolean ignoreEncodingErrors) {
                return this.f1164a.toString();
            }

            /* renamed from: a */
            public InputStream m1458a() throws IOException {
                return new ByteArrayInputStream(m1459a(true).getBytes());
            }

            /* renamed from: b */
            public long m1460b() {
                return this.f1165b;
            }
        };
    }

    /* renamed from: a */
    public static C0369a m1477a(String packageName, C0384m typeSpec) {
        C0386o.m1661a((Object) packageName, "packageName == null", new Object[0]);
        C0386o.m1661a((Object) typeSpec, "typeSpec == null", new Object[0]);
        return new C0369a(packageName, typeSpec);
    }

    /* renamed from: b */
    public C0369a m1484b() {
        C0369a builder = new C0369a(this.f1174b, this.f1175c);
        builder.f1168c.m1396a(this.f1173a);
        builder.f1170e = this.f1176d;
        builder.f1171f = this.f1178g;
        return builder;
    }
}
