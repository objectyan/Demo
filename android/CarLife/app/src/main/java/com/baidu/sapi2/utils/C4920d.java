package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.baidu.sapi2.C4891b;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.C4922e.C4921a;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: SapiDeviceInfo */
/* renamed from: com.baidu.sapi2.utils.d */
public class C4920d {
    /* renamed from: a */
    private static final int f20542a = 4;
    /* renamed from: b */
    private static final String f20543b = Character.toString('\u0001');
    /* renamed from: c */
    private static final String f20544c = "android";
    /* renamed from: d */
    private static final String f20545d = TextUtils.join("", new String[]{"O", Config.APP_VERSION_CODE, "L", "h", MapObjKey.OBJ_SS_ARROW_Z, "O", "K", "T", "T", "Q", "G", "L", Config.DEVICE_WIDTH, NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL, "h", "P"});

    /* renamed from: a */
    static String m16397a() {
        return !TextUtils.isEmpty(VERSION.RELEASE) ? VERSION.RELEASE : "";
    }

    /* renamed from: b */
    static String m16399b() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
    }

    /* renamed from: c */
    static List<String> m16401c() {
        List<SapiAccount> shareAccountList = SapiAccountManager.getInstance().getShareAccounts();
        List<String> shareUidList = new ArrayList();
        for (SapiAccount account : shareAccountList) {
            shareUidList.add(account.uid);
        }
        return shareUidList;
    }

    /* renamed from: a */
    static List<String> m16398a(String situation) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        List<String> tokens = new ArrayList();
        tokens.add(context.getPackageName());
        tokens.add(SapiUtils.getVersionName(context));
        tokens.add(SapiAccountManager.VERSION_NAME);
        tokens.add(C4920d.m16399b());
        tokens.add(C4920d.m16397a());
        tokens.add(f20544c);
        tokens.add(SapiUtils.getClientId(context));
        tokens.add(SapiAccountManager.getInstance().getSapiConfiguration().tpl);
        tokens.add(String.valueOf(SapiAccountManager.getInstance().getShareAccounts().size()));
        tokens.add(TextUtils.join(",", C4920d.m16401c()));
        if (situation == null) {
            situation = "";
        }
        tokens.add(situation);
        tokens.add(String.valueOf(C4891b.m16250a(context).m16299u()));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        tokens.add(session != null ? session.uid : "");
        tokens.add(SapiUtils.getNetworkClass(context));
        String rootStatus = C4891b.m16250a(context).m16300v();
        if (TextUtils.isEmpty(rootStatus)) {
            rootStatus = String.valueOf(SapiUtils.isRoot());
            C4891b.m16250a(context).m16283e(rootStatus);
        }
        tokens.add(rootStatus);
        tokens.add(SapiUtils.getWifiInfo(context));
        return tokens;
    }

    /* renamed from: d */
    static String m16402d() {
        return String.format("%02d", new Object[]{Integer.valueOf(new Random().nextInt(100))}) + (System.currentTimeMillis() / 1000) + String.format("%03d", new Object[]{Integer.valueOf(4)}) + "0";
    }

    /* renamed from: b */
    public static String m16400b(String situation) {
        try {
            String encryptInfo = C4921a.m16407b(new C4917a().m16392a(TextUtils.join(f20543b, C4920d.m16398a(situation)), C4920d.m16402d(), f20545d));
            String check = MD5Util.toMd5(TextUtils.join(JNISearchConst.LAYER_ID_DIVIDER, new String[]{iv, encryptInfo, "check"}).getBytes(), false);
            return TextUtils.join(JNISearchConst.LAYER_ID_DIVIDER, new String[]{iv, encryptInfo, check.substring(0, 6)});
        } catch (Throwable e) {
            C4913L.m16374e(e);
            return "";
        }
    }
}
