package com.baidu.tts.loopj;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler
  extends TextHttpResponseHandler
{
  private static final String LOG_TAG = "JsonHttpRH";
  private boolean useRFC5179CompatibilityMode = true;
  
  public JsonHttpResponseHandler()
  {
    super("UTF-8");
  }
  
  public JsonHttpResponseHandler(String paramString)
  {
    super(paramString);
  }
  
  public JsonHttpResponseHandler(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.useRFC5179CompatibilityMode = paramBoolean;
  }
  
  public JsonHttpResponseHandler(boolean paramBoolean)
  {
    super("UTF-8");
    this.useRFC5179CompatibilityMode = paramBoolean;
  }
  
  public boolean isUseRFC5179CompatibilityMode()
  {
    return this.useRFC5179CompatibilityMode;
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable)
  {
    AsyncHttpClient.log.w("JsonHttpRH", "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", paramThrowable);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONArray paramJSONArray)
  {
    AsyncHttpClient.log.w("JsonHttpRH", "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", paramThrowable);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONObject paramJSONObject)
  {
    AsyncHttpClient.log.w("JsonHttpRH", "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", paramThrowable);
  }
  
  public final void onFailure(final int paramInt, final Header[] paramArrayOfHeader, final byte[] paramArrayOfByte, final Throwable paramThrowable)
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfHeader = new Runnable()
      {
        public void run()
        {
          try
          {
            final Object localObject = JsonHttpResponseHandler.this.parseResponse(paramArrayOfByte);
            JsonHttpResponseHandler.this.postRunnable(new Runnable()
            {
              public void run()
              {
                if ((!JsonHttpResponseHandler.this.useRFC5179CompatibilityMode) && (localObject == null))
                {
                  JsonHttpResponseHandler.this.onFailure(JsonHttpResponseHandler.2.this.val$statusCode, JsonHttpResponseHandler.2.this.val$headers, (String)null, JsonHttpResponseHandler.2.this.val$throwable);
                  return;
                }
                if ((localObject instanceof JSONObject))
                {
                  JsonHttpResponseHandler.this.onFailure(JsonHttpResponseHandler.2.this.val$statusCode, JsonHttpResponseHandler.2.this.val$headers, JsonHttpResponseHandler.2.this.val$throwable, (JSONObject)localObject);
                  return;
                }
                if ((localObject instanceof JSONArray))
                {
                  JsonHttpResponseHandler.this.onFailure(JsonHttpResponseHandler.2.this.val$statusCode, JsonHttpResponseHandler.2.this.val$headers, JsonHttpResponseHandler.2.this.val$throwable, (JSONArray)localObject);
                  return;
                }
                if ((localObject instanceof String))
                {
                  JsonHttpResponseHandler.this.onFailure(JsonHttpResponseHandler.2.this.val$statusCode, JsonHttpResponseHandler.2.this.val$headers, (String)localObject, JsonHttpResponseHandler.2.this.val$throwable);
                  return;
                }
                JsonHttpResponseHandler.this.onFailure(JsonHttpResponseHandler.2.this.val$statusCode, JsonHttpResponseHandler.2.this.val$headers, new JSONException("Unexpected response type " + localObject.getClass().getName()), (JSONObject)null);
              }
            });
            return;
          }
          catch (JSONException localJSONException)
          {
            JsonHttpResponseHandler.this.postRunnable(new Runnable()
            {
              public void run()
              {
                JsonHttpResponseHandler.this.onFailure(JsonHttpResponseHandler.2.this.val$statusCode, JsonHttpResponseHandler.2.this.val$headers, localJSONException, (JSONObject)null);
              }
            });
          }
        }
      };
      if ((!getUseSynchronousMode()) && (!getUsePoolThread()))
      {
        new Thread(paramArrayOfHeader).start();
        return;
      }
      paramArrayOfHeader.run();
      return;
    }
    AsyncHttpClient.log.v("JsonHttpRH", "response body is null, calling onFailure(Throwable, JSONObject)");
    onFailure(paramInt, paramArrayOfHeader, paramThrowable, (JSONObject)null);
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    AsyncHttpClient.log.w("JsonHttpRH", "onSuccess(int, Header[], String) was not overriden, but callback was received");
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONArray paramJSONArray)
  {
    AsyncHttpClient.log.w("JsonHttpRH", "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    AsyncHttpClient.log.w("JsonHttpRH", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
  }
  
  public final void onSuccess(final int paramInt, final Header[] paramArrayOfHeader, final byte[] paramArrayOfByte)
  {
    if (paramInt != 204)
    {
      paramArrayOfHeader = new Runnable()
      {
        public void run()
        {
          try
          {
            final Object localObject = JsonHttpResponseHandler.this.parseResponse(paramArrayOfByte);
            JsonHttpResponseHandler.this.postRunnable(new Runnable()
            {
              public void run()
              {
                if ((!JsonHttpResponseHandler.this.useRFC5179CompatibilityMode) && (localObject == null))
                {
                  JsonHttpResponseHandler.this.onSuccess(JsonHttpResponseHandler.1.this.val$statusCode, JsonHttpResponseHandler.1.this.val$headers, (String)null);
                  return;
                }
                if ((localObject instanceof JSONObject))
                {
                  JsonHttpResponseHandler.this.onSuccess(JsonHttpResponseHandler.1.this.val$statusCode, JsonHttpResponseHandler.1.this.val$headers, (JSONObject)localObject);
                  return;
                }
                if ((localObject instanceof JSONArray))
                {
                  JsonHttpResponseHandler.this.onSuccess(JsonHttpResponseHandler.1.this.val$statusCode, JsonHttpResponseHandler.1.this.val$headers, (JSONArray)localObject);
                  return;
                }
                if ((localObject instanceof String))
                {
                  if (JsonHttpResponseHandler.this.useRFC5179CompatibilityMode)
                  {
                    JsonHttpResponseHandler.this.onFailure(JsonHttpResponseHandler.1.this.val$statusCode, JsonHttpResponseHandler.1.this.val$headers, (String)localObject, new JSONException("Response cannot be parsed as JSON data"));
                    return;
                  }
                  JsonHttpResponseHandler.this.onSuccess(JsonHttpResponseHandler.1.this.val$statusCode, JsonHttpResponseHandler.1.this.val$headers, (String)localObject);
                  return;
                }
                JsonHttpResponseHandler.this.onFailure(JsonHttpResponseHandler.1.this.val$statusCode, JsonHttpResponseHandler.1.this.val$headers, new JSONException("Unexpected response type " + localObject.getClass().getName()), (JSONObject)null);
              }
            });
            return;
          }
          catch (JSONException localJSONException)
          {
            JsonHttpResponseHandler.this.postRunnable(new Runnable()
            {
              public void run()
              {
                JsonHttpResponseHandler.this.onFailure(JsonHttpResponseHandler.1.this.val$statusCode, JsonHttpResponseHandler.1.this.val$headers, localJSONException, (JSONObject)null);
              }
            });
          }
        }
      };
      if ((!getUseSynchronousMode()) && (!getUsePoolThread()))
      {
        new Thread(paramArrayOfHeader).start();
        return;
      }
      paramArrayOfHeader.run();
      return;
    }
    onSuccess(paramInt, paramArrayOfHeader, new JSONObject());
  }
  
  protected Object parseResponse(byte[] paramArrayOfByte)
    throws JSONException
  {
    Object localObject1 = null;
    if (paramArrayOfByte == null) {
      paramArrayOfByte = (byte[])localObject1;
    }
    for (;;)
    {
      return paramArrayOfByte;
      paramArrayOfByte = getResponseString(paramArrayOfByte, getCharset());
      localObject1 = paramArrayOfByte;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.trim();
        if (this.useRFC5179CompatibilityMode)
        {
          if (!paramArrayOfByte.startsWith("{"))
          {
            localObject1 = paramArrayOfByte;
            if (!paramArrayOfByte.startsWith("[")) {
              break label163;
            }
          }
          localObject1 = new JSONTokener(paramArrayOfByte).nextValue();
        }
      }
      while (localObject1 != null)
      {
        return localObject1;
        if (((paramArrayOfByte.startsWith("{")) && (paramArrayOfByte.endsWith("}"))) || ((paramArrayOfByte.startsWith("[")) && (paramArrayOfByte.endsWith("]"))))
        {
          localObject1 = new JSONTokener(paramArrayOfByte).nextValue();
        }
        else
        {
          localObject1 = paramArrayOfByte;
          if (paramArrayOfByte.startsWith("\""))
          {
            localObject1 = paramArrayOfByte;
            if (paramArrayOfByte.endsWith("\""))
            {
              localObject1 = paramArrayOfByte.substring(1, paramArrayOfByte.length() - 1);
              continue;
            }
          }
          label163:
          Object localObject2 = null;
          paramArrayOfByte = (byte[])localObject1;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void setUseRFC5179CompatibilityMode(boolean paramBoolean)
  {
    this.useRFC5179CompatibilityMode = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/JsonHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */