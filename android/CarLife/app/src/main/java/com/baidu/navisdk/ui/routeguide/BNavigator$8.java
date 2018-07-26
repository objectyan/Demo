package com.baidu.navisdk.ui.routeguide;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.util.common.LogUtil;

class BNavigator$8 implements OnGlobalLayoutListener {
    final /* synthetic */ BNavigator this$0;

    BNavigator$8(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void onGlobalLayout() {
        if (BNavigator.access$900(this.this$0) != null) {
            BNavigator.access$900(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            RGCacheStatus.sHeight = BNavigator.access$900(this.this$0).getHeight();
            RGCacheStatus.sWidth = BNavigator.access$900(this.this$0).getWidth();
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "updateCompassLocation onGlobalLayout()");
            this.this$0.updateCompassLocation(BNavigator.access$000(this.this$0));
        }
    }
}
