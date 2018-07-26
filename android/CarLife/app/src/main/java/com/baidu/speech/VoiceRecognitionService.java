package com.baidu.speech;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.speech.RecognitionService;
import android.speech.RecognitionService.Callback;
import android.util.AndroidRuntimeException;
import com.baidu.che.codriver.p123i.C2546c;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.speech.asr.SpeechConstant;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class VoiceRecognitionService extends RecognitionService {
    public static final int EVENT_ENGINE_SWITCH = 12;
    private static final int EVENT_ERROR = 11;
    private static final int EVENT_THIRD_DATA = 12;
    public static final String TAG = "VoiceRecognitionService";
    public static final String VERSION_NAME = "3.4.0.100";
    private static final Logger logger = Logger.getLogger(TAG);
    private boolean internal;
    private EventManager mEventManagerAsr;
    private Bundle mFinalBundle;
    private boolean mLongSpeech;
    private MyListener mUsingListener;

    class MyListener implements EventListener {
        Callback mListener;

        MyListener() {
        }

        private final void callbackOnEvent(Callback callback, int i, Bundle bundle) {
            try {
                Field declaredField = callback.getClass().getDeclaredField("mListener");
                declaredField.setAccessible(true);
                Class.forName("android.speech.IRecognitionListener").getMethod("onEvent", new Class[]{Integer.TYPE, Bundle.class}).invoke(declaredField.get(callback), new Object[]{Integer.valueOf(i), bundle});
            } catch (Throwable e) {
                e.printStackTrace();
                VoiceRecognitionService.logger.log(Level.WARNING, "", e);
            }
        }

        public void onEvent(String str, String str2, byte[] bArr, int i, int i2) {
            Callback callback = this.mListener;
            if (callback != null) {
                try {
                    if ("asr.ready".equals(str)) {
                        callback.readyForSpeech(new Bundle());
                    } else if ("asr.begin".equals(str)) {
                        callback.beginningOfSpeech();
                    } else if ("asr.audio".equals(str)) {
                        callback.bufferReceived(bArr);
                    } else if ("asr.volume".equals(str)) {
                        callback.rmsChanged((float) new JSONObject(str2).optDouble(C1981b.f6362b));
                    } else if ("asr.end".equals(str)) {
                        callback.endOfSpeech();
                    } else if ("asr.partial".equals(str)) {
                        r1 = new JSONObject(str2);
                        String optString = r1.optString("result_type");
                        Bundle fromJson = VoiceRecognitionService.fromJson(r1);
                        if (optString != null && optString != "") {
                            if (optString.equals("partial_result")) {
                                callback.partialResults(fromJson);
                            } else if (optString.equals("final_result")) {
                                VoiceRecognitionService.this.mFinalBundle = fromJson;
                            } else if (optString.equals("third_result")) {
                                fromJson = new Bundle();
                                fromJson.putByteArray("third_data", bArr);
                                callbackOnEvent(callback, 12, fromJson);
                            }
                        }
                    } else if ("asr.finish".equals(str)) {
                        r1 = new JSONObject(str2);
                        int i3 = r1.getInt(ParamKey.KEY_MSG_ERRORS);
                        if (i3 != 0) {
                            callback.error(i3);
                            Bundle bundle = new Bundle();
                            bundle.putInt(ParamKey.KEY_MSG_ERRORS, r1.getInt("sub_error"));
                            bundle.putString("reason", r1.getString("desc"));
                            callbackOnEvent(callback, 11, bundle);
                        } else if (!VoiceRecognitionService.this.mLongSpeech) {
                            callback.results(VoiceRecognitionService.this.mFinalBundle);
                            VoiceRecognitionService.this.mFinalBundle = null;
                        }
                    } else if (SpeechConstant.CALLBACK_EVENT_ASR_LONG_SPEECH.equals(str)) {
                        callback.results(VoiceRecognitionService.this.mFinalBundle);
                        VoiceRecognitionService.this.mFinalBundle = null;
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public void setCallbackListener(Callback callback) {
            this.mListener = callback;
        }
    }

    private JSONObject convertIntentToJson(Intent intent) {
        Map hashMap = new HashMap();
        intent.getStringExtra(Config.APP_VERSION_CODE);
        Bundle extras = intent.getExtras();
        for (String str : extras.keySet()) {
            Object obj = extras.get(str);
            if (str.equals("args") && (obj instanceof String)) {
                for (String str2 : ((String) obj).split("--")) {
                    int indexOf = str2.trim().indexOf(" ");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf("\t");
                    }
                    if (indexOf < 0) {
                        indexOf = str2.indexOf("=");
                    }
                    if (indexOf > 0) {
                        hashMap.put(str2.substring(0, indexOf).trim(), str2.substring(indexOf + 1).trim());
                    }
                }
            } else {
                hashMap.put(str, obj);
            }
        }
        return new JSONObject(hashMap);
    }

    public static Bundle fromJson(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            String optString = jSONObject.optString(str);
            if (optJSONArray != null && optJSONArray.length() <= 0) {
                bundle.putStringArray(str, new String[0]);
            } else if (optJSONArray != null && optJSONArray.optString(0) != null) {
                ArrayList arrayList = new ArrayList();
                for (r1 = 0; r1 < optJSONArray.length(); r1++) {
                    arrayList.add(optJSONArray.optString(r1));
                }
                bundle.putStringArrayList(str, arrayList);
            } else if (optJSONArray != null && !Double.isNaN(optJSONArray.optDouble(0))) {
                double[] dArr = new double[optJSONArray.length()];
                for (r1 = 0; r1 < optJSONArray.length(); r1++) {
                    dArr[r1] = optJSONArray.optDouble(r1);
                }
                bundle.putDoubleArray(str, dArr);
            } else if (optString != null) {
                bundle.putString(str, optString);
            }
        }
        return bundle;
    }

    public static String getSdkVersion() {
        return VERSION_NAME;
    }

    protected void onCancel(Callback callback) {
        this.mEventManagerAsr.send("asr.cancel", "{}", null, 0, 0);
    }

    public void onCreate() {
        super.onCreate();
        synchronized (VoiceRecognitionService.class) {
            if (this.mEventManagerAsr == null) {
                this.mEventManagerAsr = EventManagerFactory.create(getApplicationContext(), C2546c.ak);
                this.mUsingListener = new MyListener();
                this.mEventManagerAsr.registerListener(this.mUsingListener);
                SpeechConstant.PUBLIC_DECODER = false;
            }
        }
        logger.info(String.format("onCreate(), hashcode=%s", new Object[]{Integer.valueOf(hashCode())}));
        try {
            Class.forName("com.baidu.android.voicedemo.SettingMore");
            this.internal = true;
        } catch (Exception e) {
        }
        logger.info("internal=" + this.internal);
        try {
            if (getPackageManager().getServiceInfo(new ComponentName(getPackageName(), getClass().getName()), 128).exported) {
                throw new AndroidRuntimeException(getClass().getName() + ", 'android:exported' should be false, please modify AndroidManifest.xml");
            }
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void onDestroy() {
        this.mEventManagerAsr.send(SpeechConstant.ASR_KWS_UNLOAD_ENGINE, "{}", null, 0, 0);
        super.onDestroy();
    }

    protected void onStartListening(Intent intent, Callback callback) {
        boolean z = false;
        if (!intent.hasExtra("audio.mills")) {
            intent.putExtra("audio.mills", System.currentTimeMillis());
        }
        if (intent.getIntExtra(SpeechConstant.VAD_ENDPOINT_TIMEOUT, -1) == 0) {
            z = true;
        }
        this.mLongSpeech = z;
        JSONObject convertIntentToJson = convertIntentToJson(intent);
        try {
            this.mUsingListener.setCallbackListener(callback);
            if (intent.getIntExtra(SpeechConstant.DECODER, 0) != 0) {
                this.mEventManagerAsr.send(SpeechConstant.ASR_KWS_LOAD_ENGINE, convertIntentToJson.toString(4), null, 0, 0);
            }
            this.mEventManagerAsr.send(SpeechConstant.ASR_START, convertIntentToJson.toString(4), null, 0, 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void onStopListening(Callback callback) {
        this.mEventManagerAsr.send(SpeechConstant.ASR_STOP, "{}", null, 0, 0);
    }
}
