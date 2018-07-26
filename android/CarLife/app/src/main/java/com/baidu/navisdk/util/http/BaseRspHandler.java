package com.baidu.navisdk.util.http;

import com.baidu.navisdk.util.common.LogUtil;
import org.apache.http.HttpResponse;

public class BaseRspHandler {
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int PROGRESS_MESSAGE = 0;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 4;
    protected static final String TAG = "BaseRspHandler";
    private boolean isStop = false;

    public void onStart() {
    }

    public void onFinish() {
    }

    public void onSuccess(Object resultObjs) {
    }

    public void onProgress(Object progressObjs) {
    }

    public void onFailure(Throwable error) {
    }

    protected void handleSuccessMessage(Object obj) {
        if (!isStop()) {
            LogUtil.m15791e(TAG, getClass().getName() + ":onSuccess");
            onSuccess(obj);
        }
    }

    protected void handleProgressMessage(long totalSize, long curSize, long speed) {
        if (!isStop()) {
            LogUtil.m15791e(TAG, getClass().getName() + ":onProgress");
            onProgress(new Long[]{Long.valueOf(totalSize), Long.valueOf(curSize), Long.valueOf(speed)});
        }
    }

    protected void handleFailureMessage(Throwable e) {
        if (!isStop()) {
            if (e == null || e.getMessage() == null) {
                e = new Throwable("unknow error");
            }
            LogUtil.m15791e(TAG, getClass().getName() + ":onFailure");
            onFailure(e);
        }
    }

    protected void handleStartMessage(Object obj) {
        if (!isStop()) {
            LogUtil.m15791e(TAG, getClass().getName() + ":onStart");
            onStart();
        }
    }

    protected void handleFinishMessage(Object obj) {
        LogUtil.m15791e(TAG, getClass().getName() + ":onFinish");
        onFinish();
    }

    public boolean isStop() {
        return this.isStop;
    }

    public void stop() {
        LogUtil.m15791e(TAG, getClass().getName() + ":stop");
        this.isStop = true;
    }

    protected void handleResponse(HttpResponse response) {
    }
}
