package com.baidu.navisdk.ui.routeguide.mapmode;

import android.content.Intent;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

class RGMapModeViewController$11 implements OnNaviClickListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$11(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onClick() {
        try {
            RGMapModeViewController.access$000(this.this$0).startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception e) {
            LogUtil.m15791e("", e.toString());
            TipTool.onCreateToastDialog(RGMapModeViewController.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_no_gps));
        }
    }
}
