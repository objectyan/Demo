package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.radio.p080b.p103a.C2108a;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import java.util.Map;

/* compiled from: UserOnlineRequest */
/* renamed from: com.baidu.carlife.radio.b.ab */
public class ab extends C2108a {
    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7937k();
    }

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        return null;
    }

    /* renamed from: c */
    public void mo1769c() {
        super.mo1769c();
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        C1260i.m4440c("radio_request", "statusCode = " + statusCode + "; response=" + response);
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        C1260i.m4445e("radio_request", "error = " + error);
    }
}
