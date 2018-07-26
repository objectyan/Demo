package com.baidu.location.p189b;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p188h.C3380a;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3382c;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p194f.C3376f;
import com.baidu.location.p195g.C3379a;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import cz.msebera.android.httpclient.C6591q;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.baidu.location.b.e */
public class C3221e implements UncaughtExceptionHandler {
    /* renamed from: a */
    private static C3221e f17528a = null;
    /* renamed from: b */
    private int f17529b = 0;

    private C3221e() {
    }

    /* renamed from: a */
    public static C3221e m13518a() {
        if (f17528a == null) {
            f17528a = new C3221e();
        }
        return f17528a;
    }

    /* renamed from: a */
    private String m13519a(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    /* renamed from: a */
    private void m13520a(File file, String str, String str2) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(280);
            randomAccessFile.writeInt(12346);
            randomAccessFile.seek(300);
            randomAccessFile.writeLong(System.currentTimeMillis());
            byte[] bytes = str.getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.seek(600);
            bytes = str2.getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            if (!m13521a(str, str2)) {
                randomAccessFile.seek(280);
                randomAccessFile.writeInt(1326);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private boolean m13521a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!C3376f.m14363j()) {
            return false;
        }
        try {
            URL url = new URL(C3391g.f18378e);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("e0");
            stringBuffer.append("=");
            stringBuffer.append(str);
            stringBuffer.append("&");
            stringBuffer.append("e1");
            stringBuffer.append("=");
            stringBuffer.append(str2);
            stringBuffer.append("&");
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(C3380a.f18303b);
            httpURLConnection.setReadTimeout(C3380a.f18303b);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            httpURLConnection.setRequestProperty(C6591q.f26545b, "UTF-8");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.flush();
            outputStream.close();
            return httpURLConnection.getResponseCode() == 200;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public void m13522b() {
        String str = null;
        try {
            File file = new File((Environment.getExternalStorageDirectory().getPath() + "/traces") + "/error_fs2.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(280);
                if (1326 == randomAccessFile.readInt()) {
                    String str2;
                    byte[] bArr;
                    randomAccessFile.seek(308);
                    int readInt = randomAccessFile.readInt();
                    if (readInt <= 0 || readInt >= 2048) {
                        str2 = null;
                    } else {
                        bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        str2 = new String(bArr, 0, readInt);
                    }
                    randomAccessFile.seek(600);
                    readInt = randomAccessFile.readInt();
                    if (readInt > 0 && readInt < 2048) {
                        bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        str = new String(bArr, 0, readInt);
                    }
                    if (m13521a(str2, str)) {
                        randomAccessFile.seek(280);
                        randomAccessFile.writeInt(12346);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        File file;
        File file2;
        Object obj;
        File file3 = null;
        this.f17529b++;
        if (this.f17529b > 2) {
            Process.killProcess(Process.myPid());
            return;
        }
        String a;
        String encode;
        Object obj2;
        String str;
        RandomAccessFile randomAccessFile;
        if (System.currentTimeMillis() - C3379a.m14390b() < BNOffScreenParams.MIN_ENTER_INTERVAL && 7.32f > C3377f.getFrameVersion()) {
            if (System.currentTimeMillis() - C3382c.m14410a().m14415c() < 40000) {
                file = new File(C3391g.m14456l() + File.separator + C3377f.getJarFileName());
                if (file.exists()) {
                    file.delete();
                }
            } else {
                C3382c.m14410a().m14414b(System.currentTimeMillis());
            }
        }
        try {
            Object obj3;
            String str2;
            Object obj4;
            a = m13519a(th);
            if (a != null) {
                try {
                    if (a.contains("com.baidu.location")) {
                        obj3 = 1;
                        str2 = C3381b.m14398a().m14399a(false) + C3181a.m13265a().m13283f();
                        obj4 = obj3;
                        encode = str2 == null ? Jni.encode(str2) : null;
                        obj2 = obj4;
                        if (obj2 != null) {
                            try {
                                str = Environment.getExternalStorageDirectory().getPath() + "/traces";
                                file = new File(str + "/error_fs2.dat");
                                if (file.exists()) {
                                    file2 = new File(str);
                                    if (!file2.exists()) {
                                        file2.mkdirs();
                                    }
                                    if (file.createNewFile()) {
                                        file3 = file;
                                    }
                                    m13520a(file3, encode, a);
                                } else {
                                    randomAccessFile = new RandomAccessFile(file, "rw");
                                    randomAccessFile.seek(300);
                                    if (System.currentTimeMillis() - randomAccessFile.readLong() > 86400000) {
                                        m13520a(file, encode, a);
                                    }
                                    randomAccessFile.close();
                                }
                            } catch (Exception e) {
                            }
                        }
                        Process.killProcess(Process.myPid());
                    }
                } catch (Exception e2) {
                    obj2 = a;
                    obj = file;
                    encode = null;
                    obj2 = null;
                    if (obj2 != null) {
                        str = Environment.getExternalStorageDirectory().getPath() + "/traces";
                        file = new File(str + "/error_fs2.dat");
                        if (file.exists()) {
                            file2 = new File(str);
                            if (file2.exists()) {
                                file2.mkdirs();
                            }
                            if (file.createNewFile()) {
                                file3 = file;
                            }
                            m13520a(file3, encode, a);
                        } else {
                            randomAccessFile = new RandomAccessFile(file, "rw");
                            randomAccessFile.seek(300);
                            if (System.currentTimeMillis() - randomAccessFile.readLong() > 86400000) {
                                m13520a(file, encode, a);
                            }
                            randomAccessFile.close();
                        }
                    }
                    Process.killProcess(Process.myPid());
                }
            }
            obj3 = null;
            str2 = C3381b.m14398a().m14399a(false) + C3181a.m13265a().m13283f();
            if (str2 == null) {
            }
            obj4 = obj3;
            encode = str2 == null ? Jni.encode(str2) : null;
            obj2 = obj4;
        } catch (Exception e3) {
            file = null;
            obj = file;
            encode = null;
            obj2 = null;
            if (obj2 != null) {
                str = Environment.getExternalStorageDirectory().getPath() + "/traces";
                file = new File(str + "/error_fs2.dat");
                if (file.exists()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(300);
                    if (System.currentTimeMillis() - randomAccessFile.readLong() > 86400000) {
                        m13520a(file, encode, a);
                    }
                    randomAccessFile.close();
                } else {
                    file2 = new File(str);
                    if (file2.exists()) {
                        file2.mkdirs();
                    }
                    if (file.createNewFile()) {
                        file3 = file;
                    }
                    m13520a(file3, encode, a);
                }
            }
            Process.killProcess(Process.myPid());
        }
        if (obj2 != null) {
            str = Environment.getExternalStorageDirectory().getPath() + "/traces";
            file = new File(str + "/error_fs2.dat");
            if (file.exists()) {
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(300);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > 86400000) {
                    m13520a(file, encode, a);
                }
                randomAccessFile.close();
            } else {
                file2 = new File(str);
                if (file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    file3 = file;
                }
                m13520a(file3, encode, a);
            }
        }
        Process.killProcess(Process.myPid());
    }
}
