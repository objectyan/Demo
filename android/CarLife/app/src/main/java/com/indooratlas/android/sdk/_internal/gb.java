package com.indooratlas.android.sdk._internal;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface gb {
    /* renamed from: a */
    public static final gb f23839a = new C59161();

    /* renamed from: com.indooratlas.android.sdk._internal.gb$1 */
    static class C59161 implements gb {
        C59161() {
        }

        /* renamed from: a */
        public final List<InetAddress> mo4681a(String str) throws UnknownHostException {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    }

    /* renamed from: a */
    List<InetAddress> mo4681a(String str) throws UnknownHostException;
}
