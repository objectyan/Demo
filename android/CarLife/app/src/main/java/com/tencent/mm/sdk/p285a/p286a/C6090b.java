package com.tencent.mm.sdk.p285a.p286a;

import com.tencent.mm.p284a.C6086a;

/* renamed from: com.tencent.mm.sdk.a.a.b */
public final class C6090b {
    /* renamed from: a */
    public static byte[] m21673a(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return C6086a.m21671a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
