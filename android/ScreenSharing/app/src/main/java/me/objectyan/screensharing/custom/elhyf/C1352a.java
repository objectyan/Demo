package com.baidu.carlife.custom.elhyf;

import com.loopj.android.http.AsyncHttpClient;

/* compiled from: AsyncHttp */
/* renamed from: com.baidu.carlife.custom.elhyf.a */
public class C1352a {
    /* renamed from: a */
    public static final String f3954a = "http://caronline.yfgps.com";
    /* renamed from: b */
    static AsyncHttpClient f3955b;

    /* renamed from: a */
    public static AsyncHttpClient m4958a() {
        if (f3955b == null) {
            f3955b = new AsyncHttpClient();
            f3955b.setMaxRetriesAndTimeout(0, 10000);
        }
        return f3955b;
    }
}
