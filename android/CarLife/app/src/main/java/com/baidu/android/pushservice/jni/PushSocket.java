package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.h;

public class PushSocket
{
  public static boolean a;
  private static byte[] b = null;
  private static int c = 0;
  private static String d = "PushSocket";
  private static int e = 36;
  private static int f = 32;
  
  static
  {
    a = false;
    try
    {
      System.loadLibrary("bdpush_V2_9");
      a = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static short a(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(paramArrayOfByte[(paramInt + 1)] << 8 | paramArrayOfByte[(paramInt + 0)] & 0xFF);
  }
  
  public static void a(int paramInt)
  {
    b = null;
    c = 0;
    closeSocket(paramInt);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!a) {}
    try
    {
      System.loadLibrary("bdpush_V2_9");
      a = true;
      return a;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      for (;;)
      {
        Log.e("BDPushSDK-" + d, "Native library not found! Please copy libbdpush_V2_9.so into your project!");
      }
    }
  }
  
  public static byte[] a(Context paramContext, int paramInt)
  {
    Object localObject2 = null;
    do
    {
      while (b != null)
      {
        int i = b.length;
        if (i == c)
        {
          b = null;
          c = 0;
        }
        else if (i - c > 1)
        {
          int j = a(b, c);
          Object localObject1;
          if ((j == h.f.a()) || (j == h.g.a()))
          {
            localObject1 = new byte[2];
            System.arraycopy(b, c, localObject1, 0, localObject1.length);
            if (j == h.g.a()) {
              p.b("MSG_ID_TINY_HEARTBEAT_SERVER", paramContext);
            }
            c += 2;
          }
          do
          {
            return (byte[])localObject1;
            if (i - c >= e) {
              break;
            }
            localObject1 = localObject2;
          } while (!b(paramInt));
          j = b(b, c + f);
          if (c + j + e <= i - c)
          {
            paramContext = new byte[e + j];
            System.arraycopy(b, c, paramContext, 0, paramContext.length);
            c += j + e;
            return paramContext;
          }
          if (!b(paramInt)) {
            return null;
          }
        }
        else if (!b(paramInt))
        {
          return null;
        }
      }
    } while (b(paramInt));
    return null;
  }
  
  public static int b(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0;
  }
  
  private static boolean b(int paramInt)
  {
    byte[] arrayOfByte1 = rcvMsg(paramInt);
    if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0)) {
      return false;
    }
    if (b == null) {}
    byte[] arrayOfByte2;
    for (b = arrayOfByte1;; b = arrayOfByte2)
    {
      return true;
      arrayOfByte2 = new byte[b.length + arrayOfByte1.length];
      System.arraycopy(b, c, arrayOfByte2, 0, b.length - c);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, b.length, arrayOfByte1.length);
    }
  }
  
  public static native int closeSocket(int paramInt);
  
  public static native int createSocket(String paramString, int paramInt);
  
  public static native int getLastSocketError();
  
  private static native byte[] rcvMsg(int paramInt);
  
  public static native int sendMsg(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/jni/PushSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */