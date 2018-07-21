package com.baidu.mapframework.nirvana.b;

import android.os.Looper;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.Date;

class b
{
  private c a;
  private Object b;
  private Module c;
  private ScheduleConfig d;
  private long e;
  private long f;
  private long g;
  private String h;
  private boolean i;
  private Throwable j;
  
  b(c paramc, Object paramObject, Module paramModule, ScheduleConfig paramScheduleConfig)
  {
    this.a = paramc;
    this.b = paramObject;
    this.c = paramModule;
    this.d = paramScheduleConfig;
    this.e = System.currentTimeMillis();
    this.j = new Throwable();
  }
  
  private boolean k()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  void a()
  {
    this.f = System.currentTimeMillis();
    this.h = Thread.currentThread().getName();
    this.i = k();
  }
  
  void b()
  {
    this.g = System.currentTimeMillis();
  }
  
  long c()
  {
    return this.g - this.f;
  }
  
  long d()
  {
    return this.f - this.e;
  }
  
  String e()
  {
    return this.h;
  }
  
  Date f()
  {
    return new Date(this.f);
  }
  
  a g()
  {
    if (this.f == 0L) {
      return a.a;
    }
    if (this.g == 0L) {
      return a.b;
    }
    return a.c;
  }
  
  public c h()
  {
    return this.a;
  }
  
  public Throwable i()
  {
    return this.j;
  }
  
  public Module j()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "Record{, module=" + this.c + ", type=" + this.a + ", task=" + this.b.toString() + ", state=" + g() + ", cost=" + c() + ", waitting=" + d() + ", threadInfo=" + this.h + ", isUIThread=" + this.i + ", createTime=" + new Date(this.e) + ", startTime=" + new Date(this.f) + ", endTime=" + new Date(this.g) + ", config=" + this.d + '}';
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */