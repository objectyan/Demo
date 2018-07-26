package com.facebook.common.p253d;

import java.io.File;

/* compiled from: FileTree */
/* renamed from: com.facebook.common.d.a */
public class C5314a {
    /* renamed from: a */
    public static void m18113a(File directory, C5257b visitor) {
        visitor.mo3946a(directory);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    C5314a.m18113a(file, visitor);
                } else {
                    visitor.mo3947b(file);
                }
            }
        }
        visitor.mo3948c(directory);
    }

    /* renamed from: a */
    public static boolean m18114a(File directory) {
        File[] files = directory.listFiles();
        boolean success = true;
        if (files != null) {
            for (File file : files) {
                success &= C5314a.m18115b(file);
            }
        }
        return success;
    }

    /* renamed from: b */
    public static boolean m18115b(File file) {
        if (file.isDirectory()) {
            C5314a.m18114a(file);
        }
        return file.delete();
    }
}
