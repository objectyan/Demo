package me.objectyan.screensharing.core.screen.lightness;

import android.app.Activity;
import android.os.Message;
import android.provider.Settings.System;
import android.util.Log;

import me.objectyan.screensharing.core.CarLifeSettings;
import me.objectyan.screensharing.core.CommonParams;

import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.MsgBaseHandler;
import me.objectyan.screensharing.core.MsgHandlerCenter;
import me.objectyan.screensharing.core.screen.OnLightnessCoverListener;


public class LightnessControlManager {

    private static LightnessControlManager sLightnessControlManager = null;

    private static final String Tag = "LightnessControlManager";

    private static final Object sObject = new Object();

    private LightnessControlManagerHandler mLightnessControlManagerHandler;

    private boolean mState;

    private boolean f3655k;

    private boolean mVehicleState;

    private boolean mTouchMsgState;

    private boolean f3658n;

    private int f3659o;

    private OnLightnessCoverListener mOnLightnessCoverListener;

    private WindowLightnessChangeListener mWindowLightnessChangeListener;


    private class LightnessControlManagerHandler extends MsgBaseHandler {

        final LightnessControlManager mLightnessControlManager;

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


    public void access() {
        Log.d(Tag, "Access to the brightness of the screen");
    }


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


    public void setState(boolean state) {
        this.mState = state;
    }


    public boolean getState() {
        return this.mState;
    }


    public void m4491b(boolean state) {
        this.f3655k = state;
    }


    public boolean m4495d() {
        return this.f3655k;
    }


    public void setVehicleState(boolean vehicleState) {
        this.mVehicleState = vehicleState;
    }


    public boolean getVehicleState() {
        return this.mVehicleState;
    }


    public void setTouchMsgState(boolean touchMsgState) {
        this.mTouchMsgState = touchMsgState;
    }


    public boolean getTouchMsgState() {
        return this.mTouchMsgState;
    }


    public void m4496e(boolean state) {
        this.f3658n = state;
    }


    public boolean m4499g() {
        return this.f3658n;
    }


    public int m4500h() {
        return this.f3659o;
    }


    private int brightnessValue(Activity activity) {
        int brightnessValue = 0;
        try {
            brightnessValue = System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(Tag, "brightnessValue is " + Integer.valueOf(brightnessValue));
        return brightnessValue;
    }


    public void changeScreenBrightness(int value) {
        try {
            Log.d(Tag, "change screen brightness value = " + Integer.valueOf(value));
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
            Log.d(Tag, "usb is disconnect, the phone will not change");
        } catch (Exception e) {
            Log.d(Tag, "Can not change bright");
            e.printStackTrace();
        }
    }


    public void sendMessageDelayed(int msgType, boolean delay, int delayTime) {
        Log.d(Tag, "sendMessageDelayed msgType = " + Integer.valueOf(msgType) + " delayTime = " + Integer.valueOf(delayTime));
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


    public void cancleMsgBrightOff(int msgType) {
        Log.d(Tag, "cancleMsgBrightOff msgType = " + Integer.valueOf(msgType));
        switch (msgType) {
            case 4201:
                Log.d(Tag, "Cancle messge bright off");
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


    public void vehicleTouchmanage() {
        Log.d(Tag, "====vehicleTouchmanage====");
        if (true == this.mVehicleState) {
            cancleMsgBrightOff(4202);
        }
        sendMessageDelayed(4202, true, 1000);
        setVehicleState(true);
    }


    public void brightTouchEvent() {
        Log.d(Tag, "====brightTouchEvent====");
        if (true == this.f3655k) {
            cancleMsgBrightOff(4201);
        }
        if (!this.mState) {
            changeScreenBrightness(this.f3659o);
        }
        sendMessageDelayed(4201, true, 30000);
    }


    public void removeMessages() {
        this.mLightnessControlManagerHandler.removeMessages(CommonParams.hw);
    }


    public void sendEmptyMessageDelayed() {
        this.mLightnessControlManagerHandler.sendEmptyMessageDelayed(CommonParams.hw, 30000);
    }


    public void initOnLightnessCoverListener(OnLightnessCoverListener listener) {
        this.mOnLightnessCoverListener = listener;
    }


    public void initWindowLightnessChangeListener(WindowLightnessChangeListener listener) {
        this.mWindowLightnessChangeListener = listener;
    }
}
