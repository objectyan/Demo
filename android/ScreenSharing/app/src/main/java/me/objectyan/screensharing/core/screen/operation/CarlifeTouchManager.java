package me.objectyan.screensharing.core.screen.operation;

import android.app.Instrumentation;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import me.objectyan.screensharing.core.CarlifeScreenUtil;
import me.objectyan.screensharing.core.CommonParams;
import me.objectyan.screensharing.core.MsgBaseHandler;
import me.objectyan.screensharing.core.MsgHandlerCenter;
import me.objectyan.screensharing.core.config.CarlifeConfig;
import me.objectyan.screensharing.core.connect.CarlifeCmdMessage;
import me.objectyan.screensharing.core.screen.OnTouchListener;
import me.objectyan.screensharing.core.screen.lightness.LightnessControlManager;
import me.objectyan.screensharing.protobuf.CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode;
import me.objectyan.screensharing.protobuf.CarlifeTouchActionProto.CarlifeTouchAction;
import me.objectyan.screensharing.protobuf.CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint;

import com.google.protobuf.InvalidProtocolBufferException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class CarlifeTouchManager {

    private static final long f3678B = 50;

    public static final int f3679a = 300;

    public static final int f3680b = 301;

    public static final int f3681c = 302;

    public static final int f3682d = 303;

    public static final int f3683e = 304;

    public static final int f3684f = 305;

    private static final String Tag = "CarlifeTouchManager";

    private static final String TouchManagerHandlerThreadTag = "TouchManagerHandlerThread";

    private static final String LOCAL_HOST = "127.0.0.1";

    private static final int f3688j = 8270;

    private static final int f3689k = 10000;

    private static CarlifeTouchManager sCarlifeTouchManager = null;

    private long mElapsedRealtime = 0;

    private boolean mIS = true;

    private boolean isInitHardListener = false;

    private OnHardKeyCodeEventListener mOnHardKeyCodeEventListener;

    private MsgBaseHandler mMsgBaseHandler;

    private CarlifeInstrumentation mCarlifeInstrumentation;

    private Instrumentation mInstrumentation = null;

    private Socket mSocket = null;

    private InetAddress mInetAddress = null;

    private DataInputStream mDataInputStream = null;

    private DataOutputStream mDataOutputStream = null;

    private int mCntShowToast = 0;

    private int mWidth = 0;

    private int mHeight = 0;

    private int mWidthPixels = 0;

    private int mHeightPixels = 0;

    private int mBottomBarHeight;

    private long f3708z = 0;

    class CarlifeTouchManagerThread extends Thread {

        final CarlifeTouchManager mCarlifeTouchManager;

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
                Log.e(CarlifeTouchManager.Tag, "initLocalSocket fail in thread");
                this.mCarlifeTouchManager.mSocket = null;
                e.printStackTrace();
            }
        }
    }

    private class CarlifeTouchManagerHandler extends MsgBaseHandler {

        final CarlifeTouchManager mCarlifeTouchManager;

        public CarlifeTouchManagerHandler(CarlifeTouchManager carlifeTouchManager, Looper looper) {
            super(looper);
            this.mCarlifeTouchManager = carlifeTouchManager;
        }

        public void handleMessage(Message msg) {
            LightnessControlManager.newInstance().vehicleTouchmanage();
            if (this.mCarlifeTouchManager.isValid()) {
                CarlifeCmdMessage carlifeMsg = (CarlifeCmdMessage) msg.obj;
                int tx;
                int ty;
                CarlifeTouchSinglePoint singlePoint;
                switch (msg.what) {
                    case 425985:
                        if (carlifeMsg != null) {
                            try {
                                CarlifeTouchAction touchAction = CarlifeTouchAction.parseFrom(carlifeMsg.getData());
                                tx = (touchAction.getX() * this.mCarlifeTouchManager.mWidthPixels) / this.mCarlifeTouchManager.mWidth;
                                ty = (touchAction.getY() * this.mCarlifeTouchManager.mHeightPixels) / this.mCarlifeTouchManager.mHeight;
                                Log.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION: " + ("x = " + tx + ", y = " + ty + ", action = " + touchAction.getAction()));
                                if (touchAction.getAction() == 2) {
                                    this.mCarlifeTouchManager.mElapsedRealtime = SystemClock.elapsedRealtime();
                                    Log.d(CarlifeTouchManager.Tag, "preTimeMove = " + this.mCarlifeTouchManager.f3708z + ", curTimeMove = " + this.mCarlifeTouchManager.mElapsedRealtime);
                                    if (this.mCarlifeTouchManager.mElapsedRealtime - this.mCarlifeTouchManager.f3708z < CarlifeTouchManager.f3678B) {
                                        Log.d(CarlifeTouchManager.Tag, "move event is too much, ignore");
                                        return;
                                    }
                                    this.mCarlifeTouchManager.f3708z = this.mCarlifeTouchManager.mElapsedRealtime;
                                }
                                this.mCarlifeTouchManager.touchAction(tx, ty, touchAction.getAction());
                                return;
                            } catch (InvalidProtocolBufferException e) {
                                Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION Error");
                                e.printStackTrace();
                                return;
                            }
                        }
                        Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION CarlifeCmdMessage is null");
                        return;
                    case 425986:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.mWidthPixels) / this.mCarlifeTouchManager.mWidth;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.mHeightPixels) / this.mCarlifeTouchManager.mHeight;
                                Log.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_DOWN: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.touchActionDown(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e2) {
                                Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_DOWN Error");
                                e2.printStackTrace();
                                return;
                            }
                        }
                        Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_DOWN CarlifeCmdMessage is null");
                        return;
                    case 425987:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.mWidthPixels) / this.mCarlifeTouchManager.mWidth;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.mHeightPixels) / this.mCarlifeTouchManager.mHeight;
                                Log.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_UP: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.touchActionUp(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e22) {
                                Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_UP Error");
                                e22.printStackTrace();
                                return;
                            }
                        }
                        Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_UP CarlifeCmdMessage is null");
                        return;
                    case 425988:
                        this.mCarlifeTouchManager.mElapsedRealtime = SystemClock.elapsedRealtime();
                        Log.d(CarlifeTouchManager.Tag, "preTimeMove = " + this.mCarlifeTouchManager.f3708z + ", curTimeMove = " + this.mCarlifeTouchManager.mElapsedRealtime);
                        if (this.mCarlifeTouchManager.mElapsedRealtime - this.mCarlifeTouchManager.f3708z < CarlifeTouchManager.f3678B) {
                            Log.d(CarlifeTouchManager.Tag, "move event is too much, ignore");
                            return;
                        }
                        this.mCarlifeTouchManager.f3708z = this.mCarlifeTouchManager.mElapsedRealtime;
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.mWidthPixels) / this.mCarlifeTouchManager.mWidth;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.mHeightPixels) / this.mCarlifeTouchManager.mHeight;
                                Log.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_MOVE: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.touchActionMove(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e222) {
                                Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_MOVE Error");
                                e222.printStackTrace();
                                return;
                            }
                        }
                        Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_ACTION_MOVE CarlifeCmdMessage is null");
                        return;
                    case 425989:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.mWidthPixels) / this.mCarlifeTouchManager.mWidth;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.mHeightPixels) / this.mCarlifeTouchManager.mHeight;
                                Log.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_SINGLE_CLICK: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.touchSingleClick(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e2222) {
                                Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_SINGLE_CLICK Error");
                                e2222.printStackTrace();
                                return;
                            }
                        }
                        Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_SINGLE_CLICK CarlifeCmdMessage is null");
                        return;
                    case 425990:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.mWidthPixels) / this.mCarlifeTouchManager.mWidth;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.mHeightPixels) / this.mCarlifeTouchManager.mHeight;
                                Log.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_DOUBLE_CLICK: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.touchDoubleClick(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e22222) {
                                Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_DOUBLE_CLICK Error");
                                e22222.printStackTrace();
                                return;
                            }
                        }
                        Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_DOUBLE_CLICK CarlifeCmdMessage is null");
                        return;
                    case 425991:
                        if (carlifeMsg != null) {
                            try {
                                singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                tx = (singlePoint.getX() * this.mCarlifeTouchManager.mWidthPixels) / this.mCarlifeTouchManager.mWidth;
                                ty = (singlePoint.getY() * this.mCarlifeTouchManager.mHeightPixels) / this.mCarlifeTouchManager.mHeight;
                                Log.d(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_LONG_PRESS: " + ("x = " + tx + ", y = " + ty));
                                this.mCarlifeTouchManager.touchLongPress(tx, ty);
                                return;
                            } catch (InvalidProtocolBufferException e222222) {
                                Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_LONG_PRESS Error");
                                e222222.printStackTrace();
                                return;
                            }
                        }
                        Log.e(CarlifeTouchManager.Tag, "MSG_CMD_TOUCH_LONG_PRESS CarlifeCmdMessage is null");
                        return;
                    case 425992:
                        if (carlifeMsg != null) {
                            try {
                                int code = CarlifeCarHardKeyCode.parseFrom(carlifeMsg.getData()).getKeycode();
                                Log.d(CarlifeTouchManager.Tag, "MSG_TOUCH_CAR_HARD_KEY_CODE: " + ("keycode = " + code));
                                this.mCarlifeTouchManager.onHardKeyCodeEvent(code);
                                return;
                            } catch (InvalidProtocolBufferException e2222222) {
                                Log.e(CarlifeTouchManager.Tag, "MSG_TOUCH_CAR_HARD_KEY_CODE Error");
                                e2222222.printStackTrace();
                                return;
                            }
                        }
                        Log.e(CarlifeTouchManager.Tag, "MSG_TOUCH_CAR_HARD_KEY_CODE CarlifeCmdMessage is null");
                        return;
                    case 425994:
                        if (this.mCarlifeTouchManager.mIS) {
                            if (carlifeMsg != null) {
                                try {
                                    singlePoint = CarlifeTouchSinglePoint.parseFrom(carlifeMsg.getData());
                                    tx = (singlePoint.getX() * this.mCarlifeTouchManager.mWidthPixels) / this.mCarlifeTouchManager.mWidth;
                                    ty = (singlePoint.getY() * this.mCarlifeTouchManager.mHeightPixels) / this.mCarlifeTouchManager.mHeight;
                                    Log.d(CarlifeTouchManager.Tag, "MSG_TOUCH_UI_ACTION_BEGIN: " + ("x = " + tx + ", y = " + ty));
                                    Log.i(CarlifeTouchManager.Tag, "ty = " + ty + ", phoneHeight = " + CarlifeScreenUtil.newInstance().getWindowHeightPixels() + ", avaibleHeight = " + (CarlifeScreenUtil.newInstance().getWindowHeightPixels() - this.mCarlifeTouchManager.mBottomBarHeight));
                                    if (ty > CarlifeScreenUtil.newInstance().getWindowHeightPixels() - this.mCarlifeTouchManager.mBottomBarHeight) {
                                        this.mCarlifeTouchManager.touchUIAction(tx, ty);
                                        return;
                                    }
                                    return;
                                } catch (InvalidProtocolBufferException e22222222) {
                                    Log.e(CarlifeTouchManager.Tag, "MSG_TOUCH_UI_ACTION_BEGIN Error");
                                    e22222222.printStackTrace();
                                    return;
                                }
                            }
                            Log.e(CarlifeTouchManager.Tag, "MSG_TOUCH_UI_ACTION_BEGIN CarlifeCmdMessage is null");
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


    public void initOnHardKeyCodeEventListener(OnHardKeyCodeEventListener listener) {
        this.mOnHardKeyCodeEventListener = listener;
    }


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

    public void initHardListener(OnHardKeyCodeEventListener listener) {
        initHardListener(0, listener);
    }


    public void initHardListener(int bottomBarHeight, OnHardKeyCodeEventListener listener) {
        if (this.isInitHardListener) {
            this.mWidthPixels = CarlifeScreenUtil.newInstance().getWidthPixels();
            this.mHeightPixels = CarlifeScreenUtil.newInstance().getHeightPixels();
            return;
        }
        this.isInitHardListener = true;
        this.mOnHardKeyCodeEventListener = listener;
        this.mBottomBarHeight = bottomBarHeight;
        HandlerThread handlerThread = new HandlerThread(TouchManagerHandlerThreadTag);
        handlerThread.start();
        this.mMsgBaseHandler = new CarlifeTouchManagerHandler(this, handlerThread.getLooper());
        MsgHandlerCenter.registerMessageHandler(this.mMsgBaseHandler);
        this.mWidthPixels = CarlifeScreenUtil.newInstance().getWidthPixels();
        this.mHeightPixels = CarlifeScreenUtil.newInstance().getHeightPixels();
        this.mInstrumentation = new Instrumentation();
        this.mCarlifeInstrumentation = new CarlifeInstrumentation();
    }


    public void iniLocalSocket() {
        Log.d(Tag, "iniLocalSocket");
        try {
            new CarlifeTouchManagerThread(this).start();
        } catch (Exception e) {
            Log.e(Tag, "initLocalSocket fail");
            this.mSocket = null;
            e.printStackTrace();
        }
    }


    public void uniniLocalSocket() {
        Log.d(Tag, "uniniLocalSocket");
        try {
            this.mDataInputStream.close();
        } catch (Exception e) {
            Log.e(Tag, "mReader close fail");
            e.printStackTrace();
        } finally {
            this.mDataInputStream = null;
        }
        try {
            this.mDataOutputStream.close();
        } catch (Exception e2) {
            Log.e(Tag, "mWriter close fail");
            e2.printStackTrace();
        } finally {
            this.mDataOutputStream = null;
        }
        try {
            this.mSocket.close();
        } catch (Exception e22) {
            Log.e(Tag, "mSocket close fail");
            e22.printStackTrace();
        } finally {
            this.mSocket = null;
        }
    }


    private boolean isValid() {
        if (this.mWidth <= 0 || this.mWidth > 10000
                || this.mHeight <= 0 || this.mHeight > 10000
                || this.mWidthPixels <= 0 || this.mWidthPixels > 10000
                || this.mHeightPixels <= 0 || this.mHeightPixels > 10000) {
            return false;
        }
        return true;
    }


    public int getWidth() {
        return this.mWidth;
    }


    public int getHeight() {
        return this.mHeight;
    }


    public int getWidthPixels() {
        return this.mWidthPixels;
    }


    public int getHeightPixels() {
        return this.mHeightPixels;
    }


    public void getWidth(int w) {
        this.mWidth = w;
    }


    public void setHeight(int h) {
        this.mHeight = h;
    }


    public void setWidthPixels(int w) {
        this.mWidthPixels = w;
    }


    public void setHeightPixels(int h) {
        this.mHeightPixels = h;
    }


    public void setIS(boolean is) {
        this.mIS = is;
    }


    public boolean getIS() {
        return this.mIS;
    }


    private void writeToLocalSocket(int x, int y, int action) {
        try {
            Log.d(Tag, "Write to LocalSocket");
            this.mDataOutputStream.writeInt(x);
            this.mDataOutputStream.writeInt(y);
            this.mDataOutputStream.writeInt(action);
        } catch (Exception e) {
            Log.e(Tag, "Write to LocalSocket Failed");
            e.printStackTrace();
            try {
                if (this.mCntShowToast % 20 == 0) {
                    Log.e(Tag, "cntShowToast: " + this.mCntShowToast);
                    MsgHandlerCenter.dispatchMessage(1039);
                }
                this.mCntShowToast++;
            } catch (Exception ex) {
                Log.e(Tag, "Write to LocalSocket Failed 1");
                ex.printStackTrace();
            }
        }
    }


    public void touchAction(int x, int y, int action) {
        if (action == MotionEvent.ACTION_DOWN) {
            touchActionDown(x, y);
        } else if (action == MotionEvent.ACTION_MOVE) {
            touchActionMove(x, y);
        } else if (action == MotionEvent.ACTION_UP) {
            touchActionUp(x, y);
        }
    }


    public void touchActionDown(int x, int y) {
        try {
            long time = SystemClock.uptimeMillis();
            MotionEvent event = MotionEvent.obtain(time, time, MotionEvent.ACTION_DOWN, (float) x, (float) y, 0);
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4512a(event);
            } else {
                this.mInstrumentation.sendPointerSync(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, MotionEvent.ACTION_DOWN);
        }
    }


    public void touchActionUp(int x, int y) {
        try {
            long time = SystemClock.uptimeMillis();
            MotionEvent event = MotionEvent.obtain(time, time, MotionEvent.ACTION_UP, (float) x, (float) y, 0);
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4512a(event);
            } else {
                this.mInstrumentation.sendPointerSync(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, MotionEvent.ACTION_UP);
        }
    }


    public void touchActionMove(int x, int y) {
        try {
            long time = SystemClock.uptimeMillis();
            MotionEvent event = MotionEvent.obtain(time, time, MotionEvent.ACTION_MOVE, (float) x, (float) y, 0);
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4512a(event);
            } else {
                this.mInstrumentation.sendPointerSync(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, MotionEvent.ACTION_MOVE);
        }
    }


    public void touchSingleClick(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, MotionEvent.ACTION_DOWN, (float) x, (float) y, 0);
            long time2 = time1 + 10;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, MotionEvent.ACTION_UP, (float) x, (float) y, 0);
            if (CarlifeConfig.isSupportInternalScreen()) {
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
            Log.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, MotionEvent.ACTION_DOWN);
            writeToLocalSocket(x, y, MotionEvent.ACTION_UP);
        }
    }


    public void touchUIAction(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, MotionEvent.ACTION_DOWN, (float) x, (float) y, 0);
            long time2 = time1 + 10;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, MotionEvent.ACTION_UP, (float) x, (float) y, 0);
            if (CarlifeConfig.isSupportInternalScreen()) {
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


    public void touchDoubleClick(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, MotionEvent.ACTION_DOWN, (float) x, (float) y, 0);
            long time2 = time1 + 30;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, MotionEvent.ACTION_UP, (float) x, (float) y, 0);
            if (CarlifeConfig.isSupportInternalScreen()) {
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
            Log.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, MotionEvent.ACTION_DOWN);
            writeToLocalSocket(x, y, MotionEvent.ACTION_UP);
        }
    }


    public void touchLongPress(int x, int y) {
        try {
            long time1 = SystemClock.uptimeMillis();
            MotionEvent event1 = MotionEvent.obtain(time1, time1, MotionEvent.ACTION_DOWN, (float) x, (float) y, 0);
            long time2 = time1 + 100;
            MotionEvent event2 = MotionEvent.obtain(time2, time2, MotionEvent.ACTION_MOVE, (float) x, (float) y, 0);
            long time3 = time1 + 300;
            MotionEvent event3 = MotionEvent.obtain(time3, time3, MotionEvent.ACTION_MOVE, (float) x, (float) y, 0);
            long time4 = time1 + 500;
            MotionEvent event4 = MotionEvent.obtain(time4, time4, MotionEvent.ACTION_MOVE, (float) x, (float) y, 0);
            long time5 = time1 + 700;
            MotionEvent event5 = MotionEvent.obtain(time5, time5, MotionEvent.ACTION_MOVE, (float) x, (float) y, 0);
            if (CarlifeConfig.isSupportInternalScreen()) {
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
            Log.e(Tag, "Please Enter into Carlife App!");
            writeToLocalSocket(x, y, MotionEvent.ACTION_DOWN);
            writeToLocalSocket(x, y, MotionEvent.ACTION_MOVE);
            writeToLocalSocket(x, y, MotionEvent.ACTION_MOVE);
            writeToLocalSocket(x, y, MotionEvent.ACTION_MOVE);
            writeToLocalSocket(x, y, MotionEvent.ACTION_MOVE);
        }
    }


    public void onKeyBackEvent() {
        try {
            Log.e(Tag, "onKeyBackEvent keycode=4");
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(KeyEvent.KEYCODE_BACK);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeyBackEvent get execption!");
        }
    }


    public void onKeyDPadRightEvent() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(KeyEvent.KEYCODE_DPAD_RIGHT);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorRightEvent get execption!");
        }
    }


    public void onKeyDPadLeftEvent() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(KeyEvent.KEYCODE_DPAD_LEFT);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_LEFT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorLeftEvent get execption!");
        }
    }


    public void onKeyDPadUpEvent() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(KeyEvent.KEYCODE_DPAD_UP);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_UP);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorUpEvent get execption!");
        }
    }


    public void onKeySelectorRightDownEvent() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(305);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(305);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorRightDownEvent get execption!");
        }
    }


    public void sendKeyDownUpSync() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(303);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(303);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorLeftDownEvent get execption!");
        }
    }


    public void onKeySelectorRightUpEvent() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(304);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(304);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorRightUpEvent get execption!");
        }
    }


    public void onKeySelectorLeftUpEvent() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(302);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(302);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorLeftUpEvent get execption!");
        }
    }


    public void onKeySelectorDownEvent() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(KeyEvent.KEYCODE_DPAD_DOWN);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorDownEvent get execption!");
        }
    }


    public void onKeyOkEvent() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(KeyEvent.KEYCODE_DPAD_CENTER);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeyOkEvent get execption!");
        }
    }


    public void onKeySelectorRightEvent300() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(300);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorRightEvent get execption!");
        }
    }


    public void onKeySelectorRightEvent301() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(301);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(301);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onKeySelectorRightEvent get execption!");
        }
    }


    public void onKeyClear() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(KeyEvent.KEYCODE_CLEAR);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_CLEAR);
            }
        } catch (Exception e) {
            Log.e(Tag, "onKeyClear get execption:" + e.toString());
        }
    }


    public void onKeyDelete() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(KeyEvent.KEYCODE_DEL);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_DEL);
            }
        } catch (Exception e) {
            Log.e(Tag, "onKeyDelete get execption:" + e.toString());
        }
    }


    public void onKeyDeleteByCode(int num) {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(num + 7);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(num + 7);
            }
        } catch (Exception e) {
            Log.e(Tag, "onKeyDelete get execption:" + e.toString());
        }
    }


    public void onKeyNumPadAdd() {
        try {
            if (CarlifeConfig.isSupportInternalScreen()) {
                this.mCarlifeInstrumentation.m4510a(KeyEvent.KEYCODE_NUMPAD_ADD);
            } else {
                this.mInstrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_NUMPAD_ADD);
            }
        } catch (Exception e) {
            Log.e(Tag, "onKeyDelete get execption:" + e.toString());
        }
    }


    public void onHardKeyCodeEvent(int keycode) {
        Log.d(Tag, "keycode is " + keycode);
        try {
            if (this.mOnHardKeyCodeEventListener == null || !this.mOnHardKeyCodeEventListener.mo1339a(keycode)) {
                switch (keycode) {
                    case 2:
                        MsgHandlerCenter.dispatchMessageDelay(2026, 0, 0, null);
                        return;
                    case 3:
                        MsgHandlerCenter.dispatchMessageDelay(2027, 0, 0, null);
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
                        onKeyDPadLeftEvent();
                        return;
                    case 22:
                        onKeyDPadRightEvent();
                        return;
                    case 23:
                        onKeyDPadUpEvent();
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
                        onKeyDelete();
                        return;
                    case 48:
                        onKeyClear();
                        return;
                    case 49:
                        onKeyNumPadAdd();
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag, "onHardKeyCodeEvent get exception!");
        }
    }


    public void initOnTouchListener(OnTouchListener touchListener) {
        this.mCarlifeInstrumentation.initOnTouchListener(touchListener);
    }
}
