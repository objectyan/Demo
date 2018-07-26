package com.baidu.sapi2.result;

import java.util.ArrayList;
import java.util.List;

public class QuickUserRegResult extends SapiResult {
    public static final int ERROR_CODE_EMPTY_PASSWORD = -102;
    public static final int ERROR_CODE_EMPTY_USERNAME = -101;
    public static final String ERROR_MSG_EMPTY_PASSWORD = "请输入密码";
    public static final String ERROR_MSG_EMPTY_USERNAME = "请输入用户名";
    public static final int RESULT_CODE_USERNAME_EXIST = 5;
    public static final String RESULT_MSG_SUCCESS = "注册成功";
    public List<String> sugUsernameList = new ArrayList();

    public QuickUserRegResult() {
        this.msgMap.put(0, "注册成功");
        this.msgMap.put(-101, ERROR_MSG_EMPTY_USERNAME);
        this.msgMap.put(-102, "请输入密码");
    }
}
