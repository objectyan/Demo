package com.baidu.navisdk.util.http;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class NavDNSProxyCompatX509HostnameVerifier extends NavX509HostnameVerifierWrapper {
    public NavDNSProxyCompatX509HostnameVerifier(X509HostnameVerifier verifier) {
        super(verifier);
    }

    public boolean verify(String host, SSLSession session) {
        Set<String> hostNames = HttpRequestManager.getInstance().getDomains(host);
        if (hostNames == null || hostNames.size() <= 0) {
            return super.verify(host, session);
        }
        for (String name : hostNames) {
            if (name != null && !name.equals("") && !super.verify(name, session)) {
                return false;
            }
        }
        return true;
    }

    public void verify(String host, SSLSocket ssl) throws IOException {
        Set<String> hostNames = HttpRequestManager.getInstance().getDomains(host);
        if (hostNames == null || hostNames.size() <= 0) {
            super.verify(host, ssl);
            return;
        }
        for (String name : hostNames) {
            if (!(name == null || name.equals(""))) {
                super.verify(name, ssl);
            }
        }
    }

    public void verify(String host, X509Certificate cert) throws SSLException {
        Set<String> hostNames = HttpRequestManager.getInstance().getDomains(host);
        if (hostNames == null || hostNames.size() <= 0) {
            super.verify(host, cert);
            return;
        }
        for (String name : hostNames) {
            if (!(name == null || name.equals(""))) {
                super.verify(name, cert);
            }
        }
    }

    public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
        Set<String> hostNames = HttpRequestManager.getInstance().getDomains(host);
        if (hostNames == null || hostNames.size() <= 0) {
            super.verify(host, cns, subjectAlts);
            return;
        }
        for (String name : hostNames) {
            if (!(name == null || name.equals(""))) {
                super.verify(name, cns, subjectAlts);
            }
        }
    }
}
