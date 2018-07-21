package com.baidu.navi.favorite.http;

import com.baidu.carlife.util.k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;

public class RequestParamsSignUtil
{
  private static final String URL_AND = "&";
  private static final String URL_EQUAL = "=";
  
  public static String calcUrlSign(List<NameValuePair> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    label160:
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        NameValuePair localNameValuePair;
        if (localIterator.hasNext())
        {
          localNameValuePair = (NameValuePair)localIterator.next();
          if (localNameValuePair.getValue() != null) {
            break label160;
          }
          paramList = "";
          Object localObject = URLEncoder.encode(paramList, "UTF-8");
          paramList = (List<NameValuePair>)localObject;
          if (((String)localObject).contains("+")) {
            paramList = ((String)localObject).replaceAll("\\+", "%20");
          }
          localObject = paramList;
          if (localNameValuePair.getValue().contains("~")) {
            localObject = paramList.replaceAll("%7E", "~");
          }
          localStringBuffer.append(localNameValuePair.getName()).append("=").append((String)localObject).append("&");
        }
        paramList = localNameValuePair.getValue();
      }
      catch (UnsupportedEncodingException paramList)
      {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1).append("862e9198279d4c1b980b8eb394f82ae7");
        return k.a(localStringBuffer.toString()).toLowerCase();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/http/RequestParamsSignUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */