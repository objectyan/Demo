package com.baidu.navisdk.util.logic;

import com.baidu.navisdk.debug.commonui.DebugCommonUICallback;
import com.baidu.navisdk.debug.commonui.DebugCommonUIView.DebugViewKeyValueData;
import java.util.ArrayList;
import java.util.List;

class BNSysLocationManager$1 implements DebugCommonUICallback {
    final /* synthetic */ BNSysLocationManager this$0;

    BNSysLocationManager$1(BNSysLocationManager this$0) {
        this.this$0 = this$0;
    }

    public List<DebugViewKeyValueData> getKeyValues() {
        List<DebugViewKeyValueData> datas = new ArrayList();
        datas.add(new DebugViewKeyValueData("定位开关|状态", (BNSysLocationManager.access$000(this.this$0) ? "开 | " : "关 | ") + BNSysLocationManager.access$100(this.this$0)));
        datas.add(new DebugViewKeyValueData("GPS状态", this.this$0.getGPSStatusDebugString()));
        datas.add(new DebugViewKeyValueData("卫星搜索|可用", String.valueOf(BNSysLocationManager.access$200(this.this$0)) + " | " + String.valueOf(BNSysLocationManager.access$300(this.this$0))));
        datas.add(new DebugViewKeyValueData("定位器|启动监听", (BNSysLocationManager.access$400(this.this$0) != null ? "1" : "0") + " | " + (BNSysLocationManager.access$500(this.this$0) ? "1" : "0")));
        return datas;
    }

    public String getInfo() {
        return null;
    }
}
