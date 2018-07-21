package com.baidu.navisdk.logic;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.util.statistic.NetFlowStat.HttpNetFlowInfo;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HttpGetBase
  extends CommandBase
{
  private static final String TAG = "HttpGetBase";
  protected List<NameValuePair> mHttpParams = new ArrayList();
  protected JSONObject mJson;
  
  protected CommandResult exec()
  {
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      this.mRet.set(NaviErrCode.getSDKError(1));
      return this.mRet;
    }
    Object localObject = getUrl();
    LogUtil.e("HttpGetBase", "exec() url=" + (String)localObject);
    final NetFlowStat.HttpNetFlowInfo localHttpNetFlowInfo = new NetFlowStat.HttpNetFlowInfo();
    try
    {
      localHttpNetFlowInfo.setSendDataInfo(System.currentTimeMillis(), ((String)localObject).getBytes("utf-8").length * 8, getUrl());
      localObject = new BNHttpParams();
      ((BNHttpParams)localObject).isAsync = false;
      BNHttpCenter.getInstance().get(getUrl(), BNHttpCenterHelper.formatParams(getRequestParams()), new BNHttpTextResponseHandler()
      {
        public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          LogUtil.e("HttpGetBase", "exec.err statusCode=" + paramAnonymousInt + ", s=" + paramAnonymousString);
          HttpGetBase.this.mRet.set(NaviErrCode.getAppError(5));
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          LogUtil.e("HttpGetBase", "exec.ok statusCode=" + paramAnonymousInt + ", s=" + paramAnonymousString);
          if (TextUtils.isEmpty(paramAnonymousString))
          {
            HttpGetBase.this.mRet.set(NaviErrCode.getAppError(4));
            return;
          }
          if (localHttpNetFlowInfo != null) {}
          try
          {
            localHttpNetFlowInfo.setReceiveDataInfo(paramAnonymousString.getBytes("utf-8").length * 8);
            try
            {
              paramAnonymousString = new JSONObject(paramAnonymousString);
              HttpGetBase.this.mJson = paramAnonymousString;
              HttpGetBase.this.mRet.setSuccess();
              return;
            }
            catch (JSONException paramAnonymousString)
            {
              HttpGetBase.this.mRet.set(NaviErrCode.getAppError(3));
              return;
            }
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
        }
      }, (BNHttpParams)localObject);
      if (!this.mRet.isSuccess()) {
        return this.mRet;
      }
      if (localHttpNetFlowInfo != null) {
        localHttpNetFlowInfo.submit();
      }
      parseJson();
      if (this.mRet.isSuccess()) {
        handleSuccess();
      }
      for (;;)
      {
        return this.mRet;
        handleError();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  protected String formatNameValuePair(List<NameValuePair> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 154	java/lang/StringBuffer
    //   9: dup
    //   10: invokespecial 155	java/lang/StringBuffer:<init>	()V
    //   13: astore_3
    //   14: iconst_0
    //   15: istore_2
    //   16: iload_2
    //   17: aload_1
    //   18: invokeinterface 161 1 0
    //   23: if_icmpge +126 -> 149
    //   26: aload_3
    //   27: aload_1
    //   28: iload_2
    //   29: invokeinterface 164 2 0
    //   34: checkcast 166	org/apache/http/NameValuePair
    //   37: invokeinterface 169 1 0
    //   42: ldc 90
    //   44: invokestatic 175	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   50: pop
    //   51: aload_3
    //   52: ldc -76
    //   54: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   57: pop
    //   58: aload_3
    //   59: aload_1
    //   60: iload_2
    //   61: invokeinterface 164 2 0
    //   66: checkcast 166	org/apache/http/NameValuePair
    //   69: invokeinterface 183 1 0
    //   74: ldc 90
    //   76: invokestatic 175	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   82: pop
    //   83: iload_2
    //   84: aload_1
    //   85: invokeinterface 161 1 0
    //   90: iconst_1
    //   91: isub
    //   92: if_icmpge +10 -> 102
    //   95: aload_3
    //   96: ldc -71
    //   98: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   101: pop
    //   102: iload_2
    //   103: iconst_1
    //   104: iadd
    //   105: istore_2
    //   106: goto -90 -> 16
    //   109: astore 4
    //   111: aload 4
    //   113: invokevirtual 188	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   116: goto -65 -> 51
    //   119: astore 4
    //   121: aload 4
    //   123: invokevirtual 189	java/lang/Exception:printStackTrace	()V
    //   126: goto -75 -> 51
    //   129: astore 4
    //   131: aload 4
    //   133: invokevirtual 188	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   136: goto -53 -> 83
    //   139: astore 4
    //   141: aload 4
    //   143: invokevirtual 189	java/lang/Exception:printStackTrace	()V
    //   146: goto -63 -> 83
    //   149: aload_3
    //   150: invokevirtual 190	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   153: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	HttpGetBase
    //   0	154	1	paramList	List<NameValuePair>
    //   15	91	2	i	int
    //   13	137	3	localStringBuffer	StringBuffer
    //   109	3	4	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   119	3	4	localException1	Exception
    //   129	3	4	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   139	3	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   26	51	109	java/io/UnsupportedEncodingException
    //   26	51	119	java/lang/Exception
    //   58	83	129	java/io/UnsupportedEncodingException
    //   58	83	139	java/lang/Exception
  }
  
  protected abstract String generateParams();
  
  protected abstract List<NameValuePair> getRequestParams();
  
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/HttpGetBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */