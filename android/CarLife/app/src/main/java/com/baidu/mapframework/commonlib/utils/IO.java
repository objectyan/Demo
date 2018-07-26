package com.baidu.mapframework.commonlib.utils;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.platform.comapi.util.C2911f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IO {
    /* renamed from: a */
    private static final String f12684a = IO.class.getName();
    /* renamed from: b */
    private static final int f12685b = 8192;

    @NotNull
    public static byte[] inputStreamToBytes(@Nullable InputStream in) throws IOException {
        if (in == null) {
            C2911f.m11019c(f12684a, "inputStreamToBytes : inputStream is null", new Throwable());
            throw new IOException("inputStreamToBytes : inputStream is null");
        }
        C2911f.m11015b(f12684a, "inputStreamToBytes");
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        copyStream(in, byteOut);
        return byteOut.toByteArray();
    }

    public static void writeToFile(@Nullable File file, @Nullable InputStream inputStream) throws IOException {
        if (file == null || inputStream == null) {
            C2911f.m11019c(f12684a, "writeToFile : file or inputStream is null", new Throwable());
            throw new IOException("writeToFile : file or inputStream is null");
        }
        C2911f.m11015b(f12684a, "writeToFile " + file.getAbsolutePath());
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

    public static byte[] readFile(@Nullable File file) throws IOException {
        if (file == null) {
            C2911f.m11019c(f12684a, "readFile : file is null", new Throwable());
            throw new IOException("readFile : file is null");
        }
        C2911f.m11015b(f12684a, "readFile " + file.getAbsolutePath());
        if (file.isFile()) {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            copyStream(new FileInputStream(file), byteOut);
            return byteOut.toByteArray();
        }
        throw new IOException(file.getAbsolutePath() + " is not a File");
    }

    public static void copyStream(@Nullable InputStream inputStream, @Nullable OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            C2911f.m11019c(f12684a, "copyStream : outputStream or inputStream is null", new Throwable());
            throw new IOException("copyStream : outputStream or inputStream is null");
        }
        C2911f.m11015b(f12684a, "copyStream");
        try {
            if (!(inputStream instanceof BufferedInputStream)) {
                inputStream = new BufferedInputStream(inputStream);
            }
            if (!(outputStream instanceof BufferedOutputStream)) {
                outputStream = new BufferedOutputStream(outputStream);
            }
            byte[] buffer = new byte[8192];
            while (true) {
                int count = inputStream.read(buffer);
                if (count == -1) {
                    break;
                }
                outputStream.write(buffer, 0, count);
            }
            outputStream.flush();
        } finally {
            closeQuietly(inputStream);
            closeQuietly(outputStream);
        }
    }

    @Deprecated
    public static void deleteFile(@Nullable File file) {
        if (file == null || !file.exists()) {
            C2911f.m11023e(f12684a, "deleteFile the file is null");
            return;
        }
        C2911f.m11015b(f12684a, "deleteFile " + file.getAbsolutePath());
        try {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File subFile : files) {
                        deleteFile(subFile);
                    }
                }
            }
            file.delete();
        } catch (Exception e) {
            C2911f.m11023e(f12684a, "deleteFile fail " + file.getAbsolutePath());
        }
    }

    public static void closeQuietly(@Nullable Closeable closeable) {
        if (closeable == null) {
            C2911f.m11023e(f12684a, "closeQuietly closeable is null");
            return;
        }
        C2911f.m11015b(f12684a, "closeQuietly " + closeable);
        try {
            closeable.close();
        } catch (Exception e) {
            C2911f.m11023e(f12684a, "closeQuietly closeable failed");
        }
    }

    @NotNull
    public static List<File> listFiles(@Nullable File target) {
        List<File> result = new LinkedList();
        if (target != null) {
            File[] files = target.listFiles();
            if (files != null) {
                for (File file : files) {
                    result.add(file);
                    if (file.isDirectory()) {
                        for (File subFile : listFiles(file)) {
                            result.add(subFile);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void forceMkDir(@Nullable File directory) throws IOException {
        if (directory != null) {
            if (directory.exists()) {
                if (!directory.isDirectory()) {
                    throw new IOException("File " + directory + " exists and is not a directory. Unable to create directory.");
                }
            } else if (!directory.mkdirs() && !directory.isDirectory()) {
                throw new IOException("Unable to create directory " + directory);
            }
        }
    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        copyFile(srcFile, destFile, true);
    }

    public static void copyFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
        if (srcFile == null) {
            throw new NullPointerException("Source must not be null");
        } else if (destFile == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!srcFile.exists()) {
            throw new FileNotFoundException("Source '" + srcFile + "' does not exist");
        } else if (srcFile.isDirectory()) {
            throw new IOException("Source '" + srcFile + "' exists but is a directory");
        } else if (srcFile.getCanonicalPath().equals(destFile.getCanonicalPath())) {
            throw new IOException("Source '" + srcFile + "' and destination '" + destFile + "' are the same");
        } else {
            File parentFile = destFile.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!destFile.exists() || destFile.canWrite()) {
                m10943a(srcFile, destFile, preserveFileDate);
            } else {
                throw new IOException("Destination '" + destFile + "' exists but is read-only");
            }
        }
    }

    /* renamed from: a */
    private static void m10943a(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
        Throwable th;
        if (destFile.exists() && destFile.isDirectory()) {
            throw new IOException("Destination '" + destFile + "' exists but is a directory");
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            FileOutputStream fos2;
            FileInputStream fis2 = new FileInputStream(srcFile);
            try {
                fos2 = new FileOutputStream(destFile);
            } catch (Throwable th2) {
                th = th2;
                fis = fis2;
                closeQuietly(null);
                closeQuietly(fos);
                closeQuietly(null);
                closeQuietly(fis);
                throw th;
            }
            try {
                FileChannel input = fis2.getChannel();
                FileChannel output = fos2.getChannel();
                long size = input.size();
                long pos = 0;
                while (pos < size) {
                    pos += output.transferFrom(input, pos, size - pos > PlaybackStateCompat.ACTION_PLAY_FROM_URI ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : size - pos);
                }
                closeQuietly(output);
                closeQuietly(fos2);
                closeQuietly(input);
                closeQuietly(fis2);
                if (srcFile.length() != destFile.length()) {
                    throw new IOException("Failed to copy full contents from '" + srcFile + "' to '" + destFile + "'");
                } else if (preserveFileDate) {
                    destFile.setLastModified(srcFile.lastModified());
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                fis = fis2;
                closeQuietly(null);
                closeQuietly(fos);
                closeQuietly(null);
                closeQuietly(fis);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeQuietly(null);
            closeQuietly(fos);
            closeQuietly(null);
            closeQuietly(fis);
            throw th;
        }
    }

    public static void copyDirectory(File srcDir, File destDir) throws IOException {
        copyDirectory(srcDir, destDir, true);
    }

    public static void copyDirectory(File srcDir, File destDir, boolean preserveFileDate) throws IOException {
        copyDirectory(srcDir, destDir, null, preserveFileDate);
    }

    public static void copyDirectory(File srcDir, File destDir, FileFilter filter) throws IOException {
        copyDirectory(srcDir, destDir, filter, true);
    }

    public static void copyDirectory(File srcDir, File destDir, FileFilter filter, boolean preserveFileDate) throws IOException {
        if (srcDir == null) {
            throw new NullPointerException("Source must not be null");
        } else if (destDir == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!srcDir.exists()) {
            throw new FileNotFoundException("Source '" + srcDir + "' does not exist");
        } else if (!srcDir.isDirectory()) {
            throw new IOException("Source '" + srcDir + "' exists but is not a directory");
        } else if (srcDir.getCanonicalPath().equals(destDir.getCanonicalPath())) {
            throw new IOException("Source '" + srcDir + "' and destination '" + destDir + "' are the same");
        } else {
            List<String> exclusionList = null;
            if (destDir.getCanonicalPath().startsWith(srcDir.getCanonicalPath())) {
                File[] srcFiles = filter == null ? srcDir.listFiles() : srcDir.listFiles(filter);
                if (srcFiles != null && srcFiles.length > 0) {
                    exclusionList = new ArrayList(srcFiles.length);
                    for (File srcFile : srcFiles) {
                        exclusionList.add(new File(destDir, srcFile.getName()).getCanonicalPath());
                    }
                }
            }
            m10942a(srcDir, destDir, filter, preserveFileDate, exclusionList);
        }
    }

    /* renamed from: a */
    private static void m10942a(File srcDir, File destDir, FileFilter filter, boolean preserveFileDate, List<String> exclusionList) throws IOException {
        File[] srcFiles = filter == null ? srcDir.listFiles() : srcDir.listFiles(filter);
        if (srcFiles == null) {
            throw new IOException("Failed to list contents of " + srcDir);
        }
        if (destDir.exists()) {
            if (!destDir.isDirectory()) {
                throw new IOException("Destination '" + destDir + "' exists but is not a directory");
            }
        } else if (!(destDir.mkdirs() || destDir.isDirectory())) {
            throw new IOException("Destination '" + destDir + "' directory cannot be created");
        }
        if (destDir.canWrite()) {
            for (File srcFile : srcFiles) {
                File dstFile = new File(destDir, srcFile.getName());
                if (exclusionList == null || !exclusionList.contains(srcFile.getCanonicalPath())) {
                    if (srcFile.isDirectory()) {
                        m10942a(srcFile, dstFile, filter, preserveFileDate, exclusionList);
                    } else {
                        m10943a(srcFile, dstFile, preserveFileDate);
                    }
                }
            }
            if (preserveFileDate) {
                destDir.setLastModified(srcDir.lastModified());
                return;
            }
            return;
        }
        throw new IOException("Destination '" + destDir + "' cannot be written to");
    }

    public static void moveFile(File srcFile, File destFile) throws IOException {
        if (srcFile == null) {
            throw new NullPointerException("Source must not be null");
        } else if (destFile == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!srcFile.exists()) {
            throw new FileNotFoundException("Source '" + srcFile + "' does not exist");
        } else if (srcFile.isDirectory()) {
            throw new IOException("Source '" + srcFile + "' is a directory");
        } else if (destFile.exists()) {
            throw new IOException("Destination '" + destFile + "' already exists");
        } else if (destFile.isDirectory()) {
            throw new IOException("Destination '" + destFile + "' is a directory");
        } else if (!srcFile.renameTo(destFile)) {
            copyFile(srcFile, destFile);
            if (!srcFile.delete()) {
                deleteQuietly(destFile);
                throw new IOException("Failed to delete original file '" + srcFile + "' after copy to '" + destFile + "'");
            }
        }
    }

    public static boolean deleteQuietly(File file) {
        boolean z = false;
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    cleanDirectory(file);
                }
            } catch (Exception e) {
            }
            try {
                z = file.delete();
            } catch (Exception e2) {
            }
        }
        return z;
    }

    public static void cleanDirectory(File directory) throws IOException {
        if (!directory.exists()) {
            throw new IllegalArgumentException(directory + " does not exist");
        } else if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files == null) {
                throw new IOException("Failed to list contents of " + directory);
            }
            IOException exception = null;
            for (File file : files) {
                try {
                    forceDelete(file);
                } catch (IOException ioe) {
                    exception = ioe;
                }
            }
            if (exception != null) {
                throw exception;
            }
        } else {
            throw new IllegalArgumentException(directory + " is not a directory");
        }
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean filePresent = file.exists();
        if (!file.delete()) {
            if (filePresent) {
                throw new IOException("Unable to delete file: " + file);
            }
            throw new FileNotFoundException("File does not exist: " + file);
        }
    }

    public static void deleteDirectory(File directory) throws IOException {
        if (directory.exists()) {
            cleanDirectory(directory);
            if (!directory.delete()) {
                throw new IOException("Unable to delete directory " + directory + ".");
            }
        }
    }
}
