package com.baidu.che.codriver.protocol;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.baidu.che.codriver.util.h;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.UnsupportedEncodingException;

public class c<T>
  extends Request<T>
{
  private final Response.Listener<T> a;
  private final Response.ErrorListener b;
  private Gson c = new Gson();
  private Class<T> d;
  
  public c(int paramInt, String paramString, Class<T> paramClass, Response.Listener<T> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramErrorListener);
    this.d = paramClass;
    this.a = paramListener;
    this.b = paramErrorListener;
  }
  
  public c(String paramString, Class<T> paramClass, Response.Listener<T> paramListener, Response.ErrorListener paramErrorListener)
  {
    this(0, paramString, paramClass, paramListener, paramErrorListener);
  }
  
  public void deliverError(VolleyError paramVolleyError)
  {
    this.b.onErrorResponse(paramVolleyError);
  }
  
  protected void deliverResponse(T paramT)
  {
    this.a.onResponse(paramT);
  }
  
  protected Response<T> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    try
    {
      String str = new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers));
      h.e("parseNetworkResponse", str);
      paramNetworkResponse = Response.success(this.c.fromJson(str, this.d), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
      return paramNetworkResponse;
    }
    catch (UnsupportedEncodingException paramNetworkResponse)
    {
      return Response.error(new ParseError(paramNetworkResponse));
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      localJsonSyntaxException.printStackTrace();
      if (localJsonSyntaxException.getMessage() == null) {}
    }
    for (paramNetworkResponse = localJsonSyntaxException.getMessage();; paramNetworkResponse = "JsonSyntaxError")
    {
      h.e("GsonRequest", paramNetworkResponse);
      return Response.error(new ParseError(localJsonSyntaxException));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */