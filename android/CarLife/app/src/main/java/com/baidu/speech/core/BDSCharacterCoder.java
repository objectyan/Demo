package com.baidu.speech.core;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

public class BDSCharacterCoder {
    private static String[] encodingNames = new String[]{"UTF-8", "GB18030"};

    public static int convertCharacterEncoding(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        if (i >= encodingNames.length || i2 >= encodingNames.length) {
            Log.e("BDSCharacterCoder", "requested source or target encoding is invalid, min: 0, max: " + encodingNames.length + " requested source: " + i + " requested target: " + i2);
            return 0;
        }
        Charset forName = Charset.forName(encodingNames[i]);
        Charset forName2 = Charset.forName(encodingNames[i2]);
        CharsetDecoder newDecoder = forName.newDecoder();
        CharsetEncoder newEncoder = forName2.newEncoder();
        char[] cArr = new char[bArr.length];
        CharBuffer wrap = CharBuffer.wrap(cArr);
        CoderResult decode = newDecoder.decode(ByteBuffer.wrap(bArr), wrap, true);
        CharBuffer wrap2 = CharBuffer.wrap(cArr, 0, wrap.position());
        boolean isError = decode.isError();
        ByteBuffer wrap3 = ByteBuffer.wrap(bArr2);
        CoderResult encode = newEncoder.encode(wrap2, wrap3, true);
        if (isError || encode.isError()) {
            i3 = 1;
        }
        int position = wrap3.position();
        return i3 != 0 ? position * -1 : position;
    }
}
