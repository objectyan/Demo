package com.baidu.mapframework.common.a;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class j
{
  static h a = null;
  private static final String b = "MAP_LOGGER";
  private static final ConcurrentHashMap<String, l> c = new ConcurrentHashMap();
  
  /* Error */
  public static l a(f paramf, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +93 -> 97
    //   7: getstatic 32	com/baidu/mapframework/common/a/f:a	Lcom/baidu/mapframework/common/a/f;
    //   10: astore_0
    //   11: ldc 10
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: aload_1
    //   17: ifnull +14 -> 31
    //   20: aload_3
    //   21: astore_2
    //   22: aload_1
    //   23: invokevirtual 38	java/lang/String:isEmpty	()Z
    //   26: ifne +5 -> 31
    //   29: aload_1
    //   30: astore_2
    //   31: getstatic 22	com/baidu/mapframework/common/a/j:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   34: new 40	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   41: aload_2
    //   42: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokevirtual 56	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: ifnull +45 -> 100
    //   58: getstatic 22	com/baidu/mapframework/common/a/j:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   61: new 40	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   68: aload_2
    //   69: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_0
    //   73: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokevirtual 56	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 58	com/baidu/mapframework/common/a/l
    //   85: astore_0
    //   86: aload_0
    //   87: invokeinterface 60 1 0
    //   92: ldc 2
    //   94: monitorexit
    //   95: aload_0
    //   96: areturn
    //   97: goto -86 -> 11
    //   100: new 62	com/baidu/mapframework/common/a/b
    //   103: dup
    //   104: aload_0
    //   105: aload_2
    //   106: invokespecial 65	com/baidu/mapframework/common/a/b:<init>	(Lcom/baidu/mapframework/common/a/f;Ljava/lang/String;)V
    //   109: astore_1
    //   110: getstatic 22	com/baidu/mapframework/common/a/j:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: new 40	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   120: aload_2
    //   121: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: aload_1
    //   132: invokevirtual 69	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: aload_1
    //   137: invokevirtual 70	com/baidu/mapframework/common/a/b:a	()V
    //   140: aload_1
    //   141: astore_0
    //   142: goto -50 -> 92
    //   145: astore_0
    //   146: ldc 2
    //   148: monitorexit
    //   149: aload_0
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramf	f
    //   0	151	1	paramString	String
    //   15	106	2	str1	String
    //   13	8	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   7	11	145	finally
    //   22	29	145	finally
    //   31	92	145	finally
    //   100	140	145	finally
  }
  
  public static void a()
  {
    try
    {
      Iterator localIterator = c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() != null) {
          ((l)localEntry.getValue()).b();
        }
      }
    }
    finally {}
  }
  
  public static void a(h paramh)
  {
    if (a == null) {
      a = paramh;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */