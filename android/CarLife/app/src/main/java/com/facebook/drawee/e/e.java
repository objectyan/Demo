package com.facebook.drawee.e;

import com.facebook.common.internal.k;
import java.util.Arrays;

public class e
{
  private a a = a.b;
  private boolean b = false;
  private float[] c = null;
  private int d = 0;
  private float e = 0.0F;
  private int f = 0;
  private float g = 0.0F;
  
  public static e b(float paramFloat)
  {
    return new e().a(paramFloat);
  }
  
  public static e b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new e().a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static e b(float[] paramArrayOfFloat)
  {
    return new e().a(paramArrayOfFloat);
  }
  
  public static e e()
  {
    return new e().a(true);
  }
  
  private float[] i()
  {
    if (this.c == null) {
      this.c = new float[8];
    }
    return this.c;
  }
  
  public e a(float paramFloat)
  {
    Arrays.fill(i(), paramFloat);
    return this;
  }
  
  public e a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = i();
    arrayOfFloat[1] = paramFloat1;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[3] = paramFloat2;
    arrayOfFloat[2] = paramFloat2;
    arrayOfFloat[5] = paramFloat3;
    arrayOfFloat[4] = paramFloat3;
    arrayOfFloat[7] = paramFloat4;
    arrayOfFloat[6] = paramFloat4;
    return this;
  }
  
  public e a(int paramInt)
  {
    this.d = paramInt;
    this.a = a.a;
    return this;
  }
  
  public e a(int paramInt, float paramFloat)
  {
    if (paramFloat >= 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool, "the border width cannot be < 0");
      this.e = paramFloat;
      this.f = paramInt;
      return this;
    }
  }
  
  public e a(a parama)
  {
    this.a = parama;
    return this;
  }
  
  public e a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public e a(float[] paramArrayOfFloat)
  {
    k.a(paramArrayOfFloat);
    if (paramArrayOfFloat.length == 8) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, i(), 0, 8);
      return this;
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public e b(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public float[] b()
  {
    return this.c;
  }
  
  public a c()
  {
    return this.a;
  }
  
  public e c(float paramFloat)
  {
    if (paramFloat >= 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool, "the border width cannot be < 0");
      this.e = paramFloat;
      return this;
    }
  }
  
  public int d()
  {
    return this.d;
  }
  
  public e d(float paramFloat)
  {
    if (paramFloat >= 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool, "the padding cannot be < 0");
      this.g = paramFloat;
      return this;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    bool1 = bool2;
                  } while (paramObject == null);
                  bool1 = bool2;
                } while (getClass() != paramObject.getClass());
                paramObject = (e)paramObject;
                bool1 = bool2;
              } while (this.b != ((e)paramObject).b);
              bool1 = bool2;
            } while (this.d != ((e)paramObject).d);
            bool1 = bool2;
          } while (Float.compare(((e)paramObject).e, this.e) != 0);
          bool1 = bool2;
        } while (this.f != ((e)paramObject).f);
        bool1 = bool2;
      } while (Float.compare(((e)paramObject).g, this.g) != 0);
      bool1 = bool2;
    } while (this.a != ((e)paramObject).a);
    return Arrays.equals(this.c, ((e)paramObject).c);
  }
  
  public float f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public float h()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    int n = 0;
    int i;
    int j;
    label27:
    int k;
    label42:
    int i1;
    if (this.a != null)
    {
      i = this.a.hashCode();
      if (!this.b) {
        break label131;
      }
      j = 1;
      if (this.c == null) {
        break label136;
      }
      k = Arrays.hashCode(this.c);
      i1 = this.d;
      if (this.e == 0.0F) {
        break label141;
      }
    }
    label131:
    label136:
    label141:
    for (int m = Float.floatToIntBits(this.e);; m = 0)
    {
      int i2 = this.f;
      if (this.g != 0.0F) {
        n = Float.floatToIntBits(this.g);
      }
      return (((((i * 31 + j) * 31 + k) * 31 + i1) * 31 + m) * 31 + i2) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label27;
      k = 0;
      break label42;
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */