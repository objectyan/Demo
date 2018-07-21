package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class f
  implements Cloneable
{
  List<q> a = new ArrayList();
  private d<?, ?> b;
  private Object c;
  
  private byte[] c()
    throws IOException
  {
    byte[] arrayOfByte = new byte[a()];
    a(b.a(arrayOfByte, arrayOfByte.length));
    return arrayOfByte;
  }
  
  final int a()
  {
    int j;
    if (this.c != null)
    {
      j = this.b.a(this.c);
      return j;
    }
    Iterator localIterator = this.a.iterator();
    q localq;
    for (int i = 0;; i = localq.b.length + (j + 0) + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      localq = (q)localIterator.next();
      j = b.f(localq.a);
    }
  }
  
  final void a(b paramb)
    throws IOException
  {
    if (this.c != null) {
      this.b.a(this.c, paramb);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        paramb.e(localq.a);
        paramb.b(localq.b);
      }
    }
  }
  
  public final f b()
  {
    int i = 0;
    f localf = new f();
    try
    {
      localf.b = this.b;
      if (this.a == null) {
        localf.a = null;
      }
      for (;;)
      {
        if (this.c == null) {
          return localf;
        }
        if (!(this.c instanceof m)) {
          break;
        }
        localf.c = ((m)this.c).b();
        return localf;
        localf.a.addAll(this.a);
      }
      if (!(this.c instanceof byte[])) {
        break label119;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    localCloneNotSupportedException.c = ((byte[])this.c).clone();
    return localCloneNotSupportedException;
    label119:
    Object localObject1;
    Object localObject2;
    if ((this.c instanceof byte[][]))
    {
      localObject1 = (byte[][])this.c;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.c = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((this.c instanceof boolean[]))
    {
      localCloneNotSupportedException.c = ((boolean[])this.c).clone();
      return localCloneNotSupportedException;
    }
    if ((this.c instanceof int[]))
    {
      localCloneNotSupportedException.c = ((int[])this.c).clone();
      return localCloneNotSupportedException;
    }
    if ((this.c instanceof long[]))
    {
      localCloneNotSupportedException.c = ((long[])this.c).clone();
      return localCloneNotSupportedException;
    }
    if ((this.c instanceof float[]))
    {
      localCloneNotSupportedException.c = ((float[])this.c).clone();
      return localCloneNotSupportedException;
    }
    if ((this.c instanceof double[]))
    {
      localCloneNotSupportedException.c = ((double[])this.c).clone();
      return localCloneNotSupportedException;
    }
    if ((this.c instanceof m[]))
    {
      localObject1 = (m[])this.c;
      localObject2 = new m[localObject1.length];
      localCloneNotSupportedException.c = localObject2;
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i].b();
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof f));
      paramObject = (f)paramObject;
      if ((this.c == null) || (((f)paramObject).c == null)) {
        break;
      }
      bool1 = bool2;
    } while (this.b != ((f)paramObject).b);
    if (!this.b.b.isArray()) {
      return this.c.equals(((f)paramObject).c);
    }
    if ((this.c instanceof byte[])) {
      return Arrays.equals((byte[])this.c, (byte[])((f)paramObject).c);
    }
    if ((this.c instanceof int[])) {
      return Arrays.equals((int[])this.c, (int[])((f)paramObject).c);
    }
    if ((this.c instanceof long[])) {
      return Arrays.equals((long[])this.c, (long[])((f)paramObject).c);
    }
    if ((this.c instanceof float[])) {
      return Arrays.equals((float[])this.c, (float[])((f)paramObject).c);
    }
    if ((this.c instanceof double[])) {
      return Arrays.equals((double[])this.c, (double[])((f)paramObject).c);
    }
    if ((this.c instanceof boolean[])) {
      return Arrays.equals((boolean[])this.c, (boolean[])((f)paramObject).c);
    }
    return Arrays.deepEquals((Object[])this.c, (Object[])((f)paramObject).c);
    if ((this.a != null) && (((f)paramObject).a != null)) {
      return this.a.equals(((f)paramObject).a);
    }
    try
    {
      bool1 = Arrays.equals(c(), ((f)paramObject).c());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public final int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(c());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */