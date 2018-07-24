package com.baidu.carlife.platform.communication;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.text.TextUtils;
import com.baidu.carlife.core.LogUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: SocketServer */
/* renamed from: com.baidu.carlife.platform.communication.c */
public class C2006c {
    /* renamed from: a */
    public static final String f6490a = "CARLIFE_PLATFORM_SOCKET_SERVER";
    /* renamed from: b */
    private static final String f6491b = C2006c.class.getSimpleName();
    /* renamed from: c */
    private static C2006c f6492c;
    /* renamed from: d */
    private LocalServerSocket f6493d = new LocalServerSocket(f6490a);
    /* renamed from: e */
    private C2003a f6494e = new C2003a(this);
    /* renamed from: f */
    private C2005c f6495f;
    /* renamed from: g */
    private HashMap<String, C2002b> f6496g = new HashMap();
    /* renamed from: h */
    private Object f6497h = new Object();
    /* renamed from: i */
    private C2004b f6498i;

    /* compiled from: SocketServer */
    /* renamed from: com.baidu.carlife.platform.communication.c$a */
    private class C2003a extends Thread {
        /* renamed from: a */
        final /* synthetic */ C2006c f6484a;
        /* renamed from: b */
        private boolean f6485b = false;
        /* renamed from: c */
        private LinkedBlockingQueue<Object> f6486c = new LinkedBlockingQueue();
        /* renamed from: d */
        private LinkedBlockingQueue<LocalSocket> f6487d = new LinkedBlockingQueue();

        public C2003a(C2006c c2006c) {
            this.f6484a = c2006c;
            setName("Carlife AcceptThread");
        }

        /* renamed from: a */
        public void m7643a() {
            try {
                this.f6486c.put(new Object());
            } catch (Throwable e) {
                LogUtil.m4432a(C2006c.f6491b, e);
            }
        }

        /* renamed from: b */
        public LocalSocket m7644b() throws InterruptedException {
            return (LocalSocket) this.f6487d.take();
        }

        /* renamed from: c */
        public void m7645c() {
            this.f6485b = true;
            interrupt();
        }

        public void run() {
            while (true) {
                try {
                    this.f6486c.take();
                } catch (Throwable e) {
                    LogUtil.m4432a(C2006c.f6491b, e);
                    if (this.f6485b) {
                        return;
                    }
                }
                try {
                    LocalSocket localSocket = this.f6484a.f6493d.accept();
                    if (localSocket != null) {
                        try {
                            this.f6487d.put(localSocket);
                        } catch (Throwable e2) {
                            LogUtil.m4432a(C2006c.f6491b, e2);
                        }
                    }
                } catch (Throwable e22) {
                    LogUtil.m4432a(C2006c.f6491b, e22);
                    return;
                }
            }
        }
    }

    /* compiled from: SocketServer */
    /* renamed from: com.baidu.carlife.platform.communication.c$b */
    public interface C2004b {
        /* renamed from: a */
        void mo1753a(String str);
    }

    /* compiled from: SocketServer */
    /* renamed from: com.baidu.carlife.platform.communication.c$c */
    private class C2005c extends Thread {
        /* renamed from: a */
        final /* synthetic */ C2006c f6488a;
        /* renamed from: b */
        private boolean f6489b = false;

        public C2005c(C2006c c2006c) {
            this.f6488a = c2006c;
            setName("Carlife ShakeHandThread");
        }

        /* renamed from: a */
        private CLPackage m7647a(CLPackage pack) throws IllegalArgumentException {
            if (pack == null || !"Hi,Carlife".equals(pack.getDataInString())) {
                return null;
            }
            CLPackage p = new CLPackage();
            p.setData(C2006c.f6490a);
            return p;
        }

        /* renamed from: b */
        private String m7648b(CLPackage pack) {
            if (pack != null) {
                return pack.getDataInString();
            }
            return null;
        }

        /* renamed from: a */
        public void m7649a() {
            this.f6489b = true;
            interrupt();
        }

        public void run() {
            Throwable e;
            while (true) {
                boolean succeed = false;
                try {
                    LocalSocket socket = this.f6488a.f6494e.m7644b();
                    ObjectOutputStream objectOutputStream = null;
                    ObjectInputStream objectInputStream = null;
                    try {
                        ObjectInputStream objectInputStream2;
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(socket.getOutputStream());
                        try {
                            objectInputStream2 = new ObjectInputStream(socket.getInputStream());
                        } catch (IOException e2) {
                            e = e2;
                            objectOutputStream = objectOutputStream2;
                            LogUtil.m4432a(C2006c.f6491b, e);
                            if (succeed) {
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Throwable e3) {
                                        LogUtil.m4432a(C2006c.f6491b, e3);
                                    }
                                }
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Throwable e32) {
                                        LogUtil.m4432a(C2006c.f6491b, e32);
                                    }
                                }
                                if (socket != null) {
                                    try {
                                        socket.close();
                                    } catch (Throwable e322) {
                                        LogUtil.m4432a(C2006c.f6491b, e322);
                                    }
                                }
                            }
                        } catch (ClassNotFoundException e4) {
                            e322 = e4;
                            objectOutputStream = objectOutputStream2;
                            LogUtil.m4432a(C2006c.f6491b, e322);
                            if (succeed) {
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (socket != null) {
                                    socket.close();
                                }
                            }
                        } catch (IllegalArgumentException e5) {
                            e322 = e5;
                            objectOutputStream = objectOutputStream2;
                            LogUtil.m4432a(C2006c.f6491b, e322);
                            if (succeed) {
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (socket != null) {
                                    socket.close();
                                }
                            }
                        }
                        try {
                            CLPackage first = m7647a((CLPackage) objectInputStream2.readObject());
                            if (first == null) {
                                throw new IllegalArgumentException("illegal client");
                            }
                            objectOutputStream2.writeObject(first);
                            String clientName = m7648b((CLPackage) objectInputStream2.readObject());
                            if (TextUtils.isEmpty(clientName)) {
                                throw new IllegalArgumentException("illegal client");
                            }
                            if (this.f6488a.m7653a(clientName, new C2002b(socket, clientName))) {
                                succeed = true;
                                if (this.f6488a.f6498i != null) {
                                    this.f6488a.f6498i.mo1753a(clientName);
                                }
                                objectInputStream = objectInputStream2;
                                objectOutputStream = objectOutputStream2;
                                if (succeed) {
                                    if (objectInputStream != null) {
                                        objectInputStream.close();
                                    }
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                    }
                                    if (socket != null) {
                                        socket.close();
                                    }
                                }
                            } else {
                                throw new IllegalArgumentException("illegal client");
                            }
                        } catch (IOException e6) {
                            e322 = e6;
                            objectInputStream = objectInputStream2;
                            objectOutputStream = objectOutputStream2;
                            LogUtil.m4432a(C2006c.f6491b, e322);
                            if (succeed) {
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (socket != null) {
                                    socket.close();
                                }
                            }
                        } catch (ClassNotFoundException e7) {
                            e322 = e7;
                            objectInputStream = objectInputStream2;
                            objectOutputStream = objectOutputStream2;
                            LogUtil.m4432a(C2006c.f6491b, e322);
                            if (succeed) {
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (socket != null) {
                                    socket.close();
                                }
                            }
                        } catch (IllegalArgumentException e8) {
                            e322 = e8;
                            objectInputStream = objectInputStream2;
                            objectOutputStream = objectOutputStream2;
                            LogUtil.m4432a(C2006c.f6491b, e322);
                            if (succeed) {
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (socket != null) {
                                    socket.close();
                                }
                            }
                        }
                    } catch (IOException e9) {
                        e322 = e9;
                        LogUtil.m4432a(C2006c.f6491b, e322);
                        if (succeed) {
                            if (objectInputStream != null) {
                                objectInputStream.close();
                            }
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            if (socket != null) {
                                socket.close();
                            }
                        }
                    } catch (ClassNotFoundException e10) {
                        e322 = e10;
                        LogUtil.m4432a(C2006c.f6491b, e322);
                        if (succeed) {
                            if (objectInputStream != null) {
                                objectInputStream.close();
                            }
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            if (socket != null) {
                                socket.close();
                            }
                        }
                    } catch (IllegalArgumentException e11) {
                        e322 = e11;
                        LogUtil.m4432a(C2006c.f6491b, e322);
                        if (succeed) {
                            if (objectInputStream != null) {
                                objectInputStream.close();
                            }
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            if (socket != null) {
                                socket.close();
                            }
                        }
                    }
                } catch (Throwable e3222) {
                    LogUtil.m4432a(C2006c.f6491b, e3222);
                    if (this.f6489b) {
                        return;
                    }
                }
            }
        }
    }

    private C2006c() throws IOException {
        this.f6494e.start();
        this.f6495f = new C2005c(this);
        this.f6495f.start();
    }

    /* renamed from: a */
    public static C2006c m7651a() {
        if (f6492c == null) {
            try {
                f6492c = new C2006c();
            } catch (Throwable e) {
                LogUtil.m4438b(f6491b, e);
            }
        }
        return f6492c;
    }

    /* renamed from: a */
    public void m7658a(C2004b listener) {
        this.f6498i = listener;
    }

    /* renamed from: b */
    public void m7659b() {
        this.f6494e.m7643a();
    }

    /* renamed from: c */
    public void m7660c() {
        this.f6494e.m7645c();
        this.f6495f.m7649a();
    }

    /* renamed from: a */
    private boolean m7653a(String clientName, C2002b client) {
        boolean z;
        synchronized (this.f6497h) {
            if (this.f6496g.containsKey(clientName)) {
                z = false;
            } else {
                this.f6496g.put(clientName, client);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public C2002b m7657a(String clientName) {
        C2002b client;
        synchronized (this.f6497h) {
            client = (C2002b) this.f6496g.get(clientName);
            this.f6496g.remove(clientName);
        }
        return client;
    }
}
