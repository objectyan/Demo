package com.baidu.tts.client.model;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.l.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class RecordData
{
  ExecutorService a = Executors.newSingleThreadExecutor();
  private a b;
  
  public RecordData(a parama)
  {
    this.b = parama;
  }
  
  public void setEndInfo(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("modeId", paramString2);
      localJSONObject.put("result", paramInt);
      localJSONObject.put("endTime", paramString3);
      LoggerProxy.d("RecordData", "EndInfo json= " + localJSONObject.toString());
      this.a.submit(new InsertData(localJSONObject, paramString1, "endInfo"));
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setStartInfo(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("startTime", paramString3);
      localJSONObject.put("modeId", paramString2);
      LoggerProxy.d("RecordData", " StartInfo json= " + localJSONObject.toString());
      this.a.submit(new InsertData(null, paramString1, null));
      this.a.submit(new InsertData(localJSONObject, paramString1, "startInfo"));
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public class InsertData
    implements Callable<Integer>
  {
    private JSONObject b;
    private String c;
    private String d;
    
    public InsertData(JSONObject paramJSONObject, String paramString1, String paramString2)
    {
      this.b = paramJSONObject;
      this.c = paramString1;
      this.d = paramString2;
    }
    
    public Integer call()
      throws Exception
    {
      if ((this.b == null) && (this.d == null)) {
        RecordData.a(RecordData.this).c(this.c);
      }
      for (;;)
      {
        return Integer.valueOf(0);
        RecordData.a(RecordData.this).a(this.c, this.d, this.b.toString());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/RecordData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */