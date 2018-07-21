package com.baidu.android.pushservice.message;

import android.content.Context;
import com.baidu.android.pushservice.j;
import com.baidu.android.pushservice.j.p;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends c
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public g a(e parame)
  {
    int i = -1;
    g localg = new g();
    parame = new String(parame.c);
    try
    {
      parame = new JSONObject(parame);
      if (parame != null) {
        i = parame.optInt("ret", -1);
      }
      if (i == 0)
      {
        com.baidu.android.pushservice.e.b.a(this.a);
        localg.a(i);
        return localg;
      }
    }
    catch (JSONException parame)
    {
      for (;;)
      {
        parame = null;
        continue;
        if (i == 5003)
        {
          com.baidu.android.pushservice.e.b.a(this.a);
        }
        else if (i == 2002)
        {
          j.a(this.a).a(null, null);
          p.e(this.a);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */