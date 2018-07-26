package com.baidu.carlife.p054k.p055a;

import android.text.TextUtils;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.util.C2180k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: MultipartRequestParams */
/* renamed from: com.baidu.carlife.k.a.d */
public class C1622d {
    private static final String URL_AND = "&";
    private static final String URL_EQUAL = "=";
    private static final String URL_QUESTION = "?";
    protected ConcurrentHashMap<String, C1621a> fileParams;
    private String signKey;
    private boolean signNeed;
    private String tag = "NetWorkRequest";
    protected List<NameValuePair> urlParams;

    /* compiled from: MultipartRequestParams */
    /* renamed from: com.baidu.carlife.k.a.d$1 */
    class C16201 implements Comparator<NameValuePair> {
        /* renamed from: a */
        final /* synthetic */ C1622d f4958a;

        C16201(C1622d this$0) {
            this.f4958a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5906a((NameValuePair) obj, (NameValuePair) obj2);
        }

        /* renamed from: a */
        public int m5906a(NameValuePair arg0, NameValuePair arg1) {
            return arg0.getName().compareTo(arg1.getName());
        }
    }

    /* compiled from: MultipartRequestParams */
    /* renamed from: com.baidu.carlife.k.a.d$a */
    protected static class C1621a {
        /* renamed from: a */
        public InputStream f4959a;
        /* renamed from: b */
        public String f4960b;
        /* renamed from: c */
        public String f4961c;

        public C1621a(InputStream inputStream, String fileName, String contentType) {
            this.f4959a = inputStream;
            this.f4960b = fileName;
            this.f4961c = contentType;
        }

        /* renamed from: a */
        public String m5907a() {
            if (this.f4960b != null) {
                return this.f4960b;
            }
            return "nofilename";
        }
    }

    public List<NameValuePair> getUrlParams() {
        return this.urlParams;
    }

    public C1622d() {
        init();
    }

    private void init() {
        this.urlParams = new ArrayList();
        this.fileParams = new ConcurrentHashMap();
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void put(String key, String value) {
        if (key != null && value != null) {
            this.urlParams.add(new BasicNameValuePair(key, value));
        }
    }

    public void put(String key, File file) {
        try {
            put(key, new FileInputStream(file), file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void put(String key, InputStream stream, String fileName) {
        put(key, stream, fileName, null);
    }

    public void put(String key, InputStream stream, String fileName, String contentType) {
        if (key != null && stream != null) {
            this.fileParams.put(key, new C1621a(stream, fileName, contentType));
        }
    }

    public void sortParams() {
        if (this.urlParams != null) {
            Collections.sort(this.urlParams, new C16201(this));
        }
    }

    public HttpEntity getEntity() {
        C1618b multipartEntity = new C1618b();
        if (!this.urlParams.isEmpty()) {
            Iterator<NameValuePair> it = this.urlParams.iterator();
            while (it.hasNext()) {
                NameValuePair pair = (NameValuePair) it.next();
                if (TextUtils.isEmpty(pair.getName()) || TextUtils.isEmpty(pair.getValue())) {
                    it.remove();
                } else {
                    multipartEntity.m5899a(pair.getName(), pair.getValue());
                }
            }
            C1260i.m4435b(this.tag, "the post params is:" + this.urlParams.toString());
            if (this.signNeed) {
                multipartEntity.m5899a(this.signKey, C1622d.calcUrlSign(this.urlParams));
            }
        }
        if (!this.fileParams.isEmpty()) {
            int currentIndex = 0;
            int lastIndex = this.fileParams.entrySet().size() - 1;
            for (Entry<String, C1621a> entry : this.fileParams.entrySet()) {
                C1621a file = (C1621a) entry.getValue();
                if (file.f4959a != null) {
                    boolean isLast = currentIndex == lastIndex;
                    if (file.f4961c != null) {
                        multipartEntity.m5900a((String) entry.getKey(), file.m5907a(), file.f4959a, file.f4961c, isLast);
                    } else {
                        multipartEntity.m5901a((String) entry.getKey(), file.m5907a(), file.f4959a, isLast);
                    }
                    C1260i.m4435b(this.tag, "the post file is:" + file.m5907a());
                }
                currentIndex++;
            }
        }
        return multipartEntity;
    }

    void closeInputSteams() {
        if (!this.fileParams.isEmpty()) {
            for (Entry<String, C1621a> entry : this.fileParams.entrySet()) {
                C1621a file = (C1621a) entry.getValue();
                if (!(file == null || file.f4959a == null)) {
                    try {
                        file.f4959a.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    public boolean isSignNeed() {
        return this.signNeed;
    }

    public void toSign(String signKey) {
        this.signKey = signKey;
        this.signNeed = true;
    }

    public void toSign() {
        this.signKey = "sign";
        this.signNeed = true;
    }

    public static String getUrlParamsString(C1622d params, boolean signNeed, String signKey) {
        if (params == null || params.urlParams.size() < 1) {
            return "";
        }
        StringBuffer sb = new StringBuffer(URL_QUESTION);
        int i = 0;
        while (i < params.urlParams.size()) {
            try {
                NameValuePair pair = (NameValuePair) params.urlParams.get(i);
                sb.append(pair.getName()).append(URL_EQUAL).append(URLEncoder.encode(pair.getValue() == null ? "" : pair.getValue(), "UTF-8"));
                if (i < params.urlParams.size() - 1) {
                    sb.append(URL_AND);
                }
                i++;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (signNeed) {
            sb.append(signKey).append(URL_EQUAL).append(C1622d.calcUrlSign(params.urlParams));
        }
        return sb.toString();
    }

    private static String calcUrlSign(List<NameValuePair> params) {
        StringBuffer sb = new StringBuffer("navi");
        try {
            for (NameValuePair pair : params) {
                sb.append(pair.getName()).append(URL_EQUAL).append(URLEncoder.encode(pair.getValue() == null ? "" : pair.getValue(), "UTF-8")).append(URL_AND);
            }
        } catch (UnsupportedEncodingException e) {
        }
        sb.deleteCharAt(sb.length() - 1).append("bd44977f4225b957923ddefa781e8f93");
        return C2180k.m8280a(sb.toString());
    }
}
