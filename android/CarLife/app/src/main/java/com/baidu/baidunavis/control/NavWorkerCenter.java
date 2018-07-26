package com.baidu.baidunavis.control;

import com.baidu.baidunavis.ui.BNCruiserFragment;
import com.baidu.baidunavis.ui.BNDownloadPage;
import com.baidu.baidunavis.ui.BNRouteGuideFragment;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentCallable;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.concurrent.QueueToken;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;
import com.baidu.mapframework.nirvana.schedule.UITaskType;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerCenterAbs;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.BNWorkerTask;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class NavWorkerCenter extends BNWorkerCenterAbs {
    private Map<Integer, WeakReference<LooperTask>> mMainTaskMap = new ConcurrentHashMap();
    private Module module = Module.NAV_MODULE;
    private QueueToken normalToken = ConcurrentManager.obtainTaskQueue(this.module);

    private static class NavConcurrentCallable<K, T> extends ConcurrentCallable<T> {
        private BNWorkerTask<K, T> workerTask = null;

        public NavConcurrentCallable(BNWorkerTask<K, T> task) {
            this.workerTask = task;
        }

        public T call() {
            if (this.workerTask != null) {
                try {
                    return this.workerTask.call();
                } catch (Exception e) {
                    LogUtil.e(BNWorkerCenter.TAG, "concurrenttask:" + this.workerTask.getTaskName() + " - execute ex. ex=" + e.getMessage());
                }
            }
            return null;
        }
    }

    public <K, T> Future<?> submitTask(BNWorkerTask<K, T> task, BNWorkerConfig config) {
        if (!checkTask(task)) {
            return null;
        }
        Future<?> future = ConcurrentManager.submitTask(this.module, new NavConcurrentCallable(task), getConfig(config));
        if (future == null) {
            return future;
        }
        this.taskFutures.put(task, future);
        return future;
    }

    public <K, T> void submitQueneTask(final BNWorkerNormalTask<K, T> task, BNWorkerConfig config) {
        ConcurrentTask concurrentTask = new ConcurrentTask() {
            public void run() {
                if (task != null) {
                    try {
                        task.call();
                    } catch (Exception e) {
                        LogUtil.e(BNWorkerCenter.TAG, "quenetask:" + task.getTaskName() + " - execute ex. ex=" + e.getMessage());
                    }
                }
            }
        };
        concurrentTask.setQueueToken(this.normalToken);
        ConcurrentManager.executeTask(this.module, concurrentTask, getConfig(config));
    }

    public <K, T> void submitMainThreadTask(final BNWorkerNormalTask<K, T> task, BNWorkerConfig config) {
        if (task != null) {
            LooperTask lt = new LooperTask() {
                public void run() {
                    if (task != null) {
                        try {
                            task.call();
                        } catch (Exception e) {
                            LogUtil.e(BNWorkerCenter.TAG, "mianthreadtask:" + task.getTaskName() + " - execute ex. ex=" + e.getMessage());
                        }
                    }
                }
            };
            this.mMainTaskMap.put(Integer.valueOf(task.hashCode()), new WeakReference(lt));
            LooperManager.executeTask(this.module, lt, getConfig(config));
        }
    }

    public <K, T> boolean cancelTask(BNWorkerTask<K, T> task, boolean force) {
        boolean superRet = super.cancelTask(task, force);
        if (task != null) {
            LogUtil.e(BNWorkerCenter.TAG, "cancelTask() taskid=" + task.hashCode());
            if (this.mMainTaskMap.containsKey(Integer.valueOf(task.hashCode()))) {
                WeakReference<LooperTask> lt = (WeakReference) this.mMainTaskMap.get(Integer.valueOf(task.hashCode()));
                if (!(lt == null || lt.get() == null)) {
                    ((LooperTask) lt.get()).cancel();
                    this.mMainTaskMap.remove(Integer.valueOf(task.hashCode()));
                    LogUtil.e(BNWorkerCenter.TAG, "cancelTask() cancel ok in base.");
                }
            } else {
                LogUtil.e(BNWorkerCenter.TAG, "cancelTask() not found in base queue.");
            }
        }
        LogUtil.e(BNWorkerCenter.TAG, "cancelTask() superRet=" + superRet);
        return superRet;
    }

    private ScheduleConfig getConfig(BNWorkerConfig config) {
        if (config == null) {
            return new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
        }
        ScheduleTag tag;
        UITaskType uiType = null;
        DataTaskType dataType = null;
        switch (config.type) {
            case 2:
                uiType = UITaskType.forPage(BNRouteGuideFragment.class.getName());
                break;
            case 4:
            case 5:
            case 6:
            case 9:
                break;
            case 7:
                uiType = UITaskType.forPage(BNDownloadPage.class.getName());
                break;
            case 8:
                uiType = UITaskType.forPage(BNCruiserFragment.class.getName());
                break;
            case 100:
                dataType = DataTaskType.forUpdateData();
                break;
            case 101:
                dataType = DataTaskType.forDownload();
                break;
            case 102:
                dataType = DataTaskType.forStatictics();
                break;
            default:
                dataType = DataTaskType.forUpdateData();
                break;
        }
        switch (config.tag) {
            case 1:
                tag = ScheduleTag.SETUP;
                break;
            default:
                tag = ScheduleTag.NULL;
                break;
        }
        if (uiType != null && tag != null) {
            return new ScheduleConfig(uiType, tag);
        }
        if (dataType == null || tag == null) {
            return new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
        }
        return new ScheduleConfig(dataType, tag);
    }
}
