package com.baidu.navisdk.hudsdk;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapUtils {
    public static String encodeToBase64Str(byte[] data) {
        if (data != null) {
            return Base64.encodeToString(data, 0);
        }
        return null;
    }

    public static byte[] decodeBase64Str(String str) {
        if (str != null) {
            return Base64.decode(str, 0);
        }
        return null;
    }

    public static byte[] bitmap2Bytes(Bitmap bm) {
        if (bm == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(CompressFormat.PNG, 100, baos);
        byte[] result = baos.toByteArray();
        try {
            baos.close();
            return result;
        } catch (IOException e) {
            return result;
        }
    }

    public static Bitmap bytes2Bimap(byte[] buf) {
        if (buf == null || buf.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(buf, 0, buf.length);
    }

    public static void mkdir(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            mkdir(file.getParent());
        } else if (!file.exists()) {
            file.mkdir();
        }
    }

    public static void writeBitmapToFile(Bitmap bmp, String path, int type) {
        IOException e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        File file = new File(path);
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            if (type == 1) {
                try {
                    bmp.compress(CompressFormat.JPEG, 100, fos);
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fos;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e32) {
                                e32.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fos;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
            bmp.compress(CompressFormat.PNG, 100, fos);
            fos.flush();
            if (fos != null) {
                try {
                    fos.close();
                    fileOutputStream = fos;
                    return;
                } catch (IOException e322) {
                    e322.printStackTrace();
                    fileOutputStream = fos;
                    return;
                }
            }
        } catch (IOException e4) {
            e322 = e4;
            e322.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public static Bitmap readBitmapFromFile(String path) {
        Bitmap bitmap = null;
        if (!(path == null || path.length() == 0)) {
            bitmap = BitmapFactory.decodeFile(path);
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
        }
        return bitmap;
    }
}
