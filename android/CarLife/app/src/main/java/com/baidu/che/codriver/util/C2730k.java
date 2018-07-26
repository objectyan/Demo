package com.baidu.che.codriver.util;

import android.net.Uri;
import android.util.Base64;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: NlpUrlSigner */
/* renamed from: com.baidu.che.codriver.util.k */
public final class C2730k {
    /* renamed from: a */
    private static final String f8942a = "RCVrMnRK";
    /* renamed from: b */
    private static final String f8943b = "R21EVyNV";

    /* compiled from: NlpUrlSigner */
    /* renamed from: com.baidu.che.codriver.util.k$1 */
    static class C27281 implements Comparator<C2729a> {
        C27281() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m10223a((C2729a) obj, (C2729a) obj2);
        }

        /* renamed from: a */
        public int m10223a(C2729a lhs, C2729a rhs) {
            return lhs.f8940a.compareTo(rhs.f8940a);
        }
    }

    /* compiled from: NlpUrlSigner */
    /* renamed from: com.baidu.che.codriver.util.k$a */
    private static class C2729a {
        /* renamed from: a */
        String f8940a;
        /* renamed from: b */
        String f8941b;

        C2729a(String key, String value) {
            this.f8940a = key;
            this.f8941b = value;
        }
    }

    /* renamed from: a */
    public static String m10224a(String url) throws Exception {
        List<C2729a> keyValuePairList = new ArrayList();
        Uri uri = Uri.parse(url);
        for (String key : uri.getQueryParameterNames()) {
            keyValuePairList.add(new C2729a(key, uri.getQueryParameter(key)));
        }
        C2730k.m10225a((List) keyValuePairList);
        StringBuffer stringBuffer = new StringBuffer();
        for (C2729a keyValuePair : keyValuePairList) {
            stringBuffer.append(keyValuePair.f8940a).append("=").append(URLEncoder.encode(keyValuePair.f8941b, "UTF-8"));
        }
        String prefix = new String(Base64.decode(f8942a.getBytes("UTF-8"), 0));
        return url + "&sign=" + C2726i.m10216a(prefix + stringBuffer.toString() + new String(Base64.decode(f8943b.getBytes("UTF-8"), 0)));
    }

    /* renamed from: a */
    private static void m10225a(List<C2729a> keyValuePairList) {
        Collections.sort(keyValuePairList, new C27281());
    }
}
