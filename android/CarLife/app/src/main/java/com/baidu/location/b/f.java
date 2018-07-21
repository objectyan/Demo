package com.baidu.location.b;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.Jni;
import com.baidu.location.h.b;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
{
  private static Object a = new Object();
  private static f b = null;
  private Handler c = null;
  private String d = null;
  private int e = 24;
  private a f = null;
  private long g = 0L;
  
  public static f a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new f();
      }
      f localf = b;
      return localf;
    }
  }
  
  private Object a(Object paramObject, String paramString)
    throws Exception
  {
    return paramObject.getClass().getField(paramString).get(paramObject);
  }
  
  private List<b> a(List<WifiConfiguration> paramList)
  {
    String str = null;
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() > 0)
      {
        localObject = new ArrayList();
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
            str = localWifiConfiguration.SSID;
            try
            {
              i = ((Integer)a(localWifiConfiguration, "numAssociation")).intValue();
              if ((i > 0) && (str != null)) {
                ((List)localObject).add(new b(str, i));
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
                int i = 0;
              }
            }
          }
        }
      }
    }
    return (List<b>)localObject;
  }
  
  private void a(boolean paramBoolean, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (this.f == null) {
      this.f = new a();
    }
    this.f.a(paramBoolean, paramJSONArray1, paramJSONArray2);
  }
  
  private void d()
  {
    long l2;
    Object localObject4;
    boolean bool;
    Object localObject5;
    Object localObject6;
    int i;
    long l1;
    label105:
    Object localObject7;
    Object localObject8;
    if (this.d != null) {
      try
      {
        Object localObject1 = new File(this.d, "wcnf.dat");
        l2 = System.currentTimeMillis();
        localObject4 = null;
        bool = ((File)localObject1).exists();
        if (!bool) {
          break label586;
        }
        try
        {
          localObject1 = new BufferedReader(new FileReader((File)localObject1));
          localObject5 = new StringBuffer();
          for (;;)
          {
            localObject6 = ((BufferedReader)localObject1).readLine();
            if (localObject6 == null) {
              break;
            }
            ((StringBuffer)localObject5).append((String)localObject6);
          }
          localException1.printStackTrace();
        }
        catch (Exception localException1)
        {
          i = 1;
          l1 = l2;
        }
        if (i == 0) {
          this.e *= 4;
        }
        if (System.currentTimeMillis() - l1 > this.e * 60 * 60 * 1000)
        {
          JSONArray localJSONArray = null;
          localObject7 = null;
          localObject5 = null;
          localObject8 = a(com.baidu.location.f.f.a().d());
          if (l1 != 0L) {
            break label621;
          }
          if ((localObject8 == null) || (((List)localObject8).size() <= 0)) {
            break label901;
          }
          localObject5 = new JSONArray();
          localJSONArray = new JSONArray();
          localObject4 = ((List)localObject8).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject6 = (b)((Iterator)localObject4).next();
            localObject7 = new JSONObject();
            ((JSONObject)localObject7).put("ssid", ((b)localObject6).a);
            ((JSONObject)localObject7).put("num", ((b)localObject6).b);
            ((JSONArray)localObject5).put(localObject7);
            localJSONArray.put(localObject7);
          }
        }
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    label297:
    localException2.close();
    Object localObject2 = ((StringBuffer)localObject5).toString();
    label363:
    long l3;
    if (localObject2 != null)
    {
      localObject2 = new JSONObject(new String(Base64.decode(((String)localObject2).getBytes())));
      if (((JSONObject)localObject2).has("ison"))
      {
        i = ((JSONObject)localObject2).getInt("ison");
        if (i == 0)
        {
          i = 0;
          l3 = l2;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (((JSONObject)localObject2).has("cfg"))
        {
          l3 = l2;
          localObject5 = ((JSONObject)localObject2).getJSONObject("cfg");
          l3 = l2;
          if (((JSONObject)localObject5).has("frq"))
          {
            l3 = l2;
            this.e = ((JSONObject)localObject5).getInt("frq");
          }
        }
        l1 = l2;
        l3 = l2;
        if (((JSONObject)localObject2).has("tt"))
        {
          l3 = l2;
          l1 = ((JSONObject)localObject2).getLong("tt");
        }
        l3 = l1;
        if (!((JSONObject)localObject2).has("data")) {
          break label910;
        }
        l3 = l1;
        localObject5 = ((JSONObject)localObject2).getJSONArray("data");
        l3 = l1;
        localObject2 = new HashMap();
      }
      catch (Exception localException3)
      {
        int k;
        int j;
        label586:
        label621:
        l1 = l3;
      }
      try
      {
        k = ((JSONArray)localObject5).length();
        j = 0;
        if (j < k)
        {
          localObject4 = ((JSONArray)localObject5).getJSONObject(j);
          if ((((JSONObject)localObject4).has("ssid")) && (((JSONObject)localObject4).has("num")))
          {
            localObject6 = new b(((JSONObject)localObject4).getString("ssid"), ((JSONObject)localObject4).getInt("num"));
            ((Map)localObject2).put(((JSONObject)localObject4).getString("ssid"), localObject6);
          }
          j += 1;
          continue;
        }
        localObject4 = localObject2;
      }
      catch (Exception localException4)
      {
        localObject4 = localException3;
        localObject3 = localException4;
      }
      localObject4 = null;
      l1 = 0L;
      i = 1;
      break label105;
      bool = true;
      if ((localObject5 != null) && (localObject2 != null))
      {
        a(bool, (JSONArray)localObject5, (JSONArray)localObject2);
        return;
        if ((localObject8 != null) && (((List)localObject8).size() > 0))
        {
          localObject6 = new JSONArray();
          localObject5 = localObject7;
          if (localObject4 != null)
          {
            localObject5 = localObject7;
            if (((Map)localObject4).size() > 0)
            {
              localObject7 = ((List)localObject8).iterator();
              localObject5 = localObject2;
              if (((Iterator)localObject7).hasNext())
              {
                localObject5 = (b)((Iterator)localObject7).next();
                localObject8 = new JSONObject();
                ((JSONObject)localObject8).put("ssid", ((b)localObject5).a);
                ((JSONObject)localObject8).put("num", ((b)localObject5).b);
                ((JSONArray)localObject6).put(localObject8);
                if (((Map)localObject4).containsKey(((b)localObject5).a))
                {
                  if (((b)localObject5).b == ((b)((Map)localObject4).get(((b)localObject5).a)).b) {
                    break label886;
                  }
                  i = 1;
                  if (i == 0) {
                    break label883;
                  }
                  if (localObject2 == null)
                  {
                    localObject2 = new JSONArray();
                    localObject8 = new JSONObject();
                    ((JSONObject)localObject8).put("ssid", ((b)localObject5).a);
                    ((JSONObject)localObject8).put("num", ((b)localObject5).b);
                    ((JSONArray)localObject2).put(localObject8);
                  }
                }
                else
                {
                  i = 1;
                  continue;
                  break;
                  break;
                }
                continue;
                label883:
                continue;
                label886:
                i = 0;
                continue;
              }
            }
          }
          bool = false;
          localObject3 = localObject6;
          continue;
        }
        label901:
        localObject3 = null;
        bool = false;
        continue;
      }
      break label297;
      label910:
      Object localObject3 = null;
      continue;
      i = 1;
      break label363;
      l1 = l2;
      localObject3 = null;
      i = 1;
    }
  }
  
  public void b()
  {
    if (this.c == null) {
      this.c = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          }
          f.a(f.this);
        }
      };
    }
    this.d = g.k();
  }
  
  public void c()
  {
    if ((System.currentTimeMillis() - this.g > 3600000L) && (this.c != null))
    {
      this.c.sendEmptyMessage(1);
      this.g = System.currentTimeMillis();
    }
  }
  
  private class a
    extends e
  {
    private boolean b = false;
    private int c = 0;
    private JSONArray d = null;
    private JSONArray e = null;
    
    a()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = g.i();
      this.k.clear();
      this.k.put("qt", "cltrw");
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("data", this.d);
        ((JSONObject)localObject).put("frt", this.c);
        localObject = Jni.encodeOfflineLocationUpdateRequest(((JSONObject)localObject).toString());
        this.k.put("cltr[0]", "" + (String)localObject);
        this.k.put("cfg", Integer.valueOf(1));
        this.k.put("info", Jni.encode(b.a().d()));
        localObject = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        this.k.put("trtm", localObject);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {}
      try
      {
        localJSONObject = new JSONObject(this.j);
        i = 1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          JSONObject localJSONObject;
          localObject1 = null;
          int i = 0;
        }
      }
      if ((i != 0) && (localJSONObject != null)) {}
      for (;;)
      {
        try
        {
          localJSONObject.put("tt", System.currentTimeMillis());
          localJSONObject.put("data", this.e);
        }
        catch (Exception localException3)
        {
          Object localObject2;
          Object localObject1;
          continue;
        }
        try
        {
          localObject2 = new File(f.b(f.this), "wcnf.dat");
          if (!((File)localObject2).exists()) {
            ((File)localObject2).createNewFile();
          }
          localObject2 = new BufferedWriter(new FileWriter((File)localObject2, false));
          ((BufferedWriter)localObject2).write(Base64.encode(localJSONObject.toString().getBytes(), "UTF-8"));
          ((BufferedWriter)localObject2).flush();
          ((BufferedWriter)localObject2).close();
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      this.b = false;
    }
    
    public void a(boolean paramBoolean, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      if (paramBoolean) {}
      for (this.c = 1;; this.c = 0)
      {
        this.d = paramJSONArray1;
        this.e = paramJSONArray2;
        c(g.i());
        return;
      }
    }
  }
  
  private class b
  {
    public String a = null;
    public int b = 0;
    
    b(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */