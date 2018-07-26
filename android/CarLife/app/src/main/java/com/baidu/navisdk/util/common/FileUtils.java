package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class FileUtils {
    private static final String DATA_UPDATE_LOG_FILE_NAME = "DataUpdateLog.txt";

    public static boolean isFileExist(String path) {
        return new File(path).exists();
    }

    public static String sanitizeFilename(String str) {
        return MD5.toMD5(str);
    }

    public static boolean isValidFilenameChar(char c) {
        if (!Character.isLetterOrDigit(c)) {
            switch (c) {
                case '#':
                case '%':
                case '(':
                case ')':
                case '+':
                case ',':
                case '-':
                case '.':
                case '=':
                case '@':
                case '[':
                case ']':
                case '_':
                case '{':
                case RouteLineResConst.LINE_FOOT_GREEN_NORMAL /*125*/:
                    return true;
            }
        }
        return false;
    }

    public static String getMd5ByFile(String fileName) {
        Exception e;
        Throwable th;
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        String value = null;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            try {
                byte[] buffer = new byte[1024];
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                while (true) {
                    int numRead = fis.read(buffer);
                    if (numRead <= 0) {
                        break;
                    }
                    md5.update(buffer, 0, numRead);
                }
                value = new BigInteger(1, md5.digest()).toString(16);
                if (fis != null) {
                    try {
                        fis.close();
                        fileInputStream = fis;
                        return value;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        fileInputStream = fis;
                        return value;
                    }
                }
                return value;
            } catch (Exception e3) {
                e = e3;
                fileInputStream = fis;
                if (e != null) {
                    try {
                        e.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    return value;
                }
                try {
                    fileInputStream.close();
                    return value;
                } catch (IOException e222) {
                    e222.printStackTrace();
                    return value;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fis;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            if (e != null) {
                e.printStackTrace();
            }
            if (fileInputStream != null) {
                return value;
            }
            fileInputStream.close();
            return value;
        }
    }

    public static byte[] readAssetsFile(Context ctx, String assetPath) {
        byte[] b = null;
        try {
            InputStream input = ctx.getResources().getAssets().open(assetPath);
            b = new byte[input.available()];
            input.read(b);
            input.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return b;
        }
    }

    public static boolean copyAssetsFile(AssetManager am, String assetPath, String destPath, String desFileName) {
        try {
            InputStream is = am.open(assetPath);
            File outFile = new File(destPath + "/" + desFileName);
            int assetLen = is.available();
            if (outFile.exists() && outFile.length() == ((long) assetLen) && outFile.lastModified() > PackageUtil.getApkUpdateTime()) {
                is.close();
                return true;
            }
            File out = new File(destPath);
            if (!out.exists()) {
                out.mkdirs();
            }
            OutputStream os = new FileOutputStream(outFile);
            byte[] buf = new byte[1024];
            while (true) {
                int len = is.read(buf);
                if (len > 0) {
                    os.write(buf, 0, len);
                } else {
                    is.close();
                    os.close();
                    return true;
                }
            }
        } catch (Exception e) {
            LogUtil.m15791e("", e.toString());
            return false;
        }
    }

    public static boolean copyAssetsFile(AssetManager am, String assetPath, String destPath) {
        try {
            InputStream is = am.open(assetPath);
            File file = new File(destPath);
            long fileLen = file.length();
            int assetLen = is.available();
            if (file.exists() && fileLen == ((long) assetLen)) {
                is.close();
                return true;
            }
            OutputStream os = new FileOutputStream(new File(destPath));
            byte[] buf = new byte[1024];
            while (true) {
                int len = is.read(buf);
                if (len > 0) {
                    os.write(buf, 0, len);
                } else {
                    is.close();
                    os.close();
                    return true;
                }
            }
        } catch (Exception e) {
            LogUtil.m15791e("", e.toString());
            return false;
        }
    }

    public static boolean copyFile(File sourceFile, File targetFile) {
        Throwable th;
        if (!sourceFile.exists()) {
            return false;
        }
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            BufferedOutputStream outBuff2;
            BufferedInputStream inBuff2 = new BufferedInputStream(new FileInputStream(sourceFile));
            try {
                outBuff2 = new BufferedOutputStream(new FileOutputStream(targetFile));
            } catch (IOException e) {
                inBuff = inBuff2;
                if (inBuff != null) {
                    try {
                        inBuff.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (outBuff != null) {
                    return false;
                }
                try {
                    outBuff.close();
                    return false;
                } catch (IOException e22) {
                    e22.printStackTrace();
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                inBuff = inBuff2;
                if (inBuff != null) {
                    try {
                        inBuff.close();
                    } catch (IOException e222) {
                        e222.printStackTrace();
                    }
                }
                if (outBuff != null) {
                    try {
                        outBuff.close();
                    } catch (IOException e2222) {
                        e2222.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                byte[] b = new byte[1024];
                while (true) {
                    int len = inBuff2.read(b);
                    if (len == -1) {
                        break;
                    }
                    outBuff2.write(b, 0, len);
                }
                outBuff2.flush();
                if (inBuff2 != null) {
                    try {
                        inBuff2.close();
                    } catch (IOException e22222) {
                        e22222.printStackTrace();
                    }
                }
                if (outBuff2 != null) {
                    try {
                        outBuff2.close();
                    } catch (IOException e222222) {
                        e222222.printStackTrace();
                    }
                }
                return true;
            } catch (IOException e3) {
                outBuff = outBuff2;
                inBuff = inBuff2;
                if (inBuff != null) {
                    inBuff.close();
                }
                if (outBuff != null) {
                    return false;
                }
                outBuff.close();
                return false;
            } catch (Throwable th3) {
                th = th3;
                outBuff = outBuff2;
                inBuff = inBuff2;
                if (inBuff != null) {
                    inBuff.close();
                }
                if (outBuff != null) {
                    outBuff.close();
                }
                throw th;
            }
        } catch (IOException e4) {
            if (inBuff != null) {
                inBuff.close();
            }
            if (outBuff != null) {
                return false;
            }
            outBuff.close();
            return false;
        } catch (Throwable th4) {
            th = th4;
            if (inBuff != null) {
                inBuff.close();
            }
            if (outBuff != null) {
                outBuff.close();
            }
            throw th;
        }
    }

    public static boolean copyFileSmart(File sourceFile, File targetFile) {
        Throwable th;
        if (!sourceFile.exists()) {
            return false;
        }
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            BufferedInputStream inBuff2 = new BufferedInputStream(new FileInputStream(sourceFile));
            try {
                if (((long) inBuff2.available()) == targetFile.length()) {
                    inBuff2.close();
                    if (inBuff2 != null) {
                        try {
                            inBuff2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (outBuff != null) {
                        try {
                            outBuff.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return true;
                }
                BufferedOutputStream outBuff2 = new BufferedOutputStream(new FileOutputStream(targetFile));
                try {
                    byte[] b = new byte[1024];
                    while (true) {
                        int len = inBuff2.read(b);
                        if (len == -1) {
                            break;
                        }
                        outBuff2.write(b, 0, len);
                    }
                    outBuff2.flush();
                    if (inBuff2 != null) {
                        try {
                            inBuff2.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    if (outBuff2 != null) {
                        try {
                            outBuff2.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    return true;
                } catch (IOException e3) {
                    outBuff = outBuff2;
                    inBuff = inBuff2;
                    if (inBuff != null) {
                        try {
                            inBuff.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    if (outBuff != null) {
                        return false;
                    }
                    try {
                        outBuff.close();
                        return false;
                    } catch (IOException e22222) {
                        e22222.printStackTrace();
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outBuff = outBuff2;
                    inBuff = inBuff2;
                    if (inBuff != null) {
                        try {
                            inBuff.close();
                        } catch (IOException e222222) {
                            e222222.printStackTrace();
                        }
                    }
                    if (outBuff != null) {
                        try {
                            outBuff.close();
                        } catch (IOException e2222222) {
                            e2222222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                inBuff = inBuff2;
                if (inBuff != null) {
                    inBuff.close();
                }
                if (outBuff != null) {
                    return false;
                }
                outBuff.close();
                return false;
            } catch (Throwable th3) {
                th = th3;
                inBuff = inBuff2;
                if (inBuff != null) {
                    inBuff.close();
                }
                if (outBuff != null) {
                    outBuff.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            if (inBuff != null) {
                inBuff.close();
            }
            if (outBuff != null) {
                return false;
            }
            outBuff.close();
            return false;
        } catch (Throwable th4) {
            th = th4;
            if (inBuff != null) {
                inBuff.close();
            }
            if (outBuff != null) {
                outBuff.close();
            }
            throw th;
        }
    }

    public static boolean copyDirectiory(String sourceDir, String targetDir) throws IOException {
        if (!new File(sourceDir).exists()) {
            return false;
        }
        boolean result = true;
        File tFile = new File(targetDir);
        if (!tFile.exists()) {
            tFile.mkdirs();
        }
        File[] file = new File(sourceDir).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                File sourceFile = file[i];
                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
                if (result && copyFile(sourceFile, targetFile)) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (file[i].isDirectory()) {
                String dir1 = sourceDir + "/" + file[i].getName();
                String dir2 = targetDir + "/" + file[i].getName();
                if (result && copyDirectiory(dir1, dir2)) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    public static boolean del(String filepath) throws IOException {
        File f = new File(filepath);
        if (f.exists()) {
            if (f.isDirectory()) {
                if (f.listFiles().length == 0) {
                    return f.delete();
                }
                boolean ret = true;
                File[] delFile = f.listFiles();
                int i = f.listFiles().length;
                int j = 0;
                while (j < i) {
                    if (delFile[j].isDirectory()) {
                        if (ret && del(delFile[j].getAbsolutePath())) {
                            ret = true;
                        } else {
                            ret = false;
                        }
                    }
                    if (ret && delFile[j].delete()) {
                        ret = true;
                    } else {
                        ret = false;
                    }
                    j++;
                }
                return ret;
            } else if (f.isFile()) {
                return f.delete();
            }
        }
        return false;
    }

    public static File getDataUpdateLogFile() {
        return new File(SysOSAPI.getInstance().GetSDCardPath() + "/" + DATA_UPDATE_LOG_FILE_NAME);
    }

    public static void writeDataUpdateLogToFile(String logStr) {
        Exception e;
        Throwable th;
        FileOutputStream fos = null;
        try {
            FileOutputStream fos2 = new FileOutputStream(getDataUpdateLogFile(), true);
            try {
                fos2.write(logStr.getBytes("utf-8"));
                fos2.write(System.getProperty("line.separator").getBytes());
                fos2.flush();
                if (fos2 != null) {
                    try {
                        fos2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                fos = fos2;
                try {
                    e.printStackTrace();
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                if (fos != null) {
                    fos.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static boolean isExistUpdateLogFile() {
        return getDataUpdateLogFile().exists();
    }
}
