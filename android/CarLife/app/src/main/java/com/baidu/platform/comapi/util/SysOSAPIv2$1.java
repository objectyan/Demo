package com.baidu.platform.comapi.util;

import java.io.File;
import java.io.FilenameFilter;

class SysOSAPIv2$1 implements FilenameFilter {
    /* renamed from: a */
    final /* synthetic */ SysOSAPIv2 f19873a;

    SysOSAPIv2$1(SysOSAPIv2 this$0) {
        this.f19873a = this$0;
    }

    public boolean accept(File dir, String filename) {
        return filename.endsWith(".dat");
    }
}
