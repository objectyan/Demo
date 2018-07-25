package com.baidu.carlife.core.connect;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.mobstat.Config;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: AOAConnectManager */
/* renamed from: com.baidu.carlife.core.connect.a */
public class AOAConnectManager implements KeepClass {
    /* renamed from: L */
    private static final int f3261L = 100;
    /* renamed from: a */
    public static final int f3262a = 500;
    /* renamed from: b */
    private static final String f3263b = "AOAConnectManager";
    /* renamed from: c */
    private static AOAConnectManager f3264c = null;
    /* renamed from: k */
    private static final String f3265k = "AOAReadThread";
    /* renamed from: l */
    private static final String f3266l = "SocketReadThread";
    /* renamed from: m */
    private static final String f3267m = "127.0.0.1";
    /* renamed from: n */
    private static final int f3268n = 100;
    /* renamed from: o */
    private static final int f3269o = 8;
    /* renamed from: p */
    private static final int f3270p = 4096;
    /* renamed from: q */
    private static final int f3271q = 327680;
    /* renamed from: r */
    private static final int f3272r = 327680;
    /* renamed from: s */
    private static int f3273s = 0;
    /* renamed from: t */
    private static int f3274t = 10240;
    /* renamed from: u */
    private static final int f3275u = 163840;
    /* renamed from: x */
    private static final int f3276x = 16384;
    /* renamed from: y */
    private static final int f3277y = 67108864;
    /* renamed from: A */
    private C1198b f3278A = null;
    /* renamed from: B */
    private C1198b f3279B = null;
    /* renamed from: C */
    private C1198b f3280C = null;
    /* renamed from: D */
    private C1198b f3281D = null;
    /* renamed from: E */
    private C1198b f3282E = null;
    /* renamed from: F */
    private C1198b f3283F = null;
    /* renamed from: G */
    private C1198b f3284G = null;
    /* renamed from: H */
    private Timer f3285H = null;
    /* renamed from: I */
    private TimerTask f3286I = null;
    /* renamed from: J */
    private int f3287J = 0;
    /* renamed from: K */
    private int f3288K = -1;
    /* renamed from: d */
    private Context f3289d = null;
    /* renamed from: e */
    private UsbManager f3290e = null;
    /* renamed from: f */
    private UsbAccessory f3291f = null;
    /* renamed from: g */
    private ParcelFileDescriptor f3292g = null;
    /* renamed from: h */
    private FileDescriptor f3293h = null;
    /* renamed from: i */
    private FileOutputStream f3294i = null;
    /* renamed from: j */
    private FileInputStream f3295j = null;
    /* renamed from: v */
    private Thread f3296v = null;
    /* renamed from: w */
    private Thread f3297w = null;
    /* renamed from: z */
    private C1197a f3298z = null;

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$1 */
    class C11941 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ AOAConnectManager f3206a;

        C11941(AOAConnectManager this$0) {
            this.f3206a = this$0;
        }

        public void run() {
            LogUtil.e(AOAConnectManager.f3263b, "timeout 1");
            if (this.f3206a.f3285H != null) {
                LogUtil.e(AOAConnectManager.f3263b, "timeout 2");
                LogUtil.m4440c(AOAConnectManager.f3263b, "numOfHeartBeat = " + this.f3206a.f3287J + ", oldNumOfHeartBeat = " + this.f3206a.f3288K);
                if (this.f3206a.f3288K == this.f3206a.f3287J) {
                    ConnectClient.newInstance().m4222a(false);
                    this.f3206a.m4169h();
                }
                this.f3206a.f3288K = this.f3206a.f3287J;
            }
        }
    }

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$2 */
    class C11952 extends Thread {
        /* renamed from: a */
        final /* synthetic */ AOAConnectManager f3207a;

        C11952(AOAConnectManager this$0) {
            this.f3207a = this$0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r14 = this;
            r9 = 0;
            r1 = 0;
            r0 = -1;
            r8 = -1;
            r6 = android.os.SystemClock.elapsedRealtime();
        L_0x0008:
            r10 = r14.f3207a;	 Catch:{ Exception -> 0x0097 }
            r9 = r10.m4155j();	 Catch:{ Exception -> 0x0097 }
            if (r9 != 0) goto L_0x004b;
        L_0x0010:
            r4 = android.os.SystemClock.elapsedRealtime();
            r10 = "AOAConnectManager";
            r11 = new java.lang.StringBuilder;
            r11.<init>();
            r12 = "Cnt = ";
            r11 = r11.append(r12);
            r11 = r11.append(r0);
            r11 = r11.toString();
            com.baidu.carlife.core.LogUtil.e(r10, r11);
            r10 = "AOAConnectManager";
            r11 = new java.lang.StringBuilder;
            r11.<init>();
            r12 = "Write Time = ";
            r11 = r11.append(r12);
            r12 = r4 - r6;
            r11 = r11.append(r12);
            r11 = r11.toString();
            com.baidu.carlife.core.LogUtil.e(r10, r11);
            return;
        L_0x004b:
            r10 = "AOAConnectManager";
            r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0097 }
            r11.<init>();	 Catch:{ Exception -> 0x0097 }
            r12 = "write data: ";
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x0097 }
            r12 = 0;
            r13 = 20;
            r12 = r9.substring(r12, r13);	 Catch:{ Exception -> 0x0097 }
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x0097 }
            r11 = r11.toString();	 Catch:{ Exception -> 0x0097 }
            com.baidu.carlife.core.LogUtil.d(r10, r11);	 Catch:{ Exception -> 0x0097 }
            r1 = r9.getBytes();	 Catch:{ Exception -> 0x0097 }
            r10 = r14.f3207a;	 Catch:{ Exception -> 0x0097 }
            r11 = 163840; // 0x28000 float:2.29589E-40 double:8.09477E-319;
            r8 = r10.m4160a(r1, r11);	 Catch:{ Exception -> 0x0097 }
            if (r8 >= 0) goto L_0x00b9;
        L_0x007b:
            r10 = "AOAConnectManager";
            r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0097 }
            r11.<init>();	 Catch:{ Exception -> 0x0097 }
            r12 = "write data error, ret = ";
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x0097 }
            r11 = r11.append(r8);	 Catch:{ Exception -> 0x0097 }
            r11 = r11.toString();	 Catch:{ Exception -> 0x0097 }
            com.baidu.carlife.core.LogUtil.e(r10, r11);	 Catch:{ Exception -> 0x0097 }
            goto L_0x0010;
        L_0x0097:
            r2 = move-exception;
            r10 = r14.f3207a;	 Catch:{ IOException -> 0x00bd }
            r10 = r10.f3294i;	 Catch:{ IOException -> 0x00bd }
            r10.close();	 Catch:{ IOException -> 0x00bd }
        L_0x00a1:
            r10 = "AOAConnectManager";
            r11 = "get exception when write";
            com.baidu.carlife.core.LogUtil.e(r10, r11);
            r10 = "AOAConnectManager";
            r11 = r2.toString();
            com.baidu.carlife.core.LogUtil.e(r10, r11);
            r2.printStackTrace();
            goto L_0x0010;
        L_0x00b9:
            r0 = r0 + 1;
            goto L_0x0008;
        L_0x00bd:
            r3 = move-exception;
            r3.printStackTrace();
            goto L_0x00a1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.connect.a.2.run():void");
        }
    }

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$3 */
    class C11963 extends Thread {
        /* renamed from: a */
        final /* synthetic */ AOAConnectManager f3208a;

        C11963(AOAConnectManager this$0) {
            this.f3208a = this$0;
        }

        public void run() {
            Exception e;
            try {
                LogUtil.e(AOAConnectManager.f3263b, "sleep 1s before read...");
                C11963.sleep(1000);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            byte[] data = new byte[AOAConnectManager.f3275u];
            int cnt = -1;
            long mStartTime = SystemClock.elapsedRealtime();
            String str = null;
            while (true) {
                int ret = this.f3208a.m4144b(data, AOAConnectManager.f3275u);
                if (ret != AOAConnectManager.f3275u) {
                    LogUtil.e(AOAConnectManager.f3263b, "read data error, ret = " + ret);
                    String str2 = str;
                    return;
                }
                cnt++;
                try {
                    if (cnt >= AOAConnectManager.f3274t) {
                        LogUtil.e(AOAConnectManager.f3263b, "Read Time = " + (SystemClock.elapsedRealtime() - mStartTime));
                    }
                    str2 = new String(data);
                    try {
                        LogUtil.d(AOAConnectManager.f3263b, "read data:" + cnt + Config.TRACE_TODAY_VISIT_SPLIT + ret + Config.TRACE_TODAY_VISIT_SPLIT + str2.substring(0, 20));
                        str = str2;
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    str2 = str;
                }
            }
            LogUtil.e(AOAConnectManager.f3263b, "get exception when read");
            LogUtil.e(AOAConnectManager.f3263b, e.toString());
            e.printStackTrace();
        }
    }

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$a */
    private class C1197a extends Thread {
        /* renamed from: a */
        final /* synthetic */ AOAConnectManager f3209a;
        /* renamed from: b */
        private boolean f3210b = false;
        /* renamed from: c */
        private byte[] f3211c = new byte[16384];
        /* renamed from: d */
        private byte[] f3212d = new byte[16384];
        /* renamed from: e */
        private int f3213e = -1;
        /* renamed from: f */
        private int f3214f = -1;
        /* renamed from: g */
        private int f3215g = 0;
        /* renamed from: h */
        private int f3216h = -1;

        public C1197a(AOAConnectManager AOAConnectManager) {
            this.f3209a = AOAConnectManager;
            LogUtil.d(AOAConnectManager.f3263b, "ReadThread Created");
            setName(AOAConnectManager.f3265k);
        }

        /* renamed from: a */
        public void m4106a() {
            this.f3210b = false;
        }

        public void run() {
            this.f3210b = true;
            LogUtil.d(AOAConnectManager.f3263b, "Begin to read data by AOA");
            try {
                C1197a.sleep(100);
                while (this.f3210b) {
                    if (!this.f3210b) {
                        LogUtil.e(AOAConnectManager.f3263b, "read data cancled");
                    } else if (this.f3209a.m4144b(this.f3212d, 8) < 0) {
                        LogUtil.e(AOAConnectManager.f3263b, "bulkTransferIn fail 1");
                    } else {
                        this.f3213e = ByteConvert.m4178b(new byte[]{this.f3212d[0], this.f3212d[1], this.f3212d[2], this.f3212d[3]});
                        this.f3214f = ByteConvert.m4178b(new byte[]{this.f3212d[4], this.f3212d[5], this.f3212d[6], this.f3212d[7]});
                        LogUtil.d(AOAConnectManager.f3263b, "typeMsg = " + this.f3213e + ", lenMsg = " + this.f3214f);
                        int tatalChannel = 6;
                        if (CommonParams.jw) {
                            tatalChannel = 7;
                        }
                        if (this.f3213e < 1 || this.f3213e > tatalChannel || this.f3214f < 0 || this.f3214f > AOAConnectManager.f3277y) {
                            LogUtil.e(AOAConnectManager.f3263b, "typeMsg or lenMsg is error");
                            ConnectClient.newInstance().m4222a(false);
                        } else {
                            if (this.f3211c.length < this.f3214f) {
                                this.f3211c = new byte[this.f3214f];
                            }
                            if (this.f3209a.m4144b(this.f3211c, this.f3214f) < 0) {
                                LogUtil.e(AOAConnectManager.f3263b, "bulkTransferIn fail 2");
                            } else {
                                this.f3216h = -1;
                                while (this.f3210b) {
                                    this.f3215g++;
                                    if (this.f3215g >= 100) {
                                        LogUtil.e(AOAConnectManager.f3263b, "write data to socket fail...retry");
                                        this.f3215g = 0;
                                        this.f3210b = false;
                                    } else {
                                        switch (this.f3213e) {
                                            case 1:
                                                this.f3216h = this.f3209a.f3278A.m4109b(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 2:
                                                this.f3216h = this.f3209a.f3279B.m4109b(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 3:
                                                this.f3216h = this.f3209a.f3280C.m4109b(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 4:
                                                this.f3216h = this.f3209a.f3281D.m4109b(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 5:
                                                this.f3216h = this.f3209a.f3282E.m4109b(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 6:
                                                this.f3216h = this.f3209a.f3283F.m4109b(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 7:
                                                this.f3216h = this.f3209a.f3284G.m4109b(this.f3211c, 0, this.f3214f);
                                                break;
                                            default:
                                                LogUtil.e(AOAConnectManager.f3263b, "AOAReadThread typeMsg error");
                                                this.f3210b = false;
                                                break;
                                        }
                                        if (this.f3216h < 0) {
                                            C1197a.sleep(100);
                                        } else {
                                            this.f3215g = 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.f3209a.m4163b();
                }
                this.f3209a.m4163b();
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.f3263b, "Exception when read data by AOA");
                e.printStackTrace();
            }
        }
    }

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$b */
    private class C1198b extends Thread {
        /* renamed from: a */
        InetAddress f3217a = null;
        /* renamed from: b */
        final /* synthetic */ AOAConnectManager f3218b;
        /* renamed from: c */
        private boolean f3219c = false;
        /* renamed from: d */
        private int f3220d = -1;
        /* renamed from: e */
        private String f3221e = null;
        /* renamed from: f */
        private String f3222f = null;
        /* renamed from: g */
        private Socket f3223g = null;
        /* renamed from: h */
        private BufferedInputStream f3224h = null;
        /* renamed from: i */
        private BufferedOutputStream f3225i = null;
        /* renamed from: j */
        private int f3226j = -1;
        /* renamed from: k */
        private int f3227k = -1;
        /* renamed from: l */
        private int f3228l = -1;
        /* renamed from: m */
        private byte[] f3229m = new byte[12];
        /* renamed from: n */
        private byte[] f3230n = new byte[8];
        /* renamed from: o */
        private int f3231o = 0;

        public C1198b(AOAConnectManager AOAConnectManager, int port, String name) {
            this.f3218b = AOAConnectManager;
            try {
                this.f3222f = name + AOAConnectManager.f3266l;
                setName(this.f3222f);
                LogUtil.d(AOAConnectManager.f3263b, "Create " + this.f3222f);
                this.f3220d = port;
                this.f3221e = name;
                this.f3219c = true;
                if (this.f3221e.equals(CommonParams.SERVER_SOCKET_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(1), 0, this.f3230n, 0, 4);
                } else if (this.f3221e.equals(CommonParams.SERVER_SOCKET_VIDEO_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(2), 0, this.f3230n, 0, 4);
                } else if (this.f3221e.equals(CommonParams.SERVER_SOCKET_AUDIO_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(3), 0, this.f3230n, 0, 4);
                } else if (this.f3221e.equals("TTS")) {
                    System.arraycopy(ByteConvert.m4175a(4), 0, this.f3230n, 0, 4);
                } else if (this.f3221e.equals(CommonParams.SERVER_SOCKET_AUDIO_VR_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(5), 0, this.f3230n, 0, 4);
                } else if (this.f3221e.equals(CommonParams.SERVER_SOCKET_TOUCH_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(6), 0, this.f3230n, 0, 4);
                } else if (this.f3221e.equals(CommonParams.SERVER_SOCKET_DATA_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(7), 0, this.f3230n, 0, 4);
                }
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.f3263b, "Create " + this.f3222f + " fail");
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        public void m4108a() {
            try {
                if (this.f3223g != null) {
                    this.f3223g.close();
                    this.f3223g = null;
                }
                if (this.f3224h != null) {
                    this.f3224h.close();
                    this.f3224h = null;
                }
                if (this.f3225i != null) {
                    this.f3225i.close();
                    this.f3225i = null;
                }
                this.f3219c = false;
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.f3263b, "Close " + this.f3222f + " fail");
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        public int m4107a(byte[] buffer, int offset, int len) {
            int r = -1;
            try {
                if (this.f3224h != null) {
                    int cnt = len;
                    int dataLen = 0;
                    while (cnt > 0) {
                        r = this.f3224h.read(buffer, offset + dataLen, cnt);
                        if (r > 0) {
                            cnt -= r;
                            dataLen += r;
                        } else {
                            LogUtil.e(AOAConnectManager.f3263b, this.f3221e + " Receive Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        return dataLen;
                    }
                    LogUtil.e(AOAConnectManager.f3263b, this.f3221e + " Receive Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                LogUtil.e(AOAConnectManager.f3263b, this.f3221e + " Receive Data Fail, mInputStream is null");
                throw new IOException();
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.f3263b, this.f3221e + " IOException, Receive Data Fail");
                ConnectClient.newInstance().m4222a(false);
                e.printStackTrace();
                return r;
            }
        }

        /* renamed from: b */
        public int m4109b(byte[] buffer, int offset, int len) {
            try {
                if (this.f3225i != null) {
                    this.f3225i.write(buffer, offset, len);
                    this.f3225i.flush();
                    return len;
                }
                LogUtil.e(AOAConnectManager.f3263b, this.f3221e + " Send Data Fail, mOutputStream is null");
                throw new IOException();
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.f3263b, this.f3221e + " IOException, Send Data Fail");
                e.printStackTrace();
                return -1;
            }
        }

        public void run() {
            while (this.f3219c) {
                try {
                    C1198b.sleep(100);
                    this.f3231o++;
                    LogUtil.d(AOAConnectManager.f3263b, "Try to connect to socket...retry = " + this.f3231o);
                    if (this.f3231o >= 100) {
                        LogUtil.d(AOAConnectManager.f3263b, "connect to socket fail");
                        this.f3231o = 0;
                        this.f3219c = false;
                        break;
                    }
                    this.f3217a = InetAddress.getByName(AOAConnectManager.f3267m);
                    this.f3223g = new Socket(this.f3217a, this.f3220d);
                    if (this.f3223g != null) {
                        LogUtil.d(AOAConnectManager.f3263b, "Connected to: " + this.f3223g.toString());
                    }
                    this.f3223g.setTcpNoDelay(true);
                    this.f3223g.setSendBufferSize(327680);
                    this.f3223g.setReceiveBufferSize(327680);
                    this.f3224h = new BufferedInputStream(this.f3223g.getInputStream());
                    this.f3225i = new BufferedOutputStream(this.f3223g.getOutputStream());
                } catch (Exception e) {
                    LogUtil.e(AOAConnectManager.f3263b, "Create " + this.f3222f + " fail 1");
                    e.printStackTrace();
                }
            }
            do {
                try {
                    if (this.f3223g != null && this.f3219c) {
                        if (!this.f3223g.isConnected()) {
                            LogUtil.e(AOAConnectManager.f3263b, "socket is disconnected when read data");
                            break;
                        }
                        if (!this.f3221e.equals(CommonParams.SERVER_SOCKET_NAME) && !this.f3221e.equals(CommonParams.SERVER_SOCKET_TOUCH_NAME) && !this.f3221e.equals(CommonParams.SERVER_SOCKET_DATA_NAME)) {
                            if (m4107a(this.f3229m, 0, 12) < 0) {
                                break;
                            }
                            this.f3226j = 12;
                            this.f3227k = ByteConvert.m4178b(new byte[]{this.f3229m[0], this.f3229m[1], this.f3229m[2], this.f3229m[3]});
                        } else if (m4107a(this.f3229m, 0, 8) < 0) {
                            break;
                        } else {
                            this.f3226j = 8;
                            this.f3227k = ByteConvert.m4188d(new byte[]{this.f3229m[0], this.f3229m[1]});
                        }
                        LogUtil.d(AOAConnectManager.f3263b, "Channel = " + this.f3221e + ", lenMsgHead = " + this.f3226j + ", lenMsgData = " + this.f3227k);
                        System.arraycopy(ByteConvert.m4175a(this.f3226j + this.f3227k), 0, this.f3230n, 4, 4);
                        this.f3228l = this.f3226j + this.f3227k;
                        if (this.f3229m.length < this.f3228l) {
                            byte[] tmpMsg = this.f3229m;
                            this.f3229m = new byte[this.f3228l];
                            System.arraycopy(tmpMsg, 0, this.f3229m, 0, this.f3226j);
                        }
                        if (m4107a(this.f3229m, this.f3226j, this.f3227k) < 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception ex) {
                    LogUtil.e(AOAConnectManager.f3263b, "get Exception in " + this.f3222f);
                    ex.printStackTrace();
                    return;
                }
            } while (this.f3218b.m4161a(this.f3230n, 8, this.f3229m, this.f3228l) >= 0);
            LogUtil.e(AOAConnectManager.f3263b, "bulkTransferOut fail");
            this.f3218b.m4163b();
        }
    }

    /* renamed from: a */
    public static AOAConnectManager m4143a() {
        if (f3264c == null) {
            synchronized (AOAConnectManager.class) {
                if (f3264c == null) {
                    f3264c = new AOAConnectManager();
                }
            }
        }
        return f3264c;
    }

    private AOAConnectManager() {
    }

    /* renamed from: a */
    public void m4162a(Context context, UsbAccessory accessory) {
        LogUtil.e(f3263b, "init");
        this.f3289d = context;
        this.f3290e = (UsbManager) this.f3289d.getSystemService("usb");
        this.f3291f = accessory;
        if (this.f3291f == null) {
            LogUtil.e(f3263b, "mUsbAccessory is null");
        } else if (ConnectClient.newInstance().m4226d()) {
            try {
                this.f3292g = this.f3290e.openAccessory(this.f3291f);
                this.f3293h = this.f3292g.getFileDescriptor();
                this.f3294i = new FileOutputStream(this.f3293h);
                this.f3295j = new FileInputStream(this.f3293h);
                ConnectManager.newInstance().setType(2);
                m4166e();
                m4164c();
            } catch (Exception ex) {
                LogUtil.e(f3263b, "get fd fail");
                ex.printStackTrace();
            }
        } else {
            LogUtil.e(f3263b, "usb is not connected");
        }
    }

    /* renamed from: b */
    public void m4163b() {
        LogUtil.e(f3263b, "uninit");
        try {
            if (this.f3294i != null) {
                this.f3294i.close();
                this.f3294i = null;
            }
            if (this.f3295j != null) {
                this.f3295j.close();
                this.f3295j = null;
            }
            if (this.f3292g != null) {
                this.f3292g.close();
                this.f3292g = null;
            }
        } catch (Exception e) {
            LogUtil.e(f3263b, "uninit fail");
        }
        this.f3291f = null;
        this.f3293h = null;
        ConnectManager.newInstance().setType(1);
        m4167f();
        m4165d();
    }

    /* renamed from: b */
    private int m4144b(byte[] data, int len) {
        try {
            if (this.f3295j == null) {
                LogUtil.e(f3263b, "mFin is null");
                throw new IOException();
            }
            int cnt = len;
            int dataLen = 0;
            while (cnt > 0) {
                int ret = this.f3295j.read(data, dataLen, 16384);
                if (ret > 0) {
                    cnt -= ret;
                    dataLen += ret;
                } else {
                    LogUtil.e(f3263b, "bulkTransferIn error 1: ret = " + ret);
                    throw new IOException();
                }
            }
            if (dataLen == len) {
                return dataLen;
            }
            LogUtil.e(f3263b, "bulkTransferIn error 3: dataLen = " + dataLen + ", len = " + len);
            throw new IOException();
        } catch (Exception e) {
            LogUtil.e(f3263b, "bulkTransferIn catch exception");
            ConnectClient.newInstance().m4222a(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public int m4160a(byte[] data, int len) {
        try {
            if (this.f3294i == null) {
                LogUtil.e(f3263b, "mFin is null");
                throw new IOException();
            }
            this.f3294i.write(data, 0, len);
            return len;
        } catch (Exception e) {
            LogUtil.e(f3263b, "bulkTransferOut catch exception");
            ConnectClient.newInstance().m4222a(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public synchronized int m4161a(byte[] head, int lenHead, byte[] msg, int lenMsg) {
        int i = -1;
        synchronized (this) {
            this.f3287J++;
            this.f3287J %= 65536;
            if (m4160a(head, lenHead) < 0) {
                LogUtil.e(f3263b, "bulkTransferOut fail 1");
            } else if (m4160a(msg, lenMsg) < 0) {
                LogUtil.e(f3263b, "bulkTransferOut fail 2");
            } else {
                i = lenHead + lenMsg;
            }
        }
        return i;
    }

    /* renamed from: c */
    public void m4164c() {
        try {
            this.f3298z = new C1197a(this);
            this.f3298z.start();
        } catch (Exception e) {
            LogUtil.e(f3263b, "Start AOAReadThread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public void m4165d() {
        try {
            if (this.f3298z != null) {
                this.f3298z.m4106a();
                this.f3298z = null;
            }
        } catch (Exception e) {
            LogUtil.e(f3263b, "Stop AOAReadThread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m4166e() {
        try {
            this.f3278A = new C1198b(this, CommonParams.SOCKET_WIFI_PORT, CommonParams.SERVER_SOCKET_NAME);
            this.f3278A.start();
            this.f3279B = new C1198b(this, CommonParams.SOCKET_VIDEO_WIFI_PORT, CommonParams.SERVER_SOCKET_VIDEO_NAME);
            this.f3279B.start();
            this.f3280C = new C1198b(this, CommonParams.SOCKET_AUDIO_WIFI_PORT, CommonParams.SERVER_SOCKET_AUDIO_NAME);
            this.f3280C.start();
            this.f3281D = new C1198b(this, CommonParams.SOCKET_AUDIO_TTS_WIFI_PORT, "TTS");
            this.f3281D.start();
            this.f3282E = new C1198b(this, CommonParams.SOCKET_AUDIO_VR_WIFI_PORT, CommonParams.SERVER_SOCKET_AUDIO_VR_NAME);
            this.f3282E.start();
            this.f3283F = new C1198b(this, CommonParams.SOCKET_TOUCH_WIFI_PORT, CommonParams.SERVER_SOCKET_TOUCH_NAME);
            this.f3283F.start();
            this.f3284G = new C1198b(this, CommonParams.SOCKET_DATA_WIFI_PORT, CommonParams.SERVER_SOCKET_DATA_NAME);
            this.f3284G.start();
        } catch (Exception e) {
            LogUtil.e(f3263b, "Start Read Thread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public void m4167f() {
        try {
            if (this.f3278A != null) {
                this.f3278A.m4108a();
                this.f3278A = null;
            }
            if (this.f3279B != null) {
                this.f3279B.m4108a();
                this.f3279B = null;
            }
            if (this.f3280C != null) {
                this.f3280C.m4108a();
                this.f3280C = null;
            }
            if (this.f3281D != null) {
                this.f3281D.m4108a();
                this.f3281D = null;
            }
            if (this.f3282E != null) {
                this.f3282E.m4108a();
                this.f3282E = null;
            }
            if (this.f3283F != null) {
                this.f3283F.m4108a();
                this.f3283F = null;
            }
            if (this.f3284G != null) {
                this.f3284G.m4108a();
                this.f3284G = null;
            }
        } catch (Exception e) {
            LogUtil.e(f3263b, "Stop Read Thread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public void m4168g() {
        try {
            LogUtil.e(f3263b, "start timer");
            this.f3287J = 0;
            this.f3288K = -1;
            this.f3285H = new Timer();
            this.f3286I = new C11941(this);
            this.f3285H.schedule(this.f3286I, 1500, 500);
        } catch (Exception ex) {
            LogUtil.e(f3263b, "start timer get exception");
            ex.printStackTrace();
        }
    }

    /* renamed from: h */
    public void m4169h() {
        LogUtil.e(f3263b, "timer Stop");
        if (this.f3285H != null) {
            this.f3285H.cancel();
            this.f3285H = null;
        }
        if (this.f3286I != null) {
            this.f3286I.cancel();
            this.f3286I = null;
        }
        this.f3287J = 0;
        this.f3288K = -1;
    }

    /* renamed from: j */
    private String m4155j() {
        if (f3273s >= f3274t) {
            return null;
        }
        char c = (char) ((f3273s % 26) + 97);
        String ts = "Msg Num:" + Integer.toString(f3273s);
        int len = f3275u - ts.length();
        StringBuffer sb = new StringBuffer(ts);
        for (int j = 0; j < len; j++) {
            sb.append(c);
        }
        f3273s++;
        return sb.substring(0);
    }

    /* renamed from: k */
    private void m4157k() {
        this.f3297w = new C11952(this);
        this.f3297w.setName("WriteThread");
        this.f3297w.start();
    }

    /* renamed from: l */
    private void m4159l() {
        this.f3296v = new C11963(this);
        this.f3296v.setName("ReadThread");
        this.f3296v.start();
    }
}
