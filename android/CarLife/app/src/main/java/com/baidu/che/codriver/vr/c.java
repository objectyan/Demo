package com.baidu.che.codriver.vr;

import android.text.TextUtils;
import com.baidu.che.codriver.util.h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c
  implements i
{
  public static final String a = "CustomCommandInterceptor";
  private Map<String, Set<String>> b = new HashMap();
  private f c;
  
  public c(f paramf)
  {
    this.c = paramf;
  }
  
  public void a(String paramString)
  {
    h.b("CustomCommandInterceptor", "unRegisterAll pkg=" + paramString);
    this.b.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    h.b("CustomCommandInterceptor", "registerCommand pkg=" + paramString1 + " words=" + paramString2);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (this.b.containsKey(paramString1)) {
        ((Set)this.b.get(paramString1)).addAll(Arrays.asList(paramString2.split(",")));
      }
    }
    else {
      return;
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(Arrays.asList(paramString2.split(",")));
    this.b.put(paramString1, localHashSet);
  }
  
  public void b(String paramString1, String paramString2)
  {
    h.b("CustomCommandInterceptor", "unRegisterCommand pkg=" + paramString1 + " words=" + paramString2);
    paramString1 = (Set)this.b.get(paramString1);
    if ((paramString1 != null) && (paramString2 != null)) {
      paramString1.removeAll(Arrays.asList(paramString2.split(",")));
    }
  }
  
  public boolean b(String paramString)
  {
    h.b("CustomCommandInterceptor", "onIntercept result:" + paramString);
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((((Set)this.b.get(str)).contains(paramString)) && (this.c != null))
      {
        this.c.a(str, paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */