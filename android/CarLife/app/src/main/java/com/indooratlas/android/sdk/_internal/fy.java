package com.indooratlas.android.sdk._internal;

import com.facebook.common.p262l.C5361b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p003b.p004a.p009d.C0206d;

public final class fy {
    /* renamed from: c */
    private static final Pattern f23818c = Pattern.compile("(\\d{2,4})[^\\d]*");
    /* renamed from: d */
    private static final Pattern f23819d = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* renamed from: e */
    private static final Pattern f23820e = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* renamed from: f */
    private static final Pattern f23821f = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* renamed from: a */
    public final String f23822a;
    /* renamed from: b */
    public final String f23823b;
    /* renamed from: g */
    private final long f23824g;
    /* renamed from: h */
    private final String f23825h;
    /* renamed from: i */
    private final String f23826i;
    /* renamed from: j */
    private final boolean f23827j;
    /* renamed from: k */
    private final boolean f23828k;
    /* renamed from: l */
    private final boolean f23829l;
    /* renamed from: m */
    private final boolean f23830m;

    private fy(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f23822a = str;
        this.f23823b = str2;
        this.f23824g = j;
        this.f23825h = str3;
        this.f23826i = str4;
        this.f23827j = z;
        this.f23828k = z2;
        this.f23830m = z3;
        this.f23829l = z4;
    }

    /* renamed from: a */
    private static fy m20590a(long j, ge geVar, String str) {
        int length = str.length();
        int a = gy.m20780a(str, 0, length, ';');
        int a2 = gy.m20780a(str, 0, a, '=');
        if (a2 == a) {
            return null;
        }
        String c = gy.m20802c(str, 0, a2);
        if (c.isEmpty()) {
            return null;
        }
        String c2;
        String str2;
        String c3 = gy.m20802c(str, a2 + 1, a);
        long j2 = C0206d.f307a;
        long j3 = -1;
        String str3 = null;
        String str4 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        a++;
        while (a < length) {
            String str5;
            int a3 = gy.m20780a(str, a, length, ';');
            int a4 = gy.m20780a(str, a, a3, '=');
            String c4 = gy.m20802c(str, a, a4);
            c2 = a4 < a3 ? gy.m20802c(str, a4 + 1, a3) : "";
            if (c4.equalsIgnoreCase("expires")) {
                try {
                    int length2 = c2.length();
                    int a5 = m20588a(c2, 0, length2, false);
                    int i = -1;
                    int i2 = -1;
                    int i3 = -1;
                    int i4 = -1;
                    int i5 = -1;
                    a4 = -1;
                    Matcher matcher = f23821f.matcher(c2);
                    while (a5 < length2) {
                        int a6 = m20588a(c2, a5 + 1, length2, true);
                        matcher.region(a5, a6);
                        if (i == -1 && matcher.usePattern(f23821f).matches()) {
                            i = Integer.parseInt(matcher.group(1));
                            i2 = Integer.parseInt(matcher.group(2));
                            i3 = Integer.parseInt(matcher.group(3));
                        } else {
                            if (i4 == -1) {
                                if (matcher.usePattern(f23820e).matches()) {
                                    i4 = Integer.parseInt(matcher.group(1));
                                }
                            }
                            if (i5 == -1 && matcher.usePattern(f23819d).matches()) {
                                i5 = f23819d.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                            } else if (a4 == -1 && matcher.usePattern(f23818c).matches()) {
                                a4 = Integer.parseInt(matcher.group(1));
                            }
                        }
                        a5 = m20588a(c2, a6 + 1, length2, false);
                    }
                    if (a4 < 70 || a4 > 99) {
                        a = a4;
                    } else {
                        a = a4 + 1900;
                    }
                    if (a >= 0 && a <= 69) {
                        a += 2000;
                    }
                    if (a < 1601) {
                        throw new IllegalArgumentException();
                    } else if (i5 == -1) {
                        throw new IllegalArgumentException();
                    } else if (i4 <= 0 || i4 > 31) {
                        throw new IllegalArgumentException();
                    } else if (i < 0 || i > 23) {
                        throw new IllegalArgumentException();
                    } else if (i2 < 0 || i2 > 59) {
                        throw new IllegalArgumentException();
                    } else if (i3 < 0 || i3 > 59) {
                        throw new IllegalArgumentException();
                    } else {
                        Calendar gregorianCalendar = new GregorianCalendar(gy.f24043d);
                        gregorianCalendar.setLenient(false);
                        gregorianCalendar.set(1, a);
                        gregorianCalendar.set(2, i5 - 1);
                        gregorianCalendar.set(5, i4);
                        gregorianCalendar.set(11, i);
                        gregorianCalendar.set(12, i2);
                        gregorianCalendar.set(13, i3);
                        gregorianCalendar.set(14, 0);
                        j2 = gregorianCalendar.getTimeInMillis();
                        z4 = true;
                        c2 = str4;
                        str4 = str3;
                    }
                } catch (IllegalArgumentException e) {
                    c2 = str4;
                    str4 = str3;
                }
            } else if (c4.equalsIgnoreCase("max-age")) {
                try {
                    j3 = m20589a(c2);
                    z4 = true;
                    c2 = str4;
                    str4 = str3;
                } catch (NumberFormatException e2) {
                    c2 = str4;
                    str4 = str3;
                }
            } else if (c4.equalsIgnoreCase("domain")) {
                try {
                    if (c2.endsWith(".")) {
                        throw new IllegalArgumentException();
                    }
                    if (c2.startsWith(".")) {
                        c2 = c2.substring(1);
                    }
                    c2 = gy.m20784a(c2);
                    if (c2 == null) {
                        throw new IllegalArgumentException();
                    }
                    z3 = false;
                    str5 = str4;
                    str4 = c2;
                    c2 = str5;
                } catch (IllegalArgumentException e3) {
                    c2 = str4;
                    str4 = str3;
                }
            } else if (c4.equalsIgnoreCase("path")) {
                str4 = str3;
            } else {
                if (c4.equalsIgnoreCase("secure")) {
                    z = true;
                    c2 = str4;
                    str4 = str3;
                } else {
                    if (c4.equalsIgnoreCase("httponly")) {
                        z2 = true;
                        c2 = str4;
                        str4 = str3;
                    } else {
                        c2 = str4;
                        str4 = str3;
                    }
                }
            }
            str5 = c2;
            a = a3 + 1;
            str3 = str4;
            str4 = str5;
        }
        if (j3 == Long.MIN_VALUE) {
            j2 = Long.MIN_VALUE;
        } else if (j3 != -1) {
            j2 = j + (j3 <= 9223372036854775L ? j3 * 1000 : C5361b.f21945a);
            if (j2 < j || j2 > C0206d.f307a) {
                j2 = C0206d.f307a;
            }
        }
        if (str3 == null) {
            c2 = geVar.f23862b;
        } else {
            Object obj;
            str2 = geVar.f23862b;
            if (str2.equals(str3)) {
                obj = 1;
            } else if (str2.endsWith(str3) && str2.charAt((str2.length() - str3.length()) - 1) == '.' && !gy.m20800b(str2)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return null;
            }
            c2 = str3;
        }
        if (str4 == null || !str4.startsWith("/")) {
            str2 = geVar.m20650d();
            int lastIndexOf = str2.lastIndexOf(47);
            str4 = lastIndexOf != 0 ? str2.substring(0, lastIndexOf) : "/";
        }
        return new fy(c, c3, j2, c2, str4, z, z2, z3, z4);
    }

    /* renamed from: a */
    private static int m20588a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            Object obj;
            char charAt = str.charAt(i3);
            Object obj2 = ((charAt >= ' ' || charAt == '\t') && charAt < '' && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) ? null : 1;
            if (z) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj2 == obj) {
                return i3;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static long m20589a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return C5361b.f21945a;
            }
        }
    }

    /* renamed from: a */
    public static List<fy> m20591a(ge geVar, gd gdVar) {
        List unmodifiableList;
        String str = "Set-Cookie";
        int length = gdVar.f23845a.length / 2;
        List list = null;
        for (int i = 0; i < length; i++) {
            if (str.equalsIgnoreCase(gdVar.m20617a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(gdVar.m20619b(i));
            }
        }
        if (list != null) {
            unmodifiableList = Collections.unmodifiableList(list);
        } else {
            unmodifiableList = Collections.emptyList();
        }
        int size = unmodifiableList.size();
        List list2 = null;
        int i2 = 0;
        while (i2 < size) {
            fy a = m20590a(System.currentTimeMillis(), geVar, (String) unmodifiableList.get(i2));
            if (a != null) {
                if (list2 == null) {
                    list = new ArrayList();
                } else {
                    list = list2;
                }
                list.add(a);
            } else {
                list = list2;
            }
            i2++;
            list2 = list;
        }
        if (list2 != null) {
            return Collections.unmodifiableList(list2);
        }
        return Collections.emptyList();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f23822a);
        stringBuilder.append('=');
        stringBuilder.append(this.f23823b);
        if (this.f23829l) {
            if (this.f23824g == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(hu.m21040a(new Date(this.f23824g)));
            }
        }
        if (!this.f23830m) {
            stringBuilder.append("; domain=").append(this.f23825h);
        }
        stringBuilder.append("; path=").append(this.f23826i);
        if (this.f23827j) {
            stringBuilder.append("; secure");
        }
        if (this.f23828k) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }
}
