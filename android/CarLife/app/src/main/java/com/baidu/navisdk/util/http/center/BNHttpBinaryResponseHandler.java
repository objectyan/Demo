package com.baidu.navisdk.util.http.center;

public abstract class BNHttpBinaryResponseHandler
  implements IBNHttpResponseHandler
{
  public abstract void onFailure(int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public abstract void onSuccess(int paramInt, byte[] paramArrayOfByte);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/center/BNHttpBinaryResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */