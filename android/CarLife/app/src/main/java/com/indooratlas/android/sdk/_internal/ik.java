package com.indooratlas.android.sdk._internal;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;

public final class ik implements HostnameVerifier {
    /* renamed from: a */
    public static final ik f24375a = new ik();

    private ik() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean verify(java.lang.String r12, javax.net.ssl.SSLSession r13) {
        /*
        r11 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r13.getPeerCertificates();	 Catch:{ SSLException -> 0x00db }
        r1 = 0;
        r0 = r0[r1];	 Catch:{ SSLException -> 0x00db }
        r0 = (java.security.cert.X509Certificate) r0;	 Catch:{ SSLException -> 0x00db }
        r1 = com.indooratlas.android.sdk._internal.gy.b(r12);	 Catch:{ SSLException -> 0x00db }
        if (r1 == 0) goto L_0x0032;
    L_0x0012:
        r1 = 7;
        r4 = m21123a(r0, r1);	 Catch:{ SSLException -> 0x00db }
        r5 = r4.size();	 Catch:{ SSLException -> 0x00db }
        r1 = r3;
    L_0x001c:
        if (r1 >= r5) goto L_0x0030;
    L_0x001e:
        r0 = r4.get(r1);	 Catch:{ SSLException -> 0x00db }
        r0 = (java.lang.String) r0;	 Catch:{ SSLException -> 0x00db }
        r0 = r12.equalsIgnoreCase(r0);	 Catch:{ SSLException -> 0x00db }
        if (r0 == 0) goto L_0x002c;
    L_0x002a:
        r0 = r2;
    L_0x002b:
        return r0;
    L_0x002c:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x001c;
    L_0x0030:
        r0 = r3;
        goto L_0x002b;
    L_0x0032:
        r1 = java.util.Locale.US;	 Catch:{ SSLException -> 0x00db }
        r6 = r12.toLowerCase(r1);	 Catch:{ SSLException -> 0x00db }
        r1 = 2;
        r7 = m21123a(r0, r1);	 Catch:{ SSLException -> 0x00db }
        r8 = r7.size();	 Catch:{ SSLException -> 0x00db }
        r5 = r3;
        r1 = r3;
    L_0x0043:
        if (r5 >= r8) goto L_0x0058;
    L_0x0045:
        r1 = r7.get(r5);	 Catch:{ SSLException -> 0x00db }
        r1 = (java.lang.String) r1;	 Catch:{ SSLException -> 0x00db }
        r1 = m21124a(r6, r1);	 Catch:{ SSLException -> 0x00db }
        if (r1 == 0) goto L_0x0053;
    L_0x0051:
        r0 = r2;
        goto L_0x002b;
    L_0x0053:
        r1 = r5 + 1;
        r5 = r1;
        r1 = r2;
        goto L_0x0043;
    L_0x0058:
        if (r1 != 0) goto L_0x01a4;
    L_0x005a:
        r0 = r0.getSubjectX500Principal();	 Catch:{ SSLException -> 0x00db }
        r2 = new com.indooratlas.android.sdk._internal.ij;	 Catch:{ SSLException -> 0x00db }
        r2.<init>(r0);	 Catch:{ SSLException -> 0x00db }
        r5 = "cn";
        r0 = 0;
        r2.f24370c = r0;	 Catch:{ SSLException -> 0x00db }
        r0 = 0;
        r2.f24371d = r0;	 Catch:{ SSLException -> 0x00db }
        r0 = 0;
        r2.f24372e = r0;	 Catch:{ SSLException -> 0x00db }
        r0 = 0;
        r2.f24373f = r0;	 Catch:{ SSLException -> 0x00db }
        r0 = r2.f24368a;	 Catch:{ SSLException -> 0x00db }
        r0 = r0.toCharArray();	 Catch:{ SSLException -> 0x00db }
        r2.f24374g = r0;	 Catch:{ SSLException -> 0x00db }
        r0 = r2.m21118a();	 Catch:{ SSLException -> 0x00db }
        if (r0 != 0) goto L_0x01a7;
    L_0x0080:
        r0 = r4;
    L_0x0081:
        if (r0 == 0) goto L_0x01a4;
    L_0x0083:
        r0 = m21124a(r6, r0);	 Catch:{ SSLException -> 0x00db }
        goto L_0x002b;
    L_0x0088:
        r1 = r0;
    L_0x0089:
        r0 = "";
        r7 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r8 = r2.f24369b;	 Catch:{ SSLException -> 0x00db }
        if (r7 != r8) goto L_0x0094;
    L_0x0092:
        r0 = r4;
        goto L_0x0081;
    L_0x0094:
        r7 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r8 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r7 = r7[r8];	 Catch:{ SSLException -> 0x00db }
        switch(r7) {
            case 34: goto L_0x00af;
            case 35: goto L_0x0144;
            case 43: goto L_0x00a1;
            case 44: goto L_0x00a1;
            case 59: goto L_0x00a1;
            default: goto L_0x009d;
        };	 Catch:{ SSLException -> 0x00db }
    L_0x009d:
        r0 = r2.m21120c();	 Catch:{ SSLException -> 0x00db }
    L_0x00a1:
        r1 = r5.equalsIgnoreCase(r1);	 Catch:{ SSLException -> 0x00db }
        if (r1 != 0) goto L_0x0081;
    L_0x00a7:
        r0 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r1 = r2.f24369b;	 Catch:{ SSLException -> 0x00db }
        if (r0 < r1) goto L_0x014a;
    L_0x00ad:
        r0 = r4;
        goto L_0x0081;
    L_0x00af:
        r0 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0 + 1;
        r2.f24370c = r0;	 Catch:{ SSLException -> 0x00db }
        r0 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r2.f24371d = r0;	 Catch:{ SSLException -> 0x00db }
        r0 = r2.f24371d;	 Catch:{ SSLException -> 0x00db }
        r2.f24372e = r0;	 Catch:{ SSLException -> 0x00db }
    L_0x00bd:
        r0 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r7 = r2.f24369b;	 Catch:{ SSLException -> 0x00db }
        if (r0 != r7) goto L_0x00df;
    L_0x00c3:
        r0 = new java.lang.IllegalStateException;	 Catch:{ SSLException -> 0x00db }
        r1 = new java.lang.StringBuilder;	 Catch:{ SSLException -> 0x00db }
        r4 = "Unexpected end of DN: ";
        r1.<init>(r4);	 Catch:{ SSLException -> 0x00db }
        r2 = r2.f24368a;	 Catch:{ SSLException -> 0x00db }
        r1 = r1.append(r2);	 Catch:{ SSLException -> 0x00db }
        r1 = r1.toString();	 Catch:{ SSLException -> 0x00db }
        r0.<init>(r1);	 Catch:{ SSLException -> 0x00db }
        throw r0;	 Catch:{ SSLException -> 0x00db }
    L_0x00db:
        r0 = move-exception;
        r0 = r3;
        goto L_0x002b;
    L_0x00df:
        r0 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r7 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0[r7];	 Catch:{ SSLException -> 0x00db }
        r7 = 34;
        if (r0 != r7) goto L_0x0106;
    L_0x00e9:
        r0 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0 + 1;
        r2.f24370c = r0;	 Catch:{ SSLException -> 0x00db }
    L_0x00ef:
        r0 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r7 = r2.f24369b;	 Catch:{ SSLException -> 0x00db }
        if (r0 >= r7) goto L_0x0134;
    L_0x00f5:
        r0 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r7 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0[r7];	 Catch:{ SSLException -> 0x00db }
        r7 = 32;
        if (r0 != r7) goto L_0x0134;
    L_0x00ff:
        r0 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0 + 1;
        r2.f24370c = r0;	 Catch:{ SSLException -> 0x00db }
        goto L_0x00ef;
    L_0x0106:
        r0 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r7 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0[r7];	 Catch:{ SSLException -> 0x00db }
        r7 = 92;
        if (r0 != r7) goto L_0x0127;
    L_0x0110:
        r0 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r7 = r2.f24372e;	 Catch:{ SSLException -> 0x00db }
        r8 = r2.m21121d();	 Catch:{ SSLException -> 0x00db }
        r0[r7] = r8;	 Catch:{ SSLException -> 0x00db }
    L_0x011a:
        r0 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0 + 1;
        r2.f24370c = r0;	 Catch:{ SSLException -> 0x00db }
        r0 = r2.f24372e;	 Catch:{ SSLException -> 0x00db }
        r0 = r0 + 1;
        r2.f24372e = r0;	 Catch:{ SSLException -> 0x00db }
        goto L_0x00bd;
    L_0x0127:
        r0 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r7 = r2.f24372e;	 Catch:{ SSLException -> 0x00db }
        r8 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r9 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r8 = r8[r9];	 Catch:{ SSLException -> 0x00db }
        r0[r7] = r8;	 Catch:{ SSLException -> 0x00db }
        goto L_0x011a;
    L_0x0134:
        r0 = new java.lang.String;	 Catch:{ SSLException -> 0x00db }
        r7 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r8 = r2.f24371d;	 Catch:{ SSLException -> 0x00db }
        r9 = r2.f24372e;	 Catch:{ SSLException -> 0x00db }
        r10 = r2.f24371d;	 Catch:{ SSLException -> 0x00db }
        r9 = r9 - r10;
        r0.<init>(r7, r8, r9);	 Catch:{ SSLException -> 0x00db }
        goto L_0x00a1;
    L_0x0144:
        r0 = r2.m21119b();	 Catch:{ SSLException -> 0x00db }
        goto L_0x00a1;
    L_0x014a:
        r0 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r1 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0[r1];	 Catch:{ SSLException -> 0x00db }
        r1 = 44;
        if (r0 == r1) goto L_0x0180;
    L_0x0154:
        r0 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r1 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0[r1];	 Catch:{ SSLException -> 0x00db }
        r1 = 59;
        if (r0 == r1) goto L_0x0180;
    L_0x015e:
        r0 = r2.f24374g;	 Catch:{ SSLException -> 0x00db }
        r1 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0[r1];	 Catch:{ SSLException -> 0x00db }
        r1 = 43;
        if (r0 == r1) goto L_0x0180;
    L_0x0168:
        r0 = new java.lang.IllegalStateException;	 Catch:{ SSLException -> 0x00db }
        r1 = new java.lang.StringBuilder;	 Catch:{ SSLException -> 0x00db }
        r4 = "Malformed DN: ";
        r1.<init>(r4);	 Catch:{ SSLException -> 0x00db }
        r2 = r2.f24368a;	 Catch:{ SSLException -> 0x00db }
        r1 = r1.append(r2);	 Catch:{ SSLException -> 0x00db }
        r1 = r1.toString();	 Catch:{ SSLException -> 0x00db }
        r0.<init>(r1);	 Catch:{ SSLException -> 0x00db }
        throw r0;	 Catch:{ SSLException -> 0x00db }
    L_0x0180:
        r0 = r2.f24370c;	 Catch:{ SSLException -> 0x00db }
        r0 = r0 + 1;
        r2.f24370c = r0;	 Catch:{ SSLException -> 0x00db }
        r0 = r2.m21118a();	 Catch:{ SSLException -> 0x00db }
        if (r0 != 0) goto L_0x0088;
    L_0x018c:
        r0 = new java.lang.IllegalStateException;	 Catch:{ SSLException -> 0x00db }
        r1 = new java.lang.StringBuilder;	 Catch:{ SSLException -> 0x00db }
        r4 = "Malformed DN: ";
        r1.<init>(r4);	 Catch:{ SSLException -> 0x00db }
        r2 = r2.f24368a;	 Catch:{ SSLException -> 0x00db }
        r1 = r1.append(r2);	 Catch:{ SSLException -> 0x00db }
        r1 = r1.toString();	 Catch:{ SSLException -> 0x00db }
        r0.<init>(r1);	 Catch:{ SSLException -> 0x00db }
        throw r0;	 Catch:{ SSLException -> 0x00db }
    L_0x01a4:
        r0 = r3;
        goto L_0x002b;
    L_0x01a7:
        r1 = r0;
        goto L_0x0089;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.ik.verify(java.lang.String, javax.net.ssl.SSLSession):boolean");
    }

    /* renamed from: a */
    public static List<String> m21122a(X509Certificate x509Certificate) {
        Collection a = m21123a(x509Certificate, 7);
        Collection a2 = m21123a(x509Certificate, 2);
        List<String> arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m21123a(X509Certificate x509Certificate, int i) {
        List<String> arrayList = new ArrayList();
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2) {
                    Integer num = (Integer) list.get(0);
                    if (num != null && num.intValue() == i) {
                        String str = (String) list.get(1);
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    private static boolean m21124a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + '.';
        }
        String toLowerCase = str2.toLowerCase(Locale.US);
        if (!toLowerCase.contains("*")) {
            return str.equals(toLowerCase);
        }
        if (!toLowerCase.startsWith("*.") || toLowerCase.indexOf(42, 1) != -1 || str.length() < toLowerCase.length() || "*.".equals(toLowerCase)) {
            return false;
        }
        toLowerCase = toLowerCase.substring(1);
        if (!str.endsWith(toLowerCase)) {
            return false;
        }
        int length = str.length() - toLowerCase.length();
        if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
            return true;
        }
        return false;
    }
}
