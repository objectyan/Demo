package com.baidu.mapframework.common.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.baidu.carlife.core.C1260i;
import com.baidu.mapframework.nirvana.assets.AssetsManager;
import com.baidu.mapframework.nirvana.assets.AssetsTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.util.EncodingUtils;

public class FileUtils {

    public static class UnzipLibraryRunnable implements Runnable {
        private static final int BUFFER_SIZE = 1024;
        private String onlyUnzipFile;
        private String outputDictory;
        private UnzipCallBack unzipCallBack;
        private String zipPath;

        public interface UnzipCallBack {
            void onSuccess();

            void onUnzipErr();
        }

        public UnzipLibraryRunnable(String zipPath, String outputDirectory, String onlyUnzipFile, UnzipCallBack unzipCallBack) {
            this.zipPath = zipPath;
            this.outputDictory = outputDirectory;
            this.onlyUnzipFile = onlyUnzipFile;
            this.unzipCallBack = unzipCallBack;
        }

        public UnzipLibraryRunnable(String zipPath, String outputDirectory, UnzipCallBack unzipCallBack) {
            this(zipPath, outputDirectory, null, unzipCallBack);
        }

        public void run() {
            try {
                ZipFile zipFile = new ZipFile(this.zipPath);
                Enumeration<? extends ZipEntry> zipList = zipFile.entries();
                byte[] buffer = new byte[1024];
                while (zipList.hasMoreElements()) {
                    ZipEntry ze = (ZipEntry) zipList.nextElement();
                    if (!ze.isDirectory()) {
                        String filePath = getOutputFilePath(ze.getName());
                        if (TextUtils.isEmpty(this.onlyUnzipFile) || filePath.indexOf(this.onlyUnzipFile) != -1) {
                            OutputStream os = new BufferedOutputStream(new FileOutputStream(FileUtils.createFileIfNotExists(filePath)));
                            InputStream is = new BufferedInputStream(zipFile.getInputStream(ze));
                            while (true) {
                                int count = is.read(buffer, 0, 1024);
                                if (count == -1) {
                                    break;
                                }
                                os.write(buffer, 0, count);
                            }
                            os.flush();
                            is.close();
                            os.close();
                        }
                    }
                }
                zipFile.close();
                if (this.unzipCallBack != null) {
                    this.unzipCallBack.onSuccess();
                }
            } catch (FileNotFoundException e) {
                if (this.unzipCallBack != null) {
                    this.unzipCallBack.onUnzipErr();
                }
            } catch (IOException e2) {
                if (this.unzipCallBack != null) {
                    this.unzipCallBack.onUnzipErr();
                }
            }
        }

        private String getOutputFilePath(String name) {
            if (!(name == null || name.indexOf("\\") == -1)) {
                name = name.replaceAll("\\\\", File.separator);
            }
            return this.outputDictory + File.separator + name;
        }
    }

    public static String getStringFromAssertFile(Context ctx, String file) {
        String result = "";
        InputStream in = null;
        try {
            ScheduleConfig config = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
            AssetsTask task = new AssetsTask(ctx, file);
            AssetsManager.open(Module.USER_CENTER_MODULE, task, config);
            in = task.getInputStream();
            if (in == null) {
                return result;
            }
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            result = EncodingUtils.getString(buffer, "utf-8");
            close(in);
            return result;
        } catch (Exception e) {
        } finally {
            close(in);
        }
    }

    public static void deleteAll(File file) {
        if (file != null) {
            if (file.isFile() || (file.exists() && file.list() != null && file.list().length == 0)) {
                file.delete();
                return;
            }
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    deleteAll(files[i]);
                    files[i].delete();
                }
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String ReadTxtFile(String strFilePath) {
        String content = "";
        File file = new File(strFilePath);
        if (!file.isDirectory()) {
            try {
                InputStream instream = new FileInputStream(file);
                if (instream != null) {
                    BufferedReader buffreader = new BufferedReader(new InputStreamReader(instream));
                    while (true) {
                        String line = buffreader.readLine();
                        if (line == null) {
                            break;
                        }
                        content = content + line + "\n";
                    }
                    instream.close();
                }
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            }
        }
        return content;
    }

    public static File createFileIfNotExists(String filePath) {
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
        }
        return file;
    }

    public static File createFileWhetherExists(String filePath) {
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
        return file;
    }

    public static byte[] InputStreamToByte(InputStream is) throws IOException {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        while (true) {
            int ch = is.read();
            if (ch != -1) {
                bytestream.write(ch);
            } else {
                byte[] imgdata = bytestream.toByteArray();
                bytestream.close();
                return imgdata;
            }
        }
    }

    public static void makeFileDirectories(String updatePath) {
        if (!TextUtils.isEmpty(updatePath)) {
            File dir = new File(updatePath).getParentFile();
            if (dir != null && !dir.exists()) {
                dir.mkdirs();
            }
        }
    }

    public static boolean fileExists(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return new File(path).exists();
    }

    public static boolean writeToFile(File file, boolean append, String log) {
        try {
            FileOutputStream outputStream = new FileOutputStream(file, append);
            byte[] buf = log.getBytes();
            outputStream.write(buf, 0, buf.length);
            outputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
    }

    private static boolean copyAssetsFile(AssetManager am, String assetPath, String destPath, String desFileName) {
        Exception e;
        Throwable th;
        InputStream is = null;
        OutputStream outputStream = null;
        try {
            is = am.open(assetPath);
            File file = new File(destPath);
            long fileLen = file.length();
            int assetLen = is.available();
            if (file.exists() && fileLen == ((long) assetLen)) {
                close(is);
                close(null);
                return true;
            }
            File out = new File(destPath);
            if (!out.exists()) {
                out.mkdirs();
            }
            File outFile = new File(destPath + "/" + desFileName);
            C1260i.b("FileUtils", "copyAssetsFile path = " + destPath + "/" + desFileName);
            if (outFile != null && outFile.exists()) {
                outFile.delete();
                C1260i.b("FileUtils", "copyAssetsFile file exists -> delete");
            }
            OutputStream os = new FileOutputStream(outFile);
            try {
                byte[] buf = new byte[1024];
                while (true) {
                    int len = is.read(buf);
                    if (len > 0) {
                        os.write(buf, 0, len);
                    } else {
                        close(is);
                        close(os);
                        outputStream = os;
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                outputStream = os;
                try {
                    e.printStackTrace();
                    close(is);
                    close(outputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    close(is);
                    close(outputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = os;
                close(is);
                close(outputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            close(is);
            close(outputStream);
            return false;
        }
    }
}
