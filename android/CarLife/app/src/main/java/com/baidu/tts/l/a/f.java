package com.baidu.tts.l.a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.f.g;
import com.baidu.tts.f.o;
import com.baidu.tts.loopj.RequestHandle;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.tools.JsonTool;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  implements Callable<ModelFileBags>
{
  private RequestHandle a;
  private Set<String> b;
  
  public f(Set<String> paramSet)
  {
    this.b = paramSet;
  }
  
  private StringEntity b()
    throws UnsupportedEncodingException
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put(g.t.a(), "getURL");
      ((JSONObject)localObject).put(g.d.b(), "1");
      JSONArray localJSONArray = JsonTool.fromSetToJson(this.b);
      ((JSONObject)localObject).put(g.i.b(), localJSONArray);
      localObject = ((JSONObject)localObject).toString();
      LoggerProxy.d("GetServerModelFileInfosWork", "geturl params=" + (String)localObject);
      localObject = new StringEntity((String)localObject);
      return (StringEntity)localObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public ModelFileBags a()
    throws Exception
  {
    SyncHttpClient localSyncHttpClient = new SyncHttpClient(true, 80, 443);
    String str = o.b.a() + "https=1";
    StringEntity localStringEntity = b();
    d locald = new d();
    this.a = localSyncHttpClient.post(null, str, localStringEntity, "application/json", locald);
    return locald.a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/l/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */