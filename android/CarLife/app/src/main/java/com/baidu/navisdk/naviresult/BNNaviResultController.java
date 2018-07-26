package com.baidu.navisdk.naviresult;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostFunc.Callback;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class BNNaviResultController {
    public static final int CONFIG_VIEW_MODE_INFLATE_MAP = 0;
    public static final int CONFIG_VIEW_MODE_NOT_INFLATE_MAP = 1;
    public static final int Mark_From_GUIDE = 2;
    public static final int Mark_From_Nav_end = 1;
    private static final int PREF_DEFAULT_CURRENT_PROGRESS = 10;
    private static final int PREF_DEFAULT_MARKETING_DIALOG_ID = -1;
    private static final int PREF_DEFAULT_MARKETING_DIALOG_LOCAL_SHOWED_TIMES = 0;
    private static final String PREF_KEY_CHECK_RIGHTS_LINK = "navi_result_check_rights_link";
    private static final String PREF_KEY_CHECK_RIGHTS_TIPS = "navi_result_check_rights_tips";
    private static final String PREF_KEY_CURRENT_PROGRESS = "navi_result_current_progress";
    private static final String PREF_KEY_MARKETING_DIALOG_ID = "navi_result_dialog_id";
    private static final String PREF_KEY_MARKETING_DIALOG_LOCAL_SHOWED_TIMES = "navi_result_dialog_local_showed_times";
    private static final String TAG = BNNaviResultController.class.getSimpleName();
    public static int pRGViewMode = 1;
    private NaviResultWrapperCallback callback;
    private DataDownloadState imgDataState;
    private boolean isGpsFixed;
    public boolean isMarkFavourite;
    private boolean isNaviResultShowing;
    private boolean isRemainInfoRecorded;
    private MsgHandler mMsgHandler;
    private BNNaviResultModel model;
    private DataDownloadState textDataState;
    private BNNaviResultView view;

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultController$2 */
    class C42402 implements Callback {
        C42402() {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            try {
                LogUtil.m15791e(BNNaviResultController.TAG, "parseUploadJSON() markFavouriteTrajectory --> " + jsonObj.toString() + "   errno: " + jsonObj.getInt(C2125n.f6745M));
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_MARK_FAVOURITE);
        }

        public List<NameValuePair> getRequestParams() {
            try {
                List<NameValuePair> params = new ArrayList();
                params.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
                params.add(new BasicNameValuePair("guid", JNITrajectoryControl.sInstance.getCurrentUUID()));
                params.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
                params.add(new BasicNameValuePair("os", "2"));
                String ascendParamStr = CloudConfigObtainManager.SortSequenceWithAscendingOder(params);
                String tmpS = JNITrajectoryControl.sInstance.getUrlParamsSign(ascendParamStr);
                if (TextUtils.isEmpty(tmpS)) {
                    tmpS = "";
                }
                params.add(new BasicNameValuePair("sign", tmpS));
                LogUtil.m15791e(BNNaviResultController.TAG, "getRequestParams() markFavouriteTrajectory --> " + ascendParamStr);
                return params;
            } catch (Exception e) {
                return null;
            }
        }

        public int getRequestType() {
            return 1;
        }

        public void responseImage(byte[] img) {
        }
    }

    public enum DataDownloadState {
        NONE,
        DOWNLOADING,
        DOWNLOAD_FINISH,
        DOWNLOAD_CANCEL
    }

    public enum DataDownloadType {
        TXT_DATA,
        IMG_DATA
    }

    private static class LazyLoader {
        private static BNNaviResultController instance = new BNNaviResultController();

        private LazyLoader() {
        }
    }

    public interface NaviResultWrapperCallback {
        void goToUgcCompletePage();

        boolean isLoggedIn();

        void jumpToHistoryPage();

        void jumpToLoginPage(boolean z);

        void jumpToReportFragment();

        void onBackPressedTitleBar();

        void onLoadingEnd();

        void onLoadingStart();

        void openWithOpenAPI(String str);

        void openWithOpenAPINoTitleBar(String str);

        void shareNavi(String str, String str2, String str3, String str4);

        void startWalkNavi();
    }

    private BNNaviResultController() {
        this.view = null;
        this.model = null;
        this.callback = null;
        this.textDataState = DataDownloadState.NONE;
        this.imgDataState = DataDownloadState.NONE;
        this.isGpsFixed = false;
        this.isRemainInfoRecorded = false;
        this.isNaviResultShowing = false;
        this.isMarkFavourite = false;
        this.mMsgHandler = new MsgHandler(Looper.getMainLooper()) {
            public void careAbout() {
                observe(4107);
                observe(4116);
                observe(4153);
            }

            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 4107:
                        if (BNNaviResultController.this.isGpsFixed && !BNNaviResultController.this.isRemainInfoRecorded) {
                            BNNaviResultController.this.isRemainInfoRecorded = true;
                            BNNaviResultController.this.model.setEstimatedRemainDist(msg.arg1);
                            BNNaviResultController.this.model.setEstimatedRemainTimeMillis((long) (msg.arg2 * 1000));
                            LogUtil.m15791e(BNNaviResultController.TAG, "handleMessage: -->> remainDis: " + msg.arg1 + ", remainTimeSecs: " + msg.arg2);
                            return;
                        }
                        return;
                    case 4116:
                        LogUtil.m15791e(BNNaviResultController.TAG, "handleMessage: -->> MSG_NAVI_GPS_STATUS_CHANGE");
                        if (msg.arg1 == 1) {
                            BNNaviResultController.this.isGpsFixed = true;
                            return;
                        }
                        return;
                    case 4153:
                        LogUtil.m15791e(BNNaviResultController.TAG, "handleMessage: -->> MSG_NAVI_Satellite_Fix_Success_Update");
                        BNNaviResultController.this.isGpsFixed = true;
                        return;
                    default:
                        return;
                }
            }
        };
        this.model = BNNaviResultModel.getInstance();
    }

    public static BNNaviResultController getInstance() {
        return LazyLoader.instance;
    }

    public View creatView(Activity activity, MapGLSurfaceView nmapView, boolean isNavigateBack) {
        PerformStatisticsController.peByType(8, "nav_result_create_time", System.currentTimeMillis());
        if (this.view == null) {
            this.view = new BNNaviResultView();
        }
        this.view.creatView(activity, nmapView, isNavigateBack);
        return this.view.getRootView();
    }

    public boolean preloadResultView(Activity activity) {
        if (this.view == null) {
            this.view = new BNNaviResultView();
        }
        return this.view.preloadView(activity);
    }

    public boolean hasPreloadView() {
        if (this.view != null && this.view.hasPreloaded()) {
            return true;
        }
        return false;
    }

    public void setCallback(NaviResultWrapperCallback callback) {
        this.callback = callback;
    }

    public void onResume() {
        if (this.view != null) {
            this.view.onResume();
            PerformStatisticsController.peByType(8, "nav_result_resume_time", System.currentTimeMillis());
            if (PerformStatItem.sUserTest) {
                PerformStatisticsController.peDiffByType(8);
            }
        }
    }

    public void onPause() {
        if (this.view != null) {
            this.view.onPause();
        }
    }

    public void onDestroy() {
        if (this.view != null) {
            this.view.onDestroy();
            this.view = null;
        }
    }

    public void reset() {
        LogUtil.m15791e(TAG, "reset: -->> Data Reset!");
        if (this.view != null) {
            this.view.onDestroy();
            this.view = null;
        }
        this.textDataState = DataDownloadState.NONE;
        this.imgDataState = DataDownloadState.NONE;
        this.isGpsFixed = false;
        this.isRemainInfoRecorded = false;
        this.isNaviResultShowing = false;
        this.isMarkFavourite = false;
        this.model.reset();
        BusinessActivityManager.getInstance().releaseAllRes();
        VMsgDispatcher.unregisterMsgHandler(this.mMsgHandler);
        BNNaviResultView.theLastBannerShowTime = false;
        setCallback(null);
    }

    public boolean onBackPressed() {
        if (this.view == null) {
            return false;
        }
        return this.view.onBackPressed();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (this.view != null) {
            this.view.onConfigurationChanged(newConfig);
        }
    }

    public void openWithOpenAPI(String url) {
        if (this.callback != null) {
            this.callback.openWithOpenAPI(url);
        }
    }

    public void openWithOpenAPINoTitleBar(String url) {
        if (this.callback != null) {
            this.callback.openWithOpenAPINoTitleBar(url);
        }
    }

    public void jumpToHistoryPage() {
        if (this.callback != null) {
            this.callback.jumpToHistoryPage();
        }
    }

    public void startWalkNavi() {
        if (this.callback != null) {
            this.callback.startWalkNavi();
        }
    }

    public void jumpToLoginPage(boolean needsBack) {
        if (this.callback != null) {
            this.callback.jumpToLoginPage(needsBack);
        }
    }

    public void jumpToReportFragment() {
        if (this.callback != null) {
            this.callback.jumpToReportFragment();
        }
    }

    public void onBackPressedTitleBar() {
        if (this.callback != null) {
            this.callback.onBackPressedTitleBar();
        }
    }

    public void shareNavi(String linkUrl, String imgUrl, String title, String desc) {
        if (this.callback != null) {
            this.callback.shareNavi(linkUrl, imgUrl, title, desc);
        }
    }

    public boolean isLoggedIn() {
        if (this.callback != null) {
            return this.callback.isLoggedIn();
        }
        return false;
    }

    public void onLoadingStart() {
        if (this.callback != null) {
            this.callback.onLoadingStart();
        }
    }

    public void onLoadingEnd() {
        if (this.callback != null) {
            this.callback.onLoadingEnd();
        }
    }

    public void goToUgcCompletePage() {
        if (this.callback != null) {
            this.callback.goToUgcCompletePage();
        }
    }

    public void backFromLogin(boolean loginSuccessful) {
        LogUtil.m15791e(TAG, "backFromLogin: loginSuccessful -->> " + loginSuccessful);
    }

    public void registerVMsgHandler() {
        VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
    }

    public boolean setSavedTime(TextView savedTimeIcon, TextView savedTimeTv, TextView savedTimeTypeTv) {
        if (savedTimeIcon == null || savedTimeTv == null || savedTimeTypeTv == null) {
            return false;
        }
        if (!this.model.isDestArrived()) {
            LogUtil.m15791e(TAG, "setSavedTime: -->> Dest has not be reached");
            return false;
        } else if (this.model.getEstimatedRemainTimeMillis() == 0) {
            LogUtil.m15791e(TAG, "setSavedTime: -->> Not GPS");
            return false;
        } else {
            long totalTimeMillis = this.model.getTotalTimeSecs() * 1000;
            long ertMillis = this.model.getEstimatedRemainTimeMillis();
            long totalMinusErtMillis = totalTimeMillis - ertMillis;
            LogUtil.m15791e(TAG, "setSavedTime: --> totalTimeMillis: " + totalTimeMillis + ", ertMillis: " + ertMillis + ", totalMinusErtMillis: " + totalMinusErtMillis);
            if (Math.abs(totalMinusErtMillis) < 60000) {
                LogUtil.m15791e(TAG, "setSavedTime: case -->> 1");
                savedTimeIcon.setText("准");
                savedTimeIcon.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_navi_result_saved_time_icon_bg_green));
                savedTimeTv.setText("神预估");
                savedTimeTypeTv.setText("准时到达");
                return true;
            } else if (totalMinusErtMillis < 0) {
                LogUtil.m15791e(TAG, "setSavedTime: case -->> 2");
                savedTimeIcon.setText("顺");
                savedTimeIcon.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_navi_result_saved_time_icon_bg_green));
                savedTimeTv.setText(((int) ((((float) (-totalMinusErtMillis)) / 60.0f) / 1000.0f)) + "分");
                savedTimeTypeTv.setText("比预计快");
                return true;
            } else if (totalMinusErtMillis <= 0) {
                return false;
            } else {
                LogUtil.m15791e(TAG, "setSavedTime: estimateRemain * 10% -->> " + (((double) ertMillis) * 0.1d));
                if (((double) totalMinusErtMillis) > ((double) this.model.getEstimatedRemainTimeMillis()) * 0.1d) {
                    LogUtil.m15791e(TAG, "setSavedTime: case -->> 5");
                    savedTimeIcon.setText("堵");
                    savedTimeIcon.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_navi_result_saved_time_icon_bg_red));
                    savedTimeTv.setText(((int) ((((float) totalMinusErtMillis) / 60.0f) / 1000.0f)) + "分");
                    savedTimeTypeTv.setText("比预计晚");
                    return true;
                } else if (totalMinusErtMillis < 600000) {
                    LogUtil.m15791e(TAG, "setSavedTime: case -->> 3");
                    savedTimeIcon.setText("准");
                    savedTimeIcon.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_navi_result_saved_time_icon_bg_green));
                    savedTimeTv.setText("神预估");
                    savedTimeTypeTv.setText("准时到达");
                    return true;
                } else {
                    LogUtil.m15791e(TAG, "setSavedTime: case -->> 4");
                    savedTimeIcon.setText("堵");
                    savedTimeIcon.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_navi_result_saved_time_icon_bg_red));
                    savedTimeTv.setText(((int) ((((float) totalMinusErtMillis) / 60.0f) / 1000.0f)) + "分");
                    savedTimeTypeTv.setText("比预计晚");
                    return true;
                }
            }
        }
    }

    public void notifyServerDataDownloadState(DataDownloadType type, DataDownloadState state) {
        LogUtil.m15791e(TAG, "notifyServerDataDownloadState: -->> type: " + type + ", state: " + state);
        switch (type) {
            case TXT_DATA:
                setTextDataState(state);
                if (this.view != null && this.view.isFindViewsFinished() && state == DataDownloadState.DOWNLOAD_FINISH) {
                    this.view.setupViewAfterDownloadFinish();
                    return;
                } else if (this.view != null) {
                    LogUtil.m15791e(TAG, "notifyServerDataDownloadState: view.isFindViewsFinished() -->> " + this.view.isFindViewsFinished());
                    return;
                } else {
                    return;
                }
            case IMG_DATA:
                setImgDataState(state);
                if (this.view != null && this.view.isFindViewsFinished() && state == DataDownloadState.DOWNLOAD_FINISH) {
                    this.view.updateViewOnRightsLabelIconDataArrived();
                    return;
                } else if (this.view != null) {
                    LogUtil.m15791e(TAG, "notifyServerDataDownloadState: view.isFindViewsFinished() -->> " + this.view.isFindViewsFinished());
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void resetLocalMarketingData(Context context) {
        setLocalMarketingDialogId(context, -1);
        setLocalMarketingDialogShowedTimes(context, 0);
    }

    public void resetLocalMarketingDialogShowedTimes(Context context) {
        setLocalMarketingDialogShowedTimes(context, 0);
    }

    public int getLocalMarketingDialogId(Context context) {
        int result = -1;
        if (context != null) {
            result = PreferenceHelper.getInstance(context).getInt(PREF_KEY_MARKETING_DIALOG_ID, -1);
        }
        LogUtil.m15791e(TAG, "getLocalMarketingDialogId: result -->> " + result);
        return result;
    }

    public void setLocalMarketingDialogId(Context context, int newId) {
        if (context != null) {
            PreferenceHelper.getInstance(context).putInt(PREF_KEY_MARKETING_DIALOG_ID, newId);
            LogUtil.m15791e(TAG, "setLocalMarketingDialogId: newId -->> " + newId);
        }
    }

    public int getLocalMarketingDialogShowedTimes(Context context) {
        int result = 0;
        if (context != null) {
            result = PreferenceHelper.getInstance(context).getInt(PREF_KEY_MARKETING_DIALOG_LOCAL_SHOWED_TIMES, 0);
        }
        LogUtil.m15791e(TAG, "getLocalMarketingDialogShowedTimes: result -->> " + result);
        return result;
    }

    public void setLocalMarketingDialogShowedTimes(Context context, int newShowedTimes) {
        if (context != null) {
            PreferenceHelper.getInstance(context).putInt(PREF_KEY_MARKETING_DIALOG_LOCAL_SHOWED_TIMES, newShowedTimes);
            LogUtil.m15791e(TAG, "setLocalMarketingDialogShowedTimes: newShowedTimes -->> " + newShowedTimes);
        }
    }

    public Drawable getDrawableFromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new BitmapDrawable(bitmap);
        } catch (Throwable th) {
            LogUtil.m15791e(TAG, "getDrawableFromBitmap: Error (bitmap = " + bitmap + ") -->> return null");
            return null;
        }
    }

    public void updateShowWalkNaviState(boolean showWalkNavi, int walkNaviRemainDist) {
        this.model.setShowWalkNavi(showWalkNavi);
        this.model.setWalkNaviRemainDist(walkNaviRemainDist);
    }

    public static int getWalkNaviRemainDist() {
        if (!BNSysLocationManager.getInstance().isSysLocationValid()) {
            return -1;
        }
        LocData locData = BNSysLocationManager.getInstance().getCurLocation();
        RoutePlanNode rpNodeEnd = ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getEndNode();
        if (rpNodeEnd == null || rpNodeEnd.getLatitudeE6() == Integer.MIN_VALUE || rpNodeEnd.getLongitudeE6() == Integer.MIN_VALUE || locData == null || locData.longitude == -1.0d || locData.latitude == -1.0d) {
            return -1;
        }
        int sphereDist = getSphereDisFromCurPoint2RpNodeEnd(locData, rpNodeEnd);
        LogUtil.m15791e(TAG, "getWalkNaviRemainDist: --> sphereDist: " + sphereDist);
        return sphereDist;
    }

    private static int getSphereDisFromCurPoint2RpNodeEnd(LocData locData, RoutePlanNode rpNodeEnd) {
        if (locData == null || rpNodeEnd == null) {
            return -1;
        }
        return (int) StringUtils.geoSphereDistance(locData.longitude * 100000.0d, locData.latitude * 100000.0d, (double) rpNodeEnd.getLongitudeE6(), (double) rpNodeEnd.getLatitudeE6());
    }

    public static boolean needsToShowWalkNavi(int walkNaviDis) {
        boolean isWithinWalkDistance = isWithinWalkingDistance(walkNaviDis);
        boolean isTrueGPSMode;
        if (BNavConfig.pRGLocateMode != 2) {
            isTrueGPSMode = true;
        } else {
            isTrueGPSMode = false;
        }
        if (isWithinWalkDistance && isTrueGPSMode) {
            return true;
        }
        return false;
    }

    public static boolean isWithinWalkingDistance(int remainDist) {
        return remainDist >= 50 && remainDist <= 1000;
    }

    public void getShareData(Handler handler, int msgNum) {
        BusinessActivityManager.getInstance().getShareData(handler, msgNum);
    }

    public DataDownloadState getTextDataState() {
        return this.textDataState;
    }

    public void setTextDataState(DataDownloadState textDataState) {
        this.textDataState = textDataState;
    }

    public DataDownloadState getImgDataState() {
        return this.imgDataState;
    }

    public void setImgDataState(DataDownloadState imgDataState) {
        this.imgDataState = imgDataState;
    }

    public boolean isNaviResultShowing() {
        return this.isNaviResultShowing;
    }

    public void setNaviResultShowing(boolean isNaviResultShowing) {
        this.isNaviResultShowing = isNaviResultShowing;
    }

    public void markFavouriteTrajectory(Handler handler, int from) {
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPPOST_FUNC, 7, handler, BusinessActivityManager.MSG_NAV_END_MARK_TRAJECTORY_RET, 5000);
        reqdata.mCookieStore = BusinessActivityManager.getInstance().getCookieStore();
        Bundle bd = new Bundle();
        bd.putInt("FROM", from);
        reqdata.setObj(bd);
        CmdGeneralHttpPostFunc.addFunc(reqdata, new C42402());
        CommandCenter.getInstance().sendRequest(reqdata);
    }
}
