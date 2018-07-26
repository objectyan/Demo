package com.baidu.navisdk.module.routereport;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.module.routereport.BNRouteReportModel.CurrentRouteReportModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BNRouteReportController {
    public static final int BUSINESS_TRIGGER_AFTER_NAVI = 4;
    public static final int BUSINESS_TRIGGER_BEFORE_NAVI = 7;
    public static final int MSG_ROUTE_REPORT_UPLOAD_RET = 257;
    public static final int ROUTE_REPORT_AFTER_NAVI = 2;
    public static final int ROUTE_REPORT_BEFORE_NAVI = 1;
    private static final String TAG = BNRouteReportController.class.getSimpleName();
    private static int logMsgCount = 0;
    private boolean isIntentBeforeNavi;
    private boolean isUploading;
    private WeakReference<Activity> mActivityRef;
    private int mIntentType;
    private Handler mReportHandler;
    private BNRouteReportModel model;
    private BNRouteReportUI view;
    private BNRouteReportCallback wrapperCallback;
    private boolean yellowBarClosedForThisLaunch;

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportController$2 */
    class C41722 extends BNHttpTextResponseHandler {
        C41722() {
        }

        public void onSuccess(int statusCode, String responseString) {
            try {
                JSONObject retJsonObject = new JSONObject(responseString);
                LogUtil.m15791e(BNRouteReportController.TAG, "handleMessage: ret --> " + retJsonObject);
                if (retJsonObject.getInt(C2125n.f6745M) == 0) {
                    JSONObject dataJsonObject = retJsonObject.getJSONObject("data");
                    if (BNRouteReportController.this.getActivity() != null) {
                        TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), dataJsonObject.getString("tips"));
                    }
                } else if (BNRouteReportController.this.getActivity() != null) {
                    TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                }
            } catch (JSONException e) {
                LogUtil.m15791e(BNRouteReportController.TAG, "handleMessage: --> JSONException");
                if (BNRouteReportController.this.getActivity() != null) {
                    TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                }
            }
            try {
                if (BNRouteReportController.this.model.getUploadingVoiceFilePath() != null) {
                    FileUtils.del(BNRouteReportController.this.model.getUploadingVoiceFilePath());
                    BNRouteReportController.this.model.setUploadingVoiceFilePath(null);
                }
            } catch (Throwable th) {
            }
            try {
                if (BNRouteReportController.this.model.getUploadingImgFilePath() != null) {
                    FileUtils.del(BNRouteReportController.this.model.getUploadingImgFilePath());
                    BNRouteReportController.this.model.setUploadingImgFilePath(null);
                }
            } catch (Throwable th2) {
            }
            BNRouteReportController.this.isUploading = false;
        }

        public void onFailure(int statusCode, String responseString, Throwable throwable) {
            LogUtil.m15791e(BNRouteReportController.TAG, "handleMessage: Error --> " + responseString);
            if (BNRouteReportController.this.getActivity() != null) {
                TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
            }
            try {
                if (BNRouteReportController.this.model.getUploadingVoiceFilePath() != null) {
                    FileUtils.del(BNRouteReportController.this.model.getUploadingVoiceFilePath());
                    BNRouteReportController.this.model.setUploadingVoiceFilePath(null);
                }
            } catch (Throwable th) {
            }
            try {
                if (BNRouteReportController.this.model.getUploadingImgFilePath() != null) {
                    FileUtils.del(BNRouteReportController.this.model.getUploadingImgFilePath());
                    BNRouteReportController.this.model.setUploadingImgFilePath(null);
                }
            } catch (Throwable th2) {
            }
            BNRouteReportController.this.isUploading = false;
        }
    }

    public interface BNRouteReportCallback {
        public static final int TYPE_AUDIO_AUTH_REQUEST = 2;
        public static final int TYPE_BACK = 1;
        public static final int TYPE_HIDE_PROMPT_DIALOG = 5;
        public static final int TYPE_PIN_ANIM_DOWN = 10;
        public static final int TYPE_PIN_ANIM_UP = 9;
        public static final int TYPE_RESET_PROMPT_DIALOG = 8;
        public static final int TYPE_SCROLL_UP = 11;
        public static final int TYPE_SET_NEED_PROJECTION = 6;
        public static final int TYPE_SET_NO_PROJECTION = 7;
        public static final int TYPE_SET_PROMPT_DIALOG_STATE_ADDR = 12;
        public static final int TYPE_SHOW_PROMPT_DIALOG = 4;
        public static final int TYPE_SUBMIT = 3;

        void onAction(int i);
    }

    private static class LazyLoader {
        private static BNRouteReportController instance = new BNRouteReportController();

        private LazyLoader() {
        }
    }

    private BNRouteReportController() {
        this.mActivityRef = null;
        this.view = null;
        this.wrapperCallback = null;
        this.model = null;
        this.isIntentBeforeNavi = true;
        this.isUploading = false;
        this.yellowBarClosedForThisLaunch = false;
        this.mReportHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                if (msg != null && msg.what == 257) {
                    if (msg.arg1 == 0) {
                        try {
                            JSONObject retJsonObject = ((RspData) msg.obj).mData;
                            LogUtil.m15791e(BNRouteReportController.TAG, "handleMessage: ret --> " + retJsonObject);
                            if (retJsonObject.getInt(C2125n.f6745M) == 0) {
                                JSONObject dataJsonObject = retJsonObject.getJSONObject("data");
                                if (BNRouteReportController.this.getActivity() != null) {
                                    TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), dataJsonObject.getString("tips"));
                                }
                            } else if (BNRouteReportController.this.getActivity() != null) {
                                TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                            }
                        } catch (JSONException e) {
                            LogUtil.m15791e(BNRouteReportController.TAG, "handleMessage: --> JSONException");
                            if (BNRouteReportController.this.getActivity() != null) {
                                TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                            }
                        }
                    } else {
                        LogUtil.m15791e(BNRouteReportController.TAG, "handleMessage: Error --> " + msg.toString());
                        if (BNRouteReportController.this.getActivity() != null) {
                            TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
                        }
                    }
                    try {
                        if (BNRouteReportController.this.model.getUploadingVoiceFilePath() != null) {
                            FileUtils.del(BNRouteReportController.this.model.getUploadingVoiceFilePath());
                            BNRouteReportController.this.model.setUploadingVoiceFilePath(null);
                        }
                    } catch (Throwable th) {
                    }
                    try {
                        if (BNRouteReportController.this.model.getUploadingImgFilePath() != null) {
                            FileUtils.del(BNRouteReportController.this.model.getUploadingImgFilePath());
                            BNRouteReportController.this.model.setUploadingImgFilePath(null);
                        }
                    } catch (Throwable th2) {
                    }
                    BNRouteReportController.this.isUploading = false;
                }
            }
        };
        this.model = BNRouteReportModel.getInstance();
    }

    public static BNRouteReportController getInstance() {
        return LazyLoader.instance;
    }

    public void reset() {
        LogUtil.m15791e(TAG, "reset: -->> Data Reset!");
        if (this.view != null) {
            this.view.onDestroy();
            this.view = null;
        }
    }

    public void release() {
        this.model.reset();
        this.yellowBarClosedForThisLaunch = false;
    }

    public View creatUI(Activity activity, int intentType, boolean isNavigateBack) {
        boolean z = true;
        this.mIntentType = intentType;
        if (intentType != 1) {
            z = false;
        }
        this.isIntentBeforeNavi = z;
        this.mActivityRef = new WeakReference(activity);
        this.view = new BNRouteReportUI(activity, isNavigateBack);
        BNRouteReportModel.getInstance().resetCurrentReportModel();
        BNRouteReportModel.getInstance().getCurrentRouteReportModel().isIntentBeforeNavi = this.isIntentBeforeNavi;
        return this.view.getRootView();
    }

    public void registerWrapperCallback(BNRouteReportCallback callback) {
        this.wrapperCallback = callback;
    }

    public Activity getActivity() {
        return (Activity) this.mActivityRef.get();
    }

    public RelativeLayout getMapPanelContainer() {
        if (this.view == null) {
            return null;
        }
        return this.view.getMapPanelContainer();
    }

    public ViewGroup getSelectionPointerContainer() {
        if (this.view == null) {
            return null;
        }
        return this.view.getSelectionPointerContainer();
    }

    public int[] getTopAndBottomHeightDp() {
        if (this.view == null) {
            return null;
        }
        return this.view.getTopAndBottomHeightDp();
    }

    public void onWrapperAction(int type) {
        if (this.wrapperCallback != null) {
            this.wrapperCallback.onAction(type);
        }
    }

    public void updateYellowBarState(int yawPointsCount) {
        if (this.view != null) {
            this.view.updateYellowBarState(yawPointsCount);
        }
    }

    public void onClickConfirm(Bundle data) {
        this.model.setAddrResult(data);
        this.view.nextState(true);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.view.onActivityResult(requestCode, resultCode, data);
    }

    public void parseRouteReportItemJson(JSONArray jsonArray, int intentType) {
        this.model.parseRouteReportItemJson(jsonArray, intentType);
    }

    public boolean upload() {
        LogUtil.m15791e(TAG, "upload: isUploading --> " + this.isUploading);
        if (this.isUploading) {
            return false;
        }
        this.isUploading = true;
        BNHttpParams httpParams = new BNHttpParams();
        httpParams.isAsync = true;
        httpParams.postFileMap = new HashMap();
        List<NameValuePair> params = new ArrayList();
        CurrentRouteReportModel currentRouteReportModel = this.model.getCurrentRouteReportModel();
        LogUtil.m15791e(TAG, "getMultipartEntity: currentRouteReportModel --> " + currentRouteReportModel);
        boolean isIntentBeforeNavi = currentRouteReportModel.isIntentBeforeNavi;
        try {
            params.add(new BasicNameValuePair("user_point", currentRouteReportModel.userPoint));
            params.add(new BasicNameValuePair("point", currentRouteReportModel.point));
            params.add(new BasicNameValuePair("business_trigger", "" + (isIntentBeforeNavi ? 7 : 4)));
            params.add(new BasicNameValuePair("parent_type", currentRouteReportModel.parentType));
            if (currentRouteReportModel.subType != null) {
                params.add(new BasicNameValuePair("sub_type", currentRouteReportModel.subType));
            }
            if (!isIntentBeforeNavi) {
                String guid = JNITrajectoryControl.sInstance.getCurrentUUID();
                if (TextUtils.isEmpty(guid)) {
                    logLocalDataError("guid: " + guid);
                } else {
                    params.add(new BasicNameValuePair("guid", guid));
                }
            }
            if (!TextUtils.isEmpty(currentRouteReportModel.content)) {
                params.add(new BasicNameValuePair("content", getUTF8Encode(currentRouteReportModel.content)));
            }
            if (!TextUtils.isEmpty(currentRouteReportModel.photoPicPath)) {
                this.model.setUploadingImgFilePath(currentRouteReportModel.photoPicPath);
                httpParams.postFileMap.put("pic", new File(currentRouteReportModel.photoPicPath));
            }
            if (!TextUtils.isEmpty(currentRouteReportModel.voicePath)) {
                this.model.setUploadingVoiceFilePath(currentRouteReportModel.voicePath);
                httpParams.postFileMap.put("voice", new File(currentRouteReportModel.voicePath));
            }
            params.add(new BasicNameValuePair("os", "0"));
            params.add(new BasicNameValuePair("osv", PackageUtil.strOSVersion));
            params.add(new BasicNameValuePair("sv", PackageUtil.strSoftWareVer));
            params.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
            params.add(new BasicNameValuePair("name", getUTF8Encode(currentRouteReportModel.roadName)));
            Bundle bundle = new Bundle();
            BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl(bundle);
            String sessionId = bundle.getString("session");
            if (TextUtils.isEmpty(sessionId)) {
                logLocalDataError("sessionId: " + sessionId);
            } else {
                params.add(new BasicNameValuePair("session_id", sessionId));
            }
            if (isIntentBeforeNavi) {
                String mrsl = bundle.getString(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_MRSL);
                if (TextUtils.isEmpty(mrsl)) {
                    logLocalDataError("mrsl: " + mrsl);
                } else {
                    params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_MRSL, mrsl));
                }
            }
            RoutePlanModel routePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
            RoutePlanNode rpNodeStart = routePlanModel.getStartNode();
            if (rpNodeStart != null) {
                String fromPoint = ll2mcStr((double) (((float) rpNodeStart.getLongitudeE6()) / 100000.0f), (double) (((float) rpNodeStart.getLatitudeE6()) / 100000.0f));
                if (fromPoint != null) {
                    params.add(new BasicNameValuePair("from_point", fromPoint));
                } else {
                    logLocalDataError("startNode: lonE6: " + rpNodeStart.getLongitudeE6() + ", latE6: " + rpNodeStart.getLatitudeE6());
                }
                String fromName = rpNodeStart.getName();
                if (fromName != null) {
                    params.add(new BasicNameValuePair("from_name", getUTF8Encode(fromName)));
                }
                String fromUid = rpNodeStart.getUID();
                if (fromUid != null) {
                    params.add(new BasicNameValuePair("from_uid", fromUid));
                }
            }
            RoutePlanNode rpNodeEnd = routePlanModel.getEndNode();
            if (rpNodeEnd != null) {
                String toPoint = ll2mcStr((double) (((float) rpNodeEnd.getLongitudeE6()) / 100000.0f), (double) (((float) rpNodeEnd.getLatitudeE6()) / 100000.0f));
                if (toPoint != null) {
                    params.add(new BasicNameValuePair("to_point", toPoint));
                } else {
                    logLocalDataError("startNode: lonE6: " + rpNodeStart.getLongitudeE6() + ", latE6: " + rpNodeStart.getLatitudeE6());
                }
                String toName = rpNodeEnd.getName();
                if (toName != null) {
                    params.add(new BasicNameValuePair("to_name", getUTF8Encode(toName)));
                }
                String toUid = rpNodeEnd.getUID();
                if (toUid != null) {
                    params.add(new BasicNameValuePair("to_uid", toUid));
                }
            }
            int cityId = GeoLocateModel.getInstance().getCurrentCityId();
            if (cityId != Integer.MIN_VALUE) {
                params.add(new BasicNameValuePair("cityid", "" + cityId));
            }
            String cityName = GeoLocateModel.getInstance().getCurCityName();
            if (cityName != null) {
                params.add(new BasicNameValuePair("city_name", getUTF8Encode(cityName)));
            }
            params.add(new BasicNameValuePair("sign", JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder(params)) + ""));
            BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_ROUTE_REPORT_UPLOAD), BNHttpCenterHelper.formatParams(params), new C41722(), httpParams);
            LogUtil.m15791e(TAG, "getMultipartEntity: params --> " + params.toString());
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "getMultipartEntity: --> UnsupportedEncodingException");
        }
        return true;
    }

    private void logLocalDataError(String logMsg) {
        if (LogUtil.LOGGABLE) {
            String str = TAG;
            StringBuilder append = new StringBuilder().append("logLocalDataError: ");
            int i = logMsgCount;
            logMsgCount = i + 1;
            LogUtil.m15791e(str, append.append(i).append(" --> ").append(logMsg).toString());
        }
    }

    public static String ll2mcStr(double longitude, double latitude) {
        if (longitude == -2.147483648E9d || latitude == -2.147483648E9d) {
            return null;
        }
        Bundle mBundle = CoordinateTransformUtil.LL2MC(longitude, latitude);
        if (mBundle != null) {
            return mBundle.getInt("MCx") + "," + mBundle.getInt("MCy");
        }
        return null;
    }

    private String getUTF8Encode(String str) {
        String ret = "";
        if (str != null) {
            try {
                ret = URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
            }
        }
        return ret;
    }

    public void onResume() {
        if (this.view != null) {
            this.view.onResume();
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

    public boolean isUploading() {
        return this.isUploading;
    }

    public void setUploading(boolean uploading) {
        this.isUploading = uploading;
    }

    public boolean isYellowBarClosedForThisLaunch() {
        return this.yellowBarClosedForThisLaunch;
    }

    public void setYellowBarClosedForThisLaunch(boolean yellowBarClosedForThisLaunch) {
        this.yellowBarClosedForThisLaunch = yellowBarClosedForThisLaunch;
    }

    public int getIntentType() {
        return this.mIntentType;
    }

    public boolean isIntentBeforeNavi() {
        return this.isIntentBeforeNavi;
    }

    public static void setupUrlDrawable(ImageView imgView, int defaultResId, final String url) {
        if (imgView != null) {
            if (defaultResId < 0) {
                defaultResId = C4048R.drawable.navi_result_car_logo_default;
            }
            UrlDrawableContainIView.getDrawable(url, defaultResId, imgView, new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 8192 && msg.arg1 != 0) {
                        LogUtil.m15791e(BNRouteReportController.TAG, "setupUrlDrawable: Fail --> url: " + url);
                    }
                }
            });
        }
    }
}
