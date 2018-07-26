package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

@SuppressLint({"DefaultLocale"})
/* compiled from: CacheSD */
/* renamed from: com.baidu.ufosdk.util.f */
public final class C5213f {
    /* renamed from: c */
    private static String f21699c = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/image_cache").toString();
    /* renamed from: d */
    private static C5213f f21700d = null;
    /* renamed from: a */
    public final int f21701a = 1209600000;
    /* renamed from: b */
    private final String f21702b = "ufo";

    /* renamed from: a */
    public static C5213f m17749a() {
        if (f21700d == null) {
            f21700d = new C5213f();
        }
        return f21700d;
    }

    /* renamed from: b */
    private static String m17750b(String str) {
        return f21699c + "/cache/image/" + str;
    }

    /* renamed from: c */
    private static int m17752c() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (int) ((((double) statFs.getBlockSize()) * ((double) statFs.getAvailableBlocks())) / 1048576.0d);
        }
        C5210c.m17734b("sdCard is not exist");
        return 0;
    }

    /* renamed from: c */
    private void m17753c(String str) {
        int i = 0;
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            int length;
            int i2 = 0;
            for (File length2 : listFiles) {
                i2 = (int) (((long) i2) + length2.length());
            }
            if (i2 > 20971520 || 20 > C5213f.m17752c()) {
                length = (int) ((0.4d * ((double) listFiles.length)) + 1.0d);
                Arrays.sort(listFiles, new C5214g(this));
                C5210c.m17734b("Clear some expiredcache files");
                while (i < length) {
                    listFiles[i].delete();
                    i++;
                }
            }
        }
    }

    /* renamed from: b */
    public static void m17751b() {
        String str = f21699c + "/cache/image/";
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            C5210c.m17734b("ufo-->Clear all cache files,dir=" + str);
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    /* renamed from: a */
    public final void m17754a(Bitmap bitmap, String str) {
        try {
            boolean equals = Environment.getExternalStorageState().equals("mounted");
            if (equals) {
                File file = new File(C5213f.m17750b(str));
                if (20 > C5213f.m17752c()) {
                    C5210c.m17735c("ufo-->Low free space onsd, do not cache");
                    return;
                }
                m17753c(f21699c + "/cache/image/");
                if (equals) {
                    File file2 = new File(f21699c);
                    File file3 = new File(f21699c + "/cache");
                    File file4 = new File(f21699c + "/cache/image");
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (!file3.exists()) {
                        file3.mkdir();
                    }
                    if (!file4.exists()) {
                        file4.mkdir();
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                }
                OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                bitmap.compress(CompressFormat.PNG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static Bitmap m17748a(String str) {
        String b = C5213f.m17750b(str);
        if (!new File(b).exists()) {
            return null;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(b, null);
        if (decodeFile == null) {
            return null;
        }
        new File(f21699c + "/cache/image/", b).setLastModified(System.currentTimeMillis());
        return decodeFile;
    }
}
