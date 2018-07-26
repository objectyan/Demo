package com.baidu.navisdk.ui.routeguide.mapmode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.baidu.navisdk.util.common.LogUtil;

class RGMapModeViewController$1 implements OnCancelListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$1(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onCancel(DialogInterface dialog) {
        LogUtil.m15791e("RoutePlan", "mUgcDetailViewShowProgress onCancel!");
    }
}
