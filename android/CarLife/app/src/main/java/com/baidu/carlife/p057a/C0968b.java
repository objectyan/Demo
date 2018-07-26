package com.baidu.carlife.p057a;

import android.util.Base64;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;

/* compiled from: PublicKeyManager */
/* renamed from: com.baidu.carlife.a.b */
public class C0968b {
    /* renamed from: a */
    private static final String f2436a = C0968b.class.getSimpleName();
    /* renamed from: b */
    private static C0968b f2437b = null;
    /* renamed from: c */
    private static final String f2438c = "public.der";
    /* renamed from: d */
    private static final String f2439d = (C1253f.jm + "/" + f2438c);
    /* renamed from: e */
    private static final String f2440e = "123456";
    /* renamed from: f */
    private static final String f2441f = "X.509";
    /* renamed from: g */
    private static final String f2442g = "RSA/ECB/PKCS1Padding";
    /* renamed from: h */
    private PublicKey f2443h;

    /* renamed from: a */
    public static C0968b m3165a() {
        if (f2437b == null) {
            f2437b = new C0968b();
        }
        return f2437b;
    }

    private C0968b() {
        C1251e.m4358a().m4391a(f2438c, f2439d);
        try {
            this.f2443h = m3167a(m3168a(f2439d, f2441f));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public String m3169a(String encryptedContent) {
        return m3166a(encryptedContent, this.f2443h);
    }

    /* renamed from: a */
    private X509Certificate m3168a(String path, String certType) throws IOException {
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        try {
            CertificateFactory factory = CertificateFactory.getInstance(certType);
            InputStream inputStream2 = new FileInputStream(path);
            try {
                X509Certificate x509Certificate = (X509Certificate) factory.generateCertificate(inputStream2);
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                inputStream = inputStream2;
                return x509Certificate;
            } catch (Exception e2) {
                e = e2;
                inputStream = inputStream2;
                try {
                    e.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStream2;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        }
    }

    /* renamed from: a */
    private PublicKey m3167a(Certificate certificate) {
        return certificate.getPublicKey();
    }

    /* renamed from: a */
    private String m3166a(String encodedText, PublicKey publicKey) {
        try {
            byte[] encodedContent = Base64.decode(encodedText, 2);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, publicKey);
            return new String(cipher.doFinal(encodedContent), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
