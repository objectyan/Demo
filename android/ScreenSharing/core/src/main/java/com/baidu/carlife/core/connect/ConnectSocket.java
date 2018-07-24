package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/* compiled from: ConnectSocket */
/* renamed from: com.baidu.carlife.core.connect.g */
public class ConnectSocket implements KeepClass {
    /* renamed from: a */
    public static final int f3368a = 100;
    /* renamed from: b */
    private static final String f3369b = "ConnectSocket";
    /* renamed from: c */
    private static final String f3370c = "ReadThread";
    /* renamed from: d */
    private static final String f3371d = "WriteThread";
    /* renamed from: e */
    private static final String f3372e = "TouchThread";
    /* renamed from: f */
    private static final int f3373f = 4096;
    /* renamed from: g */
    private static final int f3374g = 327680;
    /* renamed from: h */
    private static final int f3375h = 327680;
    /* renamed from: i */
    private static final String f3376i = "utf-8";
    /* renamed from: r */
    private static int f3377r = 0;
    /* renamed from: s */
    private static int f3378s = 1;
    /* renamed from: j */
    private String f3379j = f3369b;
    /* renamed from: k */
    private C1221a f3380k = null;
    /* renamed from: l */
    private C1223c f3381l = null;
    /* renamed from: m */
    private C1222b f3382m = null;
    /* renamed from: n */
    private Socket f3383n = null;
    /* renamed from: o */
    private BufferedInputStream f3384o = null;
    /* renamed from: p */
    private BufferedOutputStream f3385p = null;
    /* renamed from: q */
    private boolean f3386q = false;
    /* renamed from: t */
    private boolean f3387t = false;
    /* renamed from: u */
    private AESManager f3388u = new AESManager();
    /* renamed from: v */
    private AESManager f3389v = new AESManager();

    /* compiled from: ConnectSocket */
    /* renamed from: com.baidu.carlife.core.connect.g$a */
    private class C1221a extends Thread {
        /* renamed from: a */
        final /* synthetic */ ConnectSocket f3365a;

        public C1221a(ConnectSocket connectSocket) {
            this.f3365a = connectSocket;
            setName(ConnectSocket.f3370c);
        }

        public void run() {
            try {
                C1221a.sleep(100);
                while (this.f3365a.f3386q) {
                    if (this.f3365a.f3383n.isConnected()) {
                        Object carlifeMsg = this.f3365a.m4267i();
                        if (carlifeMsg != null) {
                            MsgHandlerCenter.m4456a(carlifeMsg.m4202d(), 0, 0, carlifeMsg);
                        } else {
                            LogUtil.m4445e(ConnectSocket.f3369b, "read carlife msg fail");
                            return;
                        }
                    }
                    LogUtil.m4445e(ConnectSocket.f3369b, "socket is disconnected when read data");
                    return;
                }
            } catch (InterruptedException e) {
                LogUtil.m4445e(ConnectSocket.f3369b, "get InterruptedException in ReadThread");
                e.printStackTrace();
            } catch (Exception ex) {
                LogUtil.m4445e(ConnectSocket.f3369b, "get Exception in ReadThread");
                ex.printStackTrace();
            }
        }
    }

    /* compiled from: ConnectSocket */
    /* renamed from: com.baidu.carlife.core.connect.g$b */
    private class C1222b extends Thread {
        /* renamed from: a */
        final /* synthetic */ ConnectSocket f3366a;

        public C1222b(ConnectSocket connectSocket) {
            this.f3366a = connectSocket;
            setName(ConnectSocket.f3372e);
        }

        public void run() {
            try {
                C1222b.sleep(100);
                while (this.f3366a.f3386q) {
                    if (this.f3366a.f3383n.isConnected()) {
                        Object carlifeMsg = this.f3366a.m4267i();
                        if (carlifeMsg != null) {
                            int serviceType = carlifeMsg.m4202d();
                            if (serviceType == CommonParams.bH) {
                                this.f3366a.m4272a(true);
                            } else {
                                if (this.f3366a.m4274b()) {
                                    MsgHandlerCenter.m4452a((int) CommonParams.bH);
                                }
                                this.f3366a.m4272a(false);
                            }
                            MsgHandlerCenter.m4456a(serviceType, 0, 0, carlifeMsg);
                        } else {
                            LogUtil.m4445e(ConnectSocket.f3369b, "read touch carlife msg fail");
                            return;
                        }
                    }
                    LogUtil.m4445e(ConnectSocket.f3369b, "socket is disconnected when read touch data");
                    return;
                }
            } catch (InterruptedException e) {
                LogUtil.m4445e(ConnectSocket.f3369b, "get InterruptedException in TouchThread");
                e.printStackTrace();
            } catch (Exception ex) {
                LogUtil.m4445e(ConnectSocket.f3369b, "get Exception in TouchThread");
                ex.printStackTrace();
            }
        }
    }

    /* compiled from: ConnectSocket */
    /* renamed from: com.baidu.carlife.core.connect.g$c */
    private class C1223c extends Thread {
        /* renamed from: a */
        final /* synthetic */ ConnectSocket f3367a;

        public C1223c(ConnectSocket connectSocket) {
            this.f3367a = connectSocket;
            setName(ConnectSocket.f3371d);
        }

        public void run() {
            while (this.f3367a.f3386q) {
                try {
                    if (this.f3367a.f3383n.isConnected()) {
                        CarlifeCmdMessage carlifeMsg = this.f3367a.m4268j();
                        if (carlifeMsg != null) {
                            this.f3367a.m4269a(carlifeMsg);
                        } else {
                            LogUtil.m4445e(ConnectSocket.f3369b, "write carlife msg fail");
                            return;
                        }
                    }
                    LogUtil.m4445e(ConnectSocket.f3369b, "socket is disconnected when write data");
                    return;
                } catch (Exception ex) {
                    LogUtil.m4445e(ConnectSocket.f3369b, "get Exception in WriteThread");
                    ex.printStackTrace();
                    return;
                }
            }
        }
    }

    public ConnectSocket(String socketName, Socket socket) {
        this.f3379j = socketName;
        this.f3383n = socket;
    }

    /* renamed from: a */
    public String m4271a() {
        return this.f3379j;
    }

    /* renamed from: a */
    public void m4272a(boolean is) {
        this.f3387t = is;
    }

    /* renamed from: b */
    public boolean m4274b() {
        return this.f3387t;
    }

    /* renamed from: c */
    public void m4275c() {
        LogUtil.d(f3369b, "Start Conmunication");
        if (!this.f3386q) {
            try {
                this.f3383n.setTcpNoDelay(true);
                this.f3383n.setSendBufferSize(327680);
                this.f3383n.setReceiveBufferSize(327680);
                this.f3384o = new BufferedInputStream(this.f3383n.getInputStream());
                this.f3385p = new BufferedOutputStream(this.f3383n.getOutputStream());
                m4265g();
                m4266h();
                this.f3386q = true;
            } catch (Exception e) {
                LogUtil.m4445e(f3369b, "Start Conmunication Fail");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public void m4276d() {
        LogUtil.d(f3369b, "Stop Conmunication");
        if (this.f3386q) {
            try {
                if (this.f3383n != null) {
                    this.f3383n.close();
                    this.f3383n = null;
                }
                if (this.f3384o != null) {
                    this.f3384o.close();
                    this.f3384o = null;
                }
                if (this.f3385p != null) {
                    this.f3385p.close();
                    this.f3385p = null;
                }
                this.f3386q = false;
            } catch (Exception e) {
                LogUtil.m4445e(f3369b, "Stop Conmunication Fail");
            }
        }
    }

    /* renamed from: g */
    private void m4265g() {
        LogUtil.d(f3369b, "ConnectSocket do shake hands");
        ConnectManager.m4228a().m4238a(this);
    }

    /* renamed from: h */
    private void m4266h() {
        LogUtil.d(f3369b, "ConnectSocket after shake hands");
        if (this.f3379j.equals(CommonParams.SERVER_SOCKET_NAME) || this.f3379j.equals(CommonParams.iT)) {
            this.f3380k = new C1221a(this);
            this.f3380k.start();
        }
        if (this.f3379j.equals(CommonParams.SERVER_SOCKET_TOUCH_NAME)) {
            this.f3382m = new C1222b(this);
            this.f3382m.start();
        }
    }

    /* renamed from: a */
    public int m4269a(CarlifeCmdMessage msg) {
        try {
            if (this.f3385p != null) {
                ConnectSocket.m4259a("SEND CarlifeMsg CMD", msg);
                if (!EncryptSetupManager.m4120a().m4135c() || msg.getLength() <= 0) {
                    this.f3385p.write(msg.toByteArray());
                    this.f3385p.flush();
                    if (msg.getLength() > 0) {
                        this.f3385p.write(msg.getData());
                        this.f3385p.flush();
                    }
                } else {
                    byte[] encryptData = this.f3389v.m4112a(msg.getData(), msg.getData().length);
                    if (encryptData == null) {
                        LogUtil.m4445e(f3369b, "encrypt failed!");
                        return -1;
                    }
                    msg.setLength(encryptData.length);
                    this.f3385p.write(msg.toByteArray());
                    this.f3385p.flush();
                    if (msg.getLength() > 0) {
                        this.f3385p.write(encryptData);
                        this.f3385p.flush();
                    }
                }
                return msg.getLength() + 8;
            }
            LogUtil.m4445e(f3369b, this.f3379j + " Send Data Fail, mOutputStream is null");
            throw new IOException();
        } catch (Exception e) {
            LogUtil.m4445e(f3369b, this.f3379j + " IOException, Send Data Fail");
            ConnectClient.m4207a().m4222a(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public int m4270a(byte[] buffer, int len) {
        try {
            if (this.f3385p != null) {
                if (!CommonParams.SERVER_SOCKET_VIDEO_NAME.equals(this.f3379j)) {
                    ConnectSocket.m4260a("SEND CarlifeMsg " + this.f3379j, buffer, len);
                }
                this.f3385p.write(buffer, 0, len);
                this.f3385p.flush();
                return len;
            }
            LogUtil.m4445e(f3369b, this.f3379j + " Send Data Fail, mOutputStream is null");
            throw new IOException();
        } catch (Exception e) {
            LogUtil.m4445e(f3369b, this.f3379j + " IOException, Send Data Fail");
            ConnectClient.m4207a().m4222a(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: i */
    private CarlifeCmdMessage m4267i() {
        CarlifeCmdMessage carlifeMsg = new CarlifeCmdMessage(false);
        try {
            if (this.f3384o != null) {
                int r;
                int cnt = 8;
                byte[] headBuf = new byte[8];
                int headLen = 0;
                while (cnt > 0) {
                    r = this.f3384o.read(headBuf, headLen, cnt);
                    if (r > 0) {
                        cnt -= r;
                        headLen += r;
                    } else {
                        LogUtil.m4445e(f3369b, this.f3379j + " Receive Carlife Msg Head Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (headLen == 8) {
                    carlifeMsg.m4195a(headBuf);
                    int len = carlifeMsg.getLength();
                    cnt = len;
                    byte[] dataBuf = new byte[len];
                    int dataLen = 0;
                    while (cnt > 0) {
                        r = this.f3384o.read(dataBuf, dataLen, cnt);
                        if (r > 0) {
                            cnt -= r;
                            dataLen += r;
                        } else {
                            LogUtil.m4445e(f3369b, this.f3379j + " Receive Carlife Msg Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        if (!EncryptSetupManager.m4120a().m4135c() || dataLen <= 0) {
                            carlifeMsg.setData(dataBuf);
                        } else {
                            byte[] decryptData = this.f3388u.m4113b(dataBuf, dataLen);
                            if (decryptData == null) {
                                LogUtil.m4445e(f3369b, "decrypt failed!");
                                return null;
                            }
                            carlifeMsg.setLength(decryptData.length);
                            carlifeMsg.setData(decryptData);
                        }
                        ConnectSocket.m4259a("RECV CarlifeMsg " + this.f3379j, carlifeMsg);
                        return carlifeMsg;
                    }
                    LogUtil.m4445e(f3369b, this.f3379j + " Receive Carlife Msg Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                LogUtil.m4445e(f3369b, this.f3379j + " Receive Carlife Msg Head Error: headLen = " + headLen);
                throw new IOException();
            }
            LogUtil.m4445e(f3369b, this.f3379j + " Receive Data Fail, mInputStream is null");
            throw new IOException();
        } catch (Exception e) {
            LogUtil.m4445e(f3369b, this.f3379j + " IOException, Receive Data Fail");
            ConnectClient.m4207a().m4222a(false);
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static CarlifeCmdMessage m4258a(BufferedInputStream tmpInputStream) {
        CarlifeCmdMessage carlifeMsg = new CarlifeCmdMessage(false);
        if (tmpInputStream != null) {
            int cnt = 8;
            try {
                int r;
                byte[] headBuf = new byte[8];
                int headLen = 0;
                while (cnt > 0) {
                    r = tmpInputStream.read(headBuf, headLen, cnt);
                    if (r > 0) {
                        cnt -= r;
                        headLen += r;
                    } else {
                        LogUtil.m4445e(f3369b, "Receive Carlife Msg Head Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (headLen == 8) {
                    carlifeMsg.m4195a(headBuf);
                    int len = carlifeMsg.getLength();
                    cnt = len;
                    byte[] dataBuf = new byte[len];
                    int dataLen = 0;
                    while (cnt > 0) {
                        r = tmpInputStream.read(dataBuf, dataLen, cnt);
                        if (r > 0) {
                            cnt -= r;
                            dataLen += r;
                        } else {
                            LogUtil.m4445e(f3369b, "Receive Carlife Msg Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        carlifeMsg.setData(dataBuf);
                        ConnectSocket.m4259a("RECV CarlifeMsg CMD", carlifeMsg);
                        return carlifeMsg;
                    }
                    LogUtil.m4445e(f3369b, "Receive Carlife Msg Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                LogUtil.m4445e(f3369b, " Receive Carlife Msg Head Error: headLen = " + headLen);
                throw new IOException();
            } catch (Exception e) {
                LogUtil.m4445e(f3369b, "IOException, Receive Data Fail");
                ConnectClient.m4207a().m4222a(false);
                e.printStackTrace();
                return null;
            }
        }
        LogUtil.m4445e(f3369b, "Receive Data Fail, mInputStream is null");
        throw new IOException();
    }

    /* renamed from: b */
    public int m4273b(byte[] buffer, int len) {
        int r = -1;
        try {
            if (this.f3384o != null) {
                int cnt = len;
                int dataLen = 0;
                while (cnt > 0) {
                    r = this.f3384o.read(buffer, dataLen, cnt);
                    if (r > 0) {
                        cnt -= r;
                        dataLen += r;
                    } else {
                        LogUtil.m4445e(f3369b, this.f3379j + " Receive Data Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (dataLen == len) {
                    return dataLen;
                }
                LogUtil.m4445e(f3369b, this.f3379j + " Receive Data Error: dataLen = " + dataLen);
                throw new IOException();
            }
            LogUtil.m4445e(f3369b, this.f3379j + " Receive Data Fail, mInputStream is null");
            throw new IOException();
        } catch (Exception e) {
            LogUtil.m4445e(f3369b, this.f3379j + " IOException, Receive Data Fail");
            ConnectClient.m4207a().m4222a(false);
            e.printStackTrace();
            return r;
        }
    }

    /* renamed from: a */
    private static void m4259a(String tag, CarlifeCmdMessage carlifeMsg) {
        if (CarlifeUtil.m4382t()) {
            try {
                LogUtil.d(f3369b, "[" + tag + "]" + (((("" + "index = " + Integer.toString(carlifeMsg.getIndex())) + ", length = " + Integer.toString(carlifeMsg.getLength())) + ", service_type = 0x" + DigitalTrans.m4317a(carlifeMsg.getServiceType(), 8)) + ", name = " + CommonParams.getMsgName(carlifeMsg.getServiceType())));
            } catch (Exception e) {
                LogUtil.m4445e("TAG", "dumpData get Exception");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m4260a(String tag, byte[] data, int len) {
        if (CarlifeUtil.m4382t() && len >= 4) {
            String msg = "";
            try {
                msg = msg + "length = " + Integer.toString(ByteConvert.m4178b(new byte[]{data[0], data[1], data[2], data[3]}));
                if (len >= 12) {
                    int serviceType = ByteConvert.m4178b(new byte[]{data[8], data[9], data[10], data[11]});
                    String name = CommonParams.getMsgName(serviceType);
                    if (name != null) {
                        msg = (msg + ", service_type = 0x" + DigitalTrans.m4317a(serviceType, 8)) + ", name = " + name;
                    } else {
                        return;
                    }
                }
                LogUtil.d(f3369b, "[" + tag + "]" + msg);
            } catch (Exception e) {
                LogUtil.m4445e("TAG", "dumpData get Exception");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public BufferedInputStream m4277e() {
        return this.f3384o;
    }

    /* renamed from: f */
    public BufferedOutputStream m4278f() {
        return this.f3385p;
    }

    /* renamed from: j */
    private CarlifeCmdMessage m4268j() {
        if (f3377r >= f3378s) {
            return null;
        }
        char c = (char) ((f3377r % 26) + 97);
        CarlifeCmdMessage tcarlifeMsg = new CarlifeCmdMessage(true);
        String ts = "Msg Num:" + Integer.toString(f3377r);
        int len = 4096 - ts.length();
        StringBuffer sb = new StringBuffer(ts);
        for (int j = 0; j < len; j++) {
            sb.append(c);
        }
        try {
            tcarlifeMsg.setData(sb.toString().getBytes(f3376i));
            tcarlifeMsg.setLength(4096);
            f3377r++;
            return tcarlifeMsg;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
