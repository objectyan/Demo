package b.a.j;

import okio.ByteString;

public final class b
{
  static final String a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  static final int b = 128;
  static final int c = 64;
  static final int d = 32;
  static final int e = 16;
  static final int f = 15;
  static final int g = 8;
  static final int h = 128;
  static final int i = 127;
  static final int j = 0;
  static final int k = 1;
  static final int l = 2;
  static final int m = 8;
  static final int n = 9;
  static final int o = 10;
  static final long p = 125L;
  static final long q = 123L;
  static final int r = 126;
  static final long s = 65535L;
  static final int t = 127;
  static final int u = 1001;
  static final int v = 1002;
  static final int w = 1005;
  static final int x = 1006;
  
  private b()
  {
    throw new AssertionError("No instances.");
  }
  
  static String a(int paramInt)
  {
    if ((paramInt < 1000) || (paramInt >= 5000)) {
      return "Code must be in range [1000,5000): " + paramInt;
    }
    if (((paramInt >= 1004) && (paramInt <= 1006)) || ((paramInt >= 1012) && (paramInt <= 2999))) {
      return "Code " + paramInt + " is reserved and may not be used.";
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return ByteString.encodeUtf8(paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
  }
  
  static void a(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2)
  {
    int i2 = paramArrayOfByte2.length;
    int i1 = 0;
    while (i1 < paramLong1)
    {
      int i3 = (int)(paramLong2 % i2);
      paramArrayOfByte1[i1] = ((byte)(paramArrayOfByte1[i1] ^ paramArrayOfByte2[i3]));
      i1 += 1;
      paramLong2 += 1L;
    }
  }
  
  static void b(int paramInt)
  {
    String str = a(paramInt);
    if (str != null) {
      throw new IllegalArgumentException(str);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/j/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */