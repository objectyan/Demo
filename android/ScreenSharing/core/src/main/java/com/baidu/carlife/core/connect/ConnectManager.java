package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ConnectManager */
/* renamed from: com.baidu.carlife.core.connect.e */
public class ConnectManager implements KeepClass {
    /* renamed from: a */
    public static final String f3328a = "ConnectManager";
    /* renamed from: b */
    public static final String f3329b = "AcceptThread";
    /* renamed from: c */
    public static final int f3330c = 1000;
    /* renamed from: d */
    public static final int f3331d = 1000;
    /* renamed from: e */
    public static final int f3332e = 1;
    /* renamed from: f */
    public static final int f3333f = 2;
    /* renamed from: g */
    public static final int f3334g = 3;
    /* renamed from: h */
    public static int f3335h = 1;
    /* renamed from: w */
    private static ConnectManager f3336w = null;
    /* renamed from: y */
    private static int f3337y = 6;
    /* renamed from: A */
    private Timer f3338A = null;
    /* renamed from: B */
    private TimerTask f3339B = null;
    /* renamed from: C */
    private DatagramSocket f3340C = null;
    /* renamed from: D */
    private DatagramPacket f3341D = null;
    /* renamed from: E */
    private boolean f3342E = false;
    /* renamed from: i */
    private C1217a f3343i = null;
    /* renamed from: j */
    private C1217a f3344j = null;
    /* renamed from: k */
    private C1217a f3345k = null;
    /* renamed from: l */
    private C1217a f3346l = null;
    /* renamed from: m */
    private C1217a f3347m = null;
    /* renamed from: n */
    private C1217a f3348n = null;
    /* renamed from: o */
    private C1217a f3349o = null;
    /* renamed from: p */
    private ConnectSocket f3350p = null;
    /* renamed from: q */
    private ConnectSocket f3351q = null;
    /* renamed from: r */
    private ConnectSocket f3352r = null;
    /* renamed from: s */
    private ConnectSocket f3353s = null;
    /* renamed from: t */
    private ConnectSocket f3354t = null;
    /* renamed from: u */
    private ConnectSocket f3355u = null;
    /* renamed from: v */
    private ConnectSocket f3356v = null;
    /* renamed from: x */
    private int f3357x = 0;
    /* renamed from: z */
    private boolean f3358z = false;

    /* compiled from: ConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.e$1 */
    class C12161 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ ConnectManager f3321a;

        C12161(ConnectManager this$0) {
            this.f3321a = this$0;
        }

        public void run() {
            String ipv4Address = this.f3321a.m4234j();
            if (ipv4Address != null) {
                LogUtil.d(ConnectManager.f3328a, "send udp address : " + ipv4Address);
                byte[] buf = "CarlifeHost".getBytes();
                try {
                    this.f3321a.f3341D = new DatagramPacket(buf, buf.length, InetAddress.getByName(ipv4Address), 7999);
                    this.f3321a.f3340C.setBroadcast(true);
                    this.f3321a.f3340C.send(this.f3321a.f3341D);
                    this.f3321a.f3340C.close();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* compiled from: ConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.e$a */
    private class C1217a extends Thread {
        /* renamed from: a */
        final /* synthetic */ ConnectManager f3322a;
        /* renamed from: b */
        private ServerSocket f3323b = null;
        /* renamed from: c */
        private boolean f3324c = false;
        /* renamed from: d */
        private int f3325d = -1;
        /* renamed from: e */
        private String f3326e = null;
        /* renamed from: f */
        private String f3327f = null;

        public C1217a(ConnectManager connectManager, int port, String name) {
            this.f3322a = connectManager;
            try {
                this.f3327f = name + ConnectManager.f3329b;
                setName(this.f3327f);
                LogUtil.d(ConnectManager.f3328a, "Create " + this.f3327f);
                this.f3325d = port;
                this.f3326e = name;
                this.f3323b = new ServerSocket(this.f3325d);
                this.f3324c = true;
            } catch (Exception e) {
                LogUtil.m4445e(ConnectManager.f3328a, "Create " + this.f3327f + " fail");
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        public void m4227a() {
            try {
                if (this.f3323b != null) {
                    this.f3323b.close();
                }
                this.f3324c = false;
            } catch (Exception e) {
                LogUtil.m4445e(ConnectManager.f3328a, "Close " + this.f3327f + " fail");
                e.printStackTrace();
            }
        }

        public void run() {
            LogUtil.d(ConnectManager.f3328a, "Begin to listen in " + this.f3327f);
            while (this.f3323b != null && this.f3324c) {
                try {
                    Socket localSocket = this.f3323b.accept();
                    if (localSocket != null) {
                        LogUtil.d(ConnectManager.f3328a, "One client connected in " + this.f3327f);
                        if (this.f3326e.equals(CommonParams.SERVER_SOCKET_NAME)) {
                            MsgHandlerCenter.m4461b(1003);
                        }
                        new ConnectSocket(this.f3326e, localSocket).m4275c();
                    }
                } catch (Exception e) {
                    LogUtil.m4445e(ConnectManager.f3328a, "Get Exception in " + this.f3327f);
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static ConnectManager m4228a() {
        if (f3336w == null) {
            synchronized (ConnectManager.class) {
                if (f3336w == null) {
                    f3336w = new ConnectManager();
                }
            }
        }
        return f3336w;
    }

    private ConnectManager() {
    }

    /* renamed from: a */
    public void m4237a(int type) {
        f3335h = type;
    }

    /* renamed from: b */
    public int m4240b() {
        return f3335h;
    }

    /* renamed from: c */
    public void m4244c() {
        try {
            this.f3343i = new C1217a(this, CommonParams.iG, CommonParams.SERVER_SOCKET_NAME);
            this.f3343i.start();
            this.f3344j = new C1217a(this, CommonParams.iH, CommonParams.SERVER_SOCKET_VIDEO_NAME);
            this.f3344j.start();
            this.f3345k = new C1217a(this, CommonParams.iI, CommonParams.SERVER_SOCKET_AUDIO_NAME);
            this.f3345k.start();
            this.f3346l = new C1217a(this, CommonParams.iJ, "TTS");
            this.f3346l.start();
            this.f3347m = new C1217a(this, CommonParams.iK, CommonParams.SERVER_SOCKET_AUDIO_VR_NAME);
            this.f3347m.start();
            this.f3348n = new C1217a(this, CommonParams.iL, CommonParams.SERVER_SOCKET_TOUCH_NAME);
            this.f3348n.start();
            this.f3349o = new C1217a(this, CommonParams.iM, CommonParams.iT);
            this.f3349o.start();
        } catch (Exception e) {
            LogUtil.m4445e(f3328a, "Start Accept Thread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public void m4246d() {
        try {
            if (this.f3343i != null) {
                this.f3343i.m4227a();
                this.f3343i = null;
            }
            if (this.f3344j != null) {
                this.f3344j.m4227a();
                this.f3344j = null;
            }
            if (this.f3345k != null) {
                this.f3345k.m4227a();
                this.f3345k = null;
            }
            if (this.f3346l != null) {
                this.f3346l.m4227a();
                this.f3346l = null;
            }
            if (this.f3347m != null) {
                this.f3347m.m4227a();
                this.f3347m = null;
            }
            if (this.f3348n != null) {
                this.f3348n.m4227a();
                this.f3348n = null;
            }
            if (this.f3349o != null) {
                this.f3349o.m4227a();
                this.f3349o = null;
            }
            m4248e();
        } catch (Exception e) {
            LogUtil.m4445e(f3328a, "Stop Accept Thread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m4248e() {
        this.f3357x = 0;
        this.f3358z = false;
        m4250f();
    }

    /* renamed from: f */
    public void m4250f() {
        try {
            if (this.f3350p != null) {
                this.f3350p.m4276d();
                this.f3350p = null;
            }
            if (this.f3351q != null) {
                this.f3351q.m4276d();
                this.f3351q = null;
            }
            if (this.f3352r != null) {
                this.f3352r.m4276d();
                this.f3352r = null;
            }
            if (this.f3353s != null) {
                this.f3353s.m4276d();
                this.f3353s = null;
            }
            if (this.f3354t != null) {
                this.f3354t.m4276d();
                this.f3354t = null;
            }
            if (this.f3355u != null) {
                this.f3355u.m4276d();
                this.f3355u = null;
            }
            if (this.f3356v != null) {
                this.f3356v.m4276d();
                this.f3356v = null;
            }
        } catch (Exception e) {
            LogUtil.m4445e(f3328a, "Stop Connect Socket Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public synchronized void m4238a(ConnectSocket connectSocket) {
        if (!connectSocket.m4271a().equals(CommonParams.iT)) {
            this.f3357x++;
        }
        if (this.f3357x >= f3337y) {
            ConnectClient.m4207a().m4222a(true);
        }
        try {
            if (connectSocket.m4271a().equals(CommonParams.SERVER_SOCKET_NAME)) {
                this.f3350p = connectSocket;
            } else if (connectSocket.m4271a().equals(CommonParams.SERVER_SOCKET_VIDEO_NAME)) {
                this.f3351q = connectSocket;
            } else if (connectSocket.m4271a().equals(CommonParams.SERVER_SOCKET_AUDIO_NAME)) {
                this.f3352r = connectSocket;
            } else if (connectSocket.m4271a().equals("TTS")) {
                this.f3353s = connectSocket;
            } else if (connectSocket.m4271a().equals(CommonParams.SERVER_SOCKET_AUDIO_VR_NAME)) {
                this.f3354t = connectSocket;
            } else if (connectSocket.m4271a().equals(CommonParams.SERVER_SOCKET_TOUCH_NAME)) {
                this.f3355u = connectSocket;
            } else if (connectSocket.m4271a().equals(CommonParams.iT)) {
                this.f3356v = connectSocket;
            }
        } catch (Exception e) {
            LogUtil.m4445e(f3328a, "Add ConnectSocket Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public boolean m4252g() {
        return this.f3358z;
    }

    /* renamed from: a */
    public void m4239a(boolean is) {
        this.f3358z = is;
    }

    /* renamed from: a */
    public int m4235a(CarlifeCmdMessage msg) {
        if (this.f3350p != null) {
            return this.f3350p.m4269a(msg);
        }
        LogUtil.m4445e(f3328a, "write error: connectSocket is null");
        return -1;
    }

    /* renamed from: a */
    public int m4236a(byte[] buffer, int len) {
        if (this.f3351q != null) {
            return this.f3351q.m4270a(buffer, len);
        }
        LogUtil.m4445e(f3328a, "write error: video connectSocket is null");
        return -1;
    }

    /* renamed from: b */
    public int m4242b(byte[] buffer, int len) {
        if (this.f3351q != null) {
            return this.f3351q.m4273b(buffer, len);
        }
        LogUtil.m4445e(f3328a, "read error: video connectSocket is null");
        return -1;
    }

    /* renamed from: c */
    public int m4243c(byte[] buffer, int len) {
        if (this.f3352r != null) {
            return this.f3352r.m4270a(buffer, len);
        }
        LogUtil.m4445e(f3328a, "write error: audio connectSocket is null");
        return -1;
    }

    /* renamed from: d */
    public int m4245d(byte[] buffer, int len) {
        if (this.f3352r != null) {
            return this.f3352r.m4273b(buffer, len);
        }
        LogUtil.m4445e(f3328a, "read error: audio connectSocket is null");
        return -1;
    }

    /* renamed from: e */
    public int m4247e(byte[] buffer, int len) {
        if (this.f3353s != null) {
            return this.f3353s.m4270a(buffer, len);
        }
        LogUtil.m4445e(f3328a, "write error: tts connectSocket is null");
        return -1;
    }

    /* renamed from: f */
    public int m4249f(byte[] buffer, int len) {
        if (this.f3353s != null) {
            return this.f3353s.m4273b(buffer, len);
        }
        LogUtil.m4445e(f3328a, "read error: tts connectSocket is null");
        return -1;
    }

    /* renamed from: g */
    public int m4251g(byte[] buffer, int len) {
        if (this.f3354t != null) {
            return this.f3354t.m4270a(buffer, len);
        }
        LogUtil.m4445e(f3328a, "write error: VR connectSocket is null");
        return -1;
    }

    /* renamed from: h */
    public int m4253h(byte[] buffer, int len) {
        if (this.f3354t != null) {
            return this.f3354t.m4273b(buffer, len);
        }
        LogUtil.m4445e(f3328a, "read error: VR connectSocket is null");
        return -1;
    }

    /* renamed from: b */
    public int m4241b(CarlifeCmdMessage msg) {
        if (this.f3356v != null) {
            return this.f3356v.m4269a(msg);
        }
        LogUtil.m4445e(f3328a, "write error: Date connectSocket is null");
        return -1;
    }

    /* renamed from: a */
    private boolean m4231a(String ipAddr) {
        if (ipAddr.contains(Config.TRACE_TODAY_VISIT_SPLIT)) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    private String m4234j() {
        LogUtil.d(f3328a, "getLocalHostIp ");
        String broadcastAddress = null;
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface networkCard = (NetworkInterface) en.nextElement();
                LogUtil.d(f3328a, "name  : " + networkCard.getName());
                if (networkCard.getName().equals("wlan0") || networkCard.getName().equals("ap0")) {
                    for (InterfaceAddress networkCardAddress : networkCard.getInterfaceAddresses()) {
                        InetAddress address = networkCardAddress.getAddress();
                        if (!address.isLoopbackAddress()) {
                            String hostAddress = address.getHostAddress();
                            LogUtil.d(f3328a, "hostAddress : " + hostAddress);
                            if (!m4231a(hostAddress)) {
                                broadcastAddress = networkCardAddress.getBroadcast().getHostAddress();
                                LogUtil.d(f3328a, "broadcastAddress : " + broadcastAddress);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            LogUtil.m4445e(f3328a, "获取本地ip地址失败");
            e.printStackTrace();
        }
        return broadcastAddress;
    }

    /* renamed from: h */
    public void m4254h() {
        if (this.f3342E) {
            try {
                LogUtil.d(f3328a, "start udp send timer");
                this.f3340C = new DatagramSocket();
                this.f3338A = new Timer();
                this.f3339B = new C12161(this);
                this.f3338A.schedule(this.f3339B, Config.BPLUS_DELAY_TIME, 1000);
            } catch (Exception ex) {
                LogUtil.d(f3328a, "startUdpSendTimer get exception");
                ex.printStackTrace();
            }
        }
    }

    /* renamed from: i */
    public void m4255i() {
        if (this.f3342E) {
            LogUtil.d(f3328a, "stop udp send timer");
            if (this.f3338A != null) {
                this.f3338A.cancel();
                this.f3338A = null;
            }
            if (this.f3339B != null) {
                this.f3339B.cancel();
                this.f3339B = null;
            }
        }
    }
}
