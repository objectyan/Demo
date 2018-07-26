package com.baidu.navisdk.module.ugc.ui.naviresult;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository.NaviDynamicMark;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.ui.SubContentContract;
import com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultContract.View;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.IOException;
import org.json.JSONObject;

public class UgcRportNaviResultPresenter extends Presenter {
    private boolean hasInformComHeight = false;
    private UgcImageLoaderUtils imageLoaderUtils;
    private boolean isInNewRoad = false;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg != null && msg.what == 1003 && msg.arg1 == 0) {
                SearchPoi poi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getAntiGeoPoi();
                if (poi != null && poi.mAddress.length() > 0 && UgcRportNaviResultPresenter.this.mRootView != null && UgcRportNaviResultPresenter.this.infoPackage != null) {
                    UgcRportNaviResultPresenter.this.mRootView.showAddrInfoUpdate(poi.mAddress, null);
                }
            }
        }
    };
    private View mRootView;
    private UgcLayout mUgcLayout;
    private UgcSubDetailCallback mUgcReportCallback;
    private NaviDynamicMark naviDynamicMark;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultPresenter$1 */
    class C42271 implements UgcHttpsResultCallBack {
        C42271() {
        }

        public void onUgcInfoReportUpLoadSuccess(JSONObject data) {
            String mRetTips = "上报成功！";
            if (data != null) {
                try {
                    mRetTips = data.getString("tips");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), mRetTips);
            UgcNaviDynamicMarkRespository.getInstance().removeId(UgcRportNaviResultPresenter.this.infoPackage.id);
            UgcNaviDynamicMarkRespository.getInstance().removeUploadingId(UgcRportNaviResultPresenter.this.infoPackage.id);
            if (UgcRportNaviResultPresenter.this.mUgcReportCallback != null) {
                UgcRportNaviResultPresenter.this.mUgcReportCallback.onUpLoadMsgCallBack(true);
            }
            try {
                if (UgcRportNaviResultPresenter.this.infoPackage.voicePath != null) {
                    FileUtils.del(UgcRportNaviResultPresenter.this.infoPackage.voicePath);
                }
                if (UgcRportNaviResultPresenter.this.infoPackage.photoPicPath != null) {
                    FileUtils.del(UgcRportNaviResultPresenter.this.infoPackage.photoPicPath);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public void onUgcInfoReportUpLoadFail(String reson) {
            if (reson != null) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), reson);
            } else {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
            }
            UgcNaviDynamicMarkRespository.getInstance().removeUploadingId(UgcRportNaviResultPresenter.this.infoPackage.id);
            if (UgcRportNaviResultPresenter.this.mUgcReportCallback != null) {
                UgcRportNaviResultPresenter.this.mUgcReportCallback.onUpLoadMsgCallBack(false);
            }
            try {
                if (UgcRportNaviResultPresenter.this.infoPackage.voicePath != null) {
                    FileUtils.del(UgcRportNaviResultPresenter.this.infoPackage.voicePath);
                }
                if (UgcRportNaviResultPresenter.this.infoPackage.photoPicPath != null) {
                    FileUtils.del(UgcRportNaviResultPresenter.this.infoPackage.photoPicPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public interface UgcSubDetailCallback {
        void onBackBtnPress();

        void onBackDetailView();

        void onUpLoadCompleted();

        void onUpLoadMsgCallBack(boolean z);
    }

    public void onAddrInfoUpdate(String addr, String addrDesc) {
        if (TextUtils.isEmpty(addr)) {
            addr = TrackDataShop.SPECIAL_ADDR_IN_TRACK;
        }
    }

    public void onPointSelected(double x, double y) {
    }

    public boolean isInNewRoad() {
        return this.isInNewRoad;
    }

    public UgcRportNaviResultPresenter(Context mContext, SubContentContract.View mRootView, UgcLayout mUgcLayout, UgcSubDetailCallback mUgcReportCallback, NaviDynamicMark mNaviDynamicMark) {
        super(mContext, mRootView, mUgcLayout);
        this.mRootView = (View) mRootView;
        this.mContext = mContext;
        this.mUgcReportCallback = mUgcReportCallback;
        this.imageLoaderUtils = new UgcImageLoaderUtils();
        this.naviDynamicMark = mNaviDynamicMark;
        this.mUgcLayout = mUgcLayout;
        recordUploadInfo(mNaviDynamicMark);
        mRootView.setPresenter(this);
    }

    private void recordUploadInfo(NaviDynamicMark mNaviDynamicMark) {
        if (this.infoPackage != null && mNaviDynamicMark != null) {
            this.infoPackage.parentType = mNaviDynamicMark.type;
            this.infoPackage.id = mNaviDynamicMark.id;
            this.infoPackage.userPoint = mNaviDynamicMark.f19709x + "," + mNaviDynamicMark.f19710y;
            this.infoPackage.mGeoPoint = mNaviDynamicMark.mGeoPoint;
        }
    }

    private static UgcLayout getLayout(NaviDynamicMark mNaviDynamicMark) {
        if (mNaviDynamicMark == null) {
            return null;
        }
        return UgcDataProvider.obtainDynamicUgcNaviSubLayout(mNaviDynamicMark.type);
    }

    public void start() {
        super.start();
        this.isInNewRoad = this.infoPackage.parentType == 1;
        if (this.mRootView != null) {
            this.mRootView.initPresenterView();
            if (this.isInNewRoad) {
                this.mRootView.supportScrollView();
                this.mRootView.showNewRoadLayoutView(true);
            } else {
                this.mRootView.showNewRoadLayoutView(false);
            }
        }
        if (this.infoPackage != null && this.infoPackage.mGeoPoint != null) {
            int netMode = 1;
            if (!(BNaviModuleManager.getActivity() == null || NetworkUtils.isNetworkAvailable(BNaviModuleManager.getActivity()))) {
                netMode = 0;
            }
            BNPoiSearcher.getInstance().asynGetPoiByPoint(this.infoPackage.mGeoPoint, netMode, 3000, this.mHandler);
        }
    }

    private void showOriginPage() {
        if (this.mRootView != null) {
            this.mRootView.showOriginPage();
        }
    }

    public void hasShowOriginPage() {
        if (this.mUgcReportCallback == null) {
        }
    }

    public void showSelectorPointStatus() {
        if (this.mRootView != null && !this.mRootView.isSelectPointViewShowing()) {
            this.mRootView.showSelectorPointStatus();
        }
    }

    public void hasShowSelectorPointStatus() {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.onBackDetailView();
        }
    }

    public boolean onBackPress() {
        if (this.mRootView.isSelectPointViewShowing() || !this.isInNewRoad) {
            return false;
        }
        gotoDtailView();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void secondUpload() {
        if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
        } else if (this.isInNewRoad && (TextUtils.isEmpty(this.infoPackage.startPoint) || TextUtils.isEmpty(this.infoPackage.endPoint))) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "请选择起点和终点");
        } else {
            new UgcHttpsUtils().addNaviResultInfoToPackge(this.infoPackage);
            new UgcHttps().ugcReportInfoUpLoad(this.infoPackage, new C42271());
            UgcNaviDynamicMarkRespository.getInstance().addUploadingDynamicMark(this.naviDynamicMark);
            finish();
        }
    }

    public void finish() {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.onUpLoadCompleted();
        }
    }

    public void informRubPointAdsorb(String point, String address) {
    }

    public void setNewRoadSelectStatus(int status, double x, double y, String roadName) {
        if (this.infoPackage != null) {
            if (this.mRootView != null) {
                this.mRootView.setNewRoadSelectStatus(status);
            }
            switch (status) {
                case 0:
                    return;
                case 1:
                    this.infoPackage.startPoint = x + "," + y;
                    this.infoPackage.startName = roadName;
                    return;
                case 2:
                    this.infoPackage.endPoint = x + "," + y;
                    this.infoPackage.endName = roadName;
                    return;
                default:
                    return;
            }
        }
    }

    public void informComHeight() {
        if (!this.hasInformComHeight) {
            this.hasInformComHeight = true;
            if (this.isInNewRoad) {
                showSelectorPointStatus();
            }
        }
    }

    public void gotoDtailView() {
        this.mUgcReportCallback.onBackDetailView();
    }
}
