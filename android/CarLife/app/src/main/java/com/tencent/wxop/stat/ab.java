package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.e;
import com.tencent.wxop.stat.b.b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

class ab
  implements Runnable
{
  private Context a = null;
  private Map<String, Integer> b = null;
  private k c = null;
  
  public ab(Context paramContext, Map<String, Integer> paramMap, k paramk)
  {
    this.a = paramContext;
    this.c = paramk;
    if (paramMap != null) {
      this.b = paramMap;
    }
  }
  
  private c a(String paramString, int paramInt)
  {
    c localc = new c();
    Socket localSocket = new Socket();
    int i = 0;
    for (;;)
    {
      try
      {
        localc.a(paramString);
        localc.b(paramInt);
        long l = System.currentTimeMillis();
        paramString = new InetSocketAddress(paramString, paramInt);
        localSocket.connect(paramString, 30000);
        localc.a(System.currentTimeMillis() - l);
        localc.b(paramString.getAddress().getHostAddress());
        localSocket.close();
      }
      catch (IOException paramString)
      {
        paramString = paramString;
        paramInt = -1;
        j.g().b(paramString);
        try
        {
          localSocket.close();
        }
        catch (Throwable paramString)
        {
          j.g().b(paramString);
        }
        continue;
      }
      finally {}
      try
      {
        localSocket.close();
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        j.g().b(paramString);
        paramInt = i;
      }
    }
    localc.a(paramInt);
    return localc;
    try
    {
      localSocket.close();
      throw paramString;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j.g().b(localThrowable);
      }
    }
  }
  
  private Map<String, Integer> a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = f.b("__MTA_TEST_SPEED__", null);
    if ((localObject == null) || (((String)localObject).trim().length() == 0)) {}
    for (;;)
    {
      return localHashMap;
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = localObject[i].split(",");
        String str;
        if ((arrayOfString != null) && (arrayOfString.length == 2))
        {
          str = arrayOfString[0];
          if ((str == null) || (str.trim().length() == 0)) {}
        }
        try
        {
          int k = Integer.valueOf(arrayOfString[1]).intValue();
          localHashMap.put(str, Integer.valueOf(k));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            j.g().b(localNumberFormatException);
          }
        }
        i += 1;
      }
    }
  }
  
  public void run()
  {
    Object localObject;
    for (;;)
    {
      Map.Entry localEntry;
      String str;
      try
      {
        if (this.b == null) {
          this.b = a();
        }
        if ((this.b == null) || (this.b.size() == 0))
        {
          j.g().b("empty domain list.");
          return;
        }
        JSONArray localJSONArray = new JSONArray();
        localObject = this.b.entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject).next();
        str = (String)localEntry.getKey();
        if ((str == null) || (str.length() == 0))
        {
          j.g().f("empty domain name.");
          continue;
        }
        if ((Integer)localEntry.getValue() != null) {
          break label167;
        }
      }
      catch (Throwable localThrowable)
      {
        j.g().b(localThrowable);
        return;
      }
      j.g().f("port is null for " + str);
      continue;
      label167:
      localThrowable.put(a((String)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue()).f());
    }
    if (localThrowable.length() != 0)
    {
      localObject = new com.tencent.wxop.stat.a.j(this.a, j.a(this.a, false, this.c), this.c);
      ((com.tencent.wxop.stat.a.j)localObject).a(localThrowable.toString());
      new ac((e)localObject).a();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */