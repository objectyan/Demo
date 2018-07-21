package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;

public class v
  extends e
{
  protected String d = null;
  protected String e = null;
  protected String f = null;
  protected String g = null;
  
  public v(l paraml, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paraml, paramContext);
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    super.a(paramHashMap);
    paramHashMap.put("method", "sendmsgtouser");
    paramHashMap.put("appid", this.d);
    paramHashMap.put("user_id", this.e);
    if ((this.g != null) && (this.f != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder("[\"");
      localStringBuilder1.append(this.f).append("\"]");
      StringBuilder localStringBuilder2 = new StringBuilder("[\"");
      localStringBuilder2.append(this.g).append("\"]");
      paramHashMap.put("msg_keys", localStringBuilder1.toString());
      paramHashMap.put("messages", localStringBuilder2.toString());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */