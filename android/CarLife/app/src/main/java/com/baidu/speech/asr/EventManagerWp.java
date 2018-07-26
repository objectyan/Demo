package com.baidu.speech.asr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class EventManagerWp implements EventManager {
    private static final String TAG = "EventManagerWp";
    private static final String version = "1.1.0.20161226";
    private Exception initException = null;
    private ArrayList<EventListener> listeners = new ArrayList();
    private Context mContext;
    private WakeUpControl mEnginer;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.speech.asr.EventManagerWp$2 */
    class C49422 implements EventListener {
        C49422() {
        }

        public void onEvent(String str, String str2, byte[] bArr, int i, int i2) {
            synchronized (EventManagerWp.this.listeners) {
                Iterator it = EventManagerWp.this.listeners.iterator();
                while (it.hasNext()) {
                    final EventListener eventListener = (EventListener) it.next();
                    final String str3 = str;
                    final String str4 = str2;
                    final byte[] bArr2 = bArr;
                    final int i3 = i;
                    final int i4 = i2;
                    EventManagerWp.this.mHandler.post(new Runnable() {
                        public void run() {
                            if (eventListener != null) {
                                LogUtil.m16427i(EventManagerWp.TAG, "onEvent mCommand : " + str3);
                                LogUtil.m16427i(EventManagerWp.TAG, "onEvent mParam : " + str4);
                                eventListener.onEvent(str3, str4, bArr2, i3, i4);
                            }
                        }
                    });
                }
            }
        }
    }

    public EventManagerWp(Context context) {
        this.mContext = context;
        try {
            this.mEnginer = new WakeUpControl(context);
        } catch (Exception e) {
            e.printStackTrace();
            this.initException = e;
        }
    }

    public static final String getSDKVersion() {
        return version;
    }

    public void registerListener(EventListener eventListener) {
        if (eventListener != null && !this.listeners.contains(eventListener)) {
            this.listeners.add(eventListener);
        }
    }

    public void send(String str, String str2, byte[] bArr, int i, int i2) {
        LogUtil.m16427i(TAG, "send cmd : " + str);
        LogUtil.m16427i(TAG, "send params : " + str2);
        if (!TextUtils.isEmpty(str)) {
            if (SpeechConstant.WAKEUP_START.equals(str) && this.initException != null) {
                Iterator it = this.listeners.iterator();
                while (it.hasNext()) {
                    final EventListener eventListener = (EventListener) it.next();
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            if (eventListener != null) {
                                LogUtil.m16427i(EventManagerWp.TAG, "onEvent mCommand : wp.error and wp.exit  onEvent mParam : " + EventManagerWp.this.initException.getMessage());
                                eventListener.onEvent("wp.error", EventManagerWp.this.initException.getMessage(), null, 0, 0);
                                eventListener.onEvent("wp.exit", EventManagerWp.this.initException.getMessage(), null, 0, 0);
                            }
                        }
                    });
                }
            }
            if (this.mEnginer != null && str != null) {
                this.mEnginer.setListener(new C49422());
                this.mEnginer.postEvent(str, str2);
            }
        }
    }

    public void unregisterListener(EventListener eventListener) {
        this.listeners.remove(eventListener);
    }
}
