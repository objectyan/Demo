package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;

class RGHUDControlView$1 implements OnDismissListener {
    final /* synthetic */ RGHUDControlView this$0;

    RGHUDControlView$1(RGHUDControlView this$0) {
        this.this$0 = this$0;
    }

    public void onDismiss(DialogInterface dialog) {
        BNMapController.getInstance().onResume();
    }
}
