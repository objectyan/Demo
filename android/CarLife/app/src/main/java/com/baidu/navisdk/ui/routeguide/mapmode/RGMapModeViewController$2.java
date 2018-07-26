package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.widget.BNQuitNaviDialog.OnNaviClickListener;

class RGMapModeViewController$2 implements OnNaviClickListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$2(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onClick(int type) {
        if (type == 1) {
            this.this$0.dismissQuitNaviDialog();
            UgcNaviDynamicMarkRespository.getInstance().clear();
            BNavigator.getInstance().forceQuitWithoutDialog();
        } else if (type == 2) {
            this.this$0.dismissQuitNaviDialog();
            BNavigator.getInstance().gotoUgcRelsutPage = true;
            BNavigator.getInstance().forceQuitWithoutDialog();
        }
    }
}
