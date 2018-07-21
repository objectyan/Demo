package com.baidu.tts.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class CommonUtility
{
  private static int[] a(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[paramArrayOfByte.length];
    int i = 0;
    int k = 1;
    while (k < paramArrayOfByte.length)
    {
      for (int j = i; (j > 0) && (paramArrayOfByte[j] != paramArrayOfByte[k]); j = arrayOfInt[(j - 1)]) {}
      i = j;
      if (paramArrayOfByte[j] == paramArrayOfByte[k]) {
        i = j + 1;
      }
      arrayOfInt[k] = i;
      k += 1;
    }
    return arrayOfInt;
  }
  
  public static byte[] addCAFHeaderForPCMData(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    long l1 = paramArrayOfByte.length;
    long l2 = 44L + l1;
    long l3 = 16L * l2 * 1 / 8L;
    byte[] arrayOfByte1 = new byte[44];
    arrayOfByte1[0] = 82;
    arrayOfByte1[1] = 73;
    arrayOfByte1[2] = 70;
    arrayOfByte1[3] = 70;
    arrayOfByte1[4] = ((byte)(int)(0xFF & l2));
    arrayOfByte1[5] = ((byte)(int)(l2 >> 8 & 0xFF));
    arrayOfByte1[6] = ((byte)(int)(l2 >> 16 & 0xFF));
    arrayOfByte1[7] = ((byte)(int)(l2 >> 24 & 0xFF));
    arrayOfByte1[8] = 87;
    arrayOfByte1[9] = 65;
    arrayOfByte1[10] = 86;
    arrayOfByte1[11] = 69;
    arrayOfByte1[12] = 102;
    arrayOfByte1[13] = 109;
    arrayOfByte1[14] = 116;
    arrayOfByte1[15] = 32;
    arrayOfByte1[16] = 16;
    arrayOfByte1[17] = 0;
    arrayOfByte1[18] = 0;
    arrayOfByte1[19] = 0;
    arrayOfByte1[20] = 1;
    arrayOfByte1[21] = 0;
    arrayOfByte1[22] = ((byte)1);
    arrayOfByte1[23] = 0;
    arrayOfByte1[24] = ((byte)(int)(0xFF & 0x3E80));
    arrayOfByte1[25] = ((byte)(int)(16000L >> 8 & 0xFF));
    arrayOfByte1[26] = ((byte)(int)(16000L >> 16 & 0xFF));
    arrayOfByte1[27] = ((byte)(int)(16000L >> 24 & 0xFF));
    arrayOfByte1[28] = ((byte)(int)(0xFF & l3));
    arrayOfByte1[29] = ((byte)(int)(l3 >> 8 & 0xFF));
    arrayOfByte1[30] = ((byte)(int)(l3 >> 16 & 0xFF));
    arrayOfByte1[31] = ((byte)(int)(l3 >> 24 & 0xFF));
    arrayOfByte1[32] = 2;
    arrayOfByte1[33] = 0;
    arrayOfByte1[34] = 16;
    arrayOfByte1[35] = 0;
    arrayOfByte1[36] = 100;
    arrayOfByte1[37] = 97;
    arrayOfByte1[38] = 116;
    arrayOfByte1[39] = 97;
    arrayOfByte1[40] = ((byte)(int)(0xFF & l1));
    arrayOfByte1[41] = ((byte)(int)(l1 >> 8 & 0xFF));
    arrayOfByte1[42] = ((byte)(int)(l1 >> 16 & 0xFF));
    arrayOfByte1[43] = ((byte)(int)(l1 >> 24 & 0xFF));
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    return arrayOfByte2;
  }
  
  public static byte[] copyBytesOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 > paramInt2) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length))
    {
      localObject = null;
      return (byte[])localObject;
    }
    byte[] arrayOfByte = new byte[paramInt2 - paramInt1];
    int i = paramInt1;
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= paramInt2) {
        break;
      }
      arrayOfByte[(i - paramInt1)] = paramArrayOfByte[i];
      i += 1;
    }
  }
  
  public static String generateSerialNumber()
  {
    return UUID.randomUUID().toString();
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static int indexOf(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    for (;;)
    {
      int[] arrayOfInt;
      int i;
      int j;
      try
      {
        arrayOfInt = a(paramArrayOfByte2);
        i = 0;
        if (paramArrayOfByte1.length == 0) {
          return -1;
        }
        if (paramInt >= paramArrayOfByte1.length) {
          break label64;
        }
        j = paramInt;
        paramInt = i;
        if (j >= paramArrayOfByte1.length) {
          break label64;
        }
        i = paramInt;
      }
      catch (Exception paramArrayOfByte1) {}
      if (paramInt == paramArrayOfByte2.length)
      {
        paramInt = paramArrayOfByte2.length;
        return j - paramInt + 1;
      }
      j += 1;
      continue;
      label64:
      return -1;
      while ((i > 0) && (paramArrayOfByte2[i] != paramArrayOfByte1[j])) {
        i = arrayOfInt[(i - 1)];
      }
      paramInt = i;
      if (paramArrayOfByte2[i] == paramArrayOfByte1[j]) {
        paramInt = i + 1;
      }
    }
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = getNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    paramContext = getNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1);
  }
  
  public static byte[] shortArrayToByteArray(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfShort.length * 2);
    localByteBuffer.clear();
    localByteBuffer.order(ByteOrder.nativeOrder());
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putShort(i * 2, paramArrayOfShort[i]);
      i += 1;
    }
    return localByteBuffer.array();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/CommonUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */