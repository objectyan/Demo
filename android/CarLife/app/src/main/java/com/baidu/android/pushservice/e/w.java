package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import java.util.HashMap;

public class w
  extends c
{
  protected String d;
  
  public w(l paraml, Context paramContext, String paramString)
  {
    super(paraml, paramContext);
    this.d = paramString;
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (paramIntent != null) {
      paramIntent.getIntExtra("error_msg", -1);
    }
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    super.a(paramHashMap);
    paramHashMap.put("method", "settags");
    paramHashMap.put("tags", this.d);
  }
  
  protected String b(String paramString)
  {
    return super.b(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */