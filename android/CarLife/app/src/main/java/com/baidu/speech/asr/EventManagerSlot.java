package com.baidu.speech.asr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import java.util.ArrayList;
import java.util.Iterator;

public class EventManagerSlot implements EventManager {
    private ArrayList<EventListener> listeners = new ArrayList();
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private SlotControl mSlotControl;

    /* renamed from: com.baidu.speech.asr.EventManagerSlot$1 */
    class C49391 implements EventListener {
        C49391() {
        }

        public void onEvent(String str, String str2, byte[] bArr, int i, int i2) {
            synchronized (EventManagerSlot.this.listeners) {
                Iterator it = EventManagerSlot.this.listeners.iterator();
                while (it.hasNext()) {
                    final EventListener eventListener = (EventListener) it.next();
                    final String str3 = str;
                    final String str4 = str2;
                    final byte[] bArr2 = bArr;
                    final int i3 = i;
                    final int i4 = i2;
                    EventManagerSlot.this.mHandler.post(new Runnable() {
                        public void run() {
                            if (eventListener != null) {
                                eventListener.onEvent(str3, str4, bArr2, i3, i4);
                            }
                        }
                    });
                }
            }
        }
    }

    public EventManagerSlot(Context context) {
        this.mContext = context;
        try {
            this.mSlotControl = new SlotControl(this.mContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerListener(EventListener eventListener) {
        if (eventListener != null) {
            this.listeners.add(eventListener);
        }
    }

    public void send(String str, String str2, byte[] bArr, int i, int i2) {
        if (!TextUtils.isEmpty(str) && this.mSlotControl != null) {
            this.mSlotControl.setListener(new C49391());
            this.mSlotControl.postEvent(str, str2);
        }
    }

    public void unregisterListener(EventListener eventListener) {
        this.listeners.remove(eventListener);
    }
}
