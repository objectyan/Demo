package com.baidu.carlife.bluetooth;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.protobuf.CarlifeBTPairInfoProto.CarlifeBTPairInfo;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.List;
import java.util.Set;

/* compiled from: BtManager */
/* renamed from: com.baidu.carlife.bluetooth.f */
public class BtManager {
    /* renamed from: a */
    public static final String f2747a = "BtManager";
    /* renamed from: b */
    public static final int f2748b = 0;
    /* renamed from: c */
    public static final int f2749c = 1;
    /* renamed from: d */
    public static final int f2750d = 2;
    /* renamed from: e */
    public static final int f2751e = 1;
    /* renamed from: f */
    public static final int f2752f = 2;
    /* renamed from: g */
    public static final int f2753g = 3;
    /* renamed from: h */
    public static final int f2754h = 20;
    /* renamed from: i */
    public static final int f2755i = 21;
    /* renamed from: j */
    public static final int f2756j = 22;
    /* renamed from: k */
    public static final int f2757k = 23;
    /* renamed from: l */
    public static final int f2758l = 24;
    /* renamed from: m */
    public static final int f2759m = 25;
    /* renamed from: n */
    public static final int f2760n = 40;
    /* renamed from: o */
    public static final int f2761o = 41;
    /* renamed from: p */
    public static final int f2762p = -1;
    /* renamed from: q */
    public static final int f2763q = -2;
    /* renamed from: r */
    public static final int f2764r = -3;
    /* renamed from: s */
    public static final int f2765s = -4;
    /* renamed from: t */
    public static final int f2766t = 10000;
    /* renamed from: u */
    public static final int f2767u = 10000;
    /* renamed from: x */
    private static BtManager f2768x = null;
    /* renamed from: A */
    private String f2769A = "";
    /* renamed from: B */
    private String f2770B = "";
    /* renamed from: C */
    private Context f2771C = null;
    /* renamed from: D */
    private BluetoothHeadset f2772D;
    /* renamed from: E */
    private BluetoothA2dp f2773E;
    /* renamed from: F */
    private Runnable f2774F = null;
    /* renamed from: G */
    private int f2775G = 0;
    /* renamed from: H */
    private int f2776H = 0;
    /* renamed from: I */
    private int f2777I = 0;
    /* renamed from: J */
    private int f2778J = 0;
    /* renamed from: K */
    private int f2779K = 0;
    /* renamed from: L */
    private final BroadcastReceiver f2780L = new BtManagerBroadcastReceiver(this);
    /* renamed from: v */
    public C1057b f2781v = new C1057b(this);
    /* renamed from: w */
    public Handler f2782w = new C10511(this);
    /* renamed from: y */
    private BluetoothAdapter f2783y = null;
    /* renamed from: z */
    private BluetoothDevice f2784z = null;

    /* compiled from: BtManager */
    /* renamed from: com.baidu.carlife.bluetooth.f$1 */
    class C10511 extends Handler {
        /* renamed from: a */
        final /* synthetic */ BtManager f2741a;

        C10511(BtManager this$0) {
            this.f2741a = this$0;
        }

        public void handleMessage(Message inMsg) {
            Message pollMsg;
            int state;
            Message pairMsg;
            Bundle bundle;
            String address;
            Message timeoutMsg;
            switch (inMsg.what) {
                case 0:
                    this.f2741a.f2769A = inMsg.getData().getString("bdaddr");
                    this.f2741a.f2770B = inMsg.getData().getString("pin");
                    this.f2741a.m3479b(this.f2741a.f2769A, this.f2741a.f2770B);
                    return;
                case 1:
                    this.f2741a.m3510o();
                    return;
                case 2:
                    this.f2741a.m3507n();
                    return;
                case 20:
                    if (this.f2741a.f2775G > 0) {
                        this.f2741a.f2775G = this.f2741a.f2775G - 1;
                        LogUtil.d(BtManager.f2747a, "IDLE STAGE: Polling BT Adapter state left times = " + this.f2741a.f2775G);
                        if (this.f2741a.m3514q()) {
                            LogUtil.d(BtManager.f2747a, "IDLE STAGE: Bluetooth Adapter enabled after polling");
                            this.f2741a.f2776H = 10;
                            pollMsg = new Message();
                            pollMsg.what = 21;
                            this.f2741a.f2782w.sendMessageDelayed(pollMsg, 1000);
                            return;
                        }
                        pollMsg = new Message();
                        pollMsg.what = 20;
                        this.f2741a.f2782w.sendMessageDelayed(pollMsg, 1000);
                        return;
                    }
                    LogUtil.d(BtManager.f2747a, "IDLE STAGE: Polling adapter state timeout");
                    this.f2741a.m3473a(-1);
                    return;
                case 21:
                    if (this.f2741a.f2776H > 0) {
                        this.f2741a.f2776H = this.f2741a.f2776H - 1;
                        LogUtil.d(BtManager.f2747a, "READY STAGE: Polling HFP connection state left times = " + this.f2741a.f2776H);
                        state = this.f2741a.m3526d();
                        if (state == 1) {
                            LogUtil.d(BtManager.f2747a, "READY STAGE: Get ready for bluetooth connection");
                            Message m = new Message();
                            m.what = 22;
                            this.f2741a.f2782w.sendMessage(m);
                            return;
                        } else if (state == 2) {
                            pollMsg = new Message();
                            pollMsg.what = 21;
                            this.f2741a.f2782w.sendMessageDelayed(pollMsg, 1000);
                            return;
                        } else if (state == 3) {
                            LogUtil.d(BtManager.f2747a, "READY STAGE: Had been connected with HU");
                            return;
                        } else {
                            return;
                        }
                    }
                    LogUtil.d(BtManager.f2747a, "READY STAGE: Polling HFP connection state timeout");
                    this.f2741a.m3473a(-4);
                    return;
                case 22:
                    BtHfpProtocolHelper.m3432a(1);
                    return;
                case 23:
                    int bond = this.f2741a.m3500j(this.f2741a.f2769A);
                    if (bond == 12) {
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Bonded with HU, start hfp connect");
                        this.f2741a.m3485d(this.f2741a.f2769A);
                        return;
                    }
                    if (bond == 11) {
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Still in Bonding, cancel bond and restart");
                        this.f2741a.m3498i(this.f2741a.f2769A);
                    }
                    pairMsg = new Message();
                    pairMsg.what = 41;
                    bundle = new Bundle();
                    bundle.putString("bdaddr", this.f2741a.f2769A);
                    pairMsg.setData(bundle);
                    if (this.f2741a.f2782w != null) {
                        this.f2741a.f2782w.sendMessageDelayed(pairMsg, 500);
                        return;
                    }
                    return;
                case 24:
                    LogUtil.d(BtManager.f2747a, "PAIR STAGE: Connected with HU timeout");
                    state = this.f2741a.m3524c();
                    if (state == 0) {
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Still in disconnected state");
                    } else if (state == 2) {
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Connected with HU yet");
                        return;
                    } else {
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Still in connecting state, do a disconnect and restart connect");
                        this.f2741a.m3518t();
                    }
                    Message connectMsg = new Message();
                    connectMsg.what = 40;
                    Bundle addrBundle = new Bundle();
                    addrBundle.putString("bdaddr", this.f2741a.f2769A);
                    connectMsg.setData(addrBundle);
                    if (this.f2741a.f2782w != null) {
                        this.f2741a.f2782w.sendMessageDelayed(connectMsg, 500);
                        return;
                    }
                    return;
                case 40:
                    address = inMsg.getData().getString("bdaddr");
                    if (!this.f2741a.f2769A.equals(address)) {
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Address is not matched with last stage");
                        return;
                    } else if (this.f2741a.f2778J > 0) {
                        this.f2741a.f2778J = this.f2741a.f2778J - 1;
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Try to connect hfp with left attempts = " + this.f2741a.f2778J);
                        this.f2741a.m3491f(address);
                        timeoutMsg = new Message();
                        timeoutMsg.what = 24;
                        this.f2741a.f2782w.sendMessageDelayed(timeoutMsg, 10000);
                        return;
                    } else {
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Failed as down counter is over");
                        this.f2741a.m3473a(-3);
                        return;
                    }
                case 41:
                    address = inMsg.getData().getString("bdaddr");
                    if (!this.f2741a.f2769A.equals(address)) {
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Address is not matched with last stage");
                        return;
                    } else if (this.f2741a.f2777I > 0) {
                        this.f2741a.f2777I = this.f2741a.f2777I - 1;
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Try to bond with left attempts = " + this.f2741a.f2777I);
                        if (this.f2741a.m3494g(address)) {
                            timeoutMsg = new Message();
                            timeoutMsg.what = 23;
                            this.f2741a.f2782w.sendMessageDelayed(timeoutMsg, 10000);
                            return;
                        }
                        pairMsg = new Message();
                        pairMsg.what = 41;
                        bundle = new Bundle();
                        bundle.putString("bdaddr", address);
                        pairMsg.setData(bundle);
                        if (this.f2741a.f2782w != null) {
                            this.f2741a.m3498i(address);
                            this.f2741a.f2782w.sendMessageDelayed(pairMsg, 500);
                            return;
                        }
                        return;
                    } else {
                        LogUtil.d(BtManager.f2747a, "PAIR STAGE: Failed as down counter is over");
                        this.f2741a.m3473a(-2);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* compiled from: BtManager */
    /* renamed from: com.baidu.carlife.bluetooth.f$2 */
    class C10522 implements ServiceListener {
        /* renamed from: a */
        final /* synthetic */ BtManager f2742a;

        C10522(BtManager this$0) {
            this.f2742a = this$0;
        }

        public void onServiceDisconnected(int profile) {
            this.f2742a.f2772D = null;
            LogUtil.d(BtManager.f2747a, "INIT STAGE: Disconnect headset proxy!!!");
        }

        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if (profile == 1 && proxy != null) {
                this.f2742a.f2772D = (BluetoothHeadset) proxy;
                LogUtil.d(BtManager.f2747a, "INIT STAGE: Get headset proxy: " + this.f2742a.f2772D);
            }
        }
    }

    /* compiled from: BtManager */
    /* renamed from: com.baidu.carlife.bluetooth.f$3 */
    class C10533 implements ServiceListener {
        /* renamed from: a */
        final /* synthetic */ BtManager f2743a;

        C10533(BtManager this$0) {
            this.f2743a = this$0;
        }

        public void onServiceDisconnected(int profile) {
            this.f2743a.f2773E = null;
            LogUtil.d(BtManager.f2747a, "INIT STAGE: Disconnect A2DP proxy!!!");
        }

        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if (profile == 2 && proxy != null) {
                this.f2743a.f2773E = (BluetoothA2dp) proxy;
                LogUtil.d(BtManager.f2747a, "INIT STAGE: Get A2DP proxy: " + this.f2743a.f2773E);
            }
        }
    }

    /* compiled from: BtManager */
    /* renamed from: com.baidu.carlife.bluetooth.f$4 */
    class C10544 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BtManager f2744a;

        C10544(BtManager this$0) {
            this.f2744a = this$0;
        }

        public void run() {
            if (this.f2744a.m3514q()) {
                LogUtil.d(BtManager.f2747a, "Bluetooth is Enabled yet");
            } else if (this.f2744a.m3512p()) {
                LogUtil.d(BtManager.f2747a, "Enable Bluetooth In Success");
            } else {
                LogUtil.d(BtManager.f2747a, "Enable Bluetooth In Failure");
            }
        }
    }

    /* compiled from: BtManager */
    /* renamed from: com.baidu.carlife.bluetooth.f$5 */
    class C10555 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BtManager f2745a;

        C10555(BtManager this$0) {
            this.f2745a = this$0;
        }

        public void run() {
            if (this.f2745a.m3512p()) {
                LogUtil.d(BtManager.f2747a, "IDLE STAGE: Start to enable Bluetooth Adapter, and polling state...");
                this.f2745a.f2775G = 10;
                Message msg = new Message();
                msg.what = 20;
                this.f2745a.f2782w.sendMessageDelayed(msg, 1000);
                return;
            }
            LogUtil.d(BtManager.f2747a, "IDLE STAGE: Failed to enable Bluetooth Adapter");
        }
    }

    /* compiled from: BtManager */
    /* renamed from: com.baidu.carlife.bluetooth.f$a */
    public interface C1056a {
        /* renamed from: a */
        void m3463a();

        /* renamed from: b */
        void m3464b();

        /* renamed from: c */
        void m3465c();

        /* renamed from: d */
        void m3466d();

        /* renamed from: e */
        void m3467e();
    }

    /* compiled from: BtManager */
    /* renamed from: com.baidu.carlife.bluetooth.f$b */
    public class C1057b extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ BtManager f2746a;

        public C1057b(BtManager this$0) {
            this.f2746a = this$0;
        }

        public void careAbout() {
            addMsg(CommonParams.f3539F);
            addMsg(CommonParams.fX);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CommonParams.fX /*2031*/:
                    this.f2746a.m3522b();
                    return;
                case CommonParams.f3539F /*98309*/:
                    LogUtil.d(BtManager.f2747a, "my OOB info");
                    try {
                        CarlifeBTPairInfo btInfo = CarlifeBTPairInfo.parseFrom(msg.obj.m4205f());
                        if (btInfo != null) {
                            int status = btInfo.getStatus();
                            String address = btInfo.getAddress();
                            LogUtil.d(BtManager.f2747a, "MD <--- HU :address = " + btInfo.getAddress() + ",status = " + status);
                            if (!TextUtils.isEmpty(address) && BluetoothAdapter.checkBluetoothAddress(address)) {
                                switch (status) {
                                    case 0:
                                        this.f2746a.m3521a(btInfo.getAddress(), btInfo.getPassKey());
                                        return;
                                    case 1:
                                        this.f2746a.m3520a(btInfo.getAddress());
                                        return;
                                    case 2:
                                        this.f2746a.m3523b(btInfo.getAddress());
                                        return;
                                    default:
                                        return;
                                }
                            }
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private BtManager() {
    }

    /* renamed from: a */
    public static BtManager m3470a() {
        if (f2768x == null) {
            synchronized (BtManager.class) {
                if (f2768x == null) {
                    f2768x = new BtManager();
                }
            }
        }
        return f2768x;
    }

    /* renamed from: a */
    public void m3519a(Context context) {
        this.f2771C = context;
        this.f2783y = BluetoothAdapter.getDefaultAdapter();
        if (this.f2783y == null) {
            LogUtil.d(f2747a, "INIT STAGE: Failed to obtain Bluetooth Adapter for MD");
            return;
        }
        m3504l();
        m3506m();
    }

    /* renamed from: l */
    private void m3504l() {
        if (this.f2783y != null) {
            try {
                this.f2783y.getProfileProxy(this.f2771C, new C10522(this), 1);
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.d(f2747a, "INIT STAGE: getProfileProxy Exception");
            }
        }
    }

    /* renamed from: m */
    private void m3506m() {
        if (this.f2783y != null) {
            try {
                this.f2783y.getProfileProxy(this.f2771C, new C10533(this), 2);
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.d(f2747a, "INIT STAGE: getA2dpProxy Exception");
            }
        }
    }

    /* renamed from: b */
    public void m3522b() {
        if (this.f2773E != null) {
            List<BluetoothDevice> devices = this.f2773E.getConnectedDevices();
            if (devices != null) {
                for (BluetoothDevice device : devices) {
                    if (device != null) {
                        try {
                            if (this.f2773E != null) {
                                if (BtUtils.m3618c(this.f2773E.getClass(), this.f2773E, device)) {
                                    LogUtil.d(f2747a, "BtUtils.disconnectA2dp = TRUE ");
                                } else {
                                    LogUtil.d(f2747a, "BtUtils.disconnectA2dp = FALSE");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public int m3524c() {
        int connState = 0;
        try {
            if (this.f2783y != null) {
                connState = this.f2783y.getProfileConnectionState(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.d(f2747a, "Failed in getConnectionState");
        }
        return connState;
    }

    /* renamed from: d */
    public int m3526d() {
        int state = m3524c();
        LogUtil.d(f2747a, "checkHfpConnection state = " + state);
        if (state == 0) {
            LogUtil.d(f2747a, "HFP is disconnected");
            return 1;
        } else if (state == 2) {
            if (m3525c(this.f2769A)) {
                return 3;
            }
            List<BluetoothDevice> devices = m3532j();
            if (devices == null || devices.size() == 0) {
                return 1;
            }
            m3518t();
            return 2;
        } else if (state == 1) {
            LogUtil.d(f2747a, "HFP is connecting");
            return 2;
        } else if (state != 3) {
            return 2;
        } else {
            LogUtil.d(f2747a, "HFP is disconnecting");
            return 2;
        }
    }

    /* renamed from: e */
    public void m3527e() {
        if (this.f2772D != null && this.f2783y != null) {
            this.f2783y.closeProfileProxy(1, this.f2772D);
            LogUtil.d(f2747a, "UNINIT STAGE: Close headset proxy");
        }
    }

    /* renamed from: f */
    public void m3528f() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(BtUtils.f2830c);
        filter.addAction(BtUtils.f2831d);
        filter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        filter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        if (this.f2771C != null) {
            this.f2771C.registerReceiver(this.f2780L, filter);
        }
        LogUtil.d(f2747a, "INIT STAGE: register Bluetooth broadcast receiver");
        if (this.f2781v != null) {
            LogUtil.d(f2747a, "start register msg handler");
            MsgHandlerCenter.m4460a(this.f2781v);
        }
    }

    /* renamed from: g */
    public void m3529g() {
        if (!(this.f2771C == null || this.f2780L == null)) {
            try {
                this.f2771C.unregisterReceiver(this.f2780L);
                LogUtil.d(f2747a, "UNINIT STAGE: unregister Bluetooth broadcast receiver");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f2781v != null) {
            MsgHandlerCenter.m4464b(this.f2781v);
        }
    }

    /* renamed from: h */
    public void m3530h() {
    }

    /* renamed from: i */
    public void m3531i() {
        new Thread(new C10544(this)).start();
    }

    /* renamed from: b */
    private void m3479b(String addr, String pincode) {
        if (m3514q()) {
            LogUtil.d(f2747a, "IDLE STAGE: Bluetooth Adapter is enabled yet!");
            this.f2776H = 10;
            Message pollMsg = new Message();
            pollMsg.what = 21;
            this.f2782w.sendMessageDelayed(pollMsg, 1000);
        } else if (this.f2783y != null) {
            new Thread(new C10555(this)).start();
        }
    }

    /* renamed from: n */
    private void m3507n() {
        BtDeviceManager.m3360a().m3392n();
        if (this.f2782w != null) {
            this.f2782w.removeMessages(24);
            this.f2782w.removeMessages(40);
            this.f2782w.removeMessages(41);
            this.f2782w.removeMessages(23);
        }
    }

    /* renamed from: o */
    private void m3510o() {
    }

    /* renamed from: a */
    private void m3473a(int errcode) {
        switch (errcode) {
            case -4:
                LogUtil.d(f2747a, "Auto-Pair Failed in checking hfp connection");
                break;
            case -3:
                LogUtil.d(f2747a, "Auto-Pair Failed in connecting");
                break;
            case -2:
                LogUtil.d(f2747a, "Auto-Pair Failed in pairing");
                break;
            case -1:
                LogUtil.d(f2747a, "Auto-Pair Failed in enabling adapter");
                break;
        }
        if (this.f2782w != null) {
            this.f2782w.removeMessages(24);
            this.f2782w.removeMessages(40);
            this.f2782w.removeMessages(41);
            this.f2782w.removeMessages(23);
        }
        BtDeviceManager.m3360a().m3391m();
    }

    /* renamed from: a */
    public void m3521a(String remoteAddr, String pincode) {
        LogUtil.d(f2747a, "HU ---> MD : HU OOB INFO IDLE, addr = " + remoteAddr + ",pincode = " + pincode);
        Message msg = new Message();
        msg.what = 0;
        Bundle bundle = new Bundle();
        bundle.putString("bdaddr", remoteAddr);
        bundle.putString("pin", pincode);
        msg.setData(bundle);
        if (this.f2782w != null) {
            this.f2782w.sendMessage(msg);
        }
    }

    /* renamed from: a */
    public void m3520a(String remoteAddr) {
        LogUtil.d(f2747a, "HU ---> MD : HU OOB INFO READY, addr = " + remoteAddr);
        if (remoteAddr == null || !remoteAddr.equals(this.f2769A)) {
            LogUtil.d(f2747a, "PAIR STAGE: Received invalid address from HU");
        } else if (m3502k(remoteAddr)) {
            LogUtil.d(f2747a, "PAIR STAGE: has been paired, just do hfp connection");
            m3485d(remoteAddr);
        } else {
            LogUtil.d(f2747a, "PAIR STAGE: not paired, start pairing...");
            m3488e(remoteAddr);
        }
    }

    /* renamed from: b */
    public void m3523b(String remoteAddr) {
        LogUtil.d(f2747a, "HU ---> MD : HU OOB INFO DONE, addr = " + remoteAddr);
        BtDeviceManager.m3360a().m3392n();
    }

    /* renamed from: d */
    private void m3485d(String address) {
        if (this.f2782w != null) {
            Message connectMsg = new Message();
            connectMsg.what = 40;
            Bundle bundle = new Bundle();
            bundle.putString("bdaddr", address);
            connectMsg.setData(bundle);
            if (this.f2782w != null) {
                this.f2778J = 3;
                this.f2782w.sendMessage(connectMsg);
            }
        }
    }

    /* renamed from: e */
    private void m3488e(String address) {
        if (this.f2782w != null) {
            Message pairMsg = new Message();
            pairMsg.what = 41;
            Bundle bundle = new Bundle();
            bundle.putString("bdaddr", address);
            pairMsg.setData(bundle);
            if (this.f2782w != null) {
                this.f2777I = 3;
                this.f2782w.sendMessage(pairMsg);
            }
        }
    }

    /* renamed from: p */
    private boolean m3512p() {
        if (this.f2783y == null) {
            return false;
        }
        return this.f2783y.enable();
    }

    /* renamed from: q */
    private boolean m3514q() {
        if (this.f2783y != null) {
            return this.f2783y.isEnabled();
        }
        return false;
    }

    /* renamed from: r */
    private void m3515r() {
    }

    /* renamed from: j */
    public List<BluetoothDevice> m3532j() {
        List<BluetoothDevice> connectedDevices = null;
        try {
            if (this.f2772D != null) {
                connectedDevices = this.f2772D.getConnectedDevices();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connectedDevices;
    }

    /* renamed from: k */
    public boolean m3533k() {
        if (!m3514q()) {
            return false;
        }
        List<BluetoothDevice> deviceList = m3532j();
        if (deviceList == null || deviceList.size() == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public boolean m3525c(String address) {
        List<BluetoothDevice> devices = m3532j();
        if (devices == null || devices.size() == 0) {
            LogUtil.d(f2747a, "isHfpConnectWith: Connected device list is NULL");
            return false;
        } else if (BluetoothAdapter.checkBluetoothAddress(address)) {
            for (BluetoothDevice device : devices) {
                if (device != null) {
                    String bdaddr = device.getAddress();
                    if (TextUtils.isEmpty(address) || !address.equals(bdaddr)) {
                        LogUtil.d(f2747a, "isHfpConnectWith: Bluetooth has been connected with wrong device");
                    } else {
                        LogUtil.d(f2747a, "isHfpConnectWith: Bluetooth has been connected with correct device");
                        return true;
                    }
                }
            }
            return false;
        } else {
            LogUtil.d(f2747a, "isHfpConnectWith: Bluetooth address is invalid");
            return false;
        }
    }

    /* renamed from: s */
    private int m3517s() {
        return 0;
    }

    /* renamed from: t */
    private void m3518t() {
        List<BluetoothDevice> devices = m3532j();
        if (devices != null) {
            for (BluetoothDevice device : devices) {
                if (device != null) {
                    try {
                        if (this.f2772D != null) {
                            if (BtUtils.m3615b(this.f2772D.getClass(), this.f2772D, device)) {
                                LogUtil.d(f2747a, "PAIR STAGE: BtUtils.disconnect = TRUE ");
                            } else {
                                LogUtil.d(f2747a, "PAIR STAGE: BtUtils.disconnect = FALSE");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: f */
    private void m3491f(String address) {
        if (address != null && BluetoothAdapter.checkBluetoothAddress(address)) {
            BluetoothDevice device = this.f2783y.getRemoteDevice(address);
            if (this.f2772D != null && device != null) {
                try {
                    if (BtUtils.m3611a(this.f2772D.getClass(), this.f2772D, device)) {
                        LogUtil.d(f2747a, "PAIR STAGE: BtUtils.connect = TRUE ");
                    } else {
                        LogUtil.d(f2747a, "PAIR STAGE: BtUtils.connect = FALSE");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtil.d(f2747a, "PAIR STAGE: BtUtils.connect exception");
                }
            }
        }
    }

    /* renamed from: g */
    private boolean m3494g(String address) {
        if (this.f2783y == null || TextUtils.isEmpty(address)) {
            LogUtil.d(f2747a, "pair: mBluetoothAdapter is NULL");
            return false;
        } else if (BluetoothAdapter.checkBluetoothAddress(address)) {
            BluetoothDevice device = this.f2783y.getRemoteDevice(address);
            if (device == null) {
                LogUtil.d(f2747a, "pair: Bluetooth Device is null");
                return false;
            }
            try {
                boolean bond = BtUtils.m3608a(device.getClass(), device);
                if (bond) {
                    LogUtil.d(f2747a, "PAIR STAGE: BtUtils.createBond = TRUE ");
                    return bond;
                }
                LogUtil.d(f2747a, "PAIR STAGE: BtUtils.createBond = FALSE");
                return bond;
            } catch (Exception e) {
                e.printStackTrace();
                if (!Build.DEVICE.toLowerCase().equals("hwh30-t00")) {
                    return false;
                }
                LogUtil.d(f2747a, "PAIR STAGE: Special case for Huawei Honor");
                return true;
            }
        } else {
            LogUtil.d(f2747a, "pair: address is invalid");
            return false;
        }
    }

    /* renamed from: h */
    private void m3496h(String address) {
        if (this.f2783y != null) {
            BluetoothDevice device = this.f2783y.getRemoteDevice(address);
            if (device != null) {
                try {
                    if (BtUtils.m3617c(device.getClass(), device)) {
                        LogUtil.d(f2747a, "PAIR STAGE: BtUtils.removeBond = TRUE ");
                    } else {
                        LogUtil.d(f2747a, "PAIR STAGE: BtUtils.removeBond = FALSE");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: i */
    private void m3498i(String address) {
        if (this.f2783y == null) {
            LogUtil.d(f2747a, "stopPair: mBluetoothAdapter is NULL");
        } else if (BluetoothAdapter.checkBluetoothAddress(address)) {
            BluetoothDevice device = this.f2783y.getRemoteDevice(address);
            if (device == null) {
                LogUtil.d(f2747a, "stopPair: Bluetooth Device is NULL");
            } else if (this.f2783y != null && device != null) {
                try {
                    if (BtUtils.m3614b(device.getClass(), device)) {
                        LogUtil.d(f2747a, "PAIR STAGE: BtUtils.cancelBondProcess = TRUE ");
                    } else {
                        LogUtil.d(f2747a, "PAIR STAGE: BtUtils.cancelBondProcess = FALSE");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtil.d(f2747a, "stopPair: Exception in cancelBondProcess");
                }
            }
        } else {
            LogUtil.d(f2747a, "stopPair: address is invalid");
        }
    }

    /* renamed from: j */
    private int m3500j(String address) {
        if (this.f2783y == null) {
            return 10;
        }
        BluetoothDevice device = this.f2783y.getRemoteDevice(address);
        if (device != null) {
            return device.getBondState();
        }
        return 10;
    }

    /* renamed from: k */
    private boolean m3502k(String addr) {
        boolean result = false;
        if (this.f2783y == null) {
            return 0;
        }
        Set<BluetoothDevice> pairedList = this.f2783y.getBondedDevices();
        if (pairedList != null && pairedList.size() > 0) {
            for (BluetoothDevice device : pairedList) {
                String bdaddr = device.getAddress();
                if (bdaddr != null && bdaddr.equals(addr)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
