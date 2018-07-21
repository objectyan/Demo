package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class n
{
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("push_client_self_info", 4).getString("bd_use_huawei_token", null);
  }
  
  /* Error */
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_5
    //   4: istore_3
    //   5: aload_0
    //   6: ldc 8
    //   8: iconst_4
    //   9: invokevirtual 14	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   12: astore_0
    //   13: aload_0
    //   14: invokeinterface 30 1 0
    //   19: astore 5
    //   21: iload_3
    //   22: iconst_1
    //   23: isub
    //   24: istore 4
    //   26: aload 5
    //   28: ifnonnull +11 -> 39
    //   31: iload 4
    //   33: istore_3
    //   34: iload 4
    //   36: ifgt -23 -> 13
    //   39: aload 5
    //   41: ifnull +31 -> 72
    //   44: iload_1
    //   45: tableswitch	default:+27->72, 5:+31->76, 6:+50->95, 7:+75->120
    //   72: ldc 2
    //   74: monitorexit
    //   75: return
    //   76: aload 5
    //   78: ldc 16
    //   80: aload_2
    //   81: invokeinterface 36 3 0
    //   86: invokeinterface 40 1 0
    //   91: pop
    //   92: goto -20 -> 72
    //   95: aload 5
    //   97: ldc 42
    //   99: aload_2
    //   100: invokeinterface 36 3 0
    //   105: invokeinterface 40 1 0
    //   110: pop
    //   111: goto -39 -> 72
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    //   120: aload 5
    //   122: ldc 44
    //   124: aload_2
    //   125: invokeinterface 36 3 0
    //   130: invokeinterface 40 1 0
    //   135: pop
    //   136: goto -64 -> 72
    //   139: astore_0
    //   140: goto -68 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	Context
    //   0	143	1	paramInt	int
    //   0	143	2	paramString	String
    //   4	30	3	i	int
    //   24	11	4	j	int
    //   19	102	5	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   5	13	114	finally
    //   13	21	114	finally
    //   76	92	114	finally
    //   95	111	114	finally
    //   120	136	114	finally
    //   5	13	139	java/lang/Exception
    //   13	21	139	java/lang/Exception
    //   76	92	139	java/lang/Exception
    //   95	111	139	java/lang/Exception
    //   120	136	139	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i = 20;
    try
    {
      paramContext = paramContext.getSharedPreferences("push_client_self_info", 4);
      SharedPreferences.Editor localEditor;
      int j;
      do
      {
        localEditor = paramContext.edit();
        j = i - 1;
        if (localEditor != null) {
          break;
        }
        i = j;
      } while (j > 0);
      localEditor.putBoolean(paramString, paramBoolean).commit();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences("push_client_self_info", 4).getString("bd_use_xiaomi_regid", null);
  }
  
  public static String c(Context paramContext)
  {
    return paramContext.getSharedPreferences("push_client_self_info", 4).getString("bd_use_meizu_pushid", null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */