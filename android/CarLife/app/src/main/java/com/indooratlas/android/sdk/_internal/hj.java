package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

final class hj
{
  int a;
  final ip b = ix.a(this.c);
  private final iw c = new iw(new is(paramip)new Inflater
  {
    public final long a(in paramAnonymousin, long paramAnonymousLong)
      throws IOException
    {
      if (hj.this.a == 0) {}
      do
      {
        return -1L;
        paramAnonymousLong = super.a(paramAnonymousin, Math.min(paramAnonymousLong, hj.this.a));
      } while (paramAnonymousLong == -1L);
      hj.this.a = ((int)(hj.this.a - paramAnonymousLong));
      return paramAnonymousLong;
    }
  }, new Inflater()
  {
    public final int inflate(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      throws DataFormatException
    {
      int j = super.inflate(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      int i = j;
      if (j == 0)
      {
        i = j;
        if (needsDictionary())
        {
          setDictionary(hn.a);
          i = super.inflate(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
      }
      return i;
    }
  });
  
  public hj(ip paramip) {}
  
  private iq a()
    throws IOException
  {
    int i = this.b.g();
    return this.b.c(i);
  }
  
  public final List<he> a(int paramInt)
    throws IOException
  {
    this.a += paramInt;
    int i = this.b.g();
    if (i < 0) {
      throw new IOException("numberOfPairs < 0: " + i);
    }
    if (i > 1024) {
      throw new IOException("numberOfPairs > 1024: " + i);
    }
    ArrayList localArrayList = new ArrayList(i);
    paramInt = 0;
    while (paramInt < i)
    {
      iq localiq1 = a().c();
      iq localiq2 = a();
      if (localiq1.c.length == 0) {
        throw new IOException("name.size == 0");
      }
      localArrayList.add(new he(localiq1, localiq2));
      paramInt += 1;
    }
    if (this.a > 0)
    {
      this.c.b();
      if (this.a != 0) {
        throw new IOException("compressedLimit > 0: " + this.a);
      }
    }
    return localArrayList;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/hj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */