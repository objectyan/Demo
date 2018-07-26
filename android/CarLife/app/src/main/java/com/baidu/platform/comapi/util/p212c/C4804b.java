package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.baidu.platform.comapi.util.C2911f;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: AssetManagerCompat */
/* renamed from: com.baidu.platform.comapi.util.c.b */
public final class C4804b {
    /* renamed from: a */
    private static final String f19911a = "AssetManagerCompat";
    /* renamed from: b */
    private String f19912b;

    /* compiled from: AssetManagerCompat */
    /* renamed from: com.baidu.platform.comapi.util.c.b$a */
    public interface C4802a {
        /* renamed from: a */
        void m15948a(ZipFile zipFile, ZipEntry zipEntry) throws IOException;
    }

    /* compiled from: AssetManagerCompat */
    /* renamed from: com.baidu.platform.comapi.util.c.b$b */
    public interface C4803b {
        /* renamed from: a */
        void m15949a(InputStream inputStream) throws IOException;
    }

    public C4804b(Context context) {
        this.f19912b = C4804b.m15950a(context);
    }

    /* renamed from: a */
    public void m15952a(String path, C4803b handler) throws IOException {
        InputStream inputStream;
        ZipFile zipFile = new ZipFile(this.f19912b);
        try {
            StringBuilder append = new StringBuilder().append("assets/");
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            ZipEntry entry = zipFile.getEntry(append.append(path).toString());
            if (entry != null) {
                inputStream = zipFile.getInputStream(entry);
                handler.m15949a(inputStream);
                inputStream.close();
            }
            zipFile.close();
        } catch (Throwable th) {
            zipFile.close();
        }
    }

    /* renamed from: a */
    public void m15951a(String path, C4802a handler) throws IOException {
        StringBuilder append = new StringBuilder().append("assets/");
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        String prePath = append.append(path).toString();
        ZipFile zipFile = new ZipFile(this.f19912b);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            try {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (zipEntry.getName().startsWith(prePath)) {
                    handler.m15948a(zipFile, zipEntry);
                }
            } finally {
                zipFile.close();
            }
        }
    }

    /* renamed from: a */
    private static String m15950a(Context context) {
        if (VERSION.SDK_INT >= 8) {
            return context.getPackageCodePath();
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
        } catch (NameNotFoundException e) {
            C2911f.c(f19911a, "", e);
            return "";
        }
    }
}
