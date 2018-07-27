package com.baidu.carlife.logic;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import com.baidu.carlife.bluetooth.BtUtils;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.CommonParams.EnumVehicleChannel;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.protobuf.CarlifeDeviceInfoProto.CarlifeDeviceInfo;
import com.baidu.carlife.protobuf.CarlifeDeviceInfoProto.CarlifeDeviceInfo.Builder;
import com.baidu.carlife.util.C2186p;

/* compiled from: CarlifeDeviceInfoManager */
/* renamed from: com.baidu.carlife.logic.c */
public class C1747c {
    /* renamed from: a */
    public static final String f5284a = "CarlifeDeviceInfoManager";
    /* renamed from: b */
    private static C1747c f5285b = null;
    /* renamed from: c */
    private static CarlifeDeviceInfo f5286c = null;
    /* renamed from: d */
    private static CarlifeDeviceInfo f5287d = null;

    private C1747c() {
    }

    /* renamed from: a */
    public static C1747c m6337a() {
        if (f5285b == null) {
            synchronized (C1747c.class) {
                if (f5285b == null) {
                    f5285b = new C1747c();
                }
            }
        }
        return f5285b;
    }

    /* renamed from: b */
    public void m6339b() {
        try {
            Builder builder = CarlifeDeviceInfo.newBuilder();
            builder.setOs(CommonParams.jb);
            builder.setBoard(Build.BOARD);
            builder.setBootloader(Build.BOOTLOADER);
            builder.setBrand(Build.BRAND);
            builder.setCpuAbi(Build.CPU_ABI);
            builder.setCpuAbi2(Build.CPU_ABI2);
            builder.setDevice(Build.DEVICE);
            builder.setDisplay(Build.DISPLAY);
            builder.setFingerprint(Build.FINGERPRINT);
            builder.setHardware(Build.HARDWARE);
            builder.setHost(Build.HOST);
            builder.setCid(Build.ID);
            builder.setManufacturer(Build.MANUFACTURER);
            builder.setModel(Build.MODEL);
            builder.setProduct(Build.PRODUCT);
            builder.setSerial(Build.SERIAL);
            builder.setCodename(VERSION.CODENAME);
            builder.setIncremental(VERSION.INCREMENTAL);
            builder.setSdk(VERSION.SDK);
            builder.setSdkInt(VERSION.SDK_INT);
            String channel = C2186p.m8304a().m8309a(CommonParams.jA, "");
            if (EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_ONLINE.getChannel().equals(channel) || EnumVehicleChannel.VEHICLE_CHANNEL_YUANFENG_ELH_PCBA.getChannel().equals(channel)) {
                builder.setRelease("CarLifePhoneVesion:" + CarlifeUtil.m4373g());
            } else {
                builder.setRelease(VERSION.RELEASE);
            }
            builder.setCarlifeversion(CarlifeUtil.m4373g());
            String address = BtUtils.m3605a();
            if (address == "") {
                builder.setBtaddress("unknow");
            } else {
                builder.setBtaddress(address);
            }
            f5286c = builder.build();
        } catch (Exception ex) {
            LogUtil.e(f5284a, "init error");
            ex.printStackTrace();
        }
    }

    /* renamed from: c */
    public CarlifeDeviceInfo m6340c() {
        return f5286c;
    }

    /* renamed from: a */
    public void m6338a(CarlifeDeviceInfo info) {
        f5287d = info;
    }

    /* renamed from: d */
    public CarlifeDeviceInfo m6341d() {
        return f5287d;
    }

    /* renamed from: e */
    public void m6342e() {
        try {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.m4201c(65540);
            command.m4199b(f5286c.toByteArray());
            command.m4203d(f5286c.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        } catch (Exception ex) {
            LogUtil.e(f5284a, "send md info error");
            ex.printStackTrace();
        }
    }
}
