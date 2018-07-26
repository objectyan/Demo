package com.baidu.carlife.core.screen.lightness;

import android.app.Activity;
import android.os.Message;
import android.provider.Settings.System;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.OnLightnessCoverListener;

/* compiled from: LightnessControlManager */
/* renamed from: com.baidu.carlife.core.screen.a.a */
public class LightnessControlManager implements KeepClass {
    /* renamed from: f */
    private static LightnessControlManager sLightnessControlManager = null;
    /* renamed from: g */
    private static final String Tag = "LightnessControlManager";
    /* renamed from: h */
    private static final Object sObject = new Object();
    /* renamed from: i */
    private LightnessControlManagerHandler mLightnessControlManagerHandler;
    /* renamed from: j */
    private boolean mState;
    /* renamed from: k */
    private boolean f3655k;
    /* renamed from: l */
    private boolean mVehicleState;
    /* renamed from: m */
    private boolean mTouchMsgState;
    /* renamed from: n */
    private boolean f3658n;
    /* renamed from: o */
    private int f3659o;
    /* renamed from: p */
    private OnLightnessCoverListener mOnLightnessCoverListener;
    /* renamed from: q */
    private WindowLightnessChangeListener mWindowLightnessChangeListener;

    /* compiled from: LightnessControlManager */
    /* renamed from: com.baidu.carlife.core.screen.a.a$a */
    private class LightnessControlManagerHandler extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ LightnessControlManager mLightnessControlManager;

        private LightnessControlManagerHandler(LightnessControlManager lightnessControlManager) {
            this.mLightnessControlManager = lightnessControlManager;
        }

        public void careAbout() {
            addMsg(4200);
            addMsg(4201);
            addMsg(4202);
            addMsg(4250);
            addMsg(4252);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4200:
                    this.mLightnessControlManager.changeScreenBrightness(this.mLightnessControlManager.f3659o);
                    return;
                case 4201:
                    if (true == this.mLightnessControlManager.f3655k) {
                        this.mLightnessControlManager.m4491b(false);
                    }
                    this.mLightnessControlManager.changeScreenBrightness(1);
                    return;
                case 4202:
                    this.mLightnessControlManager.setVehicleState(false);
                    return;
                case 4250:
                    if (this.mLightnessControlManager.mOnLightnessCoverListener != null && CarLifeSettings.m4069a().m4095m()) {
                        this.mLightnessControlManager.mOnLightnessCoverListener.mo1480b();
                        return;
                    }
                    return;
                case 4252:
                    if (this.mLightnessControlManager.mOnLightnessCoverListener != null) {
                        this.mLightnessControlManager.mOnLightnessCoverListener.mo1479a(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public LightnessControlManager() {
        this.mLightnessControlManagerHandler = null;
        this.mState = true;
        this.f3655k = false;
        this.mVehicleState = false;
        this.mTouchMsgState = false;
        this.f3658n = false;
        this.f3659o = -10;
        this.mLightnessControlManagerHandler = new LightnessControlManagerHandler(this);
        MsgHandlerCenter.registerMessageHandler(this.mLightnessControlManagerHandler);
    }

    /* renamed from: a */
    public void access() {
        LogUtil.d(Tag, "Access to the brightness of the screen");
    }

    /* renamed from: b */
    public static LightnessControlManager newInstance() {
        if (sLightnessControlManager == null) {
            synchronized (sObject) {
                if (sLightnessControlManager == null) {
                    sLightnessControlManager = new LightnessControlManager();
                }
            }
        }
        return sLightnessControlManager;
    }

    /* renamed from: a */
    public void setState(boolean state) {
        this.mState = state;
    }

    /* renamed from: c */
    public boolean getState() {
        return this.mState;
    }

    /* renamed from: b */
    public void m4491b(boolean state) {
        this.f3655k = state;
    }

    /* renamed from: d */
    public boolean m4495d() {
        return this.f3655k;
    }

    /* renamed from: c */
    public void setVehicleState(boolean vehicleState) {
        this.mVehicleState = vehicleState;
    }

    /* renamed from: e */
    public boolean getVehicleState() {
        return this.mVehicleState;
    }

    /* renamed from: d */
    public void setTouchMsgState(boolean touchMsgState) {
        this.mTouchMsgState = touchMsgState;
    }

    /* renamed from: f */
    public boolean getTouchMsgState() {
        return this.mTouchMsgState;
    }

    /* renamed from: e */
    public void m4496e(boolean state) {
        this.f3658n = state;
    }

    /* renamed from: g */
    public boolean m4499g() {
        return this.f3658n;
    }

    /* renamed from: h */
    public int m4500h() {
        return this.f3659o;
    }

    /* renamed from: a */
    private int brightnessValue(Activity activity) {
        int brightnessValue = 0;
        try {
            brightnessValue = System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.d(Tag, "brightnessValue is %d", Integer.valueOf(brightnessValue));
        return brightnessValue;
    }

    /* renamed from: a */
    public void changeScreenBrightness(int value) {
        try {
            LogUtil.d(Tag, "change screen brightness value = %d", Integer.valueOf(value));
            if (1 != value || this.f3658n) {
                float screenBrightness = ((float) value) / 255.0f;
                boolean screenOn = false;
                if (1 == value) {
                    setState(false);
                } else {
                    setState(true);
                }
                if (((float) value) != 0.0f) {
                    screenOn = true;
                }
                if (this.mWindowLightnessChangeListener != null) {
                    this.mWindowLightnessChangeListener.mo1345a(screenBrightness, screenOn);
                    return;
                }
                return;
            }
            LogUtil.d(Tag, "usb is disconnect, the phone will not change");
        } catch (Exception e) {
            LogUtil.d(Tag, "Can not change bright");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void sendMessageDelayed(int msgType, boolean delay, int delayTime) {
        LogUtil.d(Tag, "sendMessageDelayed msgType = %d delayTime = %d", Integer.valueOf(msgType), Integer.valueOf(delayTime));
        if (true == delay) {
            switch (msgType) {
                case 4201:
                    this.mLightnessControlManagerHandler.sendEmptyMessageDelayed(msgType, (long) delayTime);
                    if (!this.f3655k) {
                        m4491b(true);
                        return;
                    }
                    return;
                case 4202:
                    this.mLightnessControlManagerHandler.sendEmptyMessageDelayed(msgType, (long) delayTime);
                    if (!this.mTouchMsgState) {
                        setVehicleState(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        this.mLightnessControlManagerHandler.sendEmptyMessage(msgType);
    }

    /* renamed from: b */
    public void cancleMsgBrightOff(int msgType) {
        LogUtil.d(Tag, "cancleMsgBrightOff msgType = %d", Integer.valueOf(msgType));
        switch (msgType) {
            case 4201:
                LogUtil.d(Tag, "Cancle messge bright off");
                this.mLightnessControlManagerHandler.removeMessages(msgType);
                m4491b(false);
                return;
            case 4202:
                this.mLightnessControlManagerHandler.removeMessages(msgType);
                setVehicleState(false);
                return;
            default:
                return;
        }
    }

    /* renamed from: i */
    public void vehicleTouchmanage() {
        LogUtil.d(Tag, "====vehicleTouchmanage====");
        if (true == this.mVehicleState) {
            cancleMsgBrightOff(4202);
        }
        sendMessageDelayed(4202, true, 1000);
        setVehicleState(true);
    }

    /* renamed from: j */
    public void brightTouchEvent() {
        LogUtil.d(Tag, "====brightTouchEvent====");
        if (true == this.f3655k) {
            cancleMsgBrightOff(4201);
        }
        if (!this.mState) {
            changeScreenBrightness(this.f3659o);
        }
        sendMessageDelayed(4201, true, 30000);
    }

    /* renamed from: k */
    public void removeMessages() {
        this.mLightnessControlManagerHandler.removeMessages(CommonParams.hw);
    }

    /* renamed from: l */
    public void sendEmptyMessageDelayed() {
        this.mLightnessControlManagerHandler.sendEmptyMessageDelayed(CommonParams.hw, 30000);
    }

    /* renamed from: a */
    public void initOnLightnessCoverListener(OnLightnessCoverListener listener) {
        this.mOnLightnessCoverListener = listener;
    }

    /* renamed from: a */
    public void initWindowLightnessChangeListener(WindowLightnessChangeListener listener) {
        this.mWindowLightnessChangeListener = listener;
    }
}
