package com.indooratlas.android.sdk._internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class gd {
    /* renamed from: a */
    public final String[] f23845a;

    /* renamed from: com.indooratlas.android.sdk._internal.gd$a */
    public static final class C5917a {
        /* renamed from: a */
        final List<String> f23844a = new ArrayList(20);

        /* renamed from: a */
        public final C5917a m20612a(String str, String str2) {
            C5917a.m20610d(str, str2);
            return m20614b(str, str2);
        }

        /* renamed from: b */
        final C5917a m20614b(String str, String str2) {
            this.f23844a.add(str);
            this.f23844a.add(str2.trim());
            return this;
        }

        /* renamed from: a */
        public final C5917a m20611a(String str) {
            int i = 0;
            while (i < this.f23844a.size()) {
                if (str.equalsIgnoreCase((String) this.f23844a.get(i))) {
                    this.f23844a.remove(i);
                    this.f23844a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: c */
        public final C5917a m20615c(String str, String str2) {
            C5917a.m20610d(str, str2);
            m20611a(str);
            m20614b(str, str2);
            return this;
        }

        /* renamed from: d */
        private static void m20610d(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                int i;
                char charAt;
                int length = str.length();
                for (i = 0; i < length; i++) {
                    charAt = str.charAt(i);
                    if (charAt <= '\u001f' || charAt >= '') {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i), str}));
                    }
                }
                if (str2 == null) {
                    throw new IllegalArgumentException("value == null");
                }
                length = str2.length();
                for (i = 0; i < length; i++) {
                    charAt = str2.charAt(i);
                    if (charAt <= '\u001f' || charAt >= '') {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i), str, str2}));
                    }
                }
            }
        }

        /* renamed from: a */
        public final gd m20613a() {
            return new gd();
        }
    }

    private gd(C5917a c5917a) {
        this.f23845a = (String[]) c5917a.f23844a.toArray(new String[c5917a.f23844a.size()]);
    }

    /* renamed from: a */
    public final String m20618a(String str) {
        String[] strArr = this.f23845a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: b */
    public final Date m20620b(String str) {
        String a = m20618a(str);
        return a != null ? hu.m21041a(a) : null;
    }

    /* renamed from: a */
    public final String m20617a(int i) {
        return this.f23845a[i * 2];
    }

    /* renamed from: b */
    public final String m20619b(int i) {
        return this.f23845a[(i * 2) + 1];
    }

    /* renamed from: a */
    public final C5917a m20616a() {
        C5917a c5917a = new C5917a();
        Collections.addAll(c5917a.f23844a, this.f23845a);
        return c5917a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = this.f23845a.length / 2;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(m20617a(i)).append(": ").append(m20619b(i)).append("\n");
        }
        return stringBuilder.toString();
    }
}
