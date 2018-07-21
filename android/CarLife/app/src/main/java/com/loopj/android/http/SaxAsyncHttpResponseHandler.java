package com.loopj.android.http;

import cz.msebera.android.httpclient.f;
import org.xml.sax.helpers.DefaultHandler;

public abstract class SaxAsyncHttpResponseHandler<T extends DefaultHandler>
  extends AsyncHttpResponseHandler
{
  private static final String LOG_TAG = "SaxAsyncHttpRH";
  private T handler = null;
  
  public SaxAsyncHttpResponseHandler(T paramT)
  {
    if (paramT == null) {
      throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
    }
    this.handler = paramT;
  }
  
  /* Error */
  protected byte[] getResponseData(cz.msebera.android.httpclient.n paramn)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +93 -> 94
    //   4: aload_1
    //   5: invokeinterface 43 1 0
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore_2
    //   17: aconst_null
    //   18: astore_3
    //   19: aload 5
    //   21: ifnull +73 -> 94
    //   24: aload_2
    //   25: astore_1
    //   26: invokestatic 49	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   29: invokevirtual 53	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   32: invokevirtual 59	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   35: astore 6
    //   37: aload_2
    //   38: astore_1
    //   39: aload 6
    //   41: aload_0
    //   42: getfield 19	com/loopj/android/http/SaxAsyncHttpResponseHandler:handler	Lorg/xml/sax/helpers/DefaultHandler;
    //   45: invokeinterface 65 2 0
    //   50: aload_2
    //   51: astore_1
    //   52: new 67	java/io/InputStreamReader
    //   55: dup
    //   56: aload 5
    //   58: aload_0
    //   59: invokevirtual 71	com/loopj/android/http/SaxAsyncHttpResponseHandler:getCharset	()Ljava/lang/String;
    //   62: invokespecial 74	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   65: astore_2
    //   66: aload 6
    //   68: new 76	org/xml/sax/InputSource
    //   71: dup
    //   72: aload_2
    //   73: invokespecial 79	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   76: invokeinterface 83 2 0
    //   81: aload 5
    //   83: invokestatic 89	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 92	java/io/InputStreamReader:close	()V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_1
    //   97: aload_3
    //   98: astore_2
    //   99: aload_1
    //   100: astore_3
    //   101: aload_2
    //   102: astore_1
    //   103: getstatic 96	com/loopj/android/http/AsyncHttpClient:log	Lcom/loopj/android/http/LogInterface;
    //   106: ldc 9
    //   108: ldc 98
    //   110: aload_3
    //   111: invokeinterface 104 4 0
    //   116: aload 5
    //   118: invokestatic 89	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   121: aload_2
    //   122: ifnull -28 -> 94
    //   125: aload_2
    //   126: invokevirtual 92	java/io/InputStreamReader:close	()V
    //   129: goto -35 -> 94
    //   132: astore_1
    //   133: goto -39 -> 94
    //   136: astore_3
    //   137: aload 4
    //   139: astore_2
    //   140: aload_2
    //   141: astore_1
    //   142: getstatic 96	com/loopj/android/http/AsyncHttpClient:log	Lcom/loopj/android/http/LogInterface;
    //   145: ldc 9
    //   147: ldc 98
    //   149: aload_3
    //   150: invokeinterface 104 4 0
    //   155: aload 5
    //   157: invokestatic 89	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   160: aload_2
    //   161: ifnull -67 -> 94
    //   164: aload_2
    //   165: invokevirtual 92	java/io/InputStreamReader:close	()V
    //   168: goto -74 -> 94
    //   171: astore_1
    //   172: goto -78 -> 94
    //   175: astore_2
    //   176: aload 5
    //   178: invokestatic 89	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 92	java/io/InputStreamReader:close	()V
    //   189: aload_2
    //   190: athrow
    //   191: astore_1
    //   192: goto -98 -> 94
    //   195: astore_1
    //   196: goto -7 -> 189
    //   199: astore_3
    //   200: aload_2
    //   201: astore_1
    //   202: aload_3
    //   203: astore_2
    //   204: goto -28 -> 176
    //   207: astore_3
    //   208: goto -68 -> 140
    //   211: astore_3
    //   212: goto -111 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	SaxAsyncHttpResponseHandler
    //   0	215	1	paramn	cz.msebera.android.httpclient.n
    //   16	149	2	localObject1	Object
    //   175	26	2	localObject2	Object
    //   203	1	2	localObject3	Object
    //   18	93	3	localn	cz.msebera.android.httpclient.n
    //   136	14	3	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   199	4	3	localObject4	Object
    //   207	1	3	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   211	1	3	localSAXException	org.xml.sax.SAXException
    //   13	125	4	localObject5	Object
    //   10	167	5	localInputStream	java.io.InputStream
    //   35	32	6	localXMLReader	org.xml.sax.XMLReader
    // Exception table:
    //   from	to	target	type
    //   26	37	96	org/xml/sax/SAXException
    //   39	50	96	org/xml/sax/SAXException
    //   52	66	96	org/xml/sax/SAXException
    //   125	129	132	java/io/IOException
    //   26	37	136	javax/xml/parsers/ParserConfigurationException
    //   39	50	136	javax/xml/parsers/ParserConfigurationException
    //   52	66	136	javax/xml/parsers/ParserConfigurationException
    //   164	168	171	java/io/IOException
    //   26	37	175	finally
    //   39	50	175	finally
    //   52	66	175	finally
    //   103	116	175	finally
    //   142	155	175	finally
    //   90	94	191	java/io/IOException
    //   185	189	195	java/io/IOException
    //   66	81	199	finally
    //   66	81	207	javax/xml/parsers/ParserConfigurationException
    //   66	81	211	org/xml/sax/SAXException
  }
  
  public abstract void onFailure(int paramInt, f[] paramArrayOff, T paramT);
  
  public void onFailure(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    onFailure(paramInt, paramArrayOff, this.handler);
  }
  
  public abstract void onSuccess(int paramInt, f[] paramArrayOff, T paramT);
  
  public void onSuccess(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOff, this.handler);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/SaxAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */