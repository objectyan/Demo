package com.baidu.carlife.logic.music;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.carlife.core.LogUtil;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.tencent.qplayauto.device.QPlayAutoJNI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: PlayPCM */
/* renamed from: com.baidu.carlife.logic.music.n */
public class C1829n {
    /* renamed from: a */
    public static Queue<String> f5661a = new LinkedList();
    /* renamed from: b */
    public static final int f5662b = 1;
    /* renamed from: c */
    public static final int f5663c = 2;
    /* renamed from: d */
    public static final int f5664d = 3;
    /* renamed from: e */
    public static final int f5665e = 0;
    /* renamed from: f */
    public static final int f5666f = 1;
    /* renamed from: g */
    public static final int f5667g = 2;
    /* renamed from: i */
    private static int f5668i = 0;
    /* renamed from: h */
    private final String f5669h = "PlayPCM";
    /* renamed from: j */
    private volatile boolean f5670j = true;
    /* renamed from: k */
    private boolean f5671k = false;
    /* renamed from: l */
    private Thread f5672l = null;
    /* renamed from: m */
    private C1830o f5673m;
    /* renamed from: n */
    private HandlerThread f5674n = new HandlerThread("playpcm");
    /* renamed from: o */
    private Handler f5675o;
    /* renamed from: p */
    private Object f5676p = new Object();
    /* renamed from: q */
    private C1828a f5677q;
    /* renamed from: r */
    private String f5678r = "";

    /* compiled from: PlayPCM */
    /* renamed from: com.baidu.carlife.logic.music.n$2 */
    class C18272 implements Runnable {
        /* renamed from: a */
        byte[] f5652a = null;
        /* renamed from: b */
        int f5653b = 0;
        /* renamed from: c */
        final /* synthetic */ C1829n f5654c;

        C18272(C1829n this$0) {
            this.f5654c = this$0;
        }

        public void run() {
            while (!this.f5654c.f5671k) {
                if (C1829n.f5661a.size() < 2) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    while (C1829n.f5661a.size() > 1) {
                        C1829n.f5661a.poll();
                    }
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (C1829n.f5661a.size() <= 1) {
                        String[] PlayList = new String[C1829n.f5661a.size()];
                        C1829n.f5661a.toArray(PlayList);
                        if (PlayList != null && PlayList.length >= 1) {
                            this.f5654c.m6912g();
                            this.f5654c.f5678r = PlayList[PlayList.length - 1];
                            LogUtil.d("PlayPCM", "Start play ID:" + this.f5654c.f5678r);
                            this.f5654c.f5670j = false;
                            try {
                                Thread.sleep(10);
                                QPlayAutoJNI.InitPCMData();
                                QPlayAutoJNI.SetCurrentSongID(this.f5654c.f5678r);
                                this.f5653b = 0;
                                this.f5654c.f5677q = this.f5654c.m6896b(this.f5654c.f5678r);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e22) {
                                    e22.printStackTrace();
                                }
                                if (this.f5654c.f5677q == null) {
                                    this.f5654c.f5677q = new C1828a(this.f5654c);
                                } else {
                                    this.f5654c.m6888a(this.f5654c.f5677q);
                                    this.f5654c.f5673m.mo1789a(true);
                                    this.f5654c.f5673m.mo1788a(String.valueOf(this.f5654c.f5677q.f5659e * 1000));
                                    while (!this.f5654c.f5670j && C1829n.f5661a.size() <= 1) {
                                        if (C1829n.f5668i != 2) {
                                            try {
                                                Thread.sleep(500);
                                            } catch (InterruptedException e3) {
                                                this.f5654c.m6887a(1, 1, this.f5654c.f5678r);
                                            }
                                        } else {
                                            if (this.f5654c.m6894a(QPlayAutoJNI.PcmQueue)) {
                                                this.f5654c.f5675o.obtainMessage(1, QPlayAutoJNI.PCMPackageIndex + 1, 0, this.f5654c.f5678r).sendToTarget();
                                            }
                                            this.f5652a = (byte[]) QPlayAutoJNI.PcmQueue.poll();
                                            if (this.f5652a == null) {
                                                try {
                                                    Thread.sleep(1000);
                                                } catch (InterruptedException e4) {
                                                    this.f5654c.m6887a(1, 1, this.f5654c.f5678r);
                                                }
                                            } else if (this.f5652a.length == 0) {
                                                this.f5654c.m6887a(1, 0, this.f5654c.f5678r);
                                                break;
                                            } else if (this.f5653b < 10) {
                                                this.f5653b++;
                                            } else {
                                                this.f5654c.f5673m.mo1790a(this.f5652a, this.f5652a.length);
                                            }
                                        }
                                    }
                                    LogUtil.d("PlayPCM", "Play song:" + this.f5654c.f5678r + " end!!!");
                                }
                            } catch (InterruptedException e5) {
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: PlayPCM */
    /* renamed from: com.baidu.carlife.logic.music.n$a */
    class C1828a {
        /* renamed from: a */
        public String f5655a;
        /* renamed from: b */
        public int f5656b;
        /* renamed from: c */
        public int f5657c;
        /* renamed from: d */
        public int f5658d;
        /* renamed from: e */
        public int f5659e;
        /* renamed from: f */
        final /* synthetic */ C1829n f5660f;

        C1828a(C1829n this$0) {
            this.f5660f = this$0;
        }
    }

    public C1829n(C1830o playServiceCallback) {
        this.f5673m = playServiceCallback;
        this.f5677q = new C1828a(this);
        this.f5674n.start();
        this.f5675o = new Handler(this, this.f5674n.getLooper()) {
            /* renamed from: a */
            final /* synthetic */ C1829n f5651a;

            public void dispatchMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        if (this.f5651a.f5678r == msg.obj && msg.arg1 > QPlayAutoJNI.PCMPackageIndex) {
                            this.f5651a.m6891a(msg.obj.toString(), msg.arg1);
                            break;
                        }
                    case 2:
                        QPlayAutoJNI.SendCommand("{Request:DevicePlayPlay}\\r\\n", false);
                        break;
                    case 3:
                        QPlayAutoJNI.SendCommand("{Request:DevicePlayPause}\\r\\n", false);
                        break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        m6904i();
    }

    /* renamed from: a */
    private void m6888a(C1828a pi) {
        this.f5673m.mo1786a(pi.f5656b, pi.f5657c, pi.f5658d);
    }

    /* renamed from: a */
    public int m6905a() {
        return this.f5677q.f5659e;
    }

    /* renamed from: b */
    public boolean m6907b() {
        return !this.f5670j;
    }

    /* renamed from: c */
    public void m6908c() {
        if (f5668i != 1) {
            this.f5675o.obtainMessage(3).sendToTarget();
        }
        f5668i = 1;
        this.f5673m.mo1792c();
    }

    /* renamed from: d */
    public void m6909d() {
        if (f5668i != 2) {
            this.f5675o.obtainMessage(2).sendToTarget();
        }
        this.f5673m.mo1791b();
        f5668i = 2;
    }

    /* renamed from: e */
    public void m6910e() {
        f5668i = 0;
    }

    /* renamed from: a */
    public static void m6886a(int state) {
        f5668i = state;
    }

    /* renamed from: f */
    public void m6911f() {
        this.f5671k = true;
        m6912g();
        if (this.f5672l != null) {
            this.f5672l.interrupt();
            this.f5672l = null;
        }
    }

    /* renamed from: g */
    public void m6912g() {
        this.f5677q.f5659e = 0;
        this.f5670j = true;
    }

    /* renamed from: a */
    private boolean m6894a(ConcurrentLinkedQueue<byte[]> BinData) {
        if (BinData.size() >= 100 || BinData.size() % 30 != 0) {
            return false;
        }
        Object[] data = BinData.toArray();
        if (data == null || data.length == 0) {
            return true;
        }
        for (Object obj : data) {
            if (((byte[]) obj).length == 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m6887a(int arg1, int arg2, String songId) {
        if (songId.equals(this.f5678r)) {
            LogUtil.d("PlayPCM", "PPlayExit arg1=" + arg1 + ", error: arg2=" + arg2 + ", songId:" + songId);
            this.f5677q.f5659e = 0;
            this.f5670j = true;
            QPlayAutoJNI.PCMPackageIndex = -1;
            this.f5673m.mo1787a(1, arg1, arg2, songId);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m6891a(java.lang.String r9, int r10) {
        /*
        r8 = this;
        r7 = 0;
        r3 = 0;
        r5 = r8.f5676p;
        monitor-enter(r5);
        r3 = com.tencent.qplayauto.device.QPlayAutoJNI.GetPCMData(r9, r10);	 Catch:{ all -> 0x0073 }
        if (r3 != 0) goto L_0x0039;
    L_0x000b:
        r3 = com.tencent.qplayauto.device.QPlayAutoJNI.GetPCMData(r9, r10);	 Catch:{ all -> 0x0073 }
        if (r3 != 0) goto L_0x0039;
    L_0x0011:
        r4 = "PlayPCM";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0073 }
        r6.<init>();	 Catch:{ all -> 0x0073 }
        r7 = "Play song ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0073 }
        r6 = r6.append(r9);	 Catch:{ all -> 0x0073 }
        r7 = " error: GetPCMData error";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0073 }
        r6 = r6.toString();	 Catch:{ all -> 0x0073 }
        com.baidu.carlife.core.LogUtil.d(r4, r6);	 Catch:{ all -> 0x0073 }
        r4 = 0;
        r6 = 0;
        r8.m6887a(r4, r6, r9);	 Catch:{ all -> 0x0073 }
        monitor-exit(r5);	 Catch:{ all -> 0x0073 }
    L_0x0038:
        return;
    L_0x0039:
        monitor-exit(r5);	 Catch:{ all -> 0x0073 }
        r4 = "error";
        r1 = r3.get(r4);
        if (r1 == 0) goto L_0x0038;
    L_0x0043:
        r2 = 0;
        r4 = r1.toString();	 Catch:{ NumberFormatException -> 0x0076 }
        r2 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0076 }
        if (r2 == 0) goto L_0x0038;
    L_0x004e:
        r4 = "PlayPCM";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "errornumber = ";
        r5 = r5.append(r6);
        r5 = r5.append(r2);
        r5 = r5.toString();
        com.baidu.carlife.core.LogUtil.m4445e(r4, r5);
        r4 = -8;
        if (r2 != r4) goto L_0x0078;
    L_0x006b:
        r4 = 1;
        com.tencent.qplayauto.device.QPlayAutoJNI.OnConnectMessage(r4);
        r8.m6910e();
        goto L_0x0038;
    L_0x0073:
        r4 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0073 }
        throw r4;
    L_0x0076:
        r0 = move-exception;
        goto L_0x0038;
    L_0x0078:
        r4 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        if (r2 == r4) goto L_0x0038;
    L_0x007c:
        r8.m6887a(r7, r2, r9);
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.logic.music.n.a(java.lang.String, int):void");
    }

    /* renamed from: b */
    private C1828a m6896b(String SongID) {
        C1828a c1828a;
        synchronized (this.f5676p) {
            int pcmDataLen;
            HashMap hm = QPlayAutoJNI.GetMediaInfo(SongID);
            if (hm == null || hm.size() < 2 || hm.get(ParamKey.KEY_MSG_ERRORS) != null) {
                hm = QPlayAutoJNI.GetMediaInfo(SongID);
                if (hm == null || hm.size() < 2 || hm.get(ParamKey.KEY_MSG_ERRORS) != null) {
                    String str;
                    String str2 = "PlayPCM";
                    StringBuilder append = new StringBuilder().append("Play song ").append(SongID).append(" error: GetMediaInfo:");
                    if (hm == null) {
                        str = "null";
                    } else {
                        str = hm.toString();
                    }
                    LogUtil.m4443d(str2, append.append(str).toString());
                    this.f5670j = true;
                    if (hm == null || hm.get(ParamKey.KEY_MSG_ERRORS) == null) {
                        m6887a(0, 1, SongID);
                    } else {
                        int val;
                        try {
                            val = Integer.parseInt(hm.get(ParamKey.KEY_MSG_ERRORS).toString());
                        } catch (NumberFormatException e) {
                            val = 0;
                        }
                        m6887a(0, val, SongID);
                    }
                    c1828a = null;
                }
            }
            c1828a = new C1828a(this);
            QPlayAutoJNI.PrintHashMap("PlayPCM", hm, "GetMediaInfo");
            c1828a.f5655a = SongID;
            try {
                c1828a.f5656b = Integer.parseInt(hm.get("rate").toString());
                c1828a.f5658d = Integer.parseInt(hm.get("bit").toString());
                c1828a.f5657c = Integer.parseInt(hm.get("channel").toString());
                pcmDataLen = Integer.parseInt(hm.get("pcmdatalength").toString());
            } catch (NumberFormatException e2) {
                pcmDataLen = 0;
            }
            c1828a.f5659e = pcmDataLen / (((c1828a.f5656b * c1828a.f5657c) * c1828a.f5658d) / 8);
            if (c1828a.f5658d == 8) {
                c1828a.f5658d = 3;
            } else {
                c1828a.f5658d = 2;
            }
            if (c1828a.f5657c == 1) {
                c1828a.f5657c = 16;
            } else {
                c1828a.f5657c = 12;
            }
        }
        return c1828a;
    }

    /* renamed from: i */
    private void m6904i() {
        this.f5672l = new Thread(new C18272(this));
        this.f5672l.start();
    }

    /* renamed from: a */
    public void m6906a(String SongID) {
        this.f5675o.obtainMessage(2).sendToTarget();
        if (f5661a.size() < 1) {
            f5661a.add(SongID);
        }
        f5661a.add(SongID);
        f5668i = 2;
    }
}
