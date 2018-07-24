package com.baidu.carlife.logic.codriver.adapter;

import android.os.Handler;
import android.os.Looper;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2201w;
import com.baidu.che.codriver.sdk.p081a.C1750o;
import com.baidu.che.codriver.sdk.p081a.C1750o.C2610a;
import com.baidu.che.codriver.vr.record.outside.OutsideRecordHelper;

/* compiled from: NormalVehicleRecordToolImpl */
/* renamed from: com.baidu.carlife.logic.codriver.adapter.c */
public class C1756c implements C1750o {
    /* renamed from: c */
    private static final String f5306c = "NormalVehicleRecord";
    /* renamed from: e */
    private static final int f5307e = 1024;
    /* renamed from: f */
    private static final int f5308f = 16;
    /* renamed from: g */
    private static final int f5309g = 1040;
    /* renamed from: d */
    private byte[] f5310d = new byte[5000];
    /* renamed from: h */
    private OutsideRecordHelper f5311h = new OutsideRecordHelper();

    /* compiled from: NormalVehicleRecordToolImpl */
    /* renamed from: com.baidu.carlife.logic.codriver.adapter.c$1 */
    class C17551 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1756c f5305a;

        C17551(C1756c this$0) {
            this.f5305a = this$0;
        }

        public void run() {
            C2201w.m8372a("---- get data too long!!!-");
        }
    }

    /* renamed from: a */
    public int mo1631a(byte[] inputData) {
        if (inputData == null || inputData.length == 0) {
            return -1;
        }
        int flag = C1663a.m5979a().m6033e(inputData, 12);
        if (flag == -1 || flag != 12) {
            LogUtil.m4445e(f5306c, "-- get data length failed");
            return -1;
        }
        int dataLength = ((((inputData[0] << 24) & -16777216) + ((inputData[1] << 16) & 16711680)) + ((inputData[2] << 8) & 65280)) + ((inputData[3] << 0) & 255);
        if (dataLength > inputData.length) {
            LogUtil.m4445e(f5306c, "---- get data too long!!!-len:" + dataLength);
            return -1;
        } else if (C1663a.m5979a().m6033e(inputData, dataLength) < 0) {
            LogUtil.m4445e(f5306c, "-- get data failed---");
            return -1;
        } else if (!C1663a.m5979a().m6001V() || dataLength <= 0) {
            return dataLength;
        } else {
            byte[] recData = C1663a.m5979a().m6040g(inputData, dataLength);
            if (recData == null) {
                LogUtil.m4445e(f5306c, "decrypt failed!");
                return -1;
            }
            dataLength = recData.length;
            System.arraycopy(recData, 0, inputData, 0, dataLength);
            return dataLength;
        }
    }

    /* renamed from: a */
    public void mo1633a(C2610a in) {
        LogUtil.d(f5306c, "record InputData");
        if (this.f5310d == null || this.f5310d.length == 0) {
            in.f8633a = null;
            return;
        }
        int flag = C1663a.m5979a().m6033e(this.f5310d, 12);
        if (flag == -1 || flag != 12) {
            LogUtil.m4445e(f5306c, "-- get data length failed");
            in.f8633a = null;
            in.f8634b = -1;
            return;
        }
        int dataLength = ((((this.f5310d[0] << 24) & -16777216) + ((this.f5310d[1] << 16) & 16711680)) + ((this.f5310d[2] << 8) & 65280)) + ((this.f5310d[3] << 0) & 255);
        if (dataLength > this.f5310d.length) {
            LogUtil.m4445e(f5306c, "---- get data too long!!!-len:" + dataLength);
            in.f8633a = null;
            in.f8634b = -1;
            new Handler(Looper.getMainLooper()).post(new C17551(this));
        } else if (C1663a.m5979a().m6033e(this.f5310d, dataLength) < 0) {
            LogUtil.m4445e(f5306c, "-- get data failed---");
            in.f8633a = null;
            in.f8634b = -1;
        } else if (C1663a.m5979a().m6001V()) {
            in.f8633a = C1663a.m5979a().m6040g(this.f5310d, dataLength);
            if (in.f8633a == null) {
                in.f8634b = -1;
            } else {
                in.f8634b = in.f8633a.length;
            }
        } else {
            in.f8633a = this.f5310d;
            in.f8634b = dataLength;
        }
    }

    /* renamed from: a */
    public void mo1632a() {
        LogUtil.d(f5306c, "startRecord");
        this.f5311h.startRecordForAsr(this);
    }

    /* renamed from: b */
    public void mo1634b() {
        LogUtil.d(f5306c, "endRecord");
        this.f5311h.release();
    }

    /* renamed from: c */
    public void mo1635c() {
        LogUtil.d(f5306c, "initRecorder");
        this.f5311h.reset();
    }
}
