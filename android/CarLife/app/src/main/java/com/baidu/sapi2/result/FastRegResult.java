package com.baidu.sapi2.result;

public class FastRegResult extends SapiResult {
    public static final int ERROR_CODE_REG_TIMEOUT = -103;
    public static final int ERROR_CODE_SEND_SMS_FAILED = -102;
    public static final int ERROR_CODE_SIM_UNAVAILABLE = -101;
    public static final String ERROR_MSG_REG_TIMEOUT = "注册失败";
    public static final String ERROR_MSG_SEND_SMS_FAILED = "验证短信发送失败";
    public static final String ERROR_MSG_SIM_UNAVAILABLE = "SIM卡不可用";
    public static final int RESULT_CODE_SMS_UNDELIVERED = 7;
    public static final String RESULT_MSG_SUCCESS = "注册成功";
    public String authSid;
    public boolean newReg;

    public FastRegResult() {
        this.msgMap.put(0, "注册成功");
        this.msgMap.put(-101, ERROR_MSG_SIM_UNAVAILABLE);
        this.msgMap.put(-102, ERROR_MSG_SEND_SMS_FAILED);
        this.msgMap.put(-103, ERROR_MSG_REG_TIMEOUT);
    }

    public String toString() {
        return "FastRegResult{authSid='" + this.authSid + '\'' + ", newReg=" + this.newReg + '}';
    }
}
