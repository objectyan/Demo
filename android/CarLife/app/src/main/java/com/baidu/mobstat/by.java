package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.Timer;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

class by {
    /* renamed from: a */
    private static by f19539a = new by();
    /* renamed from: b */
    private boolean f19540b = false;
    /* renamed from: c */
    private int f19541c = 0;
    /* renamed from: d */
    private int f19542d = 1;
    /* renamed from: e */
    private SendStrategyEnum f19543e = SendStrategyEnum.APP_START;
    /* renamed from: f */
    private Timer f19544f;
    /* renamed from: g */
    private Handler f19545g;

    /* renamed from: a */
    public static by m15524a() {
        return f19539a;
    }

    private by() {
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.f19545g = new Handler(handlerThread.getLooper());
    }

    /* renamed from: a */
    public void m15540a(int i) {
        if (i >= 0 && i <= 30) {
            this.f19541c = i;
        }
    }

    /* renamed from: a */
    public void m15542a(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        if (!sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.f19543e = sendStrategyEnum;
            bj.m15464a().m15466a(context, this.f19543e.ordinal());
            if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                bj.m15464a().m15470b(context, 24);
            }
        } else if (i <= 0 || i > 24) {
            db.m15663c("timeInterval is invalid, new strategy does not work");
        } else {
            this.f19542d = i;
            this.f19543e = SendStrategyEnum.SET_TIME_INTERVAL;
            bj.m15464a().m15466a(context, this.f19543e.ordinal());
            bj.m15464a().m15470b(context, this.f19542d);
        }
        this.f19540b = z;
        bj.m15464a().m15468a(context, this.f19540b);
        db.m15657a("sstype is:" + this.f19543e.name() + " And timeInterval is:" + this.f19542d + " And mOnlyWifi:" + this.f19540b);
    }

    /* renamed from: a */
    public void m15541a(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context != null) {
            this.f19545g.post(new bz(this, context));
        }
    }

    /* renamed from: b */
    public void m15544b(Context context) {
        Context applicationContext = context.getApplicationContext();
        long j = (long) (this.f19542d * 3600000);
        this.f19544f = new Timer();
        this.f19544f.schedule(new cb(this, applicationContext), j, j);
    }

    /* renamed from: c */
    private void m15536c(Context context) {
        if (!this.f19540b || de.m15703n(context)) {
            this.f19545g.post(new cc(this, context));
        }
    }

    /* renamed from: b */
    private static void m15532b(Context context, String str, String str2) {
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str2);
        } catch (Exception e) {
        }
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get(Config.TRACE_PART);
                jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
            } catch (Exception e2) {
            }
            cu.m15630a(context, str, jSONObject.toString(), false);
        }
    }

    /* renamed from: a */
    public void m15543a(Context context, String str) {
        cu.m15630a(context, Config.PREFIX_SEND_DATA + System.currentTimeMillis(), str, false);
    }

    /* renamed from: b */
    private boolean m15533b(Context context, String str) {
        boolean z = false;
        if (!this.f19540b || de.m15703n(context)) {
            try {
                m15535c(context, Config.LOG_SEND_URL, str);
                z = true;
            } catch (Throwable e) {
                db.m15664c(e);
            }
            db.m15657a("send log data over. result = " + z + "; data = " + str);
        }
        return z;
    }

    /* renamed from: c */
    private String m15535c(Context context, String str, String str2) {
        if (str.startsWith("https://")) {
            return m15538d(context, str, str2);
        }
        return m15539e(context, str, str2);
    }

    /* renamed from: d */
    private String m15538d(Context context, String str, String str2) {
        HttpURLConnection d = cu.m15637d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Type", "gzip");
        d.connect();
        db.m15657a("AdUtil.httpPost connected");
        try {
            String readLine;
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(d.getOutputStream())));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            for (readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringBuilder.append(readLine);
            }
            int contentLength = d.getContentLength();
            if (d.getResponseCode() == 200 && contentLength == 0) {
                readLine = stringBuilder.toString();
                return readLine;
            }
            throw new IOException("http code = " + d.getResponseCode() + "; contentResponse = " + stringBuilder);
        } finally {
            d.disconnect();
        }
    }

    /* renamed from: e */
    private String m15539e(Context context, String str, String str2) {
        db.m15657a("httpPostEncrypt");
        HttpURLConnection d = cu.m15637d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Type", "gzip");
        byte[] a = cs.m15618a();
        byte[] b = cs.m15621b();
        d.setRequestProperty("key", dc.m15666a(a));
        d.setRequestProperty("iv", dc.m15666a(b));
        a = cs.m15619a(a, b, str2.getBytes("utf-8"));
        d.connect();
        db.m15657a("AdUtil.httpPost connected");
        try {
            String readLine;
            OutputStream gZIPOutputStream = new GZIPOutputStream(d.getOutputStream());
            gZIPOutputStream.write(a);
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            for (readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringBuilder.append(readLine);
            }
            int contentLength = d.getContentLength();
            if (d.getResponseCode() == 200 && contentLength == 0) {
                readLine = stringBuilder.toString();
                return readLine;
            }
            throw new IOException("http code = " + d.getResponseCode() + "; contentResponse = " + stringBuilder);
        } finally {
            d.disconnect();
        }
    }
}
