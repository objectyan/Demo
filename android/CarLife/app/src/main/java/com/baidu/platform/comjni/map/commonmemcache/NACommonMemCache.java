package com.baidu.platform.comjni.map.commonmemcache;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comjni.c;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class NACommonMemCache
  extends c
{
  public NACommonMemCache()
  {
    create();
  }
  
  private static native long nativeCreate();
  
  private static native String nativeDecodeUsync(long paramLong, String paramString);
  
  private static native String nativeEnCrypt(long paramLong, String paramString);
  
  private static native String nativeEnCryptWithType(long paramLong, String paramString1, String paramString2);
  
  private static native String nativeEnCryptWithUsync(long paramLong, String paramString);
  
  private static native String nativeGetPhoneInfoBundle(long paramLong, boolean paramBoolean);
  
  private static native String nativeGetPhoneInfoUrl(long paramLong);
  
  private static native String nativeGetSataInfo(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2);
  
  private static native void nativeInit(long paramLong, String paramString);
  
  private static native int nativeRelease(long paramLong);
  
  private static native void nativeSetKeyBundle(long paramLong, String paramString1, String paramString2);
  
  private static native void nativeSetKeyDouble(long paramLong, String paramString, double paramDouble);
  
  private static native void nativeSetKeyFloat(long paramLong, String paramString, float paramFloat);
  
  private static native void nativeSetKeyInt(long paramLong, String paramString, int paramInt);
  
  private static native void nativeSetKeyString(long paramLong, String paramString1, String paramString2);
  
  public long create()
  {
    this.mNativePointer = nativeCreate();
    return this.mNativePointer;
  }
  
  public String decodeUsync(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return nativeDecodeUsync(this.mNativePointer, paramString);
    }
    return "";
  }
  
  public int dispose()
  {
    int i = 0;
    if (this.mNativePointer != 0L)
    {
      i = nativeRelease(this.mNativePointer);
      this.mNativePointer = 0L;
    }
    return i;
  }
  
  public String enCrypt(String paramString)
  {
    return nativeEnCrypt(this.mNativePointer, paramString);
  }
  
  public String enCrypt(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "bduid";
    }
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return nativeEnCryptWithType(this.mNativePointer, paramString1, "bduid");
        if (str.equals("bduid"))
        {
          i = 0;
          continue;
          if (str.equals("sinan"))
          {
            i = 1;
            continue;
            if (str.equals("usync")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return nativeEnCryptWithType(this.mNativePointer, paramString1, str);
    return nativeEnCryptWithUsync(this.mNativePointer, paramString1);
  }
  
  public Bundle getPhoneInfoBundle(boolean paramBoolean)
  {
    Object localObject = nativeGetPhoneInfoBundle(this.mNativePointer, paramBoolean);
    localBundle = new Bundle();
    if ((localObject != null) && (!((String)localObject).isEmpty())) {
      try
      {
        localObject = new JSONObject((String)localObject);
        Iterator localIterator = ((JSONObject)localObject).keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if ((!paramBoolean) && ("bduid".equals(str1)))
          {
            String str2 = ((JSONObject)localObject).optString(str1);
            if (!TextUtils.isEmpty(str2)) {
              localBundle.putString(str1, enCrypt(str2, "bduid"));
            } else {
              localBundle.putString(str1, ((JSONObject)localObject).optString(str1));
            }
          }
          else
          {
            localBundle.putString(str1, ((JSONObject)localObject).optString(str1));
          }
        }
        return localBundle;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  public String getPhoneInfoUrl()
  {
    return nativeGetPhoneInfoUrl(this.mNativePointer);
  }
  
  public String getSataInfo(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return nativeGetSataInfo(this.mNativePointer, paramBoolean, paramInt1, paramInt2);
  }
  
  public void init(String paramString)
  {
    nativeInit(this.mNativePointer, paramString);
  }
  
  public void setKey(String paramString, double paramDouble)
  {
    nativeSetKeyDouble(this.mNativePointer, paramString, paramDouble);
  }
  
  public void setKey(String paramString, float paramFloat)
  {
    nativeSetKeyFloat(this.mNativePointer, paramString, paramFloat);
  }
  
  public void setKey(String paramString, int paramInt)
  {
    nativeSetKeyInt(this.mNativePointer, paramString, paramInt);
  }
  
  public void setKey(String paramString1, String paramString2)
  {
    nativeSetKeyString(this.mNativePointer, paramString1, paramString2);
  }
  
  public void setKeyJSON(String paramString1, String paramString2)
  {
    nativeSetKeyBundle(this.mNativePointer, paramString1, paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/map/commonmemcache/NACommonMemCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */