package com.baidu.carlife.custom;

import android.os.Message;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1253f.C1252a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.protobuf.CarlifeGearInfoProto.CarlifeGearInfo;
import com.baidu.carlife.util.C2201w;

/* compiled from: YiQiFengTianCustom */
/* renamed from: com.baidu.carlife.custom.b */
public class C1343b {
    /* renamed from: a */
    private static final String f3937a = "yftech";
    /* renamed from: b */
    private static final String f3938b = "进入驾驶模式部分功能在停车后可操作";
    /* renamed from: c */
    private static C1343b f3939c = null;
    /* renamed from: d */
    private boolean f3940d = false;

    /* renamed from: a */
    public static C1343b m4932a() {
        if (f3939c == null) {
            synchronized (C1343b.class) {
                if (f3939c == null) {
                    f3939c = new C1343b();
                }
            }
        }
        return f3939c;
    }

    /* renamed from: a */
    public void m4933a(Message msg) {
        try {
            int gear = CarlifeGearInfo.parseFrom(msg.obj.m4205f()).getGear();
            switch (gear) {
                case 1:
                case 2:
                    if (C1328h.m4757a().getNaviFragmentManager() != null) {
                        C1328h.m4757a().getNaviFragmentManager().stopDriving();
                        return;
                    }
                    return;
                case 3:
                case 4:
                case 5:
                    if (C1328h.m4757a().getNaviFragmentManager() != null) {
                        this.f3940d = true;
                        C1328h.m4757a().getNaviFragmentManager().driving();
                        return;
                    }
                    return;
                default:
                    C1260i.m4435b(f3937a, "ERROR gear =  " + gear);
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        e.printStackTrace();
    }

    /* renamed from: b */
    public boolean m4935b() {
        if (C1253f.jx == C1252a.VEHICLE_CHANNEL_YIQIFENGTIAN_COROLLA_DA || C1253f.jx == C1252a.VEHICLE_CHANNEL_YIQIFENGTIAN_COROLLA_GSHV || C1253f.jx == C1252a.VEHICLE_CHANNEL_IZOA_PANASONIC) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void m4936c() {
        if (m4935b() && C1328h.m4757a().getNaviFragmentManager() != null) {
            C1328h.m4757a().getNaviFragmentManager().stopDriving();
        }
    }

    /* renamed from: a */
    public void m4934a(boolean status) {
        this.f3940d = status;
    }

    /* renamed from: d */
    public void m4937d() {
        C1260i.m4435b(f3937a, "showToast isShowToast =  " + this.f3940d);
        if (this.f3940d) {
            C2201w.m8373a(f3938b, 0);
            this.f3940d = false;
        }
    }
}
