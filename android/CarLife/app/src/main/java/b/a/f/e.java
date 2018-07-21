package b.a.f;

import b.a.c;
import java.io.IOException;
import okio.ByteString;

public final class e
{
  static final ByteString a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final int b = 16384;
  static final byte c = 0;
  static final byte d = 1;
  static final byte e = 2;
  static final byte f = 3;
  static final byte g = 4;
  static final byte h = 5;
  static final byte i = 6;
  static final byte j = 7;
  static final byte k = 8;
  static final byte l = 9;
  static final byte m = 0;
  static final byte n = 1;
  static final byte o = 1;
  static final byte p = 4;
  static final byte q = 4;
  static final byte r = 8;
  static final byte s = 32;
  static final byte t = 32;
  static final String[] u;
  static final String[] v;
  private static final String[] w = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
  
  static
  {
    u = new String[64];
    v = new String['Ā'];
    int i1 = 0;
    while (i1 < v.length)
    {
      v[i1] = c.a("%8s", new Object[] { Integer.toBinaryString(i1) }).replace(' ', '0');
      i1 += 1;
    }
    u[0] = "";
    u[1] = "END_STREAM";
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = 1;
    u[8] = "PADDED";
    int i2 = arrayOfInt1.length;
    i1 = 0;
    while (i1 < i2)
    {
      i3 = arrayOfInt1[i1];
      u[(i3 | 0x8)] = (u[i3] + "|PADDED");
      i1 += 1;
    }
    u[4] = "END_HEADERS";
    u[32] = "PRIORITY";
    u[36] = "END_HEADERS|PRIORITY";
    int[] arrayOfInt2 = new int[3];
    int[] tmp248_246 = arrayOfInt2;
    tmp248_246[0] = 4;
    int[] tmp252_248 = tmp248_246;
    tmp252_248[1] = 32;
    int[] tmp257_252 = tmp252_248;
    tmp257_252[2] = 36;
    tmp257_252;
    int i3 = arrayOfInt2.length;
    i1 = 0;
    while (i1 < i3)
    {
      int i4 = arrayOfInt2[i1];
      int i5 = arrayOfInt1.length;
      i2 = 0;
      while (i2 < i5)
      {
        int i6 = arrayOfInt1[i2];
        u[(i6 | i4)] = (u[i6] + '|' + u[i4]);
        u[(i6 | i4 | 0x8)] = (u[i6] + '|' + u[i4] + "|PADDED");
        i2 += 1;
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < u.length)
    {
      if (u[i1] == null) {
        u[i1] = v[i1];
      }
      i1 += 1;
    }
  }
  
  static IllegalArgumentException a(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(c.a(paramString, paramVarArgs));
  }
  
  static String a(byte paramByte1, byte paramByte2)
  {
    if (paramByte2 == 0) {
      return "";
    }
    switch (paramByte1)
    {
    case 5: 
    default: 
      if (paramByte2 >= u.length) {
        break;
      }
    }
    for (String str = u[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = v[paramByte2])
    {
      return str.replace("HEADERS", "PUSH_PROMISE");
      if (paramByte2 == 1) {
        return "ACK";
      }
      return v[paramByte2];
      return v[paramByte2];
    }
    if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
      return str.replace("PRIORITY", "COMPRESSED");
    }
    return str;
  }
  
  static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    String str1;
    String str3;
    if (paramByte1 < w.length)
    {
      str1 = w[paramByte1];
      str3 = a(paramByte1, paramByte2);
      if (!paramBoolean) {
        break label91;
      }
    }
    label91:
    for (String str2 = "<<";; str2 = ">>")
    {
      return c.a("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
      str1 = c.a("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
      break;
    }
  }
  
  static IOException b(String paramString, Object... paramVarArgs)
    throws IOException
  {
    throw new IOException(c.a(paramString, paramVarArgs));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */