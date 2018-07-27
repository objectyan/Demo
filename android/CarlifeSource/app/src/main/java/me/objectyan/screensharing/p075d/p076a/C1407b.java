package com.baidu.carlife.p075d.p076a;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: HTTPSTrustManager */
/* renamed from: com.baidu.carlife.d.a.b */
public class C1407b implements X509TrustManager {
    /* renamed from: a */
    private static TrustManager[] f4124a;
    /* renamed from: b */
    private static final X509Certificate[] f4125b = new X509Certificate[0];
    /* renamed from: c */
    private static SSLSocketFactory f4126c;

    /* compiled from: HTTPSTrustManager */
    /* renamed from: com.baidu.carlife.d.a.b$1 */
    static class C14051 implements HostnameVerifier {
        C14051() {
        }

        public boolean verify(String arg0, SSLSession arg1) {
            return true;
        }
    }

    /* compiled from: HTTPSTrustManager */
    /* renamed from: com.baidu.carlife.d.a.b$2 */
    static class C14062 implements X509TrustManager {
        C14062() {
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
    }

    /* renamed from: a */
    public boolean m5190a(X509Certificate[] chain) {
        return true;
    }

    /* renamed from: b */
    public boolean m5191b(X509Certificate[] chain) {
        return true;
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f4125b;
    }

    /* renamed from: a */
    public static void m5188a() {
        HttpsURLConnection.setDefaultHostnameVerifier(new C14051());
        SSLContext context = null;
        if (f4124a == null) {
            f4124a = new TrustManager[]{new C1407b()};
        }
        try {
            context = SSLContext.getInstance("TLS");
            context.init(null, f4124a, new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        }
        f4126c = context.getSocketFactory();
        HttpsURLConnection.setDefaultSSLSocketFactory(f4126c);
    }

    /* renamed from: b */
    public static SSLSocketFactory m5189b() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new C14062()};
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
