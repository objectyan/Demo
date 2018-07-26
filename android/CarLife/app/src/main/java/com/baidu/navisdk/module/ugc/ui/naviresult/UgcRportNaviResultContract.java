package com.baidu.navisdk.module.ugc.ui.naviresult;

import android.content.Context;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.ui.SubContentPrensenter;
import com.baidu.navisdk.module.ugc.ui.SubContentView;

public class UgcRportNaviResultContract {

    public static abstract class Presenter extends SubContentPrensenter {
        abstract void finish();

        abstract void gotoDtailView();

        abstract void hasShowOriginPage();

        abstract void hasShowSelectorPointStatus();

        abstract void informComHeight();

        abstract boolean isInNewRoad();

        abstract void secondUpload();

        abstract void showSelectorPointStatus();

        public Presenter(Context mContext, com.baidu.navisdk.module.ugc.ui.SubContentContract.View mRootView, UgcLayout mUgcLayout) {
            super(mContext, mRootView, mUgcLayout);
        }
    }

    public static abstract class View extends SubContentView {
        abstract boolean isSelectPointViewShowing();

        abstract void setNewRoadSelectStatus(int i);

        abstract void showNewRoadLayoutView(boolean z);

        abstract void showOriginPage();

        abstract void showPositionChangeLayout(boolean z);

        abstract void showSelectorPointStatus();

        abstract void supportScrollView();

        public View(Context mContext) {
            super(mContext);
        }
    }
}
