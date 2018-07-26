package com.baidu.navisdk.module.ugc.ui.inmap.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.ui.inmap.main.UgcReportMapMainContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.inmap.main.UgcReportMapMainContract.View;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.ugc.control.UgcOperationActController;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel.UgcBaseDataModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

public class UgcReportMapMainPresenter implements Presenter, Serializable {
    private static final long serialVersionUID = -4117642688886118172L;
    private UgcImageLoaderUtils imageLoaderUtils = null;
    public ArrayList<UgcBaseDataModel> mMapUgcDataList = null;
    private View mRootView = null;
    private UgcLayout mUgcLayout = null;
    private UgcReportCallback mUgcReportCallback = null;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.inmap.main.UgcReportMapMainPresenter$1 */
    class C42061 implements UgcHttpsResultCallBack {
        C42061() {
        }

        public void onUgcInfoReportUpLoadSuccess(JSONObject data) {
            try {
                int count = data.getInt("count");
                if (count >= 0 && UgcReportMapMainPresenter.this.mRootView != null) {
                    UgcReportMapMainPresenter.this.mRootView.showUserUploadCounts(count);
                }
            } catch (Exception e) {
            }
        }

        public void onUgcInfoReportUpLoadFail(String reson) {
            UgcReportMapMainPresenter.this.mRootView.showUserUnRegister();
        }
    }

    public interface UgcReportCallback {
        void onGotoMapSubDetailView(int i);

        void onOpenApi(String str);

        void onShowH5Page(String str);

        void onUgcBtnClick(int i);

        void onUgcFinish();
    }

    public UgcReportMapMainPresenter(View mRootView, UgcLayout mUgcLayout, UgcReportCallback mUgcReportCallback) {
        this.mRootView = mRootView;
        this.mUgcReportCallback = mUgcReportCallback;
        this.mUgcLayout = mUgcLayout;
        this.imageLoaderUtils = new UgcImageLoaderUtils();
        mRootView.setPresenter(this);
    }

    public void start() {
        if (this.mRootView != null) {
            this.mRootView.initPresenterView();
        }
    }

    public void gotoMapSubDetailView(int position) {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.onGotoMapSubDetailView(position);
        }
    }

    public int parentItemsGvSize() {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getMainItemsSize();
        }
        return 0;
    }

    public void parentItemsGvImageLoader(int position, ImageView mView) {
        if (this.imageLoaderUtils != null && this.mUgcLayout != null) {
            this.imageLoaderUtils.updateUgcViewOnLine(true, this.mUgcLayout.getMainItemsType(position), mView);
        }
    }

    public void setOnlineImageLoader(int type, ImageView mView, String url) {
        if (this.imageLoaderUtils != null && this.mUgcLayout != null) {
            this.imageLoaderUtils.updateUgcViewOnLine(type, mView, url);
        }
    }

    public String getParentItemsGvTextTile(int position) {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getMainItemsTitle(position);
        }
        return null;
    }

    public void gotoUgcMapH5Page(String url) {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.onShowH5Page(url);
        }
    }

    public void gotoUgcMapApi(String url) {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.onOpenApi(url);
        }
    }

    public void performCheckDetailBtn() {
        if (this.mUgcReportCallback != null) {
            gotoUgcMapH5Page(UgcOperationActController.getInstance().getShowRCEventListUrl());
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_4, "1", "94", null);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onResume() {
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onUgcBackPressed() {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.onUgcFinish();
        }
    }

    public void onDestroy() {
    }

    public void initUserInfo(TextView mView) {
        if (TextUtils.isEmpty(BNaviModuleManager.getBduss())) {
            this.mRootView.showUserUnRegister();
        } else {
            getUserInfoFromNet();
        }
    }

    public void gotoUgcMapH5Page(int position) {
        try {
            gotoUgcMapH5Page(((UgcDataRepository.UgcBaseDataModel) UgcDataRepository.getInstance().obtainMapFeedBackDataList().get(position)).iconUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginStatusChange() {
        if (TextUtils.isEmpty(BNaviModuleManager.getBduss())) {
            LogUtil.m15791e("loginStatusChange:", "no login");
            return;
        }
        LogUtil.m15791e("loginStatusChange:", "has login");
        getUserInfoFromNet();
    }

    private void getUserInfoFromNet() {
        new UgcHttps().getUgcUserInfo(new C42061());
    }

    public void informUserToRegister() {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.onUgcBtnClick(6);
        }
    }
}
