package cz.msebera.android.httpclient.o;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.n.f;
import java.io.Serializable;

@NotThreadSafe
public final class d
  implements Serializable
{
  private static final long a = -6208952725094867135L;
  private char[] b;
  private int c;
  
  public d(int paramInt)
  {
    a.b(paramInt, "Buffer capacity");
    this.b = new char[paramInt];
  }
  
  private void e(int paramInt)
  {
    char[] arrayOfChar = new char[Math.max(this.b.length << 1, paramInt)];
    System.arraycopy(this.b, 0, arrayOfChar, 0, this.c);
    this.b = arrayOfChar;
  }
  
  public char a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    paramInt2 = i;
    if (i < 0) {
      paramInt2 = 0;
    }
    i = paramInt3;
    paramInt3 = i;
    if (i > this.c) {
      paramInt3 = this.c;
    }
    if (paramInt2 > paramInt3)
    {
      i = -1;
      return i;
    }
    for (;;)
    {
      if (paramInt2 >= paramInt3) {
        break label69;
      }
      i = paramInt2;
      if (this.b[paramInt2] == paramInt1) {
        break;
      }
      paramInt2 += 1;
    }
    label69:
    return -1;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return new String(this.b, paramInt1, paramInt2 - paramInt1);
  }
  
  public void a()
  {
    this.c = 0;
  }
  
  public void a(char paramChar)
  {
    int i = this.c + 1;
    if (i > this.b.length) {
      e(i);
    }
    this.b[this.c] = paramChar;
    this.c = i;
  }
  
  public void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramc == null) {
      return;
    }
    a(paramc.e(), paramInt1, paramInt2);
  }
  
  public void a(d paramd)
  {
    if (paramd == null) {
      return;
    }
    a(paramd.b, 0, paramd.c);
  }
  
  public void a(d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null) {
      return;
    }
    a(paramd.b, paramInt1, paramInt2);
  }
  
  public void a(Object paramObject)
  {
    a(String.valueOf(paramObject));
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      int i = paramString.length();
      int j = this.c + i;
      if (j > this.b.length) {
        e(j);
      }
      paramString.getChars(0, i, this.b, this.c);
      this.c = j;
      return;
      paramString = "null";
    }
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
    int i = this.c;
    int j = i + paramInt2;
    if (j > this.b.length) {
      e(j);
    }
    paramInt2 = i;
    while (paramInt2 < j)
    {
      this.b[paramInt2] = ((char)(paramArrayOfByte[paramInt1] & 0xFF));
      paramInt1 += 1;
      paramInt2 += 1;
    }
    this.c = j;
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
    int i = this.c + paramInt2;
    if (i > this.b.length) {
      e(i);
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.b, this.c, paramInt2);
    this.c = i;
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (i < 0) {
      throw new IndexOutOfBoundsException("Negative beginIndex: " + i);
    }
    if (paramInt2 > this.c) {
      throw new IndexOutOfBoundsException("endIndex: " + paramInt2 + " > length: " + this.c);
    }
    paramInt1 = i;
    if (i > paramInt2) {
      throw new IndexOutOfBoundsException("beginIndex: " + i + " > endIndex: " + paramInt2);
    }
    for (;;)
    {
      i = paramInt2;
      if (paramInt1 >= paramInt2) {
        break;
      }
      i = paramInt2;
      if (!f.a(this.b[paramInt1])) {
        break;
      }
      paramInt1 += 1;
    }
    while ((i > paramInt1) && (f.a(this.b[(i - 1)]))) {
      i -= 1;
    }
    return new String(this.b, paramInt1, i - paramInt1);
  }
  
  public void b(int paramInt)
  {
    if (paramInt <= 0) {}
    while (paramInt <= this.b.length - this.c) {
      return;
    }
    e(this.c + paramInt);
  }
  
  public char[] b()
  {
    char[] arrayOfChar = new char[this.c];
    if (this.c > 0) {
      System.arraycopy(this.b, 0, arrayOfChar, 0, this.c);
    }
    return arrayOfChar;
  }
  
  public void c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.b.length)) {
      throw new IndexOutOfBoundsException("len: " + paramInt + " < 0 or > buffer len: " + this.b.length);
    }
    this.c = paramInt;
  }
  
  public char[] c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.b.length;
  }
  
  public int d(int paramInt)
  {
    return a(paramInt, 0, this.c);
  }
  
  public int e()
  {
    return this.c;
  }
  
  public boolean f()
  {
    return this.c == 0;
  }
  
  public boolean g()
  {
    return this.c == this.b.length;
  }
  
  public String toString()
  {
    return new String(this.b, 0, this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/o/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */