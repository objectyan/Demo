package com.facebook.p135b.p137b;

import com.facebook.common.internal.VisibleForTesting;
import java.io.File;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: DynamicDefaultDiskStorage */
/* renamed from: com.facebook.b.b.g$a */
class g$a {
    @Nullable
    /* renamed from: a */
    public final C5266d f12857a;
    @Nullable
    /* renamed from: b */
    public final File f12858b;

    @VisibleForTesting
    g$a(@Nullable File rootDirectory, @Nullable C5266d delegate) {
        this.f12857a = delegate;
        this.f12858b = rootDirectory;
    }
}
