package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.jar.JarFile;

class ax {
    /* renamed from: a */
    private static volatile DexClassLoader f19407a;
    /* renamed from: b */
    private static volatile boolean f19408b = false;

    /* renamed from: a */
    public static Class<?> m15377a(Context context, String str) {
        DexClassLoader a = m15375a(context);
        return a == null ? null : a.loadClass(str);
    }

    /* renamed from: a */
    private static synchronized DexClassLoader m15375a(Context context) {
        DexClassLoader dexClassLoader = null;
        synchronized (ax.class) {
            if (f19407a != null) {
                dexClassLoader = f19407a;
            } else {
                File fileStreamPath = context.getFileStreamPath(".remote.jar");
                if (fileStreamPath == null || fileStreamPath.isFile()) {
                    if (!m15382b(context, fileStreamPath.getAbsolutePath())) {
                        bd.m15428a("remote jar version lower than min limit, need delete");
                        if (fileStreamPath.isFile()) {
                            fileStreamPath.delete();
                        }
                    } else if (m15383c(context, fileStreamPath.getAbsolutePath())) {
                        try {
                            f19407a = new DexClassLoader(fileStreamPath.getAbsolutePath(), context.getDir("outdex", 0).getAbsolutePath(), null, context.getClassLoader());
                        } catch (Throwable e) {
                            bd.m15429a(e);
                        }
                        dexClassLoader = f19407a;
                    } else {
                        bd.m15428a("remote jar md5 is not right, need delete");
                        if (fileStreamPath.isFile()) {
                            fileStreamPath.delete();
                        }
                    }
                }
            }
        }
        return dexClassLoader;
    }

    /* renamed from: b */
    private static boolean m15382b(Context context, String str) {
        Object b = m15381b(str);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        int intValue;
        try {
            intValue = Integer.valueOf(b).intValue();
        } catch (Throwable e) {
            bd.m15432b(e);
            intValue = 0;
        }
        if (intValue >= 4) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static synchronized void m15379a(Context context, C3587l c3587l) {
        synchronized (ax.class) {
            if (!f19408b) {
                if (!de.m15703n(context)) {
                    bd.m15428a("isWifiAvailable = false, will not to update");
                } else if (c3587l.mo2729a(context)) {
                    bd.m15428a("can start update config");
                    new ay(context, c3587l).start();
                    f19408b = true;
                } else {
                    bd.m15428a("check time, will not to update");
                }
            }
        }
    }

    /* renamed from: c */
    private static boolean m15383c(Context context, String str) {
        Object a = cz.m15650a(new File(str));
        bd.m15428a("remote.jar local file digest value digest = " + a);
        if (TextUtils.isEmpty(a)) {
            bd.m15428a("remote.jar local file digest value fail");
            return false;
        }
        Object b = m15381b(str);
        bd.m15428a("remote.jar local file digest value version = " + b);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        CharSequence d = m15384d(context, b);
        bd.m15428a("remote.jar config digest value remoteJarMd5 = " + d);
        if (!TextUtils.isEmpty(d)) {
            return a.equals(d);
        }
        bd.m15428a("remote.jar config digest value lost");
        return false;
    }

    /* renamed from: d */
    private static String m15384d(Context context, String str) {
        return az.m15388a(context).m15399c(str);
    }

    /* renamed from: b */
    private static String m15381b(String str) {
        Throwable e;
        JarFile jarFile = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                bd.m15431b("file size: " + file.length());
            }
            JarFile jarFile2 = new JarFile(str);
            try {
                String value = jarFile2.getManifest().getMainAttributes().getValue("Plugin-Version");
                if (jarFile2 == null) {
                    return value;
                }
                try {
                    jarFile2.close();
                    return value;
                } catch (Exception e2) {
                    return value;
                }
            } catch (Exception e3) {
                e = e3;
                jarFile = jarFile2;
                try {
                    bd.m15429a(e);
                    bd.m15428a("baidu remote sdk is not ready" + str);
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    e = th;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                jarFile = jarFile2;
                if (jarFile != null) {
                    jarFile.close();
                }
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            bd.m15429a(e);
            bd.m15428a("baidu remote sdk is not ready" + str);
            if (jarFile != null) {
                jarFile.close();
            }
            return "";
        }
    }
}
