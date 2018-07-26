package com.tencent.wxop.stat.p291b;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* renamed from: com.tencent.wxop.stat.b.t */
final class C6151t implements Comparator<ScanResult> {
    C6151t() {
    }

    /* renamed from: a */
    public final int m21928a(ScanResult scanResult, ScanResult scanResult2) {
        int abs = Math.abs(scanResult.level);
        int abs2 = Math.abs(scanResult2.level);
        return abs > abs2 ? 1 : abs == abs2 ? 0 : -1;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return m21928a((ScanResult) obj, (ScanResult) obj2);
    }
}
