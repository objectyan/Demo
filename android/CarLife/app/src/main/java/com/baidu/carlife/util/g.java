package com.baidu.carlife.util;

import java.io.UnsupportedEncodingException;

public class g
{
  static final int a = 7;
  static final int b = 12;
  static final int c = 17;
  static final int d = 22;
  static final int e = 5;
  static final int f = 9;
  static final int g = 14;
  static final int h = 20;
  static final int i = 4;
  static final int j = 11;
  static final int k = 16;
  static final int l = 23;
  static final int m = 6;
  static final int n = 10;
  static final int o = 15;
  static final int p = 21;
  static final byte[] q = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  public String r;
  private long[] s = new long[4];
  private long[] t = new long[2];
  private byte[] u = new byte[64];
  private byte[] v = new byte[16];
  
  public g()
  {
    b();
  }
  
  public static long a(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte & 0xFF;
    }
    return paramByte;
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong2 | (0xFFFFFFFFFFFFFFFF ^ paramLong1) & paramLong3;
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 += a(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7;
    return ((int)paramLong1 << (int)paramLong6 | (int)paramLong1 >>> (int)(32L - paramLong6)) + paramLong2;
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 0;
    while (i1 < paramInt3)
    {
      paramArrayOfByte1[(paramInt1 + i1)] = paramArrayOfByte2[(paramInt2 + i1)];
      i1 += 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i2 = 0;
    int i1 = 0;
    while (i1 < paramInt)
    {
      paramArrayOfByte[i1] = ((byte)(int)(paramArrayOfLong[i2] & 0xFF));
      paramArrayOfByte[(i1 + 1)] = ((byte)(int)(paramArrayOfLong[i2] >>> 8 & 0xFF));
      paramArrayOfByte[(i1 + 2)] = ((byte)(int)(paramArrayOfLong[i2] >>> 16 & 0xFF));
      paramArrayOfByte[(i1 + 3)] = ((byte)(int)(paramArrayOfLong[i2] >>> 24 & 0xFF));
      i2 += 1;
      i1 += 4;
    }
  }
  
  private void a(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i2 = 0;
    int i1 = 0;
    while (i1 < paramInt)
    {
      paramArrayOfLong[i2] = (a(paramArrayOfByte[i1]) | a(paramArrayOfByte[(i1 + 1)]) << 8 | a(paramArrayOfByte[(i1 + 2)]) << 16 | a(paramArrayOfByte[(i1 + 3)]) << 24);
      i2 += 1;
      i1 += 4;
    }
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
    return new g().a(paramString);
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | (0xFFFFFFFFFFFFFFFF ^ paramLong3) & paramLong2;
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 += b(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7;
    return ((int)paramLong1 << (int)paramLong6 | (int)paramLong1 >>> (int)(32L - paramLong6)) + paramLong2;
  }
  
  public static String b(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >>> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static String b(String paramString)
  {
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        int i1;
        paramString = paramString.getBytes();
      }
    }
    arrayOfByte = new g().a(paramString);
    paramString = "";
    i1 = 0;
    while (i1 < 16)
    {
      paramString = paramString + b(arrayOfByte[i1]);
      i1 += 1;
    }
    return paramString;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    return new g().a(paramArrayOfByte);
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 += c(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7;
    return ((int)paramLong1 << (int)paramLong6 | (int)paramLong1 >>> (int)(32L - paramLong6)) + paramLong2;
  }
  
  public static String c(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 97;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 98;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 99;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 100;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 101;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 102;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >>> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static String c(String paramString)
  {
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        int i1;
        paramString = paramString.getBytes();
      }
    }
    arrayOfByte = new g().a(paramString);
    paramString = "";
    i1 = 0;
    while (i1 < 16)
    {
      paramString = paramString + c(arrayOfByte[i1]);
      i1 += 1;
    }
    return paramString;
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new g().a(paramArrayOfByte);
    paramArrayOfByte = "";
    int i1 = 0;
    while (i1 < 16)
    {
      paramArrayOfByte = paramArrayOfByte + b(arrayOfByte[i1]);
      i1 += 1;
    }
    return paramArrayOfByte;
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3)
  {
    return (0xFFFFFFFFFFFFFFFF ^ paramLong3 | paramLong1) ^ paramLong2;
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 += d(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7;
    return ((int)paramLong1 << (int)paramLong6 | (int)paramLong1 >>> (int)(32L - paramLong6)) + paramLong2;
  }
  
  private void d(byte[] paramArrayOfByte)
  {
    long l2 = this.s[0];
    long l1 = this.s[1];
    long l4 = this.s[2];
    long l3 = this.s[3];
    long[] arrayOfLong = new long[16];
    a(arrayOfLong, paramArrayOfByte, 64);
    l2 = a(l2, l1, l4, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[1], 12L, 3905402710L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[3], 22L, 3250441966L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[5], 12L, 1200080426L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[7], 22L, 4249261313L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[9], 12L, 2336552879L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[11], 22L, 2304563134L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[13], 12L, 4254626195L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[15], 22L, 1236535329L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[6], 9L, 3225465664L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[0], 20L, 3921069994L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[10], 9L, 38016083L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[4], 20L, 3889429448L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[14], 9L, 3275163606L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[8], 20L, 1163531501L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[2], 9L, 4243563512L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[12], 20L, 2368359562L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[8], 11L, 2272392833L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[14], 23L, 4259657740L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[4], 11L, 1272893353L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[10], 23L, 3200236656L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[0], 11L, 3936430074L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[6], 23L, 76029189L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[12], 11L, 3873151461L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[2], 23L, 3299628645L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[7], 10L, 1126891415L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[5], 21L, 4237533241L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[3], 10L, 2399980690L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[1], 21L, 2240044497L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[15], 10L, 4264355552L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[13], 21L, 1309151649L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[11], 10L, 3174756917L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.s;
    paramArrayOfByte[0] += l2;
    paramArrayOfByte = this.s;
    paramArrayOfByte[1] += l1;
    paramArrayOfByte = this.s;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte = this.s;
    paramArrayOfByte[3] += l3;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    int i1 = (int)(this.t[0] >>> 3) & 0x3F;
    long[] arrayOfLong = this.t;
    long l1 = arrayOfLong[0] + (paramInt << 3);
    arrayOfLong[0] = l1;
    if (l1 < paramInt << 3)
    {
      arrayOfLong = this.t;
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.t;
    arrayOfLong[1] += (paramInt >>> 29);
    int i2 = 64 - i1;
    if (paramInt >= i2)
    {
      a(this.u, paramArrayOfByte, i1, 0, i2);
      d(this.u);
      i1 = i2;
      while (i1 + 63 < paramInt)
      {
        a(arrayOfByte, paramArrayOfByte, 0, i1, 64);
        d(arrayOfByte);
        i1 += 64;
      }
      int i3 = 0;
      i2 = i1;
      i1 = i3;
    }
    for (;;)
    {
      a(this.u, paramArrayOfByte, i1, i2, paramInt - i2);
      return;
      i2 = 0;
    }
  }
  
  public byte[] a()
  {
    return this.v;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    b();
    a(paramArrayOfByte, paramArrayOfByte.length);
    c();
    return this.v;
  }
  
  public void b()
  {
    this.t[0] = 0L;
    this.t[1] = 0L;
    this.s[0] = 1732584193L;
    this.s[1] = 4023233417L;
    this.s[2] = 2562383102L;
    this.s[3] = 271733878L;
  }
  
  public void c()
  {
    byte[] arrayOfByte = new byte[8];
    a(arrayOfByte, this.t, 8);
    int i1 = (int)(this.t[0] >>> 3) & 0x3F;
    if (i1 < 56) {}
    for (i1 = 56 - i1;; i1 = 120 - i1)
    {
      a(q, i1);
      a(arrayOfByte, 8);
      a(this.v, this.s, 16);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */