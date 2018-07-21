package com.baidu.che.codriver.ui.d;

import com.baidu.che.codriver.e.a;
import com.baidu.che.codriver.ui.a.f.a;
import java.util.List;

public class i
  extends b
{
  private f.a a;
  private a l;
  private List<a> m;
  private int n;
  
  public i(String paramString, int paramInt)
  {
    this.f = b.a.f;
    this.g = paramString;
    this.j = paramInt;
    this.k = true;
  }
  
  public i(String paramString, int paramInt, b.a parama)
  {
    this.f = parama;
    this.g = paramString;
    this.j = paramInt;
    this.k = true;
  }
  
  public i(String paramString1, String paramString2, int paramInt, b.a parama)
  {
    this(paramString1, paramInt, parama);
    this.h = paramString2;
    this.k = true;
  }
  
  public i(String paramString, List<a> paramList, a parama, int paramInt)
  {
    this(paramString, paramInt);
    this.l = parama;
    this.m = paramList;
    this.k = true;
  }
  
  public a a()
  {
    return this.l;
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void a(f.a parama)
  {
    this.a = parama;
  }
  
  public List<a> b()
  {
    return this.m;
  }
  
  public int c()
  {
    return this.n;
  }
  
  public f.a d()
  {
    return this.a;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */