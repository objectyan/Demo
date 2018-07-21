package com.baidu.tts.p;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.f.g;
import com.baidu.tts.f.n;
import com.baidu.tts.h.a.c;
import com.baidu.tts.loopj.JsonHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONObject;

public class d
  extends JsonHttpResponseHandler
{
  private TtsError a;
  private int b = -1;
  
  public int a()
  {
    return this.b;
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONObject paramJSONObject)
  {
    paramArrayOfHeader = null;
    if (paramJSONObject != null) {
      paramArrayOfHeader = paramJSONObject.toString();
    }
    this.a = c.a().a(n.ac, paramInt, paramArrayOfHeader, paramThrowable);
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    paramInt = paramJSONObject.optInt(g.u.a());
    paramArrayOfHeader = paramJSONObject.optString(g.v.a());
    if (paramInt == 0)
    {
      this.b = paramInt;
      return;
    }
    this.a = c.a().a(n.ad, paramInt, paramArrayOfHeader);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/p/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */