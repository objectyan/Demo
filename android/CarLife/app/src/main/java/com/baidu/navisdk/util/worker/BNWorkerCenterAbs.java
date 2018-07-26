package com.baidu.navisdk.util.worker;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class BNWorkerCenterAbs implements IBNWorkerCenter {
    private static final int MSG_MAINTHREAD_TASK_DELAY = 2;
    private static final int MSG_NORMAL_TASK_DELAY = 1;
    private static final int MSG_QUEUE_TASK_DELAY = 3;
    private static final int TYPE_MAINTHREAD_TASK_DELAY = 2;
    private static final int TYPE_NORMAL_TASK_DELAY = 1;
    private static final int TYPE_QUEUE_TASK_DELAY = 3;
    private Handler mHandler = new Handler(CommonHandlerThread.getInstance().getLooper()) {
        public void handleMessage(Message msg) {
            LogUtil.m15791e(BNWorkerCenter.TAG, "handleMessage() what=hashcode=" + msg.what);
            TaskWrapper<?, ?> taskWrapper;
            if (msg.arg1 == 1 && msg.obj != null && (msg.obj instanceof TaskWrapper)) {
                taskWrapper = msg.obj;
                BNWorkerCenterAbs.this.submitTask(taskWrapper.task, taskWrapper.config);
            } else if (msg.arg1 == 2 && msg.obj != null && (msg.obj instanceof TaskWrapper)) {
                taskWrapper = (TaskWrapper) msg.obj;
                BNWorkerCenterAbs.this.submitMainThreadTask((BNWorkerNormalTask) taskWrapper.task, taskWrapper.config);
            } else if (msg.arg1 == 3 && msg.obj != null && (msg.obj instanceof TaskWrapper)) {
                taskWrapper = (TaskWrapper) msg.obj;
                BNWorkerCenterAbs.this.submitQueneTask((BNWorkerNormalTask) taskWrapper.task, taskWrapper.config);
            }
        }
    };
    protected Map<BNWorkerTask<?, ?>, Future<?>> taskFutures = new ConcurrentHashMap();

    private static class TaskWrapper<K, T> {
        public BNWorkerConfig config = null;
        public BNWorkerTask<K, T> task = null;

        public TaskWrapper(BNWorkerTask<K, T> t, BNWorkerConfig c) {
            this.task = t;
            this.config = c;
        }
    }

    public abstract <K, T> Future<?> submitTask(BNWorkerTask<K, T> bNWorkerTask, BNWorkerConfig bNWorkerConfig);

    protected boolean checkTask(BNWorkerTask<?, ?> task) {
        if (task == null) {
            LogUtil.m15791e(BNWorkerCenter.TAG, "checkTask() task is null.");
            return false;
        }
        LogUtil.m15791e(BNWorkerCenter.TAG, "checkTask() taskname=" + task.getTaskName());
        return true;
    }

    public <K, T> void submitNormalTask(BNWorkerNormalTask<K, T> task, BNWorkerConfig config) {
        submitTask(task, config);
    }

    public <K, T> void submitNormalTaskDelay(BNWorkerNormalTask<K, T> task, BNWorkerConfig config, long delayMS) {
        if (task == null) {
            LogUtil.m15791e(BNWorkerCenter.TAG, "submitNormalTaskDelay() task is null !!!");
            return;
        }
        TaskWrapper<K, T> tw = new TaskWrapper(task, config);
        LogUtil.m15791e(BNWorkerCenter.TAG, "submitNormalTaskDelay() what=hashcode=" + task.hashCode());
        Message message = this.mHandler.obtainMessage(task.hashCode());
        message.arg1 = 1;
        message.obj = tw;
        this.mHandler.sendMessageDelayed(message, delayMS);
    }

    public <K, T> void submitCallbackTask(BNWorkerCallbackTask<K, T> task, BNWorkerConfig config) {
        submitTask(task, config);
    }

    public <K, T> void submitHandlerTask(BNWorkerHandlerTask<K, T> task, BNWorkerConfig config) {
        submitTask(task, config);
    }

    public <K, T> void submitBlockTask(BNWorkerBlockTask<K, T> task, BNWorkerConfig config) {
        if (task == null) {
            LogUtil.m15791e(BNWorkerCenter.TAG, "submitBlockTask() task is null !!!");
            return;
        }
        try {
            submitTask(task, config).get();
        } catch (InterruptedException e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
        } catch (ExecutionException e2) {
            if (LogUtil.LOGGABLE) {
                e2.printStackTrace();
            }
        }
    }

    public <K, T> void submitQueneTask(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig config) {
    }

    public <K, T> void submitQueneTaskDelay(BNWorkerNormalTask<K, T> task, BNWorkerConfig config, long delayMS) {
        if (task == null) {
            LogUtil.m15791e(BNWorkerCenter.TAG, "submitQueneTaskDelay() task is null !!!");
            return;
        }
        TaskWrapper<K, T> tw = new TaskWrapper(task, config);
        LogUtil.m15791e(BNWorkerCenter.TAG, "submitQueneTaskDelay() what=hashcode=" + task.hashCode() + " taskName:" + task.getTaskName());
        Message message = this.mHandler.obtainMessage(task.hashCode());
        message.arg1 = 3;
        message.obj = tw;
        this.mHandler.sendMessageDelayed(message, delayMS);
    }

    public <K, T> void submitMainThreadTask(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig config) {
    }

    public <K, T> void submitMainThreadTaskDelay(BNWorkerNormalTask<K, T> task, BNWorkerConfig config, long delayMS) {
        if (task == null) {
            LogUtil.m15791e(BNWorkerCenter.TAG, "submitMainThreadTaskDelay() task is null !!!");
            return;
        }
        TaskWrapper<K, T> tw = new TaskWrapper(task, config);
        Message message = this.mHandler.obtainMessage(task.hashCode());
        LogUtil.m15791e(BNWorkerCenter.TAG, "submitMainThreadTaskDelay() what=hashcode=" + task.hashCode() + " taskName" + task.getTaskName());
        message.arg1 = 2;
        message.obj = tw;
        this.mHandler.sendMessageDelayed(message, delayMS);
    }

    public <K, T> void submitLooperChildThreadTask(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig config) {
    }

    public <K, T> Future<?> removeTask(BNWorkerTask<K, T> task) {
        if (task == null || !this.taskFutures.containsKey(task)) {
            return null;
        }
        return (Future) this.taskFutures.remove(task);
    }

    public <K, T> boolean cancelTask(BNWorkerTask<K, T> task, boolean force) {
        if (task == null) {
            LogUtil.m15791e(BNWorkerCenter.TAG, "cancelTask() return for the task is null.");
            return false;
        }
        if (LogUtil.LOGGABLE && task != null) {
            LogUtil.m15791e(BNWorkerCenter.TAG, "cancelTask() task.hashcode=" + task.hashCode());
        }
        boolean ret = false;
        try {
            task.isCancelled = true;
            if (this.mHandler.hasMessages(task.hashCode())) {
                this.mHandler.removeMessages(task.hashCode());
                ret = true;
                LogUtil.m15791e(BNWorkerCenter.TAG, "cancelTask() find in messages queue. task.hashcode=" + task.hashCode() + " taskName:" + task.getTaskName());
            }
            if (task != null && this.taskFutures.containsKey(task)) {
                ret = ((Future) this.taskFutures.get(task)).cancel(force);
                LogUtil.m15791e(BNWorkerCenter.TAG, "cancelTask() find in taskFutures. task.hashcode=" + task.hashCode() + " taskName:" + task.getTaskName());
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
            ret = false;
        }
        if (!LogUtil.LOGGABLE || task == null) {
            return ret;
        }
        LogUtil.m15791e(BNWorkerCenter.TAG, "cancelTask() taskName=" + task.getTaskName() + ", isCancelOK=" + ret);
        return ret;
    }
}
