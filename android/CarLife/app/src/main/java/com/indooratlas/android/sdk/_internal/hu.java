package com.indooratlas.android.sdk._internal;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.http.impl.cookie.DateUtils;

public final class hu {
    /* renamed from: a */
    private static final ThreadLocal<DateFormat> f24290a = new C59741();
    /* renamed from: b */
    private static final String[] f24291b = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", DateUtils.PATTERN_RFC1036, "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    /* renamed from: c */
    private static final DateFormat[] f24292c = new DateFormat[15];

    /* renamed from: com.indooratlas.android.sdk._internal.hu$1 */
    static class C59741 extends ThreadLocal<DateFormat> {
        C59741() {
        }

        protected final /* synthetic */ Object initialValue() {
            DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(gy.f24043d);
            return simpleDateFormat;
        }
    }

    /* renamed from: a */
    public static Date m21041a(String str) {
        int i = 0;
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) f24290a.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f24291b) {
            int length = f24291b.length;
            while (i < length) {
                DateFormat dateFormat = f24292c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f24291b[i], Locale.US);
                    dateFormat.setTimeZone(gy.f24043d);
                    f24292c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                parse = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse;
                }
                i++;
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m21040a(Date date) {
        return ((DateFormat) f24290a.get()).format(date);
    }
}
