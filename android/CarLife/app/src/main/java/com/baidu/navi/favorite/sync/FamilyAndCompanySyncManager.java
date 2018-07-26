package com.baidu.navi.favorite.sync;

import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.navi.favorite.http.AuthTokenSyncRequest;
import com.baidu.navi.favorite.http.FamilyAndCompanySyncRequest;
import com.baidu.navi.favorite.model.FamilyAndCompanyRequestModel;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import com.baidu.platform.comapi.util.C4794a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONObject;

public class FamilyAndCompanySyncManager {
    public static final int SYNC_FAIL = 1;
    public static final int SYNC_NETWORK_FAIL = 2;
    public static final int SYNC_SUCCESS = 0;
    public static final String TAG = FamilyAndCompanySyncManager.class.getSimpleName();
    private static FamilyAndCompanySyncManager mInstance;
    private String authId;
    private String authToken;
    private boolean isSyncing = false;
    private FamilyAndCompanyRequestModel mSyncData;
    private Handler mSyncHandler;
    private FamilyAndCompanySyncRequest mSyncRequest;
    C0924a mSyncResponseListener = new C37791();

    /* renamed from: com.baidu.navi.favorite.sync.FamilyAndCompanySyncManager$1 */
    class C37791 implements C0924a {
        C37791() {
        }

        public void onNetWorkResponse(int responseCode) {
            switch (responseCode) {
                case -4:
                    FamilyAndCompanySyncManager.this.isSyncing = false;
                    if (FamilyAndCompanySyncManager.this.mSyncHandler != null) {
                        FamilyAndCompanySyncManager.this.mSyncHandler.sendEmptyMessage(1);
                        return;
                    }
                    return;
                case -2:
                    FamilyAndCompanySyncManager.this.isSyncing = false;
                    if (FamilyAndCompanySyncManager.this.mSyncHandler != null) {
                        FamilyAndCompanySyncManager.this.mSyncHandler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                case -1:
                    return;
                case 0:
                    FamilyAndCompanySyncManager.this.isSyncing = false;
                    if (FamilyAndCompanySyncManager.this.mSyncHandler != null) {
                        FamilyAndCompanySyncManager.this.mSyncHandler.sendEmptyMessage(0);
                        return;
                    }
                    return;
                default:
                    FamilyAndCompanySyncManager.this.isSyncing = false;
                    if (FamilyAndCompanySyncManager.this.mSyncHandler != null) {
                        FamilyAndCompanySyncManager.this.mSyncHandler.sendEmptyMessage(1);
                        return;
                    }
                    return;
            }
        }
    }

    private FamilyAndCompanySyncManager() {
    }

    public static FamilyAndCompanySyncManager getInstance() {
        if (mInstance == null) {
            synchronized (FamilyAndCompanySyncManager.class) {
                if (mInstance == null) {
                    mInstance = new FamilyAndCompanySyncManager();
                    mInstance.init();
                }
            }
        }
        return mInstance;
    }

    private void init() {
        this.mSyncRequest = new FamilyAndCompanySyncRequest();
        this.mSyncRequest.registerResponseListener(this.mSyncResponseListener);
    }

    public boolean isSyncing() {
        return this.isSyncing;
    }

    public void setSyncing(boolean syncing) {
        this.isSyncing = syncing;
    }

    public synchronized void startSync() {
        this.isSyncing = true;
        this.mSyncData = getFamilyAndCompanyParams();
        sendSyncRequest();
    }

    private FamilyAndCompanyRequestModel getFamilyAndCompanyParams() {
        FamilyAndCompanyRequestModel parms = new FamilyAndCompanyRequestModel();
        parms.setBduss(NaviAccountUtils.getInstance().syncGetBduss());
        String data = getFamilyAndCompanyData();
        long cTime = System.currentTimeMillis();
        this.authId = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString(AuthTokenSyncRequest.SYNC_AUTH_ID, "");
        this.authToken = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString(AuthTokenSyncRequest.SYNC_AUTH_TOKEN, "");
        parms.setCtime(cTime + "");
        parms.setData(data);
        parms.setSign(getSign(data, cTime));
        parms.setAuthId(this.authId);
        return parms;
    }

