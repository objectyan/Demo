package com.baidu.carlife.bluetooth;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection;
import com.baidu.carlife.protobuf.CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication;
import com.baidu.carlife.protobuf.CarlifeBTHfpResponseProto.CarlifeBTHfpResponse;
import com.baidu.carlife.protobuf.CarlifeDeviceInfoProto.CarlifeDeviceInfo;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: BtHfpManager */
/* renamed from: com.baidu.carlife.bluetooth.b */
public class C1047b {
    /* renamed from: B */
    private static final String f2700B = C1047b.class.getSimpleName();
    /* renamed from: I */
    private static final int f2701I = 1000;
    /* renamed from: J */
    private static final int f2702J = 100;
    /* renamed from: a */
    public static final int f2703a = 1;
    /* renamed from: b */
    public static final int f2704b = 2;
    /* renamed from: c */
    public static final int f2705c = 3;
    /* renamed from: d */
    public static final int f2706d = 4;
    /* renamed from: e */
    public static final int f2707e = 5;
    /* renamed from: f */
    public static final int f2708f = 6;
    /* renamed from: g */
    public static final int f2709g = 7;
    /* renamed from: h */
    public static final int f2710h = 1;
    /* renamed from: i */
    public static final int f2711i = 2;
    /* renamed from: j */
    public static final int f2712j = 3;
    /* renamed from: k */
    public static final int f2713k = 4;
    /* renamed from: l */
    public static final int f2714l = 5;
    /* renamed from: m */
    public static final int f2715m = 1;
    /* renamed from: n */
    public static final int f2716n = 0;
    /* renamed from: o */
    public static final int f2717o = 0;
    /* renamed from: p */
    public static final int f2718p = 1;
    /* renamed from: q */
    public static final int f2719q = 2;
    /* renamed from: r */
    public static final int f2720r = 0;
    /* renamed from: s */
    public static final int f2721s = 1;
    /* renamed from: t */
    public static final int f2722t = 2;
    /* renamed from: u */
    public static final int f2723u = 3;
    /* renamed from: v */
    public static final int f2724v = 4;
    /* renamed from: w */
    public static final int f2725w = 0;
    /* renamed from: x */
    public static final int f2726x = 1;
    /* renamed from: y */
    public static C1047b f2727y = null;
    /* renamed from: A */
    public boolean f2728A;
    /* renamed from: C */
    private int f2729C;
    /* renamed from: D */
    private C1046b f2730D;
    /* renamed from: E */
    private List<C1049d> f2731E;
    /* renamed from: F */
    private List<C1045a> f2732F;
    /* renamed from: G */
    private String f2733G;
    /* renamed from: H */
    private Context f2734H;
    /* renamed from: K */
    private int f2735K;
    /* renamed from: L */
    private int f2736L;
    /* renamed from: M */
    private boolean f2737M;
    /* renamed from: z */
    public boolean f2738z;

    /* compiled from: BtHfpManager */
    /* renamed from: com.baidu.carlife.bluetooth.b$a */
    public interface C1045a {
        /* renamed from: a */
        void mo1697a(int i, int i2, int i3);
    }

    /* compiled from: BtHfpManager */
    /* renamed from: com.baidu.carlife.bluetooth.b$b */
    private class C1046b extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1047b f2699a;

        private C1046b(C1047b c1047b) {
            this.f2699a = c1047b;
        }

        public void careAbout() {
            addMsg(C1253f.aU);
            addMsg(C1253f.aI);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    if (this.f2699a.f2735K > this.f2699a.f2736L) {
                        C1260i.m4435b(C1047b.f2700B, "MD<---HU: HFP Response timeout,requestNum=" + this.f2699a.f2735K + ",responseNum=" + this.f2699a.f2736L);
                        if (this.f2699a.f2732F != null) {
                            for (C1045a callback : this.f2699a.f2732F) {
                                callback.mo1697a(0, 0, 0);
                            }
                        }
                    } else {
                        C1260i.m4435b(C1047b.f2700B, "MD<---HU: HFP Response suc,requestNum=" + this.f2699a.f2735K + ",responseNum=" + this.f2699a.f2736L);
                    }
                    this.f2699a.f2735K = 0;
                    this.f2699a.f2736L = 0;
                    return;
                case 1002:
                    for (C1049d callback2 : this.f2699a.f2731E) {
                        callback2.mo1384a(false);
                    }
                    return;
                case C1253f.f3537D /*98307*/:
                    try {
                        this.f2699a.f2733G = CarlifeDeviceInfo.parseFrom(msg.obj.m4205f()).getBtaddress();
                        C1260i.m4435b(C1047b.f2700B, "MSG_CMD_HU_INFO: HU's bt address is " + this.f2699a.f2733G);
                        this.f2699a.m3409o();
                        return;
                    } catch (Exception ex) {
                        C1260i.m4445e(C1047b.f2700B, "get hu info error");
                        ex.printStackTrace();
                        return;
                    }
                case C1253f.aI /*98369*/:
                    try {
                        CarlifeBTHfpIndication btIndication = CarlifeBTHfpIndication.parseFrom(msg.obj.m4205f());
                        if (btIndication != null) {
                            int callState = btIndication.getState();
                            C1260i.m4435b(C1047b.f2700B, "MD<---HU: HFP indication state = " + callState);
                            switch (callState) {
                                case 1:
                                    String phoneNum = btIndication.getPhoneNum();
                                    if (TextUtils.isEmpty(phoneNum)) {
                                        C1260i.m4435b(C1047b.f2700B, "New incoming call, Number : unkown");
                                    } else {
                                        C1260i.m4435b(C1047b.f2700B, "New incoming call, Number :" + phoneNum);
                                        this.f2699a.m3416b(2);
                                    }
                                    for (C1049d callback22 : this.f2699a.f2731E) {
                                        callback22.mo1383a();
                                    }
                                    return;
                                case 2:
                                    C1260i.m4435b(C1047b.f2700B, "New outgoning call");
                                    this.f2699a.m3416b(3);
                                    for (C1049d callback222 : this.f2699a.f2731E) {
                                        callback222.mo1385b();
                                    }
                                    return;
                                case 3:
                                    C1260i.m4435b(C1047b.f2700B, "Call is active");
                                    this.f2699a.m3416b(1);
                                    for (C1049d callback2222 : this.f2699a.f2731E) {
                                        callback2222.mo1386c();
                                    }
                                    return;
                                case 4:
                                    C1260i.m4435b(C1047b.f2700B, "Call is inactive");
                                    this.f2699a.m3416b(0);
                                    for (C1049d callback22222 : this.f2699a.f2731E) {
                                        callback22222.mo1387d();
                                    }
                                    return;
                                case 5:
                                    C1260i.m4435b(C1047b.f2700B, "MultiCall is active");
                                    this.f2699a.m3416b(4);
                                    for (C1049d callback222222 : this.f2699a.f2731E) {
                                        callback222222.mo1388e();
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                    } catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                        return;
                    }
                case C1253f.aJ /*98370*/:
                    try {
                        CarlifeBTHfpConnection btConnection = CarlifeBTHfpConnection.parseFrom(msg.obj.m4205f());
                        if (btConnection != null) {
                            int connState = btConnection.getState();
                            String address = btConnection.getAddress();
                            String localAddress = C1079i.m3605a();
                            switch (connState) {
                                case 0:
                                    C1260i.m4435b(C1047b.f2700B, "MD <--- HU: HFP DISCONNECTED,Local Address = " + localAddress + ",Connected Address = " + address);
                                    if (TextUtils.isEmpty(address)) {
                                        C1260i.m4435b(C1047b.f2700B, "Disconnected with unkownn device");
                                        return;
                                    } else if (address.equals(localAddress)) {
                                        this.f2699a.f2738z = false;
                                        for (C1049d callback2222222 : this.f2699a.f2731E) {
                                            callback2222222.mo1384a(false);
                                        }
                                        return;
                                    } else {
                                        return;
                                    }
                                case 1:
                                    C1260i.m4435b(C1047b.f2700B, "MD <--- HU: HFP CONNECTING,Local Address = " + localAddress + ",Connected Address = " + address);
                                    if (TextUtils.isEmpty(address)) {
                                        C1260i.m4435b(C1047b.f2700B, "Connecting with unknonw device");
                                        return;
                                    } else {
                                        C1260i.m4435b(C1047b.f2700B, "Connecting with address = " + address);
                                        return;
                                    }
                                case 2:
                                    C1260i.m4435b(C1047b.f2700B, "MD <--- HU: HFP CONNECTED,Local Address = " + localAddress + ",Connected Address = " + address);
                                    if (TextUtils.isEmpty(address)) {
                                        C1260i.m4435b(C1047b.f2700B, "HU has connected with unknown device");
                                        return;
                                    } else if (address.toLowerCase().equals(localAddress)) {
                                        this.f2699a.f2738z = true;
                                        return;
                                    } else {
                                        return;
                                    }
                                default:
                                    return;
                            }
                        }
                        return;
                    } catch (InvalidProtocolBufferException e2) {
                        e2.printStackTrace();
                        return;
                    }
                case C1253f.aU /*98382*/:
                    try {
                        CarlifeBTHfpResponse btHfpResponse = CarlifeBTHfpResponse.parseFrom(msg.obj.m4205f());
                        if (btHfpResponse != null) {
                            int cmd = btHfpResponse.getCmd();
                            int status = btHfpResponse.getStatus();
                            int code = btHfpResponse.getDtmfCode();
                            C1260i.m4435b(C1047b.f2700B, "MD<---HU: HFP Response cmdID = " + cmd + ",status = " + status + ",code = " + code);
                            this.f2699a.f2736L = this.f2699a.f2736L + 1;
                            if (this.f2699a.f2732F != null) {
                                for (C1045a callback3 : this.f2699a.f2732F) {
                                    callback3.mo1697a(cmd, status, code);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferException e22) {
                        e22.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public C1047b() {
        this.f2738z = false;
        this.f2729C = 0;
        this.f2730D = null;
        this.f2731E = null;
        this.f2732F = null;
        this.f2728A = false;
        this.f2737M = true;
        this.f2730D = new C1046b();
        C1261k.m4460a(this.f2730D);
    }

    /* renamed from: a */
    public static C1047b m3397a() {
        if (f2727y == null) {
            synchronized (C1047b.class) {
                if (f2727y == null) {
                    f2727y = new C1047b();
                }
            }
        }
        return f2727y;
    }

    /* renamed from: a */
    public void m3411a(Context cx) {
        this.f2734H = cx;
    }

    /* renamed from: b */
    public void m3415b() {
        C1261k.m4460a(this.f2730D);
        this.f2728A = true;
        if (this.f2731E != null) {
            for (C1049d callback : this.f2731E) {
                callback.mo1384a(true);
            }
        }
    }

    /* renamed from: c */
    public void m3419c() {
        C1261k.m4464b(this.f2730D);
        this.f2728A = false;
        if (this.f2731E != null) {
            for (C1049d callback : this.f2731E) {
                callback.mo1384a(false);
            }
        }
    }

    /* renamed from: d */
    public void m3421d() {
    }

    /* renamed from: a */
    public void m3413a(C1049d callback) {
        if (this.f2731E == null) {
            this.f2731E = new ArrayList();
        }
        if (!this.f2731E.contains(callback) && callback != null) {
            this.f2731E.add(callback);
            callback.mo1384a(this.f2728A);
        }
    }

    /* renamed from: b */
    public void m3418b(C1049d callback) {
        if (this.f2731E != null && callback != null) {
            this.f2731E.remove(callback);
        }
    }

    /* renamed from: a */
    public void m3412a(C1045a callback) {
        if (this.f2732F == null) {
            this.f2732F = new ArrayList();
        }
        if (!this.f2732F.contains(callback) && callback != null) {
            this.f2732F.add(callback);
        }
    }

    /* renamed from: b */
    public void m3417b(C1045a callback) {
        if (this.f2732F != null && callback != null) {
            this.f2732F.remove(callback);
        }
    }

    /* renamed from: e */
    public void m3423e() {
        if (!this.f2728A) {
            return;
        }
        if (C1868q.m7089f().m7116c() != 1) {
            C1260i.m4435b(f2700B, "answerCall : No incoming call");
            return;
        }
        StatisticManager.onEvent(StatisticConstants.PHONE_003);
        C1048c.m3434a(3, "");
        m3408n();
    }

    /* renamed from: f */
    public void m3424f() {
        if (!this.f2728A) {
            return;
        }
        if (C1868q.m7089f().m7116c() != 1) {
            C1260i.m4435b(f2700B, "rejectCall : No incoming call");
            return;
        }
        C1048c.m3434a(4, "");
        m3408n();
    }

    /* renamed from: g */
    public void m3425g() {
        if (!this.f2728A) {
            return;
        }
        if (C1868q.m7089f().m7116c() != 0) {
            C1260i.m4435b(f2700B, "terminateCall : No ongoing call");
            return;
        }
        C1048c.m3434a(2, "");
        m3408n();
    }

    /* renamed from: h */
    public void m3426h() {
        if (!this.f2728A) {
            return;
        }
        if (C1868q.m7089f().m7116c() == 0) {
            C1260i.m4435b(f2700B, "muteMic : Mute mic not in call active");
            return;
        }
        C1048c.m3434a(6, "");
        m3408n();
    }

    /* renamed from: i */
    public void m3427i() {
        if (!this.f2728A) {
            return;
        }
        if (C1868q.m7089f().m7116c() == 0) {
            C1260i.m4435b(f2700B, "muteMic : Unmute mic not in call active");
            return;
        }
        C1048c.m3434a(7, "");
        m3408n();
    }

    /* renamed from: a */
    public void m3410a(int code) {
        if (!this.f2728A) {
            return;
        }
        if (C1868q.m7089f().m7116c() != 2) {
            C1260i.m4435b(f2700B, "sendDTMF : send DTMF is not allowed in call inactive state");
            return;
        }
        C1048c.m3433a(5, code);
        m3408n();
    }

    /* renamed from: n */
    private void m3408n() {
        this.f2735K++;
        this.f2730D.removeMessages(100);
        this.f2730D.sendEmptyMessageDelayed(100, 1000);
    }

    /* renamed from: b */
    public void m3416b(int state) {
        this.f2729C = state;
    }

    /* renamed from: j */
    public int m3428j() {
        return this.f2729C;
    }

    /* renamed from: a */
    public void m3414a(boolean enable) {
        if (enable) {
            C1260i.m4435b(f2700B, "Enable Telephone lifecycle listener");
            this.f2737M = true;
            return;
        }
        C1260i.m4435b(f2700B, "Disable Telephone lifecycle listener");
        this.f2737M = false;
    }

    /* renamed from: k */
    public boolean m3429k() {
        if (this.f2737M) {
            C1260i.m4435b(f2700B, "My Telephone lifecycle listener is enabled");
            return true;
        }
        C1260i.m4435b(f2700B, "My Telephone lifecycle listener is disabled");
        return false;
    }

    /* renamed from: l */
    public void m3430l() {
        C1260i.m4435b(f2700B, "Try to bring Carlife to foreground via adb command");
        if (C1663a.m5979a().m5993N()) {
            C1212c command = new C1212c(true);
            command.m4201c(C1253f.aF);
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }
    }

    /* renamed from: c */
    public void m3420c(int callState) {
        if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("xiaomi")) {
            C1260i.m4435b(f2700B, "Try to bring Carlife to foreground via adb command used by XiaoMi");
            m3422d(callState);
            return;
        }
        m3422d(callState);
    }

    /* renamed from: d */
    public void m3422d(int callState) {
        C1260i.m4435b(f2700B, "Try to bring Carlife to foreground via local intent");
        Context context = BaiduNaviApplication.getInstance().getApplicationContext();
        Intent intent = new Intent(context, CarlifeActivity.class);
        intent.putExtra("com.baidu.carlife.callstate", callState);
        intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        context.startActivity(intent);
    }

    /* renamed from: o */
    private void m3409o() {
        String address = C1079i.m3605a();
        if (C1058f.m3470a().m3525c(this.f2733G)) {
            C1048c.m3446b(2, this.f2733G);
        } else {
            C1048c.m3446b(0, this.f2733G);
        }
    }
}
