package com.baidu.platform.comapi.e;

import com.baidu.platform.comapi.b.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static a a = null;
  private static JSONObject b = null;
  private c c = null;
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    if (b == null) {
      b = new JSONObject();
    }
    return a;
  }
  
  private void b()
  {
    b = null;
    b = new JSONObject();
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnonnull +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   16: aload_1
    //   17: iload_2
    //   18: invokestatic 36	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   21: invokevirtual 40	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   24: pop
    //   25: goto -15 -> 10
    //   28: astore_1
    //   29: goto -19 -> 10
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	a
    //   0	37	1	paramString	String
    //   0	37	2	paramInt	int
    //   5	2	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   13	25	28	org/json/JSONException
    //   2	6	32	finally
    //   13	25	32	finally
  }
  
  /* Error */
  public void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnonnull +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   16: aload_1
    //   17: aload_2
    //   18: invokevirtual 40	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   21: pop
    //   22: goto -12 -> 10
    //   25: astore_1
    //   26: goto -16 -> 10
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	a
    //   0	34	1	paramString1	String
    //   0	34	2	paramString2	String
    //   5	2	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   13	22	25	org/json/JSONException
    //   2	6	29	finally
    //   13	22	29	finally
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            localJSONObject.put(str, paramMap.get(str));
          }
          catch (JSONException localJSONException) {}
        }
      }
      a(paramString, localJSONObject);
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: invokestatic 81	com/baidu/platform/comapi/b/c:a	()Lcom/baidu/platform/comapi/b/c;
    //   13: putfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   16: iconst_0
    //   17: istore_2
    //   18: aload_0
    //   19: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   22: ifnull +41 -> 63
    //   25: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   28: ifnull +39 -> 67
    //   31: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   34: invokevirtual 85	org/json/JSONObject:length	()I
    //   37: ifle +30 -> 67
    //   40: aload_0
    //   41: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   44: sipush 1100
    //   47: iconst_1
    //   48: aload_1
    //   49: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   52: invokevirtual 88	org/json/JSONObject:toString	()Ljava/lang/String;
    //   55: invokevirtual 91	com/baidu/platform/comapi/b/c:a	(IILjava/lang/String;Ljava/lang/String;)Z
    //   58: istore_2
    //   59: aload_0
    //   60: invokespecial 93	com/baidu/platform/comapi/e/a:b	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: iload_2
    //   66: ireturn
    //   67: aload_0
    //   68: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   71: sipush 1100
    //   74: iconst_1
    //   75: aload_1
    //   76: aconst_null
    //   77: invokevirtual 91	com/baidu/platform/comapi/b/c:a	(IILjava/lang/String;Ljava/lang/String;)Z
    //   80: istore_2
    //   81: goto -22 -> 59
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	a
    //   0	89	1	paramString	String
    //   17	64	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	16	84	finally
    //   18	59	84	finally
    //   59	63	84	finally
    //   67	81	84	finally
  }
  
  /* Error */
  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: invokestatic 81	com/baidu/platform/comapi/b/c:a	()Lcom/baidu/platform/comapi/b/c;
    //   13: putfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   16: iconst_0
    //   17: istore_3
    //   18: aload_0
    //   19: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   22: ifnull +31 -> 53
    //   25: aload_2
    //   26: ifnull +31 -> 57
    //   29: aload_2
    //   30: invokevirtual 85	org/json/JSONObject:length	()I
    //   33: ifle +24 -> 57
    //   36: aload_0
    //   37: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   40: sipush 1100
    //   43: iconst_1
    //   44: aload_1
    //   45: aload_2
    //   46: invokevirtual 88	org/json/JSONObject:toString	()Ljava/lang/String;
    //   49: invokevirtual 91	com/baidu/platform/comapi/b/c:a	(IILjava/lang/String;Ljava/lang/String;)Z
    //   52: istore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_3
    //   56: ireturn
    //   57: aload_0
    //   58: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   61: sipush 1100
    //   64: iconst_1
    //   65: aload_1
    //   66: aconst_null
    //   67: invokevirtual 91	com/baidu/platform/comapi/b/c:a	(IILjava/lang/String;Ljava/lang/String;)Z
    //   70: istore_3
    //   71: goto -18 -> 53
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   0	79	1	paramString	String
    //   0	79	2	paramJSONObject	JSONObject
    //   17	54	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	16	74	finally
    //   18	25	74	finally
    //   29	53	74	finally
    //   57	71	74	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: invokestatic 81	com/baidu/platform/comapi/b/c:a	()Lcom/baidu/platform/comapi/b/c;
    //   13: putfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   16: iconst_0
    //   17: istore_2
    //   18: aload_0
    //   19: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   22: ifnull +41 -> 63
    //   25: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   28: ifnull +39 -> 67
    //   31: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   34: invokevirtual 85	org/json/JSONObject:length	()I
    //   37: ifle +30 -> 67
    //   40: aload_0
    //   41: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   44: sipush 1100
    //   47: iconst_2
    //   48: aload_1
    //   49: getstatic 14	com/baidu/platform/comapi/e/a:b	Lorg/json/JSONObject;
    //   52: invokevirtual 88	org/json/JSONObject:toString	()Ljava/lang/String;
    //   55: invokevirtual 91	com/baidu/platform/comapi/b/c:a	(IILjava/lang/String;Ljava/lang/String;)Z
    //   58: istore_2
    //   59: aload_0
    //   60: invokespecial 93	com/baidu/platform/comapi/e/a:b	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: iload_2
    //   66: ireturn
    //   67: aload_0
    //   68: getfield 22	com/baidu/platform/comapi/e/a:c	Lcom/baidu/platform/comapi/b/c;
    //   71: sipush 1100
    //   74: iconst_2
    //   75: aload_1
    //   76: aconst_null
    //   77: invokevirtual 91	com/baidu/platform/comapi/b/c:a	(IILjava/lang/String;Ljava/lang/String;)Z
    //   80: istore_2
    //   81: goto -22 -> 59
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	a
    //   0	89	1	paramString	String
    //   17	64	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	16	84	finally
    //   18	59	84	finally
    //   59	63	84	finally
    //   67	81	84	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */