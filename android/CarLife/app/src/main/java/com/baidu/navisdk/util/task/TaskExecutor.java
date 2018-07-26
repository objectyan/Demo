package com.baidu.navisdk.util.task;

import android.os.Looper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.task.TaskRunnable.OnRunListener;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskExecutor implements OnRunListener {
    private static final int STATE_ADD = 1;
    private static final int STATE_CANCLE = 4;
    private static final int STATE_END = 3;
    private static final int STATE_INIT = 0;
    private static final int STATE_START = 2;
    private static final String TAG = "TaskExecutor";
    private ArrayList<TaskRunnable<String, String>> mBackgroundTaskList;
    private TaskCallback mCallbackListener;
    private ArrayList<TaskRunnable<String, String>> mMainTaskList;
    private int mState;

    public interface TaskCallback {
        void onComplete();
    }

    private TaskExecutor() {
        this.mMainTaskList = new ArrayList();
        this.mBackgroundTaskList = new ArrayList();
        this.mState = 0;
        this.mState = 0;
    }

    public static TaskExecutor create() {
        return new TaskExecutor();
    }

    public TaskExecutor addTask(TaskRunnable<String, String> runnable) {
        if (this.mState == 3) {
            throw new RuntimeException("current taskExecutor has end, need renew instance");
        }
        this.mState = 1;
        switch (runnable.mType) {
            case 0:
                runnable.setOnRunListener(this);
                this.mMainTaskList.add(runnable);
                break;
            case 1:
                runnable.setOnRunListener(this);
                this.mBackgroundTaskList.add(runnable);
                break;
        }
        return this;
    }

    public void start() {
        if (this.mState == 3) {
            throw new RuntimeException("current taskExecutor has end, need renew instance");
        } else if (this.mState == 4) {
            LogUtil.m15791e(TAG, "start return state_cancle");
        } else {
            this.mState = 2;
            Iterator it = new ArrayList(this.mBackgroundTaskList).iterator();
            while (it.hasNext()) {
                BNWorkerCenter.getInstance().submitNormalTask((TaskRunnable) it.next(), new BNWorkerConfig(2, 0));
            }
            it = new ArrayList(this.mMainTaskList).iterator();
            while (it.hasNext()) {
                BNWorkerCenter.getInstance().submitMainThreadTask((TaskRunnable) it.next(), new BNWorkerConfig(2, 0));
            }
        }
    }

    public void cancleAll() {
        Iterator it;
        this.mState = 4;
        if (!this.mBackgroundTaskList.isEmpty()) {
            ArrayList<TaskRunnable<String, String>> localBGList = new ArrayList(this.mBackgroundTaskList);
            this.mBackgroundTaskList.clear();
            it = localBGList.iterator();
            while (it.hasNext()) {
                BNWorkerCenter.getInstance().cancelTask((TaskRunnable) it.next(), false);
            }
        }
        if (!this.mMainTaskList.isEmpty()) {
            ArrayList<TaskRunnable<String, String>> localMainList = new ArrayList(this.mMainTaskList);
            this.mMainTaskList.clear();
            it = localMainList.iterator();
            while (it.hasNext()) {
                BNWorkerCenter.getInstance().cancelTask((TaskRunnable) it.next(), false);
            }
        }
    }

    public void onComplete(TaskRunnable<?, ?> task) {
        if (this.mMainTaskList.contains(task)) {
            this.mMainTaskList.remove(task);
        }
        if (this.mBackgroundTaskList.contains(task)) {
            this.mBackgroundTaskList.remove(task);
        }
        if (this.mMainTaskList.isEmpty() && this.mBackgroundTaskList.isEmpty()) {
            this.mState = 3;
            if (this.mCallbackListener != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    this.mCallbackListener.onComplete();
                } else {
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("onComplete-" + getClass().getSimpleName(), null) {
                        protected String execute() {
                            TaskExecutor.this.mCallbackListener.onComplete();
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }
            }
        }
    }

    public void setCallback(TaskCallback callback) {
        this.mCallbackListener = callback;
    }
}
