package com.baidu.navisdk.util.worker;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.logic.NaviErrCode;

public abstract class BNWorkerHandlerTask<K, T> extends BNWorkerTask<K, T> {
    private Handler handler = null;
    private int rspMsgWhat = NaviErrCode.RET_BUG;

    public BNWorkerHandlerTask(String taskName, K pInData, Handler hd, int what) {
        super(taskName, (Object) pInData);
        this.handler = hd;
        this.rspMsgWhat = what;
    }

    protected final void notifyResult(T result) {
        if (this.handler != null) {
            Message message = this.handler.obtainMessage();
            message.what = this.rspMsgWhat;
            message.obj = result;
        }
    }
}
