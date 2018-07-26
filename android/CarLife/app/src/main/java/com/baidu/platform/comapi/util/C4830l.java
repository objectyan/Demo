package com.baidu.platform.comapi.util;

import android.os.Environment;
import android.os.StatFs;

/* compiled from: StorageCheck */
/* renamed from: com.baidu.platform.comapi.util.l */
public class C4830l {
    /* renamed from: a */
    public static final int f19985a = 0;
    /* renamed from: b */
    public static final int f19986b = 1;
    /* renamed from: c */
    public static final int f19987c = 2;
    /* renamed from: d */
    public static final int f19988d = 3;
    /* renamed from: e */
    public static final int f19989e = 15728640;
    /* renamed from: f */
    public static final int f19990f = 20971520;

    /* renamed from: a */
    public static int m16024a(int sizeInByte, boolean bBuffer) {
        int state = C4830l.m16023a();
        if (state != 0) {
            return state;
        }
        StatFs sfs = C4830l.m16025b();
        if (((long) sfs.getBlockSize()) * ((long) sfs.getFreeBlocks()) < ((long) ((bBuffer ? 15728640 : 0) + sizeInByte))) {
            return 1;
        }
        return state;
    }

    /* renamed from: a */
    public static int m16023a() {
        String status = Environment.getExternalStorageState();
        if (status == null || status.equals("bad_removal")) {
            return 2;
        }
        if (!status.equals("checking")) {
            if (status.equals("mounted")) {
                return 0;
            }
            if (status.equals("mounted_ro") || status.equals("nofs")) {
                return 2;
            }
            if (status.equals("removed")) {
                return 3;
            }
            if (status.equals("shared")) {
                return 3;
            }
            if (status.equals("unmountable")) {
                return 2;
            }
            if (status.equals("unmounted")) {
                return 3;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public static StatFs m16025b() {
        return new StatFs(Environment.getExternalStorageDirectory().getPath());
    }
}
