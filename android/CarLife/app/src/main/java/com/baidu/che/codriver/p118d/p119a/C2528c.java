package com.baidu.che.codriver.p118d.p119a;

import com.baidu.carlife.core.C1260i;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: RequestParamSigner */
/* renamed from: com.baidu.che.codriver.d.a.c */
public final class C2528c {
    /* renamed from: a */
    private static final char[] f8268a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* compiled from: RequestParamSigner */
    /* renamed from: com.baidu.che.codriver.d.a.c$1 */
    static class C25261 implements Comparator<C2527a> {
        C25261() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9585a((C2527a) obj, (C2527a) obj2);
        }

        /* renamed from: a */
        public int m9585a(C2527a lhs, C2527a rhs) {
            return lhs.f8266a.compareTo(rhs.f8266a);
        }
    }

    /* compiled from: RequestParamSigner */
    /* renamed from: com.baidu.che.codriver.d.a.c$a */
    private static class C2527a {
        /* renamed from: a */
        String f8266a;
        /* renamed from: b */
        String f8267b;

        C2527a(String key, String value) {
            this.f8266a = key;
            this.f8267b = value;
        }

        public String toString() {
            return this.f8266a + "=" + this.f8267b;
        }
    }

    /* renamed from: a */
    public static String m9587a(Map<String, String> params, String signPrefix, String signPostfix) {
        List<C2527a> keyValuePairList = C2528c.m9589a((Map) params);
        C2528c.m9590a((List) keyValuePairList);
        StringBuffer stringBuffer = new StringBuffer();
        for (C2527a keyValuePair : keyValuePairList) {
            stringBuffer.append(keyValuePair.toString());
        }
        C1260i.m4435b(C1981b.f6367g, "str for signed: " + stringBuffer.toString());
        C1260i.m4435b(C1981b.f6367g, "key_sign: prefix=" + signPrefix + "; suffix=" + signPostfix);
        return C2528c.m9586a(signPrefix + stringBuffer.toString() + signPostfix);
    }

    /* renamed from: a */
    private static List<C2527a> m9589a(Map<String, String> params) {
        List<C2527a> keyValuePairList = new ArrayList();
        try {
            for (String key : params.keySet()) {
                keyValuePairList.add(new C2527a(key, URLEncoder.encode((String) params.get(key), "UTF-8")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValuePairList;
    }

    /* renamed from: a */
    private static void m9590a(List<C2527a> keyValuePairList) {
        Collections.sort(keyValuePairList, new C25261());
    }

    /* renamed from: a */
    public static String m9586a(String str) {
        String md5Str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            md5Str = C2528c.m9588a(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Str.toLowerCase();
    }

    /* renamed from: a */
    public static String m9588a(byte[] bytes) {
        char[] hexChars = new char[(bytes.length * 2)];
        int index = 0;
        for (byte b : bytes) {
            int i = index + 1;
            hexChars[index] = f8268a[(b >>> 4) & 15];
            index = i + 1;
            hexChars[i] = f8268a[b & 15];
        }
        return new String(hexChars);
    }
}
