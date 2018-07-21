package com.baidu.mapframework.nirvana.b;

import com.baidu.mapframework.nirvana.n;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
{
  public static final String a = a.class.getSimpleName();
  private boolean b;
  private HashMap<Integer, b> c = new HashMap();
  private HashMap<Integer, b> d = new HashMap();
  
  public a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private void a(b paramb)
  {
    if ((paramb.h() == c.c) && (paramb.c() > 30L))
    {
      n.c(a, "LOOPER record: " + paramb);
      n.c(a, "LOOPER record module: " + paramb.j());
      n.c(a, "LOOPER record cost: " + paramb.c());
      n.a(a, "LOOPER record trace: ", paramb.i());
      return;
    }
    n.a(a, "record: " + paramb);
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append("----------- nirvana status begin -----------").append("\n");
    localStringBuilder.append("waiting task:").append("\n");
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((b)localIterator.next()).toString()).append("\n");
    }
    localStringBuilder.append("running task:").append("\n");
    localIterator = this.d.values().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((b)localIterator.next()).toString()).append("\n");
    }
    localStringBuilder.append("----------- nirvana status end -----------").append("\n").append("\n");
    return localStringBuilder.toString();
  }
  
  private void c()
  {
    try
    {
      Executors.newSingleThreadExecutor().execute(new Runnable()
      {
        public void run()
        {
          try
          {
            Thread.sleep(3000L);
            if ((!a.a(a.this).isEmpty()) || (!a.b(a.this).isEmpty())) {
              a.c(a.this);
            }
            a.d(a.this);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void d()
  {
    n.a(a, "-----------                      -----------");
    n.a(a, "----------- nirvana status begin -----------");
    n.a(a, "waiting task:");
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      a((b)localIterator.next());
    }
    n.a(a, "running task:");
    localIterator = this.d.values().iterator();
    while (localIterator.hasNext()) {
      a((b)localIterator.next());
    }
    n.a(a, "----------- nirvana status end -----------");
    n.a(a, "-----------                    -----------");
  }
  
  /* Error */
  public void a(c paramc, Object paramObject, com.baidu.mapframework.nirvana.module.Module paramModule, com.baidu.mapframework.nirvana.schedule.ScheduleConfig paramScheduleConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/baidu/mapframework/nirvana/b/a:b	Z
    //   6: istore 5
    //   8: iload 5
    //   10: ifne +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 42	com/baidu/mapframework/nirvana/b/b
    //   19: dup
    //   20: aload_1
    //   21: aload_2
    //   22: aload_3
    //   23: aload 4
    //   25: invokespecial 159	com/baidu/mapframework/nirvana/b/b:<init>	(Lcom/baidu/mapframework/nirvana/b/c;Ljava/lang/Object;Lcom/baidu/mapframework/nirvana/module/Module;Lcom/baidu/mapframework/nirvana/schedule/ScheduleConfig;)V
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 34	com/baidu/mapframework/nirvana/b/a:c	Ljava/util/HashMap;
    //   33: aload_2
    //   34: invokevirtual 163	java/lang/Object:hashCode	()I
    //   37: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aload_1
    //   41: invokevirtual 173	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: goto -32 -> 13
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	a
    //   0	53	1	paramc	c
    //   0	53	2	paramObject	Object
    //   0	53	3	paramModule	com.baidu.mapframework.nirvana.module.Module
    //   0	53	4	paramScheduleConfig	com.baidu.mapframework.nirvana.schedule.ScheduleConfig
    //   6	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	48	finally
    //   16	45	48	finally
  }
  
  /* Error */
  public void a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/baidu/mapframework/nirvana/b/a:b	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 34	com/baidu/mapframework/nirvana/b/a:c	Ljava/util/HashMap;
    //   18: aload_1
    //   19: invokevirtual 163	java/lang/Object:hashCode	()I
    //   22: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   25: invokevirtual 178	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 42	com/baidu/mapframework/nirvana/b/b
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull -22 -> 11
    //   36: aload_0
    //   37: getfield 34	com/baidu/mapframework/nirvana/b/a:c	Ljava/util/HashMap;
    //   40: aload_1
    //   41: invokevirtual 163	java/lang/Object:hashCode	()I
    //   44: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 181	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_3
    //   52: invokevirtual 183	com/baidu/mapframework/nirvana/b/b:a	()V
    //   55: aload_0
    //   56: getfield 36	com/baidu/mapframework/nirvana/b/a:d	Ljava/util/HashMap;
    //   59: aload_1
    //   60: invokevirtual 163	java/lang/Object:hashCode	()I
    //   63: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aload_3
    //   67: invokevirtual 173	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: goto -60 -> 11
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   0	79	1	paramObject	Object
    //   6	2	2	bool	boolean
    //   31	36	3	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	7	74	finally
    //   14	32	74	finally
    //   36	71	74	finally
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.b != paramBoolean)
      {
        this.b = paramBoolean;
        this.c.clear();
        this.d.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  /* Error */
  public void b(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/baidu/mapframework/nirvana/b/a:b	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 36	com/baidu/mapframework/nirvana/b/a:d	Ljava/util/HashMap;
    //   18: aload_1
    //   19: invokevirtual 163	java/lang/Object:hashCode	()I
    //   22: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   25: invokevirtual 178	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 42	com/baidu/mapframework/nirvana/b/b
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull -22 -> 11
    //   36: aload_0
    //   37: getfield 36	com/baidu/mapframework/nirvana/b/a:d	Ljava/util/HashMap;
    //   40: aload_1
    //   41: invokevirtual 163	java/lang/Object:hashCode	()I
    //   44: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 181	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_3
    //   52: invokevirtual 188	com/baidu/mapframework/nirvana/b/b:b	()V
    //   55: aload_0
    //   56: aload_3
    //   57: invokespecial 152	com/baidu/mapframework/nirvana/b/a:a	(Lcom/baidu/mapframework/nirvana/b/b;)V
    //   60: goto -49 -> 11
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	a
    //   0	68	1	paramObject	Object
    //   6	2	2	bool	boolean
    //   31	26	3	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	7	63	finally
    //   14	32	63	finally
    //   36	60	63	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */