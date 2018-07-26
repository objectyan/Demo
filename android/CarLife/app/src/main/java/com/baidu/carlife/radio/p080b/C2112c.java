package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.p103a.C2108a;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ChannelListRequest */
/* renamed from: com.baidu.carlife.radio.b.c */
public class C2112c extends C2108a {
    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7929c();
    }

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        return null;
    }

    /* renamed from: c */
    public void mo1769c() {
        boolean isCacheValid = C2142b.m8067a().m8081f();
        C1260i.m4440c("radio_request", "isCacheValid = " + isCacheValid);
        if (!isCacheValid) {
            super.mo1769c();
        }
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        C1260i.m4440c("radio_request", "statusCode=" + statusCode);
        try {
            if (new JSONObject(response).getInt(C2125n.f6745M) == 0) {
                C2142b.m8067a().m8079d(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        C1260i.m4445e("radio_request", "error=" + error);
    }
}
