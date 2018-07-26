package com.baidu.sapi2.result;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class SapiResult {
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE = "网络连接不可用，请检查网络设置";
    public static final String ERROR_MSG_UNKNOWN = "网络连接失败，请检查网络设置";
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_WAPPASS_SUCCESS = 110000;
    public static final String RESULT_MSG_SUCCESS = "成功";
    protected SparseArray<String> msgMap = new SparseArray();
    protected int resultCode = ERROR_CODE_UNKNOWN;
    protected String resultMsg;

    public static class Action {
        public ActionMode actionMode;
        public String actionTitle;
        public ActionType actionType;
        public String actionUrl;
    }

    public enum ActionMode {
        MSG("msg"),
        URL("url");
        
        /* renamed from: a */
        private static final Map<String, ActionMode> f20452a = null;
        /* renamed from: b */
        private String f20454b;

        static {
            f20452a = new HashMap();
            for (ActionMode actionMode : values()) {
                f20452a.put(actionMode.toString(), actionMode);
            }
        }

        private ActionMode(String actionMode) {
            this.f20454b = actionMode;
        }

        public String getValue() {
            return this.f20454b;
        }

        public static ActionMode fromString(String actionMode) {
            return (ActionMode) f20452a.get(actionMode);
        }

        public String toString() {
            return this.f20454b;
        }
    }

    public enum ActionType {
        FORCE("force"),
        OPTIONAL("optional");
        
        /* renamed from: a */
        private static final Map<String, ActionType> f20455a = null;
        /* renamed from: b */
        private String f20457b;

        static {
            f20455a = new HashMap();
            for (ActionType actionType : values()) {
                f20455a.put(actionType.toString(), actionType);
            }
        }

        private ActionType(String actionType) {
            this.f20457b = actionType;
        }

        public String getValue() {
            return this.f20457b;
        }

        public static ActionType fromString(String actionType) {
            return (ActionType) f20455a.get(actionType);
        }

        public String toString() {
            return this.f20457b;
        }
    }

    public SapiResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(110000, RESULT_MSG_SUCCESS);
        this.msgMap.put(ERROR_CODE_NETWORK_UNAVAILABLE, ERROR_MSG_NETWORK_UNAVAILABLE);
        this.msgMap.put(ERROR_CODE_UNKNOWN, "网络连接失败，请检查网络设置");
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultMsg() {
        if (TextUtils.isEmpty(this.resultMsg)) {
            return this.msgMap.get(this.resultCode) != null ? (String) this.msgMap.get(this.resultCode) : (String) this.msgMap.get(ERROR_CODE_UNKNOWN);
        } else {
            return this.resultMsg;
        }
    }
}
