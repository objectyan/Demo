package com.baidu.platform.comapi.util;

import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

public class BMEventBus {
    public static final BMEventBus INSTANCE = new BMEventBus();
    private static final String TAG = BMEventBus.class.getName();
    private final Map<Class<?>, CopyOnWriteArraySet<BMEventBus$ModuleOnEvent>> listenersMap = new HashMap();
    private final Map<Class<?>, Object> stickyEvents = new HashMap();

    private BMEventBus() {
    }

    public static BMEventBus getInstance() {
        return INSTANCE;
    }

    @Deprecated
    public synchronized void registSticky(BMEventBus$OnEvent listener, Class<?> oneType, Class<?>... moreTypes) {
        registSticky(listener, Module.UNFINISHED_MODULE, oneType, moreTypes);
    }

    public synchronized void registSticky(BMEventBus$OnEvent listener, Module module, Class<?> oneType, Class<?>... moreTypes) {
        BMEventBus$ModuleOnEvent moduleOnEvent = new BMEventBus$ModuleOnEvent(this, listener, module);
        subscribe(moduleOnEvent, oneType, true);
        if (moreTypes != null) {
            for (Class<?> type : moreTypes) {
                subscribe(moduleOnEvent, type, true);
            }
        }
    }

    @Deprecated
    public synchronized void regist(BMEventBus$OnEvent listener, Class<?> oneType, Class<?>... moreTypes) {
        regist(listener, Module.UNFINISHED_MODULE, oneType, moreTypes);
    }

    public synchronized void regist(BMEventBus$OnEvent listener, Module module, Class<?> oneType, Class<?>... moreTypes) {
        synchronized (this) {
            BMEventBus$ModuleOnEvent moduleOnEvent = new BMEventBus$ModuleOnEvent(this, listener, module);
            subscribe(moduleOnEvent, oneType, false);
            if (moreTypes != null) {
                for (Class<?> type : moreTypes) {
                    subscribe(moduleOnEvent, type, false);
                }
            }
        }
    }

    private void subscribe(BMEventBus$ModuleOnEvent listener, Class<?> type, boolean isSticky) {
        if (this.listenersMap.containsKey(type)) {
            ((CopyOnWriteArraySet) this.listenersMap.get(type)).add(listener);
        } else {
            CopyOnWriteArraySet<BMEventBus$ModuleOnEvent> listeners = new CopyOnWriteArraySet();
            listeners.add(listener);
            this.listenersMap.put(type, listeners);
        }
        if (isSticky) {
            Object stickyEvent;
            synchronized (this.stickyEvents) {
                stickyEvent = this.stickyEvents.get(type);
            }
            if (stickyEvent != null) {
                doEvent(listener, stickyEvent);
            }
        }
    }

    public synchronized void unregist(BMEventBus$OnEvent listener) {
        for (Class type : this.listenersMap.keySet()) {
            unregist(type, listener);
        }
    }

    public synchronized void unregist(Class<?> type, BMEventBus$OnEvent listener) {
        if (this.listenersMap.containsKey(type)) {
            ((CopyOnWriteArraySet) this.listenersMap.get(type)).remove(new BMEventBus$OnEventEqualWrapper(this, listener));
        }
    }

    public void post(Object obj) {
        if (this.listenersMap.containsKey(obj.getClass())) {
            CopyOnWriteArraySet<BMEventBus$ModuleOnEvent> listeners;
            synchronized (this) {
                listeners = (CopyOnWriteArraySet) this.listenersMap.get(obj.getClass());
            }
            Iterator it = listeners.iterator();
            while (it.hasNext()) {
                BMEventBus$ModuleOnEvent listener = (BMEventBus$ModuleOnEvent) it.next();
                LooperTask task = new BMEventBus$1(this, listener, obj);
                task.appendDescription(TAG);
                task.appendDescription("listener=" + BMEventBus$ModuleOnEvent.access$100(listener).getClass().getName());
                task.appendDescription("event=" + obj.getClass().getName());
                LooperManager.executeTask(BMEventBus$ModuleOnEvent.access$200(listener), task, ScheduleConfig.forData());
            }
        }
    }

    public void postDelay(Object obj, int delayTime) {
        LooperManager.executeTask(Module.UNFINISHED_MODULE, new BMEventBus$2(this, (long) delayTime, obj), ScheduleConfig.forData());
    }

    public void postSticky(Object event) {
        synchronized (this.stickyEvents) {
            this.stickyEvents.put(event.getClass(), event);
        }
        post(event);
    }

    public void postStickyDelay(Object obj, int delayTime) {
        LooperManager.executeTask(Module.UNFINISHED_MODULE, new BMEventBus$3(this, (long) delayTime, obj), ScheduleConfig.forData());
    }

    public Object getStickyEvent(Class<?> eventType) {
        Object obj;
        synchronized (this.stickyEvents) {
            obj = this.stickyEvents.get(eventType);
        }
        return obj;
    }

    public Object removeStickyEvent(Class<?> eventType) {
        Object remove;
        synchronized (this.stickyEvents) {
            remove = this.stickyEvents.remove(eventType);
        }
        return remove;
    }

    public boolean removeStickyEvent(Object event) {
        boolean z;
        synchronized (this.stickyEvents) {
            Class<? extends Object> eventType = event.getClass();
            if (event.equals(this.stickyEvents.get(eventType))) {
                this.stickyEvents.remove(eventType);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void doEvent(BMEventBus$OnEvent listener, Object event) {
        listener.onEvent(event);
    }
}
