package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog;
import com.baidu.navisdk.util.common.AppStateUtils;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SystemAuth;
import java.util.ArrayList;
import java.util.List;

public class PhoneStatusReceiver extends BroadcastReceiver {
    public static final int MSG_PHONE_CALL_OUT = 2;
    public static final int MSG_PHONE_IDEL = 4;
    public static final int MSG_PHONE_OFF_HOOK = 3;
    public static final int MSG_PHONE_RINGING = 1;
    public static final int MSG_TYPE_PHONE_CHANGE = 5556;
    private static final String TAG = "PhoneStatusReceiver";
    private static final List<Handler> outboxHandlers = new ArrayList();
    private static Context sContext = null;
    private static PhoneStatusReceiver sInstance = new PhoneStatusReceiver();
    private static boolean sIsPhoneReceiverRegisted = false;
    PhoneStateListener mListener = new C47081();

    /* renamed from: com.baidu.navisdk.util.listener.PhoneStatusReceiver$1 */
    class C47081 extends PhoneStateListener {
        C47081() {
        }

        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            switch (state) {
                case 0:
                    LogUtil.m15791e(PhoneStatusReceiver.TAG, "CALL_STATE_IDLE");
                    AppStateUtils.getInstance().setPhoneStatus(0);
                    PhoneStatusReceiver.dispatchMessage(PhoneStatusReceiver.MSG_TYPE_PHONE_CHANGE, 4, 0);
                    return;
                case 1:
                    LogUtil.m15791e(PhoneStatusReceiver.TAG, "CALL_STATE_RINGING");
                    AppStateUtils.getInstance().setPhoneStatus(1);
                    PhoneStatusReceiver.dispatchMessage(PhoneStatusReceiver.MSG_TYPE_PHONE_CHANGE, 1, 0);
                    return;
                case 2:
                    LogUtil.m15791e(PhoneStatusReceiver.TAG, "CALL_STATE_OFFHOOK");
                    AppStateUtils.getInstance().setPhoneStatus(2);
                    PhoneStatusReceiver.dispatchMessage(PhoneStatusReceiver.MSG_TYPE_PHONE_CHANGE, 3, 0);
                    return;
                default:
                    return;
            }
        }
    }

    private PhoneStatusReceiver() {
    }

    public static void initPhoneStatusReceiver(Context context) {
        if (SystemAuth.checkAuth("android.permission.CALL_PHONE") && SystemAuth.checkAuth(SystemAuth.PROCESS_OUTGOING_CALLS_AUTH) && context != null) {
            sContext = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
            intentFilter.setPriority(Integer.MAX_VALUE);
            try {
                sContext.registerReceiver(sInstance, intentFilter);
                sIsPhoneReceiverRegisted = true;
            } catch (Exception e) {
            }
        }
    }

    public static void uninitPhoneStatusReceiver() {
        if (SystemAuth.checkAuth("android.permission.CALL_PHONE") && SystemAuth.checkAuth(SystemAuth.PROCESS_OUTGOING_CALLS_AUTH)) {
            try {
                if (sContext != null && sIsPhoneReceiverRegisted) {
                    sIsPhoneReceiverRegisted = false;
                    sContext.unregisterReceiver(sInstance);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void registerMessageHandler(Handler handler) {
        if (handler != null && !outboxHandlers.contains(handler)) {
            outboxHandlers.add(handler);
        }
    }

    public static void unRegisterMessageHandler(Handler handler) {
        if (handler != null && outboxHandlers.contains(handler)) {
            outboxHandlers.remove(handler);
        }
    }

    private static void dispatchMessage(int what, int arg1, int arg2) {
        if (!outboxHandlers.isEmpty()) {
            for (Handler handler : outboxHandlers) {
                Message msg = Message.obtain(handler, what, arg1, arg2, null);
                if (msg.getTarget() != null) {
                    msg.sendToTarget();
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra("state");
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
            LogUtil.m15791e(TAG, "phone state change to TelephonyManager.CALL_STATE_RINGING");
            AudioUtils.setPhoneIn(true);
            BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
            TTSPlayerControl.stopSound();
            BNOffScreenManager.getInstance().handleOffScreenInterupt(true);
            UgcSoundsRecordDialog.stopRecordAndDismiss();
        } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)) {
            LogUtil.m15791e(TAG, "phone state change to TelephonyManager.CALL_STATE_OFFHOOK");
            AudioUtils.setPhoneIn(true);
            BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
            TTSPlayerControl.stopSound();
        } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(state)) {
            LogUtil.m15791e(TAG, "phone state change to TelephonyManager.CALL_STATE_IDLE");
            AudioUtils.setPhoneIn(false);
            BNOffScreenManager.getInstance().handleOffScreenInterupt(false);
        }
        if (SystemAuth.checkAuth("android.permission.CALL_PHONE") && SystemAuth.checkAuth(SystemAuth.PROCESS_OUTGOING_CALLS_AUTH)) {
            try {
                ((TelephonyManager) context.getSystemService("phone")).listen(this.mListener, 32);
            } catch (Exception e) {
            }
        }
    }
}
