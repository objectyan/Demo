package com.baidu.carlife.platform.communication;

import android.net.LocalSocket;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.carlife.core.C1260i;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.util.common.HttpsClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: SocketClient */
/* renamed from: com.baidu.carlife.platform.communication.b */
public class C2002b {
    /* renamed from: a */
    private static final String f6477a = C2002b.class.getSimpleName();
    /* renamed from: b */
    private String f6478b;
    /* renamed from: c */
    private LocalSocket f6479c;
    /* renamed from: d */
    private C1998b f6480d = new C1998b(this);
    /* renamed from: e */
    private C2001d f6481e = new C2001d(this);
    /* renamed from: f */
    private C1997a f6482f = new C1997a(this);
    /* renamed from: g */
    private C1999c f6483g;

    /* compiled from: SocketClient */
    /* renamed from: com.baidu.carlife.platform.communication.b$a */
    private class C1997a extends Thread {
        /* renamed from: b */
        private static final int f6463b = 10000;
        /* renamed from: a */
        final /* synthetic */ C2002b f6464a;
        /* renamed from: c */
        private AtomicLong f6465c = new AtomicLong(System.currentTimeMillis());
        /* renamed from: d */
        private boolean f6466d = false;

        public C1997a(C2002b c2002b) {
            this.f6464a = c2002b;
            setName("Carlife HeartBeatThread");
        }

        /* renamed from: a */
        public void m7624a() {
            this.f6465c.set(System.currentTimeMillis());
        }

        /* renamed from: b */
        public void m7625b() {
            this.f6466d = true;
            interrupt();
        }

        /* renamed from: c */
        private void m7623c() {
            if (this.f6464a.f6481e != null) {
                CLPackage pack = new CLPackage();
                pack.service = 1;
                pack.type = 1;
                this.f6464a.f6481e.m7629a(pack);
            }
        }

        public void run() {
            while (!this.f6466d && !isInterrupted()) {
                long notActiveTime = System.currentTimeMillis() - this.f6465c.get();
                if (notActiveTime <= HttpsClient.CONN_MGR_TIMEOUT) {
                    if (notActiveTime > BNOffScreenParams.MIN_ENTER_INTERVAL) {
                        m7623c();
                    }
                    try {
                        C1997a.sleep(BNOffScreenParams.MIN_ENTER_INTERVAL);
                    } catch (Throwable e) {
                        C1260i.m4432a(C2002b.f6477a, e);
                        if (this.f6464a.f6483g != null) {
                            this.f6464a.f6483g.mo1757a(this, e);
                            return;
                        }
                        return;
                    }
                } else if (this.f6464a.f6483g != null) {
                    this.f6464a.f6483g.mo1757a(this, new TimeoutException("remote client dead!"));
                    return;
                } else {
                    return;
                }
            }
        }
    }

    /* compiled from: SocketClient */
    /* renamed from: com.baidu.carlife.platform.communication.b$b */
    private class C1998b extends Thread {
        /* renamed from: a */
        final /* synthetic */ C2002b f6467a;
        /* renamed from: b */
        private InputStream f6468b;
        /* renamed from: c */
        private boolean f6469c = false;
        /* renamed from: d */
        private byte[] f6470d = new byte[16];
        /* renamed from: e */
        private CLPackage f6471e = CLPackage.getLargestPackage();

        public C1998b(C2002b c2002b) {
            this.f6467a = c2002b;
            setName("Carlife ReadThread");
        }

        /* renamed from: a */
        public void m7626a() {
            this.f6469c = true;
            interrupt();
        }

        public void run() {
            try {
                this.f6468b = this.f6467a.f6479c.getInputStream();
                while (!C1998b.interrupted() && !this.f6469c) {
                    int len = this.f6468b.read(this.f6470d, 0, this.f6470d.length);
                    if (len == -1) {
                        break;
                    } else if (len != this.f6470d.length) {
                        throw new IOException("wrong header length");
                    } else {
                        try {
                            this.f6471e.setHeader(this.f6470d);
                            if (this.f6471e.length > 0) {
                                int count = this.f6471e.length;
                                int offset = 0;
                                while (count > 0) {
                                    len = this.f6468b.read(this.f6471e.data, offset, count);
                                    if (len == -1) {
                                        throw new IOException("wrong data length");
                                    }
                                    count -= len;
                                    offset += len;
                                }
                            }
                            if (this.f6467a.f6482f != null) {
                                this.f6467a.f6482f.m7624a();
                            }
                            this.f6471e = this.f6467a.m7634c(this.f6471e);
                        } catch (Throwable e) {
                            C1260i.m4432a(C2002b.f6477a, e);
                            if (this.f6467a.f6483g != null) {
                                this.f6467a.f6483g.mo1757a(this, e);
                                return;
                            }
                            return;
                        }
                    }
                }
                if (this.f6467a.f6483g != null) {
                    this.f6467a.f6483g.mo1757a(this, null);
                }
            } catch (Throwable e2) {
                C1260i.m4432a(C2002b.f6477a, e2);
                if (this.f6467a.f6483g != null) {
                    this.f6467a.f6483g.mo1757a(this, e2);
                }
            }
        }
    }

    /* compiled from: SocketClient */
    /* renamed from: com.baidu.carlife.platform.communication.b$c */
    public interface C1999c {
        /* renamed from: a */
        CLPackage mo1754a(CLPackage cLPackage);

        /* renamed from: a */
        void mo1757a(Thread thread, Exception exception);
    }

    /* compiled from: SocketClient */
    /* renamed from: com.baidu.carlife.platform.communication.b$d */
    private class C2001d {
        /* renamed from: a */
        final /* synthetic */ C2002b f6474a;
        /* renamed from: b */
        private OutputStream f6475b;
        /* renamed from: c */
        private Handler f6476c;

        public C2001d(C2002b c2002b) {
            this.f6474a = c2002b;
            HandlerThread handlerThread = new HandlerThread("WriteHelperAsync");
            handlerThread.start();
            this.f6476c = new Handler(handlerThread.getLooper());
            try {
                this.f6475b = c2002b.f6479c.getOutputStream();
            } catch (Throwable e) {
                C1260i.m4438b(C2002b.f6477a, e);
                this.f6475b = null;
            }
        }

        /* renamed from: a */
        public void m7629a(final CLPackage pack) {
            this.f6476c.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C2001d f6473b;

                public void run() {
                    this.f6473b.m7630b(pack);
                }
            });
        }

        /* renamed from: b */
        public synchronized boolean m7630b(CLPackage pack) {
            boolean z = false;
            synchronized (this) {
                if (pack != null) {
                    if (this.f6475b != null) {
                        try {
                            this.f6475b.write(pack.getHeader());
                            if (pack.length > 0) {
                                if (pack.data == null || pack.data.length < pack.length) {
                                    throw new IOException("package with null data & not zero length");
                                }
                                this.f6475b.write(pack.data, 0, pack.length);
                            }
                            z = true;
                        } catch (Throwable e) {
                            C1260i.m4432a(C2002b.f6477a, e);
                        }
                    }
                }
            }
            return z;
        }
    }

    public C2002b(LocalSocket localSocket, String name) {
        this.f6479c = localSocket;
        this.f6478b = name;
        this.f6480d.start();
        this.f6482f.start();
    }

    /* renamed from: a */
    public void m7638a() {
        this.f6483g = null;
        this.f6481e = null;
        if (this.f6480d != null) {
            this.f6480d.m7626a();
            this.f6480d = null;
        }
        if (this.f6482f != null) {
            this.f6482f.m7625b();
            this.f6482f = null;
        }
        if (this.f6479c != null) {
            try {
                this.f6479c.close();
            } catch (Throwable e) {
                C1260i.m4432a(f6477a, e);
            }
            this.f6479c = null;
        }
    }

    /* renamed from: b */
    public String m7641b() {
        return this.f6478b;
    }

    /* renamed from: a */
    public void m7639a(C1999c listener) {
        this.f6483g = listener;
    }

    /* renamed from: a */
    public boolean m7640a(CLPackage pack) {
        if (this.f6481e != null) {
            return this.f6481e.m7630b(pack);
        }
        return false;
    }

    /* renamed from: b */
    public void m7642b(CLPackage pack) {
        if (this.f6481e != null) {
            this.f6481e.m7629a(pack);
        }
    }

    /* renamed from: c */
    private CLPackage m7634c(CLPackage pack) {
        if (pack == null) {
            return pack;
        }
        if (1 == pack.service) {
            if (this.f6481e == null || pack.type != 1) {
                return pack;
            }
            CLPackage p = new CLPackage();
            p.service = 1;
            p.type = 2;
            this.f6481e.m7629a(p);
            return pack;
        } else if (this.f6483g != null) {
            return this.f6483g.mo1754a(pack);
        } else {
            return pack;
        }
    }
}
