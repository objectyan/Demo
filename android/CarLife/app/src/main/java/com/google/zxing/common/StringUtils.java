package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Map;

public final class StringUtils
{
  private static final boolean ASSUME_SHIFT_JIS;
  private static final String EUC_JP = "EUC_JP";
  public static final String GB2312 = "GB2312";
  private static final String ISO88591 = "ISO8859_1";
  private static final String PLATFORM_DEFAULT_ENCODING = System.getProperty("file.encoding");
  public static final String SHIFT_JIS = "SJIS";
  private static final String UTF8 = "UTF8";
  
  static
  {
    if (("SJIS".equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING)) || ("EUC_JP".equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING))) {}
    for (boolean bool = true;; bool = false)
    {
      ASSUME_SHIFT_JIS = bool;
      return;
    }
  }
  
  public static String guessEncoding(byte[] paramArrayOfByte, Map<DecodeHintType, ?> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = (String)paramMap.get(DecodeHintType.CHARACTER_SET);
      if (paramMap != null) {
        return paramMap;
      }
    }
    if ((paramArrayOfByte.length > 3) && (paramArrayOfByte[0] == -17) && (paramArrayOfByte[1] == -69) && (paramArrayOfByte[2] == -65)) {
      return "UTF8";
    }
    int i11 = paramArrayOfByte.length;
    int i6 = 1;
    int m = 1;
    int i = 1;
    int j = 0;
    int n = 0;
    int i5 = 0;
    int i7 = 0;
    int i8 = 0;
    int i4 = 0;
    int i1 = 0;
    if ((i1 < i11) && ((i6 != 0) || (m != 0) || (i != 0)))
    {
      int i10 = paramArrayOfByte[i1] & 0xFF;
      int i2;
      int i3;
      int k;
      label161:
      int i9;
      if ((i10 >= 128) && (i10 <= 191))
      {
        i2 = i;
        i3 = i8;
        k = j;
        if (j > 0)
        {
          k = j - 1;
          i3 = i8;
          i2 = i;
        }
        if (i10 != 194)
        {
          i8 = i7;
          if (i10 != 195) {}
        }
        else
        {
          i8 = i7;
          if (i1 < i11 - 1)
          {
            i = paramArrayOfByte[(i1 + 1)] & 0xFF;
            i8 = i7;
            if (i <= 191) {
              if ((i10 != 194) || (i < 160))
              {
                i8 = i7;
                if (i10 == 195)
                {
                  i8 = i7;
                  if (i < 128) {}
                }
              }
              else
              {
                i8 = 1;
              }
            }
          }
        }
        i7 = i6;
        if (i10 >= 127)
        {
          i7 = i6;
          if (i10 <= 159) {
            i7 = 0;
          }
        }
        i9 = i5;
        if (i10 >= 161)
        {
          i9 = i5;
          if (i10 <= 223)
          {
            i9 = i5;
            if (i4 == 0) {
              i9 = i5 + 1;
            }
          }
        }
        i = m;
        if (i4 == 0) {
          if (((i10 < 240) || (i10 > 255)) && (i10 != 128))
          {
            i = m;
            if (i10 != 160) {}
          }
          else
          {
            i = 0;
          }
        }
        if (((i10 < 129) || (i10 > 159)) && ((i10 < 224) || (i10 > 239))) {
          break label580;
        }
        if (i4 == 0) {
          break label523;
        }
        j = 0;
      }
      for (;;)
      {
        i1 += 1;
        i6 = i7;
        m = i;
        i = i2;
        i4 = j;
        i5 = i9;
        i7 = i8;
        i8 = i3;
        j = k;
        break;
        if (j > 0) {
          i = 0;
        }
        i2 = i;
        i3 = i8;
        k = j;
        if (i10 < 192) {
          break label161;
        }
        i2 = i;
        i3 = i8;
        k = j;
        if (i10 > 253) {
          break label161;
        }
        i9 = 1;
        i8 = i10;
        for (;;)
        {
          i2 = i;
          i3 = i9;
          k = j;
          if ((i8 & 0x40) == 0) {
            break;
          }
          j += 1;
          i8 <<= 1;
        }
        label523:
        j = 1;
        if (i1 >= paramArrayOfByte.length - 1)
        {
          i = 0;
        }
        else
        {
          m = paramArrayOfByte[(i1 + 1)] & 0xFF;
          if ((m < 64) || (m > 252))
          {
            i = 0;
          }
          else
          {
            n += 1;
            continue;
            label580:
            j = 0;
          }
        }
      }
    }
    if (j > 0) {
      i = 0;
    }
    if ((m != 0) && (ASSUME_SHIFT_JIS)) {
      return "SJIS";
    }
    if ((i != 0) && (i8 != 0)) {
      return "UTF8";
    }
    if ((m != 0) && ((n >= 3) || (i5 * 20 > i11))) {
      return "SJIS";
    }
    if ((i7 == 0) && (i6 != 0)) {
      return "ISO8859_1";
    }
    return PLATFORM_DEFAULT_ENCODING;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/common/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */