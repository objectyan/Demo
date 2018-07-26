package com.baidu.navisdk.ui.routeguide.mapmode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;

class RGMapModeViewController$22 implements OnCancelListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$22(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onCancel(DialogInterface dialog) {
        RGViewController.getInstance().showReCalRouteQuitDialog();
    }
}
