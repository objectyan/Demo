package com.baidu.speech.core;

import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class BDSCoreJniInterface
  implements BDSSDKLoader.BDSSDKInterface
{
  private static HashMap<String, WeakReference<BDSCoreJniInterface>> s_sdkInstances = new HashMap();
  private WeakReference<BDSSDKLoader.BDSCoreEventListener> m_observer;
  private String m_sdkHandle;
  
  private native void EchoMessage(BDSMessage paramBDSMessage, String paramString);
  
  private native int Post(BDSMessage paramBDSMessage, String paramString);
  
  private native void ReleaseInstance(String paramString);
  
  private static void addInstance(String paramString, BDSCoreJniInterface arg1)
  {
    WeakReference localWeakReference = new WeakReference(???);
    synchronized (s_sdkInstances)
    {
      s_sdkInstances.put(paramString, localWeakReference);
      return;
    }
  }
  
  private static BDSCoreJniInterface findInstance(String paramString)
  {
    synchronized (s_sdkInstances)
    {
      Object localObject = (WeakReference)s_sdkInstances.get(paramString);
      if (localObject == null) {
        return null;
      }
      localObject = (BDSCoreJniInterface)((WeakReference)localObject).get();
      if (localObject == null) {
        removeInstance(paramString);
      }
      return (BDSCoreJniInterface)localObject;
    }
  }
  
  public static BDSCoreJniInterface getNewSDK(String paramString)
  {
    String str = initCoreSDK(paramString);
    Object localObject = null;
    paramString = (String)localObject;
    if (str != null)
    {
      paramString = (String)localObject;
      if (str.length() > 0)
      {
        paramString = new BDSCoreJniInterface();
        paramString.m_sdkHandle = str;
        addInstance(str, paramString);
      }
    }
    return paramString;
  }
  
  private static native String initCoreSDK(String paramString);
  
  private static void receiveCoreEvent(String paramString, BDSMessage paramBDSMessage)
  {
    BDSCoreJniInterface localBDSCoreJniInterface = findInstance(paramString);
    if (localBDSCoreJniInterface != null)
    {
      BDSSDKLoader.BDSCoreEventListener localBDSCoreEventListener = (BDSSDKLoader.BDSCoreEventListener)localBDSCoreJniInterface.m_observer.get();
      if (localBDSCoreEventListener != null)
      {
        localBDSCoreEventListener.receiveCoreEvent(paramBDSMessage, localBDSCoreJniInterface);
        return;
      }
      Log.e("core event", "Listener is null for instance id " + paramString);
      return;
    }
    Log.e("core event", "Can't find instance for id " + paramString);
  }
  
  private static void removeInstance(String paramString)
  {
    synchronized (s_sdkInstances)
    {
      s_sdkInstances.remove(paramString);
      return;
    }
  }
  
  public void EchoMessage(BDSMessage paramBDSMessage)
  {
    EchoMessage(paramBDSMessage, this.m_sdkHandle);
  }
  
  public boolean instanceInitialized()
  {
    return (this.m_sdkHandle != null) && (this.m_sdkHandle.length() > 0);
  }
  
  public int postMessage(BDSMessage paramBDSMessage)
  {
    return Post(paramBDSMessage, this.m_sdkHandle);
  }
  
  public void release()
  {
    if (instanceInitialized()) {
      ReleaseInstance(this.m_sdkHandle);
    }
    removeInstance(this.m_sdkHandle);
  }
  
  public void setListener(BDSSDKLoader.BDSCoreEventListener paramBDSCoreEventListener)
  {
    this.m_observer = new WeakReference(paramBDSCoreEventListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/core/BDSCoreJniInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */