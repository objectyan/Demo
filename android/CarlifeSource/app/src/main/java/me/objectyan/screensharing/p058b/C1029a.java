package com.baidu.carlife.p058b;

import android.os.Message;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.p085i.C1609a;
import com.baidu.carlife.p086j.C1612a;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList;
import com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo;
import com.baidu.carlife.protobuf.CarlifeVehicleInfoListProto.CarlifeVehicleInfoList;
import com.baidu.carlife.protobuf.CarlifeVehicleInfoProto.CarlifeVehicleInfo;
import com.baidu.carlife.protobuf.CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CarDataSubscribeManager */
/* renamed from: com.baidu.carlife.b.a */
public class C1029a {
    /* renamed from: a */
    private static final String f2632a = C1029a.class.getSimpleName();
    /* renamed from: b */
    private static C1029a f2633b;
    /* renamed from: c */
    private List<C1028a> f2634c = new ArrayList();

    /* compiled from: CarDataSubscribeManager */
    /* renamed from: com.baidu.carlife.b.a$a */
    public enum C1028a {
        CAR_DATA_GPS,
        CAR_DATA_VELOCITY,
        CAR_DATA_GYROSCOPE,
        CAR_DATA_ACCELERATION,
        CAR_DATA_GEAR,
        CAR_DATA_OIL
    }

    private C1029a() {
    }

    /* renamed from: a */
    public static C1029a m3268a() {
        if (f2633b == null) {
            f2633b = new C1029a();
        }
        return f2633b;
    }

    /* renamed from: b */
    public void m3273b() {
        m3275d();
    }

    /* renamed from: c */
    public void m3274c() {
        C1609a.m5871a();
        C1609a.f4915a = 1;
        this.f2634c.clear();
    }

    /* renamed from: d */
    public void m3275d() {
        LogUtil.d(f2632a, "carDataSubscribe");
        CarlifeCmdMessage carDataSubscribeCommand = new CarlifeCmdMessage(true);
        carDataSubscribeCommand.m4201c(CommonParams.f3557X);
        CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, carDataSubscribeCommand.getServiceType(), 1001, 0, carDataSubscribeCommand));
        LogUtil.d(f2632a, "sendMsgToService MSG_CMD_CAR_DATA_SUBSCRIBE_REQ");
    }

    /* renamed from: a */
    public void m3272a(CarlifeVehicleInfoList carlifeVehicleInfoList) {
        LogUtil.d(f2632a, "parseFromRspMsgInfo");
        if (carlifeVehicleInfoList != null) {
            this.f2634c.clear();
            for (CarlifeVehicleInfo info : carlifeVehicleInfoList.getVehicleInfoList()) {
                if (info.getModuleID() != C1028a.CAR_DATA_GPS.ordinal()) {
                    this.f2634c.add(C1028a.values()[info.getModuleID()]);
                } else if (info.getFlag() == 1 || info.getFlag() == 2) {
                    this.f2634c.add(C1028a.values()[info.getModuleID()]);
                    C1609a.m5871a();
                    C1609a.f4915a = info.getFlag();
                    m3269a(C1028a.CAR_DATA_GPS.ordinal(), info.getFlag(), 0, true);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3269a(int moduleId, int flag, int frequency, boolean isStart) {
        LogUtil.d(f2632a, "sendCarDataControlMsgToHU moduleId:" + moduleId + " frequency:" + frequency + " isStart:" + isStart);
        Builder builder = CarlifeVehicleInfo.newBuilder();
        if (builder != null) {
            builder.setModuleID(moduleId);
            builder.setFrequency(frequency);
            builder.setFlag(flag);
            CarlifeVehicleInfo carlifeVehicleInfo = builder.build();
            CarlifeCmdMessage carDataControlCommand = new CarlifeCmdMessage(true);
            carDataControlCommand.m4199b(carlifeVehicleInfo.toByteArray());
            carDataControlCommand.m4203d(carlifeVehicleInfo.getSerializedSize());
            if (isStart) {
                carDataControlCommand.m4201c(CommonParams.f3559Z);
            } else {
                carDataControlCommand.m4201c(CommonParams.aa);
            }
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, carDataControlCommand.getServiceType(), 1001, 0, carDataControlCommand));
            LogUtil.d(f2632a, carlifeVehicleInfo.toString());
        }
    }

    /* renamed from: a */
    public static void m3270a(Object obj) {
        try {
            CarlifeSubscribeMobileCarLifeInfoList infoListSource = CarlifeSubscribeMobileCarLifeInfoList.parseFrom(((CarlifeCmdMessage) obj).m4205f());
            int listSize = infoListSource.getSubscribemobileCarLifeInfoList().size();
            if (listSize != infoListSource.getCnt()) {
                LogUtil.e(f2632a, "SubscribemobileCarLifeInfoList().size() != Cnt");
            }
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.m4201c(CommonParams.aL);
            CarlifeSubscribeMobileCarLifeInfoList.Builder builderList = CarlifeSubscribeMobileCarLifeInfoList.newBuilder();
            for (int i = 0; i < listSize; i++) {
                int moduleID = infoListSource.getSubscribemobileCarLifeInfo(i).getModuleID();
                CarlifeSubscribeMobileCarLifeInfo.Builder builder = CarlifeSubscribeMobileCarLifeInfo.newBuilder();
                builder.setModuleID(moduleID);
                switch (moduleID) {
                    case 0:
                        builder.setSupportFlag(true);
                        break;
                    case 1:
                        builder.setSupportFlag(false);
                        break;
                    default:
                        builder.setSupportFlag(false);
                        break;
                }
                builderList.addSubscribemobileCarLifeInfo(builder);
            }
            builderList.setCnt(listSize);
            CarlifeSubscribeMobileCarLifeInfoList infoList = builderList.build();
            command.m4199b(infoList.toByteArray());
            command.m4203d(infoList.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m3271a(Object obj, boolean isStart) {
        try {
            CarlifeSubscribeMobileCarLifeInfoList infoListSource = CarlifeSubscribeMobileCarLifeInfoList.parseFrom(((CarlifeCmdMessage) obj).m4205f());
            int listSize = infoListSource.getSubscribemobileCarLifeInfoList().size();
            if (listSize != infoListSource.getCnt()) {
                LogUtil.e(f2632a, "start SubscribemobileCarLifeInfoList().size() != Cnt");
            }
            for (int i = 0; i < listSize; i++) {
                switch (infoListSource.getSubscribemobileCarLifeInfo(i).getModuleID()) {
                    case 0:
                        if (!isStart) {
                            C1612a.m5884a().m5893b(false);
                            break;
                        } else {
                            C1612a.m5884a().m5893b(true);
                            break;
                        }
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
