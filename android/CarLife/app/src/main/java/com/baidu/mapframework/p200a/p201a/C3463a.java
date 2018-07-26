package com.baidu.mapframework.p200a.p201a;

import android.text.TextUtils;
import com.baidu.mapframework.commonlib.utils.IO;
import com.baidu.platform.comapi.util.C2911f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Zip */
/* renamed from: com.baidu.mapframework.a.a.a */
public class C3463a {
    /* renamed from: a */
    private static final String f18734a = C3463a.class.getName();

    /* renamed from: a */
    public static void m14857a(@Nullable File dirPath, @Nullable String targetPath) throws IOException {
        C2911f.b(f18734a, "unzip " + dirPath + " " + targetPath);
        if (dirPath == null || TextUtils.isEmpty(targetPath)) {
            C2911f.e(f18734a, "unzipPart : path or partName is null");
            throw new IOException("unzipPart : path or partName is null");
        }
        ZipFile zipFile = new ZipFile(dirPath);
        Enumeration<? extends ZipEntry> zipList = zipFile.entries();
        while (zipList.hasMoreElements()) {
            ZipEntry ze = (ZipEntry) zipList.nextElement();
            if (!(ze.isDirectory() || ze.getName().contains("../"))) {
                IO.writeToFile(new File(targetPath, ze.getName()), zipFile.getInputStream(ze));
            }
        }
        zipFile.close();
    }

    @NotNull
    /* renamed from: b */
    public static byte[] m14858b(@Nullable File path, @Nullable String partName) throws IOException {
        C2911f.b(f18734a, "unzipPart " + path + " " + partName);
        if (path == null || TextUtils.isEmpty(partName)) {
            throw new IOException("unzipPart : path or partName is null");
        }
        ZipFile zipFile = new ZipFile(path);
        InputStream in = null;
        try {
            in = zipFile.getInputStream(zipFile.getEntry(partName));
            byte[] inputStreamToBytes = IO.inputStreamToBytes(in);
            return inputStreamToBytes;
        } finally {
            IO.closeQuietly(in);
            zipFile.close();
        }
    }

    /* renamed from: a */
    public static void m14856a(File from, File to, String entryName, int level, int method) throws IOException {
        Throwable th;
        ZipOutputStream outputStream = null;
        BufferedInputStream inputStream = null;
        try {
            ZipOutputStream outputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(to)));
            try {
                outputStream2.setLevel(level);
                outputStream2.setMethod(method);
                BufferedInputStream inputStream2 = new BufferedInputStream(new FileInputStream(from));
                try {
                    outputStream2.putNextEntry(new ZipEntry(entryName));
                    IO.copyStream(inputStream2, outputStream2);
                    IO.closeQuietly(outputStream2);
                    IO.closeQuietly(inputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    outputStream = outputStream2;
                    IO.closeQuietly(outputStream);
                    IO.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                IO.closeQuietly(outputStream);
                IO.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            IO.closeQuietly(outputStream);
            IO.closeQuietly(inputStream);
            throw th;
        }
    }
}
