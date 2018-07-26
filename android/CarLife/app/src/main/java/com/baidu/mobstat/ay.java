package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.net.HttpURLConnection;

class ay extends Thread {
    /* renamed from: a */
    private Context f19409a;
    /* renamed from: b */
    private C3587l f19410b;

    public ay(Context context, C3587l c3587l) {
        this.f19409a = context;
        this.f19410b = c3587l;
    }

    public void run() {
        try {
            int i = bb.f19430a ? 3 : 10;
            bd.m15428a("start version check in " + i + "s");
            sleep((long) (i * 1000));
            m15385a();
            m15386a(this.f19409a);
        } catch (Throwable e) {
            bd.m15429a(e);
        }
        ax.f19408b = false;
    }

    /* renamed from: a */
    private void m15386a(Context context) {
        this.f19410b.mo2726a(context, System.currentTimeMillis());
    }

    /* renamed from: a */
    private synchronized void m15385a() {
        bd.m15428a("start get config and download jar");
        Context context = this.f19409a;
        C3587l c3587l = this.f19410b;
        String b = m15387b(context);
        bd.m15433c("update req url is:" + b);
        HttpURLConnection d = cu.m15637d(context, b);
        try {
            d.connect();
            String headerField = d.getHeaderField("X-CONFIG");
            bd.m15428a("config is: " + headerField);
            Object headerField2 = d.getHeaderField("X-SIGN");
            bd.m15428a("sign is: " + headerField2);
            int responseCode = d.getResponseCode();
            bd.m15428a("update response code is: " + responseCode);
            int contentLength = d.getContentLength();
            bd.m15428a("update response content length is: " + contentLength);
            if (responseCode == 200 && contentLength > 0) {
                Closeable openFileOutput = context.openFileOutput(".remote.jar", 0);
                if (da.m15654a(d.getInputStream(), openFileOutput)) {
                    bd.m15428a("save remote jar success");
                }
                da.m15653a(openFileOutput);
            }
        } catch (Throwable e) {
            bd.m15432b(e);
            da.m15653a(null);
        } catch (Throwable th) {
            d.disconnect();
        }
        ax.f19407a = null;
        au.m15355a();
        if (!TextUtils.isEmpty(headerField)) {
            c3587l.mo2727a(context, headerField);
        }
        if (!TextUtils.isEmpty(headerField2)) {
            c3587l.mo2730b(context, headerField2);
        }
        d.disconnect();
        bd.m15428a("finish get config and download jar");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private java.lang.String m15387b(android.content.Context r7) {
        /*
        r6 = this;
        r0 = ".remote.jar";
        r0 = r7.getFileStreamPath(r0);
        r1 = "14";
        if (r0 == 0) goto L_0x010a;
    L_0x000c:
        r0 = r0.exists();
        if (r0 == 0) goto L_0x010a;
    L_0x0012:
        r0 = ".remote.jar";
        r0 = r7.getFileStreamPath(r0);
        if (r0 == 0) goto L_0x010a;
    L_0x001b:
        r0 = r0.getAbsolutePath();
        r0 = com.baidu.mobstat.ax.m15381b(r0);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "startDownload remote jar file version = ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.baidu.mobstat.bd.m15428a(r2);
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x010a;
    L_0x0040:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "dynamicVersion";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r0 = r0.toString();
        r2.<init>(r3, r0);
        r1.add(r2);
        r0 = new org.apache.http.message.BasicNameValuePair;
        r2 = "packageName";
        r3 = com.baidu.mobstat.de.m15705p(r7);
        r0.<init>(r2, r3);
        r1.add(r0);
        r0 = new org.apache.http.message.BasicNameValuePair;
        r2 = "appVersion";
        r3 = com.baidu.mobstat.de.m15693f(r7);
        r0.<init>(r2, r3);
        r1.add(r0);
        r0 = new org.apache.http.message.BasicNameValuePair;
        r2 = "cuid";
        r3 = com.baidu.mobstat.de.m15676a(r7);
        r0.<init>(r2, r3);
        r1.add(r0);
        r0 = new org.apache.http.message.BasicNameValuePair;
        r2 = "platform";
        r3 = "Android";
        r0.<init>(r2, r3);
        r1.add(r0);
        r0 = new org.apache.http.message.BasicNameValuePair;
        r2 = "m";
        r3 = android.os.Build.MODEL;
        r0.<init>(r2, r3);
        r1.add(r0);
        r0 = new org.apache.http.message.BasicNameValuePair;
        r2 = "s";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = android.os.Build.VERSION.SDK_INT;
        r3 = r3.append(r4);
        r4 = "";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r0.<init>(r2, r3);
        r1.add(r0);
        r0 = new org.apache.http.message.BasicNameValuePair;
        r2 = "o";
        r3 = android.os.Build.VERSION.RELEASE;
        r0.<init>(r2, r3);
        r1.add(r0);
        r0 = new org.apache.http.message.BasicNameValuePair;
        r2 = "i";
        r3 = "14";
        r0.<init>(r2, r3);
        r1.add(r0);
        r0 = "utf-8";
        r0 = org.apache.http.client.utils.URLEncodedUtils.format(r1, r0);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.baidu.mobstat.bb.f19432c;
        r1 = r1.append(r2);
        r2 = "?";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        return r0;
    L_0x010a:
        r0 = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.ay.b(android.content.Context):java.lang.String");
    }
}
