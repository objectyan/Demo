package com.baidu.location.indoor;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.h.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class a
  extends e
{
  private static HashMap<String, Long> a = new HashMap();
  private final String b = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
  private final SimpleDateFormat c = new SimpleDateFormat("yyyyMM");
  private Context d;
  private boolean e;
  private String f;
  private HashSet<String> p;
  private a q;
  private String r = null;
  private Handler s;
  private Runnable t;
  
  public a(Context paramContext)
  {
    this.d = paramContext;
    this.p = new HashSet();
    this.e = false;
    this.k = new HashMap();
    this.s = new Handler();
    this.t = new Runnable()
    {
      public void run()
      {
        if (a.a(a.this) != null)
        {
          a.a(a.this, a.a(a.this));
          a.this.i();
        }
      }
    };
  }
  
  private String a(Date paramDate)
  {
    paramDate = com.baidu.android.bbalbs.common.security.b.a((this.f + this.c.format(paramDate)).getBytes(), false);
    paramDate = new File(this.d.getCacheDir(), paramDate);
    if (!paramDate.isFile()) {}
    for (;;)
    {
      return null;
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramDate));
        String str;
        for (paramDate = "";; paramDate = paramDate + str + "\n")
        {
          str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
        }
        localBufferedReader.close();
        if (!paramDate.equals(""))
        {
          paramDate = new String(Base64.decode(paramDate.getBytes()));
          return paramDate;
        }
      }
      catch (Exception paramDate) {}
    }
    return null;
  }
  
  private void d(String paramString)
  {
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      this.p.add(((String)localObject).toLowerCase());
      i += 1;
    }
  }
  
  private Date e()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(2, -1);
    return localCalendar.getTime();
  }
  
  private void e(String paramString)
  {
    Object localObject = com.baidu.android.bbalbs.common.security.b.a((this.f + this.c.format(new Date())).getBytes(), false);
    localObject = new File(this.d.getCacheDir(), (String)localObject);
    try
    {
      localObject = new FileWriter((File)localObject);
      ((FileWriter)localObject).write(Base64.encode(paramString.getBytes(), "UTF-8"));
      ((FileWriter)localObject).flush();
      ((FileWriter)localObject).close();
      return;
    }
    catch (IOException paramString) {}
  }
  
  private void f()
  {
    try
    {
      Object localObject = e();
      localObject = com.baidu.android.bbalbs.common.security.b.a((this.f + this.c.format((Date)localObject)).getBytes(), false);
      localObject = new File(this.d.getCacheDir(), (String)localObject);
      if (!((File)localObject).isFile()) {
        return;
      }
      ((File)localObject).delete();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void f(String paramString)
  {
    Object localObject = new File(this.d.getCacheDir(), "buildings");
    try
    {
      localObject = new FileWriter((File)localObject, true);
      ((FileWriter)localObject).write(paramString + "\n");
      ((FileWriter)localObject).flush();
      ((FileWriter)localObject).close();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a()
  {
    this.h = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
    this.k.clear();
    this.k.put("bid", "none");
    this.k.put("bldg", this.f);
    this.k.put("mb", Build.MODEL);
    this.k.put("msdk", "2.0");
    this.k.put("cuid", com.baidu.location.h.b.a().b);
    this.k.put("anchors", "v1");
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.j != null)) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject(new String(Base64.decode(this.j.toString().getBytes())));
        if (!((JSONObject)localObject).has("anchorinfo")) {
          break label225;
        }
        localObject = ((JSONObject)localObject).optString("anchorinfo");
        if ((localObject == null) || (((String)localObject).equals(""))) {
          break label225;
        }
        this.p.clear();
        d((String)localObject);
        e((String)localObject);
      }
      catch (Exception localException1)
      {
        Object localObject;
        paramBoolean = false;
        continue;
      }
      try
      {
        f();
        paramBoolean = true;
      }
      catch (Exception localException2)
      {
        paramBoolean = true;
        continue;
      }
      if ((!paramBoolean) && (this.r == null))
      {
        this.r = this.f;
        this.s.postDelayed(this.t, 60000L);
        this.e = false;
        if (this.q != null) {
          this.q.a(paramBoolean);
        }
        return;
      }
      if (paramBoolean)
      {
        this.r = null;
      }
      else
      {
        f(this.r);
        this.r = null;
        localObject = a(e());
        if (localObject != null)
        {
          d((String)localObject);
          if (this.q != null)
          {
            this.q.a(true);
            continue;
            label225:
            paramBoolean = false;
          }
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return (this.f != null) && (this.f.equalsIgnoreCase(paramString)) && (!this.p.isEmpty());
  }
  
  public boolean a(String paramString, a parama)
  {
    if (!this.e)
    {
      this.q = parama;
      this.e = true;
      this.f = paramString;
      try
      {
        parama = a(new Date());
        if (parama == null)
        {
          long l = System.currentTimeMillis();
          if ((a.get(paramString) == null) || (l - ((Long)a.get(paramString)).longValue() > 86400000L))
          {
            a.put(paramString, Long.valueOf(l));
            i();
            return false;
          }
        }
        else
        {
          d(parama);
          if (this.q != null) {
            this.q.a(true);
          }
          this.e = false;
          return false;
        }
      }
      catch (Exception paramString)
      {
        this.e = false;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return (this.p != null) && (!this.p.isEmpty());
  }
  
  public boolean b(String paramString)
  {
    if ((this.f == null) || (this.p == null) || (this.p.isEmpty())) {}
    while (!this.p.contains(paramString)) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    this.f = null;
    this.p.clear();
  }
  
  public boolean d()
  {
    File localFile = new File(this.d.getCacheDir(), "buildings");
    if (!localFile.exists()) {
      return false;
    }
    final HashSet localHashSet = new HashSet();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localHashSet.add(str.trim());
      }
      localBufferedReader.close();
      localFile.delete();
      new Thread(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localHashSet.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (String)localIterator.next();
            a.a(a.this, (String)localObject);
            localObject = null;
            try
            {
              String str = a.a(a.this, new Date());
              localObject = str;
            }
            catch (Exception localException)
            {
              for (;;) {}
            }
            if ((localObject == null) || (((String)localObject).equals("")))
            {
              a.this.i();
              try
              {
                Thread.sleep(10000L);
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
        }
      }).start();
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */