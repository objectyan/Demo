package com.baidu.carlife.wechat.p110e;

import android.text.TextUtils;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p108b.C2388j;
import com.baidu.carlife.wechat.p113g.C2499c;
import java.net.URLEncoder;

/* compiled from: WechatUrl */
/* renamed from: com.baidu.carlife.wechat.e.c */
public final class C2436c {

    /* compiled from: WechatUrl */
    /* renamed from: com.baidu.carlife.wechat.e.c$a */
    static final class C2435a {
        /* renamed from: a */
        public static final String f7985a = "wx.qq.com";
        /* renamed from: b */
        static String f7986b = f7985a;

        C2435a() {
        }

        /* renamed from: a */
        static String m9304a() {
            return f7986b;
        }

        /* renamed from: b */
        static String m9305b() {
            return "login." + C2435a.m9304a();
        }

        /* renamed from: c */
        static String m9306c() {
            return "file." + C2435a.m9304a();
        }

        /* renamed from: d */
        static String m9307d() {
            return "webpush." + C2435a.m9304a();
        }
    }

    /* renamed from: a */
    public static void m9308a() {
        C2435a.f7986b = C2435a.f7985a;
    }

    /* renamed from: a */
    public static void m9309a(String host) {
        if (!TextUtils.isEmpty(host)) {
            C2435a.f7986b = host;
        }
    }

    /* renamed from: k */
    private static String m9322k() {
        try {
            return URLEncoder.encode("https://" + C2435a.m9304a() + "/cgi-bin/mmwebwx-bin/webwxnewloginpage", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "https%3A%2F%2F" + C2435a.m9304a() + "%2Fcgi-bin%2Fmmwebwx-bin%2Fwebwxnewloginpage";
        }
    }

    /* renamed from: b */
    public static final String m9310b() {
        return ("https://" + C2435a.m9305b() + "/jslogin?appid=wx782c26e4c19acffb&redirect_uri=" + C2436c.m9322k() + "&fun=new&lang=zh_CN&_={timestamp}").replace("{timestamp}", String.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: b */
    public static final String m9311b(String uuid) {
        return "https://login.weixin.qq.com/l/" + uuid;
    }

    /* renamed from: c */
    public static final String m9313c(String uuid) {
        return ("https://" + C2435a.m9305b() + "/cgi-bin/mmwebwx-bin/login?loginicon=true&uuid={uuid}&tip=0&r={r}&_={timestamp}").replace("{uuid}", uuid).replace("{r}", String.valueOf(System.currentTimeMillis() ^ -1)).replace("{timestamp}", String.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: c */
    public static final String m9312c() {
        String url = "https://" + C2435a.m9304a() + "/cgi-bin/mmwebwx-bin/webwxinit?r={r}&lang={lang}&pass_ticket={pass_ticket}";
        C2388j wechatCookie = C2380c.m9070a().m9086g();
        return url.replace("{pass_ticket}", wechatCookie.m9148f()).replace("{r}", String.valueOf(System.currentTimeMillis() ^ -1)).replace("{lang}", wechatCookie.m9150g());
    }

    /* renamed from: d */
    public static final String m9315d(String seq) {
        String url = "https://" + C2435a.m9304a() + "/cgi-bin/mmwebwx-bin/webwxgetcontact?r={timestamp}&seq={seq}&skey={skey}&pass_ticket={pass_ticket}&lang={lang}";
        C2388j wechatCookie = C2380c.m9070a().m9086g();
        return url.replace("{pass_ticket}", wechatCookie.m9148f()).replace("{timestamp}", String.valueOf(System.currentTimeMillis())).replace("{skey}", wechatCookie.m9138a()).replace("{seq}", seq).replace("{lang}", wechatCookie.m9150g());
    }

    /* renamed from: d */
    public static final String m9314d() {
        return ("https://" + C2435a.m9304a() + "/cgi-bin/mmwebwx-bin/webwxbatchgetcontact?r={timestamp}&type=ex").replace("{timestamp}", String.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: e */
    public static final String m9316e() {
        String url = "https://" + C2435a.m9304a() + "/cgi-bin/mmwebwx-bin/webwxsendmsg?lang={lang}&pass_ticket={pass_ticket}";
        C2388j wechatCookie = C2380c.m9070a().m9086g();
        return url.replace("{pass_ticket}", wechatCookie.m9148f()).replace("{lang}", wechatCookie.m9150g());
    }

    /* renamed from: f */
    public static final String m9317f() {
        String url = "https://" + C2435a.m9307d() + "/cgi-bin/mmwebwx-bin/synccheck?r={r}&skey={skey}&sid={sid}&uin={uin}&deviceid={deviceid}&synckey={synckey}&_={timestamp}";
        C2388j wechatCookie = C2380c.m9070a().m9086g();
        return url.replace("{r}", String.valueOf(System.currentTimeMillis() ^ -1)).replace("{skey}", wechatCookie.m9138a()).replace("{sid}", wechatCookie.m9140b().replaceAll("\\+", "%2B")).replace("{uin}", wechatCookie.m9142c()).replace("{deviceid}", C2499c.m9501b()).replace("{synckey}", C2380c.m9070a().m9091l()).replace("{timestamp}", String.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: g */
    public static final String m9318g() {
        String url = "https://" + C2435a.m9304a() + "/cgi-bin/mmwebwx-bin/webwxsync?skey={skey}&sid={sid}&pass_ticket={pass_ticket}&lang={lang}";
        C2388j wechatCookie = C2380c.m9070a().m9086g();
        return url.replace("{skey}", wechatCookie.m9138a()).replace("{sid}", wechatCookie.m9140b().replaceAll("\\+", "%2B")).replace("{pass_ticket}", wechatCookie.m9148f()).replace("{lang}", wechatCookie.m9150g());
    }

    /* renamed from: h */
    public static final String m9319h() {
        return ("https://" + C2435a.m9304a() + "/cgi-bin/mmwebwx-bin/webwxlogout?redirect=1&type=0&skey={skey}").replace("{skey}", C2380c.m9070a().m9086g().m9138a());
    }

    /* renamed from: i */
    public static final String m9320i() {
        return "https://" + C2435a.m9304a();
    }

    /* renamed from: j */
    public static final String m9321j() {
        return "https://" + C2435a.m9304a();
    }
}
