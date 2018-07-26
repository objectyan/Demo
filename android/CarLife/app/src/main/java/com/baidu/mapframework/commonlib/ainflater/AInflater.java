package com.baidu.mapframework.commonlib.ainflater;

import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentCallable;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.C4835n;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;

public final class AInflater {
    /* renamed from: a */
    private static final ConcurrentMap<Integer, View> f18789a = new ConcurrentHashMap();

    public static class AInflaterTask extends ConcurrentCallable<View> {
        /* renamed from: a */
        private final SoftReference<Context> f18787a;
        /* renamed from: b */
        private final int f18788b;

        public AInflaterTask(@NotNull Context context, int layoutId) {
            this.f18787a = new SoftReference(context);
            this.f18788b = layoutId;
        }

        public View call() throws Exception {
            if (AInflater.f18789a.get(Integer.valueOf(this.f18788b)) != null) {
                View v = (View) AInflater.f18789a.get(Integer.valueOf(this.f18788b));
                C2911f.b("AInflater", "getView from map:" + v);
                return v;
            } else if (this.f18787a == null || this.f18787a.get() == null) {
                return null;
            } else {
                View view = null;
                try {
                    view = LayoutInflater.from((Context) this.f18787a.get()).inflate(this.f18788b, null);
                    if (view != null) {
                        synchronized (AInflater.class) {
                            if (!AInflater.f18789a.containsKey(Integer.valueOf(this.f18788b))) {
                                AInflater.f18789a.put(Integer.valueOf(this.f18788b), view);
                                C2911f.b("AInflater", "put view to map:" + view);
                            }
                        }
                    }
                } catch (InflateException e) {
                    C2911f.e("AInflater", "AsyncInflateException");
                    e.printStackTrace();
                    if (view != null) {
                        synchronized (AInflater.class) {
                            if (!AInflater.f18789a.containsKey(Integer.valueOf(this.f18788b))) {
                                AInflater.f18789a.put(Integer.valueOf(this.f18788b), view);
                                C2911f.b("AInflater", "put view to map:" + view);
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (view != null) {
                        synchronized (AInflater.class) {
                            if (!AInflater.f18789a.containsKey(Integer.valueOf(this.f18788b))) {
                                AInflater.f18789a.put(Integer.valueOf(this.f18788b), view);
                                C2911f.b("AInflater", "put view to map:" + view);
                            }
                        }
                    }
                }
                return view;
            }
        }
    }

    public AInflater(ExecutorService executorService) {
    }

    public Future<View> submitAInflaterTask(AInflaterTask task) {
        return ConcurrentManager.submitTask(Module.POI_DETAIL_MODULE, task, ScheduleConfig.forData());
    }

    public View getView(Context context, int layoutId) throws ExecutionException, InterruptedException {
        if (f18789a.get(Integer.valueOf(layoutId)) == null) {
            return normalInflate(context, layoutId);
        }
        View v = (View) f18789a.get(Integer.valueOf(layoutId));
        C2911f.b("AInflater", "getView from map:" + v);
        return v;
    }

    public View normalInflate(Context context, int layoutId) {
        C4835n.m16036b();
        C2911f.e("AInflater", "normalInflate " + layoutId);
        View v = null;
        try {
            v = LayoutInflater.from(context).inflate(layoutId, null);
            synchronized (AInflater.class) {
                f18789a.put(Integer.valueOf(layoutId), v);
                C2911f.b("AInflater", "put view to map:" + v);
            }
        } catch (InflateException e) {
            C2911f.e("AInflater", "normalInflate error");
            e.printStackTrace();
        }
        return v;
    }

    public void clearCache() {
        f18789a.clear();
    }

    public void removeCacheView(int layoutId) {
        f18789a.remove(Integer.valueOf(layoutId));
    }
}
