package com.baidu.navisdk.util.http;

import android.graphics.BitmapFactory;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.center.BNHttpBinaryResponseHandler;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;

public class BaseHttpClient
{
  public void get(String paramString, final BitmapRspHandler paramBitmapRspHandler)
  {
    BNHttpParams localBNHttpParams = new BNHttpParams();
    localBNHttpParams.isAsync = false;
    BNHttpCenter.getInstance().get(paramString, null, new BNHttpBinaryResponseHandler()
    {
      public void onFailure(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        LogUtil.e("BaseHttpClient", "onFailure().statusCode=" + paramAnonymousInt);
        if (paramBitmapRspHandler != null) {
          paramBitmapRspHandler.onFailure(paramAnonymousThrowable);
        }
      }
      
      public void onSuccess(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        LogUtil.e("BaseHttpClient", "onSuccess().statusCode=" + paramAnonymousInt);
        if ((paramBitmapRspHandler != null) && (paramAnonymousArrayOfByte != null))
        {
          paramAnonymousArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
          paramBitmapRspHandler.handleSuccessMessage(paramAnonymousArrayOfByte);
        }
      }
    }, localBNHttpParams);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/BaseHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */