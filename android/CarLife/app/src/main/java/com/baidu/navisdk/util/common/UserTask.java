package com.baidu.navisdk.util.common;

import android.os.Process;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class UserTask<Params, Progress, Result> {
    private static final String LOG_TAG = "UserTask";
    private static final int MESSAGE_POST_CANCEL = 3;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private Future<Result> mFuture;
    private volatile Status mStatus = Status.PENDING;

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public abstract Result doInBackground(Params... paramsArr);

    public final Status getStatus() {
        return this.mStatus;
    }

    public void onPreExecute() {
    }

    public void onPostExecute(Result result) {
    }

    public void onProgressUpdate(Progress... progressArr) {
    }

    public void onCancelled() {
    }

    public final boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    public final boolean cancel(boolean mayInterruptIfRunning) {
        return this.mFuture.cancel(mayInterruptIfRunning);
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(timeout, unit);
    }

    public final UserTask<Params, Progress, Result> execute(Params... params) {
        if (this.mStatus != Status.PENDING) {
            try {
                switch (this.mStatus) {
                    case RUNNING:
                        throw new IllegalStateException("Cannot execute task: the task is already running.");
                    case FINISHED:
                        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
            } catch (Exception e) {
                LogUtil.m15791e(getClass().getName(), "IllegalStateException: " + e.getMessage());
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        try {
            this.mFuture = BNWorkerCenter.getInstance().submitTask(new BNWorkerNormalTask<Params, Result>("", params, true) {
                protected Result execute() {
                    Process.setThreadPriority(10);
                    Result result = UserTask.this.doInBackground(getInDatas());
                    UserTask.this.done(result);
                    return result;
                }
            }, new BNWorkerConfig(100, 0));
        } catch (Exception e2) {
            LogUtil.m15791e(getClass().getName(), "exception: " + e2.getMessage());
            onCancelled();
            this.mStatus = Status.FINISHED;
        }
        return this;
    }

    private void done(Result result) {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<Result, String>(getClass().getSimpleName() + "-done.onPostExecute", result) {
            protected String execute() {
                UserTask.this.finish(this.inData);
                return null;
            }
        }, new BNWorkerConfig(100, 0));
    }

    protected final void publishProgress(Progress... values) {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<Progress, String>(getClass().getSimpleName() + "-publishProgress", values, true) {
            protected String execute() {
                UserTask.this.onProgressUpdate(this.inDatas);
                return null;
            }
        }, new BNWorkerConfig(100, 0));
    }

    private void finish(Result result) {
        onPostExecute(result);
        this.mStatus = Status.FINISHED;
    }
}
