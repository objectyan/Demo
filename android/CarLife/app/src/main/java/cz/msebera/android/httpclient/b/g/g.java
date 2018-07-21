package cz.msebera.android.httpclient.b.g;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.util.StringTokenizer;

@Immutable
public class g
  implements d
{
  private static final int a = 36;
  private static final int b = 1;
  private static final int c = 26;
  private static final int d = 38;
  private static final int e = 700;
  private static final int f = 72;
  private static final int g = 128;
  private static final char h = '-';
  private static final String i = "xn--";
  
  private int a(char paramChar)
  {
    if ((paramChar >= 'A') && (paramChar <= 'Z')) {
      return paramChar - 'A';
    }
    if ((paramChar >= 'a') && (paramChar <= 'z')) {
      return paramChar - 'a';
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0' + 26;
    }
    throw new IllegalArgumentException("illegal digit: " + paramChar);
  }
  
  private int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramInt1 /= 700;
    }
    for (;;)
    {
      paramInt2 = paramInt1 + paramInt1 / paramInt2;
      paramInt1 = 0;
      while (paramInt2 > 455)
      {
        paramInt2 /= 35;
        paramInt1 += 36;
      }
      paramInt1 /= 2;
    }
    return paramInt2 * 36 / (paramInt2 + 38) + paramInt1;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ".");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append('.');
      }
      paramString = str;
      if (str.startsWith("xn--")) {
        paramString = b(str.substring(4));
      }
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  protected String b(String paramString)
  {
    String str = paramString;
    int k = 128;
    int i1 = 0;
    int i2 = 72;
    StringBuilder localStringBuilder = new StringBuilder(str.length());
    int i3 = str.lastIndexOf('-');
    int m = i2;
    int j = i1;
    paramString = str;
    int n = k;
    if (i3 != -1)
    {
      localStringBuilder.append(str.subSequence(0, i3));
      paramString = str.substring(i3 + 1);
      n = k;
      j = i1;
      m = i2;
    }
    if (paramString.length() > 0)
    {
      i2 = 1;
      i1 = 36;
      k = j;
      int i4;
      if (paramString.length() == 0)
      {
        i4 = k;
        label121:
        k = localStringBuilder.length();
        if (j != 0) {
          break label304;
        }
      }
      label304:
      for (boolean bool = true;; bool = false)
      {
        m = a(i4 - j, k + 1, bool);
        n += i4 / (localStringBuilder.length() + 1);
        j = i4 % (localStringBuilder.length() + 1);
        localStringBuilder.insert(j, (char)n);
        j += 1;
        break;
        char c1 = paramString.charAt(0);
        str = paramString.substring(1);
        int i5 = a(c1);
        i3 = k + i5 * i2;
        if (i1 <= m + 1) {
          k = 1;
        }
        for (;;)
        {
          i4 = i3;
          paramString = str;
          if (i5 < k) {
            break label121;
          }
          i2 *= (36 - k);
          i1 += 36;
          k = i3;
          paramString = str;
          break;
          if (i1 >= m + 26) {
            k = 26;
          } else {
            k = i1 - m;
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/g/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */