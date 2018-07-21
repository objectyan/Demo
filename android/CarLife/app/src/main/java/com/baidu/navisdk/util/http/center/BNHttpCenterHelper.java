package com.baidu.navisdk.util.http.center;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;

public class BNHttpCenterHelper
{
  public static HashMap<String, String> formatParams(List<NameValuePair> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)paramList.next();
        localHashMap.put(localNameValuePair.getName(), localNameValuePair.getValue());
      }
    }
    return localHashMap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/center/BNHttpCenterHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */