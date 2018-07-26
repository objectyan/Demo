package com.baidu.navisdk.util.common;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    private static final String TAG = "ZipUtils";

    public static ZipOutputStream getZipOutputStream(File file) throws FileNotFoundException {
        return new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }

    public static void zip(File from, ZipOutputStream to, String entryName) throws IOException {
        Throwable th;
        ZipOutputStream outputStream = to;
        BufferedInputStream inputStream = null;
        try {
            outputStream.setLevel(6);
            BufferedInputStream inputStream2 = new BufferedInputStream(new FileInputStream(from));
            try {
                outputStream.putNextEntry(new ZipEntry(entryName));
                copyStream(inputStream2, outputStream);
                closeStrem(inputStream2);
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                closeStrem(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeStrem(inputStream);
            throw th;
        }
    }

    public static void unzip(File dirPath, String targetPath) throws IOException {
        LogUtil.m15791e(TAG, "unzip " + dirPath + " " + targetPath);
        if (dirPath == null || TextUtils.isEmpty(targetPath)) {
            LogUtil.m15791e(TAG, "unzipPart : path or partName is null");
            throw new IOException("unzipPart : path or partName is null");
        }
        ZipFile zipFile = new ZipFile(dirPath);
        Enumeration<? extends ZipEntry> zipList = zipFile.entries();
        while (zipList.hasMoreElements()) {
            ZipEntry ze = (ZipEntry) zipList.nextElement();
            if (!(ze.isDirectory() || ze.getName().contains("../"))) {
                writeToFile(new File(targetPath, ze.getName()), zipFile.getInputStream(ze));
            }
        }
        zipFile.close();
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            LogUtil.m15791e(TAG, "copyStream : outputStream or inputStream is null");
            return;
        }
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(outputStream instanceof BufferedOutputStream)) {
            outputStream = new BufferedOutputStream(outputStream);
        }
        byte[] buffer = new byte[8192];
        while (true) {
            int count = inputStream.read(buffer);
            if (count != -1) {
                outputStream.write(buffer, 0, count);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public static void writeToFile(File file, InputStream inputStream) throws IOException {
        if (file == null || inputStream == null) {
            LogUtil.m15791e(TAG, "writeToFile : file or inputStream is null");
            return;
        }
        LogUtil.m15791e(TAG, "writeToFile " + file.getAbsolutePath());
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        if (parent.exists()) {
            copyStream(inputStream, new FileOutputStream(file));
            return;
        }
        throw new IOException("Can't create dir " + parent.getAbsolutePath());
    }

    public static void closeStrem(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.m15791e(TAG, "closeQuietly closeable failed");
                return;
            }
        }
        LogUtil.m15791e(TAG, "closeQuietly closeable is null");
    }
}
