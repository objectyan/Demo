package com.indooratlas.android.sdk._internal;

import com.baidu.che.codriver.vr.C2848p;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;

public class gw {
    /* renamed from: a */
    private static final gw f24022a = m20763c();

    /* renamed from: com.indooratlas.android.sdk._internal.gw$a */
    static class C5931a extends gw {
        /* renamed from: a */
        private final gv<Socket> f24023a;
        /* renamed from: b */
        private final gv<Socket> f24024b;
        /* renamed from: c */
        private final Method f24025c;
        /* renamed from: d */
        private final Method f24026d;
        /* renamed from: e */
        private final gv<Socket> f24027e;
        /* renamed from: f */
        private final gv<Socket> f24028f;

        public C5931a(gv<Socket> gvVar, gv<Socket> gvVar2, Method method, Method method2, gv<Socket> gvVar3, gv<Socket> gvVar4) {
            this.f24023a = gvVar;
            this.f24024b = gvVar2;
            this.f24025c = method;
            this.f24026d = method2;
            this.f24027e = gvVar3;
            this.f24028f = gvVar4;
        }

        /* renamed from: a */
        public final void mo4698a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (AssertionError e) {
                if (gy.m20795a(e)) {
                    throw new IOException(e);
                }
                throw e;
            } catch (Throwable e2) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
        }

        /* renamed from: a */
        public final void mo4699a(SSLSocket sSLSocket, String str, List<gi> list) {
            if (str != null) {
                this.f24023a.m20758a(sSLSocket, Boolean.valueOf(true));
                this.f24024b.m20758a(sSLSocket, str);
            }
            if (this.f24028f != null && this.f24028f.m20759a((Object) sSLSocket)) {
                Object[] objArr = new Object[1];
                in inVar = new in();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    gi giVar = (gi) list.get(i);
                    if (giVar != gi.HTTP_1_0) {
                        inVar.b(giVar.toString().length());
                        inVar.a(giVar.toString());
                    }
                }
                objArr[0] = inVar.n();
                this.f24028f.m20760b(sSLSocket, objArr);
            }
        }

        /* renamed from: b */
        public final String mo4700b(SSLSocket sSLSocket) {
            if (this.f24027e == null) {
                return null;
            }
            if (!this.f24027e.m20759a((Object) sSLSocket)) {
                return null;
            }
            byte[] bArr = (byte[]) this.f24027e.m20760b(sSLSocket, new Object[0]);
            return bArr != null ? new String(bArr, gy.f24042c) : null;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.gw$b */
    static class C5932b extends gw {
        /* renamed from: a */
        private final Method f24029a;
        /* renamed from: b */
        private final Method f24030b;
        /* renamed from: c */
        private final Method f24031c;
        /* renamed from: d */
        private final Class<?> f24032d;
        /* renamed from: e */
        private final Class<?> f24033e;

        public C5932b(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
            this.f24029a = method;
            this.f24030b = method2;
            this.f24031c = method3;
            this.f24032d = cls;
            this.f24033e = cls2;
        }

        /* renamed from: a */
        public final void mo4699a(SSLSocket sSLSocket, String str, List<gi> list) {
            Object newProxyInstance;
            List arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                gi giVar = (gi) list.get(i);
                if (giVar != gi.HTTP_1_0) {
                    arrayList.add(giVar.toString());
                }
            }
            try {
                newProxyInstance = Proxy.newProxyInstance(gw.class.getClassLoader(), new Class[]{this.f24032d, this.f24033e}, new C5933c(arrayList));
                this.f24029a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
            } catch (InvocationTargetException e) {
                newProxyInstance = e;
                throw new AssertionError(newProxyInstance);
            } catch (IllegalAccessException e2) {
                newProxyInstance = e2;
                throw new AssertionError(newProxyInstance);
            }
        }

        /* renamed from: a */
        public final void mo4701a(SSLSocket sSLSocket) {
            try {
                this.f24031c.invoke(null, new Object[]{sSLSocket});
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new AssertionError();
            }
        }

        /* renamed from: b */
        public final String mo4700b(SSLSocket sSLSocket) {
            try {
                C5933c c5933c = (C5933c) Proxy.getInvocationHandler(this.f24030b.invoke(null, new Object[]{sSLSocket}));
                if (c5933c.f24035b || c5933c.f24036c != null) {
                    return c5933c.f24035b ? null : c5933c.f24036c;
                } else {
                    gs.f23876a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
            } catch (InvocationTargetException e) {
                throw new AssertionError();
            } catch (IllegalAccessException e2) {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.gw$c */
    static class C5933c implements InvocationHandler {
        /* renamed from: a */
        private final List<String> f24034a;
        /* renamed from: b */
        private boolean f24035b;
        /* renamed from: c */
        private String f24036c;

        public C5933c(List<String> list) {
            this.f24034a = list;
        }

        public final Object invoke(Object obj, Method method, Object[] args) throws Throwable {
            String name = method.getName();
            Class returnType = method.getReturnType();
            if (args == null) {
                args = gy.f24041b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f24035b = true;
                return null;
            } else if (name.equals("protocols") && args.length == 0) {
                return this.f24034a;
            } else {
                if ((name.equals("selectProtocol") || name.equals(C2848p.f9278E)) && String.class == returnType && args.length == 1 && (args[0] instanceof List)) {
                    List list = (List) args[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f24034a.contains(list.get(i))) {
                            name = (String) list.get(i);
                            this.f24036c = name;
                            return name;
                        }
                    }
                    name = (String) this.f24034a.get(0);
                    this.f24036c = name;
                    return name;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || args.length != 1) {
                    return method.invoke(this, args);
                } else {
                    this.f24036c = (String) args[0];
                    return null;
                }
            }
        }
    }

    /* renamed from: a */
    public static gw m20761a() {
        return f24022a;
    }

    /* renamed from: b */
    public static String m20762b() {
        return "OkHttp";
    }

    /* renamed from: a */
    public void mo4699a(SSLSocket sSLSocket, String str, List<gi> list) {
    }

    /* renamed from: a */
    public void mo4701a(SSLSocket sSLSocket) {
    }

    /* renamed from: b */
    public String mo4700b(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: a */
    public void mo4698a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: c */
    private static gw m20763c() {
        Method method;
        Method method2;
        Method method3;
        gv gvVar;
        gv gvVar2;
        Method method4;
        gv gvVar3;
        try {
            Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        try {
            gv gvVar4 = new gv(null, "setUseSessionTickets", Boolean.TYPE);
            gv gvVar5 = new gv(null, "setHostname", String.class);
            try {
                Class cls = Class.forName("android.net.TrafficStats");
                method = cls.getMethod("tagSocket", new Class[]{Socket.class});
                try {
                    method2 = cls.getMethod("untagSocket", new Class[]{Socket.class});
                } catch (ClassNotFoundException e2) {
                    method3 = method;
                    method2 = null;
                    method = method3;
                    gvVar = null;
                    gvVar2 = null;
                    method4 = method;
                    gvVar3 = gvVar;
                    return new C5931a(gvVar4, gvVar5, method4, method2, gvVar3, gvVar2);
                } catch (NoSuchMethodException e3) {
                    gvVar = null;
                    method2 = null;
                    gvVar2 = null;
                    method4 = method;
                    gvVar3 = gvVar;
                    return new C5931a(gvVar4, gvVar5, method4, method2, gvVar3, gvVar2);
                }
                try {
                    Class.forName("android.net.Network");
                    gvVar = new gv(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                } catch (ClassNotFoundException e4) {
                    gvVar = null;
                    gvVar2 = null;
                    method4 = method;
                    gvVar3 = gvVar;
                    return new C5931a(gvVar4, gvVar5, method4, method2, gvVar3, gvVar2);
                } catch (NoSuchMethodException e5) {
                    gvVar = null;
                    gvVar2 = null;
                    method4 = method;
                    gvVar3 = gvVar;
                    return new C5931a(gvVar4, gvVar5, method4, method2, gvVar3, gvVar2);
                }
                try {
                    gvVar2 = new gv(null, "setAlpnProtocols", byte[].class);
                    method4 = method;
                    gvVar3 = gvVar;
                } catch (ClassNotFoundException e6) {
                    gvVar2 = null;
                    method4 = method;
                    gvVar3 = gvVar;
                    return new C5931a(gvVar4, gvVar5, method4, method2, gvVar3, gvVar2);
                } catch (NoSuchMethodException e7) {
                    gvVar2 = null;
                    method4 = method;
                    gvVar3 = gvVar;
                    return new C5931a(gvVar4, gvVar5, method4, method2, gvVar3, gvVar2);
                }
            } catch (ClassNotFoundException e8) {
                method3 = null;
                method2 = null;
                method = method3;
                gvVar = null;
                gvVar2 = null;
                method4 = method;
                gvVar3 = gvVar;
                return new C5931a(gvVar4, gvVar5, method4, method2, gvVar3, gvVar2);
            } catch (NoSuchMethodException e9) {
                gvVar = null;
                method2 = null;
                method = null;
                gvVar2 = null;
                method4 = method;
                gvVar3 = gvVar;
                return new C5931a(gvVar4, gvVar5, method4, method2, gvVar3, gvVar2);
            }
            return new C5931a(gvVar4, gvVar5, method4, method2, gvVar3, gvVar2);
        } catch (ClassNotFoundException e10) {
            try {
                String str = "org.eclipse.jetty.alpn.ALPN";
                Class cls2 = Class.forName(str);
                Class cls3 = Class.forName(str + "$Provider");
                Class cls4 = Class.forName(str + "$ClientProvider");
                Class cls5 = Class.forName(str + "$ServerProvider");
                return new C5932b(cls2.getMethod("put", new Class[]{SSLSocket.class, cls3}), cls2.getMethod("get", new Class[]{SSLSocket.class}), cls2.getMethod("remove", new Class[]{SSLSocket.class}), cls4, cls5);
            } catch (ClassNotFoundException e11) {
                return new gw();
            } catch (NoSuchMethodException e12) {
                return new gw();
            }
        }
    }
}
