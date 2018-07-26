package com.baidu.ufosdk;

import com.baidu.navi.util.ShareTools;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5211d;
import cz.msebera.android.httpclient.C6591q;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: UfoSDK */
/* renamed from: com.baidu.ufosdk.c */
final class C5175c implements Runnable {
    C5175c() {
    }

    public final void run() {
        Exception e;
        Throwable th;
        if (new C5211d(UfoSDK.mApplication).m17747e()) {
            String format = String.format(new StringBuilder(String.valueOf(C5167a.ak + "?m=hide&a=behavior")).append("&editFeedbackView=%d&editFeedbackWord=%d&editFeedbackPicture=%d&myFeedback=%d&appid=%s").toString(), new Object[]{Integer.valueOf(r1.m17739a()), Integer.valueOf(r1.m17741b()), Integer.valueOf(r1.m17743c()), Integer.valueOf(r1.m17745d()), UfoSDK.appid});
            C5210c.m17734b("getURL is " + format);
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(format).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    httpURLConnection2.setConnectTimeout(3000);
                    httpURLConnection2.setReadTimeout(3000);
                    httpURLConnection2.setRequestProperty(C6591q.f26545b, "utf-8");
                    httpURLConnection2.setRequestProperty(ShareTools.BUNDLE_KEY_CONTENTTYPE, "utf-8");
                    if (httpURLConnection2.getResponseCode() == 200) {
                        C5210c.m17732a("^^ httpURLConnGet success! ^^");
                    }
                    httpURLConnection2.disconnect();
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    httpURLConnection = httpURLConnection2;
                    e2 = exception;
                    try {
                        e2.printStackTrace();
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e32) {
                                e32.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e22 = e4;
                e22.printStackTrace();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }
}
