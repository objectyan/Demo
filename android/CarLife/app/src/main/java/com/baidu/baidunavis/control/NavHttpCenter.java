package com.baidu.baidunavis.control;

import android.content.Context;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.network.asynchttp.NirvanaBinaryHttpResponseHandler;
import com.baidu.mapframework.nirvana.network.asynchttp.NirvanaFileAsyncHttpResponseHandler;
import com.baidu.mapframework.nirvana.network.asynchttp.NirvanaTextHttpResponseHandler;
import com.baidu.mapframework.nirvana.runtime.http.HttpProxy;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.center.BNHttpBinaryResponseHandler;
import com.baidu.navisdk.util.http.center.BNHttpFileResponseHandler;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.util.http.center.IBNHttpResponseHandler;
import com.baidu.platform.comapi.c.a;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

public class NavHttpCenter
  implements IBNHttpCenter
{
  private static final String TAG = NavHttpCenter.class.getSimpleName();
  private ScheduleConfig config = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
  private CookieStore cookieStore = null;
  private Module module = Module.NAV_MODULE;
  
  private CookieStore getCookieStore(String paramString)
  {
    if (NavMapAdapter.getInstance().getBduss() == null) {
      localObject = null;
    }
    BasicCookieStore localBasicCookieStore;
    do
    {
      do
      {
        do
        {
          do
          {
            return (CookieStore)localObject;
            localObject = new BasicClientCookie("BDUSS", NavMapAdapter.getInstance().getBduss());
            localBasicCookieStore = new BasicCookieStore();
            ((BasicClientCookie)localObject).setDomain(".baidu.com");
            ((BasicClientCookie)localObject).setPath("/");
            ((BasicClientCookie)localObject).setVersion(0);
            localBasicCookieStore.addCookie((Cookie)localObject);
            localObject = localBasicCookieStore;
          } while (paramString == null);
          localObject = localBasicCookieStore;
        } while (paramString.length() <= 0);
        paramString = URI.create(paramString);
        paramString = a.a().getIP(paramString.getHost());
        localObject = localBasicCookieStore;
      } while (paramString == null);
      localObject = localBasicCookieStore;
    } while (paramString.length() <= 0);
    Object localObject = new BasicClientCookie("BDUSS", NavMapAdapter.getInstance().getBduss());
    ((BasicClientCookie)localObject).setDomain(paramString);
    ((BasicClientCookie)localObject).setPath("/");
    ((BasicClientCookie)localObject).setVersion(0);
    localBasicCookieStore.addCookie((Cookie)localObject);
    return localBasicCookieStore;
  }
  
  public void get(final String paramString, HashMap<String, String> paramHashMap, final IBNHttpResponseHandler paramIBNHttpResponseHandler, BNHttpParams paramBNHttpParams)
  {
    LogUtil.e(TAG, "get() url=" + paramString);
    Object localObject = paramBNHttpParams;
    paramBNHttpParams = (BNHttpParams)localObject;
    if (localObject == null) {
      paramBNHttpParams = new BNHttpParams();
    }
    if ((paramIBNHttpResponseHandler instanceof BNHttpTextResponseHandler))
    {
      localObject = (NavHttpCenterImpl)HttpProxy.getDefault().create(NavHttpCenterImpl.class);
      if (!paramBNHttpParams.isAsync)
      {
        bool = true;
        ((NavHttpCenterImpl)localObject).get(bool, paramString, paramHashMap, getCookieStore(paramString), new NirvanaTextHttpResponseHandler(this.module, this.config)
        {
          public void onFailure(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable)
          {
            if (LogUtil.LOGGABLE) {
              LogUtil.e(NavHttpCenter.TAG, "get.text.onFailure() url=" + paramString + ", statusCode=" + paramAnonymousInt + ", responseString=" + paramAnonymousString);
            }
            if (paramIBNHttpResponseHandler != null) {
              ((BNHttpTextResponseHandler)paramIBNHttpResponseHandler).onFailure(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
            }
          }
          
          public void onSuccess(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString)
          {
            if (LogUtil.LOGGABLE) {
              LogUtil.e(NavHttpCenter.TAG, "get.text.onSuccess() url=" + paramString + ", statusCode=" + paramAnonymousInt + ", responseString=" + paramAnonymousString);
            }
            if (paramIBNHttpResponseHandler != null) {
              ((BNHttpTextResponseHandler)paramIBNHttpResponseHandler).onSuccess(paramAnonymousInt, paramAnonymousString);
            }
          }
        });
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if ((paramIBNHttpResponseHandler instanceof BNHttpFileResponseHandler))
      {
        localObject = (NavHttpCenterImpl)HttpProxy.getDefault().create(NavHttpCenterImpl.class);
        if (!paramBNHttpParams.isAsync) {}
        for (bool = true;; bool = false)
        {
          ((NavHttpCenterImpl)localObject).get(bool, paramString, paramHashMap, getCookieStore(paramString), new NirvanaFileAsyncHttpResponseHandler(this.module, this.config, NavCommonFuncModel.getInstance().getActivity())
          {
            public void onFailure(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, Throwable paramAnonymousThrowable, File paramAnonymousFile)
            {
              if (LogUtil.LOGGABLE)
              {
                LogUtil.e(NavHttpCenter.TAG, "get.file.onFailure() url=" + paramString + ", statusCode=" + paramAnonymousInt + "， throwable=" + paramAnonymousThrowable.getMessage());
                paramAnonymousThrowable.printStackTrace();
              }
              if (paramIBNHttpResponseHandler != null) {
                ((BNHttpFileResponseHandler)paramIBNHttpResponseHandler).onFailure(paramAnonymousInt, paramAnonymousThrowable, paramAnonymousFile);
              }
            }
            
            public void onSuccess(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, File paramAnonymousFile)
            {
              if (LogUtil.LOGGABLE) {
                LogUtil.e(NavHttpCenter.TAG, "get.file.onSuccess() url=" + paramString + ", statusCode=" + paramAnonymousInt);
              }
              if (paramIBNHttpResponseHandler != null) {
                ((BNHttpFileResponseHandler)paramIBNHttpResponseHandler).onSuccess(paramAnonymousInt, paramAnonymousFile);
              }
            }
          });
          return;
        }
      }
    } while (!(paramIBNHttpResponseHandler instanceof BNHttpBinaryResponseHandler));
    localObject = (NavHttpCenterImpl)HttpProxy.getDefault().create(NavHttpCenterImpl.class);
    if (!paramBNHttpParams.isAsync) {}
    for (boolean bool = true;; bool = false)
    {
      ((NavHttpCenterImpl)localObject).get(bool, paramString, paramHashMap, getCookieStore(paramString), new NirvanaBinaryHttpResponseHandler(this.module, this.config, new String[] { "text/plain", "application/octet-stream", "image/jpeg", "image/png", "image/gif", "application/octet-stream".concat(";charset=utf-8"), "image/jpeg;charset=utf-8", "image/png;charset=utf-8", "image/gif;charset=utf-8" })
      {
        public void onFailure(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
        {
          if (LogUtil.LOGGABLE)
          {
            LogUtil.e(NavHttpCenter.TAG, "get.binary.onFailure() url=" + paramString + ", statusCode=" + paramAnonymousInt + "， error=" + paramAnonymousThrowable.getMessage());
            paramAnonymousThrowable.printStackTrace();
          }
          if (paramIBNHttpResponseHandler != null) {
            ((BNHttpBinaryResponseHandler)paramIBNHttpResponseHandler).onFailure(paramAnonymousInt, paramAnonymousArrayOfByte, paramAnonymousThrowable);
          }
        }
        
        public void onSuccess(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, byte[] paramAnonymousArrayOfByte)
        {
          if (LogUtil.LOGGABLE) {
            LogUtil.e(NavHttpCenter.TAG, "get.binary.onSuccess() url=" + paramString + ", statusCode=" + paramAnonymousInt);
          }
          if (paramIBNHttpResponseHandler != null) {
            ((BNHttpBinaryResponseHandler)paramIBNHttpResponseHandler).onSuccess(paramAnonymousInt, paramAnonymousArrayOfByte);
          }
        }
      });
      return;
    }
  }
  
  public void post(final String paramString, HashMap<String, String> paramHashMap, final IBNHttpResponseHandler paramIBNHttpResponseHandler, BNHttpParams paramBNHttpParams)
  {
    LogUtil.e("NavHttpCenter", "post() url=" + paramString);
    BNHttpParams localBNHttpParams = paramBNHttpParams;
    if (paramBNHttpParams == null) {
      localBNHttpParams = new BNHttpParams();
    }
    NavHttpCenterImpl localNavHttpCenterImpl = null;
    if (localBNHttpParams.postFileMap != null)
    {
      paramBNHttpParams = localBNHttpParams.postFileMap;
      if ((paramIBNHttpResponseHandler instanceof BNHttpTextResponseHandler))
      {
        localNavHttpCenterImpl = (NavHttpCenterImpl)HttpProxy.getDefault().create(NavHttpCenterImpl.class);
        if (localBNHttpParams.isAsync) {
          break label180;
        }
      }
    }
    label180:
    for (boolean bool = true;; bool = false)
    {
      localNavHttpCenterImpl.uploadFile(bool, paramString, paramHashMap, paramBNHttpParams, getCookieStore(paramString), new NirvanaTextHttpResponseHandler(this.module, this.config)
      {
        public void onFailure(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          if (LogUtil.LOGGABLE) {
            LogUtil.e(NavHttpCenter.TAG, "post.text.onFailure() url=" + paramString + ", statusCode=" + paramAnonymousInt + ", responseString=" + paramAnonymousString);
          }
          if (paramIBNHttpResponseHandler != null) {
            ((BNHttpTextResponseHandler)paramIBNHttpResponseHandler).onFailure(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
          }
        }
        
        public void onSuccess(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString)
        {
          if (LogUtil.LOGGABLE) {
            LogUtil.e(NavHttpCenter.TAG, "post.text.onSuccess() url=" + paramString + ", statusCode=" + paramAnonymousInt + ", responseString=" + paramAnonymousString);
          }
          if (paramIBNHttpResponseHandler != null) {
            ((BNHttpTextResponseHandler)paramIBNHttpResponseHandler).onSuccess(paramAnonymousInt, paramAnonymousString);
          }
        }
      });
      return;
      paramBNHttpParams = localNavHttpCenterImpl;
      if (localBNHttpParams.fileKey == null) {
        break;
      }
      paramBNHttpParams = localNavHttpCenterImpl;
      if (localBNHttpParams.file == null) {
        break;
      }
      paramBNHttpParams = new HashMap();
      paramBNHttpParams.put(localBNHttpParams.fileKey, localBNHttpParams.file);
      break;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavHttpCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */