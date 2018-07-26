package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public enum gi {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    /* renamed from: e */
    private final String f23933e;

    private gi(String str) {
        this.f23933e = str;
    }

    /* renamed from: a */
    public static gi m20684a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f23933e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f23933e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f23933e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f23933e)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public final String toString() {
        return this.f23933e;
    }
}
