package com.baidu.mobstat;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class df implements Comparator<ScanResult> {
    df() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15712a((ScanResult) obj, (ScanResult) obj2);
    }

    /* renamed from: a */
    public int m15712a(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
