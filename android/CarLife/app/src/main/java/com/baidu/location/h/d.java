package com.baidu.location.h;

import java.util.Iterator;
import java.util.LinkedList;

public class d
{
  private static d a = null;
  private static final double[] b = { 110.389648D, 105.070224D, 96.898845D, 95.617053D, 93.822557D, 91.387165D, 91.387165D, 89.079901D, 87.221341D, 86.259997D, 85.170461D, 85.234525D, 82.863261D, 81.901917D, 79.594685D, 80.395798D, 79.931142D, 77.800174D, 75.252622D, 73.490158D, 73.185732D, 73.874699D, 74.403435D, 74.099003D, 75.460905D, 76.77474D, 78.280852D, 78.15266D, 78.37698D, 78.8897D, 79.690818D, 81.196914D, 81.805762D, 83.888674D, 85.939538D, 87.862215D, 89.031847D, 90.057287D, 91.098741D, 92.156213D, 93.742421D, 95.825333D, 97.956327D, 97.123143D, 98.212679D, 99.206055D, 101.657471D, 102.52267D, 102.23427D, 105.022158D, 106.095662D, 107.858116D, 111.639396D, 109.588503D, 112.280343D, 117.792023D, 118.945559D, 114.203031D, 118.689303D, 123.143466D, 122.726858D, 120.932369D, 123.415857D, 122.374385D, 122.134054D, 121.586108D, 121.17271D, 120.676006D, 120.243409D, 122.790961D, 122.871076D, 121.300884D, 122.134052D, 123.736285D, 126.412019D, 128.559027D, 129.712627D, 131.218707D, 131.987795D, 133.622084D, 135.60888D, 131.378992D, 130.866224D, 128.623088D, 126.091572D, 124.393204D, 122.214164D, 119.65058D, 119.778772D, 118.561044D, 116.510192D, 114.811824D, 119.073776D, 116.446096D, 111.735536D, 110.389648D };
  private static final double[] c = { 43.216755D, 42.378597D, 43.172612D, 44.421188D, 45.097508D, 45.565732D, 47.334548D, 48.687188D, 49.62362D, 48.947316D, 48.479092D, 47.334548D, 47.438596D, 46.03394D, 45.201556D, 43.344095D, 42.328663D, 41.395882D, 40.829126D, 39.955382D, 39.258748D, 38.361382D, 38.054394D, 37.168842D, 36.389553D, 35.362313D, 34.311457D, 32.587581D, 31.572149D, 30.781055D, 30.438642D, 29.77743D, 30.09623D, 28.714766D, 27.71114D, 27.581258D, 27.014504D, 27.781984D, 27.510415D, 26.506787D, 26.707513D, 27.959095D, 27.29788D, 23.649404D, 23.62579D, 21.677574D, 20.780213D, 21.323353D, 22.185291D, 22.315173D, 22.515897D, 16.802289D, 13.198973D, 0.693351D, 1.541191D, 10.504055D, 15.591095D, 17.892375D, 19.951383D, 22.187501D, 25.375613D, 25.617568D, 30.627458D, 31.082902D, 31.894166D, 32.503117D, 32.805056D, 34.256784D, 35.155304D, 36.90119D, 37.83411D, 37.940728D, 38.64708D, 38.966937D, 40.979374D, 41.253698D, 42.069802D, 42.48888D, 44.65045D, 44.691252D, 48.620679D, 48.091311D, 49.194151D, 50.032311D, 53.274665D, 53.627577D, 53.892257D, 52.987929D, 52.017425D, 50.230825D, 50.186707D, 47.495779D, 47.341379D, 46.503219D, 45.245983D, 43.216755D };
  private LinkedList<b> d = null;
  
  private d()
  {
    int j = b.length;
    this.d = new LinkedList();
    int i = 0;
    while (i < j - 1)
    {
      this.d.add(new b(new a(b[i] * 100000.0D, c[i] * 100000.0D), new a(b[(i + 1)] * 100000.0D, c[(i + 1)] * 100000.0D)));
      i += 1;
    }
  }
  
  public static d a()
  {
    if (a == null) {
      a = new d();
    }
    return a;
  }
  
  int a(double paramDouble)
  {
    if (paramDouble < -1.0E-8D) {
      return -1;
    }
    if (paramDouble > 1.0E-8D) {
      return 1;
    }
    return 0;
  }
  
  public boolean a(double paramDouble1, double paramDouble2)
  {
    label193:
    for (;;)
    {
      try
      {
        a locala = new a(100000.0D * paramDouble1, 100000.0D * paramDouble2);
        int i = 0;
        Iterator localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb.b(locala)) {
            return true;
          }
          int k = a(localb.a(locala));
          int m = a(localb.a.b - locala.b);
          int n = a(localb.b.b - locala.b);
          if ((k <= 0) || (m > 0) || (n <= 0)) {
            break label193;
          }
          i += 1;
          int j = i;
          if (k < 0)
          {
            j = i;
            if (n <= 0)
            {
              j = i;
              if (m > 0) {
                j = i - 1;
              }
            }
          }
          i = j;
          continue;
        }
        if (i == 0) {
          return false;
        }
      }
      catch (Exception localException)
      {
        return true;
      }
      return true;
    }
  }
  
  class a
  {
    double a;
    double b;
    
    a(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }
  }
  
  class b
  {
    d.a a;
    d.a b;
    
    b(d.a parama1, d.a parama2)
    {
      this.a = parama1;
      this.b = parama2;
    }
    
    double a(d.a parama)
    {
      d.a locala = new d.a(d.this, this.b.a - this.a.a, this.b.b - this.a.b);
      parama = new d.a(d.this, parama.a - this.a.a, parama.b - this.a.b);
      return locala.a * parama.b - locala.b * parama.a;
    }
    
    boolean b(d.a parama)
    {
      return (d.this.a(a(parama)) == 0) && (parama.a < Math.max(this.a.a, this.b.a) + 1.0E-8D) && (parama.a > Math.min(this.a.a, this.b.a) - 1.0E-8D) && (parama.b < Math.max(this.a.b, this.b.b) + 1.0E-8D) && (parama.b > Math.min(this.a.b, this.b.b) - 1.0E-8D);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */