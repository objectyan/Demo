package com.indooratlas.android.sdk._internal;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

public final class da {
    @Nullable
    /* renamed from: a */
    public final Handler f23372a;
    @Nullable
    /* renamed from: b */
    public final Bundle f23373b;
    /* renamed from: c */
    public final int f23374c;

    /* renamed from: com.indooratlas.android.sdk._internal.da$a */
    public static class C5846a {
        /* renamed from: a */
        public Handler f23369a = null;
        /* renamed from: b */
        public Bundle f23370b;
        /* renamed from: c */
        public int f23371c;

        /* renamed from: a */
        public final Bundle m20292a() {
            if (this.f23370b == null) {
                this.f23370b = new Bundle(1);
            }
            return this.f23370b;
        }

        /* renamed from: b */
        public final da m20293b() {
            return new da();
        }
    }

    private da(C5846a c5846a) {
        this.f23372a = c5846a.f23369a;
        this.f23373b = c5846a.f23370b;
        this.f23374c = c5846a.f23371c;
    }
}
