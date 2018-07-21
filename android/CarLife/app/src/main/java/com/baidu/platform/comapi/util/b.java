package com.baidu.platform.comapi.util;

import java.io.ByteArrayOutputStream;

public class b
{
  static final String[] a = { "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/" };
  
  public static int a(char paramChar, int paramInt)
  {
    char[] arrayOfChar = a[paramInt].toCharArray();
    int i;
    if (paramChar == '=')
    {
      i = 0;
      return i;
    }
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= 64) {
        break label43;
      }
      i = paramInt;
      if (arrayOfChar[paramInt] == paramChar) {
        break;
      }
      paramInt += 1;
    }
    label43:
    throw new RuntimeException("unexpected code: " + paramChar);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, null).toString();
  }
  
  public static StringBuffer a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, StringBuffer paramStringBuffer)
  {
    char[] arrayOfChar = a[0].toCharArray();
    StringBuffer localStringBuffer = paramStringBuffer;
    if (paramStringBuffer == null) {
      localStringBuffer = new StringBuffer(paramArrayOfByte.length * 3 / 2);
    }
    int i = paramInt1;
    while (i <= paramInt2 - 3)
    {
      int j = (paramArrayOfByte[i] & 0xFF) << 16 | (paramArrayOfByte[(i + 1)] & 0xFF) << 8 | paramArrayOfByte[(i + 2)] & 0xFF;
      localStringBuffer.append(arrayOfChar[(j >> 18 & 0x3F)]);
      localStringBuffer.append(arrayOfChar[(j >> 12 & 0x3F)]);
      localStringBuffer.append(arrayOfChar[(j >> 6 & 0x3F)]);
      localStringBuffer.append(arrayOfChar[(j & 0x3F)]);
      i += 3;
    }
    if (i == paramInt1 + paramInt2 - 2)
    {
      paramInt1 = (paramArrayOfByte[i] & 0xFF) << 16 | (paramArrayOfByte[(i + 1)] & 0xFF) << 8;
      localStringBuffer.append(arrayOfChar[(paramInt1 >> 18 & 0x3F)]);
      localStringBuffer.append(arrayOfChar[(paramInt1 >> 12 & 0x3F)]);
      localStringBuffer.append(arrayOfChar[(paramInt1 >> 6 & 0x3F)]);
    }
    while (i != paramInt1 + paramInt2 - 1) {
      return localStringBuffer;
    }
    paramInt1 = (paramArrayOfByte[i] & 0xFF) << 16;
    localStringBuffer.append(arrayOfChar[(paramInt1 >> 18 & 0x3F)]);
    localStringBuffer.append(arrayOfChar[(paramInt1 >> 12 & 0x3F)]);
    return localStringBuffer;
  }
  
  public static void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    int k = 0;
    int m = paramString.length();
    int j = paramString.length() % 4;
    int i = j;
    String str = paramString;
    if (j > 0)
    {
      i = 4 - j;
      str = paramString;
    }
    for (;;)
    {
      j = k;
      if (i <= 0) {
        break;
      }
      str = str + '=';
      i -= 1;
    }
    for (;;)
    {
      if ((j < m) && (str.charAt(j) <= ' '))
      {
        j += 1;
      }
      else
      {
        if (j == m) {}
        do
        {
          do
          {
            return;
            i = (a(str.charAt(j), 0) << 18) + (a(str.charAt(j + 1), 0) << 12) + (a(str.charAt(j + 2), 0) << 6) + a(str.charAt(j + 3), 0);
            paramByteArrayOutputStream.write(i >> 16 & 0xFF);
          } while (str.charAt(j + 2) == '=');
          paramByteArrayOutputStream.write(i >> 8 & 0xFF);
        } while (str.charAt(j + 3) == '=');
        paramByteArrayOutputStream.write(i & 0xFF);
        j += 4;
      }
    }
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 70	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 79	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore_3
    //   10: aload_0
    //   11: ifnonnull +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_2
    //   17: astore_1
    //   18: aload_0
    //   19: aload_3
    //   20: invokestatic 81	com/baidu/platform/comapi/util/b:a	(Ljava/lang/String;Ljava/io/ByteArrayOutputStream;)V
    //   23: aload_2
    //   24: astore_1
    //   25: aload_3
    //   26: invokevirtual 85	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   29: astore_0
    //   30: aload_0
    //   31: astore_1
    //   32: aload_3
    //   33: invokevirtual 88	java/io/ByteArrayOutputStream:close	()V
    //   36: aload_3
    //   37: invokevirtual 88	java/io/ByteArrayOutputStream:close	()V
    //   40: aload_0
    //   41: areturn
    //   42: astore_0
    //   43: aload_3
    //   44: invokevirtual 88	java/io/ByteArrayOutputStream:close	()V
    //   47: aload_1
    //   48: astore_0
    //   49: goto -9 -> 40
    //   52: astore_0
    //   53: aload_1
    //   54: astore_0
    //   55: goto -15 -> 40
    //   58: astore_0
    //   59: aload_3
    //   60: invokevirtual 88	java/io/ByteArrayOutputStream:close	()V
    //   63: aload_0
    //   64: athrow
    //   65: astore_1
    //   66: goto -26 -> 40
    //   69: astore_1
    //   70: goto -7 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramString	String
    //   17	37	1	localObject1	Object
    //   65	1	1	localIOException1	java.io.IOException
    //   69	1	1	localIOException2	java.io.IOException
    //   1	23	2	localObject2	Object
    //   9	51	3	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	23	42	java/lang/Exception
    //   25	30	42	java/lang/Exception
    //   32	36	42	java/lang/Exception
    //   43	47	52	java/io/IOException
    //   18	23	58	finally
    //   25	30	58	finally
    //   32	36	58	finally
    //   36	40	65	java/io/IOException
    //   59	63	69	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    int i = 0;
    if (i < paramString.length())
    {
      if (paramString.charAt(i) == '-') {}
      label61:
      label79:
      label109:
      label114:
      label119:
      label124:
      label127:
      for (;;)
      {
        i += 1;
        break;
        int j;
        if (paramString.charAt(i) <= 'z')
        {
          if (paramString.charAt(i) >= 'a') {
            break label109;
          }
          j = 1;
          if (paramString.charAt(i) <= 'Z') {
            break label114;
          }
          k = 1;
          if ((j & k) == 0)
          {
            if (paramString.charAt(i) >= 'A') {
              break label119;
            }
            j = 1;
            if (paramString.charAt(i) <= '9') {
              break label124;
            }
          }
        }
        for (int k = 1;; k = 0)
        {
          if (((j & k) == 0) && (paramString.charAt(i) >= '0')) {
            break label127;
          }
          return true;
          j = 0;
          break;
          k = 0;
          break label61;
          j = 0;
          break label79;
        }
      }
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */