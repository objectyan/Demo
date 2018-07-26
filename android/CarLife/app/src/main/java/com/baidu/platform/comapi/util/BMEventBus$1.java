package com.baidu.platform.comapi.util;

import com.baidu.mapframework.nirvana.looper.LooperTask;

class BMEventBus$1 extends LooperTask {
    final /* synthetic */ BMEventBus this$0;
    final /* synthetic */ BMEventBus$ModuleOnEvent val$listener;
    final /* synthetic */ Object val$obj;

    BMEventBus$1(BMEventBus this$0, BMEventBus$ModuleOnEvent bMEventBus$ModuleOnEvent, Object obj) {
        this.this$0 = this$0;
        this.val$listener = bMEventBus$ModuleOnEvent;
        this.val$obj = obj;
    }

    public void run() {
        BMEventBus.access$000(this.this$0, this.val$listener, this.val$obj);
    }
}
