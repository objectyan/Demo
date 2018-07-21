package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.p;

public class b
  extends a
{
  public b(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/baidu/che/codriver/vr/a/b:b	Lcom/baidu/che/codriver/vr/p;
    //   4: invokevirtual 23	com/baidu/che/codriver/vr/p:d	()Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +110 -> 119
    //   12: aload_1
    //   13: invokevirtual 29	java/lang/String:length	()I
    //   16: ifle +103 -> 119
    //   19: aconst_null
    //   20: astore_2
    //   21: new 31	org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 34	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: new 36	com/baidu/che/codriver/ui/d/b
    //   33: dup
    //   34: invokespecial 38	com/baidu/che/codriver/ui/d/b:<init>	()V
    //   37: astore_1
    //   38: aload_1
    //   39: getstatic 44	com/baidu/che/codriver/ui/d/b$a:c	Lcom/baidu/che/codriver/ui/d/b$a;
    //   42: putfield 47	com/baidu/che/codriver/ui/d/b:f	Lcom/baidu/che/codriver/ui/d/b$a;
    //   45: aload_1
    //   46: iconst_1
    //   47: putfield 51	com/baidu/che/codriver/ui/d/b:j	I
    //   50: aload_1
    //   51: aload_3
    //   52: ldc 53
    //   54: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: putfield 61	com/baidu/che/codriver/ui/d/b:g	Ljava/lang/String;
    //   60: aload_1
    //   61: getfield 61	com/baidu/che/codriver/ui/d/b:g	Ljava/lang/String;
    //   64: ifnull +13 -> 77
    //   67: aload_1
    //   68: getfield 61	com/baidu/che/codriver/ui/d/b:g	Ljava/lang/String;
    //   71: invokevirtual 29	java/lang/String:length	()I
    //   74: ifne +13 -> 87
    //   77: aload_1
    //   78: aload_3
    //   79: ldc 63
    //   81: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: putfield 61	com/baidu/che/codriver/ui/d/b:g	Ljava/lang/String;
    //   87: aload_0
    //   88: getfield 66	com/baidu/che/codriver/vr/a/b:c	Lcom/baidu/che/codriver/vr/m;
    //   91: aload_1
    //   92: invokeinterface 72 2 0
    //   97: aload_0
    //   98: getfield 75	com/baidu/che/codriver/vr/a/b:d	Landroid/content/Context;
    //   101: ldc 77
    //   103: invokestatic 82	com/baidu/che/codriver/util/c:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   106: return
    //   107: astore_3
    //   108: aload_2
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: aload_2
    //   113: invokevirtual 85	org/json/JSONException:printStackTrace	()V
    //   116: goto -29 -> 87
    //   119: aload_0
    //   120: getfield 66	com/baidu/che/codriver/vr/a/b:c	Lcom/baidu/che/codriver/vr/m;
    //   123: aconst_null
    //   124: invokeinterface 72 2 0
    //   129: goto -32 -> 97
    //   132: astore_2
    //   133: goto -21 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	b
    //   7	103	1	localObject1	Object
    //   20	93	2	localObject2	Object
    //   132	1	2	localJSONException1	org.json.JSONException
    //   29	50	3	localJSONObject	org.json.JSONObject
    //   107	4	3	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   21	38	107	org/json/JSONException
    //   38	77	132	org/json/JSONException
    //   77	87	132	org/json/JSONException
  }
  
  protected void j() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */