package com.baidu.baidunavis.control.generate;

import android.net.Uri;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.baidu.baidunavis.control.NavHttpCenterImpl;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType;
import com.baidu.mapframework.nirvana.runtime.http.BMRetrofit;
import com.baidu.mapframework.nirvana.runtime.http.HttpRequestManager;
import com.baidu.mapframework.nirvana.runtime.http.URLEncodeUtils;
import java.io.File;
import java.util.HashMap;
import org.apache.http.client.CookieStore;

@Keep
public final class NavHttpCenterImplImpl
  implements NavHttpCenterImpl
{
  private BMRetrofit mRetrofit = new BMRetrofit();
  
  public static NavHttpCenterImpl getInstance()
  {
    return HOLDER.INSTANCE;
  }
  
  public void get(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap, CookieStore paramCookieStore, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    HashMap localHashMap = new HashMap();
    if (paramHashMap != null) {
      localHashMap.putAll(paramHashMap);
    }
    this.mRetrofit.build().setCookieStore(paramCookieStore);
    paramHashMap = paramString;
    if (localHashMap != null)
    {
      paramHashMap = new StringBuilder(paramString);
      if (paramString.contains("?")) {
        break label99;
      }
      paramHashMap.append("?");
    }
    for (;;)
    {
      paramHashMap.append(URLEncodeUtils.getUrlQueryString(localHashMap, UrlEncode.UrlEncodeType.JAVA));
      paramHashMap = paramHashMap.toString();
      this.mRetrofit.build().getRequest(paramBoolean, paramHashMap, null, localHashMap, paramNirvanaResponseHandlerInterface);
      return;
      label99:
      if (!TextUtils.isEmpty(Uri.parse(paramString).getQuery())) {
        paramHashMap.append("&");
      }
    }
  }
  
  public void uploadFile(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap, HashMap<String, File> paramHashMap1, CookieStore paramCookieStore, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    HashMap localHashMap = new HashMap();
    if (paramHashMap != null) {
      localHashMap.putAll(paramHashMap);
    }
    paramHashMap = new HashMap();
    if (paramHashMap1 != null) {
      paramHashMap.putAll(paramHashMap1);
    }
    this.mRetrofit.build().setCookieStore(paramCookieStore);
    this.mRetrofit.build().postRequest(paramBoolean, paramString, null, localHashMap, paramHashMap, null, paramNirvanaResponseHandlerInterface);
  }
  
  private static final class HOLDER
  {
    static final NavHttpCenterImpl INSTANCE = new NavHttpCenterImplImpl(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/generate/NavHttpCenterImplImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */