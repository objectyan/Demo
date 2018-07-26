package com.baidu.platform.comapi.util;

import com.baidu.mapframework.nirvana.module.Module;

class BMEventBus$ModuleOnEvent implements BMEventBus$OnEvent {
    private final Module module;
    private final BMEventBus$OnEvent onEvent;
    final /* synthetic */ BMEventBus this$0;

    public BMEventBus$ModuleOnEvent(BMEventBus bMEventBus, BMEventBus$OnEvent onEvent, Module module) {
        this.this$0 = bMEventBus;
        this.onEvent = onEvent;
        this.module = module;
    }

    public void onEvent(Object event) {
        this.onEvent.onEvent(event);
    }

    public boolean equals(Object o) {
        return this.onEvent.equals(o);
    }
}
