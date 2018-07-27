package com.baidu.carlife.logic;

import android.os.Message;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.model.C1928h;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.protobuf.CarlifeModuleStatusListProto.CarlifeModuleStatusList;
import com.baidu.carlife.protobuf.CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder;
import com.baidu.carlife.protobuf.CarlifeModuleStatusProto.CarlifeModuleStatus;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navisdk.ui.routeguide.BNavigator;

/* compiled from: ModuleStatusManage */
/* renamed from: com.baidu.carlife.logic.k */
public class C1772k {
    /* renamed from: a */
    private static final String f5388a = "ModuleStatusManage";
    /* renamed from: b */
    private static C1772k f5389b;
    /* renamed from: c */
    private C1928h f5390c;
    /* renamed from: d */
    private C1928h f5391d;
    /* renamed from: e */
    private C1928h f5392e;
    /* renamed from: f */
    private C1928h f5393f;
    /* renamed from: g */
    private C1928h f5394g;
    /* renamed from: h */
    private C1928h f5395h;
    /* renamed from: i */
    private C1928h f5396i;

    /* renamed from: a */
    public static synchronized C1772k m6480a() {
        C1772k c1772k;
        synchronized (C1772k.class) {
            if (f5389b == null) {
                synchronized (C1772k.class) {
                    if (f5389b == null) {
                        f5389b = new C1772k();
                    }
                }
            }
            c1772k = f5389b;
        }
        return c1772k;
    }

    public C1772k() {
        if (this.f5390c == null) {
            this.f5390c = new C1928h(1, 0);
        }
        if (this.f5391d == null) {
            this.f5391d = new C1928h(2, 0);
        }
        if (this.f5392e == null) {
            this.f5392e = new C1928h(3, 0);
        }
        if (this.f5393f == null) {
            this.f5393f = new C1928h(4, 0);
        }
        if (this.f5394g == null) {
            this.f5394g = new C1928h(6, 0);
        }
        if (this.f5395h == null) {
            this.f5395h = new C1928h(8, 0);
        }
        if (this.f5396i == null) {
            this.f5396i = new C1928h(9, 0);
        }
    }

    /* renamed from: a */
    public void m6485a(int moduleId, int statusId) {
        switch (moduleId) {
            case 1:
                if (this.f5390c == null) {
                    this.f5390c = new C1928h(moduleId, statusId);
                } else {
                    this.f5390c.m7397b(statusId);
                }
                m6483b(this.f5390c);
                return;
            case 2:
                if (this.f5391d == null) {
                    this.f5391d = new C1928h(moduleId, statusId);
                } else {
                    this.f5391d.m7397b(statusId);
                }
                m6483b(this.f5391d);
                return;
            case 3:
                if (this.f5392e == null) {
                    this.f5392e = new C1928h(moduleId, statusId);
                } else {
                    this.f5392e.m7397b(statusId);
                }
                m6483b(this.f5392e);
                return;
            case 4:
                if (this.f5393f == null) {
                    this.f5393f = new C1928h(moduleId, statusId);
                } else {
                    this.f5393f.m7397b(statusId);
                }
                m6483b(this.f5393f);
                return;
            case 6:
                if (this.f5394g == null) {
                    this.f5394g = new C1928h(moduleId, statusId);
                } else {
                    this.f5394g.m7397b(statusId);
                }
                m6483b(this.f5394g);
                return;
            case 8:
                if (this.f5395h == null) {
                    this.f5395h = new C1928h(moduleId, statusId);
                } else {
                    this.f5395h.m7397b(statusId);
                }
                m6483b(this.f5395h);
                return;
            case 9:
                if (this.f5396i == null) {
                    this.f5396i = new C1928h(moduleId, statusId);
                } else {
                    this.f5396i.m7397b(statusId);
                }
                m6483b(this.f5396i);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void m6487b() {
        Builder builder = CarlifeModuleStatusList.newBuilder();
        if (this.f5390c != null) {
            builder.addModuleStatus(m6481a(this.f5390c));
            LogUtil.d(f5388a, "sendCarlifeModuleListStatus moduleId:" + this.f5390c.m7394a() + " statusId" + this.f5390c.m7396b());
        }
        if (this.f5391d != null) {
            if (C1757d.m6389a().m6393d().getMajorVersion() >= 2) {
                if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                    this.f5391d.m7397b(1);
                } else {
                    this.f5391d.m7397b(0);
                }
            } else if (BaiduNaviSDKManager.getInstance().isNaviBegin() || BaiduNaviSDKManager.getInstance().isCruiseBegin() || BCruiser.getInstance().isCruiseBegin()) {
                this.f5391d.m7397b(1);
            } else {
                this.f5391d.m7397b(0);
            }
            if (!m6488b(CommonParams.sVehicleChannel.getChannel())) {
                if (BNavigator.getInstance().isNaviBegin()) {
                    this.f5391d.m7397b(1);
                } else {
                    this.f5391d.m7397b(0);
                }
            }
            builder.addModuleStatus(m6481a(this.f5391d));
            LogUtil.d(f5388a, "sendCarlifeModuleListStatus moduleId:" + this.f5391d.m7394a() + " statusId" + this.f5391d.m7396b());
        }
        if (this.f5392e != null) {
            builder.addModuleStatus(m6481a(this.f5392e));
            LogUtil.d(f5388a, "sendCarlifeModuleListStatus moduleId:" + this.f5392e.m7394a() + " statusId" + this.f5392e.m7396b());
        }
        if (this.f5393f != null) {
            builder.addModuleStatus(m6481a(this.f5393f));
            LogUtil.d(f5388a, "sendCarlifeModuleListStatus moduleId:" + this.f5393f.m7394a() + " statusId" + this.f5393f.m7396b());
        }
        if (this.f5394g != null) {
            builder.addModuleStatus(m6481a(this.f5394g));
            LogUtil.d(f5388a, "sendCarlifeModuleListStatus moduleId:" + this.f5394g.m7394a() + " statusId" + this.f5394g.m7396b());
        }
        if (C1757d.m6389a().m6393d().getMajorVersion() >= 2) {
            if (this.f5395h != null) {
                if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
                    this.f5395h.m7397b(1);
                } else {
                    this.f5395h.m7397b(0);
                }
                builder.addModuleStatus(m6481a(this.f5395h));
                LogUtil.d(f5388a, "sendCarlifeModuleListStatus moduleId:" + this.f5395h.m7394a() + " statusId" + this.f5395h.m7396b());
            }
            if (this.f5396i != null) {
                if (BCruiser.getInstance().isCruiseBegin()) {
                    this.f5396i.m7397b(1);
                } else {
                    this.f5396i.m7397b(0);
                }
                builder.addModuleStatus(m6481a(this.f5396i));
                LogUtil.d(f5388a, "sendCarlifeModuleListStatus moduleId:" + this.f5396i.m7394a() + " statusId" + this.f5396i.m7396b());
            }
        }
        builder.setCnt(builder.getModuleStatusCount());
        CarlifeModuleStatusList carlifeModuleStatusList = builder.build();
        LogUtil.d(f5388a, "sendCarlifeModuleListStatus carlifeModuleStatusList.size : " + carlifeModuleStatusList.getCnt());
        if (carlifeModuleStatusList != null && carlifeModuleStatusList.getModuleStatusCount() > 0) {
            m6482a(carlifeModuleStatusList);
        }
    }

    /* renamed from: c */
    public int m6489c() {
        if (this.f5390c == null) {
            return 0;
        }
        return this.f5390c.m7396b();
    }

    /* renamed from: d */
    public int m6490d() {
        if (this.f5394g == null) {
            return 0;
        }
        return this.f5394g.m7396b();
    }

