package com.baidu.sapi2.result;

public class QrPcLoginResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "登录失败";
    public static final int RESULT_CODE_BDUSS_EMPTY = 160102;
    public static final int RESULT_CODE_BDUSS_EXPIRED = 2;
    public static final int RESULT_CODE_INCOMPLETE_USER = 3;
    public static final int RESULT_CODE_QRCODE_EXPIRED = 1;
    public static final String RESULT_MSG_BDUSS_EMPTY = "用户登录状态失效，请重新登录";
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public static final String RESULT_MSG_INCOMPLETE_USER = "用户尚未正常化，无法使用此功能";
    public static final String RESULT_MSG_QRCODE_EXPIRED = "抱歉，您的登录二维码已过期失效，请刷新网页重新获取";
    public static final String RESULT_MSG_SUCCESS = "登录成功";
    public String city;
    public String country;
    public String province;

    public QrPcLoginResult() {
        this.msgMap.put(0, "登录成功");
        this.msgMap.put(110000, "登录成功");
        this.msgMap.put(1, "抱歉，您的登录二维码已过期失效，请刷新网页重新获取");
        this.msgMap.put(2, "用户登录状态失效，请重新登录");
        this.msgMap.put(3, "用户尚未正常化，无法使用此功能");
        this.msgMap.put(160102, "用户登录状态失效，请重新登录");
        this.msgMap.put(SapiResult.ERROR_CODE_UNKNOWN, "登录失败");
    }
}
