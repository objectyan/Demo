package com.baidu.navisdk.module.ugc.ui.inmap.sub;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.ui.SubContentPrensenter;
import com.baidu.navisdk.module.ugc.ui.SubContentView;

public class UgcReportMapSubDetailContract {

    public static abstract class Presenter extends SubContentPrensenter {
        abstract void finish();

        abstract void goback();

        abstract void hasShowOriginPage();

        abstract void hasShowSelectorPointStatus();

        abstract void informComHeight();

        abstract boolean isRoadBuild();

        abstract void showSelectorPointStatus();

        public Presenter(Context mContext, com.baidu.navisdk.module.ugc.ui.SubContentContract.View mRootView, UgcLayout mUgcLayout) {
            super(mContext, mRootView, mUgcLayout);
        }
    }

    public static abstract class View extends SubContentView {
        abstract ViewGroup getMapComPanelContainer();

        abstract boolean isSelectPointViewShowing();

        abstract void showOriginPage();

        abstract void showSelectorPointStatus();

        public View(Context mContext) {
            super(mContext);
        }
    }
}
