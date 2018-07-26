package com.indooratlas.android.sdk._internal;

import android.support.v4.media.session.PlaybackStateCompat;

final class jb {
    /* renamed from: a */
    static ja f24436a;
    /* renamed from: b */
    static long f24437b;

    private jb() {
    }

    /* renamed from: a */
    static ja m21307a() {
        synchronized (jb.class) {
            if (f24436a != null) {
                ja jaVar = f24436a;
                f24436a = jaVar.f24434f;
                jaVar.f24434f = null;
                f24437b -= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                return jaVar;
            }
            return new ja();
        }
    }

    /* renamed from: a */
    static void m21308a(ja jaVar) {
        if (jaVar.f24434f != null || jaVar.f24435g != null) {
            throw new IllegalArgumentException();
        } else if (!jaVar.f24432d) {
            synchronized (jb.class) {
                if (f24437b + PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH > 65536) {
                    return;
                }
                f24437b += PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                jaVar.f24434f = f24436a;
                jaVar.f24431c = 0;
                jaVar.f24430b = 0;
                f24436a = jaVar;
            }
        }
    }
}
