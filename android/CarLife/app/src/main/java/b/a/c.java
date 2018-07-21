package b.a;

import b.ac;
import b.ae;
import b.u;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class c
{
  public static final byte[] a = new byte[0];
  public static final String[] b = new String[0];
  public static final ae c = ae.a(null, a);
  public static final ac d = ac.a(null, a);
  public static final Charset e;
  public static final TimeZone f = TimeZone.getTimeZone("GMT");
  private static final ByteString g = ByteString.decodeHex("efbbbf");
  private static final ByteString h = ByteString.decodeHex("feff");
  private static final ByteString i = ByteString.decodeHex("fffe");
  private static final ByteString j = ByteString.decodeHex("0000ffff");
  private static final ByteString k = ByteString.decodeHex("ffff0000");
  private static final Charset l;
  private static final Charset m;
  private static final Charset n;
  private static final Charset o;
  private static final Pattern p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  static
  {
    e = Charset.forName("UTF-8");
    l = Charset.forName("UTF-16BE");
    m = Charset.forName("UTF-16LE");
    n = Charset.forName("UTF-32BE");
    o = Charset.forName("UTF-32LE");
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      switch (paramString.charAt(paramInt1))
      {
      default: 
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static <T> int a(T[] paramArrayOfT, T paramT)
  {
    int i1 = 0;
    int i2 = paramArrayOfT.length;
    while (i1 < i2)
    {
      if (a(paramArrayOfT[i1], paramT)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public static String a(u paramu, boolean paramBoolean)
  {
    if (paramu.i().contains(":")) {}
    for (String str1 = "[" + paramu.i() + "]";; str1 = paramu.i())
    {
      String str2;
      if (!paramBoolean)
      {
        str2 = str1;
        if (paramu.j() == u.a(paramu.c())) {}
      }
      else
      {
        str2 = str1 + ":" + paramu.j();
      }
      return str2;
    }
  }
  
  public static String a(String paramString)
  {
    int i1 = 0;
    int i4 = paramString.length();
    int i2;
    for (;;)
    {
      localObject = paramString;
      if (i1 >= i4) {
        break label119;
      }
      i2 = paramString.codePointAt(i1);
      if ((i2 <= 31) || (i2 >= 127)) {
        break;
      }
      i1 += Character.charCount(i2);
    }
    Object localObject = new Buffer();
    ((Buffer)localObject).writeUtf8(paramString, 0, i1);
    if (i1 < i4)
    {
      int i3 = paramString.codePointAt(i1);
      if ((i3 > 31) && (i3 < 127)) {}
      for (i2 = i3;; i2 = 63)
      {
        ((Buffer)localObject).writeUtf8CodePoint(i2);
        i1 += Character.charCount(i3);
        break;
      }
    }
    localObject = ((Buffer)localObject).readUtf8();
    label119:
    return (String)localObject;
  }
  
  public static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static Charset a(BufferedSource paramBufferedSource, Charset paramCharset)
    throws IOException
  {
    if (paramBufferedSource.rangeEquals(0L, g))
    {
      paramBufferedSource.skip(g.size());
      paramCharset = e;
    }
    do
    {
      return paramCharset;
      if (paramBufferedSource.rangeEquals(0L, h))
      {
        paramBufferedSource.skip(h.size());
        return l;
      }
      if (paramBufferedSource.rangeEquals(0L, i))
      {
        paramBufferedSource.skip(i.size());
        return m;
      }
      if (paramBufferedSource.rangeEquals(0L, j))
      {
        paramBufferedSource.skip(j.size());
        return n;
      }
    } while (!paramBufferedSource.rangeEquals(0L, k));
    paramBufferedSource.skip(k.size());
    return o;
  }
  
  public static <T> List<T> a(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static <T> List<T> a(T... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  private static <T> List<T> a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfT1.length;
    int i1 = 0;
    if (i1 < i3)
    {
      T ? = paramArrayOfT1[i1];
      int i4 = paramArrayOfT2.length;
      int i2 = 0;
      for (;;)
      {
        if (i2 < i4)
        {
          T ? = paramArrayOfT2[i2];
          if (?.equals(?)) {
            localArrayList.add(?);
          }
        }
        else
        {
          i1 += 1;
          break;
        }
        i2 += 1;
      }
    }
    return localArrayList;
  }
  
  public static ThreadFactory a(String paramString, final boolean paramBoolean)
  {
    new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, this.a);
        paramAnonymousRunnable.setDaemon(paramBoolean);
        return paramAnonymousRunnable;
      }
    };
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3)) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof VirtualMachineError)) {
      throw ((VirtualMachineError)paramThrowable);
    }
    if ((paramThrowable instanceof ThreadDeath)) {
      throw ((ThreadDeath)paramThrowable);
    }
    if ((paramThrowable instanceof LinkageError)) {
      throw ((LinkageError)paramThrowable);
    }
  }
  
  public static void a(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null) {}
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (RuntimeException paramServerSocket)
    {
      throw paramServerSocket;
    }
    catch (Exception paramServerSocket) {}
  }
  
  public static void a(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (AssertionError paramSocket)
    {
      while (a(paramSocket)) {}
      throw paramSocket;
    }
    catch (RuntimeException paramSocket)
    {
      throw paramSocket;
    }
    catch (Exception paramSocket) {}
  }
  
  public static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean a(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = b(paramSource, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException paramSource) {}
    return false;
  }
  
  public static <T> T[] a(Class<T> paramClass, T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    paramArrayOfT1 = a(paramArrayOfT1, paramArrayOfT2);
    return paramArrayOfT1.toArray((Object[])Array.newInstance(paramClass, paramArrayOfT1.size()));
  }
  
  public static String[] a(String[] paramArrayOfString, String paramString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    return arrayOfString;
  }
  
  public static int b(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    for (;;)
    {
      int i1 = paramInt1;
      if (paramInt2 >= paramInt1) {}
      switch (paramString.charAt(paramInt2))
      {
      default: 
        i1 = paramInt2 + 1;
        return i1;
      }
      paramInt2 -= 1;
    }
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      if (paramString.isEmpty()) {
        return null;
      }
      boolean bool = d(paramString);
      if (bool) {
        return null;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      paramString = null;
    }
    return paramString;
  }
  
  public static boolean b(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
    throws IOException
  {
    long l2 = System.nanoTime();
    long l1;
    if (paramSource.timeout().hasDeadline()) {
      l1 = paramSource.timeout().deadlineNanoTime() - l2;
    }
    for (;;)
    {
      paramSource.timeout().deadlineNanoTime(Math.min(l1, paramTimeUnit.toNanos(paramInt)) + l2);
      try
      {
        paramTimeUnit = new Buffer();
        while (paramSource.read(paramTimeUnit, 8192L) != -1L) {
          paramTimeUnit.clear();
        }
      }
      catch (InterruptedIOException paramTimeUnit)
      {
        if (l1 == Long.MAX_VALUE) {
          paramSource.timeout().clearDeadline();
        }
        for (;;)
        {
          return false;
          l1 = Long.MAX_VALUE;
          break;
          if (l1 == Long.MAX_VALUE) {
            paramSource.timeout().clearDeadline();
          }
          for (;;)
          {
            return true;
            paramSource.timeout().deadlineNanoTime(l2 + l1);
          }
          paramSource.timeout().deadlineNanoTime(l2 + l1);
        }
      }
      finally
      {
        if (l1 != Long.MAX_VALUE) {
          break label188;
        }
      }
    }
    paramSource.timeout().clearDeadline();
    for (;;)
    {
      throw paramTimeUnit;
      label188:
      paramSource.timeout().deadlineNanoTime(l2 + l1);
    }
  }
  
  public static String c(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, b(paramString, paramInt1, paramInt2));
  }
  
  public static boolean c(String paramString)
  {
    return p.matcher(paramString).matches();
  }
  
  private static boolean d(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      int i2 = paramString.charAt(i1);
      if ((i2 <= 31) || (i2 >= 127)) {}
      while (" #%/:?@[\\]".indexOf(i2) != -1) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */