package com.baidu.navisdk.util.http.center;

import java.io.File;

public abstract class BNHttpFileResponseHandler
  implements IBNHttpResponseHandler
{
  public abstract void onFailure(int paramInt, Throwable paramThrowable, File paramFile);
  
  public abstract void onSuccess(int paramInt, File paramFile);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/center/BNHttpFileResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */