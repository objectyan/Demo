package com.baidu.carlife.bluetooth;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.Builder;
import com.baidu.carlife.protobuf.CarlifeBTHfpRequestProto.CarlifeBTHfpRequest;
import com.baidu.carlife.protobuf.CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd;
import com.baidu.carlife.protobuf.CarlifeBTPairInfoProto.CarlifeBTPairInfo;
import com.baidu.carlife.protobuf.CarlifeBTStartPairReqProto.CarlifeBTStartPairReq;

/* compiled from: BtHfpProtocolHelper */
/* renamed from: com.baidu.carlife.bluetooth.c */
public class C1048c {
    /* renamed from: a */
    private static final String f2739a = "CarlifeActivity#BtHfpProtocolHelper";

    /* renamed from: a */
    public static void m3441a(boolean isForegroud) {
        C1048c.m3442a(C1190a.m4065a(), isForegroud);
    }

    /* renamed from: a */
    public static void m3442a(boolean isInternalScreen, boolean isForeground) {
        if (isInternalScreen) {
            C1260i.m4435b(f2739a, "sendForegroundStatusMsg internal screen capture. ");
        } else if (C1663a.m5979a().m6046m()) {
            C1212c command = new C1212c(true);
            if (isForeground) {
                C1260i.m4435b(f2739a, "sent foreground message");
                command.m4201c(C1253f.ao);
            } else {
                C1260i.m4435b(f2739a, "sent background message");
                command.m4201c(C1253f.ap);
            }
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }
    }

    /* renamed from: a */
    public static void m3431a() {
        if (C1190a.m4065a()) {
            C1212c command = new C1212c(true);
            C1260i.m4435b(f2739a, "sent foreground message");
            command.m4201c(C1253f.ao);
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }
    }

    /* renamed from: a */
    public static void m3432a(int status) {
        CarlifeBTPairInfo btPairInfo = C1048c.m3444b(status);
        if (btPairInfo != null) {
            C1048c.m3438a(btPairInfo);
            C1260i.m4435b(f2739a, "MD ---> HU: BT OOB Info,status = " + status);
        }
    }

    /* renamed from: a */
    public static void m3433a(int cmd, int code) {
        CarlifeBTHfpRequest hFPRequest = C1048c.m3443b(cmd, code);
        if (hFPRequest != null) {
            C1048c.m3436a(hFPRequest);
            C1260i.m4435b(f2739a, "MD --- >HU: DTMF_CODE, code =  " + code);
        }
    }

    /* renamed from: a */
    public static void m3434a(int cmd, String phoneNum) {
        CarlifeBTHfpRequest hFPRequest = C1048c.m3448d(cmd, phoneNum);
        if (hFPRequest != null) {
            C1048c.m3436a(hFPRequest);
            C1260i.m4435b(f2739a, "MD ---> HU: HFP_REQUEST, cmd = " + cmd);
        }
    }

    /* renamed from: a */
    public static void m3440a(String address) {
        CarlifeBTStartPairReq btStartPairReq = C1048c.m3445b(address);
        if (btStartPairReq != null) {
            C1048c.m3439a(btStartPairReq);
            C1260i.m4435b(f2739a, "MD ---> HU: START_PAIR, addr = " + address);
        }
    }

    /* renamed from: b */
    public static void m3446b(int state, String address) {
        CarlifeBTHfpConnection btHFPConnection = C1048c.m3449e(state, address);
        if (btHFPConnection != null) {
            C1048c.m3435a(btHFPConnection);
            C1260i.m4435b(f2739a, "MD ---> HU: HFP Connection Status Indication : " + state);
        }
    }

    /* renamed from: c */
    public static void m3447c(int status, String address) {
        CarlifeBTIdentifyResultInd btIdentifyResultInd = C1048c.m3450f(status, address);
        if (btIdentifyResultInd != null) {
            C1048c.m3437a(btIdentifyResultInd);
            C1260i.m4435b(f2739a, "MD ---> HU: Identify Result Indication : " + status);
        }
    }

    /* renamed from: a */
    private static void m3435a(CarlifeBTHfpConnection btHFPConnection) {
        if (btHFPConnection != null) {
            C1212c btCommand = new C1212c(true);
            btCommand.m4201c(C1253f.aJ);
            btCommand.m4199b(btHFPConnection.toByteArray());
            btCommand.m4203d(btHFPConnection.getSerializedSize());
            C1663a.m5979a().m6017a(Message.obtain(null, btCommand.m4202d(), 1001, 0, btCommand));
        }
    }

    /* renamed from: a */
    private static void m3437a(CarlifeBTIdentifyResultInd btIdentifyResultInd) {
        if (btIdentifyResultInd != null) {
            C1212c btCommand = new C1212c(true);
            btCommand.m4201c(C1253f.ba);
            btCommand.m4199b(btIdentifyResultInd.toByteArray());
            btCommand.m4203d(btIdentifyResultInd.getSerializedSize());
            C1663a.m5979a().m6017a(Message.obtain(null, btCommand.m4202d(), 1001, 0, btCommand));
        }
    }

    /* renamed from: e */
    private static CarlifeBTHfpConnection m3449e(int state, String address) {
        Builder builder = CarlifeBTHfpConnection.newBuilder();
        if (builder == null) {
            return null;
        }
        if (TextUtils.isEmpty(address)) {
            builder.setAddress("");
        } else {
            builder.setAddress(address);
        }
        builder.setState(state);
        return builder.build();
    }

    /* renamed from: f */
    private static CarlifeBTIdentifyResultInd m3450f(int status, String address) {
        CarlifeBTIdentifyResultInd.Builder builder = CarlifeBTIdentifyResultInd.newBuilder();
        if (builder == null) {
            return null;
        }
        if (TextUtils.isEmpty(address)) {
            builder.setAddress("");
        } else {
            builder.setAddress(address);
        }
        builder.setStatus(status);
        return builder.build();
    }

    /* renamed from: a */
    public static void m3438a(CarlifeBTPairInfo carlifeBTOOBInfo) {
        if (carlifeBTOOBInfo != null) {
            C1212c btCommand = new C1212c(true);
            btCommand.m4201c(C1253f.f3540G);
            btCommand.m4199b(carlifeBTOOBInfo.toByteArray());
            btCommand.m4203d(carlifeBTOOBInfo.getSerializedSize());
            C1663a.m5979a().m6017a(Message.obtain(null, btCommand.m4202d(), 1001, 0, btCommand));
        }
    }

    /* renamed from: a */
    public static void m3439a(CarlifeBTStartPairReq carlifeBTStartPairReq) {
        if (carlifeBTStartPairReq != null) {
            C1212c btCommand = new C1212c(true);
            btCommand.m4201c(C1253f.aT);
            btCommand.m4199b(carlifeBTStartPairReq.toByteArray());
            btCommand.m4203d(carlifeBTStartPairReq.getSerializedSize());
            C1663a.m5979a().m6017a(Message.obtain(null, btCommand.m4202d(), 1001, 0, btCommand));
        }
    }

    /* renamed from: b */
    private static CarlifeBTStartPairReq m3445b(String address) {
        CarlifeBTStartPairReq.Builder builder = CarlifeBTStartPairReq.newBuilder();
        if (builder == null) {
            return null;
        }
        if (TextUtils.isEmpty(address)) {
            builder.setAddress("");
        } else {
            builder.setAddress(address);
        }
        builder.setOstype(0);
        return builder.build();
    }

    /* renamed from: b */
    private static CarlifeBTPairInfo m3444b(int status) {
        String mMobileBTAddress = C1079i.m3605a();
        if (mMobileBTAddress == null || mMobileBTAddress == "") {
            return null;
        }
        CarlifeBTPairInfo.Builder builder = CarlifeBTPairInfo.newBuilder();
        if (builder == null) {
            return null;
        }
        if (TextUtils.isEmpty(mMobileBTAddress)) {
            builder.setAddress("");
        } else {
            builder.setAddress(mMobileBTAddress);
        }
        String name = C1079i.m3613b();
        if (TextUtils.isEmpty(name)) {
            builder.setName("");
        } else {
            builder.setName(name);
        }
        builder.setStatus(status);
        builder.setUuid("00001101-0000-1000-8000-00805F9B34FB");
        builder.setPassKey("1234");
        builder.setRandomizer("1234");
        return builder.build();
    }

    /* renamed from: a */
    public static void m3436a(CarlifeBTHfpRequest hFPRequest) {
        C1260i.m4435b(f2739a, "MD--->HU : Request");
        if (hFPRequest != null && C1663a.m5979a().m5993N()) {
            C1212c btCommand = new C1212c(true);
            btCommand.m4201c(C1253f.aH);
            btCommand.m4199b(hFPRequest.toByteArray());
            btCommand.m4203d(hFPRequest.getSerializedSize());
            C1663a.m5979a().m6017a(Message.obtain(null, btCommand.m4202d(), 1001, 0, btCommand));
        }
    }

    /* renamed from: d */
    public static CarlifeBTHfpRequest m3448d(int cmdID, String phoneNum) {
        CarlifeBTHfpRequest.Builder builder = CarlifeBTHfpRequest.newBuilder();
        if (builder == null) {
            return null;
        }
        if (TextUtils.isEmpty(phoneNum)) {
            builder.setPhoneNum("");
        } else {
            builder.setPhoneNum(phoneNum);
        }
        builder.setCommand(cmdID);
        return builder.build();
    }

    /* renamed from: b */
    public static CarlifeBTHfpRequest m3443b(int cmdID, int code) {
        CarlifeBTHfpRequest.Builder builder = CarlifeBTHfpRequest.newBuilder();
        if (builder == null) {
            return null;
        }
        builder.setDtmfCode(code);
        builder.setCommand(cmdID);
        return builder.build();
    }
}
