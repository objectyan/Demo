package com.baidu.navisdk.jni.nativeif;

public class JNINaviManager
{
  public static JNINaviManager sInstance = new JNINaviManager();
  
  public native String getIPByHost(String paramString);
  
  public native String getInitLogPath(int paramInt);
  
  public native int initNaviManager(Object paramObject);
  
  public native void initNaviStatistics(int paramInt);
  
  public native int initSubSystem(int paramInt);
  
  public native int reInitSearchEngine(int paramInt, Object paramObject);
  
  public native int reloadNaviManager(int paramInt, String paramString);
  
  public native int uninitNaviManager();
  
  public native void uninitNaviStatistics();
  
  public native void uninitSubSystem(int paramInt);
  
  public native int updateAppSource(int paramInt);
  
  public static abstract interface LogPathType
  {
    public static final int INIT_LOG = 0;
    public static final int RP_LOG = 1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNINaviManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */