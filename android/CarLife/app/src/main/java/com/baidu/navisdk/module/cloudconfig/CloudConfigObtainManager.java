package com.baidu.navisdk.module.cloudconfig;

import android.net.http.Headers;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navi.protocol.model.HUDGuideDataStruct;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.module.car.BNYellowBannerTipsModel;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository;
import com.baidu.navisdk.module.ugc.utils.UgcMapsViewConstructor;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel.UgcBaseDataModel;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.vi.VDeviceAPI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudConfigObtainManager {
    private static final int ERRNO_RET_NOUPDATE = 304;
    private static final int ERRNO_RET_UPDATE = 0;
    private static final int MSG_CLOUD_CONFIG_DATA_REQUEST_RET = 1;
    private static final int MSG_CLOUD_CONFIG_DATA_UPDATE_RET = 2;
    public static final String TAG = CloudConfigObtainManager.class.getName();
    private DataCacheManager mDataCacheManager;
    private Handler mUgcHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg != null) {
                if (msg.what == 1) {
                    if (msg.arg1 == 0 && CloudlConfigDataModel.getInstance().isWebDataValid && UgcOperationalActModel.getInstance().isWebDataValid) {
                        CloudConfigObtainManager.this.informModulesAftUpdate();
                        return;
                    }
                    CloudConfigObtainManager.this.getUgcDataFromFile();
                    CloudConfigObtainManager.this.informModulesAftUpdate();
                } else if (msg.what == 2) {
                    CloudConfigObtainManager.this.informModulesAftUpdate();
                }
            }
        }
    };

    /* renamed from: com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager$1 */
    class C41631 implements Callback {
        C41631() {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            boolean ret = CloudConfigObtainManager.this.parseUgcOperationalActJSON(jsonObj);
            if (!ret) {
                LogUtil.m15791e(CloudConfigObtainManager.TAG, "parseResponseJSON failed");
            } else if (LogUtil.LOGGABLE) {
                UgcOperationalActModel.getInstance().showSpecificDataLog();
            }
            if (ret) {
                UgcOperationalActModel.getInstance().isWebDataValid = true;
                CloudlConfigDataModel.getInstance().isWebDataValid = true;
            } else {
                UgcOperationalActModel.getInstance().isWebDataValid = false;
                CloudlConfigDataModel.getInstance().isWebDataValid = false;
            }
            return ret;
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_INIT_CLOUD_CONFIG);
        }

        public List<NameValuePair> getRequestParams() {
            return CloudConfigObtainManager.this.getServiceReqParam();
        }

        public int getRequestType() {
            return 1;
        }

        public void responseImage(byte[] img) {
        }
    }

    private List<NameValuePair> getServiceReqParam() {
        List<NameValuePair> list;
        Exception e;
        try {
            List<NameValuePair> params = new ArrayList();
            try {
                StringBuffer sb = new StringBuffer();
                String paramTmp = PackageUtil.getCuid() + "";
                params.add(new BasicNameValuePair("cuid", paramTmp));
                sb.append("cuid=" + URLEncoder.encode(paramTmp, "utf-8"));
                params.add(new BasicNameValuePair("sid", "1"));
                sb.append("&sid=" + URLEncoder.encode("1", "utf-8"));
                params.add(new BasicNameValuePair("os", "0"));
                sb.append("&os=" + URLEncoder.encode("0", "utf-8"));
                paramTmp = "10.1.0";
                params.add(new BasicNameValuePair("sv", paramTmp));
                sb.append("&sv=" + URLEncoder.encode(paramTmp, "utf-8"));
                paramTmp = PackageUtil.strOSVersion + "";
                params.add(new BasicNameValuePair("osv", paramTmp));
                sb.append("&osv=" + URLEncoder.encode(paramTmp, "utf-8"));
                paramTmp = getCurrentCityId() + "";
                params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYCODE, paramTmp));
                sb.append("&cityCode=" + URLEncoder.encode(paramTmp, "utf-8"));
                params.add(new BasicNameValuePair("mb", VDeviceAPI.getPhoneType()));
                sb.append("&mb=" + URLEncoder.encode(VDeviceAPI.getPhoneType()));
                String tmpS = VoiceHelper.getInstance().getCurrentUsedTTSId();
                if (TextUtils.isEmpty(tmpS)) {
                    tmpS = "0";
                }
                params.add(new BasicNameValuePair("tts_id", tmpS));
                sb.append("&tts_id=" + URLEncoder.encode(tmpS, "utf-8"));
                if (this.mDataCacheManager == null) {
                    this.mDataCacheManager = new DataCacheManager();
                }
                paramTmp = this.mDataCacheManager.getEtag() + "";
                params.add(new BasicNameValuePair(Headers.ETAG, paramTmp));
                sb.append("&etag=" + URLEncoder.encode(paramTmp, "utf-8"));
                LogUtil.m15791e(TAG + "unsign str:", SortSequenceWithAscendingOder(params));
                paramTmp = JNITrajectoryControl.sInstance.getUrlParamsSign(SortSequenceWithAscendingOder(params)) + "";
                LogUtil.m15791e(TAG + "hassign sign:", paramTmp);
                params.add(new BasicNameValuePair("sign", paramTmp));
                sb.append("&sign=" + URLEncoder.encode(paramTmp, "utf-8"));
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

    private boolean getUgcDataFromFile() {
        if (this.mDataCacheManager == null) {
            this.mDataCacheManager = new DataCacheManager();
        }
        try {
            JSONObject jSONObject = this.mDataCacheManager.getJSonObjectFromFile();
            JSONObject dataJSONObject = null;
            if (jSONObject != null) {
                dataJSONObject = jSONObject.getJSONObject("data");
            }
            if (dataJSONObject != null && parseUgcDataJSON(dataJSONObject)) {
                UgcOperationalActModel.getInstance().isWebDataValid = true;
                CloudlConfigDataModel.getInstance().isWebDataValid = true;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void initCloudConfigOutline() {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            if (this.mDataCacheManager == null) {
                this.mDataCacheManager = new DataCacheManager();
            }
            ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mUgcHandler, 1, 10000);
            CmdGeneralHttpRequestFunc.addFunc(reqdata, new C41631());
            CommandCenter.getInstance().sendRequest(reqdata);
            return;
        }
        if (getUgcDataFromFile()) {
            UgcOperationalActModel.getInstance().setActBaseDataModel(null);
        }
        if (this.mUgcHandler != null) {
            this.mUgcHandler.sendEmptyMessage(2);
        }
    }

    private void informModulesAftUpdate() {
        RGMultiRouteModel.getInstance().updateMultiRouteParams();
        BNRoutePlaner.getInstance().updateFuncConfigParams();
        UgcMapsViewConstructor.updateUgcReportBtn();
        BNVoice.getInstance().checkCombineVoice();
        UgcDataRepository.getInstance().update();
        BNYellowBannerTipsModel.getInstance().update();
        BNEyeSpyPaperController.getInstance().cloudConfigInitEnd();
        LogUtil.m15791e(TAG + "mCommonConfig.engineStr:", CloudlConfigDataModel.getInstance().mCommonConfig.engineStr);
        if (!TextUtils.isEmpty(CloudlConfigDataModel.getInstance().mCommonConfig.engineStr)) {
            JNIGuidanceControl.getInstance().setCloudControlCommand(CloudlConfigDataModel.getInstance().mCommonConfig.engineStr);
        }
    }

    private boolean parseUgcOperationalActJSON(JSONObject jsonObj) {
        boolean z = true;
        boolean isNewDataFlag = false;
        if (jsonObj == null || UgcOperationalActModel.getInstance() == null) {
            return false;
        }
        JSONObject dataJSONObject = null;
        try {
            LogUtil.m15791e("", " parseUgcOperationalActJSON safety errno: " + jsonObj.getInt(C2125n.f6745M) + " errmsg: " + jsonObj.getString(C2125n.f6746N));
            if (jsonObj.getInt(C2125n.f6745M) == 304) {
                if (this.mDataCacheManager == null) {
                    this.mDataCacheManager = new DataCacheManager();
                }
                try {
                    dataJSONObject = this.mDataCacheManager.getJSonObjectFromFile().getJSONObject("data");
                } catch (Exception e) {
                    e.printStackTrace();
                    dataJSONObject = null;
                }
            } else if (jsonObj.getInt(C2125n.f6745M) != 0) {
                return false;
            } else {
                if (!jsonObj.getString(C2125n.f6746N).equals("success")) {
                    return false;
                }
            }
            if (dataJSONObject == null) {
                dataJSONObject = jsonObj.getJSONObject("data");
                isNewDataFlag = true;
            }
            if (parseUgcDataJSON(dataJSONObject)) {
                if (isNewDataFlag) {
                    if (this.mDataCacheManager == null) {
                        this.mDataCacheManager = new DataCacheManager();
                    }
                    this.mDataCacheManager.saveJSonObjectToFile(jsonObj);
                }
                return true;
            }
            boolean z2;
            if (isNewDataFlag) {
                z2 = false;
            } else {
                z2 = true;
            }
            restartQeqData(z2);
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (null != null) {
                z = false;
            }
            restartQeqData(z);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean parseUgcDataJSON(org.json.JSONObject r47) {
        /*
        r46 = this;
        if (r47 != 0) goto L_0x0004;
    L_0x0002:
        r4 = 0;
    L_0x0003:
        return r4;
    L_0x0004:
        r26 = com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel.getInstance();
        r26.clearBaseDataModel();
        r13 = 0;
        r4 = "ugc_act";
        r0 = r47;
        r13 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0534 }
    L_0x0015:
        if (r13 != 0) goto L_0x047e;
    L_0x0017:
        r4 = 0;
        r0 = r26;
        r0.setActBaseDataModel(r4);	 Catch:{ Exception -> 0x04bb }
    L_0x001d:
        r4 = "engine";
        r0 = r47;
        r20 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0531 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0531 }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0531 }
        r5 = "collada";
        r0 = r20;
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x0531 }
        r4.colladaFlag = r5;	 Catch:{ Exception -> 0x0531 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0531 }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0531 }
        r5 = "guidecase";
        r0 = r20;
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x0531 }
        r4.guidecaseFlag = r5;	 Catch:{ Exception -> 0x0531 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0531 }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0531 }
        r5 = r20.toString();	 Catch:{ Exception -> 0x0531 }
        r4.engineStr = r5;	 Catch:{ Exception -> 0x0531 }
    L_0x0054:
        r4 = "navi_common";
        r0 = r47;
        r32 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x052e }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x052e }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x052e }
        r4 = "collada_component_download";
        r0 = r32;
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x052e }
        r6 = 1;
        if (r4 != r6) goto L_0x04c2;
    L_0x006f:
        r4 = 1;
    L_0x0070:
        r5.colladaComponentDownload = r4;	 Catch:{ Exception -> 0x052e }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x052e }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x052e }
        r4 = "collada_component_init";
        r0 = r32;
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x052e }
        r6 = 1;
        if (r4 != r6) goto L_0x04c5;
    L_0x0084:
        r4 = 1;
    L_0x0085:
        r5.colladaComponentInit = r4;	 Catch:{ Exception -> 0x052e }
        com.baidu.navisdk.BNaviModuleManager.initCollada();	 Catch:{ Exception -> 0x052e }
    L_0x008a:
        r4 = com.baidu.navisdk.module.car.BNYellowBannerTipsModel.getInstance();	 Catch:{ Exception -> 0x04bb }
        r0 = r47;
        r4.parseJson(r0);	 Catch:{ Exception -> 0x04bb }
        r4 = "reunion";
        r0 = r47;
        r35 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x052b }
        r4 = "is_open";
        r0 = r35;
        r4 = r0.has(r4);	 Catch:{ Exception -> 0x052b }
        if (r4 == 0) goto L_0x00bc;
    L_0x00a7:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x052b }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x052b }
        r4 = "is_open";
        r0 = r35;
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x052b }
        r6 = 1;
        if (r4 != r6) goto L_0x04c8;
    L_0x00b9:
        r4 = 1;
    L_0x00ba:
        r5.safetyShow = r4;	 Catch:{ Exception -> 0x052b }
    L_0x00bc:
        r4 = "in_navi_open";
        r0 = r35;
        r4 = r0.has(r4);	 Catch:{ Exception -> 0x052b }
        if (r4 == 0) goto L_0x00dc;
    L_0x00c7:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x052b }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x052b }
        r4 = "in_navi_open";
        r0 = r35;
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x052b }
        r6 = 1;
        if (r4 != r6) goto L_0x04cb;
    L_0x00d9:
        r4 = 1;
    L_0x00da:
        r5.safetyNavingShow = r4;	 Catch:{ Exception -> 0x052b }
    L_0x00dc:
        r4 = "title";
        r0 = r35;
        r4 = r0.has(r4);	 Catch:{ Exception -> 0x052b }
        if (r4 == 0) goto L_0x0100;
    L_0x00e7:
        r4 = "title";
        r0 = r35;
        r39 = r0.getString(r4);	 Catch:{ Exception -> 0x052b }
        r4 = com.baidu.navisdk.util.common.StringUtils.isEmpty(r39);	 Catch:{ Exception -> 0x052b }
        if (r4 != 0) goto L_0x0100;
    L_0x00f6:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x052b }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x052b }
        r0 = r39;
        r4.safetyText = r0;	 Catch:{ Exception -> 0x052b }
    L_0x0100:
        r4 = "light_navi_pic";
        r0 = r35;
        r4 = r0.has(r4);	 Catch:{ Exception -> 0x052b }
        if (r4 == 0) goto L_0x011c;
    L_0x010b:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x052b }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x052b }
        r5 = "light_navi_pic";
        r0 = r35;
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x052b }
        r4.safetyIpoIcon = r5;	 Catch:{ Exception -> 0x052b }
    L_0x011c:
        r4 = "navi_pic";
        r0 = r35;
        r4 = r0.has(r4);	 Catch:{ Exception -> 0x052b }
        if (r4 == 0) goto L_0x0138;
    L_0x0127:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x052b }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x052b }
        r5 = "navi_pic";
        r0 = r35;
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x052b }
        r4.safetyNavIcon = r5;	 Catch:{ Exception -> 0x052b }
    L_0x0138:
        r4 = "navi_night_icon";
        r0 = r35;
        r4 = r0.has(r4);	 Catch:{ Exception -> 0x052b }
        if (r4 == 0) goto L_0x0154;
    L_0x0143:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x052b }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x052b }
        r5 = "navi_night_icon";
        r0 = r35;
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x052b }
        r4.safetyNavNightIcon = r5;	 Catch:{ Exception -> 0x052b }
    L_0x0154:
        r4 = "in_navi_icon";
        r0 = r35;
        r4 = r0.has(r4);	 Catch:{ Exception -> 0x052b }
        if (r4 == 0) goto L_0x0170;
    L_0x015f:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x052b }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x052b }
        r5 = "in_navi_icon";
        r0 = r35;
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x052b }
        r4.safetyNavingIcon = r5;	 Catch:{ Exception -> 0x052b }
    L_0x0170:
        r4 = "safeJSONObject";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x052b }
        r5.<init>();	 Catch:{ Exception -> 0x052b }
        r6 = " safety safeJSONObject ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x052b }
        r6 = r35.toString();	 Catch:{ Exception -> 0x052b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x052b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x052b }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r4, r5);	 Catch:{ Exception -> 0x052b }
    L_0x018e:
        r4 = "core_log_record";
        r0 = r47;
        r18 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0528 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0528 }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0528 }
        r4 = "core_log_record";
        r0 = r18;
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x0528 }
        r6 = 1;
        if (r4 != r6) goto L_0x04ce;
    L_0x01a9:
        r4 = 1;
    L_0x01aa:
        r5.coreLogRecord = r4;	 Catch:{ Exception -> 0x0528 }
    L_0x01ac:
        r4 = "https_enable";
        r0 = r47;
        r23 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0525 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0525 }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0525 }
        r4 = "value";
        r0 = r23;
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x0525 }
        r6 = 1;
        if (r4 != r6) goto L_0x04d1;
    L_0x01c7:
        r4 = 1;
    L_0x01c8:
        r5.httpsControl = r4;	 Catch:{ Exception -> 0x0525 }
        r4 = com.baidu.navisdk.util.http.HttpURLManager.getInstance();	 Catch:{ Exception -> 0x0525 }
        r4.initUrlData();	 Catch:{ Exception -> 0x0525 }
        com.baidu.navisdk.BNaviModuleManager.initUrl();	 Catch:{ Exception -> 0x0525 }
    L_0x01d4:
        r4 = "ugc_camara";
        r0 = r47;
        r15 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0522 }
        r4 = "ugc_map_point";
        r0 = r47;
        r28 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0522 }
        r4 = new com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel$CommonBaseDataModel;	 Catch:{ Exception -> 0x0522 }
        r5 = "title";
        r5 = r15.getString(r5);	 Catch:{ Exception -> 0x0522 }
        r6 = "icon";
        r6 = r15.getString(r6);	 Catch:{ Exception -> 0x0522 }
        r7 = "title";
        r0 = r28;
        r7 = r0.getString(r7);	 Catch:{ Exception -> 0x0522 }
        r8 = "icon";
        r0 = r28;
        r8 = r0.getString(r8);	 Catch:{ Exception -> 0x0522 }
        r4.<init>(r5, r6, r7, r8);	 Catch:{ Exception -> 0x0522 }
        r0 = r26;
        r0.setCommonBaseDataModel(r4);	 Catch:{ Exception -> 0x0522 }
    L_0x0210:
        r4 = "feedback_style";
        r0 = r47;
        r21 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x051f }
        r4 = r26.getCommonBaseDataModel();	 Catch:{ Exception -> 0x051f }
        r5 = "text_left";
        r0 = r21;
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x051f }
        r6 = "text_right";
        r0 = r21;
        r6 = r0.getString(r6);	 Catch:{ Exception -> 0x051f }
        r7 = "text_new";
        r0 = r21;
        r7 = r0.getString(r7);	 Catch:{ Exception -> 0x051f }
        r4.setFeedbackStyle(r5, r6, r7);	 Catch:{ Exception -> 0x051f }
    L_0x023b:
        r4 = com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository.getInstance();	 Catch:{ Exception -> 0x04bb }
        r0 = r47;
        r4 = r4.parseCloudJson(r0);	 Catch:{ Exception -> 0x04bb }
        if (r4 != 0) goto L_0x0247;
    L_0x0247:
        r4 = "ugc_map";
        r0 = r47;
        r27 = r0.getJSONArray(r4);	 Catch:{ Exception -> 0x051c }
        r4 = 1;
        r0 = r46;
        r1 = r27;
        r2 = r26;
        r4 = r0.parseMapOrNaviJSON(r1, r2, r4);	 Catch:{ Exception -> 0x051c }
        if (r4 != 0) goto L_0x025d;
    L_0x025d:
        r4 = "ugc_navi";
        r0 = r47;
        r31 = r0.getJSONArray(r4);	 Catch:{ Exception -> 0x0519 }
        r4 = 0;
        r0 = r46;
        r1 = r31;
        r2 = r26;
        r4 = r0.parseMapOrNaviJSON(r1, r2, r4);	 Catch:{ Exception -> 0x0519 }
        if (r4 != 0) goto L_0x0273;
    L_0x0273:
        r4 = "multi_road";
        r0 = r47;
        r29 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0516 }
        r4 = "open";
        r0 = r29;
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x0516 }
        if (r4 != 0) goto L_0x04d4;
    L_0x0287:
        r30 = 0;
    L_0x0289:
        r4 = "tag_dis";
        r0 = r29;
        r4 = r0.getString(r4);	 Catch:{ Exception -> 0x0516 }
        r0 = r46;
        r37 = r0.converStringToIntArr(r4);	 Catch:{ Exception -> 0x0516 }
        r4 = "card_show_time";
        r5 = 20;
        r0 = r29;
        r16 = r0.optInt(r4, r5);	 Catch:{ Exception -> 0x0516 }
        r4 = "lastmile";
        r5 = -1;
        r0 = r29;
        r25 = r0.optInt(r4, r5);	 Catch:{ Exception -> 0x0516 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0516 }
        r5 = new com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel$MultiRoadConfig;	 Catch:{ Exception -> 0x0516 }
        r0 = r30;
        r1 = r37;
        r2 = r16;
        r3 = r25;
        r5.<init>(r0, r1, r2, r3);	 Catch:{ Exception -> 0x0516 }
        r4.mMultiRoadConfig = r5;	 Catch:{ Exception -> 0x0516 }
    L_0x02c0:
        r4 = "xmly";
        r0 = r47;
        r45 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0513 }
        r4 = "open";
        r5 = 0;
        r0 = r45;
        r33 = r0.optInt(r4, r5);	 Catch:{ Exception -> 0x0513 }
        r4 = "wifi_download";
        r5 = 1;
        r0 = r45;
        r43 = r0.optInt(r4, r5);	 Catch:{ Exception -> 0x0513 }
        r4 = "tips";
        r5 = 0;
        r0 = r45;
        r38 = r0.optString(r4, r5);	 Catch:{ Exception -> 0x0513 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0513 }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0513 }
        r4 = 1;
        r0 = r33;
        if (r0 != r4) goto L_0x04d8;
    L_0x02f2:
        r4 = 1;
    L_0x02f3:
        r5.isXmlyOpen = r4;	 Catch:{ Exception -> 0x0513 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0513 }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0513 }
        r4 = 1;
        r0 = r43;
        if (r0 != r4) goto L_0x04db;
    L_0x0300:
        r4 = 1;
    L_0x0301:
        r5.isWifiDownload = r4;	 Catch:{ Exception -> 0x0513 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0513 }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0513 }
        r0 = r38;
        r4.switchTips = r0;	 Catch:{ Exception -> 0x0513 }
    L_0x030d:
        r4 = "carnavitrajectory";
        r0 = r47;
        r14 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0510 }
        r4 = "recordopen";
        r5 = 0;
        r34 = r14.optInt(r4, r5);	 Catch:{ Exception -> 0x0510 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0510 }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0510 }
        r4 = 1;
        r0 = r34;
        if (r0 != r4) goto L_0x04de;
    L_0x0329:
        r4 = 1;
    L_0x032a:
        r5.isCarNaviRecording = r4;	 Catch:{ Exception -> 0x0510 }
        r4 = com.baidu.navisdk.jni.nativeif.JNITrajectoryControl.sInstance;	 Catch:{ Exception -> 0x0510 }
        r5 = 1;
        r4.isCarRecodingFromCLoud = r5;	 Catch:{ Exception -> 0x0510 }
        r4 = "CarNaviTrajectoryModel";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0510 }
        r5.<init>();	 Catch:{ Exception -> 0x0510 }
        r6 = "carnavicloud recordopen = ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0510 }
        r0 = r34;
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x0510 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0510 }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r4, r5);	 Catch:{ Exception -> 0x0510 }
    L_0x034d:
        r4 = "tts_control";
        r0 = r47;
        r40 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x050d }
        r4 = "combine_id";
        r5 = 0;
        r0 = r40;
        r24 = r0.optString(r4, r5);	 Catch:{ Exception -> 0x050d }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x050d }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x050d }
        r0 = r24;
        r4.mixVoiceIds = r0;	 Catch:{ Exception -> 0x050d }
    L_0x036a:
        r4 = "ugc_carpage";
        r0 = r47;
        r41 = r0.getJSONArray(r4);	 Catch:{ Exception -> 0x050a }
        r4 = com.baidu.navisdk.module.routereport.BNRouteReportController.getInstance();	 Catch:{ Exception -> 0x050a }
        r5 = 1;
        r0 = r41;
        r4.parseRouteReportItemJson(r0, r5);	 Catch:{ Exception -> 0x050a }
    L_0x037d:
        r4 = "ugc_finishpage";
        r0 = r47;
        r42 = r0.getJSONArray(r4);	 Catch:{ Exception -> 0x0507 }
        r4 = com.baidu.navisdk.module.routereport.BNRouteReportController.getInstance();	 Catch:{ Exception -> 0x0507 }
        r5 = 2;
        r0 = r42;
        r4.parseRouteReportItemJson(r0, r5);	 Catch:{ Exception -> 0x0507 }
    L_0x0390:
        r4 = "android_foreground_service";
        r0 = r47;
        r22 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x04e4 }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x04e4 }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x04e4 }
        r4 = "open";
        r0 = r22;
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x04e4 }
        r6 = 1;
        if (r4 != r6) goto L_0x04e1;
    L_0x03ab:
        r4 = 1;
    L_0x03ac:
        r5.foregroundService = r4;	 Catch:{ Exception -> 0x04e4 }
    L_0x03ae:
        r4 = com.baidu.navisdk.ui.routeguide.control.RGRouteSortController.getInstance();	 Catch:{ Exception -> 0x04bb }
        r0 = r47;
        r4 = r4.parseCloudJson(r0);	 Catch:{ Exception -> 0x04bb }
        if (r4 == 0) goto L_0x03c1;
    L_0x03ba:
        r4 = com.baidu.navisdk.ui.routeguide.control.RGRouteSortController.getInstance();	 Catch:{ Exception -> 0x04bb }
        r4.checkCloudConfig();	 Catch:{ Exception -> 0x04bb }
    L_0x03c1:
        r4 = "castrol_yellow_tips";
        r0 = r47;
        r17 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x04f0 }
        if (r17 == 0) goto L_0x0404;
    L_0x03cc:
        r4 = "icon";
        r0 = r17;
        r4 = r0.has(r4);	 Catch:{ Exception -> 0x04f0 }
        if (r4 == 0) goto L_0x03e8;
    L_0x03d7:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x04f0 }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x04f0 }
        r5 = "icon";
        r0 = r17;
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x04f0 }
        r4.mCastrolYellowIconURL = r5;	 Catch:{ Exception -> 0x04f0 }
    L_0x03e8:
        r4 = "text";
        r0 = r17;
        r4 = r0.has(r4);	 Catch:{ Exception -> 0x04f0 }
        if (r4 == 0) goto L_0x0404;
    L_0x03f3:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x04f0 }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x04f0 }
        r5 = "text";
        r0 = r17;
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x04f0 }
        r4.mCastrolYellowText = r5;	 Catch:{ Exception -> 0x04f0 }
    L_0x0404:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x04bb }
        r5 = new com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel$RequestBaseDataConfig;	 Catch:{ Exception -> 0x04bb }
        r6 = "etag";
        r0 = r47;
        r6 = r0.getString(r6);	 Catch:{ Exception -> 0x04bb }
        r7 = "st";
        r0 = r47;
        r8 = r0.getLong(r7);	 Catch:{ Exception -> 0x04bb }
        r5.<init>(r6, r8);	 Catch:{ Exception -> 0x04bb }
        r4.mRequestBaseDataConfig = r5;	 Catch:{ Exception -> 0x04bb }
        r4 = "abroad_voice";
        r0 = r47;
        r12 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0504 }
        if (r12 == 0) goto L_0x043b;
    L_0x042c:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0504 }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0504 }
        r5 = "entts_taskid";
        r5 = r12.optString(r5);	 Catch:{ Exception -> 0x0504 }
        r4.abroadVoice = r5;	 Catch:{ Exception -> 0x0504 }
    L_0x043b:
        r4 = "XDVoiceEnable";
        r0 = r47;
        r44 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x0501 }
        if (r44 == 0) goto L_0x0458;
    L_0x0446:
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x0501 }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x0501 }
        r5 = "value";
        r6 = 0;
        r0 = r44;
        r5 = r0.optInt(r5, r6);	 Catch:{ Exception -> 0x0501 }
        r4.xdVoice = r5;	 Catch:{ Exception -> 0x0501 }
    L_0x0458:
        r4 = "skyeye";
        r0 = r47;
        r36 = r0.getJSONObject(r4);	 Catch:{ Exception -> 0x04fe }
        if (r36 == 0) goto L_0x047b;
    L_0x0463:
        r4 = "open";
        r5 = 0;
        r0 = r36;
        r33 = r0.optInt(r4, r5);	 Catch:{ Exception -> 0x04fe }
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x04fe }
        r5 = r4.mCommonConfig;	 Catch:{ Exception -> 0x04fe }
        r4 = 1;
        r0 = r33;
        if (r0 != r4) goto L_0x04fb;
    L_0x0478:
        r4 = 1;
    L_0x0479:
        r5.isEyespyPagerOpen = r4;	 Catch:{ Exception -> 0x04fe }
    L_0x047b:
        r4 = 1;
        goto L_0x0003;
    L_0x047e:
        r4 = new com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel$actBaseDataModel;	 Catch:{ Exception -> 0x04bb }
        r5 = "entry_icon";
        r5 = r13.getString(r5);	 Catch:{ Exception -> 0x04bb }
        r6 = "banner_icon";
        r6 = r13.getString(r6);	 Catch:{ Exception -> 0x04bb }
        r7 = "camara_icon";
        r7 = r13.getString(r7);	 Catch:{ Exception -> 0x04bb }
        r8 = "entry_tips";
        r8 = r13.getString(r8);	 Catch:{ Exception -> 0x04bb }
        r9 = "banner_tips";
        r9 = r13.getString(r9);	 Catch:{ Exception -> 0x04bb }
        r10 = "camara_tips";
        r10 = r13.getString(r10);	 Catch:{ Exception -> 0x04bb }
        r11 = "botton_tips";
        r11 = r13.getString(r11);	 Catch:{ Exception -> 0x04bb }
        r4.<init>(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x04bb }
        r0 = r26;
        r0.setActBaseDataModel(r4);	 Catch:{ Exception -> 0x04bb }
        goto L_0x001d;
    L_0x04bb:
        r19 = move-exception;
        r19.printStackTrace();
        r4 = 0;
        goto L_0x0003;
    L_0x04c2:
        r4 = 0;
        goto L_0x0070;
    L_0x04c5:
        r4 = 0;
        goto L_0x0085;
    L_0x04c8:
        r4 = 0;
        goto L_0x00ba;
    L_0x04cb:
        r4 = 0;
        goto L_0x00da;
    L_0x04ce:
        r4 = 0;
        goto L_0x01aa;
    L_0x04d1:
        r4 = 0;
        goto L_0x01c8;
    L_0x04d4:
        r30 = 1;
        goto L_0x0289;
    L_0x04d8:
        r4 = 0;
        goto L_0x02f3;
    L_0x04db:
        r4 = 0;
        goto L_0x0301;
    L_0x04de:
        r4 = 0;
        goto L_0x032a;
    L_0x04e1:
        r4 = 0;
        goto L_0x03ac;
    L_0x04e4:
        r19 = move-exception;
        r4 = com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.getInstance();	 Catch:{ Exception -> 0x04bb }
        r4 = r4.mCommonConfig;	 Catch:{ Exception -> 0x04bb }
        r5 = 0;
        r4.foregroundService = r5;	 Catch:{ Exception -> 0x04bb }
        goto L_0x03ae;
    L_0x04f0:
        r19 = move-exception;
        r4 = TAG;	 Catch:{ Exception -> 0x04bb }
        r5 = "castrol_yellow_tips exception";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r4, r5);	 Catch:{ Exception -> 0x04bb }
        goto L_0x0404;
    L_0x04fb:
        r4 = 0;
        goto L_0x0479;
    L_0x04fe:
        r4 = move-exception;
        goto L_0x047b;
    L_0x0501:
        r4 = move-exception;
        goto L_0x0458;
    L_0x0504:
        r4 = move-exception;
        goto L_0x043b;
    L_0x0507:
        r4 = move-exception;
        goto L_0x0390;
    L_0x050a:
        r4 = move-exception;
        goto L_0x037d;
    L_0x050d:
        r4 = move-exception;
        goto L_0x036a;
    L_0x0510:
        r4 = move-exception;
        goto L_0x034d;
    L_0x0513:
        r4 = move-exception;
        goto L_0x030d;
    L_0x0516:
        r4 = move-exception;
        goto L_0x02c0;
    L_0x0519:
        r4 = move-exception;
        goto L_0x0273;
    L_0x051c:
        r4 = move-exception;
        goto L_0x025d;
    L_0x051f:
        r4 = move-exception;
        goto L_0x023b;
    L_0x0522:
        r4 = move-exception;
        goto L_0x0210;
    L_0x0525:
        r4 = move-exception;
        goto L_0x01d4;
    L_0x0528:
        r4 = move-exception;
        goto L_0x01ac;
    L_0x052b:
        r4 = move-exception;
        goto L_0x018e;
    L_0x052e:
        r4 = move-exception;
        goto L_0x008a;
    L_0x0531:
        r4 = move-exception;
        goto L_0x0054;
    L_0x0534:
        r4 = move-exception;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager.parseUgcDataJSON(org.json.JSONObject):boolean");
    }

    private void restartQeqData(boolean restartNeeded) {
        if (restartNeeded) {
            if (this.mDataCacheManager == null) {
                this.mDataCacheManager = new DataCacheManager();
            }
            this.mDataCacheManager.clearFileCache();
            initCloudConfigOutline();
        }
    }

    private boolean parseMapOrNaviJSON(JSONArray mapOrNaviJSONObjectArray, UgcOperationalActModel mUgcOperationalActModelTemp, boolean isParseMapJson) {
        Exception e;
        if (mapOrNaviJSONObjectArray == null) {
            return false;
        }
        if (mUgcOperationalActModelTemp == null) {
            return false;
        }
        int length = mapOrNaviJSONObjectArray.length();
        int i = 0;
        UgcBaseDataModel mUgcBaseDataModel = null;
        while (i < length) {
            UgcBaseDataModel mUgcBaseDataModel2;
            try {
                JSONObject mJSONObject = mapOrNaviJSONObjectArray.getJSONObject(i);
                mUgcBaseDataModel2 = new UgcBaseDataModel(mJSONObject.getString("title"), mJSONObject.getInt("type"), mJSONObject.getString(HUDGuideDataStruct.KEY_ICON_NAME));
                try {
                    JSONArray mJSONArray = mJSONObject.getJSONArray("sub");
                    if (mJSONArray != null) {
                        UgcBaseDataModel[] subUgcBaseDataModel = getUgcBaseDataModelFromSub(mJSONArray);
                        if (subUgcBaseDataModel != null && subUgcBaseDataModel.length > 0) {
                            for (UgcBaseDataModel mUgcBaseDataModelTemp : subUgcBaseDataModel) {
                                mUgcBaseDataModel2.addSubUgcData(mUgcBaseDataModelTemp);
                            }
                        }
                    }
                } catch (Exception e2) {
                }
                if (isParseMapJson) {
                    try {
                        mUgcOperationalActModelTemp.addMapUgcBaseDataModel(mUgcBaseDataModel2);
                    } catch (Exception e3) {
                        e = e3;
                    }
                } else {
                    mUgcOperationalActModelTemp.addNaviUgcBaseDataModel(mUgcBaseDataModel2);
                }
                i++;
                mUgcBaseDataModel = mUgcBaseDataModel2;
            } catch (Exception e4) {
                e = e4;
                mUgcBaseDataModel2 = mUgcBaseDataModel;
            }
        }
        return true;
        e.printStackTrace();
        return false;
    }

    private UgcBaseDataModel[] getUgcBaseDataModelFromSub(JSONArray mapJSONObjectArray) {
        if (mapJSONObjectArray == null) {
            return null;
        }
        int length = mapJSONObjectArray.length();
        if (length <= 0) {
            return null;
        }
        UgcBaseDataModel[] mUgcBaseDataModelArray = new UgcBaseDataModel[length];
        int i = 0;
        while (i < length) {
            try {
                JSONObject mJSONObject = mapJSONObjectArray.getJSONObject(i);
                mUgcBaseDataModelArray[i] = new UgcBaseDataModel(mJSONObject.getString("title"), mJSONObject.getInt("type"), mJSONObject.getString(HUDGuideDataStruct.KEY_ICON_NAME));
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return mUgcBaseDataModelArray;
    }

    private int getCurrentCityId() {
        DistrictInfo district = GeoLocateModel.getInstance().getCurrentDistrict();
        if (district != null) {
            return district.mId;
        }
        return -1;
    }

    private int[] converStringToIntArr(String strParam) {
        if (strParam.startsWith("[") && strParam.endsWith("]")) {
            strParam = strParam.substring(1, strParam.length() - 1);
        }
        String[] strArr = strParam.split(",");
        int len = strArr.length;
        if (len < 1) {
            return null;
        }
        int[] intArr = new int[len];
        int i = 0;
        while (i < len) {
            try {
                intArr[i] = Integer.parseInt(strArr[i]);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return intArr;
    }

    public static String SortSequenceWithAscendingOder(List<NameValuePair> params) {
        if (params == null || params.size() <= 0) {
            return null;
        }
        String[] stringArray = new String[params.size()];
        String tempStr = "";
        int index = 0;
        while (index < params.size()) {
            try {
                try {
                    stringArray[index] = (URLEncoder.encode(((NameValuePair) params.get(index)).getName(), "utf-8") + "=") + URLEncoder.encode(((NameValuePair) params.get(index)).getValue(), "utf-8");
                    index++;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        Arrays.sort(stringArray);
        StringBuffer sb = new StringBuffer();
        int ArrLength = stringArray.length;
        for (index = 0; index < ArrLength; index++) {
            sb.append(stringArray[index]);
            if (index != ArrLength - 1) {
                sb.append("&");
            }
        }
        LogUtil.m15791e(TAG + "SortSequenceWithAscendingOder:", sb.toString());
        return sb.toString();
    }
}
