package com.baidu.carlife.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.l.a;
import com.baidu.carlife.view.dialog.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class x
{
  public static final String a = "VehicleChannelUtils";
  private static c b = null;
  private static List<String> c = new ArrayList();
  
  public static void a()
  {
    c.clear();
    c.add("20062100");
    c.add("20062101");
    c.add("20062102");
    c.add("20062103");
    c.add("20062104");
    c.add("20062105");
  }
  
  public static void a(Context paramContext, e parame)
  {
    if (paramContext == null) {}
    do
    {
      return;
      if (b == null)
      {
        b = new c(paramContext);
        b.b(2131296284);
        b.c(2131296265);
        b.a(2131296437);
        b.a(new b()
        {
          public void onClick()
          {
            a.a().O();
            x.a(null);
          }
        });
        b.setOnDialogCancelListener(new d()
        {
          public void onCancel()
          {
            a.a().O();
            x.a(null);
          }
        });
      }
    } while (parame == null);
    parame.showDialog(b);
  }
  
  public static boolean a(Context paramContext, String paramString, e parame)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.trim();
    if ((TextUtils.isEmpty(paramString)) || (!paramString.matches("2(\\d){7}")) || (f.a.ah.a().equals(paramString)) || (f.a.ai.a().equals(paramString)))
    {
      a(paramContext, parame);
      return false;
    }
    return true;
  }
  
  public static boolean b()
  {
    String str = f.jx.a();
    boolean bool2 = false;
    Iterator localIterator = c.iterator();
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!TextUtils.equals(str, (String)localIterator.next()));
    boolean bool1 = true;
    return bool1;
  }
  
  public static boolean c()
  {
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */