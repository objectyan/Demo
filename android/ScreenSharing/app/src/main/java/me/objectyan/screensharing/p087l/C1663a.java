package com.baidu.carlife.p087l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbAccessory;
import android.os.Message;
import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.AOAConnectManager;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.connect.ConnectClient;
import com.baidu.carlife.core.connect.ConnectManager;
import com.baidu.carlife.core.connect.config.IConfigSyncDone;
import com.baidu.carlife.core.screen.OnStatusChangeListener;
import com.baidu.carlife.core.screen.operation.OnHardKeyCodeEventListener;
import com.baidu.carlife.core.screen.operation.CarlifeTouchManager;
import com.baidu.carlife.core.screen.presentation.CarlifeServiceConnection;
import java.util.ArrayList;

/* compiled from: CarlifeCoreSDK */
/* renamed from: com.baidu.carlife.l.a */
public class C1663a implements KeepClass {
    /* renamed from: a */
    public static final String f5112a = "CarlifeCoreSDK";
    /* renamed from: b */
    public static final int f5113b = 4353;
    /* renamed from: c */
    public static final int f5114c = 1;
    /* renamed from: d */
    public static final int f5115d = 2;
    /* renamed from: e */
    public static final int f5116e = 300;
    /* renamed from: f */
    public static final int f5117f = 301;
    /* renamed from: g */
    public static final int f5118g = 302;
    /* renamed from: h */
    public static final int f5119h = 303;
    /* renamed from: i */
    public static final int f5120i = 304;
    /* renamed from: j */
    public static final int f5121j = 305;
    /* renamed from: k */
    public static final boolean f5122k = true;
    /* renamed from: l */
    public static final boolean f5123l = false;
    /* renamed from: m */
    private static C1663a f5124m;

    private C1663a() {
    }

    /* renamed from: a */
    public static C1663a m5979a() {
        if (f5124m == null) {
            f5124m = new C1663a();
        }
        return f5124m;
    }

    /* renamed from: a */
    public void m6008a(Activity activity, Class CarlifeActivityServiceClass, OnStatusChangeListener listener, Drawable maskDrawable, int launchIconId) {
        C1667d.m6102a().m6104a(activity, CarlifeActivityServiceClass, listener, maskDrawable, launchIconId);
    }

    /* renamed from: b */
    public int m6019b() {
        return C1667d.m6102a().m6106b();
    }

    /* renamed from: c */
    public int m6025c() {
        return C1667d.m6102a().m6108c();
    }

    /* renamed from: d */
    public Bitmap m6031d() {
        return C1667d.m6102a().m6110d();
    }

    /* renamed from: e */
    public boolean m6035e() {
        return C1667d.m6102a().m6112e();
    }

    /* renamed from: a */
    public void m6015a(boolean needCheckIDRCnt) {
        C1667d.m6102a().m6105a(needCheckIDRCnt);
    }

    /* renamed from: f */
    public void m6036f() {
        C1667d.m6102a().m6113f();
    }

    /* renamed from: g */
    public void m6039g() {
        C1667d.m6102a().m6114g();
    }

    /* renamed from: h */
    public boolean m6041h() {
        return C1667d.m6102a().m6115h();
    }

    /* renamed from: b */
    public void m6023b(boolean isJPEGMode) {
        C1667d.m6102a().m6107b(isJPEGMode);
    }

    /* renamed from: c */
    public void m6028c(boolean isStart) {
        C1667d.m6102a().m6109c(isStart);
    }

    /* renamed from: i */
    public boolean m6042i() {
        return C1667d.m6102a().m6116i();
    }

    /* renamed from: j */
    public boolean m6043j() {
        return C1667d.m6102a().m6117j();
    }

    /* renamed from: d */
    public void m6032d(boolean isNeedChangeColor) {
        C1667d.m6102a().m6111d(isNeedChangeColor);
    }

    /* renamed from: k */
    public void m6044k() {
        C1667d.m6102a().m6118k();
    }

    /* renamed from: l */
    public void m6045l() {
        C1667d.m6102a().m6119l();
    }

    /* renamed from: a */
    public void m6006a(int requestCode, int resultCode, Intent data) {
        C1667d.m6102a().m6103a(requestCode, resultCode, data);
    }

    /* renamed from: m */
    public boolean m6046m() {
        return C1667d.m6102a().m6120m();
    }

    /* renamed from: n */
    public CarlifeServiceConnection m6047n() {
        return C1667d.m6102a().m6121n();
    }

    /* renamed from: a */
    public void m6007a(int bottomBarHeight, OnHardKeyCodeEventListener listener) {
        CarlifeTouchManager.m4515a().m4537a(bottomBarHeight, listener);
    }

    /* renamed from: a */
    public void m6012a(OnHardKeyCodeEventListener listener) {
        CarlifeTouchManager.m4515a().m4544b(listener);
    }

    /* renamed from: o */
    public int m6048o() {
        return CarlifeTouchManager.m4515a().m4548d();
    }

    /* renamed from: p */
    public int m6049p() {
        return CarlifeTouchManager.m4515a().m4551e();
    }

    /* renamed from: q */
    public int m6050q() {
        return CarlifeTouchManager.m4515a().m4554f();
    }

    /* renamed from: r */
    public int m6051r() {
        return CarlifeTouchManager.m4515a().m4557g();
    }

    /* renamed from: s */
    public boolean m6052s() {
        return C1665b.m6061a().m6072b();
    }

    /* renamed from: t */
    public boolean m6053t() {
        return C1665b.m6061a().m6075c();
    }

    /* renamed from: a */
    public void m6013a(String filePath) {
        C1665b.m6061a().m6066a(filePath, null);
    }

    /* renamed from: a */
    public void m6014a(String filePath, ArrayList<String> fileList) {
        C1665b.m6061a().m6066a(filePath, (ArrayList) fileList);
    }

    /* renamed from: u */
    public void m6054u() {
        C1665b.m6061a().m6076d();
    }

    /* renamed from: v */
    public void m6055v() {
        C1665b.m6061a().m6077e();
    }

    /* renamed from: w */
    public void m6056w() {
        C1665b.m6061a().m6078f();
    }

    /* renamed from: x */
    public void m6057x() {
        C1665b.m6061a().m6088p();
    }

    /* renamed from: a */
    public void m6005a(int sampleRate, int channels, int bitsPerSample) {
        C1665b.m6061a().m6063a(sampleRate, channels, bitsPerSample);
    }

    /* renamed from: y */
    public void m6058y() {
        C1665b.m6061a().m6079g();
    }

    /* renamed from: z */
    public void m6059z() {
        C1665b.m6061a().m6080h();
    }

    /* renamed from: A */
    public void m5980A() {
        C1665b.m6061a().m6081i();
    }

    /* renamed from: a */
    public void m6016a(byte[] buffer, int size) {
        C1665b.m6061a().m6067a(buffer, size);
    }

    /* renamed from: b */
    public void m6021b(int sampleRate, int channelConfig, int sampleFormat) {
        C1665b.m6061a().m6070b(sampleRate, channelConfig, sampleFormat);
    }

    /* renamed from: B */
    public void m5981B() {
        C1665b.m6061a().m6082j();
    }

    /* renamed from: C */
    public boolean m5982C() {
        return C1665b.m6061a().m6083k();
    }

    /* renamed from: D */
    public boolean m5983D() {
        return C1665b.m6061a().m6085m();
    }

    /* renamed from: b */
    public void m6024b(byte[] ttsPCMData, int dataLen) {
        C1665b.m6061a().m6071b(ttsPCMData, dataLen);
    }

    /* renamed from: c */
    public void m6027c(int sampleRate, int channelConfig, int sampleFormat) {
        C1665b.m6061a().m6073c(sampleRate, channelConfig, sampleFormat);
    }

    /* renamed from: E */
    public void m5984E() {
        C1665b.m6061a().m6084l();
    }

    /* renamed from: c */
    public void m6029c(byte[] ttsPCMData, int dataLen) {
        C1665b.m6061a().m6074c(ttsPCMData, dataLen);
    }

    /* renamed from: F */
    public void m5985F() {
        C1665b.m6061a().m6086n();
    }

    /* renamed from: G */
    public void m5986G() {
        C1665b.m6061a().m6087o();
    }

    /* renamed from: H */
    public void m5987H() {
        C1665b.m6061a().m6089q();
    }

    /* renamed from: a */
    public void m6009a(Context context) {
        C1665b.m6061a().m6065a(context);
    }

    /* renamed from: I */
    public void m5988I() {
        C1665b.m6061a().m6090r();
    }

    /* renamed from: J */
    public boolean m5989J() {
        return C1665b.m6061a().m6091s();
    }

    /* renamed from: a */
    public void m6004a(int mode) {
        C1665b.m6061a().m6062a(mode);
    }

    /* renamed from: K */
    public boolean m5990K() {
        return C1665b.m6061a().m6092t();
    }

    /* renamed from: b */
    public void m6020b(int sr) {
        C1665b.m6061a().m6069b(sr);
    }

    /* renamed from: a */
    public byte[] m6018a(int type, int dataLen) {
        return C1665b.m6061a().m6068a(type, dataLen);
    }

    /* renamed from: b */
    public void m6022b(Context context) {
        ConnectClient.m4207a().m4221a(context);
    }

    /* renamed from: L */
    public void m5991L() {
        ConnectClient.m4207a().m4224b();
    }

    /* renamed from: a */
    public void m6010a(Context context, UsbAccessory accessory) {
        AOAConnectManager.m4143a().m4162a(context, accessory);
    }

    /* renamed from: M */
    public void m5992M() {
        AOAConnectManager.m4143a().m4163b();
    }

    /* renamed from: N */
    public boolean m5993N() {
        return ConnectClient.m4207a().m4225c();
    }

    /* renamed from: O */
    public void m5994O() {
        ConnectClient.m4207a().m4222a(false);
    }

    /* renamed from: a */
    public boolean m6017a(Message msg) {
        if (msg != null) {
            return ConnectClient.m4207a().m4223a(msg);
        }
        LogUtil.m4445e(f5112a, "send error: msg is null");
        return false;
    }

    /* renamed from: P */
    public void m5995P() {
        ConnectManager.m4228a().m4255i();
    }

    /* renamed from: e */
    public void m6034e(boolean is) {
        ConnectManager.m4228a().m4239a(is);
    }

    /* renamed from: Q */
    public void m5996Q() {
        ConnectManager.m4228a().m4248e();
    }

    /* renamed from: R */
    public void m5997R() {
        ConnectManager.m4228a().m4250f();
    }

    /* renamed from: S */
    public int m5998S() {
        return ConnectManager.m4228a().m4240b();
    }

    /* renamed from: c */
    public void m6026c(int serviceType) {
        if (ConnectClient.m4207a().m4225c()) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.m4201c(serviceType);
            ConnectClient.m4207a().m4223a(Message.obtain(null, command.m4202d(), 1001, 0, command));
            return;
        }
        LogUtil.m4445e(f5112a, "--disconnected!!!---");
    }

    /* renamed from: d */
    public int m6030d(byte[] buffer, int len) {
        if (buffer != null) {
            return ConnectManager.m4228a().m4251g(buffer, len);
        }
        LogUtil.m4445e(f5112a, "write error: VR buffer is null");
        return -1;
    }

    /* renamed from: e */
    public int m6033e(byte[] buffer, int len) {
        if (buffer != null) {
            return ConnectManager.m4228a().m4253h(buffer, len);
        }
        LogUtil.m4445e(f5112a, "read error: VR buffer is null");
        return -1;
    }

    /* renamed from: a */
    public int m6003a(CarlifeCmdMessage msg) {
        if (msg != null) {
            return ConnectManager.m4228a().m4241b(msg);
        }
        LogUtil.m4445e(f5112a, "write error: data buffer is null");
        return -1;
    }

    /* renamed from: T */
    public void m5999T() {
        C1666c.m6093a().m6097b();
    }

    /* renamed from: f */
    public void m6037f(boolean flag) {
        C1666c.m6093a().m6095a(flag);
    }

    /* renamed from: U */
    public boolean m6000U() {
        return C1666c.m6093a().m6099c();
    }

    /* renamed from: V */
    public boolean m6001V() {
        return C1666c.m6093a().m6100d();
    }

    /* renamed from: a */
    public void m6011a(IConfigSyncDone syncDone) {
        C1666c.m6093a().m6094a(syncDone);
    }

    /* renamed from: W */
    public void m6002W() {
        C1666c.m6093a().m6101e();
    }

    /* renamed from: f */
    public byte[] m6038f(byte[] rawData, int len) {
        return C1666c.m6093a().m6096a(rawData, len);
    }

    /* renamed from: g */
    public byte[] m6040g(byte[] encryptData, int len) {
        return C1666c.m6093a().m6098b(encryptData, len);
    }
}
