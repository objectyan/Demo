package com.baidu.baidumaps.a;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static final int b = 9000;
  private static final int c = 2912;
  private static final int d = 2911;
  private static b e;
  private static final Rect f = new Rect(13150208, 2373632, 13976576, 3031040);
  private static final Rect g = new Rect(13429150, 2718823, 13585755, 2901092);
  private static final Rect h = new Rect(13354776, 2479986, 13551711, 2806815);
  private static final Rect i = new Rect(13292448, 2674826, 13336968, 2718823);
  private static final Rect j = new Rect(12670976, 2511872, 12747776, 2564096);
  private static final Rect k = new Rect(12670976, 2511872, 12747776, 2549242);
  private static final Rect l = new Rect(12686524, 2549241, 12747776, 2556027);
  private static final Rect m = new Rect(12639232, 2507776, 12648448, 2522112);
  private static final Rect n = new Rect(12640423, 2514355, 12640966, 2514875);
  private static final Rect o = new Rect(12639947, 2514966, 12640944, 2516098);
  private static final Rect p = new Rect(12640831, 2513811, 12641668, 2516143);
  private static final Rect q = new Rect(12639291, 2516053, 12641736, 2518612);
  private static final Rect r = new Rect(12639925, 2518249, 12642144, 2521193);
  private static final Rect s = new Rect(12641532, 2508309, 12648099, 2521306);
  private static final Rect t = new Rect(12640966, 2521193, 12641736, 2521623);
  private static final Rect u = new Rect(8287165, 371290, 15042493, 7096923);
  private static final List<a> v = new ArrayList() {};
  private int a = 0;
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i1 = -1;
    if (f.contains(paramInt1, paramInt2)) {
      if ((g.contains(paramInt1, paramInt2)) || (h.contains(paramInt1, paramInt2)) || (i.contains(paramInt1, paramInt2))) {
        i1 = 9000;
      }
    }
    do
    {
      do
      {
        do
        {
          return i1;
          if (!j.contains(paramInt1, paramInt2)) {
            break;
          }
        } while ((!k.contains(paramInt1, paramInt2)) && (!l.contains(paramInt1, paramInt2)));
        return 2912;
        if (!m.contains(paramInt1, paramInt2)) {
          break;
        }
      } while ((!n.contains(paramInt1, paramInt2)) && (!o.contains(paramInt1, paramInt2)) && (!p.contains(paramInt1, paramInt2)) && (!q.contains(paramInt1, paramInt2)) && (!r.contains(paramInt1, paramInt2)) && (!s.contains(paramInt1, paramInt2)) && (!t.contains(paramInt1, paramInt2)));
      return 2911;
      Iterator localIterator = v.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a.contains(paramInt1, paramInt2)) {
          return locala.b;
        }
      }
    } while (u.contains(paramInt1, paramInt2));
    return 20000;
  }
  
  public static b a()
  {
    if (e == null) {
      e = new b();
    }
    return e;
  }
  
  private static class a
  {
    public Rect a;
    public int b;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.a = new Rect(paramInt2, paramInt3, paramInt4, paramInt5);
      this.b = paramInt1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */