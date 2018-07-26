package com.baidu.ufosdk.util;

import java.io.File;
import java.util.Comparator;

/* compiled from: CacheSD */
/* renamed from: com.baidu.ufosdk.util.g */
final class C5214g implements Comparator {
    /* renamed from: a */
    final /* synthetic */ C5213f f21703a;

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        if (file.lastModified() > file2.lastModified()) {
            return 1;
        }
        if (file.lastModified() == file2.lastModified()) {
            return 0;
        }
        return -1;
    }

    C5214g(C5213f c5213f) {
        this.f21703a = c5213f;
    }
}
