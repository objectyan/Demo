package com.baidu.navisdk.ui.routeguide.mapmode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class RGMapModeViewController$17 implements OnCancelListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$17(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onCancel(DialogInterface dialog) {
        RGMapModeViewController.access$200(this.this$0).onCancelLoading();
    }
}
