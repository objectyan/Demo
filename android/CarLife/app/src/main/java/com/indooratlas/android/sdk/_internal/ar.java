package com.indooratlas.android.sdk._internal;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.LinkedList;

public class ar {
    /* renamed from: a */
    private static ar f22991a = null;
    /* renamed from: b */
    private LinkedList<as> f22992b = new LinkedList();

    /* renamed from: com.indooratlas.android.sdk._internal.ar$a */
    static class C5766a implements as {
        private C5766a() {
        }

        /* renamed from: a */
        public final String mo4600a(C5768c c5768c) {
            switch (c5768c) {
                case ID:
                    return Build.ID;
                case DISPLAY:
                    return Build.DISPLAY;
                case PRODUCT:
                    return Build.PRODUCT;
                case DEVICE:
                    return Build.DEVICE;
                case BOARD:
                    return Build.BOARD;
                case MANUFACTURER:
                    return Build.MANUFACTURER;
                case BRAND:
                    return Build.BRAND;
                case MODEL:
                    return Build.MODEL;
                case BOOTLOADER:
                    return Build.BOOTLOADER;
                case HARDWARE:
                    return Build.HARDWARE;
                case SERIAL:
                    return Build.SERIAL;
                case VERSION_INCREMENTAL:
                    return VERSION.INCREMENTAL;
                case VERSION_RELEASE:
                    return VERSION.RELEASE;
                case VERSION_BASE_OS:
                    if (VERSION.SDK_INT < 23) {
                        return "unknown";
                    }
                    return VERSION.BASE_OS;
                case VERSION_SECURITY_PATCH:
                    if (VERSION.SDK_INT < 23) {
                        return "unknown";
                    }
                    return VERSION.SECURITY_PATCH;
                default:
                    throw new RuntimeException("IAEnvironmentManager broken: " + c5768c);
            }
        }

        /* renamed from: a */
        public final int mo4599a(C5767b c5767b) {
            switch (c5767b) {
                case f22973a:
                    return VERSION.SDK_INT;
                default:
                    throw new RuntimeException("IAEnvironmentManager broken " + c5767b);
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ar$b */
    public enum C5767b {
        ;

        private C5767b(String str) {
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ar$c */
    public enum C5768c {
        ID,
        DISPLAY,
        PRODUCT,
        DEVICE,
        BOARD,
        MANUFACTURER,
        BRAND,
        MODEL,
        BOOTLOADER,
        HARDWARE,
        SERIAL,
        VERSION_INCREMENTAL,
        VERSION_RELEASE,
        VERSION_BASE_OS,
        VERSION_SECURITY_PATCH
    }

    private ar() {
        this.f22992b.add(new C5766a());
    }

    /* renamed from: a */
    public static ar m19847a() {
        synchronized (ar.class) {
            if (f22991a == null) {
                f22991a = new ar();
            }
        }
        return f22991a;
    }

    /* renamed from: a */
    public final String m19849a(C5768c c5768c) {
        String a;
        synchronized (this.f22992b) {
            Iterator it = this.f22992b.iterator();
            if (it.hasNext()) {
                a = ((as) it.next()).mo4600a(c5768c);
            } else {
                a = "unknown";
            }
        }
        return a;
    }

    /* renamed from: a */
    public final int m19848a(C5767b c5767b) {
        int a;
        synchronized (this.f22992b) {
            Iterator it = this.f22992b.iterator();
            if (it.hasNext()) {
                a = ((as) it.next()).mo4599a(c5767b);
            } else {
                a = -1;
            }
        }
        return a;
    }
}
