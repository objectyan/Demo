package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.h.i;
import com.baidu.android.pushservice.h.q;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class j
{
  public static void a(Context paramContext, Intent paramIntent1, Intent paramIntent2)
  {
    String str = paramIntent1.getStringExtra("message_id");
    ArrayList localArrayList = new ArrayList();
    Object localObject = new HashMap();
    long l1;
    long l2;
    long l3;
    long l4;
    if (paramIntent2 != null)
    {
      l1 = paramIntent1.getLongExtra("bd.message.rate.GET", 0L);
      l2 = paramIntent1.getLongExtra("bd.message.rate.REDIRECTION", 0L);
      l3 = paramIntent2.getLongExtra("bd.message.rate.BACK", 0L);
      l4 = paramIntent2.getLongExtra("bd.message.rate.END", 0L);
      ((Map)localObject).put("030801", Long.valueOf(l2 - l1));
      ((Map)localObject).put("030802", Long.valueOf(l3 - l2));
      ((Map)localObject).put("030803", Long.valueOf(l4 - l3));
      l1 = l4 - l1;
    }
    for (;;)
    {
      paramIntent1 = new i();
      paramIntent1.d = "030804";
      paramIntent1.b = str;
      paramIntent1.c = (l1 + "");
      paramIntent1.f = "100%";
      paramIntent1.i = (l1 + "");
      paramIntent1.e = System.currentTimeMillis();
      localArrayList.add(paramIntent1);
      paramIntent1 = ((Map)localObject).entrySet().iterator();
      while (paramIntent1.hasNext())
      {
        paramIntent2 = (Map.Entry)paramIntent1.next();
        localObject = new i();
        ((i)localObject).d = ((String)paramIntent2.getKey());
        ((i)localObject).b = str;
        ((i)localObject).c = (l1 + "");
        ((i)localObject).i = (paramIntent2.getValue() + "");
        DecimalFormat localDecimalFormat = new DecimalFormat("#.##");
        ((i)localObject).f = (localDecimalFormat.format(((Long)paramIntent2.getValue()).longValue() / l1 * 100.0D) + "%");
        ((i)localObject).e = System.currentTimeMillis();
        localArrayList.add(localObject);
      }
      l2 = paramIntent1.getLongExtra("bd.message.rate.GET", 0L);
      l3 = paramIntent1.getLongExtra("bd.message.rate.REDIRECTION", 0L);
      l4 = paramIntent1.getLongExtra("bd.message.rate.TIMEOUT", 0L);
      l1 = l4 - l2;
      ((Map)localObject).put("030801", Long.valueOf(l3 - l2));
      ((Map)localObject).put("030803", Long.valueOf(l4 - l3));
      ((Map)localObject).put("030805", Long.valueOf(l1));
    }
    paramIntent1 = localArrayList.iterator();
    while (paramIntent1.hasNext()) {
      q.a(paramContext, (i)paramIntent1.next());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */