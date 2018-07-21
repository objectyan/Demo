package com.indooratlas.android.sdk._internal;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

public final class ah
{
  String a;
  a b;
  public ArrayList<b> c;
  private StringBuilder d = new StringBuilder();
  private String e;
  
  static String b()
  {
    try
    {
      String str = URLEncoder.encode(null, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException("cannot encode query param, UTF-8 missing", localUnsupportedEncodingException);
    }
  }
  
  public final ah a(String paramString, Object... paramVarArgs)
  {
    String str = eg.a(paramString, "path cannot be null", new Object[0]);
    paramString = str;
    if (!str.startsWith("/")) {
      paramString = "/" + str;
    }
    this.e = String.format(Locale.US, paramString, paramVarArgs);
    return this;
  }
  
  public final String a()
  {
    int i = 0;
    eg.a(this.b, "url version was never set", new Object[0]);
    eg.a(this.a, "endpoint must be non empty", new Object[0]);
    this.d.setLength(0);
    StringBuilder localStringBuilder = this.d;
    Object localObject2 = this.a;
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("/")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    localStringBuilder.append((String)localObject1);
    this.d.append(this.b.f);
    this.d.append(this.e);
    localObject1 = this.d;
    if ((this.c == null) || (this.c.isEmpty())) {}
    for (;;)
    {
      return this.d.toString();
      if (((StringBuilder)localObject1).indexOf("?") == -1) {
        ((StringBuilder)localObject1).append('?');
      }
      int j = this.c.size();
      while (i < j)
      {
        localObject2 = (b)this.c.get(i);
        ((StringBuilder)localObject1).append(((b)localObject2).a).append('=').append(((b)localObject2).b);
        if (i < j - 1) {
          ((StringBuilder)localObject1).append('&');
        }
        i += 1;
      }
    }
  }
  
  public static enum a
  {
    final String f;
    
    private a(String paramString)
    {
      this.f = paramString;
    }
  }
  
  public static final class b
  {
    String a;
    String b;
    
    public b(String paramString)
    {
      this.a = paramString;
      this.b = ah.b();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */