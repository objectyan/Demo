package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.p075d.p076a.C1408c;
import com.baidu.carlife.p075d.p076a.C1416e;
import com.baidu.carlife.radio.p080b.p103a.C2108a;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import java.util.Map;

/* compiled from: FeedbackNewRequest */
/* renamed from: com.baidu.carlife.radio.b.i */
public class C2119i extends C2108a {
    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7936j();
    }

    /* renamed from: a */
    protected void mo1776a(String url, Map<String, String> paramMap, C1408c httpCallback) {
        C1416e.m5211b(url, paramMap, httpCallback);
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        LogUtil.m4440c("radio_request", "statusCode = " + statusCode + "; response=" + response);
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        LogUtil.e("radio_request", "error = " + error);
    }
}
