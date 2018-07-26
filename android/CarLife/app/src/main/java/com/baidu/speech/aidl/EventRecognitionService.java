package com.baidu.speech.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;
import com.baidu.speech.aidl.EventManagerFactory.Stub;
import com.baidu.speech.asr.SpeechConstant;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class EventRecognitionService extends Service {
    private static final String TAG = "EventRecognitionService";
    private int RESTART_TIME = 3600000;
    private boolean asrUsing = false;
    private IBinder iBinder = new C49331();
    private long startTime = 0;
    private boolean wpUsing = false;

    /* renamed from: com.baidu.speech.aidl.EventRecognitionService$1 */
    class C49331 extends Stub {
        C49331() {
        }

        public EventManager create(final String str) throws RemoteException {
            EventManager c49321 = new EventManager.Stub() {
                EventManager impl = EventManagerFactory.create(EventRecognitionService.this.getApplicationContext(), str, false);
                public ArrayList<EventListenerProxy> usingLis = new ArrayList();

                public void registerListener(EventListener eventListener) throws RemoteException {
                    EventListener eventListenerProxy = new EventListenerProxy(eventListener);
                    unregisterListener(eventListener);
                    this.usingLis.add(eventListenerProxy);
                    this.impl.registerListener(eventListenerProxy);
                }

                public void send(String str, String str2, byte[] bArr, int i, int i2) throws RemoteException {
                    if (SpeechConstant.ASR_START.equals(str) || SpeechConstant.ASR_KWS_LOAD_ENGINE.equals(str)) {
                        EventRecognitionService.this.asrUsing = true;
                    } else if (SpeechConstant.WAKEUP_START.equals(str)) {
                        EventRecognitionService.this.wpUsing = true;
                    }
                    this.impl.send(str, str2, bArr, i, i2);
                }

                public void unregisterListener(EventListener eventListener) throws RemoteException {
                    Iterator it = this.usingLis.iterator();
                    while (it.hasNext()) {
                        this.impl.unregisterListener((EventListenerProxy) it.next());
                    }
                    this.usingLis.clear();
                }
            };
            EventRecognitionService.this.startTime = System.currentTimeMillis();
            return c49321;
        }
    }

    /* renamed from: com.baidu.speech.aidl.EventRecognitionService$2 */
    class C49342 implements Runnable {
        C49342() {
        }

        public void run() {
        }
    }

    class EventListenerProxy implements EventListener {
        private EventListener listener;

        public EventListenerProxy(EventListener eventListener) {
            this.listener = eventListener;
        }

        public void onEvent(String str, String str2, byte[] bArr, int i, int i2) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - EventRecognitionService.this.startTime;
                byte[] bArr2 = bArr == null ? new byte[0] : bArr;
                if ("asr.exit".equals(str)) {
                    EventRecognitionService.this.asrUsing = false;
                } else if ("wp.exit".equals(str)) {
                    EventRecognitionService.this.wpUsing = false;
                }
                if (EventRecognitionService.this.asrUsing || EventRecognitionService.this.wpUsing) {
                    this.listener.onEvent(str, str2, bArr2, i, i2);
                    return;
                }
                String jSONObject;
                boolean z = currentTimeMillis > ((long) EventRecognitionService.this.RESTART_TIME);
                try {
                    JSONObject jSONObject2 = new JSONObject(str2 == null ? "{}" : str2);
                    jSONObject2.put("_free", z);
                    jSONObject = jSONObject2.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = str2;
                }
                this.listener.onEvent(str, jSONObject, bArr2, i, i2);
                if (z) {
                    Log.d(EventRecognitionService.TAG, "wake up idle, exit!");
                    System.exit(0);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public EventRecognitionService() {
        new Handler().postDelayed(new C49342(), Config.BPLUS_DELAY_TIME);
    }

    public IBinder onBind(Intent intent) {
        return this.iBinder;
    }
}
