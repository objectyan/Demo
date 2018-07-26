package com.baidu.android.pushservice.p031j;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p027f.C0521b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.j.b */
public class C0562b {
    /* renamed from: a */
    private static final Object f1849a = new Object();

    /* renamed from: a */
    public static String m2419a(Context context, String str) {
        if (context == null) {
            return "";
        }
        String str2 = null;
        try {
            str2 = System.getString(context.getContentResolver(), str);
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            Object b = C0562b.m2424b(context, str);
            return (b == null || !(b instanceof String)) ? str2 : String.valueOf(b);
        } catch (Exception e2) {
            return str2;
        }
    }

    /* renamed from: a */
    private static JSONObject m2420a(Context context) {
        Throwable th;
        JSONObject jSONObject = new JSONObject();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2;
            File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/files");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, ".info");
            if (file2.exists()) {
                fileInputStream2 = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    jSONObject = new JSONObject(BaiduAppSSOJni.getDecrypted(context, "", new String(bArr, "utf-8")));
                } catch (Exception e) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    return jSONObject;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                }
            }
        } catch (Exception e5) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return jSONObject;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m2421a(Context context, String str, int i) {
        if (context != null) {
            boolean z = false;
            try {
                if (C0578p.m2601u(context, "android.permission.WRITE_SETTINGS")) {
                    z = System.putInt(context.getContentResolver(), str, i);
                }
            } catch (Exception e) {
            }
            if (!z) {
                C0562b.m2423a(context, str, Integer.valueOf(i));
            }
        }
    }

    /* renamed from: a */
    public static void m2422a(Context context, String str, String str2) {
        if (context != null) {
            boolean z = false;
            try {
                z = System.putString(context.getContentResolver(), str, str2);
            } catch (Exception e) {
            }
            if (!z) {
                C0562b.m2423a(context, str, (Object) str2);
            }
        }
    }

    /* renamed from: a */
    private static boolean m2423a(Context context, String str, Object obj) {
        Closeable closeable;
        Throwable th;
        if (!C0578p.m2601u(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return false;
        }
        synchronized (f1849a) {
            JSONObject a = C0562b.m2420a(context);
            Closeable closeable2 = null;
            if (a.opt(str) != null) {
                a.remove(str);
            }
            try {
                a.put(str, obj);
                File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/files");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, ".info");
                Object encrypted = BaiduAppSSOJni.getEncrypted(context, "", a.toString());
                if (TextUtils.isEmpty(encrypted)) {
                    C0521b.m2169a(null);
                    return false;
                }
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(encrypted.getBytes());
                    C0521b.m2169a(fileOutputStream);
                    return true;
                } catch (Exception e) {
                    Object obj2 = fileOutputStream;
                    C0521b.m2169a(closeable);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    Object obj3 = fileOutputStream;
                    C0521b.m2169a(closeable2);
                    throw th;
                }
            } catch (Exception e2) {
                closeable = null;
                C0521b.m2169a(closeable);
                return false;
            } catch (Throwable th3) {
                th = th3;
                C0521b.m2169a(closeable2);
                throw th;
            }
        }
    }

    /* renamed from: b */
    private static Object m2424b(Context context, String str) {
        if (!C0578p.m2601u(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return null;
        }
        Object opt;
        synchronized (f1849a) {
            opt = C0562b.m2420a(context).opt(str);
        }
        return opt;
    }
}