    /* renamed from: a */
    private CarlifeModuleStatus m6481a(C1928h moduleStatusModel) {
        if (moduleStatusModel == null) {
            return null;
        }
        CarlifeModuleStatus.Builder moduleStatusBuilder = CarlifeModuleStatus.newBuilder();
        moduleStatusBuilder.setModuleID(moduleStatusModel.m7394a());
        moduleStatusBuilder.setStatusID(moduleStatusModel.m7396b());
        return moduleStatusBuilder.build();
    }

    /* renamed from: b */
    private void m6483b(C1928h module) {
        if (module != null) {
            LogUtil.d(f5388a, "--sendCarlifeModuleStatus--moduleId:" + module.m7394a() + "--statusId:" + module.m7396b());
            Builder builder = CarlifeModuleStatusList.newBuilder();
            builder.addModuleStatus(m6481a(module));
            builder.setCnt(builder.getModuleStatusCount());
            CarlifeModuleStatusList carlifeModuleStatusList = builder.build();
            if (carlifeModuleStatusList != null && carlifeModuleStatusList.getModuleStatusCount() > 0) {
                m6482a(carlifeModuleStatusList);
            }
        }
    }

    /* renamed from: a */
    private void m6482a(CarlifeModuleStatusList carlifeModuleStatusList) {
        if (carlifeModuleStatusList != null && CarlifeCoreSDK.m5979a().m5993N()) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.m4201c(CommonParams.az);
            command.m4199b(carlifeModuleStatusList.toByteArray());
            command.m4203d(carlifeModuleStatusList.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        }
    }

    /* renamed from: a */
    public void m6484a(int statusId) {
        if (CommonParams.sVehicleChannel.getChannel().length() >= 4) {
            String channel = CommonParams.sVehicleChannel.getChannel().substring(0, 4);
            if ("2006".equals(channel) || "2019".equals(channel) || "2020".equals(channel) || m6486a(CommonParams.sVehicleChannel.getChannel())) {
                C1928h module = new C1928h(4, statusId);
                Builder builder = CarlifeModuleStatusList.newBuilder();
                builder.addModuleStatus(m6481a(module));
                builder.setCnt(builder.getModuleStatusCount());
                CarlifeModuleStatusList carlifeModuleStatusList = builder.build();
                if (carlifeModuleStatusList != null && carlifeModuleStatusList.getModuleStatusCount() > 0) {
                    byte[] sendData = carlifeModuleStatusList.toByteArray();
                    int sendLen = carlifeModuleStatusList.getSerializedSize();
                    if (CarlifeCoreSDK.m5979a().m6001V() && sendLen > 0) {
                        sendData = CarlifeCoreSDK.m5979a().m6038f(sendData, sendLen);
                        if (sendData == null) {
                            LogUtil.e(f5388a, "encrypt failed!");
                            return;
                        }
                        sendLen = sendData.length;
                    }
                    C1857p command = new C1857p();
                    command.m7055c(CommonParams.bC);
                    command.m7054c();
                    command.m7049a(sendLen);
                    CarlifeCoreSDK.m5979a().m6030d(command.m7050a(), command.m7051b());
                    CarlifeCoreSDK.m5979a().m6030d(sendData, sendLen);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m6486a(String strChannel) {
        String[] strBoschChannelArray = new String[]{"20262119", "20262120", "20262121", "20262122", "20262123", "20262124", "20262125", "20262126", "20262127", "20262128", "20262108", "20632103"};
        for (String equals : strBoschChannelArray) {
            if (equals.equals(strChannel)) {
                LogUtil.d(f5388a, "is boshi channel : " + strChannel);
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m6488b(String channel) {
        String[] channels = new String[]{"20022100", "20022106", "20032101", "20022107", "20022108", "20022109", "20022110", "20032103", "20041100", "20042100"};
        for (String equalsIgnoreCase : channels) {
            if (channel.equalsIgnoreCase(equalsIgnoreCase)) {
                return false;
            }
        }
        return true;
    }
}
