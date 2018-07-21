package com.facebook.drawee.b;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class b
{
  private static final int b = 20;
  private static final b c = new b();
  private static boolean d = true;
  private final Queue<a> a = new ArrayBlockingQueue(20);
  
  public static b a()
  {
    if (d) {
      return new b();
    }
    return c;
  }
  
  public static void b()
  {
    d = false;
  }
  
  public void a(a parama)
  {
    if (!d) {
      return;
    }
    if (this.a.size() + 1 > 20) {
      this.a.poll();
    }
    this.a.add(parama);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */