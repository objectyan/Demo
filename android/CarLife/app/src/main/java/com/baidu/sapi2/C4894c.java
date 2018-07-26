package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.sapi2.utils.C4923f;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SapiOptions */
/* renamed from: com.baidu.sapi2.c */
final class C4894c {
    /* renamed from: a */
    private static final String f20430a = "fast_reg_sms_num";
    /* renamed from: b */
    private static final String f20431b = "global_share_strategy";
    /* renamed from: c */
    private static final String f20432c = "specific_share_strategy";
    /* renamed from: d */
    private static final String f20433d = "authorized_packages";
    /* renamed from: e */
    private static final String f20434e = "authorized_domains";
    /* renamed from: f */
    private static final String f20435f = "cache";
    /* renamed from: g */
    private static final String f20436g = "enabled";
    /* renamed from: h */
    private static final String f20437h = "modules";
    /* renamed from: i */
    private static final String f20438i = "id";
    /* renamed from: j */
    private static final String f20439j = "download_url";
    /* renamed from: k */
    private static final String f20440k = "hash";
    /* renamed from: l */
    private C4893a f20441l = new C4893a();
    /* renamed from: m */
    private String f20442m = C4923f.f20615t;
    /* renamed from: n */
    private LoginShareStrategy f20443n;
    /* renamed from: o */
    private Map<String, LoginShareStrategy> f20444o = new HashMap();
    /* renamed from: p */
    private Map<String, String> f20445p = new HashMap();
    /* renamed from: q */
    private List<String> f20446q = new ArrayList();

    /* compiled from: SapiOptions */
    /* renamed from: com.baidu.sapi2.c$a */
    public static class C4893a {
        /* renamed from: a */
        private static final String f20427a = ".BD_SAPI_CACHE";
        /* renamed from: b */
        private boolean f20428b = true;
        /* renamed from: c */
        private List<C4892a> f20429c = new ArrayList();

        /* compiled from: SapiOptions */
        /* renamed from: com.baidu.sapi2.c$a$a */
        public static class C4892a {
            /* renamed from: a */
            public String f20424a;
            /* renamed from: b */
            public String f20425b;
            /* renamed from: c */
            public String f20426c;

            /* renamed from: a */
            JSONObject m16305a() {
                JSONObject object = new JSONObject();
                try {
                    object.put("id", this.f20424a);
                    object.put(C4894c.f20439j, this.f20425b);
                    object.put(C4894c.f20440k, this.f20426c);
                    return object;
                } catch (Throwable th) {
                    return null;
                }
            }

            /* renamed from: a */
            static C4892a m16301a(JSONObject object) {
                C4892a module = new C4892a();
                module.f20424a = object.optString("id");
                module.f20425b = object.optString(C4894c.f20439j);
                module.f20426c = object.optString(C4894c.f20440k);
                return module;
            }

            /* renamed from: a */
            public static String m16302a(String id) {
                return C4892a.m16303b(id).replace('/', '-');
            }

            /* renamed from: b */
            public static String m16303b(String id) {
                return id.replace(':', '/');
            }

            /* renamed from: c */
            public static String m16304c(String id) {
                return ".BD_SAPI_CACHE/" + C4892a.m16303b(id);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                return this.f20424a.equals(((C4892a) o).f20424a);
            }

            public int hashCode() {
                return this.f20424a.hashCode();
            }
        }

        /* renamed from: a */
        public boolean m16307a() {
            return this.f20428b;
        }

        /* renamed from: b */
        public List<C4892a> m16308b() {
            return this.f20429c;
        }

        /* renamed from: c */
        JSONObject m16309c() {
            JSONObject object = new JSONObject();
            try {
                object.put("enabled", this.f20428b);
                JSONArray array = new JSONArray();
                for (C4892a module : m16308b()) {
                    array.put(module.m16305a());
                }
                object.put(C4894c.f20437h, array);
                return object;
            } catch (Throwable th) {
                return null;
            }
        }

        /* renamed from: a */
        static C4893a m16306a(JSONObject object) {
            C4893a cache = new C4893a();
            if (object != null) {
                try {
                    cache.f20428b = object.optBoolean("enabled", true);
                    JSONArray array = object.optJSONArray(C4894c.f20437h);
                    for (int i = 0; i < array.length(); i++) {
                        cache.m16308b().add(C4892a.m16301a(array.getJSONObject(i)));
                    }
                } catch (Throwable th) {
                }
            }
            return cache;
        }
    }

    /* renamed from: a */
    public String m16314a() {
        return this.f20442m;
    }

    /* renamed from: b */
    public LoginShareStrategy m16315b() {
        return this.f20443n;
    }

    /* renamed from: c */
    public Map<String, LoginShareStrategy> m16316c() {
        return this.f20444o;
    }

    /* renamed from: d */
    public Map<String, String> m16317d() {
        if (this.f20445p.isEmpty()) {
            return C4894c.m16311h();
        }
        return this.f20445p;
    }

    /* renamed from: e */
    public List<String> m16318e() {
        if (this.f20446q.isEmpty()) {
            return C4894c.m16313j();
        }
        return this.f20446q;
    }

    /* renamed from: f */
    public C4893a m16319f() {
        return this.f20441l;
    }

    /* renamed from: g */
    public String m16320g() {
        JSONObject json = new JSONObject();
        try {
            json.put("cache", this.f20441l.m16309c());
            json.put(f20430a, this.f20442m);
            if (this.f20443n != null) {
                json.put(f20431b, this.f20443n.getStrValue());
            }
            JSONObject obj = new JSONObject();
            for (Entry<String, LoginShareStrategy> entry : this.f20444o.entrySet()) {
                obj.put((String) entry.getKey(), ((LoginShareStrategy) entry.getValue()).getStrValue());
            }
            json.put(f20432c, obj);
            obj = new JSONObject();
            for (Entry<String, String> entry2 : this.f20445p.entrySet()) {
                obj.put((String) entry2.getKey(), entry2.getValue());
            }
            json.put(f20433d, obj);
            JSONArray array = new JSONArray();
            for (String domain : this.f20446q) {
                array.put(domain);
            }
            json.put(f20434e, array);
            return json.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    public static C4894c m16310a(JSONObject jsonObject) {
        Iterator iterator;
        C4894c options = new C4894c();
        options.f20441l = C4893a.m16306a(jsonObject.optJSONObject("cache"));
        options.f20442m = jsonObject.optString(f20430a, C4923f.f20615t);
        String strategyStr = jsonObject.optString(f20431b);
        if (!TextUtils.isEmpty(strategyStr)) {
            options.f20443n = LoginShareStrategy.mapStrToValue(strategyStr);
        }
        JSONObject obj = jsonObject.optJSONObject(f20432c);
        if (obj != null) {
            iterator = obj.keys();
            while (iterator.hasNext()) {
                String tpl = (String) iterator.next();
                options.f20444o.put(tpl, LoginShareStrategy.mapStrToValue(obj.optString(tpl)));
            }
        }
        obj = jsonObject.optJSONObject(f20433d);
        if (obj != null) {
            iterator = obj.keys();
            while (iterator.hasNext()) {
                String packageName = (String) iterator.next();
                String packageSign = obj.optString(packageName);
                if (!(TextUtils.isEmpty(packageName) || TextUtils.isEmpty(packageSign))) {
                    options.f20445p.put(packageName, packageSign);
                }
            }
        }
        JSONArray array = jsonObject.optJSONArray(f20434e);
        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                if (!TextUtils.isEmpty(array.optString(i))) {
                    options.f20446q.add(array.optString(i));
                }
            }
        }
        return options;
    }

    /* renamed from: h */
    static Map<String, String> m16311h() {
        Map<String, String> initialAuthorizedPackages = new HashMap();
        initialAuthorizedPackages.put("com.baidu.sapi2.(.*)", "de308d7973b5171883333a97253327e4");
        initialAuthorizedPackages.put("com.baidu.tieba(.*)", "673004cf2f6efdec2385c8116c1e8c14");
        initialAuthorizedPackages.put("com.baidu.searchbox(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
        initialAuthorizedPackages.put("com.baidu.appsearch", "c2b0b497d0389e6de1505e7fd8f4d539");
        initialAuthorizedPackages.put("com.baidu.(.*)input(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
        initialAuthorizedPackages.put("com.baidu.BaiduMap(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
        initialAuthorizedPackages.put("com.baidu.browser.(.+)", "c2b0b497d0389e6de1505e7fd8f4d539");
        initialAuthorizedPackages.put("com.baidu.iknow", "13a0a8019be4015ed20e075d824f1696");
        initialAuthorizedPackages.put("com.baidu.yuedu", "13a0a8019be4015ed20e075d824f1696");
        initialAuthorizedPackages.put("com.baidu.homework", "13a0a8019be4015ed20e075d824f1696");
        initialAuthorizedPackages.put("com.baidu.wenku", "13a0a8019be4015ed20e075d824f1696");
        initialAuthorizedPackages.put("com.baidu.mbaby", "13a0a8019be4015ed20e075d824f1696");
        initialAuthorizedPackages.put(PlatformConstants.BAIDU_NAVI_PACKAGE_NAME, "0586742e88a2e6a19e996598ec336b61");
        initialAuthorizedPackages.put("com.baidu.travel", "0586742e88a2e6a19e996598ec336b61");
        initialAuthorizedPackages.put("com.baidu.baidulife", "0586742e88a2e6a19e996598ec336b61");
        initialAuthorizedPackages.put("com.ting.mp3.android", "0586742e88a2e6a19e996598ec336b61");
        initialAuthorizedPackages.put("com.baidu.news(.*)", "0586742e88a2e6a19e996598ec336b61");
        initialAuthorizedPackages.put("com.baidu.video", "0586742e88a2e6a19e996598ec336b61");
        initialAuthorizedPackages.put("com.baidu.hao123(.*)", "7fd3727852d29eb6f4283988dc0d6150");
        initialAuthorizedPackages.put("com.baidu.netdisk(.*)", "ae5821440fab5e1a61a025f014bd8972");
        initialAuthorizedPackages.put("com.baidu.music.lebo", "b1d67a31136599143c5c38879728dcfd");
        initialAuthorizedPackages.put("com.hiapk.marketpho", "d46053ef4381d35cb774eb632d8e8aec");
        initialAuthorizedPackages.put("com.baidu.gamecenter(.*)", "bddf74f2473eb1802fe13fe3e1aab81a");
        initialAuthorizedPackages.put("com.baidu.notes", "989d3c446cadade24c8c57a10fe6370d");
        initialAuthorizedPackages.put("com.baidu.lifenote", "c1a65e392e3892db0935d22f6c20b9cc");
        initialAuthorizedPackages.put("com.baidu.passport.securitycenter", "db97d206640d7aca6d75975b3c1f6e87");
        initialAuthorizedPackages.put("com.nuomi", "59215ee95c063ff2c56226581a62130a");
        initialAuthorizedPackages.put("com.baidu.shucheng91", "2090b2ef3011c12d851ed125c2360954");
        initialAuthorizedPackages.put("com.duoku.gamesearch", "153a76549eb514258b5806f95da02bb3");
        initialAuthorizedPackages.put("com.baidu.qingpai", "80344917d9e7cf0fd8a8914cc918e0ef");
        initialAuthorizedPackages.put("cn.jingling.motu.photowonder", "6930f0bd9fa461c2cd65e216acee0118");
        initialAuthorizedPackages.put("com.baidu.account", "fe3c74f0431ea0dc303a10b6af6470fc");
        initialAuthorizedPackages.put("com.duoku.game.helper", "6231a79a3f43cdd01797eb5febbc6350");
        initialAuthorizedPackages.put("com.dragon.android.pandaspace", "5b120e96b20f5b4ec695d79b20d18753");
        initialAuthorizedPackages.put("com.baidu.addressugc", "9e2a7cde67d36c1e6a01bb070fc8ef7b");
        initialAuthorizedPackages.put("cn.opda.a.phonoalbumshoushou", "310a4f78e839b86df7731c2f48fcadae");
        initialAuthorizedPackages.put("com.baidu.fb", "a4622402640f20dfda894cbe2edf8823");
        initialAuthorizedPackages.put("com.baidu.baidutranslate", "0586742e88a2e6a19e996598ec336b61");
        initialAuthorizedPackages.put("com.baidu.lbs.waimai", "77ad7ac419a031af0252422152c62e67");
        initialAuthorizedPackages.put("com.baidu.lottery", "6e45686dd05db2374b0a600c7f28c0c4");
        initialAuthorizedPackages.put("com.baidu.doctor", "49c95b74699e358ffe67f5daacab3d48");
        initialAuthorizedPackages.put("com.baidu.patient", "49c95b74699e358ffe67f5daacab3d48");
        initialAuthorizedPackages.put("com.baidu.baidumovie", "645c143e25f34e076bcee9600b30e4c2");
        initialAuthorizedPackages.put("com.baidu.bdg.skyeye", "544f0f4a82864fbf7b9663fbc80437bb");
        initialAuthorizedPackages.put("com.zongheng.reader(.*)", "b9c43ba43f1e150d4f1670ae09a89a7f");
        initialAuthorizedPackages.put("com.baidu.doctor.doctorask", "13a0a8019be4015ed20e075d824f1696");
        initialAuthorizedPackages.put("com.baidu.k12edu", "610d60c69d2adf4b57fc6c2ec83fecbf");
        initialAuthorizedPackages.put("com.baidu.zuowen", "fa6b26072965ee3f372da85ca69b7b99");
        initialAuthorizedPackages.put("com.baidu.wallet", "de74282b18c0847e64b2b3f0ebbfe0a0");
        initialAuthorizedPackages.put("com.baidu.clouda.mobile.crm", "561e009b4a1f97012bf90dfed6c054d5");
        initialAuthorizedPackages.put("com.baidu.wear.app", "73a9573a74d219b8cf3066316d0b330c");
        initialAuthorizedPackages.put("com.dianxinos.optimizer.channel", "bd3df198d50f0dafa3c5804d342d3698");
        initialAuthorizedPackages.put("com.baidu.lbs.bus", "3d96c8b0be8fd5b1db754b8dbb73f23e");
        initialAuthorizedPackages.put("com.baidu.hui", "3102ce07daa9cb7c8d62c82fdc61c0ba");
        initialAuthorizedPackages.put("com.baidu.image", "ff934173c55f54a81d9c5da216263479");
        initialAuthorizedPackages.put("com.baidu.vip", "a00a833bf8afe07172262db3ccb3a5c5");
        initialAuthorizedPackages.put("com.baidu.mami", "86743dc804add1dd5f3a81a5818ead58");
        initialAuthorizedPackages.put("com.baidu.faceu", "a140a3b0775361c459fc751c50e98d77");
        initialAuthorizedPackages.put("com.baidu.movie", "0586742e88a2e6a19e996598ec336b61");
        return initialAuthorizedPackages;
    }

    /* renamed from: i */
    static Map<String, Integer> m16312i() {
        Map<String, Integer> orderAuthorizedPackages = new HashMap();
        orderAuthorizedPackages.put("com.baidu.wallet", Integer.valueOf(1));
        orderAuthorizedPackages.put("com.nuomi", Integer.valueOf(2));
        orderAuthorizedPackages.put("com.baidu.lbs.waimai", Integer.valueOf(3));
        orderAuthorizedPackages.put("com.baidu.searchbox(.*)", Integer.valueOf(4));
        orderAuthorizedPackages.put("com.baidu.BaiduMap(.*)", Integer.valueOf(5));
        orderAuthorizedPackages.put("com.baidu.tieba(.*)", Integer.valueOf(6));
        orderAuthorizedPackages.put("com.baidu.netdisk(.*)", Integer.valueOf(7));
        orderAuthorizedPackages.put("com.baidu.appsearch", Integer.valueOf(8));
        return orderAuthorizedPackages;
    }

    /* renamed from: j */
    static List<String> m16313j() {
        List<String> authorizedDomains = new ArrayList();
        authorizedDomains.add("baidu.com");
        authorizedDomains.add("hao123.com");
        authorizedDomains.add("nuomi.com");
        return authorizedDomains;
    }
}
