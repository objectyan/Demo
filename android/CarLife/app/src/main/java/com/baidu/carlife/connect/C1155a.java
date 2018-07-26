package com.baidu.carlife.connect;

import android.os.Build.VERSION;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.view.dialog.FullScreenNoticeDialog;
import com.baidu.carlife.view.dialog.PushWebNoticeDialog;

/* compiled from: TemporaryCheckUtil */
/* renamed from: com.baidu.carlife.connect.a */
public class C1155a {
    /* renamed from: a */
    private static boolean f2966a = false;

    /* renamed from: a */
    public static void m3872a() {
        if (C1155a.m3875d()) {
            C2186p.m8304a().m8323c(C1253f.jB, false);
        }
    }

    /* renamed from: b */
    public static void m3873b() {
        if (C1155a.m3875d() && C2186p.m8304a().m8312a(C1253f.jB, true) && !f2966a) {
            f2966a = true;
            C1309g.m4699a().showDialog(new FullScreenNoticeDialog(C1309g.m4699a().m4701b().mo1482e()));
        }
    }

    /* renamed from: d */
    private static boolean m3875d() {
        return VERSION.SDK_INT >= 24 && C2186p.m8304a().m8309a(C1253f.jA, "20022100").equals("20022102");
    }

    /* renamed from: c */
    public static void m3874c() {
        C1309g.m4699a().showDialog(new PushWebNoticeDialog(C1309g.m4699a().m4701b().mo1482e()));
    }
}
