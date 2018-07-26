package com.baidu.mapframework.nirvana;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolProfile */
/* renamed from: com.baidu.mapframework.nirvana.m */
public class C3559m {
    /* renamed from: a */
    List<C3558a> f19217a = new ArrayList();

    /* compiled from: ThreadPoolProfile */
    /* renamed from: com.baidu.mapframework.nirvana.m$a */
    public static class C3558a {
        /* renamed from: a */
        public String f19214a;
        /* renamed from: b */
        public long f19215b;
        /* renamed from: c */
        public long f19216c;

        public String toString() {
            return "[" + this.f19214a + "|" + this.f19215b + "," + this.f19216c + ", dur:" + TimeUnit.NANOSECONDS.toMillis(this.f19216c - this.f19215b) + " ms ]";
        }
    }

    /* renamed from: a */
    private long m15207a() {
        long result = 0;
        for (C3558a item : this.f19217a) {
            result += item.f19216c - item.f19215b;
        }
        return result;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Task size:").append(this.f19217a.size()).append(", Total execution time:").append(TimeUnit.NANOSECONDS.toMillis(m15207a()) + " ms");
        stringBuilder.append("\n");
        for (C3558a item : this.f19217a) {
            stringBuilder.append(item).append("\n");
        }
        return stringBuilder.toString();
    }
}
