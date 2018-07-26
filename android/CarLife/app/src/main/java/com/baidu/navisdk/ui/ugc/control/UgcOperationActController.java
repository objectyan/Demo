package com.baidu.navisdk.ui.ugc.control;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel.UgcReportSerInfoPackage;
import com.baidu.navisdk.ui.ugc.util.PhotoCaptureUtils;
import com.baidu.navisdk.util.cache.ImageTools;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.vi.VMsgDispatcher;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class UgcOperationActController {
    public static final int MSG_UGCOPERATIONACT_DATA_REPORT_RET = 1501;
    public static final int MSG_UGCOPERATIONACT_DATA_REQUEST_RET = 1500;
    private static final int MSG_UGC_EVENT_COUNTS_RET = 1502;
    private static final int SCREEN_SHOT_HEIGH = 150;
    public static final String SCREEN_SHOT_TEMP_FILE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ugc_navi_screen_shot_temp.jpg");
    private static final int SCREEN_SHOT_WIDTH = 200;
    private static final String TAG = UgcOperationActController.class.getName();
    public static UgcOperationActController instance;
    private LinkedList<IViewPackage> CacheIamgeList = new LinkedList();
    public boolean isUgcUploading = false;
    private Handler mImageHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg != null && msg.arg1 == 0) {
                try {
                    Bitmap mBitmap = (Bitmap) msg.obj.mReq.getObj();
                    UgcOperationActController.this.updateUgcImageView(msg.what, mBitmap);
                    UgcOperationalActModel.getInstance().setUgcBitMapWithType(msg.what, mBitmap);
                } catch (Exception e) {
                    LogUtil.m15791e(UgcOperationActController.TAG, e.toString());
                }
            }
        }
    };
    private JNIBaseMap mJniBaseMap = null;
    private MsgHandler mMsgHandler = new MsgHandler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == MsgDefine.MSG_NAVI_TYPE_UGC_SCREENSHOT) {
                try {
                    if (UgcOperationActController.this.mJniBaseMap != null) {
                        Bundle bundle = new Bundle();
                        UgcOperationActController.this.mJniBaseMap.getScreenShotImage(bundle);
                        Bitmap mLockBitmap = Bitmap.createBitmap(bundle.getIntArray("pbtImageData"), bundle.getInt("unImageWidth"), bundle.getInt("unImageHeight"), Config.ARGB_8888);
                        if (mLockBitmap != null) {
                            Bitmap mCompressBitmap = PhotoCaptureUtils.compress(mLockBitmap, 600, 800);
                            if (mCompressBitmap != null && PhotoCaptureUtils.getInstance().setBitmapToFile(UgcOperationActController.SCREEN_SHOT_TEMP_FILE_PATH, mCompressBitmap)) {
                                UgcOperationalActModel.getInstance().mUgcReportSerInfoPackage.screenshotPicPath = UgcOperationActController.SCREEN_SHOT_TEMP_FILE_PATH;
                                LogUtil.m15791e(UgcOperationActController.TAG + "msg", "has map bitmap");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                UgcOperationActController.getInstance().ugcInfoReportUpLoad();
                if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
                    UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcFinish();
                }
            }
        }

        public void careAbout() {
            observe((int) MsgDefine.MSG_NAVI_TYPE_UGC_SCREENSHOT);
        }
    };
    private UgcInfoReportUpLoadResultCallBack mUgcInfoReportUpLoadResultCallBack = null;

    /* renamed from: com.baidu.navisdk.ui.ugc.control.UgcOperationActController$3 */
    class C45013 extends BNHttpTextResponseHandler {
        C45013() {
        }

        public void onSuccess(int statusCode, String responseString) {
            LogUtil.m15791e(UgcOperationActController.TAG + "mUgcRportHandler msg:", responseString);
            try {
                JSONObject retJsonObject = new JSONObject(responseString);
                if (retJsonObject.getInt(C2125n.f6745M) == 0) {
                    JSONObject dataJsonObject = retJsonObject.getJSONObject("data");
                    if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
                        UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcInfoReportUpLoadSuccess(dataJsonObject);
                    }
                } else if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
                    UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
                    UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                }
            }
            UgcOperationActController.this.isUgcUploading = false;
        }

        public void onFailure(int statusCode, String responseString, Throwable throwable) {
            if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
                UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
            }
            UgcOperationActController.this.isUgcUploading = false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.control.UgcOperationActController$5 */
    class C45035 implements Callback {
        C45035() {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            return true;
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_UGC_RCEVENT_COUNTS);
        }

        public List<NameValuePair> getRequestParams() {
            return UgcOperationActController.this.getUgcReportCountsReqParam();
        }

        public int getRequestType() {
            return 1;
        }

        public void responseImage(byte[] img) {
        }
    }

    public static class IViewPackage {
        ImageView mImageView;
        int type;

        public IViewPackage(int type, ImageView mImageView) {
            this.type = type;
            this.mImageView = mImageView;
        }

        public boolean update(int type, Bitmap mBitmap) {
            if (this.type != type) {
                return false;
            }
            if (!(this.mImageView == null || mBitmap == null)) {
                this.mImageView.setBackgroundDrawable(null);
                this.mImageView.setImageBitmap(mBitmap);
            }
            return true;
        }

        public boolean equals(int type, ImageView mImageView) {
            if (this.type == type && this.mImageView == mImageView) {
                return true;
            }
            return false;
        }
    }

    public interface UgcInfoReportUpLoadResultCallBack {
        void onUgcFinish();

        void onUgcInfoReportUpLoadFail(String str);

        void onUgcInfoReportUpLoadSuccess(JSONObject jSONObject);
    }

    private interface UgcPostHttpConstans {
        public static final String UGC_POST_HTTP_PARAM_BDUSS = "bduss";
        public static final String UGC_POST_HTTP_PARAM_BUSINESS_TRIGGER = "business_trigger";
        public static final String UGC_POST_HTTP_PARAM_CITYCODE = "cityCode";
        public static final String UGC_POST_HTTP_PARAM_CITYNAME = "cityName";
        public static final String UGC_POST_HTTP_PARAM_CONTENT = "content";
        public static final String UGC_POST_HTTP_PARAM_CUID = "cuid";
        public static final String UGC_POST_HTTP_PARAM_FROM_NAME = "from_name";
        public static final String UGC_POST_HTTP_PARAM_FROM_POINT = "from_point";
        public static final String UGC_POST_HTTP_PARAM_FROM_UID = "from_uid";
        public static final String UGC_POST_HTTP_PARAM_NAME = "name";
        public static final String UGC_POST_HTTP_PARAM_OS = "os";
        public static final String UGC_POST_HTTP_PARAM_OSV = "osv";
        public static final String UGC_POST_HTTP_PARAM_PARENT_TYPE = "parent_type";
        public static final String UGC_POST_HTTP_PARAM_PHOTO_POINT = "photo_point";
        public static final String UGC_POST_HTTP_PARAM_PIC = "pic";
        public static final String UGC_POST_HTTP_PARAM_POINT = "point";
        public static final String UGC_POST_HTTP_PARAM_SCREENSHOT_PIC = "screenshot_pic";
        public static final String UGC_POST_HTTP_PARAM_SESSION_ID = "session_id";
        public static final String UGC_POST_HTTP_PARAM_SID = "sid";
        public static final String UGC_POST_HTTP_PARAM_SIGN = "sign";
        public static final String UGC_POST_HTTP_PARAM_SUB_TYPE = "sub_type";
        public static final String UGC_POST_HTTP_PARAM_SV = "sv";
        public static final String UGC_POST_HTTP_PARAM_TO_NAME = "to_name";
        public static final String UGC_POST_HTTP_PARAM_TO_POINT = "to_point";
        public static final String UGC_POST_HTTP_PARAM_TO_UID = "to_uid";
        public static final String UGC_POST_HTTP_PARAM_UPLOAD_TYPE = "upload_type";
        public static final String UGC_POST_HTTP_PARAM_USER_POINT = "user_point";
        public static final String UGC_POST_HTTP_PARAM_VOICE = "voice";
    }

    private UgcOperationActController() {
        VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
    }

    public static UgcOperationActController getInstance() {
        if (instance == null) {
            instance = new UgcOperationActController();
        }
        return instance;
    }

    public void requestBitMapFromHttp(int what) {
        final String url = UgcOperationalActModel.getInstance().getUrlByType(what);
        if (url != null) {
            final ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mImageHandler, what, 10000);
            CmdGeneralHttpRequestFunc.addFunc(reqdata, new Callback() {
                public boolean parseResponseJSON(JSONObject jsonObj) {
                    return true;
                }

                public String getUrl() {
                    return url;
                }

                public List<NameValuePair> getRequestParams() {
                    return null;
                }

                public int getRequestType() {
                    return 2;
                }

                public void responseImage(byte[] img) {
                    if (img != null) {
                        reqdata.setObj(BitmapFactory.decodeByteArray(img, 0, img.length));
                    }
                }
            });
            CommandCenter.getInstance().sendRequest(reqdata);
        }
    }

    public void registerUgcImageView(int type, ImageView mImageView) {
        if (mImageView != null) {
            if (this.CacheIamgeList == null) {
                this.CacheIamgeList = new LinkedList();
            }
            this.CacheIamgeList.add(new IViewPackage(type, mImageView));
        }
    }

    public void unRegisterUgcImageView(int type, ImageView mImageView) {
        if (this.CacheIamgeList != null) {
            int i = 0;
            while (i < this.CacheIamgeList.size()) {
                if (((IViewPackage) this.CacheIamgeList.get(i)).equals(type, mImageView)) {
                    this.CacheIamgeList.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    public void updateUgcImageView(int type, Bitmap mBitmap) {
        if (mBitmap != null && this.CacheIamgeList != null) {
            int i = 0;
            while (i < this.CacheIamgeList.size()) {
                if (((IViewPackage) this.CacheIamgeList.get(i)).update(type, mBitmap)) {
                    this.CacheIamgeList.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    public void unRegisterAllUgcImageView() {
        if (this.CacheIamgeList != null) {
            this.CacheIamgeList.clear();
        }
    }

    public void destroy() {
        instance = null;
        this.mJniBaseMap = null;
        VMsgDispatcher.unregisterMsgHandler(this.mMsgHandler);
    }

    public void updateImageViewBGroundSrc(int type, ImageView mImageView, Handler mHandler) {
        if (mImageView != null) {
            LogUtil.m15791e("caizhirui:bitmap_type", type + "");
            if (UgcOperationalActModel.getInstance().getUgcBitMapByType(type) != null) {
                mImageView.setBackgroundDrawable(new BitmapDrawable(ImageTools.getBitmapFromResId(C4048R.drawable.ugc_default_pic)));
            } else {
                UrlDrawableContainIView.getDrawable(UgcOperationalActModel.getInstance().getUrlByType(type), UgcOperationalActModel.getInstance().getUgcDrawableIdByType(type), mImageView, mHandler);
            }
        }
    }

    public void updateImageViewBGroundSrc(int type, ImageView mImageView) {
        updateImageViewBGroundSrc(type, mImageView, null);
    }

    public void setUgcInfoReportUpLoadResultCallBack(UgcInfoReportUpLoadResultCallBack mUgcInfoReportUpLoadResultCallBack) {
        this.mUgcInfoReportUpLoadResultCallBack = mUgcInfoReportUpLoadResultCallBack;
    }

    public boolean ugcInfoReportUpLoad() {
        if (this.isUgcUploading) {
            return false;
        }
        this.isUgcUploading = true;
        BNHttpParams httpParams = new BNHttpParams();
        httpParams.isAsync = true;
        httpParams.postFileMap = new HashMap();
        UgcReportSerInfoPackage mUgcReportSerInfoPackage = UgcOperationalActModel.getInstance().mUgcReportSerInfoPackage;
        if (mUgcReportSerInfoPackage == null) {
            return true;
        }
        List<NameValuePair> params = new ArrayList();
        try {
            params.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
            params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_UPLOAD_TYPE, mUgcReportSerInfoPackage.uploadType));
            params.add(new BasicNameValuePair("sid", "1"));
            params.add(new BasicNameValuePair("os", "0"));
            params.add(new BasicNameValuePair("osv", PackageUtil.strOSVersion));
            params.add(new BasicNameValuePair("sv", PackageUtil.strSoftWareVer));
            params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYCODE, getCurrentCityId() + ""));
            params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYNAME, getUTF8Encode(GeoLocateModel.getInstance().getCurCityName())));
            params.add(new BasicNameValuePair("from_point", mUgcReportSerInfoPackage.fromPoint));
            params.add(new BasicNameValuePair("from_uid", mUgcReportSerInfoPackage.fromUid));
            params.add(new BasicNameValuePair("from_name", getUTF8Encode(mUgcReportSerInfoPackage.fromName)));
            params.add(new BasicNameValuePair("to_point", mUgcReportSerInfoPackage.toPoint));
            params.add(new BasicNameValuePair("to_uid", mUgcReportSerInfoPackage.toUid));
            params.add(new BasicNameValuePair("to_name", getUTF8Encode(mUgcReportSerInfoPackage.toName)));
            params.add(new BasicNameValuePair("business_trigger", mUgcReportSerInfoPackage.business_trigger));
            params.add(new BasicNameValuePair("name", getUTF8Encode(mUgcReportSerInfoPackage.Name)));
            params.add(new BasicNameValuePair("parent_type", mUgcReportSerInfoPackage.parentType));
            params.add(new BasicNameValuePair("sub_type", mUgcReportSerInfoPackage.subType));
            params.add(new BasicNameValuePair("content", getUTF8Encode(mUgcReportSerInfoPackage.content)));
            if (!(mUgcReportSerInfoPackage.screenshotPicPath == null || mUgcReportSerInfoPackage.screenshotPicPath.trim().equals(""))) {
                httpParams.postFileMap.put("screenshot_pic", new File(mUgcReportSerInfoPackage.screenshotPicPath));
            }
            if (!(mUgcReportSerInfoPackage.photoPicPath == null || mUgcReportSerInfoPackage.photoPicPath.trim().equals(""))) {
                httpParams.postFileMap.put("pic", new File(mUgcReportSerInfoPackage.photoPicPath));
            }
            if (!(mUgcReportSerInfoPackage.voicePath == null || mUgcReportSerInfoPackage.voicePath.trim().equals(""))) {
                httpParams.postFileMap.put("voice", new File(mUgcReportSerInfoPackage.voicePath));
            }
            params.add(new BasicNameValuePair("point", mUgcReportSerInfoPackage.point));
            params.add(new BasicNameValuePair("photo_point", mUgcReportSerInfoPackage.photoPoint));
            params.add(new BasicNameValuePair("user_point", mUgcReportSerInfoPackage.userPoint));
            params.add(new BasicNameValuePair("session_id", mUgcReportSerInfoPackage.sessionId));
            String str = CloudConfigObtainManager.SortSequenceWithAscendingOder(params);
            LogUtil.m15791e(TAG + "unsign str:", str);
            String sign = JNITrajectoryControl.sInstance.getUrlParamsSign(str) + "";
            LogUtil.m15791e(TAG + "hassign sign:", sign);
            params.add(new BasicNameValuePair("sign", sign));
            BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_UGC_OPER_INFO_REPORT), BNHttpCenterHelper.formatParams(params), new C45013(), httpParams);
            LogUtil.m15791e(TAG + "_getMultipartEntity():", params.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private int getCurrentCityId() {
        DistrictInfo district = GeoLocateModel.getInstance().getCurrentDistrict();
        if (district != null) {
            return district.mId;
        }
        return -1;
    }

    private CookieStore getCookieStore() {
        if (BNaviModuleManager.getBduss() == null) {
            return null;
        }
        BasicClientCookie cookie = new BasicClientCookie("BDUSS", BNaviModuleManager.getBduss());
        CookieStore cookieStore = new BasicCookieStore();
        cookie.setDomain(".baidu.com");
        cookie.setPath("/");
        cookie.setVersion(0);
        cookieStore.addCookie(cookie);
        return cookieStore;
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

    public String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = reader.readLine();
                if (line != null) {
                    sb.append(line + "/n");
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    is.close();
                } catch (IOException e22) {
                    e22.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    is.close();
                } catch (IOException e222) {
                    e222.printStackTrace();
                }
                throw th;
            }
        }
        is.close();
        return sb.toString();
    }

    public boolean setScreenShotParam(int mOrientation) {
        int width;
        int height;
        if (this.mJniBaseMap == null) {
            this.mJniBaseMap = new JNIBaseMap();
        }
        ScreenUtil mScreen = ScreenUtil.getInstance();
        if (mOrientation == 1) {
            width = mScreen.getWidthPixels();
            height = mScreen.getHeightPixels() - ScreenUtil.getInstance().dip2px(120);
        } else {
            width = (mScreen.getWidthPixels() * 2) / 3;
            height = mScreen.getHeightPixels();
        }
        return new JNIBaseMap().setScreenShotParam(4, width, height, 0, 0, 0);
    }

    public String getShowRCEventListUrl() {
        String cuid = PackageUtil.getCuid();
        String os = "0";
        String osv = PackageUtil.strOSVersion;
        String sv = PackageUtil.strSoftWareVer;
        List<NameValuePair> params = new ArrayList();
        StringBuffer sb = new StringBuffer();
        try {
            params.add(new BasicNameValuePair("cuid", cuid));
            sb.append("cuid=" + URLEncoder.encode(cuid, "utf-8"));
            params.add(new BasicNameValuePair("os", os));
            sb.append("&os=" + URLEncoder.encode(os, "utf-8"));
            params.add(new BasicNameValuePair("osv", osv));
            sb.append("&osv=" + URLEncoder.encode(osv, "utf-8"));
            params.add(new BasicNameValuePair("sv", osv));
            sb.append("&sv=" + URLEncoder.encode(osv, "utf-8"));
            String sign = JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder(params)) + "";
            params.add(new BasicNameValuePair("sign", sign));
            sb.append("&sign=" + URLEncoder.encode(sign, "utf-8"));
            String retUrl = HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_UGC_RCEVENT_LIST_SHOW) + "?" + sb.toString();
            LogUtil.m15791e(TAG + "getShowRCEventListUrl:", retUrl);
            return retUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getUgcReportCounts(Handler mHandler, int what) {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, mHandler, what, 10000);
            reqdata.mCookieStore = getCookieStore();
            CmdGeneralHttpRequestFunc.addFunc(reqdata, new C45035());
            CommandCenter.getInstance().sendRequest(reqdata);
        }
    }

    private List<NameValuePair> getUgcReportCountsReqParam() {
        List<NameValuePair> list;
        Exception e;
        try {
            List<NameValuePair> params = new ArrayList();
            try {
                StringBuffer sb = new StringBuffer();
                String mParam = PackageUtil.getCuid() + "";
                params.add(new BasicNameValuePair("cuid", mParam));
                sb.append("cuid=" + URLEncoder.encode(mParam, "utf-8"));
                mParam = PackageUtil.getVersionName() + "";
                params.add(new BasicNameValuePair("sv", mParam));
                sb.append("&sv=" + URLEncoder.encode(mParam, "utf-8"));
                mParam = PackageUtil.strOSVersion + "";
                params.add(new BasicNameValuePair("osv", mParam));
                sb.append("&osv=" + URLEncoder.encode(mParam, "utf-8"));
                String str = CloudConfigObtainManager.SortSequenceWithAscendingOder(params);
                LogUtil.m15791e(TAG + "unsign str:", str);
                mParam = JNITrajectoryControl.sInstance.getUrlParamsSign(str) + "";
                LogUtil.m15791e(TAG + "hassign sign:", mParam);
                params.add(new BasicNameValuePair("sign", mParam));
                sb.append("&sign=" + URLEncoder.encode(mParam, "utf-8"));
                LogUtil.m15791e(TAG + "params:", sb.toString());
                list = params;
                return params;
            } catch (Exception e2) {
                e = e2;
                list = params;
                e.printStackTrace();
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return null;
        }
    }
}