    public String getFamilyAndCompanyData() {
        Exception e;
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            boolean familySync = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getBoolean(PreferenceHelperConst.FAMILY_HAS_SYNCED, false);
            boolean companySync = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getBoolean(PreferenceHelperConst.COMPANY_HAS_SYNCED, false);
            Bundle mBundle;
            int locx;
            int locy;
            JSONObject familyContent;
            JSONObject familyContent2;
            if (familySync && !companySync) {
                if (AddressSettingModel.hasSetHomeAddr(BNaviModuleManager.getContext())) {
                    mBundle = CoordinateTransformUtil.LL2MC(((double) AddressSettingModel.getHomeLon(BNaviModuleManager.getContext())) / 100000.0d, ((double) AddressSettingModel.getHomeLat(BNaviModuleManager.getContext())) / 100000.0d);
                    locx = 0;
                    locy = 0;
                    if (mBundle != null) {
                        locx = mBundle.getInt("MCx");
                        locy = mBundle.getInt("MCy");
                    }
                    familyContent = new JSONObject();
                    try {
                        familyContent.put("key", "home");
                        familyContent.put("name", AddressSettingModel.getHomeName(BNaviModuleManager.getContext()));
                        familyContent.put("locx", locx);
                        familyContent.put("locy", locy);
                        familyContent.put("poi_id", AddressSettingModel.getHomePoiOriginUID(BNaviModuleManager.getContext()));
                        familyContent2 = familyContent;
                    } catch (Exception e2) {
                        e = e2;
                        familyContent2 = familyContent;
                        e.printStackTrace();
                        return null;
                    }
                }
                familyContent = new JSONObject();
                familyContent.put("key", "home");
                familyContent.put("name", "");
                familyContent2 = familyContent;
                jsonArray.put(familyContent2);
            } else if (!familySync && companySync) {
                if (AddressSettingModel.hasSetCompAddr(BNaviModuleManager.getContext())) {
                    mBundle = CoordinateTransformUtil.LL2MC(((double) AddressSettingModel.getCompLon(BNaviModuleManager.getContext())) / 100000.0d, ((double) AddressSettingModel.getCompLat(BNaviModuleManager.getContext())) / 100000.0d);
                    locx = 0;
                    locy = 0;
                    if (mBundle != null) {
                        locx = mBundle.getInt("MCx");
                        locy = mBundle.getInt("MCy");
                    }
                    companyContent = new JSONObject();
                    try {
                        companyContent.put("key", "company");
                        companyContent.put("name", AddressSettingModel.getCompName(BNaviModuleManager.getContext()));
                        companyContent.put("locx", locx);
                        companyContent.put("locy", locy);
                        companyContent.put("poi_id", AddressSettingModel.getCompPoiOriginUID(BNaviModuleManager.getContext()));
                        companyContent = companyContent;
                    } catch (Exception e3) {
                        e = e3;
                        companyContent = companyContent;
                        e.printStackTrace();
                        return null;
                    }
                }
                companyContent = new JSONObject();
                companyContent.put("key", "company");
                companyContent.put("name", "");
                companyContent = companyContent;
                jsonArray.put(companyContent);
            } else if (familySync && companySync) {
                if (AddressSettingModel.hasSetHomeAddr(BNaviModuleManager.getContext())) {
                    familyContent = new JSONObject();
                    mBundle = CoordinateTransformUtil.LL2MC(((double) AddressSettingModel.getHomeLon(BNaviModuleManager.getContext())) / 100000.0d, ((double) AddressSettingModel.getHomeLat(BNaviModuleManager.getContext())) / 100000.0d);
                    locx = 0;
                    locy = 0;
                    if (mBundle != null) {
                        locx = mBundle.getInt("MCx");
                        locy = mBundle.getInt("MCy");
                    }
                    familyContent.put("key", "home");
                    familyContent.put("name", AddressSettingModel.getHomeName(BNaviModuleManager.getContext()));
                    familyContent.put("locx", locx);
                    familyContent.put("locy", locy);
                    familyContent.put("poi_id", AddressSettingModel.getHomePoiOriginUID(BNaviModuleManager.getContext()));
                    familyContent2 = familyContent;
                } else {
                    familyContent = new JSONObject();
                    familyContent.put("key", "home");
                    familyContent.put("name", "");
                    familyContent2 = familyContent;
                }
                if (AddressSettingModel.hasSetCompAddr(BNaviModuleManager.getContext())) {
                    companyContent = new JSONObject();
                    mBundle = CoordinateTransformUtil.LL2MC(((double) AddressSettingModel.getCompLon(BNaviModuleManager.getContext())) / 100000.0d, ((double) AddressSettingModel.getCompLat(BNaviModuleManager.getContext())) / 100000.0d);
                    locx = 0;
                    locy = 0;
                    if (mBundle != null) {
                        locx = mBundle.getInt("MCx");
                        locy = mBundle.getInt("MCy");
                    }
                    companyContent.put("key", "company");
                    companyContent.put("name", AddressSettingModel.getCompName(BNaviModuleManager.getContext()));
                    companyContent.put("locx", locx);
                    companyContent.put("locy", locy);
                    companyContent.put("poi_id", AddressSettingModel.getCompPoiOriginUID(BNaviModuleManager.getContext()));
                    companyContent = companyContent;
                } else {
                    companyContent = new JSONObject();
                    companyContent.put("key", "company");
                    companyContent.put("name", "");
                    companyContent = companyContent;
                }
                jsonArray.put(familyContent2);
                jsonArray.put(companyContent);
            }
            jsonObject.put("sync_data", jsonArray);
            jsonObject.put("cuid", PackageUtil.getCuid());
            LogUtil.m15791e("family", "data:" + jsonObject);
            return byte2hex(C4794a.m15887a(AuthTokenSyncRequest.KEY, jsonObject.toString().getBytes()));
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            return null;
        }
    }

    public String getSign(String data, long cTime) {
        String sign = null;
        try {
            sign = URLEncoder.encode(getSign(this.authId, this.authToken, URLEncoder.encode(data, "UTF-8"), Long.valueOf(cTime)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return sign;
    }

    public String getSign(String authId, String authToken, String dataStr, Long ctime) {
        return hmacSha1(authToken, authId + ctime + dataStr);
    }

    public String hmacSha1(String token, String datas) {
        String reStr = "";
        String type = "HmacSHA1";
        try {
            SecretKeySpec secretKey = new SecretKeySpec(token.getBytes("UTF-8"), type);
            Mac mac = Mac.getInstance(type);
            mac.init(secretKey);
            reStr = Base64.encodeToString(mac.doFinal(datas.getBytes("UTF-8")), 0).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reStr;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public synchronized void stopSync() {
        if (this.mSyncRequest != null) {
            this.mSyncRequest.cancel();
            this.isSyncing = false;
        }
    }

    private void sendSyncRequest() {
        if (this.mSyncData != null) {
            this.isSyncing = true;
            if (this.mSyncRequest == null) {
                this.mSyncRequest = new FamilyAndCompanySyncRequest();
                this.mSyncRequest.registerResponseListener(this.mSyncResponseListener);
            }
            this.mSyncRequest.setParamsModel(this.mSyncData);
            this.mSyncRequest.toPostRequest();
            return;
        }
        this.isSyncing = false;
        if (this.mSyncHandler != null) {
            this.mSyncHandler.sendEmptyMessage(1);
        }
    }

    public void setmSyncHandler(Handler mSyncHandler) {
        this.mSyncHandler = mSyncHandler;
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String tmp = "";
        for (byte b2 : b) {
            tmp = Integer.toHexString(b2 & 255);
            if (tmp.length() == 1) {
                hs = hs + "0" + tmp;
            } else {
                hs = hs + tmp;
            }
        }
        return hs.toUpperCase();
    }
}
