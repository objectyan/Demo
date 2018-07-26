package com.baidu.platform.comapi.util;

import com.baidu.mapframework.nirvana.looper.LooperTask;

class BMEventBus$3 extends LooperTask {
    final /* synthetic */ BMEventBus this$0;
    final /* synthetic */ Object val$obj;

    BMEventBus$3(BMEventBus this$0, long x0, Object obj) {
        this.this$0 = this$0;
        this.val$obj = obj;
        super(x0);
    }

    public void run() {
        this.this$0.postSticky(this.val$obj);
    }
}
