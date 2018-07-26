package com.baidu.mapframework.commonlib.http;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class DNSProxyCompatX509HostnameVerifier extends X509HostnameVerifierWrapper {
    /* renamed from: a */
    private DNSProxy f19047a;

    public DNSProxyCompatX509HostnameVerifier(X509HostnameVerifier verifier) {
        super(verifier);
    }

    public void setDNSProxy(DNSProxy dnsProxy) {
        this.f19047a = dnsProxy;
    }

    /* renamed from: a */
    private Set<String> m15100a(String ip) {
        return this.f19047a.getDomains(ip);
    }

    public boolean verify(String host, SSLSession session) {
        if (this.f19047a != null) {
            Set<String> hostNames = m15100a(host);
            if (hostNames != null && hostNames.size() > 0) {
                for (String name : hostNames) {
                    if (name != null && !name.equals("") && !super.verify(name, session)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return super.verify(host, session);
    }

    public void verify(String host, SSLSocket ssl) throws IOException {
        if (this.f19047a != null) {
            Set<String> hostNames = m15100a(host);
            if (hostNames != null && hostNames.size() > 0) {
                for (String name : hostNames) {
                    if (!(name == null || name.equals(""))) {
                        super.verify(name, ssl);
                    }
                }
                return;
            }
        }
        super.verify(host, ssl);
    }

    public void verify(String host, X509Certificate cert) throws SSLException {
        if (this.f19047a != null) {
            Set<String> hostNames = m15100a(host);
            if (hostNames != null && hostNames.size() > 0) {
                for (String name : hostNames) {
                    if (!(name == null || name.equals(""))) {
                        super.verify(name, cert);
                    }
                }
                return;
            }
        }
        super.verify(host, cert);
    }

    public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
        if (this.f19047a != null) {
            Set<String> hostNames = m15100a(host);
            if (hostNames != null && hostNames.size() > 0) {
                for (String name : hostNames) {
                    if (!(name == null || name.equals(""))) {
                        super.verify(name, cns, subjectAlts);
                    }
                }
                return;
            }
        }
        super.verify(host, cns, subjectAlts);
    }
}
