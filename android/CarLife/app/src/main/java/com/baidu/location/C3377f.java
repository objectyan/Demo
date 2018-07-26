package com.baidu.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p195g.C3379a;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.baidu.location.f */
public class C3377f extends Service {
    public static boolean isServing = false;
    private static final String jarFileName = "app.jar";
    public static Context mC = null;
    public static String replaceFileName = "repll.jar";
    LLSInterface lib = null;
    LLSInterface libJar = null;
    LLSInterface libNat = null;

    public static float getFrameVersion() {
        return 7.32f;
    }

    public static String getJarFileName() {
        return jarFileName;
    }

    public static Context getServiceContext() {
        return mC;
    }

    private boolean readConf(File file) {
        boolean z = false;
        try {
            File file2 = new File(C3391g.m14456l() + "/grtcfrsa.dat");
            if (file2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(200);
                if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean()) {
                    int readInt = randomAccessFile.readInt();
                    if (readInt != 0) {
                        byte[] bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        String str = new String(bArr);
                        String a = C3391g.m14435a(file, "SHA-256");
                        if (!(str == null || a == null || !C3391g.m14443b(a, str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB"))) {
                            z = true;
                        }
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        return z;
    }

    public IBinder onBind(Intent intent) {
        return this.lib.onBind(intent);
    }

    public void onCreate() {
        mC = getApplicationContext();
        System.currentTimeMillis();
        this.libNat = new C3379a();
        try {
            File file = new File(C3391g.m14456l() + File.separator + replaceFileName);
            File file2 = new File(C3391g.m14456l() + File.separator + jarFileName);
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            if (file2.exists() && readConf(new File(C3391g.m14456l() + File.separator + jarFileName))) {
                this.libJar = (LLSInterface) new DexClassLoader(C3391g.m14456l() + File.separator + jarFileName, C3391g.m14456l(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
            }
        } catch (Exception e) {
            this.libJar = null;
        }
        if (this.libJar == null || this.libJar.getVersion() < this.libNat.getVersion()) {
            this.lib = this.libNat;
            this.libJar = null;
        } else {
            this.lib = this.libJar;
            this.libNat = null;
        }
        isServing = true;
        this.lib.onCreate(this);
    }

    public void onDestroy() {
        isServing = false;
        this.lib.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return this.lib.onStartCommand(intent, i, i2);
    }

    public void onTaskRemoved(Intent intent) {
        this.lib.onTaskRemoved(intent);
    }

    public boolean onUnbind(Intent intent) {
        return this.lib.onUnBind(intent);
    }
}
