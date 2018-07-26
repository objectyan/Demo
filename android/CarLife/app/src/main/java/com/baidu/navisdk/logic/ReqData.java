package com.baidu.navisdk.logic;

import android.os.Handler;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.logic.CommandCenter.CommandCenterListener;
import java.util.HashMap;
import org.apache.http.client.CookieStore;

public class ReqData {
    public static final int K_DEFAULT_TIMEOUT = 500000;
    public String mCmd;
    public CookieStore mCookieStore = null;
    public Handler mHandler;
    public int mHandlerMsgWhat;
    public boolean mHasMsgSent = false;
    public boolean mNeedCache = false;
    public Object mObj;
    public HashMap<String, Object> mParams = new HashMap();
    public CommandCenterListener mRequestListener;
    public int mRetryIntervals = 0;
    public int mRetryTimes = 1;
    public int mSubSystem;
    public String mTag;
    public int mTimeout = 500000;

    public ReqData(String cmd, int subSystem, Handler handler, int what) {
        this.mCmd = cmd;
        this.mSubSystem = subSystem;
        this.mHandler = handler;
        this.mHandlerMsgWhat = what;
        if (handler != null) {
            this.mTag = handler.getClass().getName();
        }
    }

    public ReqData(String cmd, int subSystem, Handler handler, int what, int timeout) {
        this.mCmd = cmd;
        this.mSubSystem = subSystem;
        this.mHandler = handler;
        this.mHandlerMsgWhat = what;
        this.mTimeout = timeout;
        if (handler != null) {
            this.mTag = handler.getClass().getName();
        }
    }

    public String toString() {
        return "req_" + this.mSubSystem + this.mCmd + JNISearchConst.LAYER_ID_DIVIDER + this.mTag;
    }

    public void setObj(Object obj) {
        this.mObj = obj;
    }

    public Object getObj() {
        return this.mObj;
    }
}
