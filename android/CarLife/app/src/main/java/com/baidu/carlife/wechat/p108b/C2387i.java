package com.baidu.carlife.wechat.p108b;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserInfo */
/* renamed from: com.baidu.carlife.wechat.b.i */
public class C2387i {
    /* renamed from: a */
    private String f7907a = "";
    /* renamed from: b */
    private String f7908b = "";
    /* renamed from: c */
    private String f7909c = "";
    /* renamed from: d */
    private String f7910d = "";

    /* renamed from: a */
    public String m9129a() {
        return this.f7907a;
    }

    /* renamed from: a */
    public void m9130a(String uin) {
        this.f7907a = uin;
    }

    /* renamed from: b */
    public String m9131b() {
        return this.f7908b;
    }

    /* renamed from: b */
    public void m9132b(String userName) {
        this.f7908b = userName;
    }

    /* renamed from: c */
    public String m9133c() {
        return this.f7909c;
    }

    /* renamed from: c */
    public void m9134c(String nickName) {
        this.f7909c = nickName;
    }

    /* renamed from: d */
    public String m9135d() {
        return this.f7910d;
    }

    /* renamed from: d */
    public void m9136d(String headImgUrl) {
        this.f7910d = headImgUrl;
    }

    /* renamed from: e */
    public C2376b m9137e() {
        C2376b contact = new C2376b();
        contact.m9053a(this.f7908b);
        contact.m9055b(this.f7909c);
        contact.m9057c(this.f7910d);
        return contact;
    }

    /* renamed from: a */
    public static C2387i m9128a(JSONObject userJson) throws JSONException {
        C2387i userInfo = new C2387i();
        userInfo.m9130a(userJson.getString("Uin"));
        userInfo.m9132b(userJson.getString("UserName"));
        userInfo.m9134c(userJson.getString("NickName"));
        userInfo.m9136d(userJson.getString("HeadImgUrl"));
        return userInfo;
    }
}
