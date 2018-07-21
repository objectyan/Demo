package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.message.g;
import com.baidu.android.pushservice.message.k;
import org.json.JSONObject;

public abstract class c
{
  protected Context a;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public abstract g a(k paramk, byte[] paramArrayOfByte);
  
  protected boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte));
      if (!paramArrayOfByte.isNull("bccs_fb"))
      {
        i = Integer.parseInt(paramArrayOfByte.getString("bccs_fb"));
        if (i == 1) {
          bool = true;
        }
        return bool;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        int i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */