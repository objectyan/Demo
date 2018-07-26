package com.baidu.carlife.wechat.p110e;

import android.text.TextUtils;
import com.baidu.carlife.wechat.e.b.AnonymousClass10;
import com.baidu.carlife.wechat.p105a.p106a.C2358a;
import com.baidu.carlife.wechat.p105a.p106a.C2368c;
import com.baidu.carlife.wechat.p105a.p106a.C2368c.C2367c;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p108b.C2375a;
import com.baidu.carlife.wechat.p108b.C2376b;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p108b.C2380c.C2379b;
import com.baidu.carlife.wechat.p108b.C2382d;
import com.baidu.carlife.wechat.p108b.C2386h;
import com.baidu.carlife.wechat.p108b.C2387i;
import com.baidu.carlife.wechat.p108b.C2388j;
import com.baidu.carlife.wechat.p108b.C2398k;
import com.baidu.carlife.wechat.p110e.C2434b;
import com.baidu.carlife.wechat.p110e.C2434b.C2406a;
import com.baidu.carlife.wechat.p113g.C2499c;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WechatAPI */
/* renamed from: com.baidu.carlife.wechat.e.b */
public final class C2434b {

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$g */
    public interface C2400g {
        /* renamed from: a */
        void mo1831a();

        /* renamed from: b */
        void mo1832b();

        /* renamed from: c */
        void mo1833c();

        /* renamed from: d */
        void mo1834d();

        /* renamed from: e */
        void mo1835e();
    }

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$j */
    public interface C2402j {
        /* renamed from: a */
        void mo1836a();

        /* renamed from: a */
        void mo1837a(int i);
    }

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$b */
    public interface C2404b {
        /* renamed from: a */
        void mo1838a();

        /* renamed from: a */
        void mo1839a(String str);
    }

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$a */
    public interface C2406a {
        /* renamed from: a */
        void mo1840a(int i);

        /* renamed from: a */
        void mo1841a(int i, List<C2376b> list);
    }

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$f */
    public interface C2411f {
        /* renamed from: a */
        void mo1842a();

        /* renamed from: a */
        void mo1843a(String str);

        /* renamed from: b */
        void mo1844b();
    }

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$c */
    public interface C2429c {
        /* renamed from: a */
        void mo1860a();

        /* renamed from: a */
        void mo1861a(String str);

        /* renamed from: b */
        void mo1862b();

        /* renamed from: b */
        void mo1863b(String str);

        /* renamed from: c */
        void mo1864c();

        /* renamed from: d */
        void mo1865d();
    }

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$d */
    public interface C2430d {
        /* renamed from: a */
        void mo1870a();

        /* renamed from: b */
        void mo1871b();
    }

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$e */
    public interface C2431e {
        /* renamed from: a */
        void mo1866a();

        /* renamed from: b */
        void mo1867b();
    }

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$h */
    public interface C2432h {
        /* renamed from: a */
        void mo1858a(String str);

        /* renamed from: b */
        void mo1859b(String str);
    }

    /* compiled from: WechatAPI */
    /* renamed from: com.baidu.carlife.wechat.e.b$i */
    public interface C2433i {
        /* renamed from: a */
        void mo1868a();

        /* renamed from: a */
        void mo1869a(String str);
    }

    /* renamed from: a */
    public static void m9300a(boolean clearCookie) {
        C2368c.m8998a(clearCookie);
    }

    /* renamed from: a */
    public static void m9292a(final C2432h cb) {
        C2368c.m8994a(C2436c.m9310b(), new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                cb.mo1859b(e.toString());
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                C2372c.m9030c("load uuid response: " + httpResult.m8965b());
                if (httpResult.m8961a().intValue() != 200) {
                    cb.mo1859b("statusCode=" + httpResult.m8961a());
                    return;
                }
                Matcher matcher = Pattern.compile("window.QRLogin.code = ([0-9]+);").matcher(httpResult.m8965b());
                int code = 0;
                if (matcher.find()) {
                    code = Integer.valueOf(matcher.group(1)).intValue();
                }
                if (code != 200) {
                    cb.mo1859b("code=" + code);
                    return;
                }
                matcher = Pattern.compile("window.QRLogin.uuid = \"([0-9a-zA-Z_\\-]+==)\";").matcher(httpResult.m8965b());
                String uuid = "";
                if (matcher.find()) {
                    cb.mo1858a(matcher.group(1));
                    return;
                }
                cb.mo1859b("uuid_not_found");
            }
        });
    }

    /* renamed from: a */
    public static void m9296a(String uuid, final C2429c cb) {
        C2368c.m8994a(C2436c.m9313c(uuid), new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                C2372c.m9030c(new StringBuilder().append("login check response  onError :\n").append(e).toString() == null ? null : e.toString());
                if (e == null || !e.toString().contains("Canceled")) {
                    cb.mo1860a();
                } else {
                    cb.mo1865d();
                }
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                C2372c.m9030c("login check response : statusCode = " + httpResult.m8961a());
                if (httpResult.m8961a().intValue() != 200) {
                    cb.mo1860a();
                    return;
                }
                Matcher matcher = Pattern.compile("window.code=([0-9]+);").matcher(httpResult.m8965b());
                int code = 0;
                if (matcher.find()) {
                    code = Integer.valueOf(matcher.group(1)).intValue();
                }
                C2372c.m9030c("login check response : code = " + code);
                switch (code) {
                    case 200:
                        C2380c.m9070a().m9072a(C2379b.LOGIN);
                        matcher = Pattern.compile("window.redirect_uri=\"(.+)\";").matcher(httpResult.m8965b());
                        if (matcher.find()) {
                            String redirectUri = matcher.group(1);
                            String host = "";
                            if (redirectUri.startsWith("https://")) {
                                host = redirectUri.substring("https://".length());
                            } else if (redirectUri.startsWith("http://")) {
                                host = redirectUri.substring("http://".length());
                            }
                            host = host.split("/", 2)[0];
                            C2372c.m9030c("login check >> redirect host = " + host);
                            C2436c.m9309a(host);
                            cb.mo1861a(redirectUri);
                            return;
                        }
                        cb.mo1860a();
                        return;
                    case 201:
                        matcher = Pattern.compile("window.userAvatar = '(.*)';").matcher(httpResult.m8965b());
                        String iconUrl = "";
                        if (matcher.find()) {
                            iconUrl = matcher.group(1);
                        }
                        cb.mo1863b(iconUrl);
                        cb.mo1864c();
                        return;
                    case 400:
                        cb.mo1862b();
                        return;
                    default:
                        cb.mo1864c();
                        return;
                }
            }
        });
    }

    /* renamed from: a */
    public static void m9297a(String redirectUri, final C2431e cb) {
        C2368c.m8994a(redirectUri + "&fun=new&version=v2&lang=zh_CN", new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                e.printStackTrace();
                cb.mo1867b();
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                C2372c.m9030c("redirect uri response : statusCode = " + httpResult.m8961a() + "\n" + httpResult.m8965b());
                if (httpResult.m8961a().intValue() != 200) {
                    cb.mo1867b();
                    return;
                }
                Matcher matcher = Pattern.compile("<ret>([0-9]*)</ret>").matcher(httpResult.m8965b());
                if (!matcher.find() || Integer.parseInt(matcher.group(1)) == 0) {
                    Map<String, String> cookieMap = httpResult.m8967c();
                    C2388j wechatCookie = new C2388j();
                    matcher = Pattern.compile("<skey>(.+)</skey>").matcher(httpResult.m8965b());
                    if (matcher.find()) {
                        wechatCookie.m9139a(matcher.group(1));
                    }
                    matcher = Pattern.compile("<pass_ticket>(.+)</pass_ticket>").matcher(httpResult.m8965b());
                    if (matcher.find()) {
                        wechatCookie.m9149f(matcher.group(1));
                    }
                    wechatCookie.m9141b((String) cookieMap.get("wxsid"));
                    wechatCookie.m9143c((String) cookieMap.get("wxuin"));
                    wechatCookie.m9147e((String) cookieMap.get("webwx_data_ticket"));
                    wechatCookie.m9145d((String) cookieMap.get("webwxuvid"));
                    wechatCookie.m9151g((String) cookieMap.get("mm_lang"));
                    wechatCookie.m9153h((String) cookieMap.get("wxloadtime"));
                    C2380c.m9070a().m9074a(wechatCookie);
                    cb.mo1866a();
                    return;
                }
                cb.mo1867b();
            }
        });
    }

    /* renamed from: a */
    public static void m9293a(final C2433i cb) {
        C2367c resultCallback = new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                cb.mo1869a(e.toString());
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                if (httpResult.m8961a().intValue() != 200) {
                    C2372c.m9036e("webwx init failed: statusCode = " + httpResult.m8961a());
                    cb.mo1869a("statusCode=" + httpResult.m8961a());
                    return;
                }
                try {
                    JSONObject json = new JSONObject(httpResult.m8965b());
                    int ret = json.getJSONObject("BaseResponse").getInt("Ret");
                    if (ret != 0) {
                        cb.mo1869a("ret=" + ret);
                        return;
                    }
                    int size;
                    int i;
                    C2380c.m9070a().m9073a(C2387i.m9128a(json.getJSONObject("User")));
                    JSONObject synckeyjson = json.optJSONObject("SyncKey");
                    if (synckeyjson != null) {
                        JSONArray list = synckeyjson.getJSONArray("List");
                        if (list != null && list.length() > 0) {
                            List syncKeys = new ArrayList();
                            size = list.length();
                            for (i = 0; i < size; i++) {
                                synckeyjson = list.getJSONObject(i);
                                syncKeys.add(new C2386h(synckeyjson.getString("Key"), synckeyjson.getString("Val")));
                            }
                            C2380c.m9070a().m9075a(syncKeys);
                        }
                    }
                    if (json.optInt("Count") > 0) {
                        List<C2376b> contacts = C2434b.m9303d(json.optJSONArray("ContactList"));
                        List chats = new ArrayList();
                        size = contacts.size();
                        for (i = 0; i < size; i++) {
                            C2376b contact = (C2376b) contacts.get(i);
                            if (!contact.m9066k() || contact.m9068m()) {
                                chats.add(new C2375a(contact, (long) (0 - i)));
                            }
                        }
                        C2398k.m9160a().m9178a(chats);
                    }
                    String chatSet = json.optString("ChatSet");
                    if (!TextUtils.isEmpty(chatSet)) {
                        for (String userName : chatSet.split(",")) {
                            if (userName.startsWith("@")) {
                                C2398k.m9160a().m9177a(userName);
                            }
                        }
                    }
                    cb.mo1868a();
                } catch (Exception e) {
                    e.printStackTrace();
                    cb.mo1869a(e.toString());
                }
            }
        };
        JSONObject postJson = new JSONObject();
        try {
            postJson.put("BaseRequest", C2380c.m9070a().m9089j());
        } catch (Exception e) {
            e.printStackTrace();
        }
        C2368c.m8995a(C2436c.m9312c(), resultCallback, C2434b.m9288a(postJson.toString()));
    }

    /* renamed from: a */
    public static void m9295a(String seq, final C2404b cb) {
        C2368c.m8994a(C2436c.m9315d(seq), new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                cb.mo1838a();
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                C2372c.m9030c("load contact response:");
                if (httpResult.m8961a().intValue() != 200) {
                    cb.mo1838a();
                    return;
                }
                try {
                    JSONObject json = new JSONObject(httpResult.m8965b());
                    C2372c.m9030c(json.getJSONObject("BaseResponse").toString());
                    if (json.getJSONObject("BaseResponse").getInt("Ret") != 0) {
                        cb.mo1838a();
                        return;
                    }
                    C2380c.m9070a().m9080b(C2434b.m9303d(json.optJSONArray("MemberList")));
                    cb.mo1839a(json.getString("Seq"));
                } catch (Exception e) {
                    e.printStackTrace();
                    cb.mo1838a();
                }
            }
        });
    }

    /* renamed from: a */
    public static void m9299a(List<C2376b> contacts, int start, final C2406a cb) {
        int size = contacts.size();
        if (start < 0 || start >= size) {
            cb.mo1841a(-1, null);
            return;
        }
        final int next = start + size;
        C2367c resultCallback = new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                cb.mo1840a(next);
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                C2372c.m9030c("load batch contact response:\n" + httpResult.m8965b());
                if (httpResult.m8961a().intValue() != 200) {
                    cb.mo1840a(next);
                    return;
                }
                try {
                    JSONObject json = new JSONObject(httpResult.m8965b());
                    C2372c.m9030c(json.getJSONObject("BaseResponse").toString());
                    if (json.getJSONObject("BaseResponse").getInt("Ret") != 0) {
                        cb.mo1840a(next);
                        return;
                    }
                    cb.mo1841a(next, C2434b.m9303d(json.optJSONArray("ContactList")));
                } catch (Exception e) {
                    e.printStackTrace();
                    cb.mo1840a(next);
                }
            }
        };
        JSONObject postJson = new JSONObject();
        try {
            postJson.put("BaseRequest", C2380c.m9070a().m9089j());
            postJson.put("Count", contacts.size());
            JSONArray jsonArray = new JSONArray();
            for (C2376b contact : contacts) {
                JSONObject json = new JSONObject();
                json.put("UserName", contact.m9052a());
                json.put("EncryChatRoomId", contact.m9063h());
                jsonArray.put(json);
            }
            postJson.put("List", jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C2368c.m8995a(C2436c.m9314d(), resultCallback, C2434b.m9288a(postJson.toString()));
    }

    /* renamed from: a */
    public static void m9298a(String toUserName, String content, final C2411f cb) {
        C2367c resultCallback = new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                cb.mo1843a(e.toString());
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                C2372c.m9030c("send msg response:\n" + httpResult.m8965b());
                if (httpResult.m8961a().intValue() != 200) {
                    cb.mo1843a("statusCode=" + httpResult.m8961a());
                    return;
                }
                try {
                    int ret = new JSONObject(httpResult.m8965b()).getJSONObject("BaseResponse").getInt("Ret");
                    if (ret == 0) {
                        cb.mo1842a();
                    } else if (ret == 1100 || ret == 1100) {
                        cb.mo1844b();
                    } else {
                        cb.mo1843a("ret=" + ret);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    cb.mo1843a(e.toString());
                }
            }
        };
        JSONObject postJson = new JSONObject();
        try {
            postJson.put("BaseRequest", C2380c.m9070a().m9089j());
            JSONObject msgJson = new JSONObject();
            msgJson.put("Type", "1");
            msgJson.put("Content", content);
            msgJson.put("FromUserName", C2380c.m9070a().m9084e());
            msgJson.put("ToUserName", toUserName);
            String msgId = C2499c.m9493a();
            msgJson.put("ClientMsgId", msgId);
            msgJson.put("LocalID", msgId);
            postJson.put("Msg", msgJson);
            postJson.put("Scene", "0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        C2368c.m8995a(C2436c.m9316e(), resultCallback, C2434b.m9288a(postJson.toString()));
    }

    /* renamed from: a */
    public static void m9291a(final C2400g cb) {
        C2368c.m8994a(C2436c.m9317f(), new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                C2372c.m9036e(new StringBuilder().append("sync check response onError:  ").append(e).toString() == null ? null : e.toString());
                if (e == null || !e.toString().contains("Canceled")) {
                    cb.mo1833c();
                } else {
                    cb.mo1834d();
                }
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                C2372c.m9030c("sync check response:\n" + httpResult.m8965b());
                if (httpResult.m8961a().intValue() != 200) {
                    cb.mo1833c();
                    return;
                }
                Matcher matcher = Pattern.compile("window.synccheck=\\{retcode:\"([0-9]+)\",selector:\"([0-9]+)\"\\}").matcher(httpResult.m8965b());
                int code = 0;
                int selector = 0;
                if (matcher.find()) {
                    code = Integer.valueOf(matcher.group(1)).intValue();
                    selector = Integer.valueOf(matcher.group(2)).intValue();
                }
                C2372c.m9030c("synccheck result： code = " + code + " ; selector = " + selector);
                if (code != 0) {
                    cb.mo1835e();
                } else if (selector != 0) {
                    cb.mo1831a();
                } else {
                    cb.mo1832b();
                }
            }
        });
    }

    /* renamed from: a */
    public static void m9294a(final C2402j cb) {
        C2367c resultCallback = new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                cb.mo1836a();
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                C2372c.m9030c("webwxSync response:\n" + httpResult.m8965b());
                if (httpResult.m8961a().intValue() != 200) {
                    cb.mo1836a();
                    return;
                }
                try {
                    JSONObject json = new JSONObject(httpResult.m8965b());
                    C2372c.m9030c("webwx Sync BaseResponse  : " + json.getJSONObject("BaseResponse").toString());
                    if (json.getJSONObject("BaseResponse").getInt("Ret") != 0) {
                        cb.mo1836a();
                        return;
                    }
                    JSONArray contactArray = json.getJSONArray("ModContactList");
                    if (contactArray != null && contactArray.length() > 0) {
                        C2398k.m9160a().m9184b(C2434b.m9303d(contactArray));
                    }
                    JSONObject skeyJson = json.optJSONObject("SyncKey");
                    if (skeyJson != null) {
                        JSONArray list = skeyJson.getJSONArray("List");
                        if (list != null && list.length() > 0) {
                            List syncKeys = new ArrayList();
                            int size = list.length();
                            for (int i = 0; i < size; i++) {
                                skeyJson = list.getJSONObject(i);
                                syncKeys.add(new C2386h(skeyJson.getString("Key"), skeyJson.getString("Val")));
                            }
                            C2380c.m9070a().m9075a(syncKeys);
                        }
                    }
                    List msgs;
                    if (json.optInt("AddMsgCount") > 0) {
                        msgs = C2434b.m9302c(json.optJSONArray("AddMsgList"));
                    } else {
                        msgs = new ArrayList();
                    }
                    List contacts = new ArrayList();
                    for (C2382d msg : msgs) {
                        if (msg.m9105g() == null) {
                            C2376b contact = new C2376b();
                            if (C2380c.m9070a().m9077a(msg.m9103e())) {
                                contact.m9053a(msg.m9102d());
                            } else {
                                contact.m9053a(msg.m9103e());
                            }
                            contacts.add(contact);
                        }
                    }
                    if (contacts.size() == 0) {
                        C2398k.m9160a().m9188c((List) msgs);
                        cb.mo1837a(msgs.size());
                        return;
                    }
                    C2372c.m9030c("收到消息，但发送者的信息未缓存，需重新查询.............");
                    C2434b.m9299a(contacts, 0, new C2406a(this) {
                        /* renamed from: b */
                        final /* synthetic */ AnonymousClass10 f7973b;

                        /* renamed from: a */
                        public void mo1841a(int next, List<C2376b> contacts) {
                            if (contacts != null) {
                                C2398k.m9160a().m9184b((List) contacts);
                            }
                            for (C2382d msg : msgs) {
                                if (msg.m9105g() == null) {
                                    if (C2380c.m9070a().m9077a(msg.m9103e())) {
                                        msg.m9096a(C2380c.m9070a().m9078b(msg.m9102d()));
                                    } else {
                                        msg.m9096a(C2380c.m9070a().m9078b(msg.m9103e()));
                                    }
                                }
                            }
                            C2398k.m9160a().m9188c(msgs);
                            cb.mo1837a(msgs.size());
                        }

                        /* renamed from: a */
                        public void mo1840a(int next) {
                            C2398k.m9160a().m9188c(msgs);
                            cb.mo1837a(msgs.size());
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    cb.mo1836a();
                }
            }
        };
        JSONObject postJson = new JSONObject();
        try {
            postJson.put("BaseRequest", C2380c.m9070a().m9089j());
            postJson.put("SyncKey", C2380c.m9070a().m9090k());
            postJson.put("rr", new Date().getTime() ^ -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C2368c.m8995a(C2436c.m9318g(), resultCallback, C2434b.m9288a(postJson.toString()));
    }

    /* renamed from: a */
    public static void m9290a(final C2430d cb) {
        C2367c resultCallback = new C2367c() {
            /* renamed from: a */
            public void mo1827a(Exception e) {
                cb.mo1871b();
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                if (httpResult.m8961a().intValue() != 200) {
                    cb.mo1871b();
                } else {
                    cb.mo1870a();
                }
            }
        };
        Map params = new HashMap();
        C2388j wechatCookie = C2380c.m9070a().m9086g();
        if (wechatCookie != null) {
            params.put("sid", wechatCookie.m9140b());
            params.put("uin", wechatCookie.m9142c());
        }
        C2368c.m8996a(C2436c.m9319h(), resultCallback, params);
    }

    /* renamed from: c */
    private static List<C2382d> m9302c(JSONArray array) throws JSONException {
        List<C2382d> msgs = new ArrayList();
        int len = array.length();
        for (int i = 0; i < len; i++) {
            C2382d msg = C2382d.m9092a(array.getJSONObject(i));
            if (msg != null && msg.m9113o()) {
                msgs.add(msg);
            }
        }
        return msgs;
    }

    /* renamed from: d */
    private static List<C2376b> m9303d(JSONArray array) {
        List<C2376b> contactList = new ArrayList();
        int size = array.length();
        for (int i = 0; i < size; i++) {
            C2376b contact = C2376b.m9050a(array.optJSONObject(i));
            if (!(contact == null || contact.m9065j())) {
                contactList.add(contact);
            }
        }
        return contactList;
    }

    /* renamed from: a */
    public static String m9288a(String str) {
        while (str.contains("\\")) {
            str = str.replace("\\", "");
        }
        return str;
    }
}
