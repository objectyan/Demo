package com.baidu.mapframework.nirvana.runtime.http;

import android.support.annotation.Keep;
import com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType;
import com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

@Keep
public class URLEncodeUtils
{
  static final String NativeURLEncodeUtilsClass = "com.baidu.platform.comapi.util.URLEncodeUtils";
  
  public static String getUrlQueryString(HashMap<String, String> paramHashMap, UrlEncode.UrlEncodeType paramUrlEncodeType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append((String)localEntry.getKey()).append("=").append(urlEncode(paramUrlEncodeType, (String)localEntry.getValue()));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String signString(HashMap<String, String> paramHashMap, SignToken.SignTokenType paramSignTokenType)
  {
    Object localObject;
    if (paramSignTokenType.equals(SignToken.SignTokenType.MAP_PHPUI))
    {
      paramSignTokenType = new StringBuilder();
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext())
        {
          localObject = (Map.Entry)paramHashMap.next();
          if (paramSignTokenType.length() > 0) {
            paramSignTokenType.append("&");
          }
          paramSignTokenType.append((String)((Map.Entry)localObject).getKey()).append("=").append(urlEncode(UrlEncode.UrlEncodeType.ENGINE, (String)((Map.Entry)localObject).getValue()));
        }
      }
      paramHashMap = Integer.TYPE;
      paramSignTokenType = paramSignTokenType.toString();
      paramHashMap = Utils.reflectionInvokeStaticMethod("com.baidu.platform.comapi.util.URLEncodeUtils", "generateSign", new Class[] { paramHashMap, String.class }, new Object[] { Integer.valueOf(1), paramSignTokenType });
      if (paramHashMap != null) {
        return (String)paramHashMap;
      }
    }
    else if ((paramSignTokenType.equals(SignToken.SignTokenType.POI_LIKE)) || (paramSignTokenType.equals(SignToken.SignTokenType.FILE_UPLOAD)))
    {
      localObject = paramHashMap.keySet().iterator();
      ArrayList localArrayList = new ArrayList();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((Iterator)localObject).next());
      }
      Collections.sort(localArrayList);
      localObject = new StringBuffer();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        ((StringBuffer)localObject).append(str);
        ((StringBuffer)localObject).append("=");
        ((StringBuffer)localObject).append(urlEncode(UrlEncode.UrlEncodeType.JAVA, (String)paramHashMap.get(str)));
        if (i + 1 < localArrayList.size()) {
          ((StringBuffer)localObject).append("&");
        }
        i += 1;
      }
      if (paramSignTokenType.equals(SignToken.SignTokenType.POI_LIKE)) {}
      for (paramHashMap = "99754106633f94d350db34d548d6091a";; paramHashMap = "43df48117350b904a6b1d4183e5611c7")
      {
        paramHashMap = ((StringBuffer)localObject).toString() + paramHashMap;
        paramHashMap = Utils.reflectionInvokeStaticMethod("com.baidu.platform.comapi.util.URLEncodeUtils", "getMD5String", new Class[] { String.class }, new Object[] { paramHashMap });
        if (paramHashMap == null) {
          break;
        }
        return (String)paramHashMap;
      }
    }
    return "";
  }
  
  public static String urlEncode(UrlEncode.UrlEncodeType paramUrlEncodeType, String paramString)
  {
    if ((paramUrlEncodeType == null) || (paramUrlEncodeType.equals(UrlEncode.UrlEncodeType.NONE))) {}
    do
    {
      do
      {
        return paramString;
        if (paramUrlEncodeType.equals(UrlEncode.UrlEncodeType.JAVA)) {}
        try
        {
          paramUrlEncodeType = URLEncoder.encode(paramString, "UTF-8");
          return paramUrlEncodeType;
        }
        catch (UnsupportedEncodingException paramUrlEncodeType) {}
      } while (!paramUrlEncodeType.equals(UrlEncode.UrlEncodeType.ENGINE));
      paramUrlEncodeType = Utils.reflectionInvokeStaticMethod("com.baidu.platform.comapi.util.URLEncodeUtils", "urlEncode", new Class[] { String.class }, new Object[] { paramString });
    } while (paramUrlEncodeType == null);
    return (String)paramUrlEncodeType;
    return paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/runtime/http/URLEncodeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */