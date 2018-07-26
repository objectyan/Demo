package com.loopj.android.http;

import com.facebook.common.p141m.C2924g;
import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.p157l.C3062j;
import cz.msebera.android.httpclient.p157l.C3128b;
import cz.msebera.android.httpclient.p157l.C3134m;
import cz.msebera.android.httpclient.p162e.p169c.C3018e;
import cz.msebera.android.httpclient.p162e.p169c.C3019f;
import cz.msebera.android.httpclient.p162e.p169c.C3024j;
import cz.msebera.android.httpclient.p162e.p170e.C3028j;
import cz.msebera.android.httpclient.p173i.p175b.C3059s;
import cz.msebera.android.httpclient.p173i.p177c.p178a.C3085h;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MySSLSocketFactory extends C3028j {
    final SSLContext sslContext = SSLContext.getInstance("TLS");

    /* renamed from: com.loopj.android.http.MySSLSocketFactory$1 */
    class C60441 implements X509TrustManager {
        C60441() {
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public MySSLSocketFactory(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(truststore);
        X509TrustManager tm = new C60441();
        this.sslContext.init(null, new TrustManager[]{tm}, null);
    }

    public static KeyStore getKeystoreOfCA(InputStream cert) {
        CertificateException e1;
        KeyStore keyStore;
        Throwable th;
        InputStream caInput = null;
        Certificate ca = null;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            InputStream caInput2 = new BufferedInputStream(cert);
            try {
                ca = cf.generateCertificate(caInput2);
                if (caInput2 != null) {
                    try {
                        caInput2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        caInput = caInput2;
                    }
                }
                caInput = caInput2;
            } catch (CertificateException e2) {
                e1 = e2;
                caInput = caInput2;
                try {
                    e1.printStackTrace();
                    if (caInput != null) {
                        try {
                            caInput.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    keyStore = null;
                    keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    keyStore.load(null, null);
                    keyStore.setCertificateEntry("ca", ca);
                    return keyStore;
                } catch (Throwable th2) {
                    th = th2;
                    if (caInput != null) {
                        try {
                            caInput.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                caInput = caInput2;
                if (caInput != null) {
                    caInput.close();
                }
                throw th;
            }
        } catch (CertificateException e4) {
            e1 = e4;
            e1.printStackTrace();
            if (caInput != null) {
                caInput.close();
            }
            keyStore = null;
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);
            return keyStore;
        }
        keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);
            return keyStore;
        } catch (Exception e5) {
            e5.printStackTrace();
            return keyStore;
        }
    }

    public static KeyStore getKeystore() {
        KeyStore trustStore = null;
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            return trustStore;
        } catch (Throwable t) {
            t.printStackTrace();
            return trustStore;
        }
    }

    public static C3028j getFixedSocketFactory() {
        try {
            C3028j socketFactory = new MySSLSocketFactory(getKeystore());
            socketFactory.setHostnameVerifier(C3028j.ALLOW_ALL_HOSTNAME_VERIFIER);
            return socketFactory;
        } catch (Throwable t) {
            t.printStackTrace();
            return C3028j.getSocketFactory();
        }
    }

    public static C3059s getNewHttpClient(KeyStore keyStore) {
        try {
            C3028j sf = new MySSLSocketFactory(keyStore);
            C3024j registry = new C3024j();
            registry.a(new C3019f("http", C3018e.a(), 80));
            registry.a(new C3019f(C2924g.f12888b, sf, 443));
            C3062j params = new C3128b();
            C3134m.a(params, ac.f25260d);
            C3134m.b(params, "UTF-8");
            return new C3059s(new C3085h(params, registry), params);
        } catch (Exception e) {
            return new C3059s();
        }
    }

    public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
        return this.sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
    }

    public Socket createSocket() throws IOException {
        return this.sslContext.getSocketFactory().createSocket();
    }

    public void fixHttpsURLConnection() {
        HttpsURLConnection.setDefaultSSLSocketFactory(this.sslContext.getSocketFactory());
    }
}
