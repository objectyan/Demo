package cz.msebera.android.httpclient.o;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.Serializable;

@NotThreadSafe
public final class c
  implements Serializable
{
  private static final long a = 4359112959524048036L;
  private byte[] b;
  private int c;
  
  public c(int paramInt)
  {
    a.b(paramInt, "Buffer capacity");
    this.b = new byte[paramInt];
  }
  
  private void e(int paramInt)
  {
    byte[] arrayOfByte = new byte[Math.max(this.b.length << 1, paramInt)];
    System.arraycopy(this.b, 0, arrayOfByte, 0, this.c);
    this.b = arrayOfByte;
  }
  
  public int a(byte paramByte)
  {
    return a(paramByte, 0, this.c);
  }
  
  public int a(byte paramByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    paramInt1 = i;
    if (i < 0) {
      paramInt1 = 0;
    }
    i = paramInt2;
    paramInt2 = i;
    if (i > this.c) {
      paramInt2 = this.c;
    }
    if (paramInt1 > paramInt2)
    {
      i = -1;
      return i;
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        break label69;
      }
      i = paramInt1;
      if (this.b[paramInt1] == paramByte) {
        break;
      }
      paramInt1 += 1;
    }
    label69:
    return -1;
  }
  
  public void a()
  {
    this.c = 0;
  }
  
  public void a(int paramInt)
  {
    int i = this.c + 1;
    if (i > this.b.length) {
      e(i);
    }
    this.b[this.c] = ((byte)paramInt);
    this.c = i;
  }
  
  public void a(d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null) {
      return;
    }
    a(paramd.c(), paramInt1, paramInt2);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
        throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfByte.length);
      }
    } while (paramInt2 == 0);
    int i = this.c + paramInt2;
    if (i > this.b.length) {
      e(i);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.b, this.c, paramInt2);
    this.c = i;
  }
  
  public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null) {}
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
        throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfChar.length);
      }
    } while (paramInt2 == 0);
    int i = this.c;
    int j = i + paramInt2;
    if (j > this.b.length) {
      e(j);
    }
    paramInt2 = i;
    while (paramInt2 < j)
    {
      this.b[paramInt2] = ((byte)paramArrayOfChar[paramInt1]);
      paramInt1 += 1;
      paramInt2 += 1;
    }
    this.c = j;
  }
  
  public int b(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public byte[] b()
  {
    byte[] arrayOfByte = new byte[this.c];
    if (this.c > 0) {
      System.arraycopy(this.b, 0, arrayOfByte, 0, this.c);
    }
    return arrayOfByte;
  }
  
  public int c()
  {
    return this.b.length;
  }
  
  public void c(int paramInt)
  {
    if (paramInt <= 0) {}
    while (paramInt <= this.b.length - this.c) {
      return;
    }
    e(this.c + paramInt);
  }
  
  public int d()
  {
    return this.c;
  }
  
  public void d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.b.length)) {
      throw new IndexOutOfBoundsException("len: " + paramInt + " < 0 or > buffer len: " + this.b.length);
    }
    this.c = paramInt;
  }
  
  public byte[] e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    return this.c == 0;
  }
  
  public boolean g()
  {
    return this.c == this.b.length;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/o/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */