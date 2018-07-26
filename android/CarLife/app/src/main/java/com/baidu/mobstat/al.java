package com.baidu.mobstat;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class al {
    /* renamed from: a */
    private static String f19385a = (VERSION.SDK_INT < 9 ? "http://openrcv.baidu.com/1010/bplus.gif" : "https://openrcv.baidu.com/1010/bplus.gif");
    /* renamed from: b */
    private static al f19386b;
    /* renamed from: c */
    private Handler f19387c;

    private al() {
        HandlerThread handlerThread = new HandlerThread("LogSender");
        handlerThread.start();
        this.f19387c = new Handler(handlerThread.getLooper());
    }

    /* renamed from: a */
    public static al m15336a() {
        if (f19386b == null) {
            synchronized (al.class) {
                if (f19386b == null) {
                    f19386b = new al();
                }
            }
        }
        return f19386b;
    }

    /* renamed from: a */
    public void m15345a(Context context, String str) {
        bd.m15428a("data = " + str);
        if (str != null && !"".equals(str)) {
            this.f19387c.post(new am(this, str, context));
        }
    }

    /* renamed from: a */
    private void m15341a(String str) {
        cu.m15631a("backups/system" + File.separator + "__send_log_data_" + System.currentTimeMillis(), str, false);
    }

    /* renamed from: a */
    private void m15338a(Context context) {
        if ("mounted".equals(cu.m15627a())) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/system");
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    try {
                        Arrays.sort(listFiles, new an(this));
                    } catch (Throwable e) {
                        bd.m15432b(e);
                    }
                    int i = 0;
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            String name = file2.getName();
                            if (!TextUtils.isEmpty(name) && name.startsWith("__send_log_data_")) {
                                name = "backups/system" + File.separator + name;
                                String b = cu.m15633b(name);
                                if (m15344b(context, b)) {
                                    cu.m15636c(name);
                                    i = 0;
                                } else {
                                    m15342a(b, name);
                                    i++;
                                    if (i >= 5) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m15342a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception e) {
                jSONObject = null;
            }
            JSONObject a = C3607v.m15781a(jSONObject);
            if (a != null) {
                C3607v.m15782b(a);
                cu.m15631a(str2, jSONObject.toString(), false);
            }
        }
    }

    /* renamed from: b */
    private boolean m15344b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            m15337a(context, f19385a, str);
            return true;
        } catch (Throwable e) {
            bd.m15434c(e);
            return false;
        }
    }

    /* renamed from: a */
    private String m15337a(Context context, String str, String str2) {
        boolean z;
        if (str.startsWith("https:")) {
            z = false;
        } else {
            z = true;
        }
        HttpURLConnection d = cu.m15637d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Encoding", "gzip");
        d.connect();
        String stringBuilder;
        try {
            byte[] a;
            OutputStream outputStream = d.getOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            gZIPOutputStream.write(new byte[]{(byte) 72, (byte) 77, (byte) 48, (byte) 49});
            gZIPOutputStream.write(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1});
            gZIPOutputStream.write(new byte[]{(byte) 0, (byte) 0, (byte) 3, (byte) -14});
            gZIPOutputStream.write(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0});
            gZIPOutputStream.write(new byte[]{(byte) 0, (byte) 2});
            if (z) {
                gZIPOutputStream.write(new byte[]{(byte) 0, (byte) 1});
            } else {
                gZIPOutputStream.write(new byte[]{(byte) 0, (byte) 0});
            }
            gZIPOutputStream.write(new byte[]{(byte) 72, (byte) 77, (byte) 48, (byte) 49});
            if (z) {
                a = cs.m15618a();
                byte[] a2 = dc.m15669a(false, cw.m15643a(), a);
                gZIPOutputStream.write(m15343a((long) a2.length, 4));
                gZIPOutputStream.write(a2);
                a = cs.m15619a(a, new byte[]{(byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1}, str2.getBytes("utf-8"));
                gZIPOutputStream.write(m15343a((long) a.length, 2));
            } else {
                a = str2.getBytes("utf-8");
            }
            gZIPOutputStream.write(a);
            gZIPOutputStream.close();
            outputStream.close();
            int responseCode = d.getResponseCode();
            int contentLength = d.getContentLength();
            bd.m15433c("code: " + responseCode + "; len: " + contentLength);
            if (responseCode == 200 && contentLength == 0) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
                StringBuilder stringBuilder2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder2.append(readLine);
                }
                stringBuilder = stringBuilder2.toString();
                return stringBuilder;
            }
            throw new IOException("Response code = " + d.getResponseCode());
        } catch (Exception e) {
            stringBuilder = e;
            bd.m15432b((Throwable) stringBuilder);
            return "";
        } finally {
            d.disconnect();
        }
    }

    /* renamed from: a */
    private static byte[] m15343a(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[(i - i2) - 1] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        return bArr;
    }
}
