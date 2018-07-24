package com.baidu.carlife.connect;

import android.os.Build.VERSION;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.view.dialog.FullScreenNoticeDialog;
import com.baidu.carlife.view.dialog.PushWebNoticeDialog;

/* compiled from: TemporaryCheckUtil */
/* renamed from: com.baidu.carlife.connect.a */
public class TemporaryCheckUtil {
    /* renamed from: a */
    private static boolean f2966a = false;

    /* renamed from: a */
    public static void m3872a() {
        if (TemporaryCheckUtil.m3875d()) {
            C2186p.m8304a().m8323c(CommonParams.jB, false);
        }
    }

    /* renamed from: b */
    public static void m3873b() {
        if (TemporaryCheckUtil.m3875d() && C2186p.m8304a().m8312a(CommonParams.jB, true) && !f2966a) {
            f2966a = true;
            CarlifeViewContainer.m4699a().showDialog(new FullScreenNoticeDialog(CarlifeViewContainer.m4699a().m4701b().mo1482e()));
        }
    }

    /* renamed from: d */
    private static boolean m3875d() {
        return VERSION.SDK_INT >= 24 && C2186p.m8304a().m8309a(CommonParams.jA, "20022100").equals("20022102");
    }

    /* renamed from: c */
    public static void m3874c() {
        CarlifeViewContainer.m4699a().showDialog(new PushWebNoticeDialog(CarlifeViewContainer.m4699a().m4701b().mo1482e()));
    }
}
