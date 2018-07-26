package com.baidu.navisdk.util.http;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class NavX509HostnameVerifierWrapper implements X509HostnameVerifier {
    private final X509HostnameVerifier verifier;

    public NavX509HostnameVerifierWrapper(X509HostnameVerifier verifier) {
        this.verifier = verifier;
    }

    public boolean verify(String host, SSLSession session) {
        return this.verifier != null && this.verifier.verify(host, session);
    }

    public void verify(String host, SSLSocket ssl) throws IOException {
        if (this.verifier != null) {
            this.verifier.verify(host, ssl);
        }
    }

    public void verify(String host, X509Certificate cert) throws SSLException {
        if (this.verifier != null) {
            this.verifier.verify(host, cert);
        }
    }

    public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
        if (this.verifier != null) {
            this.verifier.verify(host, cns, subjectAlts);
        }
    }
}
