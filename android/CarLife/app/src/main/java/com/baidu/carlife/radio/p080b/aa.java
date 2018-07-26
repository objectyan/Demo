package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.radio.p080b.p103a.C2108a;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: UserOnlineNumberRequest */
/* renamed from: com.baidu.carlife.radio.b.aa */
public class aa extends C2108a {
    /* renamed from: c */
    private C1496a f6712c;

    /* compiled from: UserOnlineNumberRequest */
    /* renamed from: com.baidu.carlife.radio.b.aa$a */
    public interface C1496a {
        /* renamed from: a */
        void mo1563a(int i);

        /* renamed from: a */
        void mo1564a(String str);
    }

    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7938l();
    }

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        return null;
    }

    /* renamed from: a */
    public void m7944a(C1496a callback) {
        this.f6712c = callback;
        mo1769c();
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        C1260i.m4440c("radio_request", "statusCode = " + statusCode + "; response=" + response);
        if (statusCode == 200) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.getInt(C2125n.f6745M) != 0) {
                    if (this.f6712c != null) {
                        this.f6712c.mo1564a("errmsg=" + jsonObject.getString(C2125n.f6746N));
                    }
                } else if (this.f6712c != null) {
                    this.f6712c.mo1563a(jsonObject.getInt("count"));
                }
            } catch (Exception e) {
                if (this.f6712c != null) {
                    this.f6712c.mo1564a("exception=" + e.toString());
                }
            }
        } else if (this.f6712c != null) {
            this.f6712c.mo1564a("statusCode=" + statusCode);
        }
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        C1260i.m4445e("radio_request", "error = " + error);
        if (this.f6712c != null) {
            this.f6712c.mo1564a(error);
        }
    }
}
