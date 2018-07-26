package com.indooratlas.android.sdk._internal;

import cz.msebera.android.httpclient.p158b.p294a.C6197b;
import java.util.concurrent.TimeUnit;

public final class fq {
    /* renamed from: a */
    public static final fq f23728a;
    /* renamed from: b */
    public static final fq f23729b;
    /* renamed from: c */
    public final boolean f23730c;
    /* renamed from: d */
    public final boolean f23731d;
    /* renamed from: e */
    public final int f23732e;
    /* renamed from: f */
    public final boolean f23733f;
    /* renamed from: g */
    public final boolean f23734g;
    /* renamed from: h */
    public final boolean f23735h;
    /* renamed from: i */
    public final int f23736i;
    /* renamed from: j */
    public final int f23737j;
    /* renamed from: k */
    public final boolean f23738k;
    /* renamed from: l */
    String f23739l;
    /* renamed from: m */
    private final int f23740m;
    /* renamed from: n */
    private final boolean f23741n;

    /* renamed from: com.indooratlas.android.sdk._internal.fq$a */
    public static final class C5910a {
        /* renamed from: a */
        boolean f23721a;
        /* renamed from: b */
        boolean f23722b;
        /* renamed from: c */
        int f23723c = -1;
        /* renamed from: d */
        int f23724d = -1;
        /* renamed from: e */
        int f23725e = -1;
        /* renamed from: f */
        boolean f23726f;
        /* renamed from: g */
        boolean f23727g;

        /* renamed from: a */
        public final fq m20564a() {
            return new fq();
        }
    }

    static {
        int i;
        C5910a c5910a = new C5910a();
        c5910a.f23721a = true;
        f23728a = c5910a.m20564a();
        C5910a c5910a2 = new C5910a();
        c5910a2.f23726f = true;
        long toSeconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        if (toSeconds > 2147483647L) {
            i = Integer.MAX_VALUE;
        } else {
            i = (int) toSeconds;
        }
        c5910a2.f23724d = i;
        f23729b = c5910a2.m20564a();
    }

    private fq(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f23730c = z;
        this.f23731d = z2;
        this.f23732e = i;
        this.f23740m = i2;
        this.f23733f = z3;
        this.f23734g = z4;
        this.f23735h = z5;
        this.f23736i = i3;
        this.f23737j = i4;
        this.f23738k = z6;
        this.f23741n = z7;
        this.f23739l = str;
    }

    private fq(C5910a c5910a) {
        this.f23730c = c5910a.f23721a;
        this.f23731d = c5910a.f23722b;
        this.f23732e = c5910a.f23723c;
        this.f23740m = -1;
        this.f23733f = false;
        this.f23734g = false;
        this.f23735h = false;
        this.f23736i = c5910a.f23724d;
        this.f23737j = c5910a.f23725e;
        this.f23738k = c5910a.f23726f;
        this.f23741n = c5910a.f23727g;
    }

    /* renamed from: a */
    public static fq m20565a(gd gdVar) {
        String b;
        boolean z = false;
        int i = -1;
        int i2 = -1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z5 = false;
        boolean z6 = false;
        Object obj = 1;
        int length = gdVar.f23845a.length / 2;
        int i5 = 0;
        String str = null;
        boolean z7 = false;
        while (i5 < length) {
            boolean z8;
            String a = gdVar.m20617a(i5);
            b = gdVar.m20619b(i5);
            if (a.equalsIgnoreCase("Cache-Control")) {
                if (str != null) {
                    obj = null;
                } else {
                    str = b;
                }
            } else if (a.equalsIgnoreCase("Pragma")) {
                obj = null;
            } else {
                z8 = z7;
                i5++;
                z7 = z8;
            }
            z8 = z7;
            int i6 = 0;
            while (i6 < b.length()) {
                String str2;
                int a2 = hr.m21008a(b, i6, "=,;");
                String trim = b.substring(i6, a2).trim();
                if (a2 == b.length() || b.charAt(a2) == ',' || b.charAt(a2) == ';') {
                    i6 = a2 + 1;
                    str2 = null;
                } else {
                    i6 = a2 + 1;
                    while (i6 < b.length()) {
                        char charAt = b.charAt(i6);
                        if (charAt != ' ' && charAt != '\t') {
                            break;
                        }
                        i6++;
                    }
                    String trim2;
                    if (i6 >= b.length() || b.charAt(i6) != '\"') {
                        a2 = hr.m21008a(b, i6, ",;");
                        trim2 = b.substring(i6, a2).trim();
                        i6 = a2;
                        str2 = trim2;
                    } else {
                        i6++;
                        a2 = hr.m21008a(b, i6, "\"");
                        trim2 = b.substring(i6, a2);
                        i6 = a2 + 1;
                        str2 = trim2;
                    }
                }
                if (C6197b.f25310y.equalsIgnoreCase(trim)) {
                    z8 = true;
                } else if (C6197b.f25309x.equalsIgnoreCase(trim)) {
                    z = true;
                } else if ("max-age".equalsIgnoreCase(trim)) {
                    i = hr.m21007a(str2, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i2 = hr.m21007a(str2, -1);
                } else if (C6197b.f25307v.equalsIgnoreCase(trim)) {
                    z2 = true;
                } else if (C6197b.f25306u.equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if (C6197b.f25276C.equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if (C6197b.f25274A.equalsIgnoreCase(trim)) {
                    i3 = hr.m21007a(str2, Integer.MAX_VALUE);
                } else if (C6197b.f25275B.equalsIgnoreCase(trim)) {
                    i4 = hr.m21007a(str2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z6 = true;
                }
            }
            i5++;
            z7 = z8;
        }
        if (obj == null) {
            b = null;
        } else {
            b = str;
        }
        return new fq(z7, z, i, i2, z2, z3, z4, i3, i4, z5, z6, b);
    }

    public final String toString() {
        String str = this.f23739l;
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.f23730c) {
                stringBuilder.append("no-cache, ");
            }
            if (this.f23731d) {
                stringBuilder.append("no-store, ");
            }
            if (this.f23732e != -1) {
                stringBuilder.append("max-age=").append(this.f23732e).append(", ");
            }
            if (this.f23740m != -1) {
                stringBuilder.append("s-maxage=").append(this.f23740m).append(", ");
            }
            if (this.f23733f) {
                stringBuilder.append("private, ");
            }
            if (this.f23734g) {
                stringBuilder.append("public, ");
            }
            if (this.f23735h) {
                stringBuilder.append("must-revalidate, ");
            }
            if (this.f23736i != -1) {
                stringBuilder.append("max-stale=").append(this.f23736i).append(", ");
            }
            if (this.f23737j != -1) {
                stringBuilder.append("min-fresh=").append(this.f23737j).append(", ");
            }
            if (this.f23738k) {
                stringBuilder.append("only-if-cached, ");
            }
            if (this.f23741n) {
                stringBuilder.append("no-transform, ");
            }
            if (stringBuilder.length() == 0) {
                str = "";
            } else {
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                str = stringBuilder.toString();
            }
            this.f23739l = str;
        }
        return str;
    }
}
