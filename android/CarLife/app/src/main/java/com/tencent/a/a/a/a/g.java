package com.tencent.a.a.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class g
{
  private static g d = null;
  private Map<Integer, f> a = null;
  private int b = 0;
  private Context c = null;
  
  private g(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = new HashMap(3);
    this.a.put(Integer.valueOf(1), new e(paramContext));
    this.a.put(Integer.valueOf(2), new b(paramContext));
    this.a.put(Integer.valueOf(4), new d(paramContext));
  }
  
  private c a(List<Integer> paramList)
  {
    if (paramList.size() >= 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Integer)paramList.next();
        localObject = (f)this.a.get(localObject);
        if (localObject != null)
        {
          localObject = ((f)localObject).c();
          if ((localObject != null) && (h.b(((c)localObject).c))) {
            return (c)localObject;
          }
        }
      }
    }
    return new c();
  }
  
  public static g a(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new g(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  public final c a()
  {
    return a(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
  }
  
  public final void a(String paramString)
  {
    c localc = a();
    localc.c = paramString;
    if (!h.a(localc.a)) {
      localc.a = h.a(this.c);
    }
    if (!h.a(localc.b)) {
      localc.b = h.b(this.c);
    }
    localc.d = System.currentTimeMillis();
    paramString = this.a.entrySet().iterator();
    while (paramString.hasNext()) {
      ((f)((Map.Entry)paramString.next()).getValue()).a(localc);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/a/a/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */