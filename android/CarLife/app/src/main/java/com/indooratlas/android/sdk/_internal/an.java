package com.indooratlas.android.sdk._internal;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class an
  extends u
{
  static String d;
  public static final Charset f;
  private static final gg k;
  gh e;
  private String h;
  private Map<String, String> i = null;
  private al j;
  
  static
  {
    if (!an.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      d = ee.a(ac.class);
      k = gg.a("application/json");
      f = Charset.forName("UTF-8");
      return;
    }
  }
  
  public an(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, (byte)0);
  }
  
  private an(String paramString1, String paramString2, byte paramByte)
  {
    super(paramString1, w.a);
    paramString1 = new gh.a().a(TimeUnit.SECONDS).c(TimeUnit.SECONDS).b(TimeUnit.SECONDS).a(new ak()).a(new aj()).b(new ap(this));
    ei.a(null);
    this.e = paramString1.b();
    this.h = eg.a(paramString2, "userAgent must be non empty", new Object[0]);
  }
  
  @SuppressLint({"Assert"})
  private gk b(@NonNull String paramString1, @NonNull String paramString2, @Nullable byte[] paramArrayOfByte, @Nullable String paramString3, @Nullable String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        Object localObject = new URL(paramString1);
        if (paramString3 == null)
        {
          localgg = k;
          localObject = new gk.a().a((URL)localObject);
          if (paramArrayOfByte == null) {
            break label266;
          }
          paramArrayOfByte = gl.a(localgg, paramArrayOfByte);
          paramString2 = ((gk.a)localObject).a(paramString2, paramArrayOfByte).a("User-Agent", this.h).a("Date", af.a()).a("Connection", "Keep-Alive");
          if (paramString3 != null) {
            paramString2.a("Content-Type", paramString3);
          }
          if (this.i == null) {
            break;
          }
          paramArrayOfByte = this.i.entrySet().iterator();
          if (!paramArrayOfByte.hasNext()) {
            break;
          }
          paramString3 = (Map.Entry)paramArrayOfByte.next();
          paramString2.a((String)paramString3.getKey(), (String)paramString3.getValue());
          continue;
        }
        gg localgg = gg.a(paramString3);
      }
      catch (MalformedURLException paramString2)
      {
        throw new IllegalArgumentException("bad url: " + paramString1);
      }
    }
    if (paramArrayOfString != null)
    {
      if ((g) || (paramArrayOfString.length % 2 == 0)) {
        break label271;
      }
      throw new AssertionError("headers must be pairs of key value");
    }
    for (;;)
    {
      int m;
      if (m < paramArrayOfString.length)
      {
        paramString2.a(paramArrayOfString[m], paramArrayOfString[(m + 1)]);
        m += 2;
      }
      else
      {
        paramString2 = paramString2.a();
        return paramString2;
        label266:
        paramArrayOfByte = null;
        break;
        label271:
        m = 0;
      }
    }
  }
  
  protected final gk a(@NonNull String paramString1, @NonNull String paramString2, @Nullable byte[] paramArrayOfByte, @Nullable String paramString3, @Nullable String[] paramArrayOfString)
  {
    return b(paramString1, paramString2, paramArrayOfByte, paramString3, paramArrayOfString);
  }
  
  public final void a(String paramString)
  {
    d = paramString;
    boolean bool = ee.a(paramString, 2);
    if ((bool) && (this.j == null))
    {
      this.j = new al();
      this.e = this.e.b().b(this.j).b();
    }
    while ((bool) || (this.j == null)) {
      return;
    }
    paramString = this.e.b();
    paramString.a().remove(this.j);
    this.j = null;
    this.e = paramString.b();
  }
  
  protected final gk b(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, "POST", paramArrayOfByte, "application/json", null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */