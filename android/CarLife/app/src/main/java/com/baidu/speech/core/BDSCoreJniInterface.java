package com.baidu.speech.core;

import android.util.Log;
import com.baidu.speech.core.BDSSDKLoader.BDSCoreEventListener;
import com.baidu.speech.core.BDSSDKLoader.BDSSDKInterface;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class BDSCoreJniInterface implements BDSSDKInterface {
    private static HashMap<String, WeakReference<BDSCoreJniInterface>> s_sdkInstances = new HashMap();
    private WeakReference<BDSCoreEventListener> m_observer;
    private String m_sdkHandle;

    private native void EchoMessage(BDSMessage bDSMessage, String str);

    private native int Post(BDSMessage bDSMessage, String str);

    private native void ReleaseInstance(String str);

    private static void addInstance(String str, BDSCoreJniInterface bDSCoreJniInterface) {
        WeakReference weakReference = new WeakReference(bDSCoreJniInterface);
        synchronized (s_sdkInstances) {
            s_sdkInstances.put(str, weakReference);
        }
    }

    private static BDSCoreJniInterface findInstance(String str) {
        BDSCoreJniInterface bDSCoreJniInterface;
        synchronized (s_sdkInstances) {
            WeakReference weakReference = (WeakReference) s_sdkInstances.get(str);
            if (weakReference == null) {
                bDSCoreJniInterface = null;
            } else {
                bDSCoreJniInterface = (BDSCoreJniInterface) weakReference.get();
                if (bDSCoreJniInterface == null) {
                    removeInstance(str);
                }
            }
        }
        return bDSCoreJniInterface;
    }

    public static BDSCoreJniInterface getNewSDK(String str) {
        String initCoreSDK = initCoreSDK(str);
        if (initCoreSDK == null || initCoreSDK.length() <= 0) {
            return null;
        }
        BDSCoreJniInterface bDSCoreJniInterface = new BDSCoreJniInterface();
        bDSCoreJniInterface.m_sdkHandle = initCoreSDK;
        addInstance(initCoreSDK, bDSCoreJniInterface);
        return bDSCoreJniInterface;
    }

    private static native String initCoreSDK(String str);

    private static void receiveCoreEvent(String str, BDSMessage bDSMessage) {
        BDSSDKInterface findInstance = findInstance(str);
        if (findInstance != null) {
            BDSCoreEventListener bDSCoreEventListener = (BDSCoreEventListener) findInstance.m_observer.get();
            if (bDSCoreEventListener != null) {
                bDSCoreEventListener.receiveCoreEvent(bDSMessage, findInstance);
                return;
            } else {
                Log.e("core event", "Listener is null for instance id " + str);
                return;
            }
        }
        Log.e("core event", "Can't find instance for id " + str);
    }

    private static void removeInstance(String str) {
        synchronized (s_sdkInstances) {
            s_sdkInstances.remove(str);
        }
    }

    public void EchoMessage(BDSMessage bDSMessage) {
        EchoMessage(bDSMessage, this.m_sdkHandle);
    }

    public boolean instanceInitialized() {
        return this.m_sdkHandle != null && this.m_sdkHandle.length() > 0;
    }

    public int postMessage(BDSMessage bDSMessage) {
        return Post(bDSMessage, this.m_sdkHandle);
    }

    public void release() {
        if (instanceInitialized()) {
            ReleaseInstance(this.m_sdkHandle);
        }
        removeInstance(this.m_sdkHandle);
    }

    public void setListener(BDSCoreEventListener bDSCoreEventListener) {
        this.m_observer = new WeakReference(bDSCoreEventListener);
    }
}
