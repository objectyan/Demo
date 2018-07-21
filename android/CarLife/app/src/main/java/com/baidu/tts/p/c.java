package com.baidu.tts.p;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.o;
import com.baidu.tts.loopj.RequestHandle;
import com.baidu.tts.loopj.SyncHttpClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  ExecutorService a = Executors.newSingleThreadExecutor();
  private Context b;
  private com.baidu.tts.l.a c;
  private FutureTask<Integer> d;
  private int e = 0;
  private int f = 0;
  
  public c(Context paramContext)
  {
    this.b = paramContext;
    this.c = new com.baidu.tts.l.a(paramContext);
  }
  
  public FutureTask<Integer> a()
  {
    this.d = new FutureTask(new a());
    this.a.submit(this.d);
    return this.d;
  }
  
  public void b()
  {
    this.d.cancel(true);
  }
  
  public class a
    implements Callable<Integer>
  {
    private RequestHandle b;
    
    public a() {}
    
    private UrlEncodedFormEntity b()
    {
      Object localObject1 = new ArrayList();
      JSONObject localJSONObject = new JSONObject();
      Object localObject2 = (ArrayList)c.c(c.this).f().get("listId");
      if (((ArrayList)localObject2).size() != 0)
      {
        c.a(c.this, ((Integer)((ArrayList)localObject2).get(0)).intValue());
        c.b(c.this, ((Integer)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).intValue());
      }
      localObject2 = new JSONArray((ArrayList)c.c(c.this).f().get("list"));
      try
      {
        localJSONObject.put("deviceInfo", a.a(c.d(c.this)));
        localJSONObject.put("appinfo", a.b(c.d(c.this)));
        localJSONObject.put("methodinfo", localObject2);
        LoggerProxy.d("UploadStatistics", "StatisticsData= " + localJSONObject.toString());
        ((List)localObject1).add(new BasicNameValuePair("d", localJSONObject.toString()));
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          try
          {
            localObject1 = new UrlEncodedFormEntity((List)localObject1, "UTF-8");
            return (UrlEncodedFormEntity)localObject1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
        }
      }
      return null;
    }
    
    public Integer a()
      throws Exception
    {
      SyncHttpClient localSyncHttpClient = new SyncHttpClient(true, 80, 443);
      String str = o.c.a();
      UrlEncodedFormEntity localUrlEncodedFormEntity = b();
      d locald = new d();
      this.b = localSyncHttpClient.post(null, str, localUrlEncodedFormEntity, null, locald);
      final int i = locald.a();
      c.this.a.submit(new Runnable()
      {
        public void run()
        {
          if (i == 0)
          {
            int i = c.c(c.this).a(c.a(c.this), c.b(c.this));
            LoggerProxy.d("UploadStatistics", "delete database code==" + i);
          }
        }
      });
      return Integer.valueOf(i);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/p/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */