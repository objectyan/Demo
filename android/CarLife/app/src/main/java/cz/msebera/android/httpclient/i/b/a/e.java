package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.GuardedBy;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Locale;

@ThreadSafe
class e
{
  private final String a;
  private final SecureRandom b;
  @GuardedBy("this")
  private long c;
  
  public e()
  {
    try
    {
      String str1 = InetAddress.getLocalHost().getHostName();
      this.a = str1;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        try
        {
          this.b = SecureRandom.getInstance("SHA1PRNG");
          return;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          String str2;
          throw new Error(localNoSuchAlgorithmException);
        }
        localUnknownHostException = localUnknownHostException;
        str2 = "localhost";
      }
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void a(StringBuilder paramStringBuilder)
  {
    try
    {
      this.c += 1L;
      int i = this.b.nextInt();
      paramStringBuilder.append(System.currentTimeMillis());
      paramStringBuilder.append('.');
      Formatter localFormatter = new Formatter(paramStringBuilder, Locale.US);
      localFormatter.format("%1$016x-%2$08x", new Object[] { Long.valueOf(this.c), Integer.valueOf(i) });
      localFormatter.close();
      paramStringBuilder.append('.');
      paramStringBuilder.append(this.a);
      return;
    }
    finally
    {
      paramStringBuilder = finally;
      throw paramStringBuilder;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */