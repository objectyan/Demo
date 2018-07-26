package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: com.indooratlas.android.sdk._internal.if */
public final class C5979if {
    /* renamed from: a */
    public final gi f24344a;
    /* renamed from: b */
    public final int f24345b;
    /* renamed from: c */
    public final String f24346c;

    private C5979if(gi giVar, int i, String str) {
        this.f24344a = giVar;
        this.f24345b = i;
        this.f24346c = str;
    }

    /* renamed from: a */
    public static C5979if m21100a(String str) throws IOException {
        gi giVar;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - 48;
            if (charAt == 0) {
                giVar = gi.HTTP_1_0;
            } else if (charAt == 1) {
                giVar = gi.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            giVar = gi.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        if (str.length() < i + 3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            String str2;
            int parseInt = Integer.parseInt(str.substring(i, i + 3));
            String str3 = "";
            if (str.length() <= i + 3) {
                str2 = str3;
            } else if (str.charAt(i + 3) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i + 4);
            }
            return new C5979if(giVar, parseInt, str2);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f24344a == gi.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        stringBuilder.append(' ').append(this.f24345b);
        if (this.f24346c != null) {
            stringBuilder.append(' ').append(this.f24346c);
        }
        return stringBuilder.toString();
    }
}
