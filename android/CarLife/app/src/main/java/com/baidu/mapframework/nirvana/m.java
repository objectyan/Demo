package com.baidu.mapframework.nirvana;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class m
{
  List<a> a = new ArrayList();
  
  private long a()
  {
    long l = 0L;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      l += locala.c - locala.b;
    }
    return l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task size:").append(this.a.size()).append(", Total execution time:").append(TimeUnit.NANOSECONDS.toMillis(a()) + " ms");
    localStringBuilder.append("\n");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((a)localIterator.next()).append("\n");
    }
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public String a;
    public long b;
    public long c;
    
    public String toString()
    {
      return "[" + this.a + "|" + this.b + "," + this.c + ", dur:" + TimeUnit.NANOSECONDS.toMillis(this.c - this.b) + " ms ]";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */