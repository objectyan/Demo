package com.baidu.carlife.wechat.p108b;

import android.text.TextUtils;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import org.json.JSONObject;

/* compiled from: RoomMember */
/* renamed from: com.baidu.carlife.wechat.b.g */
public class C2385g {
    /* renamed from: a */
    private int f7900a;
    /* renamed from: b */
    private String f7901b;
    /* renamed from: c */
    private String f7902c;
    /* renamed from: d */
    private String f7903d;
    /* renamed from: e */
    private String f7904e;

    /* renamed from: a */
    public int m9123a() {
        return this.f7900a;
    }

    /* renamed from: b */
    public String m9124b() {
        return this.f7901b;
    }

    /* renamed from: c */
    public String m9125c() {
        return this.f7902c;
    }

    /* renamed from: d */
    public String m9126d() {
        return this.f7903d;
    }

    /* renamed from: e */
    public String m9127e() {
        return this.f7904e;
    }

    /* renamed from: a */
    public static C2385g m9122a(JSONObject json, String encryChatRoomId) {
        try {
            C2385g member = new C2385g();
            member.f7900a = json.optInt("Uin");
            member.f7901b = json.getString("UserName");
            String showName = json.optString("DisplayName");
            if (TextUtils.isEmpty(showName)) {
                member.f7902c = json.getString("NickName");
            } else {
                member.f7902c = showName;
            }
            member.f7904e = encryChatRoomId;
            member.f7903d = "/cgi-bin/mmwebwx-bin/webwxgeticon?seq=0&username=" + member.f7901b + "&chatroomid=" + encryChatRoomId + "&skey=" + C2380c.m9070a().m9086g().m9138a();
            return member;
        } catch (Exception e) {
            C2372c.m9036e("contact parse failed");
            e.printStackTrace();
            return null;
        }
    }
}
