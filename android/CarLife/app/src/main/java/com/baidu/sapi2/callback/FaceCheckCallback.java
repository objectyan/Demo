package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.FaceCheckResult;

public abstract class FaceCheckCallback implements LoginStatusAware<FaceCheckResult> {
    public abstract void onAccountTypeConflict(FaceCheckResult faceCheckResult);

    public abstract void onNeedVerify(FaceCheckResult faceCheckResult);

    public abstract void onNoRegistered(FaceCheckResult faceCheckResult);
}
