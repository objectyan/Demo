package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.List;

public abstract class c<M extends c<M>>
  extends m
{
  public e a;
  
  private M d()
    throws CloneNotSupportedException
  {
    c localc = (c)super.b();
    i.a(this, localc);
    return localc;
  }
  
  public int a()
  {
    int j = 0;
    if (this.a != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= this.a.b()) {
          break;
        }
        i += this.a.a(j).a();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public void a(b paramb)
    throws IOException
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.a.b())
      {
        this.a.a(i).a(paramb);
        i += 1;
      }
    }
  }
  
  public final boolean a(a parama, int paramInt)
    throws IOException
  {
    int i = parama.k();
    if (!parama.b(paramInt)) {
      return false;
    }
    int j = s.b(paramInt);
    int k = parama.k() - i;
    q localq;
    label69:
    Object localObject;
    if (k == 0)
    {
      parama = s.h;
      localq = new q(paramInt, parama);
      if (this.a != null) {
        break label162;
      }
      this.a = new e();
      parama = null;
      localObject = parama;
      if (parama == null)
      {
        parama = new f();
        localObject = this.a;
        paramInt = ((e)localObject).c(j);
        if (paramInt < 0) {
          break label205;
        }
        ((e)localObject).d[paramInt] = parama;
        localObject = parama;
      }
    }
    for (;;)
    {
      ((f)localObject).a.add(localq);
      return true;
      localObject = new byte[k];
      int m = parama.b;
      System.arraycopy(parama.a, i + m, localObject, 0, k);
      parama = (a)localObject;
      break;
      label162:
      parama = this.a;
      paramInt = parama.c(j);
      if ((paramInt < 0) || (parama.d[paramInt] == e.a))
      {
        parama = null;
        break label69;
      }
      parama = parama.d[paramInt];
      break label69;
      label205:
      i = paramInt ^ 0xFFFFFFFF;
      if ((i < ((e)localObject).e) && (localObject.d[i] == e.a))
      {
        ((e)localObject).c[i] = j;
        ((e)localObject).d[i] = parama;
        localObject = parama;
      }
      else
      {
        paramInt = i;
        if (((e)localObject).b)
        {
          paramInt = i;
          if (((e)localObject).e >= ((e)localObject).c.length)
          {
            ((e)localObject).a();
            paramInt = ((e)localObject).c(j) ^ 0xFFFFFFFF;
          }
        }
        if (((e)localObject).e >= ((e)localObject).c.length)
        {
          i = e.b(((e)localObject).e + 1);
          int[] arrayOfInt = new int[i];
          f[] arrayOff = new f[i];
          System.arraycopy(((e)localObject).c, 0, arrayOfInt, 0, ((e)localObject).c.length);
          System.arraycopy(((e)localObject).d, 0, arrayOff, 0, ((e)localObject).d.length);
          ((e)localObject).c = arrayOfInt;
          ((e)localObject).d = arrayOff;
        }
        if (((e)localObject).e - paramInt != 0)
        {
          System.arraycopy(((e)localObject).c, paramInt, ((e)localObject).c, paramInt + 1, ((e)localObject).e - paramInt);
          System.arraycopy(((e)localObject).d, paramInt, ((e)localObject).d, paramInt + 1, ((e)localObject).e - paramInt);
        }
        ((e)localObject).c[paramInt] = j;
        ((e)localObject).d[paramInt] = parama;
        ((e)localObject).e += 1;
        localObject = parama;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */