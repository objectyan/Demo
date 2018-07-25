package com.baidu.carlife.logic;

import android.os.Message;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion.Builder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CarlifeProtocolVersionInfoManager */
/* renamed from: com.baidu.carlife.logic.d */
public class C1757d {
    /* renamed from: a */
    public static final String f5312a = "CarlifeProtocolInfoManager";
    /* renamed from: b */
    private static C1757d f5313b = null;
    /* renamed from: c */
    private static CarlifeProtocolVersion f5314c = null;
    /* renamed from: d */
    private static CarlifeProtocolVersion f5315d = null;
    /* renamed from: e */
    private static CarlifeProtocolVersion f5316e = null;
    /* renamed from: f */
    private static CarlifeProtocolVersion f5317f = null;
    /* renamed from: g */
    private static CarlifeProtocolVersionMatchStatus f5318g = null;
    /* renamed from: h */
    private static List<CarlifeProtocolVersion> f5319h = new ArrayList();

    private C1757d() {
    }

    /* renamed from: a */
    public static C1757d m6389a() {
        if (f5313b == null) {
            synchronized (C1757d.class) {
                if (f5313b == null) {
                    f5313b = new C1757d();
                }
            }
        }
        return f5313b;
    }

    /* renamed from: b */
    public void m6391b() {
        Builder builder1 = CarlifeProtocolVersion.newBuilder();
        builder1.setMajorVersion(1);
        builder1.setMinorVersion(0);
        f5315d = builder1.build();
        Builder builder2 = CarlifeProtocolVersion.newBuilder();
        builder2.setMajorVersion(2);
        builder2.setMinorVersion(0);
        f5316e = builder2.build();
        f5314c = f5316e;
        f5319h.add(f5315d);
        f5319h.add(f5316e);
    }

    /* renamed from: c */
    public CarlifeProtocolVersion m6392c() {
        return f5314c;
    }

    /* renamed from: a */
    public void m6390a(CarlifeProtocolVersion info) {
        f5317f = info;
    }

    /* renamed from: d */
    public CarlifeProtocolVersion m6393d() {
        return f5317f;
    }

    /* renamed from: e */
    public boolean m6394e() {
        try {
            if (f5319h.isEmpty() || f5317f == null) {
                return false;
            }
            for (int i = 0; i < f5319h.size(); i++) {
                if (((CarlifeProtocolVersion) f5319h.get(i)).getMajorVersion() == f5317f.getMajorVersion()) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            LogUtil.e(f5312a, "computerProtocolMatchStatus fail");
            ex.printStackTrace();
            return false;
        }
    }

    /* renamed from: f */
    public void m6395f() {
        boolean matchStatus = m6394e();
        CarlifeProtocolVersionMatchStatus.Builder builder = CarlifeProtocolVersionMatchStatus.newBuilder();
        builder.setMatchStatus(matchStatus ? 1 : 2);
        f5318g = builder.build();
    }

    /* renamed from: g */
    public CarlifeProtocolVersionMatchStatus m6396g() {
        return f5318g;
    }

    /* renamed from: h */
    public void m6397h() {
        try {
            CarlifeCmdMessage protocolM = new CarlifeCmdMessage(true);
            protocolM.m4201c(CommonParams.f3536C);
            protocolM.m4199b(f5318g.toByteArray());
            protocolM.m4203d(f5318g.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, protocolM.getServiceType(), 1001, 0, protocolM));
        } catch (Exception ex) {
            LogUtil.e(f5312a, "sendProtocolMatchStatus fail");
            ex.printStackTrace();
        }
    }
}
