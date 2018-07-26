package com.baidu.android.pushservice.p031j;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.baidu.android.pushservice.j.a */
public class C0561a {
    /* renamed from: a */
    private final Properties f1848a = new Properties();

    private C0561a() throws IOException {
        Throwable th;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                this.f1848a.load(fileInputStream2);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileInputStream = fileInputStream2;
                th = th3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static C0561a m2417a() throws IOException {
        return new C0561a();
    }

    /* renamed from: a */
    public String m2418a(String str, String str2) {
        return this.f1848a.getProperty(str, str2);
    }
}
