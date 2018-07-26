package com.baidu.location.p191d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p194f.C3376f;
import com.baidu.mapframework.common.p202a.C3473h;
import com.baidu.mobstat.Config;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* renamed from: com.baidu.location.d.f */
public class C3299f {
    /* renamed from: b */
    private static final Object f17894b = new Object();
    /* renamed from: e */
    private static C3299f f17895e;
    /* renamed from: a */
    SharedPreferences f17896a;
    /* renamed from: c */
    private HandlerThread f17897c;
    /* renamed from: d */
    private Handler f17898d;
    /* renamed from: f */
    private String f17899f;
    /* renamed from: g */
    private String f17900g;
    /* renamed from: h */
    private StringBuffer f17901h;
    /* renamed from: i */
    private int f17902i;
    /* renamed from: j */
    private boolean f17903j;
    /* renamed from: k */
    private long f17904k;

    /* renamed from: com.baidu.location.d.f$a */
    private class C3298a extends C3186e {
        /* renamed from: a */
        String f17892a;
        /* renamed from: b */
        final /* synthetic */ C3299f f17893b;

        private C3298a(C3299f c3299f) {
            this.f17893b = c3299f;
            this.f17892a = null;
        }

        /* renamed from: a */
        public void mo2494a() {
            String a;
            this.l = this.f17892a;
            File file = new File(this.l);
            try {
                a = C3391g.m14435a(file, "MD5");
            } catch (Exception e) {
                a = null;
            }
            this.h = "http://loc.map.baidu.com/opre.php";
            this.h += "?qt=operations&trtm=" + System.currentTimeMillis();
            if (a != null) {
                this.h += "&md5=" + a + "&fn=" + file.getName().replace(".zip", "");
            }
            this.i = 1;
        }

