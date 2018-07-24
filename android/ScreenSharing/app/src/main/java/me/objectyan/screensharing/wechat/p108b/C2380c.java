package com.baidu.carlife.wechat.p108b;

import android.text.TextUtils;
import com.baidu.carlife.wechat.p105a.p107b.C2371b;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p113g.C2499c;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DataCenter */
/* renamed from: com.baidu.carlife.wechat.b.c */
public class C2380c {
    /* renamed from: a */
    private C2379b f7867a;
    /* renamed from: b */
    private String f7868b;
    /* renamed from: c */
    private C2387i f7869c;
    /* renamed from: d */
    private List<C2386h> f7870d;
    /* renamed from: e */
    private C2388j f7871e;
    /* renamed from: f */
    private List<C2376b> f7872f;
    /* renamed from: g */
    private List<C2376b> f7873g;
    /* renamed from: h */
    private boolean f7874h;

    /* compiled from: DataCenter */
    /* renamed from: com.baidu.carlife.wechat.b.c$a */
    private static class C2378a {
        /* renamed from: a */
        public static final C2380c f7862a = new C2380c();

        private C2378a() {
        }
    }

    /* compiled from: DataCenter */
    /* renamed from: com.baidu.carlife.wechat.b.c$b */
    public enum C2379b {
        NOT_LOGIN,
        LOGIN,
        LOGOUT
    }

    private C2380c() {
        this.f7867a = C2379b.NOT_LOGIN;
        this.f7872f = new ArrayList();
        this.f7873g = new ArrayList();
        this.f7874h = true;
    }

    /* renamed from: a */
    public static C2380c m9070a() {
        return C2378a.f7862a;
    }

    /* renamed from: b */
    public void m9079b() {
        this.f7867a = C2379b.NOT_LOGIN;
        this.f7868b = "";
        this.f7869c = new C2387i();
        this.f7871e = new C2388j();
        this.f7870d = null;
        this.f7872f = new ArrayList();
        this.f7873g = new ArrayList();
        this.f7874h = true;
    }

    /* renamed from: c */
    public boolean m9082c() {
        return this.f7874h;
    }

    /* renamed from: a */
    public void m9076a(boolean openAfterLogin) {
        this.f7874h = openAfterLogin;
    }

    /* renamed from: a */
    public void m9072a(C2379b loginState) {
        this.f7867a = loginState;
    }

    /* renamed from: a */
    public void m9073a(C2387i userInfo) {
        this.f7869c = userInfo;
        this.f7868b = userInfo.m9131b();
    }

    /* renamed from: a */
    public void m9074a(C2388j wechatCookie) {
        this.f7871e = wechatCookie;
    }

    /* renamed from: a */
    public void m9075a(List<C2386h> syncKeyList) {
        this.f7870d = syncKeyList;
    }

    /* renamed from: b */
    public void m9080b(List<C2376b> contactList) {
        for (C2376b contact : contactList) {
            if (contact.m9066k()) {
                this.f7873g.add(contact);
            } else {
                this.f7872f.add(contact);
            }
        }
        C2372c.m9030c("room contact size = " + this.f7873g.size());
        C2372c.m9030c("contact size = " + this.f7872f.size());
    }

    /* renamed from: d */
    public C2379b m9083d() {
        return this.f7867a;
    }

    /* renamed from: e */
    public String m9084e() {
        return this.f7868b;
    }

    /* renamed from: f */
    public C2387i m9085f() {
        return this.f7869c == null ? new C2387i() : this.f7869c;
    }

    /* renamed from: g */
    public C2388j m9086g() {
        return this.f7871e == null ? new C2388j() : this.f7871e;
    }

    /* renamed from: h */
    public List<C2376b> m9087h() {
        List<C2376b> contactList = new ArrayList();
        contactList.addAll(this.f7873g);
        contactList.addAll(this.f7872f);
        return contactList;
    }

    /* renamed from: i */
    public List<C2376b> m9088i() {
        return this.f7873g;
    }

