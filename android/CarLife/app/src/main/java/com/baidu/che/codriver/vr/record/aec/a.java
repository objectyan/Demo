package com.baidu.che.codriver.vr.record.aec;

import com.baidu.che.codriver.util.h;
import com.baidu.speech.easr.easrNativeJni;

public class a
{
  public static final int a = 2560;
  private static final String b = "AecUtils";
  private static short[] c;
  private static short[] d;
  private static short[] e;
  
  public static void a()
  {
    if (easrNativeJni.AECInit() != 0) {
      throw new UnsupportedOperationException("AEC init failed!");
    }
    c = new short['Ԁ'];
    d = new short['Ԁ'];
    e = new short['Ԁ'];
  }
  
  public static void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (!a(paramArrayOfByte1, d))
    {
      h.e("AecUtils", "MicData.length != AEC_ENGINE_REQUIRE_SIZE");
      return;
    }
    if (!a(paramArrayOfByte2, c))
    {
      h.e("AecUtils", "SpkData.length != AEC_ENGINE_REQUIRE_SIZE");
      return;
    }
    if (easrNativeJni.AECProcess(d, c, e, e.length) < 0) {
      h.e("AecUtils", "---AEC error!!!--");
    }
    a(e, paramArrayOfByte3);
  }
  
  private static void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < paramArrayOfShort.length * 2) {
      h.e("AecUtils", "---shortArrayToByteArraySmallEnd error!!!--");
    }
    for (;;)
    {
      return;
      int j = paramArrayOfShort.length;
      int i = 0;
      while (i < j)
      {
        int k = (short)(paramArrayOfShort[i] & 0xFF00);
        paramArrayOfByte[(i * 2)] = ((byte)((short)(paramArrayOfShort[i] & 0xFF) & 0xFF));
        paramArrayOfByte[(i * 2 + 1)] = ((byte)(k >> 8 & 0xFF));
        i += 1;
      }
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    int j = paramArrayOfByte.length / 2;
    if (paramArrayOfShort.length != j) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      int k = (short)(paramArrayOfByte[(i * 2)] & 0xFF);
      paramArrayOfShort[i] = ((short)((short)(paramArrayOfByte[(i * 2 + 1)] & 0xFF) << 8 | k));
      i += 1;
    }
    return true;
  }
  
  private static byte[] a(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    byte[] arrayOfByte = new byte[j * 2];
    int i = 0;
    while (i < j)
    {
      int k = (short)(paramArrayOfShort[i] & 0xFF00);
      arrayOfByte[(i * 2)] = ((byte)((short)(paramArrayOfShort[i] & 0xFF) & 0xFF));
      arrayOfByte[(i * 2 + 1)] = ((byte)(k >> 8 & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static void b()
  {
    easrNativeJni.AECExit();
  }
  
  public static int c()
  {
    return easrNativeJni.AECGetVolume();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/record/aec/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */