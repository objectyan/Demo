package com.baidu.location.p191d.p192a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.baidu.location.d.a.d */
public class C3264d {
    /* renamed from: a */
    static String[] f17726a = new String[]{"lbaca.dat", "lbacb.dat", "lbacc.dat", "lbacd.dat"};
    /* renamed from: b */
    private static C3264d f17727b;

    private C3264d() {
    }

    /* renamed from: a */
    public static C3264d m13668a() {
        if (f17727b == null) {
            f17727b = new C3264d();
        }
        return f17727b;
    }

    /* renamed from: a */
    static void m13669a(StringBuffer stringBuffer, File file) {
        Object obj = 1;
        if (file.exists()) {
            try {
                OutputStream fileOutputStream = new FileOutputStream(file, true);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(fileOutputStream));
                int i = 0;
                while (i < 3) {
                    try {
                        gZIPOutputStream.write(stringBuffer.toString().getBytes());
                    } catch (Exception e) {
                        obj = null;
                    }
                    if (obj == null) {
                        i++;
                    }
                }
                gZIPOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    static void m13670a(StringBuffer stringBuffer, StringBuffer stringBuffer2, String str) {
        if (stringBuffer.length() + stringBuffer2.length() < 8190) {
            stringBuffer.append(stringBuffer2);
        } else if (str != null) {
            try {
                C3264d.m13669a(stringBuffer, new File(str));
            } catch (Exception e) {
            }
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(stringBuffer2);
        }
    }

    /* renamed from: a */
    public static boolean m13671a(int i) {
        boolean z = false;
        String c = C3264d.m13676c(i);
        if (c == null || i != 2) {
            return z;
        }
        File file = new File(c);
        if (file.exists()) {
            if (file.length() <= 92160) {
                return true;
            }
            if (!C3264d.m13673a(file, i)) {
                return z;
            }
        }
        File file2 = new File(c);
        if (file2.exists()) {
            return z;
        }
        try {
            return C3264d.m13672a(file2);
        } catch (Exception e) {
            return z;
        }
    }

    /* renamed from: a */
    private static boolean m13672a(File file) {
        try {
            file.createNewFile();
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("C");
            stringBuffer.append("\t");
            stringBuffer.append(Jni.encode(C3381b.m14398a().m14406e()));
            stringBuffer.append("\n");
            C3264d.m13669a(stringBuffer, file);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m13673a(File file, int i) {
        String str = null;
        if (i == 2) {
            str = C3264d.m13675c();
        }
        return str == null ? false : file.renameTo(new File(str));
    }

    /* renamed from: b */
    static String m13674b(int i) {
        String k = C3391g.m14455k();
        if (k == null) {
            return null;
        }
        if (i == 1) {
            k = k + File.separator + "llmis1";
        } else if (i != 2) {
            return null;
        } else {
            k = k + File.separator + "llmis2";
        }
        File file = new File(k);
        if (file.exists()) {
            return k;
        }
        try {
            return !file.mkdirs() ? null : k;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: c */
    private static String m13675c() {
        String b = C3264d.m13674b(2);
        for (String str : f17726a) {
            if (!new File(b + File.separator + str).exists()) {
                return b + File.separator + str;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m13676c(int i) {
        String b = C3264d.m13674b(i);
        return b == null ? null : i == 2 ? b + File.separator + "lbacz.dat" : i == 1 ? b + File.separator + "lmibacz.dat" : null;
    }

    /* renamed from: b */
    public String m13677b() {
        String b = C3264d.m13674b(2);
        try {
            for (String str : f17726a) {
                File file = new File(b + File.separator + str);
                if (file.exists()) {
                    if (file.length() > 524288) {
                        file.delete();
                    } else if (file.length() >= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                        return b + File.separator + str;
                    }
                }
            }
            if (!C3268e.m13681a().f17736a) {
                File file2 = new File(b + File.separator + "lbacz.dat");
                if (file2.exists() && file2.length() > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                    return b + File.separator + "lbacz.dat";
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}