    /* renamed from: j */
    public JSONObject m9089j() {
        JSONObject baseRequestJson = new JSONObject();
        if (this.f7871e != null) {
            try {
                baseRequestJson.put("Sid", this.f7871e.m9140b());
                baseRequestJson.put("Skey", this.f7871e.m9138a());
                baseRequestJson.put("Uin", this.f7871e.m9142c());
                baseRequestJson.put("DeviceID", C2499c.m9501b());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return baseRequestJson;
    }

    /* renamed from: k */
    public JSONObject m9090k() {
        if (this.f7870d == null || this.f7870d.size() == 0) {
            return null;
        }
        JSONObject syncKeyJson = new JSONObject();
        JSONArray list = new JSONArray();
        int count = this.f7870d.size();
        try {
            syncKeyJson.put("Count", count);
            for (int i = 0; i < count; i++) {
                JSONObject itemJson = new JSONObject();
                itemJson.put("Key", ((C2386h) this.f7870d.get(i)).f7905a);
                itemJson.put("Val", ((C2386h) this.f7870d.get(i)).f7906b);
                list.put(itemJson);
            }
            syncKeyJson.put("List", list);
            return syncKeyJson;
        } catch (Exception e) {
            e.printStackTrace();
            return syncKeyJson;
        }
    }

    /* renamed from: l */
    public String m9091l() {
        if (this.f7870d == null || this.f7870d.size() == 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        int size = this.f7870d.size();
        for (int i = 0; i < size; i++) {
            buffer.append(((C2386h) this.f7870d.get(i)).f7905a + JNISearchConst.LAYER_ID_DIVIDER + ((C2386h) this.f7870d.get(i)).f7906b);
            if (i < size - 1) {
                buffer.append("%7c");
            }
        }
        return buffer.toString();
    }

    /* renamed from: a */
    public boolean m9077a(String userName) {
        return TextUtils.equals(userName, this.f7868b);
    }

    /* renamed from: b */
    public C2376b m9078b(String userName) {
        C2376b chatContact = C2398k.m9160a().m9180b(userName);
        if (chatContact != null) {
            return chatContact;
        }
        if (userName.startsWith("@@")) {
            for (C2376b contact : this.f7873g) {
                if (TextUtils.equals(contact.m9052a(), userName)) {
                    return contact;
                }
            }
        }
        for (C2376b contact2 : this.f7872f) {
            if (TextUtils.equals(contact2.m9052a(), userName)) {
                return contact2;
            }
        }
        if (C2380c.m9070a().m9077a(userName)) {
            return C2380c.m9070a().m9085f().m9137e();
        }
        return null;
    }

    /* renamed from: c */
    public List<C2376b> m9081c(String searchName) {
        C2376b contact;
        String fuzzyName = m9071d(C2371b.m9015a().m9018a(searchName.replaceAll("，|。", "")));
        List<C2376b> contactList = new ArrayList();
        for (C2376b contact2 : this.f7873g) {
            if (m9071d(contact2.m9056c()).contains(fuzzyName)) {
                contactList.add(contact2);
            }
        }
        for (C2376b contact22 : this.f7872f) {
            if (m9071d(contact22.m9056c()).contains(fuzzyName)) {
                contactList.add(contact22);
            }
        }
        for (C2375a chat : C2398k.m9160a().m9185c()) {
            contact22 = chat.m9045a();
            if (contact22.m9066k() && m9071d(contact22.m9056c()).contains(fuzzyName)) {
                boolean exist = false;
                for (C2376b c : contactList) {
                    if (TextUtils.equals(c.m9052a(), contact22.m9052a())) {
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    contactList.add(contact22);
                }
            }
        }
        return contactList;
    }

    /* renamed from: d */
    private String m9071d(String str) {
        return str.replaceAll("ch", "c").replaceAll("sh", "s").replaceAll("zh", MapObjKey.OBJ_SS_ARROW_Z).replaceAll(Regular.CATEGORY_FIX_VALUE, "h").replaceAll("r", "n").replaceAll("l", "n").replaceAll("ang", "an").replaceAll("eng", NaviStatConstants.K_NSC_KEY_EN).replaceAll("ing", "in").replaceAll(" ", "");
    }
}
