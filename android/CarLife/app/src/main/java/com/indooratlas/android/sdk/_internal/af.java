package com.indooratlas.android.sdk._internal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public final class af {
    /* renamed from: a */
    public static final String f22931a = ee.m20407a("BackendWire");

    /* renamed from: a */
    public static boolean m19798a(CharSequence charSequence) {
        return charSequence == null || charSequence.toString().trim().equals("");
    }

    /* renamed from: a */
    public static Date m19797a(String str) throws ParseException {
        return m19799b().parse(str);
    }

    /* renamed from: a */
    public static String m19796a() {
        return m19799b().format(C6010v.d().b());
    }

    /* renamed from: b */
    private static DateFormat m19799b() {
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(2, "UTC"));
        return simpleDateFormat;
    }
}
