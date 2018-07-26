package com.baidu.carlife.core.screen.p053b;

import android.app.Instrumentation;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.core.screen.C1286o;
import com.baidu.carlife.core.screen.p056a.C1268a;
import com.baidu.carlife.protobuf.CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode;
import com.baidu.carlife.protobuf.CarlifeTouchActionProto.CarlifeTouchAction;
import com.baidu.carlife.protobuf.CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/* compiled from: CarlifeTouchManager */
/* renamed from: com.baidu.carlife.core.screen.b.f */
public class C1276f {
    /* renamed from: B */
    private static final long f3678B = 50;
    /* renamed from: a */
    public static final int f3679a = 300;
    /* renamed from: b */
    public static final int f3680b = 301;
    /* renamed from: c */
    public static final int f3681c = 302;
    /* renamed from: d */
    public static final int f3682d = 303;
    /* renamed from: e */
    public static final int f3683e = 304;
    /* renamed from: f */
    public static final int f3684f = 305;
    /* renamed from: g */
    private static final String f3685g = "CarlifeTouchManager";
    /* renamed from: h */
    private static final String f3686h = "TouchManagerHandlerThread";
    /* renamed from: i */
    private static final String f3687i = "127.0.0.1";
    /* renamed from: j */
    private static final int f3688j = 8270;
    /* renamed from: k */
    private static final int f3689k = 10000;
    /* renamed from: l */
    private static C1276f f3690l = null;
    /* renamed from: A */
    private long f3691A = 0;
    /* renamed from: C */
    private boolean f3692C = true;
    /* renamed from: D */
    private boolean f3693D = false;
    /* renamed from: E */
    private C0920c f3694E;
    /* renamed from: m */
    private C0936j f3695m;
    /* renamed from: n */
    private C1273e f3696n;
    /* renamed from: o */
    private Instrumentation f3697o = null;
    /* renamed from: p */
    private Socket f3698p = null;
    /* renamed from: q */
    private InetAddress f3699q = null;
    /* renamed from: r */
    private DataInputStream f3700r = null;
    /* renamed from: s */
    private DataOutputStream f3701s = null;
    /* renamed from: t */
    private int f3702t = 0;
    /* renamed from: u */
    private int f3703u = 0;
    /* renamed from: v */
    private int f3704v = 0;
    /* renamed from: w */
    private int f3705w = 0;
    /* renamed from: x */
    private int f3706x = 0;
    /* renamed from: y */
    private int f3707y;
    /* renamed from: z */
    private long f3708z = 0;

    /* compiled from: CarlifeTouchManager */
    /* renamed from: com.baidu.carlife.core.screen.b.f$1 */
    class C12741 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C1276f f3676a;

        C12741(C1276f this$0) {
            this.f3676a = this$0;
        }

        public void run() {
            try {
                this.f3676a.f3699q = InetAddress.getByName(C1276f.f3687i);
                this.f3676a.f3698p = new Socket(this.f3676a.f3699q, C1276f.f3688j);
                this.f3676a.f3700r = new DataInputStream(this.f3676a.f3698p.getInputStream());
                this.f3676a.f3701s = new DataOutputStream(this.f3676a.f3698p.getOutputStream());
            } catch (Exception e) {
                C1260i.m4445e(C1276f.f3685g, "initLocalSocket fail in thread");
                this.f3676a.f3698p = null;
                e.printStackTrace();
            }
        }
    }

    /* compiled from: CarlifeTouchManager */
    /* renamed from: com.baidu.carlife.core.screen.b.f$a */
    private class C1275a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1276f f3677a;

        public C1275a(C1276f c1276f, Looper looper) {
            this.f3677a = c1276f;
            super(looper);
        }

        public void handleMessage(Message msg) {
            C1268a.m4481b().m4501i();
            if (this.f3677a.m4533x()) {
                C1212c carlifeMsg;
                int tx;
                int ty;
                CarlifeTouchSinglePoint singlePoint;
                switch (msg.what) {
                    case C1253f.bE /*425985*/:
                        carlifeMsg = msg.obj;
                        if (carlifeMsg != null) {
                            try {
                                CarlifeTouchAction touchAction = CarlifeTouchAction.parseFrom(carlifeMsg.m4205f());
                                tx = (touchAction.getX() * this.f3677a.f3705w) / this.f3677a.f3703u;
                                ty = (touchAction.getY() * this.f3677a.f3706x) / this.f3677a.f3704v;
                                C1260i.m4435b(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION: " + ("x = " + tx + ", y = " + ty + ", action = " + touchAction.getAction()));
                                if (touchAction.getAction() == 2) {
                                    this.f3677a.f3691A = SystemClock.elapsedRealtime();
                                    C1260i.m4435b(C1276f.f3685g, "preTimeMove = " + this.f3677a.f3708z + ", curTimeMove = " + this.f3677a.f3691A);
                                    if (this.f3677a.f3691A - this.f3677a.f3708z < C1276f.f3678B) {
                                        C1260i.m4435b(C1276f.f3685g, "move event is too much, ignore");
                                        return;
                                    }
                                    this.f3677a.f3708z = this.f3677a.f3691A;
                                }
                                this.f3677a.m4536a(tx, ty, touchAction.getAction());
                                return;
                            } catch (InvalidProtocolBufferException e) {
                                C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION Error");
                                e.printStackTrace();
                                return;
                            }
                        }
                        C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION CarlifeCmdMessage is null");
                        return;
                    case C1253f.bF /*425986*/:
                        carlifeMsg = msg.obj;
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.m4205f());
                                tx = (singlePoint.getX() * this.f3677a.f3705w) / this.f3677a.f3703u;
                                ty = (singlePoint.getY() * this.f3677a.f3706x) / this.f3677a.f3704v;
                                C1260i.m4435b(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION_DOWN: " + ("x = " + tx + ", y = " + ty));
                                this.f3677a.m4535a(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e2) {
                                C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION_DOWN Error");
                                e2.printStackTrace();
                                return;
                            }
                        }
                        C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION_DOWN CarlifeCmdMessage is null");
                        return;
                    case C1253f.bG /*425987*/:
                        carlifeMsg = msg.obj;
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.m4205f());
                                tx = (singlePoint.getX() * this.f3677a.f3705w) / this.f3677a.f3703u;
                                ty = (singlePoint.getY() * this.f3677a.f3706x) / this.f3677a.f3704v;
                                C1260i.m4435b(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION_UP: " + ("x = " + tx + ", y = " + ty));
                                this.f3677a.m4543b(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e22) {
                                C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION_UP Error");
                                e22.printStackTrace();
                                return;
                            }
                        }
                        C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION_UP CarlifeCmdMessage is null");
                        return;
                    case C1253f.bH /*425988*/:
                        this.f3677a.f3691A = SystemClock.elapsedRealtime();
                        C1260i.m4435b(C1276f.f3685g, "preTimeMove = " + this.f3677a.f3708z + ", curTimeMove = " + this.f3677a.f3691A);
                        if (this.f3677a.f3691A - this.f3677a.f3708z < C1276f.f3678B) {
                            C1260i.m4435b(C1276f.f3685g, "move event is too much, ignore");
                            return;
                        }
                        this.f3677a.f3708z = this.f3677a.f3691A;
                        carlifeMsg = msg.obj;
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.m4205f());
                                tx = (singlePoint.getX() * this.f3677a.f3705w) / this.f3677a.f3703u;
                                ty = (singlePoint.getY() * this.f3677a.f3706x) / this.f3677a.f3704v;
                                C1260i.m4435b(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION_MOVE: " + ("x = " + tx + ", y = " + ty));
                                this.f3677a.m4547c(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e222) {
                                C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION_MOVE Error");
                                e222.printStackTrace();
                                return;
                            }
                        }
                        C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_ACTION_MOVE CarlifeCmdMessage is null");
                        return;
                    case C1253f.bI /*425989*/:
                        carlifeMsg = msg.obj;
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.m4205f());
                                tx = (singlePoint.getX() * this.f3677a.f3705w) / this.f3677a.f3703u;
                                ty = (singlePoint.getY() * this.f3677a.f3706x) / this.f3677a.f3704v;
                                C1260i.m4435b(C1276f.f3685g, "MSG_CMD_TOUCH_SINGLE_CLICK: " + ("x = " + tx + ", y = " + ty));
                                this.f3677a.m4550d(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e2222) {
                                C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_SINGLE_CLICK Error");
                                e2222.printStackTrace();
                                return;
                            }
                        }
                        C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_SINGLE_CLICK CarlifeCmdMessage is null");
                        return;
                    case C1253f.bJ /*425990*/:
                        carlifeMsg = msg.obj;
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.m4205f());
                                tx = (singlePoint.getX() * this.f3677a.f3705w) / this.f3677a.f3703u;
                                ty = (singlePoint.getY() * this.f3677a.f3706x) / this.f3677a.f3704v;
                                C1260i.m4435b(C1276f.f3685g, "MSG_CMD_TOUCH_DOUBLE_CLICK: " + ("x = " + tx + ", y = " + ty));
                                this.f3677a.m4556f(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e22222) {
                                C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_DOUBLE_CLICK Error");
                                e22222.printStackTrace();
                                return;
                            }
                        }
                        C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_DOUBLE_CLICK CarlifeCmdMessage is null");
                        return;
                    case C1253f.bK /*425991*/:
                        carlifeMsg = msg.obj;
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.m4205f());
                                tx = (singlePoint.getX() * this.f3677a.f3705w) / this.f3677a.f3703u;
                                ty = (singlePoint.getY() * this.f3677a.f3706x) / this.f3677a.f3704v;
                                C1260i.m4435b(C1276f.f3685g, "MSG_CMD_TOUCH_LONG_PRESS: " + ("x = " + tx + ", y = " + ty));
                                this.f3677a.m4558g(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e222222) {
                                C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_LONG_PRESS Error");
                                e222222.printStackTrace();
                                return;
                            }
                        }
                        C1260i.m4445e(C1276f.f3685g, "MSG_CMD_TOUCH_LONG_PRESS CarlifeCmdMessage is null");
                        return;
                    case C1253f.bL /*425992*/:
                        carlifeMsg = msg.obj;
                        if (carlifeMsg != null) {
                            try {
                                int code = CarlifeCarHardKeyCode.parseFrom(carlifeMsg.m4205f()).getKeycode();
                                C1260i.m4435b(C1276f.f3685g, "MSG_TOUCH_CAR_HARD_KEY_CODE: " + ("keycode = " + code));
                                this.f3677a.m4555f(code);
                                return;
                            } catch (InvalidProtocolBufferException e2222222) {
                                C1260i.m4445e(C1276f.f3685g, "MSG_TOUCH_CAR_HARD_KEY_CODE Error");
                                e2222222.printStackTrace();
                                return;
                            }
                        }
                        C1260i.m4445e(C1276f.f3685g, "MSG_TOUCH_CAR_HARD_KEY_CODE CarlifeCmdMessage is null");
                        return;
                    case C1253f.bN /*425994*/:
                        if (this.f3677a.f3692C) {
                            carlifeMsg = msg.obj;
                            if (carlifeMsg != null) {
                                try {
                                    singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.m4205f());
                                    tx = (singlePoint.getX() * this.f3677a.f3705w) / this.f3677a.f3703u;
                                    ty = (singlePoint.getY() * this.f3677a.f3706x) / this.f3677a.f3704v;
                                    C1260i.m4435b(C1276f.f3685g, "MSG_TOUCH_UI_ACTION_BEGIN: " + ("x = " + tx + ", y = " + ty));
                                    C1260i.m4440c(C1276f.f3685g, "ty = " + ty + ", phoneHeight = " + C1249d.m4331a().m4355l() + ", avaibleHeight = " + (C1249d.m4331a().m4355l() - this.f3677a.f3707y));
                                    if (ty > C1249d.m4331a().m4355l() - this.f3677a.f3707y) {
                                        this.f3677a.m4553e(tx, ty);
                                        return;
                                    }
                                    return;
                                } catch (InvalidProtocolBufferException e22222222) {
                                    C1260i.m4445e(C1276f.f3685g, "MSG_TOUCH_UI_ACTION_BEGIN Error");
                                    e22222222.printStackTrace();
                                    return;
                                }
                            }
                            C1260i.m4445e(C1276f.f3685g, "MSG_TOUCH_UI_ACTION_BEGIN CarlifeCmdMessage is null");
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public void careAbout() {
            addMsg(C1253f.bE);
            addMsg(C1253f.bF);
            addMsg(C1253f.bG);
            addMsg(C1253f.bH);
            addMsg(C1253f.bI);
            addMsg(C1253f.bJ);
            addMsg(C1253f.bK);
            addMsg(C1253f.bL);
        }
    }

    /* renamed from: a */
    public void m4538a(C0920c listener) {
        this.f3694E = listener;
    }

    /* renamed from: a */
    public static C1276f m4515a() {
        if (f3690l == null) {
            synchronized (C1276f.class) {
                if (f3690l == null) {
                    f3690l = new C1276f();
                }
            }
        }
        return f3690l;
    }

    private C1276f() {
    }

    /* renamed from: b */
    public void m4544b(C0920c listener) {
        m4537a(0, listener);
    }

    /* renamed from: a */
    public void m4537a(int bottomBarHeight, C0920c listener) {
        if (this.f3693D) {
            this.f3705w = C1249d.m4331a().m4351h();
            this.f3706x = C1249d.m4331a().m4352i();
            return;
        }
        this.f3693D = true;
        this.f3694E = listener;
        this.f3707y = bottomBarHeight;
        HandlerThread handlerThread = new HandlerThread(f3686h);
        handlerThread.start();
        this.f3695m = new C1275a(this, handlerThread.getLooper());
        C1261k.m4460a(this.f3695m);
        this.f3705w = C1249d.m4331a().m4351h();
        this.f3706x = C1249d.m4331a().m4352i();
        this.f3697o = new Instrumentation();
        this.f3696n = new C1273e();
    }

    /* renamed from: b */
    public void m4541b() {
        C1260i.m4435b(f3685g, "iniLocalSocket");
        try {
            new C12741(this).start();
        } catch (Exception e) {
            C1260i.m4445e(f3685g, "initLocalSocket fail");
            this.f3698p = null;
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m4545c() {
        C1260i.m4435b(f3685g, "uniniLocalSocket");
        try {
            this.f3700r.close();
        } catch (Exception e) {
            C1260i.m4445e(f3685g, "mReader close fail");
            e.printStackTrace();
        } finally {
            this.f3700r = null;
        }
        try {
            this.f3701s.close();
        } catch (Exception e2) {
            C1260i.m4445e(f3685g, "mWriter close fail");
            e2.printStackTrace();
        } finally {
            this.f3701s = null;
        }
        try {
            this.f3698p.close();
        } catch (Exception e22) {
            C1260i.m4445e(f3685g, "mSocket close fail");
            e22.printStackTrace();
        } finally {
            this.f3698p = null;
        }
    }

    /* renamed from: x */
    private boolean m4533x() {
        if (this.f3703u <= 0 || this.f3703u > 10000 || this.f3704v <= 0 || this.f3704v > 10000 || this.f3705w <= 0 || this.f3705w > 10000 || this.f3706x <= 0 || this.f3706x > 10000) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public int m4548d() {
        return this.f3703u;
    }

    /* renamed from: e */
    public int m4551e() {
        return this.f3704v;
    }

    /* renamed from: f */
    public int m4554f() {
        return this.f3705w;
    }

    /* renamed from: g */
    public int m4557g() {
        return this.f3706x;
    }

    /* renamed from: a */
    public void m4534a(int w) {
        this.f3703u = w;
    }

    /* renamed from: b */
    public void m4542b(int h) {
        this.f3704v = h;
    }

    /* renamed from: c */
    public void m4546c(int w) {
        this.f3705w = w;
    }

    /* renamed from: d */
    public void m4549d(int h) {
        this.f3706x = h;
    }

    /* renamed from: a */
    public void m4540a(boolean is) {
        this.f3692C = is;
    }

    /* renamed from: h */
    public boolean m4559h() {
        return this.f3692C;
    }

    /* renamed from: b */
    private void m4523b(int x, int y, int action) {
        try {
            C1260i.m4435b(f3685g, "Write to LocalSocket");
            this.f3701s.writeInt(x);
            this.f3701s.writeInt(y);
            this.f3701s.writeInt(action);
        } catch (Exception e) {
            C1260i.m4445e(f3685g, "Write to LocalSocket Failed");
            e.printStackTrace();
            try {
                if (this.f3702t % 20 == 0) {
                    C1260i.m4445e(f3685g, "cntShowToast: " + this.f3702t);
                    C1261k.m4461b((int) C1253f.fl);
                }
                this.f3702t++;
            } catch (Exception ex) {
                C1260i.m4445e(f3685g, "Write to LocalSocket Failed 1");
                ex.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m4536a(int x, int y, int action) {
        if (action == 0) {
            m4535a(x, y);
        } else if (action == 2) {
            m4547c(x, y);
        } else if (action == 1) {
            m4543b(x, y);
        }
    }

    /* renamed from: a */
    public void m4535a(int x, int y) {
        try {
            long time = SystemClock.uptimeMillis();
            MotionEvent event = MotionEvent.obtain(time, time, 0, (float) x, (float) y, 0);
            if (C1190a.m4065a()) {
                this.f3696n.m4512a(event);
            } else {
                this.f3697o.sendPointerSync(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "Please Enter into Carlife App!");
            m4523b(x, y, 0);
        }
    }

    /* renamed from: b */
    public void m4543b(int x, int y) {
        try {
            long time = SystemClock.uptimeMillis();
            MotionEvent event = MotionEvent.obtain(time, time, 1, (float) x, (float) y, 0);
            if (C1190a.m4065a()) {
                this.f3696n.m4512a(event);
            } else {
                this.f3697o.sendPointerSync(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "Please Enter into Carlife App!");
            m4523b(x, y, 1);
        }
    }

    /* renamed from: c */
    public void m4547c(int x, int y) {
        try {
            long time = SystemClock.uptimeMillis();
            MotionEvent event = MotionEvent.obtain(time, time, 2, (float) x, (float) y, 0);
            if (C1190a.m4065a()) {
                this.f3696n.m4512a(event);
            } else {
                this.f3697o.sendPointerSync(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "Please Enter into Carlife App!");
            m4523b(x, y, 2);
        }
    }

    /* renamed from: d */
    public void m4550d(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, 0, (float) x, (float) y, 0);
            long time2 = time1 + 10;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, 1, (float) x, (float) y, 0);
            if (C1190a.m4065a()) {
                event1.setSource(4098);
                event2.setSource(4098);
                this.f3696n.m4512a(event1);
                this.f3696n.m4512a(event2);
                return;
            }
            this.f3697o.sendPointerSync(event1);
            this.f3697o.sendPointerSync(event2);
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "Please Enter into Carlife App!");
            m4523b(x, y, 0);
            m4523b(x, y, 1);
        }
    }

    /* renamed from: e */
    public void m4553e(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, 0, (float) x, (float) y, 0);
            long time2 = time1 + 10;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, 1, (float) x, (float) y, 0);
            if (C1190a.m4065a()) {
                event1.setSource(4098);
                event2.setSource(4098);
                this.f3696n.m4512a(event1);
                this.f3696n.m4512a(event2);
                return;
            }
            this.f3697o.sendPointerSync(event1);
            this.f3697o.sendPointerSync(event2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public void m4556f(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, 0, (float) x, (float) y, 0);
            long time2 = time1 + 30;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, 1, (float) x, (float) y, 0);
            if (C1190a.m4065a()) {
                event1.setSource(4098);
                event2.setSource(4098);
                this.f3696n.m4512a(event1);
                this.f3696n.m4512a(event2);
                return;
            }
            this.f3697o.sendPointerSync(event1);
            this.f3697o.sendPointerSync(event2);
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "Please Enter into Carlife App!");
            m4523b(x, y, 0);
            m4523b(x, y, 1);
        }
    }

    /* renamed from: g */
    public void m4558g(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, 0, (float) x, (float) y, 0);
            long time2 = time1 + 100;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, 2, (float) x, (float) y, 0);
            long time3 = time1 + 300;
            MotionEvent event3 = MotionEvent.obtain(time3, time3, 2, (float) x, (float) y, 0);
            long time4 = time1 + 500;
            MotionEvent event4 = MotionEvent.obtain(time4, time4, 2, (float) x, (float) y, 0);
            long time5 = time1 + 700;
            MotionEvent event5 = MotionEvent.obtain(time5, time5, 2, (float) x, (float) y, 0);
            if (C1190a.m4065a()) {
                this.f3696n.m4509a((float) x, (float) y);
                return;
            }
            this.f3697o.sendPointerSync(event1);
            this.f3697o.sendPointerSync(event2);
            this.f3697o.sendPointerSync(event3);
            this.f3697o.sendPointerSync(event4);
            this.f3697o.sendPointerSync(event5);
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "Please Enter into Carlife App!");
            m4523b(x, y, 0);
            m4523b(x, y, 2);
            m4523b(x, y, 2);
            m4523b(x, y, 2);
            m4523b(x, y, 2);
        }
    }

    /* renamed from: i */
    public void m4560i() {
        try {
            C1260i.m4445e(f3685g, "onKeyBackEvent keycode=4");
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(4);
            } else {
                this.f3697o.sendKeyDownUpSync(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeyBackEvent get execption!");
        }
    }

    /* renamed from: j */
    public void m4561j() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(22);
            } else {
                this.f3697o.sendKeyDownUpSync(22);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorRightEvent get execption!");
        }
    }

    /* renamed from: k */
    public void m4562k() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(21);
            } else {
                this.f3697o.sendKeyDownUpSync(21);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorRightEvent get execption!");
        }
    }

    /* renamed from: l */
    public void m4563l() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(19);
            } else {
                this.f3697o.sendKeyDownUpSync(19);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorUpEvent get execption!");
        }
    }

    /* renamed from: m */
    public void m4564m() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(305);
            } else {
                this.f3697o.sendKeyDownUpSync(305);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorRightDownEvent get execption!");
        }
    }

    /* renamed from: n */
    public void m4565n() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(303);
            } else {
                this.f3697o.sendKeyDownUpSync(303);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorLeftDownEvent get execption!");
        }
    }

    /* renamed from: o */
    public void m4566o() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(304);
            } else {
                this.f3697o.sendKeyDownUpSync(304);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorRightUpEvent get execption!");
        }
    }

    /* renamed from: p */
    public void m4567p() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(302);
            } else {
                this.f3697o.sendKeyDownUpSync(302);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorLeftUpEvent get execption!");
        }
    }

    /* renamed from: q */
    public void m4568q() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(20);
            } else {
                this.f3697o.sendKeyDownUpSync(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorDownEvent get execption!");
        }
    }

    /* renamed from: r */
    public void m4569r() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(23);
            } else {
                this.f3697o.sendKeyDownUpSync(23);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeyOkEvent get execption!");
        }
    }

    /* renamed from: s */
    public void m4570s() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(300);
            } else {
                this.f3697o.sendKeyDownUpSync(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorRightEvent get execption!");
        }
    }

    /* renamed from: t */
    public void m4571t() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(301);
            } else {
                this.f3697o.sendKeyDownUpSync(301);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onKeySelectorRightEvent get execption!");
        }
    }

    /* renamed from: u */
    public void m4572u() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(28);
            } else {
                this.f3697o.sendKeyDownUpSync(28);
            }
        } catch (Exception e) {
            C1260i.m4445e(f3685g, "onKeyClear get execption:" + e.toString());
        }
    }

    /* renamed from: v */
    public void m4573v() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(67);
            } else {
                this.f3697o.sendKeyDownUpSync(67);
            }
        } catch (Exception e) {
            C1260i.m4445e(f3685g, "onKeyDelete get execption:" + e.toString());
        }
    }

    /* renamed from: e */
    public void m4552e(int num) {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(num + 7);
            } else {
                this.f3697o.sendKeyDownUpSync(num + 7);
            }
        } catch (Exception e) {
            C1260i.m4445e(f3685g, "onKeyDelete get execption:" + e.toString());
        }
    }

    /* renamed from: w */
    public void m4574w() {
        try {
            if (C1190a.m4065a()) {
                this.f3696n.m4510a(157);
            } else {
                this.f3697o.sendKeyDownUpSync(157);
            }
        } catch (Exception e) {
            C1260i.m4445e(f3685g, "onKeyDelete get execption:" + e.toString());
        }
    }

    /* renamed from: f */
    public void m4555f(int keycode) {
        C1260i.m4435b(f3685g, "keycode is " + keycode);
        try {
            if (this.f3694E == null || !this.f3694E.mo1339a(keycode)) {
                switch (keycode) {
                    case 2:
                        C1261k.m4456a((int) C1253f.fS, 0, 0, null);
                        return;
                    case 3:
                        C1261k.m4456a((int) C1253f.fT, 0, 0, null);
                        return;
                    case 6:
                        m4570s();
                        return;
                    case 7:
                        m4571t();
                        return;
                    case 14:
                        m4560i();
                        return;
                    case 20:
                        m4569r();
                        return;
                    case 21:
                        m4562k();
                        return;
                    case 22:
                        m4561j();
                        return;
                    case 23:
                        m4563l();
                        return;
                    case 24:
                        m4568q();
                        return;
                    case 25:
                        m4567p();
                        return;
                    case 26:
                        m4566o();
                        return;
                    case 27:
                        m4565n();
                        return;
                    case 28:
                        m4564m();
                        return;
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                        m4552e(keycode - 35);
                        return;
                    case 47:
                        m4573v();
                        return;
                    case 48:
                        m4572u();
                        return;
                    case 49:
                        m4574w();
                        return;
                    default:
                        return;
                }
                e.printStackTrace();
                C1260i.m4445e(f3685g, "onHardKeyCodeEvent get exception!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1260i.m4445e(f3685g, "onHardKeyCodeEvent get exception!");
        }
    }

    /* renamed from: a */
    public void m4539a(C1286o touchListener) {
        this.f3696n.m4513a(touchListener);
    }
}
