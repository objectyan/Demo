package com.baidu.carlife.custom;

import android.os.Message;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1253f.C1252a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.protobuf.CarlifeGearInfoProto.CarlifeGearInfo;
import com.baidu.carlife.util.C2201w;

/* compiled from: GuangFengCustom */
/* renamed from: com.baidu.carlife.custom.a */
public class C1342a {
    /* renamed from: a */
    private static final String f3933a = "yftech";
    /* renamed from: b */
    private static final String f3934b = "进入驾驶模式部分功能在停车后可操作";
    /* renamed from: c */
    private static C1342a f3935c = null;
    /* renamed from: d */
    private boolean f3936d = false;

    /* renamed from: a */
    public static C1342a m4926a() {
        if (f3935c == null) {
            synchronized (C1342a.class) {
                if (f3935c == null) {
                    f3935c = new C1342a();
                }
            }
        }
        return f3935c;
    }

    /* renamed from: a */
    public void m4927a(Message msg) {
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
                        this.f3936d = true;
                        C1328h.m4757a().getNaviFragmentManager().driving();
                        return;
                    }
                    return;
                default:
                    C1260i.m4435b(f3933a, "ERROR gear =  " + gear);
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        e.printStackTrace();
    }

    /* renamed from: b */
    public boolean m4929b() {
        if (C1253f.jx == C1252a.VEHICLE_CHANNEL_GUANGFENG_LEVIN || C1253f.jx == C1252a.VEHICLE_CHANNEL_GUANGFENG_AVN || C1253f.jx == C1252a.VEHICLE_CHANNEL_GUANGFENG_HIGHLANDER || C1253f.jx == C1252a.VEHICLE_CHANNEL_GUANGFENG_LEVIN_PHV) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void m4930c() {
        if (m4929b() && C1328h.m4757a().getNaviFragmentManager() != null) {
            C1328h.m4757a().getNaviFragmentManager().stopDriving();
        }
    }

    /* renamed from: a */
    public void m4928a(boolean status) {
        this.f3936d = status;
    }

    /* renamed from: d */
    public void m4931d() {
        C1260i.m4435b(f3933a, "showToast isShowToast =  " + this.f3936d);
        if (this.f3936d) {
            C2201w.m8373a(f3934b, 0);
            this.f3936d = false;
        }
    }
}
