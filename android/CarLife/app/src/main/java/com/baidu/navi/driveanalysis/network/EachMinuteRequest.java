package com.baidu.navi.driveanalysis.network;

import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.k.a.b;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.util.k;
import com.baidu.navi.driveanalysis.model.TrackModel;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.json.JSONException;

public class EachMinuteRequest
  extends com.baidu.carlife.k.a.e
{
  private final String SIGN_KEY = "bd44977f4225b957923ddefa781e8f93";
  private final String SIGN_KEY_ID = "sign";
  private final String SIGN_PREFIX = "navi";
  private String URL = null;
  private final String URL_AND = "&";
  private final String URL_DEBUG = "http://cq01-rdqa-dev018.cq01.baidu.com:8080/carlife/orbitpostminute";
  private final String URL_EQUAL = "=";
  private final String URL_RELEASE = "https://vehicle.baidu.com/carlife/orbitpostminute";
  private List<TrackModel> mList;
  
  public EachMinuteRequest()
  {
    com.baidu.carlife.core.e.a();
    if (com.baidu.carlife.core.e.t())
    {
      this.URL = "http://cq01-rdqa-dev018.cq01.baidu.com:8080/carlife/orbitpostminute";
      return;
    }
    this.URL = "https://vehicle.baidu.com/carlife/orbitpostminute";
  }
  
  private String calcUrlSign(List<NameValuePair> paramList)
  {
    Object localObject2 = new TreeMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (NameValuePair)paramList.next();
      ((TreeMap)localObject2).put(((NameValuePair)localObject1).getName(), ((NameValuePair)localObject1).getValue());
    }
    Object localObject1 = new StringBuffer("navi");
    label170:
    for (;;)
    {
      try
      {
        localObject2 = ((TreeMap)localObject2).entrySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          paramList = (Map.Entry)((Iterator)localObject2).next();
          StringBuffer localStringBuffer = ((StringBuffer)localObject1).append((String)paramList.getKey()).append("=");
          if (paramList.getValue() != null) {
            break label170;
          }
          paramList = "";
          localStringBuffer.append(URLEncoder.encode(paramList, "UTF-8")).append("&");
        }
        paramList = (String)paramList.getValue();
      }
      catch (UnsupportedEncodingException paramList)
      {
        ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1).append("bd44977f4225b957923ddefa781e8f93");
        return k.a(((StringBuffer)localObject1).toString());
      }
    }
  }
  
  private String urlEncode(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  protected d getPostRequestParams()
  {
    d local1 = new d()
    {
      public HttpEntity getEntity()
      {
        b localb = new b();
        if (!this.urlParams.isEmpty())
        {
          Iterator localIterator = this.urlParams.iterator();
          while (localIterator.hasNext())
          {
            NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
            if ((TextUtils.isEmpty(localNameValuePair.getName())) || (TextUtils.isEmpty(localNameValuePair.getValue()))) {
              localIterator.remove();
            } else {
              localb.a(localNameValuePair.getName(), EachMinuteRequest.this.urlEncode(localNameValuePair.getValue()));
            }
          }
          i.b(EachMinuteRequest.this.tag, "the post params is:" + this.urlParams.toString());
          localb.a("sign", EachMinuteRequest.this.calcUrlSign(this.urlParams));
        }
        return localb;
      }
    };
    int j = 0;
    int i = 0;
    Iterator localIterator = this.mList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (TrackModel)localIterator.next();
      int k = j;
      if (j == 0)
      {
        local1.put("entity_name", ((TrackModel)localObject).entityName);
        k = 1;
      }
      localObject = "" + ((TrackModel)localObject).latitude + "," + ((TrackModel)localObject).longitude + "," + ((TrackModel)localObject).coordType + "," + ((TrackModel)localObject).speed + "," + ((TrackModel)localObject).direction + "," + ((TrackModel)localObject).height + "," + ((TrackModel)localObject).radius + "," + ((TrackModel)localObject).localTime + "," + ((TrackModel)localObject).isConnectWithVehicle;
      i += 1;
      local1.put("coord" + i, (String)localObject);
      j = k;
    }
    local1.toSign();
    return local1;
  }
  
  protected String getUrl()
  {
    return this.URL;
  }
  
  protected void responseErrorCallBack(int paramInt) {}
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    return 0;
  }
  
  public void setParamsModel(List<TrackModel> paramList)
  {
    this.mList = paramList;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/network/EachMinuteRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */