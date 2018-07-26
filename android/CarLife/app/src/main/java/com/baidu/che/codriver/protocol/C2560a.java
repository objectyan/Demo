package com.baidu.che.codriver.protocol;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.che.codriver.p115a.C2505a;
import com.baidu.che.codriver.protocol.C2569e.C2568a;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2717d;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;

/* compiled from: APIConstants */
/* renamed from: com.baidu.che.codriver.protocol.a */
public class C2560a {
    /* renamed from: A */
    private static final String f8482A = "MDzBterNOpVZhq9S";
    /* renamed from: B */
    private static final String f8483B = "0123456789abcdef";
    /* renamed from: C */
    private static final String f8484C = "qkjXX1Msv4eNv8T5";
    /* renamed from: a */
    public static final String f8485a = "OTLMypNt9tKU60avOae9zHszuxSPEFyG";
    /* renamed from: b */
    public static final String f8486b = "http://api.map.baidu.com/";
    /* renamed from: c */
    private static final String f8487c = "https://vehicle.baidu.com/codriverapi";
    /* renamed from: d */
    private static final String f8488d = "http://sandbox.codriverapi.baidu.com/codriverapi";
    /* renamed from: e */
    private static final String f8489e = "http://10.52.185.183:8080/codriverapi";
    /* renamed from: f */
    private static final String f8490f = "https://vehicle.baidu.com/codriverapi";
    /* renamed from: g */
    private static final String f8491g = "https://ufosdk.baidu.com/?m=Index&a=postmsg";
    /* renamed from: h */
    private static final String f8492h = "https://ufosdk.baidu.com/?m=Index&a=postclientinfo";
    /* renamed from: i */
    private static final String f8493i = "http://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=217770&needFbtype=true";
    /* renamed from: j */
    private static final String f8494j = "https://vehicle.baidu.com/codriverapi/robokit";
    /* renamed from: k */
    private static final String f8495k = "https://vehicle.baidu.com/codriverapi/uniqueid";
    /* renamed from: l */
    private static final String f8496l = "https://vehicle.baidu.com/codriverapi/bootloading";
    /* renamed from: m */
    private static final String f8497m = "https://vehicle.baidu.com/codriverapi/orbitpostjson";
    /* renamed from: n */
    private static final String f8498n = "https://vehicle.baidu.com/codriverapi/api/userlogpost";
    /* renamed from: o */
    private static final String f8499o = "https://vehicle.baidu.com/codriverapi/scanloginv2";
    /* renamed from: p */
    private static final String f8500p = "http://10.52.185.183:8080/codriverapi/robokit";
    /* renamed from: q */
    private static final String f8501q = "http://10.52.185.183:8080/codriverapi/uniqueid";
    /* renamed from: r */
    private static final String f8502r = "http://10.52.185.183:8080/codriverapi/bootloading";
    /* renamed from: s */
    private static final String f8503s = "http://10.52.185.183:8080/codriverapi/orbitpostjson";
    /* renamed from: t */
    private static final String f8504t = "http://10.52.185.183:8080/codriverapi/api/userlogpost";
    /* renamed from: u */
    private static final String f8505u = "http://10.52.185.183:8080/codriverapi/scanloginv2";
    /* renamed from: v */
    private static final String f8506v = "123456";
    /* renamed from: w */
    private static final String f8507w = C2505a.m9513c();
    /* renamed from: x */
    private static final String f8508x = "123456";
    /* renamed from: y */
    private static final String f8509y = C2505a.m9514d();
    /* renamed from: z */
    private static final String f8510z = "1234567812345678";

    /* renamed from: a */
    public static String m9677a() {
        return f8494j;
    }

    /* renamed from: b */
    public static String m9679b() {
        return f8495k;
    }

    /* renamed from: c */
    public static String m9680c() {
        return f8496l;
    }

    /* renamed from: d */
    public static String m9681d() {
        return f8497m;
    }

    /* renamed from: e */
    public static String m9682e() {
        return f8498n;
    }

    /* renamed from: f */
    public static String m9683f() {
        return f8499o;
    }

    /* renamed from: g */
    public static String m9684g() {
        return "https://vehicle.baidu.com/codriverapi";
    }

    /* renamed from: h */
    public static String m9685h() {
        return f8491g;
    }

    /* renamed from: i */
    public static String m9686i() {
        return f8492h;
    }

    /* renamed from: j */
    public static String m9687j() {
        return f8493i;
    }

    /* renamed from: k */
    public static String m9688k() {
        return f8507w;
    }

    /* renamed from: l */
    public static String m9689l() {
        return f8509y;
    }

    /* renamed from: m */
    public static String m9690m() {
        if ("https://vehicle.baidu.com/codriverapi".equals(f8489e) || "https://vehicle.baidu.com/codriverapi".equals(f8488d)) {
            return f8510z;
        }
        return f8482A;
    }

    /* renamed from: n */
    public static String m9691n() {
        if ("https://vehicle.baidu.com/codriverapi".equals(f8489e) || "https://vehicle.baidu.com/codriverapi".equals(f8488d)) {
            return f8483B;
        }
        return f8484C;
    }

    /* renamed from: a */
    public static String m9678a(String query) {
        C2569e urlBuilder = new C2569e().m9697a(C2560a.m9677a());
        urlBuilder.m9698a("coordtype", "2");
        urlBuilder.m9698a("word", query);
        urlBuilder.m9698a("crd", LocationUtil.getInstance().getLongitude() + JNISearchConst.LAYER_ID_DIVIDER + LocationUtil.getInstance().getLatitude());
        urlBuilder.m9698a("av", C2716c.m10165k());
        urlBuilder.m9698a("ak", C2716c.m10166l());
        urlBuilder.m9698a(NaviStatConstants.K_NSC_KEY_SETTING_CAR_PLATE, C2716c.m10164j());
        if (!TextUtils.isEmpty(C2716c.m10168n())) {
            urlBuilder.m9698a("uuid", C2716c.m10168n());
        } else if (C2716c.m10169o()) {
            Toast.makeText(C2716c.m10141a(), "uuid is empty", 0).show();
        }
        urlBuilder.m9698a("pn", C2716c.m10157e());
        if (!TextUtils.isEmpty(C2716c.m10167m())) {
            urlBuilder.m9698a("ext", C2716c.m10167m());
        }
        urlBuilder.m9698a("sign", C2717d.m10177a(C2560a.m9688k() + urlBuilder.m9702c() + C2560a.m9689l()));
        String url = null;
        try {
            url = urlBuilder.m9701b();
        } catch (C2568a e) {
            C2725h.m10213d("NLP", "Config url exception!!!!", e);
        }
        C2725h.m10207b("NLP: ", url);
        return url;
    }
}
