package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class aa
  extends InputStream
{
  @VisibleForTesting
  final y a;
  @VisibleForTesting
  int b;
  @VisibleForTesting
  int c;
  
  public aa(y paramy)
  {
    if (!paramy.c()) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      this.a = ((y)k.a(paramy));
      this.b = 0;
      this.c = 0;
      return;
    }
  }
  
  public int available()
  {
    return this.a.a() - this.b;
  }
  
  public void mark(int paramInt)
  {
    this.c = this.b;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (available() <= 0) {
      return -1;
    }
    y localy = this.a;
    int i = this.b;
    this.b = (i + 1);
    return localy.a(i) & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new ArrayIndexOutOfBoundsException("length=" + paramArrayOfByte.length + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    int i = available();
    if (i <= 0) {
      return -1;
    }
    if (paramInt2 <= 0) {
      return 0;
    }
    paramInt2 = Math.min(i, paramInt2);
    this.a.a(this.b, paramArrayOfByte, paramInt1, paramInt2);
    this.b += paramInt2;
    return paramInt2;
  }
  
  public void reset()
  {
    this.b = this.c;
  }
  
  public long skip(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      int i = Math.min((int)paramLong, available());
      this.b += i;
      return i;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */