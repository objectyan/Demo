package com.baidu.navisdk.module.ugc.ui.inmap.main;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.module.ugc.BasePresenter;
import com.baidu.navisdk.module.ugc.BaseView;

public interface UgcReportMapMainContract {

    public interface Presenter extends BasePresenter {
        String getParentItemsGvTextTile(int i);

        void gotoMapSubDetailView(int i);

        void gotoUgcMapApi(String str);

        void gotoUgcMapH5Page(int i);

        void gotoUgcMapH5Page(String str);

        void informUserToRegister();

        void initUserInfo(TextView textView);

        void onUgcBackPressed();

        void parentItemsGvImageLoader(int i, ImageView imageView);

        int parentItemsGvSize();

        void performCheckDetailBtn();

        void setOnlineImageLoader(int i, ImageView imageView, String str);
    }

    public interface View extends BaseView<Presenter> {
        void setUserInfoLayoutvisibile(boolean z);

        void showUserUnRegister();

        void showUserUploadCounts(int i);
    }
}
