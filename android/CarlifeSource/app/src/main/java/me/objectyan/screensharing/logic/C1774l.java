package com.baidu.carlife.logic;

import android.os.Handler;
import android.util.Log;
import com.baidu.carlife.core.CommonParams;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Vector;

/* compiled from: MonitorTcpPort */
/* renamed from: com.baidu.carlife.logic.l */
public class C1774l {
    /* renamed from: a */
    public static final String f5401a = "MonitorTcpPort";
    /* renamed from: b */
    private static C1774l f5402b = null;
    /* renamed from: c */
    private C1773a f5403c = null;
    /* renamed from: d */
    private boolean f5404d = false;
    /* renamed from: e */
    private Vector<String> f5405e = null;
    /* renamed from: f */
    private Vector<String> f5406f = null;
    /* renamed from: g */
    private boolean f5407g = false;
    /* renamed from: h */
    private boolean f5408h = false;
    /* renamed from: i */
    private boolean f5409i = false;
    /* renamed from: j */
    private final String[] f5410j = new String[]{"170C", "170D", "29D6", "29D7"};

    /* compiled from: MonitorTcpPort */
    /* renamed from: com.baidu.carlife.logic.l$a */
    private class C1773a extends Thread {
        /* renamed from: a */
        public static final String f5397a = "MonitorThread";
        /* renamed from: b */
        final /* synthetic */ C1774l f5398b;
        /* renamed from: c */
        private boolean f5399c = false;
        /* renamed from: d */
        private Handler f5400d = null;

        public C1773a(C1774l c1774l, Handler msgandler) {
            this.f5398b = c1774l;
            this.f5400d = msgandler;
        }

        /* renamed from: a */
        public void m6491a() {
            try {
                this.f5399c = true;
                Log.d(f5397a, "MonitorThread  Exit" + this.f5399c);
            } catch (Exception e) {
                Log.e(f5397a, "Close  fail");
                e.printStackTrace();
            }
        }

        public void run() {
            Log.d(f5397a, "MonitorThread Running!!!");
            while (!this.f5399c) {
                this.f5398b.f5407g = false;
                this.f5398b.f5408h = false;
                this.f5398b.m6505h();
                if (!this.f5398b.f5408h) {
                    this.f5398b.f5409i = false;
                } else if (!(this.f5398b.f5409i || !this.f5398b.m6502e() || this.f5400d == null)) {
                    this.f5400d.sendEmptyMessage(CommonParams.jd);
                    this.f5398b.f5409i = true;
                }
                try {
                    C1773a.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.f5398b.f5407g = false;
                this.f5398b.f5408h = false;
            }
            Log.d(f5397a, "MonitorThread End!!!");
        }
    }

    private C1774l() {
    }

    /* renamed from: a */
    public void m6506a() {
        this.f5405e = new Vector();
        this.f5406f = new Vector();
    }

    /* renamed from: b */
    public void m6509b() {
        this.f5408h = false;
        this.f5409i = false;
        this.f5407g = false;
    }

    /* renamed from: c */
    public static C1774l m6498c() {
        if (f5402b == null) {
            synchronized (C1774l.class) {
                if (f5402b == null) {
                    f5402b = new C1774l();
                }
            }
        }
        return f5402b;
    }

    /* renamed from: a */
    public void m6507a(Handler msgandler) {
        synchronized (C1774l.class) {
            if (this.f5403c == null) {
                this.f5403c = new C1773a(this, msgandler);
                this.f5403c.start();
            }
        }
    }

    /* renamed from: d */
    public void m6510d() {
        if (this.f5403c != null) {
            this.f5403c.m6491a();
            this.f5403c = null;
        }
    }

    /* renamed from: a */
    public synchronized void m6508a(boolean isShow) {
        this.f5404d = isShow;
    }

    /* renamed from: e */
    private synchronized boolean m6502e() {
        return this.f5404d;
    }

    /* renamed from: a */
    private boolean m6495a(Vector<String> Inodestcp) {
        for (int i = 0; i < Inodestcp.size(); i++) {
            String[] strarraynet = ((String) Inodestcp.get(i)).trim().split("\\s+");
            if (strarraynet.length >= 4) {
                String strPort = strarraynet[1];
                String strState = strarraynet[3];
                if (m6494a(strPort)) {
                    this.f5407g = true;
                    if (strState.equals(SysOSAPIv2.RES_ID)) {
                        this.f5408h = true;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return this.f5408h;
    }

    /* renamed from: f */
    private void m6503f() {
        LineNumberReader lineNumberReader;
        FileReader fileReader;
        this.f5405e.clear();
        int iCount = 0;
        try {
            FileReader tcpReader = new FileReader("/proc/net/tcp");
            try {
                LineNumberReader lnr = new LineNumberReader(tcpReader);
                if (tcpReader != null) {
                }
                while (true) {
                    try {
                        String line = lnr.readLine();
                        if (line == null) {
                            break;
                        }
                        iCount++;
                        String[] strarraynet = line.trim().split("\\s+");
                        if (strarraynet.length >= 4 && strarraynet[3].equals(SysOSAPIv2.RES_ID)) {
                            this.f5405e.addElement(line);
                        }
                    } catch (IOException e) {
                    } catch (NullPointerException e2) {
                    } catch (FileNotFoundException e3) {
                        lineNumberReader = lnr;
                        fileReader = tcpReader;
                    }
                }
                if (tcpReader != null) {
                    tcpReader.close();
                }
                lineNumberReader = lnr;
                fileReader = tcpReader;
            } catch (FileNotFoundException e4) {
                fileReader = tcpReader;
            }
        } catch (FileNotFoundException e5) {
        }
        this.f5405e.addElement("                    ");
    }

    /* renamed from: g */
    private void m6504g() {
        LineNumberReader lineNumberReader;
        FileReader fileReader;
        this.f5406f.clear();
        int iCount = 0;
        try {
            FileReader tcp = new FileReader("/proc/net/tcp6");
            try {
                LineNumberReader lnr = new LineNumberReader(tcp);
                if (tcp != null) {
                }
                while (true) {
                    try {
                        String line = lnr.readLine();
                        if (line == null) {
                            break;
                        }
                        iCount++;
                        String[] strarraynet = line.trim().split("\\s+");
                        if (strarraynet.length >= 4 && strarraynet[3].equals(SysOSAPIv2.RES_ID)) {
                            this.f5406f.addElement(line);
                        }
                    } catch (IOException e) {
                    } catch (NullPointerException e2) {
                    } catch (FileNotFoundException e3) {
                        lineNumberReader = lnr;
                        fileReader = tcp;
                        return;
                    }
                }
                tcp.close();
                lineNumberReader = lnr;
                fileReader = tcp;
            } catch (FileNotFoundException e4) {
                fileReader = tcp;
            }
        } catch (FileNotFoundException e5) {
        }
    }

    /* renamed from: a */
    private boolean m6494a(String strPortCon) {
        for (String indexOf : this.f5410j) {
            int nIndexPort = strPortCon.indexOf(indexOf);
            if (nIndexPort > 0 && ':' == strPortCon.charAt(nIndexPort - 1)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private boolean m6505h() {
        this.f5407g = false;
        this.f5408h = false;
        if (this.f5405e == null) {
            this.f5405e = new Vector();
        }
        if (this.f5406f == null) {
            this.f5406f = new Vector();
        }
        m6503f();
        m6504g();
        m6495a(this.f5405e);
        if (!this.f5408h) {
            m6495a(this.f5406f);
        }
        return this.f5408h;
    }
}
