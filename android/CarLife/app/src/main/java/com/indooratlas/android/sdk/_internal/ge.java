package com.indooratlas.android.sdk._internal;

import android.support.v4.media.TransportMediator;
import com.baidu.mobstat.Config;
import com.facebook.common.p141m.C2924g;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ge {
    /* renamed from: d */
    private static final char[] f23860d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: a */
    public final String f23861a;
    /* renamed from: b */
    public final String f23862b;
    /* renamed from: c */
    public final int f23863c;
    /* renamed from: e */
    private final String f23864e;
    /* renamed from: f */
    private final String f23865f;
    /* renamed from: g */
    private final List<String> f23866g;
    /* renamed from: h */
    private final List<String> f23867h;
    /* renamed from: i */
    private final String f23868i;
    /* renamed from: j */
    private final String f23869j;

    /* renamed from: com.indooratlas.android.sdk._internal.ge$a */
    public static final class C5919a {
        /* renamed from: a */
        String f23852a;
        /* renamed from: b */
        String f23853b = "";
        /* renamed from: c */
        String f23854c = "";
        /* renamed from: d */
        String f23855d;
        /* renamed from: e */
        int f23856e = -1;
        /* renamed from: f */
        final List<String> f23857f = new ArrayList();
        /* renamed from: g */
        List<String> f23858g;
        /* renamed from: h */
        String f23859h;

        /* renamed from: com.indooratlas.android.sdk._internal.ge$a$a */
        enum C5918a {
            ;

            static {
                f23846a = 1;
                f23847b = 2;
                f23848c = 3;
                f23849d = 4;
                f23850e = 5;
                f23851f = new int[]{f23846a, f23847b, f23848c, f23849d, f23850e};
            }
        }

        public C5919a() {
            this.f23857f.add("");
        }

        /* renamed from: a */
        final int m20626a() {
            return this.f23856e != -1 ? this.f23856e : ge.m20631a(this.f23852a);
        }

        /* renamed from: a */
        public final C5919a m20628a(String str) {
            this.f23858g = str != null ? ge.m20642b(ge.m20636a(str, " \"'<>#", false, true, true)) : null;
            return this;
        }

        /* renamed from: b */
        public final ge m20629b() {
            if (this.f23852a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f23855d != null) {
                return new ge();
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f23852a);
            stringBuilder.append("://");
            if (!(this.f23853b.isEmpty() && this.f23854c.isEmpty())) {
                stringBuilder.append(this.f23853b);
                if (!this.f23854c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.f23854c);
                }
                stringBuilder.append('@');
            }
            if (this.f23855d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.f23855d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.f23855d);
            }
            int a = m20626a();
            if (a != ge.m20631a(this.f23852a)) {
                stringBuilder.append(':');
                stringBuilder.append(a);
            }
            ge.m20639a(stringBuilder, this.f23857f);
            if (this.f23858g != null) {
                stringBuilder.append('?');
                ge.m20643b(stringBuilder, this.f23858g);
            }
            if (this.f23859h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.f23859h);
            }
            return stringBuilder.toString();
        }

        /* renamed from: a */
        final int m20627a(ge geVar, String str) {
            int i;
            Object obj;
            Object obj2;
            int i2;
            char charAt;
            int a;
            String a2;
            Object obj3;
            Object obj4;
            int a3 = gy.m20779a(str, 0, str.length());
            int b = gy.m20799b(str, a3, str.length());
            if (b - a3 >= 2) {
                char charAt2 = str.charAt(a3);
                if ((charAt2 < 'a' || charAt2 > 'z') && (charAt2 < 'A' || charAt2 > 'Z')) {
                    i = -1;
                    if (i == -1) {
                        if (str.regionMatches(true, a3, "https:", 0, 6)) {
                            this.f23852a = C2924g.f12888b;
                            a3 += 6;
                        } else {
                            if (str.regionMatches(true, a3, "http:", 0, 5)) {
                                return C5918a.f23848c;
                            }
                            this.f23852a = "http";
                            a3 += 5;
                        }
                    } else if (geVar != null) {
                        return C5918a.f23847b;
                    } else {
                        this.f23852a = geVar.f23861a;
                    }
                    obj = null;
                    obj2 = null;
                    i = 0;
                    for (i2 = a3; i2 < b; i2++) {
                        charAt = str.charAt(i2);
                        if (charAt != '\\' && charAt != '/') {
                            break;
                        }
                        i++;
                    }
                    if (i < 2 || geVar == null || !geVar.f23861a.equals(this.f23852a)) {
                        i2 = a3 + i;
                        while (true) {
                            a = gy.m20781a(str, i2, b, "@/\\?#");
                            switch (a != b ? str.charAt(a) : '￿') {
                                case '￿':
                                case '#':
                                case '/':
                                case '?':
                                case '\\':
                                    i = C5919a.m20624c(str, i2, a);
                                    if (i + 1 < a) {
                                        this.f23855d = C5919a.m20621a(str, i2, i);
                                        this.f23856e = C5919a.m20625d(str, i + 1, a);
                                        if (this.f23856e == -1) {
                                            return C5918a.f23849d;
                                        }
                                    }
                                    this.f23855d = C5919a.m20621a(str, i2, i);
                                    this.f23856e = ge.m20631a(this.f23852a);
                                    if (this.f23855d == null) {
                                        a3 = a;
                                        break;
                                    }
                                    return C5918a.f23850e;
                                case '@':
                                    if (obj2 == null) {
                                        a3 = gy.m20780a(str, i2, a, ':');
                                        a2 = ge.m20634a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                        if (obj != null) {
                                            a2 = this.f23853b + "%40" + a2;
                                        }
                                        this.f23853b = a2;
                                        if (a3 != a) {
                                            obj2 = 1;
                                            this.f23854c = ge.m20634a(str, a3 + 1, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                        }
                                        obj3 = obj2;
                                        obj4 = 1;
                                    } else {
                                        this.f23854c += "%40" + ge.m20634a(str, i2, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                        obj3 = obj2;
                                        obj4 = obj;
                                    }
                                    obj2 = obj3;
                                    obj = obj4;
                                    i2 = a + 1;
                                    continue;
                                    continue;
                                    continue;
                                default:
                                    continue;
                                    continue;
                                    continue;
                            }
                        }
                    } else {
                        this.f23853b = geVar.m20647b();
                        this.f23854c = geVar.m20649c();
                        this.f23855d = geVar.f23862b;
                        this.f23856e = geVar.f23863c;
                        this.f23857f.clear();
                        this.f23857f.addAll(geVar.m20651e());
                        if (a3 == b || str.charAt(a3) == '#') {
                            m20628a(geVar.m20652f());
                        }
                    }
                    i = gy.m20781a(str, a3, b, "?#");
                    m20623b(str, a3, i);
                    if (i < b || str.charAt(i) != '?') {
                        a3 = i;
                    } else {
                        a3 = gy.m20780a(str, i, b, '#');
                        this.f23858g = ge.m20642b(ge.m20634a(str, i + 1, a3, " \"'<>#", true, false, true, true));
                    }
                    if (a3 < b && str.charAt(a3) == '#') {
                        this.f23859h = ge.m20634a(str, a3 + 1, b, "", true, false, false, false);
                    }
                    return C5918a.f23846a;
                }
                i = a3 + 1;
                while (i < b) {
                    char charAt3 = str.charAt(i);
                    if ((charAt3 < 'a' || charAt3 > 'z') && ((charAt3 < 'A' || charAt3 > 'Z') && !((charAt3 >= '0' && charAt3 <= '9') || charAt3 == '+' || charAt3 == '-' || charAt3 == '.'))) {
                        if (charAt3 != ':') {
                            i = -1;
                        }
                        if (i == -1) {
                            if (str.regionMatches(true, a3, "https:", 0, 6)) {
                                if (str.regionMatches(true, a3, "http:", 0, 5)) {
                                    return C5918a.f23848c;
                                }
                                this.f23852a = "http";
                                a3 += 5;
                            } else {
                                this.f23852a = C2924g.f12888b;
                                a3 += 6;
                            }
                        } else if (geVar != null) {
                            return C5918a.f23847b;
                        } else {
                            this.f23852a = geVar.f23861a;
                        }
                        obj = null;
                        obj2 = null;
                        i = 0;
                        for (i2 = a3; i2 < b; i2++) {
                            charAt = str.charAt(i2);
                            if (charAt != '\\') {
                            }
                            i++;
                        }
                        if (i < 2) {
                        }
                        i2 = a3 + i;
                        while (true) {
                            a = gy.m20781a(str, i2, b, "@/\\?#");
                            if (a != b) {
                            }
                            switch (a != b ? str.charAt(a) : '￿') {
                                case '￿':
                                case '#':
                                case '/':
                                case '?':
                                case '\\':
                                    i = C5919a.m20624c(str, i2, a);
                                    if (i + 1 < a) {
                                        this.f23855d = C5919a.m20621a(str, i2, i);
                                        this.f23856e = ge.m20631a(this.f23852a);
                                    } else {
                                        this.f23855d = C5919a.m20621a(str, i2, i);
                                        this.f23856e = C5919a.m20625d(str, i + 1, a);
                                        if (this.f23856e == -1) {
                                            return C5918a.f23849d;
                                        }
                                    }
                                    if (this.f23855d == null) {
                                        a3 = a;
                                        break;
                                    }
                                    return C5918a.f23850e;
                                case '@':
                                    if (obj2 == null) {
                                        this.f23854c += "%40" + ge.m20634a(str, i2, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                        obj3 = obj2;
                                        obj4 = obj;
                                    } else {
                                        a3 = gy.m20780a(str, i2, a, ':');
                                        a2 = ge.m20634a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                        if (obj != null) {
                                            a2 = this.f23853b + "%40" + a2;
                                        }
                                        this.f23853b = a2;
                                        if (a3 != a) {
                                            obj2 = 1;
                                            this.f23854c = ge.m20634a(str, a3 + 1, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                        }
                                        obj3 = obj2;
                                        obj4 = 1;
                                    }
                                    obj2 = obj3;
                                    obj = obj4;
                                    i2 = a + 1;
                                    continue;
                                    continue;
                                    continue;
                                default:
                                    continue;
                                    continue;
                                    continue;
                            }
                            i = gy.m20781a(str, a3, b, "?#");
                            m20623b(str, a3, i);
                            if (i < b) {
                            }
                            a3 = i;
                            this.f23859h = ge.m20634a(str, a3 + 1, b, "", true, false, false, false);
                            return C5918a.f23846a;
                        }
                    }
                    i++;
                }
            }
            i = -1;
            if (i == -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.f23852a = C2924g.f12888b;
                    a3 += 6;
                } else {
                    if (str.regionMatches(true, a3, "http:", 0, 5)) {
                        return C5918a.f23848c;
                    }
                    this.f23852a = "http";
                    a3 += 5;
                }
            } else if (geVar != null) {
                return C5918a.f23847b;
            } else {
                this.f23852a = geVar.f23861a;
            }
            obj = null;
            obj2 = null;
            i = 0;
            for (i2 = a3; i2 < b; i2++) {
                charAt = str.charAt(i2);
                if (charAt != '\\') {
                }
                i++;
            }
            if (i < 2) {
            }
            i2 = a3 + i;
            while (true) {
                a = gy.m20781a(str, i2, b, "@/\\?#");
                if (a != b) {
                }
                switch (a != b ? str.charAt(a) : '￿') {
                    case '￿':
                    case '#':
                    case '/':
                    case '?':
                    case '\\':
                        i = C5919a.m20624c(str, i2, a);
                        if (i + 1 < a) {
                            this.f23855d = C5919a.m20621a(str, i2, i);
                            this.f23856e = C5919a.m20625d(str, i + 1, a);
                            if (this.f23856e == -1) {
                                return C5918a.f23849d;
                            }
                        }
                        this.f23855d = C5919a.m20621a(str, i2, i);
                        this.f23856e = ge.m20631a(this.f23852a);
                        if (this.f23855d == null) {
                            a3 = a;
                            break;
                        }
                        return C5918a.f23850e;
                    case '@':
                        if (obj2 == null) {
                            a3 = gy.m20780a(str, i2, a, ':');
                            a2 = ge.m20634a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (obj != null) {
                                a2 = this.f23853b + "%40" + a2;
                            }
                            this.f23853b = a2;
                            if (a3 != a) {
                                obj2 = 1;
                                this.f23854c = ge.m20634a(str, a3 + 1, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            obj3 = obj2;
                            obj4 = 1;
                        } else {
                            this.f23854c += "%40" + ge.m20634a(str, i2, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            obj3 = obj2;
                            obj4 = obj;
                        }
                        obj2 = obj3;
                        obj = obj4;
                        i2 = a + 1;
                        continue;
                        continue;
                        continue;
                    default:
                        continue;
                        continue;
                        continue;
                }
                i = gy.m20781a(str, a3, b, "?#");
                m20623b(str, a3, i);
                if (i < b) {
                }
                a3 = i;
                this.f23859h = ge.m20634a(str, a3 + 1, b, "", true, false, false, false);
                return C5918a.f23846a;
            }
        }

        /* renamed from: b */
        private void m20623b(String str, int i, int i2) {
            if (i != i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.f23857f.clear();
                    this.f23857f.add("");
                    i3 = i + 1;
                } else {
                    this.f23857f.set(this.f23857f.size() - 1, "");
                    i3 = i;
                }
                while (i3 < i2) {
                    boolean z;
                    boolean z2;
                    int a = gy.m20781a(str, i3, i2, "/\\");
                    if (a < i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    String a2 = ge.m20634a(str, i3, a, " \"<>^`{}|/\\?#", true, false, false, true);
                    if (a2.equals(".") || a2.equalsIgnoreCase("%2e")) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        if (a2.equals("..") || a2.equalsIgnoreCase("%2e.") || a2.equalsIgnoreCase(".%2e") || a2.equalsIgnoreCase("%2e%2e")) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            if (((String) this.f23857f.get(this.f23857f.size() - 1)).isEmpty()) {
                                this.f23857f.set(this.f23857f.size() - 1, a2);
                            } else {
                                this.f23857f.add(a2);
                            }
                            if (z) {
                                this.f23857f.add("");
                            }
                        } else if (!((String) this.f23857f.remove(this.f23857f.size() - 1)).isEmpty() || this.f23857f.isEmpty()) {
                            this.f23857f.add("");
                        } else {
                            this.f23857f.set(this.f23857f.size() - 1, "");
                        }
                    }
                    if (z) {
                        a++;
                    }
                    i3 = a;
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        private static int m20624c(java.lang.String r3, int r4, int r5) {
            /*
            r0 = r4;
        L_0x0001:
            if (r0 >= r5) goto L_0x001a;
        L_0x0003:
            r1 = r3.charAt(r0);
            switch(r1) {
                case 58: goto L_0x001b;
                case 91: goto L_0x000d;
                default: goto L_0x000a;
            };
        L_0x000a:
            r0 = r0 + 1;
            goto L_0x0001;
        L_0x000d:
            r0 = r0 + 1;
            if (r0 >= r5) goto L_0x000a;
        L_0x0011:
            r1 = r3.charAt(r0);
            r2 = 93;
            if (r1 != r2) goto L_0x000d;
        L_0x0019:
            goto L_0x000a;
        L_0x001a:
            r0 = r5;
        L_0x001b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.ge.a.c(java.lang.String, int, int):int");
        }

        /* renamed from: a */
        static String m20621a(String str, int i, int i2) {
            int i3 = 0;
            String a = ge.m20635a(str, i, i2, false);
            if (!a.startsWith("[") || !a.endsWith("]")) {
                return gy.m20784a(a);
            }
            InetAddress a2 = C5919a.m20622a(a, a.length() - 1);
            if (a2 == null) {
                return null;
            }
            byte[] address = a2.getAddress();
            if (address.length == 16) {
                int i4 = 0;
                int i5 = -1;
                int i6 = 0;
                while (i6 < address.length) {
                    int i7 = i6;
                    while (i7 < 16 && address[i7] == (byte) 0 && address[i7 + 1] == (byte) 0) {
                        i7 += 2;
                    }
                    int i8 = i7 - i6;
                    if (i8 > i4) {
                        i4 = i8;
                        i5 = i6;
                    }
                    i6 = i7 + 2;
                }
                in inVar = new in();
                while (i3 < address.length) {
                    if (i3 == i5) {
                        inVar.b(58);
                        i3 += i4;
                        if (i3 == 16) {
                            inVar.b(58);
                        }
                    } else {
                        if (i3 > 0) {
                            inVar.b(58);
                        }
                        inVar.h((long) (((address[i3] & 255) << 8) | (address[i3 + 1] & 255)));
                        i3 += 2;
                    }
                }
                return inVar.l();
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        private static InetAddress m20622a(String str, int i) {
            Object obj = new byte[16];
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            int i5 = 1;
            while (i5 < i) {
                if (i2 == 16) {
                    return null;
                }
                int i6;
                int i7;
                if (i5 + 2 > i || !str.regionMatches(i5, "::", 0, 2)) {
                    if (i2 != 0) {
                        if (str.regionMatches(i5, Config.TRACE_TODAY_VISIT_SPLIT, 0, 1)) {
                            i5++;
                        } else if (!str.regionMatches(i5, ".", 0, 1)) {
                            return null;
                        } else {
                            Object obj2;
                            int i8 = i2 - 2;
                            i6 = i8;
                            i5 = i4;
                            loop2:
                            while (i5 < i) {
                                if (i6 == 16) {
                                    obj2 = null;
                                    break;
                                }
                                if (i6 != i8) {
                                    if (str.charAt(i5) != '.') {
                                        obj2 = null;
                                        break;
                                    }
                                    i5++;
                                }
                                i7 = 0;
                                i4 = i5;
                                while (i4 < i) {
                                    char charAt = str.charAt(i4);
                                    if (charAt >= '0' && charAt <= '9') {
                                        if (i7 == 0 && i5 != i4) {
                                            obj2 = null;
                                            break loop2;
                                        }
                                        i7 = ((i7 * 10) + charAt) - 48;
                                        if (i7 > 255) {
                                            obj2 = null;
                                            break loop2;
                                        }
                                        i4++;
                                    } else {
                                        break;
                                    }
                                }
                                if (i4 - i5 == 0) {
                                    obj2 = null;
                                    break;
                                }
                                i5 = i6 + 1;
                                obj[i6] = (byte) i7;
                                i6 = i5;
                                i5 = i4;
                            }
                            if (i6 != i8 + 4) {
                                obj2 = null;
                            } else {
                                obj2 = 1;
                            }
                            if (obj2 == null) {
                                return null;
                            }
                            i2 += 2;
                        }
                    }
                } else if (i3 != -1) {
                    return null;
                } else {
                    i5 += 2;
                    i3 = i2 + 2;
                    if (i5 == i) {
                        i2 = i3;
                        break;
                    }
                    i2 = i3;
                }
                i7 = 0;
                i4 = i5;
                while (i4 < i) {
                    i6 = ge.m20630a(str.charAt(i4));
                    if (i6 == -1) {
                        break;
                    }
                    i7 = (i7 << 4) + i6;
                    i4++;
                }
                i6 = i4 - i5;
                if (i6 == 0 || i6 > 4) {
                    return null;
                }
                i6 = i2 + 1;
                obj[i2] = (byte) ((i7 >>> 8) & 255);
                i2 = i6 + 1;
                obj[i6] = (byte) (i7 & 255);
                int i9 = i4;
                i4 = i5;
                i5 = i9;
            }
            if (i2 != 16) {
                if (i3 == -1) {
                    return null;
                }
                System.arraycopy(obj, i3, obj, 16 - (i2 - i3), i2 - i3);
                Arrays.fill(obj, i3, (16 - i2) + i3, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(obj);
            } catch (UnknownHostException e) {
                throw new AssertionError();
            }
        }

        /* renamed from: d */
        private static int m20625d(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(ge.m20634a(str, i, i2, "", false, false, false, true));
                return (parseInt <= 0 || parseInt > 65535) ? -1 : parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    private ge(C5919a c5919a) {
        String str = null;
        this.f23861a = c5919a.f23852a;
        this.f23864e = m20637a(c5919a.f23853b, false);
        this.f23865f = m20637a(c5919a.f23854c, false);
        this.f23862b = c5919a.f23855d;
        this.f23863c = c5919a.m20626a();
        this.f23866g = m20638a(c5919a.f23857f, false);
        this.f23867h = c5919a.f23858g != null ? m20638a(c5919a.f23858g, true) : null;
        if (c5919a.f23859h != null) {
            str = m20637a(c5919a.f23859h, false);
        }
        this.f23868i = str;
        this.f23869j = c5919a.toString();
    }

    /* renamed from: a */
    public final URI m20646a() {
        String str;
        int i;
        C5919a c5919a = new C5919a();
        c5919a.f23852a = this.f23861a;
        c5919a.f23853b = m20647b();
        c5919a.f23854c = m20649c();
        c5919a.f23855d = this.f23862b;
        c5919a.f23856e = this.f23863c != m20631a(this.f23861a) ? this.f23863c : -1;
        c5919a.f23857f.clear();
        c5919a.f23857f.addAll(m20651e());
        c5919a.m20628a(m20652f());
        if (this.f23868i == null) {
            str = null;
        } else {
            str = this.f23869j.substring(this.f23869j.indexOf(35) + 1);
        }
        c5919a.f23859h = str;
        int size = c5919a.f23857f.size();
        for (i = 0; i < size; i++) {
            c5919a.f23857f.set(i, m20636a((String) c5919a.f23857f.get(i), "[]", true, false, true));
        }
        if (c5919a.f23858g != null) {
            size = c5919a.f23858g.size();
            for (i = 0; i < size; i++) {
                str = (String) c5919a.f23858g.get(i);
                if (str != null) {
                    c5919a.f23858g.set(i, m20636a(str, "\\^`{|}", true, true, true));
                }
            }
        }
        if (c5919a.f23859h != null) {
            c5919a.f23859h = m20636a(c5919a.f23859h, " \"#<>\\^`{|}", true, false, false);
        }
        String c5919a2 = c5919a.toString();
        try {
            return new URI(c5919a2);
        } catch (Throwable e) {
            try {
                return URI.create(c5919a2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: b */
    public final String m20647b() {
        if (this.f23864e.isEmpty()) {
            return "";
        }
        int length = this.f23861a.length() + 3;
        return this.f23869j.substring(length, gy.m20781a(this.f23869j, length, this.f23869j.length(), ":@"));
    }

    /* renamed from: c */
    public final String m20649c() {
        if (this.f23865f.isEmpty()) {
            return "";
        }
        return this.f23869j.substring(this.f23869j.indexOf(58, this.f23861a.length() + 3) + 1, this.f23869j.indexOf(64));
    }

    /* renamed from: a */
    public static int m20631a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals(C2924g.f12888b)) {
            return 443;
        }
        return -1;
    }

    /* renamed from: d */
    public final String m20650d() {
        int indexOf = this.f23869j.indexOf(47, this.f23861a.length() + 3);
        return this.f23869j.substring(indexOf, gy.m20781a(this.f23869j, indexOf, this.f23869j.length(), "?#"));
    }

    /* renamed from: a */
    static void m20639a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    /* renamed from: e */
    public final List<String> m20651e() {
        int indexOf = this.f23869j.indexOf(47, this.f23861a.length() + 3);
        int a = gy.m20781a(this.f23869j, indexOf, this.f23869j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            indexOf = gy.m20780a(this.f23869j, i, a, '/');
            arrayList.add(this.f23869j.substring(i, indexOf));
        }
        return arrayList;
    }

    /* renamed from: f */
    public final String m20652f() {
        if (this.f23867h == null) {
            return null;
        }
        int indexOf = this.f23869j.indexOf(63) + 1;
        return this.f23869j.substring(indexOf, gy.m20780a(this.f23869j, indexOf + 1, this.f23869j.length(), '#'));
    }

    /* renamed from: b */
    static void m20643b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    /* renamed from: b */
    static List<String> m20642b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: g */
    public final String m20653g() {
        if (this.f23867h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        m20643b(stringBuilder, this.f23867h);
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public final ge m20648c(String str) {
        C5919a c5919a = new C5919a();
        if (c5919a.m20627a(this, str) != C5918a.f23846a) {
            c5919a = null;
        }
        if (c5919a != null) {
            return c5919a.m20629b();
        }
        return null;
    }

    /* renamed from: d */
    public static ge m20645d(String str) {
        C5919a c5919a = new C5919a();
        if (c5919a.m20627a(null, str) == C5918a.f23846a) {
            return c5919a.m20629b();
        }
        return null;
    }

    /* renamed from: a */
    public static ge m20632a(URL url) {
        return m20645d(url.toString());
    }

    public final boolean equals(Object o) {
        return (o instanceof ge) && ((ge) o).f23869j.equals(this.f23869j);
    }

    public final int hashCode() {
        return this.f23869j.hashCode();
    }

    public final String toString() {
        return this.f23869j;
    }

    /* renamed from: a */
    private static String m20637a(String str, boolean z) {
        return m20635a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private static List<String> m20638a(List<String> list, boolean z) {
        List arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(str != null ? m20637a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m20635a(String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                in inVar = new in();
                inVar.a(str, i, i3);
                while (i3 < i2) {
                    int codePointAt = str.codePointAt(i3);
                    if (codePointAt != 37 || i3 + 2 >= i2) {
                        if (codePointAt == 43 && z) {
                            inVar.b(32);
                        }
                        inVar.a(codePointAt);
                    } else {
                        int a = m20630a(str.charAt(i3 + 1));
                        int a2 = m20630a(str.charAt(i3 + 2));
                        if (!(a == -1 || a2 == -1)) {
                            inVar.b((a << 4) + a2);
                            i3 += 2;
                        }
                        inVar.a(codePointAt);
                    }
                    i3 += Character.charCount(codePointAt);
                }
                return inVar.l();
            }
            i3++;
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    private static boolean m20640a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && m20630a(str.charAt(i + 1)) != -1 && m20630a(str.charAt(i + 2)) != -1;
    }

    /* renamed from: a */
    static int m20630a(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 65) + 10;
    }

    /* renamed from: a */
    static String m20634a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == TransportMediator.KEYCODE_MEDIA_PAUSE || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !m20640a(str, i3, i2)))) || (codePointAt == 43 && z3)))) {
                in inVar = new in();
                inVar.a(str, i, i3);
                int i4 = i3;
                in inVar2 = null;
                while (i4 < i2) {
                    int codePointAt2 = str.codePointAt(i4);
                    if (!(z && (codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13))) {
                        if (codePointAt2 == 43 && z3) {
                            String str3;
                            if (z) {
                                str3 = "+";
                            } else {
                                str3 = "%2B";
                            }
                            inVar.a(str3);
                        } else if (codePointAt2 < 32 || codePointAt2 == TransportMediator.KEYCODE_MEDIA_PAUSE || ((codePointAt2 >= 128 && z4) || str2.indexOf(codePointAt2) != -1 || (codePointAt2 == 37 && (!z || (z2 && !m20640a(str, i4, i2)))))) {
                            if (inVar2 == null) {
                                inVar2 = new in();
                            }
                            inVar2.a(codePointAt2);
                            while (!inVar2.d()) {
                                codePointAt = inVar2.e() & 255;
                                inVar.b(37);
                                inVar.b(f23860d[(codePointAt >> 4) & 15]);
                                inVar.b(f23860d[codePointAt & 15]);
                            }
                        } else {
                            inVar.a(codePointAt2);
                        }
                    }
                    i4 = Character.charCount(codePointAt2) + i4;
                }
                return inVar.l();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static String m20636a(String str, String str2, boolean z, boolean z2, boolean z3) {
        return m20634a(str, 0, str.length(), str2, true, z, z2, z3);
    }
}
