package com.baidu.location.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.location.f;

public class i
{
  private static Object a = new Object();
  private static i b = null;
  private SharedPreferences c = null;
  
  public i()
  {
    if (this.c == null) {
      this.c = f.getServiceContext().getSharedPreferences("MapCoreServicePreIA", 0);
    }
  }
  
  public static i a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new i();
      }
      i locali = b;
      return locali;
    }
  }
  
  /* Error */
  public int a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   6: astore 4
    //   8: iload_2
    //   9: istore_3
    //   10: aload 4
    //   12: ifnull +15 -> 27
    //   15: aload_0
    //   16: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   19: aload_1
    //   20: iload_2
    //   21: invokeinterface 46 3 0
    //   26: istore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_3
    //   30: ireturn
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    //   36: astore_1
    //   37: iload_2
    //   38: istore_3
    //   39: goto -12 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	i
    //   0	42	1	paramString	String
    //   0	42	2	paramInt	int
    //   9	30	3	i	int
    //   6	5	4	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   2	8	31	finally
    //   15	27	31	finally
    //   15	27	36	java/lang/Exception
  }
  
  /* Error */
  public long a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   6: astore 6
    //   8: lload_2
    //   9: lstore 4
    //   11: aload 6
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   20: aload_1
    //   21: lload_2
    //   22: invokeinterface 50 4 0
    //   27: lstore 4
    //   29: aload_0
    //   30: monitorexit
    //   31: lload 4
    //   33: lreturn
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: astore_1
    //   40: lload_2
    //   41: lstore 4
    //   43: goto -14 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	i
    //   0	46	1	paramString	String
    //   0	46	2	paramLong	long
    //   9	33	4	l	long
    //   6	6	6	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   2	8	34	finally
    //   16	29	34	finally
    //   16	29	39	java/lang/Exception
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   6: astore 4
    //   8: aload_2
    //   9: astore_3
    //   10: aload 4
    //   12: ifnull +15 -> 27
    //   15: aload_0
    //   16: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   19: aload_1
    //   20: aload_2
    //   21: invokeinterface 54 3 0
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: areturn
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    //   36: astore_1
    //   37: aload_2
    //   38: astore_3
    //   39: goto -12 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	i
    //   0	42	1	paramString1	String
    //   0	42	2	paramString2	String
    //   9	30	3	str	String
    //   6	5	4	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   2	8	31	finally
    //   15	27	31	finally
    //   15	27	36	java/lang/Exception
  }
  
  /* Error */
  public void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +29 -> 37
    //   11: aload_0
    //   12: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   15: invokeinterface 59 1 0
    //   20: astore_3
    //   21: aload_3
    //   22: aload_1
    //   23: iload_2
    //   24: invokeinterface 65 3 0
    //   29: pop
    //   30: aload_3
    //   31: invokeinterface 69 1 0
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: goto -9 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	i
    //   0	49	1	paramString	String
    //   0	49	2	paramInt	int
    //   6	25	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	40	finally
    //   11	37	40	finally
    //   11	37	45	java/lang/Exception
  }
  
  /* Error */
  public void b(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +32 -> 42
    //   13: aload_0
    //   14: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   17: invokeinterface 59 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: aload_1
    //   27: lload_2
    //   28: invokeinterface 74 4 0
    //   33: pop
    //   34: aload 4
    //   36: invokeinterface 69 1 0
    //   41: pop
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: goto -9 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	i
    //   0	54	1	paramString	String
    //   0	54	2	paramLong	long
    //   6	29	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	45	finally
    //   13	42	45	finally
    //   13	42	50	java/lang/Exception
  }
  
  /* Error */
  public void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +29 -> 37
    //   11: aload_0
    //   12: getfield 22	com/baidu/location/d/i:c	Landroid/content/SharedPreferences;
    //   15: invokeinterface 59 1 0
    //   20: astore_3
    //   21: aload_3
    //   22: aload_1
    //   23: aload_2
    //   24: invokeinterface 79 3 0
    //   29: pop
    //   30: aload_3
    //   31: invokeinterface 69 1 0
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: goto -9 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	i
    //   0	49	1	paramString1	String
    //   0	49	2	paramString2	String
    //   6	25	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	40	finally
    //   11	37	40	finally
    //   11	37	45	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */