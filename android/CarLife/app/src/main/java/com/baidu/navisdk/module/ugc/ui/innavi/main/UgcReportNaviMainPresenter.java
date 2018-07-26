package com.baidu.navisdk.module.ugc.ui.innavi.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils.ScreenShotCallBack;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainContract.View;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailView;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.IOException;
import org.json.JSONObject;

public class UgcReportNaviMainPresenter implements Presenter {
    private static final int MAX_TIME_COUNT = 10;
    private static final int MSG_TIMES_COUNT_WAHT = 1;
    public static UgcReportInfoUploadPackage statusPackage = null;
    private Handler coutTimesHandler;
    private UgcImageLoaderUtils imageLoaderUtils = null;
    public boolean isIpoNavi = false;
    private boolean isTipsDynamic;
    private CallBackListener mListener;
    private ViewGroup mMenuViewContainer;
    private View mRootView = null;
    private UgcReportNaviSubDetailPresenter mSubPrensenter = null;
    private UgcLayout mUgcLayout;
    private int pageStatus = 0;
    private int parPosition;
    private UgcReportInfoUploadPackage reportInfoPackage = null;
    private int tipsPosition;

    public interface CallBackListener {
        void onUgcFinish();
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter$2 */
    class C42172 implements UgcHttpsResultCallBack {
        C42172() {
        }

        public void onUgcInfoReportUpLoadSuccess(JSONObject data) {
            int id = -1;
            String mRetTips = null;
            if (data != null) {
                try {
                    mRetTips = data.getString("tips");
                    id = data.getInt("id");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (!UgcReportNaviMainPresenter.this.isIpoNavi) {
                RouteGuideFSM.getInstance().run(RouteGuideFSM.getInstance().getEventToLastestMapState());
                if (TextUtils.isEmpty(mRetTips)) {
                    RGNotificationController.getInstance().showUgcReportSuccess("上报成功！");
                } else {
                    RGNotificationController.getInstance().showUgcReportSuccess(mRetTips);
                }
            } else if (TextUtils.isEmpty(mRetTips)) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
            } else {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
            }
            if (UgcReportNaviMainPresenter.this.isTipsDynamic) {
                UgcReportNaviMainPresenter.this.reportInfoPackage.id = id;
                UgcNaviDynamicMarkRespository.getInstance().addUgcReportInfoUploadPackage(UgcReportNaviMainPresenter.this.reportInfoPackage);
            }
            try {
                if (UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath != null) {
                    FileUtils.del(UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath);
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
            try {
                if (UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath != null) {
                    FileUtils.del(UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter$3 */
    class C42183 implements ScreenShotCallBack {
        C42183() {
        }

        public void onScreenShotCompleted(String filePath) {
            UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath = filePath;
            UgcReportNaviMainPresenter.this.realSimpleUpload();
        }
    }

    public boolean getIsTipsDynamic() {
        return this.isTipsDynamic;
    }

    public UgcReportNaviMainPresenter(View mRootView, UgcLayout mUgcLayout, CallBackListener mListener) {
        initVariable(mRootView, mListener, mUgcLayout);
    }

    private void initVariable(View mRootView, CallBackListener mListener, UgcLayout mUgcLayout) {
        this.mRootView = mRootView;
        this.mListener = mListener;
        this.mUgcLayout = mUgcLayout;
        this.pageStatus = 0;
        this.imageLoaderUtils = new UgcImageLoaderUtils();
        this.reportInfoPackage = new UgcReportInfoUploadPackage();
        mRootView.setPresenter(this);
    }

    public void setIsIpoNavi(boolean isIpoNavi) {
        this.isIpoNavi = isIpoNavi;
    }

    public boolean getIsIpoNavi() {
        return this.isIpoNavi;
    }

    public void start() {
        if (this.mRootView != null) {
            this.mRootView.initPresenterView();
        }
        statusPackage = new UgcReportInfoUploadPackage();
        if (this.isIpoNavi && this.mRootView != null) {
            this.mRootView.showIpoView();
        }
    }

    public boolean onBackPress() {
        if (this.pageStatus == 1) {
            simpleUpload();
        }
        return false;
    }

    public int parentItemsGvSize() {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getMainItemsSize();
        }
        return 0;
    }

    public void parentItemsGvImageLoader(int position, ImageView mView) {
        if (mView != null && this.imageLoaderUtils != null && this.mUgcLayout != null) {
            this.imageLoaderUtils.updateUgcViewOnLine(this.mUgcLayout.getMainItemsType(position), mView);
        }
    }

    public void parentDynamicItemsGvImageLoader(int position, ImageView mView) {
        if (mView != null && this.imageLoaderUtils != null && this.mUgcLayout != null) {
            this.imageLoaderUtils.updateUgcViewOnLine(this.mUgcLayout.getDynamicItemsType(position), mView);
        }
    }

    public String getParentItemsGvTextTile(int position) {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getMainItemsTitle(position);
        }
        return null;
    }

    public void gotoNaviSubDetailView(boolean isOrienceChange) {
        UgcLayout mUgcLayout;
        this.pageStatus = 2;
        stopTimesCounts();
        if (statusPackage == null) {
            statusPackage = new UgcReportInfoUploadPackage();
        }
        statusPackage.isInSubView = false;
        UgcReportNaviSubDetailView mUgcReportNaviSubDetailView = new UgcReportNaviSubDetailView(this.mRootView.getContext(), this.mRootView.getOrientation());
        if (this.isTipsDynamic) {
            mUgcLayout = UgcDataProvider.obtainDynamicUgcNaviSubLayout(this.tipsPosition);
        } else {
            mUgcLayout = UgcDataProvider.obtainUgcNaviSubLayout(this.tipsPosition);
        }
        if (!isOrienceChange || this.mSubPrensenter == null) {
            this.mSubPrensenter = new UgcReportNaviSubDetailPresenter(this.mRootView.getContext(), mUgcLayout, mUgcReportNaviSubDetailView, this, this.reportInfoPackage);
        } else {
            this.mSubPrensenter.setRootView(mUgcReportNaviSubDetailView);
        }
        mUgcReportNaviSubDetailView.setPresenter(this.mSubPrensenter);
        android.view.View mMenuView = mUgcReportNaviSubDetailView.getParentView();
        this.mMenuViewContainer = this.mRootView.getParentContainer();
        if (this.mMenuViewContainer != null && mMenuView != null) {
            this.mMenuViewContainer.removeAllViews();
            this.mMenuViewContainer.addView(mMenuView, new LayoutParams(-1, -1));
            if (isOrienceChange) {
                this.mSubPrensenter.onConfigurationChanged(null);
                return;
            }
            if (this.isIpoNavi) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_2, "3", null, null);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_5, "3", mUgcLayout.getSubType() + "", null);
            } else {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_2, "2", null, null);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_5, "2", mUgcLayout.getSubType() + "", null);
            }
            this.mSubPrensenter.start();
        }
    }

    public void onDestroy() {
        if (this.mSubPrensenter != null) {
            this.mSubPrensenter.onDestroy();
        }
        stopTimesCounts();
        statusPackage = null;
    }

    private ViewGroup getRootViewContainer() {
        return this.mMenuViewContainer;
    }

    public void finish() {
        if (this.mListener != null) {
            this.mListener.onUgcFinish();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.mSubPrensenter != null) {
            this.mSubPrensenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void gotoUploadView(int position, boolean isDynamic) {
        if (checkBaseRequire()) {
            if (this.isIpoNavi) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_4, "3", this.reportInfoPackage.parentType + "", null);
            } else {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_4, "2", this.reportInfoPackage.parentType + "", null);
            }
            statusPackage.mainPosition = position;
            showUploadView(position, isDynamic);
            startTimesCounts();
        }
    }

    private void showUploadView(int position, boolean isDynamic) {
        statusPackage.isInSubView = true;
        this.tipsPosition = position;
        this.isTipsDynamic = isDynamic;
        this.pageStatus = 1;
        if (this.mRootView != null) {
            this.mRootView.initUploadView();
        }
        if (isDynamic) {
            this.mRootView.hideTipItemIv();
        }
        if (this.reportInfoPackage != null && this.mUgcLayout != null) {
            if (isDynamic) {
                this.reportInfoPackage.parentType = this.mUgcLayout.getDynamicItemsType(this.tipsPosition);
                this.reportInfoPackage.mark = 1;
            } else {
                this.reportInfoPackage.parentType = this.mUgcLayout.getMainItemsType(this.tipsPosition);
            }
            statusPackage.parentType = this.reportInfoPackage.parentType;
            statusPackage.mark = this.reportInfoPackage.mark;
            statusPackage.mainPosition = this.tipsPosition;
        }
    }

    public boolean checkBaseRequire() {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            if (this.reportInfoPackage == null) {
                this.reportInfoPackage = new UgcReportInfoUploadPackage();
            }
            this.reportInfoPackage.userPoint = getCurrentLocationPoint();
            if (TextUtils.isEmpty(this.reportInfoPackage.userPoint)) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "请开启卫星定位");
                return false;
            }
            statusPackage.userPoint = this.reportInfoPackage.userPoint;
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getVehicleInfo(bundle);
            if (bundle != null) {
                try {
                    Bundle mCoordinateTransBundle = CoordinateTransformUtil.LL2MC(bundle.getDouble("vehicle_stPosX"), bundle.getDouble("vehicle_stPosY"));
                    if (mCoordinateTransBundle != null) {
                        this.reportInfoPackage.point = mCoordinateTransBundle.getInt("MCx") + "," + mCoordinateTransBundle.getInt("MCy");
                        statusPackage.point = this.reportInfoPackage.point;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
        return false;
    }

    private void startTimesCounts() {
        if (this.coutTimesHandler == null) {
            this.coutTimesHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    if (UgcReportNaviMainPresenter.this.coutTimesHandler != null) {
                        UgcReportNaviMainPresenter.this.coutTimesHandler.removeMessages(1);
                        int count = msg.arg1 - 1;
                        if (count <= 0) {
                            UgcReportNaviMainPresenter.this.mRootView.showCurTimes(count);
                            UgcReportNaviMainPresenter.this.simpleUpload();
                            return;
                        }
                        UgcReportNaviMainPresenter.this.mRootView.showCurTimes(count);
                        UgcReportNaviMainPresenter.this.coutTimesHandler.sendMessageDelayed(UgcReportNaviMainPresenter.this.coutTimesHandler.obtainMessage(1, count, 0), 1000);
                    }
                }
            };
        }
        this.mRootView.showCurTimes(10);
        this.coutTimesHandler.sendMessageDelayed(this.coutTimesHandler.obtainMessage(1, 10, 0), 1000);
    }

    private void stopTimesCounts() {
        if (this.coutTimesHandler != null) {
            this.coutTimesHandler.removeMessages(1);
            this.coutTimesHandler = null;
        }
    }

    public void realSimpleUpload() {
        if (this.isIpoNavi) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_1, "3", this.reportInfoPackage.parentType + "", null);
        } else {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_1, "2", this.reportInfoPackage.parentType + "", null);
        }
        new UgcHttps().ugcReportInfoUpLoad(this.reportInfoPackage, new C42172());
    }

    public void simpleUpload() {
        stopTimesCounts();
        new UgcHttpsUtils().addNaviInfoToPackage(this.reportInfoPackage, this.isTipsDynamic);
        if (this.reportInfoPackage.mark != 1) {
            realSimpleUpload();
        } else {
            new UgcHttpsUtils().setScreenShotParam(this.mRootView.getOrientation(), new C42183());
        }
        finish();
    }

    public int getDynamicItemsSize() {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getDynamicItemsSize();
        }
        return 0;
    }

    public String getDynamicItemsTextTitle(int index) {
        if (this.mUgcLayout != null) {
            return this.mUgcLayout.getDynamicItemsTitle(index);
        }
        return null;
    }

    public String getUploadTipsTextTitle() {
        if (this.isTipsDynamic) {
            return getDynamicItemsTextTitle(this.tipsPosition);
        }
        return getParentItemsGvTextTile(this.tipsPosition);
    }

    public void parentTipsItemsGvImageLoader(ImageView mView) {
        if (this.isTipsDynamic) {
            parentDynamicItemsGvImageLoader(this.tipsPosition, mView);
        } else {
            parentItemsGvImageLoader(this.tipsPosition, mView);
        }
    }

    public String getCurrentLocationPoint() {
        LocData curLoaction = BNSysLocationManager.getInstance().getCurLocation();
        String retStr = "";
        if (curLoaction == null) {
            return retStr;
        }
        GeoPoint mGeoPoint = curLoaction.toGeoPoint();
        if (this.reportInfoPackage == null) {
            this.reportInfoPackage = new UgcReportInfoUploadPackage();
        }
        if (statusPackage == null) {
            statusPackage = new UgcReportInfoUploadPackage();
        }
        this.reportInfoPackage.mGeoPoint = mGeoPoint;
        statusPackage.mGeoPoint = mGeoPoint;
        Bundle mBundle = CoordinateTransformUtil.LL2MC(curLoaction.longitude, curLoaction.latitude);
        if (mBundle != null) {
            return mBundle.getInt("MCx") + "," + mBundle.getInt("MCy");
        }
        return retStr;
    }

    public void orientationChanged(int orientation) {
        boolean z = true;
        if (statusPackage == null || statusPackage.parentType == -1) {
            start();
        } else if (statusPackage.mainPosition == -1 || !statusPackage.isInSubView) {
            gotoNaviSubDetailView(true);
        } else {
            int i = statusPackage.mainPosition;
            if (statusPackage.mark != 1) {
                z = false;
            }
            showUploadView(i, z);
            this.reportInfoPackage.mGeoPoint = statusPackage.mGeoPoint;
            this.reportInfoPackage.userPoint = statusPackage.userPoint;
            this.reportInfoPackage.point = statusPackage.point;
        }
    }

    public void setRootView(UgcReportNaviMainView mUgcReportMapMainView) {
        this.mRootView = mUgcReportMapMainView;
    }
}
