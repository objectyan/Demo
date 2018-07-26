package com.tencent.wxop.stat.p291b;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: com.tencent.wxop.stat.b.o */
class C6146o implements FileFilter {
    C6146o() {
    }

    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
