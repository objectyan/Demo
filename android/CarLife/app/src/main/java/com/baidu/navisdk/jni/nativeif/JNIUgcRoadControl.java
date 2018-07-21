package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import java.util.ArrayList;

public class JNIUgcRoadControl
{
  public static JNIUgcRoadControl sInstance = new JNIUgcRoadControl();
  
  public native boolean add(int paramInt);
  
  public native boolean addLinkItemInGuide(int paramInt);
  
  public native boolean addLinkItemInGuideEnd(int paramInt1, int paramInt2);
  
  public native boolean batchRemove(ArrayList<String> paramArrayList, int paramInt);
  
  public native boolean getAllItems(ArrayList<Bundle> paramArrayList, int paramInt);
  
  public native String getCurSelectLinkName();
  
  public native int getCurSelectYawPointIdx();
  
  public native boolean getCurYawPoint(ArrayList<Bundle> paramArrayList, int paramInt);
  
  public native boolean login(String paramString);
  
  public native boolean modify(String paramString, int paramInt);
  
  public native boolean remove(String paramString);
  
  public native boolean selectLink(int paramInt1, int paramInt2);
  
  public native boolean setCurSelectYawPointIdx(int paramInt);
  
  public native boolean submitAddUGCInGuideEnd();
  
  public native boolean syncData();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNIUgcRoadControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */