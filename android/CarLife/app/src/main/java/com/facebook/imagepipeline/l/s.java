package com.facebook.imagepipeline.l;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.i.d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class s
  extends c<r>
{
  public static final int a = 307;
  public static final int b = 308;
  private static final int c = 3;
  private static final int d = 5;
  private final ExecutorService e;
  
  public s()
  {
    this(Executors.newFixedThreadPool(3));
  }
  
  @VisibleForTesting
  s(ExecutorService paramExecutorService)
  {
    this.e = paramExecutorService;
  }
  
  private static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.getDefault(), paramString, paramVarArgs);
  }
  
  @VisibleForTesting
  static HttpURLConnection a(Uri paramUri)
    throws IOException
  {
    return (HttpURLConnection)new URL(paramUri.toString()).openConnection();
  }
  
  private HttpURLConnection a(Uri paramUri, int paramInt)
    throws IOException
  {
    Object localObject = a(paramUri);
    int i = ((HttpURLConnection)localObject).getResponseCode();
    if (a(i)) {
      return (HttpURLConnection)localObject;
    }
    if (b(i))
    {
      String str = ((HttpURLConnection)localObject).getHeaderField("Location");
      ((HttpURLConnection)localObject).disconnect();
      if (str == null) {}
      for (localObject = null;; localObject = Uri.parse(str))
      {
        str = paramUri.getScheme();
        if ((paramInt <= 0) || (localObject == null) || (((Uri)localObject).getScheme().equals(str))) {
          break;
        }
        return a((Uri)localObject, paramInt - 1);
      }
      if (paramInt == 0) {}
      for (paramUri = a("URL %s follows too many redirects", new Object[] { paramUri.toString() });; paramUri = a("URL %s returned %d without a valid redirect", new Object[] { paramUri.toString(), Integer.valueOf(i) })) {
        throw new IOException(paramUri);
      }
    }
    ((HttpURLConnection)localObject).disconnect();
    throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[] { paramUri.toString(), Integer.valueOf(i) }));
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 300);
  }
  
  private static boolean b(int paramInt)
  {
    switch (paramInt)
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      return false;
    }
    return true;
  }
  
  public void a(final r paramr, final ae.a parama)
  {
    final Future localFuture = this.e.submit(new Runnable()
    {
      public void run()
      {
        s.this.b(paramr, parama);
      }
    });
    paramr.b().a(new e()
    {
      public void a()
      {
        if (localFuture.cancel(false)) {
          parama.a();
        }
      }
    });
  }
  
  public r b(j<d> paramj, aj paramaj)
  {
    return new r(paramj, paramaj);
  }
  
  @VisibleForTesting
  void b(r paramr, ae.a parama)
  {
    Object localObject = null;
    r localr = null;
    try
    {
      paramr = a(paramr.e(), 5);
      if (paramr != null)
      {
        localr = paramr;
        localObject = paramr;
        parama.a(paramr.getInputStream(), -1);
      }
      if (paramr != null) {
        paramr.disconnect();
      }
      return;
    }
    catch (IOException paramr)
    {
      do
      {
        localObject = localr;
        parama.a(paramr);
      } while (localr == null);
      localr.disconnect();
      return;
    }
    finally
    {
      if (localObject != null) {
        ((HttpURLConnection)localObject).disconnect();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */