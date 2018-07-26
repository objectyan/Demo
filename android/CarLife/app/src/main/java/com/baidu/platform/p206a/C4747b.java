package com.baidu.platform.p206a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: NativeRuntime */
/* renamed from: com.baidu.platform.a.b */
public class C4747b {
    /* renamed from: a */
    public static final boolean f19739a = false;
    /* renamed from: c */
    private static final String f19740c = "lib/armeabi/";
    /* renamed from: d */
    private static final Set<String> f19741d = new HashSet();
    /* renamed from: e */
    private static final Set<String> f19742e = new HashSet();
    /* renamed from: f */
    private static final boolean f19743f = false;
    /* renamed from: g */
    private static final String f19744g = "/debuginfo/update/";
    /* renamed from: h */
    private static final String f19745h = "/debuginfo/update/config.txt";
    /* renamed from: i */
    private static final HashMap<String, String> f19746i = new HashMap();
    /* renamed from: b */
    private Context f19747b;

    /* renamed from: a */
    public static C4747b m15799a() {
        return new C4747b(C4746a.m15797a().m15798b());
    }

    protected C4747b(Context context) {
        this.f19747b = context;
    }

    /* renamed from: a */
    public static void m15800a(HashMap<String, String> hotfixSoMap) {
        if (hotfixSoMap != null && hotfixSoMap.size() > 0 && f19746i.size() == 0) {
            f19746i.putAll(hotfixSoMap);
        }
    }

    /* renamed from: a */
    public synchronized boolean m15802a(String name) {
        boolean z;
        try {
            synchronized (f19741d) {
                if (f19741d.contains(name)) {
                    z = true;
                } else {
                    String libName = "lib" + name + ".so";
                    if (f19746i.containsKey(libName)) {
                        try {
                            System.load((String) f19746i.get(libName));
                        } catch (Exception e) {
                            System.loadLibrary(name);
                        }
                    } else {
                        System.loadLibrary(name);
                    }
                    synchronized (f19741d) {
                        f19741d.add(name);
                    }
                    z = true;
                }
            }
        } catch (Throwable th) {
            z = m15804b(name);
        }
        return z;
    }

    /* renamed from: b */
    public Set<String> m15803b() {
        Set hashSet;
        synchronized (f19741d) {
            hashSet = new HashSet(f19741d);
        }
        return hashSet;
    }

    /* renamed from: c */
    public Set<String> m15805c() {
        Set hashSet;
        synchronized (f19742e) {
            hashSet = new HashSet(f19742e);
        }
        return hashSet;
    }

    /* renamed from: b */
    protected boolean m15804b(String name) {
        String libname = System.mapLibraryName(name);
        if (m15806c(libname)) {
            try {
                System.load(new File(m15808e(), libname).getAbsolutePath());
                synchronized (f19741d) {
                    f19741d.add(name);
                }
                return true;
            } catch (Throwable th) {
                synchronized (f19742e) {
                    f19742e.add(name);
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    protected boolean m15806c(String libname) {
        Throwable th;
        boolean z = false;
        String path = f19740c + libname;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(m15807d());
            try {
                File out = new File(m15808e(), libname);
                ZipEntry zipEntry = zipFile2.getEntry(path);
                if (zipEntry == null) {
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e) {
                        }
                    }
                    zipFile = zipFile2;
                } else {
                    m15801a(zipFile2.getInputStream(zipEntry), new FileOutputStream(out));
                    z = true;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e2) {
                        }
                    }
                    zipFile = zipFile2;
                }
            } catch (Exception e3) {
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e4) {
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            if (zipFile != null) {
                zipFile.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
        return z;
    }

    @TargetApi(8)
    /* renamed from: d */
    protected String m15807d() {
        if (8 <= VERSION.SDK_INT) {
            return this.f19747b.getPackageCodePath();
        }
        return "";
    }

    /* renamed from: e */
    protected String m15808e() {
        File soDir = new File(this.f19747b.getFilesDir(), "libs");
        soDir.mkdirs();
        return soDir.getAbsolutePath();
    }

    /* renamed from: a */
    protected final void m15801a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buf = new byte[4096];
        while (true) {
            try {
                int count = inputStream.read(buf);
                if (count == -1) {
                    break;
                }
                outputStream.write(buf, 0, count);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
        }
        outputStream.flush();
        try {
            outputStream.close();
        } catch (IOException e3) {
        }
    }
}
