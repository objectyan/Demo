package com.baidu.navisdk.util.common;

import com.baidu.nplatform.comjni.tools.JNITools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils
{
  public static final int DEFAULT_PROXY_PORT = 80;
  public static final int HTTP_OK_CODE = 202;
  public static final String http = "http://";
  public static final String https = "https://";
  
  public static String buildParamListInHttpRequest(List<NameValuePair> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append(((NameValuePair)paramList.get(i)).getName());
      localStringBuffer.append("=");
      localStringBuffer.append(((NameValuePair)paramList.get(i)).getValue());
      if (i < paramList.size() - 1) {
        localStringBuffer.append("&");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static String buildParamListInHttpRequestUrlEncode(List<NameValuePair> paramList)
  {
    // Byte code:
    //   0: new 25	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 26	java/lang/StringBuffer:<init>	()V
    //   7: astore_2
    //   8: iconst_0
    //   9: istore_1
    //   10: iload_1
    //   11: aload_0
    //   12: invokeinterface 32 1 0
    //   17: if_icmpge +118 -> 135
    //   20: aload_2
    //   21: aload_0
    //   22: iload_1
    //   23: invokeinterface 36 2 0
    //   28: checkcast 38	org/apache/http/NameValuePair
    //   31: invokeinterface 42 1 0
    //   36: ldc 65
    //   38: invokestatic 71	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: invokevirtual 46	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   44: pop
    //   45: aload_2
    //   46: ldc 48
    //   48: invokevirtual 46	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload_2
    //   53: aload_0
    //   54: iload_1
    //   55: invokeinterface 36 2 0
    //   60: checkcast 38	org/apache/http/NameValuePair
    //   63: invokeinterface 51 1 0
    //   68: ldc 65
    //   70: invokestatic 71	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: invokevirtual 46	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   76: pop
    //   77: iload_1
    //   78: aload_0
    //   79: invokeinterface 32 1 0
    //   84: iconst_1
    //   85: isub
    //   86: if_icmpge +10 -> 96
    //   89: aload_2
    //   90: ldc 53
    //   92: invokevirtual 46	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   95: pop
    //   96: iload_1
    //   97: iconst_1
    //   98: iadd
    //   99: istore_1
    //   100: goto -90 -> 10
    //   103: astore_3
    //   104: aload_3
    //   105: invokevirtual 74	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   108: goto -63 -> 45
    //   111: astore_3
    //   112: aload_3
    //   113: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   116: goto -71 -> 45
    //   119: astore_3
    //   120: aload_3
    //   121: invokevirtual 74	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   124: goto -47 -> 77
    //   127: astore_3
    //   128: aload_3
    //   129: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   132: goto -55 -> 77
    //   135: aload_2
    //   136: invokevirtual 56	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   139: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramList	List<NameValuePair>
    //   9	91	1	i	int
    //   7	129	2	localStringBuffer	StringBuffer
    //   103	2	3	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   111	2	3	localException1	Exception
    //   119	2	3	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   127	2	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   20	45	103	java/io/UnsupportedEncodingException
    //   20	45	111	java/lang/Exception
    //   52	77	119	java/io/UnsupportedEncodingException
    //   52	77	127	java/lang/Exception
  }
  
  public static String calcUrlSign(List<NameValuePair> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(((NameValuePair)paramList.get(i)).getName());
      localArrayList.add(((NameValuePair)paramList.get(i)).getValue());
      i += 1;
    }
    return JNITools.CalcUrlSign(localArrayList);
  }
  
  public static String filterXmlTags(String paramString, List<String> paramList)
  {
    String str1 = paramString;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        str1 = paramString;
        if (!paramList.hasNext()) {
          break;
        }
        String str2 = (String)paramList.next();
        str1 = "<" + str2 + ">";
        str2 = "</" + str2 + ">";
        paramString = paramString.replaceAll(str1, "").replaceAll(str2, "");
      }
    }
    return str1;
  }
  
  public static String getContent(HttpResponse paramHttpResponse)
    throws IOException
  {
    if (paramHttpResponse == null) {
      return null;
    }
    int k = 0;
    Object localObject = paramHttpResponse.getHeaders("Content-Encoding");
    if ((localObject != null) && (localObject.length > 0))
    {
      int m = localObject.length;
      int i = 0;
      StringBuffer localStringBuffer;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          if (localObject[i].getValue().toLowerCase().indexOf("gzip") > -1) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break label165;
          }
          paramHttpResponse = paramHttpResponse.getEntity().getContent();
          localObject = new GZIPInputStream(paramHttpResponse);
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader((InputStream)localObject));
          localStringBuffer = new StringBuffer();
          for (;;)
          {
            String str = localBufferedReader.readLine();
            if (str == null) {
              break;
            }
            localStringBuffer.append(str);
          }
        }
        i += 1;
      }
      ((GZIPInputStream)localObject).close();
      paramHttpResponse.close();
      return localStringBuffer.toString();
    }
    label165:
    return EntityUtils.toString(paramHttpResponse.getEntity(), "uft-8");
  }
  
  public static boolean isHttp(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("http://");
  }
  
  public static boolean isHttps(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("https://");
  }
  
  public static int safePositiveInteger(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      int j = i;
      if (i < 0) {
        j = 0;
      }
      return j;
    }
    catch (NumberFormatException paramString)
    {
      LogUtil.e("", paramString.toString());
    }
    return 0;
  }
  
  public static long safePositiveLong(String paramString)
  {
    try
    {
      long l1 = Long.parseLong(paramString);
      long l2 = l1;
      if (l1 < 0L) {
        l2 = 0L;
      }
      return l2;
    }
    catch (NumberFormatException paramString)
    {
      LogUtil.e("", paramString.toString());
    }
    return 0L;
  }
  
  public static Date strToDate(String paramString)
    throws ParseException
  {
    return new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */