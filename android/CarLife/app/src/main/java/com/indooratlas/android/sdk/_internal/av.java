package com.indooratlas.android.sdk._internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class av {
    /* renamed from: a */
    String f23022a;
    /* renamed from: b */
    public C5774c f23023b;
    /* renamed from: c */
    HandlerThread f23024c;

    /* renamed from: com.indooratlas.android.sdk._internal.av$a */
    public static class C5769a {
        /* renamed from: a */
        private int f22993a;
        /* renamed from: b */
        private au f22994b;
        /* renamed from: c */
        private au f22995c;

        C5769a(Message message, au auVar, au auVar2) {
            m19855a(message, auVar, auVar2);
        }

        /* renamed from: a */
        public final void m19855a(Message message, au auVar, au auVar2) {
            this.f22993a = message.what;
            this.f22994b = auVar;
            this.f22995c = auVar2;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("what=");
            stringBuilder.append(this.f22993a);
            stringBuilder.append(" state=");
            stringBuilder.append(C5769a.m19854a(this.f22994b));
            stringBuilder.append(" orgState=");
            stringBuilder.append(C5769a.m19854a(this.f22995c));
            return stringBuilder.toString();
        }

        /* renamed from: a */
        private static String m19854a(Object obj) {
            if (obj == null) {
                return "null";
            }
            String name = obj.getClass().getName();
            return name.substring(name.lastIndexOf(36) + 1);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.av$b */
    static class C5770b {
        /* renamed from: a */
        private Vector<C5769a> f22996a = new Vector();
        /* renamed from: b */
        private int f22997b = 20;
        /* renamed from: c */
        private int f22998c = 0;
        /* renamed from: d */
        private int f22999d = 0;

        C5770b() {
        }

        /* renamed from: a */
        final void m19856a(Message message, au auVar, au auVar2) {
            this.f22999d++;
            if (this.f22996a.size() < this.f22997b) {
                this.f22996a.add(new C5769a(message, auVar, auVar2));
                return;
            }
            C5769a c5769a = (C5769a) this.f22996a.get(this.f22998c);
            this.f22998c++;
            if (this.f22998c >= this.f22997b) {
                this.f22998c = 0;
            }
            c5769a.m19855a(message, auVar, auVar2);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.av$c */
    public static class C5774c extends Handler {
        /* renamed from: b */
        private static final Object f23006b = new Object();
        /* renamed from: a */
        private boolean f23007a;
        /* renamed from: c */
        private Message f23008c;
        /* renamed from: d */
        private C5770b f23009d;
        /* renamed from: e */
        private boolean f23010e;
        /* renamed from: f */
        private C5773c[] f23011f;
        /* renamed from: g */
        private int f23012g;
        /* renamed from: h */
        private C5773c[] f23013h;
        /* renamed from: i */
        private int f23014i;
        /* renamed from: j */
        private C5771a f23015j;
        /* renamed from: k */
        private C5772b f23016k;
        /* renamed from: l */
        private av f23017l;
        /* renamed from: m */
        private HashMap<au, C5773c> f23018m;
        /* renamed from: n */
        private au f23019n;
        /* renamed from: o */
        private au f23020o;
        /* renamed from: p */
        private ArrayList<Message> f23021p;

        /* renamed from: com.indooratlas.android.sdk._internal.av$c$a */
        class C5771a extends au {
            /* renamed from: a */
            final /* synthetic */ C5774c f23000a;

            private C5771a(C5774c c5774c) {
                this.f23000a = c5774c;
            }

            /* renamed from: a */
            public final boolean mo4601a(Message message) {
                this.f23000a.f23017l;
                return true;
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.av$c$b */
        class C5772b extends au {
            /* renamed from: a */
            final /* synthetic */ C5774c f23001a;

            private C5772b(C5774c c5774c) {
                this.f23001a = c5774c;
            }

            /* renamed from: a */
            public final boolean mo4601a(Message message) {
                return false;
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.av$c$c */
        class C5773c {
            /* renamed from: a */
            au f23002a;
            /* renamed from: b */
            C5773c f23003b;
            /* renamed from: c */
            boolean f23004c;
            /* renamed from: d */
            final /* synthetic */ C5774c f23005d;

            private C5773c(C5774c c5774c) {
                this.f23005d = c5774c;
            }

            public final String toString() {
                String str;
                StringBuilder append = new StringBuilder("state=").append(this.f23002a.m19853c()).append(",active=").append(this.f23004c).append(",parent=");
                if (this.f23003b == null) {
                    str = "null";
                } else {
                    str = this.f23003b.f23002a.m19853c();
                }
                return append.append(str).toString();
            }
        }

        /* renamed from: c */
        public static /* synthetic */ void m19873c(C5774c c5774c) {
            if (c5774c.f23007a) {
                Log.d("StateMachine", "completeConstruction: E");
            }
            int i = 0;
            for (C5773c c5773c : c5774c.f23018m.values()) {
                int i2 = 0;
                C5773c c5773c2;
                while (c5773c2 != null) {
                    c5773c2 = c5773c2.f23003b;
                    i2++;
                }
                if (i >= i2) {
                    i2 = i;
                }
                i = i2;
            }
            if (c5774c.f23007a) {
                Log.d("StateMachine", "completeConstruction: maxDepth=" + i);
            }
            c5774c.f23011f = new C5773c[i];
            c5774c.f23013h = new C5773c[i];
            c5774c.m19874d();
            c5774c.f23010e = true;
            c5774c.f23008c = c5774c.obtainMessage(-1);
            c5774c.m19863a(0);
            c5774c.m19862a();
            if (c5774c.f23007a) {
                Log.d("StateMachine", "completeConstruction: X");
            }
        }

        public final void handleMessage(Message msg) {
            if (this.f23007a) {
                Log.d("StateMachine", "handleMessage: E msg.what=" + msg.what);
            }
            this.f23008c = msg;
            if (this.f23010e) {
                m19864a(msg);
                m19862a();
                if (this.f23007a) {
                    Log.d("StateMachine", "handleMessage: X");
                    return;
                }
                return;
            }
            Log.e("StateMachine", "The start method not called, ignore msg: " + msg);
        }

        /* renamed from: a */
        private void m19862a() {
            C5772b c5772b = null;
            while (this.f23020o != null) {
                if (this.f23007a) {
                    Log.d("StateMachine", "handleMessage: new destination call exit");
                }
                au auVar = this.f23020o;
                this.f23020o = null;
                this.f23014i = 0;
                C5773c c5773c = (C5773c) this.f23018m.get(auVar);
                do {
                    C5773c[] c5773cArr = this.f23013h;
                    int i = this.f23014i;
                    this.f23014i = i + 1;
                    c5773cArr[i] = c5773c;
                    c5773c = c5773c.f23003b;
                    if (c5773c == null) {
                        break;
                    }
                } while (!c5773c.f23004c);
                if (this.f23007a) {
                    Log.d("StateMachine", "setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.f23014i + ",curStateInfo: " + c5773c);
                }
                m19866a(c5773c);
                m19863a(m19872c());
                m19870b();
                au auVar2 = auVar;
            }
            if (c5772b != null && c5772b == this.f23016k) {
                this.f23017l.mo4628a();
                if (this.f23017l.f23024c != null) {
                    getLooper().quit();
                    this.f23017l.f23024c = null;
                }
            }
        }

        /* renamed from: a */
        private final void m19864a(Message message) {
            C5773c c5773c = this.f23011f[this.f23012g];
            if (this.f23007a) {
                Log.d("StateMachine", "processMsg: " + c5773c.f23002a.m19853c());
            }
            while (!c5773c.f23002a.mo4601a(message)) {
                c5773c = c5773c.f23003b;
                if (c5773c == null) {
                    Object obj;
                    av avVar = this.f23017l;
                    if (avVar.f23023b.f23007a) {
                        Log.e("StateMachine", avVar.f23022a + " - unhandledMessage: msg.what=" + message.what);
                    }
                    if (message.what == -1 && message.obj == f23006b) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m19865a(this.f23016k);
                    }
                    if (c5773c == null) {
                        this.f23009d.m19856a(message, c5773c.f23002a, this.f23011f[this.f23012g].f23002a);
                    }
                    this.f23009d.m19856a(message, null, null);
                    return;
                } else if (this.f23007a) {
                    Log.d("StateMachine", "processMsg: " + c5773c.f23002a.m19853c());
                }
            }
            if (c5773c == null) {
                this.f23009d.m19856a(message, null, null);
                return;
            }
            this.f23009d.m19856a(message, c5773c.f23002a, this.f23011f[this.f23012g].f23002a);
        }

        /* renamed from: a */
        private final void m19866a(C5773c c5773c) {
            while (this.f23012g >= 0 && this.f23011f[this.f23012g] != c5773c) {
                au auVar = this.f23011f[this.f23012g].f23002a;
                if (this.f23007a) {
                    Log.d("StateMachine", "invokeExitMethods: " + auVar.m19853c());
                }
                auVar.mo4622b();
                this.f23011f[this.f23012g].f23004c = false;
                this.f23012g--;
            }
        }

        /* renamed from: a */
        private final void m19863a(int i) {
            while (i <= this.f23012g) {
                if (this.f23007a) {
                    Log.d("StateMachine", "invokeEnterMethods: " + this.f23011f[i].f23002a.m19853c());
                }
                this.f23011f[i].f23002a.mo4621a();
                this.f23011f[i].f23004c = true;
                i++;
            }
        }

        /* renamed from: b */
        private final void m19870b() {
            for (int size = this.f23021p.size() - 1; size >= 0; size--) {
                Message message = (Message) this.f23021p.get(size);
                if (this.f23007a) {
                    Log.d("StateMachine", "moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.f23021p.clear();
        }

        /* renamed from: c */
        private final int m19872c() {
            int i = this.f23012g + 1;
            int i2 = i;
            for (int i3 = this.f23014i - 1; i3 >= 0; i3--) {
                if (this.f23007a) {
                    Log.d("StateMachine", "moveTempStackToStateStack: i=" + i3 + ",j=" + i2);
                }
                this.f23011f[i2] = this.f23013h[i3];
                i2++;
            }
            this.f23012g = i2 - 1;
            if (this.f23007a) {
                Log.d("StateMachine", "moveTempStackToStateStack: X mStateStackTop=" + this.f23012g + ",startingIndex=" + i + ",Top=" + this.f23011f[this.f23012g].f23002a.m19853c());
            }
            return i;
        }

        /* renamed from: d */
        private final void m19874d() {
            if (this.f23007a) {
                Log.d("StateMachine", "setupInitialStateStack: E mInitialState=" + this.f23019n.m19853c());
            }
            C5773c c5773c = (C5773c) this.f23018m.get(this.f23019n);
            this.f23014i = 0;
            while (c5773c != null) {
                this.f23013h[this.f23014i] = c5773c;
                c5773c = c5773c.f23003b;
                this.f23014i++;
            }
            this.f23012g = -1;
            m19872c();
        }

        /* renamed from: a */
        private final C5773c m19859a(au auVar, au auVar2) {
            C5773c c5773c;
            C5773c c5773c2 = null;
            if (this.f23007a) {
                String str;
                String str2 = "StateMachine";
                StringBuilder append = new StringBuilder("addStateInternal: E state=").append(auVar.m19853c()).append(",parent=");
                if (auVar2 == null) {
                    str = "";
                } else {
                    str = auVar2.m19853c();
                }
                Log.d(str2, append.append(str).toString());
            }
            if (auVar2 != null) {
                c5773c = (C5773c) this.f23018m.get(auVar2);
                if (c5773c == null) {
                    c5773c2 = m19859a(auVar2, null);
                } else {
                    c5773c2 = c5773c;
                }
            }
            c5773c = (C5773c) this.f23018m.get(auVar);
            if (c5773c == null) {
                c5773c = new C5773c();
                this.f23018m.put(auVar, c5773c);
            }
            if (c5773c.f23003b == null || c5773c.f23003b == c5773c2) {
                c5773c.f23002a = auVar;
                c5773c.f23003b = c5773c2;
                c5773c.f23004c = false;
                if (this.f23007a) {
                    Log.d("StateMachine", "addStateInternal: X stateInfo: " + c5773c);
                }
                return c5773c;
            }
            throw new RuntimeException("state already added");
        }

        private C5774c(Looper looper, av avVar) {
            super(looper);
            this.f23007a = false;
            this.f23009d = new C5770b();
            this.f23012g = -1;
            this.f23015j = new C5771a();
            this.f23016k = new C5772b();
            this.f23018m = new HashMap();
            this.f23021p = new ArrayList();
            this.f23017l = avVar;
            m19859a(this.f23015j, null);
            m19859a(this.f23016k, null);
        }

        /* renamed from: a */
        private final void m19865a(at atVar) {
            this.f23020o = (au) atVar;
            if (this.f23007a) {
                Log.d("StateMachine", "StateMachine.transitionTo EX destState" + this.f23020o.m19853c());
            }
        }

        /* renamed from: a */
        public static /* synthetic */ void m19869a(C5774c c5774c, au auVar) {
            if (c5774c.f23007a) {
                Log.d("StateMachine", "setInitialState: initialState" + auVar.m19853c());
            }
            c5774c.f23019n = auVar;
        }

        /* renamed from: a */
        public static /* synthetic */ void m19867a(C5774c c5774c, Message message) {
            if (c5774c.f23007a) {
                Log.d("StateMachine", "deferMessage: msg=" + message.what);
            }
            Message obtainMessage = c5774c.obtainMessage();
            obtainMessage.copyFrom(message);
            c5774c.f23021p.add(obtainMessage);
        }

        /* renamed from: b */
        public static /* synthetic */ void m19871b(C5774c c5774c) {
            if (c5774c.f23007a) {
                Log.d("StateMachine", "quit:");
            }
            c5774c.sendMessage(c5774c.obtainMessage(-1, f23006b));
        }
    }

    /* renamed from: a */
    private void m19875a(String str, Looper looper) {
        this.f23022a = str;
        this.f23023b = new C5774c(looper, this);
    }

    public av(String str) {
        this.f23024c = new HandlerThread(str);
        this.f23024c.start();
        m19875a(str, this.f23024c.getLooper());
    }

    public av(String str, Looper looper) {
        m19875a(str, looper);
    }

    /* renamed from: a */
    public final void m19883a(au auVar, au auVar2) {
        this.f23023b.m19859a(auVar, auVar2);
    }

    /* renamed from: a */
    public final void m19882a(au auVar) {
        this.f23023b.m19859a(auVar, null);
    }

    /* renamed from: a */
    public final void m19881a(at atVar) {
        this.f23023b.m19865a(atVar);
    }

    /* renamed from: a */
    public void mo4628a() {
    }

    /* renamed from: a */
    public final Message m19876a(int i) {
        return Message.obtain(this.f23023b, i);
    }

    /* renamed from: a */
    public final Message m19878a(int i, Object obj) {
        return Message.obtain(this.f23023b, i, obj);
    }

    /* renamed from: a */
    public final Message m19877a(int i, int i2, int i3, Object obj) {
        return Message.obtain(this.f23023b, i, i2, i3, obj);
    }

    /* renamed from: b */
    public final void m19884b(int i) {
        this.f23023b.sendMessage(m19876a(i));
    }

    /* renamed from: b */
    public final void m19885b(int i, Object obj) {
        this.f23023b.sendMessage(m19878a(i, obj));
    }

    /* renamed from: a */
    public final void m19880a(int i, long j) {
        this.f23023b.sendMessageDelayed(m19876a(i), j);
    }

    /* renamed from: c */
    public final void m19886c(int i) {
        this.f23023b.removeMessages(i);
    }
}
