package com.baidu.carlife.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection;
import com.baidu.carlife.protobuf.CarlifeBTPairInfoProto.CarlifeBTPairInfo;
import com.baidu.carlife.protobuf.CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq;
import com.baidu.carlife.protobuf.CarlifeDeviceInfoProto.CarlifeDeviceInfo;
import com.baidu.carlife.util.C2204x;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: BtDeviceManager */
/* renamed from: com.baidu.carlife.bluetooth.a */
public class BtDeviceManager extends StateMachine {
    /* renamed from: C */
    private static final String f2661C = BtDeviceManager.class.getSimpleName();
    /* renamed from: D */
    private static BtDeviceManager f2662D = null;
    /* renamed from: a */
    public static final int f2663a = 0;
    /* renamed from: b */
    public static final int f2664b = 1;
    /* renamed from: c */
    public static final int f2665c = 2;
    /* renamed from: d */
    public static final int f2666d = 3;
    /* renamed from: e */
    public static final int f2667e = 4;
    /* renamed from: f */
    public static final int f2668f = 5;
    /* renamed from: g */
    public static final int f2669g = 6;
    /* renamed from: h */
    public static final int f2670h = 7;
    /* renamed from: i */
    public static final int f2671i = 8;
    /* renamed from: j */
    public static final int f2672j = 9;
    /* renamed from: k */
    public static final int f2673k = 10;
    /* renamed from: l */
    public static final int f2674l = 11;
    /* renamed from: m */
    public static final int f2675m = 12;
    /* renamed from: n */
    public static final int f2676n = 13;
    /* renamed from: o */
    public static final int f2677o = 14;
    /* renamed from: p */
    public static final int f2678p = 15;
    /* renamed from: q */
    public static final int f2679q = 16;
    /* renamed from: r */
    public static final int f2680r = 17;
    /* renamed from: s */
    public static final int f2681s = 18;
    /* renamed from: t */
    public static final int f2682t = 0;
    /* renamed from: u */
    public static final int f2683u = 1;
    /* renamed from: v */
    public static final int f2684v = 2;
    /* renamed from: E */
    private C1041g f2685E;
    /* renamed from: F */
    private C1040f f2686F;
    /* renamed from: G */
    private C1037c f2687G;
    /* renamed from: H */
    private C1036b f2688H;
    /* renamed from: I */
    private C1039e f2689I;
    /* renamed from: J */
    private C1035a f2690J;
    /* renamed from: K */
    private C1038d f2691K;
    /* renamed from: L */
    private Context f2692L;
    /* renamed from: M */
    private String f2693M;
    /* renamed from: N */
    private String f2694N;
    /* renamed from: O */
    private boolean f2695O;
    /* renamed from: P */
    private final BroadcastReceiver f2696P;
    /* renamed from: w */
    public boolean f2697w;
    /* renamed from: x */
    public boolean f2698x;

    /* compiled from: BtDeviceManager */
    /* renamed from: com.baidu.carlife.bluetooth.a$a */
    private class C1035a extends State {
        /* renamed from: a */
        final /* synthetic */ BtDeviceManager f2646a;

        private C1035a(BtDeviceManager btDeviceManager) {
            this.f2646a = btDeviceManager;
        }

        /* renamed from: a */
        public void mo1378a() {
            LogUtil.d(BtDeviceManager.f2661C, "Entering CarlifeBtTele State");
            BtHfpProtocolHelper.m3447c(1, this.f2646a.f2693M);
            BtHfpManager.m3397a().m3415b();
        }

        /* renamed from: b */
        public void mo1380b() {
            LogUtil.d(BtDeviceManager.f2661C, "Exiting CarlifeBtTele State");
            BtHfpManager.m3397a().m3419c();
            BtHfpProtocolHelper.m3447c(0, this.f2646a.f2693M);
        }

        /* renamed from: a */
        public boolean mo1379a(Message msg) {
            switch (msg.what) {
                case 10:
                    this.f2646a.m3326a(msg);
                    this.f2646a.m3328a(this.f2646a.f2688H);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: BtDeviceManager */
    /* renamed from: com.baidu.carlife.bluetooth.a$b */
    private class C1036b extends State {
        /* renamed from: a */
        final /* synthetic */ BtDeviceManager f2647a;

        private C1036b(BtDeviceManager btDeviceManager) {
            this.f2647a = btDeviceManager;
        }

        /* renamed from: a */
        public void mo1378a() {
            LogUtil.d(BtDeviceManager.f2661C, "Entering CarlifeConnected State");
            if (BtUtils.m3619d()) {
                BtManager.m3470a().m3522b();
            }
        }

        /* renamed from: b */
        public void mo1380b() {
            LogUtil.d(BtDeviceManager.f2661C, "Exiting CarlifeConnected State");
        }

        /* renamed from: a */
        public boolean mo1379a(Message msg) {
            switch (msg.what) {
                case 1:
                case 3:
                case 5:
                case 6:
                case 10:
                    return true;
                case 2:
                    this.f2647a.m3328a(this.f2647a.f2686F);
                    return true;
                case 4:
                    if (!BtManager.m3470a().m3525c(this.f2647a.f2693M)) {
                        BtHfpProtocolHelper.m3447c(0, this.f2647a.f2693M);
                        if (!this.f2647a.f2698x) {
                            return true;
                        }
                        this.f2647a.m3326a(this.f2647a.m3337c(6));
                        this.f2647a.m3328a(this.f2647a.f2689I);
                        return true;
                    } else if (this.f2647a.f2697w) {
                        this.f2647a.m3328a(this.f2647a.f2690J);
                        return true;
                    } else if (C2204x.m8382b()) {
                        return true;
                    } else {
                        BtHfpProtocolHelper.m3447c(0, this.f2647a.f2693M);
                        return true;
                    }
                case 7:
                    if (!this.f2647a.f2695O) {
                        return true;
                    }
                    this.f2647a.m3324a(4, 500);
                    return true;
                case 12:
                    this.f2647a.m3328a(this.f2647a.f2691K);
                    return true;
                case 14:
                    LogUtil.d(BtDeviceManager.f2661C, "HU INFO: Old Auto Pairing Mechanism");
                    this.f2647a.m3384f();
                    BtManager.m3470a().f2781v.sendMessageDelayed(this.f2647a.m3322a((int) CommonParams.f3539F, msg.obj), 500);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: BtDeviceManager */
    /* renamed from: com.baidu.carlife.bluetooth.a$c */
    private class C1037c extends State {
        /* renamed from: a */
        final /* synthetic */ BtDeviceManager f2648a;

        private C1037c(BtDeviceManager btDeviceManager) {
            this.f2648a = btDeviceManager;
        }

        /* renamed from: a */
        public void mo1378a() {
            LogUtil.d(BtDeviceManager.f2661C, "Entering CarlifeConnecting State");
        }

        /* renamed from: b */
        public void mo1380b() {
            LogUtil.d(BtDeviceManager.f2661C, "Exiting CarlifeConnecting State");
        }

        /* renamed from: a */
        public boolean mo1379a(Message msg) {
            switch (msg.what) {
                case 2:
                    this.f2648a.m3328a(this.f2648a.f2686F);
                    return true;
                case 3:
                    this.f2648a.m3328a(this.f2648a.f2688H);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: BtDeviceManager */
    /* renamed from: com.baidu.carlife.bluetooth.a$d */
    private class C1038d extends State {
        /* renamed from: a */
        final /* synthetic */ BtDeviceManager f2649a;

        private C1038d(BtDeviceManager btDeviceManager) {
            this.f2649a = btDeviceManager;
        }

        /* renamed from: a */
        public void mo1378a() {
            LogUtil.d(BtDeviceManager.f2661C, "Entering CarlifeLegacy State");
            this.f2649a.m3340d(13);
            BtManager.m3470a().m3528f();
        }

        /* renamed from: b */
        public void mo1380b() {
            LogUtil.d(BtDeviceManager.f2661C, "Exiting CarlifeLegacy State");
            BtManager.m3470a().m3529g();
        }

        /* renamed from: a */
        public boolean mo1379a(Message msg) {
            switch (msg.what) {
                case 7:
                case 10:
                case 13:
                    return true;
                case 16:
                case 17:
                    this.f2649a.m3328a(this.f2649a.f2688H);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: BtDeviceManager */
    /* renamed from: com.baidu.carlife.bluetooth.a$e */
    private class C1039e extends State {
        /* renamed from: a */
        final /* synthetic */ BtDeviceManager f2650a;

        private C1039e(BtDeviceManager btDeviceManager) {
            this.f2650a = btDeviceManager;
        }

        /* renamed from: a */
        public void mo1378a() {
            LogUtil.d(BtDeviceManager.f2661C, "Entering CarlifePairing State");
            BtManager.m3470a().m3528f();
        }

        /* renamed from: b */
        public void mo1380b() {
            LogUtil.d(BtDeviceManager.f2661C, "Exiting CarlifePairing State");
            BtManager.m3470a().m3529g();
        }

        /* renamed from: a */
        public boolean mo1379a(Message msg) {
            switch (msg.what) {
                case 6:
                    BtHfpProtocolHelper.m3440a(this.f2650a.f2694N);
                    return true;
                case 10:
                case 14:
                    return true;
                case 16:
                    LogUtil.d(BtDeviceManager.f2661C, "Auto pairing failed");
                    this.f2650a.m3328a(this.f2650a.f2688H);
                    return true;
                case 17:
                    LogUtil.d(BtDeviceManager.f2661C, "Audo pairing done in success");
                    this.f2650a.m3328a(this.f2650a.f2688H);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: BtDeviceManager */
    /* renamed from: com.baidu.carlife.bluetooth.a$f */
    private class C1040f extends State {
        /* renamed from: a */
        final /* synthetic */ BtDeviceManager f2651a;

        private C1040f(BtDeviceManager btDeviceManager) {
            this.f2651a = btDeviceManager;
        }

        /* renamed from: a */
        public void mo1378a() {
            LogUtil.d(BtDeviceManager.f2661C, "Entering Idle State");
            LogUtil.d(BtDeviceManager.f2661C, "bdaddr for MD = " + this.f2651a.f2694N);
            this.f2651a.f2693M = "";
            this.f2651a.f2697w = false;
            this.f2651a.f2698x = false;
            this.f2651a.f2695O = false;
        }

        /* renamed from: b */
        public void mo1380b() {
            LogUtil.d(BtDeviceManager.f2661C, "Exiting Idle State");
        }

        /* renamed from: a */
        public boolean mo1379a(Message msg) {
            switch (msg.what) {
                case 1:
                    this.f2651a.m3328a(this.f2651a.f2687G);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: BtDeviceManager */
    /* renamed from: com.baidu.carlife.bluetooth.a$g */
    private class C1041g extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ BtDeviceManager f2652a;

        private C1041g(BtDeviceManager btDeviceManager) {
            this.f2652a = btDeviceManager;
        }

        public void careAbout() {
            addMsg(1002);
            addMsg(1004);
            addMsg(CommonParams.aZ);
            addMsg(CommonParams.aJ);
            addMsg(CommonParams.f3537D);
            addMsg(CommonParams.f3539F);
        }

        public void handleMessage(Message msg) {
            String address;
            switch (msg.what) {
                case 1002:
                    this.f2652a.m3383e();
                    return;
                case 1004:
                    this.f2652a.m3381c();
                    return;
                case CommonParams.f3537D /*98307*/:
                    try {
                        CarlifeDeviceInfo info = CarlifeDeviceInfo.parseFrom(msg.obj.m4205f());
                        if (info.hasBtaddress()) {
                            address = info.getBtaddress();
                            if (TextUtils.isEmpty(address) || !BluetoothAdapter.checkBluetoothAddress(address)) {
                                LogUtil.d(BtDeviceManager.f2661C, "HU INFO: bluetooth address invalid");
                                return;
                            }
                            this.f2652a.f2693M = address;
                            LogUtil.d(BtDeviceManager.f2661C, "HU INFO: bluetooth address  = " + this.f2652a.f2693M);
                            return;
                        }
                        LogUtil.d(BtDeviceManager.f2661C, "HU INFO: Old HU without BtAddress");
                        return;
                    } catch (Exception ex) {
                        LogUtil.m4445e(BtDeviceManager.f2661C, "get hu info error");
                        ex.printStackTrace();
                        return;
                    }
                case CommonParams.f3539F /*98309*/:
                    CarlifeCmdMessage btMsg = msg.obj;
                    try {
                        CarlifeBTPairInfo btInfo = CarlifeBTPairInfo.parseFrom(btMsg.m4205f());
                        if (btInfo != null) {
                            if (btInfo.hasAddress()) {
                                address = btInfo.getAddress();
                                if (TextUtils.isEmpty(address) || !BluetoothAdapter.checkBluetoothAddress(address)) {
                                    LogUtil.d(BtDeviceManager.f2661C, "OOB INFO: bluetooth address invalid");
                                } else {
                                    this.f2652a.f2693M = address;
                                    LogUtil.d(BtDeviceManager.f2661C, "OOB INFO: bluetooth address  = " + this.f2652a.f2693M);
                                }
                            } else {
                                LogUtil.d(BtDeviceManager.f2661C, "OOB INFO: Unexpected OOB INFO message, no bluetooth address");
                            }
                            if (btInfo.getStatus() == 0) {
                                this.f2652a.m3376a(btMsg);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                        return;
                    }
                case CommonParams.aJ /*98370*/:
                    try {
                        CarlifeBTHfpConnection btConnection = CarlifeBTHfpConnection.parseFrom(msg.obj.m4205f());
                        if (btConnection != null) {
                            int connState = btConnection.getState();
                            address = btConnection.getAddress();
                            String localAddress = BtUtils.m3605a();
                            switch (connState) {
                                case 2:
                                    LogUtil.d(BtDeviceManager.f2661C, "MD <--- HU: HFP CONNECTED,Local Address = " + localAddress + ",Connected Address = " + address);
                                    if (TextUtils.isEmpty(address)) {
                                        LogUtil.d(BtDeviceManager.f2661C, "HU has connected with unknown device");
                                        return;
                                    } else if (!address.toLowerCase().equals(localAddress)) {
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
                case CommonParams.aZ /*98387*/:
                    try {
                        CarlifeBTStartIdentifyReq btStartIdentifyReq = CarlifeBTStartIdentifyReq.parseFrom(msg.obj.m4205f());
                        if (btStartIdentifyReq != null) {
                            String bdaddr = btStartIdentifyReq.getAddress();
                            LogUtil.d(BtDeviceManager.f2661C, "MD <--- HU: Start Identify Req,address = " + bdaddr);
                            if (!TextUtils.isEmpty(bdaddr)) {
                                this.f2652a.m3377a(bdaddr);
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

    protected BtDeviceManager(String name) {
        super(f2661C, Looper.getMainLooper());
        this.f2693M = "";
        this.f2694N = "";
        this.f2695O = false;
        this.f2697w = false;
        this.f2698x = false;
        this.f2696P = new BtDeviceManagerBroadcastReceiver(this);
        this.f2685E = new C1041g();
        this.f2694N = BtUtils.m3605a();
        this.f2686F = new C1040f();
        this.f2687G = new C1037c();
        this.f2688H = new C1036b();
        this.f2689I = new C1039e();
        this.f2690J = new C1035a();
        this.f2691K = new C1038d();
        m3329a(this.f2686F);
        m3330a(this.f2687G, this.f2686F);
        m3330a(this.f2688H, this.f2686F);
        m3330a(this.f2691K, this.f2688H);
        m3330a(this.f2689I, this.f2688H);
        m3330a(this.f2690J, this.f2688H);
        m3336b(this.f2686F);
    }

    /* renamed from: a */
    public static BtDeviceManager m3360a() {
        if (f2662D == null) {
            synchronized (BtDeviceManager.class) {
                if (f2662D == null) {
                    f2662D = new BtDeviceManager(f2661C);
                }
            }
        }
        return f2662D;
    }

    /* renamed from: a */
    public void m3375a(Context cx) {
        this.f2692L = cx;
        BtManager.m3470a().m3519a(cx);
        BtHfpManager.m3397a().m3411a(cx);
        m3358D();
        m3319C();
    }

    /* renamed from: b */
    public void m3379b() {
        BtHfpManager.m3397a().m3421d();
        BtManager.m3470a().m3527e();
        m3359E();
    }

    /* renamed from: D */
    private void m3358D() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        filter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        if (this.f2692L != null) {
            this.f2692L.registerReceiver(this.f2696P, filter);
        }
        if (this.f2685E != null) {
            MsgHandlerCenter.m4460a(this.f2685E);
        }
    }

    /* renamed from: E */
    private void m3359E() {
        if (!(this.f2692L == null || this.f2696P == null)) {
            this.f2692L.unregisterReceiver(this.f2696P);
        }
        if (this.f2685E != null) {
            MsgHandlerCenter.m4464b(this.f2685E);
        }
    }

    /* renamed from: a */
    private void m3363a(Intent intent) {
        int bluetoothState = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
        if (bluetoothState == 13 || bluetoothState == 10) {
            m3390l();
        }
    }

    /* renamed from: c */
    public void m3381c() {
        LogUtil.d(f2661C, "send usb connected event");
        m3340d(1);
    }

    /* renamed from: d */
    public void m3382d() {
        LogUtil.d(f2661C, "send carlife authenticated event");
        m3340d(3);
    }

    /* renamed from: e */
    public void m3383e() {
        LogUtil.d(f2661C, "send usb disconnected event");
        m3340d(2);
    }

    /* renamed from: f */
    public void m3384f() {
        LogUtil.d(f2661C, "send enter legacy event");
        m3340d(12);
    }

    /* renamed from: a */
    public void m3377a(String address) {
        LogUtil.d(f2661C, "send start identify event");
        if (!TextUtils.isEmpty(address)) {
            this.f2695O = true;
            this.f2693M = address;
            m3340d(4);
        }
    }

    /* renamed from: g */
    protected void mo1382g() {
        LogUtil.d(f2661C, "Halting SM!!");
    }

    /* renamed from: h */
    public void m3386h() {
        LogUtil.d(f2661C, "finish identify event");
        m3340d(5);
    }

    /* renamed from: i */
    public void m3387i() {
        LogUtil.d(f2661C, "start bt pairing event");
        m3340d(6);
    }

    /* renamed from: j */
    public void m3388j() {
        LogUtil.d(f2661C, "finish bt pairing event");
        m3340d(7);
    }

    /* renamed from: k */
    public void m3389k() {
        LogUtil.d(f2661C, "HU support BT telephone, and enable this feature");
        m3340d(9);
    }

    /* renamed from: l */
    public void m3390l() {
        LogUtil.d(f2661C, "Hfp connection with HU is disconnected");
        m3340d(10);
    }

    /* renamed from: m */
    public void m3391m() {
        m3340d(16);
    }

    /* renamed from: n */
    public void m3392n() {
        m3340d(17);
    }

    /* renamed from: o */
    public void m3393o() {
        m3340d(18);
    }

    /* renamed from: a */
    public void m3378a(String key, int enable) {
        if (C1765g.f5338c.equals(key)) {
            if (enable == 1) {
                LogUtil.d(f2661C, "BT Auto Pair is supported by HU");
                this.f2698x = true;
            } else {
                LogUtil.d(f2661C, "BT Auto Pair is NOT supported by HU");
                this.f2698x = false;
            }
        } else if (C1765g.f5339d.equals(key)) {
            if (enable == 1) {
                LogUtil.d(f2661C, "Internal Tele UI is supported by HU");
                if (CarlifeConfig.m4065a()) {
                    this.f2697w = true;
                } else {
                    this.f2697w = false;
                }
            } else {
                LogUtil.d(f2661C, "Internal Tele UI is NOT supported by HU");
                this.f2697w = false;
            }
        }
        m3340d(15);
    }

    /* renamed from: a */
    public void m3376a(CarlifeCmdMessage oobMsg) {
        LogUtil.d(f2661C, "Got OOB Info msg from HU");
        if (oobMsg != null) {
            m3341d(m3322a(14, (Object) oobMsg));
        }
    }

    /* renamed from: p */
    public String m3394p() {
        return this.f2693M;
    }

    /* renamed from: b */
    public void m3380b(String addr) {
        this.f2693M = addr;
    }
}
