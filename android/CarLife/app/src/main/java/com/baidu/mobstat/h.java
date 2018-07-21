package com.baidu.mobstat;

import java.util.Comparator;

class h
  implements Comparator<i>
{
  h(g paramg) {}
  
  public int a(i parami1, i parami2)
  {
    int j = parami2.b - parami1.b;
    int i = j;
    if (j == 0)
    {
      if ((!parami1.d) || (!parami2.d)) {
        break label37;
      }
      i = 0;
    }
    label37:
    do
    {
      return i;
      if (parami1.d) {
        return -1;
      }
      i = j;
    } while (!parami2.d);
    return 1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */