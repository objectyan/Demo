package com.baidu.mapframework.nirvana.runtime.http;

import android.support.annotation.Keep;
import com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;

@Keep
public class URLEncodeUtils {
    static final String NativeURLEncodeUtilsClass = "com.baidu.platform.comapi.util.URLEncodeUtils";

    public static String urlEncode(UrlEncodeType type, String value) {
        if (type == null || type.equals(UrlEncodeType.NONE)) {
            return value;
        }
        if (type.equals(UrlEncodeType.JAVA)) {
            try {
                return URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return value;
            }
        } else if (!type.equals(UrlEncodeType.ENGINE)) {
            return value;
        } else {
            Object retVal = Utils.reflectionInvokeStaticMethod(NativeURLEncodeUtilsClass, "urlEncode", new Class[]{String.class}, new Object[]{value});
            if (retVal != null) {
                return (String) retVal;
            }
            return value;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String signString(java.util.HashMap<java.lang.String, java.lang.String> r18, com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType r19) {
        /*
        r11 = com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType.MAP_PHPUI;
        r0 = r19;
        r11 = r0.equals(r11);
        if (r11 == 0) goto L_0x0081;
    L_0x000a:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        if (r18 == 0) goto L_0x0052;
    L_0x0011:
        r11 = r18.entrySet();
        r12 = r11.iterator();
    L_0x0019:
        r11 = r12.hasNext();
        if (r11 == 0) goto L_0x0052;
    L_0x001f:
        r7 = r12.next();
        r7 = (java.util.Map.Entry) r7;
        r11 = r6.length();
        if (r11 <= 0) goto L_0x0031;
    L_0x002b:
        r11 = "&";
        r6.append(r11);
    L_0x0031:
        r11 = r7.getKey();
        r11 = (java.lang.String) r11;
        r11 = r6.append(r11);
        r13 = "=";
        r13 = r11.append(r13);
        r14 = com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType.ENGINE;
        r11 = r7.getValue();
        r11 = (java.lang.String) r11;
        r11 = urlEncode(r14, r11);
        r13.append(r11);
        goto L_0x0019;
    L_0x0052:
        r11 = "com.baidu.platform.comapi.util.URLEncodeUtils";
        r12 = "generateSign";
        r13 = 2;
        r13 = new java.lang.Class[r13];
        r14 = 0;
        r15 = java.lang.Integer.TYPE;
        r13[r14] = r15;
        r14 = 1;
        r15 = java.lang.String.class;
        r13[r14] = r15;
        r14 = 2;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r16 = 1;
        r16 = java.lang.Integer.valueOf(r16);
        r14[r15] = r16;
        r15 = 1;
        r16 = r6.toString();
        r14[r15] = r16;
        r8 = com.baidu.mapframework.nirvana.runtime.http.Utils.reflectionInvokeStaticMethod(r11, r12, r13, r14);
        if (r8 == 0) goto L_0x0139;
    L_0x007e:
        r8 = (java.lang.String) r8;
    L_0x0080:
        return r8;
    L_0x0081:
        r11 = com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType.POI_LIKE;
        r0 = r19;
        r11 = r0.equals(r11);
        if (r11 != 0) goto L_0x0095;
    L_0x008b:
        r11 = com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType.FILE_UPLOAD;
        r0 = r19;
        r11 = r0.equals(r11);
        if (r11 == 0) goto L_0x0139;
    L_0x0095:
        r11 = r18.keySet();
        r3 = r11.iterator();
        r1 = new java.util.ArrayList;
        r1.<init>();
    L_0x00a2:
        r11 = r3.hasNext();
        if (r11 == 0) goto L_0x00b0;
    L_0x00a8:
        r11 = r3.next();
        r1.add(r11);
        goto L_0x00a2;
    L_0x00b0:
        java.util.Collections.sort(r1);
        r9 = new java.lang.StringBuffer;
        r9.<init>();
        r2 = 0;
    L_0x00b9:
        r11 = r1.size();
        if (r2 >= r11) goto L_0x00f0;
    L_0x00bf:
        r5 = r1.get(r2);
        r5 = (java.lang.String) r5;
        r9.append(r5);
        r11 = "=";
        r9.append(r11);
        r12 = com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType.JAVA;
        r0 = r18;
        r11 = r0.get(r5);
        r11 = (java.lang.String) r11;
        r4 = urlEncode(r12, r11);
        r9.append(r4);
        r11 = r2 + 1;
        r12 = r1.size();
        if (r11 >= r12) goto L_0x00ed;
    L_0x00e7:
        r11 = "&";
        r9.append(r11);
    L_0x00ed:
        r2 = r2 + 1;
        goto L_0x00b9;
    L_0x00f0:
        r10 = "";
        r11 = com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType.POI_LIKE;
        r0 = r19;
        r11 = r0.equals(r11);
        if (r11 == 0) goto L_0x0135;
    L_0x00fd:
        r10 = "99754106633f94d350db34d548d6091a";
    L_0x0100:
        r11 = "com.baidu.platform.comapi.util.URLEncodeUtils";
        r12 = "getMD5String";
        r13 = 1;
        r13 = new java.lang.Class[r13];
        r14 = 0;
        r15 = java.lang.String.class;
        r13[r14] = r15;
        r14 = 1;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r16 = new java.lang.StringBuilder;
        r16.<init>();
        r17 = r9.toString();
        r16 = r16.append(r17);
        r0 = r16;
        r16 = r0.append(r10);
        r16 = r16.toString();
        r14[r15] = r16;
        r8 = com.baidu.mapframework.nirvana.runtime.http.Utils.reflectionInvokeStaticMethod(r11, r12, r13, r14);
        if (r8 == 0) goto L_0x0139;
    L_0x0131:
        r8 = (java.lang.String) r8;
        goto L_0x0080;
    L_0x0135:
        r10 = "43df48117350b904a6b1d4183e5611c7";
        goto L_0x0100;
    L_0x0139:
        r8 = "";
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapframework.nirvana.runtime.http.URLEncodeUtils.signString(java.util.HashMap, com.baidu.mapframework.nirvana.annotation.SignToken$SignTokenType):java.lang.String");
    }

    public static String getUrlQueryString(HashMap<String, String> urlParams, UrlEncodeType urlEncodeType) {
        StringBuilder newUrl = new StringBuilder();
        if (urlParams != null) {
            for (Entry<String, String> pair : urlParams.entrySet()) {
                if (newUrl.length() > 0) {
                    newUrl.append("&");
                }
                newUrl.append((String) pair.getKey()).append("=").append(urlEncode(urlEncodeType, (String) pair.getValue()));
            }
        }
        return newUrl.toString();
    }
}
