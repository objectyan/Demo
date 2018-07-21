package com.baidu.carlife.k.a;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.baidu.carlife.core.i;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

public class c
  extends Request<String>
{
  private String a = "NetWorkRequest";
  private Response.Listener<String> b = null;
  private d c = null;
  private long d;
  private HttpEntity e = null;
  
  public c(int paramInt, String paramString1, d paramd, Response.Listener<String> paramListener, Response.ErrorListener paramErrorListener, boolean paramBoolean, String paramString2)
  {
    super(paramInt, paramString1, paramErrorListener);
    this.b = paramListener;
    this.c = paramd;
    if (paramd != null) {
      paramd.setTag(paramString2);
    }
    this.a = paramString2;
    this.d = System.currentTimeMillis();
    setShouldCache(paramBoolean);
  }
  
  private boolean b()
  {
    if (this.c == null) {}
    do
    {
      return false;
      if ((this.c.fileParams != null) && (!this.c.fileParams.isEmpty())) {
        return true;
      }
    } while (!this.c.isSignNeed());
    return true;
  }
  
  public long a()
  {
    return this.d;
  }
  
  protected void a(String paramString)
  {
    if (this.b != null) {
      this.b.onResponse(paramString);
    }
  }
  
  /* Error */
  public byte[] getBody()
    throws AuthFailureError
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 84	com/baidu/carlife/k/a/c:b	()Z
    //   4: ifeq +76 -> 80
    //   7: new 86	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 89	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore_1
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 29	com/baidu/carlife/k/a/c:c	Lcom/baidu/carlife/k/a/d;
    //   20: invokevirtual 93	com/baidu/carlife/k/a/d:getEntity	()Lorg/apache/http/HttpEntity;
    //   23: putfield 31	com/baidu/carlife/k/a/c:e	Lorg/apache/http/HttpEntity;
    //   26: aload_0
    //   27: getfield 31	com/baidu/carlife/k/a/c:e	Lorg/apache/http/HttpEntity;
    //   30: aload_1
    //   31: invokeinterface 99 2 0
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   44: aload_1
    //   45: invokevirtual 105	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: areturn
    //   49: astore_2
    //   50: aload_2
    //   51: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   54: aload_1
    //   55: ifnull -11 -> 44
    //   58: aload_1
    //   59: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   62: goto -18 -> 44
    //   65: astore_2
    //   66: goto -22 -> 44
    //   69: astore_2
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   78: aload_2
    //   79: athrow
    //   80: aload_0
    //   81: invokespecial 110	com/android/volley/Request:getBody	()[B
    //   84: areturn
    //   85: astore_2
    //   86: goto -42 -> 44
    //   89: astore_1
    //   90: goto -12 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	c
    //   14	61	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   89	1	1	localIOException1	java.io.IOException
    //   49	2	2	localIOException2	java.io.IOException
    //   65	1	2	localIOException3	java.io.IOException
    //   69	10	2	localObject	Object
    //   85	1	2	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   26	36	49	java/io/IOException
    //   58	62	65	java/io/IOException
    //   26	36	69	finally
    //   50	54	69	finally
    //   40	44	85	java/io/IOException
    //   74	78	89	java/io/IOException
  }
  
  public String getBodyContentType()
  {
    if (b()) {
      return this.e.getContentType().getValue();
    }
    return super.getBodyContentType();
  }
  
  public Map<String, String> getHeaders()
    throws AuthFailureError
  {
    return super.getHeaders();
  }
  
  protected Map<String, String> getParams()
    throws AuthFailureError
  {
    if ((this.c != null) && (this.c.urlParams != null) && (!this.c.urlParams.isEmpty()))
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.c.urlParams.iterator();
      while (localIterator.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
        localHashMap.put(localNameValuePair.getName(), localNameValuePair.getValue());
      }
      i.b(this.a, "the post params is:" + localHashMap.toString());
      return localHashMap;
    }
    return super.getParams();
  }
  
  protected Response<String> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    try
    {
      String str1 = new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers));
      return Response.success(str1, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2 = new String(paramNetworkResponse.data);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */