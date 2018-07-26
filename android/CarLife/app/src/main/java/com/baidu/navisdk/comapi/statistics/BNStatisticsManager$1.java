package com.baidu.navisdk.comapi.statistics;

import com.baidu.navisdk.util.common.LogUtil;

class BNStatisticsManager$1 implements Runnable {
    final /* synthetic */ BNStatisticsManager this$0;

    BNStatisticsManager$1(BNStatisticsManager this$0) {
        this.this$0 = this$0;
    }

    public void run() {
        LogUtil.m15791e("MapGesture", "stat map scale task:  > 5s, scale " + BNStatisticsManager.access$000(this.this$0));
    }
}
