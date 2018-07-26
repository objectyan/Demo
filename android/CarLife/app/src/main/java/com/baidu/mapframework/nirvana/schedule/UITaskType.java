package com.baidu.mapframework.nirvana.schedule;

public class UITaskType implements TaskType {
    /* renamed from: a */
    private final UIType f19262a;
    /* renamed from: b */
    private final String f19263b;

    public enum UIType {
        PAGE,
        SCENE,
        ACTIVITY
    }

    private UITaskType(UIType type, String name) {
        this.f19262a = type;
        this.f19263b = name;
    }

    public static UITaskType forPage(String pageClassName) {
        return new UITaskType(UIType.PAGE, pageClassName);
    }

    public static UITaskType forScene(String sceneClassName) {
        return new UITaskType(UIType.SCENE, sceneClassName);
    }

    public static UITaskType forActivity(String activityClassName) {
        return new UITaskType(UIType.ACTIVITY, activityClassName);
    }

    public UIType getType() {
        return this.f19262a;
    }

    public String getName() {
        return this.f19263b;
    }

    public String toString() {
        return "UITaskType{type=" + this.f19262a + ", name='" + this.f19263b + '\'' + '}';
    }
}
