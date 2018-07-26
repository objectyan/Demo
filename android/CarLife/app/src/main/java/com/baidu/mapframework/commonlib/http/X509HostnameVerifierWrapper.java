package com.baidu.mapframework.commonlib.http;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class X509HostnameVerifierWrapper implements X509HostnameVerifier {
    /* renamed from: a */
    private final X509HostnameVerifier f19046a;

    public X509HostnameVerifierWrapper(X509HostnameVerifier verifier) {
        this.f19046a = verifier;
    }

    public boolean verify(String host, SSLSession session) {
        return this.f19046a != null && this.f19046a.verify(host, session);
    }

    public void verify(String host, SSLSocket ssl) throws IOException {
        if (this.f19046a != null) {
            this.f19046a.verify(host, ssl);
        }
    }

    public void verify(String host, X509Certificate cert) throws SSLException {
        if (this.f19046a != null) {
            this.f19046a.verify(host, cert);
        }
    }

    public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
        if (this.f19046a != null) {
            this.f19046a.verify(host, cns, subjectAlts);
        }
    }
}
