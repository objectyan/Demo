package com.loopj.android.http;

import java.io.UnsupportedEncodingException;

public class Base64
{
  public static final int CRLF = 4;
  public static final int DEFAULT = 0;
  public static final int NO_CLOSE = 16;
  public static final int NO_PADDING = 1;
  public static final int NO_WRAP = 2;
  public static final int URL_SAFE = 8;
  
  public static byte[] decode(String paramString, int paramInt)
  {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Decoder localDecoder = new Decoder(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localDecoder.process(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localDecoder.op == localDecoder.output.length) {
      return localDecoder.output;
    }
    paramArrayOfByte = new byte[localDecoder.op];
    System.arraycopy(localDecoder.output, 0, paramArrayOfByte, 0, localDecoder.op);
    return paramArrayOfByte;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Encoder localEncoder = new Encoder(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localEncoder.do_padding)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localEncoder.do_newline)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localEncoder.do_cr) {
            break label166;
          }
        }
      }
    }
    label166:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localEncoder.output = new byte[i];
      localEncoder.process(paramArrayOfByte, paramInt1, paramInt2, true);
      return localEncoder.output;
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
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt1, paramInt2, paramInt3), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  static abstract class Coder
  {
    public int op;
    public byte[] output;
    
    public abstract int maxOutputSize(int paramInt);
    
    public abstract boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  static class Decoder
    extends Base64.Coder
  {
    private static final int[] DECODE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int[] DECODE_WEBSAFE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int EQUALS = -2;
    private static final int SKIP = -1;
    private final int[] alphabet;
    private int state;
    private int value;
    
    public Decoder(int paramInt, byte[] paramArrayOfByte)
    {
      this.output = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {}
      for (paramArrayOfByte = DECODE;; paramArrayOfByte = DECODE_WEBSAFE)
      {
        this.alphabet = paramArrayOfByte;
        this.state = 0;
        this.value = 0;
        return;
      }
    }
    
    public int maxOutputSize(int paramInt)
    {
      return paramInt * 3 / 4 + 10;
    }
    
    public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.state == 6) {
        return false;
      }
      int j = paramInt1;
      int i2 = paramInt2 + paramInt1;
      int n = this.state;
      paramInt2 = this.value;
      int i = 0;
      byte[] arrayOfByte = this.output;
      int[] arrayOfInt = this.alphabet;
      int k;
      int i1;
      int m;
      if (j < i2)
      {
        k = i;
        i1 = j;
        m = paramInt2;
        if (n == 0)
        {
          for (paramInt1 = paramInt2; j + 4 <= i2; paramInt1 = paramInt2)
          {
            paramInt2 = arrayOfInt[(paramArrayOfByte[j] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(j + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(j + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(j + 3)] & 0xFF)];
            paramInt1 = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            arrayOfByte[(i + 2)] = ((byte)paramInt2);
            arrayOfByte[(i + 1)] = ((byte)(paramInt2 >> 8));
            arrayOfByte[i] = ((byte)(paramInt2 >> 16));
            i += 3;
            j += 4;
          }
          k = i;
          i1 = j;
          m = paramInt1;
          if (j >= i2) {
            paramInt2 = paramInt1;
          }
        }
      }
      for (paramInt1 = i;; paramInt1 = i)
      {
        if (!paramBoolean)
        {
          this.state = n;
          this.value = paramInt2;
          this.op = paramInt1;
          return true;
          j = arrayOfInt[(paramArrayOfByte[i1] & 0xFF)];
          switch (n)
          {
          default: 
            paramInt2 = m;
            paramInt1 = n;
            i = k;
          }
          label639:
          do
          {
            do
            {
              for (;;)
              {
                j = i1 + 1;
                n = paramInt1;
                break;
                if (j >= 0)
                {
                  paramInt2 = j;
                  paramInt1 = n + 1;
                  i = k;
                }
                else
                {
                  i = k;
                  paramInt1 = n;
                  paramInt2 = m;
                  if (j != -1)
                  {
                    this.state = 6;
                    return false;
                    if (j >= 0)
                    {
                      paramInt2 = m << 6 | j;
                      paramInt1 = n + 1;
                      i = k;
                    }
                    else
                    {
                      i = k;
                      paramInt1 = n;
                      paramInt2 = m;
                      if (j != -1)
                      {
                        this.state = 6;
                        return false;
                        if (j >= 0)
                        {
                          paramInt2 = m << 6 | j;
                          paramInt1 = n + 1;
                          i = k;
                        }
                        else if (j == -2)
                        {
                          arrayOfByte[k] = ((byte)(m >> 4));
                          paramInt1 = 4;
                          i = k + 1;
                          paramInt2 = m;
                        }
                        else
                        {
                          i = k;
                          paramInt1 = n;
                          paramInt2 = m;
                          if (j != -1)
                          {
                            this.state = 6;
                            return false;
                            if (j >= 0)
                            {
                              paramInt2 = m << 6 | j;
                              arrayOfByte[(k + 2)] = ((byte)paramInt2);
                              arrayOfByte[(k + 1)] = ((byte)(paramInt2 >> 8));
                              arrayOfByte[k] = ((byte)(paramInt2 >> 16));
                              i = k + 3;
                              paramInt1 = 0;
                            }
                            else if (j == -2)
                            {
                              arrayOfByte[(k + 1)] = ((byte)(m >> 2));
                              arrayOfByte[k] = ((byte)(m >> 10));
                              i = k + 2;
                              paramInt1 = 5;
                              paramInt2 = m;
                            }
                            else
                            {
                              i = k;
                              paramInt1 = n;
                              paramInt2 = m;
                              if (j != -1)
                              {
                                this.state = 6;
                                return false;
                                if (j != -2) {
                                  break label639;
                                }
                                paramInt1 = n + 1;
                                i = k;
                                paramInt2 = m;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              i = k;
              paramInt1 = n;
              paramInt2 = m;
            } while (j == -1);
            this.state = 6;
            return false;
            i = k;
            paramInt1 = n;
            paramInt2 = m;
          } while (j == -1);
          this.state = 6;
          return false;
        }
        switch (n)
        {
        default: 
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            this.state = n;
            this.op = paramInt1;
            return true;
            continue;
            this.state = 6;
            return false;
            i = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte)(paramInt2 >> 4));
            paramInt1 = i;
            continue;
            i = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte)(paramInt2 >> 10));
            arrayOfByte[i] = ((byte)(paramInt2 >> 2));
            paramInt1 = i + 1;
          }
        }
        this.state = 6;
        return false;
      }
    }
  }
  
  static class Encoder
    extends Base64.Coder
  {
    private static final byte[] ENCODE = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
    private static final byte[] ENCODE_WEBSAFE = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
    public static final int LINE_GROUPS = 19;
    private final byte[] alphabet;
    private int count;
    public final boolean do_cr;
    public final boolean do_newline;
    public final boolean do_padding;
    private final byte[] tail;
    int tailLen;
    
    public Encoder(int paramInt, byte[] paramArrayOfByte)
    {
      this.output = paramArrayOfByte;
      boolean bool1;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.do_padding = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        label33:
        this.do_newline = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        label47:
        this.do_cr = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        paramArrayOfByte = ENCODE;
        label63:
        this.alphabet = paramArrayOfByte;
        this.tail = new byte[2];
        this.tailLen = 0;
        if (!this.do_newline) {
          break label118;
        }
      }
      label101:
      label106:
      label111:
      label118:
      for (paramInt = 19;; paramInt = -1)
      {
        this.count = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label33;
        bool1 = false;
        break label47;
        paramArrayOfByte = ENCODE_WEBSAFE;
        break label63;
      }
    }
    
    public int maxOutputSize(int paramInt)
    {
      return paramInt * 8 / 5 + 10;
    }
    
    public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte1 = this.alphabet;
      byte[] arrayOfByte2 = this.output;
      int k = 0;
      int n = this.count;
      int i = paramInt1;
      int i1 = paramInt2 + paramInt1;
      paramInt2 = -1;
      paramInt1 = i;
      int j = paramInt2;
      int m;
      switch (this.tailLen)
      {
      default: 
        j = paramInt2;
        paramInt1 = i;
      case 0: 
        paramInt2 = n;
        i = k;
        k = paramInt1;
        if (j != -1)
        {
          i = 0 + 1;
          arrayOfByte2[0] = arrayOfByte1[(j >> 18 & 0x3F)];
          paramInt2 = i + 1;
          arrayOfByte2[i] = arrayOfByte1[(j >> 12 & 0x3F)];
          i = paramInt2 + 1;
          arrayOfByte2[paramInt2] = arrayOfByte1[(j >> 6 & 0x3F)];
          m = i + 1;
          arrayOfByte2[i] = arrayOfByte1[(j & 0x3F)];
          j = n - 1;
          paramInt2 = j;
          i = m;
          k = paramInt1;
          if (j == 0)
          {
            paramInt2 = m;
            if (this.do_cr)
            {
              arrayOfByte2[m] = 13;
              paramInt2 = m + 1;
            }
            i = paramInt2 + 1;
            arrayOfByte2[paramInt2] = 10;
            j = 19;
            paramInt2 = paramInt1;
            paramInt1 = i;
            i = j;
          }
        }
        break;
      }
      for (;;)
      {
        if (paramInt2 + 3 <= i1)
        {
          j = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
          arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 18 & 0x3F)];
          arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(j >> 12 & 0x3F)];
          arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(j >> 6 & 0x3F)];
          arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(j & 0x3F)];
          j = paramInt2 + 3;
          paramInt1 += 4;
          m = i - 1;
          paramInt2 = m;
          i = paramInt1;
          k = j;
          if (m != 0) {
            break label1150;
          }
          paramInt2 = paramInt1;
          if (this.do_cr)
          {
            arrayOfByte2[paramInt1] = 13;
            paramInt2 = paramInt1 + 1;
          }
          paramInt1 = paramInt2 + 1;
          arrayOfByte2[paramInt2] = 10;
          i = 19;
          paramInt2 = j;
          continue;
          paramInt1 = i;
          j = paramInt2;
          if (i + 2 > i1) {
            break;
          }
          paramInt2 = this.tail[0];
          j = i + 1;
          i = paramArrayOfByte[i];
          paramInt1 = j + 1;
          j = (paramInt2 & 0xFF) << 16 | (i & 0xFF) << 8 | paramArrayOfByte[j] & 0xFF;
          this.tailLen = 0;
          break;
          paramInt1 = i;
          j = paramInt2;
          if (i + 1 > i1) {
            break;
          }
          j = (this.tail[0] & 0xFF) << 16 | (this.tail[1] & 0xFF) << 8 | paramArrayOfByte[i] & 0xFF;
          this.tailLen = 0;
          paramInt1 = i + 1;
          break;
        }
        if (paramBoolean)
        {
          if (paramInt2 - this.tailLen == i1 - 1)
          {
            j = 0;
            if (this.tailLen > 0)
            {
              j = this.tail[0];
              paramInt2 = 0 + 1;
            }
            for (;;)
            {
              j = (j & 0xFF) << 4;
              this.tailLen -= paramInt2;
              paramInt2 = paramInt1 + 1;
              arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 6 & 0x3F)];
              paramInt1 = paramInt2 + 1;
              arrayOfByte2[paramInt2] = arrayOfByte1[(j & 0x3F)];
              paramInt2 = paramInt1;
              if (this.do_padding)
              {
                j = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 61;
                paramInt2 = j + 1;
                arrayOfByte2[j] = 61;
              }
              paramInt1 = paramInt2;
              if (this.do_newline)
              {
                paramInt1 = paramInt2;
                if (this.do_cr)
                {
                  arrayOfByte2[paramInt2] = 13;
                  paramInt1 = paramInt2 + 1;
                }
                paramInt2 = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 10;
                paramInt1 = paramInt2;
              }
              this.op = paramInt1;
              this.count = i;
              return true;
              k = paramArrayOfByte[paramInt2];
              paramInt2 = j;
              j = k;
            }
          }
          if (paramInt2 - this.tailLen == i1 - 2)
          {
            j = 0;
            if (this.tailLen > 1)
            {
              j = this.tail[0];
              m = 0 + 1;
              k = paramInt2;
              paramInt2 = m;
              label792:
              if (this.tailLen <= 0) {
                break label980;
              }
              k = this.tail[paramInt2];
              paramInt2 += 1;
            }
            for (;;)
            {
              j = (j & 0xFF) << 10 | (k & 0xFF) << 2;
              this.tailLen -= paramInt2;
              paramInt2 = paramInt1 + 1;
              arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 12 & 0x3F)];
              k = paramInt2 + 1;
              arrayOfByte2[paramInt2] = arrayOfByte1[(j >> 6 & 0x3F)];
              paramInt1 = k + 1;
              arrayOfByte2[k] = arrayOfByte1[(j & 0x3F)];
              paramInt2 = paramInt1;
              if (this.do_padding)
              {
                arrayOfByte2[paramInt1] = 61;
                paramInt2 = paramInt1 + 1;
              }
              paramInt1 = paramInt2;
              if (!this.do_newline) {
                break;
              }
              paramInt1 = paramInt2;
              if (this.do_cr)
              {
                arrayOfByte2[paramInt2] = 13;
                paramInt1 = paramInt2 + 1;
              }
              paramInt2 = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 10;
              paramInt1 = paramInt2;
              break;
              k = paramInt2 + 1;
              m = paramArrayOfByte[paramInt2];
              paramInt2 = j;
              j = m;
              break label792;
              label980:
              k = paramArrayOfByte[k];
            }
          }
          if ((!this.do_newline) || (paramInt1 <= 0) || (i == 19)) {
            break label1144;
          }
          if (!this.do_cr) {
            break label1147;
          }
          paramInt2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 13;
          paramInt1 = paramInt2;
        }
        label1144:
        label1147:
        for (;;)
        {
          arrayOfByte2[paramInt1] = 10;
          paramInt1 += 1;
          break;
          if (paramInt2 == i1 - 1)
          {
            arrayOfByte1 = this.tail;
            j = this.tailLen;
            this.tailLen = (j + 1);
            arrayOfByte1[j] = paramArrayOfByte[paramInt2];
            break;
          }
          if (paramInt2 == i1 - 2)
          {
            arrayOfByte1 = this.tail;
            j = this.tailLen;
            this.tailLen = (j + 1);
            arrayOfByte1[j] = paramArrayOfByte[paramInt2];
            arrayOfByte1 = this.tail;
            j = this.tailLen;
            this.tailLen = (j + 1);
            arrayOfByte1[j] = paramArrayOfByte[(paramInt2 + 1)];
          }
          break;
        }
        label1150:
        paramInt1 = i;
        i = paramInt2;
        paramInt2 = k;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */