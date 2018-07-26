package com.indooratlas.android.sdk._internal;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gg {
    /* renamed from: b */
    private static final Pattern f23870b = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    /* renamed from: c */
    private static final Pattern f23871c = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    /* renamed from: a */
    final String f23872a;
    /* renamed from: d */
    private final String f23873d;
    /* renamed from: e */
    private final String f23874e;
    /* renamed from: f */
    private final String f23875f;

    private gg(String str, String str2, String str3, String str4) {
        this.f23873d = str;
        this.f23874e = str2;
        this.f23875f = str3;
        this.f23872a = str4;
    }

    /* renamed from: a */
    public static gg m20657a(String str) {
        Matcher matcher = f23870b.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f23871c.matcher(str);
        int end = matcher.end();
        String str2 = null;
        while (end < str.length()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group == null || !group.equalsIgnoreCase("charset")) {
                group = str2;
            } else {
                if (matcher2.group(2) != null) {
                    group = matcher2.group(2);
                } else {
                    group = matcher2.group(3);
                }
                if (!(str2 == null || r0.equalsIgnoreCase(str2))) {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
            String str3 = group;
            end = matcher2.end();
            str2 = str3;
        }
        return new gg(str, toLowerCase, toLowerCase2, str2);
    }

    public final String toString() {
        return this.f23873d;
    }

    public final boolean equals(Object o) {
        return (o instanceof gg) && ((gg) o).f23873d.equals(this.f23873d);
    }

    public final int hashCode() {
        return this.f23873d.hashCode();
    }
}
