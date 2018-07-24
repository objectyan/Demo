package com.baidu.carlife.util;

import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

/* compiled from: MemorySpaceCheck */
/* renamed from: com.baidu.carlife.util.l */
public class C2181l {
    /* renamed from: a */
    public static long m8283a(String path) {
        try {
            StatFs fileStats = new StatFs(path);
            fileStats.restat(path);
            if (VERSION.SDK_INT >= 18) {
                return fileStats.getAvailableBlocksLong() * fileStats.getBlockSizeLong();
            }
            return ((long) fileStats.getAvailableBlocks()) * ((long) fileStats.getBlockSize());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: c */
    private static long m8287c(String path) {
        StatFs fileStats = new StatFs(path);
        fileStats.restat(path);
        if (VERSION.SDK_INT >= 18) {
            return fileStats.getBlockCountLong() * fileStats.getBlockSizeLong();
        }
        return ((long) fileStats.getBlockCount()) * ((long) fileStats.getBlockSize());
    }

    /* renamed from: a */
    public static long m8282a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return C2181l.m8283a(Environment.getExternalStorageDirectory().toString());
        }
        return 0;
    }

    /* renamed from: b */
    public static long m8284b() {
        return C2181l.m8283a("/data");
    }

    /* renamed from: b */
    public static boolean m8285b(String filePath) {
        long length = new File(filePath).length();
        if (filePath.startsWith("/sdcard") || filePath.startsWith("/mnt/sdcard")) {
            if (C2181l.m8282a() > length) {
                return true;
            }
            return false;
        } else if (C2181l.m8284b() <= length) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: c */
    public static long m8286c() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return C2181l.m8287c(Environment.getExternalStorageDirectory().toString());
        }
        return 0;
    }

    /* renamed from: d */
    public static long m8288d() {
        return C2181l.m8287c("/data");
    }
}
