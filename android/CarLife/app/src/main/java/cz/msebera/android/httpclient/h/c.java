package cz.msebera.android.httpclient.h;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;

@TargetApi(4)
public final class c
{
  private static final int a = 16;
  private static final int b = 18;
  private static final byte[] c = ;
  
  public static void a()
  {
    c();
    d();
  }
  
  private static void c()
    throws SecurityException
  {
    if ((Build.VERSION.SDK_INT < 16) || (Build.VERSION.SDK_INT > 18)) {}
    for (;;)
    {
      return;
      try
      {
        Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[] { byte[].class }).invoke(null, new Object[] { e() });
        int i = ((Integer)Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[] { String.class, Long.TYPE }).invoke(null, new Object[] { "/dev/urandom", Integer.valueOf(1024) })).intValue();
        if (i == 1024) {
          continue;
        }
        throw new IOException("Unexpected number of bytes read from Linux PRNG: " + i);
      }
      catch (Exception localException)
      {
        throw new SecurityException("Failed to seed OpenSSL PRNG", localException);
      }
    }
  }
  
  private static void d()
    throws SecurityException
  {
    if (Build.VERSION.SDK_INT > 18) {}
    for (;;)
    {
      return;
      Object localObject = Security.getProviders("SecureRandom.SHA1PRNG");
      if ((localObject == null) || (localObject.length < 1) || (!b.class.equals(localObject[0].getClass()))) {
        Security.insertProviderAt(new b(), 1);
      }
      localObject = new SecureRandom();
      if (!b.class.equals(((SecureRandom)localObject).getProvider().getClass())) {
        throw new SecurityException("new SecureRandom() backed by wrong Provider: " + ((SecureRandom)localObject).getProvider().getClass());
      }
      try
      {
        localObject = SecureRandom.getInstance("SHA1PRNG");
        if (b.class.equals(((SecureRandom)localObject).getProvider().getClass())) {
          continue;
        }
        throw new SecurityException("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: " + ((SecureRandom)localObject).getProvider().getClass());
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new SecurityException("SHA1PRNG not available", localNoSuchAlgorithmException);
      }
    }
  }
  
  private static byte[] e()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(System.currentTimeMillis());
      localDataOutputStream.writeLong(System.nanoTime());
      localDataOutputStream.writeInt(Process.myPid());
      localDataOutputStream.writeInt(Process.myUid());
      localDataOutputStream.write(c);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new SecurityException("Failed to generate seed", localIOException);
    }
  }
  
  private static String f()
  {
    try
    {
      String str = (String)Build.class.getField("SERIAL").get(null);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static byte[] g()
  {
    Object localObject = new StringBuilder();
    String str = Build.FINGERPRINT;
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    str = f();
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    try
    {
      localObject = ((StringBuilder)localObject).toString().getBytes("UTF-8");
      return (byte[])localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 encoding not supported");
    }
  }
  
  public static class a
    extends SecureRandomSpi
  {
    private static final File a = new File("/dev/urandom");
    private static final Object b = new Object();
    private static DataInputStream c;
    private static OutputStream d;
    private boolean e;
    
    private DataInputStream a()
    {
      synchronized (b)
      {
        DataInputStream localDataInputStream = c;
        if (localDataInputStream == null) {}
        try
        {
          c = new DataInputStream(new FileInputStream(a));
          localDataInputStream = c;
          return localDataInputStream;
        }
        catch (IOException localIOException)
        {
          throw new SecurityException("Failed to open " + a + " for reading", localIOException);
        }
      }
    }
    
    private OutputStream b()
      throws IOException
    {
      synchronized (b)
      {
        if (d == null) {
          d = new FileOutputStream(a);
        }
        OutputStream localOutputStream = d;
        return localOutputStream;
      }
    }
    
    protected byte[] engineGenerateSeed(int paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      engineNextBytes(arrayOfByte);
      return arrayOfByte;
    }
    
    /* Error */
    protected void engineNextBytes(byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 89	cz/msebera/android/httpclient/h/c$a:e	Z
      //   4: ifne +10 -> 14
      //   7: aload_0
      //   8: invokestatic 92	cz/msebera/android/httpclient/h/c:b	()[B
      //   11: invokevirtual 95	cz/msebera/android/httpclient/h/c$a:engineSetSeed	([B)V
      //   14: getstatic 34	cz/msebera/android/httpclient/h/c$a:b	Ljava/lang/Object;
      //   17: astore_2
      //   18: aload_2
      //   19: monitorenter
      //   20: aload_0
      //   21: invokespecial 97	cz/msebera/android/httpclient/h/c$a:a	()Ljava/io/DataInputStream;
      //   24: astore_3
      //   25: aload_2
      //   26: monitorexit
      //   27: aload_3
      //   28: monitorenter
      //   29: aload_3
      //   30: aload_1
      //   31: invokevirtual 100	java/io/DataInputStream:readFully	([B)V
      //   34: aload_3
      //   35: monitorexit
      //   36: return
      //   37: astore_1
      //   38: aload_2
      //   39: monitorexit
      //   40: aload_1
      //   41: athrow
      //   42: astore_1
      //   43: new 53	java/lang/SecurityException
      //   46: dup
      //   47: new 55	java/lang/StringBuilder
      //   50: dup
      //   51: invokespecial 56	java/lang/StringBuilder:<init>	()V
      //   54: ldc 102
      //   56: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   59: getstatic 28	cz/msebera/android/httpclient/h/c$a:a	Ljava/io/File;
      //   62: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   65: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   68: aload_1
      //   69: invokespecial 74	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   72: athrow
      //   73: astore_1
      //   74: aload_3
      //   75: monitorexit
      //   76: aload_1
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	paramArrayOfByte	byte[]
      //   24	51	3	localDataInputStream	DataInputStream
      // Exception table:
      //   from	to	target	type
      //   20	27	37	finally
      //   38	40	37	finally
      //   14	20	42	java/io/IOException
      //   27	29	42	java/io/IOException
      //   40	42	42	java/io/IOException
      //   76	78	42	java/io/IOException
      //   29	36	73	finally
      //   74	76	73	finally
    }
    
    /* Error */
    protected void engineSetSeed(byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: getstatic 34	cz/msebera/android/httpclient/h/c$a:b	Ljava/lang/Object;
      //   3: astore_2
      //   4: aload_2
      //   5: monitorenter
      //   6: aload_0
      //   7: invokespecial 104	cz/msebera/android/httpclient/h/c$a:b	()Ljava/io/OutputStream;
      //   10: astore_3
      //   11: aload_2
      //   12: monitorexit
      //   13: aload_3
      //   14: aload_1
      //   15: invokevirtual 109	java/io/OutputStream:write	([B)V
      //   18: aload_3
      //   19: invokevirtual 112	java/io/OutputStream:flush	()V
      //   22: aload_0
      //   23: iconst_1
      //   24: putfield 89	cz/msebera/android/httpclient/h/c$a:e	Z
      //   27: return
      //   28: astore_1
      //   29: aload_2
      //   30: monitorexit
      //   31: aload_1
      //   32: athrow
      //   33: astore_1
      //   34: ldc 6
      //   36: invokevirtual 117	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   39: new 55	java/lang/StringBuilder
      //   42: dup
      //   43: invokespecial 56	java/lang/StringBuilder:<init>	()V
      //   46: ldc 119
      //   48: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: getstatic 28	cz/msebera/android/httpclient/h/c$a:a	Ljava/io/File;
      //   54: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   57: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   60: invokestatic 125	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   63: pop
      //   64: aload_0
      //   65: iconst_1
      //   66: putfield 89	cz/msebera/android/httpclient/h/c$a:e	Z
      //   69: return
      //   70: astore_1
      //   71: aload_0
      //   72: iconst_1
      //   73: putfield 89	cz/msebera/android/httpclient/h/c$a:e	Z
      //   76: aload_1
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	paramArrayOfByte	byte[]
      //   10	9	3	localOutputStream	OutputStream
      // Exception table:
      //   from	to	target	type
      //   6	13	28	finally
      //   29	31	28	finally
      //   0	6	33	java/io/IOException
      //   13	22	33	java/io/IOException
      //   31	33	33	java/io/IOException
      //   0	6	70	finally
      //   13	22	70	finally
      //   31	33	70	finally
      //   34	64	70	finally
    }
  }
  
  private static class b
    extends Provider
  {
    public b()
    {
      super(1.0D, "A Linux-specific random number provider that uses /dev/urandom");
      put("SecureRandom.SHA1PRNG", c.a.class.getName());
      put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/h/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */