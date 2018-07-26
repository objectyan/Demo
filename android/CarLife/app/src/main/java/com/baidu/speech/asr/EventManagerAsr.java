package com.baidu.speech.asr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.core.ASREngine;
import com.baidu.speech.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class EventManagerAsr implements EventManager, ASRListener {
    private static final String TAG = "EventManagerAsr";
    private static final String version = "3.4.0.100";
    private Exception initException = null;
    private ArrayList<EventListener> listeners = new ArrayList();
    private ASREngine mEnginer;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<ASRMessage> mMessageQueue = new ArrayList();
    private Context mcontext;

    public EventManagerAsr(Context context) {
        this.mcontext = context;
        try {
            this.mEnginer = new ASREngine(context);
            this.mMessageQueue.clear();
        } catch (Exception e) {
            e.printStackTrace();
            this.initException = e;
        }
    }

    public static final String getSDKVersion() {
        return "3.4.0.100";
    }

    private void updateMessageQueue(ASRMessage aSRMessage) {
        synchronized (this.mMessageQueue) {
            if (aSRMessage.mIsVip) {
                this.mMessageQueue.clear();
            }
            this.mMessageQueue.add(aSRMessage);
        }
    }

    public void onEvent(String str, String str2, byte[] bArr, int i, int i2) {
        onEvent(str, str2, bArr, i, i2, false);
    }

    public void onEvent(String str, String str2, byte[] bArr, int i, int i2, boolean z) {
        updateMessageQueue(new ASRMessage(str, str2, bArr, i, i2, z));
        synchronized (this.listeners) {
            synchronized (this.mMessageQueue) {
                if (this.mMessageQueue.size() <= 0) {
                    return;
                }
                final ASRMessage aSRMessage = (ASRMessage) this.mMessageQueue.remove(0);
                if (aSRMessage != null) {
                    Iterator it = this.listeners.iterator();
                    while (it.hasNext()) {
                        final EventListener eventListener = (EventListener) it.next();
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                if (eventListener != null) {
                                    LogUtil.m16427i(EventManagerAsr.TAG, "onEvent mCommand : " + aSRMessage.mCommand);
                                    LogUtil.m16427i(EventManagerAsr.TAG, "onEvent mParam : " + aSRMessage.mParam);
                                    eventListener.onEvent(aSRMessage.mCommand, aSRMessage.mParam, aSRMessage.mData, aSRMessage.mOffset, aSRMessage.mLength);
                                }
                            }
                        });
                    }
                }
            }
        }
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
            if (str.equals(SpeechConstant.ASR_START) && this.initException != null) {
                Iterator it = this.listeners.iterator();
                while (it.hasNext()) {
                    final EventListener eventListener = (EventListener) it.next();
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            if (eventListener != null) {
                                LogUtil.m16427i(EventManagerAsr.TAG, "onEvent mCommand : asr.finish and asr.exit  onEvent mParam : " + EventManagerAsr.this.initException.getMessage());
                                eventListener.onEvent("asr.finish", EventManagerAsr.this.initException.getMessage(), null, 0, 0);
                                eventListener.onEvent("asr.exit", EventManagerAsr.this.initException.getMessage(), null, 0, 0);
                            }
                        }
                    });
                }
            }
            if (this.mEnginer != null) {
                this.mEnginer.setListener(this);
                this.mEnginer.postEvent(str, str2);
            }
        }
    }

    public void unregisterListener(EventListener eventListener) {
        this.listeners.remove(eventListener);
    }
}
