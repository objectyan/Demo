package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.FaceCheckResult;

public abstract class FaceCheckCallback
  implements LoginStatusAware<FaceCheckResult>
{
  public abstract void onAccountTypeConflict(FaceCheckResult paramFaceCheckResult);
  
  public abstract void onNeedVerify(FaceCheckResult paramFaceCheckResult);
  
  public abstract void onNoRegistered(FaceCheckResult paramFaceCheckResult);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/FaceCheckCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */