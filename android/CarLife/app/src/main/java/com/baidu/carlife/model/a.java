package com.baidu.carlife.model;

import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;

public class a
  extends b
{
  private static final String h = "AppsAdministrationFragment";
  public String a;
  public String b;
  public int c = 0;
  public a d;
  public int e = 2130838479;
  
  public void a()
  {
    if (this.d == null) {
      this.d = new a(null);
    }
    if (this.f == 0) {
      this.d.start();
    }
    while (2 != this.f) {
      return;
    }
    this.d.a(false);
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    switch (this.f)
    {
    case 4: 
    default: 
      return;
    case 0: 
      this.a = "未下载";
      this.b = "下载";
      return;
    case 1: 
      this.a = "下载中";
      this.b = "下载暂停";
      return;
    case 2: 
      this.a = "下载暂停";
      this.b = "下载";
      return;
    }
    this.a = "未安装";
    this.b = "安装";
  }
  
  public void b()
  {
    if (this.d == null) {
      this.d = new a(null);
    }
    this.d.a(true);
  }
  
  private class a
    extends Thread
  {
    private boolean b = false;
    private boolean c = false;
    
    private a() {}
    
    public void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public void run()
    {
      while (!this.c)
      {
        if (!this.b)
        {
          a locala = a.this;
          locala.c += 1;
        }
        if (100 == a.this.c)
        {
          this.c = true;
          a.this.a(3);
        }
        i.e("AppsAdministrationFragment", "-----download-------progress:" + a.this.c);
        try
        {
          k.b(600);
          sleep(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */