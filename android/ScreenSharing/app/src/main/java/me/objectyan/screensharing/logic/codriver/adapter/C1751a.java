package com.baidu.carlife.logic.codriver.adapter;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.che.codriver.sdk.p081a.C1750o;
import com.baidu.che.codriver.sdk.p081a.C1750o.C2610a;
import com.baidu.che.codriver.vr.record.aec.C2858a;

/* compiled from: AecVehicleRecordToolImpl */
/* renamed from: com.baidu.carlife.logic.codriver.adapter.a */
public class C1751a implements C1750o {
    /* renamed from: c */
    private static final String f5294c = "AecVehicleRecord";
    /* renamed from: d */
    private static final int f5295d = 2560;
    /* renamed from: e */
    private static final int f5296e = 5120;
    /* renamed from: f */
    private static final int f5297f = 16;
    /* renamed from: g */
    private static final int f5298g = 5136;
    /* renamed from: h */
    private boolean f5299h;
    /* renamed from: i */
    private byte[] f5300i;

    public C1751a(boolean isMicInLeftChannel) {
        this.f5299h = isMicInLeftChannel;
        if (C1663a.m5979a().m6001V()) {
            this.f5300i = new byte[f5298g];
        } else {
            this.f5300i = new byte[5120];
        }
        C2858a.m10812a();
    }

    /* renamed from: a */
    public void mo1633a(C2610a in) {
        if (this.f5300i == null || this.f5300i.length == 0) {
            in.f8633a = null;
            in.f8634b = -1;
            C2858a.m10817b();
            return;
        }
        int flag = C1663a.m5979a().m6033e(this.f5300i, 12);
        if (flag == -1 || flag != 12) {
            LogUtil.m4445e(f5294c, "-- get data length failed");
            in.f8633a = null;
            in.f8634b = -1;
            C2858a.m10817b();
            return;
        }
        int dataLength = ((((this.f5300i[0] << 24) & -16777216) + ((this.f5300i[1] << 16) & 16711680)) + ((this.f5300i[2] << 8) & 65280)) + ((this.f5300i[3] << 0) & 255);
        if (dataLength != this.f5300i.length) {
            LogUtil.m4445e(f5294c, "---- get data error!!!-len:" + dataLength);
            in.f8633a = null;
            in.f8634b = -1;
            C2858a.m10817b();
        } else if (C1663a.m5979a().m6033e(this.f5300i, dataLength) < 0) {
            LogUtil.m4445e(f5294c, "-- get data failed---");
            in.f8633a = null;
            in.f8634b = -1;
            C2858a.m10817b();
        } else {
            LogUtil.d(f5294c, "- get data OK!!-dataLength:" + dataLength);
            if (C1663a.m5979a().m6001V()) {
                if (C1663a.m5979a().m6040g(this.f5300i, dataLength) == null) {
                    LogUtil.m4445e(f5294c, "decrypt failed!");
                    in.f8633a = null;
                    in.f8634b = -1;
                    C2858a.m10817b();
                }
                in.f8634b = 2560;
                return;
            }
            in.f8634b = 2560;
        }
    }

    /* renamed from: a */
    public int mo1631a(byte[] bytes) {
        return 0;
    }

    /* renamed from: a */
    public void mo1632a() {
    }

    /* renamed from: b */
    public void mo1634b() {
    }

    /* renamed from: c */
    public void mo1635c() {
    }
}
