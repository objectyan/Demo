package com.baidu.navisdk.comapi.mapcontrol;

import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.model.params.MsgDefine;

class BNMapController$1 extends MsgHandler {
    final /* synthetic */ BNMapController this$0;

    BNMapController$1(BNMapController this$0, Looper looper) {
        this.this$0 = this$0;
        super(looper);
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 4097:
            case MsgDefine.MSG_NAVI_LEVEL_UPDATE /*4611*/:
                this.this$0.notifyObservers(1, 274, null);
                return;
            case MsgDefine.MSG_NAVI_TRAFFICLAYER_NEED_REFRESH /*4138*/:
                this.this$0.UpdataBaseLayers();
                return;
            case MsgDefine.MSG_MAP_GLRENDER /*4196*/:
                this.this$0.notifyObservers(1, 275, msg);
                return;
            case 4200:
                this.this$0.notifyObservers(1, 259, Integer.valueOf(msg.arg2));
                return;
            case 4201:
                this.this$0.notifyObservers(1, 260, msg);
                return;
            default:
                return;
        }
    }

    public void careAbout() {
        observe(4200);
        observe(4097);
        observe((int) MsgDefine.MSG_MAP_GLRENDER);
        observe((int) MsgDefine.MSG_NAVI_TRAFFICLAYER_NEED_REFRESH);
        observe(4201);
        observe((int) MsgDefine.MSG_NAVI_LEVEL_UPDATE);
    }
}
