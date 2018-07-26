package com.indooratlas.android.sdk._internal;

import com.baidu.mobstat.Config;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class ft {
    /* renamed from: a */
    public static final ft f23743a = new ft(new C5911a());
    /* renamed from: b */
    private final Map<String, Set<iq>> f23744b;

    /* renamed from: com.indooratlas.android.sdk._internal.ft$a */
    public static final class C5911a {
        /* renamed from: a */
        final Map<String, Set<iq>> f23742a = new LinkedHashMap();
    }

    private ft(C5911a c5911a) {
        this.f23744b = gy.m20787a(c5911a.f23742a);
    }

    /* renamed from: a */
    public final void m20573a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        Collection collection;
        Set set = null;
        Set set2 = (Set) this.f23744b.get(str);
        int indexOf = str.indexOf(46);
        if (indexOf != str.lastIndexOf(46)) {
            collection = (Set) this.f23744b.get("*." + str.substring(indexOf + 1));
        } else {
            collection = null;
        }
        if (!(set2 == null && collection == null)) {
            if (set2 != null && collection != null) {
                Set linkedHashSet = new LinkedHashSet();
                linkedHashSet.addAll(set2);
                linkedHashSet.addAll(collection);
                set = linkedHashSet;
            } else if (set2 != null) {
                set = set2;
            } else {
                Collection collection2 = collection;
            }
        }
        if (r3 != null) {
            int size = list.size();
            indexOf = 0;
            while (indexOf < size) {
                if (!r3.contains(m20571a((X509Certificate) list.get(indexOf)))) {
                    indexOf++;
                } else {
                    return;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            int size2 = list.size();
            for (indexOf = 0; indexOf < size2; indexOf++) {
                Certificate certificate = (X509Certificate) list.get(indexOf);
                stringBuilder.append("\n    ").append(m20572a(certificate)).append(": ").append(certificate.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ").append(str).append(Config.TRACE_TODAY_VISIT_SPLIT);
            for (iq iqVar : r3) {
                stringBuilder.append("\n    sha1/").append(im.a(iqVar.f24395c));
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static String m20572a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + im.a(m20571a((X509Certificate) certificate).f24395c);
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    private static iq m20571a(X509Certificate x509Certificate) {
        return gy.m20782a(iq.a(x509Certificate.getPublicKey().getEncoded()));
    }
}
