package com.baidu.location.p191d.p192a;

import android.net.wifi.ScanResult;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.location.d.a.h */
class C3279h {

    /* renamed from: com.baidu.location.d.a.h$a */
    private static class C3278a {
        /* renamed from: a */
        private int[] f17787a;
        /* renamed from: b */
        private int[] f17788b;

        public C3278a(int i) {
            if (i > 0) {
                this.f17787a = new int[i];
                this.f17788b = new int[i];
                for (int i2 = 0; i2 < i; i2++) {
                    this.f17787a[i2] = i2;
                    this.f17788b[i2] = 1;
                }
            }
        }

        /* renamed from: a */
        public int m13717a(int i) {
            return (this.f17787a == null || i < 0 || i >= this.f17787a.length) ? -1 : i == this.f17787a[i] ? 1 : 0;
        }

        /* renamed from: a */
        public int m13718a(int i, int i2) {
            if (this.f17787a == null || i < 0 || i >= this.f17787a.length || i2 < 0 || i2 >= this.f17787a.length) {
                return -1;
            }
            int c = m13720c(i);
            int c2 = m13720c(i2);
            if (c == c2) {
                return 0;
            }
            int[] iArr = this.f17788b;
            iArr[c] = iArr[c] + this.f17788b[c2];
            this.f17787a[c2] = c;
            return 1;
        }

        /* renamed from: b */
        public int m13719b(int i) {
            return (this.f17788b == null || i < 0 || i >= this.f17788b.length) ? -1 : this.f17788b[i];
        }

        /* renamed from: c */
        public int m13720c(int i) {
            if (this.f17787a == null || i < 0 || i >= this.f17787a.length) {
                return -1;
            }
            while (i != this.f17787a[i]) {
                this.f17787a[i] = this.f17787a[this.f17787a[i]];
                i = this.f17787a[i];
            }
            return i;
        }
    }

    /* renamed from: a */
    static boolean m13721a(String str, String str2) {
        if (str == null || str2 == null || str.length() != 12 || str2.length() != 12) {
            return false;
        }
        byte[] bytes = str.getBytes();
        byte[] bytes2 = str2.getBytes();
        int i = 0;
        for (int i2 = 0; i2 < 12; i2++) {
            if (bytes[i2] == bytes2[i2]) {
                i++;
            }
        }
        return i >= 8;
    }

    /* renamed from: a */
    public static boolean m13722a(List<ScanResult> list) {
        if (list == null) {
            return false;
        }
        int i;
        ArrayList arrayList = new ArrayList(list.size());
        for (i = 0; i < list.size(); i++) {
            String replace = ((ScanResult) list.get(i)).BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
            if (replace.length() == 12) {
                arrayList.add(replace);
            }
        }
        int size = arrayList.size();
        if (size < 3) {
            return false;
        }
        C3278a c3278a = new C3278a(size);
        for (int i2 = 0; i2 < size; i2++) {
            for (int i3 = i2 + 1; i3 < size; i3++) {
                if (C3279h.m13721a((String) arrayList.get(i2), (String) arrayList.get(i3))) {
                    c3278a.m13718a(i2, i3);
                }
            }
        }
        i = 0;
        int i4 = 0;
        while (i < size) {
            if (c3278a.m13717a(i) == 1 && c3278a.m13719b(i) >= 3) {
                i4 += c3278a.m13719b(i);
            }
            i++;
        }
        return i4 * 2 > size;
    }
}
