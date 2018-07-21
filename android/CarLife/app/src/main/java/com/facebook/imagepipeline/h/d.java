package com.facebook.imagepipeline.h;

import com.facebook.common.internal.c;
import com.facebook.common.internal.k;
import com.facebook.common.internal.o;
import com.facebook.common.m.e;
import com.facebook.imagepipeline.memory.f;
import com.facebook.imagepipeline.memory.x;
import java.io.IOException;
import java.io.InputStream;

public class d
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private static final int g = 6;
  private static final int h = 16384;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private final f o;
  
  public d(f paramf)
  {
    this.o = ((f)k.a(paramf));
    this.k = 0;
    this.j = 0;
    this.l = 0;
    this.n = 0;
    this.m = 0;
    this.i = 0;
  }
  
  private static boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {}
    while ((paramInt >= 208) && (paramInt <= 215)) {
      return false;
    }
    if ((paramInt != 217) && (paramInt != 216)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean a(InputStream paramInputStream)
  {
    int i1 = this.m;
    int i2;
    for (;;)
    {
      try
      {
        if (this.i != 6)
        {
          i2 = paramInputStream.read();
          if (i2 != -1) {
            this.k += 1;
          }
        }
        switch (this.i)
        {
        case 0: 
          k.b(false);
          label80:
          this.j = i2;
          continue;
          if (this.m == i1) {
            break label284;
          }
        }
      }
      catch (IOException paramInputStream)
      {
        o.b(paramInputStream);
        if (this.i == 6) {
          break;
        }
      }
      return true;
      if (i2 == 255)
      {
        this.i = 1;
      }
      else
      {
        this.i = 6;
        continue;
        if (i2 == 216)
        {
          this.i = 2;
        }
        else
        {
          this.i = 6;
          continue;
          if (i2 == 255)
          {
            this.i = 3;
            continue;
            if (i2 == 255)
            {
              this.i = 3;
            }
            else
            {
              if (i2 != 0) {
                break label289;
              }
              this.i = 2;
            }
          }
        }
      }
    }
    for (;;)
    {
      label203:
      b(this.k - 2);
      label284:
      label289:
      do
      {
        if (a(i2))
        {
          this.i = 4;
          break label80;
        }
        this.i = 2;
        break label80;
        this.i = 5;
        break label80;
        int i3 = (this.j << 8) + i2 - 2;
        e.a(paramInputStream, i3);
        this.k += i3;
        this.i = 2;
        break label80;
        return false;
        break;
        if (i2 == 218) {
          break label203;
        }
      } while (i2 != 217);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.l > 0) {
      this.n = paramInt;
    }
    paramInt = this.l;
    this.l = (paramInt + 1);
    this.m = paramInt;
  }
  
  public boolean a()
  {
    return (this.k > 1) && (this.i != 6);
  }
  
  public boolean a(com.facebook.imagepipeline.i.d paramd)
  {
    if (this.i == 6) {
      return false;
    }
    if (paramd.j() <= this.k) {
      return false;
    }
    paramd = new x(paramd.d(), (byte[])this.o.a(16384), this.o);
    try
    {
      e.a(paramd, this.k);
      boolean bool = a(paramd);
      return bool;
    }
    catch (IOException localIOException)
    {
      o.b(localIOException);
      return false;
    }
    finally
    {
      c.a(paramd);
    }
  }
  
  public int b()
  {
    return this.n;
  }
  
  public int c()
  {
    return this.m;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */