package com.indooratlas.android.sdk._internal;

import com.baidu.navi.fragment.NaviFragmentManager;
import java.util.Arrays;

/* renamed from: com.indooratlas.android.sdk._internal.q */
final class C6005q {
    /* renamed from: a */
    final int f24571a;
    /* renamed from: b */
    final byte[] f24572b;

    C6005q(int i, byte[] bArr) {
        this.f24571a = i;
        this.f24572b = bArr;
    }

    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C6005q)) {
            return false;
        }
        C6005q c6005q = (C6005q) o;
        if (this.f24571a == c6005q.f24571a && Arrays.equals(this.f24572b, c6005q.f24572b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f24571a + NaviFragmentManager.TYPE_PHONE_END) * 31) + Arrays.hashCode(this.f24572b);
    }
}