        /* renamed from: a */
        public void m13845a(String str) {
            if (!this.f17893b.f17903j && !TextUtils.isEmpty(str)) {
                this.f17892a = str;
                this.f17893b.f17903j = true;
                m13302j();
            }
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z) {
                try {
                    File file = new File(this.f17892a);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e) {
                }
            }
            this.f17893b.f17903j = false;
        }
    }

    private C3299f() {
        this.f17899f = null;
        this.f17900g = null;
        this.f17901h = new StringBuffer();
        this.f17902i = 0;
        this.f17903j = false;
        this.f17896a = null;
        this.f17904k = 0;
        this.f17899f = C3377f.getServiceContext().getFilesDir() + File.separator + "maplog";
        this.f17900g = C3377f.getServiceContext().getFilesDir() + File.separator + "ziplog";
        m13864e();
        if (this.f17896a == null) {
            this.f17896a = C3377f.getServiceContext().getSharedPreferences("map_loctype_statics", 0);
        }
    }

    /* renamed from: a */
    public static C3299f m13848a() {
        C3299f c3299f;
        synchronized (f17894b) {
            if (f17895e == null) {
                f17895e = new C3299f();
            }
            c3299f = f17895e;
        }
        return c3299f;
    }

    /* renamed from: a */
    private void m13854a(String str, File file) throws Exception {
        try {
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Exception e) {
        }
        OutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
        m13856a(zipOutputStream, file, file.getName(), bufferedOutputStream);
        bufferedOutputStream.close();
        zipOutputStream.close();
    }

    /* renamed from: a */
    private void m13855a(String str, String str2) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (str2 != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter.write(str2);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m13856a(ZipOutputStream zipOutputStream, File file, String str, BufferedOutputStream bufferedOutputStream) throws Exception {
        if (file == null || !file.isDirectory()) {
            zipOutputStream.putNextEntry(new ZipEntry(str));
            InputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            while (true) {
                int read = bufferedInputStream.read();
                if (read != -1) {
                    bufferedOutputStream.write(read);
                } else {
                    bufferedInputStream.close();
                    fileInputStream.close();
                    file.delete();
                    return;
                }
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (listFiles.length == 0) {
                zipOutputStream.putNextEntry(new ZipEntry(str + File.separator));
            }
            for (int i = 0; i < listFiles.length; i++) {
                m13856a(zipOutputStream, listFiles[i], str + File.separator + listFiles[i].getName(), bufferedOutputStream);
            }
        }
    }

    /* renamed from: d */
    private String m13862d(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: e */
    private void m13864e() {
        try {
            File file = new File(C3377f.getServiceContext().getFilesDir() + File.separator + "maplog");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.isDirectory() && file.list() != null && file.list().length > 1) {
                File[] listFiles = file.listFiles();
                for (int i = 0; i < listFiles.length; i++) {
                    long lastModified = listFiles[i].lastModified();
                    if (lastModified > 0 && System.currentTimeMillis() - lastModified > 172800000) {
                        try {
                            listFiles[i].delete();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: e */
    private void m13865e(String str) {
        C3301g.m13879a().m13885a("locType&result=" + str);
    }

    /* renamed from: a */
    public void m13868a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Message obtainMessage = this.f17898d.obtainMessage(1);
            Bundle bundle = new Bundle();
            bundle.putByteArray("log", str.getBytes());
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    /* renamed from: b */
    public void m13869b() {
        this.f17897c = new HandlerThread("map-loc-log");
        this.f17897c.start();
        this.f17898d = new Handler(this, this.f17897c.getLooper()) {
            /* renamed from: a */
            final /* synthetic */ C3299f f17891a;

            public void handleMessage(Message message) {
                long j = 0;
                String str = null;
                int i = 0;
                byte[] byteArray;
                Object str2;
                switch (message.what) {
                    case 1:
                        try {
                            byteArray = message.getData().getByteArray("log");
                            if (byteArray != null) {
                                str2 = new String(byteArray);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append(C3391g.m14442b());
                                stringBuffer.append(" ");
                                stringBuffer.append(str2);
                                str = Jni.encodeOfflineLocationUpdateRequest(stringBuffer.toString()) + "\r\n";
                                if (this.f17891a.f17901h == null) {
                                    this.f17891a.f17901h = new StringBuffer();
                                }
                                this.f17891a.f17901h.append(str);
                                this.f17891a.f17902i = this.f17891a.f17902i + 1;
                                if (this.f17891a.f17901h.length() > 2048 || this.f17891a.f17902i > 3) {
                                    this.f17891a.m13855a(this.f17891a.m13862d(this.f17891a.f17899f) + File.separator + C3391g.m14445c() + C3473h.f18755a, this.f17891a.f17901h.toString());
                                    this.f17891a.f17901h = null;
                                    this.f17891a.f17902i = 0;
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    case 2:
                        try {
                            Bundle data = message.getData();
                            if (data != null) {
                                byteArray = data.getByteArray("errorid");
                                if (byteArray != null) {
                                    str2 = new String(byteArray);
                                }
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                str = this.f17891a.m13862d(this.f17891a.f17900g) + File.separator + str2 + ".zip";
                                this.f17891a.m13864e();
                                this.f17891a.m13854a(str, new File(this.f17891a.m13862d(this.f17891a.f17899f)));
                                File file = new File(str);
                                if (file.exists() && file.getTotalSpace() > 100 && !this.f17891a.f17903j) {
                                    C3376f.m14355a();
                                    if (C3376f.m14363j() || file.getTotalSpace() < 204800) {
                                        new C3298a().m13845a(str);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    case 3:
                        try {
                            String str3;
                            Bundle data2 = message.getData();
                            if (data2 != null) {
                                byte[] byteArray2 = data2.getByteArray("loctype");
                                if (byteArray2 != null) {
                                    str3 = new String(byteArray2);
                                    if (!TextUtils.isEmpty(str3) && this.f17891a.f17896a != null) {
                                        long j2 = this.f17891a.f17896a.getLong("lastUpTime", 0);
                                        Editor edit = this.f17891a.f17896a.edit();
                                        if (j2 == 0) {
                                            edit.putLong("lastUpTime", System.currentTimeMillis());
                                        }
                                        Set hashSet = new HashSet();
                                        String string = this.f17891a.f17896a.getString("loctypestr", "");
                                        int length = (TextUtils.isEmpty(string) || !string.contains("|")) ? 0 : string.split("\\|").length;
                                        if (length > 0) {
                                            String[] split = string.split("\\|");
                                            for (length = 0; length < r6; length++) {
                                                if (split[length].contains(";")) {
                                                    String[] split2 = split[length].split(";", 2);
                                                    if (split2[0].equals(str3)) {
                                                        split[length] = split2[0] + ";" + (Integer.valueOf(split2[1]).intValue() + 1);
                                                        length = 1;
                                                        if (length != 0) {
                                                            for (Object add : split) {
                                                                hashSet.add(add);
                                                            }
                                                            hashSet.add(str3 + ";1");
                                                        } else {
                                                            for (Object add2 : split) {
                                                                hashSet.add(add2);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            length = 0;
                                            if (length != 0) {
                                                while (length < r6) {
                                                    hashSet.add(add2);
                                                }
                                            } else {
                                                while (length < r6) {
                                                    hashSet.add(add2);
                                                }
                                                hashSet.add(str3 + ";1");
                                            }
                                        } else {
                                            hashSet.add(str3 + ";1");
                                        }
                                        StringBuffer stringBuffer2 = new StringBuffer();
                                        if (hashSet.size() > 0) {
                                            String[] strArr = (String[]) hashSet.toArray(new String[hashSet.size()]);
                                            while (i < hashSet.size()) {
                                                stringBuffer2.append(strArr[i] + "|");
                                                i++;
                                            }
                                            edit.putString("loctypestr", stringBuffer2.toString());
                                        }
                                        edit.commit();
                                        long j3 = this.f17891a.f17896a.getLong("lastUpTime", 0);
                                        if (hashSet.size() > 0 && System.currentTimeMillis() - j3 > 86400000) {
                                            this.f17891a.m13865e(stringBuffer2.toString());
                                            edit.putLong("lastUpTime", System.currentTimeMillis());
                                            edit.putString("loctypestr", "");
                                            edit.commit();
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            str3 = null;
                            if (!TextUtils.isEmpty(str3)) {
                                return;
                            }
                            return;
                        } catch (Exception e3) {
                            return;
                        }
                    case 4:
                        try {
                            File file2 = new File(this.f17891a.m13862d(this.f17891a.f17900g));
                            if (file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) {
                                File[] listFiles = file2.listFiles();
                                while (i < listFiles.length) {
                                    long lastModified = listFiles[i].lastModified();
                                    if (lastModified > j) {
                                        if (System.currentTimeMillis() - lastModified > Config.MAX_LOG_DATA_EXSIT_TIME) {
                                            listFiles[i].delete();
                                        } else {
                                            str = listFiles[i].getAbsolutePath();
                                            j = lastModified;
                                        }
                                    }
                                    i++;
                                }
                                if (str != null) {
                                    C3376f.m14355a();
                                    if (C3376f.m14363j()) {
                                        new C3298a().m13845a(str);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception e4) {
                            return;
                        }
                    case 5:
                        try {
                            if (this.f17891a.f17901h != null && this.f17891a.f17901h.length() > 0) {
                                this.f17891a.m13855a(this.f17891a.m13862d(this.f17891a.f17899f) + File.separator + C3391g.m14445c() + C3473h.f18755a, this.f17891a.f17901h.toString());
                                this.f17891a.f17901h = null;
                                this.f17891a.f17902i = 0;
                                return;
                            }
                            return;
                        } catch (Exception e5) {
                            return;
                        }
                    default:
                        return;
                }
            }
        };
    }

    /* renamed from: b */
    public void m13870b(String str) {
        if (!TextUtils.isEmpty(str) && System.currentTimeMillis() - this.f17904k >= 3000) {
            this.f17904k = System.currentTimeMillis();
            Message obtainMessage = this.f17898d.obtainMessage(3);
            Bundle bundle = new Bundle();
            bundle.putByteArray("loctype", str.getBytes());
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    /* renamed from: c */
    public void m13871c() {
        try {
            if (this.f17898d != null) {
                this.f17898d.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
        }
        this.f17898d = null;
        try {
            if (this.f17897c != null) {
                this.f17897c.quit();
                this.f17897c.interrupt();
            }
        } catch (Exception e2) {
        }
        this.f17897c = null;
    }

    /* renamed from: c */
    public void m13872c(String str) {
        if (!TextUtils.isEmpty(str)) {
            m13873d();
            Message obtainMessage = this.f17898d.obtainMessage(2);
            Bundle bundle = new Bundle();
            bundle.putByteArray("errorid", str.getBytes());
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    /* renamed from: d */
    public void m13873d() {
        this.f17898d.sendEmptyMessage(5);
    }
}
