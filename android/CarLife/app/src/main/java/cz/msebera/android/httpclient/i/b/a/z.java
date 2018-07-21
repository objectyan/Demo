package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.a.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@ThreadSafe
public class z
  implements l
{
  private static final long a = 4132244415919043397L;
  private final File b;
  private volatile boolean c;
  
  public z(File paramFile)
  {
    this.b = paramFile;
    this.c = false;
  }
  
  public InputStream a()
    throws IOException
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(this.b);
      return localFileInputStream;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long b()
  {
    try
    {
      long l = this.b.length();
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	cz/msebera/android/httpclient/i/b/a/z:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 24	cz/msebera/android/httpclient/i/b/a/z:c	Z
    //   19: aload_0
    //   20: getfield 22	cz/msebera/android/httpclient/i/b/a/z:b	Ljava/io/File;
    //   23: invokevirtual 43	java/io/File:delete	()Z
    //   26: pop
    //   27: goto -16 -> 11
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	z
    //   6	2	1	bool	boolean
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	30	finally
    //   14	27	30	finally
  }
  
  File d()
  {
    try
    {
      File localFile = this.b;
      return localFile;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */