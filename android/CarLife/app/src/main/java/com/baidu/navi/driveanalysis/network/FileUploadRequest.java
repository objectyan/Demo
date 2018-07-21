package com.baidu.navi.driveanalysis.network;

import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.k.a.b;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.d.a;
import com.baidu.carlife.util.k;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.json.JSONException;

public class FileUploadRequest
  extends com.baidu.carlife.k.a.e
{
  private final String SIGN_KEY = "bd44977f4225b957923ddefa781e8f93";
  private final String SIGN_KEY_ID = "sign";
  private final String SIGN_PREFIX = "navi";
  private String URL = null;
  private final String URL_AND = "&";
  private final String URL_DEBUG = "http://cq01-rdqa-dev018.cq01.baidu.com:8080/carlife/orbitpost";
  private final String URL_EQUAL = "=";
  private final String URL_RELEASE = "https://vehicle.baidu.com/carlife/orbitpost";
  private String mCuid;
  private String mFileName;
  private InputStream mInputStream;
  
  public FileUploadRequest(String paramString1, String paramString2, InputStream paramInputStream)
  {
    this.mCuid = paramString1;
    this.mFileName = paramString2;
    this.mInputStream = paramInputStream;
    com.baidu.carlife.core.e.a();
    if (com.baidu.carlife.core.e.t())
    {
      this.URL = "http://cq01-rdqa-dev018.cq01.baidu.com:8080/carlife/orbitpost";
      return;
    }
    this.URL = "https://vehicle.baidu.com/carlife/orbitpost";
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
    label187:
    for (;;)
    {
      try
      {
        localObject2 = ((TreeMap)localObject2).entrySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          paramList = (Map.Entry)((Iterator)localObject2).next();
          if (((String)paramList.getKey()).equals("point_list")) {
            continue;
          }
          StringBuffer localStringBuffer = ((StringBuffer)localObject1).append((String)paramList.getKey()).append("=");
          if (paramList.getValue() != null) {
            break label187;
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
        Iterator localIterator;
        Object localObject;
        if (!this.urlParams.isEmpty())
        {
          localIterator = this.urlParams.iterator();
          while (localIterator.hasNext())
          {
            localObject = (NameValuePair)localIterator.next();
            if ((TextUtils.isEmpty(((NameValuePair)localObject).getName())) || (TextUtils.isEmpty(((NameValuePair)localObject).getValue()))) {
              localIterator.remove();
            } else {
              localb.a(((NameValuePair)localObject).getName(), FileUploadRequest.this.urlEncode(((NameValuePair)localObject).getValue()));
            }
          }
          i.b(FileUploadRequest.this.tag, "the post params is:" + this.urlParams.toString());
          localb.a("sign", FileUploadRequest.this.calcUrlSign(this.urlParams));
        }
        if (!this.fileParams.isEmpty())
        {
          int i = 0;
          int j = this.fileParams.entrySet().size();
          localIterator = this.fileParams.entrySet().iterator();
          if (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            d.a locala = (d.a)((Map.Entry)localObject).getValue();
            boolean bool;
            if (locala.a != null)
            {
              if (i != j - 1) {
                break label341;
              }
              bool = true;
              label262:
              if (locala.c == null) {
                break label346;
              }
              localb.a((String)((Map.Entry)localObject).getKey(), locala.a(), locala.a, locala.c, bool);
            }
            for (;;)
            {
              i.b(FileUploadRequest.this.tag, "the post file is:" + locala.a());
              i += 1;
              break;
              label341:
              bool = false;
              break label262;
              label346:
              localb.a((String)((Map.Entry)localObject).getKey(), locala.a(), locala.a, bool);
            }
          }
        }
        return localb;
      }
    };
    local1.put("entity_name", this.mCuid);
    local1.put("point_list", this.mInputStream, this.mFileName);
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/network/FileUploadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */