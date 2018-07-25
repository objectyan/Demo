package com.baidu.carlife.bluetooth;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.Builder;
import com.baidu.carlife.protobuf.CarlifeBTHfpRequestProto.CarlifeBTHfpRequest;
import com.baidu.carlife.protobuf.CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd;
import com.baidu.carlife.protobuf.CarlifeBTPairInfoProto.CarlifeBTPairInfo;
import com.baidu.carlife.protobuf.CarlifeBTStartPairReqProto.CarlifeBTStartPairReq;

/* compiled from: BtHfpProtocolHelper */
/* renamed from: com.baidu.carlife.bluetooth.c */
public class BtHfpProtocolHelper {
    /* renamed from: a */
    private static final String f2739a = "CarlifeActivity#BtHfpProtocolHelper";

    /* renamed from: a */
    public static void m3441a(boolean isForegroud) {
        BtHfpProtocolHelper.m3442a(CarlifeConfig.m4065a(), isForegroud);
    }

    /* renamed from: a */
    public static void m3442a(boolean isInternalScreen, boolean isForeground) {
        if (isInternalScreen) {
            LogUtil.d(f2739a, "sendForegroundStatusMsg internal screen capture. ");
        } else if (CarlifeCoreSDK.m5979a().m6046m()) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            if (isForeground) {
                LogUtil.d(f2739a, "sent foreground message");
                command.m4201c(CommonParams.ao);
            } else {
                LogUtil.d(f2739a, "sent background message");
                command.m4201c(CommonParams.ap);
            }
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        }
    }

    /* renamed from: a */
    public static void m3431a() {
        if (CarlifeConfig.m4065a()) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            LogUtil.d(f2739a, "sent foreground message");
            command.m4201c(CommonParams.ao);
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        }
    }

    /* renamed from: a */
    public static void m3432a(int status) {
        CarlifeBTPairInfo btPairInfo = BtHfpProtocolHelper.m3444b(status);
        if (btPairInfo != null) {
            BtHfpProtocolHelper.m3438a(btPairInfo);
            LogUtil.d(f2739a, "MD ---> HU: BT OOB Info,status = " + status);
        }
    }

    /* renamed from: a */
    public static void m3433a(int cmd, int code) {
        CarlifeBTHfpRequest hFPRequest = BtHfpProtocolHelper.m3443b(cmd, code);
        if (hFPRequest != null) {
            BtHfpProtocolHelper.m3436a(hFPRequest);
            LogUtil.d(f2739a, "MD --- >HU: DTMF_CODE, code =  " + code);
        }
    }

    /* renamed from: a */
    public static void m3434a(int cmd, String phoneNum) {
        CarlifeBTHfpRequest hFPRequest = BtHfpProtocolHelper.m3448d(cmd, phoneNum);
        if (hFPRequest != null) {
            BtHfpProtocolHelper.m3436a(hFPRequest);
            LogUtil.d(f2739a, "MD ---> HU: HFP_REQUEST, cmd = " + cmd);
        }
    }

    /* renamed from: a */
    public static void m3440a(String address) {
        CarlifeBTStartPairReq btStartPairReq = BtHfpProtocolHelper.m3445b(address);
        if (btStartPairReq != null) {
            BtHfpProtocolHelper.m3439a(btStartPairReq);
            LogUtil.d(f2739a, "MD ---> HU: START_PAIR, addr = " + address);
        }
    }

    /* renamed from: b */
    public static void m3446b(int state, String address) {
        CarlifeBTHfpConnection btHFPConnection = BtHfpProtocolHelper.m3449e(state, address);
        if (btHFPConnection != null) {
            BtHfpProtocolHelper.m3435a(btHFPConnection);
            LogUtil.d(f2739a, "MD ---> HU: HFP Connection Status Indication : " + state);
        }
    }

    /* renamed from: c */
    public static void m3447c(int status, String address) {
        CarlifeBTIdentifyResultInd btIdentifyResultInd = BtHfpProtocolHelper.m3450f(status, address);
        if (btIdentifyResultInd != null) {
            BtHfpProtocolHelper.m3437a(btIdentifyResultInd);
            LogUtil.d(f2739a, "MD ---> HU: Identify Result Indication : " + status);
        }
    }

    /* renamed from: a */
    private static void m3435a(CarlifeBTHfpConnection btHFPConnection) {
        if (btHFPConnection != null) {
            CarlifeCmdMessage btCommand = new CarlifeCmdMessage(true);
            btCommand.m4201c(CommonParams.aJ);
            btCommand.m4199b(btHFPConnection.toByteArray());
            btCommand.m4203d(btHFPConnection.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, btCommand.getServiceType(), 1001, 0, btCommand));
        }
    }

    /* renamed from: a */
    private static void m3437a(CarlifeBTIdentifyResultInd btIdentifyResultInd) {
        if (btIdentifyResultInd != null) {
            CarlifeCmdMessage btCommand = new CarlifeCmdMessage(true);
            btCommand.m4201c(CommonParams.ba);
            btCommand.m4199b(btIdentifyResultInd.toByteArray());
            btCommand.m4203d(btIdentifyResultInd.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, btCommand.getServiceType(), 1001, 0, btCommand));
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
            CarlifeCmdMessage btCommand = new CarlifeCmdMessage(true);
            btCommand.m4201c(CommonParams.f3540G);
            btCommand.m4199b(carlifeBTOOBInfo.toByteArray());
            btCommand.m4203d(carlifeBTOOBInfo.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, btCommand.getServiceType(), 1001, 0, btCommand));
        }
    }

    /* renamed from: a */
    public static void m3439a(CarlifeBTStartPairReq carlifeBTStartPairReq) {
        if (carlifeBTStartPairReq != null) {
            CarlifeCmdMessage btCommand = new CarlifeCmdMessage(true);
            btCommand.m4201c(CommonParams.aT);
            btCommand.m4199b(carlifeBTStartPairReq.toByteArray());
            btCommand.m4203d(carlifeBTStartPairReq.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, btCommand.getServiceType(), 1001, 0, btCommand));
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
        String mMobileBTAddress = BtUtils.m3605a();
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
        String name = BtUtils.m3613b();
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
        LogUtil.d(f2739a, "MD--->HU : Request");
        if (hFPRequest != null && CarlifeCoreSDK.m5979a().m5993N()) {
            CarlifeCmdMessage btCommand = new CarlifeCmdMessage(true);
            btCommand.m4201c(CommonParams.aH);
            btCommand.m4199b(hFPRequest.toByteArray());
            btCommand.m4203d(hFPRequest.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, btCommand.getServiceType(), 1001, 0, btCommand));
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
