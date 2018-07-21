package com.baidu.platform.comjni.base.longlink;

import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NALongLink
  extends a
{
  private static Map<Integer, LinkedList<Object>> a = new ConcurrentHashMap();
  
  public static int create()
  {
    return nativeCreate();
  }
  
  public static boolean init(int paramInt, String paramString1, String paramString2)
  {
    return nativeInit(paramInt, paramString1, paramString2);
  }
  
  private static native int nativeCreate();
  
  private static native boolean nativeInit(int paramInt, String paramString1, String paramString2);
  
  private static native boolean nativeRegister(int paramInt1, int paramInt2);
  
  private static native int nativeRelease(int paramInt);
  
  private static native int nativeSendData(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  private static native int nativeSendFileData(int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<LongLinkFileData> paramArrayList);
  
  private static native boolean nativeStart(int paramInt);
  
  private static native boolean nativeStop(int paramInt);
  
  private static native boolean nativeUnRegister(int paramInt1, int paramInt2);
  
  public static boolean onJNILongLinkDataCallback(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    f.e("JNILongLink", "onJNILongLinkDataCallback:" + paramInt1 + " status:" + paramInt2 + " reqId:" + paramInt3 + " isPush:" + paramBoolean);
    byte[] arrayOfByte = paramArrayOfByte;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = (LinkedList)a.get(Integer.valueOf(paramInt1));
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new LinkedList(paramArrayOfByte).iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject = paramArrayOfByte.next();
        if ((localObject instanceof LongLinkDataCallback))
        {
          ELongLinkStatus localELongLinkStatus = ELongLinkStatus.values()[paramInt2];
          localELongLinkStatus.setRequestId(paramInt3);
          ((LongLinkDataCallback)localObject).onReceiveData(localELongLinkStatus, paramInt3, arrayOfByte, paramBoolean);
        }
      }
    }
    return true;
  }
  
  public static boolean register(int paramInt1, int paramInt2, Object paramObject)
  {
    LinkedList localLinkedList = (LinkedList)a.get(Integer.valueOf(paramInt2));
    if (localLinkedList == null)
    {
      localLinkedList = new LinkedList();
      localLinkedList.add(paramObject);
      a.put(Integer.valueOf(paramInt2), localLinkedList);
      return nativeRegister(paramInt1, paramInt2);
    }
    if (!localLinkedList.contains(paramObject))
    {
      localLinkedList.add(paramObject);
      a.put(Integer.valueOf(paramInt2), localLinkedList);
    }
    return true;
  }
  
  public static int release(int paramInt)
  {
    return nativeRelease(paramInt);
  }
  
  public static int sendData(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    return nativeSendData(paramInt1, paramInt2, paramInt3, paramArrayOfByte);
  }
  
  public static int sendFileData(int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<LongLinkFileData> paramArrayList)
  {
    return nativeSendFileData(paramInt1, paramInt2, paramInt3, paramString, paramArrayList);
  }
  
  public static boolean start(int paramInt)
  {
    return nativeStart(paramInt);
  }
  
  public static boolean stop(int paramInt)
  {
    return nativeStop(paramInt);
  }
  
  public static boolean unRegister(int paramInt1, int paramInt2, Object paramObject)
  {
    LinkedList localLinkedList = (LinkedList)a.get(Integer.valueOf(paramInt2));
    if (localLinkedList != null)
    {
      if (paramObject != null) {
        localLinkedList.remove(paramObject);
      }
      if (localLinkedList.isEmpty())
      {
        a.remove(Integer.valueOf(paramInt2));
        return nativeUnRegister(paramInt1, paramInt2);
      }
      return true;
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/base/longlink/NALongLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */