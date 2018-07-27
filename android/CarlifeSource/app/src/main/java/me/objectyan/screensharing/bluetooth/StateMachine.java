package com.baidu.carlife.bluetooth;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

/* compiled from: StateMachine */
/* renamed from: com.baidu.carlife.bluetooth.n */
public class StateMachine {
    /* renamed from: A */
    public static final boolean f2653A = true;
    /* renamed from: B */
    public static final boolean f2654B = false;
    /* renamed from: a */
    private static final String f2655a = "StateMachine";
    /* renamed from: y */
    public static final int f2656y = -1;
    /* renamed from: z */
    public static final int f2657z = -2;
    /* renamed from: b */
    private String f2658b;
    /* renamed from: c */
    private C1088c f2659c;
    /* renamed from: d */
    private HandlerThread f2660d;

    /* compiled from: StateMachine */
    /* renamed from: com.baidu.carlife.bluetooth.n$a */
    public static class C1083a {
        /* renamed from: a */
        private long f2838a;
        /* renamed from: b */
        private int f2839b;
        /* renamed from: c */
        private String f2840c;
        /* renamed from: d */
        private State f2841d;
        /* renamed from: e */
        private State f2842e;

        C1083a(Message msg, String info, State state, State orgState) {
            m3637a(msg, info, state, orgState);
        }

        /* renamed from: a */
        public void m3637a(Message msg, String info, State state, State orgState) {
            this.f2838a = System.currentTimeMillis();
            this.f2839b = msg.what;
            this.f2840c = info;
            this.f2841d = state;
            this.f2842e = orgState;
        }

        /* renamed from: a */
        public long m3636a() {
            return this.f2838a;
        }

        /* renamed from: b */
        public long m3638b() {
            return (long) this.f2839b;
        }

        /* renamed from: c */
        public String m3639c() {
            return this.f2840c;
        }

        /* renamed from: d */
        public State m3640d() {
            return this.f2841d;
        }

        /* renamed from: e */
        public State m3641e() {
            return this.f2842e;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("time=");
            Calendar.getInstance().setTimeInMillis(this.f2838a);
            sb.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{c, c, c, c, c, c}));
            sb.append(" state=");
            sb.append(this.f2841d == null ? "<null>" : this.f2841d.mo1381c());
            sb.append(" orgState=");
            sb.append(this.f2842e == null ? "<null>" : this.f2842e.mo1381c());
            sb.append(" what=");
            sb.append(this.f2839b);
            sb.append("(0x");
            sb.append(Integer.toHexString(this.f2839b));
            sb.append(")");
            if (!TextUtils.isEmpty(this.f2840c)) {
                sb.append(" ");
                sb.append(this.f2840c);
            }
            return sb.toString();
        }
    }

    /* compiled from: StateMachine */
    /* renamed from: com.baidu.carlife.bluetooth.n$b */
    private static class C1084b {
        /* renamed from: a */
        private static final int f2843a = 20;
        /* renamed from: b */
        private Vector<C1083a> f2844b;
        /* renamed from: c */
        private int f2845c;
        /* renamed from: d */
        private int f2846d;
        /* renamed from: e */
        private int f2847e;

        private C1084b() {
            this.f2844b = new Vector();
            this.f2845c = 20;
            this.f2846d = 0;
            this.f2847e = 0;
        }

        /* renamed from: a */
        void m3643a(int maxSize) {
            this.f2845c = maxSize;
            this.f2847e = 0;
            this.f2844b.clear();
        }

        /* renamed from: a */
        int m3642a() {
            return this.f2844b.size();
        }

        /* renamed from: b */
        int m3645b() {
            return this.f2847e;
        }

        /* renamed from: c */
        void m3647c() {
            this.f2844b.clear();
        }

        /* renamed from: b */
        C1083a m3646b(int index) {
            int nextIndex = this.f2846d + index;
            if (nextIndex >= this.f2845c) {
                nextIndex -= this.f2845c;
            }
            if (nextIndex >= m3642a()) {
                return null;
            }
            return (C1083a) this.f2844b.get(nextIndex);
        }

        /* renamed from: a */
        void m3644a(Message msg, String messageInfo, State state, State orgState) {
            this.f2847e++;
            if (this.f2844b.size() < this.f2845c) {
                this.f2844b.add(new C1083a(msg, messageInfo, state, orgState));
                return;
            }
            C1083a pmi = (C1083a) this.f2844b.get(this.f2846d);
            this.f2846d++;
            if (this.f2846d >= this.f2845c) {
                this.f2846d = 0;
            }
            pmi.m3637a(msg, messageInfo, state, orgState);
        }
    }

    /* compiled from: StateMachine */
    /* renamed from: com.baidu.carlife.bluetooth.n$c */
    private static class C1088c extends Handler {
        /* renamed from: b */
        private static final Object f2854b = new Object();
        /* renamed from: a */
        private boolean f2855a;
        /* renamed from: c */
        private Message f2856c;
        /* renamed from: d */
        private C1084b f2857d;
        /* renamed from: e */
        private boolean f2858e;
        /* renamed from: f */
        private C1087c[] f2859f;
        /* renamed from: g */
        private int f2860g;
        /* renamed from: h */
        private C1087c[] f2861h;
        /* renamed from: i */
        private int f2862i;
        /* renamed from: j */
        private C1085a f2863j;
        /* renamed from: k */
        private C1086b f2864k;
        /* renamed from: l */
        private StateMachine f2865l;
        /* renamed from: m */
        private HashMap<State, C1087c> f2866m;
        /* renamed from: n */
        private State f2867n;
        /* renamed from: o */
        private State f2868o;
        /* renamed from: p */
        private ArrayList<Message> f2869p;

        /* compiled from: StateMachine */
        /* renamed from: com.baidu.carlife.bluetooth.n$c$a */
        private class C1085a extends State {
            /* renamed from: a */
            final /* synthetic */ C1088c f2848a;

            private C1085a(C1088c c1088c) {
                this.f2848a = c1088c;
            }

            /* renamed from: a */
            public boolean mo1379a(Message msg) {
                this.f2848a.f2865l.m3339c(msg);
                return true;
            }
        }

        /* compiled from: StateMachine */
        /* renamed from: com.baidu.carlife.bluetooth.n$c$b */
        private class C1086b extends State {
            /* renamed from: a */
            final /* synthetic */ C1088c f2849a;

            private C1086b(C1088c c1088c) {
                this.f2849a = c1088c;
            }

            /* renamed from: a */
            public boolean mo1379a(Message msg) {
                return false;
            }
        }

        /* compiled from: StateMachine */
        /* renamed from: com.baidu.carlife.bluetooth.n$c$c */
        private class C1087c {
            /* renamed from: a */
            State f2850a;
            /* renamed from: b */
            C1087c f2851b;
            /* renamed from: c */
            boolean f2852c;
            /* renamed from: d */
            final /* synthetic */ C1088c f2853d;

            private C1087c(C1088c c1088c) {
                this.f2853d = c1088c;
            }

            public String toString() {
                String str;
                StringBuilder append = new StringBuilder().append("state=").append(this.f2850a.mo1381c()).append(",active=").append(this.f2852c).append(",parent=");
                if (this.f2851b == null) {
                    str = "null";
                } else {
                    str = this.f2851b.f2850a.mo1381c();
                }
                return append.append(str).toString();
            }
        }

        public final void handleMessage(Message msg) {
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "handleMessage: E msg.what=" + msg.what);
            }
            this.f2856c = msg;
            if (this.f2858e) {
                m3656a(msg);
            } else if (!this.f2858e && this.f2856c.what == -2 && this.f2856c.obj == f2854b) {
                this.f2858e = true;
                m3655a(0);
            } else {
                throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + msg);
            }
            m3654a();
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "handleMessage: X");
            }
        }

        /* renamed from: a */
        private void m3654a() {
            State destState = null;
            while (this.f2868o != null) {
                if (this.f2855a) {
                    Log.d(StateMachine.f2655a, "handleMessage: new destination call exit");
                }
                destState = this.f2868o;
                this.f2868o = null;
                m3658a(m3650a(destState));
                m3655a(m3678e());
                m3677d();
            }
            if (destState == null) {
                return;
            }
            if (destState == this.f2864k) {
                m3667b();
            } else if (destState == this.f2863j) {
                this.f2865l.mo1382g();
            }
        }

        /* renamed from: b */
        private final void m3667b() {
            this.f2865l.m3352u();
            if (this.f2865l.f2660d != null) {
                getLooper().quit();
                this.f2865l.f2660d = null;
            }
            this.f2865l.f2659c = null;
            this.f2865l = null;
            this.f2856c = null;
            this.f2857d.m3647c();
            this.f2859f = null;
            this.f2861h = null;
            this.f2866m.clear();
            this.f2867n = null;
            this.f2868o = null;
            this.f2869p.clear();
        }

        /* renamed from: c */
        private final void m3674c() {
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "completeConstruction: E");
            }
            int maxDepth = 0;
            for (C1087c i : this.f2866m.values()) {
                int depth = 0;
                C1087c i2;
                while (i2 != null) {
                    i2 = i2.f2851b;
                    depth++;
                }
                if (maxDepth < depth) {
                    maxDepth = depth;
                }
            }
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "completeConstruction: maxDepth=" + maxDepth);
            }
            this.f2859f = new C1087c[maxDepth];
            this.f2861h = new C1087c[maxDepth];
            m3681f();
            sendMessageAtFrontOfQueue(obtainMessage(-2, f2854b));
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "completeConstruction: X");
            }
        }

        /* renamed from: a */
        private final void m3656a(Message msg) {
            C1087c curStateInfo = this.f2859f[this.f2860g];
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "processMsg: " + curStateInfo.f2850a.mo1381c());
            }
            while (!curStateInfo.f2850a.mo1379a(msg)) {
                curStateInfo = curStateInfo.f2851b;
                if (curStateInfo == null) {
                    this.f2865l.m3335b(msg);
                    if (m3675c(msg)) {
                        m3657a(this.f2864k);
                    }
                    if (!this.f2865l.m3347g(msg)) {
                        if (curStateInfo == null) {
                            this.f2857d.m3644a(msg, this.f2865l.m3348h(msg), curStateInfo.f2850a, this.f2859f[this.f2860g].f2850a);
                        }
                        this.f2857d.m3644a(msg, this.f2865l.m3348h(msg), null, null);
                        return;
                    }
                    return;
                } else if (this.f2855a) {
                    Log.d(StateMachine.f2655a, "processMsg: " + curStateInfo.f2850a.mo1381c());
                }
            }
            if (!this.f2865l.m3347g(msg)) {
                return;
            }
            if (curStateInfo == null) {
                this.f2857d.m3644a(msg, this.f2865l.m3348h(msg), null, null);
                return;
            }
            this.f2857d.m3644a(msg, this.f2865l.m3348h(msg), curStateInfo.f2850a, this.f2859f[this.f2860g].f2850a);
        }

        /* renamed from: a */
        private final void m3658a(C1087c commonStateInfo) {
            while (this.f2860g >= 0 && this.f2859f[this.f2860g] != commonStateInfo) {
                State curState = this.f2859f[this.f2860g].f2850a;
                if (this.f2855a) {
                    Log.d(StateMachine.f2655a, "invokeExitMethods: " + curState.mo1381c());
                }
                curState.mo1380b();
                this.f2859f[this.f2860g].f2852c = false;
                this.f2860g--;
            }
        }

        /* renamed from: a */
        private final void m3655a(int stateStackEnteringIndex) {
            for (int i = stateStackEnteringIndex; i <= this.f2860g; i++) {
                if (this.f2855a) {
                    Log.d(StateMachine.f2655a, "invokeEnterMethods: " + this.f2859f[i].f2850a.mo1381c());
                }
                this.f2859f[i].f2850a.mo1378a();
                this.f2859f[i].f2852c = true;
            }
        }

        /* renamed from: d */
        private final void m3677d() {
            for (int i = this.f2869p.size() - 1; i >= 0; i--) {
                Message curMsg = (Message) this.f2869p.get(i);
                if (this.f2855a) {
                    Log.d(StateMachine.f2655a, "moveDeferredMessageAtFrontOfQueue; what=" + curMsg.what);
                }
                sendMessageAtFrontOfQueue(curMsg);
            }
            this.f2869p.clear();
        }

        /* renamed from: e */
        private final int m3678e() {
            int startingIndex = this.f2860g + 1;
            int j = startingIndex;
            for (int i = this.f2862i - 1; i >= 0; i--) {
                if (this.f2855a) {
                    Log.d(StateMachine.f2655a, "moveTempStackToStateStack: i=" + i + ",j=" + j);
                }
                this.f2859f[j] = this.f2861h[i];
                j++;
            }
            this.f2860g = j - 1;
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "moveTempStackToStateStack: X mStateStackTop=" + this.f2860g + ",startingIndex=" + startingIndex + ",Top=" + this.f2859f[this.f2860g].f2850a.mo1381c());
            }
            return startingIndex;
        }

        /* renamed from: a */
        private final C1087c m3650a(State destState) {
            this.f2862i = 0;
            C1087c curStateInfo = (C1087c) this.f2866m.get(destState);
            do {
                C1087c[] c1087cArr = this.f2861h;
                int i = this.f2862i;
                this.f2862i = i + 1;
                c1087cArr[i] = curStateInfo;
                curStateInfo = curStateInfo.f2851b;
                if (curStateInfo == null) {
                    break;
                }
            } while (!curStateInfo.f2852c);
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.f2862i + ",curStateInfo: " + curStateInfo);
            }
            return curStateInfo;
        }

        /* renamed from: f */
        private final void m3681f() {
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "setupInitialStateStack: E mInitialState=" + this.f2867n.mo1381c());
            }
            C1087c curStateInfo = (C1087c) this.f2866m.get(this.f2867n);
            this.f2862i = 0;
            while (curStateInfo != null) {
                this.f2861h[this.f2862i] = curStateInfo;
                curStateInfo = curStateInfo.f2851b;
                this.f2862i++;
            }
            this.f2860g = -1;
            m3678e();
        }

        /* renamed from: g */
        private final Message m3683g() {
            return this.f2856c;
        }

        /* renamed from: h */
        private final IState m3684h() {
            return this.f2859f[this.f2860g].f2850a;
        }

        /* renamed from: a */
        private final C1087c m3651a(State state, State parent) {
            if (this.f2855a) {
                String str;
                String str2 = StateMachine.f2655a;
                StringBuilder append = new StringBuilder().append("addStateInternal: E state=").append(state.mo1381c()).append(",parent=");
                if (parent == null) {
                    str = "";
                } else {
                    str = parent.mo1381c();
                }
                Log.d(str2, append.append(str).toString());
            }
            C1087c parentStateInfo = null;
            if (parent != null) {
                parentStateInfo = (C1087c) this.f2866m.get(parent);
                if (parentStateInfo == null) {
                    parentStateInfo = m3651a(parent, null);
                }
            }
            C1087c stateInfo = (C1087c) this.f2866m.get(state);
            if (stateInfo == null) {
                stateInfo = new C1087c();
                this.f2866m.put(state, stateInfo);
            }
            if (stateInfo.f2851b == null || stateInfo.f2851b == parentStateInfo) {
                stateInfo.f2850a = state;
                stateInfo.f2851b = parentStateInfo;
                stateInfo.f2852c = false;
                if (this.f2855a) {
                    Log.d(StateMachine.f2655a, "addStateInternal: X stateInfo: " + stateInfo);
                }
                return stateInfo;
            }
            throw new RuntimeException("state already added");
        }

        private C1088c(Looper looper, StateMachine sm) {
            super(looper);
            this.f2855a = false;
            this.f2857d = new C1084b();
            this.f2860g = -1;
            this.f2863j = new C1085a();
            this.f2864k = new C1086b();
            this.f2866m = new HashMap();
            this.f2869p = new ArrayList();
            this.f2865l = sm;
            m3651a(this.f2863j, null);
            m3651a(this.f2864k, null);
        }

        /* renamed from: b */
        private final void m3670b(State initialState) {
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "setInitialState: initialState=" + initialState.mo1381c());
            }
            this.f2867n = initialState;
        }

        /* renamed from: a */
        private final void m3657a(IState destState) {
            this.f2868o = (State) destState;
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "transitionTo: destState=" + this.f2868o.mo1381c());
            }
        }

        /* renamed from: b */
        private final void m3669b(Message msg) {
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "deferMessage: msg=" + msg.what);
            }
            Message newMsg = obtainMessage();
            newMsg.copyFrom(msg);
            this.f2869p.add(newMsg);
        }

        /* renamed from: i */
        private final void m3686i() {
            if (this.f2855a) {
                Log.d(StateMachine.f2655a, "quit:");
            }
            sendMessage(obtainMessage(-1, f2854b));
        }

        /* renamed from: c */
        private final boolean m3675c(Message msg) {
            return msg.what == -1 && msg.obj == f2854b;
        }

        /* renamed from: j */
        private final boolean m3689j() {
            return this.f2855a;
        }

        /* renamed from: a */
        private final void m3664a(boolean dbg) {
            this.f2855a = dbg;
        }

        /* renamed from: b */
        private final void m3668b(int maxSize) {
            this.f2857d.m3643a(maxSize);
        }

        /* renamed from: k */
        private final int m3690k() {
            return this.f2857d.m3642a();
        }

        /* renamed from: l */
        private final int m3691l() {
            return this.f2857d.m3645b();
        }

        /* renamed from: c */
        private final C1083a m3673c(int index) {
            return this.f2857d.m3646b(index);
        }
    }

    /* renamed from: a */
    private void m3316a(String name, Looper looper) {
        this.f2658b = name;
        this.f2659c = new C1088c(looper, this);
    }

    protected StateMachine(String name) {
        this.f2660d = new HandlerThread(name);
        this.f2660d.start();
        m3316a(name, this.f2660d.getLooper());
    }

    protected StateMachine(String name, Looper looper) {
        m3316a(name, looper);
    }

    /* renamed from: a */
    protected final void m3330a(State state, State parent) {
        this.f2659c.m3651a(state, parent);
    }

    /* renamed from: r */
    protected final Message m3349r() {
        return this.f2659c.m3683g();
    }

    /* renamed from: s */
    protected final IState m3350s() {
        return this.f2659c.m3684h();
    }

    /* renamed from: a */
    protected final void m3329a(State state) {
        this.f2659c.m3651a(state, null);
    }

    /* renamed from: b */
    protected final void m3336b(State initialState) {
        this.f2659c.m3670b(initialState);
    }

    /* renamed from: a */
    protected final void m3328a(IState destState) {
        this.f2659c.m3657a(destState);
    }

    /* renamed from: t */
    protected final void m3351t() {
        this.f2659c.m3657a(this.f2659c.f2863j);
    }

    /* renamed from: a */
    protected final void m3326a(Message msg) {
        this.f2659c.m3669b(msg);
    }

    /* renamed from: b */
    protected void m3335b(Message msg) {
        if (this.f2659c.f2855a) {
            Log.e(f2655a, this.f2658b + " - unhandledMessage: msg.what=" + msg.what);
        }
    }

    /* renamed from: c */
    protected void m3339c(Message msg) {
    }

    /* renamed from: g */
    protected void mo1382g() {
    }

    /* renamed from: u */
    protected void m3352u() {
    }

    /* renamed from: v */
    public final String m3353v() {
        return this.f2658b;
    }

    /* renamed from: a */
    public final void m3323a(int maxSize) {
        this.f2659c.m3668b(maxSize);
    }

    /* renamed from: w */
    public final int m3354w() {
        return this.f2659c.m3690k();
    }

    /* renamed from: x */
    public final int m3355x() {
        return this.f2659c.m3691l();
    }

    /* renamed from: b */
    public final C1083a m3333b(int index) {
        return this.f2659c.m3673c(index);
    }

    /* renamed from: y */
    public final Handler m3356y() {
        return this.f2659c;
    }

    /* renamed from: z */
    public final Message m3357z() {
        if (this.f2659c == null) {
            return null;
        }
        return Message.obtain(this.f2659c);
    }

    /* renamed from: c */
    public final Message m3337c(int what) {
        if (this.f2659c == null) {
            return null;
        }
        return Message.obtain(this.f2659c, what);
    }

    /* renamed from: a */
    public final Message m3322a(int what, Object obj) {
        if (this.f2659c == null) {
            return null;
        }
        return Message.obtain(this.f2659c, what, obj);
    }

    /* renamed from: a */
    public final Message m3320a(int what, int arg1, int arg2) {
        if (this.f2659c == null) {
            return null;
        }
        return Message.obtain(this.f2659c, what, arg1, arg2);
    }

    /* renamed from: a */
    public final Message m3321a(int what, int arg1, int arg2, Object obj) {
        if (this.f2659c == null) {
            return null;
        }
        return Message.obtain(this.f2659c, what, arg1, arg2, obj);
    }

    /* renamed from: d */
    public final void m3340d(int what) {
        if (this.f2659c != null) {
            this.f2659c.sendMessage(m3337c(what));
        }
    }

    /* renamed from: b */
    public final void m3334b(int what, Object obj) {
        if (this.f2659c != null) {
            this.f2659c.sendMessage(m3322a(what, obj));
        }
    }

    /* renamed from: d */
    public final void m3341d(Message msg) {
        if (this.f2659c != null) {
            this.f2659c.sendMessage(msg);
        }
    }

    /* renamed from: a */
    public final void m3324a(int what, long delayMillis) {
        if (this.f2659c != null) {
            this.f2659c.sendMessageDelayed(m3337c(what), delayMillis);
        }
    }

    /* renamed from: a */
    public final void m3325a(int what, Object obj, long delayMillis) {
        if (this.f2659c != null) {
            this.f2659c.sendMessageDelayed(m3322a(what, obj), delayMillis);
        }
    }

    /* renamed from: a */
    public final void m3327a(Message msg, long delayMillis) {
        if (this.f2659c != null) {
            this.f2659c.sendMessageDelayed(msg, delayMillis);
        }
    }

    /* renamed from: c */
    protected final void m3338c(int what, Object obj) {
        this.f2659c.sendMessageAtFrontOfQueue(m3322a(what, obj));
    }

    /* renamed from: e */
    protected final void m3342e(int what) {
        this.f2659c.sendMessageAtFrontOfQueue(m3337c(what));
    }

    /* renamed from: e */
    protected final void m3343e(Message msg) {
        this.f2659c.sendMessageAtFrontOfQueue(msg);
    }

    /* renamed from: f */
    protected final void m3344f(int what) {
        this.f2659c.removeMessages(what);
    }

    /* renamed from: A */
    public final void m3317A() {
        if (this.f2659c != null) {
            this.f2659c.m3686i();
        }
    }

    /* renamed from: f */
    protected final boolean m3345f(Message msg) {
        return this.f2659c.m3675c(msg);
    }

    /* renamed from: g */
    protected boolean m3347g(Message msg) {
        return true;
    }

    /* renamed from: h */
    protected String m3348h(Message msg) {
        return "";
    }

    /* renamed from: B */
    public boolean m3318B() {
        if (this.f2659c == null) {
            return false;
        }
        return this.f2659c.m3689j();
    }

    /* renamed from: a */
    public void m3332a(boolean dbg) {
        if (this.f2659c != null) {
            this.f2659c.m3664a(dbg);
        }
    }

    /* renamed from: C */
    public void m3319C() {
        if (this.f2659c != null) {
            this.f2659c.m3674c();
        }
    }

    /* renamed from: a */
    public void m3331a(FileDescriptor fd, PrintWriter pw, String[] args) {
        pw.println(m3353v() + Config.TRACE_TODAY_VISIT_SPLIT);
        pw.println(" total messages=" + m3355x());
        for (int i = 0; i < m3354w(); i++) {
            pw.printf(" msg[%d]: %s\n", new Object[]{Integer.valueOf(i), m3333b(i)});
            pw.flush();
        }
        pw.println("curState=" + m3350s().mo1381c());
    }
}
