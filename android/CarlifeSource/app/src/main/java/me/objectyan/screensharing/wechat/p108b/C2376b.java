package com.baidu.carlife.wechat.p108b;

import android.text.TextUtils;
import com.baidu.carlife.wechat.p105a.p107b.C2371b;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Contact */
/* renamed from: com.baidu.carlife.wechat.b.b */
public class C2376b {
    /* renamed from: a */
    private int f7850a;
    /* renamed from: b */
    private String f7851b;
    /* renamed from: c */
    private String f7852c;
    /* renamed from: d */
    private String f7853d;
    /* renamed from: e */
    private int f7854e;
    /* renamed from: f */
    private int f7855f;
    /* renamed from: g */
    private int f7856g;
    /* renamed from: h */
    private int f7857h;
    /* renamed from: i */
    private String f7858i;
    /* renamed from: j */
    private String f7859j;
    /* renamed from: k */
    private String f7860k;
    /* renamed from: l */
    private List<C2385g> f7861l = new ArrayList();

    public String toString() {
        return "Contact[" + this.f7852c + "," + this.f7851b + "]";
    }

    /* renamed from: a */
    public void m9053a(String userName) {
        this.f7851b = userName;
    }

    /* renamed from: b */
    public void m9055b(String showName) {
        this.f7852c = showName;
    }

    /* renamed from: c */
    public void m9057c(String iconUrl) {
        this.f7853d = iconUrl;
    }

    /* renamed from: a */
    public String m9052a() {
        return this.f7851b;
    }

    /* renamed from: b */
    public String m9054b() {
        if (!TextUtils.isEmpty(this.f7852c) || !m9066k()) {
            return this.f7852c;
        }
        if (this.f7861l == null || this.f7861l.size() <= 0) {
            return "群消息";
        }
        StringBuffer nameBuffer = new StringBuffer();
        int size = Math.min(5, this.f7861l.size());
        for (int i = 0; i < size; i++) {
            nameBuffer.append(((C2385g) this.f7861l.get(i)).m9125c());
            if (i < size - 1) {
                nameBuffer.append("、");
            }
        }
        if (this.f7861l.size() > 5) {
            nameBuffer.append("...");
        }
        return nameBuffer.toString();
    }

    /* renamed from: c */
    public String m9056c() {
        return this.f7859j;
    }

    /* renamed from: d */
    public int m9058d() {
        return this.f7856g;
    }

    /* renamed from: e */
    public String m9060e() {
        return this.f7853d;
    }

    /* renamed from: f */
    public int m9061f() {
        return this.f7854e;
    }

    /* renamed from: g */
    public String m9062g() {
        return this.f7858i;
    }

    /* renamed from: h */
    public String m9063h() {
        return this.f7860k;
    }

    /* renamed from: i */
    public List<C2385g> m9064i() {
        return this.f7861l;
    }

    /* renamed from: d */
    public C2385g m9059d(String userName) {
        if (this.f7861l != null) {
            for (C2385g member : this.f7861l) {
                if (TextUtils.equals(userName, member.m9124b())) {
                    return member;
                }
            }
        }
        return null;
    }

    /* renamed from: j */
    public boolean m9065j() {
        return this.f7855f > 0 || !this.f7851b.startsWith("@");
    }

    /* renamed from: k */
    public boolean m9066k() {
        return this.f7851b.startsWith("@@");
    }

    /* renamed from: l */
    public boolean m9067l() {
        return this.f7857h >= 2048 && this.f7857h < 4096;
    }

    /* renamed from: m */
    public boolean m9068m() {
        return m9059d(C2380c.m9070a().m9084e()) != null;
    }

    /* renamed from: n */
    public int m9069n() {
        if (this.f7856g == 1) {
            return 0;
        }
        if (m9066k()) {
            return 1;
        }
        if (m9051o()) {
            return 3;
        }
        char first = this.f7859j.charAt(0);
        return (first < 'a' || first > 'z') ? 3 : 2;
    }

    /* renamed from: o */
    private boolean m9051o() {
        return this.f7859j == null || this.f7859j.length() <= 0;
    }

    /* renamed from: a */
    public static C2376b m9050a(JSONObject json) {
        try {
            C2376b c2376b = new C2376b();
            c2376b.f7850a = json.optInt("Uin");
            c2376b.f7851b = json.getString("UserName");
            String showName = json.optString("RemarkName");
            if (TextUtils.isEmpty(showName)) {
                c2376b.f7852c = json.getString("NickName");
            } else {
                c2376b.f7852c = showName;
            }
            c2376b.f7852c = c2376b.f7852c.replaceAll("<span.*></span>", "�");
            c2376b.f7859j = C2371b.m9015a().m9018a(c2376b.m9054b());
            c2376b.f7853d = json.optString("HeadImgUrl");
            c2376b.f7854e = json.optInt("Statues");
            c2376b.f7855f = json.optInt("VerifyFlag");
            c2376b.f7856g = json.optInt("StarFriend");
            c2376b.f7857h = json.optInt("ContactFlag");
            c2376b.f7858i = json.optString("Alias");
            c2376b.f7860k = json.optString("EncryChatRoomId");
            if (!c2376b.m9066k()) {
                return c2376b;
            }
            c2376b.f7861l = new ArrayList();
            if (json.isNull("MemberList")) {
                return c2376b;
            }
            JSONArray jsonArray = json.getJSONArray("MemberList");
            int len = jsonArray.length();
            for (int i = 0; i < len; i++) {
                String encryChatRoomId = c2376b.f7860k;
                if (TextUtils.isEmpty(encryChatRoomId)) {
                    encryChatRoomId = c2376b.f7851b;
                }
                C2385g member = C2385g.m9122a(jsonArray.getJSONObject(i), encryChatRoomId);
                if (member != null) {
                    c2376b.f7861l.add(member);
                }
            }
            return c2376b;
        } catch (Exception e) {
            C2372c.m9036e("contact parse failed");
            e.printStackTrace();
            return null;
        }
    }
}
