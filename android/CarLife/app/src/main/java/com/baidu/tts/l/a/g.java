package com.baidu.tts.l.a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.f.o;
import com.baidu.tts.loopj.RequestHandle;
import com.baidu.tts.loopj.SyncHttpClient;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Callable;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  implements Callable<ModelBags>
{
  private Conditions a;
  private RequestHandle b;
  
  public g(Conditions paramConditions)
  {
    this.a = paramConditions;
  }
  
  private StringEntity b()
    throws UnsupportedEncodingException
  {
    Object localObject = this.a.getJSONConditions();
    try
    {
      ((JSONObject)localObject).put(com.baidu.tts.f.g.d.b(), "1");
      ((JSONObject)localObject).put(com.baidu.tts.f.g.t.a(), "getList");
      localObject = ((JSONObject)localObject).toString();
      LoggerProxy.d("GetServerModelsWork", "getlist params=" + (String)localObject);
      return new StringEntity((String)localObject);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public ModelBags a()
    throws Exception
  {
    SyncHttpClient localSyncHttpClient = new SyncHttpClient(true, 80, 443);
    String str = o.b.a();
    StringEntity localStringEntity = b();
    a locala = new a();
    this.b = localSyncHttpClient.post(null, str, localStringEntity, "application/json", locala);
    return locala.a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/l/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */