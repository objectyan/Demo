package com.baidu.navisdk.module.ugc.ui.innavi.sub;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils.ScreenShotCallBack;
import com.baidu.navisdk.module.ugc.ui.SubContentContract;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailContract.View;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.IOException;
import org.json.JSONObject;

public class UgcReportNaviSubDetailPresenter extends Presenter {
    private static final int MAX_TIME_COUNT = 10;
    private static final int MSG_TIMES_COUNT_WAHT = 256;
    private Handler coutTimesHandler = null;
    private boolean hasStopCount = false;
    private UgcImageLoaderUtils imageLoaderUtils;
    private View mRootView;
    private UgcReportNaviMainPresenter parPresenter;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailPresenter$2 */
    class C42232 implements UgcHttpsResultCallBack {
        C42232() {
        }

        public void onUgcInfoReportUpLoadSuccess(JSONObject data) {
            String mRetTips = null;
            if (data != null) {
                try {
                    mRetTips = data.getString("tips");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (UgcReportNaviSubDetailPresenter.this.parPresenter != null && !UgcReportNaviSubDetailPresenter.this.parPresenter.getIsIpoNavi()) {
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
            try {
                if (UgcReportNaviSubDetailPresenter.this.infoPackage.voicePath != null) {
                    FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.voicePath);
                }
                if (UgcReportNaviSubDetailPresenter.this.infoPackage.photoPicPath != null) {
                    FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.photoPicPath);
                }
                if (UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath != null) {
                    FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath);
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
                if (UgcReportNaviSubDetailPresenter.this.infoPackage.voicePath != null) {
                    FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.voicePath);
                }
                if (UgcReportNaviSubDetailPresenter.this.infoPackage.photoPicPath != null) {
                    FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.photoPicPath);
                }
                if (UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath != null) {
                    FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailPresenter$3 */
    class C42243 implements ScreenShotCallBack {
        C42243() {
        }

        public void onScreenShotCompleted(String filePath) {
            UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath = filePath;
            UgcReportNaviSubDetailPresenter.this.realComUpload();
        }
    }

    public UgcReportNaviSubDetailPresenter(Context context, UgcLayout mUgcLayout, View mUgcReportNaviSubDetailView, UgcReportNaviMainPresenter parPresenter, UgcReportInfoUploadPackage parPackage) {
        super(context, mUgcReportNaviSubDetailView, mUgcLayout);
        this.mRootView = mUgcReportNaviSubDetailView;
        this.parPresenter = parPresenter;
        this.imageLoaderUtils = new UgcImageLoaderUtils();
        this.mRootView.setPresenter((SubContentContract.Presenter) this);
        if (!(parPackage == null || this.infoPackage == null)) {
            this.infoPackage.parentType = parPackage.parentType;
            this.infoPackage.mark = parPackage.mark;
            this.infoPackage.userPoint = parPackage.userPoint;
            this.infoPackage.point = parPackage.point;
        }
        if (this.infoPackage.mark == 1) {
            this.mRootView.hideSubTitleIv();
        }
    }

    public void start() {
        super.start();
        if (this.mRootView != null) {
            this.mRootView.initPresenterView();
        }
        startTimesCounts();
        if (this.parPresenter != null && this.mRootView != null && this.parPresenter.getIsIpoNavi()) {
            this.mRootView.showIpoNaviView();
        }
    }

    private void startTimesCounts() {
        if (this.coutTimesHandler == null && !this.hasStopCount) {
            if (this.coutTimesHandler == null) {
                this.coutTimesHandler = new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message msg) {
                        if (UgcReportNaviSubDetailPresenter.this.coutTimesHandler != null) {
                            UgcReportNaviSubDetailPresenter.this.coutTimesHandler.removeMessages(256);
                            int count = msg.arg1 - 1;
                            if (count <= 0) {
                                UgcReportNaviSubDetailPresenter.this.mRootView.showCurTimes(count);
                                UgcReportNaviSubDetailPresenter.this.simpleUpload();
                                return;
                            }
                            UgcReportNaviSubDetailPresenter.this.mRootView.showCurTimes(count);
                            UgcReportNaviSubDetailPresenter.this.coutTimesHandler.sendMessageDelayed(UgcReportNaviSubDetailPresenter.this.coutTimesHandler.obtainMessage(256, count, 0), 1000);
                        }
                    }
                };
            }
            this.mRootView.showCurTimes(10);
            this.coutTimesHandler.sendMessageDelayed(this.coutTimesHandler.obtainMessage(256, 10, 0), 1000);
        }
    }

    public void simpleUpload() {
        stopTimesCounts();
        if (this.parPresenter != null) {
            this.parPresenter.simpleUpload();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void realComUpload() {
        boolean z = true;
        UgcHttpsUtils ugcHttpsUtils = new UgcHttpsUtils();
        UgcReportInfoUploadPackage ugcReportInfoUploadPackage = this.infoPackage;
        if (this.infoPackage.mark != 1) {
            z = false;
        }
        ugcHttpsUtils.addNaviInfoToPackage(ugcReportInfoUploadPackage, z);
        this.infoPackage.mark = 0;
        new UgcHttps().ugcReportInfoUpLoad(this.infoPackage, new C42232());
    }

    public void comUpload() {
        if (this.mRootView != null && this.infoPackage != null) {
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                stopTimesCounts();
                if (this.infoPackage.mark != 1) {
                    realComUpload();
                } else {
                    new UgcHttpsUtils().setScreenShotParam(this.mRootView.getOrientation(), new C42243());
                }
                if (this.parPresenter != null) {
                    this.parPresenter.finish();
                    return;
                }
                return;
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void mainContentOnTouch(MotionEvent event) {
        stopTimesCounts();
    }

    private void stopTimesCounts() {
        if (this.coutTimesHandler != null) {
            this.coutTimesHandler.removeMessages(256);
            this.coutTimesHandler = null;
        }
        this.hasStopCount = true;
    }

    public void informRubPointAdsorb(String point, String address) {
        this.mRootView.showAddrInfoUpdate(address, null);
        if (UgcReportNaviMainPresenter.statusPackage != null) {
            UgcReportNaviMainPresenter.statusPackage.name = address;
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.infoPackage.mark == 1 && this.mRootView != null) {
            this.mRootView.hideSubTitleIv();
        }
    }

    public void setRootView(View mRootView) {
        super.setRootView(mRootView);
        this.mRootView = mRootView;
    }

    public boolean onBackPress() {
        simpleUpload();
        return true;
    }
}
