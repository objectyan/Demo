package com.indooratlas.android.sdk._internal;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public final class kp {
    /* renamed from: a */
    public static CodingErrorAction f24566a = CodingErrorAction.REPORT;

    /* renamed from: a */
    public static byte[] m21499a(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public static byte[] m21500b(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static String m21498a(byte[] bArr, int i) {
        try {
            return new String(bArr, 0, i, "ASCII");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static String m21497a(ByteBuffer byteBuffer) throws ju {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(f24566a);
        newDecoder.onUnmappableCharacter(f24566a);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (Throwable e) {
            throw new ju(1007, e);
        }
    }
}
