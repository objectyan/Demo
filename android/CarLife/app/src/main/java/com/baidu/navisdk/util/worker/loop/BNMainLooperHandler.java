package com.baidu.navisdk.util.worker.loop;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class BNMainLooperHandler extends Handler {
    public abstract void onMessage(Message message);

    public BNMainLooperHandler() {
        super(Looper.getMainLooper());
    }

    public final boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        BNPerformceFramework.getInstance().markSubmit(msg);
        return super.sendMessageAtTime(msg, uptimeMillis);
    }

    public final void handleMessage(Message msg) {
        if (msg != null) {
            final Message copyMsg = Message.obtain();
            copyMsg.copyFrom(msg);
            BNPerformceFramework.getInstance().runInLooperBuffer(new Runnable() {
                public void run() {
                    BNPerformceFramework.getInstance().markRunning(copyMsg);
                    BNMainLooperHandler.this.onMessage(copyMsg);
                    BNPerformceFramework.getInstance().markFinish(copyMsg);
                    copyMsg.recycle();
                }
            });
        }
    }

    public final void dispatchMessage(Message msg) {
        super.dispatchMessage(msg);
    }
}
