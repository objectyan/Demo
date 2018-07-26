package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.C0689h;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.connect.p070a.C1200b;
import com.baidu.carlife.core.connect.p070a.C1208e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/* compiled from: ConnectSocket */
/* renamed from: com.baidu.carlife.core.connect.g */
public class C1224g implements C0689h {
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
    private C1200b f3388u = new C1200b();
    /* renamed from: v */
    private C1200b f3389v = new C1200b();

    /* compiled from: ConnectSocket */
    /* renamed from: com.baidu.carlife.core.connect.g$a */
    private class C1221a extends Thread {
        /* renamed from: a */
        final /* synthetic */ C1224g f3365a;

        public C1221a(C1224g c1224g) {
            this.f3365a = c1224g;
            setName(C1224g.f3370c);
        }

        public void run() {
            try {
                C1221a.sleep(100);
                while (this.f3365a.f3386q) {
                    if (this.f3365a.f3383n.isConnected()) {
                        Object carlifeMsg = this.f3365a.m4267i();
                        if (carlifeMsg != null) {
                            C1261k.m4456a(carlifeMsg.m4202d(), 0, 0, carlifeMsg);
                        } else {
                            C1260i.m4445e(C1224g.f3369b, "read carlife msg fail");
                            return;
                        }
                    }
                    C1260i.m4445e(C1224g.f3369b, "socket is disconnected when read data");
                    return;
                }
            } catch (InterruptedException e) {
                C1260i.m4445e(C1224g.f3369b, "get InterruptedException in ReadThread");
                e.printStackTrace();
            } catch (Exception ex) {
                C1260i.m4445e(C1224g.f3369b, "get Exception in ReadThread");
                ex.printStackTrace();
            }
        }
    }

    /* compiled from: ConnectSocket */
    /* renamed from: com.baidu.carlife.core.connect.g$b */
    private class C1222b extends Thread {
        /* renamed from: a */
        final /* synthetic */ C1224g f3366a;

        public C1222b(C1224g c1224g) {
            this.f3366a = c1224g;
            setName(C1224g.f3372e);
        }

        public void run() {
            try {
                C1222b.sleep(100);
                while (this.f3366a.f3386q) {
                    if (this.f3366a.f3383n.isConnected()) {
                        Object carlifeMsg = this.f3366a.m4267i();
                        if (carlifeMsg != null) {
                            int serviceType = carlifeMsg.m4202d();
                            if (serviceType == C1253f.bH) {
                                this.f3366a.m4272a(true);
                            } else {
                                if (this.f3366a.m4274b()) {
                                    C1261k.m4452a((int) C1253f.bH);
                                }
                                this.f3366a.m4272a(false);
                            }
                            C1261k.m4456a(serviceType, 0, 0, carlifeMsg);
                        } else {
                            C1260i.m4445e(C1224g.f3369b, "read touch carlife msg fail");
                            return;
                        }
                    }
                    C1260i.m4445e(C1224g.f3369b, "socket is disconnected when read touch data");
                    return;
                }
            } catch (InterruptedException e) {
                C1260i.m4445e(C1224g.f3369b, "get InterruptedException in TouchThread");
                e.printStackTrace();
            } catch (Exception ex) {
                C1260i.m4445e(C1224g.f3369b, "get Exception in TouchThread");
                ex.printStackTrace();
            }
        }
    }

    /* compiled from: ConnectSocket */
    /* renamed from: com.baidu.carlife.core.connect.g$c */
    private class C1223c extends Thread {
        /* renamed from: a */
        final /* synthetic */ C1224g f3367a;

        public C1223c(C1224g c1224g) {
            this.f3367a = c1224g;
            setName(C1224g.f3371d);
        }

        public void run() {
            while (this.f3367a.f3386q) {
                try {
                    if (this.f3367a.f3383n.isConnected()) {
                        C1212c carlifeMsg = this.f3367a.m4268j();
                        if (carlifeMsg != null) {
                            this.f3367a.m4269a(carlifeMsg);
                        } else {
                            C1260i.m4445e(C1224g.f3369b, "write carlife msg fail");
                            return;
                        }
                    }
                    C1260i.m4445e(C1224g.f3369b, "socket is disconnected when write data");
                    return;
                } catch (Exception ex) {
                    C1260i.m4445e(C1224g.f3369b, "get Exception in WriteThread");
                    ex.printStackTrace();
                    return;
                }
            }
        }
    }

    public C1224g(String socketName, Socket socket) {
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
        C1260i.m4435b(f3369b, "Start Conmunication");
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
                C1260i.m4445e(f3369b, "Start Conmunication Fail");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public void m4276d() {
        C1260i.m4435b(f3369b, "Stop Conmunication");
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
                C1260i.m4445e(f3369b, "Stop Conmunication Fail");
            }
        }
    }

    /* renamed from: g */
    private void m4265g() {
        C1260i.m4435b(f3369b, "ConnectSocket do shake hands");
        C1218e.m4228a().m4238a(this);
    }

    /* renamed from: h */
    private void m4266h() {
        C1260i.m4435b(f3369b, "ConnectSocket after shake hands");
        if (this.f3379j.equals(C1253f.iN) || this.f3379j.equals(C1253f.iT)) {
            this.f3380k = new C1221a(this);
            this.f3380k.start();
        }
        if (this.f3379j.equals(C1253f.iS)) {
            this.f3382m = new C1222b(this);
            this.f3382m.start();
        }
    }

    /* renamed from: a */
    public int m4269a(C1212c msg) {
        try {
            if (this.f3385p != null) {
                C1224g.m4259a("SEND CarlifeMsg CMD", msg);
                if (!C1208e.m4120a().m4135c() || msg.m4204e() <= 0) {
                    this.f3385p.write(msg.m4196a());
                    this.f3385p.flush();
                    if (msg.m4204e() > 0) {
                        this.f3385p.write(msg.m4205f());
                        this.f3385p.flush();
                    }
                } else {
                    byte[] encryptData = this.f3389v.m4112a(msg.m4205f(), msg.m4205f().length);
                    if (encryptData == null) {
                        C1260i.m4445e(f3369b, "encrypt failed!");
                        return -1;
                    }
                    msg.m4203d(encryptData.length);
                    this.f3385p.write(msg.m4196a());
                    this.f3385p.flush();
                    if (msg.m4204e() > 0) {
                        this.f3385p.write(encryptData);
                        this.f3385p.flush();
                    }
                }
                return msg.m4204e() + 8;
            }
            C1260i.m4445e(f3369b, this.f3379j + " Send Data Fail, mOutputStream is null");
            throw new IOException();
        } catch (Exception e) {
            C1260i.m4445e(f3369b, this.f3379j + " IOException, Send Data Fail");
            C1215d.m4207a().m4222a(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public int m4270a(byte[] buffer, int len) {
        try {
            if (this.f3385p != null) {
                if (!C1253f.iO.equals(this.f3379j)) {
                    C1224g.m4260a("SEND CarlifeMsg " + this.f3379j, buffer, len);
                }
                this.f3385p.write(buffer, 0, len);
                this.f3385p.flush();
                return len;
            }
            C1260i.m4445e(f3369b, this.f3379j + " Send Data Fail, mOutputStream is null");
            throw new IOException();
        } catch (Exception e) {
            C1260i.m4445e(f3369b, this.f3379j + " IOException, Send Data Fail");
            C1215d.m4207a().m4222a(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: i */
    private C1212c m4267i() {
        C1212c carlifeMsg = new C1212c(false);
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
                        C1260i.m4445e(f3369b, this.f3379j + " Receive Carlife Msg Head Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (headLen == 8) {
                    carlifeMsg.m4195a(headBuf);
                    int len = carlifeMsg.m4204e();
                    cnt = len;
                    byte[] dataBuf = new byte[len];
                    int dataLen = 0;
                    while (cnt > 0) {
                        r = this.f3384o.read(dataBuf, dataLen, cnt);
                        if (r > 0) {
                            cnt -= r;
                            dataLen += r;
                        } else {
                            C1260i.m4445e(f3369b, this.f3379j + " Receive Carlife Msg Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        if (!C1208e.m4120a().m4135c() || dataLen <= 0) {
                            carlifeMsg.m4199b(dataBuf);
                        } else {
                            byte[] decryptData = this.f3388u.m4113b(dataBuf, dataLen);
                            if (decryptData == null) {
                                C1260i.m4445e(f3369b, "decrypt failed!");
                                return null;
                            }
                            carlifeMsg.m4203d(decryptData.length);
                            carlifeMsg.m4199b(decryptData);
                        }
                        C1224g.m4259a("RECV CarlifeMsg " + this.f3379j, carlifeMsg);
                        return carlifeMsg;
                    }
                    C1260i.m4445e(f3369b, this.f3379j + " Receive Carlife Msg Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                C1260i.m4445e(f3369b, this.f3379j + " Receive Carlife Msg Head Error: headLen = " + headLen);
                throw new IOException();
            }
            C1260i.m4445e(f3369b, this.f3379j + " Receive Data Fail, mInputStream is null");
            throw new IOException();
        } catch (Exception e) {
            C1260i.m4445e(f3369b, this.f3379j + " IOException, Receive Data Fail");
            C1215d.m4207a().m4222a(false);
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static C1212c m4258a(BufferedInputStream tmpInputStream) {
        C1212c carlifeMsg = new C1212c(false);
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
                        C1260i.m4445e(f3369b, "Receive Carlife Msg Head Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (headLen == 8) {
                    carlifeMsg.m4195a(headBuf);
                    int len = carlifeMsg.m4204e();
                    cnt = len;
                    byte[] dataBuf = new byte[len];
                    int dataLen = 0;
                    while (cnt > 0) {
                        r = tmpInputStream.read(dataBuf, dataLen, cnt);
                        if (r > 0) {
                            cnt -= r;
                            dataLen += r;
                        } else {
                            C1260i.m4445e(f3369b, "Receive Carlife Msg Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        carlifeMsg.m4199b(dataBuf);
                        C1224g.m4259a("RECV CarlifeMsg CMD", carlifeMsg);
                        return carlifeMsg;
                    }
                    C1260i.m4445e(f3369b, "Receive Carlife Msg Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                C1260i.m4445e(f3369b, " Receive Carlife Msg Head Error: headLen = " + headLen);
                throw new IOException();
            } catch (Exception e) {
                C1260i.m4445e(f3369b, "IOException, Receive Data Fail");
                C1215d.m4207a().m4222a(false);
                e.printStackTrace();
                return null;
            }
        }
        C1260i.m4445e(f3369b, "Receive Data Fail, mInputStream is null");
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
                        C1260i.m4445e(f3369b, this.f3379j + " Receive Data Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (dataLen == len) {
                    return dataLen;
                }
                C1260i.m4445e(f3369b, this.f3379j + " Receive Data Error: dataLen = " + dataLen);
                throw new IOException();
            }
            C1260i.m4445e(f3369b, this.f3379j + " Receive Data Fail, mInputStream is null");
            throw new IOException();
        } catch (Exception e) {
            C1260i.m4445e(f3369b, this.f3379j + " IOException, Receive Data Fail");
            C1215d.m4207a().m4222a(false);
            e.printStackTrace();
            return r;
        }
    }

    /* renamed from: a */
    private static void m4259a(String tag, C1212c carlifeMsg) {
        if (C1251e.m4382t()) {
            try {
                C1260i.m4435b(f3369b, "[" + tag + "]" + (((("" + "index = " + Integer.toString(carlifeMsg.m4197b())) + ", length = " + Integer.toString(carlifeMsg.m4204e())) + ", service_type = 0x" + C1247j.m4317a(carlifeMsg.m4202d(), 8)) + ", name = " + C1253f.m4405a(carlifeMsg.m4202d())));
            } catch (Exception e) {
                C1260i.m4445e("TAG", "dumpData get Exception");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m4260a(String tag, byte[] data, int len) {
        if (C1251e.m4382t() && len >= 4) {
            String msg = "";
            try {
                msg = msg + "length = " + Integer.toString(C1211b.m4178b(new byte[]{data[0], data[1], data[2], data[3]}));
                if (len >= 12) {
                    int serviceType = C1211b.m4178b(new byte[]{data[8], data[9], data[10], data[11]});
                    String name = C1253f.m4405a(serviceType);
                    if (name != null) {
                        msg = (msg + ", service_type = 0x" + C1247j.m4317a(serviceType, 8)) + ", name = " + name;
                    } else {
                        return;
                    }
                }
                C1260i.m4435b(f3369b, "[" + tag + "]" + msg);
            } catch (Exception e) {
                C1260i.m4445e("TAG", "dumpData get Exception");
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
    private C1212c m4268j() {
        if (f3377r >= f3378s) {
            return null;
        }
        char c = (char) ((f3377r % 26) + 97);
        C1212c tcarlifeMsg = new C1212c(true);
        String ts = "Msg Num:" + Integer.toString(f3377r);
        int len = 4096 - ts.length();
        StringBuffer sb = new StringBuffer(ts);
        for (int j = 0; j < len; j++) {
            sb.append(c);
        }
        try {
            tcarlifeMsg.m4199b(sb.toString().getBytes(f3376i));
            tcarlifeMsg.m4203d(4096);
            f3377r++;
            return tcarlifeMsg;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
