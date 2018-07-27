package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.radio.p080b.p103a.C2108a;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import java.util.Map;

/* compiled from: FavoriteAddRequest */
/* renamed from: com.baidu.carlife.radio.b.g */
public class C2117g extends C2108a {
    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7934h();
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
