package com.baidu.speech;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.che.codriver.p123i.C2546c;
import com.baidu.speech.aidl.EventListener;
import com.baidu.speech.aidl.EventManager;
import com.baidu.speech.aidl.EventManagerFactory.Stub;
import com.baidu.speech.aidl.EventRecognitionService;
import com.baidu.speech.asr.EventManagerAsr;
import com.baidu.speech.asr.EventManagerSlot;
import com.baidu.speech.asr.EventManagerWp;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.speech.audio.MicrophoneServer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class EventManagerFactory {
    private static final String TAG = "EventManagerFactory";
    private static boolean asrUsing = false;
    private static boolean kwsLoaded = false;
    private static boolean wpUsing = false;

    static class EventManagerRemote2Local implements EventManager {
        final ServiceConnection conn = new C49241();
        private Context context;
        ExecutorService executor = Executors.newCachedThreadPool();
        private EventListener mLis;
        private String name;
        private EventManager remoteEM;

        /* renamed from: com.baidu.speech.EventManagerFactory$EventManagerRemote2Local$1 */
        class C49241 implements ServiceConnection {
            C49241() {
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                com.baidu.speech.aidl.EventManagerFactory asInterface = Stub.asInterface(iBinder);
                try {
                    if (EventManagerRemote2Local.this.remoteEM == null) {
                        EventManagerRemote2Local.this.setRemoteEM(asInterface.create(EventManagerRemote2Local.this.name));
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                if (EventManagerFactory.kwsLoaded && EventManagerRemote2Local.this.mLis != null) {
                    EventManagerRemote2Local.this.mLis.onEvent("asr.unloaded", null, null, 0, 0);
                }
                if (EventManagerFactory.asrUsing && EventManagerRemote2Local.this.mLis != null) {
                    EventManagerRemote2Local.this.mLis.onEvent("asr.exit", null, null, 0, 0);
                }
                if (EventManagerFactory.wpUsing && EventManagerRemote2Local.this.mLis != null) {
                    EventManagerRemote2Local.this.mLis.onEvent("wp.exit", null, null, 0, 0);
                }
                EventManagerRemote2Local.this.remoteEM = null;
            }
        }

        EventManagerRemote2Local(Context context, String str) {
            this.context = context;
            this.name = str;
        }

        public void registerListener(EventListener eventListener) {
            this.mLis = eventListener;
        }

        public void send(String str, String str2, byte[] bArr, int i, int i2) {
            this.context.bindService(new Intent(this.context, EventRecognitionService.class), this.conn, 1);
            final byte[] bArr2 = bArr == null ? new byte[0] : bArr;
            if (SpeechConstant.ASR_START.equals(str) || SpeechConstant.ASR_KWS_LOAD_ENGINE.equals(str)) {
                EventManagerFactory.asrUsing = true;
            } else if (SpeechConstant.WAKEUP_START.equals(str)) {
                EventManagerFactory.wpUsing = true;
            } else if (SpeechConstant.ASR_KWS_LOAD_ENGINE.equals(str)) {
                EventManagerFactory.kwsLoaded = true;
            }
            final String str3 = str2;
            final String str4 = str;
            final int i3 = i;
            final int i4 = i2;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

                /* renamed from: com.baidu.speech.EventManagerFactory$EventManagerRemote2Local$2$1 */
                class C49281 extends EventListener.Stub {
                    C49281() {
                    }

                    public void onEvent(String str, String str2, byte[] bArr, int i, int i2) throws RemoteException {
                        boolean optBoolean;
                        JSONException jSONException;
                        final String jSONObject;
                        final String str3;
                        final byte[] bArr2;
                        final int i3;
                        final int i4;
                        if ("asr.exit".equals(str)) {
                            EventManagerFactory.asrUsing = false;
                        } else if ("wp.exit".equals(str)) {
                            EventManagerFactory.wpUsing = false;
                        } else if ("asr.unloaded".equals(str)) {
                            EventManagerFactory.kwsLoaded = false;
                        }
                        if ("wp.exit".equals(str)) {
                            JSONObject jSONObject2;
                            try {
                                if (str2 == null) {
                                    str2 = "{}";
                                }
                                jSONObject2 = new JSONObject(str2);
                                try {
                                    optBoolean = jSONObject2.optBoolean("_free");
                                } catch (JSONException e) {
                                    JSONException jSONException2 = e;
                                    optBoolean = false;
                                    jSONException = jSONException2;
                                    jSONException.printStackTrace();
                                    jSONObject = jSONObject2.toString();
                                    if (optBoolean) {
                                        str3 = str;
                                        bArr2 = bArr;
                                        i3 = i;
                                        i4 = i2;
                                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                            public void run() {
                                                EventManagerRemote2Local.this.mLis.onEvent(str3, jSONObject, bArr2, i3, i4);
                                            }
                                        }, 200);
                                        return;
                                    }
                                    str3 = str;
                                    bArr2 = bArr;
                                    i3 = i;
                                    i4 = i2;
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        public void run() {
                                            EventManagerRemote2Local.this.mLis.onEvent(str3, jSONObject, bArr2, i3, i4);
                                        }
                                    });
                                    return;
                                }
                                try {
                                    jSONObject2.remove("_free");
                                } catch (JSONException e2) {
                                    jSONException = e2;
                                    jSONException.printStackTrace();
                                    jSONObject = jSONObject2.toString();
                                    if (optBoolean) {
                                        str3 = str;
                                        bArr2 = bArr;
                                        i3 = i;
                                        i4 = i2;
                                        new Handler(Looper.getMainLooper()).post(/* anonymous class already generated */);
                                        return;
                                    }
                                    str3 = str;
                                    bArr2 = bArr;
                                    i3 = i;
                                    i4 = i2;
                                    new Handler(Looper.getMainLooper()).postDelayed(/* anonymous class already generated */, 200);
                                    return;
                                }
                            } catch (JSONException e3) {
                                jSONObject2 = null;
                                jSONException = e3;
                                optBoolean = false;
                                jSONException.printStackTrace();
                                jSONObject = jSONObject2.toString();
                                if (optBoolean) {
                                    str3 = str;
                                    bArr2 = bArr;
                                    i3 = i;
                                    i4 = i2;
                                    new Handler(Looper.getMainLooper()).postDelayed(/* anonymous class already generated */, 200);
                                    return;
                                }
                                str3 = str;
                                bArr2 = bArr;
                                i3 = i;
                                i4 = i2;
                                new Handler(Looper.getMainLooper()).post(/* anonymous class already generated */);
                                return;
                            }
                            jSONObject = jSONObject2.toString();
                            if (optBoolean) {
                                str3 = str;
                                bArr2 = bArr;
                                i3 = i;
                                i4 = i2;
                                new Handler(Looper.getMainLooper()).postDelayed(/* anonymous class already generated */, 200);
                                return;
                            }
                            str3 = str;
                            bArr2 = bArr;
                            i3 = i;
                            i4 = i2;
                            new Handler(Looper.getMainLooper()).post(/* anonymous class already generated */);
                            return;
                        }
                        str3 = str;
                        jSONObject = str2;
                        bArr2 = bArr;
                        i3 = i;
                        i4 = i2;
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                EventManagerRemote2Local.this.mLis.onEvent(str3, jSONObject, bArr2, i3, i4);
                            }
                        });
                    }
                }

                public void run() {
                    if (EventManagerRemote2Local.this.remoteEM == null) {
                        new Handler(Looper.getMainLooper()).postDelayed(this, 10);
                        return;
                    }
                    String str;
                    String str2 = str3;
                    if (SpeechConstant.ASR_START.equals(str4) || SpeechConstant.WAKEUP_START.equals(str4)) {
                        JSONObject jSONObject;
                        try {
                            jSONObject = new JSONObject(str3);
                        } catch (Exception e) {
                            jSONObject = new JSONObject();
                        }
                        try {
                            Object optString = jSONObject.optString(SpeechConstant.IN_FILE);
                            if (!(jSONObject.has("audio.socketport") || TextUtils.isEmpty(optString))) {
                                int i = 1;
                                if (jSONObject.has(SpeechConstant.AUDIO_SOURCE)) {
                                    i = jSONObject.optInt(SpeechConstant.AUDIO_SOURCE);
                                }
                                jSONObject.put("audio.socketport", MicrophoneServer.create(optString, i));
                                str2 = jSONObject.toString();
                            }
                            str = str2;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        EventManagerRemote2Local.this.remoteEM.registerListener(new C49281());
                        EventManagerRemote2Local.this.remoteEM.send(str4, str, bArr2, i3, i4);
                    }
                    str = str2;
                    try {
                        EventManagerRemote2Local.this.remoteEM.registerListener(new C49281());
                        EventManagerRemote2Local.this.remoteEM.send(str4, str, bArr2, i3, i4);
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                        EventManagerRemote2Local.this.remoteEM = null;
                    }
                }
            }, 0);
        }

        public void setRemoteEM(EventManager eventManager) {
            this.remoteEM = eventManager;
        }

        public void unregisterListener(EventListener eventListener) {
            this.mLis = null;
        }
    }

    public static final EventManager create(Context context, String str) {
        return create(context, str, false);
    }

    public static final EventManager create(Context context, String str, boolean z) {
        if (context == null || str == null || str.equals("")) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        return z ? new EventManagerRemote2Local(applicationContext, str) : str.equals(C2546c.ak) ? new EventManagerAsr(applicationContext) : str.equals(C2546c.am) ? new EventManagerWp(applicationContext) : str.equals(C2546c.al) ? new EventManagerSlot(applicationContext) : null;
    }
}
