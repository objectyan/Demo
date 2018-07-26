package com.baidu.navisdk.ui.routeguide;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

class BNavigator$29 extends Handler {
    final /* synthetic */ BNavigator this$0;

    BNavigator$29(BNavigator this$0, Looper x0) {
        this.this$0 = this$0;
        super(x0);
    }

    public void handleMessage(Message msg) {
        if (msg.what == 1006) {
            RGViewController.getInstance().dismissAvoidTrafficLoading();
            if (msg.arg1 == 0) {
                ArrayList<SearchParkPoi> list = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchParkPoi();
                if (list == null || list.size() == 0) {
                    RGControlPanelModel.getInstance().setmIsParkSearching(false);
                    if (BNavigator.access$400(this.this$0)) {
                        BNavigator.access$402(this.this$0, false);
                        return;
                    } else {
                        TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_park_not_found));
                        return;
                    }
                }
                RGParkPointModel.getInstance().setDoneWithParkSearch(true);
                if (RGControlPanelModel.getInstance().ismIsParkSearching()) {
                    BNavigator.access$2600(this.this$0, 0);
                    return;
                }
                return;
            }
            RGControlPanelModel.getInstance().setmIsParkSearching(false);
            if (BNavigator.access$400(this.this$0)) {
                BNavigator.access$402(this.this$0, false);
            } else {
                TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_park_not_found));
            }
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "search park fail");
        } else if (msg.what != 1005) {
        } else {
            if (BNavigator.access$2700(this.this$0)) {
                BNavigator.access$2702(this.this$0, false);
                BNavigator.access$2800(this.this$0, msg);
                return;
            }
            this.this$0.handleRouteSearch(msg);
            if (BNavigator.access$1700(this.this$0) != null) {
                BNavigator.access$1700(this.this$0).onRoutePlan();
            }
            BNavigator.access$2902(this.this$0, true);
        }
    }
}
