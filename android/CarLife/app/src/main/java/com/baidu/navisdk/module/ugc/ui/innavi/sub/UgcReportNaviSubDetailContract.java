package com.baidu.navisdk.module.ugc.ui.innavi.sub;

import android.content.Context;
import android.view.MotionEvent;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.ui.SubContentPrensenter;
import com.baidu.navisdk.module.ugc.ui.SubContentView;

public interface UgcReportNaviSubDetailContract {

    public static abstract class Presenter extends SubContentPrensenter {
        abstract void comUpload();

        abstract void mainContentOnTouch(MotionEvent motionEvent);

        abstract void simpleUpload();

        public Presenter(Context mContext, com.baidu.navisdk.module.ugc.ui.SubContentContract.View mRootView, UgcLayout mUgcLayout) {
            super(mContext, mRootView, mUgcLayout);
        }
    }

    public static abstract class View extends SubContentView {
        abstract int getOrientation();

        abstract void hideSubTitleIv();

        abstract void showCurTimes(int i);

        abstract void showIpoNaviView();

        public View(Context mContext) {
            super(mContext);
        }

        public View(Context mContext, int mOrientation) {
            super(mContext, mOrientation);
        }
    }
}
