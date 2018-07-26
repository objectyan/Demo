package com.baidu.mapframework.nirvana.schedule;

import com.baidu.mapframework.nirvana.C3541e;

public class ScheduleConfig {
    /* renamed from: d */
    private static final ScheduleConfig f19254d = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
    /* renamed from: e */
    private static final ScheduleConfig f19255e = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.SETUP);
    /* renamed from: f */
    private static final ScheduleConfig f19256f = new ScheduleConfig(DataTaskType.forStatictics(), ScheduleTag.NULL);
    /* renamed from: a */
    private final TaskType f19257a;
    /* renamed from: b */
    private final ScheduleTag f19258b;
    /* renamed from: c */
    private Lifecycle f19259c;

    public static ScheduleConfig forData() {
        return f19254d;
    }

    public static ScheduleConfig forSetupData() {
        return f19255e;
    }

    public static ScheduleConfig forStatistics() {
        return f19256f;
    }

    public static ScheduleConfig uiPage(String pageName) {
        return new ScheduleConfig(UITaskType.forPage(pageName), ScheduleTag.NULL);
    }

    public static ScheduleConfig uiScene(String sceneName) {
        return new ScheduleConfig(UITaskType.forScene(sceneName), ScheduleTag.NULL);
    }

    public ScheduleConfig(TaskType type, ScheduleTag tag) {
        this.f19257a = type;
        this.f19258b = tag;
    }

    public TaskType getType() {
        return this.f19257a;
    }

    public ScheduleTag getTag() {
        return this.f19258b;
    }

    public void bindLifecycle() {
        if (this.f19257a instanceof UITaskType) {
            UITaskType t = this.f19257a;
            this.f19259c = C3541e.m15176d().m15228a(t.getType(), t.getName());
        }
    }

    public boolean isLifecycleActive() {
        if (this.f19259c != null) {
            return this.f19259c.isActive();
        }
        return true;
    }

    public String toString() {
        return "ScheduleConfig{type=" + this.f19257a + ", tag=" + this.f19258b + '}';
    }
}
