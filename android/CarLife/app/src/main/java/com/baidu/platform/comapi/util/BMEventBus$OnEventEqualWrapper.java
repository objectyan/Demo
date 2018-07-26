package com.baidu.platform.comapi.util;

class BMEventBus$OnEventEqualWrapper {
    private final BMEventBus$OnEvent onEvent;
    final /* synthetic */ BMEventBus this$0;

    public BMEventBus$OnEventEqualWrapper(BMEventBus bMEventBus, BMEventBus$OnEvent onEvent) {
        this.this$0 = bMEventBus;
        this.onEvent = onEvent;
    }

    public boolean equals(Object o) {
        if (o instanceof BMEventBus$ModuleOnEvent) {
            return ((BMEventBus$ModuleOnEvent) o).onEvent.equals(this.onEvent);
        }
        if (o instanceof BMEventBus$OnEvent) {
            return this.onEvent.equals(o);
        }
        return super.equals(o);
    }
}
