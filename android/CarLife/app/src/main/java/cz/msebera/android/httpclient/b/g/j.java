package cz.msebera.android.httpclient.b.g;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.c;
import cz.msebera.android.httpclient.k.x;
import cz.msebera.android.httpclient.o.d;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Immutable
public class j
{
  public static final String a = "application/x-www-form-urlencoded";
  private static final char b = '&';
  private static final char c = ';';
  private static final String d = "=";
  private static final char[] e = { 38, 59 };
  private static final String f = "[" + new String(e) + "]";
  private static final BitSet g = new BitSet(256);
  private static final BitSet h = new BitSet(256);
  private static final BitSet i = new BitSet(256);
  private static final BitSet j = new BitSet(256);
  private static final BitSet k = new BitSet(256);
  private static final BitSet l = new BitSet(256);
  private static final BitSet m = new BitSet(256);
  private static final int n = 16;
  
  static
  {
    int i1 = 97;
    while (i1 <= 122)
    {
      g.set(i1);
      i1 += 1;
    }
    i1 = 65;
    while (i1 <= 90)
    {
      g.set(i1);
      i1 += 1;
    }
    i1 = 48;
    while (i1 <= 57)
    {
      g.set(i1);
      i1 += 1;
    }
    g.set(95);
    g.set(45);
    g.set(46);
    g.set(42);
    m.or(g);
    g.set(33);
    g.set(126);
    g.set(39);
    g.set(40);
    g.set(41);
    h.set(44);
    h.set(59);
    h.set(58);
    h.set(36);
    h.set(38);
    h.set(43);
    h.set(61);
    i.or(g);
    i.or(h);
    j.or(g);
    j.set(47);
    j.set(59);
    j.set(58);
    j.set(64);
    j.set(38);
    j.set(61);
    j.set(43);
    j.set(36);
    j.set(44);
    l.set(59);
    l.set(47);
    l.set(63);
    l.set(58);
    l.set(64);
    l.set(38);
    l.set(61);
    l.set(43);
    l.set(36);
    l.set(44);
    l.set(91);
    l.set(93);
    k.or(l);
    k.or(g);
  }
  
  public static String a(Iterable<? extends ag> paramIterable, char paramChar, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = (ag)paramIterable.next();
      String str = f(((ag)localObject).a(), paramCharset);
      localObject = f(((ag)localObject).b(), paramCharset);
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramChar);
      }
      localStringBuilder.append(str);
      if (localObject != null)
      {
        localStringBuilder.append("=");
        localStringBuilder.append((String)localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Iterable<? extends ag> paramIterable, Charset paramCharset)
  {
    return a(paramIterable, '&', paramCharset);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 != null) {}
    for (paramString2 = Charset.forName(paramString2);; paramString2 = c.e) {
      return a(paramString1, paramString2, true);
    }
  }
  
  private static String a(String paramString, Charset paramCharset, BitSet paramBitSet, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramCharset.encode(paramString);
    while (paramString.hasRemaining())
    {
      int i1 = paramString.get() & 0xFF;
      if (paramBitSet.get(i1))
      {
        localStringBuilder.append((char)i1);
      }
      else if ((paramBoolean) && (i1 == 32))
      {
        localStringBuilder.append('+');
      }
      else
      {
        localStringBuilder.append("%");
        char c1 = Character.toUpperCase(Character.forDigit(i1 >> 4 & 0xF, 16));
        char c2 = Character.toUpperCase(Character.forDigit(i1 & 0xF, 16));
        localStringBuilder.append(c1);
        localStringBuilder.append(c2);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString, Charset paramCharset, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length());
    paramString = CharBuffer.wrap(paramString);
    while (paramString.hasRemaining())
    {
      int i1 = paramString.get();
      if ((i1 == 37) && (paramString.remaining() >= 2))
      {
        char c1 = paramString.get();
        char c2 = paramString.get();
        i1 = Character.digit(c1, 16);
        int i2 = Character.digit(c2, 16);
        if ((i1 != -1) && (i2 != -1))
        {
          localByteBuffer.put((byte)((i1 << 4) + i2));
        }
        else
        {
          localByteBuffer.put((byte)37);
          localByteBuffer.put((byte)c1);
          localByteBuffer.put((byte)c2);
        }
      }
      else if ((paramBoolean) && (i1 == 43))
      {
        localByteBuffer.put((byte)32);
      }
      else
      {
        localByteBuffer.put((byte)i1);
      }
    }
    localByteBuffer.flip();
    return paramCharset.decode(localByteBuffer).toString();
  }
  
  public static String a(List<? extends ag> paramList, char paramChar, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ag)paramList.next();
      String str = b(((ag)localObject).a(), paramString);
      localObject = b(((ag)localObject).b(), paramString);
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramChar);
      }
      localStringBuilder.append(str);
      if (localObject != null)
      {
        localStringBuilder.append("=");
        localStringBuilder.append((String)localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(List<? extends ag> paramList, String paramString)
  {
    return a(paramList, '&', paramString);
  }
  
  public static List<ag> a(cz.msebera.android.httpclient.n paramn)
    throws IOException
  {
    Object localObject = cz.msebera.android.httpclient.g.g.a(paramn);
    if ((localObject != null) && (((cz.msebera.android.httpclient.g.g)localObject).a().equalsIgnoreCase("application/x-www-form-urlencoded")))
    {
      String str = cz.msebera.android.httpclient.o.g.a(paramn, c.f);
      if ((str != null) && (str.length() > 0))
      {
        localObject = ((cz.msebera.android.httpclient.g.g)localObject).b();
        paramn = (cz.msebera.android.httpclient.n)localObject;
        if (localObject == null) {
          paramn = cz.msebera.android.httpclient.n.f.t;
        }
        return a(str, paramn, e);
      }
    }
    return Collections.emptyList();
  }
  
  public static List<ag> a(String paramString, Charset paramCharset)
  {
    return a(paramString, paramCharset, e);
  }
  
  public static List<ag> a(String paramString, Charset paramCharset, char... paramVarArgs)
  {
    if (paramString == null)
    {
      paramString = Collections.emptyList();
      return paramString;
    }
    cz.msebera.android.httpclient.k.g localg = cz.msebera.android.httpclient.k.g.b;
    d locald = new d(paramString.length());
    locald.a(paramString);
    x localx = new x(0, locald.e());
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramString = localArrayList;
      if (localx.d()) {
        break;
      }
      paramString = localg.a(locald, localx, paramVarArgs);
      if (paramString.a().length() > 0) {
        localArrayList.add(new cz.msebera.android.httpclient.k.n(e(paramString.a(), paramCharset), e(paramString.b(), paramCharset)));
      }
    }
  }
  
  public static List<ag> a(URI paramURI, String paramString)
  {
    paramURI = paramURI.getRawQuery();
    if ((paramURI != null) && (paramURI.length() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, new Scanner(paramURI), f, paramString);
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  public static void a(List<ag> paramList, Scanner paramScanner, String paramString)
  {
    a(paramList, paramScanner, f, paramString);
  }
  
  public static void a(List<ag> paramList, Scanner paramScanner, String paramString1, String paramString2)
  {
    paramScanner.useDelimiter(paramString1);
    if (paramScanner.hasNext())
    {
      String str1 = null;
      String str2 = paramScanner.next();
      int i1 = str2.indexOf("=");
      if (i1 != -1)
      {
        paramString1 = a(str2.substring(0, i1).trim(), paramString2);
        str1 = a(str2.substring(i1 + 1).trim(), paramString2);
      }
      for (;;)
      {
        paramList.add(new cz.msebera.android.httpclient.k.n(paramString1, str1));
        break;
        paramString1 = a(str2.trim(), paramString2);
      }
    }
  }
  
  private static String b(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 != null) {}
    for (paramString2 = Charset.forName(paramString2);; paramString2 = c.e) {
      return a(paramString1, paramString2, m, true);
    }
  }
  
  static String b(String paramString, Charset paramCharset)
  {
    return a(paramString, paramCharset, i, false);
  }
  
  public static boolean b(cz.msebera.android.httpclient.n paramn)
  {
    boolean bool2 = false;
    paramn = paramn.getContentType();
    boolean bool1 = bool2;
    if (paramn != null)
    {
      paramn = paramn.e();
      bool1 = bool2;
      if (paramn.length > 0) {
        bool1 = paramn[0].a().equalsIgnoreCase("application/x-www-form-urlencoded");
      }
    }
    return bool1;
  }
  
  static String c(String paramString, Charset paramCharset)
  {
    return a(paramString, paramCharset, k, false);
  }
  
  static String d(String paramString, Charset paramCharset)
  {
    return a(paramString, paramCharset, j, false);
  }
  
  private static String e(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      return null;
    }
    if (paramCharset != null) {}
    for (;;)
    {
      return a(paramString, paramCharset, true);
      paramCharset = c.e;
    }
  }
  
  private static String f(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      return null;
    }
    if (paramCharset != null) {}
    for (;;)
    {
      return a(paramString, paramCharset, m, true);
      paramCharset = c.e;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/g/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */