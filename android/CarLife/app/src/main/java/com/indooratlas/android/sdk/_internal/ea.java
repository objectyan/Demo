package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.net.wifi.ScanResult;

@TargetApi(17)
public abstract class ea {

    /* renamed from: com.indooratlas.android.sdk._internal.ea$a */
    static class C5863a extends ea {
        /* renamed from: a */
        private static final String f23499a = ee.m20406a(C5863a.class);
        /* renamed from: b */
        private final ef<String, Long> f23500b = new ef();
        /* renamed from: c */
        private final StringBuilder f23501c = new StringBuilder();

        C5863a() {
        }

        /* renamed from: a */
        private int m20386a() {
            int size;
            synchronized (this.f23500b) {
                size = this.f23500b.size();
            }
            return size;
        }

        /* renamed from: a */
        public final synchronized int mo4669a(ScanResult scanResult) {
            int i;
            synchronized (this.f23501c) {
                this.f23501c.setLength(0);
                String stringBuilder = this.f23501c.append(scanResult.SSID).append('|').append(scanResult.BSSID).toString();
                Long l = (Long) this.f23500b.get(stringBuilder);
                long j = scanResult.timestamp;
            }
            synchronized (this.f23500b) {
                if (l == null) {
                    this.f23500b.put(stringBuilder, Long.valueOf(j));
                    i = 1;
                } else if (l.longValue() == j) {
                    r0 = new Object[]{Integer.valueOf(m20386a()), scanResult};
                    i = -1;
                } else if (j > l.longValue()) {
                    r0 = new Object[]{Integer.valueOf(m20386a()), scanResult};
                    this.f23500b.put(stringBuilder, Long.valueOf(j));
                    i = 2;
                } else {
                    r0 = new Object[]{Integer.valueOf(m20386a()), scanResult};
                    this.f23500b.put(stringBuilder, Long.valueOf(j));
                    i = 3;
                }
            }
            return i;
        }
    }

    /* renamed from: a */
    public abstract int mo4669a(ScanResult scanResult);
}
