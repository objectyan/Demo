package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class b
{
  final ByteBuffer a;
  
  private b(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
    this.a.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private b(byte[] paramArrayOfByte, int paramInt)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, 0, paramInt));
  }
  
  static int a(int paramInt1, int paramInt2, Object paramObject)
  {
    long l;
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("Unknown type: " + paramInt2);
    case 8: 
      ((Boolean)paramObject).booleanValue();
      return d(paramInt1) + 1;
    case 12: 
      return b(paramInt1, (byte[])paramObject);
    case 9: 
      return b(paramInt1, (String)paramObject);
    case 2: 
      ((Float)paramObject).floatValue();
      return d(paramInt1) + 4;
    case 1: 
      ((Double)paramObject).doubleValue();
      return d(paramInt1) + 8;
    case 14: 
      return f(paramInt1, ((Integer)paramObject).intValue());
    case 7: 
      ((Integer)paramObject).intValue();
      return d(paramInt1) + 4;
    case 5: 
      return d(paramInt1, ((Integer)paramObject).intValue());
    case 13: 
      return e(paramInt1, ((Integer)paramObject).intValue());
    case 17: 
      paramInt2 = ((Integer)paramObject).intValue();
      paramInt1 = d(paramInt1);
      return f(g(paramInt2)) + paramInt1;
    case 15: 
      ((Integer)paramObject).intValue();
      return d(paramInt1) + 4;
    case 3: 
      l = ((Long)paramObject).longValue();
      paramInt1 = d(paramInt1);
      return b(l) + paramInt1;
    case 4: 
      return b(paramInt1, ((Long)paramObject).longValue());
    case 18: 
      l = ((Long)paramObject).longValue();
      paramInt1 = d(paramInt1);
      return b(d(l)) + paramInt1;
    case 6: 
      ((Long)paramObject).longValue();
      return d(paramInt1) + 8;
    case 16: 
      ((Long)paramObject).longValue();
      return d(paramInt1) + 8;
    case 11: 
      return c(paramInt1, (m)paramObject);
    }
    return b(paramInt1, (m)paramObject);
  }
  
  private static int a(CharSequence paramCharSequence)
  {
    int k = 0;
    int n = paramCharSequence.length();
    int j = 0;
    while ((j < n) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    for (;;)
    {
      int i;
      if (j < n)
      {
        int m = paramCharSequence.charAt(j);
        if (m < 2048)
        {
          i += (127 - m >>> 31);
          j += 1;
        }
        else
        {
          int i2 = paramCharSequence.length();
          if (j < i2)
          {
            int i3 = paramCharSequence.charAt(j);
            if (i3 < 2048)
            {
              k += (127 - i3 >>> 31);
              m = j;
            }
            for (;;)
            {
              j = m + 1;
              break;
              int i1 = k + 2;
              k = i1;
              m = j;
              if (55296 <= i3)
              {
                k = i1;
                m = j;
                if (i3 <= 57343)
                {
                  if (Character.codePointAt(paramCharSequence, j) < 65536) {
                    throw new IllegalArgumentException("Unpaired surrogate at index " + j);
                  }
                  m = j + 1;
                  k = i1;
                }
              }
            }
          }
          i = k + i;
        }
      }
      else
      {
        for (;;)
        {
          if (i < n) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i + 4294967296L));
          }
          return i;
        }
        i = n;
      }
    }
  }
  
  private static int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128) {
        break;
      }
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4) {
              break label439;
            }
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c)) {
                j = paramInt2;
              }
            }
            else
            {
              throw new IllegalArgumentException("Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label439:
      throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return f(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static b a(byte[] paramArrayOfByte, int paramInt)
  {
    return new b(paramArrayOfByte, paramInt);
  }
  
  private void a(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        h((int)paramLong);
        return;
      }
      h((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static void a(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (paramByteBuffer.hasArray()) {
      try
      {
        paramByteBuffer.position(a(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    }
    b(paramCharSequence, paramByteBuffer);
  }
  
  public static int b(int paramInt, long paramLong)
  {
    return d(paramInt) + b(paramLong);
  }
  
  public static int b(int paramInt, m paramm)
  {
    return d(paramInt) * 2 + paramm.c();
  }
  
  public static int b(int paramInt, String paramString)
  {
    paramInt = d(paramInt);
    int i = a(paramString);
    return paramInt + (i + f(i));
  }
  
  public static int b(int paramInt, byte[] paramArrayOfByte)
  {
    return d(paramInt) + a(paramArrayOfByte);
  }
  
  private static int b(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((0x8000000000000000 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  private static void b(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128) {
        paramByteBuffer.put((byte)i);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c)) {
              k = j;
            }
          }
          else
          {
            throw new IllegalArgumentException("Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static int c(int paramInt)
  {
    if (paramInt >= 0) {
      return f(paramInt);
    }
    return 10;
  }
  
  public static int c(int paramInt, m paramm)
  {
    paramInt = d(paramInt);
    int i = paramm.c();
    return paramInt + (i + f(i));
  }
  
  private void c(long paramLong)
    throws IOException
  {
    if (this.a.remaining() < 8) {
      throw new a(this.a.position(), this.a.limit());
    }
    this.a.putLong(paramLong);
  }
  
  public static int d(int paramInt)
  {
    return f(s.a(paramInt, 0));
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    return d(paramInt1) + c(paramInt2);
  }
  
  private static long d(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int e(int paramInt1, int paramInt2)
  {
    return d(paramInt1) + f(paramInt2);
  }
  
  public static int f(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int f(int paramInt1, int paramInt2)
  {
    return d(paramInt1) + f(paramInt2);
  }
  
  public static int g(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  private void h(int paramInt)
    throws IOException
  {
    byte b = (byte)paramInt;
    if (!this.a.hasRemaining()) {
      throw new a(this.a.position(), this.a.limit());
    }
    this.a.put(b);
  }
  
  private void i(int paramInt)
    throws IOException
  {
    if (this.a.remaining() < 4) {
      throw new a(this.a.position(), this.a.limit());
    }
    this.a.putInt(paramInt);
  }
  
  public final void a(double paramDouble)
    throws IOException
  {
    c(Double.doubleToLongBits(paramDouble));
  }
  
  public final void a(float paramFloat)
    throws IOException
  {
    i(Float.floatToIntBits(paramFloat));
  }
  
  public final void a(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      e(paramInt);
      return;
    }
    a(paramInt);
  }
  
  public final void a(int paramInt, double paramDouble)
    throws IOException
  {
    g(paramInt, 1);
    a(paramDouble);
  }
  
  public final void a(int paramInt, float paramFloat)
    throws IOException
  {
    g(paramInt, 5);
    a(paramFloat);
  }
  
  public final void a(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    a(paramInt2);
  }
  
  public final void a(int paramInt, long paramLong)
    throws IOException
  {
    g(paramInt, 0);
    a(paramLong);
  }
  
  public final void a(int paramInt, m paramm)
    throws IOException
  {
    g(paramInt, 2);
    a(paramm);
  }
  
  public final void a(int paramInt, String paramString)
    throws IOException
  {
    g(paramInt, 2);
    int i;
    try
    {
      paramInt = f(paramString.length());
      if (paramInt != f(paramString.length() * 3)) {
        break label156;
      }
      i = this.a.position();
      if (this.a.remaining() < paramInt) {
        throw new a(paramInt + i, this.a.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      a locala = new a(this.a.position(), this.a.limit());
      locala.initCause(paramString);
      throw locala;
    }
    this.a.position(i + paramInt);
    a(paramString, this.a);
    int j = this.a.position();
    this.a.position(i);
    e(j - i - paramInt);
    this.a.position(j);
    return;
    label156:
    e(a(paramString));
    a(paramString, this.a);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    g(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    h(paramInt);
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    g(paramInt, 2);
    e(paramArrayOfByte.length);
    b(paramArrayOfByte);
  }
  
  public final void a(m paramm)
    throws IOException
  {
    if (paramm.c < 0) {
      paramm.c();
    }
    e(paramm.c);
    paramm.a(this);
  }
  
  public final void b(int paramInt)
    throws IOException
  {
    e(g(paramInt));
  }
  
  public final void b(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    e(paramInt2);
  }
  
  final void b(int paramInt1, int paramInt2, Object paramObject)
    throws IOException
  {
    long l;
    switch (paramInt2)
    {
    default: 
      throw new IOException("Unknown type: " + paramInt2);
    case 1: 
      a(paramInt1, ((Double)paramObject).doubleValue());
      return;
    case 2: 
      a(paramInt1, ((Float)paramObject).floatValue());
      return;
    case 3: 
      l = ((Long)paramObject).longValue();
      g(paramInt1, 0);
      a(l);
      return;
    case 4: 
      a(paramInt1, ((Long)paramObject).longValue());
      return;
    case 5: 
      a(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 6: 
      l = ((Long)paramObject).longValue();
      g(paramInt1, 1);
      c(l);
      return;
    case 7: 
      paramInt2 = ((Integer)paramObject).intValue();
      g(paramInt1, 5);
      i(paramInt2);
      return;
    case 8: 
      a(paramInt1, ((Boolean)paramObject).booleanValue());
      return;
    case 9: 
      a(paramInt1, (String)paramObject);
      return;
    case 12: 
      a(paramInt1, (byte[])paramObject);
      return;
    case 13: 
      b(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 14: 
      c(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 15: 
      paramInt2 = ((Integer)paramObject).intValue();
      g(paramInt1, 5);
      i(paramInt2);
      return;
    case 16: 
      l = ((Long)paramObject).longValue();
      g(paramInt1, 1);
      c(l);
      return;
    case 17: 
      paramInt2 = ((Integer)paramObject).intValue();
      g(paramInt1, 0);
      b(paramInt2);
      return;
    case 18: 
      l = ((Long)paramObject).longValue();
      g(paramInt1, 0);
      a(d(l));
      return;
    case 11: 
      a(paramInt1, (m)paramObject);
      return;
    }
    paramObject = (m)paramObject;
    g(paramInt1, 3);
    ((m)paramObject).a(this);
    g(paramInt1, 4);
  }
  
  public final void b(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramArrayOfByte.length;
    if (this.a.remaining() >= i)
    {
      this.a.put(paramArrayOfByte, 0, i);
      return;
    }
    throw new a(this.a.position(), this.a.limit());
  }
  
  public final void c(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    e(paramInt2);
  }
  
  public final void e(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        h(paramInt);
        return;
      }
      h(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void g(int paramInt1, int paramInt2)
    throws IOException
  {
    e(s.a(paramInt1, paramInt2));
  }
  
  public static final class a
    extends IOException
  {
    private static final long serialVersionUID = -6947486886997889499L;
    
    a(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */