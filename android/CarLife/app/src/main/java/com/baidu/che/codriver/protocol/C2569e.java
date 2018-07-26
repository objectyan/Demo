package com.baidu.che.codriver.protocol;

import android.text.TextUtils;
import com.baidu.che.codriver.util.C2725h;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: UrlBuilder */
/* renamed from: com.baidu.che.codriver.protocol.e */
public class C2569e {
    /* renamed from: a */
    private static final String f8530a = "UrlBuilder";
    /* renamed from: b */
    private String f8531b;
    /* renamed from: c */
    private String f8532c;
    /* renamed from: d */
    private HashMap<String, String> f8533d = new HashMap();
    /* renamed from: e */
    private HashMap<String, String> f8534e = new HashMap();

    /* compiled from: UrlBuilder */
    /* renamed from: com.baidu.che.codriver.protocol.e$1 */
    class C25671 implements Comparator<Entry<String, String>> {
        /* renamed from: a */
        final /* synthetic */ C2569e f8528a;

        C25671(C2569e this$0) {
            this.f8528a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9694a((Entry) obj, (Entry) obj2);
        }

        /* renamed from: a */
        public int m9694a(Entry<String, String> firstMapEntry, Entry<String, String> secondMapEntry) {
            return ((String) firstMapEntry.getKey()).compareTo((String) secondMapEntry.getKey());
        }
    }

    /* compiled from: UrlBuilder */
    /* renamed from: com.baidu.che.codriver.protocol.e$a */
    public static class C2568a extends Exception {
        /* renamed from: a */
        private static final long f8529a = 4496218849022966611L;

        public C2568a(String message) {
            super(message);
        }
    }

    /* renamed from: a */
    public C2569e m9697a(String host) {
        this.f8531b = host;
        return this;
    }

    /* renamed from: b */
    public C2569e m9700b(String uri) {
        this.f8532c = uri;
        return this;
    }

    /* renamed from: a */
    public C2569e m9698a(String key, String value) {
        if (value != null) {
            this.f8533d.put(key, value);
            try {
                this.f8534e.put(key, URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            C2725h.m10214e(f8530a, "buildParam key=" + key + " value=" + value);
        }
        return this;
    }

    /* renamed from: a */
    public HashMap<String, String> m9699a() {
        return this.f8533d;
    }

    /* renamed from: b */
    public String m9701b() throws C2568a {
        if (TextUtils.isEmpty(this.f8531b)) {
            C2725h.m10214e(f8530a, "host or request uri is empty");
            throw new C2568a("host or request uri is empty");
        }
        String rtnUrl;
        if (TextUtils.isEmpty(this.f8532c)) {
            rtnUrl = this.f8531b;
        } else if (this.f8531b.endsWith("/") && this.f8532c.startsWith("/")) {
            rtnUrl = this.f8531b + this.f8532c.substring(1);
        } else if (this.f8531b.endsWith("/") || this.f8532c.startsWith("/")) {
            rtnUrl = this.f8531b + this.f8532c;
        } else {
            rtnUrl = this.f8531b + "/" + this.f8532c;
        }
        String paramStr = m9696a(this.f8533d);
        if (!TextUtils.isEmpty(paramStr)) {
            if (rtnUrl.indexOf("?") < 0) {
                rtnUrl = rtnUrl + "?" + paramStr;
            } else {
                rtnUrl = rtnUrl + "&" + paramStr;
            }
        }
        C2725h.m10207b(f8530a, "getUrl(): " + rtnUrl);
        return rtnUrl;
    }

    /* renamed from: a */
    private String m9696a(Map<String, String> data) {
        StringBuilder sb = new StringBuilder();
        for (String key : data.keySet()) {
            String value = null;
            try {
                value = URLEncoder.encode((String) data.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(key + "=" + value);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m9695a(String url, String key, String value) {
        if (TextUtils.isEmpty(url)) {
            return url;
        }
        key = key + "=";
        int index = url.indexOf("?");
        String anchor;
        int indexHash;
        StringBuilder sb;
        if (index < 0) {
            anchor = null;
            indexHash = url.indexOf("#");
            if (indexHash < 0) {
                sb = new StringBuilder(url);
            } else {
                anchor = url.substring(indexHash);
                sb = new StringBuilder(url.substring(0, indexHash));
            }
            sb.append("?").append(key).append(value);
            if (anchor != null) {
                sb.append(anchor);
            }
            return sb.toString();
        } else if (url.indexOf("&" + key, index) >= 0 || url.indexOf("?" + key, index) >= 0) {
            return url;
        } else {
            String tmpUrl;
            anchor = null;
            indexHash = url.indexOf("#");
            if (indexHash < 0) {
                tmpUrl = url;
                sb = new StringBuilder(tmpUrl);
            } else {
                anchor = url.substring(indexHash);
                tmpUrl = url.substring(0, indexHash);
                sb = new StringBuilder(tmpUrl);
            }
            if (!(tmpUrl.endsWith("&") || tmpUrl.endsWith("?"))) {
                sb.append("&");
            }
            sb.append(key).append(value);
            if (anchor != null) {
                sb.append(anchor);
            }
            return sb.toString();
        }
    }

    /* renamed from: c */
    public String m9702c() {
        List<Entry<String, String>> mHashMapEntryList = new ArrayList(this.f8534e.entrySet());
        Collections.sort(mHashMapEntryList, new C25671(this));
        String xString = "";
        for (int i = 0; i < mHashMapEntryList.size(); i++) {
            xString = xString + mHashMapEntryList.get(i);
        }
        return xString;
    }
}
