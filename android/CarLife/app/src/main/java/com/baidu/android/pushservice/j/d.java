package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private static Map<Long, e> a;
  
  public static void a(long paramLong)
  {
    try
    {
      if (a.containsKey(Long.valueOf(paramLong))) {
        a.remove(a.get(Long.valueOf(paramLong)));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    String str1;
    long l;
    if (paramIntent.hasExtra("bd.cross.request.COMMAND_TYPE"))
    {
      str1 = paramIntent.getStringExtra("bd.cross.request.COMMAND_TYPE");
      if (!TextUtils.isEmpty(str1))
      {
        if ((!str1.equals("bd.cross.command.MESSAGE_ACK")) && (!str1.equals("bd.cross.command.ULTRON_ACK"))) {
          break label121;
        }
        l = paramIntent.getLongExtra("bd.cross.request.ID", 0L);
        if ((l != 0L) && (a != null) && (a.containsKey(Long.valueOf(l)))) {
          ((e)a.get(Long.valueOf(l))).a(paramIntent);
        }
      }
    }
    label121:
    String str2;
    do
    {
      a.remove(a.get(Long.valueOf(l)));
      do
      {
        return;
      } while (!str1.equals("bd.cross.command.ULTRON_DELIVER"));
      paramIntent.getLongExtra("bd.cross.request.ID", 0L);
      str1 = paramIntent.getStringExtra("bd.cross.request.SOURCE_SERVICE");
      str2 = paramIntent.getStringExtra("bd.cross.request.SOURCE_PACKAGE");
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    paramIntent.setPackage(str2);
    paramIntent.setClassName(str2, str1);
    paramIntent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
    paramIntent.putExtra("bd.cross.request.SENDING", false);
    paramIntent.putExtra("bd.cross.request.RESULT_CODE", (short)10);
    paramIntent.putExtra("bd.cross.request.RESULT_DATA", "{DATA:\"OK\"}");
    paramIntent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.ULTRON_ACK");
    try
    {
      paramContext.startService(paramIntent);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(e parame)
  {
    try
    {
      if (a == null) {
        a = Collections.synchronizedMap(new HashMap());
      }
      if (a.containsKey(Long.valueOf(parame.a()))) {
        ((e)a.remove(parame)).a();
      }
      a.put(Long.valueOf(parame.a()), parame);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */