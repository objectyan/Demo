package com.baidu.mobstat;

import java.io.File;
import java.io.FilenameFilter;

class cd implements FilenameFilter {
    /* renamed from: a */
    final /* synthetic */ cc f19553a;

    cd(cc ccVar) {
        this.f19553a = ccVar;
    }

    public boolean accept(File file, String str) {
        if (str.startsWith(Config.PREFIX_SEND_DATA)) {
            return true;
        }
        return false;
    }
}
