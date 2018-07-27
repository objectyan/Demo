package me.objectyan.screensharing.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbAccessory;
import android.os.Message;
import android.util.Log;

import me.objectyan.screensharing.core.CarlifeScreenUtil;

import me.objectyan.screensharing.core.connect.AOAConnectManager;
import me.objectyan.screensharing.core.connect.CarlifeCmdMessage;
import me.objectyan.screensharing.core.connect.ConnectClient;
import me.objectyan.screensharing.core.connect.ConnectManager;
import me.objectyan.screensharing.core.connect.config.IConfigSyncDone;
import me.objectyan.screensharing.core.screen.OnStatusChangeListener;
import me.objectyan.screensharing.core.screen.operation.CarlifeTouchManager;
import me.objectyan.screensharing.core.screen.operation.OnHardKeyCodeEventListener;
import me.objectyan.screensharing.core.screen.presentation.view.CarLifePresentationController;

import java.util.ArrayList;

public class CarlifeCoreSDK {

    public static final String Tag = "CarlifeCoreSDK";

    private static CarlifeCoreSDK sCarlifeCoreSDK;

    public static CarlifeCoreSDK newInstance() {
        if (sCarlifeCoreSDK == null) {
            sCarlifeCoreSDK = new CarlifeCoreSDK();
        }
        return sCarlifeCoreSDK;
    }

    public void init(Activity activity, Class CarlifeActivityServiceClass,
                     OnStatusChangeListener listener,
                     Drawable maskDrawable, int launchIconId) {
        CarLifePresentationController.newInstance().init(activity, CarlifeActivityServiceClass, listener);
        CarLifePresentationController.newInstance().setMaskDrawable(maskDrawable);
        CarLifePresentationController.newInstance().setLaunchIconId(launchIconId);
        CarlifeScreenUtil.newInstance().initScreenInfo(activity);
    }

    public void initHardListener(int bottomBarHeight, OnHardKeyCodeEventListener listener) {
        CarlifeTouchManager.newInstance().initHardListener(bottomBarHeight, listener);
    }


    public void initHardListener(OnHardKeyCodeEventListener listener) {
        CarlifeTouchManager.newInstance().initHardListener(listener);
    }


    public int getWidth() {
        return CarlifeTouchManager.newInstance().getWidth();
    }


    public int getHeight() {
        return CarlifeTouchManager.newInstance().getHeight();
    }


    public int getWidthPixels() {
        return CarlifeTouchManager.newInstance().getWidthPixels();
    }


    public int getHeightPixels() {
        return CarlifeTouchManager.newInstance().getHeightPixels();
    }


    public boolean initAudioHandler() {
        return CarlifeCoreAudio.newInstance().initCarlifeCoreAudioHandler();
    }


    public boolean quitAudioHandler() {
        return CarlifeCoreAudio.newInstance().quitCarlifeCoreAudioHandler();
    }


    public void sendMsg(String filePath) {
        CarlifeCoreAudio.newInstance().sendMessage1(filePath, null);
    }


    public void sendMsg(String filePath, ArrayList<String> fileList) {
        CarlifeCoreAudio.newInstance().sendMessage1(filePath, (ArrayList) fileList);
    }


    public void sendMsg2() {
        CarlifeCoreAudio.newInstance().sendMessage2();
    }


    public void sendMsg3() {
        CarlifeCoreAudio.newInstance().sendMessage3();
    }


    public void sendMsg4() {
        CarlifeCoreAudio.newInstance().sendMessage4();
    }


    public void m6057x() {
        CarlifeCoreAudio.newInstance().m6088p();
    }


    public void send(int sampleRate, int channels, int bitsPerSample) {
        CarlifeCoreAudio.newInstance().send(sampleRate, channels, bitsPerSample);
    }


    public void m6058y() {
        CarlifeCoreAudio.newInstance().stop();
    }


    public void m6059z() {
        CarlifeCoreAudio.newInstance().m6080h();
    }


    public void m5980A() {
        CarlifeCoreAudio.newInstance().m6081i();
    }


    public void m6016a(byte[] buffer, int size) {
        CarlifeCoreAudio.newInstance().m6067a(buffer, size);
    }


    public void m6021b(int sampleRate, int channelConfig, int sampleFormat) {
        CarlifeCoreAudio.newInstance().m6070b(sampleRate, channelConfig, sampleFormat);
    }


    public void m5981B() {
        CarlifeCoreAudio.newInstance().m6082j();
    }


    public boolean m5982C() {
        return CarlifeCoreAudio.newInstance().m6083k();
    }


    public boolean m5983D() {
        return CarlifeCoreAudio.newInstance().m6085m();
    }


    public void m6024b(byte[] ttsPCMData, int dataLen) {
        CarlifeCoreAudio.newInstance().m6071b(ttsPCMData, dataLen);
    }


    public void m6027c(int sampleRate, int channelConfig, int sampleFormat) {
        CarlifeCoreAudio.newInstance().m6073c(sampleRate, channelConfig, sampleFormat);
    }


    public void m5984E() {
        CarlifeCoreAudio.newInstance().m6084l();
    }


    public void m6029c(byte[] ttsPCMData, int dataLen) {
        CarlifeCoreAudio.newInstance().m6074c(ttsPCMData, dataLen);
    }


    public void m5985F() {
        CarlifeCoreAudio.newInstance().m6086n();
    }


    public void m5986G() {
        CarlifeCoreAudio.newInstance().m6087o();
    }


    public void m5987H() {
        CarlifeCoreAudio.newInstance().m6089q();
    }


    public void m6009a(Context context) {
        CarlifeCoreAudio.newInstance().setMI3MediaVolume(context);
    }


    public void m5988I() {
        CarlifeCoreAudio.newInstance().setStatus();
    }


    public boolean m5989J() {
        return CarlifeCoreAudio.newInstance().isBlueToothMode();
    }


    public void m6004a(int mode) {
        CarlifeCoreAudio.newInstance().setMode(mode);
    }


    public boolean m5990K() {
        return CarlifeCoreAudio.newInstance().isSR();
    }


    public void m6020b(int sr) {
        CarlifeCoreAudio.newInstance().setSR(sr);
    }


    public byte[] m6018a(int type, int dataLen) {
        return CarlifeCoreAudio.newInstance().m6068a(type, dataLen);
    }


    public void initConn(Context context) {
        ConnectClient.newInstance().init(context);
    }


    public void uninitConn() {
        ConnectClient.newInstance().uninit();
    }


    public void initAOA(Context context, UsbAccessory accessory) {
        AOAConnectManager.newInstance().init(context, accessory);
    }


    public void unInitAOA() {
        AOAConnectManager.newInstance().unInit();
    }


    public boolean getISConn() {
        return ConnectClient.newInstance().getIS();
    }


    public void setISFlase() {
        ConnectClient.newInstance().setIS(false);
    }


    public boolean sendMsgToService(Message msg) {
        if (msg != null) {
            return ConnectClient.newInstance().sendMsgToService(msg);
        }
        Log.e(Tag, "send error: msg is null");
        return false;
    }


    public void stopUDP() {
        ConnectManager.newInstance().stopUDP();
    }


    public void setIS(boolean is) {
        ConnectManager.newInstance().setIS(is);
    }


    public void m5996Q() {
        ConnectManager.newInstance().m4248e();
    }


    public void m5997R() {
        ConnectManager.newInstance().m4250f();
    }


    public int getConnType() {
        return ConnectManager.newInstance().getType();
    }


    public void disconnected(int serviceType) {
        if (ConnectClient.newInstance().getIS()) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.setServiceType(serviceType);
            ConnectClient.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(), 1001, 0, command));
            return;
        }
        Log.e(Tag, "--disconnected!!!---");
    }


    public int writeVR(byte[] buffer, int len) {
        if (buffer != null) {
            return ConnectManager.newInstance().writeVR(buffer, len);
        }
        Log.e(Tag, "write error: VR buffer is null");
        return -1;
    }


    public int readVR(byte[] buffer, int len) {
        if (buffer != null) {
            return ConnectManager.newInstance().readVR(buffer, len);
        }
        Log.e(Tag, "read error: VR buffer is null");
        return -1;
    }


    public int writeDate(CarlifeCmdMessage msg) {
        if (msg != null) {
            return ConnectManager.newInstance().writeDate(msg);
        }
        Log.e(Tag, "write error: data buffer is null");
        return -1;
    }


    public void m5999T() {
        CarlifeCoreEncrypt.newInstance().m6097b();
    }


    public void m6037f(boolean flag) {
        CarlifeCoreEncrypt.newInstance().m6095a(flag);
    }


    public boolean m6000U() {
        return CarlifeCoreEncrypt.newInstance().m6099c();
    }


    public boolean m6001V() {
        return CarlifeCoreEncrypt.newInstance().getFlag();
    }


    public void m6011a(IConfigSyncDone syncDone) {
        CarlifeCoreEncrypt.newInstance().m6094a(syncDone);
    }


    public void m6002W() {
        CarlifeCoreEncrypt.newInstance().m6101e();
    }


    public byte[] encrypt(byte[] rawData, int len) {
        return CarlifeCoreEncrypt.newInstance().encrypt(rawData, len);
    }


    public byte[] decrypt(byte[] encryptData, int len) {
        return CarlifeCoreEncrypt.newInstance().decrypt(encryptData, len);
    }
}
