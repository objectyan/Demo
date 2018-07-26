package com.baidu.navisdk.module.ugc.ui.innavi.main;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.navisdk.module.ugc.BasePresenter;
import com.baidu.navisdk.module.ugc.BaseView;

public interface UgcReportNaviMainContract {

    public interface Presenter extends BasePresenter {
        boolean checkBaseRequire();

        void finish();

        int getDynamicItemsSize();

        String getDynamicItemsTextTitle(int i);

        boolean getIsTipsDynamic();

        String getParentItemsGvTextTile(int i);

        String getUploadTipsTextTitle();

        void gotoNaviSubDetailView(boolean z);

        void gotoUploadView(int i, boolean z);

        void parentDynamicItemsGvImageLoader(int i, ImageView imageView);

        void parentItemsGvImageLoader(int i, ImageView imageView);

        int parentItemsGvSize();

        void parentTipsItemsGvImageLoader(ImageView imageView);

        void simpleUpload();
    }

    public interface View extends BaseView<Presenter> {
        Context getContext();

        int getOrientation();

        ViewGroup getParentContainer();

        android.view.View getParentView();

        void hideTipItemIv();

        void initUploadView();

        void showCurTimes(int i);

        void showIpoView();
    }
}
