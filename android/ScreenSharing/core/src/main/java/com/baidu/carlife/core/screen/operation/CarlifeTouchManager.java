package com.baidu.carlife.core.screen.operation;

import android.app.Instrumentation;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;

import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.core.screen.OnTouchListener;
import com.baidu.carlife.core.screen.lightness.LightnessControlManager;
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
public class CarlifeTouchManager {
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
    private static final String Tag = "CarlifeTouchManager";
    /* renamed from: h */
    private static final String TouchManagerHandlerThreadTag = "TouchManagerHandlerThread";
    /* renamed from: i */
    private static final String LOCAL_HOST = "127.0.0.1";
    /* renamed from: j */
    private static final int f3688j = 8270;
    /* renamed from: k */
    private static final int f3689k = 10000;
    /* renamed from: l */
    private static CarlifeTouchManager sCarlifeTouchManager = null;
    /* renamed from: A */
    private long mElapsedRealtime = 0;
    /* renamed from: C */
    private boolean f3692C = true;
    /* renamed from: D */
    private boolean f3693D = false;
    /* renamed from: E */
    private OnHardKeyCodeEventListener mOnHardKeyCodeEventListener;
    /* renamed from: m */
    private MsgBaseHandler mMsgBaseHandler;
    /* renamed from: n */
    private CarlifeInstrumentation mCarlifeInstrumentation;
    /* renamed from: o */
    private Instrumentation mInstrumentation = null;
    /* renamed from: p */
    private Socket mSocket = null;
    /* renamed from: q */
    private InetAddress mInetAddress = null;
    /* renamed from: r */
    private DataInputStream mDataInputStream = null;
    /* renamed from: s */
    private DataOutputStream mDataOutputStream = null;
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
    class CarlifeTouchManagerThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ CarlifeTouchManager mCarlifeTouchManager;

        CarlifeTouchManagerThread(CarlifeTouchManager this$0) {
            this.mCarlifeTouchManager = this$0;
        }

        public void run() {
            try {
                this.mCarlifeTouchManager.mInetAddress = InetAddress.getByName(CarlifeTouchManager.LOCAL_HOST);
                this.mCarlifeTouchManager.mSocket = new Socket(this.mCarlifeTouchManager.mInetAddress, CarlifeTouchManager.f3688j);
                this.mCarlifeTouchManager.mDataInputStream = new DataInputStream(this.mCarlifeTouchManager.mSocket.getInputStream());
                this.mCarlifeTouchManager.mDataOutputStream = new DataOutputStream(this.mCarlifeTouchManager.mSocket.getOutputStream());
            } catch (Exception e) {
                LogUtil.e(CarlifeTouchManager.Tag, "initLocalSocket fail in thread");
                this.mCarlifeTouchManager.mSocket = null;
                e.printStackTrace();
            }
        }
    }

    /* compiled from: CarlifeTouchManager */
    /* renamed from: com.baidu.carlife.core.screen.b.f$a */
    private class CarlifeTouchManagerHandler extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ CarlifeTouchManager mCarlifeTouchManager;

        public CarlifeTouchManagerHandler(CarlifeTouchManager carlifeTouchManager, Looper looper) {
            super(looper);
            this.mCarlifeTouchManager = carlifeTouchManager;
        }

        public void handleMessage(Message msg) {
            LightnessControlManager.newInstance().vehicleTouchmanage();
            if (this.mCarlifeTouchManager.m4533x()) {
                CarlifeCmdMessage carlifeMsg = (CarlifeCmdMessage) msg.obj;
                int tx;
                int ty;
                CarlifeTouchSinglePoint singlePoint;
                switch (msg.what) {
                    case 425985:
                        if (carlifeMsg != null) {
                            try {
                                CarlifeTouchAction touchAction = CarlifeTouchAction.parseFrom(carlifeMsg.getData());
                                tx = (touchAction.getX() * this.mCarlifeTouchManager.f3705w) / this.mCarlifeTouchManager.f3703u;
                                ty = (touchAction.getY() * this.mCarlifeTouchManager.f3706x) / this.mCarlifeTouchManager.f3704v;
                                LogUtil.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION: " + ("x = " + tx + ", y = " + ty + ", action = " + touchAction.getAction()));
                                if (touchAction.getAction() == 2) {
                                    this.mCarlifeTouchManager.mElapsedRealtime = SystemClock.elapsedRealtime();
                                    LogUtil.d(CarlifeTouchManager.Tag, "preTimeMove = " + this.mCarlifeTouchManager.f3708z + ", curTimeMove = " + this.mCarlifeTouchManager.mElapsedRealtime);
                                    if (this.mCarlifeTouchManager.mElapsedRealtime - this.mCarlifeTouchManager.f3708z < CarlifeTouchManager.f3678B) {
                                        LogUtil.d(CarlifeTouchManager.Tag, "move event is too much, ignore");
                                        return;
                                    }
                                    this.mCarlifeTouchManager.f3708z = this.mCarlifeTouchManager.mElapsedRealtime;
                                }
                                this.mCarlifeTouchManager.m4536a(tx, ty, touchAction.getAction());
                                return;
                            } catch (InvalidProtocolBufferException e) {
                                LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION Error");
                                e.printStackTrace();
                                return;
                            }
                        }
                        LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION CarlifeCmdMessage is null");
                        return;
                    case 425986:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.f3705w) / this.mCarlifeTouchManager.f3703u;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.f3706x) / this.mCarlifeTouchManager.f3704v;
                                LogUtil.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_DOWN: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.m4535a(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e2) {
                                LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_DOWN Error");
                                e2.printStackTrace();
                                return;
                            }
                        }
                        LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_DOWN CarlifeCmdMessage is null");
                        return;
                    case 425987:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.f3705w) / this.mCarlifeTouchManager.f3703u;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.f3706x) / this.mCarlifeTouchManager.f3704v;
                                LogUtil.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_UP: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.m4543b(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e22) {
                                LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_UP Error");
                                e22.printStackTrace();
                                return;
                            }
                        }
                        LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_UP CarlifeCmdMessage is null");
                        return;
                    case 425988:
                        this.mCarlifeTouchManager.mElapsedRealtime = SystemClock.elapsedRealtime();
                        LogUtil.d(CarlifeTouchManager.Tag, "preTimeMove = " + this.mCarlifeTouchManager.f3708z + ", curTimeMove = " + this.mCarlifeTouchManager.mElapsedRealtime);
                        if (this.mCarlifeTouchManager.mElapsedRealtime - this.mCarlifeTouchManager.f3708z < CarlifeTouchManager.f3678B) {
                            LogUtil.d(CarlifeTouchManager.Tag, "move event is too much, ignore");
                            return;
                        }
                        this.mCarlifeTouchManager.f3708z = this.mCarlifeTouchManager.mElapsedRealtime;
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.f3705w) / this.mCarlifeTouchManager.f3703u;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.f3706x) / this.mCarlifeTouchManager.f3704v;
                                LogUtil.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_MOVE: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.m4547c(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e222) {
                                LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_MOVE Error");
                                e222.printStackTrace();
                                return;
                            }
                        }
                        LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_MOVE CarlifeCmdMessage is null");
                        return;
                    case 425989:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.f3705w) / this.mCarlifeTouchManager.f3703u;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.f3706x) / this.mCarlifeTouchManager.f3704v;
                                LogUtil.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_SINGLE_CLICK: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.m4550d(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e2222) {
                                LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_SINGLE_CLICK Error");
                                e2222.printStackTrace();
                                return;
                            }
                        }
                        LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_SINGLE_CLICK CarlifeCmdMessage is null");
                        return;
                    case 425990:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.f3705w) / this.mCarlifeTouchManager.f3703u;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.f3706x) / this.mCarlifeTouchManager.f3704v;
                                LogUtil.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_DOUBLE_CLICK: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.m4556f(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e22222) {
                                LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_DOUBLE_CLICK Error");
                                e22222.printStackTrace();
                                return;
                            }
                        }
                        LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_DOUBLE_CLICK CarlifeCmdMessage is null");
                        return;
                    case 425991:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.f3705w) / this.mCarlifeTouchManager.f3703u;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.f3706x) / this.mCarlifeTouchManager.f3704v;
                                LogUtil.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_LONG_PRESS: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.m4558g(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e222222) {
                                LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_LONG_PRESS Error");
                                e222222.printStackTrace();
                                return;
                            }
                        }
                        LogUtil.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_LONG_PRESS CarlifeCmdMessage is null");
                        return;
                    case 425992:
                        if (carlifeMsg != null) {
                            try {
                                int code = CarlifeCarHardKeyCode.parseFrom(carlifeMsg.getData()).getKeycode();
                                LogUtil.d(CarlifeTouchManager.Tag, "MSG_TOUCH_CAR_HARD_KEY_CODE: " + ("keycode = " + code));
                                this.mCarlifeTouchManager.onHardKeyCodeEvent(code);
                                return;
                            } catch (InvalidProtocolBufferException e2222222) {
                                LogUtil.e(CarlifeTouchManager.Tag, "MSG_TOUCH_CAR_HARD_KEY_CODE Error");
                                e2222222.printStackTrace();
                                return;
                            }
                        }
                        LogUtil.e(CarlifeTouchManager.Tag, "MSG_TOUCH_CAR_HARD_KEY_CODE CarlifeCmdMessage is null");
                        return;
                    case 425994:
                        if (this.mCarlifeTouchManager.f3692C) {
                            if (carlifeMsg != null) {
                                try {
                                    singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                    tx = (singlePoint.getX() * this.mCarlifeTouchManager.f3705w) / this.mCarlifeTouchManager.f3703u;
                                    ty = (singlePoint.getY() * this.mCarlifeTouchManager.f3706x) / this.mCarlifeTouchManager.f3704v;
                                    LogUtil.d(CarlifeTouchManager.Tag, "MSG_TOUCH_UI_ACTION_BEGIN: " + ("x = " + tx + ", y = " + ty));
                                    LogUtil.m4440c(CarlifeTouchManager.Tag, "ty = " + ty + ", phoneHeight = " + CarlifeScreenUtil.m4331a().m4355l() + ", avaibleHeight = " + (CarlifeScreenUtil.m4331a().m4355l() - this.mCarlifeTouchManager.f3707y));
                                    if (ty > CarlifeScreenUtil.m4331a().m4355l() - this.mCarlifeTouchManager.f3707y) {
                                        this.mCarlifeTouchManager.m4553e(tx, ty);
                                        return;
                                    }
                                    return;
                                } catch (InvalidProtocolBufferException e22222222) {
                                    LogUtil.e(CarlifeTouchManager.Tag, "MSG_TOUCH_UI_ACTION_BEGIN Error");
                                    e22222222.printStackTrace();
                                    return;
                                }
                            }
                            LogUtil.e(CarlifeTouchManager.Tag, "MSG_TOUCH_UI_ACTION_BEGIN CarlifeCmdMessage is null");
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public void careAbout() {
            addMsg(425985);
            addMsg(425986);
            addMsg(425987);
            addMsg(425988);
            addMsg(425989);
            addMsg(425990);
            addMsg(425991);
            addMsg(425992);
        }
    }

    /* renamed from: a */
    public void initOnHardKeyCodeEventListener(OnHardKeyCodeEventListener listener) {
        this.mOnHardKeyCodeEventListener = listener;
    }

    /* renamed from: a */
    public static CarlifeTouchManager newInstance() {
        if (sCarlifeTouchManager == null) {
            synchronized (CarlifeTouchManager.class) {
                if (sCarlifeTouchManager == null) {
                    sCarlifeTouchManager = new CarlifeTouchManager();
                }
            }
        }
        return sCarlifeTouchManager;
    }

    private CarlifeTouchManager() {
    }

    /* renamed from: b */
    public void m4544b(OnHardKeyCodeEventListener listener) {
        m4537a(0, listener);
    }

    /* renamed from: a */
    public void m4537a(int bottomBarHeight, OnHardKeyCodeEventListener listener) {
        if (this.f3693D) {
            this.f3705w = CarlifeScreenUtil.m4331a().m4351h();
            this.f3706x = CarlifeScreenUtil.m4331a().m4352i();
            return;
        }
        this.f3693D = true;
        this.mOnHardKeyCodeEventListener = listener;
        this.f3707y = bottomBarHeight;
        HandlerThread handlerThread = new HandlerThread(TouchManagerHandlerThreadTag);
        handlerThread.start();
        this.mMsgBaseHandler = new CarlifeTouchManagerHandler(this, handlerThread.getLooper());
        MsgHandlerCenter.registerMessageHandler(this.mMsgBaseHandler);
        this.f3705w = CarlifeScreenUtil.m4331a().m4351h();
        this.f3706x = CarlifeScreenUtil.m4331a().m4352i();
        this.mInstrumentation = new Instrumentation();
        this.mCarlifeInstrumentation = new CarlifeInstrumentation();
    }

    /* renamed from: b */
    public void iniLocalSocket() {
        LogUtil.d(Tag, "iniLocalSocket");
        try {
            new CarlifeTouchManagerThread(this).start();
        } catch (Exception e) {
            LogUtil.e(Tag, "initLocalSocket fail");
            this.mSocket = null;
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void uniniLocalSocket() {
        LogUtil.d(Tag, "uniniLocalSocket");
        try {
            this.mDataInputStream.close();
        } catch (Exception e) {
            LogUtil.e(Tag, "mReader close fail");
            e.printStackTrace();
        } finally {
            this.mDataInputStream = null;
        }
        try {
            this.mDataOutputStream.close();
        } catch (Exception e2) {
            LogUtil.e(Tag, "mWriter close fail");
            e2.printStackTrace();
        } finally {
            this.mDataOutputStream = null;
        }
        try {
            this.mSocket.close();
        } catch (Exception e22) {
            LogUtil.e(Tag, "mSocket close fail");
            e22.printStackTrace();
        } finally {
            this.mSocket = null;
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
    private void writeToLocalSocket(int x, int y, int action) {
        try {
            LogUtil.d(Tag, "Write to LocalSocket");
            this.mDataOutputStream.writeInt(x);
            this.mDataOutputStream.writeInt(y);
            this.mDataOutputStream.writeInt(action);
        } catch (Exception e) {
            LogUtil.e(Tag, "Write to LocalSocket Failed");
            e.printStackTrace();
            try {
                if (this.f3702t % 20 == 0) {
                    LogUtil.e(Tag, "cntShowToast: " + this.f3702t);
                    MsgHandlerCenter.dispatchMessage((int) CommonParams.fl);
                }
                this.f3702t++;
            } catch (Exception ex) {
                LogUtil.e(Tag, "Write to LocalSocket Failed 1");
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
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4512a(event);
            } else {
                this.mInstrumentation.sendPointerSync(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, 0);
        }
    }

    /* renamed from: b */
    public void m4543b(int x, int y) {
        try {
            long time = SystemClock.uptimeMillis();
            MotionEvent event = MotionEvent.obtain(time, time, 1, (float) x, (float) y, 0);
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4512a(event);
            } else {
                this.mInstrumentation.sendPointerSync(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, 1);
        }
    }

    /* renamed from: c */
    public void m4547c(int x, int y) {
        try {
            long time = SystemClock.uptimeMillis();
            MotionEvent event = MotionEvent.obtain(time, time, 2, (float) x, (float) y, 0);
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4512a(event);
            } else {
                this.mInstrumentation.sendPointerSync(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, 2);
        }
    }

    /* renamed from: d */
    public void m4550d(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, 0, (float) x, (float) y, 0);
            long time2 = time1 + 10;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, 1, (float) x, (float) y, 0);
            if (CarlifeConfig.m4065a()) {
                event1.setSource(4098);
                event2.setSource(4098);
                this.mCarlifeInstrumentation.m4512a(event1);
                this.mCarlifeInstrumentation.m4512a(event2);
                return;
            }
            this.mInstrumentation.sendPointerSync(event1);
            this.mInstrumentation.sendPointerSync(event2);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, 0);
            writeToLocalSocket(x, y, 1);
        }
    }

    /* renamed from: e */
    public void m4553e(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, 0, (float) x, (float) y, 0);
            long time2 = time1 + 10;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, 1, (float) x, (float) y, 0);
            if (CarlifeConfig.m4065a()) {
                event1.setSource(4098);
                event2.setSource(4098);
                this.mCarlifeInstrumentation.m4512a(event1);
                this.mCarlifeInstrumentation.m4512a(event2);
                return;
            }
            this.mInstrumentation.sendPointerSync(event1);
            this.mInstrumentation.sendPointerSync(event2);
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
            if (CarlifeConfig.m4065a()) {
                event1.setSource(4098);
                event2.setSource(4098);
                this.mCarlifeInstrumentation.m4512a(event1);
                this.mCarlifeInstrumentation.m4512a(event2);
                return;
            }
            this.mInstrumentation.sendPointerSync(event1);
            this.mInstrumentation.sendPointerSync(event2);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, 0);
            writeToLocalSocket(x, y, 1);
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
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4509a((float) x, (float) y);
                return;
            }
            this.mInstrumentation.sendPointerSync(event1);
            this.mInstrumentation.sendPointerSync(event2);
            this.mInstrumentation.sendPointerSync(event3);
            this.mInstrumentation.sendPointerSync(event4);
            this.mInstrumentation.sendPointerSync(event5);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, 0);
            writeToLocalSocket(x, y, 2);
            writeToLocalSocket(x, y, 2);
            writeToLocalSocket(x, y, 2);
            writeToLocalSocket(x, y, 2);
        }
    }

    /* renamed from: i */
    public void onKeyBackEvent() {
        try {
            LogUtil.e(Tag, "onKeyBackEvent keycode=4");
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(4);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeyBackEvent get execption!");
        }
    }

    /* renamed from: j */
    public void onKeySelectorRightEvent22() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(22);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(22);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorRightEvent get execption!");
        }
    }

    /* renamed from: k */
    public void onKeySelectorRightEvent21() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(21);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(21);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorRightEvent get execption!");
        }
    }

    /* renamed from: l */
    public void onKeySelectorUpEvent() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(19);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(19);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorUpEvent get execption!");
        }
    }

    /* renamed from: m */
    public void onKeySelectorRightDownEvent() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(305);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(305);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorRightDownEvent get execption!");
        }
    }

    /* renamed from: n */
    public void sendKeyDownUpSync() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(303);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(303);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorLeftDownEvent get execption!");
        }
    }

    /* renamed from: o */
    public void onKeySelectorRightUpEvent() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(304);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(304);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorRightUpEvent get execption!");
        }
    }

    /* renamed from: p */
    public void onKeySelectorLeftUpEvent() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(302);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(302);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorLeftUpEvent get execption!");
        }
    }

    /* renamed from: q */
    public void onKeySelectorDownEvent() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(20);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorDownEvent get execption!");
        }
    }

    /* renamed from: r */
    public void onKeyOkEvent() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(23);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(23);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeyOkEvent get execption!");
        }
    }

    /* renamed from: s */
    public void onKeySelectorRightEvent300() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(300);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorRightEvent get execption!");
        }
    }

    /* renamed from: t */
    public void onKeySelectorRightEvent301() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(301);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(301);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onKeySelectorRightEvent get execption!");
        }
    }

    /* renamed from: u */
    public void onKeyClear() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(28);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(28);
            }
        } catch (Exception e) {
            LogUtil.e(Tag, "onKeyClear get execption:" + e.toString());
        }
    }

    /* renamed from: v */
    public void onKeyDelete67() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(67);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(67);
            }
        } catch (Exception e) {
            LogUtil.e(Tag, "onKeyDelete get execption:" + e.toString());
        }
    }

    /* renamed from: e */
    public void onKeyDeleteByCode(int num) {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(num + 7);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(num + 7);
            }
        } catch (Exception e) {
            LogUtil.e(Tag, "onKeyDelete get execption:" + e.toString());
        }
    }

    /* renamed from: w */
    public void onKeyDelete157() {
        try {
            if (CarlifeConfig.m4065a()) {
                this.mCarlifeInstrumentation.m4510a(157);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(157);
            }
        } catch (Exception e) {
            LogUtil.e(Tag, "onKeyDelete get execption:" + e.toString());
        }
    }

    /* renamed from: f */
    public void onHardKeyCodeEvent(int keycode) {
        LogUtil.d(Tag, "keycode is " + keycode);
        try {
            if (this.mOnHardKeyCodeEventListener == null || !this.mOnHardKeyCodeEventListener.mo1339a(keycode)) {
                switch (keycode) {
                    case 2:
                        MsgHandlerCenter.dispatchMessageDelay((int) CommonParams.fS, 0, 0, null);
                        return;
                    case 3:
                        MsgHandlerCenter.dispatchMessageDelay((int) CommonParams.fT, 0, 0, null);
                        return;
                    case 6:
                        onKeySelectorRightEvent300();
                        return;
                    case 7:
                        onKeySelectorRightEvent301();
                        return;
                    case 14:
                        onKeyBackEvent();
                        return;
                    case 20:
                        onKeyOkEvent();
                        return;
                    case 21:
                        onKeySelectorRightEvent21();
                        return;
                    case 22:
                        onKeySelectorRightEvent22();
                        return;
                    case 23:
                        onKeySelectorUpEvent();
                        return;
                    case 24:
                        onKeySelectorDownEvent();
                        return;
                    case 25:
                        onKeySelectorLeftUpEvent();
                        return;
                    case 26:
                        onKeySelectorRightUpEvent();
                        return;
                    case 27:
                        sendKeyDownUpSync();
                        return;
                    case 28:
                        onKeySelectorRightDownEvent();
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
                        onKeyDeleteByCode(keycode - 35);
                        return;
                    case 47:
                        onKeyDelete67();
                        return;
                    case 48:
                        onKeyClear();
                        return;
                    case 49:
                        onKeyDelete157();
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(Tag, "onHardKeyCodeEvent get exception!");
        }
    }

    /* renamed from: a */
    public void initOnTouchListener(OnTouchListener touchListener) {
        this.mCarlifeInstrumentation.initOnTouchListener(touchListener);
    }
}
