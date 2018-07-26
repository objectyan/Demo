package com.baidu.navisdk.module.ugc.https;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class UgcHttps {
    public static final int MSG_RUBPOINT_ADSORB_OBTAIN_RET = 5378;
    public static final int MSG_UGCREPORT_INFO_OBTAIN_RET = 5377;
    public static final int MSG_UGCREPORT_INFO_UPLOAD_RET = 5376;
    private static final String TAG = "UgcHttps";
    private UgcHttpsResultCallBack mCallBack = null;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg != null) {
                LogUtil.m15791e("UgcHttps mHandler msg:", msg.toString());
                UgcHttpsResultCallBack mUgcUpLoadResultCallBack = null;
                RspData mRspData = null;
                try {
                    mRspData = (RspData) msg.obj;
                    mUgcUpLoadResultCallBack = (UgcHttpsResultCallBack) mRspData.mReq.getObj();
                } catch (Exception e) {
                }
                if (mUgcUpLoadResultCallBack == null) {
                    mUgcUpLoadResultCallBack = UgcHttps.this.mCallBack;
                }
                JSONObject retJsonObject;
                if (msg.what == UgcHttps.MSG_UGCREPORT_INFO_UPLOAD_RET) {
                    if (msg.arg1 == 0) {
                        try {
                            retJsonObject = (JSONObject) mRspData.mData;
                            if (retJsonObject.getInt(C2125n.f6745M) == 0) {
                                mUgcUpLoadResultCallBack.onUgcInfoReportUpLoadSuccess(retJsonObject.getJSONObject("data"));
                            } else {
                                mUgcUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (mUgcUpLoadResultCallBack != null) {
                                mUgcUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                            }
                        }
                    } else if (mUgcUpLoadResultCallBack != null) {
                        mUgcUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
                    }
                } else if (msg.what == UgcHttps.MSG_UGCREPORT_INFO_OBTAIN_RET) {
                    if (msg.arg1 == 0) {
                        try {
                            retJsonObject = (JSONObject) mRspData.mData;
                            if (retJsonObject.getInt(C2125n.f6745M) == 0) {
                                mUgcUpLoadResultCallBack.onUgcInfoReportUpLoadSuccess(retJsonObject.getJSONObject("data"));
                            }
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    }
                } else if (msg.what != UgcHttps.MSG_RUBPOINT_ADSORB_OBTAIN_RET) {
                } else {
                    if (msg.arg1 == 0) {
                        try {
                            retJsonObject = (JSONObject) mRspData.mData;
                            if (retJsonObject.getInt(C2125n.f6745M) == 0) {
                                mUgcUpLoadResultCallBack.onUgcInfoReportUpLoadSuccess(retJsonObject.getJSONObject("data"));
                            } else {
                                mUgcUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                            }
                        } catch (Exception e222) {
                            e222.printStackTrace();
                            if (mUgcUpLoadResultCallBack != null) {
                                mUgcUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                            }
                        }
                    } else if (mUgcUpLoadResultCallBack != null) {
                        mUgcUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.navisdk.module.ugc.https.UgcHttps$3 */
    class C41953 implements Callback {
        C41953() {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            return true;
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_UGC_RCEVENT_COUNTS);
        }

        public List<NameValuePair> getRequestParams() {
            return UgcHttps.this.getUgcReportCountsReqParam();
        }

        public int getRequestType() {
            return 1;
        }

        public void responseImage(byte[] img) {
        }
    }

    public interface UgcHttpsResultCallBack {
        void onUgcInfoReportUpLoadFail(String str);

        void onUgcInfoReportUpLoadSuccess(JSONObject jSONObject);
    }

    private interface UgcPostHttpConstans {
        public static final String UGC_POST_HTTP_PARAM_BDUSS = "bduss";
        public static final String UGC_POST_HTTP_PARAM_BUSINESS_TRIGGER = "business_trigger";
        public static final String UGC_POST_HTTP_PARAM_CITYID = "cityid";
        public static final String UGC_POST_HTTP_PARAM_CITYNAME = "city_name";
        public static final String UGC_POST_HTTP_PARAM_CONTENT = "content";
        public static final String UGC_POST_HTTP_PARAM_CONTRACT = "contact";
        public static final String UGC_POST_HTTP_PARAM_CUID = "cuid";
        public static final String UGC_POST_HTTP_PARAM_DETAIL_TYPE = "detail_type";
        public static final String UGC_POST_HTTP_PARAM_END_NAME = "end_name";
        public static final String UGC_POST_HTTP_PARAM_END_POINT = "end_point";
        public static final String UGC_POST_HTTP_PARAM_FROM_NAME = "from_name";
        public static final String UGC_POST_HTTP_PARAM_FROM_POINT = "from_point";
        public static final String UGC_POST_HTTP_PARAM_FROM_UID = "from_uid";
        public static final String UGC_POST_HTTP_PARAM_GUID = "guid";
        public static final String UGC_POST_HTTP_PARAM_ID = "id";
        public static final String UGC_POST_HTTP_PARAM_IS_CHANGE = "is_change";
        public static final String UGC_POST_HTTP_PARAM_LANE_TYPE = "lane_type";
        public static final String UGC_POST_HTTP_PARAM_LINKID = "linkid";
        public static final String UGC_POST_HTTP_PARAM_MARK = "mark";
        public static final String UGC_POST_HTTP_PARAM_MRSL = "mrsl";
        public static final String UGC_POST_HTTP_PARAM_NAME = "name";
        public static final String UGC_POST_HTTP_PARAM_OS = "os";
        public static final String UGC_POST_HTTP_PARAM_OSV = "osv";
        public static final String UGC_POST_HTTP_PARAM_PARENT_TYPE = "parent_type";
        public static final String UGC_POST_HTTP_PARAM_PHOTO_POINT = "photo_point";
        public static final String UGC_POST_HTTP_PARAM_PIC = "pic";
        public static final String UGC_POST_HTTP_PARAM_POINT = "point";
        public static final String UGC_POST_HTTP_PARAM_POSITION_TYPE = "position_type";
        public static final String UGC_POST_HTTP_PARAM_ROAD_NAME = "road_name";
        public static final String UGC_POST_HTTP_PARAM_SCREENSHOT_PIC = "screenshot_pic";
        public static final String UGC_POST_HTTP_PARAM_SESSION_ID = "session_id";
        public static final String UGC_POST_HTTP_PARAM_SIGN = "sign";
        public static final String UGC_POST_HTTP_PARAM_SPEED_LIMIT = "speed_limit";
        public static final String UGC_POST_HTTP_PARAM_START_NAME = "start_name";
        public static final String UGC_POST_HTTP_PARAM_START_POINT = "start_point";
        public static final String UGC_POST_HTTP_PARAM_SUB_TYPE = "sub_type";
        public static final String UGC_POST_HTTP_PARAM_SUPPLY = "supply";
        public static final String UGC_POST_HTTP_PARAM_SV = "sv";
        public static final String UGC_POST_HTTP_PARAM_TO_NAME = "to_name";
        public static final String UGC_POST_HTTP_PARAM_TO_POINT = "to_point";
        public static final String UGC_POST_HTTP_PARAM_TO_UID = "to_uid";
        public static final String UGC_POST_HTTP_PARAM_USER_POINT = "user_point";
        public static final String UGC_POST_HTTP_PARAM_VOICE = "voice";
    }

    public boolean ugcReportInfoUpLoad(UgcReportInfoUploadPackage infoPackage, final UgcHttpsResultCallBack mCallBack) {
        if (infoPackage == null) {
            return false;
        }
        this.mCallBack = mCallBack;
        UgcReportInfoUploadPackage mUgcReportSerInfoPackage = UgcReportInfoUploadPackage.getNewFormatPackage(infoPackage);
        infoPackage.showLog("upload2");
        mUgcReportSerInfoPackage.showLog("upload3");
        BNHttpParams httpParams = new BNHttpParams();
        httpParams.isAsync = true;
        httpParams.postFileMap = new HashMap();
        List<NameValuePair> params = new ArrayList();
        try {
            if (mUgcReportSerInfoPackage.id != -1) {
                params.add(new BasicNameValuePair("id", UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.id)));
            }
            params.add(new BasicNameValuePair("user_point", mUgcReportSerInfoPackage.userPoint));
            params.add(new BasicNameValuePair("point", mUgcReportSerInfoPackage.point));
            params.add(new BasicNameValuePair("business_trigger", UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.businessTrigger)));
            if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.parentType))) {
                params.add(new BasicNameValuePair("parent_type", UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.parentType)));
            }
            if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.subType))) {
                params.add(new BasicNameValuePair("sub_type", UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.subType)));
            }
            params.add(new BasicNameValuePair("guid", mUgcReportSerInfoPackage.guid));
            params.add(new BasicNameValuePair("content", mUgcReportSerInfoPackage.content));
            params.add(new BasicNameValuePair("photo_point", mUgcReportSerInfoPackage.photoPoint));
            params.add(new BasicNameValuePair("road_name", mUgcReportSerInfoPackage.roadName));
            if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.isChange))) {
                params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_IS_CHANGE, UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.isChange)));
            }
            params.add(new BasicNameValuePair("contact", mUgcReportSerInfoPackage.contact));
            params.add(new BasicNameValuePair("os", UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.os)));
            params.add(new BasicNameValuePair("osv", mUgcReportSerInfoPackage.osv));
            params.add(new BasicNameValuePair("sv", mUgcReportSerInfoPackage.sv));
            params.add(new BasicNameValuePair("cuid", mUgcReportSerInfoPackage.cuid));
            params.add(new BasicNameValuePair("name", mUgcReportSerInfoPackage.name));
            params.add(new BasicNameValuePair("session_id", mUgcReportSerInfoPackage.sessionId));
            params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_MRSL, mUgcReportSerInfoPackage.mrsl));
            params.add(new BasicNameValuePair("from_point", mUgcReportSerInfoPackage.fromPoint));
            params.add(new BasicNameValuePair("from_name", mUgcReportSerInfoPackage.fromName));
            params.add(new BasicNameValuePair("from_uid", mUgcReportSerInfoPackage.fromUid));
            params.add(new BasicNameValuePair("to_point", mUgcReportSerInfoPackage.toPoint));
            params.add(new BasicNameValuePair("to_name", mUgcReportSerInfoPackage.toName));
            params.add(new BasicNameValuePair("to_uid", mUgcReportSerInfoPackage.toUid));
            if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.cityId))) {
                params.add(new BasicNameValuePair("cityid", UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.cityId)));
            }
            params.add(new BasicNameValuePair("city_name", mUgcReportSerInfoPackage.cityName));
            if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.laneType))) {
                params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_LANE_TYPE, UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.laneType)));
            }
            if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.detailType))) {
                params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_DETAIL_TYPE, UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.detailType)));
            }
            if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.speedLimit))) {
                params.add(new BasicNameValuePair("speed_limit", UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.speedLimit)));
            }
            params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_START_POINT, mUgcReportSerInfoPackage.startPoint));
            params.add(new BasicNameValuePair("start_name", mUgcReportSerInfoPackage.startName));
            params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_END_POINT, mUgcReportSerInfoPackage.endPoint));
            params.add(new BasicNameValuePair("end_name", mUgcReportSerInfoPackage.endName));
            if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.mark))) {
                params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_MARK, UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.mark)));
            }
            params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_SUPPLY, UgcHttpsUtils.transferUploadIntToString(mUgcReportSerInfoPackage.supply)));
            params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_LINKID, mUgcReportSerInfoPackage.linkid));
            if (!(mUgcReportSerInfoPackage.screenshotPicPath == null || mUgcReportSerInfoPackage.screenshotPicPath.trim().equals(""))) {
                httpParams.postFileMap.put("screenshot_pic", new File(mUgcReportSerInfoPackage.screenshotPicPath));
            }
            if (!(mUgcReportSerInfoPackage.photoPicPath == null || mUgcReportSerInfoPackage.photoPicPath.trim().equals(""))) {
                httpParams.postFileMap.put("pic", new File(mUgcReportSerInfoPackage.photoPicPath));
            }
            if (!(mUgcReportSerInfoPackage.voicePath == null || mUgcReportSerInfoPackage.voicePath.trim().equals(""))) {
                httpParams.postFileMap.put("voice", new File(mUgcReportSerInfoPackage.voicePath));
            }
            String str = "sign";
            params.add(new BasicNameValuePair(str, JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder(params)) + ""));
            BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_UGC_OPER_INFO_REPORT), BNHttpCenterHelper.formatParams(params), new BNHttpTextResponseHandler() {
                public void onSuccess(int statusCode, String responseString) {
                    LogUtil.m15791e(UgcHttps.TAG, "onSuccess() statusCode=" + statusCode + ", responseString=" + responseString);
                    try {
                        JSONObject retJsonObject = new JSONObject(responseString);
                        if (retJsonObject.getInt(C2125n.f6745M) == 0) {
                            JSONObject dataJsonObject = retJsonObject.getJSONObject("data");
                            if (mCallBack != null) {
                                mCallBack.onUgcInfoReportUpLoadSuccess(dataJsonObject);
                            }
                        } else if (mCallBack != null) {
                            mCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (mCallBack != null) {
                            mCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
                        }
                    }
                }

                public void onFailure(int statusCode, String responseString, Throwable throwable) {
                    LogUtil.m15791e(UgcHttps.TAG, "onFailure() statusCode=" + statusCode + ", responseString=" + responseString);
                    if (mCallBack != null) {
                        mCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
                    }
                }
            }, httpParams);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void getUgcUserInfo(UgcHttpsResultCallBack mCallBack) {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            this.mCallBack = mCallBack;
            ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mHandler, MSG_UGCREPORT_INFO_OBTAIN_RET, 10000);
            reqdata.setObj(mCallBack);
            reqdata.mCookieStore = UgcHttpsUtils.getCookieStore();
            CmdGeneralHttpRequestFunc.addFunc(reqdata, new C41953());
            CommandCenter.getInstance().sendRequest(reqdata);
        }
    }

    private List<NameValuePair> getUgcReportCountsReqParam() {
        Exception e;
        try {
            List<NameValuePair> params = new ArrayList();
            List<NameValuePair> list;
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
                LogUtil.m15791e("UgcHttpsunsign str:", str);
                mParam = JNITrajectoryControl.sInstance.getUrlParamsSign(str) + "";
                LogUtil.m15791e("UgcHttpshassign sign:", mParam);
                params.add(new BasicNameValuePair("sign", mParam));
                sb.append("&sign=" + URLEncoder.encode(mParam, "utf-8"));
                LogUtil.m15791e("UgcHttpsparams:", sb.toString());
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

    public void getRubPointAdsorbInfo(final String cityid, final String point, UgcHttpsResultCallBack mCallBack, final int source) {
        if (mCallBack != null) {
            if (point == null) {
                mCallBack.onUgcInfoReportUpLoadFail("point is null");
            } else if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                this.mCallBack = mCallBack;
                ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mHandler, MSG_RUBPOINT_ADSORB_OBTAIN_RET, 1000);
                reqdata.setObj(mCallBack);
                reqdata.mCookieStore = UgcHttpsUtils.getCookieStore();
                CmdGeneralHttpRequestFunc.addFunc(reqdata, new Callback() {
                    public boolean parseResponseJSON(JSONObject jsonObj) {
                        return true;
                    }

                    public String getUrl() {
                        return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_RUBPOINT_ADSORB);
                    }

                    public List<NameValuePair> getRequestParams() {
                        return UgcHttps.this.getRubPointAdsorbParam(cityid, point, source);
                    }

                    public int getRequestType() {
                        return 1;
                    }

                    public void responseImage(byte[] img) {
                    }
                });
                CommandCenter.getInstance().sendRequest(reqdata);
            } else {
                mCallBack.onUgcInfoReportUpLoadFail("no net");
            }
        }
    }

    private List<NameValuePair> getRubPointAdsorbParam(String cityid, String point, int source) {
        List<NameValuePair> list;
        Exception e;
        try {
            List<NameValuePair> params = new ArrayList();
            try {
                StringBuffer sb = new StringBuffer();
                String mParam = PackageUtil.getCuid() + "";
                params.add(new BasicNameValuePair("cuid", mParam));
                sb.append("cuid=" + URLEncoder.encode(mParam, "utf-8"));
                mParam = "0";
                params.add(new BasicNameValuePair("os", mParam));
                sb.append("os=" + URLEncoder.encode(mParam, "utf-8"));
                mParam = PackageUtil.getVersionName() + "";
                params.add(new BasicNameValuePair("sv", mParam));
                sb.append("&sv=" + URLEncoder.encode(mParam, "utf-8"));
                mParam = PackageUtil.strOSVersion + "";
                params.add(new BasicNameValuePair("osv", mParam));
                sb.append("&osv=" + URLEncoder.encode(mParam, "utf-8"));
                mParam = cityid;
                if (!(TextUtils.isEmpty(mParam) || mParam.equals(""))) {
                    params.add(new BasicNameValuePair("cityid", mParam));
                    sb.append("&cityid=" + URLEncoder.encode(mParam, "utf-8"));
                }
                mParam = source + "";
                params.add(new BasicNameValuePair("source", mParam));
                sb.append("&source=" + URLEncoder.encode(mParam, "utf-8"));
                mParam = point;
                params.add(new BasicNameValuePair("point", mParam));
                sb.append("&point=" + URLEncoder.encode(mParam, "utf-8"));
                String str = CloudConfigObtainManager.SortSequenceWithAscendingOder(params);
                LogUtil.m15791e("UgcHttpsunsign str:", str);
                mParam = JNITrajectoryControl.sInstance.getUrlParamsSign(str) + "";
                LogUtil.m15791e("UgcHttpshassign sign:", mParam);
                params.add(new BasicNameValuePair("sign", mParam));
                sb.append("&sign=" + URLEncoder.encode(mParam, "utf-8"));
                LogUtil.m15791e("UgcHttpsparams:", sb.toString());
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
