package com.baidu.navisdk.logic;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.HttpRequestManager;
import java.net.URI;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HttpPostDataBase
  extends CommandBase
{
  private static final int K_TIMEOUT_CONNECTION = 3000;
  private static final int K_TIMEOUT_SOCKET = 5000;
  private static final String TAG = "HttpPostFileBase";
  protected JSONObject mJson;
  
  protected CommandResult exec()
  {
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      this.mRet.set(NaviErrCode.getSDKError(1));
      localObject1 = this.mRet;
      return (CommandResult)localObject1;
    }
    HttpsClient localHttpsClient = HttpsClient.getHttpClient();
    Object localObject1 = getUrl();
    Object localObject5 = getMultipartEntity();
    for (;;)
    {
      try
      {
        localObject1 = HttpRequestManager.getInstance().getHttpPost((String)localObject1);
        ((HttpPost)localObject1).setEntity((HttpEntity)localObject5);
        localObject5 = this.mReqData.mCookieStore;
        if ((localObject5 != null) && (((CookieStore)localObject5).getCookies() != null))
        {
          BasicHttpContext localBasicHttpContext = new BasicHttpContext();
          if ((((CookieStore)localObject5).getCookies().get(0) != null) && ((((CookieStore)localObject5).getCookies().get(0) instanceof BasicClientCookie))) {
            ((BasicClientCookie)((CookieStore)localObject5).getCookies().get(0)).setDomain(((HttpPost)localObject1).getURI().getHost());
          }
          localBasicHttpContext.setAttribute("http.cookie-store", localObject5);
          localObject1 = localHttpsClient.execute((HttpUriRequest)localObject1, localBasicHttpContext);
          if (((HttpResponse)localObject1).getStatusLine().getStatusCode() != 200)
          {
            this.mRet.set(NaviErrCode.getAppError(5));
            localObject5 = this.mRet;
            localObject1 = localObject5;
            return (CommandResult)localObject5;
          }
        }
        else
        {
          localObject1 = localHttpsClient.execute((HttpUriRequest)localObject1);
          continue;
        }
        localObject1 = ((HttpResponse)localObject1).getEntity();
        if (localObject1 != null)
        {
          localObject1 = EntityUtils.toString((HttpEntity)localObject1);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            this.mRet.set(NaviErrCode.getAppError(4));
          }
        }
        else
        {
          if (localHttpsClient != null) {
            localHttpsClient.getConnectionManager().shutdown();
          }
          parseJson();
          if (!this.mRet.isSuccess()) {
            break label405;
          }
          handleSuccess();
          return this.mRet;
        }
        try
        {
          this.mJson = new JSONObject((String)localObject1);
          this.mRet.setSuccess();
        }
        catch (JSONException localJSONException)
        {
          this.mRet.set(NaviErrCode.getAppError(3));
          localObject5 = this.mRet;
          Object localObject2 = localObject5;
        }
        return (CommandResult)localObject5;
      }
      catch (Exception localException)
      {
        LogUtil.e("HttpPostFileBase", "HttpPostDataBase exec exception");
        this.mRet.set(NaviErrCode.getAppError(0));
        localObject5 = this.mRet;
        Object localObject3 = localObject5;
        return (CommandResult)localObject5;
      }
      finally
      {
        if (localHttpsClient != null) {
          localHttpsClient.getConnectionManager().shutdown();
        }
      }
      label405:
      handleError();
    }
  }
  
  protected abstract MultipartEntity getMultipartEntity();
  
  protected abstract String getUrl();
  
  protected void handleSuccess()
  {
    if ((!this.mReqData.mHasMsgSent) && (this.mReqData.mRetryTimes == 1))
    {
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = 0;
      localMessage.obj = new RspData(this.mReqData, this.mJson);
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected void parseJson() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/HttpPostDataBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */