package com.baidu.tts.m;

import com.baidu.tts.b.a.b.e.b;
import com.baidu.tts.b.a.b.f.b;
import com.baidu.tts.f.j;
import com.baidu.tts.f.n;
import com.baidu.tts.n.a;
import com.baidu.tts.tools.DataTool;

public class b
  extends a<b>
{
  private f.b a = new f.b();
  private e.b b = new e.b();
  private j c;
  
  public f.b a()
  {
    return this.a;
  }
  
  public void a(j paramj)
  {
    this.c = paramj;
  }
  
  public void a(String paramString)
  {
    this.a.k(paramString);
    this.b.k(paramString);
  }
  
  public e.b b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.a.m(paramString);
    this.b.m(paramString);
  }
  
  public j c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.a.l(paramString);
    this.b.l(paramString);
  }
  
  public int d(String paramString)
  {
    if (DataTool.isLong(paramString))
    {
      this.a.j(paramString);
      this.b.j(paramString);
      return 0;
    }
    return n.Y.b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/m/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */