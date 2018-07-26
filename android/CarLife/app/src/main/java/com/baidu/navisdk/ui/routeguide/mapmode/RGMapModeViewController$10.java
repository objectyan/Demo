package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.jar.JarUtils;

class RGMapModeViewController$10 implements OnNaviClickListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$10(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onClick() {
        TipTool.onCreateToastDialog(RGMapModeViewController.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_open_gps));
    }
}
