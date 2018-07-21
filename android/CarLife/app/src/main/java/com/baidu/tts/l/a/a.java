package com.baidu.tts.l.a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.f.g;
import com.baidu.tts.f.n;
import com.baidu.tts.h.a.c;
import com.baidu.tts.loopj.JsonHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONObject;

public class a
  extends JsonHttpResponseHandler
{
  private TtsError a;
  private ModelBags b;
  
  public ModelBags a()
  {
    return this.b;
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable)
  {
    LoggerProxy.d("GetListHttpHandler", "onFailure1");
    this.a = c.a().a(n.ac, paramInt, paramString, paramThrowable);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONObject paramJSONObject)
  {
    LoggerProxy.d("GetListHttpHandler", "onFailure2");
    paramArrayOfHeader = null;
    if (paramJSONObject != null) {
      paramArrayOfHeader = paramJSONObject.toString();
    }
    this.a = c.a().a(n.ac, paramInt, paramArrayOfHeader, paramThrowable);
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    LoggerProxy.d("GetListHttpHandler", "onSuccess response=" + paramJSONObject);
    paramInt = paramJSONObject.optInt(g.u.a());
    paramArrayOfHeader = paramJSONObject.optString(g.v.a());
    if ((paramInt == 0) || (paramInt == 64532))
    {
      paramArrayOfHeader = paramJSONObject.optJSONArray(g.n.b());
      this.b = new ModelBags();
      this.b.parseJson(paramArrayOfHeader);
      return;
    }
    this.a = c.a().a(n.ad, paramInt, paramArrayOfHeader);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/l/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */