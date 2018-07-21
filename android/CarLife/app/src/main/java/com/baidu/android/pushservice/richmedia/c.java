package com.baidu.android.pushservice.richmedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class c
{
  public String a;
  public String b;
  public String c;
  public String d;
  protected a e;
  public HashMap<String, String> f = new HashMap();
  public boolean g = true;
  public boolean h = false;
  private String i;
  private Map<String, String> j = new HashMap();
  private String k;
  private String l;
  private String m;
  
  public a a()
  {
    return this.e;
  }
  
  public void a(a parama)
  {
    this.e = parama;
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
  }
  
  public String b()
  {
    if (this.k == null) {
      return "GET";
    }
    return this.k;
  }
  
  public void b(String paramString)
  {
    this.l = paramString;
  }
  
  public String c()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.l != null) {
      localStringBuffer.append(this.l);
    }
    this.l = localStringBuffer.toString();
    if (this.l.endsWith("&")) {
      return this.l.substring(0, this.l.length() - 1);
    }
    return this.l;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    label47:
    label61:
    label75:
    label89:
    label103:
    label147:
    label164:
    label183:
    label200:
    label217:
    label234:
    label249:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof c)) {
        break;
      }
      paramObject = (c)paramObject;
      if (this.i == null) {
        if (((c)paramObject).i == null)
        {
          if (this.e != null) {
            break label147;
          }
          if (((c)paramObject).e == null)
          {
            if (this.j != null) {
              break label164;
            }
            if (((c)paramObject).j == null)
            {
              if (this.k != null) {
                break label183;
              }
              if (((c)paramObject).k == null)
              {
                if (this.l != null) {
                  break label200;
                }
                if (((c)paramObject).l == null)
                {
                  if (this.m != null) {
                    break label217;
                  }
                  if (((c)paramObject).m == null)
                  {
                    if (this.f != null) {
                      break label234;
                    }
                    if (((c)paramObject).f != null) {}
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (this.h == ((c)paramObject).h) {
          break label249;
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return false;
                    } while (!this.i.equals(((c)paramObject).i));
                    break;
                  } while (!this.e.equals(((c)paramObject).e));
                  break label47;
                } while (!this.j.equals(((c)paramObject).j));
                break label61;
              } while (!this.k.equals(((c)paramObject).k));
              break label75;
            } while (!this.l.equals(((c)paramObject).l));
            break label89;
          } while (!this.m.equals(((c)paramObject).m));
          break label103;
        } while (!this.f.equals(((c)paramObject).f));
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.i);
    localArrayList.add(this.e);
    localArrayList.add(this.j);
    localArrayList.add(this.k);
    localArrayList.add(this.l);
    localArrayList.add(this.m);
    localArrayList.add(this.f);
    localArrayList.add(Boolean.valueOf(this.h));
    return localArrayList.hashCode();
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/richmedia/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */