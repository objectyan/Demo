package com.baidu.location.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.h.b;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONObject;

final class c
{
  private final d a;
  private final SQLiteDatabase b;
  private final a c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private String[] i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private double o;
  private double p;
  private double q;
  private double r;
  private double s;
  private int t;
  private boolean u = true;
  private long v = 8000L;
  private long w = 5000L;
  private long x = 5000L;
  private long y = 5000L;
  private long z = 5000L;
  
  c(d paramd, SQLiteDatabase paramSQLiteDatabase)
  {
    this.a = paramd;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.h = false;
    this.j = false;
    this.k = false;
    this.l = 6;
    this.m = 30;
    this.n = 30;
    this.o = 0.0D;
    this.p = 0.0D;
    this.q = 0.0D;
    this.r = 0.0D;
    this.s = 0.0D;
    this.t = 8;
    this.i = new String[0];
    this.b = paramSQLiteDatabase;
    this.c = new a(null);
    if ((this.b != null) && (this.b.isOpen())) {}
    try
    {
      this.b.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
      g();
      return;
    }
    catch (Exception paramd)
    {
      for (;;) {}
    }
  }
  
  int a()
  {
    return this.t;
  }
  
  long a(String paramString)
  {
    long l1 = 5000L;
    if (paramString.equals("2G")) {
      l1 = this.v;
    }
    do
    {
      return l1;
      if (paramString.equals("3G")) {
        return this.w;
      }
      if (paramString.equals("4G")) {
        return this.x;
      }
      if (paramString.equals("WIFI")) {
        return this.y;
      }
    } while (!paramString.equals("unknown"));
    return this.z;
  }
  
  void a(String[] paramArrayOfString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      if (i1 > 0) {
        localStringBuffer.append(",");
      }
      localStringBuffer.append("(\"");
      localStringBuffer.append(paramArrayOfString[i1]);
      localStringBuffer.append("\")");
      i1 += 1;
    }
    if ((this.b != null) && (this.b.isOpen()) && (localStringBuffer.length() > 0)) {
      paramArrayOfString = String.format(Locale.US, "INSERT OR IGNORE INTO BLACK VALUES %s;", new Object[] { localStringBuffer.toString() });
    }
    try
    {
      this.b.execSQL(paramArrayOfString);
      return;
    }
    catch (Exception paramArrayOfString) {}
  }
  
  double b()
  {
    return this.o;
  }
  
  boolean b(String paramString)
  {
    Object localObject = null;
    Cursor localCursor = null;
    bool1 = false;
    bool2 = false;
    String str = String.format(Locale.US, "SELECT * FROM BLACK WHERE NAME IN (\"%s\");", new Object[] { paramString });
    paramString = localCursor;
    try
    {
      localCursor = this.b.rawQuery(str, null);
      paramString = localCursor;
      localObject = localCursor;
      int i1 = localCursor.getCount();
      bool1 = bool2;
      if (i1 > 0) {
        bool1 = true;
      }
      bool2 = bool1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        bool2 = bool1;
        if (paramString != null) {
          try
          {
            paramString.close();
            bool2 = bool1;
          }
          catch (Exception paramString)
          {
            bool2 = bool1;
          }
        }
      }
    }
    finally
    {
      if (localException1 == null) {}
    }
    try
    {
      localCursor.close();
      bool2 = bool1;
    }
    catch (Exception paramString)
    {
      try
      {
        localException1.close();
        throw paramString;
        paramString = paramString;
        bool2 = bool1;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    if (bool2) {}
    return bool2;
  }
  
  double c()
  {
    return this.p;
  }
  
  double d()
  {
    return this.q;
  }
  
  double e()
  {
    return this.r;
  }
  
  double f()
  {
    return this.s;
  }
  
  void g()
  {
    a.a(this.c);
  }
  
  boolean h()
  {
    return this.d;
  }
  
  boolean i()
  {
    return this.k;
  }
  
  boolean j()
  {
    return this.f;
  }
  
  boolean k()
  {
    return this.g;
  }
  
  boolean l()
  {
    return this.e;
  }
  
  boolean m()
  {
    return this.j;
  }
  
  boolean n()
  {
    return this.u;
  }
  
  int o()
  {
    return this.l;
  }
  
  String[] p()
  {
    return this.i;
  }
  
  int q()
  {
    return this.n;
  }
  
  int r()
  {
    return this.m;
  }
  
  private final class a
    extends e
  {
    private int b = 0;
    private long c = -1L;
    private long d = -1L;
    private boolean e = false;
    private final String f = Jni.encodeOfflineLocationUpdateRequest(String.format(Locale.US, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f", new Object[] { "1", b.a().b, b.e, b.d, Float.valueOf(7.32F) }));
    
    private a()
    {
      this.k = new HashMap();
    }
    
    private void b()
    {
      if (this.e) {}
      do
      {
        return;
        int j = 0;
        try
        {
          File localFile = new File(c.v(c.this).c(), "ofl.config");
          if ((this.d == -1L) && (localFile.exists()))
          {
            Object localObject1 = new Scanner(localFile);
            Object localObject2 = ((Scanner)localObject1).next();
            ((Scanner)localObject1).close();
            localObject1 = new JSONObject((String)localObject2);
            c.a(c.this, ((JSONObject)localObject1).getBoolean("ol"));
            c.b(c.this, ((JSONObject)localObject1).getBoolean("fl"));
            c.c(c.this, ((JSONObject)localObject1).getBoolean("on"));
            c.d(c.this, ((JSONObject)localObject1).getBoolean("wn"));
            c.e(c.this, ((JSONObject)localObject1).getBoolean("oc"));
            this.d = ((JSONObject)localObject1).getLong("t");
            if (((JSONObject)localObject1).has("ol")) {
              c.g(c.this, ((JSONObject)localObject1).getBoolean("olv2"));
            }
            if (((JSONObject)localObject1).has("cplist")) {
              c.a(c.this, ((JSONObject)localObject1).getString("cplist").split(";"));
            }
            if (((JSONObject)localObject1).has("rgcgp")) {
              c.a(c.this, ((JSONObject)localObject1).getInt("rgcgp"));
            }
            if (((JSONObject)localObject1).has("rgcon")) {
              c.f(c.this, ((JSONObject)localObject1).getBoolean("rgcon"));
            }
            if (((JSONObject)localObject1).has("addrup")) {
              c.b(c.this, ((JSONObject)localObject1).getInt("addrup"));
            }
            if (((JSONObject)localObject1).has("poiup")) {
              c.c(c.this, ((JSONObject)localObject1).getInt("poiup"));
            }
            if (((JSONObject)localObject1).has("oflp"))
            {
              localObject2 = ((JSONObject)localObject1).getJSONObject("oflp");
              if (((JSONObject)localObject2).has("0")) {
                c.a(c.this, ((JSONObject)localObject2).getDouble("0"));
              }
              if (((JSONObject)localObject2).has("1")) {
                c.b(c.this, ((JSONObject)localObject2).getDouble("1"));
              }
              if (((JSONObject)localObject2).has("2")) {
                c.c(c.this, ((JSONObject)localObject2).getDouble("2"));
              }
              if (((JSONObject)localObject2).has("3")) {
                c.d(c.this, ((JSONObject)localObject2).getDouble("3"));
              }
              if (((JSONObject)localObject2).has("4")) {
                c.e(c.this, ((JSONObject)localObject2).getDouble("4"));
              }
            }
            if (((JSONObject)localObject1).has("onlt"))
            {
              localObject2 = ((JSONObject)localObject1).getJSONObject("onlt");
              if (((JSONObject)localObject2).has("0")) {
                c.a(c.this, ((JSONObject)localObject2).getLong("0"));
              }
              if (((JSONObject)localObject2).has("1")) {
                c.b(c.this, ((JSONObject)localObject2).getLong("1"));
              }
              if (((JSONObject)localObject2).has("2")) {
                c.c(c.this, ((JSONObject)localObject2).getLong("2"));
              }
              if (((JSONObject)localObject2).has("3")) {
                c.d(c.this, ((JSONObject)localObject2).getLong("3"));
              }
              if (((JSONObject)localObject2).has("4")) {
                c.e(c.this, ((JSONObject)localObject2).getLong("4"));
              }
            }
            if (((JSONObject)localObject1).has("minapn")) {
              c.d(c.this, ((JSONObject)localObject1).getInt("minapn"));
            }
          }
          if ((this.d == -1L) && (!localFile.exists())) {}
          i = j;
          if (this.d != -1L)
          {
            long l1 = this.d;
            long l2 = System.currentTimeMillis();
            i = j;
            if (l1 + 86400000L <= l2) {
              i = 1;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = j;
          }
        }
      } while (((this.d != -1L) && (i == 0)) || (!c()) || (!g.a(c.v(c.this).b())));
      this.e = true;
      c("https://ofloc.map.baidu.com/offline_loc");
    }
    
    private boolean c()
    {
      boolean bool = true;
      if (this.b < 2) {}
      for (;;)
      {
        if (!bool) {}
        return bool;
        if (this.c + 86400000L < System.currentTimeMillis())
        {
          this.b = 0;
          this.c = -1L;
        }
        else
        {
          bool = false;
        }
      }
    }
    
    public void a()
    {
      this.k.clear();
      this.k.put("qt", "conf");
      this.k.put("req", this.f);
      this.h = d.b;
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {}
      for (;;)
      {
        try
        {
          JSONObject localJSONObject2 = new JSONObject(this.j);
          Object localObject1 = "1";
          long l = 0L;
          if (localJSONObject2.has("ofl")) {
            l = localJSONObject2.getLong("ofl");
          }
          if (localJSONObject2.has("ver")) {
            localObject1 = localJSONObject2.getString("ver");
          }
          if ((l & 1L) == 1L) {
            c.a(c.this, true);
          }
          if ((l & 0x2) == 2L) {
            c.b(c.this, true);
          }
          if ((l & 0x4) == 4L) {
            c.c(c.this, true);
          }
          if ((l & 0x8) == 8L) {
            c.d(c.this, true);
          }
          if ((0x10 & l) == 16L) {
            c.e(c.this, true);
          }
          if ((0x20 & l) == 32L) {
            c.f(c.this, true);
          }
          if ((l & 0x40) == 64L) {
            c.g(c.this, true);
          }
          JSONObject localJSONObject1 = new JSONObject();
          if (localJSONObject2.has("cplist"))
          {
            c.a(c.this, localJSONObject2.getString("cplist").split(";"));
            localJSONObject1.put("cplist", localJSONObject2.getString("cplist"));
          }
          Object localObject2;
          if (localJSONObject2.has("bklist"))
          {
            localObject2 = localJSONObject2.getString("bklist").split(";");
            c.this.a((String[])localObject2);
          }
          if (localJSONObject2.has("para"))
          {
            localJSONObject2 = localJSONObject2.getJSONObject("para");
            if (localJSONObject2.has("rgcgp")) {
              c.a(c.this, localJSONObject2.getInt("rgcgp"));
            }
            if (localJSONObject2.has("addrup")) {
              c.b(c.this, localJSONObject2.getInt("addrup"));
            }
            if (localJSONObject2.has("poiup")) {
              c.c(c.this, localJSONObject2.getInt("poiup"));
            }
            if (localJSONObject2.has("oflp"))
            {
              localObject2 = localJSONObject2.getJSONObject("oflp");
              if (((JSONObject)localObject2).has("0")) {
                c.a(c.this, ((JSONObject)localObject2).getDouble("0"));
              }
              if (((JSONObject)localObject2).has("1")) {
                c.b(c.this, ((JSONObject)localObject2).getDouble("1"));
              }
              if (((JSONObject)localObject2).has("2")) {
                c.c(c.this, ((JSONObject)localObject2).getDouble("2"));
              }
              if (((JSONObject)localObject2).has("3")) {
                c.d(c.this, ((JSONObject)localObject2).getDouble("3"));
              }
              if (((JSONObject)localObject2).has("4")) {
                c.e(c.this, ((JSONObject)localObject2).getDouble("4"));
              }
            }
            if (localJSONObject2.has("onlt"))
            {
              localObject2 = localJSONObject2.getJSONObject("onlt");
              if (((JSONObject)localObject2).has("0")) {
                c.a(c.this, ((JSONObject)localObject2).getLong("0"));
              }
              if (((JSONObject)localObject2).has("1")) {
                c.b(c.this, ((JSONObject)localObject2).getLong("1"));
              }
              if (((JSONObject)localObject2).has("2")) {
                c.c(c.this, ((JSONObject)localObject2).getLong("2"));
              }
              if (((JSONObject)localObject2).has("3")) {
                c.d(c.this, ((JSONObject)localObject2).getLong("3"));
              }
              if (((JSONObject)localObject2).has("4")) {
                c.e(c.this, ((JSONObject)localObject2).getLong("4"));
              }
            }
            if (localJSONObject2.has("minapn")) {
              c.d(c.this, localJSONObject2.getInt("minapn"));
            }
          }
          localJSONObject1.put("ol", c.a(c.this));
          localJSONObject1.put("olv2", c.b(c.this));
          localJSONObject1.put("fl", c.c(c.this));
          localJSONObject1.put("on", c.d(c.this));
          localJSONObject1.put("wn", c.e(c.this));
          localJSONObject1.put("oc", c.f(c.this));
          this.d = System.currentTimeMillis();
          localJSONObject1.put("t", this.d);
          localJSONObject1.put("ver", localObject1);
          localJSONObject1.put("rgcon", c.g(c.this));
          localJSONObject1.put("rgcgp", c.h(c.this));
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("0", c.i(c.this));
          ((JSONObject)localObject1).put("1", c.j(c.this));
          ((JSONObject)localObject1).put("2", c.k(c.this));
          ((JSONObject)localObject1).put("3", c.l(c.this));
          ((JSONObject)localObject1).put("4", c.m(c.this));
          localJSONObject1.put("oflp", localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("0", c.n(c.this));
          ((JSONObject)localObject1).put("1", c.o(c.this));
          ((JSONObject)localObject1).put("2", c.p(c.this));
          ((JSONObject)localObject1).put("3", c.q(c.this));
          ((JSONObject)localObject1).put("4", c.r(c.this));
          localJSONObject1.put("onlt", localObject1);
          localJSONObject1.put("addrup", c.s(c.this));
          localJSONObject1.put("poiup", c.t(c.this));
          localJSONObject1.put("minapn", c.u(c.this));
          localObject1 = new File(c.v(c.this).c(), "ofl.config");
          if (!((File)localObject1).exists()) {
            ((File)localObject1).createNewFile();
          }
          localObject1 = new FileWriter((File)localObject1);
          ((FileWriter)localObject1).write(localJSONObject1.toString());
          ((FileWriter)localObject1).close();
        }
        catch (Exception localException)
        {
          this.b += 1;
          this.c = System.currentTimeMillis();
          continue;
        }
        this.e = false;
        return;
        this.b += 1;
        this.c = System.currentTimeMillis();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */