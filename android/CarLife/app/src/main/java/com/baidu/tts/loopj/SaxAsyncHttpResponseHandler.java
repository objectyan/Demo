package com.baidu.tts.loopj;

import org.apache.http.Header;
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
  protected byte[] getResponseData(org.apache.http.HttpEntity paramHttpEntity)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +79 -> 80
    //   4: aload_1
    //   5: invokeinterface 43 1 0
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull +66 -> 80
    //   17: invokestatic 49	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   20: invokevirtual 53	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   23: invokevirtual 59	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   26: astore_3
    //   27: aload_3
    //   28: aload_0
    //   29: getfield 19	com/baidu/tts/loopj/SaxAsyncHttpResponseHandler:handler	Lorg/xml/sax/helpers/DefaultHandler;
    //   32: invokeinterface 65 2 0
    //   37: new 67	java/io/InputStreamReader
    //   40: dup
    //   41: aload 4
    //   43: aload_0
    //   44: invokevirtual 71	com/baidu/tts/loopj/SaxAsyncHttpResponseHandler:getCharset	()Ljava/lang/String;
    //   47: invokespecial 74	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: new 76	org/xml/sax/InputSource
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 79	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   62: invokeinterface 83 2 0
    //   67: aload 4
    //   69: invokestatic 89	com/baidu/tts/loopj/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 92	java/io/InputStreamReader:close	()V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_3
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: getstatic 96	com/baidu/tts/loopj/AsyncHttpClient:log	Lcom/baidu/tts/loopj/LogInterface;
    //   90: ldc 9
    //   92: ldc 98
    //   94: aload_3
    //   95: invokeinterface 104 4 0
    //   100: aload 4
    //   102: invokestatic 89	com/baidu/tts/loopj/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   105: aload_2
    //   106: ifnull -26 -> 80
    //   109: aload_2
    //   110: invokevirtual 92	java/io/InputStreamReader:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: areturn
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_2
    //   122: astore_1
    //   123: getstatic 96	com/baidu/tts/loopj/AsyncHttpClient:log	Lcom/baidu/tts/loopj/LogInterface;
    //   126: ldc 9
    //   128: ldc 98
    //   130: aload_3
    //   131: invokeinterface 104 4 0
    //   136: aload 4
    //   138: invokestatic 89	com/baidu/tts/loopj/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   141: aload_2
    //   142: ifnull -62 -> 80
    //   145: aload_2
    //   146: invokevirtual 92	java/io/InputStreamReader:close	()V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aconst_null
    //   153: areturn
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_1
    //   157: aload 4
    //   159: invokestatic 89	com/baidu/tts/loopj/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   162: aload_1
    //   163: ifnull +7 -> 170
    //   166: aload_1
    //   167: invokevirtual 92	java/io/InputStreamReader:close	()V
    //   170: aload_2
    //   171: athrow
    //   172: astore_1
    //   173: aconst_null
    //   174: areturn
    //   175: astore_1
    //   176: goto -6 -> 170
    //   179: astore_2
    //   180: goto -23 -> 157
    //   183: astore_3
    //   184: goto -63 -> 121
    //   187: astore_3
    //   188: goto -103 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	SaxAsyncHttpResponseHandler
    //   0	191	1	paramHttpEntity	org.apache.http.HttpEntity
    //   50	96	2	localInputStreamReader	java.io.InputStreamReader
    //   154	17	2	localObject1	Object
    //   179	1	2	localObject2	Object
    //   26	28	3	localXMLReader	org.xml.sax.XMLReader
    //   82	13	3	localSAXException1	org.xml.sax.SAXException
    //   118	13	3	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   183	1	3	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   187	1	3	localSAXException2	org.xml.sax.SAXException
    //   10	148	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   17	51	82	org/xml/sax/SAXException
    //   109	113	115	java/io/IOException
    //   17	51	118	javax/xml/parsers/ParserConfigurationException
    //   145	149	151	java/io/IOException
    //   17	51	154	finally
    //   76	80	172	java/io/IOException
    //   166	170	175	java/io/IOException
    //   53	67	179	finally
    //   87	100	179	finally
    //   123	136	179	finally
    //   53	67	183	javax/xml/parsers/ParserConfigurationException
    //   53	67	187	org/xml/sax/SAXException
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, T paramT);
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    onFailure(paramInt, paramArrayOfHeader, this.handler);
  }
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, T paramT);
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOfHeader, this.handler);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/SaxAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */