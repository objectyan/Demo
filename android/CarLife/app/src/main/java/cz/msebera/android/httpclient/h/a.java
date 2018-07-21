package cz.msebera.android.httpclient.h;

import java.io.UnsupportedEncodingException;

public class a
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 4;
  public static final int e = 8;
  public static final int f = 16;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      return;
    }
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    return a(paramString.getBytes(), paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localb.a(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localb.b == localb.a.length) {
      return localb.a;
    }
    paramArrayOfByte = new byte[localb.b];
    System.arraycopy(localb.a, 0, paramArrayOfByte, 0, localb.b);
    return paramArrayOfByte;
  }
  
  public static String b(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(c(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramArrayOfByte = new String(c(paramArrayOfByte, paramInt1, paramInt2, paramInt3), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt)
  {
    return c(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = new c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localc.e)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localc.f)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localc.g) {
            break label186;
          }
        }
      }
    }
    label186:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localc.a = new byte[i];
      localc.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if ((g) || (localc.b == i)) {
        break label192;
      }
      throw new AssertionError();
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label192:
    return localc.a;
  }
  
  static abstract class a
  {
    public byte[] a;
    public int b;
    
    public abstract int a(int paramInt);
    
    public abstract boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  static class b
    extends a.a
  {
    private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int e = -1;
    private static final int f = -2;
    private int g;
    private int h;
    private final int[] i;
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {}
      for (paramArrayOfByte = c;; paramArrayOfByte = d)
      {
        this.i = paramArrayOfByte;
        this.g = 0;
        this.h = 0;
        return;
      }
    }
    
    public int a(int paramInt)
    {
      return paramInt * 3 / 4 + 10;
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.g == 6) {
        return false;
      }
      int k = paramInt1;
      int i3 = paramInt2 + paramInt1;
      int i1 = this.g;
      paramInt2 = this.h;
      int j = 0;
      byte[] arrayOfByte = this.a;
      int[] arrayOfInt = this.i;
      int m;
      int i2;
      int n;
      if (k < i3)
      {
        m = j;
        i2 = k;
        n = paramInt2;
        if (i1 == 0)
        {
          for (paramInt1 = paramInt2; k + 4 <= i3; paramInt1 = paramInt2)
          {
            paramInt2 = arrayOfInt[(paramArrayOfByte[k] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(k + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(k + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(k + 3)] & 0xFF)];
            paramInt1 = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            arrayOfByte[(j + 2)] = ((byte)paramInt2);
            arrayOfByte[(j + 1)] = ((byte)(paramInt2 >> 8));
            arrayOfByte[j] = ((byte)(paramInt2 >> 16));
            j += 3;
            k += 4;
          }
          m = j;
          i2 = k;
          n = paramInt1;
          if (k >= i3) {
            paramInt2 = paramInt1;
          }
        }
      }
      for (paramInt1 = j;; paramInt1 = j)
      {
        if (!paramBoolean)
        {
          this.g = i1;
          this.h = paramInt2;
          this.b = paramInt1;
          return true;
          k = arrayOfInt[(paramArrayOfByte[i2] & 0xFF)];
          switch (i1)
          {
          default: 
            paramInt2 = n;
            paramInt1 = i1;
            j = m;
          }
          label639:
          do
          {
            do
            {
              for (;;)
              {
                k = i2 + 1;
                i1 = paramInt1;
                break;
                if (k >= 0)
                {
                  paramInt2 = k;
                  paramInt1 = i1 + 1;
                  j = m;
                }
                else
                {
                  j = m;
                  paramInt1 = i1;
                  paramInt2 = n;
                  if (k != -1)
                  {
                    this.g = 6;
                    return false;
                    if (k >= 0)
                    {
                      paramInt2 = n << 6 | k;
                      paramInt1 = i1 + 1;
                      j = m;
                    }
                    else
                    {
                      j = m;
                      paramInt1 = i1;
                      paramInt2 = n;
                      if (k != -1)
                      {
                        this.g = 6;
                        return false;
                        if (k >= 0)
                        {
                          paramInt2 = n << 6 | k;
                          paramInt1 = i1 + 1;
                          j = m;
                        }
                        else if (k == -2)
                        {
                          arrayOfByte[m] = ((byte)(n >> 4));
                          paramInt1 = 4;
                          j = m + 1;
                          paramInt2 = n;
                        }
                        else
                        {
                          j = m;
                          paramInt1 = i1;
                          paramInt2 = n;
                          if (k != -1)
                          {
                            this.g = 6;
                            return false;
                            if (k >= 0)
                            {
                              paramInt2 = n << 6 | k;
                              arrayOfByte[(m + 2)] = ((byte)paramInt2);
                              arrayOfByte[(m + 1)] = ((byte)(paramInt2 >> 8));
                              arrayOfByte[m] = ((byte)(paramInt2 >> 16));
                              j = m + 3;
                              paramInt1 = 0;
                            }
                            else if (k == -2)
                            {
                              arrayOfByte[(m + 1)] = ((byte)(n >> 2));
                              arrayOfByte[m] = ((byte)(n >> 10));
                              j = m + 2;
                              paramInt1 = 5;
                              paramInt2 = n;
                            }
                            else
                            {
                              j = m;
                              paramInt1 = i1;
                              paramInt2 = n;
                              if (k != -1)
                              {
                                this.g = 6;
                                return false;
                                if (k != -2) {
                                  break label639;
                                }
                                paramInt1 = i1 + 1;
                                j = m;
                                paramInt2 = n;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              j = m;
              paramInt1 = i1;
              paramInt2 = n;
            } while (k == -1);
            this.g = 6;
            return false;
            j = m;
            paramInt1 = i1;
            paramInt2 = n;
          } while (k == -1);
          this.g = 6;
          return false;
        }
        switch (i1)
        {
        default: 
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            this.g = i1;
            this.b = paramInt1;
            return true;
            continue;
            this.g = 6;
            return false;
            j = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte)(paramInt2 >> 4));
            paramInt1 = j;
            continue;
            j = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte)(paramInt2 >> 10));
            arrayOfByte[j] = ((byte)(paramInt2 >> 2));
            paramInt1 = j + 1;
          }
        }
        this.g = 6;
        return false;
      }
    }
  }
  
  static class c
    extends a.a
  {
    public static final int c = 19;
    private static final byte[] i;
    private static final byte[] j;
    int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    private final byte[] k;
    private int l;
    private final byte[] m;
    
    static
    {
      if (!a.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        h = bool;
        i = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        j = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }
    
    public c(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      boolean bool1;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.e = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        label33:
        this.f = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        label47:
        this.g = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        paramArrayOfByte = i;
        label63:
        this.m = paramArrayOfByte;
        this.k = new byte[2];
        this.d = 0;
        if (!this.f) {
          break label118;
        }
      }
      label101:
      label106:
      label111:
      label118:
      for (paramInt = 19;; paramInt = -1)
      {
        this.l = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label33;
        bool1 = false;
        break label47;
        paramArrayOfByte = j;
        break label63;
      }
    }
    
    public int a(int paramInt)
    {
      return paramInt * 8 / 5 + 10;
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte1 = this.m;
      byte[] arrayOfByte2 = this.a;
      int i2 = 0;
      int i4 = this.l;
      int n = paramInt1;
      int i5 = paramInt2 + paramInt1;
      paramInt2 = -1;
      paramInt1 = n;
      int i1 = paramInt2;
      int i3;
      switch (this.d)
      {
      default: 
        i1 = paramInt2;
        paramInt1 = n;
      case 0: 
        paramInt2 = i4;
        n = i2;
        i2 = paramInt1;
        if (i1 != -1)
        {
          n = 0 + 1;
          arrayOfByte2[0] = arrayOfByte1[(i1 >> 18 & 0x3F)];
          paramInt2 = n + 1;
          arrayOfByte2[n] = arrayOfByte1[(i1 >> 12 & 0x3F)];
          n = paramInt2 + 1;
          arrayOfByte2[paramInt2] = arrayOfByte1[(i1 >> 6 & 0x3F)];
          i3 = n + 1;
          arrayOfByte2[n] = arrayOfByte1[(i1 & 0x3F)];
          i1 = i4 - 1;
          paramInt2 = i1;
          n = i3;
          i2 = paramInt1;
          if (i1 == 0)
          {
            paramInt2 = i3;
            if (this.g)
            {
              arrayOfByte2[i3] = 13;
              paramInt2 = i3 + 1;
            }
            n = paramInt2 + 1;
            arrayOfByte2[paramInt2] = 10;
            i2 = 19;
            paramInt2 = paramInt1;
            paramInt1 = n;
          }
        }
        break;
      }
      for (;;)
      {
        if (paramInt2 + 3 <= i5)
        {
          n = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
          arrayOfByte2[paramInt1] = arrayOfByte1[(n >> 18 & 0x3F)];
          arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(n >> 12 & 0x3F)];
          arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(n >> 6 & 0x3F)];
          arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(n & 0x3F)];
          i1 = paramInt2 + 3;
          paramInt1 += 4;
          i3 = i2 - 1;
          paramInt2 = i3;
          n = paramInt1;
          i2 = i1;
          if (i3 != 0) {
            break label1242;
          }
          paramInt2 = paramInt1;
          if (this.g)
          {
            arrayOfByte2[paramInt1] = 13;
            paramInt2 = paramInt1 + 1;
          }
          paramInt1 = paramInt2 + 1;
          arrayOfByte2[paramInt2] = 10;
          i2 = 19;
          paramInt2 = i1;
          continue;
          paramInt1 = n;
          i1 = paramInt2;
          if (n + 2 > i5) {
            break;
          }
          paramInt2 = this.k[0];
          i1 = n + 1;
          n = paramArrayOfByte[n];
          paramInt1 = i1 + 1;
          i1 = (paramInt2 & 0xFF) << 16 | (n & 0xFF) << 8 | paramArrayOfByte[i1] & 0xFF;
          this.d = 0;
          break;
          paramInt1 = n;
          i1 = paramInt2;
          if (n + 1 > i5) {
            break;
          }
          i1 = (this.k[0] & 0xFF) << 16 | (this.k[1] & 0xFF) << 8 | paramArrayOfByte[n] & 0xFF;
          this.d = 0;
          paramInt1 = n + 1;
          break;
        }
        if (paramBoolean)
        {
          if (paramInt2 - this.d == i5 - 1)
          {
            n = 0;
            if (this.d > 0)
            {
              i1 = this.k[0];
              n = 0 + 1;
            }
            for (;;)
            {
              i1 = (i1 & 0xFF) << 4;
              this.d -= n;
              n = paramInt1 + 1;
              arrayOfByte2[paramInt1] = arrayOfByte1[(i1 >> 6 & 0x3F)];
              paramInt1 = n + 1;
              arrayOfByte2[n] = arrayOfByte1[(i1 & 0x3F)];
              i1 = paramInt1;
              if (this.e)
              {
                n = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 61;
                i1 = n + 1;
                arrayOfByte2[n] = 61;
              }
              paramInt1 = i1;
              n = paramInt2;
              if (this.f)
              {
                paramInt1 = i1;
                if (this.g)
                {
                  arrayOfByte2[i1] = 13;
                  paramInt1 = i1 + 1;
                }
                n = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 10;
                paramInt1 = n;
                n = paramInt2;
              }
              label736:
              if ((h) || (this.d == 0)) {
                break;
              }
              throw new AssertionError();
              i3 = paramInt2 + 1;
              i1 = paramArrayOfByte[paramInt2];
              paramInt2 = i3;
            }
          }
          if (paramInt2 - this.d == i5 - 2)
          {
            n = 0;
            if (this.d > 1)
            {
              i1 = this.k[0];
              n = 0 + 1;
              label810:
              if (this.d <= 0) {
                break label1012;
              }
              i3 = this.k[n];
              n += 1;
            }
            for (;;)
            {
              i1 = (i1 & 0xFF) << 10 | (i3 & 0xFF) << 2;
              this.d -= n;
              n = paramInt1 + 1;
              arrayOfByte2[paramInt1] = arrayOfByte1[(i1 >> 12 & 0x3F)];
              i3 = n + 1;
              arrayOfByte2[n] = arrayOfByte1[(i1 >> 6 & 0x3F)];
              paramInt1 = i3 + 1;
              arrayOfByte2[i3] = arrayOfByte1[(i1 & 0x3F)];
              i1 = paramInt1;
              if (this.e)
              {
                arrayOfByte2[paramInt1] = 61;
                i1 = paramInt1 + 1;
              }
              paramInt1 = i1;
              n = paramInt2;
              if (!this.f) {
                break label736;
              }
              paramInt1 = i1;
              if (this.g)
              {
                arrayOfByte2[i1] = 13;
                paramInt1 = i1 + 1;
              }
              n = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 10;
              paramInt1 = n;
              break;
              i3 = paramInt2 + 1;
              i1 = paramArrayOfByte[paramInt2];
              paramInt2 = i3;
              break label810;
              label1012:
              i3 = paramArrayOfByte[paramInt2];
              paramInt2 += 1;
            }
          }
          n = paramInt1;
          if (this.f)
          {
            n = paramInt1;
            if (paramInt1 > 0)
            {
              n = paramInt1;
              if (i2 != 19)
              {
                if (!this.g) {
                  break label1239;
                }
                n = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 13;
                paramInt1 = n;
              }
            }
          }
        }
        label1168:
        label1239:
        for (;;)
        {
          n = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
          paramInt1 = n;
          n = paramInt2;
          break;
          paramInt2 = paramInt1;
          if (!h)
          {
            paramInt2 = paramInt1;
            if (n != i5)
            {
              throw new AssertionError();
              if (paramInt2 != i5 - 1) {
                break label1168;
              }
              arrayOfByte1 = this.k;
              n = this.d;
              this.d = (n + 1);
              arrayOfByte1[n] = paramArrayOfByte[paramInt2];
            }
          }
          for (paramInt2 = paramInt1;; paramInt2 = paramInt1)
          {
            this.b = paramInt2;
            this.l = i2;
            return true;
            if (paramInt2 == i5 - 2)
            {
              arrayOfByte1 = this.k;
              n = this.d;
              this.d = (n + 1);
              arrayOfByte1[n] = paramArrayOfByte[paramInt2];
              arrayOfByte1 = this.k;
              n = this.d;
              this.d = (n + 1);
              arrayOfByte1[n] = paramArrayOfByte[(paramInt2 + 1)];
            }
          }
        }
        label1242:
        i1 = i2;
        paramInt1 = n;
        i2 = paramInt2;
        paramInt2 = i1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */