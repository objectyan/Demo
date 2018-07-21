package com.baidu.baidunavis.control;

import android.support.annotation.Keep;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import java.io.File;
import java.util.HashMap;
import org.apache.http.client.CookieStore;

@Keep
public abstract interface NavHttpCenterImpl
{
  public abstract void get(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap, CookieStore paramCookieStore, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface);
  
  public abstract void uploadFile(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap, HashMap<String, File> paramHashMap1, CookieStore paramCookieStore, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavHttpCenterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */