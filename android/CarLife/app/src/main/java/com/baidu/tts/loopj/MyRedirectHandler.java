package com.baidu.tts.loopj;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

class MyRedirectHandler
  extends DefaultRedirectHandler
{
  private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
  private final boolean enableRedirects;
  
  public MyRedirectHandler(boolean paramBoolean)
  {
    this.enableRedirects = paramBoolean;
  }
  
  /* Error */
  public java.net.URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws org.apache.http.ProtocolException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 26	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 28
    //   10: invokespecial 31	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_1
    //   15: ldc 33
    //   17: invokeinterface 39 2 0
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +40 -> 64
    //   27: new 22	org/apache/http/ProtocolException
    //   30: dup
    //   31: new 41	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   38: ldc 44
    //   40: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokeinterface 52 1 0
    //   49: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc 57
    //   54: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 62	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;)V
    //   63: athrow
    //   64: aload_3
    //   65: invokeinterface 67 1 0
    //   70: ldc 69
    //   72: ldc 71
    //   74: invokevirtual 77	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 4
    //   79: new 79	java/net/URI
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 80	java/net/URI:<init>	(Ljava/lang/String;)V
    //   88: astore_3
    //   89: aload_1
    //   90: invokeinterface 84 1 0
    //   95: astore 4
    //   97: aload_3
    //   98: invokevirtual 88	java/net/URI:isAbsolute	()Z
    //   101: ifne +307 -> 408
    //   104: aload 4
    //   106: ldc 90
    //   108: invokeinterface 96 2 0
    //   113: ifeq +65 -> 178
    //   116: new 22	org/apache/http/ProtocolException
    //   119: dup
    //   120: new 41	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   127: ldc 98
    //   129: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_3
    //   133: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   136: ldc 100
    //   138: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokespecial 62	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;)V
    //   147: athrow
    //   148: astore_1
    //   149: new 22	org/apache/http/ProtocolException
    //   152: dup
    //   153: new 41	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   160: ldc 102
    //   162: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 4
    //   167: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: aload_1
    //   174: invokespecial 105	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: athrow
    //   178: aload_2
    //   179: ldc 107
    //   181: invokeinterface 113 2 0
    //   186: checkcast 115	org/apache/http/HttpHost
    //   189: astore_1
    //   190: aload_1
    //   191: ifnonnull +13 -> 204
    //   194: new 117	java/lang/IllegalStateException
    //   197: dup
    //   198: ldc 119
    //   200: invokespecial 120	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   203: athrow
    //   204: aload_2
    //   205: ldc 122
    //   207: invokeinterface 113 2 0
    //   212: checkcast 124	org/apache/http/HttpRequest
    //   215: astore 5
    //   217: new 79	java/net/URI
    //   220: dup
    //   221: aload 5
    //   223: invokeinterface 128 1 0
    //   228: invokeinterface 133 1 0
    //   233: invokespecial 80	java/net/URI:<init>	(Ljava/lang/String;)V
    //   236: aload_1
    //   237: iconst_1
    //   238: invokestatic 139	org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;Lorg/apache/http/HttpHost;Z)Ljava/net/URI;
    //   241: aload_3
    //   242: invokestatic 143	org/apache/http/client/utils/URIUtils:resolve	(Ljava/net/URI;Ljava/net/URI;)Ljava/net/URI;
    //   245: astore_1
    //   246: aload 4
    //   248: ldc -111
    //   250: invokeinterface 148 2 0
    //   255: ifeq +151 -> 406
    //   258: aload_2
    //   259: ldc 8
    //   261: invokeinterface 113 2 0
    //   266: checkcast 150	org/apache/http/impl/client/RedirectLocations
    //   269: astore 4
    //   271: aload 4
    //   273: astore_3
    //   274: aload 4
    //   276: ifnonnull +20 -> 296
    //   279: new 150	org/apache/http/impl/client/RedirectLocations
    //   282: dup
    //   283: invokespecial 151	org/apache/http/impl/client/RedirectLocations:<init>	()V
    //   286: astore_3
    //   287: aload_2
    //   288: ldc 8
    //   290: aload_3
    //   291: invokeinterface 155 3 0
    //   296: aload_1
    //   297: invokevirtual 158	java/net/URI:getFragment	()Ljava/lang/String;
    //   300: ifnull +96 -> 396
    //   303: aload_1
    //   304: new 115	org/apache/http/HttpHost
    //   307: dup
    //   308: aload_1
    //   309: invokevirtual 161	java/net/URI:getHost	()Ljava/lang/String;
    //   312: aload_1
    //   313: invokevirtual 165	java/net/URI:getPort	()I
    //   316: aload_1
    //   317: invokevirtual 168	java/net/URI:getScheme	()Ljava/lang/String;
    //   320: invokespecial 171	org/apache/http/HttpHost:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: iconst_1
    //   324: invokestatic 139	org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;Lorg/apache/http/HttpHost;Z)Ljava/net/URI;
    //   327: astore_2
    //   328: aload_3
    //   329: aload_2
    //   330: invokevirtual 175	org/apache/http/impl/client/RedirectLocations:contains	(Ljava/net/URI;)Z
    //   333: ifeq +68 -> 401
    //   336: new 177	org/apache/http/client/CircularRedirectException
    //   339: dup
    //   340: new 41	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   347: ldc -77
    //   349: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_2
    //   353: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   356: ldc -75
    //   358: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokespecial 182	org/apache/http/client/CircularRedirectException:<init>	(Ljava/lang/String;)V
    //   367: athrow
    //   368: astore_1
    //   369: new 22	org/apache/http/ProtocolException
    //   372: dup
    //   373: aload_1
    //   374: invokevirtual 185	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   377: aload_1
    //   378: invokespecial 105	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: athrow
    //   382: astore_1
    //   383: new 22	org/apache/http/ProtocolException
    //   386: dup
    //   387: aload_1
    //   388: invokevirtual 185	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   391: aload_1
    //   392: invokespecial 105	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: athrow
    //   396: aload_1
    //   397: astore_2
    //   398: goto -70 -> 328
    //   401: aload_3
    //   402: aload_2
    //   403: invokevirtual 189	org/apache/http/impl/client/RedirectLocations:add	(Ljava/net/URI;)V
    //   406: aload_1
    //   407: areturn
    //   408: aload_3
    //   409: astore_1
    //   410: goto -164 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	MyRedirectHandler
    //   0	413	1	paramHttpResponse	HttpResponse
    //   0	413	2	paramHttpContext	HttpContext
    //   22	387	3	localObject1	Object
    //   77	198	4	localObject2	Object
    //   215	7	5	localHttpRequest	org.apache.http.HttpRequest
    // Exception table:
    //   from	to	target	type
    //   79	89	148	java/net/URISyntaxException
    //   217	246	368	java/net/URISyntaxException
    //   303	328	382	java/net/URISyntaxException
  }
  
  public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (!this.enableRedirects) {
      return false;
    }
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    switch (paramHttpResponse.getStatusLine().getStatusCode())
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      return false;
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/MyRedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */