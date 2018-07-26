package com.baidu.mobstat;

import java.io.File;
import java.util.Comparator;

class an implements Comparator<File> {
    /* renamed from: a */
    final /* synthetic */ al f19391a;

    an(al alVar) {
        this.f19391a = alVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15346a((File) obj, (File) obj2);
    }

    /* renamed from: a */
    public int m15346a(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }
}
