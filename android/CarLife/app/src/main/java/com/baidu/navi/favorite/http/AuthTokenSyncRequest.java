package com.baidu.navi.favorite.http;

import android.text.TextUtils;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.navi.favorite.sync.FamilyAndCompanySyncManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.platform.comapi.util.C4794a;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthTokenSyncRequest extends C1626e {
    public static final String KEY = "YiVz0MC3b9UqsETN";
    public static final String SYNC_AUTH_ID = "sync_auth_id";
    public static final String SYNC_AUTH_TOKEN = "sync_auth_token";

    /* renamed from: com.baidu.navi.favorite.http.AuthTokenSyncRequest$1 */
    class C37781 implements Runnable {
        C37781() {
        }

        public void run() {
            FamilyAndCompanySyncManager.getInstance().startSync();
        }
    }

    public AuthTokenSyncRequest() {
        this.tag = AuthTokenSyncRequest.class.getSimpleName();
    }

    protected String getUrl() {
        return "http://automap.baidu.com/naviauto/?__c=user&rt=login&ofmt=json&ctime=" + System.currentTimeMillis() + "&fromapp=carlife";
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        return -4;
    }

    protected C1622d getUrlParams() {
        return null;
    }

    protected C1622d getPostRequestParams() {
        return null;
    }

    public void reponseNoJsonCallBack(String response) {
        int code = -4;
        try {
            String result = new String(C4794a.m15888b(KEY, hex2byte(response.trim())));
            if (!TextUtils.isEmpty(result)) {
                JSONObject jsonResult = new JSONObject(result).optJSONObject("result");
                String authId = jsonResult.optString("auth_id");
                String authToken = jsonResult.optString("auth_token");
                LogUtil.m15791e("family", "authId:" + authId + "authToken:" + authToken);
                if (!(TextUtils.isEmpty(authId) || TextUtils.isEmpty(authToken))) {
                    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString(SYNC_AUTH_ID, authId);
                    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString(SYNC_AUTH_TOKEN, authToken);
                    code = 0;
                    new Thread(new C37781()).start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        notifyResponseListener(code);
    }

    public static byte[] hex2byte(String s) {
        byte[] b = s.getBytes();
        if (b.length % 2 != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] b2 = new byte[(b.length / 2)];
        for (int n = 0; n < b.length; n += 2) {
            b2[n / 2] = (byte) Integer.parseInt(new String(b, n, 2), 16);
        }
        return b2;
    }
}
