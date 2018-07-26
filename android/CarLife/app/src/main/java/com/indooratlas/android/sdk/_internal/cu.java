package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.util.Comparator;

public final class cu implements Comparator<dx> {
    /* renamed from: a */
    public static final cu f23357a = new cu();

    @TargetApi(17)
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        dx dxVar = (dx) obj;
        dx dxVar2 = (dx) obj2;
        if (VERSION.SDK_INT >= 17) {
            long j = dxVar.f23487j;
            long j2 = dxVar2.f23487j;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
        }
        return 0;
    }
}
