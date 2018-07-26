package com.baidu.carlife.logic;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import com.baidu.carlife.bluetooth.C1079i;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1253f.C1252a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.p087l.C1663a;
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
            builder.setOs(C1253f.jb);
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
            String channel = C2186p.m8304a().m8309a(C1253f.jA, "");
            if (C1252a.VEHICLE_CHANNEL_YUANFENG_ELH_ONLINE.m4403a().equals(channel) || C1252a.VEHICLE_CHANNEL_YUANFENG_ELH_PCBA.m4403a().equals(channel)) {
                builder.setRelease("CarLifePhoneVesion:" + C1251e.m4373g());
            } else {
                builder.setRelease(VERSION.RELEASE);
            }
            builder.setCarlifeversion(C1251e.m4373g());
            String address = C1079i.m3605a();
            if (address == "") {
                builder.setBtaddress("unknow");
            } else {
                builder.setBtaddress(address);
            }
            f5286c = builder.build();
        } catch (Exception ex) {
            C1260i.m4445e(f5284a, "init error");
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
            C1212c command = new C1212c(true);
            command.m4201c(65540);
            command.m4199b(f5286c.toByteArray());
            command.m4203d(f5286c.getSerializedSize());
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        } catch (Exception ex) {
            C1260i.m4445e(f5284a, "send md info error");
            ex.printStackTrace();
        }
    }
}
