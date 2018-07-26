package com.baidu.mapframework.nirvana.schedule;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapframework.nirvana.p205b.C3530a;
import com.baidu.mapframework.nirvana.schedule.UITaskType.UIType;
import java.util.HashMap;

public class LifecycleManager {
    public static final String TAG = C3530a.class.getSimpleName();
    /* renamed from: a */
    private volatile long f19250a = 0;
    /* renamed from: b */
    private String f19251b;
    /* renamed from: c */
    private UIState f19252c;
    /* renamed from: d */
    private volatile HashMap<String, UIState> f19253d = new HashMap();

    interface Lifecycle {
        boolean isActive();
    }

    class PageLifecycle implements Lifecycle {
        /* renamed from: a */
        final /* synthetic */ LifecycleManager f19245a;
        /* renamed from: b */
        private final long f19246b;

        private PageLifecycle(LifecycleManager this$0, long currentSnapshot) {
            this.f19245a = this$0;
            this.f19246b = currentSnapshot;
        }

        public boolean isActive() {
            return this.f19245a.f19250a == this.f19246b;
        }
    }

    class SceneLifecycle implements Lifecycle {
        /* renamed from: a */
        final /* synthetic */ LifecycleManager f19247a;
        /* renamed from: b */
        private final String f19248b;

        private SceneLifecycle(LifecycleManager this$0, String sceneName) {
            this.f19247a = this$0;
            this.f19248b = sceneName;
        }

        public boolean isActive() {
            UIState state = (UIState) this.f19247a.f19253d.get(this.f19248b);
            return state != null && state == UIState.ACTIVE;
        }
    }

    public enum UIState {
        ACTIVE,
        DESTROYED
    }

    public synchronized void onUIStateChange(UIType type, String name, UIState state) {
        Log.d(TAG, "onUIStateChange: " + type + " " + name + " " + state);
        switch (type) {
            case PAGE:
                this.f19251b = name;
                this.f19252c = state;
                this.f19250a++;
                break;
            case SCENE:
                break;
        }
        this.f19253d.put(name, state);
    }

    /* renamed from: a */
    synchronized Lifecycle m15228a(UIType type, String name) {
        Lifecycle lifecycle = null;
        synchronized (this) {
            switch (type) {
                case PAGE:
                    if (!TextUtils.equals(name, this.f19251b)) {
                        lifecycle = new PageLifecycle(-1);
                        break;
                    }
                    lifecycle = new PageLifecycle(this.f19250a);
                    break;
                case SCENE:
                    lifecycle = new SceneLifecycle(name);
                    break;
            }
        }
        return lifecycle;
    }
}
