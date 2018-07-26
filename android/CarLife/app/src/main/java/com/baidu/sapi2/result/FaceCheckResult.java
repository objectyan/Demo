package com.baidu.sapi2.result;

public class FaceCheckResult extends SapiResult {
    public static final int RESULT_CODE_ACCOUNT_TYPE_CONFLICT = 3;
    public static final int RESULT_CODE_BDUSS_EXPIRED = 1;
    public static final String RESULT_MSG_ACCOUNT_TYPE_CONFLICT = "请选择帐号类型";
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public String authId;
    public String authToken;
    public String faceId;
    public boolean hasFace;
    public boolean isTrusted;
    public String uid;

    public FaceCheckResult() {
        this.msgMap.put(1, "用户登录状态失效，请重新登录");
        this.msgMap.put(3, RESULT_MSG_ACCOUNT_TYPE_CONFLICT);
    }
}
