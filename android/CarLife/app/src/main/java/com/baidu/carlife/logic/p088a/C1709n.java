package com.baidu.carlife.logic.p088a;

import android.webkit.URLUtil;

/* compiled from: UrlChecker */
/* renamed from: com.baidu.carlife.logic.a.n */
public class C1709n {

    /* compiled from: UrlChecker */
    /* renamed from: com.baidu.carlife.logic.a.n$a */
    private static class C1708a {
        /* renamed from: a */
        private static final C1709n f5206a = new C1709n();

        private C1708a() {
        }
    }

    private C1709n() {
    }

    /* renamed from: a */
    public static C1709n m6204a() {
        return C1708a.f5206a;
    }

    /* renamed from: a */
    public String m6205a(String urlPath) {
        if (!URLUtil.isValidUrl(urlPath) && !urlPath.endsWith(".aac")) {
            return null;
        }
        if (!urlPath.startsWith("http")) {
            urlPath = "http:" + urlPath;
        }
        if (urlPath.contains("transcode=ts")) {
            urlPath = urlPath.replace("transcode=ts", "transcode=aac");
        }
        return urlPath;
    }
}
