package com.baidu.navisdk.module;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.mobstat.Config;
import com.baidu.navi.protocol.model.HUDGuideDataStruct;
import com.baidu.navi.util.ShareTools;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.viewhelp.LightNaviDialogHelper;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.NaviErrCode;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostFunc.Callback;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoadConditionItem;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel.NaviEndPrivilege;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.module.business.BusinessActivityViewManager;
import com.baidu.navisdk.module.business.FileCache;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.naviresult.BNNaviResultController.DataDownloadState;
import com.baidu.navisdk.naviresult.BNNaviResultController.DataDownloadType;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice$VoiceUserAction;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.vi.VDeviceAPI;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BusinessActivityManager {
    public static final String AUDIO_DIR = "activity";
    public static final String AUDIO_END_NAVI_NAME = "en.mp3";
    public static final String AUDIO_ENVELOPO_EFFECT_NAME = "evelopo.mp3";
    public static final String AUDIO_SHOW_ACTIVITY_NAME = "sa.mp3";
    public static final String AUDIO_START_NAVI_NAME = "sn.mp3";
    public static final String GET_ACT_OFFLINE_URL = "http://cp01-navi-server-1.epc.baidu.com:8080/mop/getacts";
    public static final String GET_ACT_ONLINE_URL = (HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/mop/getacts");
    public static final int MSG_BUSINESSACTIVITY_REQUEST_RET = 1500;
    public static final int MSG_BUSINESSACTIVITY_UPLOAD_REQUEST_FOR_NAVING = 1505;
    public static final int MSG_BUSINESSACTIVITY_UPLOAD_RET = 1501;
    public static final int MSG_BUSINESSACTIVITY_UPLOAD_RET_FOR_NAVING = 1502;
    public static final int MSG_NAV_END_GET_SHARE_CONTENT_RET = 1503;
    public static final int MSG_NAV_END_MARK_TRAJECTORY_RET = 1504;
    private static final int MSG_NAV_SAFETY_SHARE_CHANGE = 1702;
    private static final int MSG_NAV_SAFETY_SHARE_END = 1701;
    private static final int MSG_NAV_SAFETY_SHARE_START = 1700;
    private static final int MSG_REQUEST_AUDIO_END_NAVI = 1515;
    private static final int MSG_REQUEST_AUDIO_SHOW_ACTIVITY = 1516;
    private static final int MSG_REQUEST_AUDIO_START_NAVI = 1514;
    private static final int MSG_REQUEST_BITMAP_BANNER = 1511;
    private static final int MSG_REQUEST_BITMAP_ENVELOPE_BTN_CLICKED = 1531;
    private static final int MSG_REQUEST_BITMAP_ENVELOPE_BTN_NORMAL = 1530;
    private static final int MSG_REQUEST_BITMAP_ENVELOPE_MID = 1532;
    private static final int MSG_REQUEST_BITMAP_ENVELOPE_PLUS = 1533;
    private static final int MSG_REQUEST_BITMAP_ENVELOPE_SOUND_EFFECT = 1535;
    private static final int MSG_REQUEST_BITMAP_ENVELOPE_WINDOW_BG = 1534;
    private static final int MSG_REQUEST_BITMAP_LOGO = 1510;
    private static final int MSG_REQUEST_BITMAP_NAVIENDPIC = 1513;
    private static final int MSG_REQUEST_BITMAP_OPERATION_ACTIVITY_PICTURE = 1538;
    private static final int MSG_REQUEST_BITMAP_RICON = 1512;
    private static final int MSG_REQUEST_BITMAP_USER_RIGHT_CAR_ICON = 1536;
    public static final int MSG_REQUEST_BITMAP_USER_RIGHT_ICON_END = 1539;
    private static final int MSG_TEST_SAVE_BITMAP = 1620;
    private static final int MSG_TEST_SHOW_BUSINESS_VIEW = 1621;
    public static final String TAG = BusinessActivityManager.class.getSimpleName();
    public static final String UPLOAD_OFFLINE_URL = "http://cp01-navi-server-1.epc.baidu.com:8080/mop/naviend/upload";
    public static final String UPLOAD_ONLINE_URL = (HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/mop/naviend/upload");
    private static Object mSyncObj = new Object();
    private static BusinessActivityManager sInstance = null;
    public boolean isCancelShareSafe;
    private boolean isOrientationUser;
    public boolean isShareSuc;
    private BusinessActivityModel mBusinessActivityModel;
    private Handler mHD;
    private long mLastMilea;
    private Handler mOutShareHandler;
    private int mOutShareMsgWhat;
    private Handler mOuterHandler;
    private int mOuterMsgWhat;
    private Handler mOuterUploadHandler;
    private Handler mOuterUploadHandlerForNaving;
    private int mOuterUploadMsgWhat;
    private int mOuterUploadMsgWhatForNaving;
    private BNWorkerNormalTask<String, String> mUploadMileaTask;
    private RoutePlanModel rpModel;

    /* renamed from: com.baidu.navisdk.module.BusinessActivityManager$4 */
    class C41514 implements Callback {
        C41514() {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            return BusinessActivityManager.this.parseUploadJSON(jsonObj);
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_BUSINESS_UPLOAD);
        }

        public List<NameValuePair> getRequestParams() {
            if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData == null) {
                return null;
            }
            try {
                List<NameValuePair> params = new ArrayList();
                StringBuffer sb = new StringBuffer();
                RoutePlanNode startNode = BusinessActivityManager.this.rpModel.getStartNode();
                RoutePlanNode endNode = BusinessActivityManager.this.rpModel.getEndNode();
                double startX = -1.0d;
                double startY = -1.0d;
                double endX = -1.0d;
                double endY = -1.0d;
                if (startNode != null) {
                    startX = ((double) startNode.mGeoPoint.getLongitudeE6()) / 100000.0d;
                    startY = ((double) startNode.mGeoPoint.getLatitudeE6()) / 100000.0d;
                }
                if (endNode != null) {
                    endX = ((double) endNode.mGeoPoint.getLongitudeE6()) / 100000.0d;
                    endY = ((double) endNode.mGeoPoint.getLatitudeE6()) / 100000.0d;
                }
                String startGeoStr = startX + "," + startY;
                String endGeoStr = endX + "," + endY;
                params.add(new BasicNameValuePair("aid", "0"));
                sb.append("&aid=" + URLEncoder.encode("0", "utf-8"));
                String tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcDataSign") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcDataSign") : "";
                params.add(new BasicNameValuePair("as", tmpS));
                sb.append("&as=" + URLEncoder.encode(tmpS, "utf-8"));
                params.add(new BasicNameValuePair("atype", "" + BusinessActivityManager.this.mBusinessActivityModel.atype));
                sb.append("&atype=" + URLEncoder.encode("" + BusinessActivityManager.this.mBusinessActivityModel.atype, "utf-8"));
                String cid = "0";
                if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
                    cid = "" + GeoLocateModel.getInstance().getCurrentDistrict().mId;
                }
                params.add(new BasicNameValuePair("cityid", cid));
                sb.append("&cityid=" + URLEncoder.encode(cid, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("ulCreateTime") ? "" + BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getLong("ulCreateTime") : "";
                params.add(new BasicNameValuePair(Config.EXCEPTION_CRASH_TYPE, tmpS));
                sb.append("&ct=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcCuid") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcCuid") : "";
                params.add(new BasicNameValuePair("cuid", tmpS));
                sb.append("&cuid=" + URLEncoder.encode(tmpS, "utf-8"));
                params.add(new BasicNameValuePair("data_type", "2"));
                sb.append("&data_type=" + URLEncoder.encode("2", "utf-8"));
                params.add(new BasicNameValuePair("end_position", endGeoStr));
                sb.append("&end_position=" + URLEncoder.encode(endGeoStr, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcFrom") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcFrom") : "";
                params.add(new BasicNameValuePair(PlatformConstants.CONNECT_EXTRA_KEY, tmpS));
                sb.append("&from=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcGuid") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcGuid") : "";
                params.add(new BasicNameValuePair("guid", tmpS));
                sb.append("&guid=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcNaviActInfo") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcNaviActInfo") : "";
                params.add(new BasicNameValuePair("navi_act_info", tmpS));
                sb.append("&navi_act_info=" + URLEncoder.encode(tmpS, "utf-8"));
                if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("bIsChangedKey")) {
                    tmpS = "" + (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getBoolean("bIsChangedKey") ? 1 : 0);
                } else {
                    tmpS = "";
                }
                params.add(new BasicNameValuePair("pek", tmpS));
                sb.append("&pek=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("unKeyVesion") ? "" + BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getInt("unKeyVesion") : "";
                params.add(new BasicNameValuePair("pv", tmpS));
                sb.append("&pv=" + URLEncoder.encode(tmpS, "utf-8"));
                params.add(new BasicNameValuePair("qtv", "2"));
                sb.append("&qtv=" + URLEncoder.encode("2", "utf-8"));
                tmpS = TextUtils.isEmpty(BusinessActivityManager.this.mBusinessActivityModel.session) ? "" : BusinessActivityManager.this.mBusinessActivityModel.session;
                params.add(new BasicNameValuePair("session", tmpS));
                sb.append("&session=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcSessionID") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcSessionID") : "";
                params.add(new BasicNameValuePair("sid", tmpS));
                sb.append("&sid=" + URLEncoder.encode(tmpS, "utf-8"));
                params.add(new BasicNameValuePair("st", "" + BusinessActivityManager.this.mBusinessActivityModel.timestamp));
                sb.append("&st=" + URLEncoder.encode("" + BusinessActivityManager.this.mBusinessActivityModel.timestamp, "utf-8"));
                params.add(new BasicNameValuePair("start_position", startGeoStr));
                sb.append("&start_position=" + URLEncoder.encode(startGeoStr, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcSoftVersion") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcSoftVersion") : "";
                params.add(new BasicNameValuePair("sv", tmpS));
                sb.append("&sv=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcPoiID") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcPoiID") : "";
                params.add(new BasicNameValuePair("uid", tmpS));
                sb.append("&uid=" + URLEncoder.encode(tmpS, "utf-8"));
                params.add(new BasicNameValuePair("yaw_num", String.valueOf(BNNaviResultModel.getInstance().yawNum)));
                sb.append("&yaw_num=" + URLEncoder.encode(String.valueOf(BNNaviResultModel.getInstance().yawNum), "utf-8"));
                params.add(new BasicNameValuePair("mainside_num", String.valueOf(BNNaviResultModel.getInstance().instantNum)));
                sb.append("&mainside_num=" + URLEncoder.encode(String.valueOf(BNNaviResultModel.getInstance().instantNum), "utf-8"));
                params.add(new BasicNameValuePair("is_switch", String.valueOf(BNNaviResultModel.getInstance().isSwitch)));
                sb.append("&is_switch=" + URLEncoder.encode(String.valueOf(BNNaviResultModel.getInstance().isSwitch), "utf-8"));
                tmpS = JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder(params));
                if (TextUtils.isEmpty(tmpS)) {
                    tmpS = "";
                }
                params.add(new BasicNameValuePair("sign", tmpS));
                sb.append("&sign=" + URLEncoder.encode(tmpS, "utf-8"));
                LogUtil.m15791e(BusinessActivityManager.TAG, "getRequestParams() uploadData --> " + sb.toString());
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

    /* renamed from: com.baidu.navisdk.module.BusinessActivityManager$5 */
    class C41525 implements Callback {
        C41525() {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            return BusinessActivityManager.this.parseUploadJSONForNaving(jsonObj);
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_BUSINESS_UPLOAD);
        }

        public List<NameValuePair> getRequestParams() {
            if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving == null) {
                return null;
            }
            try {
                List<NameValuePair> params = new ArrayList();
                StringBuffer sb = new StringBuffer();
                RoutePlanNode startNode = BusinessActivityManager.this.rpModel.getStartNode();
                RoutePlanNode endNode = BusinessActivityManager.this.rpModel.getEndNode();
                double startX = -1.0d;
                double startY = -1.0d;
                double endX = -1.0d;
                double endY = -1.0d;
                if (startNode != null) {
                    startX = ((double) startNode.mGeoPoint.getLongitudeE6()) / 100000.0d;
                    startY = ((double) startNode.mGeoPoint.getLatitudeE6()) / 100000.0d;
                }
                if (endNode != null) {
                    endX = ((double) endNode.mGeoPoint.getLongitudeE6()) / 100000.0d;
                    endY = ((double) endNode.mGeoPoint.getLatitudeE6()) / 100000.0d;
                }
                String startGeoStr = startX + "," + startY;
                String endGeoStr = endX + "," + endY;
                params.add(new BasicNameValuePair("aid", "0"));
                sb.append("&aid=" + URLEncoder.encode("0", "utf-8"));
                String tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcDataSign") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcDataSign") : "";
                params.add(new BasicNameValuePair("as", tmpS));
                sb.append("&as=" + URLEncoder.encode(tmpS, "utf-8"));
                params.add(new BasicNameValuePair("atype", "0"));
                sb.append("&atype=" + URLEncoder.encode("0", "utf-8"));
                String cid = "0";
                if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
                    cid = "" + GeoLocateModel.getInstance().getCurrentDistrict().mId;
                }
                params.add(new BasicNameValuePair("cityid", cid));
                sb.append("&cityid=" + URLEncoder.encode(cid, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("ulCreateTime") ? "" + BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getLong("ulCreateTime") : "";
                params.add(new BasicNameValuePair(Config.EXCEPTION_CRASH_TYPE, tmpS));
                sb.append("&ct=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcCuid") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcCuid") : "";
                params.add(new BasicNameValuePair("cuid", tmpS));
                sb.append("&cuid=" + URLEncoder.encode(tmpS, "utf-8"));
                params.add(new BasicNameValuePair("data_type", "1"));
                sb.append("&data_type=" + URLEncoder.encode("1", "utf-8"));
                params.add(new BasicNameValuePair("end_position", endGeoStr));
                sb.append("&end_position=" + URLEncoder.encode(endGeoStr, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcFrom") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcFrom") : "";
                params.add(new BasicNameValuePair(PlatformConstants.CONNECT_EXTRA_KEY, tmpS));
                sb.append("&from=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcGuid") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcGuid") : "";
                params.add(new BasicNameValuePair("guid", tmpS));
                sb.append("&guid=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcNaviActInfo") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcNaviActInfo") : "";
                params.add(new BasicNameValuePair("navi_act_info", tmpS));
                sb.append("&navi_act_info=" + URLEncoder.encode(tmpS, "utf-8"));
                if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("bIsChangedKey")) {
                    tmpS = "" + (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getBoolean("bIsChangedKey") ? 1 : 0);
                } else {
                    tmpS = "";
                }
                params.add(new BasicNameValuePair("pek", tmpS));
                sb.append("&pek=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("unKeyVesion") ? "" + BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getInt("unKeyVesion") : "";
                params.add(new BasicNameValuePair("pv", tmpS));
                sb.append("&pv=" + URLEncoder.encode(tmpS, "utf-8"));
                params.add(new BasicNameValuePair("qtv", "2"));
                sb.append("&qtv=" + URLEncoder.encode("2", "utf-8"));
                tmpS = TextUtils.isEmpty(BusinessActivityManager.this.mBusinessActivityModel.session) ? "" : BusinessActivityManager.this.mBusinessActivityModel.session;
                params.add(new BasicNameValuePair("session", tmpS));
                sb.append("&session=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcSessionID") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcSessionID") : "";
                params.add(new BasicNameValuePair("sid", tmpS));
                sb.append("&sid=" + URLEncoder.encode(tmpS, "utf-8"));
                params.add(new BasicNameValuePair("st", "" + BusinessActivityManager.this.mBusinessActivityModel.timestamp));
                sb.append("&st=" + URLEncoder.encode("" + BusinessActivityManager.this.mBusinessActivityModel.timestamp, "utf-8"));
                params.add(new BasicNameValuePair("start_position", startGeoStr));
                sb.append("&start_position=" + URLEncoder.encode(startGeoStr, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcSoftVersion") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcSoftVersion") : "";
                params.add(new BasicNameValuePair("sv", tmpS));
                sb.append("&sv=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcPoiID") ? BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcPoiID") : "";
                params.add(new BasicNameValuePair("uid", tmpS));
                sb.append("&uid=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder(params));
                if (TextUtils.isEmpty(tmpS)) {
                    tmpS = "";
                }
                params.add(new BasicNameValuePair("sign", tmpS));
                sb.append("&sign=" + URLEncoder.encode(tmpS, "utf-8"));
                LogUtil.m15791e(BusinessActivityManager.TAG, "uploadData() uploadPs=" + sb.toString());
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

    /* renamed from: com.baidu.navisdk.module.BusinessActivityManager$6 */
    class C41536 extends BNHttpTextResponseHandler {
        C41536() {
        }

        public void onSuccess(int statusCode, String responseString) {
            try {
                BusinessActivityManager.this.parseShareJSON(new JSONObject(responseString));
            } catch (JSONException e) {
            }
            if (BusinessActivityManager.this.mOutShareHandler != null) {
                BusinessActivityManager.this.mOutShareHandler.obtainMessage(BusinessActivityManager.this.mOutShareMsgWhat).sendToTarget();
            }
        }

        public void onFailure(int statusCode, String responseString, Throwable throwable) {
            if (BusinessActivityManager.this.mOutShareHandler != null) {
                BusinessActivityManager.this.mOutShareHandler.obtainMessage(BusinessActivityManager.this.mOutShareMsgWhat).sendToTarget();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.BusinessActivityManager$9 */
    class C41569 implements OnCancelListener {
        C41569() {
        }

        public void onCancel(DialogInterface dialog) {
            BusinessActivityManager.this.isCancelShareSafe = true;
        }
    }

    private BusinessActivityManager() {
        this.mOuterHandler = null;
        this.mOuterMsgWhat = -1;
        this.mOuterUploadHandler = null;
        this.mOuterUploadMsgWhat = -1;
        this.mOuterUploadHandlerForNaving = null;
        this.mOuterUploadMsgWhatForNaving = -1;
        this.mOutShareHandler = null;
        this.mOutShareMsgWhat = -1;
        this.mBusinessActivityModel = null;
        this.rpModel = null;
        this.mHD = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                if (1500 == msg.what) {
                    if (msg.arg1 == 0) {
                        LogUtil.m15791e(BusinessActivityManager.TAG, "handleMessage()");
                        if (BusinessActivityManager.this.mOuterHandler != null) {
                            BusinessActivityManager.this.mOuterHandler.sendEmptyMessage(BusinessActivityManager.this.mOuterMsgWhat);
                        }
                    }
                } else if (BusinessActivityManager.MSG_TEST_SAVE_BITMAP == msg.what) {
                    if (BusinessActivityManager.this.mBusinessActivityModel != null) {
                        BusinessActivityManager.this.mBusinessActivityModel.testSaveBitmap();
                    }
                } else if (BusinessActivityManager.MSG_TEST_SHOW_BUSINESS_VIEW == msg.what) {
                    BusinessActivityViewManager.getInstance().showViews(BNavigator.getInstance().getActivity(), false);
                    TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "测试超时触发商业水滴显示");
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_LOGO == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_BANNER);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_BANNER == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_RICON);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_RICON == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_NAVIENDPIC);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_NAVIENDPIC == msg.what) {
                    BusinessActivityManager.this.requestAudio(BusinessActivityManager.MSG_REQUEST_AUDIO_SHOW_ACTIVITY);
                } else if (BusinessActivityManager.MSG_REQUEST_AUDIO_START_NAVI == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_LOGO);
                    BusinessActivityPlayerManager.getInstance().playNaviStartContent();
                } else if (BusinessActivityManager.MSG_REQUEST_AUDIO_END_NAVI == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_BTN_NORMAL);
                } else if (BusinessActivityManager.MSG_REQUEST_AUDIO_SHOW_ACTIVITY == msg.what) {
                    BusinessActivityManager.this.requestAudio(BusinessActivityManager.MSG_REQUEST_AUDIO_END_NAVI);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_BTN_NORMAL == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_BTN_CLICKED);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_BTN_CLICKED == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_MID);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_MID == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_PLUS);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_PLUS == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_WINDOW_BG);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_WINDOW_BG == msg.what) {
                    BusinessActivityManager.this.requestAudio(BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_SOUND_EFFECT);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_SOUND_EFFECT == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_USER_RIGHT_CAR_ICON);
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_USER_RIGHT_CAR_ICON == msg.what) {
                    BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_OPERATION_ACTIVITY_PICTURE);
                    if (BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap != null) {
                        BNRouteGuider.getInstance().setCarImageToMap(FileCache.getCacheFilePath(BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink, ""));
                    } else {
                        BNRouteGuider.getInstance().clearCarImage();
                    }
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_OPERATION_ACTIVITY_PICTURE == msg.what) {
                    LogUtil.m15791e(BusinessActivityManager.TAG, "reuqest completed.");
                } else if (BusinessActivityManager.MSG_REQUEST_BITMAP_USER_RIGHT_ICON_END == msg.what) {
                    BNNaviResultController.getInstance().notifyServerDataDownloadState(DataDownloadType.IMG_DATA, DataDownloadState.DOWNLOAD_FINISH);
                } else if (1501 == msg.what) {
                    if (msg.arg1 == 0) {
                        LogUtil.m15791e(BusinessActivityManager.TAG, "Navi End Upload --> SUCCESS, Now Notify NaviPage Update UI");
                        BNNaviResultController.getInstance().notifyServerDataDownloadState(DataDownloadType.TXT_DATA, DataDownloadState.DOWNLOAD_FINISH);
                        BusinessActivityManager.this.requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_USER_RIGHT_ICON_END);
                        return;
                    }
                    LogUtil.m15791e(BusinessActivityManager.TAG, "Navi End Upload --> FAILED!!");
                    BNNaviResultController.getInstance().notifyServerDataDownloadState(DataDownloadType.TXT_DATA, DataDownloadState.DOWNLOAD_FINISH);
                    BNNaviResultController.getInstance().notifyServerDataDownloadState(DataDownloadType.IMG_DATA, DataDownloadState.DOWNLOAD_CANCEL);
                } else if (BusinessActivityManager.MSG_BUSINESSACTIVITY_UPLOAD_RET_FOR_NAVING == msg.what) {
                    if (BusinessActivityManager.this.mOuterUploadHandlerForNaving != null) {
                        BusinessActivityManager.this.mOuterUploadHandlerForNaving.obtainMessage(BusinessActivityManager.this.mOuterUploadMsgWhatForNaving).sendToTarget();
                    }
                } else if (BusinessActivityManager.MSG_BUSINESSACTIVITY_UPLOAD_REQUEST_FOR_NAVING == msg.what) {
                    BNWorkerCenter.getInstance().submitMainThreadTask(BusinessActivityManager.this.mUploadMileaTask, new BNWorkerConfig(100, 0));
                } else if (BusinessActivityManager.MSG_NAV_END_GET_SHARE_CONTENT_RET == msg.what) {
                    if (BusinessActivityManager.this.mOutShareHandler != null) {
                        BusinessActivityManager.this.mOutShareHandler.obtainMessage(BusinessActivityManager.this.mOutShareMsgWhat).sendToTarget();
                    }
                } else if (BusinessActivityManager.MSG_NAV_SAFETY_SHARE_START == msg.what) {
                    LogUtil.m15791e(BusinessActivityManager.TAG, "safety MSG_NAV_SAFETY_SHARE_START  --> msg.arg1: " + msg.arg1);
                    RGViewController.getInstance().hideSafetyShareLoading();
                    LightNaviDialogHelper.getInstance(BNaviModuleManager.getContext()).dismissSafetyShareDialog();
                    if (msg.arg1 == 0) {
                        try {
                            RspData rspData = msg.obj;
                            if (rspData != null) {
                                JSONObject jSONObject = rspData.mData;
                                if (jSONObject != null) {
                                    int error = ((JSONObject) rspData.mData).getInt(C2125n.f6745M);
                                    String share_url = ((JSONObject) rspData.mData).getString(ShareTools.BUNDLE_KEY_SHARE_URL);
                                    String share_icon = null;
                                    String share_title = null;
                                    String share_desc = null;
                                    if (jSONObject.has("share_icon")) {
                                        share_icon = ((JSONObject) rspData.mData).getString("share_icon");
                                    }
                                    if (jSONObject.has("share_title")) {
                                        share_title = ((JSONObject) rspData.mData).getString("share_title");
                                    }
                                    if (jSONObject.has("share_desc")) {
                                        share_desc = ((JSONObject) rspData.mData).getString("share_desc");
                                    }
                                    LogUtil.m15791e(BusinessActivityManager.TAG, "safety  --> jSONObject: " + jSONObject.toString());
                                    if (error == 0 && !StringUtils.isEmpty(share_url)) {
                                        BusinessActivityManager.getInstance().shareSafety(share_url, share_icon, share_title, share_desc);
                                        return;
                                    }
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (!BusinessActivityManager.this.isCancelShareSafe) {
                        TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "分享请求失败,请稍后重试");
                    }
                } else if (BusinessActivityManager.MSG_NAV_SAFETY_SHARE_END == msg.what) {
                    LogUtil.m15791e(BusinessActivityManager.TAG, "safety MSG_NAV_SAFETY_SHARE_END  --> msg.arg1: " + msg.arg1);
                } else if (BusinessActivityManager.MSG_NAV_SAFETY_SHARE_CHANGE == msg.what) {
                    LogUtil.m15791e(BusinessActivityManager.TAG, "safety MSG_NAV_SAFETY_SHARE_CHANGE  --> msg.arg1: " + msg.arg1);
                }
            }
        };
        this.mUploadMileaTask = new BNWorkerNormalTask<String, String>("mUploadMileaTask-" + getClass().getSimpleName(), null) {
            protected String execute() {
                String uuid = JNITrajectoryControl.sInstance.getCurrentUUID();
                if (uuid != null && uuid.length() > 0) {
                    long curMilea = JNITrajectoryControl.sInstance.getTrajectoryLength(uuid);
                    if (curMilea - BusinessActivityManager.this.mLastMilea >= ((long) BusinessActivityManager.this.mBusinessActivityModel.uploadMileageInter)) {
                        Bundle postBd = new Bundle();
                        if (JNITrajectoryControl.sInstance.getPostParamsForNavingUpload(uuid, postBd) != -1) {
                            BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving = postBd;
                            BusinessActivityManager.this.uploadDataForNaving(BusinessActivityManager.this.mHD, 100);
                            BusinessActivityManager.this.mLastMilea = curMilea;
                        }
                    }
                }
                return null;
            }
        };
        this.isCancelShareSafe = false;
        this.isOrientationUser = false;
        this.isShareSuc = false;
        this.rpModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
    }

    public static BusinessActivityManager getInstance() {
        if (sInstance == null) {
            synchronized (mSyncObj) {
                if (sInstance == null) {
                    sInstance = new BusinessActivityManager();
                }
            }
        }
        return sInstance;
    }

    public BusinessActivityModel getModel() {
        if (this.mBusinessActivityModel == null) {
            this.mBusinessActivityModel = new BusinessActivityModel();
        }
        return this.mBusinessActivityModel;
    }

    public boolean requestNavigatorBusinessActivity(Context context, Handler callback, final int what) {
        releaseAllRes();
        this.mOuterHandler = callback;
        this.mOuterMsgWhat = what;
        FileCache.clearCache(context, false);
        if (this.mBusinessActivityModel == null) {
            this.mBusinessActivityModel = new BusinessActivityModel();
        } else {
            this.mBusinessActivityModel.clear();
        }
        try {
            StringBuffer sb = new StringBuffer();
            HashMap<String, String> getMethodParams = new HashMap();
            getMethodParams.put("bduss", "");
            sb.append("bduss=");
            sb.append(URLEncoder.encode("", "utf-8"));
            int cid = 0;
            if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
                cid = GeoLocateModel.getInstance().getCurrentDistrict().mId;
            }
            getMethodParams.put(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYCODE, "" + cid);
            sb.append("&cityCode=");
            sb.append(URLEncoder.encode("" + cid, "utf-8"));
            getMethodParams.put("cuid", PackageUtil.getCuid());
            sb.append("&cuid=");
            sb.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
            getMethodParams.put("mb", VDeviceAPI.getPhoneType());
            sb.append("&mb=");
            sb.append(URLEncoder.encode(VDeviceAPI.getPhoneType(), "utf-8"));
            getMethodParams.put("os", "0");
            sb.append("&os=");
            sb.append(URLEncoder.encode("0", "utf-8"));
            getMethodParams.put("osv", VDeviceAPI.getOsVersion());
            sb.append("&osv=");
            sb.append(URLEncoder.encode(VDeviceAPI.getOsVersion(), "utf-8"));
            getMethodParams.put("qtv", "2");
            sb.append("&qtv=");
            sb.append(URLEncoder.encode("2", "utf-8"));
            getMethodParams.put("sid", "1");
            sb.append("&sid=");
            sb.append(URLEncoder.encode("1", "utf-8"));
            getMethodParams.put("sv", "10.1.0");
            sb.append("&sv=");
            sb.append(URLEncoder.encode("10.1.0", "utf-8"));
            String tmpS = VoiceHelper.getInstance().getCurrentUsedTTSId();
            if (TextUtils.isEmpty(tmpS)) {
                tmpS = "0";
            }
            getMethodParams.put("tts_id", tmpS);
            sb.append("&tts_id=");
            sb.append(URLEncoder.encode(tmpS, "utf-8"));
            LogUtil.m15791e(TAG, "getRequestParams() getActs --> " + sb.toString());
            getMethodParams.put("sign", MD5.toMD5("mop" + sb.toString() + "6456bc093ca827bf3db43fb106fb2624").toLowerCase());
            BNHttpCenter.getInstance().get(HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_BUSINESS_GET_ACT), getMethodParams, new BNHttpTextResponseHandler() {
                public void onSuccess(int statusCode, String responseString) {
                    LogUtil.m15791e(BusinessActivityManager.TAG, "requestNavigatorBusinessActivity().ok statusCode=" + statusCode + ", s=" + responseString);
                    if (responseString != null && responseString.length() > 0) {
                        try {
                            BusinessActivityManager.this.parseBusinessActivityJSON(new JSONObject(responseString));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (BusinessActivityManager.this.mHD != null) {
                            Message omsg = BusinessActivityManager.this.mHD.obtainMessage();
                            omsg.what = what;
                            omsg.arg1 = 0;
                            omsg.sendToTarget();
                        }
                        BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap = FileCache.loadBitmapCache(BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink, "");
                        if (BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap == null) {
                            return;
                        }
                        if (BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap != null) {
                            BNRouteGuider.getInstance().setCarImageToMap(FileCache.getCacheFilePath(BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink, ""));
                        } else {
                            BNRouteGuider.getInstance().clearCarImage();
                        }
                    }
                }

                public void onFailure(int statusCode, String responseString, Throwable throwable) {
                    LogUtil.m15791e(BusinessActivityManager.TAG, "requestNavigatorBusinessActivity().err statusCode=" + statusCode + ", s=" + responseString);
                    if (BusinessActivityManager.this.mHD != null) {
                        Message omsg = BusinessActivityManager.this.mHD.obtainMessage();
                        omsg.what = what;
                        omsg.arg1 = NaviErrCode.RET_BUG;
                        omsg.sendToTarget();
                    }
                }
            }, null);
        } catch (Exception e) {
        }
        return true;
    }

    private boolean parseBusinessActivityJSON(JSONObject jsonObj) {
        if (jsonObj == null) {
            return false;
        }
        LogUtil.m15791e(TAG, "parseBusinessActivityJSON() getActs -->" + jsonObj.toString());
        if (this.mBusinessActivityModel == null) {
            this.mBusinessActivityModel = new BusinessActivityModel();
        } else {
            this.mBusinessActivityModel.clear();
        }
        try {
            this.mBusinessActivityModel.errno = jsonObj.getInt(C2125n.f6745M);
            this.mBusinessActivityModel.errmsg = jsonObj.getString(C2125n.f6746N);
            if (this.mBusinessActivityModel.errno == 0) {
                JSONObject dataObj = jsonObj.getJSONObject("data");
                if (dataObj != null) {
                    try {
                        JSONObject compensationObj = dataObj.getJSONObject("compensation");
                        this.mBusinessActivityModel.compensationTitle = compensationObj.getString("title");
                        this.mBusinessActivityModel.compensationLink = compensationObj.getString("link");
                    } catch (Exception e) {
                    }
                    this.mBusinessActivityModel.atype = dataObj.getInt("atype");
                    this.mBusinessActivityModel.timestamp = dataObj.getInt(C2125n.f6748P);
                    JSONArray voicesArr = dataObj.getJSONArray("voices");
                    if (voicesArr != null) {
                        for (int i = 0; i < voicesArr.length(); i++) {
                            JSONObject a = voicesArr.getJSONObject(i);
                            if (a != null) {
                                String t = a.getString(BaiduNaviParams.KEY_TIME);
                                if (t != null && t.equals("start")) {
                                    this.mBusinessActivityModel.voiceTextOnStartNavi = a.getString("voiceText");
                                    this.mBusinessActivityModel.voiceLinkOnStartNavi = a.getString("voiceLink");
                                    this.mBusinessActivityModel.voicePriorityOnStartNavi = a.getInt(LogFactory.PRIORITY_KEY);
                                } else if (t == null) {
                                    continue;
                                } else if (t.equals("end")) {
                                    this.mBusinessActivityModel.voiceTextOnEndNavi = a.getString("voiceText");
                                    this.mBusinessActivityModel.voiceLinkOnEndNavi = a.getString("voiceLink");
                                    this.mBusinessActivityModel.voicePriorityOnEndNavi = a.getInt(LogFactory.PRIORITY_KEY);
                                }
                            }
                        }
                    }
                    try {
                        JSONObject actObj = dataObj.getJSONObject(AUDIO_DIR);
                        if (actObj != null) {
                            this.mBusinessActivityModel.isOpen = actObj.getInt("open") != 0;
                            this.mBusinessActivityModel.aid = actObj.getInt("aid");
                            this.mBusinessActivityModel.title = actObj.getString("atitle");
                            this.mBusinessActivityModel.logoLink = actObj.getString("alogo");
                            this.mBusinessActivityModel.bannerLink = actObj.getString("abanner");
                            this.mBusinessActivityModel.detailsLink = actObj.getString("alink");
                            this.mBusinessActivityModel.showType = actObj.getInt("showType");
                            this.mBusinessActivityModel.showTime = actObj.getInt("showTimes");
                            JSONObject showVoiceObj = actObj.getJSONObject("showVoice");
                            if (showVoiceObj != null) {
                                this.mBusinessActivityModel.showVoiceText = showVoiceObj.getString("voiceText");
                                this.mBusinessActivityModel.showVoiceLink = showVoiceObj.getString("voiceLink");
                            }
                            this.mBusinessActivityModel.session = actObj.getString("session");
                            this.mBusinessActivityModel.ruid = actObj.getString("ruid");
                            this.mBusinessActivityModel.rtitle = actObj.getString("rtitle");
                            this.mBusinessActivityModel.riconLink = actObj.getString("ricon");
                            this.mBusinessActivityModel.rtips = actObj.getString("rtips");
                            this.mBusinessActivityModel.rtime = actObj.getInt("rtimes");
                            this.mBusinessActivityModel.anum = actObj.getInt("anum");
                            this.mBusinessActivityModel.rnum = actObj.getInt("rnum");
                        }
                    } catch (Exception e2) {
                    }
                    try {
                        JSONObject naviendObj = dataObj.getJSONObject("naviend");
                        this.mBusinessActivityModel.naviendID = naviendObj.getInt("id");
                        this.mBusinessActivityModel.naviendOpen = naviendObj.getInt("open") != 0;
                        this.mBusinessActivityModel.naviendNeedUpload = naviendObj.getInt("needUpload");
                        this.mBusinessActivityModel.naviendPicLink = naviendObj.getString("pic");
                        this.mBusinessActivityModel.naviendTips = naviendObj.getString("tips");
                        this.mBusinessActivityModel.naviendClickTips = naviendObj.getString("click_tips");
                        this.mBusinessActivityModel.naviendClickTipsColor = naviendObj.getString("click_tips_color");
                        this.mBusinessActivityModel.naviendLink = naviendObj.getString("link");
                    } catch (Exception e3) {
                    }
                    try {
                        JSONObject envelopeObj = dataObj.getJSONObject("envelope");
                        this.mBusinessActivityModel.envelopeId = envelopeObj.getInt("id");
                        JSONObject picObj = envelopeObj.getJSONObject("pics");
                        if (picObj != null) {
                            this.mBusinessActivityModel.envelopePicBtnNormal = picObj.getString("btn_pic");
                            this.mBusinessActivityModel.envelopePicBtnClicked = picObj.getString("btn_clicked_pic");
                            this.mBusinessActivityModel.envelopePicMid = picObj.getString("mid_pic");
                            this.mBusinessActivityModel.envelopePicWindowBG = picObj.getString("big_pic");
                            this.mBusinessActivityModel.envelopePicPlus = picObj.getString("plus_pic");
                        }
                        JSONObject colorObj = envelopeObj.getJSONObject("bg_detail");
                        if (colorObj != null) {
                            this.mBusinessActivityModel.envelopeWindowBtnColor = colorObj.getString("btn_color");
                            this.mBusinessActivityModel.envelopeWindowBtnTextColor = colorObj.getString("font_color");
                        }
                        this.mBusinessActivityModel.envelopeShowTimes = envelopeObj.getInt("showtimes");
                        this.mBusinessActivityModel.envelopeSoundEffectLink = envelopeObj.getString("sound_effect");
                        this.mBusinessActivityModel.envelopeDist = envelopeObj.getInt(NaviStatConstants.K_NSC_KEY_MAPGESTURE_DOUBLECLICK);
                        this.mBusinessActivityModel.envelopeAnim = envelopeObj.getInt("animation");
                        this.mBusinessActivityModel.envelopeSNum = envelopeObj.getInt("snum");
                        this.mBusinessActivityModel.envelopeUnit = envelopeObj.getString("unit");
                    } catch (Exception e4) {
                    }
                    try {
                        JSONObject userGroupth = dataObj.getJSONObject("user_growth");
                        if (userGroupth != null) {
                            this.mBusinessActivityModel.userPerCarLogoLink = userGroupth.getString("car_ico");
                            this.mBusinessActivityModel.userHistoryMileas = userGroupth.getInt("dis");
                            this.mBusinessActivityModel.userDisTips = userGroupth.getString("dis_tips");
                            this.mBusinessActivityModel.userRightUpgradeTips = userGroupth.getString("level_tips");
                            this.mBusinessActivityModel.uploadMileageInter = userGroupth.getInt("up_evd");
                            this.mBusinessActivityModel.isShowUserRight = userGroupth.getInt("show");
                        }
                    } catch (Exception e5) {
                    }
                    try {
                        JSONObject operationActivity = dataObj.getJSONObject("dialog");
                        if (operationActivity != null) {
                            this.mBusinessActivityModel.operationActivityId = operationActivity.getInt("id");
                            this.mBusinessActivityModel.operationActivityLogoLink = operationActivity.getString("pic");
                            this.mBusinessActivityModel.operationActivityLink = operationActivity.getString("link");
                            this.mBusinessActivityModel.operationActivityTime = operationActivity.getInt("times");
                        }
                    } catch (Exception e6) {
                    }
                    try {
                        JSONObject castrolConfigJSONObj = dataObj.getJSONObject("config");
                        if (castrolConfigJSONObj != null) {
                            JSONObject castrolFastRouteJSONObj = castrolConfigJSONObj.getJSONObject("castrol_faster_route");
                            if (castrolFastRouteJSONObj != null) {
                                this.mBusinessActivityModel.mCastrolFastRouteIconURL = castrolFastRouteJSONObj.getString(HUDGuideDataStruct.KEY_ICON_NAME);
                                this.mBusinessActivityModel.mCastrolFastRouteText = castrolFastRouteJSONObj.getString("text");
                            }
                        }
                    } catch (Exception e7) {
                        this.mBusinessActivityModel.mCastrolFastRouteIconURL = null;
                        this.mBusinessActivityModel.mCastrolFastRouteText = null;
                    }
                    try {
                        JSONObject voiceConfigJSONObj = dataObj.getJSONObject("config");
                        if (voiceConfigJSONObj != null) {
                            JSONObject voiceDownloadJSONObj = voiceConfigJSONObj.getJSONObject(BNVoice$VoiceUserAction.voice_download);
                            if (voiceDownloadJSONObj != null) {
                                this.mBusinessActivityModel.mIsShowVoiceNotificaiton = voiceDownloadJSONObj.getInt("open") == 1;
                                this.mBusinessActivityModel.mVoiceDetailURL = voiceDownloadJSONObj.getString("url");
                                this.mBusinessActivityModel.mVoiceIconURL = voiceDownloadJSONObj.getString(HUDGuideDataStruct.KEY_ICON_NAME);
                                this.mBusinessActivityModel.mVoiceMainTitle = voiceDownloadJSONObj.getString("title");
                                this.mBusinessActivityModel.mVoiceSubTitle = voiceDownloadJSONObj.getString("subtitle");
                                this.mBusinessActivityModel.mVoiceTaskId = voiceDownloadJSONObj.getString(NaviStatConstants.K_NSC_KEY_FINISHNAVI_VOICE_ID);
                                this.mBusinessActivityModel.mVoiceAutoHideTime = voiceDownloadJSONObj.getInt("show_sec");
                                this.mBusinessActivityModel.mVoiceShowTime = voiceDownloadJSONObj.getInt("threshold");
                            }
                        }
                    } catch (Exception e8) {
                        this.mBusinessActivityModel.mIsShowVoiceNotificaiton = false;
                    }
                }
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        return true;
    }

    public CookieStore getCookieStore() {
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

    private void requestAll() {
        requestAudio(MSG_REQUEST_AUDIO_START_NAVI);
        if (this.mHD != null) {
        }
        if (this.mHD == null) {
        }
    }

    public void requestBitmap(final int what) {
        if (this.mBusinessActivityModel != null) {
            switch (what) {
                case MSG_REQUEST_BITMAP_LOGO /*1510*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.logoLink)) {
                        requestBitmap(MSG_REQUEST_BITMAP_BANNER);
                        return;
                    }
                    this.mBusinessActivityModel.logoBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.logoLink, "");
                    if (this.mBusinessActivityModel.logoBitmap != null) {
                        requestBitmap(MSG_REQUEST_BITMAP_BANNER);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_BANNER /*1511*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.bannerLink)) {
                        requestBitmap(MSG_REQUEST_BITMAP_RICON);
                        return;
                    }
                    this.mBusinessActivityModel.bannerBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.bannerLink, "");
                    if (this.mBusinessActivityModel.bannerBitmap != null) {
                        requestBitmap(MSG_REQUEST_BITMAP_RICON);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_RICON /*1512*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.riconLink)) {
                        requestBitmap(MSG_REQUEST_BITMAP_NAVIENDPIC);
                        return;
                    }
                    this.mBusinessActivityModel.riconBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.riconLink, "");
                    if (this.mBusinessActivityModel.riconBitmap != null) {
                        requestBitmap(MSG_REQUEST_BITMAP_NAVIENDPIC);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_NAVIENDPIC /*1513*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.naviendPicLink)) {
                        requestAudio(MSG_REQUEST_AUDIO_SHOW_ACTIVITY);
                        return;
                    }
                    this.mBusinessActivityModel.naviendPicBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.naviendPicLink, "");
                    if (this.mBusinessActivityModel.naviendPicBitmap != null) {
                        requestAudio(MSG_REQUEST_AUDIO_SHOW_ACTIVITY);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_ENVELOPE_BTN_NORMAL /*1530*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicBtnNormal)) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_BTN_CLICKED);
                        return;
                    }
                    this.mBusinessActivityModel.envelopePicBtnNormalBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicBtnNormal, "");
                    if (this.mBusinessActivityModel.envelopePicBtnNormalBitmap != null) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_BTN_CLICKED);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_ENVELOPE_BTN_CLICKED /*1531*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicBtnClicked)) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_MID);
                        return;
                    }
                    this.mBusinessActivityModel.envelopePicBtnClickedBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicBtnClicked, "");
                    if (this.mBusinessActivityModel.envelopePicBtnClickedBitmap != null) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_MID);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_ENVELOPE_MID /*1532*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicMid)) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_PLUS);
                        return;
                    }
                    this.mBusinessActivityModel.envelopePicMidBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicMid, "");
                    if (this.mBusinessActivityModel.envelopePicMidBitmap != null) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_PLUS);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_ENVELOPE_PLUS /*1533*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicPlus)) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_WINDOW_BG);
                        return;
                    }
                    this.mBusinessActivityModel.envelopePicPlusBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicPlus, "");
                    if (this.mBusinessActivityModel.envelopePicPlusBitmap != null) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_WINDOW_BG);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_ENVELOPE_WINDOW_BG /*1534*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicWindowBG)) {
                        requestAudio(MSG_REQUEST_BITMAP_ENVELOPE_SOUND_EFFECT);
                        return;
                    }
                    this.mBusinessActivityModel.envelopePicWindowBGBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicWindowBG, "");
                    if (this.mBusinessActivityModel.envelopePicWindowBGBitmap != null) {
                        requestAudio(MSG_REQUEST_BITMAP_ENVELOPE_SOUND_EFFECT);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_USER_RIGHT_CAR_ICON /*1536*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.userPerCarLogoLink)) {
                        BNRouteGuider.getInstance().clearCarImage();
                        requestBitmap(MSG_REQUEST_BITMAP_OPERATION_ACTIVITY_PICTURE);
                        return;
                    }
                    this.mBusinessActivityModel.userPerCarLogoBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.userPerCarLogoLink, "");
                    if (this.mBusinessActivityModel.userPerCarLogoBitmap != null) {
                        requestBitmap(MSG_REQUEST_BITMAP_OPERATION_ACTIVITY_PICTURE);
                        if (this.mBusinessActivityModel.userPerCarLogoBitmap != null) {
                            BNRouteGuider.getInstance().setCarImageToMap(FileCache.getCacheFilePath(this.mBusinessActivityModel.userPerCarLogoLink, ""));
                            return;
                        } else {
                            BNRouteGuider.getInstance().clearCarImage();
                            return;
                        }
                    }
                    break;
                case MSG_REQUEST_BITMAP_OPERATION_ACTIVITY_PICTURE /*1538*/:
                    if (!TextUtils.isEmpty(this.mBusinessActivityModel.operationActivityLogoLink)) {
                        this.mBusinessActivityModel.operationActivityLogoBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.operationActivityLogoLink, "");
                        if (this.mBusinessActivityModel.operationActivityLogoBitmap != null) {
                            return;
                        }
                    }
                    return;
                    break;
                case MSG_REQUEST_BITMAP_USER_RIGHT_ICON_END /*1539*/:
                    if (!TextUtils.isEmpty(this.mBusinessActivityModel.userRightIconLinkEnd)) {
                        this.mBusinessActivityModel.userRightIconBitmapEnd = FileCache.loadBitmapCache(this.mBusinessActivityModel.userRightIconLinkEnd, "");
                        if (this.mBusinessActivityModel.userRightIconBitmapEnd != null) {
                            BNNaviResultController.getInstance().notifyServerDataDownloadState(DataDownloadType.IMG_DATA, DataDownloadState.DOWNLOAD_FINISH);
                            return;
                        }
                    }
                    return;
                    break;
                default:
                    return;
            }
            if (this.mBusinessActivityModel != null) {
                ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mHD, what, 10000);
                CmdGeneralHttpRequestFunc.addFunc(reqdata, new CmdGeneralHttpRequestFunc.Callback() {
                    public boolean parseResponseJSON(JSONObject jsonObj) {
                        return true;
                    }

                    public String getUrl() {
                        if (BusinessActivityManager.this.mBusinessActivityModel != null) {
                            switch (what) {
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_LOGO /*1510*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.logoLink;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_BANNER /*1511*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.bannerLink;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_RICON /*1512*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.riconLink;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_NAVIENDPIC /*1513*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.naviendPicLink;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_BTN_NORMAL /*1530*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnNormal;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_BTN_CLICKED /*1531*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnClicked;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_MID /*1532*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.envelopePicMid;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_PLUS /*1533*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.envelopePicPlus;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_WINDOW_BG /*1534*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.envelopePicWindowBG;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_USER_RIGHT_CAR_ICON /*1536*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_OPERATION_ACTIVITY_PICTURE /*1538*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.operationActivityLogoLink;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_USER_RIGHT_ICON_END /*1539*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.userRightIconLinkEnd;
                            }
                        }
                        return null;
                    }

                    public List<NameValuePair> getRequestParams() {
                        return null;
                    }

                    public int getRequestType() {
                        return 2;
                    }

                    public void responseImage(byte[] img) {
                        if (img != null) {
                            LogUtil.m15791e(BusinessActivityManager.TAG, "responseImage() what=" + what);
                            switch (what) {
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_LOGO /*1510*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.logoBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.logoLink, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_BANNER /*1511*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.bannerBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.bannerLink, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_RICON /*1512*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.riconBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.riconLink, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_NAVIENDPIC /*1513*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.naviendPicBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.naviendPicLink, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_BTN_NORMAL /*1530*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnNormalBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnNormal, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_BTN_CLICKED /*1531*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnClickedBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnClicked, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_MID /*1532*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.envelopePicMidBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicMid, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_PLUS /*1533*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.envelopePicPlusBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicPlus, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_WINDOW_BG /*1534*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.envelopePicWindowBGBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicWindowBG, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_USER_RIGHT_CAR_ICON /*1536*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_OPERATION_ACTIVITY_PICTURE /*1538*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.operationActivityLogoBitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.operationActivityLogoLink, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_USER_RIGHT_ICON_END /*1539*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.userRightIconBitmapEnd = BitmapFactory.decodeByteArray(img, 0, img.length);
                                    FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.userRightIconLinkEnd, "", img);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                CommandCenter.getInstance().sendRequest(reqdata);
            }
        }
    }

    public void requestAudio(final int what) {
        if (this.mBusinessActivityModel != null) {
            switch (what) {
                case MSG_REQUEST_AUDIO_START_NAVI /*1514*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.voiceLinkOnStartNavi)) {
                        requestBitmap(MSG_REQUEST_BITMAP_LOGO);
                        BusinessActivityPlayerManager.getInstance().playNaviStartContent();
                        return;
                    }
                    this.mBusinessActivityModel.voicePathOnStartNavi = FileCache.getCacheFilePath(this.mBusinessActivityModel.voiceLinkOnStartNavi, "");
                    if (!TextUtils.isEmpty(this.mBusinessActivityModel.voicePathOnStartNavi)) {
                        requestBitmap(MSG_REQUEST_BITMAP_LOGO);
                        BusinessActivityPlayerManager.getInstance().playNaviStartContent();
                        return;
                    }
                    break;
                case MSG_REQUEST_AUDIO_END_NAVI /*1515*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.voiceLinkOnEndNavi)) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_BTN_NORMAL);
                        return;
                    }
                    this.mBusinessActivityModel.voicePathOnEndNavi = FileCache.getCacheFilePath(this.mBusinessActivityModel.voiceLinkOnEndNavi, "");
                    if (!TextUtils.isEmpty(this.mBusinessActivityModel.voicePathOnEndNavi)) {
                        requestBitmap(MSG_REQUEST_BITMAP_ENVELOPE_BTN_NORMAL);
                        return;
                    }
                    break;
                case MSG_REQUEST_AUDIO_SHOW_ACTIVITY /*1516*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.showVoiceLink)) {
                        requestAudio(MSG_REQUEST_AUDIO_END_NAVI);
                        return;
                    }
                    this.mBusinessActivityModel.showVoicePath = FileCache.getCacheFilePath(this.mBusinessActivityModel.showVoiceLink, "");
                    if (!TextUtils.isEmpty(this.mBusinessActivityModel.showVoicePath)) {
                        requestAudio(MSG_REQUEST_AUDIO_END_NAVI);
                        return;
                    }
                    break;
                case MSG_REQUEST_BITMAP_ENVELOPE_SOUND_EFFECT /*1535*/:
                    if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopeSoundEffectLink)) {
                        requestBitmap(MSG_REQUEST_BITMAP_USER_RIGHT_CAR_ICON);
                        return;
                    }
                    this.mBusinessActivityModel.envelopeSoundEffectPath = FileCache.getCacheFilePath(this.mBusinessActivityModel.envelopeSoundEffectLink, "");
                    if (!TextUtils.isEmpty(this.mBusinessActivityModel.envelopeSoundEffectPath)) {
                        requestBitmap(MSG_REQUEST_BITMAP_USER_RIGHT_CAR_ICON);
                        return;
                    }
                    break;
                default:
                    return;
            }
            if (this.mBusinessActivityModel != null) {
                ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mHD, what, 10000);
                CmdGeneralHttpRequestFunc.addFunc(reqdata, new CmdGeneralHttpRequestFunc.Callback() {
                    public boolean parseResponseJSON(JSONObject jsonObj) {
                        return true;
                    }

                    public String getUrl() {
                        if (BusinessActivityManager.this.mBusinessActivityModel != null) {
                            switch (what) {
                                case BusinessActivityManager.MSG_REQUEST_AUDIO_START_NAVI /*1514*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.voiceLinkOnStartNavi;
                                case BusinessActivityManager.MSG_REQUEST_AUDIO_END_NAVI /*1515*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.voiceLinkOnEndNavi;
                                case BusinessActivityManager.MSG_REQUEST_AUDIO_SHOW_ACTIVITY /*1516*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.showVoiceLink;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_SOUND_EFFECT /*1535*/:
                                    return BusinessActivityManager.this.mBusinessActivityModel.envelopeSoundEffectLink;
                            }
                        }
                        return null;
                    }

                    public List<NameValuePair> getRequestParams() {
                        return null;
                    }

                    public int getRequestType() {
                        return 2;
                    }

                    public void responseImage(byte[] img) {
                        if (img != null) {
                            LogUtil.m15791e(BusinessActivityManager.TAG, "responseImage() audio. what=" + what);
                            switch (what) {
                                case BusinessActivityManager.MSG_REQUEST_AUDIO_START_NAVI /*1514*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.voicePathOnStartNavi = FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.voiceLinkOnStartNavi, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_AUDIO_END_NAVI /*1515*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.voicePathOnEndNavi = FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.voiceLinkOnEndNavi, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_AUDIO_SHOW_ACTIVITY /*1516*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.showVoicePath = FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.showVoiceLink, "", img);
                                    return;
                                case BusinessActivityManager.MSG_REQUEST_BITMAP_ENVELOPE_SOUND_EFFECT /*1535*/:
                                    BusinessActivityManager.this.mBusinessActivityModel.envelopeSoundEffectPath = FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopeSoundEffectLink, "", img);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                CommandCenter.getInstance().sendRequest(reqdata);
            }
        }
    }

    private void saveFile(byte[] fileData, String dir, String fileName) {
        if (fileData != null && !TextUtils.isEmpty(dir) && !TextUtils.isEmpty(fileName)) {
            File audioDir = new File(dir);
            if (!audioDir.exists()) {
                audioDir.mkdirs();
            }
            File audioFile = new File(dir + fileName);
            audioFile.deleteOnExit();
            try {
                audioFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(audioFile);
                fos.write(fileData);
                fos.flush();
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public void updateGPSFixed(boolean isFixed) {
        if (!isFixed && this.mBusinessActivityModel != null) {
            this.mBusinessActivityModel.resetTrafficJam();
            this.mBusinessActivityModel.resetParking();
            BusinessActivityViewManager.getInstance().hideViews();
        }
    }

    public void updateGPSSpeed(double speed) {
        if (this.mBusinessActivityModel != null) {
            if (!this.mBusinessActivityModel.isOpen) {
                LogUtil.m15791e(TAG, "updateGPSSpeed() return for activity is not open.");
            } else if (BusinessActivityViewManager.getInstance().isShowing()) {
                LogUtil.m15791e(TAG, "updateGPSSpeed() return for activity is showing.");
            } else if (this.mBusinessActivityModel.isTrafficJam || this.mBusinessActivityModel.isParking) {
                LogUtil.m15791e(TAG, "updateGPSSpeed() return for isTrafficJam=" + this.mBusinessActivityModel.isTrafficJam + ", isParking=" + this.mBusinessActivityModel.isParking);
            } else {
                int nSpeed = (int) ((3.6d * speed) + 0.5d);
                if (nSpeed > 20) {
                    LogUtil.m15791e(TAG, "updateGPSSpeed() return for speed over and hide views.");
                } else if (BusinessActivityViewManager.getInstance().isShowing() || (getInstance().getModel().hasShowActivityCount < getInstance().getModel().anum && getInstance().getModel().hasClickActivityCount < getInstance().getModel().rnum)) {
                    int navidist = (int) JNITrajectoryControl.sInstance.getTrajectoryLength(JNITrajectoryControl.sInstance.getCurrentUUID());
                    LogUtil.m15791e(TAG, "updateGPSSpeed() navidist=" + navidist);
                    if (checkTrafficJam(nSpeed, navidist)) {
                        BusinessActivityViewManager.getInstance().showViews(BNavigator.getInstance().getActivity(), false);
                        return;
                    }
                    int ret = checkParking(nSpeed, navidist);
                    if (ret == 0 || ret == 1) {
                        BusinessActivityViewManager.getInstance().hideViews();
                    } else if (ret == 2) {
                        BusinessActivityViewManager.getInstance().showViews(BNavigator.getInstance().getActivity(), false);
                    }
                } else {
                    LogUtil.m15791e(TAG, "updateGPSSpeed() return . received=" + getInstance().getModel().isPrizeReceived + ", hasShowCount=" + getInstance().getModel().hasShowActivityCount);
                }
            }
        }
    }

    public boolean checkTrafficJam(int speed, int naviDis) {
        if (!this.mBusinessActivityModel.isTrafficJamEnabled()) {
            LogUtil.m15791e(TAG, "checkTrafficJam() check failed for disable");
            return false;
        } else if (speed >= 20 || naviDis < 200) {
            this.mBusinessActivityModel.resetTrafficJam();
            LogUtil.m15791e(TAG, "checkTrafficJam() check failed for speed=" + speed + ", naviDis=" + naviDis);
            return false;
        } else {
            Bundle totalInfo = RGSimpleGuideModel.getInstance().getTotalInfo();
            if (totalInfo == null || !totalInfo.containsKey(SimpleGuideInfo.TotalDist)) {
                this.mBusinessActivityModel.resetTrafficJam();
                LogUtil.m15791e(TAG, "checkTrafficJam() check failed for total guide info not exists");
                return false;
            }
            int remainTotalDist = totalInfo.getInt(SimpleGuideInfo.TotalDist);
            if (remainTotalDist <= 0) {
                this.mBusinessActivityModel.resetTrafficJam();
                LogUtil.m15791e(TAG, "checkTrafficJam() check failed for remainTotalDist=" + remainTotalDist);
                return false;
            }
            List<RoadConditionItem> list = RGAssistGuideModel.getInstance().getRoadConditionData();
            if (list == null) {
                LogUtil.m15791e(TAG, "checkTrafficJam() check failed for road condition is null");
                return false;
            }
            int curIndex = (int) (RGAssistGuideModel.getInstance().getCarProgress() * ((double) ((RoadConditionItem) list.get(list.size() - 1)).curItemEndIndex));
            int itemIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                if (curIndex < ((RoadConditionItem) list.get(i)).curItemEndIndex) {
                    itemIndex = i;
                    break;
                }
            }
            if (curIndex < 0) {
                LogUtil.m15791e(TAG, "checkTrafficJam() check failed for road condition item index < 0.");
                return false;
            } else if (this.mBusinessActivityModel.lastRoadConditionItemIndex == itemIndex) {
                LogUtil.m15791e(TAG, "checkTrafficJam() check failed for road condition item index is same. itemIndex=" + itemIndex);
                return false;
            } else {
                int totalDist;
                if (RGAssistGuideModel.getInstance().getCarProgress() <= 0.0d) {
                    totalDist = remainTotalDist;
                } else {
                    totalDist = (int) (((double) remainTotalDist) / (1.0d - RGAssistGuideModel.getInstance().getCarProgress()));
                }
                int rcIndexCount = getObstructionIndexCount(list, itemIndex);
                if (rcIndexCount > 0) {
                    rcIndexCount += getObstructionIndexCount(list, itemIndex + 1);
                }
                if (rcIndexCount == 0) {
                    LogUtil.m15791e(TAG, "checkTrafficJam() check failed for rcIndexCount=0");
                    return false;
                }
                int obsDist = (int) ((((double) totalDist) * ((double) rcIndexCount)) / ((double) ((RoadConditionItem) list.get(list.size() - 1)).curItemEndIndex));
                LogUtil.m15791e(TAG, "checkTrafficJam() remainDist=" + remainTotalDist + ", totalDist=" + totalDist + ", itemIndex=" + itemIndex + ", rcIndexCount=" + rcIndexCount + ", obsDist=" + obsDist);
                if (obsDist >= 10) {
                    this.mBusinessActivityModel.isTrafficJam = true;
                    this.mBusinessActivityModel.lastRoadConditionItemIndex = itemIndex;
                    LogUtil.m15791e(TAG, "checkTrafficJam() check ok  speed=" + speed);
                    if (LogUtil.LOGGABLE) {
                        TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "拥堵触发商业水滴显示, obsDist=" + obsDist);
                    }
                    return true;
                }
                LogUtil.m15791e(TAG, "checkTrafficJam() check failed for obsDist=" + obsDist);
                this.mBusinessActivityModel.resetTrafficJam();
                return false;
            }
        }
    }

    private int getObstructionIndexCount(List<RoadConditionItem> list, int itemIndex) {
        if (itemIndex < 0 || itemIndex >= list.size() || ((RoadConditionItem) list.get(itemIndex)).roadConditionType < 3) {
            return 0;
        }
        int count;
        if (itemIndex == 0) {
            count = ((RoadConditionItem) list.get(itemIndex)).curItemEndIndex;
        } else {
            count = ((RoadConditionItem) list.get(itemIndex)).curItemEndIndex - ((RoadConditionItem) list.get(itemIndex - 1)).curItemEndIndex;
        }
        LogUtil.m15791e(TAG, "getObstructionIndexCount() itemIndex=" + itemIndex + ", roadConditionType=" + ((RoadConditionItem) list.get(itemIndex)).roadConditionType + ", count=" + count);
        return count;
    }

    private int checkParking(int speed, int naviDis) {
        if (!this.mBusinessActivityModel.isParkingEnabled()) {
            LogUtil.m15791e(TAG, "checkParking() check failed for disable");
            return 0;
        } else if (speed >= 3 || naviDis < 200) {
            this.mBusinessActivityModel.resetParking();
            LogUtil.m15791e(TAG, "checkParking() check failed. speed=" + speed + ", naviDis=" + naviDis);
            return 0;
        } else if (RGSimpleGuideModel.getInstance().getNextGuideInfo() != null && RGSimpleGuideModel.getInstance().getNextGuideInfo().containsKey(SimpleGuideInfo.RemainDist) && 50 < RGSimpleGuideModel.getInstance().getNextGuideInfo().getInt(SimpleGuideInfo.RemainDist)) {
            this.mBusinessActivityModel.resetParking();
            LogUtil.m15791e(TAG, "checkParking() check failed. nextTurnDist=" + RGSimpleGuideModel.getInstance().getNextGuideInfo().getInt(SimpleGuideInfo.RemainDist));
            return 0;
        } else if (this.mBusinessActivityModel.parkingStartTime <= 0) {
            this.mBusinessActivityModel.parkingStartTime = SystemClock.elapsedRealtime();
            LogUtil.m15791e(TAG, "checkParking() check time 1 ");
            return 1;
        } else if (SystemClock.elapsedRealtime() - this.mBusinessActivityModel.parkingStartTime > Config.BPLUS_DELAY_TIME) {
            this.mBusinessActivityModel.isParking = true;
            LogUtil.m15791e(TAG, "checkParking() check ok speed=" + speed);
            if (LogUtil.LOGGABLE) {
                TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "停车触发商业水滴显示");
            }
            return 2;
        } else {
            LogUtil.m15791e(TAG, "checkParking() check time 2 ");
            return 1;
        }
    }

    public boolean isNeedUploadData() {
        if (VERSION.SDK_INT >= 23) {
            if (BNSysLocationManager.getInstance().isMock()) {
                return false;
            }
            return true;
        } else if (getModel() != null) {
            return getModel().isNeedUploadDataFromLocal;
        } else {
            return false;
        }
    }

    public void uploadData(Handler outHDForUpload, int what) {
        if (isNeedUploadData()) {
            if (JNITrajectoryControl.sInstance.getTrajectoryLength(JNITrajectoryControl.sInstance.getCurrentUUID()) != 0 && this.mBusinessActivityModel != null) {
                this.mOuterUploadHandler = outHDForUpload;
                this.mOuterUploadMsgWhat = what;
                Bundle postBundle = new Bundle();
                JNITrajectoryControl.sInstance.getPostParams(this.mBusinessActivityModel.atype, postBundle);
                this.mBusinessActivityModel.uploadBundleData = postBundle;
                BNNaviResultController.getInstance().notifyServerDataDownloadState(DataDownloadType.TXT_DATA, DataDownloadState.DOWNLOADING);
                BNNaviResultController.getInstance().notifyServerDataDownloadState(DataDownloadType.IMG_DATA, DataDownloadState.DOWNLOADING);
                if (!(this.mBusinessActivityModel.isUploadDataContainsValidBduss() || TextUtils.isEmpty(BNaviModuleManager.getBduss()))) {
                    String bduss = BNaviModuleManager.getBduss();
                    Bundle postBD = new Bundle();
                    JNITrajectoryControl.sInstance.getPostParamsForBdussUpdated(postBD, bduss);
                    LogUtil.m15791e(TAG, "reload upload Data. uploadData=" + postBD.toString());
                    getInstance().getModel().uploadBundleData = postBD;
                }
                ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPPOST_FUNC, 7, this.mHD, 1501, 5000);
                reqdata.mCookieStore = getCookieStore();
                CmdGeneralHttpPostFunc.addFunc(reqdata, new C41514());
                CommandCenter.getInstance().sendRequest(reqdata);
                return;
            }
            return;
        }
        UserOPController.getInstance().add(UserOPParams.EXCEPTION_7_3);
        LogUtil.m15791e(TAG, "uploadData() return for not.");
    }

    private boolean parseUploadJSON(JSONObject jsonObj) {
        if (jsonObj == null || this.mBusinessActivityModel == null) {
            return false;
        }
        try {
            LogUtil.m15791e(TAG, "parseUploadJSON() uploadData --> " + jsonObj.toString());
            this.mBusinessActivityModel.uploadRespErrNo = jsonObj.getInt(C2125n.f6745M);
            this.mBusinessActivityModel.uploadRespMsg = jsonObj.getString(C2125n.f6746N);
            JSONObject dataJson = jsonObj.getJSONObject("data");
            if (dataJson != null) {
                try {
                    this.mBusinessActivityModel.uploadRespTips = dataJson.getString("tips");
                    this.mBusinessActivityModel.uploadRespClickTips = dataJson.getString("click_tips");
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        e.printStackTrace();
                    }
                }
            }
            if (dataJson != null) {
                try {
                    if (dataJson.has("yellow_tip")) {
                        JSONObject yellowGroup = dataJson.getJSONObject("yellow_tip");
                        if (yellowGroup != null && yellowGroup.has("is_show")) {
                            this.mBusinessActivityModel.yellowBanner = yellowGroup.getInt("is_show");
                        }
                    }
                } catch (Exception e2) {
                    if (LogUtil.LOGGABLE) {
                        e2.printStackTrace();
                    }
                }
            }
            JSONObject userGroup = dataJson.getJSONObject("growth");
            if (userGroup != null) {
                if (userGroup.has("title")) {
                    this.mBusinessActivityModel.userRightTitleEnd = userGroup.getString("title");
                }
                if (userGroup.has(HUDGuideDataStruct.KEY_ICON_NAME)) {
                    this.mBusinessActivityModel.userRightIconLinkEnd = userGroup.getString(HUDGuideDataStruct.KEY_ICON_NAME);
                }
                if (userGroup.has("tips")) {
                    this.mBusinessActivityModel.userRightTipsEnd = userGroup.getString("tips");
                }
                if (userGroup.has("c_tips")) {
                    this.mBusinessActivityModel.userRightEnterTips = userGroup.getString("c_tips");
                }
                if (userGroup.has("hlink")) {
                    this.mBusinessActivityModel.userRightEnterLink = userGroup.getString("hlink");
                }
                if (userGroup.has(PlatformConstants.CONNECT_EXTRA_KEY)) {
                    this.mBusinessActivityModel.userRightUpgradeFrom = userGroup.getInt(PlatformConstants.CONNECT_EXTRA_KEY);
                }
                if (userGroup.has("to")) {
                    this.mBusinessActivityModel.userRightUpgradeTo = userGroup.getInt("to");
                }
                if (userGroup.has("privilege")) {
                    JSONArray privilegeList = userGroup.getJSONArray("privilege");
                    if (privilegeList != null) {
                        int size = privilegeList.length();
                        for (int index = 0; index < size; index++) {
                            JSONObject privilege = privilegeList.getJSONObject(index);
                            NaviEndPrivilege naviEndPrivilege = new NaviEndPrivilege();
                            try {
                                naviEndPrivilege.cardType = privilege.getString("card_type");
                                naviEndPrivilege.hint = privilege.getString("hint");
                                naviEndPrivilege.unlock = privilege.getInt("unlock");
                                naviEndPrivilege.tip = privilege.getString("tip");
                                if (privilege.has("hlink")) {
                                    naviEndPrivilege.hlink = privilege.getString("hlink");
                                }
                                if (privilege.has("hicon")) {
                                    naviEndPrivilege.hicon = privilege.getString("hicon");
                                }
                                if (privilege.has("list")) {
                                    JSONArray contentList = privilege.getJSONArray("list");
                                    if (contentList != null) {
                                        int count = contentList.length();
                                        naviEndPrivilege.list = new String[count];
                                        for (int i = 0; i < count; i++) {
                                            naviEndPrivilege.list[i] = contentList.getString(i);
                                        }
                                    }
                                }
                                this.mBusinessActivityModel.naviEndPrivilegesList.add(naviEndPrivilege);
                            } catch (Exception e3) {
                            }
                        }
                    }
                }
            }
        } catch (Exception e22) {
            if (LogUtil.LOGGABLE) {
                e22.printStackTrace();
            }
        }
        return true;
    }

    public void uploadDataForNaving(Handler outHDForUpload, int what) {
        if (!isNeedUploadData()) {
            LogUtil.m15791e(TAG, "uploadDataForNaving() return for not.");
        } else if (this.mBusinessActivityModel != null) {
            this.mOuterUploadHandlerForNaving = outHDForUpload;
            this.mOuterUploadMsgWhatForNaving = what;
            if (!(this.mBusinessActivityModel.isUploadDataContainsValidBdussoForNaving() || TextUtils.isEmpty(BNaviModuleManager.getBduss()))) {
                String bduss = BNaviModuleManager.getBduss();
                Bundle postBD = new Bundle();
                JNITrajectoryControl.sInstance.getPostParamsForBdussUpdated(postBD, bduss);
                LogUtil.m15791e(TAG, "reload upload Data. uploadData=" + postBD.toString());
                this.mBusinessActivityModel.uploadBundleDataForNaving = postBD;
            }
            ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPPOST_FUNC, 7, this.mHD, MSG_BUSINESSACTIVITY_UPLOAD_RET_FOR_NAVING, 10000);
            reqdata.mCookieStore = getCookieStore();
            CmdGeneralHttpPostFunc.addFunc(reqdata, new C41525());
            CommandCenter.getInstance().sendRequest(reqdata);
        }
    }

    private boolean parseUploadJSONForNaving(JSONObject jsonObj) {
        if (jsonObj == null || this.mBusinessActivityModel == null) {
            return false;
        }
        try {
            LogUtil.m15791e(TAG, "parseUploadJSONForNaving() json --> " + jsonObj.toString());
            this.mBusinessActivityModel.uploadRespErrNoForNaving = jsonObj.getInt(C2125n.f6745M);
            this.mBusinessActivityModel.uploadRespMsgForNaving = jsonObj.getString(C2125n.f6746N);
        } catch (Exception e) {
        }
        return true;
    }

    public void getShareData(Handler handle, int what) {
        if (this.mBusinessActivityModel != null) {
            this.mOutShareHandler = handle;
            this.mOutShareMsgWhat = what;
            if (!(this.mBusinessActivityModel.isUploadDataContainsValidBduss() || TextUtils.isEmpty(BNaviModuleManager.getBduss()))) {
                String bduss = BNaviModuleManager.getBduss();
                Bundle postBD = new Bundle();
                JNITrajectoryControl.sInstance.getPostParamsForBdussUpdated(postBD, bduss);
                LogUtil.m15791e(TAG, "reload upload Data. uploadData=" + postBD.toString());
                this.mBusinessActivityModel.uploadBundleData = postBD;
            }
            if (this.mBusinessActivityModel.uploadBundleData == null) {
                Bundle postBundle = new Bundle();
                JNITrajectoryControl.sInstance.getPostParams(this.mBusinessActivityModel.atype, postBundle);
                this.mBusinessActivityModel.uploadBundleData = postBundle;
            }
            BNHttpParams httpParams = new BNHttpParams();
            httpParams.isAsync = true;
            String filePath = JNITrajectoryControl.sInstance.getTrajecotryFilePath(JNITrajectoryControl.sInstance.getCurrentUUID());
            if (filePath != null) {
                httpParams.fileKey = "datafile";
                httpParams.file = new File(filePath);
            }
            HashMap<String, String> normapParams = new HashMap();
            StringBuffer sb = new StringBuffer();
            try {
                String tmpS = this.mBusinessActivityModel.uploadBundleData.containsKey("pcBduss") ? this.mBusinessActivityModel.uploadBundleData.getString("pcBduss") : "";
                normapParams.put("bduss", tmpS);
                sb.append("bduss=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = this.mBusinessActivityModel.uploadBundleData.containsKey("pcCuid") ? this.mBusinessActivityModel.uploadBundleData.getString("pcCuid") : "";
                normapParams.put("cuid", tmpS);
                sb.append("&cuid=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = this.mBusinessActivityModel.uploadBundleData.containsKey("pcGuid") ? this.mBusinessActivityModel.uploadBundleData.getString("pcGuid") : "";
                normapParams.put("guid", tmpS);
                sb.append("&guid=" + URLEncoder.encode(tmpS, "utf-8"));
                tmpS = this.mBusinessActivityModel.uploadBundleData.containsKey("pcNaviActInfo") ? this.mBusinessActivityModel.uploadBundleData.getString("pcNaviActInfo") : "";
                normapParams.put("navi_info", tmpS);
                sb.append("&navi_info=" + URLEncoder.encode(tmpS, "utf-8"));
                normapParams.put("st", "" + this.mBusinessActivityModel.timestamp);
                sb.append("&st=" + URLEncoder.encode("" + this.mBusinessActivityModel.timestamp, "utf-8"));
                normapParams.put("sv", PackageUtil.getVersionName());
                sb.append("&sv=" + URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
                tmpS = JNITrajectoryControl.sInstance.getUrlParamsSign(sb.toString());
                if (TextUtils.isEmpty(tmpS)) {
                    tmpS = "";
                }
                normapParams.put("sign", tmpS);
                sb.append("&sign=" + URLEncoder.encode(tmpS, "utf-8"));
                BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_NAV_END_SHARE), normapParams, new C41536(), httpParams);
            } catch (Exception e) {
            }
        }
    }

    private boolean parseShareJSON(JSONObject jsonObj) {
        if (jsonObj == null || this.mBusinessActivityModel == null) {
            return false;
        }
        try {
            this.mBusinessActivityModel.shareRespErrNo = jsonObj.getInt(C2125n.f6745M);
            this.mBusinessActivityModel.shareRespMsg = jsonObj.getString(C2125n.f6746N);
            JSONObject dataJson = jsonObj.getJSONObject("data");
            if (dataJson != null) {
                this.mBusinessActivityModel.shareTitle = dataJson.getString("title");
                this.mBusinessActivityModel.sharePicLink = dataJson.getString("pic");
                this.mBusinessActivityModel.shareContentLink = dataJson.getString("link");
                this.mBusinessActivityModel.shareDesc = dataJson.getString("desc");
            }
        } catch (Exception e) {
        }
        return true;
    }

    public void onYawing() {
        if (this.mBusinessActivityModel != null) {
            getInstance().getModel().resetTrafficJam();
            getInstance().getModel().resetParking();
            getInstance().getModel().lastRoadConditionItemIndex = -1;
            BusinessActivityViewManager.getInstance().hideViews();
        }
    }

    public void releaseAllRes() {
        BusinessActivityPlayerManager.getInstance().cancelPlayAudioAndPlayMsg();
        if (this.mBusinessActivityModel != null) {
            this.mBusinessActivityModel.clear();
        }
        if (this.mHD != null) {
            if (this.mHD.hasMessages(MSG_BUSINESSACTIVITY_UPLOAD_REQUEST_FOR_NAVING)) {
                this.mHD.removeMessages(MSG_BUSINESSACTIVITY_UPLOAD_REQUEST_FOR_NAVING);
            }
            BNWorkerCenter.getInstance().cancelTask(this.mUploadMileaTask, false);
        }
        this.mOuterHandler = null;
        this.mOuterUploadHandler = null;
        this.mOuterUploadHandlerForNaving = null;
        this.mOutShareHandler = null;
        this.mLastMilea = 0;
    }

    private void shareSafety(String shareUrl, String shareIcon, String shareTitle, String shareDesc) {
        if (this.isCancelShareSafe) {
            LogUtil.m15791e(TAG, "safety shareSafety  --> isCancelShareSafe: " + this.isCancelShareSafe);
            return;
        }
        getInstance().isShareSuc = true;
        Bundle bd = new Bundle();
        bd.putBoolean("OrientationUser", this.isOrientationUser);
        bd.putString("LinkUrl", shareUrl);
        bd.putString("ImgUrl", shareIcon);
        bd.putString("Title", shareTitle);
        bd.putString("Desc", shareDesc);
        BNaviModuleManager.shareSafety(bd);
        RGSimpleGuideModel.mIsSafetyShareGuideShow = true;
        if (RGMapModeViewController.getInstance().getSafetyViewContails() != null) {
            RGMapModeViewController.getInstance().getSafetyViewContails().setVisibility(0);
        }
        BNLightNaviManager.getInstance().showSafetyGuide(true);
    }

    public void safetyUpload(final int action, boolean orientationUser) {
        LogUtil.m15791e(TAG, "safety safetyUpload  --> action: " + action + "  isShareSuc: " + this.isShareSuc);
        if ((action != 1 && action != 2) || this.isShareSuc) {
            if (!CloudlConfigDataModel.getInstance().mCommonConfig.safetyShow) {
                TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "行程分享敬请期待...");
            } else if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                if (action != 0 || BNRouteGuider.getInstance().isCurDriveRouteOnline()) {
                    this.isOrientationUser = orientationUser;
                    int msgWhat = MSG_NAV_SAFETY_SHARE_END;
                    if (action == 0) {
                        this.isCancelShareSafe = false;
                        if (orientationUser) {
                            RGViewController.getInstance().showSafetyShareLoading();
                        } else {
                            LightNaviDialogHelper.getInstance(BNaviModuleManager.getContext()).showSafetyShareDialog().setOnCancelListener(new C41569());
                        }
                        msgWhat = MSG_NAV_SAFETY_SHARE_START;
                    } else if (action == 1) {
                        msgWhat = MSG_NAV_SAFETY_SHARE_END;
                    } else if (action == 2) {
                        msgWhat = MSG_NAV_SAFETY_SHARE_CHANGE;
                    }
                    ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPPOST_FUNC, 7, this.mHD, msgWhat, 10000);
                    reqdata.mCookieStore = getCookieStore();
                    CmdGeneralHttpPostFunc.addFunc(reqdata, new Callback() {
                        public boolean parseResponseJSON(JSONObject jsonObj) {
                            return true;
                        }

                        public String getUrl() {
                            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_SAFETY_SHARE);
                        }

                        public List<NameValuePair> getRequestParams() {
                            try {
                                double startX;
                                double startY;
                                LocData locData;
                                List<NameValuePair> params = new ArrayList();
                                params.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
                                params.add(new BasicNameValuePair("os", "0"));
                                if (action == 0 || action == 2) {
                                    RoutePlanNode startNode = BusinessActivityManager.this.rpModel.getStartNode();
                                    RoutePlanNode endNode = BusinessActivityManager.this.rpModel.getEndNode();
                                    startX = -1.0d;
                                    startY = -1.0d;
                                    double endX = -1.0d;
                                    double endY = -1.0d;
                                    if (startNode != null) {
                                        startX = ((double) startNode.mGeoPoint.getLongitudeE6()) / 100000.0d;
                                        startY = ((double) startNode.mGeoPoint.getLatitudeE6()) / 100000.0d;
                                    }
                                    if (endNode != null) {
                                        endX = ((double) endNode.mGeoPoint.getLongitudeE6()) / 100000.0d;
                                        endY = ((double) endNode.mGeoPoint.getLatitudeE6()) / 100000.0d;
                                    }
                                    String startGeoStr = startX + "," + startY;
                                    String endGeoStr = endX + "," + endY;
                                    params.add(new BasicNameValuePair("from_point", startGeoStr));
                                    params.add(new BasicNameValuePair("to_point", endGeoStr));
                                    Bundle bundle = new Bundle();
                                    String sessionId = "";
                                    String mrsl = "";
                                    BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl(bundle);
                                    if (bundle != null) {
                                        sessionId = bundle.getString("session");
                                        mrsl = bundle.getString(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_MRSL);
                                    }
                                    params.add(new BasicNameValuePair("session_id", sessionId));
                                    params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_MRSL, mrsl));
                                }
                                params.add(new BasicNameValuePair("osv", "" + PackageUtil.getSystemVersion()));
                                params.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
                                params.add(new BasicNameValuePair(VoiceKey.ACTION, "" + action));
                                startX = -1.0d;
                                startY = -1.0d;
                                if (BNSysLocationManager.getInstance().isSysLocationValid()) {
                                    locData = BNSysLocationManager.getInstance().getCurLocation();
                                } else {
                                    locData = BNExtGPSLocationManager.getInstance().getCurLocation();
                                }
                                if (locData != null) {
                                    startX = locData.longitude;
                                    startY = locData.latitude;
                                }
                                params.add(new BasicNameValuePair("current_point", startX + "," + startY));
                                String ascendParamStr = CloudConfigObtainManager.SortSequenceWithAscendingOder(params);
                                String tmpS = JNITrajectoryControl.sInstance.getUrlParamsSign(ascendParamStr);
                                if (TextUtils.isEmpty(tmpS)) {
                                    tmpS = "";
                                }
                                params.add(new BasicNameValuePair("sign", tmpS));
                                LogUtil.m15791e(BusinessActivityManager.TAG, "safetyUpload() uploadPs=" + ascendParamStr);
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
                    });
                    CommandCenter.getInstance().sendRequest(reqdata);
                    return;
                }
                TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "无网或离线导航不能分享");
            } else if (action == 0) {
                TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "无网或离线导航不能分享");
            }
        }
    }
}
